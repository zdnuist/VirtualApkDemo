package org.zdnuist.v.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.didi.virtualapk.PluginManager;
import org.zdnuist.library.a.CrashHandler;

/**
 * Created by zd on 2017/7/5.
 */

public class VApplication extends Application {

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);

    long start = System.currentTimeMillis();
    PluginManager.getInstance(base).init();
    Log.d("zd", "use time:" + (System.currentTimeMillis() - start));

  }

  @Override
  public void onCreate() {
    super.onCreate();

    CrashHandler.getInstance().init(this);
  }
}
