package androidx.leanback.media;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.PlaybackTransportRowPresenter;
import androidx.leanback.widget.RowPresenter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;

public class PlaybackTransportControlGlue<T extends PlayerAdapter> extends PlaybackBaseControlGlue<T> {
    static final boolean DEBUG = false;
    static final int MSG_UPDATE_PLAYBACK_STATE = 100;
    static final String TAG = "PlaybackTransportGlue";
    static final int UPDATE_PLAYBACK_STATE_DELAY_MS = 2000;
    static final Handler sHandler = new UpdatePlaybackStateHandler();
    final WeakReference<PlaybackBaseControlGlue> mGlueWeakReference = new WeakReference<>(this);
    final PlaybackTransportControlGlue<T>.SeekUiClient mPlaybackSeekUiClient = new SeekUiClient();
    boolean mSeekEnabled;
    PlaybackSeekDataProvider mSeekProvider;

    class SeekUiClient extends PlaybackSeekUi.Client {
        boolean mIsSeek;
        long mLastUserPosition;
        boolean mPausedBeforeSeek;
        long mPositionBeforeSeek;

        SeekUiClient() {
        }

        public PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
            return PlaybackTransportControlGlue.this.mSeekProvider;
        }

        public boolean isSeekEnabled() {
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            if (playbackTransportControlGlue.mSeekProvider != null || playbackTransportControlGlue.mSeekEnabled) {
                return true;
            }
            return false;
        }

        public void onSeekFinished(boolean z4) {
            if (!z4) {
                long j5 = this.mLastUserPosition;
                if (j5 >= 0) {
                    PlaybackTransportControlGlue.this.seekTo(j5);
                }
            } else {
                long j6 = this.mPositionBeforeSeek;
                if (j6 >= 0) {
                    PlaybackTransportControlGlue.this.seekTo(j6);
                }
            }
            this.mIsSeek = false;
            if (!this.mPausedBeforeSeek) {
                PlaybackTransportControlGlue.this.play();
                return;
            }
            PlaybackTransportControlGlue.this.mPlayerAdapter.setProgressUpdatingEnabled(false);
            PlaybackTransportControlGlue.this.onUpdateProgress();
        }

        public void onSeekPositionChanged(long j5) {
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            if (playbackTransportControlGlue.mSeekProvider == null) {
                playbackTransportControlGlue.mPlayerAdapter.seekTo(j5);
            } else {
                this.mLastUserPosition = j5;
            }
            PlaybackControlsRow playbackControlsRow = PlaybackTransportControlGlue.this.mControlsRow;
            if (playbackControlsRow != null) {
                playbackControlsRow.setCurrentPosition(j5);
            }
        }

        public void onSeekStarted() {
            long j5;
            this.mIsSeek = true;
            this.mPausedBeforeSeek = !PlaybackTransportControlGlue.this.isPlaying();
            PlaybackTransportControlGlue.this.mPlayerAdapter.setProgressUpdatingEnabled(true);
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            if (playbackTransportControlGlue.mSeekProvider == null) {
                j5 = playbackTransportControlGlue.mPlayerAdapter.getCurrentPosition();
            } else {
                j5 = -1;
            }
            this.mPositionBeforeSeek = j5;
            this.mLastUserPosition = -1;
            PlaybackTransportControlGlue.this.pause();
        }
    }

    static class UpdatePlaybackStateHandler extends Handler {
        UpdatePlaybackStateHandler() {
        }

        public void handleMessage(Message message) {
            PlaybackTransportControlGlue playbackTransportControlGlue;
            if (message.what == 100 && (playbackTransportControlGlue = (PlaybackTransportControlGlue) ((WeakReference) message.obj).get()) != null) {
                playbackTransportControlGlue.onUpdatePlaybackState();
            }
        }
    }

    public PlaybackTransportControlGlue(Context context, T t5) {
        super(context, t5);
    }

    private void updatePlaybackState(boolean z4) {
        if (this.mControlsRow != null) {
            if (!z4) {
                onUpdateProgress();
                this.mPlayerAdapter.setProgressUpdatingEnabled(this.mPlaybackSeekUiClient.mIsSeek);
            } else {
                this.mPlayerAdapter.setProgressUpdatingEnabled(true);
            }
            if (this.mFadeWhenPlaying && getHost() != null) {
                getHost().setControlsOverlayAutoHideEnabled(z4);
            }
            PlaybackControlsRow.PlayPauseAction playPauseAction = this.mPlayPauseAction;
            if (playPauseAction != null && playPauseAction.getIndex() != z4) {
                this.mPlayPauseAction.setIndex(z4 ? 1 : 0);
                PlaybackBaseControlGlue.notifyItemChanged((ArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter(), this.mPlayPauseAction);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchAction(Action action, KeyEvent keyEvent) {
        boolean z4;
        if (action instanceof PlaybackControlsRow.PlayPauseAction) {
            if (keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 126) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 127) && this.mIsPlaying) {
                this.mIsPlaying = false;
                pause();
            } else if (z4 && !this.mIsPlaying) {
                this.mIsPlaying = true;
                play();
            }
            onUpdatePlaybackStatusAfterUserAction();
            return true;
        } else if (action instanceof PlaybackControlsRow.SkipNextAction) {
            next();
            return true;
        } else if (!(action instanceof PlaybackControlsRow.SkipPreviousAction)) {
            return false;
        } else {
            previous();
            return true;
        }
    }

    public final PlaybackSeekDataProvider getSeekProvider() {
        return this.mSeekProvider;
    }

    public final boolean isSeekEnabled() {
        return this.mSeekEnabled;
    }

    public void onActionClicked(Action action) {
        dispatchAction(action, (KeyEvent) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        if (playbackGlueHost instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) playbackGlueHost).setPlaybackSeekUiClient(this.mPlaybackSeekUiClient);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreatePrimaryActions(ArrayObjectAdapter arrayObjectAdapter) {
        PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
        this.mPlayPauseAction = playPauseAction;
        arrayObjectAdapter.add(playPauseAction);
    }

    /* access modifiers changed from: protected */
    public PlaybackRowPresenter onCreateRowPresenter() {
        AnonymousClass1 r02 = new AbstractDetailsDescriptionPresenter() {
            /* access modifiers changed from: protected */
            public void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
                PlaybackBaseControlGlue playbackBaseControlGlue = (PlaybackBaseControlGlue) obj;
                viewHolder.getTitle().setText(playbackBaseControlGlue.getTitle());
                viewHolder.getSubtitle().setText(playbackBaseControlGlue.getSubtitle());
            }
        };
        AnonymousClass2 r12 = new PlaybackTransportRowPresenter() {
            /* access modifiers changed from: protected */
            public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
                super.onBindRowViewHolder(viewHolder, obj);
                viewHolder.setOnKeyListener(PlaybackTransportControlGlue.this);
            }

            /* access modifiers changed from: protected */
            public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
                super.onUnbindRowViewHolder(viewHolder);
                viewHolder.setOnKeyListener((View.OnKeyListener) null);
            }
        };
        r12.setDescriptionPresenter(r02);
        return r12;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromHost() {
        super.onDetachedFromHost();
        if (getHost() instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) getHost()).setPlaybackSeekUiClient((PlaybackSeekUi.Client) null);
        }
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
                    Action actionForKeyCode = this.mControlsRow.getActionForKeyCode(this.mControlsRow.getPrimaryActionsAdapter(), i5);
                    if (actionForKeyCode == null) {
                        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
                        actionForKeyCode = playbackControlsRow.getActionForKeyCode(playbackControlsRow.getSecondaryActionsAdapter(), i5);
                    }
                    if (actionForKeyCode != null) {
                        if (keyEvent.getAction() != 0) {
                            return true;
                        }
                        dispatchAction(actionForKeyCode, keyEvent);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPlayStateChanged() {
        Handler handler = sHandler;
        if (handler.hasMessages(100, this.mGlueWeakReference)) {
            handler.removeMessages(100, this.mGlueWeakReference);
            if (this.mPlayerAdapter.isPlaying() != this.mIsPlaying) {
                handler.sendMessageDelayed(handler.obtainMessage(100, this.mGlueWeakReference), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            } else {
                onUpdatePlaybackState();
            }
        } else {
            onUpdatePlaybackState();
        }
        super.onPlayStateChanged();
    }

    /* access modifiers changed from: package-private */
    public void onUpdatePlaybackState() {
        boolean isPlaying = this.mPlayerAdapter.isPlaying();
        this.mIsPlaying = isPlaying;
        updatePlaybackState(isPlaying);
    }

    /* access modifiers changed from: package-private */
    public void onUpdatePlaybackStatusAfterUserAction() {
        updatePlaybackState(this.mIsPlaying);
        Handler handler = sHandler;
        handler.removeMessages(100, this.mGlueWeakReference);
        handler.sendMessageDelayed(handler.obtainMessage(100, this.mGlueWeakReference), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* access modifiers changed from: protected */
    public void onUpdateProgress() {
        if (!this.mPlaybackSeekUiClient.mIsSeek) {
            super.onUpdateProgress();
        }
    }

    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        super.setControlsRow(playbackControlsRow);
        sHandler.removeMessages(100, this.mGlueWeakReference);
        onUpdatePlaybackState();
    }

    public final void setSeekEnabled(boolean z4) {
        this.mSeekEnabled = z4;
    }

    public final void setSeekProvider(PlaybackSeekDataProvider playbackSeekDataProvider) {
        this.mSeekProvider = playbackSeekDataProvider;
    }
}
