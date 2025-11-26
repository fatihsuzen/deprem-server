package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class TrimmingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer;
    private int channelCount = -1;
    private byte[] endBuffer = new byte[0];
    private int endBufferSize;
    private boolean inputEnded;
    private boolean isActive;
    private ByteBuffer outputBuffer;
    private int pendingTrimStartBytes;
    private int sampleRateHz = -1;
    private int trimEndFrames;
    private int trimStartFrames;

    public TrimmingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    public final boolean configure(int i5, int i6, int i7) throws AudioProcessor.UnhandledFormatException {
        boolean z4;
        if (i7 == 2) {
            this.channelCount = i6;
            this.sampleRateHz = i5;
            int i8 = this.trimEndFrames;
            this.endBuffer = new byte[(i8 * i6 * 2)];
            this.endBufferSize = 0;
            int i9 = this.trimStartFrames;
            this.pendingTrimStartBytes = i6 * i9 * 2;
            boolean z5 = this.isActive;
            if (i9 == 0 && i8 == 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.isActive = z4;
            if (z5 != z4) {
                return true;
            }
            return false;
        }
        throw new AudioProcessor.UnhandledFormatException(i5, i6, i7);
    }

    public final void flush() {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
        this.pendingTrimStartBytes = 0;
        this.endBufferSize = 0;
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
        return this.isActive;
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

    public final void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i5 = limit - position;
        int min = Math.min(i5, this.pendingTrimStartBytes);
        this.pendingTrimStartBytes -= min;
        byteBuffer.position(position + min);
        if (this.pendingTrimStartBytes <= 0) {
            int i6 = i5 - min;
            int length = (this.endBufferSize + i6) - this.endBuffer.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
            this.buffer.put(this.endBuffer, 0, constrainValue);
            int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i6);
            byteBuffer.limit(byteBuffer.position() + constrainValue2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i7 = i6 - constrainValue2;
            int i8 = this.endBufferSize - constrainValue;
            this.endBufferSize = i8;
            byte[] bArr = this.endBuffer;
            System.arraycopy(bArr, constrainValue, bArr, 0, i8);
            byteBuffer.get(this.endBuffer, this.endBufferSize, i7);
            this.endBufferSize += i7;
            this.buffer.flip();
            this.outputBuffer = this.buffer;
        }
    }

    public final void reset() {
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.endBuffer = new byte[0];
    }

    public final void setTrimFrameCount(int i5, int i6) {
        this.trimStartFrames = i5;
        this.trimEndFrames = i6;
    }
}
