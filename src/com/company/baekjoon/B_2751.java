package com.company.baekjoon;

import java.util.*;

public class B_2751 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    int N = sc.nextInt();
    ArrayList<Integer> inputs = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      inputs.add(sc.nextInt());
    }

    Collections.sort(inputs); // Arrays.sort() 로 하면 시간초과

    for(int l : inputs){
      sb.append(l).append("\n");
    }
    System.out.println(sb.toString()); // sb 안쓰면 시간초과
  }
}
