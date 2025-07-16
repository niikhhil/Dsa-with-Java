import java.util.*;

public class Classroom {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graphs[]) {
        for (int i = 0; i < graphs.length; i++) {
            graphs[i] = new ArrayList<Edge>();
        }
        graphs[0].add(new Edge(0, 2));
        graphs[1].add(new Edge(1, 0));
        graphs[2].add(new Edge(2, 3));
        graphs[3].add(new Edge(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge> graph[], boolean[] visited, int curr, boolean[] rec) {
        visited[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycle(graph, visited, e.dest, rec)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean[] visited = new boolean[v];
        boolean[] rec = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                boolean isCycle = isCycle(graph, visited, 0, rec);
                if (isCycle) {
                    System.out.println(true);
                    break;
                }
            }
        }
    }
}
