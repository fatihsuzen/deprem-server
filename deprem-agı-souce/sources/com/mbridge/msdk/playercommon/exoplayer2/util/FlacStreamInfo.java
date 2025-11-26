package com.mbridge.msdk.playercommon.exoplayer2.util;

public final class FlacStreamInfo {
    public final int bitsPerSample;
    public final int channels;
    public final int maxBlockSize;
    public final int maxFrameSize;
    public final int minBlockSize;
    public final int minFrameSize;
    public final int sampleRate;
    public final long totalSamples;

    public FlacStreamInfo(byte[] bArr, int i5) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.setPosition(i5 * 8);
        this.minBlockSize = parsableBitArray.readBits(16);
        this.maxBlockSize = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        this.sampleRate = parsableBitArray.readBits(20);
        this.channels = parsableBitArray.readBits(3) + 1;
        this.bitsPerSample = parsableBitArray.readBits(5) + 1;
        this.totalSamples = ((((long) parsableBitArray.readBits(4)) & 15) << 32) | (((long) parsableBitArray.readBits(32)) & 4294967295L);
    }

    public final int bitRate() {
        return this.bitsPerSample * this.sampleRate;
    }

    public final long durationUs() {
        return (this.totalSamples * 1000000) / ((long) this.sampleRate);
    }

    public final long getApproxBytesPerFrame() {
        long j5;
        long j6;
        long j7;
        int i5 = this.maxFrameSize;
        if (i5 > 0) {
            j6 = (((long) i5) + ((long) this.minFrameSize)) / 2;
            j7 = 1;
        } else {
            int i6 = this.minBlockSize;
            if (i6 != this.maxBlockSize || i6 <= 0) {
                j5 = 4096;
            } else {
                j5 = (long) i6;
            }
            j6 = ((j5 * ((long) this.channels)) * ((long) this.bitsPerSample)) / 8;
            j7 = 64;
        }
        return j6 + j7;
    }

    public final long getSampleIndex(long j5) {
        return Util.constrainValue((j5 * ((long) this.sampleRate)) / 1000000, 0, this.totalSamples - 1);
    }

    public final int maxDecodedFrameSize() {
        return this.maxBlockSize * this.channels * (this.bitsPerSample / 8);
    }

    public FlacStreamInfo(int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j5) {
        this.minBlockSize = i5;
        this.maxBlockSize = i6;
        this.minFrameSize = i7;
        this.maxFrameSize = i8;
        this.sampleRate = i9;
        this.channels = i10;
        this.bitsPerSample = i11;
        this.totalSamples = j5;
    }
}
