package com.mojtaba_shafaei.androidTextView;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.mojtaba_shafaei.persianFont.PersianFont;

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
        if (!isInEditMode()) {
            //setLineSpacing(1.5f, 1f);
            setTextIsSelectable(false);
        }
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
            Integer typeFace = a.getInteger(R.styleable.TextView_fontType, PersianFont.IRANSANS_NORMAL);
            setTypeface(PersianFont.get(context, typeFace));

            showNumberAsPersian = a.getBoolean(R.styleable.TextView_showDigitAsPersian, false);
            if (showNumberAsPersian) {
                setText(Persian.format(getText().toString()));
            }
        } finally {
            a.recycle();
        }
    }

}
