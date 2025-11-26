package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends MappingTrackSelector {
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final int[] NO_TRACKS = new int[0];
    private static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    @Nullable
    private final TrackSelection.Factory adaptiveTrackSelectionFactory;
    private final AtomicReference<Parameters> parametersReference;

    private static final class AudioConfigurationTuple {
        public final int channelCount;
        @Nullable
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i5, int i6, @Nullable String str) {
            this.channelCount = i5;
            this.sampleRate = i6;
            this.mimeType = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AudioConfigurationTuple.class == obj.getClass()) {
                AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
                if (this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            int i5;
            int i6 = ((this.channelCount * 31) + this.sampleRate) * 31;
            String str = this.mimeType;
            if (str != null) {
                i5 = str.hashCode();
            } else {
                i5 = 0;
            }
            return i6 + i5;
        }
    }

    private static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final int defaultSelectionFlagScore;
        private final int matchLanguageScore;
        private final Parameters parameters;
        private final int sampleRate;
        private final int withinRendererCapabilitiesScore;

        public AudioTrackScore(Format format, Parameters parameters2, int i5) {
            this.parameters = parameters2;
            int i6 = 0;
            this.withinRendererCapabilitiesScore = DefaultTrackSelector.isSupported(i5, false) ? 1 : 0;
            this.matchLanguageScore = DefaultTrackSelector.formatHasLanguage(format, parameters2.preferredAudioLanguage) ? 1 : 0;
            this.defaultSelectionFlagScore = (format.selectionFlags & 1) != 0 ? 1 : i6;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AudioTrackScore.class == obj.getClass()) {
                AudioTrackScore audioTrackScore = (AudioTrackScore) obj;
                if (this.withinRendererCapabilitiesScore == audioTrackScore.withinRendererCapabilitiesScore && this.matchLanguageScore == audioTrackScore.matchLanguageScore && this.defaultSelectionFlagScore == audioTrackScore.defaultSelectionFlagScore && this.channelCount == audioTrackScore.channelCount && this.sampleRate == audioTrackScore.sampleRate && this.bitrate == audioTrackScore.bitrate) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.withinRendererCapabilitiesScore * 31) + this.matchLanguageScore) * 31) + this.defaultSelectionFlagScore) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }

        public final int compareTo(AudioTrackScore audioTrackScore) {
            int access$300;
            int i5 = this.withinRendererCapabilitiesScore;
            int i6 = audioTrackScore.withinRendererCapabilitiesScore;
            if (i5 != i6) {
                return DefaultTrackSelector.compareInts(i5, i6);
            }
            int i7 = this.matchLanguageScore;
            int i8 = audioTrackScore.matchLanguageScore;
            if (i7 != i8) {
                return DefaultTrackSelector.compareInts(i7, i8);
            }
            int i9 = this.defaultSelectionFlagScore;
            int i10 = audioTrackScore.defaultSelectionFlagScore;
            if (i9 != i10) {
                return DefaultTrackSelector.compareInts(i9, i10);
            }
            if (this.parameters.forceLowestBitrate) {
                return DefaultTrackSelector.compareInts(audioTrackScore.bitrate, this.bitrate);
            }
            int i11 = 1;
            if (i5 != 1) {
                i11 = -1;
            }
            int i12 = this.channelCount;
            int i13 = audioTrackScore.channelCount;
            if (i12 != i13) {
                access$300 = DefaultTrackSelector.compareInts(i12, i13);
            } else {
                int i14 = this.sampleRate;
                int i15 = audioTrackScore.sampleRate;
                if (i14 != i15) {
                    access$300 = DefaultTrackSelector.compareInts(i14, i15);
                } else {
                    access$300 = DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
                }
            }
            return i11 * access$300;
        }
    }

    public static final class Parameters implements Parcelable {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            public final Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            public final Parameters[] newArray(int i5) {
                return new Parameters[i5];
            }
        };
        public static final Parameters DEFAULT = new Parameters();
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final int disabledTextTrackSelectionFlags;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceLowestBitrate;
        public final int maxVideoBitrate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        @Nullable
        public final String preferredAudioLanguage;
        @Nullable
        public final String preferredTextLanguage;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        public final boolean selectUndeterminedTextLanguage;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        private Parameters() {
            this(new SparseArray(), new SparseBooleanArray(), (String) null, (String) null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i5)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i5));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i5), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i5 = 0; i5 < readInt; i5++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i6 = 0; i6 < readInt3; i6++) {
                    hashMap.put((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader()), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                Map valueAt = sparseArray.valueAt(i5);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        public final ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Parameters.class == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                if (this.selectUndeterminedTextLanguage == parameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == parameters.disabledTextTrackSelectionFlags && this.forceLowestBitrate == parameters.forceLowestBitrate && this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage) && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final boolean getRendererDisabled(int i5) {
            return this.rendererDisabledFlags.get(i5);
        }

        @Nullable
        public final SelectionOverride getSelectionOverride(int i5, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i5);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean hasSelectionOverride(int i5, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i5);
            if (map == null || !map.containsKey(trackGroupArray)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i5;
            int i6 = (((((((((((((((((((((((((((this.selectUndeterminedTextLanguage ? 1 : 0) * true) + this.disabledTextTrackSelectionFlags) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxVideoBitrate) * 31) + this.tunnelingAudioSessionId) * 31;
            String str = this.preferredAudioLanguage;
            int i7 = 0;
            if (str == null) {
                i5 = 0;
            } else {
                i5 = str.hashCode();
            }
            int i8 = (i6 + i5) * 31;
            String str2 = this.preferredTextLanguage;
            if (str2 != null) {
                i7 = str2.hashCode();
            }
            return i8 + i7;
        }

        public final void writeToParcel(Parcel parcel, int i5) {
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
            parcel.writeString(this.preferredAudioLanguage);
            parcel.writeString(this.preferredTextLanguage);
            Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
            parcel.writeInt(this.disabledTextTrackSelectionFlags);
            Util.writeBoolean(parcel, this.forceLowestBitrate);
            Util.writeBoolean(parcel, this.allowMixedMimeAdaptiveness);
            Util.writeBoolean(parcel, this.allowNonSeamlessAdaptiveness);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoBitrate);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.tunnelingAudioSessionId);
        }

        Parameters(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray, @Nullable String str, @Nullable String str2, boolean z4, int i5, boolean z5, boolean z6, boolean z7, int i6, int i7, int i8, boolean z8, boolean z9, int i9, int i10, boolean z10, int i11) {
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
            this.preferredAudioLanguage = Util.normalizeLanguageCode(str);
            this.preferredTextLanguage = Util.normalizeLanguageCode(str2);
            this.selectUndeterminedTextLanguage = z4;
            this.disabledTextTrackSelectionFlags = i5;
            this.forceLowestBitrate = z5;
            this.allowMixedMimeAdaptiveness = z6;
            this.allowNonSeamlessAdaptiveness = z7;
            this.maxVideoWidth = i6;
            this.maxVideoHeight = i7;
            this.maxVideoBitrate = i8;
            this.exceedVideoConstraintsIfNecessary = z8;
            this.exceedRendererCapabilitiesIfNecessary = z9;
            this.viewportWidth = i9;
            this.viewportHeight = i10;
            this.viewportOrientationMayChange = z10;
            this.tunnelingAudioSessionId = i11;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean areSelectionOverridesEqual(java.util.Map<com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray, com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray, com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray r1 = (com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.areEqual(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.Parameters.areSelectionOverridesEqual(java.util.Map, java.util.Map):boolean");
        }

        Parameters(Parcel parcel) {
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = parcel.readSparseBooleanArray();
            this.preferredAudioLanguage = parcel.readString();
            this.preferredTextLanguage = parcel.readString();
            this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
            this.disabledTextTrackSelectionFlags = parcel.readInt();
            this.forceLowestBitrate = Util.readBoolean(parcel);
            this.allowMixedMimeAdaptiveness = Util.readBoolean(parcel);
            this.allowNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
        }
    }

    public static final class ParametersBuilder {
        private boolean allowMixedMimeAdaptiveness;
        private boolean allowNonSeamlessAdaptiveness;
        private int disabledTextTrackSelectionFlags;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceLowestBitrate;
        private int maxVideoBitrate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        @Nullable
        private String preferredAudioLanguage;
        @Nullable
        private String preferredTextLanguage;
        private final SparseBooleanArray rendererDisabledFlags;
        private boolean selectUndeterminedTextLanguage;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                sparseArray2.put(sparseArray.keyAt(i5), new HashMap(sparseArray.valueAt(i5)));
            }
            return sparseArray2;
        }

        public final Parameters build() {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = this.selectionOverrides;
            SparseBooleanArray sparseBooleanArray = this.rendererDisabledFlags;
            String str = this.preferredAudioLanguage;
            String str2 = this.preferredTextLanguage;
            boolean z4 = this.selectUndeterminedTextLanguage;
            int i5 = this.disabledTextTrackSelectionFlags;
            boolean z5 = this.forceLowestBitrate;
            boolean z6 = this.allowMixedMimeAdaptiveness;
            boolean z7 = this.allowNonSeamlessAdaptiveness;
            int i6 = this.maxVideoWidth;
            int i7 = this.maxVideoHeight;
            int i8 = this.maxVideoBitrate;
            boolean z8 = this.exceedVideoConstraintsIfNecessary;
            boolean z9 = this.exceedRendererCapabilitiesIfNecessary;
            int i9 = this.viewportWidth;
            int i10 = this.viewportHeight;
            return new Parameters(sparseArray, sparseBooleanArray, str, str2, z4, i5, z5, z6, z7, i6, i7, i8, z8, z9, i9, i10, this.viewportOrientationMayChange, this.tunnelingAudioSessionId);
        }

        public final ParametersBuilder clearSelectionOverride(int i5, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i5);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.selectionOverrides.remove(i5);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int i5) {
            Map map = this.selectionOverrides.get(i5);
            if (map != null && !map.isEmpty()) {
                this.selectionOverrides.remove(i5);
            }
            return this;
        }

        public final ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public final ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public final ParametersBuilder setAllowMixedMimeAdaptiveness(boolean z4) {
            this.allowMixedMimeAdaptiveness = z4;
            return this;
        }

        public final ParametersBuilder setAllowNonSeamlessAdaptiveness(boolean z4) {
            this.allowNonSeamlessAdaptiveness = z4;
            return this;
        }

        public final ParametersBuilder setDisabledTextTrackSelectionFlags(int i5) {
            this.disabledTextTrackSelectionFlags = i5;
            return this;
        }

        public final ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z4) {
            this.exceedRendererCapabilitiesIfNecessary = z4;
            return this;
        }

        public final ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z4) {
            this.exceedVideoConstraintsIfNecessary = z4;
            return this;
        }

        public final ParametersBuilder setForceLowestBitrate(boolean z4) {
            this.forceLowestBitrate = z4;
            return this;
        }

        public final ParametersBuilder setMaxVideoBitrate(int i5) {
            this.maxVideoBitrate = i5;
            return this;
        }

        public final ParametersBuilder setMaxVideoSize(int i5, int i6) {
            this.maxVideoWidth = i5;
            this.maxVideoHeight = i6;
            return this;
        }

        public final ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public final ParametersBuilder setPreferredAudioLanguage(String str) {
            this.preferredAudioLanguage = str;
            return this;
        }

        public final ParametersBuilder setPreferredTextLanguage(String str) {
            this.preferredTextLanguage = str;
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int i5, boolean z4) {
            if (this.rendererDisabledFlags.get(i5) == z4) {
                return this;
            }
            if (z4) {
                this.rendererDisabledFlags.put(i5, true);
                return this;
            }
            this.rendererDisabledFlags.delete(i5);
            return this;
        }

        public final ParametersBuilder setSelectUndeterminedTextLanguage(boolean z4) {
            this.selectUndeterminedTextLanguage = z4;
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int i5, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
            Map map = this.selectionOverrides.get(i5);
            if (map == null) {
                map = new HashMap();
                this.selectionOverrides.put(i5, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public final ParametersBuilder setTunnelingAudioSessionId(int i5) {
            if (this.tunnelingAudioSessionId != i5) {
                this.tunnelingAudioSessionId = i5;
            }
            return this;
        }

        public final ParametersBuilder setViewportSize(int i5, int i6, boolean z4) {
            this.viewportWidth = i5;
            this.viewportHeight = i6;
            this.viewportOrientationMayChange = z4;
            return this;
        }

        public final ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z4) {
            Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
            return setViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z4);
        }

        public ParametersBuilder() {
            this(Parameters.DEFAULT);
        }

        private ParametersBuilder(Parameters parameters) {
            this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
            this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
            this.preferredAudioLanguage = parameters.preferredAudioLanguage;
            this.preferredTextLanguage = parameters.preferredTextLanguage;
            this.selectUndeterminedTextLanguage = parameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = parameters.disabledTextTrackSelectionFlags;
            this.forceLowestBitrate = parameters.forceLowestBitrate;
            this.allowMixedMimeAdaptiveness = parameters.allowMixedMimeAdaptiveness;
            this.allowNonSeamlessAdaptiveness = parameters.allowNonSeamlessAdaptiveness;
            this.maxVideoWidth = parameters.maxVideoWidth;
            this.maxVideoHeight = parameters.maxVideoHeight;
            this.maxVideoBitrate = parameters.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.viewportWidth = parameters.viewportWidth;
            this.viewportHeight = parameters.viewportHeight;
            this.viewportOrientationMayChange = parameters.viewportOrientationMayChange;
            this.tunnelingAudioSessionId = parameters.tunnelingAudioSessionId;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }
    }

    public DefaultTrackSelector() {
        this((TrackSelection.Factory) null);
    }

    private static int compareFormatValues(int i5, int i6) {
        if (i5 == -1) {
            return i6 == -1 ? 0 : -1;
        }
        if (i6 == -1) {
            return 1;
        }
        return i5 - i6;
    }

    /* access modifiers changed from: private */
    public static int compareInts(int i5, int i6) {
        if (i5 > i6) {
            return 1;
        }
        return i6 > i5 ? -1 : 0;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i5, @Nullable String str, int i6, int i7, int i8, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list2.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i5, i6, i7, i8)) {
                list2.remove(size);
            }
        }
    }

    protected static boolean formatHasLanguage(Format format, @Nullable String str) {
        if (str == null || !TextUtils.equals(str, Util.normalizeLanguageCode(format.language))) {
            return false;
        }
        return true;
    }

    protected static boolean formatHasNoLanguage(Format format) {
        if (TextUtils.isEmpty(format.language) || formatHasLanguage(format, C.LANGUAGE_UNDETERMINED)) {
            return true;
        }
        return false;
    }

    private static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        int i5 = 0;
        for (int i6 = 0; i6 < trackGroup.length; i6++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i6), iArr[i6], audioConfigurationTuple)) {
                i5++;
            }
        }
        return i5;
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, boolean z4) {
        String str;
        int adaptiveAudioTrackCount;
        HashSet hashSet = new HashSet();
        int i5 = 0;
        AudioConfigurationTuple audioConfigurationTuple = null;
        for (int i6 = 0; i6 < trackGroup.length; i6++) {
            Format format = trackGroup.getFormat(i6);
            int i7 = format.channelCount;
            int i8 = format.sampleRate;
            if (z4) {
                str = null;
            } else {
                str = format.sampleMimeType;
            }
            AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(i7, i8, str);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i5) {
                i5 = adaptiveAudioTrackCount;
                audioConfigurationTuple = audioConfigurationTuple2;
            }
        }
        if (i5 <= 1) {
            return NO_TRACKS;
        }
        int[] iArr2 = new int[i5];
        int i9 = 0;
        for (int i10 = 0; i10 < trackGroup.length; i10++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i10), iArr[i10], (AudioConfigurationTuple) Assertions.checkNotNull(audioConfigurationTuple))) {
                iArr2[i9] = i10;
                i9++;
            }
        }
        return iArr2;
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i5, @Nullable String str, int i6, int i7, int i8, List<Integer> list) {
        int i9 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            int intValue = list.get(i10).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i5, i6, i7, i8)) {
                i9++;
            }
        }
        return i9;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z5) {
        int i11;
        int i12;
        int i13;
        String str;
        int i14;
        int i15;
        int i16;
        int[] iArr2;
        TrackGroup trackGroup2;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i9, i10, z5);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z4) {
            HashSet hashSet = new HashSet();
            int i17 = 0;
            int i18 = 0;
            String str2 = null;
            while (i17 < viewportFilteredTrackIndices.size()) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i17).intValue()).sampleMimeType;
                if (hashSet.add(str3)) {
                    int i19 = i8;
                    i14 = i7;
                    i15 = i6;
                    String str4 = str3;
                    iArr2 = iArr;
                    trackGroup2 = trackGroup;
                    int adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup2, iArr2, i5, str4, i15, i14, i19, viewportFilteredTrackIndices);
                    int i20 = i19;
                    String str5 = str4;
                    i16 = i20;
                    if (adaptiveVideoTrackCountForMimeType > i18) {
                        i18 = adaptiveVideoTrackCountForMimeType;
                        str2 = str5;
                    }
                } else {
                    int i21 = i7;
                    i15 = i6;
                    i16 = i8;
                    i14 = i21;
                    iArr2 = iArr;
                    trackGroup2 = trackGroup;
                }
                i17++;
                int i22 = i14;
                i8 = i16;
                i6 = i15;
                i7 = i22;
                trackGroup = trackGroup2;
                iArr = iArr2;
            }
            i11 = i7;
            i12 = i6;
            i13 = i8;
            str = str2;
        } else {
            i11 = i7;
            i12 = i6;
            i13 = i8;
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i5, str, i12, i11, i13, viewportFilteredTrackIndices);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        return Util.toArray(viewportFilteredTrackIndices);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r1 != r3) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x000f
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L_0x0008
            r1 = r0
            goto L_0x0009
        L_0x0008:
            r1 = r3
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            r3 = r0
        L_0x000c:
            if (r1 == r3) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0012:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0022
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0022:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i5, int i6, boolean z4) {
        int i7;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i8 = 0; i8 < trackGroup.length; i8++) {
            arrayList.add(Integer.valueOf(i8));
        }
        if (!(i5 == Integer.MAX_VALUE || i6 == Integer.MAX_VALUE)) {
            int i9 = Integer.MAX_VALUE;
            for (int i10 = 0; i10 < trackGroup.length; i10++) {
                Format format = trackGroup.getFormat(i10);
                int i11 = format.width;
                if (i11 > 0 && (i7 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z4, i5, i6, i11, i7);
                    int i12 = format.width;
                    int i13 = format.height;
                    int i14 = i12 * i13;
                    if (i12 >= ((int) (((float) maxVideoSizeInViewport.x) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i13 >= ((int) (((float) maxVideoSizeInViewport.y) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i14 < i9) {
                        i9 = i14;
                    }
                }
            }
            if (i9 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i9) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean isSupported(int i5, boolean z4) {
        int i6 = i5 & 7;
        if (i6 != 4) {
            return z4 && i6 == 3;
        }
        return true;
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i5, AudioConfigurationTuple audioConfigurationTuple) {
        String str;
        if (!isSupported(i5, false) || format.channelCount != audioConfigurationTuple.channelCount || format.sampleRate != audioConfigurationTuple.sampleRate || ((str = audioConfigurationTuple.mimeType) != null && !TextUtils.equals(str, format.sampleMimeType))) {
            return false;
        }
        return true;
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, @Nullable String str, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        if (!isSupported(i5, false) || (i5 & i6) == 0 || ((str != null && !Util.areEqual(format.sampleMimeType, str)) || (((i10 = format.width) != -1 && i10 > i7) || (((i11 = format.height) != -1 && i11 > i8) || ((i12 = format.bitrate) != -1 && i12 > i9))))) {
            return false;
        }
        return true;
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i5) {
        boolean z4;
        if (i5 != 0) {
            boolean z5 = false;
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            while (true) {
                if (i6 >= mappedTrackInfo.getRendererCount()) {
                    z4 = true;
                    break;
                }
                int rendererType = mappedTrackInfo.getRendererType(i6);
                TrackSelection trackSelection = trackSelectionArr[i6];
                if ((rendererType == 1 || rendererType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i6], mappedTrackInfo.getTrackGroups(i6), trackSelection)) {
                    if (rendererType == 1) {
                        if (i8 != -1) {
                            break;
                        }
                        i8 = i6;
                    } else if (i7 != -1) {
                        break;
                    } else {
                        i7 = i6;
                    }
                }
                i6++;
            }
            z4 = false;
            if (!(i8 == -1 || i7 == -1)) {
                z5 = true;
            }
            if (z4 && z5) {
                RendererConfiguration rendererConfiguration = new RendererConfiguration(i5);
                rendererConfigurationArr[i8] = rendererConfiguration;
                rendererConfigurationArr[i7] = rendererConfiguration;
            }
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i5 = 0; i5 < trackSelection.length(); i5++) {
            if ((iArr[indexOf][trackSelection.getIndexInTrackGroup(i5)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static TrackSelection selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i5, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        int i6;
        boolean z4;
        if (parameters.allowNonSeamlessAdaptiveness) {
            i6 = 24;
        } else {
            i6 = 16;
        }
        int i7 = i6;
        if (!parameters.allowMixedMimeAdaptiveness || (i5 & i7) == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        for (int i8 = 0; i8 < trackGroupArray.length; i8++) {
            TrackGroup trackGroup = trackGroupArray.get(i8);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i8], z4, i7, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return ((TrackSelection.Factory) Assertions.checkNotNull(factory)).createTrackSelection(trackGroup, adaptiveVideoTracksForGroup);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0087, code lost:
        if (compareFormatValues(r2.bitrate, r10) < 0) goto L_0x008c;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection selectFixedVideoTrack(com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray r19, int[][] r20, com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.Parameters r21) {
        /*
            r0 = r19
            r1 = r21
            r4 = -1
            r9 = r4
            r10 = r9
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000b:
            int r11 = r0.length
            if (r5 >= r11) goto L_0x00c7
            com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup r11 = r0.get(r5)
            int r12 = r1.viewportWidth
            int r13 = r1.viewportHeight
            boolean r14 = r1.viewportOrientationMayChange
            java.util.List r12 = getViewportFilteredTrackIndices(r11, r12, r13, r14)
            r13 = r20[r5]
            r14 = 0
        L_0x0020:
            int r15 = r11.length
            if (r14 >= r15) goto L_0x00be
            r15 = r13[r14]
            r16 = 0
            boolean r2 = r1.exceedRendererCapabilitiesIfNecessary
            boolean r2 = isSupported(r15, r2)
            if (r2 == 0) goto L_0x00b7
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = r11.getFormat(r14)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r14)
            boolean r15 = r12.contains(r15)
            r17 = 1
            if (r15 == 0) goto L_0x005b
            int r15 = r2.width
            if (r15 == r4) goto L_0x0048
            int r3 = r1.maxVideoWidth
            if (r15 > r3) goto L_0x005b
        L_0x0048:
            int r3 = r2.height
            if (r3 == r4) goto L_0x0050
            int r15 = r1.maxVideoHeight
            if (r3 > r15) goto L_0x005b
        L_0x0050:
            int r3 = r2.bitrate
            if (r3 == r4) goto L_0x0058
            int r15 = r1.maxVideoBitrate
            if (r3 > r15) goto L_0x005b
        L_0x0058:
            r3 = r17
            goto L_0x005c
        L_0x005b:
            r3 = 0
        L_0x005c:
            if (r3 != 0) goto L_0x0063
            boolean r15 = r1.exceedVideoConstraintsIfNecessary
            if (r15 != 0) goto L_0x0063
            goto L_0x00b7
        L_0x0063:
            if (r3 == 0) goto L_0x0067
            r15 = 2
            goto L_0x0069
        L_0x0067:
            r15 = r17
        L_0x0069:
            r4 = r13[r14]
            r0 = 0
            boolean r4 = isSupported(r4, r0)
            if (r4 == 0) goto L_0x0074
            int r15 = r15 + 1000
        L_0x0074:
            if (r15 <= r8) goto L_0x0079
            r18 = r17
            goto L_0x007b
        L_0x0079:
            r18 = r0
        L_0x007b:
            if (r15 != r8) goto L_0x00aa
            boolean r0 = r1.forceLowestBitrate
            if (r0 == 0) goto L_0x008f
            int r0 = r2.bitrate
            int r0 = compareFormatValues(r0, r10)
            if (r0 >= 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r17 = 0
        L_0x008c:
            r18 = r17
            goto L_0x00aa
        L_0x008f:
            int r0 = r2.getPixelCount()
            if (r0 == r9) goto L_0x009a
            int r0 = compareFormatValues(r0, r9)
            goto L_0x00a0
        L_0x009a:
            int r0 = r2.bitrate
            int r0 = compareFormatValues(r0, r10)
        L_0x00a0:
            if (r4 == 0) goto L_0x00a7
            if (r3 == 0) goto L_0x00a7
            if (r0 <= 0) goto L_0x008a
            goto L_0x008c
        L_0x00a7:
            if (r0 >= 0) goto L_0x008a
            goto L_0x008c
        L_0x00aa:
            if (r18 == 0) goto L_0x00b7
            int r0 = r2.bitrate
            int r2 = r2.getPixelCount()
            r10 = r0
            r9 = r2
            r6 = r11
            r7 = r14
            r8 = r15
        L_0x00b7:
            int r14 = r14 + 1
            r0 = r19
            r4 = -1
            goto L_0x0020
        L_0x00be:
            r16 = 0
            int r5 = r5 + 1
            r0 = r19
            r4 = -1
            goto L_0x000b
        L_0x00c7:
            r16 = 0
            if (r6 != 0) goto L_0x00cc
            return r16
        L_0x00cc:
            com.mbridge.msdk.playercommon.exoplayer2.trackselection.FixedTrackSelection r0 = new com.mbridge.msdk.playercommon.exoplayer2.trackselection.FixedTrackSelection
            r0.<init>(r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.selectFixedVideoTrack(com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray, int[][], com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection");
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    @Deprecated
    public final void clearSelectionOverride(int i5, TrackGroupArray trackGroupArray) {
        setParameters(buildUponParameters().clearSelectionOverride(i5, trackGroupArray));
    }

    @Deprecated
    public final void clearSelectionOverrides(int i5) {
        setParameters(buildUponParameters().clearSelectionOverrides(i5));
    }

    public Parameters getParameters() {
        return this.parametersReference.get();
    }

    @Deprecated
    public final boolean getRendererDisabled(int i5) {
        return getParameters().getRendererDisabled(i5);
    }

    @Deprecated
    @Nullable
    public final SelectionOverride getSelectionOverride(int i5, TrackGroupArray trackGroupArray) {
        return getParameters().getSelectionOverride(i5, trackGroupArray);
    }

    @Deprecated
    public final boolean hasSelectionOverride(int i5, TrackGroupArray trackGroupArray) {
        return getParameters().hasSelectionOverride(i5, trackGroupArray);
    }

    /* access modifiers changed from: protected */
    public TrackSelection[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        TrackSelection.Factory factory;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        int rendererCount = mappedTrackInfo2.getRendererCount();
        TrackSelection[] trackSelectionArr = new TrackSelection[rendererCount];
        boolean z4 = false;
        int i5 = 0;
        boolean z5 = false;
        while (true) {
            boolean z6 = true;
            if (i5 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo2.getRendererType(i5)) {
                if (!z4) {
                    TrackSelection selectVideoTrack = selectVideoTrack(mappedTrackInfo2.getTrackGroups(i5), iArr[i5], iArr2[i5], parameters, this.adaptiveTrackSelectionFactory);
                    trackSelectionArr[i5] = selectVideoTrack;
                    if (selectVideoTrack != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    Parameters parameters2 = parameters;
                }
                if (mappedTrackInfo2.getTrackGroups(i5).length <= 0) {
                    z6 = false;
                }
                z5 |= z6;
            } else {
                Parameters parameters3 = parameters;
            }
            i5++;
        }
        boolean z7 = false;
        int i6 = 0;
        boolean z8 = false;
        while (true) {
            Parameters parameters4 = parameters;
            if (i6 >= rendererCount) {
                return trackSelectionArr;
            }
            int rendererType = mappedTrackInfo2.getRendererType(i6);
            if (rendererType != 1) {
                if (rendererType != 2) {
                    if (rendererType != 3) {
                        trackSelectionArr[i6] = selectOtherTrack(rendererType, mappedTrackInfo2.getTrackGroups(i6), iArr[i6], parameters4);
                    } else if (!z8) {
                        TrackSelection selectTextTrack = selectTextTrack(mappedTrackInfo2.getTrackGroups(i6), iArr[i6], parameters4);
                        trackSelectionArr[i6] = selectTextTrack;
                        if (selectTextTrack != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                    }
                }
            } else if (!z7) {
                TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i6);
                int[][] iArr3 = iArr[i6];
                int i7 = iArr2[i6];
                if (z5) {
                    factory = null;
                } else {
                    factory = this.adaptiveTrackSelectionFactory;
                }
                TrackSelection selectAudioTrack = selectAudioTrack(trackGroups, iArr3, i7, parameters4, factory);
                trackSelectionArr[i6] = selectAudioTrack;
                if (selectAudioTrack != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            i6++;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i5, Parameters parameters, @Nullable TrackSelection.Factory factory) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        TrackSelection.Factory factory2 = factory;
        int i6 = -1;
        int i7 = -1;
        AudioTrackScore audioTrackScore = null;
        for (int i8 = 0; i8 < trackGroupArray2.length; i8++) {
            TrackGroup trackGroup = trackGroupArray2.get(i8);
            int[] iArr2 = iArr[i8];
            for (int i9 = 0; i9 < trackGroup.length; i9++) {
                if (isSupported(iArr2[i9], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i9), parameters2, iArr2[i9]);
                    if (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0) {
                        i6 = i8;
                        i7 = i9;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i6 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray2.get(i6);
        if (!parameters2.forceLowestBitrate && factory2 != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i6], parameters2.allowMixedMimeAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                return factory2.createTrackSelection(trackGroup2, adaptiveAudioTracks);
            }
        }
        return new FixedTrackSelection(trackGroup2, i7);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectOtherTrack(int i5, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < trackGroupArray.length; i8++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i8);
            int[] iArr2 = iArr[i8];
            for (int i9 = 0; i9 < trackGroup2.length; i9++) {
                if (isSupported(iArr2[i9], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i10 = 1;
                    if ((trackGroup2.getFormat(i9).selectionFlags & 1) != 0) {
                        i10 = 2;
                    }
                    if (isSupported(iArr2[i9], false)) {
                        i10 += 1000;
                    }
                    if (i10 > i7) {
                        trackGroup = trackGroup2;
                        i6 = i9;
                        i7 = i10;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i6);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        boolean z4;
        boolean z5;
        int i5;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i6 = 0;
        int i7 = 0;
        TrackGroup trackGroup = null;
        for (int i8 = 0; i8 < trackGroupArray2.length; i8++) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i8);
            int[] iArr2 = iArr[i8];
            for (int i9 = 0; i9 < trackGroup2.length; i9++) {
                if (isSupported(iArr2[i9], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i9);
                    int i10 = format.selectionFlags & (~parameters2.disabledTextTrackSelectionFlags);
                    int i11 = 1;
                    if ((i10 & 1) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if ((i10 & 2) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean formatHasLanguage = formatHasLanguage(format, parameters2.preferredTextLanguage);
                    if (formatHasLanguage || (parameters2.selectUndeterminedTextLanguage && formatHasNoLanguage(format))) {
                        if (z4) {
                            i5 = 8;
                        } else if (!z5) {
                            i5 = 6;
                        } else {
                            i5 = 4;
                        }
                        i11 = i5 + (formatHasLanguage ? 1 : 0);
                    } else if (z4) {
                        i11 = 3;
                    } else if (z5) {
                        if (formatHasLanguage(format, parameters2.preferredAudioLanguage)) {
                            i11 = 2;
                        }
                    }
                    if (isSupported(iArr2[i9], false)) {
                        i11 += 1000;
                    }
                    if (i11 > i7) {
                        trackGroup = trackGroup2;
                        i6 = i9;
                        i7 = i11;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i6);
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException {
        RendererConfiguration rendererConfiguration;
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        for (int i5 = 0; i5 < rendererCount; i5++) {
            if (parameters.getRendererDisabled(i5)) {
                selectAllTracks[i5] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i5);
                if (parameters.hasSelectionOverride(i5, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i5, trackGroups);
                    if (selectionOverride == null) {
                        selectAllTracks[i5] = null;
                    } else if (selectionOverride.length == 1) {
                        selectAllTracks[i5] = new FixedTrackSelection(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks[0]);
                    } else {
                        selectAllTracks[i5] = ((TrackSelection.Factory) Assertions.checkNotNull(this.adaptiveTrackSelectionFactory)).createTrackSelection(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks);
                    }
                }
            }
        }
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i6 = 0; i6 < rendererCount; i6++) {
            if (parameters.getRendererDisabled(i6) || (mappedTrackInfo.getRendererType(i6) != 5 && selectAllTracks[i6] == null)) {
                rendererConfiguration = null;
            } else {
                rendererConfiguration = RendererConfiguration.DEFAULT;
            }
            rendererConfigurationArr[i6] = rendererConfiguration;
        }
        maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, selectAllTracks, parameters.tunnelingAudioSessionId);
        return Pair.create(rendererConfigurationArr, selectAllTracks);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i5, Parameters parameters, @Nullable TrackSelection.Factory factory) throws ExoPlaybackException {
        TrackSelection trackSelection;
        if (parameters.forceLowestBitrate || factory == null) {
            trackSelection = null;
        } else {
            trackSelection = selectAdaptiveVideoTrack(trackGroupArray, iArr, i5, parameters, factory);
        }
        if (trackSelection == null) {
            return selectFixedVideoTrack(trackGroupArray, iArr, parameters);
        }
        return trackSelection;
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.parametersReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    @Deprecated
    public final void setRendererDisabled(int i5, boolean z4) {
        setParameters(buildUponParameters().setRendererDisabled(i5, z4));
    }

    @Deprecated
    public final void setSelectionOverride(int i5, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
        setParameters(buildUponParameters().setSelectionOverride(i5, trackGroupArray, selectionOverride));
    }

    @Deprecated
    public void setTunnelingAudioSessionId(int i5) {
        setParameters(buildUponParameters().setTunnelingAudioSessionId(i5));
    }

    public DefaultTrackSelector(BandwidthMeter bandwidthMeter) {
        this((TrackSelection.Factory) new AdaptiveTrackSelection.Factory(bandwidthMeter));
    }

    @Deprecated
    public final void clearSelectionOverrides() {
        setParameters(buildUponParameters().clearSelectionOverrides());
    }

    public DefaultTrackSelector(@Nullable TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(Parameters.DEFAULT);
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            public final SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            public final SelectionOverride[] newArray(int i5) {
                return new SelectionOverride[i5];
            }
        };
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(int i5, int... iArr) {
            this.groupIndex = i5;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            Arrays.sort(copyOf);
        }

        public final boolean containsTrack(int i5) {
            for (int i6 : this.tracks) {
                if (i6 == i5) {
                    return true;
                }
            }
            return false;
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SelectionOverride.class == obj.getClass()) {
                SelectionOverride selectionOverride = (SelectionOverride) obj;
                if (this.groupIndex != selectionOverride.groupIndex || !Arrays.equals(this.tracks, selectionOverride.tracks)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.groupIndex * 31) + Arrays.hashCode(this.tracks);
        }

        public final void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
        }

        SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int readByte = parcel.readByte();
            this.length = readByte;
            int[] iArr = new int[readByte];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
        }
    }
}
