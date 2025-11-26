package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Id3Peeker;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new Mp3Extractor()};
        }
    };
    public static final int FLAG_DISABLE_ID3_METADATA = 2;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_SNIFF_BYTES = 16384;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = -128000;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_INFO = Util.getIntegerCodeForString("Info");
    private static final int SEEK_HEADER_UNSET = 0;
    private static final int SEEK_HEADER_VBRI = Util.getIntegerCodeForString("VBRI");
    private static final int SEEK_HEADER_XING = Util.getIntegerCodeForString("Xing");
    private long basisTimeUs;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private Metadata metadata;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    interface Seeker extends SeekMap {
        long getTimeUs(long j5);
    }

    public Mp3Extractor() {
        this(0);
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i5) {
        if (parsableByteArray.limit() >= i5 + 4) {
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (readInt == SEEK_HEADER_XING || readInt == SEEK_HEADER_INFO) {
                return readInt;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        int readInt2 = parsableByteArray.readInt();
        int i6 = SEEK_HEADER_VBRI;
        if (readInt2 == i6) {
            return i6;
        }
        return 0;
    }

    private static boolean headersMatch(int i5, long j5) {
        return ((long) (i5 & MPEG_AUDIO_HEADER_MASK)) == (j5 & -128000);
    }

    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) throws IOException, InterruptedException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.data, 0, this.synchronizedHeader.frameSize);
        MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
        int i5 = mpegAudioHeader.version & 1;
        int i6 = 21;
        int i7 = mpegAudioHeader.channels;
        if (i5 != 0) {
            if (i7 != 1) {
                i6 = 36;
            }
        } else if (i7 == 1) {
            i6 = 13;
        }
        int i8 = i6;
        int seekFrameHeader = getSeekFrameHeader(parsableByteArray, i8);
        if (seekFrameHeader == SEEK_HEADER_XING || seekFrameHeader == SEEK_HEADER_INFO) {
            XingSeeker create = XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            if (create != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i8 + 141);
                extractorInput.peekFully(this.scratch.data, 0, 3);
                this.scratch.setPosition(0);
                this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
            }
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            if (create == null || create.isSeekable() || seekFrameHeader != SEEK_HEADER_INFO) {
                return create;
            }
            return getConstantBitrateSeeker(extractorInput);
        } else if (seekFrameHeader == SEEK_HEADER_VBRI) {
            VbriSeeker create2 = VbriSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return create2;
        } else {
            extractorInput.resetPeekPosition();
            return null;
        }
    }

    private int readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if (!headersMatch(readInt, (long) this.synchronizedHeaderData) || MpegAudioHeader.getFrameSize(readInt) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
            if (this.basisTimeUs == C.TIME_UNSET) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != C.TIME_UNSET) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0);
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
        }
        int sampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        int i5 = this.sampleBytesRemaining - sampleData;
        this.sampleBytesRemaining = i5;
        if (i5 > 0) {
            return 0;
        }
        long j5 = this.basisTimeUs;
        MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
        this.trackOutput.sampleMetadata(j5 + ((this.samplesRead * 1000000) / ((long) mpegAudioHeader.sampleRate)), 1, mpegAudioHeader.frameSize, 0, (TrackOutput.CryptoData) null);
        this.samplesRead += (long) this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z4) throws IOException, InterruptedException {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        int frameSize;
        Id3Decoder.FramePredicate framePredicate;
        if (z4) {
            i5 = 16384;
        } else {
            i5 = 131072;
        }
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            if ((this.flags & 2) != 0) {
                framePredicate = GaplessInfoHolder.GAPLESS_INFO_ID3_FRAME_PREDICATE;
            } else {
                framePredicate = null;
            }
            Metadata peekId3Data = this.id3Peeker.peekId3Data(extractorInput, framePredicate);
            this.metadata = peekId3Data;
            if (peekId3Data != null) {
                this.gaplessInfoHolder.setFromMetadata(peekId3Data);
            }
            i6 = (int) extractorInput.getPeekPosition();
            if (!z4) {
                extractorInput.skipFully(i6);
            }
            i7 = 0;
        } else {
            i6 = 0;
            i7 = 0;
        }
        int i9 = i8;
        int i10 = i9;
        while (true) {
            byte[] bArr = this.scratch.data;
            if (i8 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!extractorInput.peekFully(bArr, 0, 4, z5)) {
                break;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if ((i9 == 0 || headersMatch(readInt, (long) i9)) && (frameSize = MpegAudioHeader.getFrameSize(readInt)) != -1) {
                i8++;
                if (i8 != 1) {
                    if (i8 == 4) {
                        break;
                    }
                } else {
                    MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                    i9 = readInt;
                }
                extractorInput.advancePeekPosition(frameSize - 4);
            } else {
                int i11 = i10 + 1;
                if (i10 != i5) {
                    if (z4) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i6 + i11);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i9 = 0;
                    i10 = i11;
                    i8 = 0;
                } else if (z4) {
                    return false;
                } else {
                    throw new ParserException("Searched too many bytes.");
                }
            }
        }
        if (z4) {
            extractorInput.skipFully(i6 + i10);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i9;
        return true;
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        this.extractorOutput.endTracks();
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        Metadata metadata2;
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        } else {
            ExtractorInput extractorInput2 = extractorInput;
        }
        if (this.seeker == null) {
            Seeker maybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
            this.seeker = maybeReadSeekFrame;
            if (maybeReadSeekFrame == null || (!maybeReadSeekFrame.isSeekable() && (this.flags & 1) != 0)) {
                this.seeker = getConstantBitrateSeeker(extractorInput);
            }
            this.extractorOutput.seekMap(this.seeker);
            TrackOutput trackOutput2 = this.trackOutput;
            MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
            String str = mpegAudioHeader.mimeType;
            int i5 = mpegAudioHeader.channels;
            int i6 = mpegAudioHeader.sampleRate;
            GaplessInfoHolder gaplessInfoHolder2 = this.gaplessInfoHolder;
            int i7 = gaplessInfoHolder2.encoderDelay;
            int i8 = gaplessInfoHolder2.encoderPadding;
            if ((this.flags & 2) != 0) {
                metadata2 = null;
            } else {
                metadata2 = this.metadata;
            }
            trackOutput2.format(Format.createAudioSampleFormat((String) null, str, (String) null, -1, 4096, i5, i6, -1, i7, i8, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, metadata2));
        }
        return readSample(extractorInput);
    }

    public final void release() {
    }

    public final void seek(long j5, long j6) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = C.TIME_UNSET;
        this.samplesRead = 0;
        this.sampleBytesRemaining = 0;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return synchronize(extractorInput, true);
    }

    public Mp3Extractor(int i5) {
        this(i5, C.TIME_UNSET);
    }

    public Mp3Extractor(int i5, long j5) {
        this.flags = i5;
        this.forcedFirstSampleTimestampUs = j5;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = C.TIME_UNSET;
        this.id3Peeker = new Id3Peeker();
    }
}
