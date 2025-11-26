package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.transition.LeanbackTransitionHelper;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.BrowseFrameLayout;

public class TitleHelper {
    private final BrowseFrameLayout.OnFocusSearchListener mOnFocusSearchListener = new BrowseFrameLayout.OnFocusSearchListener() {
        public View onFocusSearch(View view, int i5) {
            int i6;
            View view2 = TitleHelper.this.mTitleView;
            if (view != view2 && i5 == 33) {
                return view2;
            }
            if (view.getLayoutDirection() == 1) {
                i6 = 17;
            } else {
                i6 = 66;
            }
            if (!TitleHelper.this.mTitleView.hasFocus()) {
                return null;
            }
            if (i5 == 130 || i5 == i6) {
                return TitleHelper.this.mSceneRoot;
            }
            return null;
        }
    };
    ViewGroup mSceneRoot;
    private Object mSceneWithTitle;
    private Object mSceneWithoutTitle;
    private Object mTitleDownTransition;
    private Object mTitleUpTransition;
    View mTitleView;

    public TitleHelper(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            throw new IllegalArgumentException("Views may not be null");
        }
        this.mSceneRoot = viewGroup;
        this.mTitleView = view;
        createTransitions();
    }

    private void createTransitions() {
        this.mTitleUpTransition = LeanbackTransitionHelper.loadTitleOutTransition(this.mSceneRoot.getContext());
        this.mTitleDownTransition = LeanbackTransitionHelper.loadTitleInTransition(this.mSceneRoot.getContext());
        this.mSceneWithTitle = TransitionHelper.createScene(this.mSceneRoot, new Runnable() {
            public void run() {
                TitleHelper.this.mTitleView.setVisibility(0);
            }
        });
        this.mSceneWithoutTitle = TransitionHelper.createScene(this.mSceneRoot, new Runnable() {
            public void run() {
                TitleHelper.this.mTitleView.setVisibility(4);
            }
        });
    }

    public BrowseFrameLayout.OnFocusSearchListener getOnFocusSearchListener() {
        return this.mOnFocusSearchListener;
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public View getTitleView() {
        return this.mTitleView;
    }

    public void showTitle(boolean z4) {
        if (z4) {
            TransitionHelper.runTransition(this.mSceneWithTitle, this.mTitleDownTransition);
        } else {
            TransitionHelper.runTransition(this.mSceneWithoutTitle, this.mTitleUpTransition);
        }
    }
}
