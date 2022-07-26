package com.company.stage18;

import java.util.Scanner;

public class ex_1541 {

  public static void main(String[] args) {
    /*
    * 양수, + , - , 괄호 를 이용해 식을 만든 뒤, 괄호를 지웠다.
    * 괄호를 다시 쳐서 이 식의 값을 최소로 만들고자 한다.
    * 최소로 만들기 위해서는 가장 큰 수로 빼야 한다.
    * */

    Scanner sc = new Scanner(System.in);

    String expression = sc.next(); // 입력 저장

    int sum = 0; // 최종 출력을 위한 변수

    String[] splitsBySub = expression.split("-"); // - 기호를 중심으로 문자열 분리

    for(int i = 0; i < splitsBySub.length; i++ ){ // 분리한 문자열에서 
      int temp = 0; // + 기호 기준으로 합계를 저장할 변수

      String[] splitsByAdd = splitsBySub[i].split("\\+"); // + 기호를 중심으로 문자열 분리

      for(int j = 0; j < splitsByAdd.length; j ++) { // 분리한 문자열에서
        temp += Integer.parseInt(splitsByAdd[j]); // temp에 숫자 더하기

      }

      if( i == 0 ) { // i ==0인 경우는 맨 처음뿐이니까
        sum += temp; // temp를 더하기
      } else { // 아니라면
        sum -= temp; // temp를 빼주기
      }
    }
    System.out.println(sum);

  }
}
