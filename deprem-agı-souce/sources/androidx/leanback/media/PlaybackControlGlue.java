package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ControlButtonPresenterSelector;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class PlaybackControlGlue extends PlaybackGlue implements OnActionClickedListener, View.OnKeyListener {
    public static final int ACTION_CUSTOM_LEFT_FIRST = 1;
    public static final int ACTION_CUSTOM_RIGHT_FIRST = 4096;
    public static final int ACTION_FAST_FORWARD = 128;
    public static final int ACTION_PLAY_PAUSE = 64;
    public static final int ACTION_REWIND = 32;
    public static final int ACTION_SKIP_TO_NEXT = 256;
    public static final int ACTION_SKIP_TO_PREVIOUS = 16;
    static final boolean DEBUG = false;
    static final int MSG_UPDATE_PLAYBACK_STATE = 100;
    private static final int NUMBER_OF_SEEK_SPEEDS = 5;
    public static final int PLAYBACK_SPEED_FAST_L0 = 10;
    public static final int PLAYBACK_SPEED_FAST_L1 = 11;
    public static final int PLAYBACK_SPEED_FAST_L2 = 12;
    public static final int PLAYBACK_SPEED_FAST_L3 = 13;
    public static final int PLAYBACK_SPEED_FAST_L4 = 14;
    public static final int PLAYBACK_SPEED_INVALID = -1;
    public static final int PLAYBACK_SPEED_NORMAL = 1;
    public static final int PLAYBACK_SPEED_PAUSED = 0;
    static final String TAG = "PlaybackControlGlue";
    private static final int UPDATE_PLAYBACK_STATE_DELAY_MS = 2000;
    static final Handler sHandler = new UpdatePlaybackStateHandler();
    private PlaybackControlsRow mControlsRow;
    private PlaybackRowPresenter mControlsRowPresenter;
    private boolean mFadeWhenPlaying;
    private PlaybackControlsRow.FastForwardAction mFastForwardAction;
    private final int[] mFastForwardSpeeds;
    final WeakReference<PlaybackControlGlue> mGlueWeakReference;
    private PlaybackControlsRow.PlayPauseAction mPlayPauseAction;
    private int mPlaybackSpeed;
    private PlaybackControlsRow.RewindAction mRewindAction;
    private final int[] mRewindSpeeds;
    private PlaybackControlsRow.SkipNextAction mSkipNextAction;
    private PlaybackControlsRow.SkipPreviousAction mSkipPreviousAction;

    static class UpdatePlaybackStateHandler extends Handler {
        UpdatePlaybackStateHandler() {
        }

        public void handleMessage(Message message) {
            PlaybackControlGlue playbackControlGlue;
            if (message.what == 100 && (playbackControlGlue = (PlaybackControlGlue) ((WeakReference) message.obj).get()) != null) {
                playbackControlGlue.updatePlaybackState();
            }
        }
    }

    public PlaybackControlGlue(Context context, int[] iArr) {
        this(context, iArr, iArr);
    }

    private int getMaxForwardSpeedId() {
        return this.mFastForwardSpeeds.length + 9;
    }

    private int getMaxRewindSpeedId() {
        return this.mRewindSpeeds.length + 9;
    }

    private static void notifyItemChanged(SparseArrayObjectAdapter sparseArrayObjectAdapter, Object obj) {
        int indexOf = sparseArrayObjectAdapter.indexOf(obj);
        if (indexOf >= 0) {
            sparseArrayObjectAdapter.notifyArrayItemRangeChanged(indexOf, 1);
        }
    }

    private void updateControlsRow() {
        updateRowMetadata();
        updateControlButtons();
        sHandler.removeMessages(100, this.mGlueWeakReference);
        updatePlaybackState();
    }

    private void updatePlaybackStatusAfterUserAction() {
        updatePlaybackState(this.mPlaybackSpeed);
        Handler handler = sHandler;
        handler.removeMessages(100, this.mGlueWeakReference);
        handler.sendMessageDelayed(handler.obtainMessage(100, this.mGlueWeakReference), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    private void updateRowMetadata() {
        if (this.mControlsRow != null) {
            if (!hasValidMedia()) {
                this.mControlsRow.setImageDrawable((Drawable) null);
                this.mControlsRow.setTotalTime(0);
                this.mControlsRow.setCurrentTime(0);
            } else {
                this.mControlsRow.setImageDrawable(getMediaArt());
                this.mControlsRow.setTotalTime(getMediaDuration());
                this.mControlsRow.setCurrentTime(getCurrentPosition());
            }
            if (getHost() != null) {
                getHost().notifyPlaybackRowChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SparseArrayObjectAdapter createPrimaryActionsAdapter(PresenterSelector presenterSelector) {
        SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(presenterSelector);
        onCreatePrimaryActions(sparseArrayObjectAdapter);
        return sparseArrayObjectAdapter;
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchAction(Action action, KeyEvent keyEvent) {
        boolean z4;
        if (action == this.mPlayPauseAction) {
            if (keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 126) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 127) {
                int i5 = this.mPlaybackSpeed;
                if (!z4 ? i5 != 0 : i5 == 1) {
                    this.mPlaybackSpeed = 0;
                    pause();
                    updatePlaybackStatusAfterUserAction();
                    return true;
                }
            }
            if (z4 && this.mPlaybackSpeed != 1) {
                this.mPlaybackSpeed = 1;
                play(1);
            }
            updatePlaybackStatusAfterUserAction();
            return true;
        } else if (action == this.mSkipNextAction) {
            next();
            return true;
        } else if (action == this.mSkipPreviousAction) {
            previous();
            return true;
        } else if (action == this.mFastForwardAction) {
            if (this.mPlaybackSpeed < getMaxForwardSpeedId()) {
                int i6 = this.mPlaybackSpeed;
                switch (i6) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        this.mPlaybackSpeed = i6 + 1;
                        break;
                    default:
                        this.mPlaybackSpeed = 10;
                        break;
                }
                play(this.mPlaybackSpeed);
                updatePlaybackStatusAfterUserAction();
            }
            return true;
        } else if (action != this.mRewindAction) {
            return false;
        } else {
            if (this.mPlaybackSpeed > (-getMaxRewindSpeedId())) {
                int i7 = this.mPlaybackSpeed;
                switch (i7) {
                    case -13:
                    case -12:
                    case -11:
                    case -10:
                        this.mPlaybackSpeed = i7 - 1;
                        break;
                    default:
                        this.mPlaybackSpeed = -10;
                        break;
                }
                play(this.mPlaybackSpeed);
                updatePlaybackStatusAfterUserAction();
            }
            return true;
        }
    }

    public void enableProgressUpdating(boolean z4) {
    }

    public PlaybackControlsRow getControlsRow() {
        return this.mControlsRow;
    }

    @Deprecated
    public PlaybackControlsRowPresenter getControlsRowPresenter() {
        PlaybackRowPresenter playbackRowPresenter = this.mControlsRowPresenter;
        if (playbackRowPresenter instanceof PlaybackControlsRowPresenter) {
            return (PlaybackControlsRowPresenter) playbackRowPresenter;
        }
        return null;
    }

    public abstract int getCurrentPosition();

    public abstract int getCurrentSpeedId();

    public int[] getFastForwardSpeeds() {
        return this.mFastForwardSpeeds;
    }

    public abstract Drawable getMediaArt();

    public abstract int getMediaDuration();

    public abstract CharSequence getMediaSubtitle();

    public abstract CharSequence getMediaTitle();

    public PlaybackRowPresenter getPlaybackRowPresenter() {
        return this.mControlsRowPresenter;
    }

    public int[] getRewindSpeeds() {
        return this.mRewindSpeeds;
    }

    public abstract long getSupportedActions();

    public int getUpdatePeriod() {
        return 500;
    }

    public abstract boolean hasValidMedia();

    public boolean isFadingEnabled() {
        return this.mFadeWhenPlaying;
    }

    public abstract boolean isMediaPlaying();

    public boolean isPlaying() {
        return isMediaPlaying();
    }

    public void onActionClicked(Action action) {
        dispatchAction(action, (KeyEvent) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        playbackGlueHost.setOnKeyInterceptListener(this);
        playbackGlueHost.setOnActionClickedListener(this);
        if (getControlsRow() == null || getPlaybackRowPresenter() == null) {
            onCreateControlsRowAndPresenter();
        }
        playbackGlueHost.setPlaybackRowPresenter(getPlaybackRowPresenter());
        playbackGlueHost.setPlaybackRow(getControlsRow());
    }

    /* access modifiers changed from: protected */
    public void onCreateControlsRowAndPresenter() {
        if (getControlsRow() == null) {
            setControlsRow(new PlaybackControlsRow(this));
        }
        if (getPlaybackRowPresenter() == null) {
            setPlaybackRowPresenter(new PlaybackControlsRowPresenter(new AbstractDetailsDescriptionPresenter() {
                /* access modifiers changed from: protected */
                public void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
                    PlaybackControlGlue playbackControlGlue = (PlaybackControlGlue) obj;
                    if (playbackControlGlue.hasValidMedia()) {
                        viewHolder.getTitle().setText(playbackControlGlue.getMediaTitle());
                        viewHolder.getSubtitle().setText(playbackControlGlue.getMediaSubtitle());
                        return;
                    }
                    viewHolder.getTitle().setText("");
                    viewHolder.getSubtitle().setText("");
                }
            }) {
                /* access modifiers changed from: protected */
                public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
                    super.onBindRowViewHolder(viewHolder, obj);
                    viewHolder.setOnKeyListener(PlaybackControlGlue.this);
                }

                /* access modifiers changed from: protected */
                public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
                    super.onUnbindRowViewHolder(viewHolder);
                    viewHolder.setOnKeyListener((View.OnKeyListener) null);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onCreatePrimaryActions(SparseArrayObjectAdapter sparseArrayObjectAdapter) {
    }

    /* access modifiers changed from: protected */
    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromHost() {
        enableProgressUpdating(false);
        super.onDetachedFromHost();
    }

    /* access modifiers changed from: protected */
    public void onHostStart() {
        enableProgressUpdating(true);
    }

    /* access modifiers changed from: protected */
    public void onHostStop() {
        enableProgressUpdating(false);
    }

    public boolean onKey(View view, int i5, KeyEvent keyEvent) {
        if (!(i5 == 4 || i5 == 111)) {
            switch (i5) {
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    SparseArrayObjectAdapter sparseArrayObjectAdapter = (SparseArrayObjectAdapter) this.mControlsRow.getPrimaryActionsAdapter();
                    Action actionForKeyCode = this.mControlsRow.getActionForKeyCode(sparseArrayObjectAdapter, i5);
                    if (actionForKeyCode == null || (actionForKeyCode != sparseArrayObjectAdapter.lookup(64) && actionForKeyCode != sparseArrayObjectAdapter.lookup(32) && actionForKeyCode != sparseArrayObjectAdapter.lookup(128) && actionForKeyCode != sparseArrayObjectAdapter.lookup(16) && actionForKeyCode != sparseArrayObjectAdapter.lookup(256))) {
                        return false;
                    }
                    if (keyEvent.getAction() == 0) {
                        dispatchAction(actionForKeyCode, keyEvent);
                    }
                    return true;
            }
        }
        int i6 = this.mPlaybackSpeed;
        if (i6 < 10 && i6 > -10) {
            return false;
        }
        this.mPlaybackSpeed = 1;
        play(1);
        updatePlaybackStatusAfterUserAction();
        if (i5 == 4 || i5 == 111) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMetadataChanged() {
        updateRowMetadata();
    }

    /* access modifiers changed from: protected */
    public void onStateChanged() {
        if (hasValidMedia()) {
            Handler handler = sHandler;
            if (handler.hasMessages(100, this.mGlueWeakReference)) {
                handler.removeMessages(100, this.mGlueWeakReference);
                if (getCurrentSpeedId() != this.mPlaybackSpeed) {
                    handler.sendMessageDelayed(handler.obtainMessage(100, this.mGlueWeakReference), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                } else {
                    updatePlaybackState();
                }
            } else {
                updatePlaybackState();
            }
        }
    }

    public void play(int i5) {
    }

    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        this.mControlsRow = playbackControlsRow;
        playbackControlsRow.setPrimaryActionsAdapter(createPrimaryActionsAdapter(new ControlButtonPresenterSelector()));
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((PresenterSelector) new ControlButtonPresenterSelector());
        onCreateSecondaryActions(arrayObjectAdapter);
        getControlsRow().setSecondaryActionsAdapter(arrayObjectAdapter);
        updateControlsRow();
    }

    @Deprecated
    public void setControlsRowPresenter(PlaybackControlsRowPresenter playbackControlsRowPresenter) {
        this.mControlsRowPresenter = playbackControlsRowPresenter;
    }

    public void setFadingEnabled(boolean z4) {
        this.mFadeWhenPlaying = z4;
        if (!z4 && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(false);
        }
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.mControlsRowPresenter = playbackRowPresenter;
    }

    /* access modifiers changed from: package-private */
    public void updateControlButtons() {
        SparseArrayObjectAdapter sparseArrayObjectAdapter = (SparseArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter();
        long supportedActions = getSupportedActions();
        int i5 = ((16 & supportedActions) > 0 ? 1 : ((16 & supportedActions) == 0 ? 0 : -1));
        if (i5 != 0 && this.mSkipPreviousAction == null) {
            PlaybackControlsRow.SkipPreviousAction skipPreviousAction = new PlaybackControlsRow.SkipPreviousAction(getContext());
            this.mSkipPreviousAction = skipPreviousAction;
            sparseArrayObjectAdapter.set(16, skipPreviousAction);
        } else if (i5 == 0 && this.mSkipPreviousAction != null) {
            sparseArrayObjectAdapter.clear(16);
            this.mSkipPreviousAction = null;
        }
        int i6 = ((32 & supportedActions) > 0 ? 1 : ((32 & supportedActions) == 0 ? 0 : -1));
        if (i6 != 0 && this.mRewindAction == null) {
            PlaybackControlsRow.RewindAction rewindAction = new PlaybackControlsRow.RewindAction(getContext(), this.mRewindSpeeds.length);
            this.mRewindAction = rewindAction;
            sparseArrayObjectAdapter.set(32, rewindAction);
        } else if (i6 == 0 && this.mRewindAction != null) {
            sparseArrayObjectAdapter.clear(32);
            this.mRewindAction = null;
        }
        int i7 = ((64 & supportedActions) > 0 ? 1 : ((64 & supportedActions) == 0 ? 0 : -1));
        if (i7 != 0 && this.mPlayPauseAction == null) {
            PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
            this.mPlayPauseAction = playPauseAction;
            sparseArrayObjectAdapter.set(64, playPauseAction);
        } else if (i7 == 0 && this.mPlayPauseAction != null) {
            sparseArrayObjectAdapter.clear(64);
            this.mPlayPauseAction = null;
        }
        int i8 = ((128 & supportedActions) > 0 ? 1 : ((128 & supportedActions) == 0 ? 0 : -1));
        if (i8 != 0 && this.mFastForwardAction == null) {
            PlaybackControlsRow.FastForwardAction fastForwardAction = new PlaybackControlsRow.FastForwardAction(getContext(), this.mFastForwardSpeeds.length);
            this.mFastForwardAction = fastForwardAction;
            sparseArrayObjectAdapter.set(128, fastForwardAction);
        } else if (i8 == 0 && this.mFastForwardAction != null) {
            sparseArrayObjectAdapter.clear(128);
            this.mFastForwardAction = null;
        }
        int i9 = ((supportedActions & 256) > 0 ? 1 : ((supportedActions & 256) == 0 ? 0 : -1));
        if (i9 != 0 && this.mSkipNextAction == null) {
            PlaybackControlsRow.SkipNextAction skipNextAction = new PlaybackControlsRow.SkipNextAction(getContext());
            this.mSkipNextAction = skipNextAction;
            sparseArrayObjectAdapter.set(256, skipNextAction);
        } else if (i9 == 0 && this.mSkipNextAction != null) {
            sparseArrayObjectAdapter.clear(256);
            this.mSkipNextAction = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void updatePlaybackState() {
        if (hasValidMedia()) {
            int currentSpeedId = getCurrentSpeedId();
            this.mPlaybackSpeed = currentSpeedId;
            updatePlaybackState(currentSpeedId);
        }
    }

    public void updateProgress() {
        int currentPosition = getCurrentPosition();
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            playbackControlsRow.setCurrentTime(currentPosition);
        }
    }

    public PlaybackControlGlue(Context context, int[] iArr, int[] iArr2) {
        super(context);
        this.mPlaybackSpeed = 1;
        this.mFadeWhenPlaying = true;
        this.mGlueWeakReference = new WeakReference<>(this);
        if (iArr.length == 0 || iArr.length > 5) {
            throw new IllegalStateException("invalid fastForwardSpeeds array size");
        }
        this.mFastForwardSpeeds = iArr;
        if (iArr2.length == 0 || iArr2.length > 5) {
            throw new IllegalStateException("invalid rewindSpeeds array size");
        }
        this.mRewindSpeeds = iArr2;
    }

    public final void play() {
        play(1);
    }

    private void updatePlaybackState(int i5) {
        if (this.mControlsRow != null) {
            SparseArrayObjectAdapter sparseArrayObjectAdapter = (SparseArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter();
            PlaybackControlsRow.FastForwardAction fastForwardAction = this.mFastForwardAction;
            if (fastForwardAction != null) {
                int i6 = i5 >= 10 ? i5 - 9 : 0;
                if (fastForwardAction.getIndex() != i6) {
                    this.mFastForwardAction.setIndex(i6);
                    notifyItemChanged(sparseArrayObjectAdapter, this.mFastForwardAction);
                }
            }
            PlaybackControlsRow.RewindAction rewindAction = this.mRewindAction;
            if (rewindAction != null) {
                int i7 = i5 <= -10 ? (-i5) - 9 : 0;
                if (rewindAction.getIndex() != i7) {
                    this.mRewindAction.setIndex(i7);
                    notifyItemChanged(sparseArrayObjectAdapter, this.mRewindAction);
                }
            }
            int i8 = 1;
            if (i5 == 0) {
                updateProgress();
                enableProgressUpdating(false);
            } else {
                enableProgressUpdating(true);
            }
            if (this.mFadeWhenPlaying && getHost() != null) {
                getHost().setControlsOverlayAutoHideEnabled(i5 == 1);
            }
            PlaybackControlsRow.PlayPauseAction playPauseAction = this.mPlayPauseAction;
            if (playPauseAction != null) {
                if (i5 == 0) {
                    i8 = 0;
                }
                if (playPauseAction.getIndex() != i8) {
                    this.mPlayPauseAction.setIndex(i8);
                    notifyItemChanged(sparseArrayObjectAdapter, this.mPlayPauseAction);
                }
            }
            List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
            if (playerCallbacks != null) {
                int size = playerCallbacks.size();
                for (int i9 = 0; i9 < size; i9++) {
                    playerCallbacks.get(i9).onPlayStateChanged(this);
                }
            }
        }
    }
}
