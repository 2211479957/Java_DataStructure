package 数据结构;

import java.util.Scanner;

public class 静态查找 {
    static Seqlist ST=null;
    public static void createSearchList() throws Exception{
        ST= new Seqlist(20);
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入查找表的表长:");
        int n=sc.nextInt();
        KeyType[] k=new KeyType[n];
        System.out.print("请输入查找表中的关键字序列:");
        for(int i=0;i<n;i++){
            k[i]=new KeyType(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            RecordNode r =new RecordNode(k[i]);
            ST.insert(i,r);
        }
    }
    public static void main(String [] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        KeyType key1,key2;
        boolean flag=true;
        while(flag){
            System.out.println("1--顺序查找        2--二分查找        3--退出");
            System.out.print("请输入选择（1-3):");
            int i=sc.nextInt();
            switch(i){
                case 1:
                    System.out.println("创建顺序查找表");
                    createSearchList();
                    System.out.print("请输入两个待查找的关键字:");
                    key1=new KeyType(sc.nextInt());
                    key2=new KeyType(sc.nextInt());
                    System.out.println("seqSearch("+key1.key+")="+ST.seqSearch(key1));
                    System.out.println("seqSearch("+key2.key+")="+ST.seqSearch(key2));
                    break;
                case 2:
                    System.out.println("创建有序的顺序查找表");
                    createSearchList();
                    System.out.print("请输入两个待查找的关键字:");
                    key1=new KeyType(sc.nextInt());
                    key2=new KeyType(sc.nextInt());
                    System.out.println("binarySearch("+key1.key+")="+ST.binarySearch(key1));
                    System.out.println("binarySearch("+key2.key+")="+ST.binarySearch(key2));
                    break;
                case 3:
                    flag=false;
                    break;
            }
        }
    }
}
class RecordNode{
    public Comparable key;
    public Object element;
    public RecordNode(Comparable key){
        this.key=key;
    }
    public RecordNode(Comparable key,Object element){
        this.key=key;
        this.element=element;
    }
}
class KeyType implements Comparable<KeyType>{
    public int key;
    public KeyType(){
    }
    public KeyType(int key){
        this.key=key;
    }
    public String toString(){
        return key+" ";
    }
    public int compareTo(KeyType another){
        int thisVal=this.key;
        int anotherVal=another.key;
        return(thisVal<anotherVal?-1:(thisVal==anotherVal?0:1));
    }
}
class Seqlist{
    public RecordNode[] r;
    public int curlen;

    public Seqlist(int maxSize){
        this.r=new RecordNode[maxSize];
        this.curlen=0;
    }
    public void insert(int i,RecordNode x) throws Exception{
        if(curlen==r.length){
            throw new Exception("顺序表已满");
        }
        if(i<0||i>curlen){
            throw new Exception("插入位置不合理");
        }
        for(int j=curlen;j>i;j--){
            r[j]=r[j-1];
        }
        r[i]=x;
        this.curlen++;
    }
    public void display(){
        for(int i=1;i<this.curlen;i++){
            System.out.print(" "+r[i].key.toString());
        }
        System.out.println();
    }
    public void insertSortWithGuard(){
        int i,j;
        System.out.print("带监视哨的直接插入序列");
        for(i=2;i<this.curlen-1;i++){
            r[0]=r[i];
        }
        for(j=i-1;r[0].key.compareTo(r[j].key)<0;j--){
            r[j+1]=r[j];
        }
        r[j+1]=r[0];
    }

    public int seqSearch(Comparable key){
        int i=0,n=curlen;
        while(i<n&&r[i].key.compareTo(key)!=0){
            i++;
        }
        if(i<n){
            return i;
        }
        else{
            return -1;
        }
    }
    public int binarySearch(Comparable key){
        if(curlen>0){
            int low=0,high=curlen-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(r[mid].key.compareTo(key)==0){
                    return mid;
                }
                else if(r[mid].key.compareTo(key)>0){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        return -1;
    }
}