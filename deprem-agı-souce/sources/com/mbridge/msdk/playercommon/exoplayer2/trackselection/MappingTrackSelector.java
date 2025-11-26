package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.RendererCapabilities;
import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {
    @Nullable
    private MappedTrackInfo currentMappedTrackInfo;

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i5 = 0;
        for (int i6 = 0; i6 < rendererCapabilitiesArr.length; i6++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i6];
            for (int i7 = 0; i7 < trackGroup.length; i7++) {
                int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i7)) & 7;
                if (supportsFormat > i5) {
                    if (supportsFormat == 4) {
                        return i6;
                    }
                    length = i6;
                    i5 = supportsFormat;
                }
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            iArr[i5] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i5));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = rendererCapabilitiesArr[i5].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Nullable
    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        int[] iArr;
        int[] iArr2 = new int[(rendererCapabilitiesArr.length + 1)];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr.length + 1)][][];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = trackGroupArray.length;
            trackGroupArr[i5] = new TrackGroup[i6];
            iArr3[i5] = new int[i6][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i7 = 0; i7 < trackGroupArray.length; i7++) {
            TrackGroup trackGroup = trackGroupArray.get(i7);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            if (findRenderer == rendererCapabilitiesArr.length) {
                iArr = new int[trackGroup.length];
            } else {
                iArr = getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
            }
            int i8 = iArr2[findRenderer];
            trackGroupArr[findRenderer][i8] = trackGroup;
            iArr3[findRenderer][i8] = iArr;
            iArr2[findRenderer] = i8 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr4 = new int[rendererCapabilitiesArr.length];
        for (int i9 = 0; i9 < rendererCapabilitiesArr.length; i9++) {
            int i10 = iArr2[i9];
            trackGroupArrayArr[i9] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i9], i10));
            iArr3[i9] = (int[][]) Util.nullSafeArrayCopy(iArr3[i9], i10);
            iArr4[i9] = rendererCapabilitiesArr[i9].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr4, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr3, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length])));
        Pair<RendererConfiguration[], TrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, mixedMimeTypeAdaptationSupports);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (TrackSelection[]) selectTracks.second, mappedTrackInfo);
    }

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        @Deprecated
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        @Retention(RetentionPolicy.SOURCE)
        @interface RendererSupport {
        }

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererFormatSupports = iArr3;
            this.rendererMixedMimeTypeAdaptiveSupports = iArr2;
            this.unmappedTrackGroups = trackGroupArray;
            int length2 = iArr.length;
            this.rendererCount = length2;
            this.length = length2;
        }

        public final int getAdaptiveSupport(int i5, int i6, boolean z4) {
            int i7 = this.rendererTrackGroups[i5].get(i6).length;
            int[] iArr = new int[i7];
            int i8 = 0;
            for (int i9 = 0; i9 < i7; i9++) {
                int trackSupport = getTrackSupport(i5, i6, i9);
                if (trackSupport == 4 || (z4 && trackSupport == 3)) {
                    iArr[i8] = i9;
                    i8++;
                }
            }
            return getAdaptiveSupport(i5, i6, Arrays.copyOf(iArr, i8));
        }

        public final int getRendererCount() {
            return this.rendererCount;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            r1 = r1 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int getRendererSupport(int r8) {
            /*
                r7 = this;
                int[][][] r0 = r7.rendererFormatSupports
                r8 = r0[r8]
                r0 = 0
                r1 = r0
                r2 = r1
            L_0x0007:
                int r3 = r8.length
                if (r1 >= r3) goto L_0x0028
                r3 = r0
            L_0x000b:
                r4 = r8[r1]
                int r5 = r4.length
                if (r3 >= r5) goto L_0x0025
                r4 = r4[r3]
                r4 = r4 & 7
                r5 = 3
                if (r4 == r5) goto L_0x001d
                r6 = 4
                if (r4 == r6) goto L_0x001c
                r4 = 1
                goto L_0x001e
            L_0x001c:
                return r5
            L_0x001d:
                r4 = 2
            L_0x001e:
                int r2 = java.lang.Math.max(r2, r4)
                int r3 = r3 + 1
                goto L_0x000b
            L_0x0025:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0028:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo.getRendererSupport(int):int");
        }

        public final int getRendererType(int i5) {
            return this.rendererTrackTypes[i5];
        }

        @Deprecated
        public final int getTrackFormatSupport(int i5, int i6, int i7) {
            return getTrackSupport(i5, i6, i7);
        }

        public final TrackGroupArray getTrackGroups(int i5) {
            return this.rendererTrackGroups[i5];
        }

        public final int getTrackSupport(int i5, int i6, int i7) {
            return this.rendererFormatSupports[i5][i6][i7] & 7;
        }

        @Deprecated
        public final int getTrackTypeRendererSupport(int i5) {
            return getTypeSupport(i5);
        }

        public final int getTypeSupport(int i5) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.rendererCount; i7++) {
                if (this.rendererTrackTypes[i7] == i5) {
                    i6 = Math.max(i6, getRendererSupport(i7));
                }
            }
            return i6;
        }

        @Deprecated
        public final TrackGroupArray getUnassociatedTrackGroups() {
            return getUnmappedTrackGroups();
        }

        public final TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }

        public final int getAdaptiveSupport(int i5, int i6, int[] iArr) {
            int i7 = 0;
            int i8 = 16;
            String str = null;
            boolean z4 = false;
            int i9 = 0;
            while (i7 < iArr.length) {
                String str2 = this.rendererTrackGroups[i5].get(i6).getFormat(iArr[i7]).sampleMimeType;
                int i10 = i9 + 1;
                if (i9 == 0) {
                    str = str2;
                } else {
                    z4 |= !Util.areEqual(str, str2);
                }
                i8 = Math.min(i8, this.rendererFormatSupports[i5][i6][i7] & 24);
                i7++;
                i9 = i10;
            }
            return z4 ? Math.min(i8, this.rendererMixedMimeTypeAdaptiveSupports[i5]) : i8;
        }
    }
}
