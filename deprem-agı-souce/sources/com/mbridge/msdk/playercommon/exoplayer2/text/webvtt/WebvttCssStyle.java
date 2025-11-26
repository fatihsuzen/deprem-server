package com.mbridge.msdk.playercommon.exoplayer2.text.webvtt;

import android.text.Layout;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class WebvttCssStyle {
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
    private int bold;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private int italic;
    private int linethrough;
    private List<String> targetClasses;
    private String targetId;
    private String targetTag;
    private String targetVoice;
    private Layout.Alignment textAlign;
    private int underline;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface OptionalBoolean {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    public WebvttCssStyle() {
        reset();
    }

    private static int updateScoreForMatch(int i5, String str, String str2, int i6) {
        if (str.isEmpty() || i5 == -1) {
            return i5;
        }
        if (str.equals(str2)) {
            return i5 + i6;
        }
        return -1;
    }

    public final void cascadeFrom(WebvttCssStyle webvttCssStyle) {
        if (webvttCssStyle.hasFontColor) {
            setFontColor(webvttCssStyle.fontColor);
        }
        int i5 = webvttCssStyle.bold;
        if (i5 != -1) {
            this.bold = i5;
        }
        int i6 = webvttCssStyle.italic;
        if (i6 != -1) {
            this.italic = i6;
        }
        String str = webvttCssStyle.fontFamily;
        if (str != null) {
            this.fontFamily = str;
        }
        if (this.linethrough == -1) {
            this.linethrough = webvttCssStyle.linethrough;
        }
        if (this.underline == -1) {
            this.underline = webvttCssStyle.underline;
        }
        if (this.textAlign == null) {
            this.textAlign = webvttCssStyle.textAlign;
        }
        if (this.fontSizeUnit == -1) {
            this.fontSizeUnit = webvttCssStyle.fontSizeUnit;
            this.fontSize = webvttCssStyle.fontSize;
        }
        if (webvttCssStyle.hasBackgroundColor) {
            setBackgroundColor(webvttCssStyle.backgroundColor);
        }
    }

    public final int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public final int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color not defined");
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

    public final int getSpecificityScore(String str, String str2, String[] strArr, String str3) {
        if (this.targetId.isEmpty() && this.targetTag.isEmpty() && this.targetClasses.isEmpty() && this.targetVoice.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int updateScoreForMatch = updateScoreForMatch(updateScoreForMatch(updateScoreForMatch(0, this.targetId, str, 1073741824), this.targetTag, str2, 2), this.targetVoice, str3, 4);
        if (updateScoreForMatch == -1 || !Arrays.asList(strArr).containsAll(this.targetClasses)) {
            return 0;
        }
        return updateScoreForMatch + (this.targetClasses.size() * 4);
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

    public final void reset() {
        this.targetId = "";
        this.targetTag = "";
        this.targetClasses = Collections.EMPTY_LIST;
        this.targetVoice = "";
        this.fontFamily = null;
        this.hasFontColor = false;
        this.hasBackgroundColor = false;
        this.linethrough = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.fontSizeUnit = -1;
        this.textAlign = null;
    }

    public final WebvttCssStyle setBackgroundColor(int i5) {
        this.backgroundColor = i5;
        this.hasBackgroundColor = true;
        return this;
    }

    public final WebvttCssStyle setBold(boolean z4) {
        this.bold = z4 ? 1 : 0;
        return this;
    }

    public final WebvttCssStyle setFontColor(int i5) {
        this.fontColor = i5;
        this.hasFontColor = true;
        return this;
    }

    public final WebvttCssStyle setFontFamily(String str) {
        this.fontFamily = Util.toLowerInvariant(str);
        return this;
    }

    public final WebvttCssStyle setFontSize(float f5) {
        this.fontSize = f5;
        return this;
    }

    public final WebvttCssStyle setFontSizeUnit(short s5) {
        this.fontSizeUnit = s5;
        return this;
    }

    public final WebvttCssStyle setItalic(boolean z4) {
        this.italic = z4 ? 1 : 0;
        return this;
    }

    public final WebvttCssStyle setLinethrough(boolean z4) {
        this.linethrough = z4 ? 1 : 0;
        return this;
    }

    public final void setTargetClasses(String[] strArr) {
        this.targetClasses = Arrays.asList(strArr);
    }

    public final void setTargetId(String str) {
        this.targetId = str;
    }

    public final void setTargetTagName(String str) {
        this.targetTag = str;
    }

    public final void setTargetVoice(String str) {
        this.targetVoice = str;
    }

    public final WebvttCssStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public final WebvttCssStyle setUnderline(boolean z4) {
        this.underline = z4 ? 1 : 0;
        return this;
    }
}
