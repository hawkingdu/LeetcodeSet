package javacode.leetcodeStringSet;

import java.util.HashMap;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * @Date 2022/5/31
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        HashMap<String, Boolean> cache = new HashMap<>();
        Boolean bool = null;
        String palindromic =String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i,j+1);
                bool = cache.get(subString);
                if (bool == null) {
                    cache.put(subString, isPalindomic(subString));
                    bool = cache.get(subString);
                }
                if (bool) {
                    if (subString.length() > palindromic.length()) {
                        palindromic = subString;
                    }
                }
            }
        }

        return palindromic;
    }

    public boolean isPalindomic(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "abbcac";
        System.out.printf( solution.longestPalindrome(s));
    }
}
