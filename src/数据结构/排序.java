package 数据结构;
public class 排序 extends Seqlist{
    static int maxSize=20;
    public 排序(int maxSize){
        super(maxSize);
    }
    static Seqlist createList(int[] d) throws Exception {
        Seqlist SL=new 排序(maxSize+1);
        for(int i=0;i<d.length;i++){
            RecordNode r=new RecordNode(d[i]);
            SL.insert(SL.curlen,r);
        }
        SL.insert(0,new RecordNode(0));
        return SL;
    }
    public static void main(String [] args) throws Exception{
        int [] d=new int[maxSize];
        for(int i=0;i<maxSize;i++){
            d[i]=(int)(Math.random()*100);
        }
        Seqlist L=createList(d);
        System.out.println("排序前:");
        L.display();
        L.insertSortWithGuard();
        System.out.println("排序后:");
        L.display();
    }

}
