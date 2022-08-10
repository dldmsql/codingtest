package com.company.programmer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Delivery {

  static public void main(String[] args) {
    int[] quiz1 = { 4,3,1,2,5 };
    int[] quiz2 = { 5,4,3,2,1 };

    System.out.println(solution1(quiz1) == 2);
    System.out.println(solution1(quiz2) == 5);
  }

  public static int solution(Integer[] order) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    int out = 0;
    for (int i = 0; i < order.length; i++) { // 컨베이어 벨트에서 오고 있는 택배 상자들
      for (int j = 1; j <= order.length; j++) { // 1 부터 n 까지 차례로 오는 중
        int curOrder = order[i]; // 현재 트럭에 들어가야 하는 택배
        int curDelivery; // 컨베이어에서 꺼내야 하는 택배
        if (out == 0) {
          curDelivery = j;
        } else {
          curDelivery = out + 1;
        }
        if (curDelivery == curOrder) {
          answer++;
          out = curOrder;
          break;
        } else {
          if (!stack.isEmpty()) {
            if (stack.peek() == curOrder) {
              answer++;
              out = stack.pop();
              break;
            }
          }
          stack.push(curDelivery);
        }
      }

    }

    return answer;
  }
  public static int solution1(int[] order) {
    int answer = 0;

    // 택배 상자 보관할 스택
    Stack<Integer> stack = new Stack<>();
    // 박스의 총 개수
    int boxTotal = order.length;
    // 현재 박스의 인덱스 ( 1부터 시작 )
    int boxIndex = 1;
    // 현재까지 처리된 order 박스 인덱스 ( 0부터 시작 )
    int orderIndex = 0;

    while(true) {
      // order[orderIndex] 와 boxIndex가 다른 상황에서
      // order[orderIndex] 가 boxIndex 보다 크다면,
      // boxIndex를 stack에 집어 넣는 것으로 order[orderIndex]를 맞출 수 있으므로 stack에 boxIndex를 push 한다.
      // 만약 order[orderIndex] 가 boxIndex보다 작다면 일단 stack에 들어 있는 지 확인하고
      // stack에서도 해당 값이 없다면 박스를 stack에 넣을 필요가 없다.
      if(order[orderIndex] != boxIndex
      && order[orderIndex] > boxIndex) {
        stack.push(boxIndex);
        boxIndex++;
      }
      // boxIndex와 order[orderIndex] 가 같으면
      // answer 값을 증가시키고 boxIndex도 증가시킨다.
      // orderIndex 값도 증가시켜야 하는데, 그냥 올리면 에러가 뜬다.
      else if(order[orderIndex] == boxIndex) {
        boxIndex++;
        answer++;
        if(orderIndex +1 != boxTotal) { // orderIndex 는 0부터 시작하여 boxTotal 까지만 유효하다.
          orderIndex++;
        }
        // boxIndex로 order[orderIndex]를 맞출 수 없을 때 stack을 확인해야 하며
        // stack을 사용할 때에는 Emtpy인지 확인 해야 한다.
        // peek을 사용해서 일단 최상단 값을 확인하고 맞으면 pop을 해야 한다.
        else if( !stack.isEmpty() && stack.peek() == order[orderIndex]) {
          stack.pop();
          answer++;
          if(orderIndex +1 != boxTotal) {
            orderIndex++;
          }
          // 위의 케이스에 맞는 게 없다면 탈출한다.
          else {
            break;
          }
        }
      }
    }

    return answer;
  }

}
