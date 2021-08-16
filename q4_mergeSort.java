import java.util.Arrays;

class Sorting {

    static void merge(int[] arr, int left, int mid, int right)
    {
        int LEFT[] = Arrays.copyOfRange(arr, left, mid);
        int RIGHT[] = Arrays.copyOfRange(arr, mid, right);

        //merging
        int left_ptr=0;
        int right_ptr=0;
        int index=left;
           
        while((left_ptr!=(mid-left)) && right_ptr!=(right-mid))
        {
            if(LEFT[left_ptr]<=RIGHT[right_ptr])
            {
                arr[index++]=LEFT[left_ptr++];
            }
            else{
                arr[index++] = RIGHT[right_ptr++];
            }
        }
        while(left_ptr!=(mid-left))
        {
            arr[index++]=LEFT[left_ptr++];
        }
        while(right_ptr!=(right-mid))
        {
            arr[index++]=RIGHT[right_ptr++];
        }
    }

    static void MergeSort(int[] arr, int left, int right) {
        //System.out.println("left: " + left + "right: " + right);
        if (right-left==1) {
            return;
        }
        else {
            int mid = left + (right-left)/2;

            // recursive magic getting sorted half subarrays somehow
            MergeSort(arr, left, mid);
            MergeSort(arr, mid, right);

            merge(arr, left, mid, right);

        }
    }
}

class q4_mergeSort{
    public static void main(String[] args){
        int length[] = {100,200,300,500,1000,2000,3000,5000,6000,8000,10000,50000};
        int arr[] = new int[50000];
        long start,end;

        for(int i=0; i<length.length; ++i)
        {
            for(int j=0; j<length[i]; ++j)
            {
    
                arr[j] = (int)(Math.random()*10+1);
            }
            start = System.nanoTime();
            Sorting.MergeSort(arr,0,length[i]);
            end = System.nanoTime();
            System.out.println("Time Taken for "+ length[i]+" is "+(end-start)/1000000.0 +" ms");
        }
    }
}
//contributed by sahil