package javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author duhaojun
 * @Date 2022/6/11
 */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<List<Integer>> list =new ArrayList();
        int j = 0;
        list.add(Arrays.asList(intervals[0][0],intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if ( interval[0] <= list.get(j).get(1) ) {
                list.get(j).set(1, interval[1]);
            } else {
                list.add(++j, Arrays.asList(intervals[i][0],intervals[i][1]));
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] i1 = new int[]{1,4};
        int[] i2 = new int[]{4,6};
        int[] i3 = new int[]{8,11};
        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();

        int[][] intervals = new int[][]{i1, i2,i3};
        int[][] merge = mergeIntervals56.merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println("");
        }
    }
}
