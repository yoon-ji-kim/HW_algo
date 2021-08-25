import java.util.Scanner;

public class Main_BronzeII_8958_김윤지 {

	public static void main(String[] args) {
		// OX퀴즈-> 연손된 O의 개수: 문제의 점수
		//OX퀴즈 결과가 주어졌을 때, 점수를 구하는 프로그램
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스
		String[] str = new String[T];
		for (int i = 0; i < T; i++) {
			str[i] = sc.next();
		}
		
		for (int i = 0; i < T; i++) {
			int cnt =0, sum =0;
			for (int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt =0;
				}
				
				sum+= cnt;
			}
			System.out.println(sum);
		}
	}
}
