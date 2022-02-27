package com.company.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class ex_1759 {
    static int N, C;
    static int[] selected;
    static char[] word;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);

        String[] nums = sc.nextLine().split(" ");
        N = Integer.parseInt(nums[0]);
        C = Integer.parseInt(nums[1]);

        selected = new int[N+1];
        word = new char[C+1];

        String[] alpha = sc.nextLine().split(" ");
        for( int i = 1; i <= C; i++){
            word[i] = alpha[i-1].charAt(0);
        }

        Arrays.sort(word, 1, C+1);
        recursive(1);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if( k == N+1 ){
            int vowel = 0, consonant = 0;
            for( int i =1 ; i <= N; i++ ){
                if( isVowel(word[selected[i]])){
                    vowel++;
                }else consonant++;
            }
            if( vowel >= 1 && consonant >= 2){
                for(int i =1; i<= N; i++){
                    sb.append(word[selected[i]]);
                }
                sb.append('\n');
            }
        } else {
            for( int i = selected[k-1] + 1; i <= C; i++ ){
                selected[k] = i;
                recursive(k+1);
                selected[k] = 0;
            }
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
