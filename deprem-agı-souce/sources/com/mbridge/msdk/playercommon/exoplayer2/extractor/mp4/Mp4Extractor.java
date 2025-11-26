package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

public final class Mp4Extractor implements Extractor, SeekMap {
    private static final int BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new Mp4Extractor()};
        }
    };
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isQuickTime;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private Mp4Track[] tracks;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track2, TrackSampleTable trackSampleTable, TrackOutput trackOutput2) {
            this.track = track2;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public Mp4Extractor() {
        this(0);
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i5 = 0; i5 < mp4TrackArr.length; i5++) {
            jArr[i5] = new long[mp4TrackArr[i5].sampleTable.sampleCount];
            jArr2[i5] = mp4TrackArr[i5].sampleTable.timestampsUs[0];
        }
        long j5 = 0;
        int i6 = 0;
        while (i6 < mp4TrackArr.length) {
            long j6 = Long.MAX_VALUE;
            int i7 = -1;
            for (int i8 = 0; i8 < mp4TrackArr.length; i8++) {
                if (!zArr[i8]) {
                    long j7 = jArr2[i8];
                    if (j7 <= j6) {
                        i7 = i8;
                        j6 = j7;
                    }
                }
            }
            int i9 = iArr[i7];
            long[] jArr3 = jArr[i7];
            jArr3[i9] = j5;
            TrackSampleTable trackSampleTable = mp4TrackArr[i7].sampleTable;
            j5 += (long) trackSampleTable.sizes[i9];
            int i10 = i9 + 1;
            iArr[i7] = i10;
            if (i10 < jArr3.length) {
                jArr2[i7] = trackSampleTable.timestampsUs[i10];
            } else {
                zArr[i7] = true;
                i6++;
            }
        }
        return jArr;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long j5) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j5);
        if (indexOfEarlierOrEqualSynchronizationSample == -1) {
            return trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j5);
        }
        return indexOfEarlierOrEqualSynchronizationSample;
    }

    private int getTrackIndexOfNextReadSample(long j5) {
        boolean z4;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        long j6 = Long.MAX_VALUE;
        boolean z5 = true;
        long j7 = Long.MAX_VALUE;
        boolean z6 = true;
        long j8 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i7 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i7];
            int i8 = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            if (i8 != trackSampleTable.sampleCount) {
                long j9 = trackSampleTable.offsets[i8];
                long j10 = this.accumulatedSampleSizes[i7][i8];
                long j11 = j9 - j5;
                if (j11 < 0 || j11 >= RELOAD_MINIMUM_SEEK_DISTANCE) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((!z4 && z6) || (z4 == z6 && j11 < j8)) {
                    z6 = z4;
                    j7 = j10;
                    i6 = i7;
                    j8 = j11;
                }
                if (j10 < j6) {
                    z5 = z4;
                    j6 = j10;
                    i5 = i7;
                }
            }
            i7++;
        }
        if (j6 == Long.MAX_VALUE || !z5 || j7 < j6 + MAXIMUM_READ_AHEAD_BYTES_STREAM) {
            return i6;
        }
        return i5;
    }

    private ArrayList<TrackSampleTable> getTrackSampleTables(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, boolean z4) throws ParserException {
        boolean z5;
        ArrayList<TrackSampleTable> arrayList = new ArrayList<>();
        int i5 = 0;
        while (i5 < containerAtom.containerChildren.size()) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i5);
            if (containerAtom2.type != Atom.TYPE_trak) {
                z5 = z4;
            } else {
                z5 = z4;
                Track parseTrak = AtomParsers.parseTrak(containerAtom2, containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd), C.TIME_UNSET, (DrmInitData) null, z5, this.isQuickTime);
                if (parseTrak != null) {
                    TrackSampleTable parseStbl = AtomParsers.parseStbl(parseTrak, containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), gaplessInfoHolder);
                    if (parseStbl.sampleCount != 0) {
                        arrayList.add(parseStbl);
                    }
                }
            }
            i5++;
            z4 = z5;
        }
        return arrayList;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long j5, long j6) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j5);
        if (synchronizationSampleIndex == -1) {
            return j6;
        }
        return Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j6);
    }

    private void processAtomEnded(long j5) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j5) {
            Atom.ContainerAtom pop = this.containerAtoms.pop();
            if (pop.type == Atom.TYPE_moov) {
                processMoovAtom(pop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(pop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private static boolean processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == BRAND_QUICKTIME) {
                return true;
            }
        }
        return false;
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata metadata;
        boolean z4;
        ArrayList<TrackSampleTable> arrayList;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList2 = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom2.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            metadata = AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
            if (metadata != null) {
                gaplessInfoHolder.setFromMetadata(metadata);
            }
        } else {
            metadata = null;
        }
        int i5 = 1;
        int i6 = 0;
        if ((this.flags & 1) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        try {
            arrayList = getTrackSampleTables(containerAtom2, gaplessInfoHolder, z4);
        } catch (AtomParsers.UnhandledEditListException unused) {
            gaplessInfoHolder = new GaplessInfoHolder();
            arrayList = getTrackSampleTables(containerAtom2, gaplessInfoHolder, true);
        }
        int size = arrayList.size();
        int i7 = -1;
        long j5 = C.TIME_UNSET;
        while (i6 < size) {
            TrackSampleTable trackSampleTable = arrayList.get(i6);
            Track track = trackSampleTable.track;
            Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.extractorOutput.track(i6, track.type));
            Format copyWithMaxInputSize = track.format.copyWithMaxInputSize(trackSampleTable.maximumSize + 30);
            if (track.type == i5) {
                if (gaplessInfoHolder.hasGaplessInfo()) {
                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(gaplessInfoHolder.encoderDelay, gaplessInfoHolder.encoderPadding);
                }
                if (metadata != null) {
                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                }
            }
            mp4Track.trackOutput.format(copyWithMaxInputSize);
            GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
            Metadata metadata2 = metadata;
            long j6 = track.durationUs;
            if (j6 == C.TIME_UNSET) {
                j6 = trackSampleTable.durationUs;
            }
            j5 = Math.max(j5, j6);
            if (track.type == 2) {
                if (i7 == -1) {
                    i7 = arrayList2.size();
                }
            }
            arrayList2.add(mp4Track);
            i6++;
            metadata = metadata2;
            gaplessInfoHolder = gaplessInfoHolder2;
            i5 = 1;
        }
        this.firstVideoTrackIndex = i7;
        this.durationUs = j5;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList2.toArray(new Mp4Track[arrayList2.size()]);
        this.tracks = mp4TrackArr;
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(mp4TrackArr);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z4;
        boolean z5;
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
            if (shouldParseContainerAtom(this.atomType)) {
                long position = (extractorInput.getPosition() + this.atomSize) - ((long) this.atomHeaderBytesRead);
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(position);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assertions.checkState(z4);
                if (this.atomSize <= 2147483647L) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Assertions.checkState(z5);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
                this.atomData = parsableByteArray;
                System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                this.parserState = 1;
            } else {
                this.atomData = null;
                this.parserState = 1;
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readAtomPayload(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput r10, com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            long r0 = r9.atomSize
            int r2 = r9.atomHeaderBytesRead
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r4 = r9.atomData
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0045
            byte[] r11 = r4.data
            int r4 = r9.atomHeaderBytesRead
            int r0 = (int) r0
            r10.readFully(r11, r4, r0)
            int r10 = r9.atomType
            int r11 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ftyp
            if (r10 != r11) goto L_0x0028
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r9.atomData
            boolean r10 = processFtypAtom(r10)
            r9.isQuickTime = r10
            goto L_0x0050
        L_0x0028:
            java.util.ArrayDeque<com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x0050
            java.util.ArrayDeque<com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            java.lang.Object r10 = r10.peek()
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$ContainerAtom r10 = (com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.ContainerAtom) r10
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom$LeafAtom
            int r0 = r9.atomType
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = r9.atomData
            r11.<init>(r0, r1)
            r10.add((com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.LeafAtom) r11)
            goto L_0x0050
        L_0x0045:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0052
            int r11 = (int) r0
            r10.skipFully(r11)
        L_0x0050:
            r10 = r6
            goto L_0x005a
        L_0x0052:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.position = r7
            r10 = r5
        L_0x005a:
            r9.processAtomEnded(r2)
            if (r10 == 0) goto L_0x0065
            int r10 = r9.parserState
            r11 = 2
            if (r10 == r11) goto L_0x0065
            return r5
        L_0x0065:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Mp4Extractor.readAtomPayload(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput, com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder):boolean");
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        ExtractorInput extractorInput2 = extractorInput;
        long position = extractorInput2.getPosition();
        if (this.sampleTrackIndex == -1) {
            int trackIndexOfNextReadSample = getTrackIndexOfNextReadSample(position);
            this.sampleTrackIndex = trackIndexOfNextReadSample;
            if (trackIndexOfNextReadSample == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i5 = mp4Track.sampleIndex;
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        long j5 = trackSampleTable.offsets[i5];
        int i6 = trackSampleTable.sizes[i5];
        long j6 = (j5 - position) + ((long) this.sampleBytesWritten);
        if (j6 < 0 || j6 >= RELOAD_MINIMUM_SEEK_DISTANCE) {
            positionHolder.position = j5;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j6 += 8;
            i6 -= 8;
        }
        extractorInput2.skipFully((int) j6);
        int i7 = mp4Track.track.nalUnitLengthFieldLength;
        if (i7 == 0) {
            while (true) {
                int i8 = this.sampleBytesWritten;
                if (i8 >= i6) {
                    break;
                }
                int sampleData = trackOutput.sampleData(extractorInput2, i6 - i8, false);
                this.sampleBytesWritten += sampleData;
                this.sampleCurrentNalBytesRemaining -= sampleData;
            }
        } else {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i9 = 4 - i7;
            while (this.sampleBytesWritten < i6) {
                int i10 = this.sampleCurrentNalBytesRemaining;
                if (i10 == 0) {
                    extractorInput2.readFully(this.nalLength.data, i9, i7);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    i6 += i9;
                } else {
                    int sampleData2 = trackOutput.sampleData(extractorInput2, i10, false);
                    this.sampleBytesWritten += sampleData2;
                    this.sampleCurrentNalBytesRemaining -= sampleData2;
                }
            }
        }
        int i11 = i6;
        TrackSampleTable trackSampleTable2 = mp4Track.sampleTable;
        trackOutput.sampleMetadata(trackSampleTable2.timestampsUs[i5], trackSampleTable2.flags[i5], i11, 0, (TrackOutput.CryptoData) null);
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private static boolean shouldParseContainerAtom(int i5) {
        if (i5 == Atom.TYPE_moov || i5 == Atom.TYPE_trak || i5 == Atom.TYPE_mdia || i5 == Atom.TYPE_minf || i5 == Atom.TYPE_stbl || i5 == Atom.TYPE_edts) {
            return true;
        }
        return false;
    }

    private static boolean shouldParseLeafAtom(int i5) {
        if (i5 == Atom.TYPE_mdhd || i5 == Atom.TYPE_mvhd || i5 == Atom.TYPE_hdlr || i5 == Atom.TYPE_stsd || i5 == Atom.TYPE_stts || i5 == Atom.TYPE_stss || i5 == Atom.TYPE_ctts || i5 == Atom.TYPE_elst || i5 == Atom.TYPE_stsc || i5 == Atom.TYPE_stsz || i5 == Atom.TYPE_stz2 || i5 == Atom.TYPE_stco || i5 == Atom.TYPE_co64 || i5 == Atom.TYPE_tkhd || i5 == Atom.TYPE_ftyp || i5 == Atom.TYPE_udta) {
            return true;
        }
        return false;
    }

    private void updateSampleIndices(long j5) {
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j5);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j5);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j5) {
        long j6;
        long j7;
        int indexOfLaterOrEqualSynchronizationSample;
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i5 = this.firstVideoTrackIndex;
        long j8 = -1;
        if (i5 != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[i5].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j5);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j9 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j6 = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j9 >= j5 || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j5)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j7 = -9223372036854775807L;
            } else {
                j7 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j8 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            j5 = j9;
        } else {
            j6 = Long.MAX_VALUE;
            j7 = -9223372036854775807L;
        }
        int i6 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr2 = this.tracks;
            if (i6 >= mp4TrackArr2.length) {
                break;
            }
            if (i6 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr2[i6].sampleTable;
                long maybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j5, j6);
                if (j7 != C.TIME_UNSET) {
                    j8 = maybeAdjustSeekOffset(trackSampleTable2, j7, j8);
                }
                j6 = maybeAdjustSeekOffset;
            }
            i6++;
        }
        SeekPoint seekPoint = new SeekPoint(j5, j6);
        if (j7 == C.TIME_UNSET) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j7, j8));
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i5 = this.parserState;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (j5 == 0) {
            enterReadingAtomHeaderState();
        } else if (this.tracks != null) {
            updateSampleIndices(j6);
        }
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffUnfragmented(extractorInput);
    }

    public Mp4Extractor(int i5) {
        this.flags = i5;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleTrackIndex = -1;
    }
}
