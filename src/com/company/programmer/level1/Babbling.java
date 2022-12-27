package com.company.programmer.level1;

public class Babbling {

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"aya", "yee", "u", "maa"}));
    System.out.println(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
  }

  private static int solution(String[] babbling) {
    int answer = 0;
    // (1) 옹알이 길이만큼 순회
    for(int i=0; i < babbling.length; i++){
      // (2) 발음 불가능한 단어를 포함하고 있다면
      if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") ||
          babbling[i].contains("mama") || babbling[i].contains("woowoo"))
        continue;
      // (3) 발음 가능한 단어는 " " 띄어쓰기로 대체 -> 띄어쓰기 삭제
      babbling[i] = babbling[i].replace("aya", " ");
      babbling[i] = babbling[i].replace("ye", " ");
      babbling[i] = babbling[i].replace("ma", " ");
      babbling[i] = babbling[i].replace("woo", " ");
      babbling[i] = babbling[i].replace(" ", "");

      // (4) 길이가 0인 단어 찾기
      if(babbling[i].length()==0){
        answer++;
      }
    }
    return answer;
  }

  public static int solution1(String[] babbling) { // -> 틀렸음
    int answer = 0;
    // (1) 발음이 가능한 단어 리스트 정의
    String[] poss = new String[]{"aya", "ye", "woo", "ma"};
    // (2) 발음이 불가능한 단어 리스트 정의 ( 연달아 발음 )
    String[] imposs = new String[]{"ayaaya", "yeye", "woowoo", "mama"};

    // (3) 옹알이 배열 순회하면서
    for (String str : babbling) {
      // (4) 현재 옹알이를 temp에 저장
      String temp = str;
      // (5) 발음이 불가능한 리스트에서 같은 단어 찾아 z로 대체
      if (temp.contains(imposs[0])
          || temp.contains(imposs[1])
          || temp.contains(imposs[2])
          || temp.contains(imposs[3]))
        continue;
      // (6) 발음이 가능한 리스트에서 같은 단어 찾아 지우기
      for (String po : poss) {
        temp = temp.replace(po, " ");
      }
      temp = temp.replace(" ", ""); // 이거 한 줄 추가하니까 정답
      // (7) temp의 길이 가 0이면, 발음 가능한 단어
      if (temp.length() == 0) {
        // (8) answer 증가
        answer++;
      }
    }
    return answer;
  }
}
