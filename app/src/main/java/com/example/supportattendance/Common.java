package com.example.supportattendance;

import android.animation.ObjectAnimator;
import android.view.View;

public class Common {
    public static void AnimationOnStart(View view, Float Delay) {
        view.setTranslationX(-250f);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", -250f, 0);
        if (Delay < 0.7) {
            animator.setDuration((long) (1 * 1000));
            animator.setStartDelay((long) (Delay * 1000));
        } else if (Delay < 5) {
            animator.setDuration((long) (0.25 * 1000));
            animator.setStartDelay((long) (0 * 1000));
        } else {
            animator.setDuration((long) (0 * 1000));
        }
        animator.start();
    }
}
