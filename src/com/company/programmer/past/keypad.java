package com.company.programmer.past;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class keypad {
  public static void main(String[] args) {
    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    String hand = "right";
    String ans = solution(numbers, hand);
    System.out.println(ans); // LRLLLRLLRRL
  }
  public static String solution(int[] numbers, String hand) {
    String answer = "";

    /*
    * numbers : 눌러야 하는 번호들
    * hand : 왼손잡이/오른손잡이
    *
    * L : 1,4,7
    * R : 3,6,9
    *
    * 2,5,8,0 -> 현재 위치 기준으로 가장 가까운 손가락이 누른다.
    * 거리 계산
    *
    * Left    Center    Right
    * 1(0,0)   2(1,0)   3(2,0)
    * 4(0,1)   5(1,1)   6(2,1)
    * 7(0,2)   8(1,2)   9(2,2)
    * *(0,3)   0(1,3)   #(2,3)
    *
    * 거리 공식 leftD = (Math.abs(number-left))/3 + (Math.abs(number-left)%3
    *         rightD = (Math.abs(right-number))/3 + (Math.abs(right-number)%3
    * */
    StringBuilder result = new StringBuilder();
    int initLeft = 10; // *
    int initRight = 12; // #

    for (Integer number : numbers) {
      if ( number == 1 || number == 4 || number == 7) { // left
        initLeft = number;
        result.append("L");
      }
      else if ( number == 3 || number == 6 || number ==9) { // right
        initRight = number;
        result.append("R");
      }
      else { // center
        number = number == 0 ? 11 : number;
        int leftDistance = (Math.abs(number-initLeft))/3 + (Math.abs(number-initLeft))%3;
        int rightDistance = (Math.abs(initRight-number))/3 + (Math.abs(initRight-number))%3;

        if (leftDistance > rightDistance) {
          result.append("R");
          initRight = number;
        } else if (leftDistance < rightDistance) {
          result.append("L");
          initLeft = number;
        } else {
          if(hand.equals("left")) {
            result.append("L");
            initLeft = number;
          } else {
            result.append("R");
            initRight = number;
          }
        }
      }
    }
    
    answer = result.toString();
    return answer;
  }
}
