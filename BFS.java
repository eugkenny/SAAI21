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

                for(Integer neighbour : g.neighbours(current)){
                    if(!visited.contains(neighbour)){
                        queue.add(neighbour);
                    }
                }
            }
        }
        return visited;
    }

    public static void main(String [] args) {
        int N = 6;
        Graph g = new Graph(N);
        // add edges
        g.addEdge(0,1);
        g.addEdge(5,2);
        g.addEdge(3,4);
        g.addEdge(5,4);
        //g.addEdge(2,3);

        BFS bfs = new BFS();

        List<Integer> result = bfs.bfs(g, 3);

        for(int i : result){
            System.out.print( i + ", ");
        }
    }
}
