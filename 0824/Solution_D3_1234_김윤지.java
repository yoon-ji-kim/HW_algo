import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1234_김윤지 {
	public static void main(String[] args) {
		//swea 1234_ 비밀번호
		//붙어 있는 쌍들을 소거하고 남은 번호로 비밀번호 만드는 것
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> result = new Stack<Character>();
		int T =10;
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				if(stack.isEmpty()) {
					stack.push(str.charAt(j));
					continue;
				}
				if(stack.peek() == str.charAt(j)) {
					stack.pop();
				}else {
					stack.push(str.charAt(j));					
				}
			}
			while (!stack.isEmpty()) {
				result.push(stack.pop());
			}
			System.out.printf("#"+i+" ");
			while (!result.isEmpty()) {
				System.out.print(result.pop());
			}
			System.out.println();
			stack.clear();
		}
	}

}
