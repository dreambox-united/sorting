public class CountingSort {
    public static void main(String[] args) {
        int[] data = {4,2,2,8,3,3,1};
        sort(data,data.length);
    }

    private static void sort(int[] arr,int len){
        int[] result=new int[len+1];
        int max=findMaxElement(arr,len);
        int[] countArr=new int[max+1];
        int countArrLen=countArr.length;
        initializeCountArr(countArr,countArrLen);
        computeCount(arr,countArr,len);
        computeCumulativeSum(countArr,countArrLen);
        for(int i=len-1;i>=0;i--){
            int pos=countArr[arr[i]];
            result[pos-1]=arr[i];
            countArr[arr[i]]--;
        }
        for(int i=0;i<len;i++){
            arr[i]=result[i];
        }
        print(arr,len);
    }

    /**
     * Find the maximum element in the given array
     * @param arr
     * @param len
     * @return
     */
    private static int findMaxElement(int[] arr,int len){
        int max=arr[0];
        for(int i=1;i<len;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    /**
     * Initialize count array with zeros
     * @param countArr
     * @param len
     */
    private static void initializeCountArr(int[] countArr,int len){
        for(int i=1;i< len;i++){
            countArr[i]=0;
        }
    }


    /**
     * Compute the count of each element in the original array and store it in the corresponding index in the count array.
     * @param arr
     * @param countArr
     * @param len
     */
    private static void computeCount(int[] arr,int[] countArr,int len){
        for(int i=0;i< len;i++){
            countArr[arr[i]]+=1;
        }
    }

    /**
     * calculate at cumulative sum at each index position
     * @param countArr
     * @param len
     */
    private static void computeCumulativeSum(int[] countArr,int len){
        for(int i=1;i<len;i++){
            countArr[i]+=countArr[i-1];
        }
    }

    /**
     * Print the array
     * @param arr
     * @param len
     */
    private static void print(int[] arr,int len){
        for(int i=0;i< len;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
