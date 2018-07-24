package com.mojtaba_shafaei.android.androidTextViewExample;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    MultiDex.install(this);
  }
}
