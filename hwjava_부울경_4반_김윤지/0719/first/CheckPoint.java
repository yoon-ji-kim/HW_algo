package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// 키와 몸무게를 자연수로 입력받아 첫 번째 줄에 비만수치 출력, 0보다 크면 다음줄에 비만 출력
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int weight = sc.nextInt();
		
		int rate = weight+100-height;
		
		System.out.println("비만수치는 "+rate+"입니다.");
		if(rate>0) {
			System.out.println("당신은 비만이군요");	
		}
		sc.close();
		}

}
