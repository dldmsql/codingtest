package com.company.programmer.past;

import java.util.Comparator;
import java.util.HashMap;

public class Pair {
  /*
  * 시간 초과
  * */

  public static void main(String[] args) {
    String X = "100";
    String Y = "123450";
    // output 10
    System.out.println(solution1(X,Y));
  }
    public static String solution(String X, String Y) {

      HashMap<Integer, Integer> arr = new HashMap<>();

      String[] arrX = X.split("");
      String[] arrY = Y.split("");

      for(int i = 0; i < arrX.length; i++) {
        for(int j =0; j < arrY.length; j++) {
          if (arrX[i].equals(arrY[j])) {
            if (arr.containsKey(j)) continue;
            arr.put(j, Integer.parseInt(arrY[j]));
            break;
          }
        }
      }

      if(arr.size() == 0) {
        return "-1";
      }

      StringBuilder answer = new StringBuilder();
      arr.values().stream().sorted(Comparator.reverseOrder()).forEach(answer::append);

      if(Integer.parseInt(answer.toString()) == 0) {
        return "0";
      }
      return answer.toString();
    }

    static public String solution1(String X, String Y) {
      StringBuilder answer = new StringBuilder();
      // x와 y 문자열의 숫자들을 보관할 배열
      // 테스트로 주어지는 String 의 최대 길이가 10이다.
      int[] xArr = new int[10];
      int[] yArr = new int[10];
      // 공통의 짝을 보관할 배열
      int[] common = new int[10];
      // 교집합인 숫자가 몇 개인 지 
      int count = 0;
      // String X를 분해해서 배열에 담기
      for(int i = 0; i < X.length(); i++) {
        xArr[(X.charAt(i) -'0')]++; // char로 바꿔서 -0 해준다. 이게 index. 해당 index를 갖는 숫자의 개수가 배열의 값
      }

      for(int i = 0; i < Y.length(); i++) {
        yArr[(Y.charAt(i) -'0')]++;
      }
      // 교집합 숫자 확인하기
      for(int i =0; i < 10; i++) {
        while(xArr[i] != 0 && yArr[i] != 0) { //해당 index를 갖는 숫작가 존재한다면 => 둘다 존재하는 것이므로 같은 숫자이다.
          count++; // 교집합 숫자 카운트
          common[i]++; // 해당 index를 갖는 숫자의 개수가 배열의 값
          xArr[i]--; // 사용했으니 차감
          yArr[i]--; // 사용했으니 차감
        }
      }

      if(count ==0) return "-1"; // 교집합이 없으면

      // 배열의 끝에서부터 값이 있는지 확인해서 큰 자리수 만들기
      while(count > 0) {  // 갖고있는 숫자 전부 다 쓸 때까지
        for(int i =9; i >=0; i--) { // 뒤에서 부터
          if(common[i] != 0) { // 해당 index에 값이 존재한다면
            answer.append(String.valueOf(i)); // 출력값에 이어 붙이기
            common[i]--; // 사용했으니 차감
            break;
          }
        }
        count--; // 개수 차감
      }
      // 문자열이 0으로만 구성되어 있다면 ( 즉, 0으로 구분하여 잘랐는데, 길이가 0이면 ) 0 반환
      if(answer.toString().split("0").length==0) return "0";
      return answer.toString(); // 출력값 반환
    }
}
