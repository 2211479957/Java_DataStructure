package 数据结构;
import java.util.Scanner;
public class BiTree{
    BiTreeNode root;
    static int index=0;
    public BiTree(String preStr){
        char c=preStr.charAt(index++);
        if(c!='#'){
            root=new BiTreeNode(c);
            root.lchild = new BiTree(preStr).root;
            root.rchild = new BiTree(preStr).root;
        }
        else
            root=null;
    }
    void preRootTraverse(BiTreeNode T){
        if(T!=null){
            System.out.print(T.data);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }
    void inRootTraverse(BiTreeNode T){
        if(T!=null){
            inRootTraverse(T.lchild);
            System.out.print(T.data);
            inRootTraverse(T.rchild);
        }
    }
    void postRootTraverse(BiTreeNode T){
        if(T!=null){
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.print(T.data);
        }
    }
    int countNode(BiTreeNode T){
         int count=0;
        if(T!=null){
            ++count;
            count+=countNode(T.lchild);
            count+=countNode(T.rchild);
        }
        return count;
    }
    int countLeafNode(BiTreeNode T){
        int count1=0;
        if(T!=null){
            if(T.lchild==null&&T.rchild==null){
                ++count1;
            }
            else{
                count1+=countLeafNode(T.lchild);
                count1+=countLeafNode(T.rchild);
            }
        }
        return count1;
    }
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入二叉树的标明了空子树的先根遍历序列:");
        String preStr=scanner.next();
        BiTree T=new BiTree(preStr);
        while(true){
            System.out.println("===================================");
            System.out.println("1==先根遍历 2==中根遍历 3==后根遍历");
            System.out.println("4==统计节点个数 5==统计叶节点个数 6==退出");
            System.out.println("===================================");
            System.out.print("请输入选择(1-6):");
            int i=scanner.nextInt();
            switch(i){
                case 1:System.out.print("先根遍历:");
                       T.preRootTraverse(T.root);
                       System.out.println();break;
                case 2:System.out.print("中根遍历:");
                       T.inRootTraverse(T.root);
                       System.out.println();break;
                case 3:System.out.print("后根遍历:");
                       T.postRootTraverse(T.root);
                       System.out.println();break;
                case 4:int m = T.countNode(T.root);
                       System.out.print("二叉树的结点个数:"+m);
                       System.out.println();break;
                case 5:int n = T.countLeafNode(T.root);
                       System.out.print("二叉树的叶结点个数:"+n);
                       System.out.println();break;
                case 6:return;
            }
        }
    }
}
class BiTreeNode{
    Object data;
    BiTreeNode lchild,rchild;
    public BiTreeNode(){
        this(null);
    }
    public BiTreeNode(Object data) {
        this(data,null,null);
    }
    public BiTreeNode(Object data,BiTreeNode lchild,BiTreeNode rchild){
        this.data=data;
        this.lchild=lchild;
        this.rchild=rchild;
    }
}
