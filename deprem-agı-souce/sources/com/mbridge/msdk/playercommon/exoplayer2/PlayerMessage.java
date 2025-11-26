package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class PlayerMessage {
    private boolean deleteAfterDelivery = true;
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private long positionMs = C.TIME_UNSET;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;

    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    public interface Target {
        void handleMessage(int i5, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender2, Target target2, Timeline timeline2, int i5, Handler handler2) {
        this.sender = sender2;
        this.target = target2;
        this.timeline = timeline2;
        this.handler = handler2;
        this.windowIndex = i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[SYNTHETIC, Splitter:B:18:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean blockUntilDelivered() throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isSent     // Catch:{ all -> 0x0037 }
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0037 }
            android.os.Handler r0 = r7.handler     // Catch:{ all -> 0x0037 }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x0037 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0037 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0037 }
            if (r0 == r1) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0037 }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0037 }
            r2 = 500(0x1f4, double:2.47E-321)
            long r0 = r0 + r2
        L_0x0023:
            boolean r4 = r7.isProcessed     // Catch:{ all -> 0x0037 }
            if (r4 != 0) goto L_0x0039
            r5 = 0
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0039
            r7.wait(r2)     // Catch:{ all -> 0x0037 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0037 }
            long r2 = r0 - r2
            goto L_0x0023
        L_0x0037:
            r0 = move-exception
            goto L_0x0047
        L_0x0039:
            if (r4 == 0) goto L_0x003f
            boolean r0 = r7.isDelivered     // Catch:{ all -> 0x0037 }
            monitor-exit(r7)
            return r0
        L_0x003f:
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "Message delivery time out"
            r0.<init>(r1)     // Catch:{ all -> 0x0037 }
            throw r0     // Catch:{ all -> 0x0037 }
        L_0x0047:
            monitor-exit(r7)     // Catch:{ all -> 0x0037 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage.blockUntilDelivered():boolean");
    }

    public final synchronized PlayerMessage cancel() {
        Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public final boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Timeline getTimeline() {
        return this.timeline;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWindowIndex() {
        return this.windowIndex;
    }

    public final synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public final synchronized void markAsProcessed(boolean z4) {
        this.isDelivered = z4 | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    public final PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == C.TIME_UNSET) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public final PlayerMessage setDeleteAfterDelivery(boolean z4) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z4;
        return this;
    }

    public final PlayerMessage setHandler(Handler handler2) {
        Assertions.checkState(!this.isSent);
        this.handler = handler2;
        return this;
    }

    public final PlayerMessage setPayload(@Nullable Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public final PlayerMessage setPosition(long j5) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j5;
        return this;
    }

    public final PlayerMessage setType(int i5) {
        Assertions.checkState(!this.isSent);
        this.type = i5;
        return this;
    }

    public final PlayerMessage setPosition(int i5, long j5) {
        boolean z4 = true;
        Assertions.checkState(!this.isSent);
        if (j5 == C.TIME_UNSET) {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        if (i5 < 0 || (!this.timeline.isEmpty() && i5 >= this.timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(this.timeline, i5, j5);
        }
        this.windowIndex = i5;
        this.positionMs = j5;
        return this;
    }
}
