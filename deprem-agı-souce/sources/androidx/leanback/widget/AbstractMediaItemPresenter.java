package androidx.leanback.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.leanback.R;
import androidx.leanback.widget.MultiActionsProvider;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMediaItemPresenter extends RowPresenter {
    public static final int PLAY_STATE_INITIAL = 0;
    public static final int PLAY_STATE_PAUSED = 1;
    public static final int PLAY_STATE_PLAYING = 2;
    static final Rect sTempRect = new Rect();
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private Presenter mMediaItemActionPresenter;
    private boolean mMediaRowSeparator;
    private int mThemeId;

    public static class ViewHolder extends RowPresenter.ViewHolder {
        private final List<Presenter.ViewHolder> mActionViewHolders = new ArrayList();
        ValueAnimator mFocusViewAnimator;
        private final ViewGroup mMediaItemActionsContainer;
        private final View mMediaItemDetailsView;
        private final TextView mMediaItemDurationView;
        private final TextView mMediaItemNameView;
        final TextView mMediaItemNumberView;
        final ViewFlipper mMediaItemNumberViewFlipper;
        final View mMediaItemPausedView;
        final View mMediaItemPlayingView;
        MultiActionsProvider.MultiAction[] mMediaItemRowActions;
        private final View mMediaItemRowSeparator;
        final View mMediaRowView;
        AbstractMediaItemPresenter mRowPresenter;
        final View mSelectorView;

        public ViewHolder(View view) {
            super(view);
            int i5;
            this.mSelectorView = view.findViewById(R.id.mediaRowSelector);
            this.mMediaRowView = view.findViewById(R.id.mediaItemRow);
            this.mMediaItemDetailsView = view.findViewById(R.id.mediaItemDetails);
            this.mMediaItemNameView = (TextView) view.findViewById(R.id.mediaItemName);
            this.mMediaItemDurationView = (TextView) view.findViewById(R.id.mediaItemDuration);
            this.mMediaItemRowSeparator = view.findViewById(R.id.mediaRowSeparator);
            this.mMediaItemActionsContainer = (ViewGroup) view.findViewById(R.id.mediaItemActionsContainer);
            getMediaItemDetailsView().setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ViewHolder.this.getOnItemViewClickedListener() != null) {
                        BaseOnItemViewClickedListener onItemViewClickedListener = ViewHolder.this.getOnItemViewClickedListener();
                        ViewHolder viewHolder = ViewHolder.this;
                        onItemViewClickedListener.onItemClicked((Presenter.ViewHolder) null, (Object) null, viewHolder, viewHolder.getRowObject());
                    }
                }
            });
            getMediaItemDetailsView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z4) {
                    ViewHolder viewHolder = ViewHolder.this;
                    viewHolder.mFocusViewAnimator = AbstractMediaItemPresenter.updateSelector(viewHolder.mSelectorView, view, viewHolder.mFocusViewAnimator, true);
                }
            });
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.mediaItemNumberViewFlipper);
            this.mMediaItemNumberViewFlipper = viewFlipper;
            TypedValue typedValue = new TypedValue();
            boolean resolveAttribute = view.getContext().getTheme().resolveAttribute(R.attr.playbackMediaItemNumberViewFlipperLayout, typedValue, true);
            LayoutInflater from = LayoutInflater.from(view.getContext());
            if (resolveAttribute) {
                i5 = typedValue.resourceId;
            } else {
                i5 = R.layout.lb_media_item_number_view_flipper;
            }
            View inflate = from.inflate(i5, viewFlipper, true);
            this.mMediaItemNumberView = (TextView) inflate.findViewById(R.id.initial);
            this.mMediaItemPausedView = inflate.findViewById(R.id.paused);
            this.mMediaItemPlayingView = inflate.findViewById(R.id.playing);
        }

        /* access modifiers changed from: package-private */
        public int findActionIndex(MultiActionsProvider.MultiAction multiAction) {
            if (this.mMediaItemRowActions == null) {
                return -1;
            }
            int i5 = 0;
            while (true) {
                MultiActionsProvider.MultiAction[] multiActionArr = this.mMediaItemRowActions;
                if (i5 >= multiActionArr.length) {
                    return -1;
                }
                if (multiActionArr[i5] == multiAction) {
                    return i5;
                }
                i5++;
            }
        }

        public ViewGroup getMediaItemActionsContainer() {
            return this.mMediaItemActionsContainer;
        }

        public View getMediaItemDetailsView() {
            return this.mMediaItemDetailsView;
        }

        public TextView getMediaItemDurationView() {
            return this.mMediaItemDurationView;
        }

        public TextView getMediaItemNameView() {
            return this.mMediaItemNameView;
        }

        public TextView getMediaItemNumberView() {
            return this.mMediaItemNumberView;
        }

        public ViewFlipper getMediaItemNumberViewFlipper() {
            return this.mMediaItemNumberViewFlipper;
        }

        public View getMediaItemPausedView() {
            return this.mMediaItemPausedView;
        }

        public View getMediaItemPlayingView() {
            return this.mMediaItemPlayingView;
        }

        public MultiActionsProvider.MultiAction[] getMediaItemRowActions() {
            return this.mMediaItemRowActions;
        }

        public View getMediaItemRowSeparator() {
            return this.mMediaItemRowSeparator;
        }

        public View getSelectorView() {
            return this.mSelectorView;
        }

        public void notifyActionChanged(MultiActionsProvider.MultiAction multiAction) {
            int findActionIndex;
            Presenter actionPresenter = this.mRowPresenter.getActionPresenter();
            if (actionPresenter != null && (findActionIndex = findActionIndex(multiAction)) >= 0) {
                Presenter.ViewHolder viewHolder = this.mActionViewHolders.get(findActionIndex);
                actionPresenter.onUnbindViewHolder(viewHolder);
                actionPresenter.onBindViewHolder(viewHolder, multiAction);
            }
        }

        public void notifyDetailsChanged() {
            this.mRowPresenter.onUnbindMediaDetails(this);
            this.mRowPresenter.onBindMediaDetails(this, getRowObject());
        }

        public void notifyPlayStateChanged() {
            this.mRowPresenter.onBindMediaPlayState(this);
        }

        public void onBindRowActions() {
            int childCount = getMediaItemActionsContainer().getChildCount();
            while (true) {
                childCount--;
                if (childCount < this.mActionViewHolders.size()) {
                    break;
                }
                getMediaItemActionsContainer().removeViewAt(childCount);
                this.mActionViewHolders.remove(childCount);
            }
            this.mMediaItemRowActions = null;
            Object rowObject = getRowObject();
            if (rowObject instanceof MultiActionsProvider) {
                MultiActionsProvider.MultiAction[] actions = ((MultiActionsProvider) rowObject).getActions();
                Presenter actionPresenter = this.mRowPresenter.getActionPresenter();
                if (actionPresenter != null) {
                    this.mMediaItemRowActions = actions;
                    for (final int size = this.mActionViewHolders.size(); size < actions.length; size++) {
                        final Presenter.ViewHolder onCreateViewHolder = actionPresenter.onCreateViewHolder(getMediaItemActionsContainer());
                        getMediaItemActionsContainer().addView(onCreateViewHolder.view);
                        this.mActionViewHolders.add(onCreateViewHolder);
                        onCreateViewHolder.view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            public void onFocusChange(View view, boolean z4) {
                                ViewHolder viewHolder = ViewHolder.this;
                                viewHolder.mFocusViewAnimator = AbstractMediaItemPresenter.updateSelector(viewHolder.mSelectorView, view, viewHolder.mFocusViewAnimator, false);
                            }
                        });
                        onCreateViewHolder.view.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                if (ViewHolder.this.getOnItemViewClickedListener() != null) {
                                    BaseOnItemViewClickedListener onItemViewClickedListener = ViewHolder.this.getOnItemViewClickedListener();
                                    Presenter.ViewHolder viewHolder = onCreateViewHolder;
                                    ViewHolder viewHolder2 = ViewHolder.this;
                                    onItemViewClickedListener.onItemClicked(viewHolder, viewHolder2.mMediaItemRowActions[size], viewHolder2, viewHolder2.getRowObject());
                                }
                            }
                        });
                    }
                    if (this.mMediaItemActionsContainer != null) {
                        for (int i5 = 0; i5 < actions.length; i5++) {
                            Presenter.ViewHolder viewHolder = this.mActionViewHolders.get(i5);
                            actionPresenter.onUnbindViewHolder(viewHolder);
                            actionPresenter.onBindViewHolder(viewHolder, this.mMediaItemRowActions[i5]);
                        }
                    }
                }
            }
        }

        public void setSelectedMediaItemNumberView(int i5) {
            if (i5 >= 0 && i5 < this.mMediaItemNumberViewFlipper.getChildCount()) {
                this.mMediaItemNumberViewFlipper.setDisplayedChild(i5);
            }
        }
    }

    public AbstractMediaItemPresenter() {
        this(0);
    }

    static int calculateMediaItemNumberFlipperIndex(ViewHolder viewHolder) {
        View view;
        int mediaPlayState = viewHolder.mRowPresenter.getMediaPlayState(viewHolder.getRowObject());
        if (mediaPlayState == 0) {
            TextView textView = viewHolder.mMediaItemNumberView;
            if (textView == null) {
                return -1;
            }
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(textView);
        } else if (mediaPlayState == 1) {
            View view2 = viewHolder.mMediaItemPausedView;
            if (view2 == null) {
                return -1;
            }
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(view2);
        } else if (mediaPlayState == 2 && (view = viewHolder.mMediaItemPlayingView) != null) {
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(view);
        } else {
            return -1;
        }
    }

    static ValueAnimator updateSelector(View view, View view2, ValueAnimator valueAnimator, boolean z4) {
        ValueAnimator valueAnimator2;
        int integer = view2.getContext().getResources().getInteger(17694720);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        int layoutDirection = view.getLayoutDirection();
        if (!view2.hasFocus()) {
            view.animate().cancel();
            view.animate().alpha(0.0f).setDuration((long) integer).setInterpolator(decelerateInterpolator).start();
            return valueAnimator;
        }
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator2 = null;
        } else {
            valueAnimator2 = valueAnimator;
        }
        float alpha = view.getAlpha();
        long j5 = (long) integer;
        view.animate().alpha(1.0f).setDuration(j5).setInterpolator(decelerateInterpolator).start();
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        Rect rect = sTempRect;
        rect.set(0, 0, view2.getWidth(), view2.getHeight());
        viewGroup.offsetDescendantRectToMyCoords(view2, rect);
        if (z4) {
            if (layoutDirection == 1) {
                rect.right += viewGroup.getHeight();
                rect.left -= viewGroup.getHeight() / 2;
            } else {
                rect.left -= viewGroup.getHeight();
                rect.right += viewGroup.getHeight() / 2;
            }
        }
        final int i5 = rect.left;
        final int width = rect.width();
        final float f5 = (float) (marginLayoutParams.width - width);
        final float f6 = (float) (marginLayoutParams.leftMargin - i5);
        if (f6 == 0.0f && f5 == 0.0f) {
            return valueAnimator2;
        }
        if (alpha == 0.0f) {
            marginLayoutParams.width = width;
            marginLayoutParams.leftMargin = i5;
            view.requestLayout();
            return valueAnimator2;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(j5);
        ofFloat.setInterpolator(decelerateInterpolator);
        final View view3 = view;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
                marginLayoutParams.leftMargin = Math.round(((float) i5) + (f6 * animatedFraction));
                marginLayoutParams.width = Math.round(((float) width) + (f5 * animatedFraction));
                view3.requestLayout();
            }
        });
        ofFloat.start();
        return ofFloat;
    }

    /* access modifiers changed from: protected */
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.mThemeId != 0) {
            context = new ContextThemeWrapper(context, this.mThemeId);
        }
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.lb_row_media_item, viewGroup, false));
        viewHolder.mRowPresenter = this;
        if (this.mBackgroundColorSet) {
            viewHolder.mMediaRowView.setBackgroundColor(this.mBackgroundColor);
        }
        return viewHolder;
    }

    public Presenter getActionPresenter() {
        return this.mMediaItemActionPresenter;
    }

    /* access modifiers changed from: protected */
    public int getMediaPlayState(Object obj) {
        return 0;
    }

    public int getThemeId() {
        return this.mThemeId;
    }

    public boolean hasMediaRowSeparator() {
        return this.mMediaRowSeparator;
    }

    /* access modifiers changed from: protected */
    public boolean isClippingChildren() {
        return true;
    }

    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void onBindMediaDetails(ViewHolder viewHolder, Object obj);

    public void onBindMediaPlayState(ViewHolder viewHolder) {
        int calculateMediaItemNumberFlipperIndex = calculateMediaItemNumberFlipperIndex(viewHolder);
        if (calculateMediaItemNumberFlipperIndex != -1 && viewHolder.mMediaItemNumberViewFlipper.getDisplayedChild() != calculateMediaItemNumberFlipperIndex) {
            viewHolder.mMediaItemNumberViewFlipper.setDisplayedChild(calculateMediaItemNumberFlipperIndex);
        }
    }

    /* access modifiers changed from: protected */
    public void onBindRowActions(ViewHolder viewHolder) {
        viewHolder.onBindRowActions();
    }

    /* access modifiers changed from: protected */
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        int i5;
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onBindRowActions(viewHolder2);
        View mediaItemRowSeparator = viewHolder2.getMediaItemRowSeparator();
        if (hasMediaRowSeparator()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        mediaItemRowSeparator.setVisibility(i5);
        onBindMediaPlayState(viewHolder2);
        onBindMediaDetails(viewHolder2, obj);
    }

    /* access modifiers changed from: protected */
    public void onUnbindMediaDetails(ViewHolder viewHolder) {
    }

    public void onUnbindMediaPlayState(ViewHolder viewHolder) {
    }

    public void setActionPresenter(Presenter presenter) {
        this.mMediaItemActionPresenter = presenter;
    }

    public void setBackgroundColor(int i5) {
        this.mBackgroundColorSet = true;
        this.mBackgroundColor = i5;
    }

    public void setHasMediaRowSeparator(boolean z4) {
        this.mMediaRowSeparator = z4;
    }

    public void setThemeId(int i5) {
        this.mThemeId = i5;
    }

    public AbstractMediaItemPresenter(int i5) {
        this.mBackgroundColor = 0;
        this.mMediaItemActionPresenter = new MediaItemActionPresenter();
        this.mThemeId = i5;
        setHeaderPresenter((RowHeaderPresenter) null);
    }
}
