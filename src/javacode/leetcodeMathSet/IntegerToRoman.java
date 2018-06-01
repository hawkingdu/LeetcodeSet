package javacode.leetcodeMathSet;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. Integer to Roman
 *
 *Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	
	Input: 1994
	Output: "MCMXCIV"
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {
	
    public String intToRoman(int num) {
    	Map<Integer, String> valueMap = new HashMap<>();
    	valueMap.put( 1   ,"I");
    	valueMap.put( 5   ,"V");
    	valueMap.put( 10  ,"X");
    	valueMap.put( 50  ,"L");
    	valueMap.put( 100 ,"C");
    	valueMap.put( 500 ,"D");
    	valueMap.put( 1000,"M");
    	StringBuilder sb = new StringBuilder();
    	int d;
    	for(int unit=1000; unit>=1;unit=unit/10){
    		String v;
    		d = num/unit;
    		if(d%5 == 4){
    			if(d<5){
    				v= valueMap.get(unit)+valueMap.get(unit*5);
    			} else{
    				v= valueMap.get(unit)+valueMap.get(unit*10);
    			}
    		} else {
    			if(d<4){
    				v= multiString(valueMap.get(unit), d);
    			} else if (d>5 && d<=8){
    				v= valueMap.get(unit*5) + multiString(valueMap.get(unit), d-5);
    			} else {
    				v= valueMap.get(unit*5);
    			}
    		}
    		num = num % unit;
    		sb = sb.append(v);
    	}
    	
    	return sb.toString();
    }
    public String multiString(String s, int factor){
    	String temp = s;
    	s = "";
    	while(factor-->0){
    		s = s+temp;
    	}
    	return s;
    }
	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(1649));
	
	}

}
