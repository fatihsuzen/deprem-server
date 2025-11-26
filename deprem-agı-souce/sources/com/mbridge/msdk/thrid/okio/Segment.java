package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i5;
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException();
        } else if (segment.owner) {
            int i6 = this.limit - this.pos;
            int i7 = 8192 - segment.limit;
            if (segment.shared) {
                i5 = 0;
            } else {
                i5 = segment.pos;
            }
            if (i6 <= i7 + i5) {
                writeTo(segment, i6);
                pop();
                SegmentPool.recycle(this);
            }
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment;
        Segment segment2 = this.next;
        if (segment2 != this) {
            segment = segment2;
        } else {
            segment = null;
        }
        Segment segment3 = this.prev;
        segment3.next = segment2;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    /* access modifiers changed from: package-private */
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i5) {
        Segment segment;
        if (i5 <= 0 || i5 > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        if (i5 >= 1024) {
            segment = sharedCopy();
        } else {
            segment = SegmentPool.take();
            System.arraycopy(this.data, this.pos, segment.data, 0, i5);
        }
        segment.limit = segment.pos + i5;
        this.pos += i5;
        this.prev.push(segment);
        return segment;
    }

    /* access modifiers changed from: package-private */
    public final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i5) {
        if (segment.owner) {
            int i6 = segment.limit;
            if (i6 + i5 > 8192) {
                if (!segment.shared) {
                    int i7 = segment.pos;
                    if ((i6 + i5) - i7 <= 8192) {
                        byte[] bArr = segment.data;
                        System.arraycopy(bArr, i7, bArr, 0, i6 - i7);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.data, this.pos, segment.data, segment.limit, i5);
            segment.limit += i5;
            this.pos += i5;
            return;
        }
        throw new IllegalArgumentException();
    }

    Segment(byte[] bArr, int i5, int i6, boolean z4, boolean z5) {
        this.data = bArr;
        this.pos = i5;
        this.limit = i6;
        this.shared = z4;
        this.owner = z5;
    }
}
