package androidx.leanback.widget;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.leanback.widget.Presenter;

public class RowHeaderPresenter extends Presenter {
    private final boolean mAnimateSelect;
    private final Paint mFontMeasurePaint;
    private final int mLayoutResourceId;
    private boolean mNullItemVisibilityGone;

    public RowHeaderPresenter() {
        this(R.layout.lb_row_header);
    }

    protected static float getFontDescent(TextView textView, Paint paint) {
        if (paint.getTextSize() != textView.getTextSize()) {
            paint.setTextSize(textView.getTextSize());
        }
        if (paint.getTypeface() != textView.getTypeface()) {
            paint.setTypeface(textView.getTypeface());
        }
        return paint.descent();
    }

    public int getSpaceUnderBaseline(ViewHolder viewHolder) {
        int paddingBottom = viewHolder.view.getPaddingBottom();
        View view = viewHolder.view;
        if (view instanceof TextView) {
            return paddingBottom + ((int) getFontDescent((TextView) view, this.mFontMeasurePaint));
        }
        return paddingBottom;
    }

    public boolean isNullItemVisibilityGone() {
        return this.mNullItemVisibilityGone;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        HeaderItem headerItem;
        if (obj == null) {
            headerItem = null;
        } else {
            headerItem = ((Row) obj).getHeaderItem();
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (headerItem == null) {
            RowHeaderView rowHeaderView = viewHolder2.mTitleView;
            if (rowHeaderView != null) {
                rowHeaderView.setText((CharSequence) null);
            }
            TextView textView = viewHolder2.mDescriptionView;
            if (textView != null) {
                textView.setText((CharSequence) null);
            }
            viewHolder.view.setContentDescription((CharSequence) null);
            if (this.mNullItemVisibilityGone) {
                viewHolder.view.setVisibility(8);
                return;
            }
            return;
        }
        RowHeaderView rowHeaderView2 = viewHolder2.mTitleView;
        if (rowHeaderView2 != null) {
            rowHeaderView2.setText(headerItem.getName());
        }
        if (viewHolder2.mDescriptionView != null) {
            if (TextUtils.isEmpty(headerItem.getDescription())) {
                viewHolder2.mDescriptionView.setVisibility(8);
            } else {
                viewHolder2.mDescriptionView.setVisibility(0);
            }
            viewHolder2.mDescriptionView.setText(headerItem.getDescription());
        }
        viewHolder.view.setContentDescription(headerItem.getContentDescription());
        viewHolder.view.setVisibility(0);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.mLayoutResourceId, viewGroup, false));
        if (this.mAnimateSelect) {
            setSelectLevel(viewHolder, 0.0f);
        }
        return viewHolder;
    }

    /* access modifiers changed from: protected */
    public void onSelectLevelChanged(ViewHolder viewHolder) {
        if (this.mAnimateSelect) {
            View view = viewHolder.view;
            float f5 = viewHolder.mUnselectAlpha;
            view.setAlpha(f5 + (viewHolder.mSelectLevel * (1.0f - f5)));
        }
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        RowHeaderView rowHeaderView = viewHolder2.mTitleView;
        if (rowHeaderView != null) {
            rowHeaderView.setText((CharSequence) null);
        }
        TextView textView = viewHolder2.mDescriptionView;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (this.mAnimateSelect) {
            setSelectLevel(viewHolder2, 0.0f);
        }
    }

    public void setNullItemVisibilityGone(boolean z4) {
        this.mNullItemVisibilityGone = z4;
    }

    public final void setSelectLevel(ViewHolder viewHolder, float f5) {
        viewHolder.mSelectLevel = f5;
        onSelectLevelChanged(viewHolder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RowHeaderPresenter(int i5) {
        this(i5, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RowHeaderPresenter(int i5, boolean z4) {
        this.mFontMeasurePaint = new Paint(1);
        this.mLayoutResourceId = i5;
        this.mAnimateSelect = z4;
    }

    public static class ViewHolder extends Presenter.ViewHolder {
        TextView mDescriptionView;
        int mOriginalTextColor;
        float mSelectLevel;
        RowHeaderView mTitleView;
        float mUnselectAlpha;

        public ViewHolder(View view) {
            super(view);
            this.mTitleView = (RowHeaderView) view.findViewById(R.id.row_header);
            this.mDescriptionView = (TextView) view.findViewById(R.id.row_header_description);
            initColors();
        }

        public final float getSelectLevel() {
            return this.mSelectLevel;
        }

        /* access modifiers changed from: package-private */
        public void initColors() {
            RowHeaderView rowHeaderView = this.mTitleView;
            if (rowHeaderView != null) {
                this.mOriginalTextColor = rowHeaderView.getCurrentTextColor();
            }
            this.mUnselectAlpha = this.view.getResources().getFraction(R.fraction.lb_browse_header_unselect_alpha, 1, 1);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewHolder(RowHeaderView rowHeaderView) {
            super(rowHeaderView);
            this.mTitleView = rowHeaderView;
            initColors();
        }
    }
}
