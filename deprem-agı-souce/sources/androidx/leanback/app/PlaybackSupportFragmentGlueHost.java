package androidx.leanback.app;

import android.view.View;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

public class PlaybackSupportFragmentGlueHost extends PlaybackGlueHost implements PlaybackSeekUi {
    final PlaybackSupportFragment mFragment;
    final PlaybackGlueHost.PlayerCallback mPlayerCallback = new PlaybackGlueHost.PlayerCallback() {
        public void onBufferingStateChanged(boolean z4) {
            PlaybackSupportFragmentGlueHost.this.mFragment.onBufferingStateChanged(z4);
        }

        public void onError(int i5, CharSequence charSequence) {
            PlaybackSupportFragmentGlueHost.this.mFragment.onError(i5, charSequence);
        }

        public void onVideoSizeChanged(int i5, int i6) {
            PlaybackSupportFragmentGlueHost.this.mFragment.onVideoSizeChanged(i5, i6);
        }
    };

    public PlaybackSupportFragmentGlueHost(PlaybackSupportFragment playbackSupportFragment) {
        this.mFragment = playbackSupportFragment;
    }

    public void fadeOut() {
        this.mFragment.fadeOut();
    }

    public PlaybackGlueHost.PlayerCallback getPlayerCallback() {
        return this.mPlayerCallback;
    }

    public void hideControlsOverlay(boolean z4) {
        this.mFragment.hideControlsOverlay(z4);
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.mFragment.isControlsOverlayAutoHideEnabled();
    }

    public boolean isControlsOverlayVisible() {
        return this.mFragment.isControlsOverlayVisible();
    }

    public void notifyPlaybackRowChanged() {
        this.mFragment.notifyPlaybackRowChanged();
    }

    public void setControlsOverlayAutoHideEnabled(boolean z4) {
        this.mFragment.setControlsOverlayAutoHideEnabled(z4);
    }

    public void setHostCallback(PlaybackGlueHost.HostCallback hostCallback) {
        this.mFragment.setHostCallback(hostCallback);
    }

    public void setOnActionClickedListener(final OnActionClickedListener onActionClickedListener) {
        if (onActionClickedListener == null) {
            this.mFragment.setOnPlaybackItemViewClickedListener((BaseOnItemViewClickedListener) null);
        } else {
            this.mFragment.setOnPlaybackItemViewClickedListener(new OnItemViewClickedListener() {
                public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
                    if (obj instanceof Action) {
                        onActionClickedListener.onActionClicked((Action) obj);
                    }
                }
            });
        }
    }

    public void setOnKeyInterceptListener(View.OnKeyListener onKeyListener) {
        this.mFragment.setOnKeyInterceptListener(onKeyListener);
    }

    public void setPlaybackRow(Row row) {
        this.mFragment.setPlaybackRow(row);
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.mFragment.setPlaybackRowPresenter(playbackRowPresenter);
    }

    public void setPlaybackSeekUiClient(PlaybackSeekUi.Client client) {
        this.mFragment.setPlaybackSeekUiClient(client);
    }

    public void showControlsOverlay(boolean z4) {
        this.mFragment.showControlsOverlay(z4);
    }
}
