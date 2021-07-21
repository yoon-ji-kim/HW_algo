package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 *  소금쟁이가 처음 뛸 때는 3칸 두번 째 2칸 세번쨰 1칸
 *  연못 밖으로 나가거나 머물고 있는 소금쟁이와 충돌하면 죽는다.
 *  N은 5~20
 *  
 *  출력 결과
 *  #1 3
 *  #2 4
 *  #3 1
 */

public class Solution22 {
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("res/Solution22.txt"));
		Scanner sc = new Scanner(System.in);	
		//			상,하,좌,우
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int T = sc.nextInt();	//테스트 케이스
		
		for(int test_case=1; test_case<=T; test_case++) { 
			int N = sc.nextInt(); //연못 크기
			int W = sc.nextInt(); //소금쟁이 수
			int[][] arr = new int[W][3]; //소금쟁이
			int[][] map = new int[N][N]; //연못
			int AnswerW =W;
			
			for (int i = 0; i < W; i++) {  //배열에 소금쟁이 데이터 입력받기
				for (int j = 0; j < 3; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			

			for (int i = 0; i < W; i++) {
				int nr = arr[i][0];  //시작위치에 소금쟁이
				int nc = arr[i][1];
				int dir = arr[i][2];
				
				if(map[nr][nc]==1) { //시작 위치가 다른 소금쟁이 있다면 죽음
					AnswerW--;
					break;
				}
				
				
				for (int j = 3; j >0; j--) { //3칸->2칸->1칸 점프
					if(dir ==1) 	 { nr += j*dr[dir-1]; }
					else if(dir ==2) { nr += j*dr[dir-1]; }
					else if(dir ==3) { nc += j*dc[dir-1]; }
					else if(dir ==4) { nc += j*dc[dir-1]; }
					else break; 
					
					if(nr< 0 || nr >= N || nc < 0 || nc >= N) { //연못 밖이라면 죽음
						AnswerW--;
						break;
					} 
					
					if(map[nr][nc] == 1) { //위치에 다른 소금쟁이 있다면 죽음
						AnswerW--;
						break;
					}
					if(j==1) {			//머무는 소금쟁이 표시
						map[nr][nc]=1; 
						
					}
 				}
			}
			
			System.out.println("#"+test_case+" "+AnswerW);
		}
	}

}
