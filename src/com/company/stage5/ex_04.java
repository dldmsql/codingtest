package com.company.stage5;

import java.util.ArrayList;
import java.util.Scanner;

public class ex_04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i =0; i < 10; i++){
            int x = Integer.parseInt(sc.nextLine())%42;
            if(!temp.contains(x)) {   temp.add(x); }
        }

        System.out.println(temp.size());
    }
}
