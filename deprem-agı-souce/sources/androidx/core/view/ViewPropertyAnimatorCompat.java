package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    private final WeakReference<View> mView;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float f5) {
            return viewPropertyAnimator.translationZ(f5);
        }

        @DoNotInline
        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float f5) {
            return viewPropertyAnimator.translationZBy(f5);
        }

        @DoNotInline
        static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float f5) {
            return viewPropertyAnimator.z(f5);
        }

        @DoNotInline
        static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float f5) {
            return viewPropertyAnimator.zBy(f5);
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f5);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @Nullable
    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return (Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long j5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long j5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        M m5;
        View view = this.mView.get();
        if (view != null) {
            if (viewPropertyAnimatorUpdateListener != null) {
                m5 = new M(viewPropertyAnimatorUpdateListener, view);
            } else {
                m5 = null;
            }
            view.animate().setUpdateListener(m5);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float f5) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZ(view.animate(), f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZBy(view.animate(), f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    @NonNull
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float f5) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.z(view.animate(), f5);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float f5) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.zBy(view.animate(), f5);
        }
        return this;
    }
}
