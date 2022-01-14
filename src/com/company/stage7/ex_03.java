package com.company.stage7;

import java.util.Scanner;

public class ex_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split("");
        char[] c = new char[26];
        int[] result = new int[26];
        for(int i =0; i< 26; i++){
            c[i] = ((char)('a'+ i ));
            result[i] = -1;
        }
        // 중복 단어 위치 제거하기
        for(int i = 0; i<ss.length; i++){
            for(int j =0; j<c.length; j++){
                if(ss[i].equals(String.valueOf(c[j])))
                    if(result[j] == -1)
                        result[j] = i;
            }
        }
        for(Integer val : result){
            System.out.print(val + " ");
        }
    }
}
