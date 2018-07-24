package com.mojtaba_shafaei.android.androidTextViewExample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.mojtaba_shafaei.androidTextView.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView textView1 = findViewById(R.id.tv1);
    textView1.setText("Hello World!");
    textView1.setCompoundDrawablesWithIntrinsicBounds(
        ContextCompat.getDrawable(this, R.drawable.ic_3d_rotation_black_24dp), null, null, null);
  }
}
