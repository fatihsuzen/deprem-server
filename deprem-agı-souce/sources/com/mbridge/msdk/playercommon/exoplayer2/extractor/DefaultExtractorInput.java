package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataSource dataSource;
    private byte[] peekBuffer = new byte[65536];
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final byte[] scratchSpace = new byte[4096];
    private final long streamLength;

    public DefaultExtractorInput(DataSource dataSource2, long j5, long j6) {
        this.dataSource = dataSource2;
        this.position = j5;
        this.streamLength = j6;
    }

    private void commitBytesRead(int i5) {
        if (i5 != -1) {
            this.position += (long) i5;
        }
    }

    private void ensureSpaceForPeek(int i5) {
        int i6 = this.peekBufferPosition + i5;
        byte[] bArr = this.peekBuffer;
        if (i6 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i6, i6 + 524288));
        }
    }

    private int readFromDataSource(byte[] bArr, int i5, int i6, int i7, boolean z4) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.dataSource.read(bArr, i5 + i7, i6 - i7);
            if (read != -1) {
                return i7 + read;
            }
            if (i7 == 0 && z4) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private int readFromPeekBuffer(byte[] bArr, int i5, int i6) {
        int i7 = this.peekBufferLength;
        if (i7 == 0) {
            return 0;
        }
        int min = Math.min(i7, i6);
        System.arraycopy(this.peekBuffer, 0, bArr, i5, min);
        updatePeekBuffer(min);
        return min;
    }

    private int skipFromPeekBuffer(int i5) {
        int min = Math.min(this.peekBufferLength, i5);
        updatePeekBuffer(min);
        return min;
    }

    private void updatePeekBuffer(int i5) {
        byte[] bArr;
        int i6 = this.peekBufferLength - i5;
        this.peekBufferLength = i6;
        this.peekBufferPosition = 0;
        byte[] bArr2 = this.peekBuffer;
        if (i6 < bArr2.length - 524288) {
            bArr = new byte[(65536 + i6)];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i5, bArr, 0, i6);
        this.peekBuffer = bArr;
    }

    public final boolean advancePeekPosition(int i5, boolean z4) throws IOException, InterruptedException {
        ensureSpaceForPeek(i5);
        int min = Math.min(this.peekBufferLength - this.peekBufferPosition, i5);
        while (min < i5) {
            int i6 = i5;
            boolean z5 = z4;
            min = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i6, min, z5);
            if (min == -1) {
                return false;
            }
            i5 = i6;
            z4 = z5;
        }
        int i7 = this.peekBufferPosition + i5;
        this.peekBufferPosition = i7;
        this.peekBufferLength = Math.max(this.peekBufferLength, i7);
        return true;
    }

    public final long getLength() {
        return this.streamLength;
    }

    public final long getPeekPosition() {
        return this.position + ((long) this.peekBufferPosition);
    }

    public final long getPosition() {
        return this.position;
    }

    public final boolean peekFully(byte[] bArr, int i5, int i6, boolean z4) throws IOException, InterruptedException {
        if (!advancePeekPosition(i6, z4)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i6, bArr, i5, i6);
        return true;
    }

    public final int read(byte[] bArr, int i5, int i6) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i5, i6);
        if (readFromPeekBuffer == 0) {
            readFromPeekBuffer = readFromDataSource(bArr, i5, i6, 0, true);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer;
    }

    public final boolean readFully(byte[] bArr, int i5, int i6, boolean z4) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i5, i6);
        while (readFromPeekBuffer < i6 && readFromPeekBuffer != -1) {
            readFromPeekBuffer = readFromDataSource(bArr, i5, i6, readFromPeekBuffer, z4);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer != -1;
    }

    public final void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    public final <E extends Throwable> void setRetryPosition(long j5, E e5) throws Throwable {
        boolean z4;
        if (j5 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.position = j5;
        throw e5;
    }

    public final int skip(int i5) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i5);
        if (skipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            skipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(i5, bArr.length), 0, true);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer;
    }

    public final boolean skipFully(int i5, boolean z4) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i5);
        while (skipFromPeekBuffer < i5 && skipFromPeekBuffer != -1) {
            skipFromPeekBuffer = readFromDataSource(this.scratchSpace, -skipFromPeekBuffer, Math.min(i5, this.scratchSpace.length + skipFromPeekBuffer), skipFromPeekBuffer, z4);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer != -1;
    }

    public final void peekFully(byte[] bArr, int i5, int i6) throws IOException, InterruptedException {
        peekFully(bArr, i5, i6, false);
    }

    public final void readFully(byte[] bArr, int i5, int i6) throws IOException, InterruptedException {
        readFully(bArr, i5, i6, false);
    }

    public final void advancePeekPosition(int i5) throws IOException, InterruptedException {
        advancePeekPosition(i5, false);
    }

    public final void skipFully(int i5) throws IOException, InterruptedException {
        skipFully(i5, false);
    }
}
