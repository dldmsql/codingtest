package com.company.programmer.past;

import java.util.Stack;

public class crain {

  public static void main(String[] args) {
    int[][] nums = {{0,0,0,0,0},
                    {0,0,1,0,3},
                    {0,2,5,0,1},
                    {4,2,4,4,2},
                    {3,5,1,3,1}};
    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    int count = solution(nums, moves);
    System.out.println(count);
  }
  public static int solution(int[][] board, int[] moves) {
    int answer = 0;
    /*
    * 스택을 이용하자.
    * 스택에 0을넣어서 top과 비교할 때 사용.
    * moves의 길이 만큼 for문을 돌린다. 그리고, borad의 길이 만큼 for문을 돌린다.
    * board[i][move -1] // borad[0][1-1] 부터 확인
    *   0인지 확인
    *   peek()으로 top과 같은 지 확인
    *   같다면, pop() 하고 answer 2증가
    *   다르다면, push()
    *   그 후에 borad[i][move-1] = 0
    * */
    Stack<Integer> nums = new Stack<>();
    nums.push(0);

    for(Integer move : moves) {
      for( int i =0; i < board.length; i++){
        if(board[i][move-1] != 0){
          if( nums.peek() == board[i][move - 1]) {
            nums.pop();
            answer+=2;
          } else {
            nums.push(board[i][move-1]);
          }
          board[i][move-1] = 0;
          break;
        }
      }
    }


    return answer;
  }
}
