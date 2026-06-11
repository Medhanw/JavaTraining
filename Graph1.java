import java.lang.classfile.constantpool.IntegerEntry;
import java.util.*;
import java.util.Queue;

public class Graph1 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void createGraph(int v) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());

        }
    }

    static void addEdge(int src, int dest) {// 1,2
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    static void BFS(int src, int v) {
        boolean[] visited = new boolean[v];
        Queue<Integer> que = new LinkedList<>();

        que.add(src);
        visited[src] = true;

        while (!que.isEmpty()) {
            int data = que.poll();
            System.out.print(data + " ");

            for (int neighbour : graph.get(data)) {
                if (!visited[neighbour]) {
                    que.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    static void DFS(int src, int v) {
        Deque<Integer> st = new ArrayDeque<>();
        boolean[] visited = new boolean[v];

        st.push(src);

        while (!st.isEmpty()) {
            int data = st.pop(); // Pop the node first

            if (!visited[data]) {
                visited[data] = true;
                System.out.print(data + " ");
                ArrayList<Integer> neighbors = graph.get(data);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        st.push(neighbor);
                    }

                }
            }
        }
    }

    static boolean isNodeExisting(int node) {
        // A node exists if it falls within the current bounds of our adjacency list
        return node >= 0 && node < graph.size();
    }

    static boolean isEdgeExisting(int src, int dest) {
        // Step 1: Ensure both nodes actually exist in the graph first
        if (!isNodeExisting(src) || !isNodeExisting(dest)) {
            return false;
        }

        // Step 2: Check if 'dest' is inside the neighbor list of 'src'
        return graph.get(src).contains(dest);
    }

    static void deleteNode(int targetNode, int totalVertices) {
        if (targetNode < 0 || targetNode >= graph.size()) {
            System.out.println("Node " + targetNode + "does not exist");
            return;
        }

        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Integer> neighbors = graph.get(i);
            neighbors.remove((Integer) targetNode);
        }
        graph.get(targetNode).clear();
        System.out.println("Node " + targetNode + "and its connections have been successfully deleted.");
    }

    static void dfstraverse(int src, boolean[] visited) {
        visited[src] = true;
        for (int neighbour : graph.get(src)) {
            if (!visited[neighbour]) {
                dfstraverse(neighbour, visited);
            }
        }
    }

    static int countConnectedComp(int v) {
        boolean[] visited = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfstraverse(i, visited);
                count++;
            }
        }
        return count;
    }

    static boolean dfscycle(int src, int parent, boolean[] visited) {
        visited[src] = true;
        for (int i : graph.get(src)) {
            if (!visited[i]) {
                if (dfscycle(i, src, visited))
                    return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    static boolean isCycle(int src, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfscycle(i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        createGraph(6);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(3, 4);
        // System.out.println(countConnectedComp(6));
        System.out.println(isCycle(0, 6));
        // createGraph(6);

        // addEdge(0, 1);
        // addEdge(0, 5);
        // addEdge(1, 2);
        // addEdge(1, 5);
        // addEdge(2, 3);
        // addEdge(3, 4);
        // addEdge(4, 5);

        // System.out.print("DFS Traversal: ");
        // DFS(0, 6);
        // System.out.println();

        // System.out.print("BFS Traversal: ");
        // BFS(0, 6);
        // System.out.println();

    }

}
