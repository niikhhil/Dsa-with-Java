import java.util.ArrayList;

class DisjointSet {
    ArrayList<Integer> size =  new ArrayList<>();
    ArrayList<Integer> rank =  new ArrayList<>();
    ArrayList<Integer> parent =  new ArrayList<>();

    public DisjointSet(int n) {
        for(int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUlP(int node) {
        if(parent.get(node) == node) {
            return node;
        }
        int ultimate = findUlP(parent.get(node));
        parent.set(node, ultimate);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulU = findUlP(u);
        int ulV = findUlP(v);

        if(ulU == ulV) {
            return;
        }
        if(size.get(ulU) < size.get(ulV)) {
            parent.set(ulU,ulV);
            size.set(ulV, size.get(ulU) + size.get(ulV));
        }
        else {
            parent.set(ulV,ulU);
            size.set(ulU, size.get(ulU) + size.get(ulV));
        }

    }
    
    public void unionByRank(int u, int v) {
        int ulU = findUlP(u);
        int ulV = findUlP(v);

        if(ulU == ulV) {
            return;
        }

        if(rank.get(ulU) < rank.get(ulV)) {
            parent.set(ulU, ulV);
        }
        else if(rank.get(ulV) < rank.get(ulU)) {
            parent.set(ulV, ulU);
        }
        else {
            parent.set(ulV, ulU);
            int rankU = rank.get(ulU);
            rank.set(ulU, rankU + 1);

        }
    }
}

public class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
   
    }
}
