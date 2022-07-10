package com.company.stage19;

import java.util.Arrays;
import java.util.Scanner;

public class ex_10828 {
  static int[] stack;
  static int size = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int N = sc.nextInt();

    stack = new int[N];

    for( int i = 0; i < N; i++ ){

      String command = sc.next();

      switch (command) {
        case "push":
          push(sc.nextInt());
          break;
        case "pop" :
          sb.append(pop()).append("\n");
          break;
        case "size" :
          sb.append(size()).append("\n");
          break;
        case "empty" :
          sb.append(empty()).append("\n");
          break;
        case "top" :
          sb.append(top()).append("\n");
          break;
      }
    }

    System.out.println(sb);
  }

  public static void push(int num) {
    stack[size] = num;
    size++;
  }

  public static int pop() {
    if(size == 0) return -1;
    else {
      int top = stack[size-1];
      stack[size-1] = 0;
      size--;
      return top;
    }
  }

  public static int size() {
    return size;
  }

  public static int empty() {
    return size == 0 ? 1 : 0;
  }

  public static int top() {
    if(size == 0) return -1;
    else return stack[size-1];
  }

}
