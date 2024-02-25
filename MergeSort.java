/*
        14,20,7,6,2,35
        itr 1: 14,20,7                  6,2,35
        itr2:  14,20      7             6,2   35
        itr3:  14  20     7             2   6   35
        itr4:  14,20      7             2,6     35
        itr5:  7,14,20                  2,6,35
        itr6:  7,14,20,6,35

     Time Complexity
     FInd the middle  => O(1)
     Divide the array to half => log(n)
     Merge the data  => O(n)
     Total complexity => O(nlogn)

    Best case , average and worst case time complexity and same

    Space Complexity - O(n)

   Algorithm :  Divide and Conquer

 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data=new int[]{14,20,7,6,2,35};
        int[] sorted=mergeSort(data,0, data.length-1);
        for(int i:sorted){
            System.out.print(i+" ");
        }
    }

    public static int[] mergeSort(int[] data,int low, int high){
        if(low==high){
            // Array with one element is always sorted
            int[] result=new int[1];
            result[0]=data[low];
            return result;
        }
       // int mid=(low+high)/2;
        // To avoid integer overflow.
        int mid=low+(high-low)/2;
        int[] fh=mergeSort(data,low,mid);
        int[] sh=mergeSort(data,mid+1,high);
        return mergeTwoSortedArray(fh,sh);
    }

    public static int[] mergeTwoSortedArray(int[] one, int[] two){
        int i=0;
        int j=0;
        int k=0;
        int[] merged=new int[one.length+ two.length];
        while(i<one.length && j< two.length){
            if(one[i]<=two[j]){
                merged[k]=one[i];
                i++;
                k++;
            }
            else{
                merged[k]=two[j];
                j++;
                k++;
            }
        }
        if(i== one.length){
            while(j<two.length){
                merged[k]=two[j];
                j++;
                k++;
            }
        }

        if(j==two.length){
            while(i< one.length){
                merged[k]=one[i];
                i++;
                k++;
            }
        }
        return merged;
    }
}