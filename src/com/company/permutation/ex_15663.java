package com.company.permutation;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ex_15663 {

  // 다시 도전
  static int N;
  static int M;
  static int[] arr, perm;
  static boolean[] visited;
  static LinkedHashSet<String> answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[N];
    perm = new int[M];
    visited = new boolean[N];
    answer = new LinkedHashSet<>();

    for ( int i= 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    recursive(0);
    answer.forEach(System.out::println);

  }

  private static void recursive(int k) {
    if ( k == M ) {
      StringBuilder sb= new StringBuilder();
      for (Integer p : perm) {
      sb.append(p).append(" ");

      }
      answer.add(sb.toString());
      return;
    }

    for(int i =0; i < N; i++) {
      if(visited[i])
        continue;
      visited[i] = true;
      perm[k] = arr[i];
      recursive(k+1);
      visited[i] = false;
    }
  }
}
