package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleViewAdapter;

public class TitleView extends FrameLayout implements TitleViewAdapter.Provider {
    private int flags;
    private ImageView mBadgeView;
    private boolean mHasSearchListener;
    private SearchOrbView mSearchOrbView;
    private TextView mTextView;
    private final TitleViewAdapter mTitleViewAdapter;

    public TitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void updateBadgeVisibility() {
        if (this.mBadgeView.getDrawable() != null) {
            this.mBadgeView.setVisibility(0);
            this.mTextView.setVisibility(8);
            return;
        }
        this.mBadgeView.setVisibility(8);
        this.mTextView.setVisibility(0);
    }

    private void updateSearchOrbViewVisiblity() {
        int i5 = 4;
        if (this.mHasSearchListener && (this.flags & 4) == 4) {
            i5 = 0;
        }
        this.mSearchOrbView.setVisibility(i5);
    }

    public void enableAnimation(boolean z4) {
        boolean z5;
        SearchOrbView searchOrbView = this.mSearchOrbView;
        if (!z4 || !searchOrbView.hasFocus()) {
            z5 = false;
        } else {
            z5 = true;
        }
        searchOrbView.enableOrbColorAnimation(z5);
    }

    public Drawable getBadgeDrawable() {
        return this.mBadgeView.getDrawable();
    }

    public SearchOrbView.Colors getSearchAffordanceColors() {
        return this.mSearchOrbView.getOrbColors();
    }

    public View getSearchAffordanceView() {
        return this.mSearchOrbView;
    }

    public CharSequence getTitle() {
        return this.mTextView.getText();
    }

    public TitleViewAdapter getTitleViewAdapter() {
        return this.mTitleViewAdapter;
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.mBadgeView.setImageDrawable(drawable);
        updateBadgeVisibility();
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        boolean z4;
        if (onClickListener != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mHasSearchListener = z4;
        this.mSearchOrbView.setOnOrbClickedListener(onClickListener);
        updateSearchOrbViewVisiblity();
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        this.mSearchOrbView.setOrbColors(colors);
    }

    public void setTitle(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
        updateBadgeVisibility();
    }

    public void updateComponentsVisibility(int i5) {
        this.flags = i5;
        if ((i5 & 2) == 2) {
            updateBadgeVisibility();
        } else {
            this.mBadgeView.setVisibility(8);
            this.mTextView.setVisibility(8);
        }
        updateSearchOrbViewVisiblity();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.browseTitleViewStyle);
    }

    public TitleView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.flags = 6;
        this.mHasSearchListener = false;
        this.mTitleViewAdapter = new TitleViewAdapter() {
            public Drawable getBadgeDrawable() {
                return TitleView.this.getBadgeDrawable();
            }

            public SearchOrbView.Colors getSearchAffordanceColors() {
                return TitleView.this.getSearchAffordanceColors();
            }

            public View getSearchAffordanceView() {
                return TitleView.this.getSearchAffordanceView();
            }

            public CharSequence getTitle() {
                return TitleView.this.getTitle();
            }

            public void setAnimationEnabled(boolean z4) {
                TitleView.this.enableAnimation(z4);
            }

            public void setBadgeDrawable(Drawable drawable) {
                TitleView.this.setBadgeDrawable(drawable);
            }

            public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
                TitleView.this.setOnSearchClickedListener(onClickListener);
            }

            public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
                TitleView.this.setSearchAffordanceColors(colors);
            }

            public void setTitle(CharSequence charSequence) {
                TitleView.this.setTitle(charSequence);
            }

            public void updateComponentsVisibility(int i5) {
                TitleView.this.updateComponentsVisibility(i5);
            }
        };
        View inflate = LayoutInflater.from(context).inflate(R.layout.lb_title_view, this);
        this.mBadgeView = (ImageView) inflate.findViewById(R.id.title_badge);
        this.mTextView = (TextView) inflate.findViewById(R.id.title_text);
        this.mSearchOrbView = (SearchOrbView) inflate.findViewById(R.id.title_orb);
        setClipToPadding(false);
        setClipChildren(false);
    }
}
