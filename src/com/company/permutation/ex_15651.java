package com.company.permutation;

import java.util.Scanner;

public class ex_15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M+1];
        recursive(1);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if( k == M+1 ){
            for(int i = 1; i <= M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++){
                arr[k] = i;
                recursive(k+1);
                arr[k] = 0;
            }
        }
    }
}
