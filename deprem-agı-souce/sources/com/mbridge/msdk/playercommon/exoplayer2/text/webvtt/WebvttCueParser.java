package com.mbridge.msdk.playercommon.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.text.webvtt.WebvttCue;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser {
    private static final char CHAR_AMPERSAND = '&';
    private static final char CHAR_GREATER_THAN = '>';
    private static final char CHAR_LESS_THAN = '<';
    private static final char CHAR_SEMI_COLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_SPACE = ' ';
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    private static final String ENTITY_AMPERSAND = "amp";
    private static final String ENTITY_GREATER_THAN = "gt";
    private static final String ENTITY_LESS_THAN = "lt";
    private static final String ENTITY_NON_BREAK_SPACE = "nbsp";
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final String TAG = "WebvttCueParser";
    private static final String TAG_BOLD = "b";
    private static final String TAG_CLASS = "c";
    private static final String TAG_ITALIC = "i";
    private static final String TAG_LANG = "lang";
    private static final String TAG_UNDERLINE = "u";
    private static final String TAG_VOICE = "v";
    private final StringBuilder textBuilder = new StringBuilder();

    private static final class StartTag {
        private static final String[] NO_CLASSES = new String[0];
        public final String[] classes;
        public final String name;
        public final int position;
        public final String voice;

        private StartTag(String str, int i5, String str2, String[] strArr) {
            this.position = i5;
            this.name = str;
            this.voice = str2;
            this.classes = strArr;
        }

        public static StartTag buildStartTag(String str, int i5) {
            String str2;
            String[] strArr;
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = Util.split(trim, "\\.");
            String str3 = split[0];
            if (split.length > 1) {
                strArr = (String[]) Arrays.copyOfRange(split, 1, split.length);
            } else {
                strArr = NO_CLASSES;
            }
            return new StartTag(str3, i5, str2, strArr);
        }

        public static StartTag buildWholeCueVirtualTag() {
            return new StartTag("", 0, "", new String[0]);
        }
    }

    private static final class StyleMatch implements Comparable<StyleMatch> {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int i5, WebvttCssStyle webvttCssStyle) {
            this.score = i5;
            this.style = webvttCssStyle;
        }

        public final int compareTo(@NonNull StyleMatch styleMatch) {
            return this.score - styleMatch.score;
        }
    }

    private static void applyEntity(String str, SpannableStringBuilder spannableStringBuilder) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals(ENTITY_GREATER_THAN)) {
                    c5 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals(ENTITY_LESS_THAN)) {
                    c5 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals(ENTITY_AMPERSAND)) {
                    c5 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals(ENTITY_NON_BREAK_SPACE)) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                spannableStringBuilder.append(CHAR_GREATER_THAN);
                return;
            case 1:
                spannableStringBuilder.append(CHAR_LESS_THAN);
                return;
            case 2:
                spannableStringBuilder.append(CHAR_AMPERSAND);
                return;
            case 3:
                spannableStringBuilder.append(CHAR_SPACE);
                return;
            default:
                Log.w(TAG, "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static void applySpansForTag(String str, StartTag startTag, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list, List<StyleMatch> list2) {
        int i5 = startTag.position;
        int length = spannableStringBuilder.length();
        String str2 = startTag.name;
        str2.getClass();
        char c5 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c5 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c5 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals(TAG_CLASS)) {
                    c5 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c5 = 3;
                    break;
                }
                break;
            case 117:
                if (str2.equals(TAG_UNDERLINE)) {
                    c5 = 4;
                    break;
                }
                break;
            case 118:
                if (str2.equals(TAG_VOICE)) {
                    c5 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals(TAG_LANG)) {
                    c5 = 6;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 2:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i5, length, 33);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i5, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i5, length, 33);
                break;
            default:
                return;
        }
        list2.clear();
        getApplicableStyles(list, str, startTag, list2);
        int size = list2.size();
        for (int i6 = 0; i6 < size; i6++) {
            applyStyleToText(spannableStringBuilder, list2.get(i6).style, i5, length);
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i5, int i6) {
        if (webvttCssStyle != null) {
            if (webvttCssStyle.getStyle() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(webvttCssStyle.getStyle()), i5, i6, 33);
            }
            if (webvttCssStyle.isLinethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i5, i6, 33);
            }
            if (webvttCssStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i5, i6, 33);
            }
            if (webvttCssStyle.hasFontColor()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(webvttCssStyle.getFontColor()), i5, i6, 33);
            }
            if (webvttCssStyle.hasBackgroundColor()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i5, i6, 33);
            }
            if (webvttCssStyle.getFontFamily() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(webvttCssStyle.getFontFamily()), i5, i6, 33);
            }
            if (webvttCssStyle.getTextAlign() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(webvttCssStyle.getTextAlign()), i5, i6, 33);
            }
            int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
            if (fontSizeUnit == 1) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i5, i6, 33);
            } else if (fontSizeUnit == 2) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.getFontSize()), i5, i6, 33);
            } else if (fontSizeUnit == 3) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i5, i6, 33);
            }
        }
    }

    private static int findEndOfTag(String str, int i5) {
        int indexOf = str.indexOf(62, i5);
        if (indexOf == -1) {
            return str.length();
        }
        return indexOf + 1;
    }

    private static void getApplicableStyles(List<WebvttCssStyle> list, String str, StartTag startTag, List<StyleMatch> list2) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            WebvttCssStyle webvttCssStyle = list.get(i5);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.name, startTag.classes, startTag.voice);
            if (specificityScore > 0) {
                list2.add(new StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(list2);
    }

    private static String getTagName(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return Util.splitAtFirst(trim, "[ \\.]")[0];
    }

    private static boolean isSupportedTag(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c5 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals(TAG_CLASS)) {
                    c5 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c5 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals(TAG_UNDERLINE)) {
                    c5 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals(TAG_VOICE)) {
                    c5 = 4;
                    break;
                }
                break;
            case 3314158:
                if (str.equals(TAG_LANG)) {
                    c5 = 5;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    static void parseCueSettingsList(String str, WebvttCue.Builder builder) {
        Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    parseLineAttribute(group2, builder);
                } else if ("align".equals(group)) {
                    builder.setTextAlignment(parseTextAlignment(group2));
                } else if ("position".equals(group)) {
                    parsePositionAttribute(group2, builder);
                } else if ("size".equals(group)) {
                    builder.setWidth(WebvttParserUtil.parsePercentage(group2));
                } else {
                    Log.w(TAG, "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException unused) {
                Log.w(TAG, "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static void parseCueText(String str, String str2, WebvttCue.Builder builder, List<WebvttCssStyle> list) {
        boolean z4;
        boolean z5;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 < str2.length()) {
            char charAt = str2.charAt(i5);
            if (charAt == '&') {
                i5++;
                int indexOf = str2.indexOf(59, i5);
                int indexOf2 = str2.indexOf(32, i5);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    applyEntity(str2.substring(i5, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i5 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i5++;
            } else {
                int i6 = i5 + 1;
                if (i6 < str2.length()) {
                    int i7 = 1;
                    if (str2.charAt(i6) == '/') {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i6 = findEndOfTag(str2, i6);
                    int i8 = i6 - 2;
                    if (str2.charAt(i8) == '/') {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z4) {
                        i7 = 2;
                    }
                    int i9 = i5 + i7;
                    if (!z5) {
                        i8 = i6 - 1;
                    }
                    String substring = str2.substring(i9, i8);
                    String tagName = getTagName(substring);
                    if (tagName != null && isSupportedTag(tagName)) {
                        if (z4) {
                            while (!arrayDeque.isEmpty()) {
                                StartTag startTag = (StartTag) arrayDeque.pop();
                                applySpansForTag(str, startTag, spannableStringBuilder, list, arrayList);
                                if (startTag.name.equals(tagName)) {
                                    break;
                                }
                            }
                        } else if (!z5) {
                            arrayDeque.push(StartTag.buildStartTag(substring, spannableStringBuilder.length()));
                        }
                    }
                }
                i5 = i6;
            }
        }
        while (!arrayDeque.isEmpty()) {
            applySpansForTag(str, (StartTag) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        applySpansForTag(str, StartTag.buildWholeCueVirtualTag(), spannableStringBuilder, list, arrayList);
        builder.setText(spannableStringBuilder);
    }

    private static void parseLineAttribute(String str, WebvttCue.Builder builder) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            builder.setLineAnchor(parsePositionAnchor(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            builder.setLineAnchor(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            builder.setLine(WebvttParserUtil.parsePercentage(str)).setLineType(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        builder.setLine((float) parseInt).setLineType(1);
    }

    private static int parsePositionAnchor(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c5 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c5 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c5 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                Log.w(TAG, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void parsePositionAttribute(String str, WebvttCue.Builder builder) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            builder.setPositionAnchor(parsePositionAnchor(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            builder.setPositionAnchor(Integer.MIN_VALUE);
        }
        builder.setPosition(WebvttParserUtil.parsePercentage(str));
    }

    private static Layout.Alignment parseTextAlignment(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c5 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c5 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c5 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    c5 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c5 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c5 = 5;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 1:
                return Layout.Alignment.ALIGN_CENTER;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 3:
            case 5:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                Log.w(TAG, "Invalid alignment value: " + str);
                return null;
        }
    }

    public final boolean parseCue(ParsableByteArray parsableByteArray, WebvttCue.Builder builder, List<WebvttCssStyle> list) {
        String readLine = parsableByteArray.readLine();
        if (readLine == null) {
            return false;
        }
        Pattern pattern = CUE_HEADER_PATTERN;
        Matcher matcher = pattern.matcher(readLine);
        if (matcher.matches()) {
            return parseCue((String) null, matcher, parsableByteArray, builder, this.textBuilder, list);
        }
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        WebvttCue.Builder builder2 = builder;
        List<WebvttCssStyle> list2 = list;
        String readLine2 = parsableByteArray2.readLine();
        if (readLine2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(readLine2);
        if (!matcher2.matches()) {
            return false;
        }
        return parseCue(readLine.trim(), matcher2, parsableByteArray2, builder2, this.textBuilder, list2);
    }

    private static boolean parseCue(String str, Matcher matcher, ParsableByteArray parsableByteArray, WebvttCue.Builder builder, StringBuilder sb, List<WebvttCssStyle> list) {
        try {
            builder.setStartTime(WebvttParserUtil.parseTimestampUs(matcher.group(1))).setEndTime(WebvttParserUtil.parseTimestampUs(matcher.group(2)));
            parseCueSettingsList(matcher.group(3), builder);
            sb.setLength(0);
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(readLine.trim());
                } else {
                    parseCueText(str, sb.toString(), builder, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }
}
