package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {

    public static final class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        private static final class ListenerAndHandler {
            public final Handler handler;
            public final MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler2;
                this.listener = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null, 0);
        }

        private long adjustMediaTime(long j5) {
            long usToMs = C.usToMs(j5);
            if (usToMs == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            return this.mediaTimeOffsetMs + usToMs;
        }

        private void postOrRun(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            boolean z4;
            if (handler == null || mediaSourceEventListener == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            Assertions.checkArgument(z4);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public final void downstreamFormatChanged(int i5, @Nullable Format format, int i6, @Nullable Object obj, long j5) {
            downstreamFormatChanged(new MediaLoadData(1, i5, format, i6, obj, adjustMediaTime(j5), C.TIME_UNSET));
        }

        public final void loadCanceled(DataSpec dataSpec, int i5, long j5, long j6, long j7) {
            loadCanceled(dataSpec, i5, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j5, j6, j7);
        }

        public final void loadCompleted(DataSpec dataSpec, int i5, long j5, long j6, long j7) {
            loadCompleted(dataSpec, i5, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j5, j6, j7);
        }

        public final void loadError(DataSpec dataSpec, int i5, long j5, long j6, long j7, IOException iOException, boolean z4) {
            loadError(dataSpec, i5, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j5, j6, j7, iOException, z4);
        }

        public final void loadStarted(DataSpec dataSpec, int i5, long j5) {
            loadStarted(dataSpec, i5, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j5);
        }

        public final void mediaPeriodCreated() {
            boolean z4;
            if (this.mediaPeriodId != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onMediaPeriodCreated(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                    }
                });
            }
        }

        public final void mediaPeriodReleased() {
            boolean z4;
            if (this.mediaPeriodId != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onMediaPeriodReleased(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                    }
                });
            }
        }

        public final void readingStarted() {
            boolean z4;
            if (this.mediaPeriodId != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onReadingStarted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                    }
                });
            }
        }

        public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public final void upstreamDiscarded(int i5, long j5, long j6) {
            upstreamDiscarded(new MediaLoadData(1, i5, (Format) null, 3, (Object) null, adjustMediaTime(j5), adjustMediaTime(j6)));
        }

        @CheckResult
        public final EventDispatcher withParameters(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, long j5) {
            return new EventDispatcher(this.listenerAndHandlers, i5, mediaPeriodId2, j5);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, long j5) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i5;
            this.mediaPeriodId = mediaPeriodId2;
            this.mediaTimeOffsetMs = j5;
        }

        public final void loadCanceled(DataSpec dataSpec, int i5, int i6, @Nullable Format format, int i7, @Nullable Object obj, long j5, long j6, long j7, long j8, long j9) {
            loadCanceled(new LoadEventInfo(dataSpec, j7, j8, j9), new MediaLoadData(i5, i6, format, i7, obj, adjustMediaTime(j5), adjustMediaTime(j6)));
        }

        public final void loadCompleted(DataSpec dataSpec, int i5, int i6, @Nullable Format format, int i7, @Nullable Object obj, long j5, long j6, long j7, long j8, long j9) {
            loadCompleted(new LoadEventInfo(dataSpec, j7, j8, j9), new MediaLoadData(i5, i6, format, i7, obj, adjustMediaTime(j5), adjustMediaTime(j6)));
        }

        public final void loadError(DataSpec dataSpec, int i5, int i6, @Nullable Format format, int i7, @Nullable Object obj, long j5, long j6, long j7, long j8, long j9, IOException iOException, boolean z4) {
            loadError(new LoadEventInfo(dataSpec, j7, j8, j9), new MediaLoadData(i5, i6, format, i7, obj, adjustMediaTime(j5), adjustMediaTime(j6)), iOException, z4);
        }

        public final void loadStarted(DataSpec dataSpec, int i5, int i6, @Nullable Format format, int i7, @Nullable Object obj, long j5, long j6, long j7) {
            loadStarted(new LoadEventInfo(dataSpec, j7, 0, 0), new MediaLoadData(i5, i6, format, i7, obj, adjustMediaTime(j5), adjustMediaTime(j6)));
        }

        public final void downstreamFormatChanged(final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onDownstreamFormatChanged(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        public final void upstreamDiscarded(final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onUpstreamDiscarded(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        public final void loadCanceled(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadCanceled(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public final void loadCompleted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadCompleted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public final void loadError(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                final LoadEventInfo loadEventInfo2 = loadEventInfo;
                final MediaLoadData mediaLoadData2 = mediaLoadData;
                final IOException iOException2 = iOException;
                final boolean z5 = z4;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo2, mediaLoadData2, iOException2, z5);
                    }
                });
            }
        }

        public final void loadStarted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadStarted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }
    }

    public static final class LoadEventInfo {
        public final long bytesLoaded;
        public final DataSpec dataSpec;
        public final long elapsedRealtimeMs;
        public final long loadDurationMs;

        public LoadEventInfo(DataSpec dataSpec2, long j5, long j6, long j7) {
            this.dataSpec = dataSpec2;
            this.elapsedRealtimeMs = j5;
            this.loadDurationMs = j6;
            this.bytesLoaded = j7;
        }
    }

    public static final class MediaLoadData {
        public final int dataType;
        public final long mediaEndTimeMs;
        public final long mediaStartTimeMs;
        @Nullable
        public final Format trackFormat;
        @Nullable
        public final Object trackSelectionData;
        public final int trackSelectionReason;
        public final int trackType;

        public MediaLoadData(int i5, int i6, @Nullable Format format, int i7, @Nullable Object obj, long j5, long j6) {
            this.dataType = i5;
            this.trackType = i6;
            this.trackFormat = format;
            this.trackSelectionReason = i7;
            this.trackSelectionData = obj;
            this.mediaStartTimeMs = j5;
            this.mediaEndTimeMs = j6;
        }
    }

    void onDownstreamFormatChanged(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void onLoadCanceled(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z4);

    void onLoadStarted(int i5, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onMediaPeriodCreated(int i5, MediaSource.MediaPeriodId mediaPeriodId);

    void onMediaPeriodReleased(int i5, MediaSource.MediaPeriodId mediaPeriodId);

    void onReadingStarted(int i5, MediaSource.MediaPeriodId mediaPeriodId);

    void onUpstreamDiscarded(int i5, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);
}
