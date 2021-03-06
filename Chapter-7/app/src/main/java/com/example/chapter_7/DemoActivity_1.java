package com.example.chapter_7;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DemoActivity_1 extends Activity {

    private static final String TAG = "DemoActivity_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_1);
        initView();
    }

    private void initView(){}

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Button button = (Button) findViewById(R.id.button1);
            performAnimate(button, button.getWidth(), 500);
        }
    }

    private void performAnimate(final View target, final int start, final int end){
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            // 持有一个IntEvaluator对象，方便下面估值的时候使用
            private IntEvaluator mEvaluator = new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 获得当前动画的进度值，整型，1-100之间
                int currentValue = (Integer) valueAnimator.getAnimatedValue();
                Log.d(TAG, "current value: " + currentValue);

                // 获得当前进度占整个动画过程的比例，浮点型，0-1之间
                float fraction = valueAnimator.getAnimatedFraction();
                // 直接调用整型估值器通过比例计算出宽度，然后再设给Button
                target.getLayoutParams().width = mEvaluator.evaluate(fraction, start, end);
                target.requestLayout();
            }
        });

        valueAnimator.setDuration(5000).start();
    }
}
