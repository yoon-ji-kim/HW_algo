import java.util.Scanner;

public class Solution_D2_1948_김윤지 {

	public static void main(String[] args) {
		//swea_1948 날짜 계산기
		//두번째 날짜랑 첫번째 날짜 차이
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int tc = 1; tc <= T; tc++) {
			int sm = sc.nextInt();
			int sd = sc.nextInt();
			int em = sc.nextInt();
			int ed = sc.nextInt();
			
			if(sm == em) {
				int result = ed-sd +1;
				System.out.printf("#"+tc+" "+ result +"%n");
			}else {
				int result =0;
				result += date[sm]-sd+1;
				for (int i = sm+1; i < em; i++) {
					result += date[i];
				}
				result += ed;
				System.out.printf("#"+tc+" " +result+"%n");
			}
		}
	}

}
