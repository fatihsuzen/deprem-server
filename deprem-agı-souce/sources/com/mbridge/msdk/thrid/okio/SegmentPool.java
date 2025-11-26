package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;
    @Nullable
    static Segment next;

    private SegmentPool() {
    }

    static void recycle(Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException();
        } else if (!segment.shared) {
            synchronized (SegmentPool.class) {
                try {
                    long j5 = byteCount;
                    if (j5 + 8192 <= MAX_SIZE) {
                        byteCount = j5 + 8192;
                        segment.next = next;
                        segment.limit = 0;
                        segment.pos = 0;
                        next = segment;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static Segment take() {
        synchronized (SegmentPool.class) {
            try {
                Segment segment = next;
                if (segment == null) {
                    return new Segment();
                }
                next = segment.next;
                segment.next = null;
                byteCount -= 8192;
                return segment;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
