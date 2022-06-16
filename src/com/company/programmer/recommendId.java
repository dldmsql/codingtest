package com.company.programmer;

public class recommendId {

  public String solution(String new_id) {
    String answer = "";

    // stage 1
    String stage1 = new_id.toLowerCase(); // 모든 글자를 소문자로 바꾸기

    char[] stage1_str = stage1.toCharArray(); // char[] 배열로 바꾸기
    StringBuilder stage2 = new StringBuilder(); // stringbuilder로 char를 합치기
    for (char c : stage1_str) {
      if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.'){
        stage2.append(c);
      }
    }

    String stage3 = stage2.toString().replace("..", "."); // replace()로 .. -> . 로 바꾸기
    while(stage3.contains("..")) { // 여전히 ".."를 포함하고 있다면, 없을 때까지 반복해서 바꿔주기
      stage3 = stage3.replace("..", ".");
    }

    String stage4 = stage3; // 임시저장
    if (stage4.length() > 0) { // 길이가 0보다 크다면
      if (stage4.startsWith(".")) { // "."으로 시작한다면
        stage4 = stage4.substring(1, stage4.length()); // 맨 앞 0번째만 잘라내기
      }
    }
    if (stage4.length() > 0) { // 길이가 0보다 크다면
      if (stage4.endsWith(".")) { // "."으로 끝난다면
        stage4 = stage4.substring(0, stage4.length()-1); // 맨 뒤만 잘라내기
      }
    }

    String stage5 = stage4; // 임시저장
    if(stage5.equals("")) { // 빈 값이라면
      stage5 = "a"; // a 대입하기
    }

    String stage6 = stage5; // 임시저장
    if (stage6.length() >= 16) { // 길이가 16자 이상이라면
      stage6 = stage6.substring(0, 15); // 15자까지 질라내기

      if ( stage6.endsWith(".")) { // "."으로 끝난다면
        stage6 = stage6.substring(0, stage6.length()-1); // 맨 뒤만 잘라내기
      }
    }


    StringBuilder stage7 = new StringBuilder(stage6); // stringbuilder에 대입
    if (stage7.length() <= 2) { // 길이가 2보다 작거나 같다면
      char last = stage7.charAt(stage7.length()-1); // 마지막 char 값 추출
      while (stage7.length() < 3) { // 길이가 3이상이 될 때까지
        stage7.append(last); // last를 이어서 붙이기
      }
    }
    answer = String.valueOf(stage7); // 최종 결과를 answer에 대입
    return answer;
  }

}
