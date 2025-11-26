package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    BrowserActionsFallbackMenuDialog(Context context, View view) {
        super(context);
        this.mContentView = view;
    }

    private void startAnimation(final boolean z4) {
        float f5;
        long j5;
        float f6 = 1.0f;
        if (z4) {
            f5 = 0.0f;
        } else {
            f5 = 1.0f;
        }
        if (!z4) {
            f6 = 0.0f;
        }
        if (z4) {
            j5 = ENTER_ANIMATION_DURATION_MS;
        } else {
            j5 = 150;
        }
        this.mContentView.setScaleX(f5);
        this.mContentView.setScaleY(f5);
        this.mContentView.animate().scaleX(f6).scaleY(f6).setDuration(j5).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z4) {
                    BrowserActionsFallbackMenuDialog.super.dismiss();
                }
            }
        }).start();
    }

    public void dismiss() {
        startAnimation(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        startAnimation(true);
        super.show();
    }
}
