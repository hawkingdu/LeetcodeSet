package javacode;

/**
 * @Author duhaojun
 * @Date 2022/6/20
 */
public class TrappingRainWater42 {
    /**
     * 暴力遍历：以列为单位
     * 从height[1]开始遍历算出每一列的储水量
     * 每一列的储水量：
     * 1. 先找出左右两边最高的两列 leftMax, rightMax
     * 2. 取其中矮的那一列 min(leftMax, rightMax)
     * 3. 矮的那一列 - 当前列高度 min(leftMax, rightMax) - height[i]
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int totalCapacity = 0;
        // 从第二列开始遍历，以每一列为单位，求每一列的储水量
        for (int i = 1, leftMax = 0, rightMax = 0; i < height.length-1; i++) {
            for (int j = i; j >= 0; j--) {
                // 找出左边最高的一列
                leftMax = Math.max(height[j], leftMax);
            }
            for (int j = i; j < height.length; j++) {
                // 找出右边最高的一列
                rightMax = Math.max(height[j], rightMax);
            }
            // 当前列储水量 = 左右两边矮的那一列 - 当前高度
            int currentCapacity = Math.min(leftMax, rightMax) - height[i];
            System.out.println(currentCapacity);
            // 总储水量 = 每一列相加
            totalCapacity += currentCapacity;
        }
        return totalCapacity;
    }

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int totalCapacity = 0;

        // 定义每一列的两边最高值
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        leftMaxArr[0] = height[0];
        rightMaxArr[height.length - 1] = height[height.length - 1];
        /**
         * 从左到右遍历，取最大，得出每一列的左边最大值
         * 需注意，当前列的值如果比左边或右边的最大值大，那么最大值就是当前列
         */
        for (int i = 1; i < height.length; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i-1]);
        }
        // 从右到左变量，取最大，得出每一列的右边最大值
        for (int i = height.length-2; i >=0; i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i+1]);
        }

        // 从第二列开始遍历，以每一列为单位，求每一列的储水量
        for (int i = 1; i < height.length-1; i++) {
            // 当前列储水量 = 左右两边矮的那一列 - 当前高度
            int currentCapacity = Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
            // 打印每一列的储水量
            System.out.println(currentCapacity);
            // 总储水量 = 每一列相加
            totalCapacity += currentCapacity;
        }
        return totalCapacity;
    }

    public static void main(String[] args) {
        TrappingRainWater42 water42 = new TrappingRainWater42();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println( water42.trap2(height));

    }
}
