package com.company.stage5;

import java.util.Scanner;

public class ex_05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] score = new int[size];

        String inputs = sc.nextLine();
        for(int i = 0; i < size; i++){
            score[i] = Integer.parseInt(inputs.split(" ")[i]);
        }
        for(int j =0; j < size-1 ; j++){
            int temp = score[j];
            if(score[j] > score[j+1]) {
                score[j] = score[j+1];
                score[j+1] = temp;
            }
        }

        int max = score[size-1];
        double sum = 0;

        for(int i =0; i< size; i++){
            sum += score[i];
        }
        sum = sum/max*100;
        System.out.println((sum)/size);
    }
}
