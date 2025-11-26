package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import java.io.IOException;
import java.util.List;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MediaPlayerGlue extends PlaybackControlGlue implements OnItemViewSelectedListener {
    public static final int FAST_FORWARD_REWIND_REPEAT_DELAY = 200;
    public static final int FAST_FORWARD_REWIND_STEP = 10000;
    public static final int NO_REPEAT = 0;
    public static final int REPEAT_ALL = 2;
    public static final int REPEAT_ONE = 1;
    private static final String TAG = "MediaPlayerGlue";
    private String mArtist;
    private Drawable mCover;
    Handler mHandler;
    boolean mInitialized;
    private long mLastKeyDownEvent;
    private String mMediaSourcePath;
    private Uri mMediaSourceUri;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    MediaPlayer mPlayer;
    private final PlaybackControlsRow.RepeatAction mRepeatAction;
    private Runnable mRunnable;
    private Action mSelectedAction;
    protected final PlaybackControlsRow.ThumbsDownAction mThumbsDownAction;
    protected final PlaybackControlsRow.ThumbsUpAction mThumbsUpAction;
    private String mTitle;

    class VideoPlayerSurfaceHolderCallback implements SurfaceHolder.Callback {
        VideoPlayerSurfaceHolderCallback() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaPlayerGlue.this.setDisplay(surfaceHolder);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaPlayerGlue.this.setDisplay((SurfaceHolder) null);
        }
    }

    public MediaPlayerGlue(Context context) {
        this(context, new int[]{1}, new int[]{1});
    }

    private void prepareMediaForPlaying() {
        reset();
        try {
            if (this.mMediaSourceUri != null) {
                this.mPlayer.setDataSource(getContext(), this.mMediaSourceUri);
            } else {
                String str = this.mMediaSourcePath;
                if (str != null) {
                    this.mPlayer.setDataSource(str);
                } else {
                    return;
                }
            }
            this.mPlayer.setAudioStreamType(3);
            this.mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayerGlue mediaPlayerGlue = MediaPlayerGlue.this;
                    mediaPlayerGlue.mInitialized = true;
                    List<PlaybackGlue.PlayerCallback> playerCallbacks = mediaPlayerGlue.getPlayerCallbacks();
                    if (playerCallbacks != null) {
                        for (PlaybackGlue.PlayerCallback onPreparedStateChanged : playerCallbacks) {
                            onPreparedStateChanged.onPreparedStateChanged(MediaPlayerGlue.this);
                        }
                    }
                }
            });
            MediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                this.mPlayer.setOnCompletionListener(onCompletionListener);
            }
            this.mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i5) {
                    if (MediaPlayerGlue.this.getControlsRow() != null) {
                        MediaPlayerGlue.this.getControlsRow().setBufferedProgress((int) (((float) mediaPlayer.getDuration()) * (((float) i5) / 100.0f)));
                    }
                }
            });
            this.mPlayer.prepareAsync();
            onStateChanged();
        } catch (IOException e5) {
            e5.printStackTrace();
            throw new RuntimeException(e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void changeToUnitialized() {
        if (this.mInitialized) {
            this.mInitialized = false;
            List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
            if (playerCallbacks != null) {
                for (PlaybackGlue.PlayerCallback onPreparedStateChanged : playerCallbacks) {
                    onPreparedStateChanged.onPreparedStateChanged(this);
                }
            }
        }
    }

    public void enableProgressUpdating(boolean z4) {
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        if (z4) {
            if (this.mRunnable == null) {
                this.mRunnable = new Runnable() {
                    public void run() {
                        MediaPlayerGlue.this.updateProgress();
                        MediaPlayerGlue mediaPlayerGlue = MediaPlayerGlue.this;
                        mediaPlayerGlue.mHandler.postDelayed(this, (long) mediaPlayerGlue.getUpdatePeriod());
                    }
                };
            }
            this.mHandler.postDelayed(this.mRunnable, (long) getUpdatePeriod());
        }
    }

    public int getCurrentPosition() {
        if (this.mInitialized) {
            return this.mPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getCurrentSpeedId() {
        return isMediaPlaying() ? 1 : 0;
    }

    public Drawable getMediaArt() {
        return this.mCover;
    }

    public int getMediaDuration() {
        if (this.mInitialized) {
            return this.mPlayer.getDuration();
        }
        return 0;
    }

    public CharSequence getMediaSubtitle() {
        String str = this.mArtist;
        if (str != null) {
            return str;
        }
        return "N/a";
    }

    public CharSequence getMediaTitle() {
        String str = this.mTitle;
        if (str != null) {
            return str;
        }
        return "N/a";
    }

    public long getSupportedActions() {
        return 224;
    }

    public boolean hasValidMedia() {
        if (this.mTitle == null) {
            return false;
        }
        if (this.mMediaSourcePath == null && this.mMediaSourceUri == null) {
            return false;
        }
        return true;
    }

    public boolean isMediaPlaying() {
        if (!this.mInitialized || !this.mPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    public boolean isPlaying() {
        return isMediaPlaying();
    }

    public boolean isPrepared() {
        return this.mInitialized;
    }

    public void onActionClicked(Action action) {
        super.onActionClicked(action);
        if (action instanceof PlaybackControlsRow.RepeatAction) {
            ((PlaybackControlsRow.RepeatAction) action).nextIndex();
        } else {
            PlaybackControlsRow.ThumbsUpAction thumbsUpAction = this.mThumbsUpAction;
            if (action != thumbsUpAction) {
                PlaybackControlsRow.ThumbsDownAction thumbsDownAction = this.mThumbsDownAction;
                if (action == thumbsDownAction) {
                    if (thumbsDownAction.getIndex() == 0) {
                        this.mThumbsDownAction.setIndex(1);
                    } else {
                        this.mThumbsDownAction.setIndex(0);
                        this.mThumbsUpAction.setIndex(1);
                    }
                }
            } else if (thumbsUpAction.getIndex() == 0) {
                this.mThumbsUpAction.setIndex(1);
            } else {
                this.mThumbsUpAction.setIndex(0);
                this.mThumbsDownAction.setIndex(1);
            }
        }
        onMetadataChanged();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            ((SurfaceHolderGlueHost) playbackGlueHost).setSurfaceHolderCallback(new VideoPlayerSurfaceHolderCallback());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
        arrayObjectAdapter.add(this.mRepeatAction);
        arrayObjectAdapter.add(this.mThumbsDownAction);
        arrayObjectAdapter.add(this.mThumbsUpAction);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromHost() {
        if (getHost() instanceof SurfaceHolderGlueHost) {
            ((SurfaceHolderGlueHost) getHost()).setSurfaceHolderCallback((SurfaceHolder.Callback) null);
        }
        reset();
        release();
        super.onDetachedFromHost();
    }

    public boolean onKey(View view, int i5, KeyEvent keyEvent) {
        Action action = this.mSelectedAction;
        if ((!(action instanceof PlaybackControlsRow.RewindAction) && !(action instanceof PlaybackControlsRow.FastForwardAction)) || !this.mInitialized || keyEvent.getKeyCode() != 23 || keyEvent.getAction() != 0 || System.currentTimeMillis() - this.mLastKeyDownEvent <= 200) {
            return super.onKey(view, i5, keyEvent);
        }
        this.mLastKeyDownEvent = System.currentTimeMillis();
        int currentPosition = getCurrentPosition() + 10000;
        if (this.mSelectedAction instanceof PlaybackControlsRow.RewindAction) {
            currentPosition = getCurrentPosition() - 10000;
        }
        if (currentPosition < 0) {
            currentPosition = 0;
        }
        if (currentPosition > getMediaDuration()) {
            currentPosition = getMediaDuration();
        }
        seekTo(currentPosition);
        return true;
    }

    public void pause() {
        if (isMediaPlaying()) {
            this.mPlayer.pause();
            onStateChanged();
        }
    }

    public void play(int i5) {
        if (this.mInitialized && !this.mPlayer.isPlaying()) {
            this.mPlayer.start();
            onMetadataChanged();
            onStateChanged();
            updateProgress();
        }
    }

    public void release() {
        changeToUnitialized();
        this.mPlayer.release();
    }

    public void reset() {
        changeToUnitialized();
        this.mPlayer.reset();
    }

    /* access modifiers changed from: protected */
    public void seekTo(int i5) {
        if (this.mInitialized) {
            this.mPlayer.seekTo(i5);
        }
    }

    public void setArtist(String str) {
        this.mArtist = str;
    }

    public void setCover(Drawable drawable) {
        this.mCover = drawable;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mPlayer.setDisplay(surfaceHolder);
    }

    public boolean setMediaSource(Uri uri) {
        Uri uri2 = this.mMediaSourceUri;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.mMediaSourceUri = uri;
        this.mMediaSourcePath = null;
        prepareMediaForPlaying();
        return true;
    }

    public void setMode(int i5) {
        if (i5 == 0) {
            this.mOnCompletionListener = null;
        } else if (i5 == 1) {
            this.mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
                public boolean mFirstRepeat;

                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (!this.mFirstRepeat) {
                        this.mFirstRepeat = true;
                        mediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                    }
                    MediaPlayerGlue.this.play();
                }
            };
        } else if (i5 == 2) {
            this.mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    MediaPlayerGlue.this.play();
                }
            };
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVideoUrl(String str) {
        setMediaSource(str);
        onMetadataChanged();
    }

    public MediaPlayerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
        this.mPlayer = new MediaPlayer();
        this.mHandler = new Handler();
        this.mInitialized = false;
        this.mLastKeyDownEvent = 0;
        this.mMediaSourceUri = null;
        this.mMediaSourcePath = null;
        this.mRepeatAction = new PlaybackControlsRow.RepeatAction(getContext());
        PlaybackControlsRow.ThumbsDownAction thumbsDownAction = new PlaybackControlsRow.ThumbsDownAction(getContext());
        this.mThumbsDownAction = thumbsDownAction;
        PlaybackControlsRow.ThumbsUpAction thumbsUpAction = new PlaybackControlsRow.ThumbsUpAction(getContext());
        this.mThumbsUpAction = thumbsUpAction;
        thumbsDownAction.setIndex(1);
        thumbsUpAction.setIndex(1);
    }

    public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof Action) {
            this.mSelectedAction = (Action) obj;
        } else {
            this.mSelectedAction = null;
        }
    }

    public boolean setMediaSource(String str) {
        String str2 = this.mMediaSourcePath;
        if (str2 != null) {
            if (str2.equals(str)) {
                return false;
            }
        } else if (str == null) {
            return false;
        }
        this.mMediaSourceUri = null;
        this.mMediaSourcePath = str;
        prepareMediaForPlaying();
        return true;
    }
}
