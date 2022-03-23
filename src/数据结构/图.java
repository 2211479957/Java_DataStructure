package 数据结构;
import java.util.*;
public class 图 {
    public static void main(String [] args) throws Exception{
     MGraph G=new MGraph();
     G.createGraph();
     System.out.println("图的广度遍历为:");
     BTraverser.BFSTraverse(G);
     System.out.println();
     System.out.println("图的深度遍历为:");
     DTraverser.DFSTraverse(G);
    }
}
class BTraverser{
    static boolean[] visited;
    public static void BFSTraverse(MGraph G) throws Exception{
        visited = new boolean[G.getVexNum()];
        for(int v=0;v<G.getVexNum();v++){
            visited[v]=false;
        }
        for(int v=0;v<G.getVexNum();v++){
            if(!visited[v])
                BFS(G,v);
        }
    }
    private static void BFS(MGraph G,int v) throws Exception{
        visited[v]=true;
        System.out.print(G.getVex(v).toString()+" ");
        Linkqueue Q=new Linkqueue();
        Q.offer(v);
        while(!Q.isEmpty()){
            int u=(Integer)Q.poll();
            for(int w=G.firstAdjVex(u);w>=0;w=G.nextAdjVex(u,w))
                if(!visited[w]){
                    visited[w]=true;
                    System.out.print(G.getVex(w).toString()+" ");
                    Q.offer(v);
                }
        }
    }
}
class DTraverser{
    private static boolean[] visited;
    public static void DFSTraverse(MGraph G) throws Exception{
        visited = new boolean[G.getVexNum()];
        for(int v=0;v<G.getVexNum();v++){
            visited[v]=false;
        }
        for(int v=0;v<G.getVexNum();v++){
            if(!visited[v])
                DFS(G,v);
        }
    }
    private static void DFS(MGraph G,int v) throws Exception{
        visited[v]=true;
        System.out.print(G.getVex(v).toString()+" ");
        for(int w=G.firstAdjVex(v);w>=0;w=G.nextAdjVex(v,w))
            if(!visited[w])
                DFS(G,w);
                }
}
class MGraph{
    public final static int INFINITY = Integer.MAX_VALUE;
    GraphKind kind;
    int vexNum,arcNum;
    Object[] vexs;
    int [][] arcs;
    enum GraphKind{
        UDG,
        DG,
        UDN,
        DN;
    }
    public MGraph(){
        this(null,0,0,null,null);
    }
    public MGraph(GraphKind kind,int vexNum,int arcNum,Object[] vexs,int [][] arcs){
        this.kind=kind;
        this.vexNum=vexNum;
        this.arcNum=arcNum;
        this.vexs=vexs;
        this.arcs=arcs;
    }
    public void createGraph(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入图的类型:");
        GraphKind kind=GraphKind.valueOf(sc.next());
        switch(kind){
            case UDG:
                createUDG();
                return;
            case DG:
                createDG();
                return;
            case UDN:
                createUDN();
                return;
            case DN:
                createDN();
                return;
        }
    }
    void createUDG(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数:");
        vexNum=sc.nextInt();
        arcNum=sc.nextInt();
        vexs=new Object[vexNum];
        System.out.println("请分别输入图的各个顶点:");
        for(int v=0;v<vexNum;v++){
            vexs[v]=sc.next();
        }
        arcs=new int[vexNum][vexNum];
        for(int v=0;v<vexNum;v++){
            for(int u=0;u<vexNum;u++){
                arcs[v][u]=INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点:");
        for(int k=0;k<arcNum;k++){
            int v=locateVex(sc.next());
            int u = locateVex(sc.next());
            arcs[v][u]=arcs[u][v]=1;
        }
    }
    void createDG(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数:");
        vexNum=sc.nextInt();
        arcNum=sc.nextInt();
        vexs=new Object[vexNum];
        System.out.println("请分别输入图的各个顶点:");
        for(int v=0;v<vexNum;v++){
            vexs[v]=sc.next();
        }
        arcs=new int[vexNum][vexNum];
        for(int v=0;v<vexNum;v++){
            for(int u=0;u<vexNum;u++){
                arcs[v][u]=INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点:");
        for(int k=0;k<arcNum;k++){
            int v=locateVex(sc.next());
            int u = locateVex(sc.next());
            arcs[v][u]=1;
        }
    }
    public int locateVex(Object vex){
        for(int v=0;v<vexNum;v++)
            if(vexs[v].equals(vex))
                return v;
            return -1;
    }
    void createDN(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数:");
        vexNum=sc.nextInt();
        arcNum=sc.nextInt();
        vexs=new Object[vexNum];
        System.out.println("请分别输入图的各个顶点:");
        for(int v=0;v<vexNum;v++){
            vexs[v]=sc.next();
        }
        arcs=new int[vexNum][vexNum];
        for(int v=0;v<vexNum;v++) {
            for (int u = 0; u < vexNum; u++) {
                arcs[v][u] = INFINITY;
            }
        }
            System.out.println("请输入各个边的两个顶点及其权值:");
            for(int k=0;k<arcNum;k++){
                int v=locateVex(sc.next());
                int u = locateVex(sc.next());
                arcs[v][u]=sc.nextInt();
            }
    }
    void createUDN(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数:");
        vexNum=sc.nextInt();
        arcNum=sc.nextInt();
        vexs=new Object[vexNum];
        System.out.println("请分别输入图的各个顶点:");
        for(int v=0;v<vexNum;v++){
            vexs[v]=sc.next();
        }
        arcs=new int[vexNum][vexNum];
        for(int v=0;v<vexNum;v++) {
            for (int u = 0; u < vexNum; u++) {
                arcs[v][u] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点及其权值:");
        for(int k=0;k<arcNum;k++){
            int v=locateVex(sc.next());
            int u = locateVex(sc.next());
            arcs[v][u]=arcs[u][v]=sc.nextInt();
        }

    }
    public int firstAdjVex(int v) throws Exception{
        if(v<0 &&v>=vexNum)
            throw new Exception("第"+v+"个顶点不存在!");
        for(int j=0;j<vexNum;j++){
            if(arcs[v][j]!=0&&arcs[v][j]<INFINITY)
                return j;
        }
        return -1;
    }
    public int nextAdjVex(int v,int w) throws Exception{
        if(v<0&&v>=vexNum)
            throw new Exception("第"+v+"个顶点不存在!");
        for(int j=w+1;j<vexNum;j++){
            if(arcs[v][j]!=0&&arcs[v][j]<INFINITY)
                return j;
        }
        return -1;
    }
    public int getVexNum(){
        return vexNum;
    }
    public Object getVex(int v) throws Exception{
        if(v<0&&v>=vexNum)
            throw new Exception("第"+v+"个顶点不存在!");
        return vexs[v];
    }
}
