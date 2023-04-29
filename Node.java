public class Node implements Comparable<Node>{
    int val ;
    int maxWeight ;
    int weight;
    Node(){}
    Node(int val,int maxWeight, int weight){
        this.val=val;
        this.maxWeight=maxWeight;
        this.weight=weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getVal() {
        return val;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node o) {
        if(o.getWeight()>this.getWeight())
            return -1;
        else if(o.getWeight()<this.getWeight())
            return 1;
        else
            return 0;
    }
}
