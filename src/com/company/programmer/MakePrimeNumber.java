package com.company.programmer;

import java.util.HashSet;

public class MakePrimeNumber {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    System.out.println(solution(nums));
  }
  public static int solution(int[] nums) {
    int answer = 0;


    /*
    * 3개의 수를 더했을 때, 소수가 되는 경우의 개수를 구하라.
    * nums 에서 서로 다른 3개를 고르고 더한다.
    * 숫자의 제곱근을 확인하자. 이는 약수의 중심을 구하는 것과 동일하다.
    * */

    for (int i =0; i <nums.length-2; i++){
      for(int j = i+1; j < nums.length-1; j++){
        for(int k = j+1; k < nums.length; k++) {
          if(isPrime(nums[i] + nums[j] + nums[k])) {
            answer++;
          }
        }
      }
    }


    return answer;
  }
  /*
    소수 판별하기
    N을 sqrt(N) 이하의 자연수로만 나눈다.
    소수를 판별한다는 것은 결국 1과 자기 자신을 제외한 다른 자연수를 약수로 갖고 있으면 안된다는 의미이다.
    N ( N > 0 )이 주어졌을 때,
    p * q = N 을 만족한다.
    1 <= p, q <= N
    따라서 p와 q 둘 중 하나는 반드시 sqrt(N) 보다 작다.
   */

  private static boolean isPrime(int num) {
    for(int i = 2; i*i <= num; i++) { // sqrt 대신 제곱수를 사용한다.
      if(num % i ==0) return false;
    }
    return true;
  }
}
