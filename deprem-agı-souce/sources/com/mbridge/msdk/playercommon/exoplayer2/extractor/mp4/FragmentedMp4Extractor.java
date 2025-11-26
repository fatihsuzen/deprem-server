package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.cea.CeaUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class FragmentedMp4Extractor implements Extractor {
    private static final Format EMSG_FORMAT = Format.createSampleFormat((String) null, MimeTypes.APPLICATION_EMSG, Long.MAX_VALUE);
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new FragmentedMp4Extractor()};
        }
    };
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    private static final int FLAG_SIDELOADED = 8;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final int SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString("seig");
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    @Nullable
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] cea608TrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final byte[] extendedTypeScratch;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private long segmentIndexEarliestPresentationTimeUs;
    @Nullable
    private final DrmInitData sideloadedDrmInitData;
    @Nullable
    private final Track sideloadedTrack;
    @Nullable
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j5, int i5) {
            this.presentationTimeDeltaUs = j5;
            this.size = i5;
        }
    }

    private static final class TrackBundle {
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();
        public DefaultSampleValues defaultSampleValues;
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        public int firstSampleToOutputIndex;
        public final TrackFragment fragment = new TrackFragment();
        public final TrackOutput output;
        public Track track;

        public TrackBundle(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private TrackEncryptionBox getEncryptionBox() {
            TrackFragment trackFragment = this.fragment;
            int i5 = trackFragment.header.sampleDescriptionIndex;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox != null) {
                return trackEncryptionBox;
            }
            return this.track.getSampleDescriptionEncryptionBox(i5);
        }

        /* access modifiers changed from: private */
        public void skipSampleEncryptionData() {
            TrackFragment trackFragment = this.fragment;
            if (trackFragment.definesEncryptionData) {
                ParsableByteArray parsableByteArray = trackFragment.sampleEncryptionData;
                int i5 = getEncryptionBox().initializationVectorSize;
                if (i5 != 0) {
                    parsableByteArray.skipBytes(i5);
                }
                if (this.fragment.sampleHasSubsampleEncryptionTable[this.currentSampleIndex]) {
                    parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
                }
            }
        }

        public final void init(Track track2, DefaultSampleValues defaultSampleValues2) {
            this.track = (Track) Assertions.checkNotNull(track2);
            this.defaultSampleValues = (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValues2);
            this.output.format(track2.format);
            reset();
        }

        public final boolean next() {
            this.currentSampleIndex++;
            int i5 = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i5;
            int[] iArr = this.fragment.trunLength;
            int i6 = this.currentTrackRunIndex;
            if (i5 != iArr[i6]) {
                return true;
            }
            this.currentTrackRunIndex = i6 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public final int outputSampleEncryptionData() {
            ParsableByteArray parsableByteArray;
            int i5;
            if (!this.fragment.definesEncryptionData) {
                return 0;
            }
            TrackEncryptionBox encryptionBox = getEncryptionBox();
            int i6 = encryptionBox.initializationVectorSize;
            if (i6 != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
            } else {
                byte[] bArr = encryptionBox.defaultInitializationVector;
                this.defaultInitializationVector.reset(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
                i6 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean z4 = this.fragment.sampleHasSubsampleEncryptionTable[this.currentSampleIndex];
            ParsableByteArray parsableByteArray3 = this.encryptionSignalByte;
            byte[] bArr2 = parsableByteArray3.data;
            if (z4) {
                i5 = 128;
            } else {
                i5 = 0;
            }
            bArr2[0] = (byte) (i5 | i6);
            parsableByteArray3.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1);
            this.output.sampleData(parsableByteArray, i6);
            if (!z4) {
                return i6 + 1;
            }
            ParsableByteArray parsableByteArray4 = this.fragment.sampleEncryptionData;
            int readUnsignedShort = parsableByteArray4.readUnsignedShort();
            parsableByteArray4.skipBytes(-2);
            int i7 = (readUnsignedShort * 6) + 2;
            this.output.sampleData(parsableByteArray4, i7);
            return i6 + 1 + i7;
        }

        public final void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
        }

        public final void seek(long j5) {
            long usToMs = C.usToMs(j5);
            int i5 = this.currentSampleIndex;
            while (true) {
                TrackFragment trackFragment = this.fragment;
                if (i5 < trackFragment.sampleCount && trackFragment.getSamplePresentationTime(i5) < usToMs) {
                    if (this.fragment.sampleIsSyncFrameTable[i5]) {
                        this.firstSampleToOutputIndex = i5;
                    }
                    i5++;
                } else {
                    return;
                }
            }
        }

        public final void updateDrmInitData(DrmInitData drmInitData) {
            String str;
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            if (sampleDescriptionEncryptionBox != null) {
                str = sampleDescriptionEncryptionBox.schemeType;
            } else {
                str = null;
            }
            this.output.format(this.track.format.copyWithDrmInitData(drmInitData.copyWithSchemeType(str)));
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> sparseArray, int i5) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.checkNotNull(sparseArray.get(i5));
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < size; i5++) {
            Atom.LeafAtom leafAtom = list.get(i5);
            if (leafAtom.type == Atom.TYPE_pssh) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = leafAtom.data.data;
                UUID parseUuid = PsshAtomUtil.parseUuid(bArr);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    private static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j5 = Long.MAX_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            TrackBundle valueAt = sparseArray.valueAt(i5);
            int i6 = valueAt.currentTrackRunIndex;
            TrackFragment trackFragment = valueAt.fragment;
            if (i6 != trackFragment.trunCount) {
                long j6 = trackFragment.trunDataPosition[i6];
                if (j6 < j5) {
                    trackBundle = valueAt;
                    j5 = j6;
                }
            }
        }
        return trackBundle;
    }

    @Nullable
    private static TrackBundle getTrackBundle(SparseArray<TrackBundle> sparseArray, int i5) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i5);
    }

    private void maybeInitExtraTracks() {
        int i5;
        if (this.emsgTrackOutputs == null) {
            TrackOutput[] trackOutputArr = new TrackOutput[2];
            this.emsgTrackOutputs = trackOutputArr;
            TrackOutput trackOutput = this.additionalEmsgTrackOutput;
            if (trackOutput != null) {
                trackOutputArr[0] = trackOutput;
                i5 = 1;
            } else {
                i5 = 0;
            }
            if ((this.flags & 4) != 0) {
                trackOutputArr[i5] = this.extractorOutput.track(this.trackBundles.size(), 4);
                i5++;
            }
            TrackOutput[] trackOutputArr2 = (TrackOutput[]) Arrays.copyOf(this.emsgTrackOutputs, i5);
            this.emsgTrackOutputs = trackOutputArr2;
            for (TrackOutput format : trackOutputArr2) {
                format.format(EMSG_FORMAT);
            }
        }
        if (this.cea608TrackOutputs == null) {
            this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
            for (int i6 = 0; i6 < this.cea608TrackOutputs.length; i6++) {
                TrackOutput track = this.extractorOutput.track(this.trackBundles.size() + 1 + i6, 3);
                track.format(this.closedCaptionFormats.get(i6));
                this.cea608TrackOutputs[i6] = track;
            }
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i5 = containerAtom.type;
        if (i5 == Atom.TYPE_moov) {
            onMoovContainerAtomRead(containerAtom);
        } else if (i5 == Atom.TYPE_moof) {
            onMoofContainerAtomRead(containerAtom);
        } else if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        TrackOutput[] trackOutputArr = this.emsgTrackOutputs;
        if (trackOutputArr != null && trackOutputArr.length != 0) {
            parsableByteArray.setPosition(12);
            int bytesLeft = parsableByteArray.bytesLeft();
            parsableByteArray.readNullTerminatedString();
            parsableByteArray.readNullTerminatedString();
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000, parsableByteArray.readUnsignedInt());
            for (TrackOutput sampleData : this.emsgTrackOutputs) {
                parsableByteArray.setPosition(12);
                sampleData.sampleData(parsableByteArray, bytesLeft);
            }
            long j5 = this.segmentIndexEarliestPresentationTimeUs;
            if (j5 != C.TIME_UNSET) {
                long j6 = j5 + scaleLargeTimestamp;
                TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
                if (timestampAdjuster2 != null) {
                    j6 = timestampAdjuster2.adjustSampleTimestamp(j6);
                }
                long j7 = j6;
                for (TrackOutput sampleMetadata : this.emsgTrackOutputs) {
                    sampleMetadata.sampleMetadata(j7, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
                }
                return;
            }
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
            this.pendingMetadataSampleBytes += bytesLeft;
        }
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j5) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
            return;
        }
        int i5 = leafAtom.type;
        if (i5 == Atom.TYPE_sidx) {
            Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j5);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) parseSidx.second);
            this.haveOutputSeekMap = true;
        } else if (i5 == Atom.TYPE_emsg) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        DrmInitData drmInitData;
        parseMoof(containerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
        if (this.sideloadedDrmInitData != null) {
            drmInitData = null;
        } else {
            drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        if (drmInitData != null) {
            int size = this.trackBundles.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.trackBundles.valueAt(i5).updateDrmInitData(drmInitData);
            }
        }
        if (this.pendingSeekTimeUs != C.TIME_UNSET) {
            int size2 = this.trackBundles.size();
            for (int i6 = 0; i6 < size2; i6++) {
                this.trackBundles.valueAt(i6).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = C.TIME_UNSET;
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z4;
        boolean z5;
        int i5 = 0;
        boolean z6 = true;
        if (this.sideloadedTrack == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4, "Unexpected moov box.");
        DrmInitData drmInitData = this.sideloadedDrmInitData;
        if (drmInitData == null) {
            drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        DrmInitData drmInitData2 = drmInitData;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
        SparseArray sparseArray = new SparseArray();
        int size = containerAtomOfType.leafChildren.size();
        long j5 = -9223372036854775807L;
        for (int i6 = 0; i6 < size; i6++) {
            Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i6);
            int i7 = leafAtom.type;
            if (i7 == Atom.TYPE_trex) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), parseTrex.second);
            } else if (i7 == Atom.TYPE_mehd) {
                j5 = parseMehd(leafAtom.data);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = containerAtom.containerChildren.size();
        for (int i8 = 0; i8 < size2; i8++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i8);
            if (containerAtom2.type == Atom.TYPE_trak) {
                Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
                if ((this.flags & 16) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Track parseTrak = AtomParsers.parseTrak(containerAtom2, leafAtomOfType, j5, drmInitData2, z5, false);
                if (parseTrak != null) {
                    sparseArray2.put(parseTrak.id, parseTrak);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.trackBundles.size() == 0) {
            while (i5 < size3) {
                Track track = (Track) sparseArray2.valueAt(i5);
                TrackBundle trackBundle = new TrackBundle(this.extractorOutput.track(i5, track.type));
                trackBundle.init(track, getDefaultSampleValues(sparseArray, track.id));
                this.trackBundles.put(track.id, trackBundle);
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i5++;
            }
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
            return;
        }
        if (this.trackBundles.size() != size3) {
            z6 = false;
        }
        Assertions.checkState(z6);
        while (i5 < size3) {
            Track track2 = (Track) sparseArray2.valueAt(i5);
            this.trackBundles.get(track2.id).init(track2, getDefaultSampleValues(sparseArray, track2.id));
            i5++;
        }
    }

    private void outputPendingMetadataSamples(long j5) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= removeFirst.size;
            long j6 = removeFirst.presentationTimeDeltaUs + j5;
            TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
            if (timestampAdjuster2 != null) {
                j6 = timestampAdjuster2.adjustSampleTimestamp(j6);
            }
            long j7 = j6;
            for (TrackOutput sampleMetadata : this.emsgTrackOutputs) {
                sampleMetadata.sampleMetadata(j7, 1, removeFirst.size, this.pendingMetadataSampleBytes, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            return parsableByteArray.readUnsignedInt();
        }
        return parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i5, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i6);
            if (containerAtom2.type == Atom.TYPE_traf) {
                parseTraf(containerAtom2, sparseArray, i5, bArr);
            }
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        long j5;
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 1) {
            int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt);
            long j6 = trackFragment.auxiliaryDataPosition;
            if (parseFullAtomVersion == 0) {
                j5 = parsableByteArray.readUnsignedInt();
            } else {
                j5 = parsableByteArray.readUnsignedLongToLong();
            }
            trackFragment.auxiliaryDataPosition = j6 + j5;
            return;
        }
        throw new ParserException("Unexpected saio entry count: " + readUnsignedIntToInt);
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i5;
        boolean z4;
        int i6 = trackEncryptionBox.initializationVectorSize;
        parsableByteArray.setPosition(8);
        boolean z5 = true;
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == trackFragment.sampleCount) {
            if (readUnsignedByte == 0) {
                boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                i5 = 0;
                for (int i7 = 0; i7 < readUnsignedIntToInt; i7++) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    i5 += readUnsignedByte2;
                    if (readUnsignedByte2 > i6) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zArr[i7] = z4;
                }
            } else {
                if (readUnsignedByte <= i6) {
                    z5 = false;
                }
                i5 = readUnsignedByte * readUnsignedIntToInt;
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z5);
            }
            trackFragment.initEncryptionData(i5);
            return;
        }
        throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSgpd(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, String str, TrackFragment trackFragment) throws ParserException {
        boolean z4;
        byte[] bArr;
        ParsableByteArray parsableByteArray3 = parsableByteArray;
        ParsableByteArray parsableByteArray4 = parsableByteArray2;
        TrackFragment trackFragment2 = trackFragment;
        parsableByteArray3.setPosition(8);
        int readInt = parsableByteArray3.readInt();
        int readInt2 = parsableByteArray3.readInt();
        int i5 = SAMPLE_GROUP_TYPE_seig;
        if (readInt2 == i5) {
            if (Atom.parseFullAtomVersion(readInt) == 1) {
                parsableByteArray3.skipBytes(4);
            }
            if (parsableByteArray3.readInt() == 1) {
                parsableByteArray4.setPosition(8);
                int readInt3 = parsableByteArray4.readInt();
                if (parsableByteArray4.readInt() == i5) {
                    int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt3);
                    if (parseFullAtomVersion == 1) {
                        if (parsableByteArray4.readUnsignedInt() == 0) {
                            throw new ParserException("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (parseFullAtomVersion >= 2) {
                        parsableByteArray4.skipBytes(4);
                    }
                    if (parsableByteArray4.readUnsignedInt() == 1) {
                        parsableByteArray4.skipBytes(1);
                        int readUnsignedByte = parsableByteArray4.readUnsignedByte();
                        int i6 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                        int i7 = readUnsignedByte & 15;
                        if (parsableByteArray4.readUnsignedByte() == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            int readUnsignedByte2 = parsableByteArray4.readUnsignedByte();
                            byte[] bArr2 = new byte[16];
                            parsableByteArray4.readBytes(bArr2, 0, 16);
                            if (!z4 || readUnsignedByte2 != 0) {
                                bArr = null;
                            } else {
                                int readUnsignedByte3 = parsableByteArray4.readUnsignedByte();
                                bArr = new byte[readUnsignedByte3];
                                parsableByteArray4.readBytes(bArr, 0, readUnsignedByte3);
                            }
                            byte[] bArr3 = bArr;
                            trackFragment2.definesEncryptionData = true;
                            trackFragment2.trackEncryptionBox = new TrackEncryptionBox(z4, str, readUnsignedByte2, bArr2, i6, i7, bArr3);
                            return;
                        }
                        return;
                    }
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j5) throws ParserException {
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray2.readInt());
        parsableByteArray2.skipBytes(4);
        long readUnsignedInt = parsableByteArray2.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            readUnsignedLongToLong = parsableByteArray2.readUnsignedInt();
            readUnsignedLongToLong2 = parsableByteArray2.readUnsignedInt();
        } else {
            readUnsignedLongToLong = parsableByteArray2.readUnsignedLongToLong();
            readUnsignedLongToLong2 = parsableByteArray2.readUnsignedLongToLong();
        }
        long j6 = j5 + readUnsignedLongToLong2;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedLongToLong, 1000000, readUnsignedInt);
        parsableByteArray2.skipBytes(2);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j7 = j6;
        long j8 = scaleLargeTimestamp;
        int i5 = 0;
        while (i5 < readUnsignedShort) {
            int readInt = parsableByteArray2.readInt();
            if ((Integer.MIN_VALUE & readInt) == 0) {
                long readUnsignedInt2 = parsableByteArray2.readUnsignedInt();
                iArr[i5] = readInt & Integer.MAX_VALUE;
                jArr[i5] = j7;
                jArr3[i5] = j8;
                readUnsignedLongToLong += readUnsignedInt2;
                long[] jArr4 = jArr3;
                j8 = Util.scaleLargeTimestamp(readUnsignedLongToLong, 1000000, readUnsignedInt);
                jArr2[i5] = j8 - jArr4[i5];
                parsableByteArray2.skipBytes(4);
                j7 += (long) iArr[i5];
                i5++;
                jArr3 = jArr4;
            } else {
                throw new ParserException("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1) {
            return parsableByteArray.readUnsignedLongToLong();
        }
        return parsableByteArray.readUnsignedInt();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray) {
        int i5;
        int i6;
        int i7;
        int i8;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        TrackBundle trackBundle = getTrackBundle(sparseArray, parsableByteArray.readInt());
        if (trackBundle == null) {
            return null;
        }
        if ((parseFullAtomFlags & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            TrackFragment trackFragment = trackBundle.fragment;
            trackFragment.dataPosition = readUnsignedLongToLong;
            trackFragment.auxiliaryDataPosition = readUnsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        if ((parseFullAtomFlags & 2) != 0) {
            i5 = parsableByteArray.readUnsignedIntToInt() - 1;
        } else {
            i5 = defaultSampleValues.sampleDescriptionIndex;
        }
        if ((parseFullAtomFlags & 8) != 0) {
            i6 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i6 = defaultSampleValues.duration;
        }
        if ((parseFullAtomFlags & 16) != 0) {
            i7 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i7 = defaultSampleValues.size;
        }
        if ((parseFullAtomFlags & 32) != 0) {
            i8 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i8 = defaultSampleValues.flags;
        }
        trackBundle.fragment.header = new DefaultSampleValues(i5, i6, i7, i8);
        return trackBundle;
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i5, byte[] bArr) throws ParserException {
        String str;
        TrackBundle parseTfhd = parseTfhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, sparseArray);
        if (parseTfhd != null) {
            TrackFragment trackFragment = parseTfhd.fragment;
            long j5 = trackFragment.nextFragmentDecodeTime;
            parseTfhd.reset();
            int i6 = Atom.TYPE_tfdt;
            if (containerAtom.getLeafAtomOfType(i6) != null && (i5 & 2) == 0) {
                j5 = parseTfdt(containerAtom.getLeafAtomOfType(i6).data);
            }
            parseTruns(containerAtom, parseTfhd, j5, i5);
            TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
            if (leafAtomOfType != null) {
                parseSaiz(sampleDescriptionEncryptionBox, leafAtomOfType.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
            if (leafAtomOfType2 != null) {
                parseSaio(leafAtomOfType2.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
            if (leafAtomOfType3 != null) {
                parseSenc(leafAtomOfType3.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
            Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
            if (!(leafAtomOfType4 == null || leafAtomOfType5 == null)) {
                ParsableByteArray parsableByteArray = leafAtomOfType4.data;
                ParsableByteArray parsableByteArray2 = leafAtomOfType5.data;
                if (sampleDescriptionEncryptionBox != null) {
                    str = sampleDescriptionEncryptionBox.schemeType;
                } else {
                    str = null;
                }
                parseSgpd(parsableByteArray, parsableByteArray2, str, trackFragment);
            }
            int size = containerAtom.leafChildren.size();
            for (int i7 = 0; i7 < size; i7++) {
                Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i7);
                if (leafAtom.type == Atom.TYPE_uuid) {
                    parseUuid(leafAtom.data, trackFragment, bArr);
                }
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readUnsignedIntToInt() - 1, parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readInt()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r27v2 */
    /* JADX WARNING: type inference failed for: r27v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseTrun(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle r27, int r28, long r29, int r31, com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r32, int r33) {
        /*
            r0 = r27
            r1 = 8
            r2 = r32
            r2.setPosition(r1)
            int r1 = r2.readInt()
            int r1 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(r1)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Track r3 = r0.track
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.TrackFragment r0 = r0.fragment
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.DefaultSampleValues r4 = r0.header
            int[] r5 = r0.trunLength
            int r6 = r2.readUnsignedIntToInt()
            r5[r28] = r6
            long[] r5 = r0.trunDataPosition
            long r6 = r0.dataPosition
            r5[r28] = r6
            r8 = r1 & 1
            if (r8 == 0) goto L_0x0031
            int r8 = r2.readInt()
            long r8 = (long) r8
            long r6 = r6 + r8
            r5[r28] = r6
        L_0x0031:
            r5 = r1 & 4
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0039
            r5 = r7
            goto L_0x003a
        L_0x0039:
            r5 = r6
        L_0x003a:
            int r8 = r4.flags
            if (r5 == 0) goto L_0x0042
            int r8 = r2.readUnsignedIntToInt()
        L_0x0042:
            r9 = r1 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0048
            r9 = r7
            goto L_0x0049
        L_0x0048:
            r9 = r6
        L_0x0049:
            r10 = r1 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x004f
            r10 = r7
            goto L_0x0050
        L_0x004f:
            r10 = r6
        L_0x0050:
            r11 = r1 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0056
            r11 = r7
            goto L_0x0057
        L_0x0056:
            r11 = r6
        L_0x0057:
            r1 = r1 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005d
            r1 = r7
            goto L_0x005e
        L_0x005d:
            r1 = r6
        L_0x005e:
            long[] r12 = r3.editListDurations
            r13 = 0
            if (r12 == 0) goto L_0x007f
            int r15 = r12.length
            if (r15 != r7) goto L_0x007f
            r15 = r12[r6]
            int r12 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r12 != 0) goto L_0x007f
            long[] r12 = r3.editListMediaTimes
            r13 = r12[r6]
            r15 = 1000(0x3e8, double:4.94E-321)
            r27 = r6
            r12 = r7
            long r6 = r3.timescale
            r17 = r6
            long r13 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r13, r15, r17)
            goto L_0x0082
        L_0x007f:
            r27 = r6
            r12 = r7
        L_0x0082:
            int[] r6 = r0.sampleSizeTable
            int[] r7 = r0.sampleCompositionTimeOffsetTable
            long[] r15 = r0.sampleDecodingTimeTable
            r16 = r12
            boolean[] r12 = r0.sampleIsSyncFrameTable
            r17 = r1
            int r1 = r3.type
            r2 = 2
            if (r1 != r2) goto L_0x009a
            r1 = r31 & 1
            if (r1 == 0) goto L_0x009a
            r1 = r16
            goto L_0x009c
        L_0x009a:
            r1 = r27
        L_0x009c:
            int[] r2 = r0.trunLength
            r2 = r2[r28]
            int r2 = r33 + r2
            r24 = r5
            r25 = r6
            long r5 = r3.timescale
            r22 = r5
            if (r28 <= 0) goto L_0x00af
            long r5 = r0.nextFragmentDecodeTime
            goto L_0x00b1
        L_0x00af:
            r5 = r29
        L_0x00b1:
            r3 = r33
            r18 = r5
        L_0x00b5:
            if (r3 >= r2) goto L_0x0126
            if (r9 == 0) goto L_0x00be
            int r5 = r32.readUnsignedIntToInt()
            goto L_0x00c0
        L_0x00be:
            int r5 = r4.duration
        L_0x00c0:
            if (r10 == 0) goto L_0x00c7
            int r6 = r32.readUnsignedIntToInt()
            goto L_0x00c9
        L_0x00c7:
            int r6 = r4.size
        L_0x00c9:
            if (r3 != 0) goto L_0x00d1
            if (r24 == 0) goto L_0x00d1
            r31 = r1
            r1 = r8
            goto L_0x00e0
        L_0x00d1:
            if (r11 == 0) goto L_0x00dc
            int r20 = r32.readInt()
            r31 = r1
            r1 = r20
            goto L_0x00e0
        L_0x00dc:
            r31 = r1
            int r1 = r4.flags
        L_0x00e0:
            if (r17 == 0) goto L_0x00f5
            r28 = r1
            int r1 = r32.readInt()
            r26 = r2
            long r1 = (long) r1
            r20 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r20
            long r1 = r1 / r22
            int r1 = (int) r1
            r7[r3] = r1
            goto L_0x00fb
        L_0x00f5:
            r28 = r1
            r26 = r2
            r7[r3] = r27
        L_0x00fb:
            r20 = 1000(0x3e8, double:4.94E-321)
            long r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.scaleLargeTimestamp(r18, r20, r22)
            r29 = r1
            r1 = r18
            long r18 = r29 - r13
            r15[r3] = r18
            r25[r3] = r6
            int r6 = r28 >> 16
            r6 = r6 & 1
            if (r6 != 0) goto L_0x0118
            if (r31 == 0) goto L_0x0115
            if (r3 != 0) goto L_0x0118
        L_0x0115:
            r6 = r16
            goto L_0x011a
        L_0x0118:
            r6 = r27
        L_0x011a:
            r12[r3] = r6
            long r5 = (long) r5
            long r18 = r1 + r5
            int r3 = r3 + 1
            r1 = r31
            r2 = r26
            goto L_0x00b5
        L_0x0126:
            r26 = r2
            r1 = r18
            r0.nextFragmentDecodeTime = r1
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FragmentedMp4Extractor.parseTrun(com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle, int, long, int, com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int):int");
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, long j5, int i5) {
        int i6;
        long j6;
        TrackBundle trackBundle2;
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Atom.LeafAtom leafAtom = list.get(i10);
            if (leafAtom.type == Atom.TYPE_trun) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i9 += readUnsignedIntToInt;
                    i8++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i8, i9);
        int i11 = 0;
        int i12 = 0;
        while (i7 < size) {
            Atom.LeafAtom leafAtom2 = list.get(i7);
            if (leafAtom2.type == Atom.TYPE_trun) {
                ParsableByteArray parsableByteArray2 = leafAtom2.data;
                trackBundle2 = trackBundle;
                j6 = j5;
                i6 = i5;
                i12 = parseTrun(trackBundle2, i11, j6, i6, parsableByteArray2, i12);
                i11++;
            } else {
                trackBundle2 = trackBundle;
                j6 = j5;
                i6 = i5;
            }
            i7++;
            trackBundle = trackBundle2;
            j5 = j6;
            i5 = i6;
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private void processAtomEnded(long j5) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j5) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j5 = this.atomSize;
        if (j5 == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j5 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            long position = extractorInput.getPosition() - ((long) this.atomHeaderBytesRead);
            if (this.atomType == Atom.TYPE_moof) {
                int size = this.trackBundles.size();
                for (int i5 = 0; i5 < size; i5++) {
                    TrackFragment trackFragment = this.trackBundles.valueAt(i5).fragment;
                    trackFragment.atomPosition = position;
                    trackFragment.auxiliaryDataPosition = position;
                    trackFragment.dataPosition = position;
                }
            }
            int i6 = this.atomType;
            if (i6 == Atom.TYPE_mdat) {
                this.currentTrackBundle = null;
                this.endOfMdatPosition = this.atomSize + position;
                if (!this.haveOutputSeekMap) {
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
                    this.haveOutputSeekMap = true;
                }
                this.parserState = 2;
                return true;
            }
            if (shouldParseContainerAtom(i6)) {
                long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position2));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(position2);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    long j6 = this.atomSize;
                    if (j6 <= 2147483647L) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray((int) j6);
                        this.atomData = parsableByteArray;
                        System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                        this.parserState = 1;
                    } else {
                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.atomSize <= 2147483647L) {
                this.atomData = null;
                this.parserState = 1;
            } else {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i5 = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, 8, i5);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i5);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int size = this.trackBundles.size();
        TrackBundle trackBundle = null;
        long j5 = Long.MAX_VALUE;
        for (int i5 = 0; i5 < size; i5++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i5).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill) {
                long j6 = trackFragment.auxiliaryDataPosition;
                if (j6 < j5) {
                    trackBundle = this.trackBundles.valueAt(i5);
                    j5 = j6;
                }
            }
        }
        if (trackBundle == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j5 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.skipFully(position);
            trackBundle.fragment.fillEncryptionData(extractorInput);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    private boolean readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z4;
        TrackOutput.CryptoData cryptoData;
        boolean z5;
        int i5;
        boolean z6;
        ExtractorInput extractorInput2 = extractorInput;
        int i6 = 4;
        boolean z7 = true;
        boolean z8 = false;
        if (this.parserState == 3) {
            if (this.currentTrackBundle == null) {
                TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                if (nextFragmentRun == null) {
                    int position = (int) (this.endOfMdatPosition - extractorInput2.getPosition());
                    if (position >= 0) {
                        extractorInput2.skipFully(position);
                        enterReadingAtomHeaderState();
                        return false;
                    }
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                int position2 = (int) (nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex] - extractorInput2.getPosition());
                if (position2 < 0) {
                    Log.w(TAG, "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                extractorInput2.skipFully(position2);
                this.currentTrackBundle = nextFragmentRun;
            }
            TrackBundle trackBundle = this.currentTrackBundle;
            int[] iArr = trackBundle.fragment.sampleSizeTable;
            int i7 = trackBundle.currentSampleIndex;
            int i8 = iArr[i7];
            this.sampleSize = i8;
            if (i7 < trackBundle.firstSampleToOutputIndex) {
                extractorInput2.skipFully(i8);
                this.currentTrackBundle.skipSampleEncryptionData();
                if (!this.currentTrackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if (trackBundle.track.sampleTransformation == 1) {
                this.sampleSize = i8 - 8;
                extractorInput2.skipFully(8);
            }
            int outputSampleEncryptionData = this.currentTrackBundle.outputSampleEncryptionData();
            this.sampleBytesWritten = outputSampleEncryptionData;
            this.sampleSize += outputSampleEncryptionData;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        TrackBundle trackBundle2 = this.currentTrackBundle;
        TrackFragment trackFragment = trackBundle2.fragment;
        Track track = trackBundle2.track;
        TrackOutput trackOutput = trackBundle2.output;
        int i9 = trackBundle2.currentSampleIndex;
        long samplePresentationTime = trackFragment.getSamplePresentationTime(i9) * 1000;
        TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
        if (timestampAdjuster2 != null) {
            samplePresentationTime = timestampAdjuster2.adjustSampleTimestamp(samplePresentationTime);
        }
        int i10 = track.nalUnitLengthFieldLength;
        if (i10 == 0) {
            z4 = true;
            while (true) {
                int i11 = this.sampleBytesWritten;
                int i12 = this.sampleSize;
                if (i11 >= i12) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData(extractorInput2, i12 - i11, false);
            }
        } else {
            byte[] bArr = this.nalPrefix.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i13 = i10 + 1;
            int i14 = 4 - i10;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i15 = this.sampleCurrentNalBytesRemaining;
                if (i15 == 0) {
                    extractorInput2.readFully(bArr, i14, i13);
                    this.nalPrefix.setPosition(z8);
                    this.sampleCurrentNalBytesRemaining = this.nalPrefix.readUnsignedIntToInt() - (z7 ? 1 : 0);
                    this.nalStartCode.setPosition(z8);
                    trackOutput.sampleData(this.nalStartCode, i6);
                    trackOutput.sampleData(this.nalPrefix, z7);
                    if (this.cea608TrackOutputs.length <= 0 || !NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i6])) {
                        z6 = z8;
                    } else {
                        z6 = z7;
                    }
                    this.processSeiNalUnitPayload = z6;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += i14;
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(i15);
                        extractorInput2.readFully(this.nalBuffer.data, z8 ? 1 : 0, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        i5 = this.sampleCurrentNalBytesRemaining;
                        ParsableByteArray parsableByteArray = this.nalBuffer;
                        int unescapeStream = NalUnitUtil.unescapeStream(parsableByteArray.data, parsableByteArray.limit());
                        z5 = z7;
                        this.nalBuffer.setPosition(MimeTypes.VIDEO_H265.equals(track.format.sampleMimeType) ? 1 : 0);
                        this.nalBuffer.setLimit(unescapeStream);
                        CeaUtil.consume(samplePresentationTime, this.nalBuffer, this.cea608TrackOutputs);
                    } else {
                        z5 = z7;
                        i5 = trackOutput.sampleData(extractorInput2, i15, z8);
                    }
                    this.sampleBytesWritten += i5;
                    this.sampleCurrentNalBytesRemaining -= i5;
                    z7 = z5;
                    i6 = 4;
                    z8 = false;
                }
            }
            z4 = z7;
        }
        boolean z9 = trackFragment.sampleIsSyncFrameTable[i9];
        if (trackFragment.definesEncryptionData) {
            z9 |= true;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
            }
            cryptoData = trackEncryptionBox.cryptoData;
        } else {
            cryptoData = null;
        }
        trackOutput.sampleMetadata(samplePresentationTime, z9 ? 1 : 0, this.sampleSize, 0, cryptoData);
        outputPendingMetadataSamples(samplePresentationTime);
        if (!this.currentTrackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return z4;
    }

    private static boolean shouldParseContainerAtom(int i5) {
        if (i5 == Atom.TYPE_moov || i5 == Atom.TYPE_trak || i5 == Atom.TYPE_mdia || i5 == Atom.TYPE_minf || i5 == Atom.TYPE_stbl || i5 == Atom.TYPE_moof || i5 == Atom.TYPE_traf || i5 == Atom.TYPE_mvex || i5 == Atom.TYPE_edts) {
            return true;
        }
        return false;
    }

    private static boolean shouldParseLeafAtom(int i5) {
        if (i5 == Atom.TYPE_hdlr || i5 == Atom.TYPE_mdhd || i5 == Atom.TYPE_mvhd || i5 == Atom.TYPE_sidx || i5 == Atom.TYPE_stsd || i5 == Atom.TYPE_tfdt || i5 == Atom.TYPE_tfhd || i5 == Atom.TYPE_tkhd || i5 == Atom.TYPE_trex || i5 == Atom.TYPE_trun || i5 == Atom.TYPE_pssh || i5 == Atom.TYPE_saiz || i5 == Atom.TYPE_saio || i5 == Atom.TYPE_senc || i5 == Atom.TYPE_uuid || i5 == Atom.TYPE_sbgp || i5 == Atom.TYPE_sgpd || i5 == Atom.TYPE_elst || i5 == Atom.TYPE_mehd || i5 == Atom.TYPE_emsg) {
            return true;
        }
        return false;
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        Track track = this.sideloadedTrack;
        if (track != null) {
            TrackBundle trackBundle = new TrackBundle(extractorOutput2.track(0, track.type));
            trackBundle.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
            this.trackBundles.put(0, trackBundle);
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i5 = this.parserState;
            if (i5 != 0) {
                if (i5 == 1) {
                    readAtomPayload(extractorInput);
                } else if (i5 == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        int size = this.trackBundles.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.trackBundles.valueAt(i5).reset();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = j6;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    public FragmentedMp4Extractor(int i5) {
        this(i5, (TimestampAdjuster) null);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i5, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i5 + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) == 0) {
            boolean z4 = (parseFullAtomFlags & 2) != 0;
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == trackFragment.sampleCount) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z4);
                trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
                trackFragment.fillEncryptionData(parsableByteArray);
                return;
            }
            throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
        }
        throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public FragmentedMp4Extractor(int i5, @Nullable TimestampAdjuster timestampAdjuster2) {
        this(i5, timestampAdjuster2, (Track) null, (DrmInitData) null);
    }

    public FragmentedMp4Extractor(int i5, @Nullable TimestampAdjuster timestampAdjuster2, @Nullable Track track, @Nullable DrmInitData drmInitData) {
        this(i5, timestampAdjuster2, track, drmInitData, Collections.EMPTY_LIST);
    }

    public FragmentedMp4Extractor(int i5, @Nullable TimestampAdjuster timestampAdjuster2, @Nullable Track track, @Nullable DrmInitData drmInitData, List<Format> list) {
        this(i5, timestampAdjuster2, track, drmInitData, list, (TrackOutput) null);
    }

    public FragmentedMp4Extractor(int i5, @Nullable TimestampAdjuster timestampAdjuster2, @Nullable Track track, @Nullable DrmInitData drmInitData, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.flags = i5 | (track != null ? 8 : 0);
        this.timestampAdjuster = timestampAdjuster2;
        this.sideloadedTrack = track;
        this.sideloadedDrmInitData = drmInitData;
        this.closedCaptionFormats = DesugarCollections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        this.extendedTypeScratch = new byte[16];
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = C.TIME_UNSET;
        this.pendingSeekTimeUs = C.TIME_UNSET;
        this.segmentIndexEarliestPresentationTimeUs = C.TIME_UNSET;
        enterReadingAtomHeaderState();
    }
}
