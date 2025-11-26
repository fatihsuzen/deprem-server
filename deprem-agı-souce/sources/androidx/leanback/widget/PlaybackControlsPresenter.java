package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.leanback.R;
import androidx.leanback.util.MathUtil;
import androidx.leanback.widget.ControlBarPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.Presenter;

class PlaybackControlsPresenter extends ControlBarPresenter {
    private static int sChildMarginBigger;
    private static int sChildMarginBiggest;
    private boolean mMoreActionsEnabled = true;

    static class BoundData extends ControlBarPresenter.BoundData {
        ObjectAdapter secondaryActionsAdapter;

        BoundData() {
        }
    }

    class ViewHolder extends ControlBarPresenter.ViewHolder {
        final TextView mCurrentTime;
        long mCurrentTimeInMs = -1;
        int mCurrentTimeMarginStart;
        StringBuilder mCurrentTimeStringBuilder = new StringBuilder();
        ObjectAdapter mMoreActionsAdapter;
        final FrameLayout mMoreActionsDock;
        ObjectAdapter.DataObserver mMoreActionsObserver;
        boolean mMoreActionsShowing;
        Presenter.ViewHolder mMoreActionsViewHolder;
        final ProgressBar mProgressBar;
        long mSecondaryProgressInMs = -1;
        final TextView mTotalTime;
        long mTotalTimeInMs = -1;
        int mTotalTimeMarginEnd;
        StringBuilder mTotalTimeStringBuilder = new StringBuilder();

        ViewHolder(View view) {
            super(view);
            this.mMoreActionsDock = (FrameLayout) view.findViewById(R.id.more_actions_dock);
            TextView textView = (TextView) view.findViewById(R.id.current_time);
            this.mCurrentTime = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.total_time);
            this.mTotalTime = textView2;
            this.mProgressBar = (ProgressBar) view.findViewById(R.id.playback_progress);
            this.mMoreActionsObserver = new ObjectAdapter.DataObserver(PlaybackControlsPresenter.this) {
                public void onChanged() {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (viewHolder.mMoreActionsShowing) {
                        viewHolder.showControls(viewHolder.mPresenter);
                    }
                }

                public void onItemRangeChanged(int i5, int i6) {
                    if (ViewHolder.this.mMoreActionsShowing) {
                        for (int i7 = 0; i7 < i6; i7++) {
                            ViewHolder viewHolder = ViewHolder.this;
                            viewHolder.bindControlToAction(i5 + i7, viewHolder.mPresenter);
                        }
                    }
                }
            };
            this.mCurrentTimeMarginStart = ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).getMarginStart();
            this.mTotalTimeMarginEnd = ((ViewGroup.MarginLayoutParams) textView2.getLayoutParams()).getMarginEnd();
        }

        /* access modifiers changed from: package-private */
        public int getChildMarginFromCenter(Context context, int i5) {
            int childMarginDefault;
            int controlIconWidth = PlaybackControlsPresenter.this.getControlIconWidth(context);
            if (i5 < 4) {
                childMarginDefault = PlaybackControlsPresenter.this.getChildMarginBiggest(context);
            } else if (i5 < 6) {
                childMarginDefault = PlaybackControlsPresenter.this.getChildMarginBigger(context);
            } else {
                childMarginDefault = PlaybackControlsPresenter.this.getChildMarginDefault(context);
            }
            return controlIconWidth + childMarginDefault;
        }

        /* access modifiers changed from: package-private */
        public long getCurrentTime() {
            return this.mTotalTimeInMs;
        }

        /* access modifiers changed from: package-private */
        public ObjectAdapter getDisplayedAdapter() {
            if (this.mMoreActionsShowing) {
                return this.mMoreActionsAdapter;
            }
            return this.mAdapter;
        }

        /* access modifiers changed from: package-private */
        public long getSecondaryProgress() {
            return this.mSecondaryProgressInMs;
        }

        /* access modifiers changed from: package-private */
        public long getTotalTime() {
            return this.mTotalTimeInMs;
        }

        /* access modifiers changed from: package-private */
        public void setCurrentTime(long j5) {
            long j6 = j5 / 1000;
            if (j5 != this.mCurrentTimeInMs) {
                this.mCurrentTimeInMs = j5;
                PlaybackControlsPresenter.formatTime(j6, this.mCurrentTimeStringBuilder);
                this.mCurrentTime.setText(this.mCurrentTimeStringBuilder.toString());
            }
            this.mProgressBar.setProgress((int) ((((double) this.mCurrentTimeInMs) / ((double) this.mTotalTimeInMs)) * 2.147483647E9d));
        }

        /* access modifiers changed from: package-private */
        public void setSecondaryProgress(long j5) {
            this.mSecondaryProgressInMs = j5;
            this.mProgressBar.setSecondaryProgress((int) ((((double) j5) / ((double) this.mTotalTimeInMs)) * 2.147483647E9d));
        }

        /* access modifiers changed from: package-private */
        public void setTotalTime(long j5) {
            if (j5 <= 0) {
                this.mTotalTime.setVisibility(8);
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.mTotalTime.setVisibility(0);
            this.mProgressBar.setVisibility(0);
            this.mTotalTimeInMs = j5;
            PlaybackControlsPresenter.formatTime(j5 / 1000, this.mTotalTimeStringBuilder);
            this.mTotalTime.setText(this.mTotalTimeStringBuilder.toString());
            this.mProgressBar.setMax(Integer.MAX_VALUE);
        }

        /* access modifiers changed from: package-private */
        public void showMoreActions(boolean z4) {
            if (z4) {
                if (this.mMoreActionsViewHolder == null) {
                    PlaybackControlsRow.MoreActions moreActions = new PlaybackControlsRow.MoreActions(this.mMoreActionsDock.getContext());
                    Presenter.ViewHolder onCreateViewHolder = this.mPresenter.onCreateViewHolder(this.mMoreActionsDock);
                    this.mMoreActionsViewHolder = onCreateViewHolder;
                    this.mPresenter.onBindViewHolder(onCreateViewHolder, moreActions);
                    this.mPresenter.setOnClickListener(this.mMoreActionsViewHolder, new View.OnClickListener() {
                        public void onClick(View view) {
                            ViewHolder.this.toggleMoreActions();
                        }
                    });
                }
                if (this.mMoreActionsViewHolder.view.getParent() == null) {
                    this.mMoreActionsDock.addView(this.mMoreActionsViewHolder.view);
                    return;
                }
                return;
            }
            Presenter.ViewHolder viewHolder = this.mMoreActionsViewHolder;
            if (viewHolder != null && viewHolder.view.getParent() != null) {
                this.mMoreActionsDock.removeView(this.mMoreActionsViewHolder.view);
            }
        }

        /* access modifiers changed from: package-private */
        public void toggleMoreActions() {
            this.mMoreActionsShowing = !this.mMoreActionsShowing;
            showControls(this.mPresenter);
        }
    }

    public PlaybackControlsPresenter(int i5) {
        super(i5);
    }

    static void formatTime(long j5, StringBuilder sb) {
        long j6 = j5 / 60;
        long j7 = j6 / 60;
        long j8 = j5 - (j6 * 60);
        long j9 = j6 - (60 * j7);
        sb.setLength(0);
        if (j7 > 0) {
            sb.append(j7);
            sb.append(':');
            if (j9 < 10) {
                sb.append('0');
            }
        }
        sb.append(j9);
        sb.append(':');
        if (j8 < 10) {
            sb.append('0');
        }
        sb.append(j8);
    }

    public boolean areMoreActionsEnabled() {
        return this.mMoreActionsEnabled;
    }

    public void enableSecondaryActions(boolean z4) {
        this.mMoreActionsEnabled = z4;
    }

    public void enableTimeMargins(ViewHolder viewHolder, boolean z4) {
        int i5;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.mCurrentTime.getLayoutParams();
        int i6 = 0;
        if (z4) {
            i5 = viewHolder.mCurrentTimeMarginStart;
        } else {
            i5 = 0;
        }
        marginLayoutParams.setMarginStart(i5);
        viewHolder.mCurrentTime.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) viewHolder.mTotalTime.getLayoutParams();
        if (z4) {
            i6 = viewHolder.mTotalTimeMarginEnd;
        }
        marginLayoutParams2.setMarginEnd(i6);
        viewHolder.mTotalTime.setLayoutParams(marginLayoutParams2);
    }

    /* access modifiers changed from: package-private */
    public int getChildMarginBigger(Context context) {
        if (sChildMarginBigger == 0) {
            sChildMarginBigger = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_child_margin_bigger);
        }
        return sChildMarginBigger;
    }

    /* access modifiers changed from: package-private */
    public int getChildMarginBiggest(Context context) {
        if (sChildMarginBiggest == 0) {
            sChildMarginBiggest = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_child_margin_biggest);
        }
        return sChildMarginBiggest;
    }

    public int getCurrentTime(ViewHolder viewHolder) {
        return MathUtil.safeLongToInt(getCurrentTimeLong(viewHolder));
    }

    public long getCurrentTimeLong(ViewHolder viewHolder) {
        return viewHolder.getCurrentTime();
    }

    public int getSecondaryProgress(ViewHolder viewHolder) {
        return MathUtil.safeLongToInt(getSecondaryProgressLong(viewHolder));
    }

    public long getSecondaryProgressLong(ViewHolder viewHolder) {
        return viewHolder.getSecondaryProgress();
    }

    public int getTotalTime(ViewHolder viewHolder) {
        return MathUtil.safeLongToInt(getTotalTimeLong(viewHolder));
    }

    public long getTotalTimeLong(ViewHolder viewHolder) {
        return viewHolder.getTotalTime();
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mMoreActionsAdapter;
        ObjectAdapter objectAdapter2 = ((BoundData) obj).secondaryActionsAdapter;
        if (objectAdapter != objectAdapter2) {
            viewHolder2.mMoreActionsAdapter = objectAdapter2;
            objectAdapter2.registerObserver(viewHolder2.mMoreActionsObserver);
            viewHolder2.mMoreActionsShowing = false;
        }
        super.onBindViewHolder(viewHolder, obj);
        viewHolder2.showMoreActions(this.mMoreActionsEnabled);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false));
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        super.onUnbindViewHolder(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mMoreActionsAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(viewHolder2.mMoreActionsObserver);
            viewHolder2.mMoreActionsAdapter = null;
        }
    }

    public void resetFocus(ViewHolder viewHolder) {
        viewHolder.mControlBar.requestFocus();
    }

    public void setCurrentTime(ViewHolder viewHolder, int i5) {
        setCurrentTimeLong(viewHolder, (long) i5);
    }

    public void setCurrentTimeLong(ViewHolder viewHolder, long j5) {
        viewHolder.setCurrentTime(j5);
    }

    public void setProgressColor(ViewHolder viewHolder, @ColorInt int i5) {
        ((LayerDrawable) viewHolder.mProgressBar.getProgressDrawable()).setDrawableByLayerId(16908301, new ClipDrawable(new ColorDrawable(i5), 3, 1));
    }

    public void setSecondaryProgress(ViewHolder viewHolder, int i5) {
        setSecondaryProgressLong(viewHolder, (long) i5);
    }

    public void setSecondaryProgressLong(ViewHolder viewHolder, long j5) {
        viewHolder.setSecondaryProgress(j5);
    }

    public void setTotalTime(ViewHolder viewHolder, int i5) {
        setTotalTimeLong(viewHolder, (long) i5);
    }

    public void setTotalTimeLong(ViewHolder viewHolder, long j5) {
        viewHolder.setTotalTime(j5);
    }

    public void showPrimaryActions(ViewHolder viewHolder) {
        if (viewHolder.mMoreActionsShowing) {
            viewHolder.toggleMoreActions();
        }
    }
}
