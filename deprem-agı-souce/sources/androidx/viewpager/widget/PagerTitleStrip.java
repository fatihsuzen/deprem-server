package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] ATTRS = {16842804, 16842901, 16842904, 16842927};
    private static final float SIDE_ALPHA = 0.6f;
    private static final int[] TEXT_ATTRS = {16843660};
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;

        PageListener() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.updateAdapter(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f5 = pagerTitleStrip2.mLastKnownPositionOffset;
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f5, true);
        }

        public void onPageScrollStateChanged(int i5) {
            this.mScrollState = i5;
        }

        public void onPageScrolled(int i5, float f5, int i6) {
            if (f5 > 0.5f) {
                i5++;
            }
            PagerTitleStrip.this.updateTextPositions(i5, f5, false);
        }

        public void onPageSelected(int i5) {
            if (this.mScrollState == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f5 = pagerTitleStrip2.mLastKnownPositionOffset;
                if (f5 < 0.0f) {
                    f5 = 0.0f;
                }
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f5, true);
            }
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        SingleLineAllCapsTransform(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.mPageListener);
            viewPager.addOnAdapterChangeListener(this.mPageListener);
            this.mPager = viewPager;
            WeakReference<PagerAdapter> weakReference = this.mWatchingAdapter;
            if (weakReference != null) {
                pagerAdapter = weakReference.get();
            } else {
                pagerAdapter = null;
            }
            updateAdapter(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            updateAdapter(viewPager.getAdapter(), (PagerAdapter) null);
            this.mPager.setInternalPageChangeListener((ViewPager.OnPageChangeListener) null);
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        if (this.mPager != null) {
            float f5 = this.mLastKnownPositionOffset;
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f5, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7;
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i5);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, (int) (((float) size) * 0.2f), -2);
            this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
            this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
            this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i6) == 1073741824) {
                i7 = View.MeasureSpec.getSize(i6);
            } else {
                i7 = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i7, i6, this.mCurrText.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    public void setGravity(int i5) {
        this.mGravity = i5;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        int i5 = ((int) (f5 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = i5;
        int i6 = (i5 << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(i6);
        this.mNextText.setTextColor(i6);
    }

    public void setTextColor(@ColorInt int i5) {
        this.mTextColor = i5;
        this.mCurrText.setTextColor(i5);
        int i6 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & ViewCompat.MEASURED_SIZE_MASK);
        this.mPrevText.setTextColor(i6);
        this.mNextText.setTextColor(i6);
    }

    public void setTextSize(int i5, float f5) {
        this.mPrevText.setTextSize(i5, f5);
        this.mCurrText.setTextSize(i5, f5);
        this.mNextText.setTextSize(i5, f5);
    }

    public void setTextSpacing(int i5) {
        this.mScaledTextSpacing = i5;
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateText(int i5, PagerAdapter pagerAdapter) {
        int i6;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i6 = pagerAdapter.getCount();
        } else {
            i6 = 0;
        }
        this.mUpdatingText = true;
        CharSequence charSequence3 = null;
        if (i5 < 1 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.getPageTitle(i5 - 1);
        }
        this.mPrevText.setText(charSequence);
        TextView textView = this.mCurrText;
        if (pagerAdapter == null || i5 >= i6) {
            charSequence2 = null;
        } else {
            charSequence2 = pagerAdapter.getPageTitle(i5);
        }
        textView.setText(charSequence2);
        int i7 = i5 + 1;
        if (i7 < i6 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i7);
        }
        this.mNextText.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mLastKnownCurrentPage = i5;
        if (!this.mUpdatingPositions) {
            updateTextPositions(i5, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    /* access modifiers changed from: package-private */
    public void updateTextPositions(int i5, float f5, boolean z4) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i5;
        float f6 = f5;
        if (i10 != this.mLastKnownCurrentPage) {
            updateText(i10, this.mPager.getAdapter());
        } else if (!z4 && f6 == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int i11 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i12 = paddingRight + i11;
        int i13 = (width - (paddingLeft + i11)) - i12;
        float f7 = 0.5f + f6;
        if (f7 > 1.0f) {
            f7 -= 1.0f;
        }
        int i14 = ((width - i12) - ((int) (((float) i13) * f7))) - i11;
        int i15 = measuredWidth2 + i14;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i16 = max - baseline;
        int i17 = max - baseline2;
        int i18 = max - baseline3;
        int i19 = measuredWidth;
        int i20 = measuredWidth3;
        int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i16, this.mCurrText.getMeasuredHeight() + i17), this.mNextText.getMeasuredHeight() + i18);
        int i21 = this.mGravity & 112;
        if (i21 == 16) {
            i9 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i21 != 80) {
            i8 = i16 + paddingTop;
            i6 = i17 + paddingTop;
            i7 = paddingTop + i18;
            TextView textView = this.mCurrText;
            textView.layout(i14, i6, i15, textView.getMeasuredHeight() + i6);
            int min = Math.min(paddingLeft, (i14 - this.mScaledTextSpacing) - i19);
            TextView textView2 = this.mPrevText;
            textView2.layout(min, i8, min + i19, textView2.getMeasuredHeight() + i8);
            int max3 = Math.max((width - paddingRight) - i20, i15 + this.mScaledTextSpacing);
            TextView textView3 = this.mNextText;
            textView3.layout(max3, i7, max3 + i20, textView3.getMeasuredHeight() + i7);
            this.mLastKnownPositionOffset = f6;
            this.mUpdatingPositions = false;
        } else {
            i9 = (height - paddingBottom) - max2;
        }
        i8 = i16 + i9;
        i6 = i17 + i9;
        i7 = i9 + i18;
        TextView textView4 = this.mCurrText;
        textView4.layout(i14, i6, i15, textView4.getMeasuredHeight() + i6);
        int min2 = Math.min(paddingLeft, (i14 - this.mScaledTextSpacing) - i19);
        TextView textView22 = this.mPrevText;
        textView22.layout(min2, i8, min2 + i19, textView22.getMeasuredHeight() + i8);
        int max32 = Math.max((width - paddingRight) - i20, i15 + this.mScaledTextSpacing);
        TextView textView32 = this.mNextText;
        textView32.layout(max32, i7, max32 + i20, textView32.getMeasuredHeight() + i7);
        this.mLastKnownPositionOffset = f6;
        this.mUpdatingPositions = false;
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        boolean z4 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        TextView textView4 = this.mPrevText;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.mCurrText.setEllipsize(truncateAt);
        this.mNextText.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z4 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z4) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
