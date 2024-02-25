public class HeapSort {
    public static void main(String[] args) {
        int[] arr={15,11,14,5,6,12,13};
        heapSort(arr);
        print(arr);
    }

    private static void heapSort(int[] arr){
        int len=arr.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(arr,len,i);
        }

        for(int i=len-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }

    private static void heapify(int[] arr,int len,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(i<len && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<len && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,len,i);
        }
    }

    private static void swap(int[] arr,int data1,int data2){
        int temp=arr[data1];
        arr[data1]=arr[data2];
        arr[data2]=temp;
    }

    private static void print(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
