package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ControlButtonPresenterSelector;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PresenterSelector;
import java.util.List;

public abstract class PlaybackBaseControlGlue<T extends PlayerAdapter> extends PlaybackGlue implements OnActionClickedListener, View.OnKeyListener {
    public static final int ACTION_CUSTOM_LEFT_FIRST = 1;
    public static final int ACTION_CUSTOM_RIGHT_FIRST = 4096;
    public static final int ACTION_FAST_FORWARD = 128;
    public static final int ACTION_PLAY_PAUSE = 64;
    public static final int ACTION_REPEAT = 512;
    public static final int ACTION_REWIND = 32;
    public static final int ACTION_SHUFFLE = 1024;
    public static final int ACTION_SKIP_TO_NEXT = 256;
    public static final int ACTION_SKIP_TO_PREVIOUS = 16;
    static final boolean DEBUG = false;
    static final String TAG = "PlaybackTransportGlue";
    final PlayerAdapter.Callback mAdapterCallback;
    boolean mBuffering = false;
    PlaybackControlsRow mControlsRow;
    PlaybackRowPresenter mControlsRowPresenter;
    Drawable mCover;
    int mErrorCode;
    String mErrorMessage;
    boolean mErrorSet = false;
    boolean mFadeWhenPlaying = true;
    boolean mIsPlaying = false;
    PlaybackControlsRow.PlayPauseAction mPlayPauseAction;
    final T mPlayerAdapter;
    PlaybackGlueHost.PlayerCallback mPlayerCallback;
    CharSequence mSubtitle;
    CharSequence mTitle;
    int mVideoHeight = 0;
    int mVideoWidth = 0;

    public PlaybackBaseControlGlue(Context context, T t5) {
        super(context);
        AnonymousClass1 r22 = new PlayerAdapter.Callback() {
            public void onBufferedPositionChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onUpdateBufferedProgress();
            }

            public void onBufferingStateChanged(PlayerAdapter playerAdapter, boolean z4) {
                PlaybackBaseControlGlue playbackBaseControlGlue = PlaybackBaseControlGlue.this;
                playbackBaseControlGlue.mBuffering = z4;
                PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.mPlayerCallback;
                if (playerCallback != null) {
                    playerCallback.onBufferingStateChanged(z4);
                }
            }

            public void onCurrentPositionChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onUpdateProgress();
            }

            public void onDurationChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onUpdateDuration();
            }

            public void onError(PlayerAdapter playerAdapter, int i5, String str) {
                PlaybackBaseControlGlue playbackBaseControlGlue = PlaybackBaseControlGlue.this;
                playbackBaseControlGlue.mErrorSet = true;
                playbackBaseControlGlue.mErrorCode = i5;
                playbackBaseControlGlue.mErrorMessage = str;
                PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.mPlayerCallback;
                if (playerCallback != null) {
                    playerCallback.onError(i5, str);
                }
            }

            public void onMetadataChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onMetadataChanged();
            }

            public void onPlayCompleted(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onPlayCompleted();
            }

            public void onPlayStateChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onPlayStateChanged();
            }

            public void onPreparedStateChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onPreparedStateChanged();
            }

            public void onVideoSizeChanged(PlayerAdapter playerAdapter, int i5, int i6) {
                PlaybackBaseControlGlue playbackBaseControlGlue = PlaybackBaseControlGlue.this;
                playbackBaseControlGlue.mVideoWidth = i5;
                playbackBaseControlGlue.mVideoHeight = i6;
                PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.mPlayerCallback;
                if (playerCallback != null) {
                    playerCallback.onVideoSizeChanged(i5, i6);
                }
            }
        };
        this.mAdapterCallback = r22;
        this.mPlayerAdapter = t5;
        t5.setCallback(r22);
    }

    protected static void notifyItemChanged(ArrayObjectAdapter arrayObjectAdapter, Object obj) {
        int indexOf = arrayObjectAdapter.indexOf(obj);
        if (indexOf >= 0) {
            arrayObjectAdapter.notifyArrayItemRangeChanged(indexOf, 1);
        }
    }

    private void updateControlsRow() {
        onMetadataChanged();
    }

    public Drawable getArt() {
        return this.mCover;
    }

    public final long getBufferedPosition() {
        return this.mPlayerAdapter.getBufferedPosition();
    }

    public PlaybackControlsRow getControlsRow() {
        return this.mControlsRow;
    }

    public long getCurrentPosition() {
        return this.mPlayerAdapter.getCurrentPosition();
    }

    public final long getDuration() {
        return this.mPlayerAdapter.getDuration();
    }

    public PlaybackRowPresenter getPlaybackRowPresenter() {
        return this.mControlsRowPresenter;
    }

    public final T getPlayerAdapter() {
        return this.mPlayerAdapter;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public long getSupportedActions() {
        return this.mPlayerAdapter.getSupportedActions();
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.mFadeWhenPlaying;
    }

    public final boolean isPlaying() {
        return this.mPlayerAdapter.isPlaying();
    }

    public final boolean isPrepared() {
        return this.mPlayerAdapter.isPrepared();
    }

    public void next() {
        this.mPlayerAdapter.next();
    }

    public abstract void onActionClicked(Action action);

    /* access modifiers changed from: package-private */
    public void onAttachHostCallback() {
        int i5;
        PlaybackGlueHost.PlayerCallback playerCallback = this.mPlayerCallback;
        if (playerCallback != null) {
            int i6 = this.mVideoWidth;
            if (!(i6 == 0 || (i5 = this.mVideoHeight) == 0)) {
                playerCallback.onVideoSizeChanged(i6, i5);
            }
            if (this.mErrorSet) {
                this.mPlayerCallback.onError(this.mErrorCode, this.mErrorMessage);
            }
            this.mPlayerCallback.onBufferingStateChanged(this.mBuffering);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        playbackGlueHost.setOnKeyInterceptListener(this);
        playbackGlueHost.setOnActionClickedListener(this);
        onCreateDefaultControlsRow();
        onCreateDefaultRowPresenter();
        playbackGlueHost.setPlaybackRowPresenter(getPlaybackRowPresenter());
        playbackGlueHost.setPlaybackRow(getControlsRow());
        this.mPlayerCallback = playbackGlueHost.getPlayerCallback();
        onAttachHostCallback();
        this.mPlayerAdapter.onAttachedToHost(playbackGlueHost);
    }

    /* access modifiers changed from: package-private */
    public void onCreateDefaultControlsRow() {
        if (this.mControlsRow == null) {
            setControlsRow(new PlaybackControlsRow(this));
        }
    }

    /* access modifiers changed from: package-private */
    public void onCreateDefaultRowPresenter() {
        if (this.mControlsRowPresenter == null) {
            setPlaybackRowPresenter(onCreateRowPresenter());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreatePrimaryActions(ArrayObjectAdapter arrayObjectAdapter) {
    }

    /* access modifiers changed from: protected */
    public abstract PlaybackRowPresenter onCreateRowPresenter();

    /* access modifiers changed from: protected */
    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
    }

    /* access modifiers changed from: package-private */
    public void onDetachHostCallback() {
        this.mErrorSet = false;
        this.mErrorCode = 0;
        this.mErrorMessage = null;
        PlaybackGlueHost.PlayerCallback playerCallback = this.mPlayerCallback;
        if (playerCallback != null) {
            playerCallback.onBufferingStateChanged(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromHost() {
        onDetachHostCallback();
        this.mPlayerCallback = null;
        this.mPlayerAdapter.onDetachedFromHost();
        this.mPlayerAdapter.setProgressUpdatingEnabled(false);
        super.onDetachedFromHost();
    }

    /* access modifiers changed from: protected */
    public void onHostStart() {
        this.mPlayerAdapter.setProgressUpdatingEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onHostStop() {
        this.mPlayerAdapter.setProgressUpdatingEnabled(false);
    }

    public abstract boolean onKey(View view, int i5, KeyEvent keyEvent);

    /* access modifiers changed from: protected */
    public void onMetadataChanged() {
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            playbackControlsRow.setImageDrawable(getArt());
            this.mControlsRow.setDuration(getDuration());
            this.mControlsRow.setCurrentPosition(getCurrentPosition());
            if (getHost() != null) {
                getHost().notifyPlaybackRowChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onPlayCompleted() {
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i5 = 0; i5 < size; i5++) {
                playerCallbacks.get(i5).onPlayCompleted(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onPlayStateChanged() {
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i5 = 0; i5 < size; i5++) {
                playerCallbacks.get(i5).onPlayStateChanged(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onPreparedStateChanged() {
        onUpdateDuration();
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i5 = 0; i5 < size; i5++) {
                playerCallbacks.get(i5).onPreparedStateChanged(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onUpdateBufferedProgress() {
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            playbackControlsRow.setBufferedPosition(this.mPlayerAdapter.getBufferedPosition());
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onUpdateDuration() {
        long j5;
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            if (this.mPlayerAdapter.isPrepared()) {
                j5 = this.mPlayerAdapter.getDuration();
            } else {
                j5 = -1;
            }
            playbackControlsRow.setDuration(j5);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onUpdateProgress() {
        long j5;
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            if (this.mPlayerAdapter.isPrepared()) {
                j5 = getCurrentPosition();
            } else {
                j5 = -1;
            }
            playbackControlsRow.setCurrentPosition(j5);
        }
    }

    public void pause() {
        this.mPlayerAdapter.pause();
    }

    public void play() {
        this.mPlayerAdapter.play();
    }

    public void previous() {
        this.mPlayerAdapter.previous();
    }

    public final void seekTo(long j5) {
        this.mPlayerAdapter.seekTo(j5);
    }

    public void setArt(Drawable drawable) {
        if (this.mCover != drawable) {
            this.mCover = drawable;
            this.mControlsRow.setImageDrawable(drawable);
            if (getHost() != null) {
                getHost().notifyPlaybackRowChanged();
            }
        }
    }

    public void setControlsOverlayAutoHideEnabled(boolean z4) {
        this.mFadeWhenPlaying = z4;
        if (!z4 && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(false);
        }
    }

    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        this.mControlsRow = playbackControlsRow;
        playbackControlsRow.setCurrentPosition(-1);
        this.mControlsRow.setDuration(-1);
        this.mControlsRow.setBufferedPosition(-1);
        if (this.mControlsRow.getPrimaryActionsAdapter() == null) {
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((PresenterSelector) new ControlButtonPresenterSelector());
            onCreatePrimaryActions(arrayObjectAdapter);
            this.mControlsRow.setPrimaryActionsAdapter(arrayObjectAdapter);
        }
        if (this.mControlsRow.getSecondaryActionsAdapter() == null) {
            ArrayObjectAdapter arrayObjectAdapter2 = new ArrayObjectAdapter((PresenterSelector) new ControlButtonPresenterSelector());
            onCreateSecondaryActions(arrayObjectAdapter2);
            getControlsRow().setSecondaryActionsAdapter(arrayObjectAdapter2);
        }
        updateControlsRow();
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.mControlsRowPresenter = playbackRowPresenter;
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mSubtitle)) {
            this.mSubtitle = charSequence;
            if (getHost() != null) {
                getHost().notifyPlaybackRowChanged();
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mTitle)) {
            this.mTitle = charSequence;
            if (getHost() != null) {
                getHost().notifyPlaybackRowChanged();
            }
        }
    }
}
