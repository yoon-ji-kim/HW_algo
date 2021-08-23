import java.util.Scanner;

public class Solution_D3_1209_김윤지 {

	public static void main(String[] args) {
		//swea_1209_sw문제해결기본_sum
		//2차원 배열이 주어질때, 각 행의 합, 열의 합, 대각선의 합중 최대값을 구하는 프로그램
		//배열의 크기 100*100 
		Scanner sc= new Scanner(System.in);
		int[][] map = new int[100][100];
		int max =0;
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				int hap =0;
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					hap += map[i][j];
				}
				max = Math.max(max, hap); //행의 최대값
			}
			
			for (int i = 0; i < 100; i++) { 
				int hap =0;
				for (int j = 0; j < 100; j++) {
					hap +=map[j][i];
				}
				max = Math.max(max, hap); //열의 최대값
			}
			int hap =0;
			for (int i = 0; i < 100; i++) {
				hap+= map[i][i];
			}
			max = Math.max(max, hap); //왼쪽 대각선 최대값
			
			hap =0;
			for (int i = 0; i < 100; i++) {
				int j = 99;
				hap += map[i][j];
				j--;
			}
			max = Math.max(max, hap); //오른쪽 대각선 최대값
			
			System.out.printf("#"+ tc+" "+max+"%n");
		}
	}

}
