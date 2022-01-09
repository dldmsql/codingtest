package com.company.stage5;

import java.util.Scanner;

public class ex_06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        String[] inputs = new String[size];
        for(int i = 0; i < size; i++){
            inputs[i] = sc.nextLine();
        }
        for (String s : inputs){
            System.out.println(check(s));
        }
    }

    private static int check(String input) {
        char[] inputs = input.toCharArray();
        int scores[] = new int[inputs.length];

        int cnt = 0;
        for (int i =0; i< inputs.length; i++){
            if(String.valueOf(inputs[i]).equals("O")){
                cnt++;
            } else {
                cnt = 0;
            }
            scores[i] = cnt;
        }
        int sum = 0;
        for(Integer sc : scores){
            sum += sc;
        }
        return sum;
    }
}
