import java.util.*;


class q5_quicksort{

    public static void sort(ArrayList<Integer> ar){
        if(ar.size()==0){
            return;
        } 
        else{
            int ind = ar.size()/2;
            ArrayList<Integer> left= new ArrayList<>(),right = new ArrayList<>();

            for(int i  =0;  i<ar.size();i++){
                if(ar.get(i)<=ar.get(ind)){
                    left.add(ar.get(i));
                }
                else{
                    right.add(ar.get(i));
                }
            }
            sort(left);
            sort(right);
            for(int i  =0; i<left.size();i++){
                ar.set(i, left.get(i));
            }
            int j = left.size();
            for(int i=0;i<right.size();i++ ){
                ar.set(j, right.get(i));
                j++;
            }
        }  
    }
    public static void main(String args[]){
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(10,9,2,7,5,6,4,3,8,1));

        
        sort(ar);
        System.out.println(ar);
    }
}