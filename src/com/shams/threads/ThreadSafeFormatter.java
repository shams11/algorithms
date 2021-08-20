package com.shams.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafeFormatter {


  public static ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal.withInitial(
      () -> new SimpleDateFormat("yyyy-MM-dd"));

}

class UserService {
  public static void main(String[] args) {

  }


  public String birthDate(int userId) {
    Date dob = birthDateFromDB(userId);
    // When the thread calls this method, based on which thread calls this get method,
    // By default, it will get its own copy
    final SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
    return df.format(dob);
  }

  private Date birthDateFromDB(int userId) {
    return new Date();
  }
}
