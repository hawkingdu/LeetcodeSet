package javacode.leetcodeStringSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string only contains digits "2-9", return all possible letter combinations that have digit and alpha map similar to mobile key
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsofPhoneNumber {
    private static Map<Character, List<Character>> map = new HashMap<>();
    static{
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
    private static List<Character> numToAlpha(char c){
        return map.get(c);
    }
    public List<String> letterCombinations(String digits) {



        return null;
    }

    public void dfs(List<String> result, String e, String digits, Map<Character, List<Character>> map){
        if( !result.contains(e) ){
            result.add(e);
        } else {

            for( int i=0; i < digits.length(); i++){

            }
        }
    }


    public static void main(String[] args) {

    }
}
