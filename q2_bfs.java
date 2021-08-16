import java.util.*;
class q2_bfs {
    int MAX =1000;
    Map<Integer,ArrayList<Integer>> graph = new HashMap<>(); 
    public void solve(int v,char source) {
        int src = (source-'A');
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        
        Boolean[] visited = new Boolean[MAX];
        for(int i= 0; i<MAX;i++){
            visited[i] = false;
        }

        ArrayList<Integer> ans = new ArrayList<>(); 
        
        while(q.size()!=0){
            int node  = q.poll();
            if(visited[node]==true){
                continue;
            }

            ans.add(node);
            visited[node]=true;

            for(int child : graph.get(node)){
                q.add(child);
            }
        }
        System.out.println("BFS traversal from "+(char)(src+'A')+" : \n");;
        for(int s : ans){
            System.out.print((char)(s+'A')+" ");
        }
    }

    q2_bfs(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v = scan.nextInt();
        System.out.println("Enter number of edges");
        int e = scan.nextInt();

        for(int i = 0; i<=MAX;i++){
            //initialize adjacency list 
            graph.put(i, new ArrayList<Integer>());
        }

        for(int i =0  ; i<e;i++){
            System.out.printf("enter edge %d in the format vertex1 vertex2\n",i+1);
            char c1 = scan.next().charAt(0);
            char c2 = scan.next().charAt(0);
            int v1 = (c1-'A'); //converts character to integer
            int v2 = (c2-'A'); // A->0, B->1...

            ArrayList<Integer> v1edges = graph.get(v1);
            ArrayList<Integer> v2edges = graph.get(v2);

            v1edges.add(v2);
            v2edges.add(v1);
            graph.put(v1, v1edges);
            graph.put(v2, v2edges);
            // insert links v1->v2 , v2->v1 in the graph

        }
        solve(v,'A');
    }
    public static void main(String[] args) {
        new q2_bfs();
    }   
}

/**
 Input

 9
 10
 A B
 A S 
 S C 
 C D
 C F
 C E 
 E H
 H G
 G F 
 S G
 */