package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count =0; //도형에 출력할 숫자 변수
		
		//
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(j<i) {
					System.out.printf("%3s", " ");
				} else {
					System.out.printf("%3d", ++count);
				}
			}
			System.out.println();
		}
		
	}

}
