package com.mbridge.msdk.playercommon.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsCollector;
import com.mbridge.msdk.playercommon.exoplayer2.analytics.AnalyticsListener;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioAttributes;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextOutput;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

@TargetApi(16)
public class SimpleExoPlayer implements ExoPlayer, Player.TextComponent, Player.VideoComponent {
    private static final String TAG = "SimpleExoPlayer";
    private final AnalyticsCollector analyticsCollector;
    private AudioAttributes audioAttributes;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<AudioRendererEventListener> audioDebugListeners;
    /* access modifiers changed from: private */
    public DecoderCounters audioDecoderCounters;
    /* access modifiers changed from: private */
    public Format audioFormat;
    /* access modifiers changed from: private */
    public int audioSessionId;
    private float audioVolume;
    private final ComponentListener componentListener;
    /* access modifiers changed from: private */
    public List<Cue> currentCues;
    private final Handler eventHandler;
    private MediaSource mediaSource;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private boolean ownsSurface;
    private final ExoPlayer player;
    protected final Renderer[] renderers;
    /* access modifiers changed from: private */
    public Surface surface;
    private SurfaceHolder surfaceHolder;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<TextOutput> textOutputs;
    private TextureView textureView;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<VideoRendererEventListener> videoDebugListeners;
    /* access modifiers changed from: private */
    public DecoderCounters videoDecoderCounters;
    /* access modifiers changed from: private */
    public Format videoFormat;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<com.mbridge.msdk.playercommon.exoplayer2.video.VideoListener> videoListeners;
    private int videoScalingMode;

    private final class ComponentListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, AudioRendererEventListener, MetadataOutput, TextOutput, VideoRendererEventListener {
        private ComponentListener() {
        }

        public final void onAudioDecoderInitialized(String str, long j5, long j6) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioDecoderInitialized(str, j5, j6);
            }
        }

        public final void onAudioDisabled(DecoderCounters decoderCounters) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioDisabled(decoderCounters);
            }
            Format unused = SimpleExoPlayer.this.audioFormat = null;
            DecoderCounters unused2 = SimpleExoPlayer.this.audioDecoderCounters = null;
            int unused3 = SimpleExoPlayer.this.audioSessionId = 0;
        }

        public final void onAudioEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioEnabled(decoderCounters);
            }
        }

        public final void onAudioInputFormatChanged(Format format) {
            Format unused = SimpleExoPlayer.this.audioFormat = format;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioInputFormatChanged(format);
            }
        }

        public final void onAudioSessionId(int i5) {
            int unused = SimpleExoPlayer.this.audioSessionId = i5;
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioSessionId(i5);
            }
        }

        public final void onAudioSinkUnderrun(int i5, long j5, long j6) {
            Iterator it = SimpleExoPlayer.this.audioDebugListeners.iterator();
            while (it.hasNext()) {
                ((AudioRendererEventListener) it.next()).onAudioSinkUnderrun(i5, j5, j6);
            }
        }

        public final void onCues(List<Cue> list) {
            List unused = SimpleExoPlayer.this.currentCues = list;
            Iterator it = SimpleExoPlayer.this.textOutputs.iterator();
            while (it.hasNext()) {
                ((TextOutput) it.next()).onCues(list);
            }
        }

        public final void onDroppedFrames(int i5, long j5) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onDroppedFrames(i5, j5);
            }
        }

        public final void onMetadata(Metadata metadata) {
            Iterator it = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it.hasNext()) {
                ((MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        public final void onRenderedFirstFrame(Surface surface) {
            if (SimpleExoPlayer.this.surface == surface) {
                Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((com.mbridge.msdk.playercommon.exoplayer2.video.VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
            Iterator it2 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                ((VideoRendererEventListener) it2.next()).onRenderedFirstFrame(surface);
            }
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i5, int i6) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoSurfaceInternal((Surface) null, true);
            return true;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i5, int i6) {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final void onVideoDecoderInitialized(String str, long j5, long j6) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoDecoderInitialized(str, j5, j6);
            }
        }

        public final void onVideoDisabled(DecoderCounters decoderCounters) {
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoDisabled(decoderCounters);
            }
            Format unused = SimpleExoPlayer.this.videoFormat = null;
            DecoderCounters unused2 = SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        public final void onVideoEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoEnabled(decoderCounters);
            }
        }

        public final void onVideoInputFormatChanged(Format format) {
            Format unused = SimpleExoPlayer.this.videoFormat = format;
            Iterator it = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it.hasNext()) {
                ((VideoRendererEventListener) it.next()).onVideoInputFormatChanged(format);
            }
        }

        public final void onVideoSizeChanged(int i5, int i6, int i7, float f5) {
            Iterator it = SimpleExoPlayer.this.videoListeners.iterator();
            while (it.hasNext()) {
                ((com.mbridge.msdk.playercommon.exoplayer2.video.VideoListener) it.next()).onVideoSizeChanged(i5, i6, i7, f5);
            }
            Iterator it2 = SimpleExoPlayer.this.videoDebugListeners.iterator();
            while (it2.hasNext()) {
                ((VideoRendererEventListener) it2.next()).onVideoSizeChanged(i5, i6, i7, f5);
            }
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer.this.setVideoSurfaceInternal((Surface) null, false);
        }
    }

    @Deprecated
    public interface VideoListener extends com.mbridge.msdk.playercommon.exoplayer2.video.VideoListener {
    }

    protected SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        this(renderersFactory, trackSelector, loadControl, drmSessionManager, new AnalyticsCollector.Factory());
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView2 = this.textureView;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* access modifiers changed from: private */
    public void setVideoSurfaceInternal(Surface surface2, boolean z4) {
        ArrayList arrayList = new ArrayList();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(surface2).send());
            }
        }
        Surface surface3 = this.surface;
        if (!(surface3 == null || surface3 == surface2)) {
            try {
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((PlayerMessage) obj).blockUntilDelivered();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.player.stop(false);
            }
            if (this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface2;
        this.ownsSurface = z4;
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.addListener(analyticsListener);
    }

    @Deprecated
    public void addAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.add(audioRendererEventListener);
    }

    public void addListener(Player.EventListener eventListener) {
        this.player.addListener(eventListener);
    }

    public void addMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.add(metadataOutput);
    }

    public void addTextOutput(TextOutput textOutput) {
        if (!this.currentCues.isEmpty()) {
            textOutput.onCues(this.currentCues);
        }
        this.textOutputs.add(textOutput);
    }

    @Deprecated
    public void addVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.add(videoRendererEventListener);
    }

    public void addVideoListener(com.mbridge.msdk.playercommon.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.add(videoListener);
    }

    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.blockingSendMessages(exoPlayerMessageArr);
    }

    @Deprecated
    public void clearMetadataOutput(MetadataOutput metadataOutput) {
        removeMetadataOutput(metadataOutput);
    }

    @Deprecated
    public void clearTextOutput(TextOutput textOutput) {
        removeTextOutput(textOutput);
    }

    @Deprecated
    public void clearVideoListener(VideoListener videoListener) {
        removeVideoListener(videoListener);
    }

    public void clearVideoSurface() {
        setVideoSurface((Surface) null);
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        if (surfaceHolder2 != null && surfaceHolder2 == this.surfaceHolder) {
            setVideoSurfaceHolder((SurfaceHolder) null);
        }
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        if (surfaceView == null) {
            surfaceHolder2 = null;
        } else {
            surfaceHolder2 = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(surfaceHolder2);
    }

    public void clearVideoTextureView(TextureView textureView2) {
        if (textureView2 != null && textureView2 == this.textureView) {
            setVideoTextureView((TextureView) null);
        }
    }

    /* access modifiers changed from: protected */
    public ExoPlayer createExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, Clock clock) {
        return new ExoPlayerImpl(rendererArr, trackSelector, loadControl, clock);
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return this.player.createMessage(target);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Deprecated
    public int getAudioStreamType() {
        return Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
    }

    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Nullable
    public Object getCurrentTag() {
        return this.player.getCurrentTag();
    }

    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    public TrackGroupArray getCurrentTrackGroups() {
        return this.player.getCurrentTrackGroups();
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        return this.player.getCurrentTrackSelections();
    }

    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    public long getDuration() {
        return this.player.getDuration();
    }

    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    public ExoPlaybackException getPlaybackError() {
        return this.player.getPlaybackError();
    }

    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    public int getRendererCount() {
        return this.player.getRendererCount();
    }

    public int getRendererType(int i5) {
        return this.player.getRendererType(i5);
    }

    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    public Player.TextComponent getTextComponent() {
        return this;
    }

    public Player.VideoComponent getVideoComponent() {
        return this;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    public float getVolume() {
        return this.audioVolume;
    }

    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    public boolean isLoading() {
        return this.player.isLoading();
    }

    public final boolean isPlaying() {
        if (getPlaybackState() != 3 || !getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    public void prepare(MediaSource mediaSource2) {
        prepare(mediaSource2, true, true);
    }

    public void release() {
        this.player.release();
        removeSurfaceCallbacks();
        Surface surface2 = this.surface;
        if (surface2 != null) {
            if (this.ownsSurface) {
                surface2.release();
            }
            this.surface = null;
        }
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            mediaSource2.removeEventListener(this.analyticsCollector);
        }
        this.currentCues = Collections.EMPTY_LIST;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    @Deprecated
    public void removeAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.remove(audioRendererEventListener);
    }

    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    @Deprecated
    public void removeVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.remove(videoRendererEventListener);
    }

    public void removeVideoListener(com.mbridge.msdk.playercommon.exoplayer2.video.VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    public void seekTo(long j5) {
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(j5);
    }

    public void seekToDefaultPosition() {
        this.analyticsCollector.notifySeekStarted();
        this.player.seekToDefaultPosition();
    }

    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        this.player.sendMessages(exoPlayerMessageArr);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        this.audioAttributes = audioAttributes2;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(3).setPayload(audioAttributes2).send();
            }
        }
    }

    @Deprecated
    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        this.audioDebugListeners.retainAll(Collections.singleton(this.analyticsCollector));
        if (audioRendererEventListener != null) {
            addAudioDebugListener(audioRendererEventListener);
        }
    }

    @Deprecated
    public void setAudioStreamType(int i5) {
        int audioUsageForStreamType = Util.getAudioUsageForStreamType(i5);
        setAudioAttributes(new AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(Util.getAudioContentTypeForStreamType(i5)).build());
    }

    @Deprecated
    public void setMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.retainAll(Collections.singleton(this.analyticsCollector));
        if (metadataOutput != null) {
            addMetadataOutput(metadataOutput);
        }
    }

    public void setPlayWhenReady(boolean z4) {
        this.player.setPlayWhenReady(z4);
    }

    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
    }

    @TargetApi(23)
    @Deprecated
    public void setPlaybackParams(@Nullable PlaybackParams playbackParams) {
        PlaybackParameters playbackParameters;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            playbackParameters = new PlaybackParameters(playbackParams.getSpeed(), playbackParams.getPitch());
        } else {
            playbackParameters = null;
        }
        setPlaybackParameters(playbackParameters);
    }

    public void setRepeatMode(int i5) {
        this.player.setRepeatMode(i5);
    }

    public void setSeekParameters(@Nullable SeekParameters seekParameters) {
        this.player.setSeekParameters(seekParameters);
    }

    public void setShuffleModeEnabled(boolean z4) {
        this.player.setShuffleModeEnabled(z4);
    }

    @Deprecated
    public void setTextOutput(TextOutput textOutput) {
        this.textOutputs.clear();
        if (textOutput != null) {
            addTextOutput(textOutput);
        }
    }

    @Deprecated
    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        this.videoDebugListeners.retainAll(Collections.singleton(this.analyticsCollector));
        if (videoRendererEventListener != null) {
            addVideoDebugListener(videoRendererEventListener);
        }
    }

    @Deprecated
    public void setVideoListener(VideoListener videoListener) {
        this.videoListeners.clear();
        if (videoListener != null) {
            addVideoListener(videoListener);
        }
    }

    public void setVideoScalingMode(int i5) {
        this.videoScalingMode = i5;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                this.player.createMessage(renderer).setType(4).setPayload(Integer.valueOf(i5)).send();
            }
        }
    }

    public void setVideoSurface(Surface surface2) {
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r2.isValid() != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setVideoSurfaceHolder(android.view.SurfaceHolder r2) {
        /*
            r1 = this;
            r1.removeSurfaceCallbacks()
            r1.surfaceHolder = r2
            if (r2 != 0) goto L_0x0008
            goto L_0x001a
        L_0x0008:
            com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer$ComponentListener r0 = r1.componentListener
            r2.addCallback(r0)
            android.view.Surface r2 = r2.getSurface()
            if (r2 == 0) goto L_0x001a
            boolean r0 = r2.isValid()
            if (r0 == 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            r0 = 0
            r1.setVideoSurfaceInternal(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer.setVideoSurfaceHolder(android.view.SurfaceHolder):void");
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        if (surfaceView == null) {
            surfaceHolder2 = null;
        } else {
            surfaceHolder2 = surfaceView.getHolder();
        }
        setVideoSurfaceHolder(surfaceHolder2);
    }

    public void setVideoTextureView(TextureView textureView2) {
        SurfaceTexture surfaceTexture;
        removeSurfaceCallbacks();
        this.textureView = textureView2;
        Surface surface2 = null;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() != null) {
                Log.w(TAG, "Replacing existing SurfaceTextureListener.");
            }
            textureView2.setSurfaceTextureListener(this.componentListener);
            if (textureView2.isAvailable()) {
                surfaceTexture = textureView2.getSurfaceTexture();
            } else {
                surfaceTexture = null;
            }
            if (surfaceTexture != null) {
                surface2 = new Surface(surfaceTexture);
            }
        }
        setVideoSurfaceInternal(surface2, true);
    }

    public void setVolume(float f5) {
        this.audioVolume = f5;
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 1) {
                this.player.createMessage(renderer).setType(2).setPayload(Float.valueOf(f5)).send();
            }
        }
    }

    public void stop() {
        stop(false);
    }

    protected SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, AnalyticsCollector.Factory factory) {
        this(renderersFactory, trackSelector, loadControl, drmSessionManager, factory, Clock.DEFAULT);
    }

    public void clearVideoSurface(Surface surface2) {
        if (surface2 != null && surface2 == this.surface) {
            setVideoSurface((Surface) null);
        }
    }

    public void prepare(MediaSource mediaSource2, boolean z4, boolean z5) {
        MediaSource mediaSource3 = this.mediaSource;
        if (mediaSource3 != mediaSource2) {
            if (mediaSource3 != null) {
                mediaSource3.removeEventListener(this.analyticsCollector);
                this.analyticsCollector.resetForNewMediaSource();
            }
            mediaSource2.addEventListener(this.eventHandler, this.analyticsCollector);
            this.mediaSource = mediaSource2;
        }
        this.player.prepare(mediaSource2, z4, z5);
    }

    public void stop(boolean z4) {
        this.player.stop(z4);
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            mediaSource2.removeEventListener(this.analyticsCollector);
            this.mediaSource = null;
            this.analyticsCollector.resetForNewMediaSource();
        }
        this.currentCues = Collections.EMPTY_LIST;
    }

    protected SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, AnalyticsCollector.Factory factory, Clock clock) {
        ComponentListener componentListener2 = new ComponentListener();
        this.componentListener = componentListener2;
        this.videoListeners = new CopyOnWriteArraySet<>();
        this.textOutputs = new CopyOnWriteArraySet<>();
        this.metadataOutputs = new CopyOnWriteArraySet<>();
        CopyOnWriteArraySet<VideoRendererEventListener> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        this.videoDebugListeners = copyOnWriteArraySet;
        CopyOnWriteArraySet<AudioRendererEventListener> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
        this.audioDebugListeners = copyOnWriteArraySet2;
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.eventHandler = handler;
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2 = drmSessionManager;
        Renderer[] createRenderers = renderersFactory.createRenderers(handler, componentListener2, componentListener2, componentListener2, componentListener2, drmSessionManager2);
        this.renderers = createRenderers;
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.currentCues = Collections.EMPTY_LIST;
        ExoPlayer createExoPlayerImpl = createExoPlayerImpl(createRenderers, trackSelector, loadControl, clock);
        this.player = createExoPlayerImpl;
        AnalyticsCollector createAnalyticsCollector = factory.createAnalyticsCollector(createExoPlayerImpl, clock);
        this.analyticsCollector = createAnalyticsCollector;
        addListener(createAnalyticsCollector);
        copyOnWriteArraySet.add(createAnalyticsCollector);
        copyOnWriteArraySet2.add(createAnalyticsCollector);
        addMetadataOutput(createAnalyticsCollector);
        if (drmSessionManager2 instanceof DefaultDrmSessionManager) {
            ((DefaultDrmSessionManager) drmSessionManager2).addListener(handler, createAnalyticsCollector);
        }
    }

    public void seekTo(int i5, long j5) {
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(i5, j5);
    }

    public void seekToDefaultPosition(int i5) {
        this.analyticsCollector.notifySeekStarted();
        this.player.seekToDefaultPosition(i5);
    }
}
