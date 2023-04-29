import java.util.*;

public class main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int from = sc.nextInt();
        int where = sc.nextInt();
        int day = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        List<List<Integer>> weight = new ArrayList<>();
        for(int i = 0;i<n;i++){
            g.add(new ArrayList<>());
            weight.add(new ArrayList<>());
        }
        int tempFC ;
        int tempTC ;
        int w ;
        while(m-->0){
            tempFC=sc.nextInt();
            tempTC=sc.nextInt();
            w=sc.nextInt();
            g.get(tempFC-1).add(tempTC);
            g.get(tempTC-1).add(tempFC);
            weight.get(tempFC-1).add(w);
            weight.get(tempTC-1).add(w);
        }
        PriorityQueue<Node> all = new PriorityQueue<>();
        Node no ;
        all.add(new Node(from,0,0));
        while(!all.isEmpty()){
            no=all.poll();
            if(no.val==where){
                if(no.maxWeight-day<0 ) System.out.println(0);
                else System.out.println(no.maxWeight-day);

                break;
            }
            for(int i = 0;i<g.get(no.val-1).size();i++){
                if(g.get(no.val-1).get(i)!=from)
                    all.add( new Node( g.get(no.val-1).get(i),
                            (no.getMaxWeight()<weight.get(no.getVal()-1).get(i)) ?
                                    weight.get(no.getVal()-1).get(i): no.getMaxWeight(),
                            no.getWeight()+weight.get(no.getVal()-1).get(i)
                    ));
            }
        }
    }
}
