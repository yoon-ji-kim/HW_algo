import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_1953_김윤지 {
	static int N,M,L;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
					//상, 우, 하, 좌
	static int[] dc = {-1,0,1,0};
	static int[] dr = {0,1, 0,-1};
	static int[][] type = {
			{0, 0, 0, 0},  //0
			{1, 1, 1, 1},  //1: 상,하,좌,우
			{1, 0, 1, 0},  //2: 상,하
			{0, 1, 0, 1},  //3: 좌,우
			{1, 1, 0, 0},  //4: 상,우
			{0, 1, 1, 0},  //5: 하,우
			{0, 0, 1, 1},  //6: 하,좌
			{1, 0, 0 ,1},  //7: 상,좌
	};
	
	public static void main(String[] args) throws Exception{
		//swea 1953 탈주범 검거
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //터널 세로 길이
			M = Integer.parseInt(st.nextToken()); //터널 가로 길이
			int C = Integer.parseInt(st.nextToken()); //맨홀 세로 위치
			int R = Integer.parseInt(st.nextToken()); //맨홀 가로 위치
			L = Integer.parseInt(st.nextToken()); //탈출 후 소요된 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력받기
			
			ans =1; //탈출 L 시간 뒤 도달할 수 있는 지점 개수
			bfs(C,R);
			
			System.out.println("#"+ test_case + " " + ans);
		}//test case
	}//main

	private static void bfs(int c, int r) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {c,r});
		visited[c][r] = true;
		
		int hour = 1;
		while(!queue.isEmpty()) {
			if(hour == L) break; //L시간이 되면 종료
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				int y = cur[0];
				int x = cur[1];
				
				int[] dir = type[map[y][x]];
				for (int d = 0; d < 4; d++) {
					if(dir[d] == 0 )continue;
					int nc = y +dc[d];
					int nr = x +dr[d];
					//경계검사
					if(nc< 0 || nr < 0 || nc>= N || nr >= M) continue;
					//터널이 없거나 , 방문했으면 통과
					if(map[nc][nr] == 0 || visited[nc][nr]) continue;
					//다음 칸에 터널이 있다면 탐색
					if(type[map[nc][nr]][(d+2) %4] ==1) {
						visited[nc][nr] = true;
						queue.offer(new int[] {nc, nr});
						ans++;
					}
				}
			}
			hour++; //시간 추가
		}		
	}
}//end class
