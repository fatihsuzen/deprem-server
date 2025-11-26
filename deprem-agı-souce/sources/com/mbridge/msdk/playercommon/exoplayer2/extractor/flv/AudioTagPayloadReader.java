package com.mbridge.msdk.playercommon.exoplayer2.extractor.flv;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.flv.TagPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int AAC_PACKET_TYPE_AAC_RAW = 1;
    private static final int AAC_PACKET_TYPE_SEQUENCE_HEADER = 0;
    private static final int AUDIO_FORMAT_AAC = 10;
    private static final int AUDIO_FORMAT_ALAW = 7;
    private static final int AUDIO_FORMAT_MP3 = 2;
    private static final int AUDIO_FORMAT_ULAW = 8;
    private static final int[] AUDIO_SAMPLING_RATE_TABLE = {5512, 11025, 22050, 44100};
    private int audioFormat;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public final boolean parseHeader(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        String str;
        int i5;
        if (!this.hasParsedAudioDataHeader) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i6 = (readUnsignedByte >> 4) & 15;
            this.audioFormat = i6;
            if (i6 == 2) {
                this.output.format(Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_MPEG, (String) null, -1, -1, 1, AUDIO_SAMPLING_RATE_TABLE[(readUnsignedByte >> 2) & 3], (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.hasOutputFormat = true;
            } else if (i6 == 7 || i6 == 8) {
                if (i6 == 7) {
                    str = MimeTypes.AUDIO_ALAW;
                } else {
                    str = MimeTypes.AUDIO_MLAW;
                }
                String str2 = str;
                if ((readUnsignedByte & 1) == 1) {
                    i5 = 2;
                } else {
                    i5 = 3;
                }
                this.output.format(Format.createAudioSampleFormat((String) null, str2, (String) null, -1, -1, 1, 8000, i5, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.hasOutputFormat = true;
            } else if (i6 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
            }
            this.hasParsedAudioDataHeader = true;
        } else {
            parsableByteArray.skipBytes(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void parsePayload(ParsableByteArray parsableByteArray, long j5) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        if (this.audioFormat == 2) {
            int bytesLeft = parsableByteArray2.bytesLeft();
            this.output.sampleData(parsableByteArray2, bytesLeft);
            this.output.sampleMetadata(j5, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
            return;
        }
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        if (readUnsignedByte == 0 && !this.hasOutputFormat) {
            int bytesLeft2 = parsableByteArray2.bytesLeft();
            byte[] bArr = new byte[bytesLeft2];
            parsableByteArray2.readBytes(bArr, 0, bytesLeft2);
            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
            this.output.format(Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_AAC, (String) null, -1, -1, ((Integer) parseAacAudioSpecificConfig.second).intValue(), ((Integer) parseAacAudioSpecificConfig.first).intValue(), Collections.singletonList(bArr), (DrmInitData) null, 0, (String) null));
            this.hasOutputFormat = true;
        } else if (this.audioFormat != 10 || readUnsignedByte == 1) {
            int bytesLeft3 = parsableByteArray2.bytesLeft();
            this.output.sampleData(parsableByteArray2, bytesLeft3);
            this.output.sampleMetadata(j5, 1, bytesLeft3, 0, (TrackOutput.CryptoData) null);
        }
    }

    public final void seek() {
    }
}
