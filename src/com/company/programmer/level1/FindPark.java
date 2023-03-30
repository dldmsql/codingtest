package com.company.programmer.level1;

public class FindPark {

  public static void main(String[] args) {
    String[] park = new String[] {"SOO","OOO","OOO"};
    String[] routes = new String[] {"E 2","S 2","W 1"};
    System.out.println(solution(park, routes));
  }
  public static int[] solution(String[] park, String[] routes) {

    // 필요한 변수 초기화
    int startX = 0;
    int startY = 0;
    int h = park.length;
    int w = park[0].length();

    // 시작 좌표 찾기
    char[][] map = new char[h][w];
    for(int i = 0; i < h; i++) {
      for(int j = 0; j < w; j++) {
        char[] s = park[i].toCharArray();
        map[i][j] = s[j];

        if(map[i][j] == 'S') {
          startX = j;
          startY = i;
        }
      }
    }

    // 루트 이동을 위한 방향과 이동 칸 수 구하기
    for(String r : routes) {
      String direction = r.split(" ")[0];
      int move = Integer.parseInt(r.split(" ")[1]);

      switch(direction) {
        case "N" :
          if(startY - move >= 0) {
            startY = moveVertical(direction, startX, move, map, startY);
          }
          break;
        case "S" :
          if(startY + move < h) {
            startY = moveVertical(direction, startX, move, map, startY);
          }
          break;
        case "E" :
          if(startX + move < w) {
            startX = moveHorizontal(direction, startX, move, map, startY);
          }
          break;
        case "W" :
          if(startX - move >= 0) {
            startX = moveHorizontal(direction, startX, move, map, startY);

          }
          break;
        default :
          break;
      }
    }

    return new int[] {startX, startY};
  }

  private static int moveHorizontal(String direction, int startX, int move, char[][] map, int startY) {
    int tmpX = startX;

    if(direction.equals("E")) {
      for(int i = 0; i < move; i++) {
        startX++;

        if(map[startY][startX] == 'X') {
          startX = tmpX;
          break;
        }
      }
    } else {
      for(int i =0; i < move; i++) {
        startX--;

        if(map[startY][startX] == 'X') {
          startX = tmpX;
          break;
        }
      }
    }
    return startX;
  }

  private static int moveVertical(String direction, int startX, int move, char[][] map, int startY) {
    int tmpY = startY;

    if(direction.equals("N")) {
      for (int i = 0; i < move; i++) {
        startY--;

        if(map[startY][startX] == 'X') {
          startY = tmpY;
          break;
        }
      }
    } else {
      for(int i = 0; i < move; i++) {
        startY++;

        if(map[startY][startX] == 'X') {
          startY = tmpY;
          break;
        }
      }
    }
    return startY;
  }
}