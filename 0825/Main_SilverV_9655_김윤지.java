import java.util.Scanner;

public class Main_SilverV_9655_김윤지 {

	public static void main(String[] args) {
		//백준 9655 돌 게임
		//탁자위 돌 N개를 번갈아가면서 1개또는 3개 들고가고 마지막 돌 가져가는 사람 이기는 게임 
		//5 - 1(4)-1(3)-1(2)-1(1)-1 상 /3(2)-1(1)-1 상
		//6 - 3(3)-3 창/ 3(3)-1(2)-1(1)-1/ 
		//7
		//8
		//9
		//10
		//11
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //돌의 개수
		if(N%2 ==0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}
}
