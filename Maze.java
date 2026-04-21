import java.util.*;

class Cell {
    int x,y,g,h;
    Cell parent;

    Cell(int x,int y,int g,int h,Cell p){
        this.x=x; this.y=y; this.g=g; this.h=h; this.parent=p;
    }
    int f(){ return g+h; }
}

public class AStarMaze {
    static int heuristic(int x,int y,int tx,int ty){
        return Math.abs(x-tx)+Math.abs(y-ty);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(), m=sc.nextInt();
        int[][] grid=new int[n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                grid[i][j]=sc.nextInt();

        int sx=sc.nextInt(), sy=sc.nextInt();
        int tx=sc.nextInt(), ty=sc.nextInt();

        PriorityQueue<Cell> pq=new PriorityQueue<>(Comparator.comparingInt(Cell::f));
        pq.add(new Cell(sx,sy,0,heuristic(sx,sy,tx,ty),null));

        boolean[][] visited=new boolean[n][m];

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            Cell c=pq.poll();

            if(c.x==tx && c.y==ty){
                System.out.println("Path Found");
                return;
            }

            for(int[] d:dirs){
                int nx=c.x+d[0], ny=c.y+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==0 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    pq.add(new Cell(nx,ny,c.g+1,heuristic(nx,ny,tx,ty),c));
                }
            }
        }
    }
}
