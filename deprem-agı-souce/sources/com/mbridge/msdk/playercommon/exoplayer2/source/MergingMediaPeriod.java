package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    public final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap<>();
    }

    public final boolean continueLoading(long j5) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j5);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.childrenPendingPreparation.get(i5).continueLoading(j5);
        }
        return false;
    }

    public final void discardBuffer(long j5, boolean z4) {
        for (MediaPeriod discardBuffer : this.enabledPeriods) {
            discardBuffer.discardBuffer(j5, z4);
        }
    }

    public final long getAdjustedSeekPositionUs(long j5, SeekParameters seekParameters) {
        return this.enabledPeriods[0].getAdjustedSeekPositionUs(j5, seekParameters);
    }

    public final long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public final long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public final void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod maybeThrowPrepareError : this.periods) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i5 = 0;
            for (MediaPeriod trackGroups2 : this.periods) {
                i5 += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i5];
            int i6 = 0;
            for (MediaPeriod trackGroups3 : this.periods) {
                TrackGroupArray trackGroups4 = trackGroups3.getTrackGroups();
                int i7 = trackGroups4.length;
                int i8 = 0;
                while (i8 < i7) {
                    trackGroupArr[i6] = trackGroups4.get(i8);
                    i8++;
                    i6++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    public final void prepare(MediaPeriod.Callback callback2, long j5) {
        this.callback = callback2;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod prepare : this.periods) {
            prepare.prepare(this, j5);
        }
    }

    public final long readDiscontinuity() {
        long readDiscontinuity = this.periods[0].readDiscontinuity();
        int i5 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.periods;
            if (i5 >= mediaPeriodArr.length) {
                if (readDiscontinuity != C.TIME_UNSET) {
                    MediaPeriod[] mediaPeriodArr2 = this.enabledPeriods;
                    int length = mediaPeriodArr2.length;
                    int i6 = 0;
                    while (i6 < length) {
                        MediaPeriod mediaPeriod = mediaPeriodArr2[i6];
                        if (mediaPeriod == this.periods[0] || mediaPeriod.seekToUs(readDiscontinuity) == readDiscontinuity) {
                            i6++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                }
                return readDiscontinuity;
            } else if (mediaPeriodArr[i5].readDiscontinuity() == C.TIME_UNSET) {
                i5++;
            } else {
                throw new IllegalStateException("Child reported discontinuity.");
            }
        }
    }

    public final void reevaluateBuffer(long j5) {
        this.compositeSequenceableLoader.reevaluateBuffer(j5);
    }

    public final long seekToUs(long j5) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j5);
        int i5 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i5 >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i5].seekToUs(seekToUs) == seekToUs) {
                i5++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j5) {
        boolean z4;
        SampleStream sampleStream;
        int i5;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i6 = 0; i6 < trackSelectionArr2.length; i6++) {
            SampleStream sampleStream2 = sampleStreamArr2[i6];
            if (sampleStream2 == null) {
                i5 = -1;
            } else {
                i5 = this.streamPeriodIndices.get(sampleStream2).intValue();
            }
            iArr[i6] = i5;
            iArr2[i6] = -1;
            TrackSelection trackSelection = trackSelectionArr2[i6];
            if (trackSelection != null) {
                TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i7 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i7 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i7].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i6] = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
        }
        this.streamPeriodIndices.clear();
        int length = trackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j6 = j5;
        int i8 = 0;
        while (i8 < this.periods.length) {
            for (int i9 = 0; i9 < trackSelectionArr2.length; i9++) {
                TrackSelection trackSelection2 = null;
                if (iArr[i9] == i8) {
                    sampleStream = sampleStreamArr2[i9];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr4[i9] = sampleStream;
                if (iArr2[i9] == i8) {
                    trackSelection2 = trackSelectionArr2[i9];
                }
                trackSelectionArr3[i9] = trackSelection2;
            }
            int i10 = i8;
            long selectTracks = this.periods[i8].selectTracks(trackSelectionArr3, zArr, sampleStreamArr4, zArr2, j6);
            if (i10 == 0) {
                j6 = selectTracks;
            } else if (selectTracks != j6) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            int i11 = 0;
            boolean z5 = false;
            while (i11 < trackSelectionArr2.length) {
                boolean z6 = true;
                if (iArr2[i11] == i10) {
                    if (sampleStreamArr4[i11] != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Assertions.checkState(z4);
                    sampleStreamArr3[i11] = sampleStreamArr4[i11];
                    this.streamPeriodIndices.put(sampleStreamArr4[i11], Integer.valueOf(i10));
                    z5 = true;
                } else if (iArr[i11] == i10) {
                    if (sampleStreamArr4[i11] != null) {
                        z6 = false;
                    }
                    Assertions.checkState(z6);
                }
                i11++;
                trackSelectionArr2 = trackSelectionArr;
            }
            if (z5) {
                arrayList.add(this.periods[i10]);
            }
            i8 = i10 + 1;
            trackSelectionArr2 = trackSelectionArr;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        MediaPeriod[] mediaPeriodArr2 = new MediaPeriod[arrayList.size()];
        this.enabledPeriods = mediaPeriodArr2;
        arrayList.toArray(mediaPeriodArr2);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j6;
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}
