package javacode.sortalgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author duhaojun
 * @Date 2022/6/10
 */
public class KthLargestElementinArray215 {
    /**
     * 暴力法
     * 1. 排序
     * 2. 倒数第 k 个数
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * 优先队列-堆排法
     * 维护一个 k 个元素的最小堆结构
     * 堆顶 就刚好是满足条件的结果
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestWithHeap(int[] nums, int k) {
        // 定义一个 k 大小的堆，正序排列
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(Integer::intValue));
        // 初始化 k 个元素
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            /**
             * 和堆顶比较，如果大于堆顶，进入堆结构
             */
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        // 直接返回堆顶
        return heap.poll();
    }

    public static void main(String[] args) {
        KthLargestElementinArray215 array215 = new KthLargestElementinArray215();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(array215.findKthLargestWithHeap(nums, 2));
    }
}
