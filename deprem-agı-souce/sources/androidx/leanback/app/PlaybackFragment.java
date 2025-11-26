package androidx.leanback.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.leanback.animation.LogAccelerateInterpolator;
import androidx.leanback.animation.LogDecelerateInterpolator;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public class PlaybackFragment extends Fragment {
    private static final int ANIMATION_MULTIPLIER = 1;
    public static final int BG_DARK = 1;
    public static final int BG_LIGHT = 2;
    public static final int BG_NONE = 0;
    static final String BUNDLE_CONTROL_VISIBLE_ON_CREATEVIEW = "controlvisible_oncreateview";
    private static final boolean DEBUG = false;
    private static final int START_FADE_OUT = 1;
    private static final String TAG = "PlaybackFragment";
    ObjectAdapter mAdapter;
    private final ItemBridgeAdapter.AdapterListener mAdapterListener = new ItemBridgeAdapter.AdapterListener() {
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (!PlaybackFragment.this.mControlVisible) {
                viewHolder.getViewHolder().view.setAlpha(0.0f);
            }
        }

        public void onBind(ItemBridgeAdapter.ViewHolder viewHolder) {
        }

        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            Presenter.ViewHolder viewHolder2 = viewHolder.getViewHolder();
            if (viewHolder2 instanceof PlaybackSeekUi) {
                ((PlaybackSeekUi) viewHolder2).setPlaybackSeekUiClient(PlaybackFragment.this.mChainedClient);
            }
        }

        public void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.getViewHolder().view.setAlpha(1.0f);
            viewHolder.getViewHolder().view.setTranslationY(0.0f);
            viewHolder.getViewHolder().view.setAlpha(1.0f);
        }
    };
    int mAnimationTranslateY;
    int mAutohideTimerAfterPlayingInMs;
    int mAutohideTimerAfterTickleInMs;
    int mBackgroundType = 1;
    View mBackgroundView;
    int mBgAlpha;
    int mBgDarkColor;
    ValueAnimator mBgFadeInAnimator;
    ValueAnimator mBgFadeOutAnimator;
    int mBgLightColor;
    final PlaybackSeekUi.Client mChainedClient = new PlaybackSeekUi.Client() {
        public PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
            PlaybackSeekUi.Client client = PlaybackFragment.this.mSeekUiClient;
            if (client == null) {
                return null;
            }
            return client.getPlaybackSeekDataProvider();
        }

        public boolean isSeekEnabled() {
            PlaybackSeekUi.Client client = PlaybackFragment.this.mSeekUiClient;
            if (client == null) {
                return false;
            }
            return client.isSeekEnabled();
        }

        public void onSeekFinished(boolean z4) {
            PlaybackSeekUi.Client client = PlaybackFragment.this.mSeekUiClient;
            if (client != null) {
                client.onSeekFinished(z4);
            }
            PlaybackFragment.this.setSeekMode(false);
        }

        public void onSeekPositionChanged(long j5) {
            PlaybackSeekUi.Client client = PlaybackFragment.this.mSeekUiClient;
            if (client != null) {
                client.onSeekPositionChanged(j5);
            }
        }

        public void onSeekStarted() {
            PlaybackSeekUi.Client client = PlaybackFragment.this.mSeekUiClient;
            if (client != null) {
                client.onSeekStarted();
            }
            PlaybackFragment.this.setSeekMode(true);
        }
    };
    ValueAnimator mControlRowFadeInAnimator;
    ValueAnimator mControlRowFadeOutAnimator;
    boolean mControlVisible = true;
    boolean mControlVisibleBeforeOnCreateView = true;
    BaseOnItemViewClickedListener mExternalItemClickedListener;
    BaseOnItemViewSelectedListener mExternalItemSelectedListener;
    OnFadeCompleteListener mFadeCompleteListener;
    private final Animator.AnimatorListener mFadeListener = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            ItemBridgeAdapter.ViewHolder viewHolder;
            PlaybackFragment playbackFragment = PlaybackFragment.this;
            if (playbackFragment.mBgAlpha > 0) {
                playbackFragment.enableVerticalGridAnimations(true);
                OnFadeCompleteListener onFadeCompleteListener = PlaybackFragment.this.mFadeCompleteListener;
                if (onFadeCompleteListener != null) {
                    onFadeCompleteListener.onFadeInComplete();
                    return;
                }
                return;
            }
            VerticalGridView verticalGridView = playbackFragment.getVerticalGridView();
            if (verticalGridView != null && verticalGridView.getSelectedPosition() == 0 && (viewHolder = (ItemBridgeAdapter.ViewHolder) verticalGridView.findViewHolderForAdapterPosition(0)) != null && (viewHolder.getPresenter() instanceof PlaybackRowPresenter)) {
                ((PlaybackRowPresenter) viewHolder.getPresenter()).onReappear((RowPresenter.ViewHolder) viewHolder.getViewHolder());
            }
            OnFadeCompleteListener onFadeCompleteListener2 = PlaybackFragment.this.mFadeCompleteListener;
            if (onFadeCompleteListener2 != null) {
                onFadeCompleteListener2.onFadeOutComplete();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            PlaybackFragment.this.enableVerticalGridAnimations(false);
        }
    };
    boolean mFadingEnabled = true;
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                PlaybackFragment playbackFragment = PlaybackFragment.this;
                if (playbackFragment.mFadingEnabled) {
                    playbackFragment.hideControlsOverlay(true);
                }
            }
        }
    };
    PlaybackGlueHost.HostCallback mHostCallback;
    boolean mInSeek;
    View.OnKeyListener mInputEventHandler;
    private TimeInterpolator mLogAccelerateInterpolator = new LogAccelerateInterpolator(100, 0);
    private TimeInterpolator mLogDecelerateInterpolator = new LogDecelerateInterpolator(100, 0);
    int mMajorFadeTranslateY;
    int mMinorFadeTranslateY;
    private final BaseOnItemViewClickedListener mOnItemViewClickedListener = new BaseOnItemViewClickedListener() {
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
            BaseOnItemViewClickedListener baseOnItemViewClickedListener = PlaybackFragment.this.mPlaybackItemClickedListener;
            if (baseOnItemViewClickedListener != null && (viewHolder2 instanceof PlaybackRowPresenter.ViewHolder)) {
                baseOnItemViewClickedListener.onItemClicked(viewHolder, obj, viewHolder2, obj2);
            }
            BaseOnItemViewClickedListener baseOnItemViewClickedListener2 = PlaybackFragment.this.mExternalItemClickedListener;
            if (baseOnItemViewClickedListener2 != null) {
                baseOnItemViewClickedListener2.onItemClicked(viewHolder, obj, viewHolder2, obj2);
            }
        }
    };
    private final BaseOnItemViewSelectedListener mOnItemViewSelectedListener = new BaseOnItemViewSelectedListener() {
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
            BaseOnItemViewSelectedListener baseOnItemViewSelectedListener = PlaybackFragment.this.mExternalItemSelectedListener;
            if (baseOnItemViewSelectedListener != null) {
                baseOnItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, obj2);
            }
        }
    };
    private final BaseGridView.OnKeyInterceptListener mOnKeyInterceptListener = new BaseGridView.OnKeyInterceptListener() {
        public boolean onInterceptKeyEvent(KeyEvent keyEvent) {
            return PlaybackFragment.this.onInterceptInputEvent(keyEvent);
        }
    };
    private final BaseGridView.OnTouchInterceptListener mOnTouchInterceptListener = new BaseGridView.OnTouchInterceptListener() {
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return PlaybackFragment.this.onInterceptInputEvent(motionEvent);
        }
    };
    ValueAnimator mOtherRowFadeInAnimator;
    ValueAnimator mOtherRowFadeOutAnimator;
    int mOtherRowsCenterToBottom;
    int mPaddingBottom;
    BaseOnItemViewClickedListener mPlaybackItemClickedListener;
    PlaybackRowPresenter mPresenter;
    ProgressBarManager mProgressBarManager = new ProgressBarManager();
    View mRootView;
    Row mRow;
    RowsFragment mRowsFragment;
    PlaybackSeekUi.Client mSeekUiClient;
    private final SetSelectionRunnable mSetSelectionRunnable = new SetSelectionRunnable();
    boolean mShowOrHideControlsOverlayOnUserInteraction = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class OnFadeCompleteListener {
        public void onFadeInComplete() {
        }

        public void onFadeOutComplete() {
        }
    }

    private class SetSelectionRunnable implements Runnable {
        int mPosition;
        boolean mSmooth = true;

        SetSelectionRunnable() {
        }

        public void run() {
            RowsFragment rowsFragment = PlaybackFragment.this.mRowsFragment;
            if (rowsFragment != null) {
                rowsFragment.setSelectedPosition(this.mPosition, this.mSmooth);
            }
        }
    }

    public PlaybackFragment() {
        this.mProgressBarManager.setInitialDelay(500);
    }

    static void endAll(ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        if (valueAnimator.isStarted()) {
            valueAnimator.end();
        } else if (valueAnimator2.isStarted()) {
            valueAnimator2.end();
        }
    }

    private static ValueAnimator loadAnimator(Context context, int i5) {
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(context, i5);
        valueAnimator.setDuration(valueAnimator.getDuration());
        return valueAnimator;
    }

    private void loadBgAnimator() {
        AnonymousClass7 r02 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PlaybackFragment.this.setBgAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        };
        Context context = FragmentUtil.getContext(this);
        ValueAnimator loadAnimator = loadAnimator(context, R.animator.lb_playback_bg_fade_in);
        this.mBgFadeInAnimator = loadAnimator;
        loadAnimator.addUpdateListener(r02);
        this.mBgFadeInAnimator.addListener(this.mFadeListener);
        ValueAnimator loadAnimator2 = loadAnimator(context, R.animator.lb_playback_bg_fade_out);
        this.mBgFadeOutAnimator = loadAnimator2;
        loadAnimator2.addUpdateListener(r02);
        this.mBgFadeOutAnimator.addListener(this.mFadeListener);
    }

    private void loadControlRowAnimator() {
        AnonymousClass8 r02 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition;
                View view;
                if (PlaybackFragment.this.getVerticalGridView() != null && (findViewHolderForAdapterPosition = PlaybackFragment.this.getVerticalGridView().findViewHolderForAdapterPosition(0)) != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    view.setAlpha(floatValue);
                    view.setTranslationY(((float) PlaybackFragment.this.mAnimationTranslateY) * (1.0f - floatValue));
                }
            }
        };
        Context context = FragmentUtil.getContext(this);
        ValueAnimator loadAnimator = loadAnimator(context, R.animator.lb_playback_controls_fade_in);
        this.mControlRowFadeInAnimator = loadAnimator;
        loadAnimator.addUpdateListener(r02);
        this.mControlRowFadeInAnimator.setInterpolator(this.mLogDecelerateInterpolator);
        ValueAnimator loadAnimator2 = loadAnimator(context, R.animator.lb_playback_controls_fade_out);
        this.mControlRowFadeOutAnimator = loadAnimator2;
        loadAnimator2.addUpdateListener(r02);
        this.mControlRowFadeOutAnimator.setInterpolator(this.mLogAccelerateInterpolator);
    }

    private void loadOtherRowAnimator() {
        AnonymousClass9 r02 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (PlaybackFragment.this.getVerticalGridView() != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int childCount = PlaybackFragment.this.getVerticalGridView().getChildCount();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = PlaybackFragment.this.getVerticalGridView().getChildAt(i5);
                        if (PlaybackFragment.this.getVerticalGridView().getChildAdapterPosition(childAt) > 0) {
                            childAt.setAlpha(floatValue);
                            childAt.setTranslationY(((float) PlaybackFragment.this.mAnimationTranslateY) * (1.0f - floatValue));
                        }
                    }
                }
            }
        };
        Context context = FragmentUtil.getContext(this);
        ValueAnimator loadAnimator = loadAnimator(context, R.animator.lb_playback_controls_fade_in);
        this.mOtherRowFadeInAnimator = loadAnimator;
        loadAnimator.addUpdateListener(r02);
        this.mOtherRowFadeInAnimator.setInterpolator(this.mLogDecelerateInterpolator);
        ValueAnimator loadAnimator2 = loadAnimator(context, R.animator.lb_playback_controls_fade_out);
        this.mOtherRowFadeOutAnimator = loadAnimator2;
        loadAnimator2.addUpdateListener(r02);
        this.mOtherRowFadeOutAnimator.setInterpolator(new AccelerateInterpolator());
    }

    static void reverseFirstOrStartSecond(ValueAnimator valueAnimator, ValueAnimator valueAnimator2, boolean z4) {
        if (valueAnimator.isStarted()) {
            valueAnimator.reverse();
            if (!z4) {
                valueAnimator.end();
                return;
            }
            return;
        }
        valueAnimator2.start();
        if (!z4) {
            valueAnimator2.end();
        }
    }

    private void setupChildFragmentLayout() {
        setVerticalGridViewLayout(this.mRowsFragment.getVerticalGridView());
    }

    private void setupPresenter() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null && this.mRow != null && this.mPresenter != null) {
            PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
            if (presenterSelector == null) {
                ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
                classPresenterSelector.addClassPresenter(this.mRow.getClass(), this.mPresenter);
                this.mAdapter.setPresenterSelector(classPresenterSelector);
            } else if (presenterSelector instanceof ClassPresenterSelector) {
                ((ClassPresenterSelector) presenterSelector).addClassPresenter(this.mRow.getClass(), this.mPresenter);
            }
        }
    }

    private void setupRow() {
        Row row;
        ObjectAdapter objectAdapter = this.mAdapter;
        if ((objectAdapter instanceof ArrayObjectAdapter) && this.mRow != null) {
            ArrayObjectAdapter arrayObjectAdapter = (ArrayObjectAdapter) objectAdapter;
            if (arrayObjectAdapter.size() == 0) {
                arrayObjectAdapter.add(this.mRow);
            } else {
                arrayObjectAdapter.replace(0, this.mRow);
            }
        } else if ((objectAdapter instanceof SparseArrayObjectAdapter) && (row = this.mRow) != null) {
            ((SparseArrayObjectAdapter) objectAdapter).set(0, row);
        }
    }

    private void startFadeTimer(int i5) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, (long) i5);
        }
    }

    private void stopFadeTimer() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private void updateBackground() {
        View view = this.mBackgroundView;
        if (view != null) {
            int i5 = this.mBgDarkColor;
            int i6 = this.mBackgroundType;
            if (i6 == 0) {
                i5 = 0;
            } else if (i6 == 2) {
                i5 = this.mBgLightColor;
            }
            view.setBackground(new ColorDrawable(i5));
            setBgAlpha(this.mBgAlpha);
        }
    }

    /* access modifiers changed from: package-private */
    public void enableVerticalGridAnimations(boolean z4) {
        if (getVerticalGridView() != null) {
            getVerticalGridView().setAnimateChildLayout(z4);
        }
    }

    @Deprecated
    public void fadeOut() {
        showControlsOverlay(false, false);
    }

    public ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getBackgroundType() {
        return this.mBackgroundType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public OnFadeCompleteListener getFadeCompleteListener() {
        return this.mFadeCompleteListener;
    }

    public ProgressBarManager getProgressBarManager() {
        return this.mProgressBarManager;
    }

    /* access modifiers changed from: package-private */
    public VerticalGridView getVerticalGridView() {
        RowsFragment rowsFragment = this.mRowsFragment;
        if (rowsFragment == null) {
            return null;
        }
        return rowsFragment.getVerticalGridView();
    }

    public void hideControlsOverlay(boolean z4) {
        showControlsOverlay(false, z4);
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.mFadingEnabled;
    }

    public boolean isControlsOverlayVisible() {
        return this.mControlVisible;
    }

    @Deprecated
    public boolean isFadingEnabled() {
        return isControlsOverlayAutoHideEnabled();
    }

    public boolean isShowOrHideControlsOverlayOnUserInteraction() {
        return this.mShowOrHideControlsOverlayOnUserInteraction;
    }

    public void notifyPlaybackRowChanged() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null) {
            objectAdapter.notifyItemRangeChanged(0, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onBufferingStateChanged(boolean z4) {
        ProgressBarManager progressBarManager = getProgressBarManager();
        if (progressBarManager == null) {
            return;
        }
        if (z4) {
            progressBarManager.show();
        } else {
            progressBarManager.hide();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mOtherRowsCenterToBottom = getResources().getDimensionPixelSize(R.dimen.lb_playback_other_rows_center_to_bottom);
        this.mPaddingBottom = getResources().getDimensionPixelSize(R.dimen.lb_playback_controls_padding_bottom);
        this.mBgDarkColor = getResources().getColor(R.color.lb_playback_controls_background_dark);
        this.mBgLightColor = getResources().getColor(R.color.lb_playback_controls_background_light);
        TypedValue typedValue = new TypedValue();
        FragmentUtil.getContext(this).getTheme().resolveAttribute(R.attr.playbackControlsAutoHideTimeout, typedValue, true);
        this.mAutohideTimerAfterPlayingInMs = typedValue.data;
        FragmentUtil.getContext(this).getTheme().resolveAttribute(R.attr.playbackControlsAutoHideTickleTimeout, typedValue, true);
        this.mAutohideTimerAfterTickleInMs = typedValue.data;
        this.mMajorFadeTranslateY = getResources().getDimensionPixelSize(R.dimen.lb_playback_major_fade_translate_y);
        this.mMinorFadeTranslateY = getResources().getDimensionPixelSize(R.dimen.lb_playback_minor_fade_translate_y);
        loadBgAnimator();
        loadControlRowAnimator();
        loadOtherRowAnimator();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lb_playback_fragment, viewGroup, false);
        this.mRootView = inflate;
        this.mBackgroundView = inflate.findViewById(R.id.playback_fragment_background);
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i5 = R.id.playback_controls_dock;
        RowsFragment rowsFragment = (RowsFragment) childFragmentManager.findFragmentById(i5);
        this.mRowsFragment = rowsFragment;
        if (rowsFragment == null) {
            this.mRowsFragment = new RowsFragment();
            getChildFragmentManager().beginTransaction().replace(i5, this.mRowsFragment).commit();
        }
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter == null) {
            setAdapter(new ArrayObjectAdapter((PresenterSelector) new ClassPresenterSelector()));
        } else {
            this.mRowsFragment.setAdapter(objectAdapter);
        }
        this.mRowsFragment.setOnItemViewSelectedListener(this.mOnItemViewSelectedListener);
        this.mRowsFragment.setOnItemViewClickedListener(this.mOnItemViewClickedListener);
        this.mBgAlpha = 255;
        updateBackground();
        this.mRowsFragment.setExternalAdapterListener(this.mAdapterListener);
        ProgressBarManager progressBarManager = getProgressBarManager();
        if (progressBarManager != null) {
            progressBarManager.setRootView((ViewGroup) this.mRootView);
        }
        return this.mRootView;
    }

    public void onDestroy() {
        PlaybackGlueHost.HostCallback hostCallback = this.mHostCallback;
        if (hostCallback != null) {
            hostCallback.onHostDestroy();
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        this.mRootView = null;
        this.mBackgroundView = null;
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public void onError(int i5, CharSequence charSequence) {
    }

    /* access modifiers changed from: package-private */
    public boolean onInterceptInputEvent(InputEvent inputEvent) {
        int i5;
        int i6;
        boolean z4;
        boolean z5 = this.mControlVisible;
        if (inputEvent instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) inputEvent;
            i6 = keyEvent.getKeyCode();
            i5 = keyEvent.getAction();
            View.OnKeyListener onKeyListener = this.mInputEventHandler;
            if (onKeyListener != null) {
                z4 = onKeyListener.onKey(getView(), i6, keyEvent);
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
            i6 = 0;
            i5 = 0;
        }
        if (i6 != 4 && i6 != 111) {
            switch (i6) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    if (!z5) {
                        z4 = true;
                    }
                    if (this.mShowOrHideControlsOverlayOnUserInteraction && i5 == 0) {
                        tickle();
                    }
                    return z4;
                default:
                    if (this.mShowOrHideControlsOverlayOnUserInteraction && z4 && i5 == 0) {
                        tickle();
                        return z4;
                    }
            }
        } else if (this.mInSeek) {
            return false;
        } else {
            if (this.mShowOrHideControlsOverlayOnUserInteraction && z5) {
                if (((KeyEvent) inputEvent).getAction() == 1) {
                    hideControlsOverlay(true);
                }
                return true;
            }
        }
        return z4;
    }

    public void onPause() {
        PlaybackGlueHost.HostCallback hostCallback = this.mHostCallback;
        if (hostCallback != null) {
            hostCallback.onHostPause();
        }
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.mControlVisible && this.mFadingEnabled) {
            startFadeTimer(this.mAutohideTimerAfterPlayingInMs);
        }
        getVerticalGridView().setOnTouchInterceptListener(this.mOnTouchInterceptListener);
        getVerticalGridView().setOnKeyInterceptListener(this.mOnKeyInterceptListener);
        PlaybackGlueHost.HostCallback hostCallback = this.mHostCallback;
        if (hostCallback != null) {
            hostCallback.onHostResume();
        }
    }

    public void onStart() {
        super.onStart();
        setupChildFragmentLayout();
        this.mRowsFragment.setAdapter(this.mAdapter);
        PlaybackGlueHost.HostCallback hostCallback = this.mHostCallback;
        if (hostCallback != null) {
            hostCallback.onHostStart();
        }
    }

    public void onStop() {
        PlaybackGlueHost.HostCallback hostCallback = this.mHostCallback;
        if (hostCallback != null) {
            hostCallback.onHostStop();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onVideoSizeChanged(int i5, int i6) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mControlVisible = true;
        if (!this.mControlVisibleBeforeOnCreateView) {
            showControlsOverlay(false, false);
            this.mControlVisibleBeforeOnCreateView = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void resetFocus() {
        ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) getVerticalGridView().findViewHolderForAdapterPosition(0);
        if (viewHolder != null && (viewHolder.getPresenter() instanceof PlaybackRowPresenter)) {
            ((PlaybackRowPresenter) viewHolder.getPresenter()).onReappear((RowPresenter.ViewHolder) viewHolder.getViewHolder());
        }
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        setupRow();
        setupPresenter();
        setPlaybackRowPresenterAlignment();
        RowsFragment rowsFragment = this.mRowsFragment;
        if (rowsFragment != null) {
            rowsFragment.setAdapter(objectAdapter);
        }
    }

    public void setBackgroundType(int i5) {
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("Invalid background type");
        } else if (i5 != this.mBackgroundType) {
            this.mBackgroundType = i5;
            updateBackground();
        }
    }

    /* access modifiers changed from: package-private */
    public void setBgAlpha(int i5) {
        this.mBgAlpha = i5;
        View view = this.mBackgroundView;
        if (view != null) {
            view.getBackground().setAlpha(i5);
        }
    }

    public void setControlsOverlayAutoHideEnabled(boolean z4) {
        if (z4 != this.mFadingEnabled) {
            this.mFadingEnabled = z4;
            if (isResumed() && getView().hasFocus()) {
                showControlsOverlay(true);
                if (z4) {
                    startFadeTimer(this.mAutohideTimerAfterPlayingInMs);
                } else {
                    stopFadeTimer();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setFadeCompleteListener(OnFadeCompleteListener onFadeCompleteListener) {
        this.mFadeCompleteListener = onFadeCompleteListener;
    }

    @Deprecated
    public void setFadingEnabled(boolean z4) {
        setControlsOverlayAutoHideEnabled(z4);
    }

    public void setHostCallback(PlaybackGlueHost.HostCallback hostCallback) {
        this.mHostCallback = hostCallback;
    }

    public void setOnItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.mExternalItemClickedListener = baseOnItemViewClickedListener;
    }

    public void setOnItemViewSelectedListener(BaseOnItemViewSelectedListener baseOnItemViewSelectedListener) {
        this.mExternalItemSelectedListener = baseOnItemViewSelectedListener;
    }

    public final void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
        this.mInputEventHandler = onKeyListener;
    }

    public void setOnPlaybackItemViewClickedListener(BaseOnItemViewClickedListener baseOnItemViewClickedListener) {
        this.mPlaybackItemClickedListener = baseOnItemViewClickedListener;
    }

    public void setPlaybackRow(Row row) {
        this.mRow = row;
        setupRow();
        setupPresenter();
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.mPresenter = playbackRowPresenter;
        setupPresenter();
        setPlaybackRowPresenterAlignment();
    }

    /* access modifiers changed from: package-private */
    public void setPlaybackRowPresenterAlignment() {
        Presenter[] presenters;
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null && objectAdapter.getPresenterSelector() != null && (presenters = this.mAdapter.getPresenterSelector().getPresenters()) != null) {
            for (int i5 = 0; i5 < presenters.length; i5++) {
                Presenter presenter = presenters[i5];
                if (presenter instanceof PlaybackRowPresenter) {
                    Class<ItemAlignmentFacet> cls = ItemAlignmentFacet.class;
                    if (presenter.getFacet(cls) == null) {
                        ItemAlignmentFacet itemAlignmentFacet = new ItemAlignmentFacet();
                        ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef = new ItemAlignmentFacet.ItemAlignmentDef();
                        itemAlignmentDef.setItemAlignmentOffset(0);
                        itemAlignmentDef.setItemAlignmentOffsetPercent(100.0f);
                        itemAlignmentFacet.setAlignmentDefs(new ItemAlignmentFacet.ItemAlignmentDef[]{itemAlignmentDef});
                        presenters[i5].setFacet(cls, itemAlignmentFacet);
                    }
                }
            }
        }
    }

    public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
        this.mSeekUiClient = client;
    }

    /* access modifiers changed from: package-private */
    public void setSeekMode(boolean z4) {
        int i5;
        if (this.mInSeek != z4) {
            this.mInSeek = z4;
            getVerticalGridView().setSelectedPosition(0);
            if (this.mInSeek) {
                stopFadeTimer();
            }
            showControlsOverlay(true);
            int childCount = getVerticalGridView().getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getVerticalGridView().getChildAt(i6);
                if (getVerticalGridView().getChildAdapterPosition(childAt) > 0) {
                    if (this.mInSeek) {
                        i5 = 4;
                    } else {
                        i5 = 0;
                    }
                    childAt.setVisibility(i5);
                }
            }
        }
    }

    public void setSelectedPosition(int i5) {
        setSelectedPosition(i5, true);
    }

    public void setShowOrHideControlsOverlayOnUserInteraction(boolean z4) {
        this.mShowOrHideControlsOverlayOnUserInteraction = z4;
    }

    /* access modifiers changed from: package-private */
    public void setVerticalGridViewLayout(VerticalGridView verticalGridView) {
        if (verticalGridView != null) {
            verticalGridView.setWindowAlignmentOffset(-this.mPaddingBottom);
            verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            verticalGridView.setItemAlignmentOffset(this.mOtherRowsCenterToBottom - this.mPaddingBottom);
            verticalGridView.setItemAlignmentOffsetPercent(50.0f);
            verticalGridView.setPadding(verticalGridView.getPaddingLeft(), verticalGridView.getPaddingTop(), verticalGridView.getPaddingRight(), this.mPaddingBottom);
            verticalGridView.setWindowAlignment(2);
        }
    }

    public void showControlsOverlay(boolean z4) {
        showControlsOverlay(true, z4);
    }

    public void tickle() {
        stopFadeTimer();
        showControlsOverlay(true);
        int i5 = this.mAutohideTimerAfterTickleInMs;
        if (i5 > 0 && this.mFadingEnabled) {
            startFadeTimer(i5);
        }
    }

    public void setSelectedPosition(int i5, boolean z4) {
        SetSelectionRunnable setSelectionRunnable = this.mSetSelectionRunnable;
        setSelectionRunnable.mPosition = i5;
        setSelectionRunnable.mSmooth = z4;
        if (getView() != null && getView().getHandler() != null) {
            getView().getHandler().post(this.mSetSelectionRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void showControlsOverlay(boolean z4, boolean z5) {
        int i5;
        if (getView() == null) {
            this.mControlVisibleBeforeOnCreateView = z4;
            return;
        }
        if (!isResumed()) {
            z5 = false;
        }
        if (z4 != this.mControlVisible) {
            this.mControlVisible = z4;
            if (!z4) {
                stopFadeTimer();
            }
            this.mAnimationTranslateY = (getVerticalGridView() == null || getVerticalGridView().getSelectedPosition() == 0) ? this.mMajorFadeTranslateY : this.mMinorFadeTranslateY;
            if (z4) {
                reverseFirstOrStartSecond(this.mBgFadeOutAnimator, this.mBgFadeInAnimator, z5);
                reverseFirstOrStartSecond(this.mControlRowFadeOutAnimator, this.mControlRowFadeInAnimator, z5);
                reverseFirstOrStartSecond(this.mOtherRowFadeOutAnimator, this.mOtherRowFadeInAnimator, z5);
            } else {
                reverseFirstOrStartSecond(this.mBgFadeInAnimator, this.mBgFadeOutAnimator, z5);
                reverseFirstOrStartSecond(this.mControlRowFadeInAnimator, this.mControlRowFadeOutAnimator, z5);
                reverseFirstOrStartSecond(this.mOtherRowFadeInAnimator, this.mOtherRowFadeOutAnimator, z5);
            }
            if (z5) {
                View view = getView();
                if (z4) {
                    i5 = R.string.lb_playback_controls_shown;
                } else {
                    i5 = R.string.lb_playback_controls_hidden;
                }
                view.announceForAccessibility(getString(i5));
            }
        } else if (!z5) {
            endAll(this.mBgFadeInAnimator, this.mBgFadeOutAnimator);
            endAll(this.mControlRowFadeInAnimator, this.mControlRowFadeOutAnimator);
            endAll(this.mOtherRowFadeInAnimator, this.mOtherRowFadeOutAnimator);
        }
    }
}
