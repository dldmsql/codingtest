package com.company.permutation;

import java.util.Scanner;

public class ex_15649_2 {
    static int N, M;
    static int[] arr, used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // arr : M개 선택된 수를 담는 그릇
        // used : 1 ~ N개 중, 중복 제거 용
        arr = new int[M+1];
        used = new int[N+1];
        recursive(1);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if( k == M+1 ){
            for(int i =1; i<=M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++){
                if(used[i] == 1 ) continue;
                    arr[k] = i;
                    used[i] = 1;
                    recursive(k+1);
                    arr[k] = 0;
                    used[i] = 0;

            }
        }
    }
}
