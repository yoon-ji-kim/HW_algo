import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_Silver_1244_김윤지 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Switch = Integer.parseInt(br.readLine()); // 스위치 수
		int[] state = new int[Switch]; // 스위치 상태
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<Switch; i++) {
			state[i] = Integer.parseInt(st.nextToken());
		}

		int std = Integer.parseInt(br.readLine()); // 학생수

		for (int i = 0; i < std; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 번호

			if (gender == 1) {// 남학생
				for (int j = 1; j < Switch-1; j++) {
					if ((j + 1) % num == 0) { // 배수를 찾아 0이면 1, 1이면 0
						if (state[j] == 1)
							state[j] = 0;
						else
							state[j] = 1;
					}
				}
			} else if (gender == 2) {// 여학생
				if (state[num-1] == 1)
					state[num-1] = 0;
				else
					state[num-1] = 1;

				int left = (num - 1) - 1;
				int right = (num - 1) + 1;

				while (true) {
					if (left < 0)
						break;
					if (right > Switch - 1)
						break;
					if (state[left] == state[right]) {
						if (state[left] == 1) {
							state[left] = 0;
							state[right] = 0;
						} else {
							state[left] = 1;
							state[right] = 1;
						}
						left--;
						right++;
					}
				}
			}
		}

		for (int i = 0; i < Switch; i++) {
			System.out.print(state[i] + " ");
			if((i+1)%20==0)System.out.println();
		}
	}
}
