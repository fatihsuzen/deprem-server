package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.ArrayList;

public abstract class BaseMediaSource implements MediaSource {
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private Object manifest;
    private ExoPlayer player;
    private final ArrayList<MediaSource.SourceInfoRefreshListener> sourceInfoListeners = new ArrayList<>(1);
    private Timeline timeline;

    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId, 0);
    }

    public final void prepareSource(ExoPlayer exoPlayer, boolean z4, MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        boolean z5;
        ExoPlayer exoPlayer2 = this.player;
        if (exoPlayer2 == null || exoPlayer2 == exoPlayer) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkArgument(z5);
        this.sourceInfoListeners.add(sourceInfoRefreshListener);
        if (this.player == null) {
            this.player = exoPlayer;
            prepareSourceInternal(exoPlayer, z4);
            return;
        }
        Timeline timeline2 = this.timeline;
        if (timeline2 != null) {
            sourceInfoRefreshListener.onSourceInfoRefreshed(this, timeline2, this.manifest);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void prepareSourceInternal(ExoPlayer exoPlayer, boolean z4);

    /* access modifiers changed from: protected */
    public final void refreshSourceInfo(Timeline timeline2, @Nullable Object obj) {
        this.timeline = timeline2;
        this.manifest = obj;
        ArrayList<MediaSource.SourceInfoRefreshListener> arrayList = this.sourceInfoListeners;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener = arrayList.get(i5);
            i5++;
            sourceInfoRefreshListener.onSourceInfoRefreshed(this, timeline2, obj);
        }
    }

    public final void releaseSource(MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        this.sourceInfoListeners.remove(sourceInfoRefreshListener);
        if (this.sourceInfoListeners.isEmpty()) {
            this.player = null;
            this.timeline = null;
            this.manifest = null;
            releaseSourceInternal();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void releaseSourceInternal();

    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j5) {
        Assertions.checkArgument(mediaPeriodId != null);
        return this.eventDispatcher.withParameters(0, mediaPeriodId, j5);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j5) {
        return this.eventDispatcher.withParameters(i5, mediaPeriodId, j5);
    }
}
