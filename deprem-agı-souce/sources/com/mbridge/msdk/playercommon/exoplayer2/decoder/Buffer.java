package com.mbridge.msdk.playercommon.exoplayer2.decoder;

public abstract class Buffer {
    private int flags;

    public final void addFlag(int i5) {
        this.flags = i5 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i5) {
        this.flags = (~i5) & this.flags;
    }

    /* access modifiers changed from: protected */
    public final boolean getFlag(int i5) {
        if ((this.flags & i5) == i5) {
            return true;
        }
        return false;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i5) {
        this.flags = i5;
    }
}
