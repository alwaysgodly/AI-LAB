import java.util.*;

class Edge {
    int u,v,w;
    Edge(int u,int v,int w){ this.u=u; this.v=v; this.w=w; }
}

public class Kruskal {
    static int find(int[] parent,int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent,parent[x]);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt(), E=sc.nextInt();

        List<Edge> edges=new ArrayList<>();

        for(int i=0;i<E;i++){
            edges.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }

        edges.sort(Comparator.comparingInt(e->e.w));

        int[] parent=new int[V];
        for(int i=0;i<V;i++) parent[i]=i;

        int cost=0;

        for(Edge e:edges){
            int pu=find(parent,e.u), pv=find(parent,e.v);
            if(pu!=pv){
                parent[pu]=pv;
                cost+=e.w;
            }
        }

        System.out.println("MST Cost: "+cost);
    }
}
