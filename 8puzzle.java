import java.util.*;

class Node {
    int[][] state;
    int g, h;
    Node parent;

    Node(int[][] state, int g, int h, Node parent) {
        this.state = state;
        this.g = g;
        this.h = h;
        this.parent = parent;
    }

    int f() { return g + h; }
}

public class AStar8Puzzle {
    static int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};

    static int heuristic(int[][] state) {
        int h = 0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(state[i][j] != 0 && state[i][j] != goal[i][j]) h++;
        return h;
    }

    static boolean isGoal(int[][] state) {
        return Arrays.deepEquals(state, goal);
    }

    static List<Node> getNeighbors(Node node) {
        List<Node> list = new ArrayList<>();
        int x=0,y=0;

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(node.state[i][j]==0){ x=i; y=j; }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d: dirs){
            int nx=x+d[0], ny=y+d[1];
            if(nx>=0 && ny>=0 && nx<3 && ny<3){
                int[][] newState = new int[3][3];
                for(int i=0;i<3;i++) newState[i]=node.state[i].clone();
                newState[x][y]=newState[nx][ny];
                newState[nx][ny]=0;
                list.add(new Node(newState, node.g+1, heuristic(newState), node));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] start = new int[3][3];

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                start[i][j] = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::f));
        pq.add(new Node(start,0,heuristic(start),null));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(isGoal(curr.state)){
                System.out.println("Solved!");
                return;
            }
            for(Node n: getNeighbors(curr)){
                pq.add(n);
            }
        }
    }
}
