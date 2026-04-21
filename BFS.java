import java.util.*;

public class BFSRecursive {
    static void bfsRecursive(Queue<Integer> queue, boolean[] visited, List<List<Integer>> adj) {
        if (queue.isEmpty()) return;

        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
        bfsRecursive(queue, visited, adj);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        int start = sc.nextInt();
        visited[start] = true;
        queue.add(start);

        bfsRecursive(queue, visited, adj);
    }
}
