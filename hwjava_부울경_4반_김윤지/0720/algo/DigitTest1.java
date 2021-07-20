package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int number;
		int[] arr= new int[10];

		while(true) {
			number = sc.nextInt();
			if(number ==0) {
				break;
			}
			arr[number/10]++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				System.out.printf("%d: %d개 \n", i, arr[i]);
			}
		}
		sc.close();
	}

}
