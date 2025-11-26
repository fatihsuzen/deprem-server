package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final int PERIOD_COUNT_UNSET = -1;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final MediaSource[] mediaSources;
    private IllegalMergeException mergeError;
    private final ArrayList<MediaSource> pendingTimelineSources;
    private int periodCount;
    private Object primaryManifest;
    private Timeline primaryTimeline;

    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i5) {
            this.reason = i5;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    private IllegalMergeException checkTimelineMerges(Timeline timeline) {
        if (this.periodCount == -1) {
            this.periodCount = timeline.getPeriodCount();
            return null;
        } else if (timeline.getPeriodCount() != this.periodCount) {
            return new IllegalMergeException(0);
        } else {
            return null;
        }
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        int length = this.mediaSources.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        for (int i5 = 0; i5 < length; i5++) {
            mediaPeriodArr[i5] = this.mediaSources[i5].createPeriod(mediaPeriodId, allocator);
        }
        return new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, mediaPeriodArr);
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.mergeError;
        if (illegalMergeException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalMergeException;
    }

    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z4) {
        super.prepareSourceInternal(exoPlayer, z4);
        for (int i5 = 0; i5 < this.mediaSources.length; i5++) {
            prepareChildSource(Integer.valueOf(i5), this.mediaSources[i5]);
        }
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i5 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i5 < mediaSourceArr.length) {
                mediaSourceArr[i5].releasePeriod(mergingMediaPeriod.periods[i5]);
                i5++;
            } else {
                return;
            }
        }
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.primaryTimeline = null;
        this.primaryManifest = null;
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }

    public MergingMediaSource(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, MediaSource... mediaSourceArr) {
        this.mediaSources = mediaSourceArr;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.pendingTimelineSources = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.periodCount = -1;
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        if (this.mergeError == null) {
            this.mergeError = checkTimelineMerges(timeline);
        }
        if (this.mergeError == null) {
            this.pendingTimelineSources.remove(mediaSource);
            if (mediaSource == this.mediaSources[0]) {
                this.primaryTimeline = timeline;
                this.primaryManifest = obj;
            }
            if (this.pendingTimelineSources.isEmpty()) {
                refreshSourceInfo(this.primaryTimeline, this.primaryManifest);
            }
        }
    }
}
