package bs;

import java.util.Scanner;
import java.util.Stack;

public class Main_2493 {
	static int height;
	static int tower; //수신하는 탑
	public static void main(String[] args) {
		// 백준 2493_탑
		//탑들의 개수 N과 탑들의 높이가 주어질 때, 
		//각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는 지 알아내는 프로그램
		Scanner sc = new Scanner(System.in);		
		Stack<Integer> stack = new Stack<Integer>(); 
		Stack<Integer> index = new Stack<Integer>(); //인덱스
		
		int N = sc.nextInt();  //탑의 수
		
		for (int i = 1;i <= N; i++) { //탑 수 만큼,
			height = sc.nextInt();
			if(i ==1) {
				System.out.print("0 ");
			}
			if(stack.isEmpty()) {
				System.out.print("0 ");
			}
			
			while(!stack.isEmpty()) {
				if(stack.peek()>height) { //현재보다 높은 탑
					System.out.print(index.peek()+" ");
					break;
				}
				stack.pop();
				index.pop();
			}
			stack.push(height);
			index.push(i);
		}
		
	}

}
