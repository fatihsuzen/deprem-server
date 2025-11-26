package androidx.leanback.media;

import android.view.View;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.Row;

public abstract class PlaybackGlueHost {
    PlaybackGlue mGlue;

    public static abstract class HostCallback {
        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public void onHostStart() {
        }

        public void onHostStop() {
        }
    }

    public static class PlayerCallback {
        public void onBufferingStateChanged(boolean z4) {
        }

        public void onError(int i5, CharSequence charSequence) {
        }

        public void onVideoSizeChanged(int i5, int i6) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void attachToGlue(PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mGlue;
        if (playbackGlue2 != null) {
            playbackGlue2.onDetachedFromHost();
        }
        this.mGlue = playbackGlue;
        if (playbackGlue != null) {
            playbackGlue.onAttachedToHost(this);
        }
    }

    @Deprecated
    public void fadeOut() {
    }

    public PlayerCallback getPlayerCallback() {
        return null;
    }

    public void hideControlsOverlay(boolean z4) {
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return false;
    }

    public boolean isControlsOverlayVisible() {
        return true;
    }

    public void notifyPlaybackRowChanged() {
    }

    public void setControlsOverlayAutoHideEnabled(boolean z4) {
        setFadingEnabled(z4);
    }

    @Deprecated
    public void setFadingEnabled(boolean z4) {
    }

    public void setHostCallback(HostCallback hostCallback) {
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
    }

    public void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
    }

    public void setPlaybackRow(Row row) {
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
    }

    public void showControlsOverlay(boolean z4) {
    }
}
