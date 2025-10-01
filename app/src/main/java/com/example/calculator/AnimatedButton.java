package com.example.calculator;

import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class AnimatedButton {

    public static void applyAnimation(Button button) {
        button.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case android.view.MotionEvent.ACTION_DOWN:
                    scaleButton(v, 1.0f, 0.9f); // уменьшаем при нажатии
                    break;
                case android.view.MotionEvent.ACTION_UP:
                case android.view.MotionEvent.ACTION_CANCEL:
                    scaleButton(v, 0.9f, 1.0f); // возвращаем размер
                    break;
            }
            return false; // чтобы onClick срабатывал
        });
    }

    private static void scaleButton(View view, float from, float to) {
        ScaleAnimation anim = new ScaleAnimation(
                from, to,
                from, to,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        anim.setDuration(100);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }
}
