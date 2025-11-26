package com.mbridge.msdk.playercommon.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.DeferredMediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdsLoader;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final String TAG = "AdsMediaSource";
    private long[][] adDurationsUs;
    private MediaSource[][] adGroupMediaSources;
    private final MediaSourceFactory adMediaSourceFactory;
    private AdPlaybackState adPlaybackState;
    /* access modifiers changed from: private */
    public final ViewGroup adUiViewGroup;
    /* access modifiers changed from: private */
    public final AdsLoader adsLoader;
    private ComponentListener componentListener;
    private Object contentManifest;
    private final MediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Map<MediaSource, List<DeferredMediaPeriod>> deferredMediaPeriodByAdMediaSource;
    /* access modifiers changed from: private */
    @Nullable
    public final Handler eventHandler;
    /* access modifiers changed from: private */
    @Nullable
    public final EventListener eventListener;
    /* access modifiers changed from: private */
    public final Handler mainHandler;
    private final Timeline.Period period;

    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i5, Exception exc) {
            super(exc);
            this.type = i5;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i5) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i5, exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public final RuntimeException getRuntimeExceptionForUnexpected() {
            boolean z4;
            if (this.type == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            return (RuntimeException) getCause();
        }
    }

    private final class AdPrepareErrorListener implements DeferredMediaPeriod.PrepareErrorListener {
        /* access modifiers changed from: private */
        public final int adGroupIndex;
        /* access modifiers changed from: private */
        public final int adIndexInAdGroup;
        private final Uri adUri;

        public AdPrepareErrorListener(Uri uri, int i5, int i6) {
            this.adUri = uri;
            this.adGroupIndex = i5;
            this.adIndexInAdGroup = i6;
        }

        public final void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new DataSpec(this.adUri), 6, -1, 0, 0, AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.mainHandler.post(new Runnable() {
                public void run() {
                    AdsMediaSource.this.adsLoader.handlePrepareError(AdPrepareErrorListener.this.adGroupIndex, AdPrepareErrorListener.this.adIndexInAdGroup, iOException);
                }
            });
        }
    }

    private final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler = new Handler();
        /* access modifiers changed from: private */
        public volatile boolean released;

        public ComponentListener() {
        }

        public final void onAdClicked() {
            if (!this.released && AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() {
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdClicked();
                        }
                    }
                });
            }
        }

        public final void onAdLoadError(AdLoadException adLoadException, DataSpec dataSpec) {
            if (!this.released) {
                final AdLoadException adLoadException2 = adLoadException;
                AdsMediaSource.this.createEventDispatcher((MediaSource.MediaPeriodId) null).loadError(dataSpec, 6, -1, 0, 0, adLoadException2, true);
                if (AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                    AdsMediaSource.this.eventHandler.post(new Runnable() {
                        public void run() {
                            if (ComponentListener.this.released) {
                                return;
                            }
                            if (adLoadException2.type == 3) {
                                AdsMediaSource.this.eventListener.onInternalAdLoadError(adLoadException2.getRuntimeExceptionForUnexpected());
                            } else {
                                AdsMediaSource.this.eventListener.onAdLoadError(adLoadException2);
                            }
                        }
                    });
                }
            }
        }

        public final void onAdPlaybackState(final AdPlaybackState adPlaybackState) {
            if (!this.released) {
                this.playerHandler.post(new Runnable() {
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
                        }
                    }
                });
            }
        }

        public final void onAdTapped() {
            if (!this.released && AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() {
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdTapped();
                        }
                    }
                });
            }
        }

        public final void release() {
            this.released = true;
            this.playerHandler.removeCallbacksAndMessages((Object) null);
        }
    }

    @Deprecated
    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(IOException iOException);

        void onAdTapped();

        void onInternalAdLoadError(RuntimeException runtimeException);
    }

    public interface MediaSourceFactory {
        MediaSource createMediaSource(Uri uri);

        int[] getSupportedTypes();
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader2, ViewGroup viewGroup) {
        this(mediaSource, (MediaSourceFactory) new ExtractorMediaSource.Factory(factory), adsLoader2, viewGroup, (Handler) null, (EventListener) null);
    }

    private void maybeUpdateSourceInfo() {
        Timeline timeline;
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 != null && this.contentTimeline != null) {
            AdPlaybackState withAdDurationsUs = adPlaybackState2.withAdDurationsUs(this.adDurationsUs);
            this.adPlaybackState = withAdDurationsUs;
            if (withAdDurationsUs.adGroupCount == 0) {
                timeline = this.contentTimeline;
            } else {
                timeline = new SinglePeriodAdTimeline(this.contentTimeline, this.adPlaybackState);
            }
            refreshSourceInfo(timeline, this.contentManifest);
        }
    }

    /* access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState2) {
        if (this.adPlaybackState == null) {
            MediaSource[][] mediaSourceArr = new MediaSource[adPlaybackState2.adGroupCount][];
            this.adGroupMediaSources = mediaSourceArr;
            Arrays.fill(mediaSourceArr, new MediaSource[0]);
            long[][] jArr = new long[adPlaybackState2.adGroupCount][];
            this.adDurationsUs = jArr;
            Arrays.fill(jArr, new long[0]);
        }
        this.adPlaybackState = adPlaybackState2;
        maybeUpdateSourceInfo();
    }

    private void onAdSourceInfoRefreshed(MediaSource mediaSource, int i5, int i6, Timeline timeline) {
        boolean z4 = true;
        if (timeline.getPeriodCount() != 1) {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.adDurationsUs[i5][i6] = timeline.getPeriod(0, this.period).getDurationUs();
        if (this.deferredMediaPeriodByAdMediaSource.containsKey(mediaSource)) {
            List list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
            for (int i7 = 0; i7 < list.size(); i7++) {
                ((DeferredMediaPeriod) list.get(i7)).createPeriod();
            }
            this.deferredMediaPeriodByAdMediaSource.remove(mediaSource);
        }
        maybeUpdateSourceInfo();
    }

    private void onContentSourceInfoRefreshed(Timeline timeline, Object obj) {
        this.contentTimeline = timeline;
        this.contentManifest = obj;
        maybeUpdateSourceInfo();
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        if (this.adPlaybackState.adGroupCount <= 0 || !mediaPeriodId.isAd()) {
            DeferredMediaPeriod deferredMediaPeriod = new DeferredMediaPeriod(this.contentMediaSource, mediaPeriodId, allocator);
            deferredMediaPeriod.createPeriod();
            return deferredMediaPeriod;
        }
        int i5 = mediaPeriodId.adGroupIndex;
        int i6 = mediaPeriodId.adIndexInAdGroup;
        Uri uri = this.adPlaybackState.adGroups[i5].uris[i6];
        if (this.adGroupMediaSources[i5].length <= i6) {
            MediaSource createMediaSource = this.adMediaSourceFactory.createMediaSource(uri);
            MediaSource[][] mediaSourceArr = this.adGroupMediaSources;
            MediaSource[] mediaSourceArr2 = mediaSourceArr[i5];
            int length = mediaSourceArr2.length;
            if (i6 >= length) {
                int i7 = i6 + 1;
                mediaSourceArr[i5] = (MediaSource[]) Arrays.copyOf(mediaSourceArr2, i7);
                long[][] jArr = this.adDurationsUs;
                jArr[i5] = Arrays.copyOf(jArr[i5], i7);
                Arrays.fill(this.adDurationsUs[i5], length, i7, C.TIME_UNSET);
            }
            this.adGroupMediaSources[i5][i6] = createMediaSource;
            this.deferredMediaPeriodByAdMediaSource.put(createMediaSource, new ArrayList());
            prepareChildSource(mediaPeriodId, createMediaSource);
        }
        MediaSource mediaSource = this.adGroupMediaSources[i5][i6];
        DeferredMediaPeriod deferredMediaPeriod2 = new DeferredMediaPeriod(mediaSource, new MediaSource.MediaPeriodId(0, mediaPeriodId.windowSequenceNumber), allocator);
        deferredMediaPeriod2.setPrepareErrorListener(new AdPrepareErrorListener(uri, i5, i6));
        List list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
        if (list == null) {
            deferredMediaPeriod2.createPeriod();
            return deferredMediaPeriod2;
        }
        list.add(deferredMediaPeriod2);
        return deferredMediaPeriod2;
    }

    public final void prepareSourceInternal(final ExoPlayer exoPlayer, boolean z4) {
        super.prepareSourceInternal(exoPlayer, z4);
        Assertions.checkArgument(z4);
        final ComponentListener componentListener2 = new ComponentListener();
        this.componentListener = componentListener2;
        prepareChildSource(new MediaSource.MediaPeriodId(0), this.contentMediaSource);
        this.mainHandler.post(new Runnable() {
            public void run() {
                AdsMediaSource.this.adsLoader.attachPlayer(exoPlayer, componentListener2, AdsMediaSource.this.adUiViewGroup);
            }
        });
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        DeferredMediaPeriod deferredMediaPeriod = (DeferredMediaPeriod) mediaPeriod;
        List list = this.deferredMediaPeriodByAdMediaSource.get(deferredMediaPeriod.mediaSource);
        if (list != null) {
            list.remove(deferredMediaPeriod);
        }
        deferredMediaPeriod.releasePeriod();
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.componentListener.release();
        this.componentListener = null;
        this.deferredMediaPeriodByAdMediaSource.clear();
        this.contentTimeline = null;
        this.contentManifest = null;
        this.adPlaybackState = null;
        this.adGroupMediaSources = new MediaSource[0][];
        this.adDurationsUs = new long[0][];
        this.mainHandler.post(new Runnable() {
            public void run() {
                AdsMediaSource.this.adsLoader.detachPlayer();
            }
        });
    }

    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader2, ViewGroup viewGroup) {
        this(mediaSource, mediaSourceFactory, adsLoader2, viewGroup, (Handler) null, (EventListener) null);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        if (mediaPeriodId.isAd()) {
            onAdSourceInfoRefreshed(mediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, timeline);
        } else {
            onContentSourceInfoRefreshed(timeline, obj);
        }
    }

    @Deprecated
    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader2, ViewGroup viewGroup, @Nullable Handler handler, @Nullable EventListener eventListener2) {
        this(mediaSource, (MediaSourceFactory) new ExtractorMediaSource.Factory(factory), adsLoader2, viewGroup, handler, eventListener2);
    }

    @Deprecated
    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader2, ViewGroup viewGroup, @Nullable Handler handler, @Nullable EventListener eventListener2) {
        this.contentMediaSource = mediaSource;
        this.adMediaSourceFactory = mediaSourceFactory;
        this.adsLoader = adsLoader2;
        this.adUiViewGroup = viewGroup;
        this.eventHandler = handler;
        this.eventListener = eventListener2;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.deferredMediaPeriodByAdMediaSource = new HashMap();
        this.period = new Timeline.Period();
        this.adGroupMediaSources = new MediaSource[0][];
        this.adDurationsUs = new long[0][];
        adsLoader2.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }
}
