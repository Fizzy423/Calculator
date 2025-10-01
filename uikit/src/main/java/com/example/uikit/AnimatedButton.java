package com.example.uikit;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

/**
 * Utility for simple press animation on a Button (or any View).
 */
public class AnimatedButton {
    public static void applyAnimation(final Button button) {
        if (button == null) return;

        final AlphaAnimation anim = new AlphaAnimation(0.7f, 1.0f);
        anim.setDuration(200);
        anim.setFillAfter(true);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.startAnimation(anim);
                }
                return false; // false чтобы onClick продолжил работать
            }
        });
    }
}
