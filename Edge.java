public class Edge implements Comparable<Edge>{
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from(){
        return from;
    }

    public int to(){
        return to;
    }

    public int weight(){
        return weight;
    }

    public String toString(){
        return from + "," + to + ":" + weight();
    }

    @Override
    public int compareTo(Edge other) {
        if(this.weight < other.weight) return -1;
        if(this.weight > other.weight) return +1;
        return 0;
    }
}
