
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_GoldIV_1987_김윤지 {
	static int R,C ;
	static int result =1;
	static char[][] map;
					//상,하,좌,우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[] visited =new boolean[26]; //알파벳
	public static void main(String[] args) throws Exception{
		//세로 R칸, 가로 C칸으로 
		// 각 칸에는 대문자 알파벳 하나씩 적혀있고, 좌측 상단 칸(1행1열)에 말이 놓여있다
		//상,하,좌,우 이동  이동칸 알파벳은 지나온 알파벳과는 달라야한다.
		//좌측상단에서 시작해서, 최대 몇 칸 지날 수 있는 지 구하는 프로그램
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);				
			}
		}
		result =1;
		dfs(0,0, result);
		System.out.println(result);
	}
	private static void dfs(int r,int c, int cnt) {
		if(result <cnt) {
			result = cnt;
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				int nr = r +dr[i];
				int nc = c +dc[i];
				
				if(nr >= 0 && nr<R && nc>=0 && nc<C && !visited[map[nr][nc]]) {
					visited[map[nr][nc]] =true;
					dfs(nr, nc,cnt+1);
					visited[map[nr][nc]] = false;
				}
			}
		}
	}


}
