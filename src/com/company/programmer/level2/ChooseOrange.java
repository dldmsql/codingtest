package com.company.programmer.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ChooseOrange {

  public static void main(String[] args) {
    System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
  }
    public static int solution(int k, int[] tangerine) {
      int answer = 0;
      // (1) 귤 사이즈별 개수를 저장하기 위해 map 사용
      HashMap<Integer, Integer> map = new HashMap<>();
      // (2) 판매하고자 하는 귤 리스트의 길이만큼 순회
      for (int i = 0; i < tangerine.length; i++) {
        // (3) 귤 사이즈를 key로 하고, 그 개수를 value로 한다.
        map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) +1);
      }

      // (4) key에 대해 별도의 리스트로 정의
      List<Integer> keyList = new ArrayList<>(map.keySet());

      // (5) value에 대해 내림차순 정렬
      keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));

      // (6) k를 충족할 때까지 순회
      int i = 0;
      while ( k > 0 ) {
        // (7) map에서 앞선 내림차순 정렬된 key 값을 가져와 검색하여 해당하는 value 만큼 k에서 차감
        k -= map.get(keyList.get(i));
        i++;
        // (8) 종류의 수 증가
        answer++;
      }
      return answer;
    }
    public static int solution1(int k, int[] tangerine) { // 실패 - 런타임 에러
    int answer = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < tangerine.length; i++) {
      map.put(tangerine[i], map.getOrDefault(tangerine[i], 1) + 1);
    }
    List<Entry> a = map.entrySet().stream().sorted(Map.Entry.comparingByValue( (o1, o2) -> o2 - o1))
        .collect(Collectors.toList());

    for (Map.Entry<Integer, Integer> e : a) {
      if (k < 0) {
        break;
      }
      k -= e.getValue();
      answer++;
    }
    return answer;
  }
}
