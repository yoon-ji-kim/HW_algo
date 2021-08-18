import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_문제은행_1828_김윤지 {
	static class Chemical implements Comparable<Chemical> {
		int lowTemp;
		int highTemp;
		
		public Chemical(int lowTemp, int highTemp) {
			this.lowTemp = lowTemp; //최저 온도
			this.highTemp = highTemp; //최고온도
		}
		
		@Override
		public int compareTo(Chemical o) {
			return this.highTemp -o.highTemp;
		}
		
	}
	public static void main(String[] args) throws Exception{
		//Ci는 xi이상 yi이하의 온도에서 보관되어야만 안전하다
		//모두 보관하기 위해 필요한 적은 수의 냉장고
		//화학물질의 수 N개 1이상100이하 -> 다음주: 최저보관온도 & 최고보관온도 -270~10000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //화학물질 개수
		
		ArrayList<Chemical> list = new ArrayList<>(N);
		String line;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Chemical(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					));
		}
		//리스트 정렬
		Collections.sort(list);
		
		//화학 물질의 최저 온도가 이전 화학물질의 최고 온도보다 낮으면 저장가능
		//=>이전 물질의 최고 온도보다 현재 물질의 최저온도가 높으면 냉장고 추가
		
		//현재 최고온도를 최고온도로 설정
		int high = list.get(0).highTemp;
		int cnt =1;
		for (int i = 1; i < N; i++) {
			if(list.get(i).lowTemp <= high) {
				if(list.get(i).highTemp < high) {
					high = list.get(i).highTemp;
				}
				continue;
			}else {
				high = list.get(i).lowTemp;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
