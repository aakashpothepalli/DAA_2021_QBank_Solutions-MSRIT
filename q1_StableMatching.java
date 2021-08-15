import java.util.*;
class q1_StableMatching{
    int w[],m[], mp[][],wp[][];
    int n ;
    // m[] will store a boolean which signifies that ith man is paired up or not
    // w[] will store the index of the men if matched, 0 otherwise

    public boolean isPrefferedBetter(int man1,int man2, int woman){
        for(int i  = 1;i<=n;i++){
            if(wp[woman][i]==man1){
                return true;
            }    
            else if(wp[woman][i]==man2){
                return false;
            }
        }
        return false;
    }
    public void solve(){
            int freemencount = n;
            while(freemencount>0){
                int freeman = 0;
                for(int i = 1; i<=n;i++){// for every man
                    if(m[i]==0){
                        freeman = i;
                        break;
                    }
                }
                if(freeman ==0){
                    continue;
                }
                // freeman is not paired up

                for(int j = 1; j<=n;j++){
                    // search man's pref list
                    if(m[freeman]!=0){
                        break;
                    }
                    int woman = mp[freeman][j];
                    if(w[woman]==0){
                        // woman is not paired up
                        m[freeman] = 1;
                        w[woman] = freeman;
                        freemencount--;
                    }
                    else{// woman is paired up with someone
                        int pairedman  = w[woman];
                        if(isPrefferedBetter(freeman,pairedman,woman)){// if freeman is preffered better than paired man
                            m[freeman] = 1;
                            w[woman] = freeman;
                            m[pairedman] = 0;
                        }
                    }
                }
            }
    }
    q1_StableMatching(){
        w = new int[1001];
        m = new int[1001];
        mp = new int [101][101];
        wp = new int[101][101];

        Scanner scan = new Scanner(System.in);         
        System.out.println("Enter number of men\n");
        n = scan.nextInt();


        for(int i = 1;i<=n;i++){
            System.out.printf("Enter preference list for man %d\n",i);
            for(int j = 1; j<=n;j++){
                mp[i][j]  = scan.nextInt();
            }
        }
        

        for(int i = 1;i<=n;i++){
            System.out.printf("Enter preference list for woman %d\n",i);
            for(int j = 1; j<=n;j++){
                wp[i][j]  = scan.nextInt();
            }
        }   
        solve();

        for(int i = 1 ; i<=n;i++){
            System.out.printf("%d:%d ",i,w[i]);
        }
        
    }
    public static void main(String[ ]args){
         new q1_StableMatching();

    }
}

/**
 Input 

4

1 2 3 4 
2 1 3 4
4 1 3 2 
4 3 2 1


1 2 4 3 
2 3 1 4
3 4 1 2 
3 4 2 1


 */