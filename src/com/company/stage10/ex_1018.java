package com.company.stage10;

import java.util.Scanner;

public class ex_1018 {
  static int MIN_VALUE = 64; // 8 x 8 을 모두 다 다시 칠해야 하는 경우
  static boolean[][] WB; // B 이면 true, W 이면 false
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    WB = new boolean[N][M];

    for(int i = 0; i<N; i++) {
      String row = sc.next();

      for(int j = 0; j < row.length(); j++) {
        if(row.charAt(j) == 'B') {
          WB[i][j] = true;
        } else WB[i][j] = false;
      }
    }

    int N_row = N-7; // 가로 - 7
    int M_row = M-7; // 세로 - 7
    /*
    * 예를 들어, N = 10, M = 13 일 때 8 x 8를 자르는 경우는 ?
    * ( 10-7 ) * ( 13 - 7)
    * */

    for(int i =0; i < N_row; i++) {
      for(int j = 0; j < M_row; j++) {
        find(i,j);
      }
    }
    System.out.println(MIN_VALUE);
  }

  private static void find(int i, int j) {
    int end_X = i+8; // 0부터 들어온다.
    int end_y = j+8;
    int count = 0;

    boolean TF = WB[i][j]; // 첫번째 좌표에 있는 색깔

    for(int x = i; x < end_X; x++) {
      for(int y = j; y < end_y; y++) {
        if(WB[x][y] != TF) { // 첫번째 좌표에 있던 색이랑 다르다면
          count++; // 흰검 혹은 검흰 일테니까 카운트 증가
        }
        TF = !TF; // 그 다음 위치는 색이 바뀌니까,
      }
      TF = !TF; //
    }
    count = Math.min(count, 64 - count); // count는 올바른 갯수. 이거랑 64에서 뺀 값 중 더 작은 값을 선택
    MIN_VALUE = Math.min(MIN_VALUE, count); // 최종 최소값은 64와 count 중 작은 값으로.
  }

}
