import java.util.LinkedList;
import java.util.List;

public class BFS {
    LinkedList<Integer> visited;
    LinkedList<Integer> queue;

    public BFS(){
    }

    public List<Integer> bfs(Graph g, int source){
        visited = new LinkedList<>();
        queue = new LinkedList<>();

        queue.add(source);

        while(!queue.isEmpty()){
            int current = queue.removeFirst();

            if(!visited.contains(current)){
                visited.add(current);

                for(Edge neighbour : g.neighbours(current)){
                    if(!visited.contains(neighbour.to())){
                        queue.add(neighbour.to());
                    }
                }
            }
        }
        return visited;
    }

    public static void main(String [] args) {
        int N = 24;
        Graph g = new Graph(N);
        // add edges
        g.addEdge(0,1, 3);
        g.addEdge(0,5, 7);
        g.addEdge(0,4, 6);
        g.addEdge(1,2, 6);
        g.addEdge(1,6, 5);
        g.addEdge(1,13, 8);
        g.addEdge(2,17, 7);
        g.addEdge(2,9, 4);
        g.addEdge(3,9, 5);
        g.addEdge(4,11, 4);
        g.addEdge(6,15, 4);
        g.addEdge(6,7, 7);
        g.addEdge(7,15, 3);
        g.addEdge(8,16, 4);
        g.addEdge(8,18, 4);
        g.addEdge(8,17, 6);
        g.addEdge(9,23, 8);
        g.addEdge(9,17, 5);
        g.addEdge(10,19, 8);
        g.addEdge(10,22, 7);
        g.addEdge(11,19, 9);
        g.addEdge(12,20, 9);
        g.addEdge(12,21, 7);
        g.addEdge(12,13, 5);
        g.addEdge(13,21, 6);
        g.addEdge(13,14, 7);
        g.addEdge(14,15, 5);
        g.addEdge(15,16, 9);
        g.addEdge(16,18, 4);
        g.addEdge(17,23, 4);

        BFS bfs = new BFS();

        List<Integer> result = bfs.bfs(g, 5);

        for(int i : result){
            System.out.print( i + ", ");
        }
    }
}
