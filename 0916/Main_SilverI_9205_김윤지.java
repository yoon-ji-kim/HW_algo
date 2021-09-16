import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_SilverI_9205_김윤지 {

	public static void main(String[] args) throws Exception{
		// 백준 9205 맥주 마시면서 걸어가기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //테이스 케이스
		
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine()); //편의점 수
			
			int[] x = new int[n+2];//상근이집 + 편의점 + 락페스티벌
			int[] y = new int[n+2];
			int max = Integer.MAX_VALUE >>2;
			StringTokenizer st;
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			} //입력 받기
			
			int[][] map = new int[n+2][n+2];
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if(i != j && Math.abs(x[i] -x[j]) + Math.abs(y[i]-y[j]) > 1000){ //거리가 1000이상 일때
						map[i][j] = max;
					}else { //1000이하면 거리 저장
						map[i][j] = Math.abs(x[i] -x[j]) + Math.abs(y[i]-y[j]);						
					}
				}
			}
			
			for (int i = 0; i < n+1; i++) {			//경유
				for (int s = 0; s < n+2; s++) { 	//출발
					for (int e = 0; e < n+2; e++) {	//도착
						if(map[s][e] > map[s][i] + map[i][e]) { //간접비용으로 갱신
							map[s][e] = map[s][i] + map[i][e];
						}
					}
				}	
			}
			
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j]+ " ");
//				}
//				System.out.println();
//			}
			if(map[0][n+1] == max) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
		}
	} //main
}//end class
