package 数据结构;

import java.util.Scanner;
public class 链表 {
    private static void creat(Linklist l) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入链表中的各元素值(0为结束):");
        for(int x=sc.nextInt();x!=0;x=sc.nextInt())
            l.insert(0,x);
    }
    public static void main(String []args) throws Exception{
        Scanner sc=new Scanner(System.in);
        Linklist l = new Linklist();
        creat(l);
        System.out.println("建立的单链表为：");
        l.display();
        System.out.println("请输入待插入的位置i(0~curLen):");
        int i = sc.nextInt();
        System.out.println("请输入待插入的数据值x:");
        int x=sc.nextInt();
        l.insert(i,x);
        System.out.println("插入后的链表为:");
        l.display();
        System.out.println("请输入待删除元素的位置(0~curLen-1):");
        i=sc.nextInt();
        l.remove(i);
        System.out.println("删除后的链表为:");
        l.display();
        System.out.println("请输入待查找的数据元素的位序号(0~curLen-1):");
        i=sc.nextInt();
        Object o=l.get(i);
        System.out.println("此单链表中第"+i+"个结点的数据元素值为"+o);
    }
}
class Node{
    public Object data;
    public Node next;
    public Node(){
        this(null,null);
    }
    public Node(Object data){
        this(data,null);
    }

    public Node(Object data,Node next) {
        this.data=data;
        this.next=next;
    }
}
class Linklist{
        public Node head;
        public Linklist(){
        head=new Node();
    }
   Object get(int i) throws Exception {
       Node p = head.next;
       int j = 0;
       while (p != null && j < i) {
           p = p.next;
           ++j;
       }
       if (j > i || p == null)
           throw new Exception("第" + i + "个元素不存在");
       return p.data;
   }
    void insert(int i,Object x) throws Exception {
        Node p = head;
        int j = -1;
        while(p!=null&&j<i-1) {
            p=p.next;
            ++j;
        }
        if(j>i-1||p==null)
            throw new Exception("插入位置不合理");
        Node s=new Node(x);
        s.next=p.next;
        p.next=s;
    }
    void remove(int i) throws Exception{
    Node p=head;
    int j=-1;
    while(p.next!=null && j<i-1){
        p=p.next;
        ++j;
    }
    if(j>i-1 || p.next==null){
        throw new Exception("删除位置不合理");
    }
    p.next=p.next.next;
    }
    void display() {
    Node node=head.next;
    while(node!=null){
        System.out.print(node.data+" ");
        node=node.next;
    }
    System.out.println();
}
}