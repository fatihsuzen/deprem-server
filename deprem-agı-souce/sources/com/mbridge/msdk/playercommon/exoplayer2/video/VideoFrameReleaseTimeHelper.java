package com.mbridge.msdk.playercommon.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

@TargetApi(16)
public final class VideoFrameReleaseTimeHelper {
    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500;
    private static final long MAX_ALLOWED_DRIFT_NS = 20000000;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private long adjustedLastFrameTimeNs;
    private final DefaultDisplayListener displayListener;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    @TargetApi(17)
    private final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public DefaultDisplayListener(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        public final void onDisplayAdded(int i5) {
        }

        public final void onDisplayChanged(int i5) {
            if (i5 == 0) {
                VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        public final void onDisplayRemoved(int i5) {
        }

        public final void register() {
            this.displayManager.registerDisplayListener(this, (Handler) null);
        }

        public final void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }
    }

    private static final class VSyncSampler implements Handler.Callback, Choreographer.FrameCallback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = C.TIME_UNSET;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler handler2 = new Handler(handlerThread.getLooper(), this);
            this.handler = handler2;
            handler2.sendEmptyMessage(0);
        }

        private void addObserverInternal() {
            int i5 = this.observerCount + 1;
            this.observerCount = i5;
            if (i5 == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private void removeObserverInternal() {
            int i5 = this.observerCount - 1;
            this.observerCount = i5;
            if (i5 == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = C.TIME_UNSET;
            }
        }

        public final void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public final void doFrame(long j5) {
            this.sampledVsyncTimeNs = j5;
            this.choreographer.postFrameCallbackDelayed(this, VideoFrameReleaseTimeHelper.CHOREOGRAPHER_SAMPLE_DELAY_MILLIS);
        }

        public final boolean handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 0) {
                createChoreographerInstanceInternal();
                return true;
            } else if (i5 == 1) {
                addObserverInternal();
                return true;
            } else if (i5 != 2) {
                return false;
            } else {
                removeObserverInternal();
                return true;
            }
        }

        public final void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this((Context) null);
    }

    private static long closestVsync(long j5, long j6, long j7) {
        long j8;
        long j9 = j6 + (((j5 - j6) / j7) * j7);
        if (j5 <= j9) {
            j8 = j9 - j7;
        } else {
            long j10 = j7 + j9;
            j8 = j9;
            j9 = j10;
        }
        if (j9 - j5 < j5 - j8) {
            return j9;
        }
        return j8;
    }

    private boolean isDriftTooLarge(long j5, long j6) {
        if (Math.abs((j6 - this.syncUnadjustedReleaseTimeNs) - (j5 - this.syncFramePresentationTimeNs)) > MAX_ALLOWED_DRIFT_NS) {
            return true;
        }
        return false;
    }

    @TargetApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    /* access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
            this.vsyncDurationNs = refreshRate;
            this.vsyncOffsetNs = (refreshRate * VSYNC_OFFSET_PERCENTAGE) / 100;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long adjustReleaseTime(long r11, long r13) {
        /*
            r10 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r11
            boolean r2 = r10.haveSync
            if (r2 == 0) goto L_0x0041
            long r2 = r10.lastFramePresentationTimeUs
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0018
            long r2 = r10.frameCount
            r4 = 1
            long r2 = r2 + r4
            r10.frameCount = r2
            long r2 = r10.pendingAdjustedFrameTimeNs
            r10.adjustedLastFrameTimeNs = r2
        L_0x0018:
            long r2 = r10.frameCount
            r4 = 6
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r5 = 0
            if (r4 < 0) goto L_0x0039
            long r6 = r10.syncFramePresentationTimeNs
            long r6 = r0 - r6
            long r6 = r6 / r2
            long r2 = r10.adjustedLastFrameTimeNs
            long r2 = r2 + r6
            boolean r4 = r10.isDriftTooLarge(r2, r13)
            if (r4 == 0) goto L_0x0032
            r10.haveSync = r5
            goto L_0x0041
        L_0x0032:
            long r4 = r10.syncUnadjustedReleaseTimeNs
            long r4 = r4 + r2
            long r6 = r10.syncFramePresentationTimeNs
            long r4 = r4 - r6
            goto L_0x0043
        L_0x0039:
            boolean r2 = r10.isDriftTooLarge(r0, r13)
            if (r2 == 0) goto L_0x0041
            r10.haveSync = r5
        L_0x0041:
            r4 = r13
            r2 = r0
        L_0x0043:
            boolean r6 = r10.haveSync
            if (r6 != 0) goto L_0x0052
            r10.syncFramePresentationTimeNs = r0
            r10.syncUnadjustedReleaseTimeNs = r13
            r13 = 0
            r10.frameCount = r13
            r13 = 1
            r10.haveSync = r13
        L_0x0052:
            r10.lastFramePresentationTimeUs = r11
            r10.pendingAdjustedFrameTimeNs = r2
            com.mbridge.msdk.playercommon.exoplayer2.video.VideoFrameReleaseTimeHelper$VSyncSampler r11 = r10.vsyncSampler
            if (r11 == 0) goto L_0x0077
            long r12 = r10.vsyncDurationNs
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 != 0) goto L_0x0066
            goto L_0x0077
        L_0x0066:
            long r6 = r11.sampledVsyncTimeNs
            int r11 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r11 != 0) goto L_0x006d
            goto L_0x0077
        L_0x006d:
            long r8 = r10.vsyncDurationNs
            long r11 = closestVsync(r4, r6, r8)
            long r13 = r10.vsyncOffsetNs
            long r11 = r11 - r13
            return r11
        L_0x0077:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.video.VideoFrameReleaseTimeHelper.adjustReleaseTime(long, long):long");
    }

    public final void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public final void enable() {
        this.haveSync = false;
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    public VideoFrameReleaseTimeHelper(@Nullable Context context) {
        DefaultDisplayListener defaultDisplayListener = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.windowManager = (WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : defaultDisplayListener;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
    }
}
