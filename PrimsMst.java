import java.util.*;

public class Prims {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();

        int[][] graph=new int[V][V];
        for(int i=0;i<V;i++)
            for(int j=0;j<V;j++)
                graph[i][j]=sc.nextInt();

        boolean[] visited=new boolean[V];
        int[] key=new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;

        int res=0;

        for(int i=0;i<V;i++){
            int u=-1;
            for(int j=0;j<V;j++)
                if(!visited[j] && (u==-1 || key[j]<key[u])) u=j;

            visited[u]=true;
            res+=key[u];

            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && !visited[v] && graph[u][v]<key[v]){
                    key[v]=graph[u][v];
                }
            }
        }

        System.out.println("MST Cost: "+res);
    }
}
