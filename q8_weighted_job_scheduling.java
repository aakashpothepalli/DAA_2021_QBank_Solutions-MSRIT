import java.util.*;
class q8_weighted_job_scheduling {
    class job{
        int start,end,profit;
        job(int s,int e , int p){
            start = s ;
            end = e;
            profit = p;
        }
    }
    
    int[] start_times = {1,2,3,4,5,6};
    int[] end_times = {2,5,6,8,9,10};
    int[] profits = {100,200,300,400,500,100};
    int n = start_times.length;
    job[] jobs= new job[n];

    q8_weighted_job_scheduling(){
        
        for(int i = 0  ; i <n;i++){
            jobs[i] = new job(start_times[i],end_times[i],profits[i]);
        }

        Arrays.sort(jobs,(job1,job2)->job1.end<job2.end?-1:1);   

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (job j : jobs) {
            int cur = dp.floorEntry(j.start).getValue() + j.profit;
            if (cur > dp.lastEntry().getValue())
                dp.put(j.end, cur);
        }
        
        System.out.println( dp.lastEntry().getValue());
    }
    public static void main(String[] args) {
      new q8_weighted_job_scheduling();  
    }    
}
/// concise solution found on leetcode