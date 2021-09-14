package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149 {

	public static void main(String[] args) throws Exception{
		//모든 집을 칠하는 비용의 최소값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][3];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}// 입력 받기
		
		for (int i = 2; i <= N; i++) {
			arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
		}
		
		int[] result = { arr[N][0], arr[N][1], arr[N][2]};
		Arrays.sort(result);
		
		System.out.println(result[0]);
	}//main
}//end class
