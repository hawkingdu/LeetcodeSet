package javacode.dfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author duhaojun
 * @Date 2022/6/22
 */
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        int sum1 = 0;
        for (int num : nums) {
            sum1 += num;
        }

        return backtrack(new ArrayDeque<>(), sum1, 0, 0, nums);
    }

    public boolean backtrack( ArrayDeque<Integer> part2, int sum1, int sum2, int pos, int[] nums) {
        if (sum1 == sum2) {
            return true;
        } else {
            for (int i = pos; i < nums.length; i++) {
                Integer num = nums[i];
                part2.addLast(num);
                if ((sum1 - num)>=(sum2 + num)){
                    if (backtrack(part2, sum1 - num, sum2 + num, i+1, nums)) {
                        return true;
                    } else {
                        part2.removeLast();
                    }
                } else {
                    break;
                }

            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{14,9,8,4,3,2};
        PartitionEqualSubsetSum416 subsetSum416 = new PartitionEqualSubsetSum416();
        System.out.println(subsetSum416.canPartition(nums));

    }
}
