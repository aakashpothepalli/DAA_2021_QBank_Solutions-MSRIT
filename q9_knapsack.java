class q9_knapsack {
    int[] weight = {3,5,6,2};
    int[] value = {10,4,9,11};
    int maxWeight = 7;

    public void printKnapsack(int dp[][]){
        System.out.println("Weights included in the knapsack are");
        int maxval = dp[weight.length][maxWeight];
        int j = maxWeight;
        for (int i = weight.length; i>0 && maxval>0; i--) {
            if (maxval == dp[i-1][j])
                continue;
            else { 
                System.out.print(weight[i-1] + " ");
                maxval -= value[i-1];
                j -= weight[i-1];
            }
        }
    }

    q9_knapsack(){

        int[][] dp = new int[weight.length+1][maxWeight+1];
        
        for(int i = 0; i <=weight.length;i++){
            dp[i][0] = 0;
        }
        for(int i = 0  ;i <=maxWeight;i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i<=weight.length;i++){
            for(int j = 1; j<=maxWeight;j++){
                if(j-weight[i-1]>=0){
                    dp[i][j] = Math.max(value[i-1]+ dp[i-1][j-weight[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        printKnapsack(dp);

    }
    public static void main(String[] args) {
        new q9_knapsack();
    }
}
