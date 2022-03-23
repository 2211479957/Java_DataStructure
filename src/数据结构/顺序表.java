package 数据结构;

import java.util.Scanner;
public class 顺序表{

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Sqlist l = new Sqlist(20);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顺序表的长度:");
        int n=sc.nextInt();
        System.out.println("请输入顺序表中的各元素的值：");
        for(int i=0;i<n;i++)
            l.insert(i,sc.nextInt());
        System.out.print("当前顺序表为：");
        l.display();
        System.out.println("请输入待插入的位置i(0~curLen):");
        int i = sc.nextInt();
        System.out.println("请输入待插入的元素值x:");
        int x =sc.nextInt();
        l.insert(i,x);
        System.out.println("插入后的顺序表为:");
        l.display();
        System.out.println("请输入待删除元素的位置(0~curLen-1):");
        i = sc.nextInt();
        l.remove(i);
        System.out.println("删除后的顺序表为:");
        l.display();
        System.out.println("请输入待查找的元素值:");
        x=sc.nextInt();
        int order=l.indexOf(x);
        if(order==-1)
            System.out.println("此顺序表中不包含值为"+x+"的元素！");
        else
            System.out.println("值为"+x+"的元素在顺序表中的第"+order+"个位置上");
        l.display();
    }

}
class Sqlist{
    private Object[] listElem;
    private int curLen;
    public Sqlist(int maxSize) {
        curLen = 0;
        listElem = new Object[maxSize];
    }
    public void insert(int i,Object x) throws Exception{
        if(curLen==listElem.length)
            throw new Exception("顺序表已满");
        if(i<0 || i > curLen)
            throw new Exception("插入位置不合法");
        for(int j=curLen;j>i;j--)
            listElem[j]=listElem[j-1];
        listElem[i]=x;
        curLen++;
    }
    public void remove(int i) throws Exception{
        if(i<0 || i>curLen - 1)
            throw new Exception("删除位置不合法");
        for(int j=i;j<curLen-1;j++)
            listElem[j]=listElem[j+1];
        curLen--;
    }
    public int indexOf(Object x) {
        int j=0;
        while(j<curLen && !listElem[j].equals(x))
            j++;
        if(j<curLen)
            return j;
        else
            return -1;
    }
    public void display() {
        for(int j=0;j<curLen;j++)
            System.out.print(listElem[j]+" ");
        System.out.println();
    }
}