package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import androidx.leanback.widget.ControlBarPresenter;
import androidx.leanback.widget.PlaybackControlsPresenter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackControlsRowView;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

public class PlaybackControlsRowPresenter extends PlaybackRowPresenter {
    static float sShadowZ;
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private Presenter mDescriptionPresenter;
    OnActionClickedListener mOnActionClickedListener;
    private final ControlBarPresenter.OnControlClickedListener mOnControlClickedListener;
    private final ControlBarPresenter.OnControlSelectedListener mOnControlSelectedListener;
    PlaybackControlsPresenter mPlaybackControlsPresenter;
    private int mProgressColor;
    private boolean mProgressColorSet;
    private boolean mSecondaryActionsHidden;
    private ControlBarPresenter mSecondaryControlsPresenter;

    static class BoundData extends PlaybackControlsPresenter.BoundData {
        ViewHolder mRowViewHolder;

        BoundData() {
        }
    }

    public class ViewHolder extends PlaybackRowPresenter.ViewHolder {
        View mBgView;
        final View mBottomSpacer;
        final ViewGroup mCard;
        final ViewGroup mCardRightPanel;
        BoundData mControlsBoundData = new BoundData();
        final ViewGroup mControlsDock;
        int mControlsDockMarginEnd;
        int mControlsDockMarginStart;
        PlaybackControlsPresenter.ViewHolder mControlsVh;
        final ViewGroup mDescriptionDock;
        public final Presenter.ViewHolder mDescriptionViewHolder;
        final ImageView mImageView;
        final PlaybackControlsRow.OnPlaybackProgressCallback mListener = new PlaybackControlsRow.OnPlaybackProgressCallback() {
            public void onBufferedPositionChanged(PlaybackControlsRow playbackControlsRow, long j5) {
                ViewHolder viewHolder = ViewHolder.this;
                PlaybackControlsRowPresenter.this.mPlaybackControlsPresenter.setSecondaryProgressLong(viewHolder.mControlsVh, j5);
            }

            public void onCurrentPositionChanged(PlaybackControlsRow playbackControlsRow, long j5) {
                ViewHolder viewHolder = ViewHolder.this;
                PlaybackControlsRowPresenter.this.mPlaybackControlsPresenter.setCurrentTimeLong(viewHolder.mControlsVh, j5);
            }

            public void onDurationChanged(PlaybackControlsRow playbackControlsRow, long j5) {
                ViewHolder viewHolder = ViewHolder.this;
                PlaybackControlsRowPresenter.this.mPlaybackControlsPresenter.setTotalTimeLong(viewHolder.mControlsVh, j5);
            }
        };
        BoundData mSecondaryBoundData = new BoundData();
        final ViewGroup mSecondaryControlsDock;
        Presenter.ViewHolder mSecondaryControlsVh;
        Object mSelectedItem;
        Presenter.ViewHolder mSelectedViewHolder;
        final View mSpacer;

        ViewHolder(View view, Presenter presenter) {
            super(view);
            Presenter.ViewHolder viewHolder;
            this.mCard = (ViewGroup) view.findViewById(R.id.controls_card);
            this.mCardRightPanel = (ViewGroup) view.findViewById(R.id.controls_card_right_panel);
            this.mImageView = (ImageView) view.findViewById(R.id.image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.description_dock);
            this.mDescriptionDock = viewGroup;
            this.mControlsDock = (ViewGroup) view.findViewById(R.id.controls_dock);
            this.mSecondaryControlsDock = (ViewGroup) view.findViewById(R.id.secondary_controls_dock);
            this.mSpacer = view.findViewById(R.id.spacer);
            this.mBottomSpacer = view.findViewById(R.id.bottom_spacer);
            if (presenter == null) {
                viewHolder = null;
            } else {
                viewHolder = presenter.onCreateViewHolder(viewGroup);
            }
            this.mDescriptionViewHolder = viewHolder;
            if (viewHolder != null) {
                viewGroup.addView(viewHolder.view);
            }
        }

        /* access modifiers changed from: package-private */
        public void dispatchItemSelection() {
            if (isSelected()) {
                if (this.mSelectedViewHolder == null) {
                    if (getOnItemViewSelectedListener() != null) {
                        getOnItemViewSelectedListener().onItemSelected((Presenter.ViewHolder) null, (Object) null, this, getRow());
                    }
                } else if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(this.mSelectedViewHolder, this.mSelectedItem, this, getRow());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Presenter getPresenter(boolean z4) {
            ObjectAdapter objectAdapter;
            if (z4) {
                objectAdapter = ((PlaybackControlsRow) getRow()).getPrimaryActionsAdapter();
            } else {
                objectAdapter = ((PlaybackControlsRow) getRow()).getSecondaryActionsAdapter();
            }
            Object obj = null;
            if (objectAdapter == null) {
                return null;
            }
            if (objectAdapter.getPresenterSelector() instanceof ControlButtonPresenterSelector) {
                ControlButtonPresenterSelector controlButtonPresenterSelector = (ControlButtonPresenterSelector) objectAdapter.getPresenterSelector();
                if (z4) {
                    return controlButtonPresenterSelector.getPrimaryPresenter();
                }
                return controlButtonPresenterSelector.getSecondaryPresenter();
            }
            if (objectAdapter.size() > 0) {
                obj = objectAdapter.get(0);
            }
            return objectAdapter.getPresenter(obj);
        }

        /* access modifiers changed from: package-private */
        public void setOutline(View view) {
            View view2 = this.mBgView;
            if (view2 != null) {
                RoundedRectHelper.setClipToRoundedOutline(view2, false);
                ViewCompat.setZ(this.mBgView, 0.0f);
            }
            this.mBgView = view;
            RoundedRectHelper.setClipToRoundedOutline(view, true);
            if (PlaybackControlsRowPresenter.sShadowZ == 0.0f) {
                PlaybackControlsRowPresenter.sShadowZ = (float) view.getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_z);
            }
            ViewCompat.setZ(view, PlaybackControlsRowPresenter.sShadowZ);
        }
    }

    public PlaybackControlsRowPresenter(Presenter presenter) {
        this.mBackgroundColor = 0;
        this.mProgressColor = 0;
        AnonymousClass1 r12 = new ControlBarPresenter.OnControlSelectedListener() {
            public void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, ControlBarPresenter.BoundData boundData) {
                ViewHolder viewHolder2 = ((BoundData) boundData).mRowViewHolder;
                if (viewHolder2.mSelectedViewHolder != viewHolder || viewHolder2.mSelectedItem != obj) {
                    viewHolder2.mSelectedViewHolder = viewHolder;
                    viewHolder2.mSelectedItem = obj;
                    viewHolder2.dispatchItemSelection();
                }
            }
        };
        this.mOnControlSelectedListener = r12;
        AnonymousClass2 r22 = new ControlBarPresenter.OnControlClickedListener() {
            public void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, ControlBarPresenter.BoundData boundData) {
                ViewHolder viewHolder2 = ((BoundData) boundData).mRowViewHolder;
                if (viewHolder2.getOnItemViewClickedListener() != null) {
                    viewHolder2.getOnItemViewClickedListener().onItemClicked(viewHolder, obj, viewHolder2, viewHolder2.getRow());
                }
                OnActionClickedListener onActionClickedListener = PlaybackControlsRowPresenter.this.mOnActionClickedListener;
                if (onActionClickedListener != null && (obj instanceof Action)) {
                    onActionClickedListener.onActionClicked((Action) obj);
                }
            }
        };
        this.mOnControlClickedListener = r22;
        setHeaderPresenter((RowHeaderPresenter) null);
        setSelectEffectEnabled(false);
        this.mDescriptionPresenter = presenter;
        this.mPlaybackControlsPresenter = new PlaybackControlsPresenter(R.layout.lb_playback_controls);
        this.mSecondaryControlsPresenter = new ControlBarPresenter(R.layout.lb_control_bar);
        this.mPlaybackControlsPresenter.setOnControlSelectedListener(r12);
        this.mSecondaryControlsPresenter.setOnControlSelectedListener(r12);
        this.mPlaybackControlsPresenter.setOnControlClickedListener(r22);
        this.mSecondaryControlsPresenter.setOnControlClickedListener(r22);
    }

    private int getDefaultBackgroundColor(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.defaultBrandColor, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return context.getResources().getColor(R.color.lb_default_brand_color);
    }

    private int getDefaultProgressColor(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.playbackProgressPrimaryColor, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return context.getResources().getColor(R.color.lb_playback_progress_color_no_theme);
    }

    private void initRow(final ViewHolder viewHolder) {
        int i5;
        int i6;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.mControlsDock.getLayoutParams();
        viewHolder.mControlsDockMarginStart = marginLayoutParams.getMarginStart();
        viewHolder.mControlsDockMarginEnd = marginLayoutParams.getMarginEnd();
        PlaybackControlsPresenter.ViewHolder viewHolder2 = (PlaybackControlsPresenter.ViewHolder) this.mPlaybackControlsPresenter.onCreateViewHolder(viewHolder.mControlsDock);
        viewHolder.mControlsVh = viewHolder2;
        PlaybackControlsPresenter playbackControlsPresenter = this.mPlaybackControlsPresenter;
        if (this.mProgressColorSet) {
            i5 = this.mProgressColor;
        } else {
            i5 = getDefaultProgressColor(viewHolder.mControlsDock.getContext());
        }
        playbackControlsPresenter.setProgressColor(viewHolder2, i5);
        PlaybackControlsPresenter playbackControlsPresenter2 = this.mPlaybackControlsPresenter;
        PlaybackControlsPresenter.ViewHolder viewHolder3 = viewHolder.mControlsVh;
        if (this.mBackgroundColorSet) {
            i6 = this.mBackgroundColor;
        } else {
            i6 = getDefaultBackgroundColor(viewHolder.view.getContext());
        }
        playbackControlsPresenter2.setBackgroundColor(viewHolder3, i6);
        viewHolder.mControlsDock.addView(viewHolder.mControlsVh.view);
        Presenter.ViewHolder onCreateViewHolder = this.mSecondaryControlsPresenter.onCreateViewHolder(viewHolder.mSecondaryControlsDock);
        viewHolder.mSecondaryControlsVh = onCreateViewHolder;
        if (!this.mSecondaryActionsHidden) {
            viewHolder.mSecondaryControlsDock.addView(onCreateViewHolder.view);
        }
        ((PlaybackControlsRowView) viewHolder.view).setOnUnhandledKeyListener(new PlaybackControlsRowView.OnUnhandledKeyListener() {
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                if (viewHolder.getOnKeyListener() == null || !viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent)) {
                    return false;
                }
                return true;
            }
        });
    }

    private void updateCardLayout(ViewHolder viewHolder, int i5) {
        int i6;
        ViewGroup.LayoutParams layoutParams = viewHolder.mCardRightPanel.getLayoutParams();
        layoutParams.height = i5;
        viewHolder.mCardRightPanel.setLayoutParams(layoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.mControlsDock.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.mDescriptionDock.getLayoutParams();
        if (i5 == -2) {
            layoutParams2.height = -2;
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(0);
            viewHolder.mCard.setBackground((Drawable) null);
            viewHolder.setOutline(viewHolder.mControlsDock);
            this.mPlaybackControlsPresenter.enableTimeMargins(viewHolder.mControlsVh, true);
        } else {
            layoutParams2.height = 0;
            layoutParams2.weight = 1.0f;
            marginLayoutParams.setMarginStart(viewHolder.mControlsDockMarginStart);
            marginLayoutParams.setMarginEnd(viewHolder.mControlsDockMarginEnd);
            ViewGroup viewGroup = viewHolder.mCard;
            if (this.mBackgroundColorSet) {
                i6 = this.mBackgroundColor;
            } else {
                i6 = getDefaultBackgroundColor(viewGroup.getContext());
            }
            viewGroup.setBackgroundColor(i6);
            viewHolder.setOutline(viewHolder.mCard);
            this.mPlaybackControlsPresenter.enableTimeMargins(viewHolder.mControlsVh, false);
        }
        viewHolder.mDescriptionDock.setLayoutParams(layoutParams2);
        viewHolder.mControlsDock.setLayoutParams(marginLayoutParams);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean areSecondaryActionsHidden() {
        return this.mSecondaryActionsHidden;
    }

    /* access modifiers changed from: protected */
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_playback_controls_row, viewGroup, false), this.mDescriptionPresenter);
        initRow(viewHolder);
        return viewHolder;
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.mOnActionClickedListener;
    }

    @ColorInt
    public int getProgressColor() {
        return this.mProgressColor;
    }

    /* access modifiers changed from: protected */
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        this.mPlaybackControlsPresenter.enableSecondaryActions(this.mSecondaryActionsHidden);
        if (playbackControlsRow.getItem() == null) {
            viewHolder2.mDescriptionDock.setVisibility(8);
            viewHolder2.mSpacer.setVisibility(8);
        } else {
            viewHolder2.mDescriptionDock.setVisibility(0);
            Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
            if (viewHolder3 != null) {
                this.mDescriptionPresenter.onBindViewHolder(viewHolder3, playbackControlsRow.getItem());
            }
            viewHolder2.mSpacer.setVisibility(0);
        }
        if (playbackControlsRow.getImageDrawable() == null || playbackControlsRow.getItem() == null) {
            viewHolder2.mImageView.setImageDrawable((Drawable) null);
            updateCardLayout(viewHolder2, -2);
        } else {
            viewHolder2.mImageView.setImageDrawable(playbackControlsRow.getImageDrawable());
            updateCardLayout(viewHolder2, viewHolder2.mImageView.getLayoutParams().height);
        }
        viewHolder2.mControlsBoundData.adapter = playbackControlsRow.getPrimaryActionsAdapter();
        viewHolder2.mControlsBoundData.secondaryActionsAdapter = playbackControlsRow.getSecondaryActionsAdapter();
        viewHolder2.mControlsBoundData.presenter = viewHolder2.getPresenter(true);
        BoundData boundData = viewHolder2.mControlsBoundData;
        boundData.mRowViewHolder = viewHolder2;
        this.mPlaybackControlsPresenter.onBindViewHolder(viewHolder2.mControlsVh, boundData);
        viewHolder2.mSecondaryBoundData.adapter = playbackControlsRow.getSecondaryActionsAdapter();
        viewHolder2.mSecondaryBoundData.presenter = viewHolder2.getPresenter(false);
        BoundData boundData2 = viewHolder2.mSecondaryBoundData;
        boundData2.mRowViewHolder = viewHolder2;
        this.mSecondaryControlsPresenter.onBindViewHolder(viewHolder2.mSecondaryControlsVh, boundData2);
        this.mPlaybackControlsPresenter.setTotalTime(viewHolder2.mControlsVh, playbackControlsRow.getTotalTime());
        this.mPlaybackControlsPresenter.setCurrentTime(viewHolder2.mControlsVh, playbackControlsRow.getCurrentTime());
        this.mPlaybackControlsPresenter.setSecondaryProgress(viewHolder2.mControlsVh, playbackControlsRow.getBufferedProgress());
        playbackControlsRow.setOnPlaybackProgressChangedListener(viewHolder2.mListener);
    }

    public void onReappear(RowPresenter.ViewHolder viewHolder) {
        showPrimaryActions((ViewHolder) viewHolder);
    }

    /* access modifiers changed from: protected */
    public void onRowViewAttachedToWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.mDescriptionPresenter;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void onRowViewDetachedFromWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.mDescriptionPresenter;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDescriptionViewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z4) {
        super.onRowViewSelected(viewHolder, z4);
        if (z4) {
            ((ViewHolder) viewHolder).dispatchItemSelection();
        }
    }

    /* access modifiers changed from: protected */
    public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        PlaybackControlsRow playbackControlsRow = (PlaybackControlsRow) viewHolder2.getRow();
        Presenter.ViewHolder viewHolder3 = viewHolder2.mDescriptionViewHolder;
        if (viewHolder3 != null) {
            this.mDescriptionPresenter.onUnbindViewHolder(viewHolder3);
        }
        this.mPlaybackControlsPresenter.onUnbindViewHolder(viewHolder2.mControlsVh);
        this.mSecondaryControlsPresenter.onUnbindViewHolder(viewHolder2.mSecondaryControlsVh);
        playbackControlsRow.setOnPlaybackProgressChangedListener((PlaybackControlsRow.OnPlaybackProgressCallback) null);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public void setBackgroundColor(@ColorInt int i5) {
        this.mBackgroundColor = i5;
        this.mBackgroundColorSet = true;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.mOnActionClickedListener = onActionClickedListener;
    }

    public void setProgressColor(@ColorInt int i5) {
        this.mProgressColor = i5;
        this.mProgressColorSet = true;
    }

    public void setSecondaryActionsHidden(boolean z4) {
        this.mSecondaryActionsHidden = z4;
    }

    public void showBottomSpace(ViewHolder viewHolder, boolean z4) {
        int i5;
        View view = viewHolder.mBottomSpacer;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        view.setVisibility(i5);
    }

    public void showPrimaryActions(ViewHolder viewHolder) {
        this.mPlaybackControlsPresenter.showPrimaryActions(viewHolder.mControlsVh);
        if (viewHolder.view.hasFocus()) {
            this.mPlaybackControlsPresenter.resetFocus(viewHolder.mControlsVh);
        }
    }

    public PlaybackControlsRowPresenter() {
        this((Presenter) null);
    }
}
