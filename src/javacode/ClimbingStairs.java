package javacode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 链接：https://leetcode.cn/problems/climbing-stairs
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return climbStairsRecursive(n, cache);
    }

    /**
     * 动态规划 + 递归解法
     * f(x) = f(x-1) + f(x-2)
     * 以3级台阶为例，3级分第一步跨1级 和 第一步跨2级 两种情况 如果第一步跨1级，其实就是剩下的就是f(2),如果第一步跨2级，其实就是剩下的就是f(1)
     * 以4级台阶为例，4级分第一步跨1级 和 第一步跨2级 两种情况，如果第一步跨1级，其实就是剩下的就是f(3),如果第一步跨2级，其实就是剩下的就是f(2)
     * 递归终止条件，剩一阶返回1，剩二阶返回2
     */
    public int climbStairsRecursive(int n, Map<Integer, Integer> cache) {
        if (cache.get(n)!=null) {
            return cache.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1 = climbStairsRecursive(n - 1, cache);
        cache.put(n - 1, n1);
        int n2 = climbStairsRecursive(n - 2, cache);
        cache.put(n - 2, n2);
        return  n1 + n2;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(4));
    }
}
