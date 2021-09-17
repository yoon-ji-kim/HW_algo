import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWTest샘플문제_1767_김윤지 {
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
					//상, 하, 좌, 우
	static int N, size, min;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static List<Pos> list;
	public static void main(String[] args) throws Exception{
		// swea 1767 프로세서 연결하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 받기
			
			size =0;
			min = Integer.MAX_VALUE;
			list = new ArrayList<>();
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if(map[i][j] == 1) list.add(new Pos(i,j));
				}
			}
			
			comb(0, 0, 0);
			
			System.out.println("#"+tc+" " +min);
		}
	}
	private static void comb(int idx, int coreCnt, int minlen) {
		if(idx == list.size()) { 
			if(size <coreCnt) {
				size = coreCnt;
				min = minlen;
			}else if(size == coreCnt) {
				if(min >minlen) {
					min = minlen;
				}
			}
			return;
		}
		
		int x = list.get(idx).r;
		int y = list.get(idx).c;
		for (int i = 0; i < 4; i++) {
			int nr = x;
			int nc = y;
			int count =0;
			int row =x, col =y;
			
			while(true) {
				nr += dr[i];
				nc += dc[i];
				//경계 값 밖이면 break
				if(nr<0 || nr >= N || nc <0 || nc >= N) break;
				if(map[nr][nc] ==1 ) { //core를 만나면 break
					count = 0;
					break;
				}
				count++;
			}
			
			//전선 깔기
			for (int j = 0; j < count; j++) {
				row += dr[i];
				col += dc[i];
				map[row][col] = 1;
			}
			if(count ==0) {
				comb(idx+1, coreCnt, minlen);
			}else {
				comb(idx+1, coreCnt+1, minlen+count);
				
				//초기 상태로 되돌림
				row = x;
				col = y;
				for (int j = 0; j < count; j++) {
					row += dr[i];
					col += dc[i];
					map[row][col] =0;
				}
			}
			
		}
	}

}
