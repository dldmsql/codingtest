package com.company.permutation;

import java.util.Scanner;

public class ex_9663 {
    static int N, M;
    static int[] col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = 0;
        col = new int[N+1];

        recursive(1);
        System.out.println(M);
    }

    private static void recursive(int row) {
        if( row == N+1 ){
            M++;
        } else {
            for( int i = 1; i <= N; i++ ){
                boolean possible = true;
                for( int j = 1; j <= row-1; j++ ){
                    if( attackable(row, i, j, col[j])){
                        possible = false;
                        break;
                    }
                }
                if( possible ){
                    col[row] = i;
                    recursive(row+1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if( c1 == c2 ) return true;
        else if( r1 - c1 == r2 - c2 ) return true;
        else if( r1 + c1 == r2 + c2 ) return true;
        else return false;
    }
}
