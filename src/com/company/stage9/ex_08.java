package com.company.stage9;

import java.util.Scanner;

public class ex_08 {
    // 입력으로 주어지는 점들은 같은 값을 갖는 쌍으로 이루어진다. 쌍을 이루지 못한 남은 값이 자연스레 구하고자 하는 값이 된다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // A( x1, y1 ) B( x2, y2 ) C( x3, y3 )
        int[] A = {sc.nextInt(), sc.nextInt()};
        int[] B = {sc.nextInt(), sc.nextInt()};
        int[] C = {sc.nextInt(), sc.nextInt()};

        int x;
        int y;

        if( A[0] == B[0]){
            x = C[0];
        }
        else if( A[0] == C[0]){
            x = B[0];
        }
        else {
            x = A[0];
        }

        if(A[1] == B[1]){
            y = C[1];
        }
        else if(A[1] == C[1]){
            y = B[1];
        }
        else {
            y = A[1];
        }
        System.out.println(x + " " + y);
    }
}
