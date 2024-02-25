public class InsertionSort {
    public static void main(String[] args) {
       int[] arr={12, 11, 13, 5, 6};
       sort(arr);
       print(arr);
    }
    private static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    private static void print(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
