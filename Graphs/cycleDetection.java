import java.util.ArrayList;

public class cycleDetection {
    static class Edge{
        int src; 
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graphs[]) {
        for (int i = 0; i < graphs.length; i++) {
            graphs[i] = new ArrayList<Edge>();
        }
        graphs[0].add(new Edge(0, 1));
        graphs[0].add(new Edge(0, 4));

        graphs[1].add(new Edge(1, 0));
        graphs[1].add(new Edge(1, 2));
        //graphs[1].add(new Edge(1, 4));

        graphs[2].add(new Edge(2, 1));
        graphs[2].add(new Edge(2, 3));

        graphs[3].add(new Edge(3, 2));

        graphs[4].add(new Edge(4, 0));
        //graphs[4].add(new Edge(4, 1));
        graphs[4].add(new Edge(4, 5));
        
        graphs[5].add(new Edge(5, 4));
    }
    public static boolean isCycle(ArrayList<Edge> graph[], boolean[] visited, int curr, int par){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visited[e.dest] && e.dest != par){
                return true;
            }
            else if(!visited[e.dest]){
                if(isCycle(graph, visited, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph, new boolean[v], 0, -1));
    }
}
