package javacode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 链接：https://leetcode.cn/problems/generate-parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(),0, 0, n);
        return result;
    }

    /**
     * 回溯方法
     * 如果左括号数量不大于 n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号
     * 字符串长度 等于 n*2, 满足条件，终止
     * @param result 结果集
     * @param left  左括号数量
     * @param right 右括号数量
     * @param n 括号对数
     */
    public void backtrack(List<String> result, StringBuilder sb,int left, int right, int n){
        // 终止条件
        if (sb.length()== n*2){ //字符串长度 等于 括号对数*2 时满足条件加入结果集，终止深入
            result.add(sb.toString());
            return;
        }
        if (left < n) { // 左括号的个数 小于 入参
            sb.append("(");
            backtrack(result, sb, left+1, right, n);
            sb.deleteCharAt(sb.length() - 1); // 回溯完成，删除末尾括号
        }
        if (left > right) { // 右边括号数量 小于 左边，就可以继续添加
            sb.append(")");
            backtrack(result, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1); // 回溯完成，删除末尾括号
        }
    }

}
