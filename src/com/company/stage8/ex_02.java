package com.company.stage8;

import java.util.Scanner;

public class ex_02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1; // 최소 루트의 개수 = 출력 변수
        int range = 2; // 방이 2개 이상일테니까 range의 시작을 2로 둠

        if(n == 1)
            System.out.println(1);
        else {
            while(range <= n){
                range = range + (6 * cnt); // 2, 8, 20, 38, ...
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
