import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SilverIII_16926_김윤지 {
	private static int[][] map;
	private static int N,M,R, count;
	//						     좌,하,우,상
	private static int[] dr = {0,1,0,-1};
	private static int[] dc = {-1,0,1,0};
	
	public static void main(String[] args) throws Exception {
		// Baekjoon_16926 배열돌리기1
		//크기가 N*M인 배열이 있을 때 배열을 반시계방향으로 돌려 R이 주어졌을 때 배열을 R번 회전시킨 결과 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); //행
		M = Integer.parseInt(st.nextToken()); //열
		R = Integer.parseInt(st.nextToken()); //회전 수
		
		map = new int[N][M]; //N*M 크기 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //map 입력받기
			}
		}
		
		count = Math.min(N, M)/2; //몇 번 나눠졌는지
		for (int i = 0; i < R; i++) { //R번 회전
			rotate();			
		}
		
		for (int i = 0; i < N; i++) {  //출력
			for (int j = 0; j < M; j++) {
				System.out.printf(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void rotate() {
			for (int i = 0; i<count; i++) {  //나눠진 만큼 반복
				int r =i; //0,0 / 1,1 /2,2
				int c =i;
				
				int arr = map[r][c]; 
				int dir =0;  //회전 방향
				while(dir<4) {
					int nr = r+ dr[dir]; 
					int nc = c+ dc[dir];
					
					if(nr>=i && nr<N-i && nc>=i && nc<M-i)  { //경계 내에 있으면
						map[r][c] = map[nr][nc]; 
						r =nr;
						c =nc;
					} else { //경계 밖이면 
						dir++; //방향 바꾸기
					}
				}
				map[i+1][i] = arr;  
			}
	}
}
