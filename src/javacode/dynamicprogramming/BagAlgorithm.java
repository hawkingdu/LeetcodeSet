package javacode.dynamicprogramming;

public class BagAlgorithm {

	public static void main(String[] args) {
		int[] values = new int[]{50,30,40,10};
		int[] weight = new int[]{3,6,4,5};
		int capacity = 10;
		zeroOneBag(weight, values, capacity);
	}
	
	public static void zeroOneBag(int[] weight, int[] values, int capacity){
		int nums = weight.length;
		int[][] f = new int[nums][capacity+1];
		for(int i=0; i < nums; i++){
			for(int j=1; j<=capacity; j++){
				if(i==0){
					if(j>=weight[0])f[i][j]=values[0];
				} else if(j < weight[i]){
					f[i][j] = f[i-1][j];
				} else{
					if(f[i-1][j]<= f[i-1][j-weight[i]]+values[i]){
						f[i][j]  = f[i-1][j-weight[i]]+values[i];
					} else {
						f[i][j] = f[i-1][j];
					}
				}
			}
		}
		int j=capacity;
		for(int i=nums-1; i>=0; i--){
			if(i==0){
				if(f[i][j] != f[i+1][j]){
					weight[i] = 0;
				}
			} else if(f[i][j] == f[i-1][j]){
				weight[i] = 0;
			} else {
				j=j-weight[i];
			}
		}
				
		System.out.println(f[nums-1][capacity]);
//		for(int i=0; i < nums; i++){
//			for(int j=0; j<f[i].length;j++){
//				System.out.print(f[i][j]);
//			}
//			System.out.println("");
//		}
		
		for(int i=0; i<weight.length; i++){
			System.out.print(weight[i]+",");
		}
	}

}
