package com.company.programmer.level1;

public class ChangeStar {

  public static void main(String[] args) {
    /*
    * 주어진 전화번호의 뒷자리 4자리를 제외하고 *로 바꾼 뒤, 4자리 숫자를 붙여 반환하라.
    * 단, 전화번호의 길이는 4자 이상 20자 이하이다.
    * */
    String phone_number = "01012345678";
    String answer = "";
    String not_star = phone_number.substring(phone_number.length()-4);
    String for_star = phone_number.substring(0, phone_number.length()-4);
    String star = for_star.replaceAll("[0-9]", "*");
    answer = star + not_star;
    System.out.println(answer);
  }
}
