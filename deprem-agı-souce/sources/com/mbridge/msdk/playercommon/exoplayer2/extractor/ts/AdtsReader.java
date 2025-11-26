package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DummyTrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;

public final class AdtsReader implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 2;
    private static final int STATE_READING_ID3_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 3;
    private static final String TAG = "AdtsReader";
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private String formatId;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public AdtsReader(boolean z4) {
        this(z4, (String) null);
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

    private void findNextSample(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int i5 = position + 1;
            byte b5 = bArr[position];
            byte b6 = b5 & 255;
            int i6 = this.matchState;
            if (i6 != 512 || b6 < 240 || b6 == 255) {
                byte b7 = i6 | b6;
                if (b7 == 329) {
                    this.matchState = 768;
                } else if (b7 == 511) {
                    this.matchState = 512;
                } else if (b7 == 836) {
                    this.matchState = 1024;
                } else if (b7 == 1075) {
                    setReadingId3HeaderState();
                    parsableByteArray.setPosition(i5);
                    return;
                } else if (i6 != 256) {
                    this.matchState = 256;
                }
                position = i5;
            } else {
                boolean z4 = true;
                if ((b5 & 1) != 0) {
                    z4 = false;
                }
                this.hasCrc = z4;
                setReadingAdtsHeaderState();
                parsableByteArray.setPosition(i5);
                return;
            }
        }
        parsableByteArray.setPosition(position);
    }

    private void parseAdtsHeader() throws ParserException {
        this.adtsScratch.setPosition(0);
        if (!this.hasOutputFormat) {
            int i5 = 2;
            int readBits = this.adtsScratch.readBits(2) + 1;
            if (readBits != 2) {
                Log.w(TAG, "Detected audio object type: " + readBits + ", but assuming AAC LC.");
            } else {
                i5 = readBits;
            }
            int readBits2 = this.adtsScratch.readBits(4);
            this.adtsScratch.skipBits(1);
            byte[] buildAacAudioSpecificConfig = CodecSpecificDataUtil.buildAacAudioSpecificConfig(i5, readBits2, this.adtsScratch.readBits(3));
            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(buildAacAudioSpecificConfig);
            Format createAudioSampleFormat = Format.createAudioSampleFormat(this.formatId, MimeTypes.AUDIO_AAC, (String) null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(buildAacAudioSpecificConfig), (DrmInitData) null, 0, this.language);
            this.sampleDurationUs = 1024000000 / ((long) createAudioSampleFormat.sampleRate);
            this.output.format(createAudioSampleFormat);
            this.hasOutputFormat = true;
        } else {
            this.adtsScratch.skipBits(10);
        }
        this.adtsScratch.skipBits(4);
        int readBits3 = this.adtsScratch.readBits(13);
        int i6 = readBits3 - 7;
        if (this.hasCrc) {
            i6 = readBits3 - 9;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, i6);
    }

    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    private void readSample(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray, min);
        int i5 = this.bytesRead + min;
        this.bytesRead = i5;
        int i6 = this.sampleSize;
        if (i5 == i6) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, i6, 0, (TrackOutput.CryptoData) null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 2;
        this.bytesRead = 0;
    }

    private void setReadingId3HeaderState() {
        this.state = 1;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput, long j5, int i5, int i6) {
        this.state = 3;
        this.bytesRead = i5;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = j5;
        this.sampleSize = i6;
    }

    public final void consume(ParsableByteArray parsableByteArray) throws ParserException {
        int i5;
        while (parsableByteArray.bytesLeft() > 0) {
            int i6 = this.state;
            if (i6 == 0) {
                findNextSample(parsableByteArray);
            } else if (i6 != 1) {
                if (i6 == 2) {
                    if (this.hasCrc) {
                        i5 = 7;
                    } else {
                        i5 = 5;
                    }
                    if (continueRead(parsableByteArray, this.adtsScratch.data, i5)) {
                        parseAdtsHeader();
                    }
                } else if (i6 == 3) {
                    readSample(parsableByteArray);
                }
            } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.data, 10)) {
                parseId3Header();
            }
        }
    }

    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        if (this.exposeId3) {
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
            this.id3Output = track;
            track.format(Format.createSampleFormat(trackIdGenerator.getFormatId(), MimeTypes.APPLICATION_ID3, (String) null, -1, (DrmInitData) null));
            return;
        }
        this.id3Output = new DummyTrackOutput();
    }

    public final void packetFinished() {
    }

    public final void packetStarted(long j5, boolean z4) {
        this.timeUs = j5;
    }

    public final void seek() {
        setFindingSampleState();
    }

    public AdtsReader(boolean z4, String str) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.exposeId3 = z4;
        this.language = str;
    }
}
