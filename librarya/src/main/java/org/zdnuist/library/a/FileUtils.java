package org.zdnuist.library.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zd on 2017/7/10.
 */

public class FileUtils {

  public static final String SD_CARD_PATH = Environment.getExternalStorageDirectory().getPath();

  public static boolean writeThrowableInfoFile(Context context, String filePath, Throwable th)
      throws IOException {
    File file = new File(filePath);

    if (file.isDirectory() || th == null) {
      // can not write to floder
      return false;
    }
    File dir = new File(file.getParent());
    if (!dir.exists() && !dir.mkdir()) {
      return false;
    }
    if (!file.exists() && !file.createNewFile()) {
      return false;
    }

    StringBuffer sb = new StringBuffer();

    // get device infomation
/*        sb.append("device info:" + android.os.Build.MODEL + "," + android.os.Build.VERSION.SDK_INT + ","
                + android.os.Build.VERSION.RELEASE + "\n");*/
    sb.append("\n------------------------------ " + new SimpleDateFormat("MM-dd HH:mm:ss.SSS")
        .format(new Date(System.currentTimeMillis())) + " ------------------------------\n");

    // get exception
    Writer writer = new StringWriter();
    PrintWriter printWriter = new PrintWriter(writer);
    th.printStackTrace(printWriter);
    Throwable cause = th.getCause();
    while (cause != null) {
      cause.printStackTrace(printWriter);
      cause = cause.getCause();
    }
    printWriter.close();
    String result = writer.toString();
    sb.append(result);

    // write into file
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(file, true);
      fos.write(sb.toString().getBytes());
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      if (fos != null) {
        fos.close();
      }
    }

    return true;
  }
}
