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
		
		split(0,0);
	}

	public static void split(int x, int y) {
		int arr = map[x][y];
		
		//0이나 1로만 이루어져 있으면 0이나 1출력
		//아니면 반으로 잘라 4번 나눠서 호출
		// N/2
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
