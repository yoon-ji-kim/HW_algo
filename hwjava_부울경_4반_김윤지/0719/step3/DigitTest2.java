package com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5; //출력할 줄 수
		int target = n/2; //중간줄 이전, 모양이 반전되는 목표 개수를 위한 변수
		int blank =0; 	//공백 출력을 위한 count 변수
		boolean isIncrease = true; //공백 증가 여부를 위한 변수
		int no = 1; //출력할 숫자
		
		while(no<=17) {
			for (int i = 0; i < blank; i++) {	//숫자 앞쪽 공백 출력 부분
				System.out.printf("%3s", " ");
			}
			for (int i = 0; i < n-2 * blank; i++) {	//숫자 출력 부분
				System.out.printf("%3d", no++);
			}
			System.out.println();
			if(isIncrease) {
				blank++;
			} else {
				blank--;
			}
			if(blank == target) {
				isIncrease=false;
			}
		}
	}

}
