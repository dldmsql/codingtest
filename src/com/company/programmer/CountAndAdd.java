package com.company.programmer;

public class CountAndAdd {

  public static void main(String[] args) {
    int result = solution(13, 17);
    System.out.println(result);
  }
  public static int solution(int left, int right) {
    int answer = 0;

    /*
    *   약수 구하기 : 1 ~ sqrt(n) 까지 n으로 나누었을 때, 0인지 판별
    *   제곱수의 경우, count +1
    *   제곱근 방식이기 때문에, 약수가 쌍을 이룬다. 따라서 count +2
    * */
    for (int i = left; i <= right; i++) {
      int count = 0;
      for (int j =1; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
          if( j * j == i) count++;
          else count += 2;
        }
      }
      if(count % 2 == 0) answer += i;
      else answer -= i;
    }
    return answer;
  }

}
