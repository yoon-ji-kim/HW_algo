import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main_SilverI_1992_김윤지 {
	//백준 쿼드트리
	//모두 0이면 0 모두 1이면 1 출력
	//0과 1이 섞여있으면 전체를 한 번에 나타내지 못하고 왼쪽 위, 오른쪽 위,왼쪽 아리, 오른쪽 아래 나눠서 압축
	static int[][] map;
	static int N, x, y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(inputData));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		split(0,0,N);
	}

	public static void split(int x, int y,int n) {
		if (n == 1) {
			System.out.print(map[x][y]);
			return;
		}
		
		boolean one = true;
		boolean zero = true;
		
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(map[i][j] ==0) one = false;
				if(map[i][j] == 1) zero = false;
			}
		}
		
		if(one) {
			System.out.print(1);
			return;
		}else if(zero) {
			System.out.print(0);
			return;
		}else {
			System.out.printf("(");
			split(x, y, n / 2);
			split(x, y + n / 2, n / 2);
			split(x + n / 2, y, n / 2);
			split(x + n / 2, y + n / 2, n / 2);
			System.out.printf(")");			
		}
		return;
	}
	
	static String inputData ="8\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"00011100\r\n" + 
			"00011100\r\n" + 
			"11110000\r\n" + 
			"11110000\r\n" + 
			"11110011\r\n" + 
			"11110011";
}
