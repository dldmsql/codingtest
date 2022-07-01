package com.company.stage12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_10815 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i =0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());

      if(binarySearch(arr, num))
        bw.write("1 " );
      else
        bw.write("0 ");
    }
    bw.close();
    br.close();
  }

  private static boolean binarySearch(int[] arr, int num) {
    int left = 0;
    int right = arr.length-1;

    while(left <= right) {
      int mid = (left+right)/2;
      if(num < arr[mid]) right = mid -1;
      else if(num > arr[mid]) left = mid + 1;
      else return true;
    }
    return false;
  }
}
