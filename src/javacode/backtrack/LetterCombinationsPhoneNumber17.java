package javacode.backtrack;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinationsPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        backtrack(result, new StringBuilder(), 0, digits, map);
        return result;
    }

    /**
     *
     * @param result
     * @param sb
     * @param pos 字符串上的位置
     * @param digits
     * @param map
     */
    public void backtrack(List<String> result, StringBuilder sb, int pos, String digits, Map<Character, List<String>> map){
        //终止条件 字符串长度 等于输入数字长度
        if (sb.length() == digits.length()) {
            if (sb.length()!=0){
                result.add(sb.toString());
            }
            return;
        }
        List<String> list = map.get(digits.charAt(pos)); //当前数字上的字母
        for (String s : list) { //遍历每个数字上的字母
            sb.append(s); // 如2，先打印a
            backtrack(result, sb, pos+1, digits, map); //后推一个数字，继续遍历打印
            sb.deleteCharAt(sb.length() - 1); //删除末尾数字
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber17 number17 = new LetterCombinationsPhoneNumber17();
        List<String> strings = number17.letterCombinations("");
        Arrays.stream(strings.toArray()).forEach(System.out::println);
    }
}
