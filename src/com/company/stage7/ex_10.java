package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ex_10 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int num = sc.nextInt();
        for( int i =0; i< num; i++){
            if(check(sc.next()) == true)
                cnt++;
        }
        System.out.println(cnt);
    }
    public static boolean check(String s){
        boolean[] check = new boolean[26]; // 알파벳 크기만큼 불린 배열 선언
        int already = 0; // 앞의 문자 저장할 변수

        for( int i=0; i< s.length(); i++){
            int now = s.charAt(i); // 현재 문자 저장할 변수
            
            if(already != now){ // 앞의 문자와 달라
                
                if( check[now - 'a'] == false){ 
                    check[now - 'a'] = true; // true로 바꿔
                    already = now;
                }
                else { // 이미 나온 적이 있는 거니까 함수 종료
                    return false;
                }
            }
            else { // 앞의 문자와 연속된 문자
                continue;
            }
        }
        return true;
    }
}
