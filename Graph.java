import java.util.LinkedList;

public class Graph {

    int N; // Num vertices

    LinkedList<Integer> adj [];

    public Graph(int N){
        this.N = N;
        adj = new LinkedList[N];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int u){
        if(!hasEdge(v, u)) {
            adj[v].add(u);
            adj[u].add(v);
        }
    }

    public boolean hasEdge(int v, int u){
        return adj[v].contains(u);
    }

    public Iterable<Integer> neighbours(int v){
        return adj[v];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < adj.length; i++) {
            sb.append(i + ": ");
            for (int j: adj[i]) {
                sb.append( j + ", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Test
    public static void main(String args[]){
        Graph g = new Graph(10);

        System.out.println(g);

        g.addEdge(0, 1);
        g.addEdge(4, 0);
        g.addEdge(2,5);
        g.addEdge(4,5);

        System.out.println(g);

        for (int i : g.neighbours(5)) {
            System.out.print(i + ", ");
        }

        System.out.println();

        System.out.println(g);
    }

}
