package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_09 { // 인터넷 풀이 참고.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        for(int i= 0; i< s.length(); i++){
            if(s.charAt(i) == 'c'){
                if( i+1 < s.length()){
                if(s.charAt(i+1) == '=' ||  s.charAt(i+1) == '-')
                  i++;
                }
            }else if(s.charAt(i) == 'd'){
                if(i+1 < s.length()) {
                    if (s.charAt(i + 1) == 'z') {
                        if(i+2 < s.length()){
                            if(s.charAt(i + 2) == '=')
                                i = i + 2;
                        }
                    } else if (s.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            } else if(s.charAt(i) == 'l' ) {
                if( i+1 < s.length())  {
                    if(s.charAt(i+1) == 'j')
                    i++;
                }
            }else if( s.charAt(i) == 'n') {
                if( i+1 < s.length())  {
                    if(s.charAt(i+1) == 'j')
                        i++;
                }
            } else if( s.charAt(i) == 's') {
                if( i+1 < s.length())  {
                    if(s.charAt(i+1) == '=')
                        i++;
                }
            }else if( s.charAt(i) == 'z' ) {
                if( i+1 < s.length())  {
                    if(s.charAt(i+1) == '=')
                        i++;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
