package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SilenceSkippingAudioProcessor implements AudioProcessor {
    private static final long MINIMUM_SILENCE_DURATION_US = 150000;
    private static final long PADDING_SILENCE_US = 20000;
    private static final short SILENCE_THRESHOLD_LEVEL = 1024;
    private static final byte SILENCE_THRESHOLD_LEVEL_MSB = 4;
    private static final int STATE_MAYBE_SILENT = 1;
    private static final int STATE_NOISY = 0;
    private static final int STATE_SILENT = 2;
    private ByteBuffer buffer;
    private int bytesPerFrame;
    private int channelCount = -1;
    private boolean enabled;
    private boolean hasOutputNoise;
    private boolean inputEnded;
    private byte[] maybeSilenceBuffer = new byte[0];
    private int maybeSilenceBufferSize;
    private ByteBuffer outputBuffer;
    private byte[] paddingBuffer = new byte[0];
    private int paddingSize;
    private int sampleRateHz = -1;
    private long skippedFrames;
    private int state;

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public SilenceSkippingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    private int durationUsToFrames(long j5) {
        return (int) ((j5 * ((long) this.sampleRateHz)) / 1000000);
    }

    private int findNoiseLimit(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (Math.abs(byteBuffer.get(limit)) > 4) {
                int i5 = this.bytesPerFrame;
                return ((limit / i5) * i5) + i5;
            }
        }
        return byteBuffer.position();
    }

    private int findNoisePosition(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.get(position)) > 4) {
                int i5 = this.bytesPerFrame;
                return i5 * (position / i5);
            }
        }
        return byteBuffer.limit();
    }

    private void output(byte[] bArr, int i5) {
        prepareForOutput(i5);
        this.buffer.put(bArr, 0, i5);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    private void prepareForOutput(int i5) {
        if (this.buffer.capacity() < i5) {
            this.buffer = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        if (i5 > 0) {
            this.hasOutputNoise = true;
        }
    }

    private void processMaybeSilence(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int findNoisePosition = findNoisePosition(byteBuffer);
        int position = findNoisePosition - byteBuffer.position();
        byte[] bArr = this.maybeSilenceBuffer;
        int length = bArr.length;
        int i5 = this.maybeSilenceBufferSize;
        int i6 = length - i5;
        if (findNoisePosition >= limit || position >= i6) {
            int min = Math.min(position, i6);
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer.get(this.maybeSilenceBuffer, this.maybeSilenceBufferSize, min);
            int i7 = this.maybeSilenceBufferSize + min;
            this.maybeSilenceBufferSize = i7;
            byte[] bArr2 = this.maybeSilenceBuffer;
            if (i7 == bArr2.length) {
                if (this.hasOutputNoise) {
                    output(bArr2, this.paddingSize);
                    this.skippedFrames += (long) ((this.maybeSilenceBufferSize - (this.paddingSize * 2)) / this.bytesPerFrame);
                } else {
                    this.skippedFrames += (long) ((i7 - this.paddingSize) / this.bytesPerFrame);
                }
                updatePaddingBuffer(byteBuffer, this.maybeSilenceBuffer, this.maybeSilenceBufferSize);
                this.maybeSilenceBufferSize = 0;
                this.state = 2;
            }
            byteBuffer.limit(limit);
            return;
        }
        output(bArr, i5);
        this.maybeSilenceBufferSize = 0;
        this.state = 0;
    }

    private void processNoisy(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.maybeSilenceBuffer.length));
        int findNoiseLimit = findNoiseLimit(byteBuffer);
        if (findNoiseLimit == byteBuffer.position()) {
            this.state = 1;
        } else {
            byteBuffer.limit(findNoiseLimit);
            output(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void processSilence(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int findNoisePosition = findNoisePosition(byteBuffer);
        byteBuffer.limit(findNoisePosition);
        this.skippedFrames += (long) (byteBuffer.remaining() / this.bytesPerFrame);
        updatePaddingBuffer(byteBuffer, this.paddingBuffer, this.paddingSize);
        if (findNoisePosition < limit) {
            output(this.paddingBuffer, this.paddingSize);
            this.state = 0;
            byteBuffer.limit(limit);
        }
    }

    private void updatePaddingBuffer(ByteBuffer byteBuffer, byte[] bArr, int i5) {
        int min = Math.min(byteBuffer.remaining(), this.paddingSize);
        int i6 = this.paddingSize - min;
        System.arraycopy(bArr, i5 - i6, this.paddingBuffer, 0, i6);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.paddingBuffer, i6, min);
    }

    public final boolean configure(int i5, int i6, int i7) throws AudioProcessor.UnhandledFormatException {
        if (i7 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i5, i6, i7);
        } else if (this.sampleRateHz == i5 && this.channelCount == i6) {
            return false;
        } else {
            this.sampleRateHz = i5;
            this.channelCount = i6;
            this.bytesPerFrame = i6 * 2;
            return true;
        }
    }

    public final void flush() {
        if (isActive()) {
            int durationUsToFrames = durationUsToFrames(MINIMUM_SILENCE_DURATION_US) * this.bytesPerFrame;
            if (this.maybeSilenceBuffer.length != durationUsToFrames) {
                this.maybeSilenceBuffer = new byte[durationUsToFrames];
            }
            int durationUsToFrames2 = durationUsToFrames(PADDING_SILENCE_US) * this.bytesPerFrame;
            this.paddingSize = durationUsToFrames2;
            if (this.paddingBuffer.length != durationUsToFrames2) {
                this.paddingBuffer = new byte[durationUsToFrames2];
            }
        }
        this.state = 0;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
        this.skippedFrames = 0;
        this.maybeSilenceBufferSize = 0;
        this.hasOutputNoise = false;
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

    public final long getSkippedFrames() {
        return this.skippedFrames;
    }

    public final boolean isActive() {
        if (this.sampleRateHz == -1 || !this.enabled) {
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
        int i5 = this.maybeSilenceBufferSize;
        if (i5 > 0) {
            output(this.maybeSilenceBuffer, i5);
        }
        if (!this.hasOutputNoise) {
            this.skippedFrames += (long) (this.paddingSize / this.bytesPerFrame);
        }
    }

    public final void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.outputBuffer.hasRemaining()) {
            int i5 = this.state;
            if (i5 == 0) {
                processNoisy(byteBuffer);
            } else if (i5 == 1) {
                processMaybeSilence(byteBuffer);
            } else if (i5 == 2) {
                processSilence(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final void reset() {
        this.enabled = false;
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.paddingSize = 0;
        this.maybeSilenceBuffer = new byte[0];
        this.paddingBuffer = new byte[0];
    }

    public final void setEnabled(boolean z4) {
        this.enabled = z4;
        flush();
    }

    private void output(ByteBuffer byteBuffer) {
        prepareForOutput(byteBuffer.remaining());
        this.buffer.put(byteBuffer);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }
}
