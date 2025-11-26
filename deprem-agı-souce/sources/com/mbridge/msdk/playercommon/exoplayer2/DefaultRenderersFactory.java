package com.mbridge.msdk.playercommon.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataOutput;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextOutput;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private final long allowedVideoJoiningTimeMs;
    private final Context context;
    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final int extensionRendererMode;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context2) {
        this(context2, 0);
    }

    /* access modifiers changed from: protected */
    public AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0062, code lost:
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0060 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:6:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:19:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r16, @androidx.annotation.Nullable com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r17, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[] r18, android.os.Handler r19, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener r20, int r21, java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.Renderer> r22) {
        /*
            r15 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "DefaultRenderersFactory"
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[]> r3 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[].class
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener> r4 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener.class
            java.lang.Class<android.os.Handler> r5 = android.os.Handler.class
            com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer r6 = new com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector r8 = com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT
            r10 = 0
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities r13 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities.getCapabilities((android.content.Context) r16)
            r7 = r16
            r9 = r17
            r14 = r18
            r11 = r19
            r12 = r20
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
            r1.add(r6)
            if (r0 != 0) goto L_0x0029
            goto L_0x00d7
        L_0x0029:
            int r6 = r1.size()
            r7 = 2
            if (r0 != r7) goto L_0x0032
            int r6 = r6 + -1
        L_0x0032:
            r0 = 0
            r8 = 3
            r9 = 1
            java.lang.String r10 = "com.mbridge.msdk.playercommon.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r0] = r5     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r9] = r4     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r7] = r3     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.reflect.Constructor r10 = r10.getConstructor(r11)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r0] = r19     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r9] = r20     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            r11[r7] = r18     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            java.lang.Object r10 = r10.newInstance(r11)     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r10 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r10     // Catch:{ ClassNotFoundException -> 0x006c, Exception -> 0x0060 }
            int r11 = r6 + 1
            r1.add(r6, r10)     // Catch:{ ClassNotFoundException -> 0x0062, Exception -> 0x0060 }
            java.lang.String r6 = "Loaded LibopusAudioRenderer."
            android.util.Log.i(r2, r6)     // Catch:{ ClassNotFoundException -> 0x0062, Exception -> 0x0060 }
            goto L_0x006d
        L_0x0060:
            r0 = move-exception
            goto L_0x0064
        L_0x0062:
            r6 = r11
            goto L_0x006c
        L_0x0064:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x006c:
            r11 = r6
        L_0x006d:
            java.lang.String r6 = "com.mbridge.msdk.playercommon.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.Class[] r10 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r0] = r5     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r9] = r4     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r7] = r3     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r10)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r0] = r19     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r9] = r20     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            r10[r7] = r18     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            java.lang.Object r6 = r6.newInstance(r10)     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r6 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r6     // Catch:{ ClassNotFoundException -> 0x00a4, Exception -> 0x0098 }
            int r10 = r11 + 1
            r1.add(r11, r6)     // Catch:{ ClassNotFoundException -> 0x009a, Exception -> 0x0098 }
            java.lang.String r6 = "Loaded LibflacAudioRenderer."
            android.util.Log.i(r2, r6)     // Catch:{ ClassNotFoundException -> 0x009a, Exception -> 0x0098 }
            goto L_0x00a5
        L_0x0098:
            r0 = move-exception
            goto L_0x009c
        L_0x009a:
            r11 = r10
            goto L_0x00a4
        L_0x009c:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00a4:
            r10 = r11
        L_0x00a5:
            java.lang.String r6 = "com.mbridge.msdk.playercommon.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r11[r0] = r5     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r11[r9] = r4     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r11[r7] = r3     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.reflect.Constructor r3 = r6.getConstructor(r11)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r4[r0] = r19     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r4[r9] = r20     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r4[r7] = r18     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.Object r0 = r3.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            r1.add(r10, r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            android.util.Log.i(r2, r0)     // Catch:{ ClassNotFoundException -> 0x00d7, Exception -> 0x00ce }
            goto L_0x00d7
        L_0x00ce:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[], android.os.Handler, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener, int, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i5, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i5, ArrayList<Renderer> arrayList) {
    }

    /* access modifiers changed from: protected */
    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i5, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void buildVideoRenderers(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, long j5, Handler handler, VideoRendererEventListener videoRendererEventListener, int i5, ArrayList<Renderer> arrayList) {
        int i6 = i5;
        ArrayList<Renderer> arrayList2 = arrayList;
        arrayList2.add(new MediaCodecVideoRenderer(context2, MediaCodecSelector.DEFAULT, j5, drmSessionManager2, false, handler, videoRendererEventListener, 50));
        if (i6 != 0) {
            int size = arrayList2.size();
            if (i6 == 2) {
                size--;
            }
            try {
                arrayList2.add(size, (Renderer) Class.forName("com.mbridge.msdk.playercommon.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE}).newInstance(new Object[]{Boolean.TRUE, Long.valueOf(j5), handler, videoRendererEventListener, 50}));
                Log.i(TAG, "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException unused) {
            } catch (Exception e5) {
                throw new RuntimeException("Error instantiating VP9 extension", e5);
            }
        }
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2) {
        if (drmSessionManager2 == null) {
            drmSessionManager2 = this.drmSessionManager;
        }
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager3 = drmSessionManager2;
        ArrayList arrayList = new ArrayList();
        Handler handler2 = handler;
        buildVideoRenderers(this.context, drmSessionManager3, this.allowedVideoJoiningTimeMs, handler2, videoRendererEventListener, this.extensionRendererMode, arrayList);
        Handler handler3 = handler2;
        buildAudioRenderers(this.context, drmSessionManager3, buildAudioProcessors(), handler3, audioRendererEventListener, this.extensionRendererMode, arrayList);
        Handler handler4 = handler3;
        buildTextRenderers(this.context, textOutput, handler4.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataOutput, handler4.getLooper(), this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler4, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2) {
        this(context2, drmSessionManager2, 0);
    }

    public DefaultRenderersFactory(Context context2, int i5) {
        this(context2, (DrmSessionManager<FrameworkMediaCrypto>) null, i5, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i5) {
        this(context2, drmSessionManager2, i5, 5000);
    }

    public DefaultRenderersFactory(Context context2, int i5, long j5) {
        this(context2, (DrmSessionManager<FrameworkMediaCrypto>) null, i5, j5);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, int i5, long j5) {
        this.context = context2;
        this.extensionRendererMode = i5;
        this.allowedVideoJoiningTimeMs = j5;
        this.drmSessionManager = drmSessionManager2;
    }
}
