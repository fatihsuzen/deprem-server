package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class SingleSampleMediaSource extends BaseMediaSource {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final int minLoadableRetryCount;
    private final Timeline timeline;
    private final boolean treatLoadErrorsAsEndOfStream;

    @Deprecated
    public interface EventListener {
        void onLoadError(int i5, IOException iOException);
    }

    private static final class EventListenerWrapper extends DefaultMediaSourceEventListener {
        private final EventListener eventListener;
        private final int eventSourceId;

        public EventListenerWrapper(EventListener eventListener2, int i5) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener2);
            this.eventSourceId = i5;
        }

        public final void onLoadError(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
            this.eventListener.onLoadError(this.eventSourceId, iOException);
        }
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        boolean z4;
        if (mediaPeriodId.periodIndex == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        return new SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, this.format, this.durationUs, this.minLoadableRetryCount, createEventDispatcher(mediaPeriodId), this.treatLoadErrorsAsEndOfStream);
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z4) {
        refreshSourceInfo(this.timeline, (Object) null);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }

    public final void releaseSourceInternal() {
    }

    public static final class Factory {
        private final DataSource.Factory dataSourceFactory;
        private boolean isCreateCalled;
        private int minLoadableRetryCount = 3;
        @Nullable
        private Object tag;
        private boolean treatLoadErrorsAsEndOfStream;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public final SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j5) {
            this.isCreateCalled = true;
            return new SingleSampleMediaSource(uri, this.dataSourceFactory, format, j5, this.minLoadableRetryCount, this.treatLoadErrorsAsEndOfStream, this.tag);
        }

        public final Factory setMinLoadableRetryCount(int i5) {
            Assertions.checkState(!this.isCreateCalled);
            this.minLoadableRetryCount = i5;
            return this;
        }

        public final Factory setTag(Object obj) {
            Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        public final Factory setTreatLoadErrorsAsEndOfStream(boolean z4) {
            Assertions.checkState(!this.isCreateCalled);
            this.treatLoadErrorsAsEndOfStream = z4;
            return this;
        }

        @Deprecated
        public final SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j5, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            SingleSampleMediaSource createMediaSource = createMediaSource(uri, format, j5);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j5) {
        this(uri, factory, format2, j5, 3);
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j5, int i5) {
        this(uri, factory, format2, j5, i5, false, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j5, int i5, Handler handler, EventListener eventListener, int i6, boolean z4) {
        this(uri, factory, format2, j5, i5, z4, (Object) null);
        Handler handler2 = handler;
        EventListener eventListener2 = eventListener;
        if (handler2 != null && eventListener2 != null) {
            addEventListener(handler2, new EventListenerWrapper(eventListener2, i6));
        }
    }

    private SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j5, int i5, boolean z4, @Nullable Object obj) {
        this.dataSourceFactory = factory;
        this.format = format2;
        this.durationUs = j5;
        this.minLoadableRetryCount = i5;
        this.treatLoadErrorsAsEndOfStream = z4;
        this.dataSpec = new DataSpec(uri);
        this.timeline = new SinglePeriodTimeline(j5, true, false, obj);
    }
}
