package com.mojtaba_shafaei.androidTextView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.mojtaba_shafaei.persianFont.PersianFont;
import com.mojtaba_shafaei.persianFont.PersianFont.FontEnum;

public class TextView extends AppCompatTextView {

private volatile boolean showNumberAsPersian = false;

public TextView(Context context) {
  super(context);
  init(context);
}

public TextView(Context context, AttributeSet attrs) {
  super(context, attrs);
  init(context);
  readAttrs(context, attrs);
}

public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
  super(context, attrs, defStyleAttr);
  init(context);
  readAttrs(context, attrs);
}

private void init(Context context) {
}

@Override
public void setText(CharSequence text, BufferType type) {
  if (showNumberAsPersian) {
    text = Persian.format(text.toString());
  }
  super.setText(text, type);
}

public void setTextWithAnimation(final CharSequence text, ObjectAnimator... animators) {
  AnimatorSet animatorSet = new AnimatorSet();
  animatorSet.setDuration(500);

  if (animators == null || animators.length == 0) {
    animators = new ObjectAnimator[2];
    animators[0] = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f);
    animators[0].addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        setText("");
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animators[1] = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f);
    animators[1].addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {
        setText(text);
      }

      @Override
      public void onAnimationEnd(Animator animator) {
        setAlpha(1f);
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
  }
  animatorSet.playSequentially(animators);
  animatorSet.start();
}

private void readAttrs(Context context, AttributeSet attrs) {
  TypedArray a = context.getTheme().obtainStyledAttributes(
    attrs,
    R.styleable.TextView,
    0, 0);

  try {
    int typeFace = 3;
    if (a.hasValue(R.styleable.TextView_fontType)) {
      typeFace = a.getInteger(R.styleable.TextView_fontType, 3);//iransans normal
    }

    FontEnum lvFontEnum = FontEnum.IRANSANS_NORMAL;
    switch (typeFace) {
      case 1:
        lvFontEnum = FontEnum.IRAN_SANS_ULTRA_LIGHT;
        break;
      case 2:
        lvFontEnum = FontEnum.IRANSANS_LIGHT;
        break;
      case 3:
        lvFontEnum = FontEnum.IRANSANS_NORMAL;
        break;
      case 4:
        lvFontEnum = FontEnum.IRANSANS_MEDIUM;
        break;
      case 5:
        lvFontEnum = FontEnum.IRANSANS_BOLD;
        break;
      case 6:
        lvFontEnum = FontEnum.IRANSANS_BLACK;
        break;

      case 10:
        lvFontEnum = FontEnum.YEKAN_REGULAR;
        break;
      case 11:
        lvFontEnum = FontEnum.YEKAN_LIGHT;
        break;
      case 12:
        lvFontEnum = FontEnum.YEKAN_BOLD;
        break;
      case 13:
        lvFontEnum = FontEnum.YEKAN_BLACK;
        break;
      case 14:
        lvFontEnum = FontEnum.YEKAN_EXTRA_BLACK;
        break;
      case 15:
        lvFontEnum = FontEnum.YEKAN_EXTRA_BOLD;
        break;
      case 16:
        lvFontEnum = FontEnum.YEKAN_MEDIUM;
        break;
      case 17:
        lvFontEnum = FontEnum.YEKAN_THIN;
        break;

    }
    setTypeface(PersianFont.get(context, lvFontEnum));

    showNumberAsPersian = a.getBoolean(R.styleable.TextView_showDigitAsPersian, false);
    if (showNumberAsPersian) {
      setText(Persian.format(getText().toString()));
    }
  } finally {
    a.recycle();
  }
}

}
