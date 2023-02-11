package com.company.baekjoon;

import java.util.Scanner;

public class B_1107 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    boolean[] broken = new boolean[10]; // 고장난 버튼 정보 담은 배열

    for(int i = 0; i < M; i++) { // 고장난 버튼
      int b = sc.nextInt();
      broken[b] = true;
    }

    int answer = Math.abs(100-N); // 현위치  100번 채널 가고자 하는 채널 N

    for (int i = 0; i <= 999999; i++) { // 이동하고자 하는 채널 N은 500,000까지 이므로 999,999번 채널부터 - 버튼으로 도달할 수 있다.
      String st = String.valueOf(i); // 새롭게 누르는 채널을 누르는 버튼의 개수
      int length = st.length();

      boolean isBroken = false; // 고장났는지 여부 확인
      for(int j = 0; j < length; j++) {
        if (broken[st.charAt(j) - '0']) { // String으로 타입 캐스팅 후, char 로 비교하기 위해 '0' 빼주기
          isBroken = true;// 해당하는 번호가 있다면 고장 난 것임
          break;
        }

      }
      if(!isBroken) { // 고장나지 않은 버튼에 대해
        int min = Math.abs(N - i) + length; // 0 ~ 999,999 까지 순회하며 N에서 현재 위치까지의 차이를 뺀 값에 이동하면 누른 버튼의 수를 더한 값을 구한다.
        answer = Math.min(min, answer); // 100에서 이동하는 것과 위에서 구한 값 중 최솟값을 찾는다.
      }
    }
    System.out.println(answer);
  }
}
