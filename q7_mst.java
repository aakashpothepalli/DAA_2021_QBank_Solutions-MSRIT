import java.util.*;
class pair{
    int v,cost,parent;
    pair(int v,int cost,int parent){
        this.v =v ;
        this.cost = cost;
        this.parent = parent;
    }
}

class q7_mst {
    Map<Integer,ArrayList<pair>> graph = new HashMap<Integer,ArrayList<pair>>();
    
    public void solve(int v, int e,int src) {
        PriorityQueue<pair> pq = new PriorityQueue<pair>(v,(p1,p2)->p1.cost<=p2.cost?-1:1);
        Map<Integer,Boolean> visited = new HashMap<>();        
        
        ArrayList<pair> edges = new ArrayList<pair>();
        
        pq.add(new pair(src,0,-1));
        while(pq.size()!=0){
            pair p = pq.poll();
            if(visited.get(p.v)!=null){
                continue;
            }
            visited.put(p.v,true);
            if(p.parent!=-1)
                edges.add(new pair(p.v,p.cost,p.parent));
            for(pair pc : graph.get(p.v)){
                pq.add(new pair(pc.v,pc.cost+p.cost,p.v));
            }
        }
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

        for(int i =0  ; i<e;i++){
            System.out.printf("enter edge %d in the format vertex1 vertex2 cost\n",i+1);
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int cost = scan.nextInt();

            ArrayList<pair> v1edges = graph.get(v1);
            if(v1edges==null)v1edges = new ArrayList<pair>();
            ArrayList<pair> v2edges = graph.get(v2);
            if(v2edges == null)v2edges = new ArrayList<pair>();

            v1edges.add(new pair(v2,cost,-1));
            v2edges.add(new pair(v1,cost,-1));
            graph.put(v1, v1edges);
            graph.put(v2, v2edges);
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