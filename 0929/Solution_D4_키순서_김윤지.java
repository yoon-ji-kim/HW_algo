import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_D4_키순서_김윤지 {
	static int N,M;
	static int[][] map;
	static int tallCnt,shortCnt;
	public static void main(String[] args) throws Exception{
		//swea D4 professional 키순서
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); //학생 수
			M = Integer.parseInt(br.readLine()); //키를 비교한 횟수
			
			map = new int[N+1][N+1];
			
			StringTokenizer st;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				//a 학생이 b학생보다 키가 작다 a->b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			
			int result =0;
			for (int i = 1; i <= N; i++) {
				tallCnt = 0;
				shortCnt =0;
				//자기보다 큰 학생
				tall(i);
				//자기보다 키 작은 학생
				small(i);
				
				//합이 N-1이면 자신의 키가 몇번째인지 알 수 있는 학생 
				if(tallCnt + shortCnt == N-1) result++;
			}
			
			System.out.println("#"+test_case + " "+ result);
		}
	}
	private static void small(int i) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int j = 1; j <= N; j++) {
				//방문하지 않고 , 자신보다 키가 작은 학생
				if(!visited[j] && map[j][cur]== 1) {
					queue.offer(j);
					visited[j] = true;
					shortCnt++;
				}
			}
		}
	}
	private static void tall(int i) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int j = 1; j <= N; j++) {
				//방문하지 않고 , 자신보다 키가 큰 학생
				if(!visited[j] && map[cur][j] ==1) {
					queue.offer(j);
					visited[j] = true;
					tallCnt++;
				}
			}
		}
	}
}
