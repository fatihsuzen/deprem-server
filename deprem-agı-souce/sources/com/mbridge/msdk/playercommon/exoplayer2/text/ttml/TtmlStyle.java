package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.text.Layout;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class TtmlStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    private int backgroundColor;
    private int bold = -1;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit = -1;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private String id;
    private TtmlStyle inheritableStyle;
    private int italic = -1;
    private int linethrough = -1;
    private Layout.Alignment textAlign;
    private int underline = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface OptionalBoolean {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public final TtmlStyle chain(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, true);
    }

    public final int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public final String getId() {
        return this.id;
    }

    public final int getStyle() {
        int i5;
        int i6 = this.bold;
        if (i6 == -1 && this.italic == -1) {
            return -1;
        }
        int i7 = 0;
        if (i6 == 1) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (this.italic == 1) {
            i7 = 2;
        }
        return i5 | i7;
    }

    public final Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public final boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public final boolean hasFontColor() {
        return this.hasFontColor;
    }

    public final TtmlStyle inherit(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, false);
    }

    public final boolean isLinethrough() {
        if (this.linethrough == 1) {
            return true;
        }
        return false;
    }

    public final boolean isUnderline() {
        if (this.underline == 1) {
            return true;
        }
        return false;
    }

    public final TtmlStyle setBackgroundColor(int i5) {
        this.backgroundColor = i5;
        this.hasBackgroundColor = true;
        return this;
    }

    public final TtmlStyle setBold(boolean z4) {
        boolean z5;
        if (this.inheritableStyle == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        this.bold = z4 ? 1 : 0;
        return this;
    }

    public final TtmlStyle setFontColor(int i5) {
        boolean z4;
        if (this.inheritableStyle == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.fontColor = i5;
        this.hasFontColor = true;
        return this;
    }

    public final TtmlStyle setFontFamily(String str) {
        boolean z4;
        if (this.inheritableStyle == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.fontFamily = str;
        return this;
    }

    public final TtmlStyle setFontSize(float f5) {
        this.fontSize = f5;
        return this;
    }

    public final TtmlStyle setFontSizeUnit(int i5) {
        this.fontSizeUnit = i5;
        return this;
    }

    public final TtmlStyle setId(String str) {
        this.id = str;
        return this;
    }

    public final TtmlStyle setItalic(boolean z4) {
        boolean z5;
        if (this.inheritableStyle == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        this.italic = z4 ? 1 : 0;
        return this;
    }

    public final TtmlStyle setLinethrough(boolean z4) {
        boolean z5;
        if (this.inheritableStyle == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        this.linethrough = z4 ? 1 : 0;
        return this;
    }

    public final TtmlStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public final TtmlStyle setUnderline(boolean z4) {
        boolean z5;
        if (this.inheritableStyle == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        this.underline = z4 ? 1 : 0;
        return this;
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle, boolean z4) {
        if (ttmlStyle != null) {
            if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                setFontColor(ttmlStyle.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ttmlStyle.bold;
            }
            if (this.italic == -1) {
                this.italic = ttmlStyle.italic;
            }
            if (this.fontFamily == null) {
                this.fontFamily = ttmlStyle.fontFamily;
            }
            if (this.linethrough == -1) {
                this.linethrough = ttmlStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ttmlStyle.underline;
            }
            if (this.textAlign == null) {
                this.textAlign = ttmlStyle.textAlign;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                this.fontSize = ttmlStyle.fontSize;
            }
            if (z4 && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                setBackgroundColor(ttmlStyle.backgroundColor);
            }
        }
        return this;
    }
}
