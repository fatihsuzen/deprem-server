package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    private static class AnimatableTransition extends Transition {
        private final Animatable mA;

        AnimatableTransition(Animatable animatable) {
            super();
            this.mA = animatable;
        }

        public void start() {
            this.mA.start();
        }

        public void stop() {
            this.mA.stop();
        }
    }

    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        AnimatedStateListState(@Nullable AnimatedStateListState animatedStateListState, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                this.mStateIds = animatedStateListState.mStateIds;
                return;
            }
            this.mTransitions = new LongSparseArray<>();
            this.mStateIds = new SparseArrayCompat<>();
        }

        private static long generateTransitionKey(int i5, int i6) {
            return ((long) i6) | (((long) i5) << 32);
        }

        /* access modifiers changed from: package-private */
        public int addStateSet(@NonNull int[] iArr, @NonNull Drawable drawable, int i5) {
            int addStateSet = super.addStateSet(iArr, drawable);
            this.mStateIds.put(addStateSet, Integer.valueOf(i5));
            return addStateSet;
        }

        /* access modifiers changed from: package-private */
        public int addTransition(int i5, int i6, @NonNull Drawable drawable, boolean z4) {
            long j5;
            int addChild = super.addChild(drawable);
            long generateTransitionKey = generateTransitionKey(i5, i6);
            if (z4) {
                j5 = REVERSIBLE_FLAG_BIT;
            } else {
                j5 = 0;
            }
            long j6 = (long) addChild;
            this.mTransitions.append(generateTransitionKey, Long.valueOf(j6 | j5));
            if (z4) {
                this.mTransitions.append(generateTransitionKey(i6, i5), Long.valueOf(REVERSED_BIT | j6 | j5));
            }
            return addChild;
        }

        /* access modifiers changed from: package-private */
        public int getKeyframeIdAt(int i5) {
            if (i5 < 0) {
                return 0;
            }
            return this.mStateIds.get(i5, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int indexOfKeyframe(@NonNull int[] iArr) {
            int indexOfStateSet = super.indexOfStateSet(iArr);
            if (indexOfStateSet >= 0) {
                return indexOfStateSet;
            }
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int indexOfTransition(int i5, int i6) {
            return (int) this.mTransitions.get(generateTransitionKey(i5, i6), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean isTransitionReversed(int i5, int i6) {
            if ((this.mTransitions.get(generateTransitionKey(i5, i6), -1L).longValue() & REVERSED_BIT) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        /* access modifiers changed from: package-private */
        public boolean transitionHasReversibleFlag(int i5, int i6) {
            if ((this.mTransitions.get(generateTransitionKey(i5, i6), -1L).longValue() & REVERSIBLE_FLAG_BIT) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    private static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.mAvd = animatedVectorDrawableCompat;
        }

        public void start() {
            this.mAvd.start();
        }

        public void stop() {
            this.mAvd.stop();
        }
    }

    private static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z4, boolean z5) {
            super();
            int i5;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i6 = 0;
            if (z4) {
                i5 = numberOfFrames - 1;
            } else {
                i5 = 0;
            }
            i6 = !z4 ? numberOfFrames - 1 : i6;
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z4);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i5, i6});
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) frameInterpolator.getTotalDuration());
            ofInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z5;
            this.mAnim = ofInt;
        }

        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public void reverse() {
            this.mAnim.reverse();
        }

        public void start() {
            this.mAnim.start();
        }

        public void stop() {
            this.mAnim.cancel();
        }
    }

    private static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z4) {
            updateFrames(animationDrawable, z4);
        }

        public float getInterpolation(float f5) {
            float f6;
            int i5 = (int) ((f5 * ((float) this.mTotalDuration)) + 0.5f);
            int i6 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i7 = 0;
            while (i7 < i6) {
                int i8 = iArr[i7];
                if (i5 < i8) {
                    break;
                }
                i5 -= i8;
                i7++;
            }
            if (i7 < i6) {
                f6 = ((float) i5) / ((float) this.mTotalDuration);
            } else {
                f6 = 0.0f;
            }
            return (((float) i7) / ((float) i6)) + f6;
        }

        /* access modifiers changed from: package-private */
        public int getTotalDuration() {
            return this.mTotalDuration;
        }

        /* access modifiers changed from: package-private */
        public int updateFrames(AnimationDrawable animationDrawable, boolean z4) {
            int i5;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.mFrames = numberOfFrames;
            int[] iArr = this.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.mFrameTimes = new int[numberOfFrames];
            }
            int[] iArr2 = this.mFrameTimes;
            int i6 = 0;
            for (int i7 = 0; i7 < numberOfFrames; i7++) {
                if (z4) {
                    i5 = (numberOfFrames - i7) - 1;
                } else {
                    i5 = i7;
                }
                int duration = animationDrawable.getDuration(i5);
                iArr2[i7] = duration;
                i6 += duration;
            }
            this.mTotalDuration = i6;
            return i6;
        }
    }

    private static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    public AnimatedStateListDrawableCompat() {
        this((AnimatedStateListState) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024 A[Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            android.content.res.Resources r1 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.content.res.XmlResourceParser r7 = r1.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x000e:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0024
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r6 = createFromXmlInner(r6, r1, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            return r6
        L_0x0020:
            r6 = move-exception
            goto L_0x002c
        L_0x0022:
            r6 = move-exception
            goto L_0x0032
        L_0x0024:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x0020 }
        L_0x002c:
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
            goto L_0x0037
        L_0x0032:
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
        L_0x0037:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.create(android.content.Context, int, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    @NonNull
    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void inflateChildElements(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals(ELEMENT_ITEM)) {
                        parseItem(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals(ELEMENT_TRANSITION)) {
                        parseTransition(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void init() {
        onStateChange(getState());
    }

    private int parseItem(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (resourceId2 > 0) {
            drawable = ResourceManagerInternal.get().getDrawable(context, resourceId2);
        } else {
            drawable = null;
        }
        obtainAttributes.recycle();
        int[] extractStateSet = extractStateSet(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
            } else if (xmlPullParser.getName().equals("vector")) {
                drawable = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            return this.mState.addStateSet(extractStateSet, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    }

    private int parseTransition(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (resourceId3 > 0) {
            drawable = ResourceManagerInternal.get().getDrawable(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z4 = obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        obtainAttributes.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.mState.addTransition(resourceId, resourceId2, drawable, z4);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
        }
    }

    private boolean selectTransition(int i5) {
        int i6;
        int indexOfTransition;
        Transition transition;
        Transition transition2 = this.mTransition;
        if (transition2 == null) {
            i6 = getCurrentIndex();
        } else if (i5 == this.mTransitionToIndex) {
            return true;
        } else {
            if (i5 != this.mTransitionFromIndex || !transition2.canReverse()) {
                i6 = this.mTransitionToIndex;
                transition2.stop();
            } else {
                transition2.reverse();
                this.mTransitionToIndex = this.mTransitionFromIndex;
                this.mTransitionFromIndex = i5;
                return true;
            }
        }
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState animatedStateListState = this.mState;
        int keyframeIdAt = animatedStateListState.getKeyframeIdAt(i6);
        int keyframeIdAt2 = animatedStateListState.getKeyframeIdAt(i5);
        if (keyframeIdAt2 == 0 || keyframeIdAt == 0 || (indexOfTransition = animatedStateListState.indexOfTransition(keyframeIdAt, keyframeIdAt2)) < 0) {
            return false;
        }
        boolean transitionHasReversibleFlag = animatedStateListState.transitionHasReversibleFlag(keyframeIdAt, keyframeIdAt2);
        selectDrawable(indexOfTransition);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            transition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.isTransitionReversed(keyframeIdAt, keyframeIdAt2), transitionHasReversibleFlag);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                transition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        transition.start();
        this.mTransition = transition;
        this.mTransitionFromIndex = i6;
        this.mTransitionToIndex = i5;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.mState;
        animatedStateListState.mChangingConfigurations |= Compatibility.Api21Impl.getChangingConfigurations(typedArray);
        animatedStateListState.setVariablePadding(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.mVariablePadding));
        animatedStateListState.setConstantSize(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.mConstantSize));
        animatedStateListState.setEnterFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.mEnterFadeDuration));
        animatedStateListState.setExitFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.mExitFadeDuration));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.mDither));
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i5) {
        ObjectsCompat.requireNonNull(drawable);
        this.mState.addStateSet(iArr, drawable, i5);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int i5, int i6, @NonNull T t5, boolean z4) {
        ObjectsCompat.requireNonNull(t5);
        this.mState.addTransition(i5, i6, t5, z4);
    }

    /* access modifiers changed from: package-private */
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        updateDensity(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        init();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.mTransition;
        if (transition != null) {
            transition.stop();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState.mutate();
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean z4;
        int indexOfKeyframe = this.mState.indexOfKeyframe(iArr);
        if (indexOfKeyframe == getCurrentIndex() || (!selectTransition(indexOfKeyframe) && !selectDrawable(indexOfKeyframe))) {
            z4 = false;
        } else {
            z4 = true;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return current.setState(iArr) | z4;
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    public void setConstantState(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.mState = (AnimatedStateListState) drawableContainerState;
        }
    }

    public boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        Transition transition = this.mTransition;
        if (transition != null && (visible || z5)) {
            if (z4) {
                transition.start();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }

    AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState animatedStateListState, @Nullable Resources resources) {
        super((StateListDrawableCompat.StateListState) null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, (Resources) null);
    }
}
