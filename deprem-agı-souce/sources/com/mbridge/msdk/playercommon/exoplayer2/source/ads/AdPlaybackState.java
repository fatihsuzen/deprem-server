package com.mbridge.msdk.playercommon.exoplayer2.source.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        @CheckResult
        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i5) {
            int length = jArr.length;
            int max = Math.max(i5, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C.TIME_UNSET);
            return copyOf;
        }

        @CheckResult
        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i5) {
            int length = iArr.length;
            int max = Math.max(i5, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public final int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public final int getNextAdIndexToPlay(int i5) {
            int i6;
            int i7 = i5 + 1;
            while (true) {
                int[] iArr = this.states;
                if (i7 >= iArr.length || (i6 = iArr[i7]) == 0 || i6 == 1) {
                    return i7;
                }
                i7++;
            }
            return i7;
        }

        public final boolean hasUnplayedAds() {
            if (this.count == -1 || getFirstAdIndexToPlay() < this.count) {
                return true;
            }
            return false;
        }

        @CheckResult
        public final AdGroup withAdCount(int i5) {
            boolean z4;
            if (this.count != -1 || this.states.length > i5) {
                z4 = false;
            } else {
                z4 = true;
            }
            Assertions.checkArgument(z4);
            return new AdGroup(i5, copyStatesWithSpaceForAdCount(this.states, i5), (Uri[]) Arrays.copyOf(this.uris, i5), copyDurationsUsWithSpaceForAdCount(this.durationsUs, i5));
        }

        @CheckResult
        public final AdGroup withAdDurationsUs(long[] jArr) {
            boolean z4;
            if (this.count == -1 || jArr.length <= this.uris.length) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        @CheckResult
        public final AdGroup withAdState(int i5, int i6) {
            boolean z4;
            int i7 = this.count;
            boolean z5 = false;
            if (i7 == -1 || i6 < i7) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i6 + 1);
            int i8 = copyStatesWithSpaceForAdCount[i6];
            if (i8 == 0 || i8 == 1 || i8 == i5) {
                z5 = true;
            }
            Assertions.checkArgument(z5);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = this.uris;
            if (uriArr.length != copyStatesWithSpaceForAdCount.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, copyStatesWithSpaceForAdCount.length);
            }
            copyStatesWithSpaceForAdCount[i6] = i5;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public final AdGroup withAdUri(Uri uri, int i5) {
            boolean z4;
            int i6 = this.count;
            boolean z5 = false;
            if (i6 == -1 || i5 < i6) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i5 + 1);
            if (copyStatesWithSpaceForAdCount[i5] == 0) {
                z5 = true;
            }
            Assertions.checkArgument(z5);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            uriArr[i5] = uri;
            copyStatesWithSpaceForAdCount[i5] = 1;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public final AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = copyOf[i5];
                if (i6 == 1 || i6 == 0) {
                    copyOf[i5] = 2;
                }
            }
            return new AdGroup(length, copyOf, this.uris, this.durationsUs);
        }

        private AdGroup(int i5, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i5;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(jArr, length);
        this.adGroups = new AdGroup[length];
        for (int i5 = 0; i5 < length; i5++) {
            this.adGroups[i5] = new AdGroup();
        }
        this.adResumePositionUs = 0;
        this.contentDurationUs = C.TIME_UNSET;
    }

    public final int getAdGroupIndexAfterPositionUs(long j5) {
        int i5 = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i5 >= jArr.length) {
                break;
            }
            long j6 = jArr[i5];
            if (j6 == Long.MIN_VALUE || (j5 < j6 && this.adGroups[i5].hasUnplayedAds())) {
                break;
            }
            i5++;
        }
        if (i5 < this.adGroupTimesUs.length) {
            return i5;
        }
        return -1;
    }

    public final int getAdGroupIndexForPositionUs(long j5) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0) {
            long j6 = this.adGroupTimesUs[length];
            if (j6 != Long.MIN_VALUE && j6 <= j5) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    @CheckResult
    public final AdPlaybackState withAdCount(int i5, int i6) {
        boolean z4;
        if (i6 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i5].count == i6) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = this.adGroups[i5].withAdCount(i6);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        for (int i5 = 0; i5 < this.adGroupCount; i5++) {
            adGroupArr2[i5] = adGroupArr2[i5].withAdDurationsUs(jArr[i5]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdLoadError(int i5, int i6) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].withAdState(4, i6);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdResumePositionUs(long j5) {
        if (this.adResumePositionUs == j5) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, j5, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdUri(int i5, int i6, Uri uri) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].withAdUri(uri, i6);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withContentDurationUs(long j5) {
        if (this.contentDurationUs == j5) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j5);
    }

    @CheckResult
    public final AdPlaybackState withPlayedAd(int i5, int i6) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].withAdState(3, i6);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withSkippedAd(int i5, int i6) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].withAdState(2, i6);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withSkippedAdGroup(int i5) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    private AdPlaybackState(long[] jArr, AdGroup[] adGroupArr, long j5, long j6) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j5;
        this.contentDurationUs = j6;
    }
}
