package javacode.twoPoints;

import java.util.HashMap;

/**
 * @Author duhaojun
 * @Date 2022/6/16
 */
public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int max =0, left = 0, right = height.length-1;
        if(height==null || height.length==0 || height.length==1){
            return 0;
        }
        while (left < right) {
            max = Math.max(max, (right-left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 mostWater11 = new ContainerWithMostWater11();
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = mostWater11.maxArea(nums);
        System.out.println(i);

    }
}
