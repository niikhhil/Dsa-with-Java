import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {
    public static ArrayList<Integer> kahn(int V, int[][] edge){
        //creating adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] e: edge){
            graph.get(e[0]).add(e[1]);
        }

        int[] indegree = new int[V];
        // creating indegree array
        for(int i = 0; i < V; i++){
            int size = graph.get(i).size();
            for(int j = 0; j < size; j++) {
                indegree[graph.get(i).get(j)]++;
            }
        }

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        // adding 0 indegree nodes to queue
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            visited[node] = true;
            for(int i = 0; i < graph.get(node).size(); i++){
                indegree[graph.get(node).get(i)]--;
                if(indegree[graph.get(node).get(i)] == 0){
                    q.add(graph.get(node).get(i));
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int V = 6;
        int[][] edge = new int[][]{{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
        ArrayList<Integer> ans =  kahn(V, edge);

        for(int i: ans){
            System.out.print(i + " ");
        }
    }
}
