package javacode.leetcodeStringSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string only contains digits "2-9", return all possible letter combinations that have digit and alpha map similar to mobile key
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofPhoneNumber {
    private static String[] maps = {"", "", "abc", "def", "ghj", "jkl", "mno", "pqrs", "tuv", "wxyz"};
   

    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<>();
    	if(digits!=null && digits.length()>0){
    		dfs(result, "", digits, 0, maps);
    	}
        return result;
    }

    public void dfs(List<String> result, String subStr, String digits, int index, String[] maps){
    	if( index == digits.length() ){
            result.add(subStr);
            return;
        } else {
            for( char c : maps[digits.charAt(index)-'0'].toCharArray()){
            	subStr += String.valueOf(c);
            	dfs(result, subStr, digits, index+1, maps);
            	subStr = subStr.substring(0, subStr.length()-1);
            }
        }
    }


    public static void main(String[] args) {
    	LetterCombinationsofPhoneNumber combin = new LetterCombinationsofPhoneNumber();
    	List<String> result = combin.letterCombinations("23");
    	System.out.println(result);
    }
}
