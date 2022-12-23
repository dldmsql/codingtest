package com.company.programmer.past;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 2, 3};
//    System.out.println(Arrays.stream(solution(prices)).forEach(System.out::print));
  }

  public static int[] solution(int[] prices) {
    int[] answer = new int[prices.length];

    Stack<Integer> stack = new Stack<>(); // 인덱스를 저장하기 위한 스택

    for( int i =0 ; i < prices.length; i++) { // 반복문을 돌면서
      while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 스택에 값이 들어있으면서 이전 가격보다 현재 가격이 작다면
        answer[stack.peek()] = i - stack.peek(); // 이전가격에 현재 인덱스 - 이전 가격 인덱스
        stack.pop(); // 스택에서 이전 가격 꺼내기
      }
      stack.push(i); // 현재 가격 스택에 넣기
    }

    while(!stack.isEmpty()) { // 가격이 한번도 떨어지지 않았던 가격들
      answer[stack.peek()] = prices.length - stack.peek() -1; // 가장 위에 있는 가격에 전체 길이 - 자기 자신 인덱스 - 1
      stack.pop(); // 스택에서 꺼내기
    }
    return answer;
  }
}
