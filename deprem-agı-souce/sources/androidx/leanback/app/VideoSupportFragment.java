package androidx.leanback.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;

public class VideoSupportFragment extends PlaybackSupportFragment {
    static final int SURFACE_CREATED = 1;
    static final int SURFACE_NOT_CREATED = 0;
    SurfaceHolder.Callback mMediaPlaybackCallback;
    int mState = 0;
    SurfaceView mVideoSurface;

    public SurfaceView getSurfaceView() {
        return this.mVideoSurface;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) super.onCreateView(layoutInflater, viewGroup, bundle);
        SurfaceView surfaceView = (SurfaceView) LayoutInflater.from(getContext()).inflate(R.layout.lb_video_surface, viewGroup2, false);
        this.mVideoSurface = surfaceView;
        viewGroup2.addView(surfaceView, 0);
        this.mVideoSurface.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
                SurfaceHolder.Callback callback = VideoSupportFragment.this.mMediaPlaybackCallback;
                if (callback != null) {
                    callback.surfaceChanged(surfaceHolder, i5, i6, i7);
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder.Callback callback = VideoSupportFragment.this.mMediaPlaybackCallback;
                if (callback != null) {
                    callback.surfaceCreated(surfaceHolder);
                }
                VideoSupportFragment.this.mState = 1;
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceHolder.Callback callback = VideoSupportFragment.this.mMediaPlaybackCallback;
                if (callback != null) {
                    callback.surfaceDestroyed(surfaceHolder);
                }
                VideoSupportFragment.this.mState = 0;
            }
        });
        setBackgroundType(2);
        return viewGroup2;
    }

    public void onDestroyView() {
        this.mVideoSurface = null;
        this.mState = 0;
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public void onVideoSizeChanged(int i5, int i6) {
        int width = getView().getWidth();
        int height = getView().getHeight();
        ViewGroup.LayoutParams layoutParams = this.mVideoSurface.getLayoutParams();
        int i7 = width * i6;
        int i8 = i5 * height;
        if (i7 > i8) {
            layoutParams.height = height;
            layoutParams.width = i8 / i6;
        } else {
            layoutParams.width = width;
            layoutParams.height = i7 / i5;
        }
        this.mVideoSurface.setLayoutParams(layoutParams);
    }

    public void setSurfaceHolderCallback(SurfaceHolder.Callback callback) {
        this.mMediaPlaybackCallback = callback;
        if (callback != null && this.mState == 1) {
            callback.surfaceCreated(this.mVideoSurface.getHolder());
        }
    }
}
