package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    private int highestPriority = Integer.MIN_VALUE;
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i5, int i6) {
            super("Priority too low [priority=" + i5 + ", highest=" + i6 + "]");
        }
    }

    public final void add(int i5) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i5));
            this.highestPriority = Math.max(this.highestPriority, i5);
        }
    }

    public final void proceed(int i5) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i5) {
                try {
                    this.lock.wait();
                } finally {
                }
            }
        }
    }

    public final boolean proceedNonBlocking(int i5) {
        boolean z4;
        synchronized (this.lock) {
            if (this.highestPriority == i5) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public final void proceedOrThrow(int i5) throws PriorityTooLowException {
        synchronized (this.lock) {
            try {
                if (this.highestPriority != i5) {
                    throw new PriorityTooLowException(i5, this.highestPriority);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void remove(int i5) {
        int i6;
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i5));
            if (this.queue.isEmpty()) {
                i6 = Integer.MIN_VALUE;
            } else {
                i6 = this.queue.peek().intValue();
            }
            this.highestPriority = i6;
            this.lock.notifyAll();
        }
    }
}
