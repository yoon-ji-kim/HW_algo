
import java.util.Scanner;

public class Solution_D2_1976_김윤지 {

	public static void main(String[] args) {
		//시 분으로 이루어진 시각을 2개 입력 받아 더한 값을 시 분으로 출력하는 프로그램
		//시각은 12시간제로 표시
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int hour1 = sc.nextInt();
			int minute1 = sc.nextInt();
			int hour2 = sc.nextInt();
			int minute2 = sc.nextInt();
			
			int H = hour1+ hour2;
			int M = minute1 + minute2;
			
			if(M >= 60) {
				H += M/60;
				M = M%60;	
			}
			if(H > 12) {
				if(H%12 ==0) H = 12;
				else H = H%12;
			}
			System.out.printf("#%d %d %d %n",i, H,M);
		}
	}

}
