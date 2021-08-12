
import java.util.Scanner;

public class Solution_D3_1217_김윤지 {
	static int N;
	static int M;
	public static void main(String[] args) {
		//재귀 호출을 이용하여 N의 M 거듭제곱 값을 구하는 프로그램
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int i = 1; i <= T; i++) {
			int casenum = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			int result = recursion(N,M);
			System.out.printf("#%d %d%n",i,result);
		}
		
	}

	public static int recursion(int N,int M) {
		if (M==1) return N;
		return  N * recursion(N, M-1);
	}

}
