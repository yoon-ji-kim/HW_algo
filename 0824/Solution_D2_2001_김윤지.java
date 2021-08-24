import java.util.Scanner;

public class Solution_D2_2001_김윤지 {

	public static void main(String[] args) {
		//swea_ 2001 파리퇴치
		//M * M크기의 파리채로 최대로 잡을 수 있는 파리 수
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N =sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int max =0;
			for (int i = 0; i < N-M +1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += map[i+k][j+l];
						}
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#"+tc+" "+ max);
		}
	}

}
