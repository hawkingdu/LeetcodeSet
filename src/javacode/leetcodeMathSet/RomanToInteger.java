package javacode.leetcodeMathSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 13. Roman to Integer
 * Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
 * 
 * 	Input: "III"
	Output: 3
	
	Input: "IX"
	Output: 9
	
	Input: "LVIII"
	Output: 58
	Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 *
 */
public class RomanToInteger {

	public int romanToInt(String s) {
		Map<Character, Integer> romanIntMap = new HashMap<>();
		romanIntMap.put('I', 1   );
		romanIntMap.put('V', 5   );
		romanIntMap.put('X', 10  );
		romanIntMap.put('L', 50  );
		romanIntMap.put('C', 100 );
		romanIntMap.put('D', 500 );
		romanIntMap.put('M', 1000);
		int result = romanIntMap.get(s.charAt(s.length()-1));
		for (int i = s.length()-2; i >=0; i--) {
			Integer num = romanIntMap.get(s.charAt(i));
			if (num< romanIntMap.get(s.charAt(i+1))){
				result -= num;
			} else {
				result += num;
			}
		}
		return result;
    }
	public static void main(String[] args) {
		int[] nums = new int[]{3,3};
		Set<Integer> set = new HashSet<>();
		for(int i=0; i< nums.length; i++){
			if(set.contains(nums[i])){
				System.out.println(true);
				break;
			} else {
				set.add(i);
			}
		}
		System.out.println(false);

	}

}
