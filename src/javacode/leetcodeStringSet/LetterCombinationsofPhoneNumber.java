package javacode.leetcodeStringSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    		dfs(result, "", digits, 0);
    	}
        return result;
    }

    public void dfs(List<String> result, String subStr, String digits, int index){
    	if( index == digits.length() ){
            result.add(subStr);
            return;
        } else {
            for( char c : maps[digits.charAt(index)-'0'].toCharArray()){
            	dfs(result, subStr+c, digits, index+1);
            }
        }
    }

    /**
     * This approach is based on BFS algorithm
     * For example as input "23"
     * Initial round queue: ""
     * first round queue: "a" "b" "c"
     * second round queue: ad, ae, af, bd, be, bf, cd, ce, cf
     * @param digits
     * @return
     */
    public List<String> letterCombinationsWithBFS(String digits){
        LinkedList<String> queue = new LinkedList<>();
        if(digits==null || digits.length()==0) return queue;
        queue.add("");
        for(int i=0; i<digits.length(); i++){
            int n = Character.getNumericValue(digits.charAt(i));
            String subStr = maps[n];
            while (queue.peek().length()==i){
                String last = queue.poll();
                for(char c: subStr.toCharArray()){
                    queue.add(last+c);
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
    	LetterCombinationsofPhoneNumber combin = new LetterCombinationsofPhoneNumber();
    	List<String> result = combin.letterCombinationsWithBFS("23");
    	System.out.println(result);
    }
}
