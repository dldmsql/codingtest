package com.company.permutation;

import java.util.Scanner;

public class ex_14888 {
    static int N, max, min;
    static int[] arr, operators;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        operators = new int[5];

        for(int i = 1; i<= N; i++) arr[i] = sc.nextInt();

        for(int i =1; i<=4; i++) operators[i] = sc.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        recursive(1, arr[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    private static void recursive(int k, int value) {
        if( k == N ){
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else{
            for(int i = 1; i<=4; i++){
                if( operators[i] > 0){
                    operators[i]--;
                    recursive(k+1, calculator(value, i, arr[k+1]));
                    operators[i]++;
                }
            }
        }
    }

    private static int calculator(int operand1, int operator, int operand2) {
        if( operator == 1)
            return operand1 + operand2;
        else if( operator == 2 )
            return operand1 - operand2;
        else if( operator == 3 )
            return operand1 * operand2;
        else
            return operand1 / operand2;
    }
}
