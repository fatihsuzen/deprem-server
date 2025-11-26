package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TranslationAnimationCreator {

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View view, View view2, int i5, int i6, float f5, float f6) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i5 - Math.round(view.getTranslationX());
            this.mStartY = i6 - Math.round(view.getTranslationY());
            this.mTerminalX = f5;
            this.mTerminalY = f6;
            int i7 = R.id.transitionPosition;
            int[] iArr = (int[]) view2.getTag(i7);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(i7, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(((float) this.mStartX) + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(((float) this.mStartY) + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(R.id.transitionPosition, this.mTransitionPosition);
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    private TranslationAnimationCreator() {
    }

    static Animator createAnimation(View view, TransitionValues transitionValues, int i5, int i6, float f5, float f6, float f7, float f8, TimeInterpolator timeInterpolator, Transition transition) {
        float f9 = f6;
        float translationX = view.getTranslationX();
        float f10 = f7;
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transitionPosition);
        if (iArr != null) {
            f5 = ((float) (iArr[0] - i5)) + translationX;
            f9 = ((float) (iArr[1] - i6)) + translationY;
        }
        int round = i5 + Math.round(f5 - translationX);
        int round2 = i6 + Math.round(f9 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f9);
        if (f5 == f10 && f9 == f8) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f5, f9);
        path.lineTo(f10, f8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        int i7 = round2;
        int i8 = round;
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, i8, i7, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofFloat.addListener(transitionPositionListener);
        ofFloat.addPauseListener(transitionPositionListener);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }
}
