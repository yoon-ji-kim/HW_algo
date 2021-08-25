import java.util.Scanner;

public class Main_BronzeII_3052_김윤지 {

	public static void main(String[] args) {
		//수 10개를 입력 받은 뒤 42로 나눈 나머지를 구한다 서로 다른 값이 몇개 있는지
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[42]; //0~41 나머지
		int cnt =0;
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			arr[n%42]++;
		}
		
		for (int i = 0; i < 42; i++) {
			if(arr[i] !=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
