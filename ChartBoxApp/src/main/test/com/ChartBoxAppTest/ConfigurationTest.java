package com.ChartBoxAppTest;

import java.util.Arrays;

public class ConfigurationTest {

	public static void main(String[] args) {
		
		int[] arr = new int[] {6,5,4,2,3};
		int remove = 5;
		int[] tempArr = new int[arr.length-1];
		
	    for (int i = 0; i < arr.length; i++) {
	    	if(arr[i]==remove){
	    		 for (int j = i; j < arr.length-1; j++) {
	    			arr[j]= arr[j+1];
				}
	    		for (int j = 0; j < arr.length-1; j++) {
					tempArr[j]=arr[j];
				}
	    		break;
	        }
	    }
	    arr = tempArr;
	for (int i = 0;  i< arr.length; i++) {
		System.out.print(", "+arr[i]);
	}
	}
}
