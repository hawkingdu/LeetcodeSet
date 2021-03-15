package javacode.sortalgorithm;

import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 杜皓君 created by 2021/3/15
 * BubbleSort
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] input = new int[]{6,5,5,5,5,5,7,8,8,4,4,-1,2,1,3};
        bubbleSort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] input){
        for (int i = 0; i < input.length-1; i++) {
            for (int j = 0; j < input.length-1-i; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1]=temp;
                }
            }
        }
    }
}
