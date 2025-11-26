package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;

public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private static final RectEvaluator sRectEvaluator = new RectEvaluator();
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private boolean mResizeClip = false;

    private static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        ClipListener(View view, Rect rect, boolean z4, Rect rect2, boolean z5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.mView = view;
            this.mStartClip = rect;
            this.mStartClipIsNull = z4;
            this.mEndClip = rect2;
            this.mEndClipIsNull = z5;
            this.mStartLeft = i5;
            this.mStartTop = i6;
            this.mStartRight = i7;
            this.mStartBottom = i8;
            this.mEndLeft = i9;
            this.mEndTop = i10;
            this.mEndRight = i11;
            this.mEndBottom = i12;
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        public void onTransitionCancel(@NonNull Transition transition) {
            this.mIsCanceled = true;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
        }

        public void onTransitionPause(@NonNull Transition transition) {
            Rect rect;
            this.mView.setTag(R.id.transition_clip, this.mView.getClipBounds());
            if (this.mEndClipIsNull) {
                rect = null;
            } else {
                rect = this.mEndClip;
            }
            this.mView.setClipBounds(rect);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            View view = this.mView;
            int i5 = R.id.transition_clip;
            this.mView.setTag(i5, (Object) null);
            this.mView.setClipBounds((Rect) view.getTag(i5));
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator, boolean z4) {
            if (!this.mIsCanceled) {
                Rect rect = null;
                if (z4) {
                    if (!this.mStartClipIsNull) {
                        rect = this.mStartClip;
                    }
                } else if (!this.mEndClipIsNull) {
                    rect = this.mEndClip;
                }
                this.mView.setClipBounds(rect);
                if (z4) {
                    ViewUtils.setLeftTopRightBottom(this.mView, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
                } else {
                    ViewUtils.setLeftTopRightBottom(this.mView, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
                }
            }
        }

        public void onAnimationStart(Animator animator, boolean z4) {
            int max = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int max2 = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            int i5 = z4 ? this.mEndLeft : this.mStartLeft;
            int i6 = z4 ? this.mEndTop : this.mStartTop;
            ViewUtils.setLeftTopRightBottom(this.mView, i5, i6, max + i5, max2 + i6);
            this.mView.setClipBounds(z4 ? this.mEndClip : this.mStartClip);
        }

        public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
            e.a(this, transition, z4);
        }

        public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
            e.b(this, transition, z4);
        }
    }

    private static class SuppressLayoutListener extends TransitionListenerAdapter {
        boolean mCanceled = false;
        final ViewGroup mParent;

        SuppressLayoutListener(@NonNull ViewGroup viewGroup) {
            this.mParent = viewGroup;
        }

        public void onTransitionCancel(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        /* access modifiers changed from: package-private */
        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i5 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i5;
            if (this.mTopLeftCalls == i5) {
                setLeftTopRightBottom();
            }
        }

        /* access modifiers changed from: package-private */
        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i5 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i5;
            if (i5 == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(cls, "topLeft") {
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setTopLeft(pointF);
            }
        };
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(cls, "bottomRight") {
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setBottomRight(pointF);
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(cls, "bottomRight") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(cls, "topLeft") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(cls, "position") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    public ChangeBounds() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, view.getClipBounds());
            }
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Rect rect;
        captureValues(transitionValues);
        if (this.mResizeClip && (rect = (Rect) transitionValues.view.getTag(R.id.transition_clip)) != null) {
            transitionValues.values.put(PROPNAME_CLIP, rect);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup r23, @androidx.annotation.Nullable androidx.transition.TransitionValues r24, @androidx.annotation.Nullable androidx.transition.TransitionValues r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r2 = r25
            if (r1 == 0) goto L_0x000a
            if (r2 != 0) goto L_0x000e
        L_0x000a:
            r23 = 0
            goto L_0x01e5
        L_0x000e:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.values
            java.util.Map<java.lang.String, java.lang.Object> r5 = r2.values
            java.lang.String r6 = "android:changeBounds:parent"
            java.lang.Object r4 = r4.get(r6)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            java.lang.Object r5 = r5.get(r6)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            if (r4 == 0) goto L_0x0024
            if (r5 != 0) goto L_0x0028
        L_0x0024:
            r23 = 0
            goto L_0x01e5
        L_0x0028:
            android.view.View r7 = r2.view
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.values
            java.lang.String r5 = "android:changeBounds:bounds"
            java.lang.Object r4 = r4.get(r5)
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            java.util.Map<java.lang.String, java.lang.Object> r6 = r2.values
            java.lang.Object r5 = r6.get(r5)
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            int r12 = r4.left
            int r6 = r5.left
            int r13 = r4.top
            int r8 = r5.top
            int r14 = r4.right
            int r9 = r5.right
            int r15 = r4.bottom
            int r4 = r5.bottom
            int r5 = r14 - r12
            int r10 = r15 - r13
            int r11 = r9 - r6
            r23 = 0
            int r3 = r4 - r8
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.values
            r16 = r3
            java.lang.String r3 = "android:changeBounds:clip"
            java.lang.Object r1 = r1.get(r3)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.values
            java.lang.Object r2 = r2.get(r3)
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            r24 = 1
            if (r5 == 0) goto L_0x0070
            if (r10 != 0) goto L_0x0074
        L_0x0070:
            if (r11 == 0) goto L_0x0085
            if (r16 == 0) goto L_0x0085
        L_0x0074:
            if (r12 != r6) goto L_0x007c
            if (r13 == r8) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            r17 = 0
            goto L_0x007e
        L_0x007c:
            r17 = r24
        L_0x007e:
            if (r14 != r9) goto L_0x0082
            if (r15 == r4) goto L_0x0087
        L_0x0082:
            int r17 = r17 + 1
            goto L_0x0087
        L_0x0085:
            r17 = 0
        L_0x0087:
            if (r1 == 0) goto L_0x008f
            boolean r18 = r1.equals(r2)
            if (r18 == 0) goto L_0x0093
        L_0x008f:
            if (r1 != 0) goto L_0x0095
            if (r2 == 0) goto L_0x0095
        L_0x0093:
            int r17 = r17 + 1
        L_0x0095:
            r3 = r17
            r25 = 0
            if (r3 <= 0) goto L_0x01e5
            r17 = r1
            boolean r1 = r0.mResizeClip
            r18 = r1
            r1 = 2
            if (r18 != 0) goto L_0x0132
            androidx.transition.ViewUtils.setLeftTopRightBottom(r7, r12, r13, r14, r15)
            if (r3 != r1) goto L_0x0105
            if (r5 != r11) goto L_0x00c3
            r3 = r16
            if (r10 != r3) goto L_0x00c3
            androidx.transition.PathMotion r1 = r0.getPathMotion()
            float r2 = (float) r12
            float r3 = (float) r13
            float r4 = (float) r6
            float r5 = (float) r8
            android.graphics.Path r1 = r1.getPath(r2, r3, r4, r5)
            android.util.Property<android.view.View, android.graphics.PointF> r2 = POSITION_PROPERTY
            android.animation.ObjectAnimator r1 = androidx.transition.ObjectAnimatorUtils.ofPointF(r7, r2, r1)
            goto L_0x01c5
        L_0x00c3:
            androidx.transition.ChangeBounds$ViewBounds r2 = new androidx.transition.ChangeBounds$ViewBounds
            r2.<init>(r7)
            androidx.transition.PathMotion r3 = r0.getPathMotion()
            float r5 = (float) r12
            float r10 = (float) r13
            float r6 = (float) r6
            float r8 = (float) r8
            android.graphics.Path r3 = r3.getPath(r5, r10, r6, r8)
            android.util.Property<androidx.transition.ChangeBounds$ViewBounds, android.graphics.PointF> r5 = TOP_LEFT_PROPERTY
            android.animation.ObjectAnimator r3 = androidx.transition.ObjectAnimatorUtils.ofPointF(r2, r5, r3)
            androidx.transition.PathMotion r5 = r0.getPathMotion()
            float r6 = (float) r14
            float r8 = (float) r15
            float r9 = (float) r9
            float r4 = (float) r4
            android.graphics.Path r4 = r5.getPath(r6, r8, r9, r4)
            android.util.Property<androidx.transition.ChangeBounds$ViewBounds, android.graphics.PointF> r5 = BOTTOM_RIGHT_PROPERTY
            android.animation.ObjectAnimator r4 = androidx.transition.ObjectAnimatorUtils.ofPointF(r2, r5, r4)
            android.animation.AnimatorSet r5 = new android.animation.AnimatorSet
            r5.<init>()
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            r1[r25] = r3
            r1[r24] = r4
            r5.playTogether(r1)
            androidx.transition.ChangeBounds$6 r1 = new androidx.transition.ChangeBounds$6
            r1.<init>(r2)
            r5.addListener(r1)
            r1 = r5
            goto L_0x01c5
        L_0x0105:
            if (r12 != r6) goto L_0x011e
            if (r13 == r8) goto L_0x010a
            goto L_0x011e
        L_0x010a:
            androidx.transition.PathMotion r1 = r0.getPathMotion()
            float r2 = (float) r14
            float r3 = (float) r15
            float r5 = (float) r9
            float r4 = (float) r4
            android.graphics.Path r1 = r1.getPath(r2, r3, r5, r4)
            android.util.Property<android.view.View, android.graphics.PointF> r2 = BOTTOM_RIGHT_ONLY_PROPERTY
            android.animation.ObjectAnimator r1 = androidx.transition.ObjectAnimatorUtils.ofPointF(r7, r2, r1)
            goto L_0x01c5
        L_0x011e:
            androidx.transition.PathMotion r1 = r0.getPathMotion()
            float r2 = (float) r12
            float r3 = (float) r13
            float r4 = (float) r6
            float r5 = (float) r8
            android.graphics.Path r1 = r1.getPath(r2, r3, r4, r5)
            android.util.Property<android.view.View, android.graphics.PointF> r2 = TOP_LEFT_ONLY_PROPERTY
            android.animation.ObjectAnimator r1 = androidx.transition.ObjectAnimatorUtils.ofPointF(r7, r2, r1)
            goto L_0x01c5
        L_0x0132:
            r3 = r16
            int r16 = java.lang.Math.max(r5, r11)
            int r18 = java.lang.Math.max(r10, r3)
            int r1 = r12 + r16
            r16 = r2
            int r2 = r13 + r18
            androidx.transition.ViewUtils.setLeftTopRightBottom(r7, r12, r13, r1, r2)
            if (r12 != r6) goto L_0x0153
            if (r13 == r8) goto L_0x014a
            goto L_0x0153
        L_0x014a:
            r1 = r23
            r18 = r4
            r21 = r6
            r20 = r9
            goto L_0x016b
        L_0x0153:
            androidx.transition.PathMotion r1 = r0.getPathMotion()
            float r2 = (float) r12
            r18 = r4
            float r4 = (float) r13
            r20 = r9
            float r9 = (float) r6
            r21 = r6
            float r6 = (float) r8
            android.graphics.Path r1 = r1.getPath(r2, r4, r9, r6)
            android.util.Property<android.view.View, android.graphics.PointF> r2 = POSITION_PROPERTY
            android.animation.ObjectAnimator r1 = androidx.transition.ObjectAnimatorUtils.ofPointF(r7, r2, r1)
        L_0x016b:
            if (r17 != 0) goto L_0x0170
            r9 = r24
            goto L_0x0172
        L_0x0170:
            r9 = r25
        L_0x0172:
            if (r9 == 0) goto L_0x017c
            android.graphics.Rect r2 = new android.graphics.Rect
            r4 = r25
            r2.<init>(r4, r4, r5, r10)
            goto L_0x0180
        L_0x017c:
            r4 = r25
            r2 = r17
        L_0x0180:
            if (r16 != 0) goto L_0x0185
            r5 = r24
            goto L_0x0186
        L_0x0185:
            r5 = r4
        L_0x0186:
            if (r5 == 0) goto L_0x018f
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>(r4, r4, r11, r3)
            r10 = r6
            goto L_0x0191
        L_0x018f:
            r10 = r16
        L_0x0191:
            boolean r3 = r2.equals(r10)
            if (r3 != 0) goto L_0x01bf
            r7.setClipBounds(r2)
            androidx.transition.RectEvaluator r3 = sRectEvaluator
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r4] = r2
            r6[r24] = r10
            java.lang.String r4 = "clipBounds"
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofObject(r7, r4, r3, r6)
            androidx.transition.ChangeBounds$ClipListener r6 = new androidx.transition.ChangeBounds$ClipListener
            r11 = r5
            r17 = r8
            r19 = r18
            r18 = r20
            r16 = r21
            r8 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r3.addListener(r6)
            r0.addListener(r6)
            goto L_0x01c1
        L_0x01bf:
            r3 = r23
        L_0x01c1:
            android.animation.Animator r1 = androidx.transition.TransitionUtils.mergeAnimators(r1, r3)
        L_0x01c5:
            android.view.ViewParent r2 = r7.getParent()
            boolean r2 = r2 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x01e4
            android.view.ViewParent r2 = r7.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r3 = r24
            androidx.transition.ViewGroupUtils.suppressLayout(r2, r3)
            androidx.transition.Transition r3 = r0.getRootTransition()
            androidx.transition.ChangeBounds$SuppressLayoutListener r4 = new androidx.transition.ChangeBounds$SuppressLayoutListener
            r4.<init>(r2)
            r3.addListener(r4)
        L_0x01e4:
            return r1
        L_0x01e5:
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return true;
    }

    public void setResizeClip(boolean z4) {
        this.mResizeClip = z4;
    }

    public ChangeBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
