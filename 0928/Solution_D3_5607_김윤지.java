package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution_D3_5607_김윤지 {
	static int p = 1234567891;
	
	public static void main(String[] args) throws Exception{
		//swea 5607 [professional] 조합
		//nCr = n! * 1/(n-r)!r!  a^p-1 = 1(mod p) --> a^p-2 = 1/a (mod p)
		//nCr = n! * a^p-2      --> n!*(n-r)!r!^(1234567891-2)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long[] fac = new long[n+1];
			fac[0] =1;
			for (int i = 1; i <= n; i++) {
				//n! = (n-1)! *n
				fac[i] = (fac[i-1] *i) %p;
			}
			//(n-r)!r!
			long a = (fac[n-r] * fac[r]) %p; 
			//a^p-2
			long result = pwr(a,p-2) %p;
			//n! * a^p-2
			System.out.println("#"+ test_case+" "+(fac[n] * result) %p);
		}
	}
	private static long pwr(long a, int b) {
		//거듭 제곱
		//짝수: 2^n = 2^n/2 * 2^n/2
		//홀수: 2^n = 2^n/2 * 2^n/2 * 2
		if(b ==0) return 1;
		else if(b == 1) return a;
		
		long num = pwr(a, b/2);
		if(b%2 == 0){ //짝수
			return (num * num) %p;
		}else {//홀수
			return ((num * num)%p * a)%p;
		}
	}

}
