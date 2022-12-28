package com.company.programmer.level1;

public class PriceOfLeak {

  public static void main(String[] args) {
    System.out.println(solution(3, 20, 4));
  }
  public static long solution(int price, int money, int count) {
    // (1) 1 ~ count까지를 더한 값
    long sumOfCnt = 0;
    for (int i = 1; i <= count; i++) {
      sumOfCnt += i;
    }
    // (2) 현재 갖고 있는 돈에서 이용료를 차감
    long tmp = money - (price*sumOfCnt);
    // (3) 차액이 양수이면, 0 반환
    if (tmp > 0) {
      return 0;
      // (4) 차액이 음수이면, 절댓값 씌워서 반환
    } else return Math.abs(tmp);
  }
}
