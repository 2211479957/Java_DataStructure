package 数据结构;

import java.util.*;
public class 队列 {
        public static void main(String [] args) throws Exception{
            Circlesqqueue q1=new Circlesqqueue(100);
            Linkqueue q2 =new Linkqueue();
            Scanner sc= new Scanner(System.in);
        System.out.print("请输入队列的长度:");
        int n = sc.nextInt();
        System.out.println("请输入队列中的各元素值:");
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            q1.offer(data);
            q2.offer(data);
        }
        System.out.println("建立的循环顺序队列中各元素值为(从队首到队尾): ");
        q1.display();
        System.out.println("\n建立的链队列中各元素值为(从队首到队尾): ");
        q2.display();
        System.out.print("\n请输入待入队的元素值x:");
        int x=sc.nextInt();
        q1.offer(x);
        System.out.println("入队后的循环顺序队列中的各元素值为(从队首到队尾):");
        q1.display();
        q2.offer(x);
        System.out.println("\n入队后的链队列中的各元素值为(从队首到队尾):");
        q2.display();
        Object t1=q1.poll();
        Object t2=q2.poll();
        if(t1!=null&&t2!=null){
            System.out.println("\n删除的循环顺序队列的队首元素为"+t1);
            System.out.println("\n删除的链队列的队首元素为"+t2);
            System.out.println("\n删除队首元素后,循环顺序队列中各元素值为(队首到队尾): ");
            q1.display();
            System.out.println("\n删除队首元素后,链队列中各元素值为(队首到队尾): ");
            q2.display();
        }
    }
}
class Circlesqqueue{
    private Object[] queueElem;
    private int front;
    private int rear;
    public Circlesqqueue(int maxSize){
        front=rear=0;
        queueElem =new Object[maxSize];
    }
    public boolean isEmpty(){
       return front==rear;
    }
    public void offer(Object x) throws Exception{
        if((rear+1)%queueElem.length==front)
            throw new Exception("队列已满");
        else{
            queueElem[rear]=x;
            rear=(rear+1)%queueElem.length;
        }
    }
    public Object poll(){
        if(front==rear)
            return null;
        else{
            Object t =queueElem[front];
            front = (front+1)%queueElem.length;
            return t;
        }
    }
    public void display(){
        if(!isEmpty()){
            for(int i=front;i!=rear;i=(i+1)%queueElem.length)
                System.out.print(queueElem[i].toString()+" ");
        }
        else{
            System.out.println("此队列为空");
        }
    }
}
class Linkqueue{
    private Node front;
    private Node rear;
    public Linkqueue(){
        front=rear=null;
    }
    public void offer(Object x){
        Node p = new Node(x);
        if(front!=null){
            rear.next=p;
            rear=p;
        }
        else
            front=rear=p;
    }
    public Object poll(){
        if(front !=null){
            Node p=front;
            front = front.next;
            if(p==rear)
                rear=null;
            return p.data;
        }
        else
            return null;
    }
    public boolean isEmpty(){
        return front==null;
    }
    public void display(){
        Node p=front;
        while(p!=null) {
            System.out.print((p.data.toString() + " "));
            p = p.next;
        }
    }
}