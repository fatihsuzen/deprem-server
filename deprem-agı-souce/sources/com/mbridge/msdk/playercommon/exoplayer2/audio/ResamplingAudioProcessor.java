package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

final class ResamplingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer;
    private int channelCount = -1;
    private int encoding = 0;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    private int sampleRateHz = -1;

    public ResamplingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    public final boolean configure(int i5, int i6, int i7) throws AudioProcessor.UnhandledFormatException {
        if (i7 != 3 && i7 != 2 && i7 != Integer.MIN_VALUE && i7 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i5, i6, i7);
        } else if (this.sampleRateHz == i5 && this.channelCount == i6 && this.encoding == i7) {
            return false;
        } else {
            this.sampleRateHz = i5;
            this.channelCount = i6;
            this.encoding = i7;
            return true;
        }
    }

    public final void flush() {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
    }

    public final ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    public final int getOutputChannelCount() {
        return this.channelCount;
    }

    public final int getOutputEncoding() {
        return 2;
    }

    public final int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    public final boolean isActive() {
        int i5 = this.encoding;
        if (i5 == 0 || i5 == 2) {
            return false;
        }
        return true;
    }

    public final boolean isEnded() {
        if (!this.inputEnded || this.outputBuffer != AudioProcessor.EMPTY_BUFFER) {
            return false;
        }
        return true;
    }

    public final void queueEndOfStream() {
        this.inputEnded = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083 A[LOOP:2: B:23:0x0083->B:24:0x0085, LOOP_START, PHI: r0 
      PHI: (r0v2 int) = (r0v0 int), (r0v3 int) binds: [B:14:0x0043, B:24:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void queueInput(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.encoding
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 3
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r6) goto L_0x0023
            if (r3 == r5) goto L_0x0020
            if (r3 != r4) goto L_0x001a
            int r2 = r2 / 2
            goto L_0x0025
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0020:
            int r2 = r2 * 2
            goto L_0x0025
        L_0x0023:
            int r2 = r2 / r5
            goto L_0x0020
        L_0x0025:
            java.nio.ByteBuffer r3 = r7.buffer
            int r3 = r3.capacity()
            if (r3 >= r2) goto L_0x003c
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.buffer = r2
            goto L_0x0041
        L_0x003c:
            java.nio.ByteBuffer r2 = r7.buffer
            r2.clear()
        L_0x0041:
            int r2 = r7.encoding
            if (r2 == r6) goto L_0x0083
            if (r2 == r5) goto L_0x006a
            if (r2 != r4) goto L_0x0064
        L_0x0049:
            if (r0 >= r1) goto L_0x009e
            java.nio.ByteBuffer r2 = r7.buffer
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.buffer
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x0049
        L_0x0064:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x006a:
            if (r0 >= r1) goto L_0x009e
            java.nio.ByteBuffer r2 = r7.buffer
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.buffer
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L_0x006a
        L_0x0083:
            if (r0 >= r1) goto L_0x009e
            java.nio.ByteBuffer r2 = r7.buffer
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.buffer
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L_0x0083
        L_0x009e:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.buffer
            r8.flip()
            java.nio.ByteBuffer r8 = r7.buffer
            r7.outputBuffer = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.ResamplingAudioProcessor.queueInput(java.nio.ByteBuffer):void");
    }

    public final void reset() {
        flush();
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.encoding = 0;
        this.buffer = AudioProcessor.EMPTY_BUFFER;
    }
}
