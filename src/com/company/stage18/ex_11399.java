package com.company.stage18;

import java.util.Arrays;
import java.util.Scanner;

public class ex_11399 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];

    for ( int i =0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr); // 정렬하기

    int pre = 0; // 이전까지의 대기시간 누적합
    int sum = 0; // 사람별 대기시간 총합

    for ( int i =0; i < N; i++) {
      sum += pre + arr[i];// Total 을 위한 연산

      pre += arr[i]; // 각 사람마다 거쳐가면서 대기 시간 더해주는 연산
    }

    System.out.println(sum);
  }
}
