package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.net.NetworkInfo;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsListener;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class EventLogger implements AnalyticsListener {
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period = new Timeline.Period();
    private final long startTimeMs = SystemClock.elapsedRealtime();
    @Nullable
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window = new Timeline.Window();

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }

    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector) {
        this.trackSelector = mappingTrackSelector;
    }

    private static String getAdaptiveSupportString(int i5, int i6) {
        if (i5 < 2) {
            return "N/A";
        }
        if (i6 == 0) {
            return "NO";
        }
        if (i6 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i6 != 16) {
            return "?";
        }
        return "YES";
    }

    private static String getDiscontinuityReasonString(int i5) {
        if (i5 == 0) {
            return "PERIOD_TRANSITION";
        }
        if (i5 == 1) {
            return "SEEK";
        }
        if (i5 == 2) {
            return "SEEK_ADJUSTMENT";
        }
        if (i5 == 3) {
            return "AD_INSERTION";
        }
        if (i5 != 4) {
            return "?";
        }
        return "INTERNAL";
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str) {
        return str + " [" + getEventTimeString(eventTime) + "]";
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.mediaPeriodId.periodIndex;
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return getTimeString(eventTime.realtimeMs - this.startTimeMs) + ", " + getTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    private static String getFormatSupportString(int i5) {
        if (i5 == 0) {
            return "NO";
        }
        if (i5 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i5 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i5 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i5 != 4) {
            return "?";
        }
        return "YES";
    }

    private static String getRepeatModeString(int i5) {
        if (i5 == 0) {
            return "OFF";
        }
        if (i5 == 1) {
            return "ONE";
        }
        if (i5 != 2) {
            return "?";
        }
        return "ALL";
    }

    private static String getStateString(int i5) {
        if (i5 == 1) {
            return "IDLE";
        }
        if (i5 == 2) {
            return "BUFFERING";
        }
        if (i5 == 3) {
            return "READY";
        }
        if (i5 != 4) {
            return "?";
        }
        return "ENDED";
    }

    private static String getTimeString(long j5) {
        if (j5 == C.TIME_UNSET) {
            return "?";
        }
        return TIME_FORMAT.format((double) (((float) j5) / 1000.0f));
    }

    private static String getTimelineChangeReasonString(int i5) {
        if (i5 == 0) {
            return "PREPARED";
        }
        if (i5 == 1) {
            return "RESET";
        }
        if (i5 != 2) {
            return "?";
        }
        return "DYNAMIC";
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i5) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i5) == -1) ? false : true);
    }

    private static String getTrackTypeString(int i5) {
        if (i5 == 0) {
            return MRAIDCommunicatorUtil.STATES_DEFAULT;
        }
        if (i5 == 1) {
            return MimeTypes.BASE_TYPE_AUDIO;
        }
        if (i5 == 2) {
            return MimeTypes.BASE_TYPE_VIDEO;
        }
        if (i5 == 3) {
            return MimeTypes.BASE_TYPE_TEXT;
        }
        if (i5 == 4) {
            return TtmlNode.TAG_METADATA;
        }
        if (i5 == 5) {
            return "none";
        }
        if (i5 < 10000) {
            return "?";
        }
        return "custom (" + i5 + ")";
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i5 = 0; i5 < metadata.length(); i5++) {
            logd(str + metadata.get(i5));
        }
    }

    /* access modifiers changed from: protected */
    public void logd(String str) {
        Log.d(TAG, str);
    }

    /* access modifiers changed from: protected */
    public void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    public void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i5) {
        logd(eventTime, "audioSessionId", Integer.toString(i5));
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i5, long j5, long j6) {
        loge(eventTime, "audioTrackUnderrun", i5 + ", " + j5 + ", " + j6 + "]", (Throwable) null);
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i5, long j5, long j6) {
    }

    public void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i5, DecoderCounters decoderCounters) {
        logd(eventTime, "decoderDisabled", getTrackTypeString(i5));
    }

    public void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i5, DecoderCounters decoderCounters) {
        logd(eventTime, "decoderEnabled", getTrackTypeString(i5));
    }

    public void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i5, String str, long j5) {
        logd(eventTime, "decoderInitialized", getTrackTypeString(i5) + ", " + str);
    }

    public void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i5, Format format) {
        logd(eventTime, "decoderInputFormatChanged", getTrackTypeString(i5) + ", " + Format.toLogString(format));
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        logd(eventTime, "downstreamFormatChanged", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i5, long j5) {
        logd(eventTime, "droppedFrames", Integer.toString(i5));
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
        printInternalError(eventTime, "loadError", iOException);
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z4) {
        logd(eventTime, MRAIDCommunicatorUtil.STATES_LOADING, Boolean.toString(z4));
    }

    public void onMediaPeriodCreated(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodCreated");
    }

    public void onMediaPeriodReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReleased");
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        logd("metadata [" + getEventTimeString(eventTime) + ", ");
        printMetadata(metadata, "  ");
        logd("]");
    }

    public void onNetworkTypeChanged(AnalyticsListener.EventTime eventTime, @Nullable NetworkInfo networkInfo) {
        String str;
        if (networkInfo == null) {
            str = "none";
        } else {
            str = networkInfo.toString();
        }
        logd(eventTime, "networkTypeChanged", str);
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", Util.formatInvariant("speed=%.2f, pitch=%.2f, skipSilence=%s", Float.valueOf(playbackParameters.speed), Float.valueOf(playbackParameters.pitch), Boolean.valueOf(playbackParameters.skipSilence)));
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        loge(eventTime, "playerFailed", exoPlaybackException);
    }

    public void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z4, int i5) {
        logd(eventTime, MRAIDCommunicatorUtil.KEY_STATE, z4 + ", " + getStateString(i5));
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i5) {
        logd(eventTime, "positionDiscontinuity", getDiscontinuityReasonString(i5));
    }

    public void onReadingStarted(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "mediaPeriodReadingStarted");
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        logd(eventTime, "renderedFirstFrame", surface.toString());
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i5) {
        logd(eventTime, "repeatMode", getRepeatModeString(i5));
    }

    public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekProcessed");
    }

    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "seekStarted");
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z4) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z4));
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i5) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        logd("timelineChanged [" + getEventTimeString(eventTime) + ", periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i5));
        for (int i6 = 0; i6 < Math.min(periodCount, 3); i6++) {
            eventTime.timeline.getPeriod(i6, this.period);
            logd("  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i7 = 0; i7 < Math.min(windowCount, 3); i7++) {
            eventTime.timeline.getWindow(i7, this.window);
            logd("  window [" + getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo;
        String str;
        int i5;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2;
        MappingTrackSelector mappingTrackSelector = this.trackSelector;
        if (mappingTrackSelector != null) {
            mappedTrackInfo = mappingTrackSelector.getCurrentMappedTrackInfo();
        } else {
            mappedTrackInfo = null;
        }
        if (mappedTrackInfo == null) {
            logd(eventTime, "tracksChanged", "[]");
            return;
        }
        AnalyticsListener.EventTime eventTime2 = eventTime;
        logd("tracksChanged [" + getEventTimeString(eventTime) + ", ");
        int rendererCount = mappedTrackInfo.getRendererCount();
        int i6 = 0;
        while (true) {
            str = "  ]";
            if (i6 >= rendererCount) {
                break;
            }
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i6);
            TrackSelection trackSelection = trackSelectionArray.get(i6);
            if (trackGroups.length > 0) {
                StringBuilder sb = new StringBuilder();
                i5 = rendererCount;
                sb.append("  Renderer:");
                sb.append(i6);
                sb.append(" [");
                logd(sb.toString());
                int i7 = 0;
                while (i7 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i7);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String str2 = str;
                    String adaptiveSupportString = getAdaptiveSupportString(trackGroup.length, mappedTrackInfo.getAdaptiveSupport(i6, i7, false));
                    logd("    Group:" + i7 + ", adaptive_supported=" + adaptiveSupportString + " [");
                    int i8 = 0;
                    while (i8 < trackGroup.length) {
                        String trackStatusString = getTrackStatusString(trackSelection, trackGroup, i8);
                        String formatSupportString = getFormatSupportString(mappedTrackInfo.getTrackSupport(i6, i7, i8));
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo;
                        logd("      " + trackStatusString + " Track:" + i8 + ", " + Format.toLogString(trackGroup.getFormat(i8)) + ", supported=" + formatSupportString);
                        i8++;
                        mappedTrackInfo = mappedTrackInfo3;
                    }
                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo4 = mappedTrackInfo;
                    logd("    ]");
                    i7++;
                    TrackSelectionArray trackSelectionArray2 = trackSelectionArray;
                    trackGroups = trackGroupArray2;
                    str = str2;
                }
                mappedTrackInfo2 = mappedTrackInfo;
                String str3 = str;
                if (trackSelection != null) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= trackSelection.length()) {
                            break;
                        }
                        Metadata metadata = trackSelection.getFormat(i9).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            printMetadata(metadata, "      ");
                            logd("    ]");
                            break;
                        }
                        i9++;
                    }
                }
                logd(str3);
            } else {
                mappedTrackInfo2 = mappedTrackInfo;
                i5 = rendererCount;
            }
            i6++;
            rendererCount = i5;
            mappedTrackInfo = mappedTrackInfo2;
        }
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo5 = mappedTrackInfo;
        String str4 = str;
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo5.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Renderer:None [");
            for (int i10 = 0; i10 < unmappedTrackGroups.length; i10++) {
                logd("    Group:" + i10 + " [");
                TrackGroup trackGroup2 = unmappedTrackGroups.get(i10);
                for (int i11 = 0; i11 < trackGroup2.length; i11++) {
                    String trackStatusString2 = getTrackStatusString(false);
                    String formatSupportString2 = getFormatSupportString(0);
                    logd("      " + trackStatusString2 + " Track:" + i11 + ", " + Format.toLogString(trackGroup2.getFormat(i11)) + ", supported=" + formatSupportString2);
                }
                logd("    ]");
            }
            logd(str4);
        }
        logd("]");
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i5, int i6, int i7, float f5) {
        logd(eventTime, "videoSizeChanged", i5 + ", " + i6);
    }

    public void onViewportSizeChange(AnalyticsListener.EventTime eventTime, int i5, int i6) {
        logd(eventTime, "viewportSizeChanged", i5 + ", " + i6);
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, String str2) {
        return str + " [" + getEventTimeString(eventTime) + ", " + str2 + "]";
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, Throwable th) {
        loge(getEventString(eventTime, str), th);
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th) {
        loge(getEventString(eventTime, str, str2), th);
    }

    private static String getTrackStatusString(boolean z4) {
        return z4 ? "[X]" : "[ ]";
    }
}
