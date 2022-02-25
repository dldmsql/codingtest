package com.company.permutation;

import java.util.Scanner;

public class ex_14888 {
    static int N, max, min;
    static int[] arr, operators, order;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for( int i = 0; i < N; i++ ){
            arr[i] = sc.nextInt();
        }
        operators = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
        recursive(1,0);
        System.out.println(sb.toString());
    }
    // order[1 ... N-1 ]에 연산자들이 순서대로 저장될 것이다.
    // k-1 번째 연산자까지 계산한 결과가 value이다.
    static void recursive(int k, int value){
        if( k == N ){
            // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // value를 정답에 갱신하기


        } else {
            // k번째 연산자는 무엇을 선택할 것인가

            // 4 가지의 연산자들 중에 뭘 쓸 지 선택하고 재귀호출하기
        }
    }
}
