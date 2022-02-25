package com.company.permutation;

import java.util.Scanner;

public class ex_15652 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // M개 선택된 수를 담는 배열
        arr = new int[M+1];

        recursive(1);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if( k == M+1 ){
            for(int i =1; i <= M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
        }else {
            int start = arr[k-1];
            if( start == 0) start = 1;
            for( int i = start; i<= N; i++){
                arr[k] = i;
                // 재귀호출할 때마다 오름차순으로 탐색한다.
                recursive(k+1);
                arr[k] = 0;
            }
        }
    }
}
