package com.company.stage18;

import java.util.Arrays;
import java.util.Scanner;

public class ex_2217 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];

    for ( int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();

    }

    Arrays.sort(arr);

    int max = 0;

    for ( int i = 0; i < N; i++) {
      max = Math.max(max, arr[i]*(N-i)); // 로프가 버틸 수 있는 최소 중량 * 로프 수
    }
    System.out.println(max);
  }
}
