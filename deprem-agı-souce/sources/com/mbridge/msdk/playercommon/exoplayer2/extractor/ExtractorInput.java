package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import java.io.IOException;

public interface ExtractorInput {
    void advancePeekPosition(int i5) throws IOException, InterruptedException;

    boolean advancePeekPosition(int i5, boolean z4) throws IOException, InterruptedException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i5, int i6) throws IOException, InterruptedException;

    boolean peekFully(byte[] bArr, int i5, int i6, boolean z4) throws IOException, InterruptedException;

    int read(byte[] bArr, int i5, int i6) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i5, int i6) throws IOException, InterruptedException;

    boolean readFully(byte[] bArr, int i5, int i6, boolean z4) throws IOException, InterruptedException;

    void resetPeekPosition();

    <E extends Throwable> void setRetryPosition(long j5, E e5) throws Throwable;

    int skip(int i5) throws IOException, InterruptedException;

    void skipFully(int i5) throws IOException, InterruptedException;

    boolean skipFully(int i5, boolean z4) throws IOException, InterruptedException;
}
