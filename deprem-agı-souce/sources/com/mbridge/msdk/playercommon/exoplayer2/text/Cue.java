package com.mbridge.msdk.playercommon.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = Float.MIN_VALUE;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int windowColor;
    public final boolean windowColorSet;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    public Cue(Bitmap bitmap2, float f5, int i5, float f6, int i6, float f7, float f8) {
        this((CharSequence) null, (Layout.Alignment) null, bitmap2, f6, 0, i6, f5, i5, Integer.MIN_VALUE, Float.MIN_VALUE, f7, f8, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence) {
        this(charSequence, (Layout.Alignment) null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f5, int i5, int i6, float f6, int i7, float f7) {
        this(charSequence, alignment, f5, i5, i6, f6, i7, f7, false, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f5, int i5, int i6, float f6, int i7, float f7, int i8, float f8) {
        this(charSequence, alignment, (Bitmap) null, f5, i5, i6, f6, i7, i8, f8, f7, Float.MIN_VALUE, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f5, int i5, int i6, float f6, int i7, float f7, boolean z4, int i8) {
        this(charSequence, alignment, (Bitmap) null, f5, i5, i6, f6, i7, Integer.MIN_VALUE, Float.MIN_VALUE, f7, Float.MIN_VALUE, z4, i8);
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap2, float f5, int i5, int i6, float f6, int i7, int i8, float f7, float f8, float f9, boolean z4, int i9) {
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap2;
        this.line = f5;
        this.lineType = i5;
        this.lineAnchor = i6;
        this.position = f6;
        this.positionAnchor = i7;
        this.size = f8;
        this.bitmapHeight = f9;
        this.windowColorSet = z4;
        this.windowColor = i9;
        this.textSizeType = i8;
        this.textSize = f7;
    }
}
