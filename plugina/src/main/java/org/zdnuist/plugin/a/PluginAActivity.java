package org.zdnuist.plugin.a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import org.zdnuist.library.a.CommonActivity;
import org.zdnuist.library.a.CommonUtil;

public class PluginAActivity extends AppCompatActivity implements View.OnClickListener{

  private Button btn1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_a);
    Log.e("zd","pluginA");
    Log.e("zd","_name_plugin_a:" + CommonUtil._name);

    initView();

  }

  private void initView(){
    btn1 = (Button) findViewById(R.id.id_plugin_btn1);
    btn1.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.id_plugin_btn1:
        Intent intent = new Intent();
        intent.setClassName("org.zdnuist.v", "org.zdnuist.library.a.CommonActivity");
        startActivity(intent);
        break;
    }
  }
}
