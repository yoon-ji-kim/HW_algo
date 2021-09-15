import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3124_김윤지 {
	static class Edge implements Comparable<Edge>{
		
		int start,end,weight;

		public Edge(int start, int end, int weight) { //생성자
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		//오름차순  comparable
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}	
	}
	
	static int[] parents; // 부모 원소를 관리

	private static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	private static int findSet(int a) {
		// a가 속한 집합의 대표자 찾기
		if (a == parents[a]) return a; // 자신이 대표자
		return parents[a] = findSet(parents[a]);
	}

	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b); // root찾기
		if (aRoot == bRoot)
			return false; // 이미 같은 집합에 속해있으므로 합치치 않음

		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V,E;
	static Edge[] edgeList; //Edge배열
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			
			V = Integer.parseInt(st.nextToken()); //정점
			E = Integer.parseInt(st.nextToken()); //간선
			
			//간선 리스트 작성
			edgeList = new Edge[E]; //간선개수만큼 리스트
			parents = new int[V+1];
					
			for (int i = 0; i < E; i++) { //간선저장
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start,end,weight);
			}
			
			Arrays.sort(edgeList); //오름차순 정렬
			
			makeSet(); //모든 정점을 각각의 집합으로 만들기
			
			//간선 하나씩 시도하며 트리 만들어 감
			int cnt =0;
			long result =0; //간선개수 관리
			for (Edge edge : edgeList) {//간선수만큼
				if(unionSet(edge.start, edge.end)) { //Edge만큼 반복 돌리며 cycle있는지 확인
					result += edge.weight;
					if(++cnt == V-1) break; //신장트리 완성
				}
			}
			
			System.out.println("#"+ tc+ " " +result);
		}	
	}
}
