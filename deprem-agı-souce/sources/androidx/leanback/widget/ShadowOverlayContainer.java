package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.leanback.R;

public class ShadowOverlayContainer extends FrameLayout {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;
    private static final Rect sTempRect = new Rect();
    private float mFocusedZ;
    private boolean mInitialized;
    int mOverlayColor;
    private Paint mOverlayPaint;
    private int mRoundedCornerRadius;
    private boolean mRoundedCorners;
    private Object mShadowImpl;
    private int mShadowType;
    private float mUnfocusedZ;
    private View mWrappedView;

    public ShadowOverlayContainer(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public static void prepareParentForShadow(ViewGroup viewGroup) {
        StaticShadowHelper.prepareParent(viewGroup);
    }

    public static boolean supportsDynamicShadow() {
        return ShadowHelper.supportsDynamicShadow();
    }

    public static boolean supportsShadow() {
        return StaticShadowHelper.supportsShadow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mOverlayPaint != null && this.mOverlayColor != 0) {
            canvas.drawRect((float) this.mWrappedView.getLeft(), (float) this.mWrappedView.getTop(), (float) this.mWrappedView.getRight(), (float) this.mWrappedView.getBottom(), this.mOverlayPaint);
        }
    }

    public int getShadowType() {
        return this.mShadowType;
    }

    public View getWrappedView() {
        return this.mWrappedView;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    @Deprecated
    public void initialize(boolean z4, boolean z5) {
        initialize(z4, z5, true);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        View view;
        super.onLayout(z4, i5, i6, i7, i8);
        boolean z5 = z4;
        if (z5 && (view = this.mWrappedView) != null) {
            Rect rect = sTempRect;
            rect.left = (int) view.getPivotX();
            rect.top = (int) this.mWrappedView.getPivotY();
            offsetDescendantRectToMyCoords(this.mWrappedView, rect);
            setPivotX((float) rect.left);
            setPivotY((float) rect.top);
        }
    }

    public void setOverlayColor(@ColorInt int i5) {
        Paint paint = this.mOverlayPaint;
        if (paint != null && i5 != this.mOverlayColor) {
            this.mOverlayColor = i5;
            paint.setColor(i5);
            invalidate();
        }
    }

    public void setShadowFocusLevel(float f5) {
        Object obj = this.mShadowImpl;
        if (obj != null) {
            ShadowOverlayHelper.setShadowFocusLevel(obj, this.mShadowType, f5);
        }
    }

    public void useDynamicShadow() {
        useDynamicShadow(getResources().getDimension(R.dimen.lb_material_shadow_normal_z), getResources().getDimension(R.dimen.lb_material_shadow_focused_z));
    }

    public void useStaticShadow() {
        if (this.mInitialized) {
            throw new IllegalStateException("Already initialized");
        } else if (supportsShadow()) {
            this.mShadowType = 2;
        }
    }

    public void wrap(View view) {
        int i5;
        if (!this.mInitialized || this.mWrappedView != null) {
            throw new IllegalStateException();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            int i6 = -2;
            if (layoutParams.width == -1) {
                i5 = -1;
            } else {
                i5 = -2;
            }
            layoutParams.width = i5;
            if (layoutParams.height == -1) {
                i6 = -1;
            }
            layoutParams.height = i6;
            setLayoutParams(layoutParams);
            addView(view, layoutParams2);
        } else {
            addView(view);
        }
        if (this.mRoundedCorners && this.mShadowType != 3) {
            RoundedRectHelper.setClipToRoundedOutline(this, true);
        }
        this.mWrappedView = view;
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void initialize(boolean z4, boolean z5, boolean z6) {
        initialize(!z4 ? 1 : this.mShadowType, z5, z6 ? getContext().getResources().getDimensionPixelSize(R.dimen.lb_rounded_rect_corner_radius) : 0);
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mShadowType = 1;
        useStaticShadow();
        useDynamicShadow();
    }

    public void useDynamicShadow(float f5, float f6) {
        if (this.mInitialized) {
            throw new IllegalStateException("Already initialized");
        } else if (supportsDynamicShadow()) {
            this.mShadowType = 3;
            this.mUnfocusedZ = f5;
            this.mFocusedZ = f6;
        }
    }

    /* access modifiers changed from: package-private */
    public void initialize(int i5, boolean z4, int i6) {
        if (!this.mInitialized) {
            this.mInitialized = true;
            this.mRoundedCornerRadius = i6;
            this.mRoundedCorners = i6 > 0;
            this.mShadowType = i5;
            if (i5 == 2) {
                this.mShadowImpl = StaticShadowHelper.addStaticShadow(this);
            } else if (i5 == 3) {
                this.mShadowImpl = ShadowHelper.addDynamicShadow(this, this.mUnfocusedZ, this.mFocusedZ, i6);
            }
            if (z4) {
                setWillNotDraw(false);
                this.mOverlayColor = 0;
                Paint paint = new Paint();
                this.mOverlayPaint = paint;
                paint.setColor(this.mOverlayColor);
                this.mOverlayPaint.setStyle(Paint.Style.FILL);
                return;
            }
            setWillNotDraw(true);
            this.mOverlayPaint = null;
            return;
        }
        throw new IllegalStateException();
    }

    ShadowOverlayContainer(Context context, int i5, boolean z4, float f5, float f6, int i6) {
        super(context);
        this.mShadowType = 1;
        this.mUnfocusedZ = f5;
        this.mFocusedZ = f6;
        initialize(i5, z4, i6);
    }
}
