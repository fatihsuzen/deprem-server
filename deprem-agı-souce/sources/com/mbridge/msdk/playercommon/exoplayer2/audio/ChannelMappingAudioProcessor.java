package com.mbridge.msdk.playercommon.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class ChannelMappingAudioProcessor implements AudioProcessor {
    private boolean active;
    private ByteBuffer buffer;
    private int channelCount = -1;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    @Nullable
    private int[] outputChannels;
    @Nullable
    private int[] pendingOutputChannels;
    private int sampleRateHz = -1;

    public ChannelMappingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    public final boolean configure(int i5, int i6, int i7) throws AudioProcessor.UnhandledFormatException {
        boolean z4;
        boolean z5;
        boolean equals = Arrays.equals(this.pendingOutputChannels, this.outputChannels);
        boolean z6 = !equals;
        int[] iArr = this.pendingOutputChannels;
        this.outputChannels = iArr;
        if (iArr == null) {
            this.active = false;
            return z6;
        } else if (i7 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i5, i6, i7);
        } else if (equals && this.sampleRateHz == i5 && this.channelCount == i6) {
            return false;
        } else {
            this.sampleRateHz = i5;
            this.channelCount = i6;
            if (i6 != iArr.length) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.active = z4;
            int i8 = 0;
            while (true) {
                int[] iArr2 = this.outputChannels;
                if (i8 >= iArr2.length) {
                    return true;
                }
                int i9 = iArr2[i8];
                if (i9 < i6) {
                    boolean z7 = this.active;
                    if (i9 != i8) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    this.active = z5 | z7;
                    i8++;
                } else {
                    throw new AudioProcessor.UnhandledFormatException(i5, i6, i7);
                }
            }
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
        int[] iArr = this.outputChannels;
        if (iArr == null) {
            return this.channelCount;
        }
        return iArr.length;
    }

    public final int getOutputEncoding() {
        return 2;
    }

    public final int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    public final boolean isActive() {
        return this.active;
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
        boolean z4;
        if (this.outputChannels != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.outputChannels.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (position < limit) {
            for (int i5 : this.outputChannels) {
                this.buffer.putShort(byteBuffer.getShort((i5 * 2) + position));
            }
            position += this.channelCount * 2;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    public final void reset() {
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputChannels = null;
        this.pendingOutputChannels = null;
        this.active = false;
    }

    public final void setChannelMap(@Nullable int[] iArr) {
        this.pendingOutputChannels = iArr;
    }
}
