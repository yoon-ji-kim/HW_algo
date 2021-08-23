import java.util.Scanner;

public class Main_문제은행_1523_김윤지 {

	public static void main(String[] args) {
		//1523_별 삼각형
		// n크기의 와 종류 m 입력받아 맞춰서 출력, 범위 벗어나면 INPUT ERROR! 출력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //높이
		int m = sc.nextInt(); //종류
		switch (m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i =n; i> 0; i--) {
				for (int j = i; j >0; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {//행
				for (int j = 0; j <n-i-1; j++) {
					System.out.printf(" ");
				}
				for (int j = 0; j < (i+1)*2-1; j++) {
					System.out.printf("*");
				}
				System.out.println();
			}
			break;
		default:
			System.out.println("INPUT ERROR!");
			break;
		}
	}

}
