package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.SlidingPercentile;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Clock clock;
    @Nullable
    private final Handler eventHandler;
    /* access modifiers changed from: private */
    @Nullable
    public final BandwidthMeter.EventListener eventListener;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public static final class Builder {
        private Clock clock = Clock.DEFAULT;
        @Nullable
        private Handler eventHandler;
        @Nullable
        private BandwidthMeter.EventListener eventListener;
        private long initialBitrateEstimate = 1000000;
        private int slidingWindowMaxWeight = 2000;

        public final DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.eventHandler, this.eventListener, this.initialBitrateEstimate, this.slidingWindowMaxWeight, this.clock);
        }

        public final Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        public final Builder setEventListener(Handler handler, BandwidthMeter.EventListener eventListener2) {
            boolean z4;
            if (handler == null || eventListener2 == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            Assertions.checkArgument(z4);
            this.eventHandler = handler;
            this.eventListener = eventListener2;
            return this;
        }

        public final Builder setInitialBitrateEstimate(long j5) {
            this.initialBitrateEstimate = j5;
            return this;
        }

        public final Builder setSlidingWindowMaxWeight(int i5) {
            this.slidingWindowMaxWeight = i5;
            return this;
        }
    }

    private void notifyBandwidthSample(int i5, long j5, long j6) {
        Handler handler = this.eventHandler;
        if (handler != null && this.eventListener != null) {
            final int i6 = i5;
            final long j7 = j5;
            final long j8 = j6;
            handler.post(new Runnable() {
                public void run() {
                    DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i6, j7, j8);
                }
            });
        }
    }

    public final synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    public final synchronized void onBytesTransferred(Object obj, int i5) {
        this.sampleBytesTransferred += (long) i5;
    }

    public final synchronized void onTransferEnd(Object obj) {
        Throwable th;
        boolean z4;
        try {
            if (this.streamCount > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            long elapsedRealtime = this.clock.elapsedRealtime();
            int i5 = (int) (elapsedRealtime - this.sampleStartTimeMs);
            long j5 = (long) i5;
            this.totalElapsedTimeMs += j5;
            long j6 = this.totalBytesTransferred;
            long j7 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j6 + j7;
            if (i5 > 0) {
                try {
                    this.slidingPercentile.addSample((int) Math.sqrt((double) j7), (float) ((8000 * j7) / j5));
                    if (this.totalElapsedTimeMs < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                        if (this.totalBytesTransferred >= 524288) {
                        }
                    }
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            try {
                notifyBandwidthSample(i5, this.sampleBytesTransferred, this.bitrateEstimate);
                int i6 = this.streamCount - 1;
                this.streamCount = i6;
                if (i6 > 0) {
                    this.sampleStartTimeMs = elapsedRealtime;
                }
                this.sampleBytesTransferred = 0;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        try {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public DefaultBandwidthMeter() {
        this((Handler) null, (BandwidthMeter.EventListener) null, 1000000, 2000, Clock.DEFAULT);
    }

    @Deprecated
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener2) {
        this(handler, eventListener2, 1000000, 2000, Clock.DEFAULT);
    }

    @Deprecated
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener2, int i5) {
        this(handler, eventListener2, 1000000, i5, Clock.DEFAULT);
    }

    private DefaultBandwidthMeter(@Nullable Handler handler, @Nullable BandwidthMeter.EventListener eventListener2, long j5, int i5, Clock clock2) {
        this.eventHandler = handler;
        this.eventListener = eventListener2;
        this.slidingPercentile = new SlidingPercentile(i5);
        this.clock = clock2;
        this.bitrateEstimate = j5;
    }
}
