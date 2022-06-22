package javacode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author duhaojun
 * @Date 2022/6/10
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1){
            return strs[0];
        }
        Map<String, Integer> cache = new HashMap<>();
        int maxUse = strs.length;
        int maxPre  = 0;
        String maxStr = "";
        for (String str : strs) {
            for (int i = 1; i <= str.length(); i++) {
                String prefix = str.substring(0, i);
                if (cache.get(prefix)!=null) {
                    cache.put(prefix, cache.get(prefix) + 1);
                } else {
                    cache.put(prefix, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : cache.entrySet()) {
            if (entry.getValue()>= maxUse){
                maxUse = entry.getValue();
                if (entry.getKey().length() > maxPre) {
                    maxPre = entry.getKey().length();
                    maxStr = entry.getKey();
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        LongestCommonPrefix14 commonPrefix14 = new LongestCommonPrefix14();
        String[] strs = new String[]{"aa","aa"};
        String s = commonPrefix14.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
