import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_문제은행_1681_김윤지 {
	static int N, result;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		//정올 1681 해밀턴 순환회로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //배달 장소 수
		map = new int[N][N];
		visited = new boolean[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력
		
		result = Integer.MAX_VALUE;
		
		//회사에서 출발
		visited[0] = true;
		dfs(1,0,0);
		System.out.println(result);
	} //main
	
	private static void dfs(int cnt, int idx, int sum) {
		//모두 배달한 경우
		if(cnt == N) {
			//출발지로 이동할 수 있다면 비용 더하기
			if(map[idx][0] == 0) return;
			result = Math.min(result, sum+map[idx][0]);
		}
		for (int i = 1; i < N; i++) {
			//이동할 수 있고 방문하지 않았다면 방문
			if(map[idx][i] ==0 || visited[i]) continue;
			//최소값 보다 크다면
			if(sum+map[idx][i] > result) continue;
			//방문처리
			visited[i] = true;
			dfs(cnt+1, i, sum+map[idx][i]);
			visited[i] = false;
		}
	}
}//end class
