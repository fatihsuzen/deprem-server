package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators = new ArrayList<>();
    private long mDuration = -1;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener = new ViewPropertyAnimatorListenerAdapter() {
        private int mProxyEndCount = 0;
        private boolean mProxyStarted = false;

        public void onAnimationEnd(View view) {
            int i5 = this.mProxyEndCount + 1;
            this.mProxyEndCount = i5;
            if (i5 == ViewPropertyAnimatorCompatSet.this.mAnimators.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd((View) null);
                }
                onEnd();
            }
        }

        public void onAnimationStart(View view) {
            if (!this.mProxyStarted) {
                this.mProxyStarted = true;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnd() {
            this.mProxyEndCount = 0;
            this.mProxyStarted = false;
            ViewPropertyAnimatorCompatSet.this.onAnimationsEnded();
        }
    };

    public void cancel() {
        if (this.mIsStarted) {
            ArrayList<ViewPropertyAnimatorCompat> arrayList = this.mAnimators;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = arrayList.get(i5);
                i5++;
                viewPropertyAnimatorCompat.cancel();
            }
            this.mIsStarted = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.mIsStarted) {
            this.mAnimators.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long j5) {
        if (!this.mIsStarted) {
            this.mDuration = j5;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (!this.mIsStarted) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.mIsStarted) {
            this.mListener = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        if (!this.mIsStarted) {
            ArrayList<ViewPropertyAnimatorCompat> arrayList = this.mAnimators;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = arrayList.get(i5);
                i5++;
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
                long j5 = this.mDuration;
                if (j5 >= 0) {
                    viewPropertyAnimatorCompat2.setDuration(j5);
                }
                Interpolator interpolator = this.mInterpolator;
                if (interpolator != null) {
                    viewPropertyAnimatorCompat2.setInterpolator(interpolator);
                }
                if (this.mListener != null) {
                    viewPropertyAnimatorCompat2.setListener(this.mProxyListener);
                }
                viewPropertyAnimatorCompat2.start();
            }
            this.mIsStarted = true;
        }
    }
}
