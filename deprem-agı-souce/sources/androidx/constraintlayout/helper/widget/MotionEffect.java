package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int mFadeMove = -1;
    private float mMotionEffectAlpha = 0.1f;
    private int mMotionEffectEnd = 50;
    private int mMotionEffectStart = 49;
    private boolean mMotionEffectStrictMove = true;
    private int mMotionEffectTranslationX = 0;
    private int mMotionEffectTranslationY = 0;
    private int mViewTransitionId = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i6 = obtainStyledAttributes.getInt(index, this.mMotionEffectStart);
                    this.mMotionEffectStart = i6;
                    this.mMotionEffectStart = Math.max(Math.min(i6, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i7 = obtainStyledAttributes.getInt(index, this.mMotionEffectEnd);
                    this.mMotionEffectEnd = i7;
                    this.mMotionEffectEnd = Math.max(Math.min(i7, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.mMotionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMotionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.mMotionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMotionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.mMotionEffectAlpha = obtainStyledAttributes.getFloat(index, this.mMotionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.mFadeMove = obtainStyledAttributes.getInt(index, this.mFadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.mMotionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.mMotionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.mViewTransitionId = obtainStyledAttributes.getResourceId(index, this.mViewTransitionId);
                }
            }
            int i8 = this.mMotionEffectStart;
            int i9 = this.mMotionEffectEnd;
            if (i8 == i9) {
                if (i8 > 0) {
                    this.mMotionEffectStart = i8 - 1;
                } else {
                    this.mMotionEffectEnd = i9 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0180, code lost:
        if (r14 == 0.0f) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0196, code lost:
        if (r14 == 0.0f) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a7, code lost:
        if (r15 == 0.0f) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b8, code lost:
        if (r15 == 0.0f) goto L_0x015c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            android.view.ViewParent r6 = r0.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            android.view.View[] r6 = r0.getViews(r6)
            if (r6 != 0) goto L_0x0035
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getLoc()
            r1.append(r2)
            java.lang.String r2 = " views = null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FadeMove"
            android.util.Log.v(r2, r1)
            return
        L_0x0035:
            androidx.constraintlayout.motion.widget.KeyAttributes r7 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r7.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            float r9 = r0.mMotionEffectAlpha
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.String r10 = "alpha"
            r7.setValue(r10, r9)
            float r9 = r0.mMotionEffectAlpha
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.setValue(r10, r9)
            int r9 = r0.mMotionEffectStart
            r7.setFramePosition(r9)
            int r9 = r0.mMotionEffectEnd
            r8.setFramePosition(r9)
            androidx.constraintlayout.motion.widget.KeyPosition r9 = new androidx.constraintlayout.motion.widget.KeyPosition
            r9.<init>()
            int r10 = r0.mMotionEffectStart
            r9.setFramePosition(r10)
            r9.setType(r2)
            java.lang.String r10 = "percentX"
            r9.setValue(r10, r3)
            java.lang.String r11 = "percentY"
            r9.setValue(r11, r3)
            androidx.constraintlayout.motion.widget.KeyPosition r12 = new androidx.constraintlayout.motion.widget.KeyPosition
            r12.<init>()
            int r13 = r0.mMotionEffectEnd
            r12.setFramePosition(r13)
            r12.setType(r2)
            r12.setValue(r10, r5)
            r12.setValue(r11, r5)
            int r5 = r0.mMotionEffectTranslationX
            r10 = 0
            if (r5 <= 0) goto L_0x00b0
            androidx.constraintlayout.motion.widget.KeyAttributes r5 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r5.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r13 = r0.mMotionEffectTranslationX
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationX"
            r5.setValue(r14, r13)
            int r13 = r0.mMotionEffectEnd
            r5.setFramePosition(r13)
            r11.setValue(r14, r3)
            int r13 = r0.mMotionEffectEnd
            int r13 = r13 - r4
            r11.setFramePosition(r13)
            goto L_0x00b2
        L_0x00b0:
            r5 = r10
            r11 = r5
        L_0x00b2:
            int r13 = r0.mMotionEffectTranslationY
            if (r13 <= 0) goto L_0x00da
            androidx.constraintlayout.motion.widget.KeyAttributes r10 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r10.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r13 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r13.<init>()
            int r14 = r0.mMotionEffectTranslationY
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.String r15 = "translationY"
            r10.setValue(r15, r14)
            int r14 = r0.mMotionEffectEnd
            r10.setFramePosition(r14)
            r13.setValue(r15, r3)
            int r3 = r0.mMotionEffectEnd
            int r3 = r3 - r4
            r13.setFramePosition(r3)
            goto L_0x00db
        L_0x00da:
            r13 = r10
        L_0x00db:
            int r3 = r0.mFadeMove
            r16 = r2
            r2 = -1
            r17 = 0
            if (r3 != r2) goto L_0x0149
            r3 = 4
            int[] r2 = new int[r3]
            r15 = r16
            r18 = 3
            r19 = 2
        L_0x00ed:
            int r14 = r6.length
            if (r15 >= r14) goto L_0x0136
            r14 = r6[r15]
            java.lang.Object r14 = r1.get(r14)
            androidx.constraintlayout.motion.widget.MotionController r14 = (androidx.constraintlayout.motion.widget.MotionController) r14
            if (r14 != 0) goto L_0x00fb
            goto L_0x0133
        L_0x00fb:
            float r20 = r14.getFinalX()
            float r21 = r14.getStartX()
            float r20 = r20 - r21
            float r21 = r14.getFinalY()
            float r14 = r14.getStartY()
            float r21 = r21 - r14
            int r14 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0118
            r14 = r2[r4]
            int r14 = r14 + r4
            r2[r4] = r14
        L_0x0118:
            int r14 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x0121
            r14 = r2[r16]
            int r14 = r14 + r4
            r2[r16] = r14
        L_0x0121:
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x012a
            r14 = r2[r18]
            int r14 = r14 + r4
            r2[r18] = r14
        L_0x012a:
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0133
            r14 = r2[r19]
            int r14 = r14 + r4
            r2[r19] = r14
        L_0x0133:
            int r15 = r15 + 1
            goto L_0x00ed
        L_0x0136:
            r14 = r2[r16]
            r15 = r14
            r14 = r16
        L_0x013b:
            if (r4 >= r3) goto L_0x0147
            r3 = r2[r4]
            if (r15 >= r3) goto L_0x0143
            r15 = r3
            r14 = r4
        L_0x0143:
            int r4 = r4 + 1
            r3 = 4
            goto L_0x013b
        L_0x0147:
            r3 = r14
            goto L_0x014d
        L_0x0149:
            r18 = 3
            r19 = 2
        L_0x014d:
            r2 = r16
        L_0x014f:
            int r4 = r6.length
            if (r2 >= r4) goto L_0x01f2
            r4 = r6[r2]
            java.lang.Object r4 = r1.get(r4)
            androidx.constraintlayout.motion.widget.MotionController r4 = (androidx.constraintlayout.motion.widget.MotionController) r4
            if (r4 != 0) goto L_0x0161
        L_0x015c:
            r1 = r23
            r15 = -1
            goto L_0x01e8
        L_0x0161:
            float r14 = r4.getFinalX()
            float r15 = r4.getStartX()
            float r14 = r14 - r15
            float r15 = r4.getFinalY()
            float r16 = r4.getStartY()
            float r15 = r15 - r16
            if (r3 != 0) goto L_0x0189
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0183
            boolean r15 = r0.mMotionEffectStrictMove
            if (r15 == 0) goto L_0x0186
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0183
            goto L_0x0186
        L_0x0183:
            r1 = r18
            goto L_0x01bb
        L_0x0186:
            r1 = r18
            goto L_0x01ba
        L_0x0189:
            r1 = 1
            if (r3 != r1) goto L_0x0199
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0183
            boolean r15 = r0.mMotionEffectStrictMove
            if (r15 == 0) goto L_0x0186
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0183
            goto L_0x0186
        L_0x0199:
            r1 = r19
            if (r3 != r1) goto L_0x01aa
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0183
            boolean r14 = r0.mMotionEffectStrictMove
            if (r14 == 0) goto L_0x0186
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0183
            goto L_0x0186
        L_0x01aa:
            r1 = r18
            if (r3 != r1) goto L_0x01bb
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01bb
            boolean r14 = r0.mMotionEffectStrictMove
            if (r14 == 0) goto L_0x015c
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01bb
        L_0x01ba:
            goto L_0x015c
        L_0x01bb:
            int r14 = r0.mViewTransitionId
            r15 = -1
            if (r14 != r15) goto L_0x01e3
            r4.addKey(r7)
            r4.addKey(r8)
            r4.addKey(r9)
            r4.addKey(r12)
            int r14 = r0.mMotionEffectTranslationX
            if (r14 <= 0) goto L_0x01d6
            r4.addKey(r5)
            r4.addKey(r11)
        L_0x01d6:
            int r14 = r0.mMotionEffectTranslationY
            if (r14 <= 0) goto L_0x01e0
            r4.addKey(r10)
            r4.addKey(r13)
        L_0x01e0:
            r1 = r23
            goto L_0x01e8
        L_0x01e3:
            r1 = r23
            r1.applyViewTransition(r14, r4)
        L_0x01e8:
            int r2 = r2 + 1
            r1 = r24
            r18 = 3
            r19 = 2
            goto L_0x014f
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(context, attributeSet);
    }
}
