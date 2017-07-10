package org.zdnuist.plugin.a;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by zd on 2017/7/10.
 */

public class PluginAService extends Service{

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {

    Toast.makeText(this, "plugin a service start", Toast.LENGTH_SHORT).show();

    return super.onStartCommand(intent, flags, startId);
  }
}
