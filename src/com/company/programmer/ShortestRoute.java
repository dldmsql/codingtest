package com.company.programmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestRoute {

  public static void main(String[] args) {
    int n = 3;
    int[][] roads = {{1, 2}, {2, 3}};
    int[] sources = {2, 3};
    int destination = 1;
    System.out.println(solution(n, roads, sources, destination));
  }

  static boolean[] visited;

  public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = new int[sources.length];

    /*
     * n : 강철부대가 위치한 지역을 포함한 총 지역의 수
     * roads : 두 지역을 왕복할 수 있는 길 정보
     *       원소 길이 2
     *       동일 정보가 중복해서 주어지지 않음
     * sources : 각 부대원이 위치한 서로 다른 지역
     * destination : 강철 부대의 지역
     * answer : 복귀 가능한 부대원의 최단 시간을 구할 것.
     *   단, 복귀 불가능한 경우 해당 부대원의 최단 시간은 -1
     * */
    List<List<Integer>> nodeList = makeNode(n, roads); // 노드 연결하기

    for (int i = 0; i < sources.length; i++) { // 각 부대원 별로
      if (sources[i] == destination) { // 출발지가 곧 도착지라면
        answer[i] = 0; // 거리가 0
        continue;
      }

      if (nodeList.get(sources[i]).isEmpty()) { // 출발지가 노드 리스트에 존재하지 않는다면
        answer[i] = -1; // 거리 -1
        continue;
      }

      visited = new boolean[n + 1]; // 방문 확인용

      answer[i] = bfs(sources[i], destination, nodeList); // 위의 케이스를 제외하고 나머지의 경우
    }
    return answer;
  }

  private static int bfs(int start, int destination, List<List<Integer>> nodeList) {

    List<Integer> regions; // 각 지역과 연결된 다른 지역 리스트
    Queue<Integer> q = new LinkedList<>();
    int count = 1; // 거리 계산용 ( 기본 거리가 1이다.)

    q.add(start); // 출발지를 큐에 삽입
    visited[start] = true; // 방문 표시

    while (!q.isEmpty()) { // 큐에 값이 존재하면

      regions = nodeList.get(q.poll()); // 출발지 기준 연결된 지역 리스트 불러오기

      for (int j = 0; j < regions.size(); j++) { // 지역 리스트 순회
        int next = regions.get(j); // 가장 먼저 연결된 지역 불러오기

        if (!visited[next]) { // 방문하지 않았던 지역이라면
          if (next == destination) { // 그 지역이 도착지라면
            return count; // 카운트 값 반환
          }
          q.add(next); // 큐에 넣어주기
          visited[next] = true; // 방문 표시
        }

      }
      count++; // 큐를 다 돌고 난 뒤, while 문 탈출을 안했다면 다음 지역으로 넘어가야 하니까 거리 1 증가
    }
    return -1;
  }

  private static List<List<Integer>> makeNode(int n, int[][] roads) {
    List<List<Integer>> nodes = new ArrayList<>(); // 노드를 모두 연결한 리스트
    List<Integer> temp;

    for (int i = 0; i <= n; i++) {
      nodes.add(new ArrayList<>()); // 각 지역 마다 초기화한 리스트를 갖도록 한다.
    }

    for (int i = 0; i < roads.length; i++) { // 루트별로
      int start = roads[i][0]; // 시작지
      int end = roads[i][1]; // 도착지

      temp = nodes.get(start); // 시작지 지역의 리스트를 불러온다.

      if (!temp.contains(end)) { // 시작지 지역 리스트에 도착지 값이 없다면
        temp.add(end); // 넣어준다.
      }

      temp = nodes.get(end); // 도착지 지역의 리스트를 불러온다.

      if (!temp.contains(start)) { // 도착지 지역의 리스트에 출발지 값이 없다면
        temp.add(start); // 넣어준다.
      }

    }
    return nodes;
  }

}
