package com.company.devMatching;

import java.math.BigInteger;

public class Solution4 {
  public long solution(int w, int h) {


    int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();

    return ((long) w *h) - (w+h - gcd);
  }
}
