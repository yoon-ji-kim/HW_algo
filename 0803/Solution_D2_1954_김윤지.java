import java.util.Scanner;

public class Solution_D2_1954_김윤지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스
		// 우, 하 , 좌, 상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		for (int i = 1; i <= T; i++) { //테스트케이스만큼 반복
			int N = sc.nextInt(); // N*N 배열크기
			int[][] arr = new int[N][N];
			
			if(N==1) { //런타임 에러
				System.out.printf("#%d %n", i);
				System.out.println(1);
				continue;
			}
			
			int x = 0; 
			int y = 0; //현재 좌표
			int d =0;
			for(int j = 1; j <= N*N; j++) {
				
				arr[x][y] =j;
				x += dr[d]; 
				y += dc[d]; 
	
				if( x<0 || x>=N || y<0 || y >= N) { //범위에서 벗어남
					//위치를 다시 옮기고 방향을 돌림
					x -= dr[d];  
					y -= dc[d];
					d = (d+1) %4; //0, 1, 2, 3
					x += dr[d];
					y += dc[d];
				}
				
				if(arr[x][y]!=0) { //숫자가 있음
					x -= dr[d];  
					y -= dc[d];
					d = (d+1) %4;
					x += dr[d];
					y += dc[d];
				}
			}
			System.out.println("#" + i);
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();
			}
		}
	}
}
