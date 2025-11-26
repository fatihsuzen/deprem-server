package com.mbridge.msdk.playercommon.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MAX_PENDING_METADATA_COUNT = 5;
    private static final int MSG_INVOKE_RENDERER = 0;
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    private final Handler outputHandler;
    private final Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;

    @Deprecated
    public interface Output extends MetadataOutput {
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, (Object) null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeRendererInternal((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public final boolean isEnded() {
        return this.inputStreamEnded;
    }

    public final boolean isReady() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onDisabled() {
        flushPendingMetadata();
        this.decoder = null;
    }

    /* access modifiers changed from: protected */
    public final void onPositionReset(long j5, boolean z4) {
        flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    /* access modifiers changed from: protected */
    public final void onStreamChanged(Format[] formatArr, long j5) throws ExoPlaybackException {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
    }

    public final void render(long j5, long j6) throws ExoPlaybackException {
        if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.clear();
            if (readSource(this.formatHolder, this.buffer, false) == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                } else if (!this.buffer.isDecodeOnly()) {
                    MetadataInputBuffer metadataInputBuffer = this.buffer;
                    metadataInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                    metadataInputBuffer.flip();
                    try {
                        int i5 = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
                        this.pendingMetadata[i5] = this.decoder.decode(this.buffer);
                        this.pendingMetadataTimestamps[i5] = this.buffer.timeUs;
                        this.pendingMetadataCount++;
                    } catch (MetadataDecoderException e5) {
                        throw ExoPlaybackException.createForRenderer(e5, getIndex());
                    }
                }
            }
        }
        if (this.pendingMetadataCount > 0) {
            long[] jArr = this.pendingMetadataTimestamps;
            int i6 = this.pendingMetadataIndex;
            if (jArr[i6] <= j5) {
                invokeRenderer(this.pendingMetadata[i6]);
                Metadata[] metadataArr = this.pendingMetadata;
                int i7 = this.pendingMetadataIndex;
                metadataArr[i7] = null;
                this.pendingMetadataIndex = (i7 + 1) % 5;
                this.pendingMetadataCount--;
            }
        }
    }

    public final int supportsFormat(Format format) {
        if (!this.decoderFactory.supportsFormat(format)) {
            return 0;
        }
        if (BaseRenderer.supportsFormatDrm((DrmSessionManager<?>) null, format.drmInitData)) {
            return 4;
        }
        return 2;
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        Handler handler;
        this.output = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.formatHolder = new FormatHolder();
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }
}
