package e4;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* renamed from: e4.f  reason: case insensitive filesystem */
public interface C2357f extends X, WritableByteChannel {
    C2356e buffer();

    C2357f emitCompleteSegments();

    void flush();

    OutputStream outputStream();

    C2357f write(byte[] bArr);

    C2357f write(byte[] bArr, int i5, int i6);

    C2357f writeByte(int i5);

    C2357f writeDecimalLong(long j5);

    C2357f writeHexadecimalUnsignedLong(long j5);

    C2357f writeInt(int i5);

    C2357f writeShort(int i5);

    C2357f writeUtf8(String str);
}
