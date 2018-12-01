package com.mojtaba_shafaei.android.androidTextViewExample;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.mojtaba_shafaei.androidTextView.TextView;

public class MainActivity extends AppCompatActivity{

@Override
protected void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  TextView textView1 = findViewById(R.id.tv1);
  textView1.setText("Hello World!");
  textView1.setCompoundDrawablesWithIntrinsicBounds(
      ContextCompat.getDrawable(this, R.drawable.ic_3d_rotation_black_24dp), null, null, null);
}
}
