package javacode.sortalgorithm;

/**
 * 杜皓君 created by 2021/3/15
 * QuickSort
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] input = new int[]{3,1,2,6,5,-2,0,-1,4,1,4};
        quickSort2(input, 0, input.length-1);
        for (int i : input) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int lo = start;
        int hi = end;
        boolean desc = true;
        while (lo < hi) {
            if (desc) { //从右往左遍历，寻找 游标hi 小于游标lo的值
                if (input[hi] > input[lo]) {
                    hi--;
                } else { //遍历到input[hi] <= input[lo]，便交换数据
                    int t = input[hi];
                    input[hi]=input[lo];
                    input[lo]=t;
                    desc =false;
                }
            }else {//从左往右遍历，寻找 游标lo 大于 游标hi 的值
                if(input[hi]>=input[lo]){
                    lo++;
                } else {
                    int t = input[hi];
                    input[hi]=input[lo];
                    input[lo]=t;
                    desc = true;
                }
            }
        }
        quickSort(input, start, lo-1);
        quickSort(input, hi+1, end);
    }

    private static void quickSort2(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int lo = start;
        int hi = end;
        int base = input[lo];
        while (lo < hi) {
            while (lo < hi && input[hi] >= base){
                hi--;
            }
            input[lo] = input[hi];
            while (lo < hi && input[lo] <= base) {
                lo++;
            }
            input[hi] = input[lo];
        }
        input[lo] = base;
        quickSort2(input, start, lo-1);
        quickSort2(input, hi+1, end);
    }
}
