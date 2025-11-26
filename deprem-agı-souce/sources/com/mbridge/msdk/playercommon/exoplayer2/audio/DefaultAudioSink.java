package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioTrackPositionTracker;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class DefaultAudioSink implements AudioSink {
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int ERROR_BAD_VALUE = -2;
    private static final long MAX_BUFFER_DURATION_US = 750000;
    private static final long MIN_BUFFER_DURATION_US = 250000;
    private static final int MODE_STATIC = 0;
    private static final int MODE_STREAM = 1;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final String TAG = "AudioTrack";
    @SuppressLint({"InlinedApi"})
    private static final int WRITE_NON_BLOCKING = 1;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioProcessor[] activeAudioProcessors;
    @Nullable
    private PlaybackParameters afterDrainPlaybackParameters;
    private AudioAttributes audioAttributes;
    @Nullable
    private final AudioCapabilities audioCapabilities;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    @Nullable
    private ByteBuffer avSyncHeader;
    private int bufferSize;
    private int bytesUntilNextAvSync;
    private boolean canApplyPlaybackParameters;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private int drainingAudioProcessorIndex;
    private final boolean enableConvertHighResIntPcmToFloat;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    @Nullable
    private ByteBuffer inputBuffer;
    private int inputSampleRate;
    private boolean isInputPcm;
    @Nullable
    private AudioTrack keepSessionIdAudioTrack;
    /* access modifiers changed from: private */
    public long lastFeedElapsedRealtimeMs;
    /* access modifiers changed from: private */
    @Nullable
    public AudioSink.Listener listener;
    @Nullable
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private int outputChannelConfig;
    private int outputEncoding;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private int pcmFrameSize;
    private PlaybackParameters playbackParameters;
    private final ArrayDeque<PlaybackParametersCheckpoint> playbackParametersCheckpoints;
    private long playbackParametersOffsetUs;
    private long playbackParametersPositionUs;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private boolean processingEnabled;
    /* access modifiers changed from: private */
    public final ConditionVariable releasingConditionVariable;
    private boolean shouldConvertHighResIntPcmToFloat;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public interface AudioProcessorChain {
        PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j5);

        long getSkippedOutputFrameCount();
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            AudioProcessor[] audioProcessorArr2 = (AudioProcessor[]) Arrays.copyOf(audioProcessorArr, audioProcessorArr.length + 2);
            this.audioProcessors = audioProcessorArr2;
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor2 = new SilenceSkippingAudioProcessor();
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor2;
            SonicAudioProcessor sonicAudioProcessor2 = new SonicAudioProcessor();
            this.sonicAudioProcessor = sonicAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor2;
        }

        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            this.silenceSkippingAudioProcessor.setEnabled(playbackParameters.skipSilence);
            return new PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters.speed), this.sonicAudioProcessor.setPitch(playbackParameters.pitch), playbackParameters.skipSilence);
        }

        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        public long getMediaDuration(long j5) {
            return this.sonicAudioProcessor.scaleDurationForSpeedup(j5);
        }

        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    private static final class PlaybackParametersCheckpoint {
        /* access modifiers changed from: private */
        public final long mediaTimeUs;
        /* access modifiers changed from: private */
        public final PlaybackParameters playbackParameters;
        /* access modifiers changed from: private */
        public final long positionUs;

        private PlaybackParametersCheckpoint(PlaybackParameters playbackParameters2, long j5, long j6) {
            this.playbackParameters = playbackParameters2;
            this.mediaTimeUs = j5;
            this.positionUs = j6;
        }
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public final void onInvalidLatency(long j5) {
            Log.w(DefaultAudioSink.TAG, "Ignoring impossibly large audio latency: " + j5);
        }

        public final void onPositionFramesMismatch(long j5, long j6, long j7, long j8) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j5 + ", " + j6 + ", " + j7 + ", " + j8 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public final void onSystemTimeUsMismatch(long j5, long j6, long j7, long j8) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j5 + ", " + j6 + ", " + j7 + ", " + j8 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public final void onUnderrun(int i5, long j5) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(i5, j5, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface StartMediaTimeState {
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities2, audioProcessorArr, false);
    }

    private long applySkipping(long j5) {
        return j5 + framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private long applySpeedup(long j5) {
        long j6;
        long mediaDurationForPlayoutDuration;
        PlaybackParametersCheckpoint playbackParametersCheckpoint = null;
        while (!this.playbackParametersCheckpoints.isEmpty() && j5 >= this.playbackParametersCheckpoints.getFirst().positionUs) {
            playbackParametersCheckpoint = this.playbackParametersCheckpoints.remove();
        }
        if (playbackParametersCheckpoint != null) {
            this.playbackParameters = playbackParametersCheckpoint.playbackParameters;
            this.playbackParametersPositionUs = playbackParametersCheckpoint.positionUs;
            this.playbackParametersOffsetUs = playbackParametersCheckpoint.mediaTimeUs - this.startMediaTimeUs;
        }
        if (this.playbackParameters.speed == 1.0f) {
            return (j5 + this.playbackParametersOffsetUs) - this.playbackParametersPositionUs;
        }
        if (this.playbackParametersCheckpoints.isEmpty()) {
            j6 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = this.audioProcessorChain.getMediaDuration(j5 - this.playbackParametersPositionUs);
        } else {
            j6 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(j5 - this.playbackParametersPositionUs, this.playbackParameters.speed);
        }
        return j6 + mediaDurationForPlayoutDuration;
    }

    @TargetApi(21)
    private AudioTrack createAudioTrackV21() {
        AudioAttributes audioAttributesV21;
        if (this.tunneling) {
            audioAttributesV21 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributesV21 = this.audioAttributes.getAudioAttributesV21();
        }
        AudioAttributes audioAttributes2 = audioAttributesV21;
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.outputChannelConfig).setEncoding(this.outputEncoding).setSampleRate(this.outputSampleRate).build();
        int i5 = this.audioSessionId;
        if (i5 == 0) {
            i5 = 0;
        }
        return new AudioTrack(audioAttributes2, build, this.bufferSize, 1, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean drainAudioProcessorsToEndOfStream() throws com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.drainingAudioProcessorIndex
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L_0x0014
            boolean r0 = r9.processingEnabled
            if (r0 == 0) goto L_0x000d
            r0 = r2
            goto L_0x0010
        L_0x000d:
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[] r0 = r9.activeAudioProcessors
            int r0 = r0.length
        L_0x0010:
            r9.drainingAudioProcessorIndex = r0
        L_0x0012:
            r0 = r1
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            int r4 = r9.drainingAudioProcessorIndex
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[] r5 = r9.activeAudioProcessors
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.queueEndOfStream()
        L_0x0028:
            r9.processBuffers(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L_0x0032
            return r2
        L_0x0032:
            int r0 = r9.drainingAudioProcessorIndex
            int r0 = r0 + r1
            r9.drainingAudioProcessorIndex = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L_0x0044
            r9.writeBuffer(r0, r7)
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L_0x0044
            return r2
        L_0x0044:
            r9.drainingAudioProcessorIndex = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.drainAudioProcessorsToEndOfStream():boolean");
    }

    private long durationUsToFrames(long j5) {
        return (j5 * ((long) this.outputSampleRate)) / 1000000;
    }

    private void flushAudioProcessors() {
        int i5 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i5 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i5];
                audioProcessor.flush();
                this.outputBuffers[i5] = audioProcessor.getOutput();
                i5++;
            } else {
                return;
            }
        }
    }

    private long framesToDurationUs(long j5) {
        return (j5 * 1000000) / ((long) this.outputSampleRate);
    }

    private AudioProcessor[] getAvailableAudioProcessors() {
        if (this.shouldConvertHighResIntPcmToFloat) {
            return this.toFloatPcmAvailableAudioProcessors;
        }
        return this.toIntPcmAvailableAudioProcessors;
    }

    private static int getFramesPerEncodedSample(int i5, ByteBuffer byteBuffer) {
        if (i5 == 7 || i5 == 8) {
            return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
        }
        if (i5 == 5) {
            return Ac3Util.getAc3SyncframeAudioSampleCount();
        }
        if (i5 == 6) {
            return Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
        }
        if (i5 == 14) {
            int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
            if (findTrueHdSyncframeOffset == -1) {
                return 0;
            }
            return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i5);
    }

    /* access modifiers changed from: private */
    public long getSubmittedFrames() {
        if (this.isInputPcm) {
            return this.submittedPcmBytes / ((long) this.pcmFrameSize);
        }
        return this.submittedEncodedFrames;
    }

    /* access modifiers changed from: private */
    public long getWrittenFrames() {
        if (this.isInputPcm) {
            return this.writtenPcmBytes / ((long) this.outputPcmFrameSize);
        }
        return this.writtenEncodedFrames;
    }

    private void initialize() throws AudioSink.InitializationException {
        PlaybackParameters playbackParameters2;
        this.releasingConditionVariable.block();
        AudioTrack initializeAudioTrack = initializeAudioTrack();
        this.audioTrack = initializeAudioTrack;
        int audioSessionId2 = initializeAudioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            AudioTrack audioTrack2 = this.keepSessionIdAudioTrack;
            if (!(audioTrack2 == null || audioSessionId2 == audioTrack2.getAudioSessionId())) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId2);
            }
        }
        if (this.audioSessionId != audioSessionId2) {
            this.audioSessionId = audioSessionId2;
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAudioSessionId(audioSessionId2);
            }
        }
        if (this.canApplyPlaybackParameters) {
            playbackParameters2 = this.audioProcessorChain.applyPlaybackParameters(this.playbackParameters);
        } else {
            playbackParameters2 = PlaybackParameters.DEFAULT;
        }
        this.playbackParameters = playbackParameters2;
        setupAudioProcessors();
        this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.outputEncoding, this.outputPcmFrameSize, this.bufferSize);
        setVolumeInternal();
    }

    private AudioTrack initializeAudioTrack() throws AudioSink.InitializationException {
        AudioTrack audioTrack2;
        AudioTrack audioTrack3;
        if (Util.SDK_INT >= 21) {
            audioTrack2 = createAudioTrackV21();
        } else {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
            if (this.audioSessionId == 0) {
                audioTrack3 = new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
            } else {
                audioTrack3 = new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, this.audioSessionId);
            }
            audioTrack2 = audioTrack3;
        }
        int state = audioTrack2.getState();
        if (state == 1) {
            return audioTrack2;
        }
        try {
            audioTrack2.release();
        } catch (Exception unused) {
        }
        throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize);
    }

    private AudioTrack initializeKeepSessionIdAudioTrack(int i5) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i5);
    }

    private long inputFramesToDurationUs(long j5) {
        return (j5 * 1000000) / ((long) this.inputSampleRate);
    }

    private boolean isInitialized() {
        if (this.audioTrack != null) {
            return true;
        }
        return false;
    }

    private void processBuffers(long j5) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i5 = length;
        while (i5 >= 0) {
            if (i5 > 0) {
                byteBuffer = this.outputBuffers[i5 - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i5 == length) {
                writeBuffer(byteBuffer, j5);
            } else {
                AudioProcessor audioProcessor = this.activeAudioProcessors[i5];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i5] = output;
                if (output.hasRemaining()) {
                    i5++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i5--;
            } else {
                return;
            }
        }
    }

    private void releaseKeepSessionIdAudioTrack() {
        final AudioTrack audioTrack2 = this.keepSessionIdAudioTrack;
        if (audioTrack2 != null) {
            this.keepSessionIdAudioTrack = null;
            new Thread() {
                public void run() {
                    audioTrack2.release();
                }
            }.start();
        }
    }

    private void setVolumeInternal() {
        if (isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    @TargetApi(21)
    private static void setVolumeInternalV21(AudioTrack audioTrack2, float f5) {
        audioTrack2.setVolume(f5);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack2, float f5) {
        audioTrack2.setStereoVolume(f5, f5);
    }

    private void setupAudioProcessors() {
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        flushAudioProcessors();
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j5) throws AudioSink.WriteException {
        DefaultAudioSink defaultAudioSink;
        boolean z4;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        boolean z5 = true;
        int i5 = 0;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
        } else {
            this.outputBuffer = byteBuffer;
            if (Util.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.preV21OutputBuffer;
                if (bArr == null || bArr.length < remaining) {
                    this.preV21OutputBuffer = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                byteBuffer.position(position);
                this.preV21OutputBufferOffset = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (Util.SDK_INT < 21) {
            int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
            if (availableBufferSize > 0 && (i5 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, availableBufferSize))) > 0) {
                this.preV21OutputBufferOffset += i5;
                byteBuffer.position(byteBuffer.position() + i5);
            }
            defaultAudioSink = this;
        } else if (this.tunneling) {
            if (j5 == C.TIME_UNSET) {
                z5 = false;
            }
            Assertions.checkState(z5);
            defaultAudioSink = this;
            i5 = defaultAudioSink.writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j5);
        } else {
            defaultAudioSink = this;
            i5 = writeNonBlockingV21(defaultAudioSink.audioTrack, byteBuffer, remaining2);
        }
        defaultAudioSink.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
        if (i5 >= 0) {
            boolean z6 = defaultAudioSink.isInputPcm;
            if (z6) {
                defaultAudioSink.writtenPcmBytes += (long) i5;
            }
            if (i5 == remaining2) {
                if (!z6) {
                    defaultAudioSink.writtenEncodedFrames += (long) defaultAudioSink.framesPerEncodedSample;
                }
                defaultAudioSink.outputBuffer = null;
                return;
            }
            return;
        }
        throw new AudioSink.WriteException(i5);
    }

    @TargetApi(21)
    private static int writeNonBlockingV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i5) {
        return audioTrack2.write(byteBuffer, i5, 1);
    }

    @TargetApi(21)
    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i5, long j5) {
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i5);
            this.avSyncHeader.putLong(8, j5 * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i5;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack2.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack2, byteBuffer, i5);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0115 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0116  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure(int r18, int r19, int r20, int r21, @androidx.annotation.Nullable int[] r22, int r23, int r24) throws com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink.ConfigurationException {
        /*
            r17 = this;
            r1 = r17
            r0 = r21
            r2 = r20
            r1.inputSampleRate = r2
            boolean r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.isEncodingPcm(r18)
            r1.isInputPcm = r3
            boolean r3 = r1.enableConvertHighResIntPcmToFloat
            r4 = 1
            if (r3 == 0) goto L_0x0023
            r3 = 1073741824(0x40000000, float:2.0)
            boolean r3 = r1.isEncodingSupported(r3)
            if (r3 == 0) goto L_0x0023
            boolean r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.isEncodingHighResolutionIntegerPcm(r18)
            if (r3 == 0) goto L_0x0023
            r3 = r4
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            r1.shouldConvertHighResIntPcmToFloat = r3
            boolean r3 = r1.isInputPcm
            if (r3 == 0) goto L_0x0030
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmFrameSize(r18, r19)
            r1.pcmFrameSize = r3
        L_0x0030:
            boolean r3 = r1.isInputPcm
            r6 = 4
            if (r3 == 0) goto L_0x003b
            r3 = r18
            if (r3 == r6) goto L_0x003d
            r7 = r4
            goto L_0x003e
        L_0x003b:
            r3 = r18
        L_0x003d:
            r7 = 0
        L_0x003e:
            if (r7 == 0) goto L_0x0046
            boolean r8 = r1.shouldConvertHighResIntPcmToFloat
            if (r8 != 0) goto L_0x0046
            r8 = r4
            goto L_0x0047
        L_0x0046:
            r8 = 0
        L_0x0047:
            r1.canApplyPlaybackParameters = r8
            if (r7 == 0) goto L_0x008f
            com.mbridge.msdk.playercommon.exoplayer2.audio.TrimmingAudioProcessor r8 = r1.trimmingAudioProcessor
            r9 = r23
            r10 = r24
            r8.setTrimFrameCount(r9, r10)
            com.mbridge.msdk.playercommon.exoplayer2.audio.ChannelMappingAudioProcessor r8 = r1.channelMappingAudioProcessor
            r9 = r22
            r8.setChannelMap(r9)
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[] r8 = r1.getAvailableAudioProcessors()
            int r9 = r8.length
            r10 = r2
            r11 = 0
            r12 = 0
            r2 = r19
        L_0x0065:
            if (r11 >= r9) goto L_0x0093
            r13 = r8[r11]
            boolean r14 = r13.configure(r10, r2, r3)     // Catch:{ UnhandledFormatException -> 0x0088 }
            r12 = r12 | r14
            boolean r14 = r13.isActive()
            if (r14 == 0) goto L_0x0085
            int r2 = r13.getOutputChannelCount()
            int r3 = r13.getOutputSampleRateHz()
            int r10 = r13.getOutputEncoding()
            r16 = r10
            r10 = r3
            r3 = r16
        L_0x0085:
            int r11 = r11 + 1
            goto L_0x0065
        L_0x0088:
            r0 = move-exception
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink$ConfigurationException r2 = new com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink$ConfigurationException
            r2.<init>((java.lang.Throwable) r0)
            throw r2
        L_0x008f:
            r10 = r2
            r12 = 0
            r2 = r19
        L_0x0093:
            r8 = 12
            r9 = 252(0xfc, float:3.53E-43)
            switch(r2) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bf;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00b9;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00b4;
                case 8: goto L_0x00b1;
                default: goto L_0x009a;
            }
        L_0x009a:
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink$ConfigurationException r0 = new com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink$ConfigurationException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unsupported channel count: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x00b1:
            int r6 = com.mbridge.msdk.playercommon.exoplayer2.C.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00c3
        L_0x00b4:
            r6 = 1276(0x4fc, float:1.788E-42)
            goto L_0x00c3
        L_0x00b7:
            r6 = r9
            goto L_0x00c3
        L_0x00b9:
            r6 = 220(0xdc, float:3.08E-43)
            goto L_0x00c3
        L_0x00bc:
            r6 = 204(0xcc, float:2.86E-43)
            goto L_0x00c3
        L_0x00bf:
            r6 = 28
            goto L_0x00c3
        L_0x00c2:
            r6 = r8
        L_0x00c3:
            int r11 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT
            r13 = 23
            r14 = 7
            r15 = 5
            if (r11 > r13) goto L_0x00ea
            java.lang.String r13 = "foster"
            java.lang.String r5 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.DEVICE
            boolean r5 = r13.equals(r5)
            if (r5 == 0) goto L_0x00ea
            java.lang.String r5 = "NVIDIA"
            java.lang.String r13 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MANUFACTURER
            boolean r5 = r5.equals(r13)
            if (r5 == 0) goto L_0x00ea
            r5 = 3
            if (r2 == r5) goto L_0x00eb
            if (r2 == r15) goto L_0x00eb
            if (r2 == r14) goto L_0x00e7
            goto L_0x00ea
        L_0x00e7:
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.C.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00eb
        L_0x00ea:
            r9 = r6
        L_0x00eb:
            r5 = 25
            if (r11 > r5) goto L_0x0100
            java.lang.String r5 = "fugu"
            java.lang.String r6 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.DEVICE
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0100
            boolean r5 = r1.isInputPcm
            if (r5 != 0) goto L_0x0100
            if (r2 != r4) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r8 = r9
        L_0x0101:
            if (r12 != 0) goto L_0x0116
            boolean r5 = r1.isInitialized()
            if (r5 == 0) goto L_0x0116
            int r5 = r1.outputEncoding
            if (r5 != r3) goto L_0x0116
            int r5 = r1.outputSampleRate
            if (r5 != r10) goto L_0x0116
            int r5 = r1.outputChannelConfig
            if (r5 != r8) goto L_0x0116
            return
        L_0x0116:
            r1.reset()
            r1.processingEnabled = r7
            r1.outputSampleRate = r10
            r1.outputChannelConfig = r8
            r1.outputEncoding = r3
            boolean r5 = r1.isInputPcm
            if (r5 == 0) goto L_0x012a
            int r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmFrameSize(r3, r2)
            goto L_0x012b
        L_0x012a:
            r2 = -1
        L_0x012b:
            r1.outputPcmFrameSize = r2
            if (r0 == 0) goto L_0x0132
            r1.bufferSize = r0
            return
        L_0x0132:
            boolean r0 = r1.isInputPcm
            if (r0 == 0) goto L_0x0169
            int r0 = r1.outputEncoding
            int r0 = android.media.AudioTrack.getMinBufferSize(r10, r8, r0)
            r2 = -2
            if (r0 == r2) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r4 = 0
        L_0x0141:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r4)
            int r2 = r0 * 4
            r3 = 250000(0x3d090, double:1.235164E-318)
            long r3 = r1.durationUsToFrames(r3)
            int r3 = (int) r3
            int r4 = r1.outputPcmFrameSize
            int r3 = r3 * r4
            long r4 = (long) r0
            r6 = 750000(0xb71b0, double:3.70549E-318)
            long r6 = r1.durationUsToFrames(r6)
            int r0 = r1.outputPcmFrameSize
            long r8 = (long) r0
            long r6 = r6 * r8
            long r4 = java.lang.Math.max(r4, r6)
            int r0 = (int) r4
            int r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.constrainValue((int) r2, (int) r3, (int) r0)
            r1.bufferSize = r0
            return
        L_0x0169:
            int r0 = r1.outputEncoding
            if (r0 == r15) goto L_0x017f
            r2 = 6
            if (r0 != r2) goto L_0x0171
            goto L_0x017f
        L_0x0171:
            if (r0 != r14) goto L_0x0179
            r0 = 49152(0xc000, float:6.8877E-41)
            r1.bufferSize = r0
            return
        L_0x0179:
            r0 = 294912(0x48000, float:4.1326E-40)
            r1.bufferSize = r0
            return
        L_0x017f:
            r0 = 20480(0x5000, float:2.8699E-41)
            r1.bufferSize = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.configure(int, int, int, int, int[], int, int):void");
    }

    public final void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            reset();
        }
    }

    public final void enableTunnelingV21(int i5) {
        boolean z4;
        if (Util.SDK_INT >= 21) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        if (!this.tunneling || this.audioSessionId != i5) {
            this.tunneling = true;
            this.audioSessionId = i5;
            reset();
        }
    }

    public final long getCurrentPositionUs(boolean z4) {
        if (!isInitialized() || this.startMediaTimeState == 0) {
            return Long.MIN_VALUE;
        }
        return this.startMediaTimeUs + applySkipping(applySpeedup(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z4), framesToDurationUs(getWrittenFrames()))));
    }

    public final PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    public final boolean handleBuffer(ByteBuffer byteBuffer, long j5) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z4;
        boolean z5;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j6 = j5;
        ByteBuffer byteBuffer3 = this.inputBuffer;
        if (byteBuffer3 == null || byteBuffer2 == byteBuffer3) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        if (!isInitialized()) {
            initialize();
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer != null) {
            z5 = false;
        } else if (!byteBuffer2.hasRemaining()) {
            return true;
        } else {
            if (!this.isInputPcm && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample2 = getFramesPerEncodedSample(this.outputEncoding, byteBuffer2);
                this.framesPerEncodedSample = framesPerEncodedSample2;
                if (framesPerEncodedSample2 == 0) {
                    return true;
                }
            }
            if (this.afterDrainPlaybackParameters == null) {
                z5 = false;
            } else if (!drainAudioProcessorsToEndOfStream()) {
                return false;
            } else {
                PlaybackParameters playbackParameters2 = this.afterDrainPlaybackParameters;
                this.afterDrainPlaybackParameters = null;
                z5 = false;
                this.playbackParametersCheckpoints.add(new PlaybackParametersCheckpoint(this.audioProcessorChain.applyPlaybackParameters(playbackParameters2), Math.max(0, j6), framesToDurationUs(getWrittenFrames())));
                setupAudioProcessors();
            }
            if (this.startMediaTimeState == 0) {
                this.startMediaTimeUs = Math.max(0, j6);
                this.startMediaTimeState = 1;
            } else {
                long inputFramesToDurationUs = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
                if (this.startMediaTimeState == 1 && Math.abs(inputFramesToDurationUs - j6) > 200000) {
                    Log.e(TAG, "Discontinuity detected [expected " + inputFramesToDurationUs + ", got " + j6 + "]");
                    this.startMediaTimeState = 2;
                }
                if (this.startMediaTimeState == 2) {
                    this.startMediaTimeUs += j6 - inputFramesToDurationUs;
                    this.startMediaTimeState = 1;
                    AudioSink.Listener listener2 = this.listener;
                    if (listener2 != null) {
                        listener2.onPositionDiscontinuity();
                    }
                }
            }
            if (this.isInputPcm) {
                this.submittedPcmBytes += (long) byteBuffer2.remaining();
            } else {
                this.submittedEncodedFrames += (long) this.framesPerEncodedSample;
            }
            this.inputBuffer = byteBuffer2;
        }
        if (this.processingEnabled) {
            processBuffers(j6);
        } else {
            writeBuffer(this.inputBuffer, j6);
        }
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            return true;
        } else if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return z5;
        } else {
            Log.w(TAG, "Resetting stalled audio track");
            reset();
            return true;
        }
    }

    public final void handleDiscontinuity() {
        if (this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    public final boolean hasPendingData() {
        if (!isInitialized() || !this.audioTrackPositionTracker.hasPendingData(getWrittenFrames())) {
            return false;
        }
        return true;
    }

    public final boolean isEncodingSupported(int i5) {
        if (!Util.isEncodingPcm(i5)) {
            AudioCapabilities audioCapabilities2 = this.audioCapabilities;
            if (audioCapabilities2 == null || !audioCapabilities2.supportsEncoding(i5)) {
                return false;
            }
            return true;
        } else if (i5 != 4 || Util.SDK_INT >= 21) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean isEnded() {
        if (!isInitialized()) {
            return true;
        }
        if (!this.handledEndOfStream || hasPendingData()) {
            return false;
        }
        return true;
    }

    public final void pause() {
        this.playing = false;
        if (isInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    public final void play() {
        this.playing = true;
        if (isInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    public final void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainAudioProcessorsToEndOfStream()) {
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
            this.handledEndOfStream = true;
        }
    }

    public final void release() {
        reset();
        releaseKeepSessionIdAudioTrack();
        for (AudioProcessor reset : this.toIntPcmAvailableAudioProcessors) {
            reset.reset();
        }
        for (AudioProcessor reset2 : this.toFloatPcmAvailableAudioProcessors) {
            reset2.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.submittedPcmBytes = 0;
            this.submittedEncodedFrames = 0;
            this.writtenPcmBytes = 0;
            this.writtenEncodedFrames = 0;
            this.framesPerEncodedSample = 0;
            PlaybackParameters playbackParameters2 = this.afterDrainPlaybackParameters;
            if (playbackParameters2 != null) {
                this.playbackParameters = playbackParameters2;
                this.afterDrainPlaybackParameters = null;
            } else if (!this.playbackParametersCheckpoints.isEmpty()) {
                this.playbackParameters = this.playbackParametersCheckpoints.getLast().playbackParameters;
            }
            this.playbackParametersCheckpoints.clear();
            this.playbackParametersOffsetUs = 0;
            this.playbackParametersPositionUs = 0;
            this.inputBuffer = null;
            this.outputBuffer = null;
            flushAudioProcessors();
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            this.startMediaTimeState = 0;
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            final AudioTrack audioTrack2 = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new Thread() {
                public void run() {
                    try {
                        audioTrack2.flush();
                        audioTrack2.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    public final void setAudioAttributes(AudioAttributes audioAttributes2) {
        if (!this.audioAttributes.equals(audioAttributes2)) {
            this.audioAttributes = audioAttributes2;
            if (!this.tunneling) {
                reset();
                this.audioSessionId = 0;
            }
        }
    }

    public final void setAudioSessionId(int i5) {
        if (this.audioSessionId != i5) {
            this.audioSessionId = i5;
            reset();
        }
    }

    public final void setListener(AudioSink.Listener listener2) {
        this.listener = listener2;
    }

    public final PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters2) {
        if (!isInitialized() || this.canApplyPlaybackParameters) {
            PlaybackParameters playbackParameters3 = this.afterDrainPlaybackParameters;
            if (playbackParameters3 == null) {
                if (!this.playbackParametersCheckpoints.isEmpty()) {
                    playbackParameters3 = this.playbackParametersCheckpoints.getLast().playbackParameters;
                } else {
                    playbackParameters3 = this.playbackParameters;
                }
            }
            if (!playbackParameters2.equals(playbackParameters3)) {
                if (isInitialized()) {
                    this.afterDrainPlaybackParameters = playbackParameters2;
                } else {
                    this.playbackParameters = this.audioProcessorChain.applyPlaybackParameters(playbackParameters2);
                }
            }
            return this.playbackParameters;
        }
        PlaybackParameters playbackParameters4 = PlaybackParameters.DEFAULT;
        this.playbackParameters = playbackParameters4;
        return playbackParameters4;
    }

    public final void setVolume(float f5) {
        if (this.volume != f5) {
            this.volume = f5;
            setVolumeInternal();
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr, boolean z4) {
        this(audioCapabilities2, (AudioProcessorChain) new DefaultAudioProcessorChain(audioProcessorArr), z4);
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities2, AudioProcessorChain audioProcessorChain2, boolean z4) {
        this.audioCapabilities = audioCapabilities2;
        this.audioProcessorChain = (AudioProcessorChain) Assertions.checkNotNull(audioProcessorChain2);
        this.enableConvertHighResIntPcmToFloat = z4;
        this.releasingConditionVariable = new ConditionVariable(true);
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor2 = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor2;
        TrimmingAudioProcessor trimmingAudioProcessor2 = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor2;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new AudioProcessor[]{new ResamplingAudioProcessor(), channelMappingAudioProcessor2, trimmingAudioProcessor2});
        Collections.addAll(arrayList, audioProcessorChain2.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[arrayList.size()]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.playbackParametersCheckpoints = new ArrayDeque<>();
    }
}
