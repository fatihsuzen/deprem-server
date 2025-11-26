package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

final class TtmlRegion {
    public final String id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final float width;

    public TtmlRegion(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public TtmlRegion(String str, float f5, float f6, int i5, int i6, float f7, int i7, float f8) {
        this.id = str;
        this.position = f5;
        this.line = f6;
        this.lineType = i5;
        this.lineAnchor = i6;
        this.width = f7;
        this.textSizeType = i7;
        this.textSize = f8;
    }
}
