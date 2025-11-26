package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorSetCompat {
    public static void playTogether(@NonNull AnimatorSet animatorSet, @NonNull List<Animator> list) {
        int size = list.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Animator animator = list.get(i5);
            j5 = Math.max(j5, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(j5);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
