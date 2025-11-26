package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final Animator[] EMPTY_ANIMATOR_ARRAY = new Animator[0];
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() {
        @NonNull
        public Path getPath(float f5, float f6, float f7, float f8) {
            Path path = new Path();
            path.moveTo(f5, f6);
            path.lineTo(f7, f8);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    private Animator[] mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
    ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    /* access modifiers changed from: private */
    public Transition mCloneParent = null;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mEndValuesList;
    boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private TransitionListener[] mListenersCache;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    SeekController mSeekController;
    long mSeekOffsetInParent;
    private long mStartDelay = -1;
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();
    long mTotalDuration;

    private static class AnimationInfo {
        Animator mAnimator;
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowId mWindowId;

        AnimationInfo(View view, String str, Transition transition, WindowId windowId, TransitionValues transitionValues, Animator animator) {
            this.mView = view;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowId;
            this.mTransition = transition;
            this.mAnimator = animator;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t5) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t5)) {
                arrayList.add(t5);
            }
            return arrayList;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t5) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t5);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class EpicenterCallback {
        @Nullable
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @RequiresApi(26)
    private static class Impl26 {
        private Impl26() {
        }

        @DoNotInline
        static long getTotalDuration(Animator animator) {
            return animator.getTotalDuration();
        }

        @DoNotInline
        static void setCurrentPlayTime(Animator animator, long j5) {
            ((AnimatorSet) animator).setCurrentPlayTime(j5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    @RequiresApi(34)
    class SeekController extends TransitionListenerAdapter implements TransitionSeekController, DynamicAnimation.OnAnimationUpdateListener {
        private long mCurrentPlayTime = -1;
        private boolean mIsCanceled;
        private boolean mIsReady;
        private Consumer<TransitionSeekController>[] mListenerCache = null;
        private ArrayList<Consumer<TransitionSeekController>> mOnProgressListeners = null;
        private ArrayList<Consumer<TransitionSeekController>> mOnReadyListeners = null;
        private Runnable mResetToStartState;
        private SpringAnimation mSpringAnimation;
        private final VelocityTracker1D mVelocityTracker = new VelocityTracker1D();

        SeekController() {
        }

        public static /* synthetic */ void a(SeekController seekController, DynamicAnimation dynamicAnimation, boolean z4, float f5, float f6) {
            if (z4) {
                seekController.getClass();
            } else if (f5 < 1.0f) {
                long durationMillis = seekController.getDurationMillis();
                Transition transitionAt = ((TransitionSet) Transition.this).getTransitionAt(0);
                Transition access$000 = transitionAt.mCloneParent;
                Transition unused = transitionAt.mCloneParent = null;
                Transition.this.setCurrentPlayTimeMillis(-1, seekController.mCurrentPlayTime);
                Transition.this.setCurrentPlayTimeMillis(durationMillis, -1);
                seekController.mCurrentPlayTime = durationMillis;
                Runnable runnable = seekController.mResetToStartState;
                if (runnable != null) {
                    runnable.run();
                }
                Transition.this.mAnimators.clear();
                if (access$000 != null) {
                    access$000.notifyListeners(TransitionNotification.ON_END, true);
                }
            } else {
                Transition.this.notifyListeners(TransitionNotification.ON_END, false);
            }
        }

        private void callProgressListeners() {
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.mOnProgressListeners;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.mOnProgressListeners.size();
                if (this.mListenerCache == null) {
                    this.mListenerCache = new Consumer[size];
                }
                Consumer<TransitionSeekController>[] consumerArr = (Consumer[]) this.mOnProgressListeners.toArray(this.mListenerCache);
                this.mListenerCache = null;
                for (int i5 = 0; i5 < size; i5++) {
                    consumerArr[i5].accept(this);
                    consumerArr[i5] = null;
                }
                this.mListenerCache = consumerArr;
            }
        }

        private void ensureAnimation() {
            if (this.mSpringAnimation == null) {
                this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), (float) this.mCurrentPlayTime);
                this.mSpringAnimation = new SpringAnimation(new FloatValueHolder());
                SpringForce springForce = new SpringForce();
                springForce.setDampingRatio(1.0f);
                springForce.setStiffness(200.0f);
                this.mSpringAnimation.setSpring(springForce);
                this.mSpringAnimation.setStartValue((float) this.mCurrentPlayTime);
                this.mSpringAnimation.addUpdateListener(this);
                this.mSpringAnimation.setStartVelocity(this.mVelocityTracker.calculateVelocity());
                this.mSpringAnimation.setMaxValue((float) (getDurationMillis() + 1));
                this.mSpringAnimation.setMinValue(-1.0f);
                this.mSpringAnimation.setMinimumVisibleChange(4.0f);
                this.mSpringAnimation.addEndListener(new d(this));
            }
        }

        public void addOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> consumer) {
            if (this.mOnProgressListeners == null) {
                this.mOnProgressListeners = new ArrayList<>();
            }
            this.mOnProgressListeners.add(consumer);
        }

        public void addOnReadyListener(@NonNull Consumer<TransitionSeekController> consumer) {
            if (isReady()) {
                consumer.accept(this);
                return;
            }
            if (this.mOnReadyListeners == null) {
                this.mOnReadyListeners = new ArrayList<>();
            }
            this.mOnReadyListeners.add(consumer);
        }

        public void animateToEnd() {
            ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition((float) (getDurationMillis() + 1));
        }

        public void animateToStart(@NonNull Runnable runnable) {
            this.mResetToStartState = runnable;
            ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(0.0f);
        }

        public float getCurrentFraction() {
            return ((float) getCurrentPlayTimeMillis()) / ((float) getDurationMillis());
        }

        public long getCurrentPlayTimeMillis() {
            return Math.min(getDurationMillis(), Math.max(0, this.mCurrentPlayTime));
        }

        public long getDurationMillis() {
            return Transition.this.getTotalDurationMillis();
        }

        /* access modifiers changed from: package-private */
        public void initPlayTime() {
            long j5 = 0;
            if (getDurationMillis() == 0) {
                j5 = 1;
            }
            Transition.this.setCurrentPlayTimeMillis(j5, this.mCurrentPlayTime);
            this.mCurrentPlayTime = j5;
        }

        public boolean isReady() {
            return this.mIsReady;
        }

        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f5, float f6) {
            long max = Math.max(-1, Math.min(getDurationMillis() + 1, Math.round((double) f5)));
            Transition.this.setCurrentPlayTimeMillis(max, this.mCurrentPlayTime);
            this.mCurrentPlayTime = max;
            callProgressListeners();
        }

        public void onTransitionCancel(@NonNull Transition transition) {
            this.mIsCanceled = true;
        }

        public void ready() {
            this.mIsReady = true;
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.mOnReadyListeners;
            if (arrayList != null) {
                this.mOnReadyListeners = null;
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    arrayList.get(i5).accept(this);
                }
            }
            callProgressListeners();
        }

        public void removeOnProgressChangedListener(@NonNull Consumer<TransitionSeekController> consumer) {
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.mOnProgressListeners;
            if (arrayList != null) {
                arrayList.remove(consumer);
            }
        }

        public void removeOnReadyListener(@NonNull Consumer<TransitionSeekController> consumer) {
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.mOnReadyListeners;
            if (arrayList != null) {
                arrayList.remove(consumer);
                if (this.mOnReadyListeners.isEmpty()) {
                    this.mOnReadyListeners = null;
                }
            }
        }

        public void setCurrentFraction(float f5) {
            if (this.mSpringAnimation == null) {
                setCurrentPlayTimeMillis((long) (f5 * ((float) getDurationMillis())));
                return;
            }
            throw new IllegalStateException("setCurrentFraction() called after animation has been started");
        }

        public void setCurrentPlayTimeMillis(long j5) {
            if (this.mSpringAnimation != null) {
                throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
            } else if (j5 != this.mCurrentPlayTime && isReady()) {
                if (!this.mIsCanceled) {
                    if (j5 != 0 || this.mCurrentPlayTime <= 0) {
                        long durationMillis = getDurationMillis();
                        if (j5 == durationMillis && this.mCurrentPlayTime < durationMillis) {
                            j5 = 1 + durationMillis;
                        }
                    } else {
                        j5 = -1;
                    }
                    long j6 = this.mCurrentPlayTime;
                    if (j5 != j6) {
                        Transition.this.setCurrentPlayTimeMillis(j5, j6);
                        this.mCurrentPlayTime = j5;
                    }
                }
                callProgressListeners();
                this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), (float) j5);
            }
        }
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition, boolean z4);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition, boolean z4);
    }

    interface TransitionNotification {
        public static final TransitionNotification ON_CANCEL = new h();
        public static final TransitionNotification ON_END = new g();
        public static final TransitionNotification ON_PAUSE = new i();
        public static final TransitionNotification ON_RESUME = new j();
        public static final TransitionNotification ON_START = new f();

        void notifyListener(@NonNull TransitionListener transitionListener, @NonNull Transition transition, boolean z4);
    }

    public Transition() {
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i5 = 0; i5 < arrayMap.size(); i5++) {
            TransitionValues valueAt = arrayMap.valueAt(i5);
            if (isValidTarget(valueAt.view)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i6 = 0; i6 < arrayMap2.size(); i6++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i6);
            if (isValidTarget(valueAt2.view)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.mViewValues.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(id) >= 0) {
                transitionValuesMaps.mIdValues.put(id, (Object) null);
            } else {
                transitionValuesMaps.mIdValues.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.mNameValues.containsKey(transitionName)) {
                transitionValuesMaps.mNameValues.put(transitionName, null);
            } else {
                transitionValuesMaps.mNameValues.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.mItemIdValues.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = transitionValuesMaps.mItemIdValues.get(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i5) {
        int i6 = iArr[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            if (iArr[i7] == i6) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z4) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i5 = 0;
                        while (i5 < size) {
                            if (!this.mTargetTypeExcludes.get(i5).isInstance(view)) {
                                i5++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z4) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.mTargetedTransitions.add(this);
                        capturePropagationValues(transitionValues);
                        if (z4) {
                            addViewValues(this.mStartValues, view, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i6 = 0;
                                    while (i6 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i6).isInstance(view)) {
                                            i6++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                                    captureHierarchy(viewGroup.getChildAt(i7), z4);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i5, boolean z4) {
        if (i5 <= 0) {
            return arrayList;
        }
        if (z4) {
            return ArrayListManager.add(arrayList, Integer.valueOf(i5));
        }
        return ArrayListManager.remove(arrayList, Integer.valueOf(i5));
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t5, boolean z4) {
        if (t5 == null) {
            return arrayList;
        }
        if (z4) {
            return ArrayListManager.add(arrayList, t5);
        }
        return ArrayListManager.remove(arrayList, t5);
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z4) {
        if (cls == null) {
            return arrayList;
        }
        if (z4) {
            return ArrayListManager.add(arrayList, cls);
        }
        return ArrayListManager.remove(arrayList, cls);
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z4) {
        if (view == null) {
            return arrayList;
        }
        if (z4) {
            return ArrayListManager.add(arrayList, view);
        }
        return ArrayListManager.remove(arrayList, view);
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean isValidMatch(int i5) {
        return i5 >= 1 && i5 <= 4;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            View valueAt = sparseArray.valueAt(i5);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i5))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.view)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            View valueAt = longSparseArray.valueAt(i5);
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i5))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i5 = 0; i5 < size; i5++) {
            View valueAt = arrayMap3.valueAt(i5);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i5))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) transitionValuesMaps.mViewValues);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) transitionValuesMaps2.mViewValues);
        int i5 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i5 < iArr.length) {
                int i6 = iArr[i5];
                if (i6 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i6 == 2) {
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.mNameValues, transitionValuesMaps2.mNameValues);
                } else if (i6 == 3) {
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.mIdValues, transitionValuesMaps2.mIdValues);
                } else if (i6 == 4) {
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.mItemIdValues, transitionValuesMaps2.mItemIdValues);
                }
                i5++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private void notifyFromTransition(Transition transition, TransitionNotification transitionNotification, boolean z4) {
        Transition transition2 = this.mCloneParent;
        if (transition2 != null) {
            transition2.notifyFromTransition(transition, transitionNotification, z4);
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.mListeners.size();
            TransitionListener[] transitionListenerArr = this.mListenersCache;
            if (transitionListenerArr == null) {
                transitionListenerArr = new TransitionListener[size];
            }
            this.mListenersCache = null;
            TransitionListener[] transitionListenerArr2 = (TransitionListener[]) this.mListeners.toArray(transitionListenerArr);
            for (int i5 = 0; i5 < size; i5++) {
                transitionNotification.notifyListener(transitionListenerArr2[i5], transition, z4);
                transitionListenerArr2[i5] = null;
            }
            this.mListenersCache = transitionListenerArr2;
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i5 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i5] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i5] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i5] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i5] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                i5--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i5++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    Transition.this.mCurrentAnimators.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.mCurrentAnimators.add(animator);
                }
            });
            animate(animator);
        }
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.mTargets.add(view);
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(@Nullable Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        int size = this.mCurrentAnimators.size();
        Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator animator = animatorArr[i5];
            animatorArr[i5] = null;
            animator.cancel();
        }
        this.mAnimatorCache = animatorArr;
        notifyListeners(TransitionNotification.ON_CANCEL, false);
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.mPropagation != null && !transitionValues.values.isEmpty() && (propagationProperties = this.mPropagation.getPropagationProperties()) != null) {
            for (String containsKey : propagationProperties) {
                if (!transitionValues.values.containsKey(containsKey)) {
                    this.mPropagation.captureValues(transitionValues);
                    return;
                }
            }
        }
    }

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public void captureValues(@NonNull ViewGroup viewGroup, boolean z4) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z4);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i5 = 0; i5 < this.mTargetIds.size(); i5++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i5).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z4) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z4) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i6 = 0; i6 < this.mTargets.size(); i6++) {
                View view = this.mTargets.get(i6);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z4) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z4) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z4);
        }
        if (!z4 && (arrayMap = this.mNameOverrides) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i7 = 0; i7 < size; i7++) {
                arrayList3.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(i7)));
            }
            for (int i8 = 0; i8 < size; i8++) {
                View view2 = (View) arrayList3.get(i8);
                if (view2 != null) {
                    this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(i8), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearValues(boolean z4) {
        if (z4) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
            return;
        }
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void createAnimators(@NonNull ViewGroup viewGroup, @NonNull TransitionValuesMaps transitionValuesMaps, @NonNull TransitionValuesMaps transitionValuesMaps2, @NonNull ArrayList<TransitionValues> arrayList, @NonNull ArrayList<TransitionValues> arrayList2) {
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        Animator createAnimator;
        Animator animator;
        TransitionValues transitionValues;
        View view;
        AnimatorSet animatorSet;
        View view2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        if (getRootTransition().mSeekController != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        long j5 = Long.MAX_VALUE;
        int i7 = 0;
        while (i7 < size) {
            TransitionValues transitionValues2 = arrayList.get(i7);
            TransitionValues transitionValues3 = arrayList2.get(i7);
            if (transitionValues2 != null && !transitionValues2.mTargetedTransitions.contains(this)) {
                transitionValues2 = null;
            }
            if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                transitionValues3 = null;
            }
            if (!(transitionValues2 == null && transitionValues3 == null) && ((transitionValues2 == null || transitionValues3 == null || isTransitionRequired(transitionValues2, transitionValues3)) && (createAnimator = createAnimator(viewGroup2, transitionValues2, transitionValues3)) != null)) {
                if (transitionValues3 != null) {
                    View view3 = transitionValues3.view;
                    String[] transitionProperties = getTransitionProperties();
                    Animator animator3 = createAnimator;
                    if (transitionProperties != null && transitionProperties.length > 0) {
                        transitionValues = new TransitionValues(view3);
                        i6 = size;
                        z5 = z4;
                        TransitionValues transitionValues4 = transitionValuesMaps2.mViewValues.get(view3);
                        i5 = i7;
                        if (transitionValues4 != null) {
                            int i8 = 0;
                            while (i8 < transitionProperties.length) {
                                Map<String, Object> map = transitionValues.values;
                                int i9 = i8;
                                String str = transitionProperties[i9];
                                map.put(str, transitionValues4.values.get(str));
                                i8 = i9 + 1;
                                transitionProperties = transitionProperties;
                            }
                        }
                        int size2 = runningAnimators.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size2) {
                                view2 = view3;
                                animator2 = animator3;
                                break;
                            }
                            AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i10));
                            if (animationInfo.mValues != null && animationInfo.mView == view3) {
                                view2 = view3;
                                if (animationInfo.mName.equals(getName()) && animationInfo.mValues.equals(transitionValues)) {
                                    animator2 = null;
                                    break;
                                }
                            } else {
                                view2 = view3;
                            }
                            i10++;
                            view3 = view2;
                        }
                    } else {
                        view2 = view3;
                        i6 = size;
                        z5 = z4;
                        i5 = i7;
                        animator2 = animator3;
                        transitionValues = null;
                    }
                    animator = animator2;
                    view = view2;
                } else {
                    animator = createAnimator;
                    i6 = size;
                    z5 = z4;
                    i5 = i7;
                    view = transitionValues2.view;
                    transitionValues = null;
                }
                if (animator != null) {
                    TransitionPropagation transitionPropagation = this.mPropagation;
                    if (transitionPropagation != null) {
                        long startDelay = transitionPropagation.getStartDelay(viewGroup2, this, transitionValues2, transitionValues3);
                        sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                        j5 = Math.min(startDelay, j5);
                    }
                    long j6 = j5;
                    View view4 = view;
                    TransitionValues transitionValues5 = transitionValues;
                    Animator animator4 = animator;
                    AnimationInfo animationInfo2 = new AnimationInfo(view4, getName(), this, viewGroup2.getWindowId(), transitionValues5, animator4);
                    if (z5) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.play(animator4);
                        animatorSet = animatorSet2;
                    } else {
                        animatorSet = animator4;
                    }
                    runningAnimators.put(animatorSet, animationInfo2);
                    this.mAnimators.add(animatorSet);
                    j5 = j6;
                }
            } else {
                i6 = size;
                z5 = z4;
                i5 = i7;
            }
            i7 = i5 + 1;
            size = i6;
            z4 = z5;
        }
        if (sparseIntArray.size() != 0) {
            for (int i11 = 0; i11 < sparseIntArray.size(); i11++) {
                AnimationInfo animationInfo3 = runningAnimators.get(this.mAnimators.get(sparseIntArray.keyAt(i11)));
                animationInfo3.mAnimator.setStartDelay((((long) sparseIntArray.valueAt(i11)) - j5) + animationInfo3.mAnimator.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    @NonNull
    public TransitionSeekController createSeekController() {
        SeekController seekController = new SeekController();
        this.mSeekController = seekController;
        addListener(seekController);
        return this.mSeekController;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int i5 = this.mNumInstances - 1;
        this.mNumInstances = i5;
        if (i5 == 0) {
            notifyListeners(TransitionNotification.ON_END, false);
            for (int i6 = 0; i6 < this.mStartValues.mItemIdValues.size(); i6++) {
                View valueAt = this.mStartValues.mItemIdValues.valueAt(i6);
                if (valueAt != null) {
                    valueAt.setHasTransientState(false);
                }
            }
            for (int i7 = 0; i7 < this.mEndValues.mItemIdValues.size(); i7++) {
                View valueAt2 = this.mEndValues.mItemIdValues.valueAt(i7);
                if (valueAt2 != null) {
                    valueAt2.setHasTransientState(false);
                }
            }
            this.mEnded = true;
        }
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z4) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z4);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z4) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z4);
        return this;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(@Nullable ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            WindowId windowId = viewGroup.getWindowId();
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) runningAnimators);
            runningAnimators.clear();
            for (int i5 = size - 1; i5 >= 0; i5--) {
                AnimationInfo animationInfo = (AnimationInfo) arrayMap.valueAt(i5);
                if (animationInfo.mView != null && windowId.equals(animationInfo.mWindowId)) {
                    ((Animator) arrayMap.keyAt(i5)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* access modifiers changed from: package-private */
    public TransitionValues getMatchedTransitionValues(View view, boolean z4) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z4);
        }
        if (z4) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i5);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                break;
            }
            i5++;
        }
        if (i5 < 0) {
            return null;
        }
        if (z4) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i5);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    @NonNull
    public final Transition getRootTransition() {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getRootTransition();
        }
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    /* access modifiers changed from: package-private */
    public final long getTotalDurationMillis() {
        return this.mTotalDuration;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z4) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z4);
        }
        if (z4) {
            transitionValuesMaps = this.mStartValues;
        } else {
            transitionValuesMaps = this.mEndValues;
        }
        return transitionValuesMaps.mViewValues.get(view);
    }

    /* access modifiers changed from: package-private */
    public boolean hasAnimators() {
        return !this.mCurrentAnimators.isEmpty();
    }

    public boolean isSeekingSupported() {
        return false;
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null)) {
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String isValueChanged : transitionProperties) {
                    if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
                        return true;
                    }
                }
            } else {
                for (String isValueChanged2 : transitionValues.values.keySet()) {
                    if (isValueChanged(transitionValues, transitionValues2, isValueChanged2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (this.mTargetTypeExcludes.get(i5).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i6 = 0; i6 < this.mTargetTypes.size(); i6++) {
                if (this.mTargetTypes.get(i6).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void notifyListeners(TransitionNotification transitionNotification, boolean z4) {
        notifyFromTransition(this, transitionNotification, z4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(@Nullable View view) {
        if (!this.mEnded) {
            int size = this.mCurrentAnimators.size();
            Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
            this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
            for (int i5 = size - 1; i5 >= 0; i5--) {
                Animator animator = animatorArr[i5];
                animatorArr[i5] = null;
                animator.pause();
            }
            this.mAnimatorCache = animatorArr;
            notifyListeners(TransitionNotification.ON_PAUSE, false);
            this.mPaused = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void playTransition(@NonNull ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i5 = size - 1; i5 >= 0; i5--) {
            Animator keyAt = runningAnimators.keyAt(i5);
            if (!(keyAt == null || (animationInfo = runningAnimators.get(keyAt)) == null || animationInfo.mView == null || !windowId.equals(animationInfo.mWindowId))) {
                TransitionValues transitionValues = animationInfo.mValues;
                View view = animationInfo.mView;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues2 == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.mViewValues.get(view);
                }
                if (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.mTransition.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                    Transition transition = animationInfo.mTransition;
                    if (transition.getRootTransition().mSeekController != null) {
                        keyAt.cancel();
                        transition.mCurrentAnimators.remove(keyAt);
                        runningAnimators.remove(keyAt);
                        if (transition.mCurrentAnimators.size() == 0) {
                            transition.notifyListeners(TransitionNotification.ON_CANCEL, false);
                            if (!transition.mEnded) {
                                transition.mEnded = true;
                                transition.notifyListeners(TransitionNotification.ON_END, false);
                            }
                        }
                    } else if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        runningAnimators.remove(keyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        if (this.mSeekController == null) {
            runAnimators();
        } else if (Build.VERSION.SDK_INT >= 34) {
            prepareAnimatorsForSeeking();
            this.mSeekController.initPlayTime();
            this.mSeekController.ready();
        }
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void prepareAnimatorsForSeeking() {
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        this.mTotalDuration = 0;
        for (int i5 = 0; i5 < this.mAnimators.size(); i5++) {
            Animator animator = this.mAnimators.get(i5);
            AnimationInfo animationInfo = runningAnimators.get(animator);
            if (!(animator == null || animationInfo == null)) {
                if (getDuration() >= 0) {
                    animationInfo.mAnimator.setDuration(getDuration());
                }
                if (getStartDelay() >= 0) {
                    animationInfo.mAnimator.setStartDelay(getStartDelay() + animationInfo.mAnimator.getStartDelay());
                }
                if (getInterpolator() != null) {
                    animationInfo.mAnimator.setInterpolator(getInterpolator());
                }
                this.mCurrentAnimators.add(animator);
                this.mTotalDuration = Math.max(this.mTotalDuration, Impl26.getTotalDuration(animator));
            }
        }
        this.mAnimators.clear();
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        Transition transition;
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null) {
            if (!arrayList.remove(transitionListener) && (transition = this.mCloneParent) != null) {
                transition.removeListener(transitionListener);
            }
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.mTargets.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(@Nullable View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                int size = this.mCurrentAnimators.size();
                Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
                this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
                for (int i5 = size - 1; i5 >= 0; i5--) {
                    Animator animator = animatorArr[i5];
                    animatorArr[i5] = null;
                    animator.resume();
                }
                this.mAnimatorCache = animatorArr;
                notifyListeners(TransitionNotification.ON_RESUME, false);
            }
            this.mPaused = false;
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        ArrayList<Animator> arrayList = this.mAnimators;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Animator animator = arrayList.get(i5);
            i5++;
            Animator animator2 = animator;
            if (runningAnimators.containsKey(animator2)) {
                start();
                runAnimator(animator2, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z4) {
        this.mCanRemoveViews = z4;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void setCurrentPlayTimeMillis(long j5, long j6) {
        boolean z4;
        long j7 = j5;
        long totalDurationMillis = getTotalDurationMillis();
        int i5 = 0;
        if (j7 < j6) {
            z4 = true;
        } else {
            z4 = false;
        }
        int i6 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if ((i6 < 0 && j7 >= 0) || (j6 > totalDurationMillis && j7 <= totalDurationMillis)) {
            this.mEnded = false;
            notifyListeners(TransitionNotification.ON_START, z4);
        }
        int size = this.mCurrentAnimators.size();
        Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        while (i5 < size) {
            Animator animator = animatorArr[i5];
            animatorArr[i5] = null;
            Impl26.setCurrentPlayTime(animator, Math.min(Math.max(0, j7), Impl26.getTotalDuration(animator)));
            i5++;
            totalDurationMillis = totalDurationMillis;
        }
        long j8 = totalDurationMillis;
        this.mAnimatorCache = animatorArr;
        int i7 = (j7 > j8 ? 1 : (j7 == j8 ? 0 : -1));
        if ((i7 > 0 && j6 <= j8) || (j7 < 0 && i6 >= 0)) {
            if (i7 > 0) {
                this.mEnded = true;
            }
            notifyListeners(TransitionNotification.ON_END, z4);
        }
    }

    @NonNull
    public Transition setDuration(long j5) {
        this.mDuration = j5;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(@Nullable int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i5 = 0;
        while (i5 < iArr.length) {
            if (!isValidMatch(iArr[i5])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i5)) {
                i5++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    @NonNull
    public Transition setStartDelay(long j5) {
        this.mStartDelay = j5;
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.mNumInstances == 0) {
            notifyListeners(TransitionNotification.ON_START, false);
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    @NonNull
    public String toString() {
        return toString("");
    }

    @NonNull
    public Transition addTarget(@IdRes int i5) {
        if (i5 != 0) {
            this.mTargetIds.add(Integer.valueOf(i5));
        }
        return this;
    }

    @NonNull
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            transition.mSeekController = null;
            transition.mCloneParent = this;
            transition.mListeners = null;
            return transition;
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i5, boolean z4) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i5, z4);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i5, boolean z4) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i5, z4);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i5) {
        if (i5 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i5));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.mDuration != -1) {
            sb.append("dur(");
            sb.append(this.mDuration);
            sb.append(") ");
        }
        if (this.mStartDelay != -1) {
            sb.append("dly(");
            sb.append(this.mStartDelay);
            sb.append(") ");
        }
        if (this.mInterpolator != null) {
            sb.append("interp(");
            sb.append(this.mInterpolator);
            sb.append(") ");
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            sb.append("tgts(");
            if (this.mTargetIds.size() > 0) {
                for (int i5 = 0; i5 < this.mTargetIds.size(); i5++) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.mTargetIds.get(i5));
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i6 = 0; i6 < this.mTargets.size(); i6++) {
                    if (i6 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.mTargets.get(i6));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z4) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z4);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z4) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z4);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z4) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z4);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public Transition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, TypedValues.TransitionType.S_DURATION, 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }
}
