package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ThumbsBar extends LinearLayout {
    final SparseArray<Bitmap> mBitmaps;
    int mHeroThumbHeightInPixel;
    int mHeroThumbWidthInPixel;
    private boolean mIsUserSets;
    int mMeasuredMarginInPixel;
    int mNumOfThumbs;
    int mThumbHeightInPixel;
    int mThumbWidthInPixel;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int calculateNumOfThumbs(int i5) {
        int roundUp = roundUp(i5 - this.mHeroThumbWidthInPixel, this.mThumbWidthInPixel + this.mMeasuredMarginInPixel);
        if (roundUp < 2) {
            roundUp = 2;
        } else if ((roundUp & 1) != 0) {
            roundUp++;
        }
        return roundUp + 1;
    }

    private static int roundUp(int i5, int i6) {
        return ((i5 + i6) - 1) / i6;
    }

    private void setNumberOfThumbsInternal() {
        while (getChildCount() > this.mNumOfThumbs) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (getChildCount() < this.mNumOfThumbs) {
            addView(createThumbView(this), new LinearLayout.LayoutParams(this.mThumbWidthInPixel, this.mThumbHeightInPixel));
        }
        int heroIndex = getHeroIndex();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i5) {
                layoutParams.width = this.mHeroThumbWidthInPixel;
                layoutParams.height = this.mHeroThumbHeightInPixel;
            } else {
                layoutParams.width = this.mThumbWidthInPixel;
                layoutParams.height = this.mThumbHeightInPixel;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void clearThumbBitmaps() {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            setThumbBitmap(i5, (Bitmap) null);
        }
        this.mBitmaps.clear();
    }

    /* access modifiers changed from: protected */
    public View createThumbView(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    public Bitmap getThumbBitmap(int i5) {
        return this.mBitmaps.get(i5);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int width2 = (getWidth() / 2) + (childAt.getMeasuredWidth() / 2);
        childAt.layout(width, getPaddingTop(), width2, getPaddingTop() + childAt.getMeasuredHeight());
        int paddingTop = getPaddingTop() + (childAt.getMeasuredHeight() / 2);
        for (int i9 = heroIndex - 1; i9 >= 0; i9--) {
            int i10 = width - this.mMeasuredMarginInPixel;
            View childAt2 = getChildAt(i9);
            childAt2.layout(i10 - childAt2.getMeasuredWidth(), paddingTop - (childAt2.getMeasuredHeight() / 2), i10, (childAt2.getMeasuredHeight() / 2) + paddingTop);
            width = i10 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex < this.mNumOfThumbs) {
                int i11 = width2 + this.mMeasuredMarginInPixel;
                View childAt3 = getChildAt(heroIndex);
                childAt3.layout(i11, paddingTop - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i11, (childAt3.getMeasuredHeight() / 2) + paddingTop);
                width2 = i11 + childAt3.getMeasuredWidth();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int calculateNumOfThumbs;
        super.onMeasure(i5, i6);
        int measuredWidth = getMeasuredWidth();
        if (!this.mIsUserSets && this.mNumOfThumbs != (calculateNumOfThumbs = calculateNumOfThumbs(measuredWidth))) {
            this.mNumOfThumbs = calculateNumOfThumbs;
            setNumberOfThumbsInternal();
        }
    }

    public void setHeroThumbSize(int i5, int i6) {
        boolean z4;
        this.mHeroThumbHeightInPixel = i6;
        this.mHeroThumbWidthInPixel = i5;
        int heroIndex = getHeroIndex();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if (heroIndex == i7) {
                View childAt = getChildAt(i7);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z5 = true;
                if (layoutParams.height != i6) {
                    layoutParams.height = i6;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (layoutParams.width != i5) {
                    layoutParams.width = i5;
                } else {
                    z5 = z4;
                }
                if (z5) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setNumberOfThumbs(int i5) {
        this.mIsUserSets = true;
        this.mNumOfThumbs = i5;
        setNumberOfThumbsInternal();
    }

    public void setThumbBitmap(int i5, Bitmap bitmap) {
        this.mBitmaps.put(i5, bitmap);
        ((ImageView) getChildAt(i5)).setImageBitmap(bitmap);
    }

    public void setThumbSize(int i5, int i6) {
        boolean z4;
        this.mThumbHeightInPixel = i6;
        this.mThumbWidthInPixel = i5;
        int heroIndex = getHeroIndex();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if (heroIndex != i7) {
                View childAt = getChildAt(i7);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z5 = true;
                if (layoutParams.height != i6) {
                    layoutParams.height = i6;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (layoutParams.width != i5) {
                    layoutParams.width = i5;
                } else {
                    z5 = z4;
                }
                if (z5) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setThumbSpace(int i5) {
        this.mMeasuredMarginInPixel = i5;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mNumOfThumbs = -1;
        this.mBitmaps = new SparseArray<>();
        this.mIsUserSets = false;
        this.mThumbWidthInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_width);
        this.mThumbHeightInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_height);
        this.mHeroThumbHeightInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_width);
        this.mHeroThumbWidthInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_height);
        this.mMeasuredMarginInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_margin);
    }
}
