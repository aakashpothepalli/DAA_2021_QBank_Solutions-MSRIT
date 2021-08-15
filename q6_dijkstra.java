import java.util.*;
class Pair{
    int v,cost;
    Pair(int v,int cost){
        this.v =v ;
        this.cost = cost;
    }
}
class q6_dijkstra {
    Map<Integer,ArrayList<Pair>> graph = new HashMap<Integer,ArrayList<Pair>>();
    
    public void solve(int v, int e,int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v,(p1,p2)->p1.cost<=p2.cost?-1:1);
        Map<Integer,Boolean> visited = new HashMap<>();        
        int[] dis= new int[v+1];

        for(int i = 0 ;i<v;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;
        
        pq.add(new Pair(src,0));
        while(pq.size()!=0){
            Pair p = pq.poll();
            if(visited.get(p.v)!=null){
                continue;
            }
            visited.put(p.v,true);
            dis[p.v] = p.cost;

            for(Pair pc : graph.get(p.v)){
                pq.add(new Pair(pc.v,pc.cost+p.cost));
            }
        }
        for(int i = 1 ; i <=v;i++){
            System.out.println(i +" : "+dis[i] );
        }
        
    }
    q6_dijkstra(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices ");
        int v = scan.nextInt();
        System.out.println("Enter number of edges");
        int e = scan.nextInt();

        for(int i =0  ; i<e;i++){
            System.out.printf("enter edge %d in the format vertex1 vertex2 cost\n",i+1);
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int cost = scan.nextInt();

            ArrayList<Pair> v1edges = graph.get(v1);
            if(v1edges==null)v1edges = new ArrayList<Pair>();
            ArrayList<Pair> v2edges = graph.get(v2);
            if(v2edges == null)v2edges = new ArrayList<Pair>();

            v1edges.add(new Pair(v2,cost));
            v2edges.add(new Pair(v1,cost));
            graph.put(v1, v1edges);
            graph.put(v2, v2edges);
        }
        solve(v,e,1);
    }

    public static void main(String[] args) {
        new q6_dijkstra();

    }
}


//Input

// 5
// 6
// 1 2 10 
// 1 5 100
// 2 3 50
// 5 3 10
// 5 4 60
// 3 4 20