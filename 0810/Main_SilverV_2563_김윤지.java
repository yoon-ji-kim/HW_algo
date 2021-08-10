import java.util.Scanner;

public class  Main_SilverV_2563_김윤지 {

	public static void main(String[] args) {
		//색종이 넓이
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		int cnt = sc.nextInt(); //색종이 수
		int area =0;
		
		for (int i = 0; i < cnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(arr[j][k]==0) {
						arr[j][k] =1;
						area++;
					}
				}
			}
		}
		System.out.println(area);
	}

}
