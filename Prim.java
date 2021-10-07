import java.util.LinkedList;
import java.util.List;

public class Prim {

    LinkedList<Integer> visited;

    public Prim(){
        visited = new LinkedList<>();
    }

    public List<Integer> prim(Graph g, int start){
        visited.add(start);

        LinkedList<Edge> edges = new LinkedList<>();
        // Add edges connected to start
        for (Edge e : g.neighbours(start)){
            edges.add(e);
        }
        while(visited.size() != g.N) {
            for (Edge e : edges) {
                System.out.print(e + " - ");
            }
            System.out.println();

            // Find the smallest edge
            int minWeight = 100;
            Edge min = null;

            for (Edge e : edges) {
                if(!(visited.contains(e.to()))){
                    if (e.weight() < minWeight) {
                        minWeight = e.weight();
                        min = e;
                    }
                }
            }
            edges.remove(min);
            visited.add(min.to());
            //System.out.println(min);

            for (Edge e : g.neighbours(min.to())) {
                //System.out.println("-->" + e);
                if (!(visited.contains(e.to()))) {
                    edges.add(e);
                    //System.out.println("--->" + e);
                }
            }
        }

        return visited;
    }

    public static void main(String [] args){
        int N = 9;

        Graph g = new Graph(N);
        g.addEdge(0,1,3);
        g.addEdge(0,5,5);
        g.addEdge(0,4,4);
        g.addEdge(1,2,6);
        g.addEdge(1,5,4);
        g.addEdge(4,5,3);
        g.addEdge(2,5,3);
        g.addEdge(2,3,5);
        g.addEdge(5,7,4);
        g.addEdge(5,6,6);
        g.addEdge(6,7,7);
        g.addEdge(3,7,3);
        g.addEdge(3,8,4);
        g.addEdge(8,7,5);

        Prim prim = new Prim();

        List<Integer> result = prim.prim(g,0);

        for(int i : result){
            System.out.print( i + ", ");
        }
    }

}
