import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문제은행_2577_김윤지 {
	private static int N,d,k,c, arr[], visited[];
	public static void main(String[] args) throws Exception{
		//정올 2577 회전 초밥
		//1. 특정 위치에서 부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
		//2. 초밥 종류 하나 적힌 쿠폰 발행하고 1.번에 참가하면 쿠폰에 적힌 초밥 하나 무료 제공 없을경우 새로 만들어 제공
		// 손님이 먹을 수 있는 초밥 가짓수의 최대값 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //벨트에 놓인 접시 수
		d = Integer.parseInt(st.nextToken()); //초밥 가지 수
		k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수 
		c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		
		arr = new int[N]; //주어진 초밥 종류
		visited = new int[d+1]; //먹은 초밥

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt =0, max;
		

		for (int i = 0; i < k; i++) {
			if(visited[arr[i]] ==0) { //안 먹어 본 번호일 때 
				cnt++;	
			}
			visited[arr[i]]++;
		}
		
		max = cnt;
		
		for (int i = 1; i < N; i++) {
			if(max <= cnt) {
				if(visited[c] == 0) max = cnt+1; //쿠폰번호가 안 먹어 본 초밥일 때
				else max = cnt; 
			}
			
			visited[arr[i-1]]--; //맨 앞 배열 요소 빼기
			if(visited[arr[i-1]] ==0) cnt--; 
			
			//다음 요소 추가
			if(visited[arr[(i+k-1)%N]] == 0) cnt++;
			visited[arr[(i+k-1) %N]]++;
			
		}
		System.out.println(max);
	}
	
}
