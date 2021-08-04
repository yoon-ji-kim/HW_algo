import java.util.Scanner;

public class Solution_D2_2001_김윤지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); //N*N크기의 배열
			int M = sc.nextInt(); //M*M크기의 파리채
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt(); //파리 수 입력 받기
				}
			}
			
			int max = 0;
			
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					int sum = 0;
					for (int k = i; k < i+M; k++) {
						for (int l = j; l < j+M; l++) {
							sum += arr[k][l];
						}
					}
					if(max < sum) {
						max = sum;
					}
				}
			}
			System.out.printf("#%d %d%n",t+1, max);
			
		}
	}

}
