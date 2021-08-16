public class q5_quicksort {

    public static int partition(int arr[],int left,int right){
        int i=left-1;
        int j=0;
        int pivot=arr[right-1],temp;

        for(j=left; j<right-1; ++j){
            if(arr[j]<pivot){
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                
            }
        }

        for(j=right-1; j>i+1; --j)
        {
            arr[j]=arr[j-1];
        }
        arr[i+1] = pivot;
        return i+1;
    }
    public static void quicksort(int[] arr,int left,int right)
    {
        if(right-left<=1)
        {
            return;
        }

        int pivot = partition(arr, left, right);
        //System.out.println(pivot);
        
        //left half
        quicksort(arr, left, pivot);
        //right half
        quicksort(arr, pivot+1, right);

    }
    public static void main(String args[]){
        int length = 10;
        int arr[] = new int[length];
        System.out.println("Before Sorting");
        for(int i=0; i<length; ++i)
        {
            arr[i] = (int)(Math.random()*10);
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        quicksort(arr,0,length);
        System.out.println("\nAfter Sorting");
        for(int i=0; i<length; ++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
/// contributed by sahil