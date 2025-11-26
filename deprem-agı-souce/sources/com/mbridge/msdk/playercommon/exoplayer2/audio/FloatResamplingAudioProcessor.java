package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class FloatResamplingAudioProcessor implements AudioProcessor {
    private static final int FLOAT_NAN_AS_INT = Float.floatToIntBits(Float.NaN);
    private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656612875245797E-10d;
    private ByteBuffer buffer;
    private int channelCount = -1;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    private int sampleRateHz = -1;
    private int sourceEncoding = 0;

    public FloatResamplingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    private static void writePcm32BitFloat(int i5, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i5) * PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR));
        if (floatToIntBits == FLOAT_NAN_AS_INT) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final boolean configure(int i5, int i6, int i7) throws AudioProcessor.UnhandledFormatException {
        if (!Util.isEncodingHighResolutionIntegerPcm(i7)) {
            throw new AudioProcessor.UnhandledFormatException(i5, i6, i7);
        } else if (this.sampleRateHz == i5 && this.channelCount == i6 && this.sourceEncoding == i7) {
            return false;
        } else {
            this.sampleRateHz = i5;
            this.channelCount = i6;
            this.sourceEncoding = i7;
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
        return 4;
    }

    public final int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    public final boolean isActive() {
        return Util.isEncodingHighResolutionIntegerPcm(this.sourceEncoding);
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
        if (this.sourceEncoding == 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i5 = limit - position;
        if (!z4) {
            i5 = (i5 / 3) * 4;
        }
        if (this.buffer.capacity() < i5) {
            this.buffer = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        if (z4) {
            while (position < limit) {
                writePcm32BitFloat((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), this.buffer);
                position += 4;
            }
        } else {
            while (position < limit) {
                writePcm32BitFloat(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), this.buffer);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    public final void reset() {
        flush();
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.sourceEncoding = 0;
        this.buffer = AudioProcessor.EMPTY_BUFFER;
    }
}
