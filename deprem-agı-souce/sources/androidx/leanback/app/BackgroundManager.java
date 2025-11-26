package androidx.leanback.app;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.leanback.R;
import java.lang.ref.WeakReference;

public final class BackgroundManager {
    private static final int CHANGE_BG_DELAY_MS = 500;
    static final boolean DEBUG = false;
    private static final int FADE_DURATION = 500;
    private static final String FRAGMENT_TAG = "androidx.leanback.app.BackgroundManager";
    static final int FULL_ALPHA = 255;
    static final String TAG = "BackgroundManager";
    private final Animator.AnimatorListener mAnimationListener;
    private final ValueAnimator.AnimatorUpdateListener mAnimationUpdateListener;
    final ValueAnimator mAnimator;
    boolean mAttached;
    private boolean mAutoReleaseOnStop = true;
    int mBackgroundColor;
    Drawable mBackgroundDrawable;
    private View mBgView;
    ChangeBackgroundRunnable mChangeRunnable;
    private boolean mChangeRunnablePending;
    Activity mContext;
    private BackgroundFragment mFragmentState;
    Handler mHandler;
    private int mHeightPx;
    int mImageInWrapperIndex;
    int mImageOutWrapperIndex;
    private long mLastSetTime;
    TranslucentLayerDrawable mLayerDrawable;
    private BackgroundContinuityService mService;
    private int mThemeDrawableResourceId;
    private int mWidthPx;

    private static class BackgroundContinuityService {
        private static final boolean DEBUG = false;
        private static final String TAG = "BackgroundContinuity";
        private static BackgroundContinuityService sService = new BackgroundContinuityService();
        private int mColor;
        private int mCount;
        private Drawable mDrawable;
        private int mLastThemeDrawableId;
        private WeakReference<Drawable.ConstantState> mLastThemeDrawableState;

        private BackgroundContinuityService() {
            reset();
        }

        public static BackgroundContinuityService getInstance() {
            BackgroundContinuityService backgroundContinuityService = sService;
            backgroundContinuityService.mCount++;
            return backgroundContinuityService;
        }

        private void reset() {
            this.mColor = 0;
            this.mDrawable = null;
        }

        public int getColor() {
            return this.mColor;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public Drawable getThemeDrawable(Context context, int i5) {
            Drawable drawable;
            Drawable.ConstantState constantState;
            WeakReference<Drawable.ConstantState> weakReference = this.mLastThemeDrawableState;
            if (weakReference == null || this.mLastThemeDrawableId != i5 || (constantState = weakReference.get()) == null) {
                drawable = null;
            } else {
                drawable = constantState.newDrawable();
            }
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = ContextCompat.getDrawable(context, i5);
            this.mLastThemeDrawableState = new WeakReference<>(drawable2.getConstantState());
            this.mLastThemeDrawableId = i5;
            return drawable2;
        }

        public void setColor(int i5) {
            this.mColor = i5;
            this.mDrawable = null;
        }

        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void unref() {
            int i5 = this.mCount;
            if (i5 > 0) {
                int i6 = i5 - 1;
                this.mCount = i6;
                if (i6 == 0) {
                    reset();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Can't unref, count " + this.mCount);
        }
    }

    static class BitmapDrawable extends Drawable {
        boolean mMutated;
        ConstantState mState;

        BitmapDrawable(Resources resources, Bitmap bitmap) {
            this(resources, bitmap, (Matrix) null);
        }

        public void draw(Canvas canvas) {
            ConstantState constantState = this.mState;
            if (constantState.mBitmap != null) {
                if (constantState.mPaint.getAlpha() >= 255 || this.mState.mPaint.getColorFilter() == null) {
                    ConstantState constantState2 = this.mState;
                    canvas.drawBitmap(constantState2.mBitmap, constantState2.mMatrix, constantState2.mPaint);
                    return;
                }
                throw new IllegalStateException("Can't draw with translucent alpha and color filter");
            }
        }

        /* access modifiers changed from: package-private */
        public Bitmap getBitmap() {
            return this.mState.mBitmap;
        }

        public ColorFilter getColorFilter() {
            return this.mState.mPaint.getColorFilter();
        }

        public int getOpacity() {
            return -3;
        }

        public Drawable mutate() {
            if (!this.mMutated) {
                this.mMutated = true;
                this.mState = new ConstantState(this.mState);
            }
            return this;
        }

        public void setAlpha(int i5) {
            mutate();
            if (this.mState.mPaint.getAlpha() != i5) {
                this.mState.mPaint.setAlpha(i5);
                invalidateSelf();
            }
        }

        public void setColorFilter(ColorFilter colorFilter) {
            mutate();
            this.mState.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        BitmapDrawable(Resources resources, Bitmap bitmap, Matrix matrix) {
            this.mState = new ConstantState(bitmap, matrix);
        }

        public ConstantState getConstantState() {
            return this.mState;
        }

        BitmapDrawable(ConstantState constantState) {
            this.mState = constantState;
        }

        static final class ConstantState extends Drawable.ConstantState {
            final Bitmap mBitmap;
            final Matrix mMatrix;
            final Paint mPaint;

            ConstantState(Bitmap bitmap, Matrix matrix) {
                Paint paint = new Paint();
                this.mPaint = paint;
                this.mBitmap = bitmap;
                this.mMatrix = matrix == null ? new Matrix() : matrix;
                paint.setFilterBitmap(true);
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return new BitmapDrawable(this);
            }

            ConstantState(ConstantState constantState) {
                Paint paint = new Paint();
                this.mPaint = paint;
                this.mBitmap = constantState.mBitmap;
                this.mMatrix = constantState.mMatrix != null ? new Matrix(constantState.mMatrix) : new Matrix();
                if (constantState.mPaint.getAlpha() != 255) {
                    paint.setAlpha(constantState.mPaint.getAlpha());
                }
                if (constantState.mPaint.getColorFilter() != null) {
                    paint.setColorFilter(constantState.mPaint.getColorFilter());
                }
                paint.setFilterBitmap(true);
            }
        }
    }

    final class ChangeBackgroundRunnable implements Runnable {
        final Drawable mDrawable;

        ChangeBackgroundRunnable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        private void runTask() {
            BackgroundManager backgroundManager = BackgroundManager.this;
            if (backgroundManager.mLayerDrawable != null) {
                DrawableWrapper imageInWrapper = backgroundManager.getImageInWrapper();
                if (imageInWrapper != null) {
                    if (!BackgroundManager.this.sameDrawable(this.mDrawable, imageInWrapper.getDrawable())) {
                        BackgroundManager backgroundManager2 = BackgroundManager.this;
                        backgroundManager2.mLayerDrawable.clearDrawable(R.id.background_imagein, backgroundManager2.mContext);
                        BackgroundManager.this.mLayerDrawable.updateDrawable(R.id.background_imageout, imageInWrapper.getDrawable());
                    } else {
                        return;
                    }
                }
                applyBackgroundChanges();
            }
        }

        /* access modifiers changed from: package-private */
        public void applyBackgroundChanges() {
            Drawable drawable;
            BackgroundManager backgroundManager = BackgroundManager.this;
            if (backgroundManager.mAttached) {
                if (backgroundManager.getImageInWrapper() == null && (drawable = this.mDrawable) != null) {
                    BackgroundManager.this.mLayerDrawable.updateDrawable(R.id.background_imagein, drawable);
                    BackgroundManager backgroundManager2 = BackgroundManager.this;
                    backgroundManager2.mLayerDrawable.setWrapperAlpha(backgroundManager2.mImageInWrapperIndex, 0);
                }
                BackgroundManager.this.mAnimator.setDuration(500);
                BackgroundManager.this.mAnimator.start();
            }
        }

        public void run() {
            runTask();
            BackgroundManager.this.mChangeRunnable = null;
        }
    }

    static class EmptyDrawable extends BitmapDrawable {
        EmptyDrawable(Resources resources) {
            super(resources, (Bitmap) null);
        }
    }

    static final class TranslucentLayerDrawable extends LayerDrawable {
        int mAlpha = 255;
        WeakReference<BackgroundManager> mManagerWeakReference;
        boolean mSuspendInvalidation;
        DrawableWrapper[] mWrapper;

        TranslucentLayerDrawable(BackgroundManager backgroundManager, Drawable[] drawableArr) {
            super(drawableArr);
            this.mManagerWeakReference = new WeakReference<>(backgroundManager);
            int length = drawableArr.length;
            this.mWrapper = new DrawableWrapper[length];
            for (int i5 = 0; i5 < length; i5++) {
                this.mWrapper[i5] = new DrawableWrapper(drawableArr[i5]);
            }
        }

        public void clearDrawable(int i5, Context context) {
            for (int i6 = 0; i6 < getNumberOfLayers(); i6++) {
                if (getId(i6) == i5) {
                    this.mWrapper[i6] = null;
                    if (!(getDrawable(i6) instanceof EmptyDrawable)) {
                        super.setDrawableByLayerId(i5, BackgroundManager.createEmptyDrawable(context));
                        return;
                    }
                    return;
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public void draw(Canvas canvas) {
            Drawable drawable;
            int i5;
            int i6;
            int i7 = 0;
            while (true) {
                DrawableWrapper[] drawableWrapperArr = this.mWrapper;
                if (i7 < drawableWrapperArr.length) {
                    DrawableWrapper drawableWrapper = drawableWrapperArr[i7];
                    if (!(drawableWrapper == null || (drawable = drawableWrapper.getDrawable()) == null)) {
                        int alpha = DrawableCompat.getAlpha(drawable);
                        int i8 = this.mAlpha;
                        if (i8 < 255) {
                            i6 = i8 * alpha;
                            i5 = 1;
                        } else {
                            i5 = 0;
                            i6 = alpha;
                        }
                        int i9 = this.mWrapper[i7].mAlpha;
                        if (i9 < 255) {
                            i6 *= i9;
                            i5++;
                        }
                        if (i5 == 0) {
                            drawable.draw(canvas);
                        } else {
                            if (i5 == 1) {
                                i6 /= 255;
                            } else if (i5 == 2) {
                                i6 /= OggPageHeader.MAX_PAGE_PAYLOAD;
                            }
                            try {
                                this.mSuspendInvalidation = true;
                                drawable.setAlpha(i6);
                                drawable.draw(canvas);
                                drawable.setAlpha(alpha);
                                this.mSuspendInvalidation = false;
                            } catch (Throwable th) {
                                this.mSuspendInvalidation = false;
                                throw th;
                            }
                        }
                    }
                    i7++;
                } else {
                    return;
                }
            }
        }

        public int findWrapperIndexById(int i5) {
            for (int i6 = 0; i6 < getNumberOfLayers(); i6++) {
                if (getId(i6) == i5) {
                    return i6;
                }
            }
            return -1;
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public int getOpacity() {
            return -3;
        }

        public void invalidateDrawable(Drawable drawable) {
            if (!this.mSuspendInvalidation) {
                super.invalidateDrawable(drawable);
            }
        }

        public Drawable mutate() {
            Drawable mutate = super.mutate();
            int numberOfLayers = getNumberOfLayers();
            for (int i5 = 0; i5 < numberOfLayers; i5++) {
                DrawableWrapper[] drawableWrapperArr = this.mWrapper;
                DrawableWrapper drawableWrapper = drawableWrapperArr[i5];
                if (drawableWrapper != null) {
                    drawableWrapperArr[i5] = new DrawableWrapper(drawableWrapper, getDrawable(i5));
                }
            }
            return mutate;
        }

        public void setAlpha(int i5) {
            if (this.mAlpha != i5) {
                this.mAlpha = i5;
                invalidateSelf();
                BackgroundManager backgroundManager = this.mManagerWeakReference.get();
                if (backgroundManager != null) {
                    backgroundManager.postChangeRunnable();
                }
            }
        }

        public boolean setDrawableByLayerId(int i5, Drawable drawable) {
            if (updateDrawable(i5, drawable) != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setWrapperAlpha(int i5, int i6) {
            DrawableWrapper drawableWrapper = this.mWrapper[i5];
            if (drawableWrapper != null) {
                drawableWrapper.mAlpha = i6;
                invalidateSelf();
            }
        }

        public DrawableWrapper updateDrawable(int i5, Drawable drawable) {
            super.setDrawableByLayerId(i5, drawable);
            for (int i6 = 0; i6 < getNumberOfLayers(); i6++) {
                if (getId(i6) == i5) {
                    this.mWrapper[i6] = new DrawableWrapper(drawable);
                    invalidateSelf();
                    return this.mWrapper[i6];
                }
            }
            return null;
        }
    }

    private BackgroundManager(Activity activity) {
        AnonymousClass1 r02 = new Animator.AnimatorListener() {
            final Runnable mRunnable = new Runnable() {
                public void run() {
                    BackgroundManager.this.postChangeRunnable();
                }
            };

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                BackgroundManager backgroundManager = BackgroundManager.this;
                TranslucentLayerDrawable translucentLayerDrawable = backgroundManager.mLayerDrawable;
                if (translucentLayerDrawable != null) {
                    translucentLayerDrawable.clearDrawable(R.id.background_imageout, backgroundManager.mContext);
                }
                BackgroundManager.this.mHandler.post(this.mRunnable);
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        };
        this.mAnimationListener = r02;
        AnonymousClass2 r12 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BackgroundManager backgroundManager = BackgroundManager.this;
                int i5 = backgroundManager.mImageInWrapperIndex;
                if (i5 != -1) {
                    backgroundManager.mLayerDrawable.setWrapperAlpha(i5, intValue);
                }
            }
        };
        this.mAnimationUpdateListener = r12;
        this.mContext = activity;
        this.mService = BackgroundContinuityService.getInstance();
        this.mHeightPx = this.mContext.getResources().getDisplayMetrics().heightPixels;
        this.mWidthPx = this.mContext.getResources().getDisplayMetrics().widthPixels;
        this.mHandler = new Handler();
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        this.mAnimator = ofInt;
        ofInt.addListener(r02);
        ofInt.addUpdateListener(r12);
        ofInt.setInterpolator(fastOutLinearInInterpolator);
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
        this.mThemeDrawableResourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        createFragment(activity);
    }

    static Drawable createEmptyDrawable(Context context) {
        return new EmptyDrawable(context.getResources());
    }

    private void createFragment(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        String str = FRAGMENT_TAG;
        BackgroundFragment backgroundFragment = (BackgroundFragment) fragmentManager.findFragmentByTag(str);
        if (backgroundFragment == null) {
            backgroundFragment = new BackgroundFragment();
            activity.getFragmentManager().beginTransaction().add(backgroundFragment, str).commit();
        } else if (backgroundFragment.getBackgroundManager() != null) {
            throw new IllegalStateException("Created duplicated BackgroundManager for same activity, please use getInstance() instead");
        }
        backgroundFragment.setBackgroundManager(this);
        this.mFragmentState = backgroundFragment;
    }

    public static BackgroundManager getInstance(Activity activity) {
        BackgroundManager backgroundManager;
        BackgroundFragment backgroundFragment = (BackgroundFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (backgroundFragment == null || (backgroundManager = backgroundFragment.getBackgroundManager()) == null) {
            return new BackgroundManager(activity);
        }
        return backgroundManager;
    }

    private long getRunnableDelay() {
        return Math.max(0, (this.mLastSetTime + 500) - System.currentTimeMillis());
    }

    private Drawable getThemeDrawable() {
        Drawable drawable;
        int i5 = this.mThemeDrawableResourceId;
        if (i5 != -1) {
            drawable = this.mService.getThemeDrawable(this.mContext, i5);
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return createEmptyDrawable(this.mContext);
        }
        return drawable;
    }

    private void lazyInit() {
        if (this.mLayerDrawable == null) {
            TranslucentLayerDrawable createTranslucentLayerDrawable = createTranslucentLayerDrawable((LayerDrawable) ContextCompat.getDrawable(this.mContext, R.drawable.lb_background).mutate());
            this.mLayerDrawable = createTranslucentLayerDrawable;
            this.mImageInWrapperIndex = createTranslucentLayerDrawable.findWrapperIndexById(R.id.background_imagein);
            this.mImageOutWrapperIndex = this.mLayerDrawable.findWrapperIndexById(R.id.background_imageout);
            if (this.mBgView.getBackground() != null) {
                this.mLayerDrawable.setAlpha(this.mBgView.getBackground().getAlpha());
            }
            this.mBgView.setBackground(this.mLayerDrawable);
        }
    }

    private void setDrawableInternal(Drawable drawable) {
        if (this.mAttached) {
            ChangeBackgroundRunnable changeBackgroundRunnable = this.mChangeRunnable;
            if (changeBackgroundRunnable != null) {
                if (!sameDrawable(drawable, changeBackgroundRunnable.mDrawable)) {
                    this.mHandler.removeCallbacks(this.mChangeRunnable);
                    this.mChangeRunnable = null;
                } else {
                    return;
                }
            }
            this.mChangeRunnable = new ChangeBackgroundRunnable(drawable);
            this.mChangeRunnablePending = true;
            postChangeRunnable();
            return;
        }
        throw new IllegalStateException("Must attach before setting background drawable");
    }

    private void syncWithService() {
        Drawable drawable;
        int color = this.mService.getColor();
        Drawable drawable2 = this.mService.getDrawable();
        this.mBackgroundColor = color;
        if (drawable2 == null) {
            drawable = null;
        } else {
            drawable = drawable2.getConstantState().newDrawable().mutate();
        }
        this.mBackgroundDrawable = drawable;
        updateImmediate();
    }

    private void updateImmediate() {
        if (this.mAttached) {
            lazyInit();
            Drawable drawable = this.mBackgroundDrawable;
            if (drawable == null) {
                this.mLayerDrawable.updateDrawable(R.id.background_imagein, getDefaultDrawable());
            } else {
                this.mLayerDrawable.updateDrawable(R.id.background_imagein, drawable);
            }
            this.mLayerDrawable.clearDrawable(R.id.background_imageout, this.mContext);
        }
    }

    public void attach(Window window) {
        attachToViewInternal(window.getDecorView());
    }

    public void attachToView(View view) {
        ColorDrawable colorDrawable;
        attachToViewInternal(view);
        View decorView = this.mContext.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 26) {
            colorDrawable = null;
        } else {
            colorDrawable = new ColorDrawable(0);
        }
        decorView.setBackground(colorDrawable);
    }

    /* access modifiers changed from: package-private */
    public void attachToViewInternal(View view) {
        if (!this.mAttached) {
            this.mBgView = view;
            this.mAttached = true;
            syncWithService();
            return;
        }
        throw new IllegalStateException("Already attached to " + this.mBgView);
    }

    public void clearDrawable() {
        setDrawable((Drawable) null);
    }

    /* access modifiers changed from: package-private */
    public TranslucentLayerDrawable createTranslucentLayerDrawable(LayerDrawable layerDrawable) {
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i5 = 0; i5 < numberOfLayers; i5++) {
            drawableArr[i5] = layerDrawable.getDrawable(i5);
        }
        TranslucentLayerDrawable translucentLayerDrawable = new TranslucentLayerDrawable(this, drawableArr);
        for (int i6 = 0; i6 < numberOfLayers; i6++) {
            translucentLayerDrawable.setId(i6, layerDrawable.getId(i6));
        }
        return translucentLayerDrawable;
    }

    /* access modifiers changed from: package-private */
    public void detach() {
        release();
        this.mBgView = null;
        this.mAttached = false;
        BackgroundContinuityService backgroundContinuityService = this.mService;
        if (backgroundContinuityService != null) {
            backgroundContinuityService.unref();
            this.mService = null;
        }
    }

    @ColorInt
    public final int getColor() {
        return this.mBackgroundColor;
    }

    @Deprecated
    public Drawable getDefaultDimLayer() {
        return ContextCompat.getDrawable(this.mContext, R.color.lb_background_protection);
    }

    /* access modifiers changed from: package-private */
    public Drawable getDefaultDrawable() {
        if (this.mBackgroundColor != 0) {
            return new ColorDrawable(this.mBackgroundColor);
        }
        return getThemeDrawable();
    }

    @Deprecated
    public Drawable getDimLayer() {
        return null;
    }

    public Drawable getDrawable() {
        return this.mBackgroundDrawable;
    }

    /* access modifiers changed from: package-private */
    public DrawableWrapper getImageInWrapper() {
        TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
        if (translucentLayerDrawable == null) {
            return null;
        }
        return translucentLayerDrawable.mWrapper[this.mImageInWrapperIndex];
    }

    /* access modifiers changed from: package-private */
    public DrawableWrapper getImageOutWrapper() {
        TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
        if (translucentLayerDrawable == null) {
            return null;
        }
        return translucentLayerDrawable.mWrapper[this.mImageOutWrapperIndex];
    }

    public boolean isAttached() {
        return this.mAttached;
    }

    public boolean isAutoReleaseOnStop() {
        return this.mAutoReleaseOnStop;
    }

    /* access modifiers changed from: package-private */
    public void onActivityStart() {
        updateImmediate();
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        postChangeRunnable();
    }

    /* access modifiers changed from: package-private */
    public void onStop() {
        if (isAutoReleaseOnStop()) {
            release();
        }
    }

    /* access modifiers changed from: package-private */
    public void postChangeRunnable() {
        if (this.mChangeRunnable != null && this.mChangeRunnablePending && !this.mAnimator.isStarted() && this.mFragmentState.isResumed() && this.mLayerDrawable.getAlpha() >= 255) {
            long runnableDelay = getRunnableDelay();
            this.mLastSetTime = System.currentTimeMillis();
            this.mHandler.postDelayed(this.mChangeRunnable, runnableDelay);
            this.mChangeRunnablePending = false;
        }
    }

    public void release() {
        ChangeBackgroundRunnable changeBackgroundRunnable = this.mChangeRunnable;
        if (changeBackgroundRunnable != null) {
            this.mHandler.removeCallbacks(changeBackgroundRunnable);
            this.mChangeRunnable = null;
        }
        if (this.mAnimator.isStarted()) {
            this.mAnimator.cancel();
        }
        TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
        if (translucentLayerDrawable != null) {
            translucentLayerDrawable.clearDrawable(R.id.background_imagein, this.mContext);
            this.mLayerDrawable.clearDrawable(R.id.background_imageout, this.mContext);
            this.mLayerDrawable = null;
        }
        this.mBackgroundDrawable = null;
    }

    /* access modifiers changed from: package-private */
    public boolean sameDrawable(Drawable drawable, Drawable drawable2) {
        if (!(drawable == null || drawable2 == null)) {
            if (drawable == drawable2) {
                return true;
            }
            if ((drawable instanceof BitmapDrawable) && (drawable2 instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap().sameAs(((BitmapDrawable) drawable2).getBitmap())) {
                return true;
            }
            if (!(drawable instanceof ColorDrawable) || !(drawable2 instanceof ColorDrawable) || ((ColorDrawable) drawable).getColor() != ((ColorDrawable) drawable2).getColor()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void setAutoReleaseOnStop(boolean z4) {
        this.mAutoReleaseOnStop = z4;
    }

    public void setBitmap(Bitmap bitmap) {
        float f5;
        Matrix matrix = null;
        if (bitmap == null) {
            setDrawable((Drawable) null);
        } else if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            if (!(bitmap.getWidth() == this.mWidthPx && bitmap.getHeight() == this.mHeightPx)) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i5 = this.mHeightPx;
                int i6 = width * i5;
                int i7 = this.mWidthPx;
                if (i6 > i7 * height) {
                    f5 = ((float) i5) / ((float) height);
                } else {
                    f5 = ((float) i7) / ((float) width);
                }
                int max = Math.max(0, (width - Math.min((int) (((float) i7) / f5), width)) / 2);
                Matrix matrix2 = new Matrix();
                matrix2.setScale(f5, f5);
                matrix2.preTranslate((float) (-max), 0.0f);
                matrix = matrix2;
            }
            setDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap, matrix));
        }
    }

    public void setColor(@ColorInt int i5) {
        this.mService.setColor(i5);
        this.mBackgroundColor = i5;
        this.mBackgroundDrawable = null;
        if (this.mLayerDrawable != null) {
            setDrawableInternal(getDefaultDrawable());
        }
    }

    @Deprecated
    public void setDimLayer(Drawable drawable) {
    }

    public void setDrawable(Drawable drawable) {
        this.mService.setDrawable(drawable);
        this.mBackgroundDrawable = drawable;
        if (this.mLayerDrawable != null) {
            if (drawable == null) {
                setDrawableInternal(getDefaultDrawable());
            } else {
                setDrawableInternal(drawable);
            }
        }
    }

    public void setThemeDrawableResourceId(int i5) {
        this.mThemeDrawableResourceId = i5;
    }

    static final class DrawableWrapper {
        int mAlpha = 255;
        final Drawable mDrawable;

        public DrawableWrapper(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public void setColor(int i5) {
            ((ColorDrawable) this.mDrawable).setColor(i5);
        }

        public DrawableWrapper(DrawableWrapper drawableWrapper, Drawable drawable) {
            this.mDrawable = drawable;
            this.mAlpha = drawableWrapper.mAlpha;
        }
    }
}
