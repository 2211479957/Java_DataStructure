package 数据结构;

import java.util.*;
public class 栈 {
    public static void main(String [] args) throws Exception{
        Sqstack sq=new Sqstack(100);
        Linkstack sl=new Linkstack();
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入栈的长度:");
        int n=sc.nextInt();
        System.out.println("请输入栈中的各元素值:");
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            sq.push(x);
            sl.push(x);
        }
        System.out.println("建立的顺序栈中的各元素值为(从栈顶到栈底):");
        sq.display();
        System.out.println("\n建立的链栈中各元素值为(从栈顶到栈底):");
        sl.display();
        System.out.println("\n请输入待入栈的元素值e:");
        int e=sc.nextInt();
        sq.push(e);
        sl.push(e);
        System.out.println("入栈后的顺序栈中各元素值为(从栈顶到栈底):");
        sq.display();
        System.out.println("\n入栈后的链栈中各元素值为(从栈顶到栈底):");
        sl.display();
        System.out.println("\n删除栈顶元素后,顺序栈中各元素值为(从栈顶到栈底):");
        sq.pop();
        sq.display();
        System.out.println("\n删除栈顶元素后,链栈中各元素值为(从栈顶到栈底):");
        sl.pop();
        sl.display();
    }
}
class Sqstack{
    private Object[] stackElem;
    private int top;
    public Sqstack(int maxSize){
        top=0;
        stackElem=new Object[maxSize];
    }
    public boolean isEmpty(){
        return top==0;
    }
    public void push(Object x) throws Exception{
        if(top==stackElem.length)
            throw new Exception("栈已满");
        else
            stackElem[top++]=x;
    }
    public Object pop(){
        if(isEmpty())
            return null;
        else
            return stackElem[--top];
    }
    public void display(){
        for(int i=top-1;i>0;i--)
            System.out.print(stackElem[i].toString()+" ");
    }
}
class Linkstack{
    private Node top;
    public boolean isEmpty(){
        return top==null;
    }
    public void push(Object x){
        Node p=new Node(x);
        p.next=top;
        top=p;
    }
    public Object pop(){
        if(isEmpty()){
            return null;
        }
        else{
            Node p=top;
            top=top.next;
            return p.data;
        }
    }
    public void display(){
        Node p=top;
        while(p!=null){
            System.out.print((p.data.toString()+ " "));
            p=p.next;
        }
    }
}