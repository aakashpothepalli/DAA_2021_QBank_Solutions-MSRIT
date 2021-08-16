import java.util.*;

class q7_mst {
    class edge{
        int v,cost,parent;
        edge(int v,int cost,int parent){
            this.v =v ;
            this.cost = cost;
            this.parent = parent;
        }
    }
    Map<Integer,ArrayList<edge>> graph = new HashMap<Integer,ArrayList<edge>>();
    
    public void solve(int v, int e,int src) {
        PriorityQueue<edge> pq = new PriorityQueue<edge>(v,(p1,p2)->p1.cost<=p2.cost?-1:1);
        
        Boolean[] visited = new Boolean[v+1];        
        for(int i = 0;i<=v;i++){
            visited[i] = false;
        }

        ArrayList<edge> edges = new ArrayList<edge>();
        
        pq.add(new edge(src,0,-1));
        while(pq.size()!=0){
            edge p = pq.poll();
            if(visited[p.v]==true){
                continue;
            }
            visited[p.v] = true;

            edges.add(new edge(p.v,p.cost,p.parent));

            for(edge child : graph.get(p.v)){
                pq.add(new edge(child.v,child.cost+p.cost,p.v));
            }
        }
        System.out.println("Edges of minimum spanning tree Vertex1 - Vertex2");
        for(int i = 0 ; i <edges.size();i++){
            System.out.println(edges.get(i).v + " - " + edges.get(i).parent  );
        }
        
    }
    q7_mst(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices ");
        int v = scan.nextInt();
        System.out.println("Enter number of edges");
        int e = scan.nextInt();
        
        for(int i = 0; i<=v;i++){
            //initialize adjacency list 
            graph.put(i, new ArrayList<edge>());
        }

        for(int i =0  ; i<e;i++){
            System.out.printf("enter edge %d in the format vertex1 vertex2 cost\n",i+1);
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int cost = scan.nextInt();

            ArrayList<edge> v1edges = graph.get(v1);
            ArrayList<edge> v2edges = graph.get(v2);

            v1edges.add(new edge(v2,cost,-1));
            v2edges.add(new edge(v1,cost,-1));
            graph.put(v1, v1edges);
            graph.put(v2, v2edges);
            // insert links v1->v2,cost , v2->v1,cost in the graph

        }
        solve(v,e,1);
    }

    public static void main(String[] args) {
        new q7_mst();

    }
}
/*
input
5
7
5 1 5
5 4 3
3 4 2
3 2 1
2 1 10
4 2 6
5 3 7
*/