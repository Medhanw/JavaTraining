import java.lang.classfile.constantpool.IntegerEntry;
import java.util.*;
import java.util.Queue;
public class Graph1 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void createGraph(int v) {
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());

        }
    }
    static void addEdge(int src, int dest){//1,2
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }
    static void BFS(int src, int v){
        boolean[] visited = new boolean[v];
        Queue<Integer> que = new LinkedList<>();

        que.add(src);
        visited[src] = true;
        
        while(!que.isEmpty()){
            int data = que.poll();
            System.out.print(data + " ");
            
            for(int neighbour : graph.get(data)){
                if(!visited[neighbour]){
                    que.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
    static void DFS(int src, int v){
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
    static void deleteNode(int targetNode, int totalVertices){
        if(targetNode < 0 || targetNode >=graph.size()){
            System.out.println("Node "+targetNode+"does not exist");
            return;
        }

        for(int i =0; i<graph.size(); i++){
            ArrayList<Integer> neighbors = graph.get(i); 
            neighbors.remove((Integer) targetNode);
        }
        graph.get(targetNode).clear();
        System.out.println("Node "+targetNode+"and its connections have been successfully deleted.");
    }
}
    public static void main(String[] args) {
        createGraph(6);
        addEdge(0, 1);
        addEdge(0, 5);
        addEdge(1, 2);
        addEdge(1, 5);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 5);

        System.out.print("DFS Traversal: ");
        DFS(0, 6);     
        System.out.println();

        System.out.print("BFS Traversal: ");
        BFS(0, 6);
        System.out.println();

    }

}
