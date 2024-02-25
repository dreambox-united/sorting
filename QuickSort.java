/**
 * 4 20 6 15 12 24 7 18
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={4,20,6,15,12,24,7,48};
        quickSort(arr,0, arr.length-1);
        print(arr);
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int partition=partition(arr,low,high);
            quickSort(arr, low,partition-1);
            quickSort(arr, partition+1,high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        int i=low-1;
        int pivot=arr[high];
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    public static void swap(int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }

    public static void print(int[] arr){
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}
