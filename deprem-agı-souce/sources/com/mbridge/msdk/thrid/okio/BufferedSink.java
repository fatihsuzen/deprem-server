package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    void flush() throws IOException;

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(Source source, long j5) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i5, int i6) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int i5) throws IOException;

    BufferedSink writeDecimalLong(long j5) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j5) throws IOException;

    BufferedSink writeInt(int i5) throws IOException;

    BufferedSink writeIntLe(int i5) throws IOException;

    BufferedSink writeLong(long j5) throws IOException;

    BufferedSink writeLongLe(long j5) throws IOException;

    BufferedSink writeShort(int i5) throws IOException;

    BufferedSink writeShortLe(int i5) throws IOException;

    BufferedSink writeString(String str, int i5, int i6, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int i5, int i6) throws IOException;

    BufferedSink writeUtf8CodePoint(int i5) throws IOException;
}
