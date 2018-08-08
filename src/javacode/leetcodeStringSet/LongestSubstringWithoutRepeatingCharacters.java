package javacode.leetcodeStringSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		StringBuilder sb = new StringBuilder();
		String s = "bbbb";
		int len = ls.lengthOfLongestSubstring(s);
		System.out.println(len);
//		sb.append("b");
//		sb = new StringBuilder(sb.substring(1));
//		System.out.println(sb.toString());
	}

}
