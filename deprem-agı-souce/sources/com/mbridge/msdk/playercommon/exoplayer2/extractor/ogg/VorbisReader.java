package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.VorbisUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;

final class VorbisReader extends StreamReader {
    private VorbisUtil.CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private VorbisUtil.VorbisIdHeader vorbisIdHeader;
    private VorbisSetup vorbisSetup;

    static final class VorbisSetup {
        public final VorbisUtil.CommentHeader commentHeader;
        public final int iLogModes;
        public final VorbisUtil.VorbisIdHeader idHeader;
        public final VorbisUtil.Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader2, byte[] bArr, VorbisUtil.Mode[] modeArr, int i5) {
            this.idHeader = vorbisIdHeader;
            this.commentHeader = commentHeader2;
            this.setupHeaderData = bArr;
            this.modes = modeArr;
            this.iLogModes = i5;
        }
    }

    VorbisReader() {
    }

    static void appendNumberOfSamples(ParsableByteArray parsableByteArray, long j5) {
        parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        parsableByteArray.data[parsableByteArray.limit() - 4] = (byte) ((int) (j5 & 255));
        parsableByteArray.data[parsableByteArray.limit() - 3] = (byte) ((int) ((j5 >>> 8) & 255));
        parsableByteArray.data[parsableByteArray.limit() - 2] = (byte) ((int) ((j5 >>> 16) & 255));
        parsableByteArray.data[parsableByteArray.limit() - 1] = (byte) ((int) ((j5 >>> 24) & 255));
    }

    private static int decodeBlockSize(byte b5, VorbisSetup vorbisSetup2) {
        if (!vorbisSetup2.modes[readBits(b5, vorbisSetup2.iLogModes, 1)].blockFlag) {
            return vorbisSetup2.idHeader.blockSize0;
        }
        return vorbisSetup2.idHeader.blockSize1;
    }

    static int readBits(byte b5, int i5, int i6) {
        return (b5 >> i6) & (255 >>> (8 - i5));
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onSeekEnd(long j5) {
        boolean z4;
        super.onSeekEnd(j5);
        int i5 = 0;
        if (j5 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.seenFirstAudioPacket = z4;
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = this.vorbisIdHeader;
        if (vorbisIdHeader2 != null) {
            i5 = vorbisIdHeader2.blockSize0;
        }
        this.previousPacketBlockSize = i5;
    }

    /* access modifiers changed from: protected */
    public final long preparePayload(ParsableByteArray parsableByteArray) {
        int i5 = 0;
        byte b5 = parsableByteArray.data[0];
        if ((b5 & 1) == 1) {
            return -1;
        }
        int decodeBlockSize = decodeBlockSize(b5, this.vorbisSetup);
        if (this.seenFirstAudioPacket) {
            i5 = (this.previousPacketBlockSize + decodeBlockSize) / 4;
        }
        long j5 = (long) i5;
        appendNumberOfSamples(parsableByteArray, j5);
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = decodeBlockSize;
        return j5;
    }

    /* access modifiers changed from: protected */
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j5, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        if (this.vorbisSetup != null) {
            return false;
        }
        VorbisSetup readSetupHeaders = readSetupHeaders(parsableByteArray);
        this.vorbisSetup = readSetupHeaders;
        if (readSetupHeaders == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.vorbisSetup.idHeader.data);
        arrayList.add(this.vorbisSetup.setupHeaderData);
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = this.vorbisSetup.idHeader;
        setupData.format = Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_VORBIS, (String) null, vorbisIdHeader2.bitrateNominal, -1, vorbisIdHeader2.channels, (int) vorbisIdHeader2.sampleRate, arrayList, (DrmInitData) null, 0, (String) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final VorbisSetup readSetupHeaders(ParsableByteArray parsableByteArray) throws IOException {
        if (this.vorbisIdHeader == null) {
            this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
            return null;
        } else if (this.commentHeader == null) {
            this.commentHeader = VorbisUtil.readVorbisCommentHeader(parsableByteArray);
            return null;
        } else {
            byte[] bArr = new byte[parsableByteArray.limit()];
            System.arraycopy(parsableByteArray.data, 0, bArr, 0, parsableByteArray.limit());
            VorbisUtil.Mode[] readVorbisModes = VorbisUtil.readVorbisModes(parsableByteArray, this.vorbisIdHeader.channels);
            return new VorbisSetup(this.vorbisIdHeader, this.commentHeader, bArr, readVorbisModes, VorbisUtil.iLog(readVorbisModes.length - 1));
        }
    }

    /* access modifiers changed from: protected */
    public final void reset(boolean z4) {
        super.reset(z4);
        if (z4) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }
}
