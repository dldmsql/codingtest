package com.company.stage9;

import java.util.Scanner;

public class ex_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i = 0; i < test; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int d = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);

                // case 4 무수히 많은 경우
            if( x1 == x2 && y1==y2 && r1==r2) System.out.println(-1);
                // case 1 한 점에서 만난다.
            else if( d == (r1+r2)*(r1+r2) || d == (r2-r1)*(r2-r1)) System.out.println(1);
                // case 2 두 점에서 만난다.
            else if( d < (r1+r2)*(r1+r2) && d > (r2-r1)*(r2-r1)) System.out.println(2);
                // 만나지 않는다.
            else if ( d > (r1+r2)*(r1+r2) || d < (r2-r1)*(r2-r1)) System.out.println(0);

        }
    }
}
