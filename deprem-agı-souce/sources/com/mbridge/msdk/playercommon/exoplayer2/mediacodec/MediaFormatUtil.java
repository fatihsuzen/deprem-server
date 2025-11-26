package com.mbridge.msdk.playercommon.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public final class MediaFormatUtil {
    private MediaFormatUtil() {
    }

    public static void maybeSetByteBuffer(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetColorInfo(MediaFormat mediaFormat, @Nullable ColorInfo colorInfo) {
        if (colorInfo != null) {
            maybeSetInteger(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            maybeSetInteger(mediaFormat, "color-standard", colorInfo.colorSpace);
            maybeSetInteger(mediaFormat, "color-range", colorInfo.colorRange);
            maybeSetByteBuffer(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }

    public static void maybeSetFloat(MediaFormat mediaFormat, String str, float f5) {
        if (f5 != -1.0f) {
            mediaFormat.setFloat(str, f5);
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat, String str, int i5) {
        if (i5 != -1) {
            mediaFormat.setInteger(str, i5);
        }
    }

    public static void setCsdBuffers(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            mediaFormat.setByteBuffer("csd-" + i5, ByteBuffer.wrap(list.get(i5)));
        }
    }

    public static void setString(MediaFormat mediaFormat, String str, String str2) {
        mediaFormat.setString(str, str2);
    }
}
