package GetTopK;
public class BFPRT {  
    
    // 得到前k个最小的数  
    public static int[] getMinKNumsByBFPRT(int[] arr, int k) {  
        if (k < 1 || k > arr.length) {  
            return arr;  
        }  
        int minKth = getMinKthByBFPRT(arr, k);  
        int[] res = new int[k];//res前k个结果集  
        int index = 0;  
          
        for (int i = 0; i != arr.length; i++) {  
            if (arr[i] < minKth) {  
                res[index++] = arr[i];  
            }  
        }  
        for (; index != res.length; index++) {  
            res[index] = minKth;  
        }  
        return res;  
    }  
      
      
   //找出比k小的前k个数  
    public static int getMinKthByBFPRT(int[] arr, int K) {  
        int[] copyArr = copyArray(arr);  
        return select(copyArr, 0, copyArr.length - 1, K - 1);  
    }  
      
   //复制数组  
    public static int[] copyArray(int[] arr) {  
        int[] res = new int[arr.length];  
        for (int i = 0; i != res.length; i++) {  
            res[i] = arr[i];  
        }  
        return res;  
    }  
      
      
      //用划分值与k相比，依次递归排序  
    public static int select(int[] arr, int begin, int end, int i) {  
        if (begin == end) { //begin数组的开始 end数组的结尾  i表示要求的第k个数  
            return arr[begin];  
        }  
        int pivot = medianOfMedians(arr, begin, end);//找出划分值（中位数组中的中位数）  
        int[] pivotRange = partition(arr, begin, end, pivot);  
        if (i >= pivotRange[0] && i <= pivotRange[1]) {//小于放左边，=放中间，大于放右边  
            return arr[i];  
        } else if (i < pivotRange[0]) {  
            return select(arr, begin, pivotRange[0] - 1, i);  
        } else {  
            return select(arr, pivotRange[1] + 1, end, i);  
        }  
    }  
      
      
     //找出中位数组中的中位数    
    public static int medianOfMedians(int[] arr, int begin, int end) {  
        int num = end - begin + 1;                
        int offset = num % 5 == 0 ? 0 : 1;       //分组:每组5个数，不满5个单独占一组  
        int[] mArr = new int[num / 5 + offset];  //mArr：中位数组成的数组  
        for (int i = 0; i < mArr.length; i++) {  //计算分开后各数组的开始位置beginI 结束位置endI  
            int beginI = begin + i * 5;  
            int endI = beginI + 4;  
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));//对于最后一组（不满5个数），结束位置要选择end  
        }  
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);  
    }  
      
    //划分过程，类似于快排  
    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {  
        int small = begin - 1;  
        int cur = begin;  
        int big = end + 1;  
        while (cur != big) {  
            if (arr[cur] < pivotValue) {  
                swap(arr, ++small, cur++);  
            } else if (arr[cur] > pivotValue) {  
                swap(arr, cur, --big);  
            } else {  
                cur++;  
            }  
        }  
        int[] range = new int[2];  
        range[0] = small + 1;//比划分值小的范围  
        range[1] = big - 1;  //比划分值大的范围  
          
        return range;  
    }  
      
      
    //计算中位数  
    public static int getMedian(int[] arr, int begin, int end) {  
        insertionSort(arr, begin, end);//将数组中的5个数排序  
        int sum = end + begin;  
        int mid = (sum / 2) + (sum % 2);  
        return arr[mid];  
    }  
      
      
    //数组中5个数排序（插入排序）  
    public static void insertionSort(int[] arr, int begin, int end) {  
        for (int i = begin + 1; i != end + 1; i++) {  
            for (int j = i; j != begin; j--) {  
                if (arr[j - 1] > arr[j]) {  
                    swap(arr, j - 1, j);  
                } else {  
                    break;  
                }  
            }  
        }  
    }  
      
      
    //交换元素顺序  
    public static void swap(int[] arr, int index1, int index2) {  
        int tmp = arr[index1];  
        arr[index1] = arr[index2];  
        arr[index2] = tmp;  
    }  
      
      
    //打印结果  
    public static void printArray(int[] arr) {  
        for (int i = 0; i != arr.length; i++) {  
            System.out.print(arr[i] + " ");  
        }  
        System.out.println();  
    }  

    public static void main(String[] args) {  
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };  
        printArray(getMinKNumsByBFPRT(arr, 5));  

    }  

}  

