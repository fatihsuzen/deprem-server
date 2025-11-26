package com.mbridge.msdk.video.dynview.h;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.List;

public final class b {
    public final void a(final View view, long j5) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if (view != null) {
            int f5 = (int) ((float) ak.f(view.getContext().getApplicationContext()));
            if (view.getLayoutParams().width == 0) {
                valueAnimator = ValueAnimator.ofInt(new int[]{0, f5});
            } else {
                valueAnimator = ValueAnimator.ofInt(new int[]{f5, 0});
            }
            valueAnimator.setDuration(j5);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.setLayoutParams(layoutParams);
                }
            });
            if (view.getLayoutParams().width == 0) {
                valueAnimator2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            } else {
                valueAnimator2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            }
            valueAnimator2.setDuration(j5);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    view.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{valueAnimator, valueAnimator2});
            animatorSet.start();
        }
    }

    public final void b(final View view, long j5) {
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(j5).setListener(new Animator.AnimatorListener() {
                public final void onAnimationCancel(Animator animator) {
                    View view = view;
                    if (view != null && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeAllViews();
                    }
                }

                public final void onAnimationEnd(Animator animator) {
                    View view = view;
                    if (view != null && (view instanceof ViewGroup)) {
                        ((ViewGroup) view).removeAllViews();
                    }
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    public final void c(View view, long j5) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(j5);
        }
    }

    private PropertyValuesHolder b(Property property, float f5) {
        float f6 = -2.0f * f5;
        float f7 = f5 * 2.0f;
        return PropertyValuesHolder.ofKeyframe(property, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, f6), Keyframe.ofFloat(0.2f, f6), Keyframe.ofFloat(0.3f, f7), Keyframe.ofFloat(0.4f, f6), Keyframe.ofFloat(0.5f, f7), Keyframe.ofFloat(0.6f, f6), Keyframe.ofFloat(0.7f, f7), Keyframe.ofFloat(0.8f, f6), Keyframe.ofFloat(0.9f, f7), Keyframe.ofFloat(1.0f, 0.0f)});
    }

    private PropertyValuesHolder c(Property property, float f5) {
        float f6 = f5 - 0.4f;
        return PropertyValuesHolder.ofKeyframe(property, new Keyframe[]{Keyframe.ofFloat(0.0f, f5), Keyframe.ofFloat(0.1f, f6), Keyframe.ofFloat(0.2f, f6), Keyframe.ofFloat(0.3f, f5), Keyframe.ofFloat(0.4f, f5), Keyframe.ofFloat(0.5f, f5), Keyframe.ofFloat(0.6f, f5), Keyframe.ofFloat(0.7f, f5), Keyframe.ofFloat(0.8f, f5), Keyframe.ofFloat(0.9f, f5), Keyframe.ofFloat(1.0f, f5)});
    }

    public final void a(final List<View> list, int i5, int i6, long j5) {
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{i5, i6}).setDuration(j5);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                List list = list;
                if (list != null && list.size() > 0) {
                    for (View view : list) {
                        if (view != null) {
                            view.setPadding(0, 0, 0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                            view.requestLayout();
                        }
                    }
                }
            }
        });
        duration.start();
    }

    public final ObjectAnimator b(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{c(View.SCALE_X, 1.0f), c(View.SCALE_Y, 1.0f)}).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final ObjectAnimator c(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{b(View.ROTATION, 2.0f)}).setDuration(1000);
        duration.setRepeatCount(-1);
        return duration;
    }

    public final void a(final View view, int i5, int i6, int i7, int i8, long j5) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i5, i6});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view = view;
                if (view != null) {
                    view.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                }
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{i7, i8});
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                View view = view;
                if (view != null) {
                    view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    view.requestLayout();
                    if (view.getVisibility() != 0) {
                        view.setVisibility(0);
                    }
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2});
        animatorSet.setDuration(j5);
        animatorSet.start();
    }

    private PropertyValuesHolder a(Property property, float f5) {
        float f6 = f5 - 0.2f;
        float f7 = f5 + 0.3f;
        return PropertyValuesHolder.ofKeyframe(property, new Keyframe[]{Keyframe.ofFloat(0.0f, f5), Keyframe.ofFloat(0.1f, f5 - 0.4f), Keyframe.ofFloat(0.2f, f6), Keyframe.ofFloat(0.3f, f7), Keyframe.ofFloat(0.4f, f6), Keyframe.ofFloat(0.5f, f7), Keyframe.ofFloat(0.6f, f5 - 0.1f), Keyframe.ofFloat(0.7f, f7), Keyframe.ofFloat(0.8f, f5), Keyframe.ofFloat(0.9f, 0.1f + f5), Keyframe.ofFloat(1.0f, f5)});
    }

    public final ObjectAnimator a(View view) {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{a(View.SCALE_X, 1.0f), a(View.SCALE_Y, 1.0f), b(View.ROTATION_X, 5.0f)}).setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        duration.setRepeatCount(-1);
        return duration;
    }
}
