package com.company.permutation;

import java.util.Scanner;

public class ex_1182 {
    static int N, S, cnt;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        cnt = 0;
        arr = new int[N+1];
        for(int i = 1; i<= N; i++){
            arr[i] = sc.nextInt();
        }

        recursive(1,0);
        if( S == 0 ){
            cnt--;
        }
        System.out.println(cnt);
    }
    // k번째 원소를 포함시킬 지 정하는 함수
    //  value = k-1 번째 원소까지 골라진 원소들의 합
    private static void recursive(int k, int value) {
        if( k == N+1 ){
            // value가 S랑 같은지 확인
            if( value == S ){
                cnt++;
                return;
            }
        }else {
            // k번째 원소를 포함시킬 지 결정하고 재귀호출
            recursive(k+1, value+ arr[k]);
            recursive( k+1, value);
        }
    }
}
