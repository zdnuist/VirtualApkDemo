package org.zdnuist.plugin.a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import org.zdnuist.library.a.CommonUtil;

public class PluginAActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_a);
    Log.e("zd","pluginA");
    Log.e("zd","_name_plugin_a:" + CommonUtil._name);
  }
}
