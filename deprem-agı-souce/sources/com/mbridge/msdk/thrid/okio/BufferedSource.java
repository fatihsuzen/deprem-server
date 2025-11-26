package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer buffer();

    boolean exhausted() throws IOException;

    long indexOf(byte b5) throws IOException;

    long indexOf(byte b5, long j5) throws IOException;

    long indexOf(byte b5, long j5, long j6) throws IOException;

    long indexOf(ByteString byteString) throws IOException;

    long indexOf(ByteString byteString, long j5) throws IOException;

    long indexOfElement(ByteString byteString) throws IOException;

    long indexOfElement(ByteString byteString, long j5) throws IOException;

    InputStream inputStream();

    boolean rangeEquals(long j5, ByteString byteString) throws IOException;

    boolean rangeEquals(long j5, ByteString byteString, int i5, int i6) throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i5, int i6) throws IOException;

    long readAll(Sink sink) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long j5) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long j5) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(Buffer buffer, long j5) throws IOException;

    void readFully(byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readString(long j5, Charset charset) throws IOException;

    String readString(Charset charset) throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long j5) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @Nullable
    String readUtf8Line() throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long j5) throws IOException;

    boolean request(long j5) throws IOException;

    void require(long j5) throws IOException;

    int select(Options options) throws IOException;

    void skip(long j5) throws IOException;
}
