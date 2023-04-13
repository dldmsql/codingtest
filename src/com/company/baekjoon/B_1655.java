package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    for(int i =0; i < N; i++) {
      int newNum = Integer.parseInt(br.readLine());

      if(max.size() == min.size()) {
        max.add(newNum);

        if(!min.isEmpty() && max.peek() > min.peek()) {
          min.add(max.poll());
          max.add(min.poll());
        }
      } else {
        min.add(newNum);

        if(max.peek() > min.peek()) {
          min.add(max.poll());
          max.add(min.poll());
        }
      }
      System.out.println(max.peek());
    }
  }
  private static void fail() {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] nums = new int[N];
    int[] answer = new int[N];
    for(int i =0; i < N; i++) {
      int newNum = sc.nextInt();
      nums[i] = newNum;
      int[] copy = Arrays.copyOfRange(nums, 0, i+1);
      Arrays.sort(copy);
      if(i == 0) answer[i] = copy[i];
      else if( i == 1) answer[i] = Math.min(copy[i-1], copy[i]);
      else answer[i] = i%2==0 ? Math.min(copy[i/2], copy[i/2 + 1]) : copy[i/2];
      System.out.println(answer[i]);
    }
  }
}
