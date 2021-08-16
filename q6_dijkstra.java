import java.util.*;
class q6_dijkstra {
    class Pair{
        int v,cost;
        Pair(int v,int cost){
            this.v =v ;
            this.cost = cost;
        }
    }
    Map<Integer,ArrayList<Pair>> graph = new HashMap<Integer,ArrayList<Pair>>();
    
    public void solve(int v, int e,int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v,(p1,p2)->p1.cost<=p2.cost?-1:1);
        Boolean[] visited = new Boolean[v+1];        
        int[] dis= new int[v+1];

        for(int i = 0 ;i<=v;i++){
            dis[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dis[src] = 0;
        
        pq.add(new Pair(src,0));
        while(pq.size()!=0){
            Pair p = pq.poll();
            if(visited[p.v]==true){
                continue;
            }
            visited[p.v]=true;
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

        for(int i = 0; i<=v;i++){
            //initialize adjacency list 
            graph.put(i, new ArrayList<Pair>());
        }
        for(int i =0  ; i<e;i++){
            System.out.printf("enter edge %d in the format vertex1 vertex2 cost\n",i+1);
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int cost = scan.nextInt();

            ArrayList<Pair> v1edges = graph.get(v1);
            ArrayList<Pair> v2edges = graph.get(v2);
            
            v1edges.add(new Pair(v2,cost));
            v2edges.add(new Pair(v1,cost));
            graph.put(v1, v1edges);
            graph.put(v2, v2edges);
            // insert links v1->v2 , v2->v1 in the graph
        }
        solve(v,e,1);
    }

    public static void main(String[] args) {
        new q6_dijkstra();

    }
}

/*
Input

5
6
1 2 10 
1 5 100
2 3 50
5 3 10
5 4 60
3 4 20

*/