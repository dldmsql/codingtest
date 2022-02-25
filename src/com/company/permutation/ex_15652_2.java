package com.company.permutation;

import java.util.Scanner;

public class ex_15652_2 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // M개 선택된 수를 담는 배열
        arr = new int[M+1];

        dfs(1,0);
        System.out.println(sb.toString());
    }

    private static void dfs(int at, int depth) {
        // depth가 M이랑 같을 경우 출력
        if( depth == M ){
            for(int val : arr){
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }
        // 재귀하면서 백트래킹 함.
        // 반복문으로 구현
        // at : 현재 위치. 어디서부터 시작하는지 표시
        // i는 at부터 탐색 시작.
        for( int i = at; i <= N; i++){
            // 현재 depth를 index로 하여 해당 위치에 i 값을 담는다.
            arr[depth] = i;
            // 재귀호출 : 비내림차순이기에 다음 재귀에 i 값을 넘겨 주고, 깊이 또한 1 증가 시킨다.
            dfs(i, depth+1);
        }
    }
}
