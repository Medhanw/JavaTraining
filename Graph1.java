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
    static void BFS(int v){
        boolean[] visited = new boolean[v];
        Queue<Integer> que = new Queue<Integer>();

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
        boolean[] visited = new boolean[];

    }
    public static void main(String[] args) {
        createGraph(10);     
    }

}
