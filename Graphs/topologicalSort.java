import java.util.*;

public class topologicalSort {
    static class Edge{
        int src; 
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2,3 ));
        graph[3].add(new Edge(3,1 ));
        graph[4].add(new Edge(4, 0 ));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 0));
    }
    public static void topoSortUtil(ArrayList<Edge> graph[], int cur, boolean[] visited, Stack<Integer> stk){
        visited[cur] = true;
        for(int i = 0; i < graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
            if(!visited[e.dest])
            topoSortUtil(graph, e.dest, visited, stk);
        }
        stk.push(cur);
    }
    public static void topoSort(ArrayList<Edge> graph[], int v){
        boolean[] visited = new boolean[v];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < v; i++){
            if(!visited[i]){
                topoSortUtil(graph, i, visited, stk);;
            }
        }
        while(!stk.isEmpty()){
            System.out.print(stk.pop() + " ");
        }
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topoSort(graph, v);
    }
}
