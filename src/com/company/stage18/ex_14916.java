package com.company.stage18;

import java.util.Scanner;

public class ex_14916 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int cnt = 0;

    while( N > 0 ) {
      if( N == 1 || N == 3 ) { // 1 혹은 3은 거스름돈을 줄 수 없는 경우이다.
        if( cnt == 0 ) { // 처음부터 1 혹은 3이 나온 케이스라면
          cnt = -1;
        }
        break;
      }

      if( N%5 == 0 ) { // 5로 나누어 떨어지는 숫자라면
        cnt += N / 5; // 5로 나눈 몫을 더해준다.

        break; // 종료
      } else { // 5로 나누어 떨어지지 않는 다면
        N -= 2; // 거스름돈에서 2를 빼준다.
        cnt++; // 한 번만 빼니까, cnt도 1씩 증가시킨다.
      }
    }

    System.out.println(cnt);
  }
}
