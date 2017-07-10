package org.zdnuist.library.a;

import android.content.Context;

/**
 * Created by zd on 2017/7/10.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

  private static CrashHandler instance;

  private Context context;

  public static CrashHandler getInstance() {
    if (instance == null) {
      instance = new CrashHandler();
    }
    return instance;
  }

  public void init(Context context) {
    this.context = context;
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  @Override
  public void uncaughtException(Thread t, Throwable e) {
    try {
      if (FileUtils.writeThrowableInfoFile(context, FileUtils.SD_CARD_PATH + "/_log_va.txt", e)) {
        // success
      }

      Thread.sleep(2 * 1000);
    } catch (Exception e1) {
      e1.printStackTrace();
    }finally {
      try {
        android.os.Process.killProcess(android.os.Process.myPid());
      }catch (Throwable e1){

      }
      System.exit(1);
    }
  }
}
