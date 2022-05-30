package javacode.leetcodeStringSet;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
	Examples:
	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int so_far_len = 0;
		StringBuilder sb = new StringBuilder();
		// 筛选用，降低时间复杂度
		Set<Character> set = new HashSet<>();
		for(int i=0; i<s.length(); i++){
			if( sb.indexOf(String.valueOf(s.charAt(i))) >=0 ){
				sb = new StringBuilder(sb.substring(sb.indexOf(String.valueOf(s.charAt(i)))+1));
				sb.append(s.charAt(i));
			} else {
				sb.append(s.charAt(i));
			}
			System.out.println(sb.toString());
			so_far_len = Math.max(so_far_len, sb.length());
		}
		return so_far_len;
    }

	/**
	 * 滑动窗口，双指针法
	 * @param s
	 * @return
	 */
	public int solution(String s){
		int maxLength = 0;
		// 记录上一次数组坐标
		Map<Character, Integer> charPos = new HashMap<>();
		// 左右边界
		int left = -1, right = 0;
		int size = s.length();
		for (; right < size; right++) {
			char c = s.charAt(right);
			if (charPos.containsKey(c)) {
				left = Math.max(charPos.get(c), left);//移动左边界
			}
			charPos.put(c, right); //记录坐标
			maxLength = Math.max(maxLength, right - left);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		StringBuilder sb = new StringBuilder();
		String s = "abba";
		int len = ls.solution(s);
		System.out.println(len);
//		sb.append("b");
//		sb = new StringBuilder(sb.substring(1));
//		System.out.println(sb.toString());
	}

}
