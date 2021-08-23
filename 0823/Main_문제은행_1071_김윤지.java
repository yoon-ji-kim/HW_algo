import java.util.Scanner;

public class Main_문제은행_1071_김윤지 {
	public static void main(String[] args) {
		//약수와 배수
		//입력 받은 수의 약수와 배수의 합을 각각 출력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //정수의 개수
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt(); //약수와 배수 구할 정수
		int sum1=0;
		int sum2 =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] ==0) continue;
			if(m%arr[i]==0) sum1+= arr[i];
			if(arr[i]%m ==0) sum2+= arr[i];
		}
		
		System.out.println(sum1);
		System.out.println(sum2);
	}
}
