package com.company.programmer.level1;

import java.util.Stack;

public class MakeHamburger {

  public static void main(String[] args) {
    int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
    System.out.println(solution(ingredient));
  }
  public static int solution(int[] ingredient) {
    int answer = 0;
    // 1-2-3-1 의 조합 찾기
    // (1) stack 자료 구조 이용하기 ( 재료를 아래에서 위 순으로 쌓는다고 했기 때문에 선택 )
    Stack<Integer> stack = new Stack<>();
    // (2) 재로 배열의 길이만큼 순회
    for (int i = 0; i < ingredient.length; i++) {
      // (3) 스택에 넣기
      stack.push(ingredient[i]);
      // (4) 스택 사이즈가 4개 이상일 때
      if (stack.size() >= 4) {
        // (5) 1-2-3-1 이 연달아 나오는지 확인
        if (stack.get(stack.size()-4) == 1
        && stack.get(stack.size()-3) == 2
        && stack.get(stack.size()-2) == 3
        && stack.get(stack.size()-1) == 1) {
          // (6) 연달아 나오면 햄버거 한 개 완성이므로 answer 증가
          answer++;
          // (7) 재료 빼기
          stack.pop(); stack.pop(); stack.pop(); stack.pop();
        }
      }
    }
    return answer;
  }
}
