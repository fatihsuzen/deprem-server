package com.mbridge.msdk.playercommon.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public interface VideoRendererEventListener {

    public static final class EventDispatcher {
        @Nullable
        private final Handler handler;
        /* access modifiers changed from: private */
        @Nullable
        public final VideoRendererEventListener listener;

        public EventDispatcher(@Nullable Handler handler2, @Nullable VideoRendererEventListener videoRendererEventListener) {
            Handler handler3;
            if (videoRendererEventListener != null) {
                handler3 = (Handler) Assertions.checkNotNull(handler2);
            } else {
                handler3 = null;
            }
            this.handler = handler3;
            this.listener = videoRendererEventListener;
        }

        public final void decoderInitialized(String str, long j5, long j6) {
            if (this.listener != null) {
                final String str2 = str;
                final long j7 = j5;
                final long j8 = j6;
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onVideoDecoderInitialized(str2, j7, j8);
                    }
                });
            }
        }

        public final void disabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        decoderCounters.ensureUpdated();
                        EventDispatcher.this.listener.onVideoDisabled(decoderCounters);
                    }
                });
            }
        }

        public final void droppedFrames(final int i5, final long j5) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onDroppedFrames(i5, j5);
                    }
                });
            }
        }

        public final void enabled(final DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onVideoEnabled(decoderCounters);
                    }
                });
            }
        }

        public final void inputFormatChanged(final Format format) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onVideoInputFormatChanged(format);
                    }
                });
            }
        }

        public final void renderedFirstFrame(final Surface surface) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onRenderedFirstFrame(surface);
                    }
                });
            }
        }

        public final void videoSizeChanged(int i5, int i6, int i7, float f5) {
            if (this.listener != null) {
                final int i8 = i5;
                final int i9 = i6;
                final int i10 = i7;
                final float f6 = f5;
                this.handler.post(new Runnable() {
                    public void run() {
                        EventDispatcher.this.listener.onVideoSizeChanged(i8, i9, i10, f6);
                    }
                });
            }
        }
    }

    void onDroppedFrames(int i5, long j5);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j5, long j6);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i5, int i6, int i7, float f5);
}
