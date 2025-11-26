package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

final class TtmlRenderUtil {
    private TtmlRenderUtil() {
    }

    public static void applyStylesToSpan(SpannableStringBuilder spannableStringBuilder, int i5, int i6, TtmlStyle ttmlStyle) {
        if (ttmlStyle.getStyle() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(ttmlStyle.getStyle()), i5, i6, 33);
        }
        if (ttmlStyle.isLinethrough()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i5, i6, 33);
        }
        if (ttmlStyle.isUnderline()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i5, i6, 33);
        }
        if (ttmlStyle.hasFontColor()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ttmlStyle.getFontColor()), i5, i6, 33);
        }
        if (ttmlStyle.hasBackgroundColor()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(ttmlStyle.getBackgroundColor()), i5, i6, 33);
        }
        if (ttmlStyle.getFontFamily() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(ttmlStyle.getFontFamily()), i5, i6, 33);
        }
        if (ttmlStyle.getTextAlign() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(ttmlStyle.getTextAlign()), i5, i6, 33);
        }
        int fontSizeUnit = ttmlStyle.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) ttmlStyle.getFontSize(), true), i5, i6, 33);
        } else if (fontSizeUnit == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.getFontSize()), i5, i6, 33);
        } else if (fontSizeUnit == 3) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.getFontSize() / 100.0f), i5, i6, 33);
        }
    }

    static String applyTextElementSpacePolicy(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void endParagraph(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != 10) {
            spannableStringBuilder.append(10);
        }
    }

    public static TtmlStyle resolveStyle(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        if (ttmlStyle == null && strArr == null) {
            return null;
        }
        int i5 = 0;
        if (ttmlStyle == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (ttmlStyle == null && strArr.length > 1) {
            TtmlStyle ttmlStyle2 = new TtmlStyle();
            int length = strArr.length;
            while (i5 < length) {
                ttmlStyle2.chain(map.get(strArr[i5]));
                i5++;
            }
            return ttmlStyle2;
        } else if (ttmlStyle != null && strArr != null && strArr.length == 1) {
            return ttmlStyle.chain(map.get(strArr[0]));
        } else {
            if (!(ttmlStyle == null || strArr == null || strArr.length <= 1)) {
                int length2 = strArr.length;
                while (i5 < length2) {
                    ttmlStyle.chain(map.get(strArr[i5]));
                    i5++;
                }
            }
            return ttmlStyle;
        }
    }
}
