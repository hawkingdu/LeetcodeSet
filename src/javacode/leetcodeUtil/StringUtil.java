package javacode.leetcodeUtil;

/**
 * @Author duhaojun
 * @Date 2022/6/5
 */
public class StringUtil {
    /**
     * 数字字符串转数字数组
     * @param input 2,-3,4,0
     * @return [2,-3,4,0]
     */
    public static int[] stringToIntegerArray(String input) {

        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
}
