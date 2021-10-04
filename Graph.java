import java.util.LinkedList;

public class Graph {

    int N; // Num vertices

    LinkedList<Edge> adj [];

    public Graph(int N){
        this.N = N;
        adj = new LinkedList[N];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int u, int weight){
        if(!hasEdge(v, u)) {
            adj[v].add(new Edge(v,u, weight));
            adj[u].add(new Edge(u,v, weight));
        }
    }

    public boolean hasEdge(int v, int u){
        return adj[v].contains(u);
    }

    public Iterable<Edge> neighbours(int v){
        return adj[v];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < adj.length; i++) {
            sb.append(i + ": ");
            for (Edge j: adj[i]) {
                sb.append( j.to() + ", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Test
    public static void main(String args[]){
        Graph g = new Graph(10);

        System.out.println(g);

        g.addEdge(0, 1, 3);
        g.addEdge(4, 0, 6);
        g.addEdge(2,5, 7);
        g.addEdge(4,5, 4);

        System.out.println(g);

        for (Edge i : g.neighbours(5)) {
            System.out.print(i.to + ", ");
        }

        System.out.println();

        System.out.println(g);
    }

}
