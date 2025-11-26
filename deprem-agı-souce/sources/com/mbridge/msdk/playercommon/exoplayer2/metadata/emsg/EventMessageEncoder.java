package com.mbridge.msdk.playercommon.exoplayer2.metadata.emsg;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        this.byteArrayOutputStream = byteArrayOutputStream2;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream2, String str) throws IOException {
        dataOutputStream2.writeBytes(str);
        dataOutputStream2.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream dataOutputStream2, long j5) throws IOException {
        dataOutputStream2.writeByte(((int) (j5 >>> 24)) & 255);
        dataOutputStream2.writeByte(((int) (j5 >>> 16)) & 255);
        dataOutputStream2.writeByte(((int) (j5 >>> 8)) & 255);
        dataOutputStream2.writeByte(((int) j5) & 255);
    }

    @Nullable
    public final byte[] encode(EventMessage eventMessage, long j5) {
        boolean z4;
        if (j5 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            writeNullTerminatedString(this.dataOutputStream, str);
            writeUnsignedInt(this.dataOutputStream, j5);
            long j6 = j5;
            writeUnsignedInt(this.dataOutputStream, Util.scaleLargeTimestamp(eventMessage.presentationTimeUs, j6, 1000000));
            writeUnsignedInt(this.dataOutputStream, Util.scaleLargeTimestamp(eventMessage.durationMs, j6, 1000));
            writeUnsignedInt(this.dataOutputStream, eventMessage.id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }
}
