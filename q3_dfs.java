// similar to question 2, replace queue with stack
import java.util.*;

class q3_dfs {
    Map<String,ArrayList<String>> m = new HashMap<>(); 
    public void solve(String src) {

        Stack<String> st = new Stack<String>();
        st.add(src);
        ArrayList<String> nodes = new ArrayList<>(); 
        HashMap<String,Boolean> visited = new HashMap<>();
        while(st.size()!=0){
            String node  = st.peek();
            st.pop();
            if(visited.get(node)!=null){
                continue;
            }
            nodes.add(node);
            visited.put(node,true);
            for(String child : m.get(node)){
                st.add(child);
            }
        }
        System.out.println("DFS traversal from "+src+" : \n");;
        for(String s : nodes){
            System.out.print(s+" ");
        }
    }
    q3_dfs(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v = scan.nextInt();
        System.out.println("Enter number of edges");
        int e = scan.nextInt();
        
        for(int i =0  ; i<e;i++){
            System.out.printf("enter edge %d in the format vertex1 vertex2\n",i+1);
            String v1 = scan.next();
            String v2 = scan.next();

            ArrayList<String> v1edges = m.get(v1);
            if(v1edges==null)v1edges = new ArrayList<>();
            ArrayList<String> v2edges = m.get(v2);
            if(v2edges == null)v2edges = new ArrayList<>();

            v1edges.add(v2);
            v2edges.add(v1);
            m.put(v1, v1edges);
            m.put(v2, v2edges);
        }
        solve("A");
    }
    public static void main(String[] args) {
        new q3_dfs();
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