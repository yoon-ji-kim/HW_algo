
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_문제은행_2247_김윤지 {
	static class Room implements Comparable<Room> {
		int stime;
		int etime;
		
		public Room(int stime, int etime) {
			this.stime = stime;
			this.etime = etime;
		}
		
		@Override
		public int compareTo(Room o) {
			return stime - o.stime;
		}	
	}

	public static void main(String[] args) throws Exception {
		//학생들의 도서관 이용시간을 분석
		//1. 적어도 한 명 이상이 머물었던 가장 긴 시간
		//2. 다녀간 전체 시간 중 학생이 한 명도 머물지 않았던 가장 긴 시간
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); //정수 N 
		ArrayList<Room> list = new ArrayList<>(N);
		String line;
		StringTokenizer st;
		for (int i = 0; i < N; i++) { //N개의 줄에 걸쳐 두 정수 S,E가 입력 된다.
			st = new StringTokenizer(in.readLine());
			list.add(new Room(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					));
		}
		//리스트 정렬
		Collections.sort(list);
		
		int stayTime = 0; 
		int emptyTime = 0;
		
		int start = list.get(0).stime;
		int end =list.get(0).etime;
		for (int i = 1; i < N; i++) {
			if(end >= list.get(i).stime) { //연속
				if(end <= list.get(i).etime) {
					//종료 시간이 바뀌었으므로 갱신
					end = list.get(i).etime;
					int Time = list.get(i).etime - list.get(i).stime;	
					stayTime = Math.max(stayTime, Time);
				}
			}else {
				int empty = list.get(i).stime - end;
				emptyTime = Math.max(emptyTime, empty);
				start = list.get(i).stime;
				end = list.get(i).etime;
			}

		}
		System.out.println(stayTime+" "+emptyTime);
	}

}
