package bs;

import java.util.Scanner;

public class Solution_D3_9229_김윤지 {
	static int N, M, sum;
	static int[] a;
	static int numbers[];
	
	public static void main(String[] args) {
		//마트에는 N개의 과자 봉지가 있으면 a그램의 무게를 가진다
		//M그램을 초과하면 못 들고 다닌다. 최대 무게 합을 출력하라. 두!봉!지!
		//N개 중에 2개 뽑는 조합 , 들고 갈 방법이 없는 경우 -1 출력
		Scanner sc= new Scanner(System.in);
		int TC =sc.nextInt(); //테스트 케이스 수
		
		for (int i = 1; i <= TC; i++) {
			N = sc.nextInt(); //과자 봉지 개수 
			M = sc.nextInt(); //최대 무게 합
			numbers = new int[2];
			int[] a = new int[N];
			for (int j = 0; j < N; j++) {
				a[j] = sc.nextInt(); //과자 무게
			}
			combination(a, 2);
			System.out.println("#" + i+" "+ sum);
		}
	}
	
	private static void combination(int[] a, int r) {
		if(r ==0) {
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			if(sum > M) sum = -1;
			return;
		}
		//선택
		
		//선택안했을 때
	}
}

