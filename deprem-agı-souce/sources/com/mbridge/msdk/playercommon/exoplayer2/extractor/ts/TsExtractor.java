package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TsExtractor implements Extractor {
    /* access modifiers changed from: private */
    public static final long AC3_FORMAT_IDENTIFIER = ((long) Util.getIntegerCodeForString("AC-3"));
    private static final int BUFFER_SIZE = 9400;
    /* access modifiers changed from: private */
    public static final long E_AC3_FORMAT_IDENTIFIER = ((long) Util.getIntegerCodeForString("EAC3"));
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new TsExtractor()};
        }
    };
    /* access modifiers changed from: private */
    public static final long HEVC_FORMAT_IDENTIFIER = ((long) Util.getIntegerCodeForString("HEVC"));
    private static final int MAX_PID_PLUS_ONE = 8192;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    private static final int SNIFF_TS_PACKET_COUNT = 5;
    private static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    private static final int TS_SYNC_BYTE = 71;
    private int bytesSinceLastSync;
    private final SparseIntArray continuityCounters;
    /* access modifiers changed from: private */
    public TsPayloadReader id3Reader;
    /* access modifiers changed from: private */
    public final int mode;
    /* access modifiers changed from: private */
    public ExtractorOutput output;
    /* access modifiers changed from: private */
    public final TsPayloadReader.Factory payloadReaderFactory;
    /* access modifiers changed from: private */
    public int remainingPmts;
    /* access modifiers changed from: private */
    public final List<TimestampAdjuster> timestampAdjusters;
    /* access modifiers changed from: private */
    public final SparseBooleanArray trackIds;
    /* access modifiers changed from: private */
    public boolean tracksEnded;
    private final ParsableByteArray tsPacketBuffer;
    /* access modifiers changed from: private */
    public final SparseArray<TsPayloadReader> tsPayloadReaders;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private class PatReader implements SectionPayloadReader {
        private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        public void consume(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() == 0) {
                parsableByteArray.skipBytes(7);
                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i5 = 0; i5 < bytesLeft; i5++) {
                    parsableByteArray.readBytes(this.patScratch, 4);
                    int readBits = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if (readBits == 0) {
                        this.patScratch.skipBits(13);
                    } else {
                        int readBits2 = this.patScratch.readBits(13);
                        TsExtractor.this.tsPayloadReaders.put(readBits2, new SectionReader(new PmtReader(readBits2)));
                        TsExtractor.access$108(TsExtractor.this);
                    }
                }
                if (TsExtractor.this.mode != 2) {
                    TsExtractor.this.tsPayloadReaders.remove(0);
                }
            }
        }

        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    private class PmtReader implements SectionPayloadReader {
        private static final int TS_PMT_DESC_AC3 = 106;
        private static final int TS_PMT_DESC_DTS = 123;
        private static final int TS_PMT_DESC_DVBSUBS = 89;
        private static final int TS_PMT_DESC_EAC3 = 122;
        private static final int TS_PMT_DESC_ISO639_LANG = 10;
        private static final int TS_PMT_DESC_REGISTRATION = 5;
        private final int pid;
        private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
        private final SparseIntArray trackIdToPidScratch = new SparseIntArray();
        private final SparseArray<TsPayloadReader> trackIdToReaderScratch = new SparseArray<>();

        public PmtReader(int i5) {
            this.pid = i5;
        }

        private TsPayloadReader.EsInfo readEsInfo(ParsableByteArray parsableByteArray, int i5) {
            int position = parsableByteArray.getPosition();
            int i6 = i5 + position;
            int i7 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (parsableByteArray.getPosition() < i6) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    if (readUnsignedInt != TsExtractor.AC3_FORMAT_IDENTIFIER) {
                        if (readUnsignedInt != TsExtractor.E_AC3_FORMAT_IDENTIFIER) {
                            if (readUnsignedInt == TsExtractor.HEVC_FORMAT_IDENTIFIER) {
                                i7 = 36;
                            }
                            parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                        }
                        i7 = 135;
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    }
                } else if (readUnsignedByte != 106) {
                    if (readUnsignedByte != 122) {
                        if (readUnsignedByte == 123) {
                            i7 = TsExtractor.TS_STREAM_TYPE_DTS;
                        } else if (readUnsignedByte == 10) {
                            str = parsableByteArray.readString(3).trim();
                        } else if (readUnsignedByte == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (parsableByteArray.getPosition() < position2) {
                                String trim = parsableByteArray.readString(3).trim();
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                byte[] bArr = new byte[4];
                                parsableByteArray.readBytes(bArr, 0, 4);
                                arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                            }
                            arrayList = arrayList2;
                            i7 = 89;
                        }
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    }
                    i7 = 135;
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                }
                i7 = 129;
                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
            }
            parsableByteArray.setPosition(i6);
            return new TsPayloadReader.EsInfo(i7, str, arrayList, Arrays.copyOfRange(parsableByteArray.data, position, i6));
        }

        public void consume(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            int i5;
            TsPayloadReader tsPayloadReader;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray2.readUnsignedByte() == 2) {
                int i6 = 0;
                if (TsExtractor.this.mode == 1 || TsExtractor.this.mode == 2 || TsExtractor.this.remainingPmts == 1) {
                    timestampAdjuster = (TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                    TsExtractor.this.timestampAdjusters.add(timestampAdjuster);
                }
                parsableByteArray2.skipBytes(2);
                int readUnsignedShort = parsableByteArray2.readUnsignedShort();
                int i7 = 5;
                parsableByteArray2.skipBytes(5);
                parsableByteArray2.readBytes(this.pmtScratch, 2);
                int i8 = 4;
                this.pmtScratch.skipBits(4);
                parsableByteArray2.skipBytes(this.pmtScratch.readBits(12));
                if (TsExtractor.this.mode == 2 && TsExtractor.this.id3Reader == null) {
                    TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, (String) null, (List<TsPayloadReader.DvbSubtitleInfo>) null, new byte[0]);
                    TsExtractor tsExtractor = TsExtractor.this;
                    TsPayloadReader unused = tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                    TsExtractor.this.id3Reader.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
                }
                this.trackIdToReaderScratch.clear();
                this.trackIdToPidScratch.clear();
                int bytesLeft = parsableByteArray2.bytesLeft();
                while (bytesLeft > 0) {
                    parsableByteArray2.readBytes(this.pmtScratch, i7);
                    int readBits = this.pmtScratch.readBits(8);
                    this.pmtScratch.skipBits(3);
                    int readBits2 = this.pmtScratch.readBits(13);
                    this.pmtScratch.skipBits(i8);
                    int readBits3 = this.pmtScratch.readBits(12);
                    TsPayloadReader.EsInfo readEsInfo = readEsInfo(parsableByteArray2, readBits3);
                    if (readBits == 6) {
                        readBits = readEsInfo.streamType;
                    }
                    bytesLeft -= readBits3 + 5;
                    if (TsExtractor.this.mode == 2) {
                        i5 = readBits;
                    } else {
                        i5 = readBits2;
                    }
                    if (!TsExtractor.this.trackIds.get(i5)) {
                        if (TsExtractor.this.mode == 2 && readBits == 21) {
                            tsPayloadReader = TsExtractor.this.id3Reader;
                        } else {
                            tsPayloadReader = TsExtractor.this.payloadReaderFactory.createPayloadReader(readBits, readEsInfo);
                        }
                        if (TsExtractor.this.mode != 2 || readBits2 < this.trackIdToPidScratch.get(i5, 8192)) {
                            this.trackIdToPidScratch.put(i5, readBits2);
                            this.trackIdToReaderScratch.put(i5, tsPayloadReader);
                        }
                    }
                    i7 = 5;
                    i8 = 4;
                }
                int size = this.trackIdToPidScratch.size();
                for (int i9 = 0; i9 < size; i9++) {
                    int keyAt = this.trackIdToPidScratch.keyAt(i9);
                    TsExtractor.this.trackIds.put(keyAt, true);
                    TsPayloadReader valueAt = this.trackIdToReaderScratch.valueAt(i9);
                    if (valueAt != null) {
                        if (valueAt != TsExtractor.this.id3Reader) {
                            valueAt.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, keyAt, 8192));
                        }
                        TsExtractor.this.tsPayloadReaders.put(this.trackIdToPidScratch.valueAt(i9), valueAt);
                    }
                }
                if (TsExtractor.this.mode != 2) {
                    TsExtractor.this.tsPayloadReaders.remove(this.pid);
                    TsExtractor tsExtractor2 = TsExtractor.this;
                    if (tsExtractor2.mode != 1) {
                        i6 = TsExtractor.this.remainingPmts - 1;
                    }
                    int unused2 = tsExtractor2.remainingPmts = i6;
                    if (TsExtractor.this.remainingPmts == 0) {
                        TsExtractor.this.output.endTracks();
                        boolean unused3 = TsExtractor.this.tracksEnded = true;
                    }
                } else if (!TsExtractor.this.tracksEnded) {
                    TsExtractor.this.output.endTracks();
                    int unused4 = TsExtractor.this.remainingPmts = 0;
                    boolean unused5 = TsExtractor.this.tracksEnded = true;
                }
            }
        }

        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public TsExtractor() {
        this(0);
    }

    static /* synthetic */ int access$108(TsExtractor tsExtractor) {
        int i5 = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = i5 + 1;
        return i5;
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray<TsPayloadReader> createInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.tsPayloadReaders.put(createInitialPayloadReaders.keyAt(i5), createInitialPayloadReaders.valueAt(i5));
        }
        this.tsPayloadReaders.put(0, new SectionReader(new PatReader()));
        this.id3Reader = null;
    }

    public final void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        boolean z4;
        boolean z5;
        TsPayloadReader tsPayloadReader;
        ParsableByteArray parsableByteArray = this.tsPacketBuffer;
        byte[] bArr = parsableByteArray.data;
        if (9400 - parsableByteArray.getPosition() < TS_PACKET_SIZE) {
            int bytesLeft = this.tsPacketBuffer.bytesLeft();
            if (bytesLeft > 0) {
                System.arraycopy(bArr, this.tsPacketBuffer.getPosition(), bArr, 0, bytesLeft);
            }
            this.tsPacketBuffer.reset(bArr, bytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < TS_PACKET_SIZE) {
            int limit = this.tsPacketBuffer.limit();
            int read = extractorInput.read(bArr, limit, 9400 - limit);
            if (read == -1) {
                return -1;
            }
            this.tsPacketBuffer.setLimit(limit + read);
        }
        int limit2 = this.tsPacketBuffer.limit();
        int position = this.tsPacketBuffer.getPosition();
        int i5 = position;
        while (i5 < limit2 && bArr[i5] != 71) {
            i5++;
        }
        this.tsPacketBuffer.setPosition(i5);
        int i6 = i5 + TS_PACKET_SIZE;
        if (i6 > limit2) {
            int i7 = this.bytesSinceLastSync + (i5 - position);
            this.bytesSinceLastSync = i7;
            if (this.mode != 2 || i7 <= 376) {
                return 0;
            }
            throw new ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
        }
        this.bytesSinceLastSync = 0;
        int readInt = this.tsPacketBuffer.readInt();
        if ((8388608 & readInt) != 0) {
            this.tsPacketBuffer.setPosition(i6);
            return 0;
        }
        if ((4194304 & readInt) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int i8 = (2096896 & readInt) >> 8;
        if ((readInt & 32) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((readInt & 16) != 0) {
            tsPayloadReader = this.tsPayloadReaders.get(i8);
        } else {
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            this.tsPacketBuffer.setPosition(i6);
            return 0;
        }
        if (this.mode != 2) {
            int i9 = readInt & 15;
            int i10 = this.continuityCounters.get(i8, i9 - 1);
            this.continuityCounters.put(i8, i9);
            if (i10 == i9) {
                this.tsPacketBuffer.setPosition(i6);
                return 0;
            } else if (i9 != ((i10 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z5) {
            this.tsPacketBuffer.skipBytes(this.tsPacketBuffer.readUnsignedByte());
        }
        this.tsPacketBuffer.setLimit(i6);
        tsPayloadReader.consume(this.tsPacketBuffer, z4);
        this.tsPacketBuffer.setLimit(limit2);
        this.tsPacketBuffer.setPosition(i6);
        return 0;
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        int size = this.timestampAdjusters.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.timestampAdjusters.get(i5).reset();
        }
        this.tsPacketBuffer.reset();
        this.continuityCounters.clear();
        resetPayloadReaders();
        this.bytesSinceLastSync = 0;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        byte[] bArr = this.tsPacketBuffer.data;
        extractorInput.peekFully(bArr, 0, 940);
        int i5 = 0;
        while (i5 < TS_PACKET_SIZE) {
            int i6 = 0;
            while (i6 != 5) {
                if (bArr[(i6 * TS_PACKET_SIZE) + i5] != 71) {
                    i5++;
                } else {
                    i6++;
                }
            }
            extractorInput.skipFully(i5);
            return true;
        }
        return false;
    }

    public TsExtractor(int i5) {
        this(1, i5);
    }

    public TsExtractor(int i5, int i6) {
        this(i5, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i6));
    }

    public TsExtractor(int i5, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this.payloadReaderFactory = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.mode = i5;
        if (i5 == 1 || i5 == 2) {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.timestampAdjusters = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.tsPacketBuffer = new ParsableByteArray(new byte[BUFFER_SIZE], 0);
        this.trackIds = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        resetPayloadReaders();
    }
}
