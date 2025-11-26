package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class OpusReader extends StreamReader {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int OPUS_CODE = Util.getIntegerCodeForString("Opus");
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final int SAMPLE_RATE = 48000;
    private boolean headerRead;

    OpusReader() {
    }

    private long getPacketDurationUs(byte[] bArr) {
        byte b5;
        int i5;
        byte b6 = bArr[0];
        byte b7 = b6 & 255;
        byte b8 = b6 & 3;
        if (b8 != 0) {
            b5 = 2;
            if (!(b8 == 1 || b8 == 2)) {
                b5 = bArr[1] & 63;
            }
        } else {
            b5 = 1;
        }
        int i6 = b7 >> 3;
        int i7 = i6 & 3;
        if (i6 >= 16) {
            i5 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i7;
        } else if (i6 >= 12) {
            i5 = 10000 << (i6 & 1);
        } else if (i7 == 3) {
            i5 = MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
        } else {
            i5 = 10000 << i7;
        }
        return ((long) b5) * ((long) i5);
    }

    private void putNativeOrderLong(List<byte[]> list, int i5) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i5) * C.NANOS_PER_SECOND) / 48000).array());
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int bytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (bytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public final long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.data));
    }

    /* access modifiers changed from: protected */
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j5, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        boolean z4 = true;
        if (!this.headerRead) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit());
            byte b5 = copyOf[9] & 255;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            putNativeOrderLong(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
            putNativeOrderLong(arrayList, DEFAULT_SEEK_PRE_ROLL_SAMPLES);
            setupData.format = Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_OPUS, (String) null, -1, -1, b5, SAMPLE_RATE, arrayList, (DrmInitData) null, 0, (String) null);
            this.headerRead = true;
            return true;
        }
        if (parsableByteArray.readInt() != OPUS_CODE) {
            z4 = false;
        }
        parsableByteArray.setPosition(0);
        return z4;
    }

    /* access modifiers changed from: protected */
    public final void reset(boolean z4) {
        super.reset(z4);
        if (z4) {
            this.headerRead = false;
        }
    }
}
