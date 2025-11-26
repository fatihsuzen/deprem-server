package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public final class Ac3Reader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 128;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private final ParsableBitArray headerScratchBits;
    private final ParsableByteArray headerScratchBytes;
    private final String language;
    private boolean lastByteWas0B;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;
    private String trackFormatId;

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public Ac3Reader() {
        this((String) null);
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i5) {
        int min = Math.min(parsableByteArray.bytesLeft(), i5 - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        int i6 = this.bytesRead + min;
        this.bytesRead = i6;
        if (i6 == i5) {
            return true;
        }
        return false;
    }

    private void parseHeader() {
        this.headerScratchBits.setPosition(0);
        Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = Ac3Util.parseAc3SyncframeInfo(this.headerScratchBits);
        Format format2 = this.format;
        if (!(format2 != null && parseAc3SyncframeInfo.channelCount == format2.channelCount && parseAc3SyncframeInfo.sampleRate == format2.sampleRate && parseAc3SyncframeInfo.mimeType == format2.sampleMimeType)) {
            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.trackFormatId, parseAc3SyncframeInfo.mimeType, (String) null, -1, -1, parseAc3SyncframeInfo.channelCount, parseAc3SyncframeInfo.sampleRate, (List<byte[]>) null, (DrmInitData) null, 0, this.language);
            this.format = createAudioSampleFormat;
            this.output.format(createAudioSampleFormat);
        }
        this.sampleSize = parseAc3SyncframeInfo.frameSize;
        this.sampleDurationUs = (((long) parseAc3SyncframeInfo.sampleCount) * 1000000) / ((long) this.format.sampleRate);
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z4 = false;
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (!this.lastByteWas0B) {
                if (parsableByteArray.readUnsignedByte() == 11) {
                    z4 = true;
                }
                this.lastByteWas0B = z4;
            } else {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte == 119) {
                    this.lastByteWas0B = false;
                    return true;
                }
                if (readUnsignedByte == 11) {
                    z4 = true;
                }
                this.lastByteWas0B = z4;
            }
        }
    }

    public final void consume(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i5 = this.state;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray, min);
                        int i6 = this.bytesRead + min;
                        this.bytesRead = i6;
                        int i7 = this.sampleSize;
                        if (i6 == i7) {
                            this.output.sampleMetadata(this.timeUs, 1, i7, 0, (TrackOutput.CryptoData) null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = 0;
                        }
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.data, 128)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 128);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
                byte[] bArr = this.headerScratchBytes.data;
                bArr[0] = 11;
                bArr[1] = 119;
                this.bytesRead = 2;
            }
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.trackFormatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j5, boolean z4) {
        this.timeUs = j5;
    }

    public final void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWas0B = false;
    }

    public Ac3Reader(String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.headerScratchBits = parsableBitArray;
        this.headerScratchBytes = new ParsableByteArray(parsableBitArray.data);
        this.state = 0;
        this.language = str;
    }
}
