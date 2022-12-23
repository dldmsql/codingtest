package com.company.programmer.past;

import java.util.Calendar;
import java.util.Locale;

public class Yearof2016 {
  public String solution(int a, int b) {
//    String answer = "";
    Calendar cal = new Calendar.Builder().setDate(2016, a-1, b).build();
    return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
  }
}
