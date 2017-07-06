package org.zdnuist.v;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.didi.virtualapk.PluginManager;
import java.io.File;
import org.zdnuist.library.a.CommonUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private Button btn1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btn1 = (Button) findViewById(R.id.button);
    btn1.setOnClickListener(this);

    this.loadPlugin(this);
    Log.e("zd","MainActivity");
    CommonUtil._name = "abc";
    Log.e("zd","_name_host:" + CommonUtil._name);
  }


  private void loadPlugin(Context base){
    PluginManager pluginManager = PluginManager.getInstance(base);
    File apk = new File(Environment.getExternalStorageDirectory(), "plugina-release-unsigned.apk");
    if (apk.exists()) {
      try {
        pluginManager.loadPlugin(apk);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.button:
        final String pkg = "org.zdnuist.plugin.a";
        if (PluginManager.getInstance(this).getLoadedPlugin(pkg) == null) {
          Toast.makeText(this, "plugin [org.zdnuist.plugin.a] not loaded", Toast.LENGTH_SHORT).show();
          return;
        }

        // test Activity and Service
        Intent intent = new Intent();
        intent.setClassName(pkg, "org.zdnuist.plugin.a.PluginAActivity");
        startActivity(intent);
        break;
    }
  }
}
