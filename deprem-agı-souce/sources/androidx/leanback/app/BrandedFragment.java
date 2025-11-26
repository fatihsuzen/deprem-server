package androidx.leanback.app;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleHelper;
import androidx.leanback.widget.TitleViewAdapter;

@Deprecated
public class BrandedFragment extends Fragment {
    private static final String TITLE_SHOW = "titleShow";
    private Drawable mBadgeDrawable;
    private View.OnClickListener mExternalOnSearchClickedListener;
    private boolean mSearchAffordanceColorSet;
    private SearchOrbView.Colors mSearchAffordanceColors;
    private boolean mShowingTitle = true;
    private CharSequence mTitle;
    private TitleHelper mTitleHelper;
    private View mTitleView;
    private TitleViewAdapter mTitleViewAdapter;

    public Drawable getBadgeDrawable() {
        return this.mBadgeDrawable;
    }

    public int getSearchAffordanceColor() {
        return getSearchAffordanceColors().color;
    }

    public SearchOrbView.Colors getSearchAffordanceColors() {
        if (this.mSearchAffordanceColorSet) {
            return this.mSearchAffordanceColors;
        }
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            return titleViewAdapter.getSearchAffordanceColors();
        }
        throw new IllegalStateException("Fragment views not yet created");
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    /* access modifiers changed from: package-private */
    public TitleHelper getTitleHelper() {
        return this.mTitleHelper;
    }

    public View getTitleView() {
        return this.mTitleView;
    }

    public TitleViewAdapter getTitleViewAdapter() {
        return this.mTitleViewAdapter;
    }

    public void installTitleView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onInflateTitleView = onInflateTitleView(layoutInflater, viewGroup, bundle);
        if (onInflateTitleView != null) {
            viewGroup.addView(onInflateTitleView);
            setTitleView(onInflateTitleView.findViewById(R.id.browse_title_group));
            return;
        }
        setTitleView((View) null);
    }

    public final boolean isShowingTitle() {
        return this.mShowingTitle;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mTitleHelper = null;
        this.mTitleView = null;
        this.mTitleViewAdapter = null;
    }

    public View onInflateTitleView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5;
        TypedValue typedValue = new TypedValue();
        if (viewGroup == null || !viewGroup.getContext().getTheme().resolveAttribute(R.attr.browseTitleViewLayout, typedValue, true)) {
            i5 = R.layout.lb_browse_title;
        } else {
            i5 = typedValue.resourceId;
        }
        return layoutInflater.inflate(i5, viewGroup, false);
    }

    public void onPause() {
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            titleViewAdapter.setAnimationEnabled(false);
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            titleViewAdapter.setAnimationEnabled(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(TITLE_SHOW, this.mShowingTitle);
    }

    public void onStart() {
        super.onStart();
        if (this.mTitleViewAdapter != null) {
            showTitle(this.mShowingTitle);
            this.mTitleViewAdapter.setAnimationEnabled(true);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.mShowingTitle = bundle.getBoolean(TITLE_SHOW);
        }
        View view2 = this.mTitleView;
        if (view2 != null && (view instanceof ViewGroup)) {
            TitleHelper titleHelper = new TitleHelper((ViewGroup) view, view2);
            this.mTitleHelper = titleHelper;
            titleHelper.showTitle(this.mShowingTitle);
        }
    }

    public void setBadgeDrawable(Drawable drawable) {
        if (this.mBadgeDrawable != drawable) {
            this.mBadgeDrawable = drawable;
            TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
            if (titleViewAdapter != null) {
                titleViewAdapter.setBadgeDrawable(drawable);
            }
        }
    }

    public void setOnSearchClickedListener(View.OnClickListener onClickListener) {
        this.mExternalOnSearchClickedListener = onClickListener;
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            titleViewAdapter.setOnSearchClickedListener(onClickListener);
        }
    }

    public void setSearchAffordanceColor(int i5) {
        setSearchAffordanceColors(new SearchOrbView.Colors(i5));
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        this.mSearchAffordanceColors = colors;
        this.mSearchAffordanceColorSet = true;
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            titleViewAdapter.setSearchAffordanceColors(colors);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            titleViewAdapter.setTitle(charSequence);
        }
    }

    public void setTitleView(View view) {
        this.mTitleView = view;
        if (view == null) {
            this.mTitleViewAdapter = null;
            this.mTitleHelper = null;
            return;
        }
        TitleViewAdapter titleViewAdapter = ((TitleViewAdapter.Provider) view).getTitleViewAdapter();
        this.mTitleViewAdapter = titleViewAdapter;
        titleViewAdapter.setTitle(this.mTitle);
        this.mTitleViewAdapter.setBadgeDrawable(this.mBadgeDrawable);
        if (this.mSearchAffordanceColorSet) {
            this.mTitleViewAdapter.setSearchAffordanceColors(this.mSearchAffordanceColors);
        }
        View.OnClickListener onClickListener = this.mExternalOnSearchClickedListener;
        if (onClickListener != null) {
            setOnSearchClickedListener(onClickListener);
        }
        if (getView() instanceof ViewGroup) {
            this.mTitleHelper = new TitleHelper((ViewGroup) getView(), this.mTitleView);
        }
    }

    public void showTitle(boolean z4) {
        if (z4 != this.mShowingTitle) {
            this.mShowingTitle = z4;
            TitleHelper titleHelper = this.mTitleHelper;
            if (titleHelper != null) {
                titleHelper.showTitle(z4);
            }
        }
    }

    public void showTitle(int i5) {
        TitleViewAdapter titleViewAdapter = this.mTitleViewAdapter;
        if (titleViewAdapter != null) {
            titleViewAdapter.updateComponentsVisibility(i5);
        }
        showTitle(true);
    }
}
