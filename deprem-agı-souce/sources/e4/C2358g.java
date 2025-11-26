package e4;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* renamed from: e4.g  reason: case insensitive filesystem */
public interface C2358g extends Z, ReadableByteChannel {
    C2356e buffer();

    boolean exhausted();

    C2356e g();

    InputStream inputStream();

    boolean k(long j5, C2359h hVar);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long j5);

    C2359h readByteString(long j5);

    long readDecimalLong();

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readUtf8(long j5);

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j5);

    void require(long j5);

    void skip(long j5);
}
