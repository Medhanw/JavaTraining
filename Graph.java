import java.util.*;
public class Graph {
    public final int v;
    public final List<List<Integer>> adj;

    public Graph(int v){
        this.v=v;
        adj = new ArrayList<>(v);
        for(int i = 0; i < v; i++){
        adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest){
    adj.get(src).add(dest);
    }
    private boolean isCyclic(int i, boolean[] visited, boolean[] recStack){
        if(recStack[i]) return true;
        if(visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;

        List<Integer> child = adj.get(i);
        for(Integer c : child){
            if(isCyclic(c, visited, recStack)){
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
    public boolean isCyclic(){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for(int i = 0; i<v;i++){
            if(!visited[i]){
                if(isCyclic(i, visited, recStack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);

        if(graph.isCyclic()){
            System.out.println("Graph contains a cycle.");
        }else{
            System.out.println("Graph does not contain a cycle");
        }
    }
}

    
    
