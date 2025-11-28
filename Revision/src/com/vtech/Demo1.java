package com.vtech;

public class Demo1 {

	public static void main(String[] vtech) {
		String[] arr1 = new String[5];
		String[] arr2 = new String[]{"A", "B", "C"};
		String[] arr3 = {"A", "B", "C"};
		
		System.out.println(arr1[0]);
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.println("arr1 - "+i +" - "+arr1[i]);
		}
		// arr2[2] = 5; //Type mismatch: cannot convert from int to String
		for(int i = 0; i < arr2.length; i++) {
			System.out.println("arr2 - "+i +" - "+arr2[i]);
		}
		for(int i = 0; i < arr3.length; i++) {
			System.out.println("arr3 - "+i +" - "+arr3[i]);
		}
		
		//Input Array of size from user and Print Sum
		
	}
}
