package com.company.stage7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_09 { // 틀렸어
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] ss = s.toCharArray();
        int cnt =0;
        for( int i =1; i< ss.length+1; i++){
            switch (ss[i-1]){
                case 'c' :
                    if(i != ss.length && ss[i] == '=' || i != ss.length && ss[i] == '-') {
                    cnt++;
                    i++;
                }else if( i == ss.length){
                        cnt++;
                    }
                    break;
                case 'd' :
                    if(i != ss.length && ss[i] == '-') {
                    cnt++;
                    i++;
                }else if(i != ss.length && ss[i] == 'z' && ss[i+1] == '=') {
                    cnt++;
                    i=i+2;
                } else if( i == ss.length){
                        cnt++;
                    }
                    break;
                case 'l' :
                    if(i != ss.length && ss[i] == 'j') {
                    cnt++;
                    i++;
                }else if( i == ss.length){
                        cnt++;
                    }
                    break;
                case 's' :
                    if(i != ss.length && ss[i] == '=') {
                    cnt++;
                    i++;
                }else if( i == ss.length){
                        cnt++;
                    }
                    break;
                case 'z' :
                    if(i != ss.length && ss[i] == '='){
                    cnt++;
                    i++;
                }  else if( i == ss.length){
                        cnt++;
                    }
                    break;
                default:
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
