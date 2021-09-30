import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의SW역량테스트_1949_김윤지 {
	static class Node {
		int x,y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][] visited;
	static int N, K, map[][];
	static int high,ans;
					//상, 하, 좌, 우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		//swea 1949 등산로 조성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			high = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(high < map[i][j]) {
						high = map[i][j];
					}
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == high) {
						dfs(i,j, 1, false);
					}
				}
			}
			
			System.out.println("#"+ test_case+" "+ans);
		}//tc
	}//main
	
	private static void dfs(int i, int j,int cnt, boolean u) {
		if(ans < cnt) ans = cnt;
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			//경계검사
			if(nr<0 || nc< 0 || nr>= N || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			//현재 보다 작은 경우 탐색 가능, 길이 +1
			if(map[nr][nc] < map[i][j]) {
				dfs(nr,nc, cnt+1, u);
			}else {
				//봉우리를 깎지 않았고 깎은 높이가 현재 높이보다 작으면 가능 
				if(!u) {
					if(map[nr][nc] -K < map[i][j]) {
						int tmp = map[nr][nc];
						map[nr][nc] = map[i][j] -1;
						dfs(nr, nc, cnt+1,true);
						map[nr][nc] = tmp;
					}
				}
			}
		}
		visited[i][j] = false;
	}
	
}//end class
