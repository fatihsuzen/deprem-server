package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultAllocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.PriorityTaskManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    private final DefaultAllocator allocator;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final PriorityTaskManager priorityTaskManager;
    private final int targetBufferBytesOverwrite;
    private int targetBufferSize;

    public static final class Builder {
        private DefaultAllocator allocator = null;
        private int bufferForPlaybackAfterRebufferMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
        private int bufferForPlaybackMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
        private int maxBufferMs = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
        private int minBufferMs = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        private boolean prioritizeTimeOverSizeThresholds = true;
        private PriorityTaskManager priorityTaskManager = null;
        private int targetBufferBytes = -1;

        public final DefaultLoadControl createDefaultLoadControl() {
            if (this.allocator == null) {
                this.allocator = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.priorityTaskManager);
        }

        public final Builder setAllocator(DefaultAllocator defaultAllocator) {
            this.allocator = defaultAllocator;
            return this;
        }

        public final Builder setBufferDurationsMs(int i5, int i6, int i7, int i8) {
            this.minBufferMs = i5;
            this.maxBufferMs = i6;
            this.bufferForPlaybackMs = i7;
            this.bufferForPlaybackAfterRebufferMs = i8;
            return this;
        }

        public final Builder setPrioritizeTimeOverSizeThresholds(boolean z4) {
            this.prioritizeTimeOverSizeThresholds = z4;
            return this;
        }

        public final Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager2) {
            this.priorityTaskManager = priorityTaskManager2;
            return this;
        }

        public final Builder setTargetBufferBytes(int i5) {
            this.targetBufferBytes = i5;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
    }

    private static void assertGreaterOrEqual(int i5, int i6, String str, String str2) {
        boolean z4;
        if (i5 >= i6) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4, str + " cannot be less than " + str2);
    }

    private void reset(boolean z4) {
        this.targetBufferSize = 0;
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 != null && this.isBuffering) {
            priorityTaskManager2.remove(0);
        }
        this.isBuffering = false;
        if (z4) {
            this.allocator.reset();
        }
    }

    /* access modifiers changed from: protected */
    public int calculateTargetBufferSize(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int i5 = 0;
        for (int i6 = 0; i6 < rendererArr.length; i6++) {
            if (trackSelectionArray.get(i6) != null) {
                i5 += Util.getDefaultBufferSize(rendererArr[i6].getTrackType());
            }
        }
        return i5;
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    public long getBackBufferDurationUs() {
        return 0;
    }

    public void onPrepared() {
        reset(false);
    }

    public void onReleased() {
        reset(true);
    }

    public void onStopped() {
        reset(true);
    }

    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        int i5 = this.targetBufferBytesOverwrite;
        if (i5 == -1) {
            i5 = calculateTargetBufferSize(rendererArr, trackSelectionArray);
        }
        this.targetBufferSize = i5;
        this.allocator.setTargetBufferSize(i5);
    }

    public boolean retainBackBufferFromKeyframe() {
        return false;
    }

    public boolean shouldContinueLoading(long j5, float f5) {
        boolean z4;
        boolean z5;
        boolean z6 = true;
        if (this.allocator.getTotalBytesAllocated() >= this.targetBufferSize) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z7 = this.isBuffering;
        long j6 = this.minBufferUs;
        if (f5 > 1.0f) {
            j6 = Math.min(Util.getMediaDurationForPlayoutDuration(j6, f5), this.maxBufferUs);
        }
        if (j5 < j6) {
            if (!this.prioritizeTimeOverSizeThresholds && z4) {
                z6 = false;
            }
            this.isBuffering = z6;
        } else if (j5 > this.maxBufferUs || z4) {
            this.isBuffering = false;
        }
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (!(priorityTaskManager2 == null || (z5 = this.isBuffering) == z7)) {
            if (z5) {
                priorityTaskManager2.add(0);
            } else {
                priorityTaskManager2.remove(0);
            }
        }
        return this.isBuffering;
    }

    public boolean shouldStartPlayback(long j5, float f5, boolean z4) {
        long j6;
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j5, f5);
        if (z4) {
            j6 = this.bufferForPlaybackAfterRebufferUs;
        } else {
            j6 = this.bufferForPlaybackUs;
        }
        if (j6 <= 0 || playoutDurationForMediaDuration >= j6) {
            return true;
        }
        if (this.prioritizeTimeOverSizeThresholds || this.allocator.getTotalBytesAllocated() < this.targetBufferSize) {
            return false;
        }
        return true;
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, DEFAULT_MIN_BUFFER_MS, DEFAULT_MAX_BUFFER_MS, DEFAULT_BUFFER_FOR_PLAYBACK_MS, DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, -1, true);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i5, int i6, int i7, int i8, int i9, boolean z4) {
        this(defaultAllocator, i5, i6, i7, i8, i9, z4, (PriorityTaskManager) null);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i5, int i6, int i7, int i8, int i9, boolean z4, PriorityTaskManager priorityTaskManager2) {
        assertGreaterOrEqual(i7, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i8, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i5, i7, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i5, i8, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i6, i5, "maxBufferMs", "minBufferMs");
        this.allocator = defaultAllocator;
        this.minBufferUs = ((long) i5) * 1000;
        this.maxBufferUs = ((long) i6) * 1000;
        this.bufferForPlaybackUs = ((long) i7) * 1000;
        this.bufferForPlaybackAfterRebufferUs = ((long) i8) * 1000;
        this.targetBufferBytesOverwrite = i9;
        this.prioritizeTimeOverSizeThresholds = z4;
        this.priorityTaskManager = priorityTaskManager2;
    }
}
