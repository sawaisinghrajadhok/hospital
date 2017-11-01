package com.sawai.medical.util;

public class AddTwoNumberAsDate {
	
	public static int[] perform(int[] first, int[] second) {
		int days = (first[2] + second [2]) % 30;
		int months = ((first[2] + first [2]) / 30) + first[1] + second[1];
		int years = ((first[1] + second[1]) / 12) + first[0] + second[0];
		return new int[]{years, months, days};
	}
	
	public static void main(String[] args) {
		int arr[] = perform(new int[]{3,2,25}, new int[]{1, 2, 20});
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
	