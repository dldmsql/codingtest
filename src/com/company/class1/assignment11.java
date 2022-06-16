package com.company.class1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class assignment11 {
  public static void main(String[] args) throws IOException{
    arr xb = new arr("Empty vessels make the most sound."); // arr 클래스 생성 및 초기화
    xb.JR(); // arr 클래스에 정의된 JR 함수 호출
/*
*  File 관련 코드는 귀찮아서 쓰지 않았어.
* */
  }

}

class arr {
  /*
  * arr 클래스 내부에서 사용할 변수는 private으로 선언
  * arr 클래스 외부에서도 사용할 수 있는 변수는 public으로 선언
  * */
  private static int count; // 자른 토큰의 개수
  public static String[] ARs; // 자른 토큰을 담아둘 String 타입의 배열
  private static String x; // StringTokenizer에 인자로 넘길 때 사용하는 변수 ( 원본은 s )
  public static StringTokenizer a; // String을 Token으로 잘라주는 애

  public arr(String s) { // arr 클래스 생성자
    x = s; // x에 s를 대입
    a = new StringTokenizer(x, " ."); // StringTokenizer 초기화 ( x를 인자로 사용하기 때문에, x보다 뒤에서 정의되어야 한다. )
    System.out.println("입력 :" + s);
    System.out.println("단어 개수: " + a.countTokens());
    count = a.countTokens(); // count에 StringTokenizer로 잘라낸 토큰의 개수를 대입한다.
    ARs = new String[count]; // ARs 배열 초기화 ( count를 배열의 크기로 넣기 때문에, count보다 뒤에서 정의되어야 한다. )

    for(int i =0; i< count; i++) { // 0부터 count 만큼 반복을 할거다.
      ARs[i] = a.nextToken(); // ARs 배열에 인덱스가 i에 StringTokenizer로 잘라낸 토큰을 대입한다.
      System.out.println(ARs[i]); // 확인용으로 내가 넣은 거니 빼도 된다.!!
    }

  }

  public void JR() { // 정렬된 배열을 출력하는 함수이다.
    Arrays.sort(ARs); // ARs 배열을 정렬한다.
    Arrays.stream(ARs).forEach(s -> System.out.println("정렬된 토큰 : " + s + ", ")); // 자바에서 제공하는 Stream 을 이용해서 forEach() 함수로 정렬된 토큰을 출력한다.
  }
}
