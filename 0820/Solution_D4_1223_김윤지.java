import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_김윤지 {

	public static void main(String[] args) throws Exception{
		//계산기2
		//총 10개의 테스트케이스가 주어질 때, 계산식을 후위표기식으로 바꾸어 계산하는 프로그램
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); //테스트케이스 길이
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			String number ="";
			 //곱셈이 우선순위가 더 크서 덧셈 들어오면 stack에 있는 연산자 빼고나서 push
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c != '*' && c!='+') { //숫자인 경우
					number += c;
				} else {
					//곱셈
					if(c == '*') stack.push(c);
					//덧셈
					else {
						while(!stack.isEmpty() && (stack.peek() =='*' || stack.peek() =='+')) {
							number += stack.pop();
						}
						stack.push(c);
					}
				}
			}
			while(!stack.isEmpty()) {
				number += stack.pop(); //연산자 push
			}
			
			Stack<Integer> sum = new Stack<>();
			for (int i = 0; i < number.length(); i++) {
				if(number.charAt(i) != '+' && number.charAt(i) != '*') {
					sum.push(number.charAt(i)-'0'); //숫자인 경우 push
				}else {
					int num1 = sum.pop();
					int num2 = sum.pop();
					char op = number.charAt(i);
					if(op == '*') {
						int mul = num1 * num2;
						sum.push(mul);
					}else if(op == '+') {
						int plus = num1 + num2;
						sum.push(plus);
					}
				}
			}
			
			System.out.println("#"+ tc+ " "+ sum.pop());
		}
	}

}
