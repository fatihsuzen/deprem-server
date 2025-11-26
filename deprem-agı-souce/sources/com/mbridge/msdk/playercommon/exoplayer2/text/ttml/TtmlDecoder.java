package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i5, int i6) {
            this.columns = i5;
            this.rows = i6;
        }
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f5, int i5, int i6) {
            this.effectiveFrameRate = f5;
            this.subFrameRate = i5;
            this.tickRate = i6;
        }
    }

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e5) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e5);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        if (ttmlStyle == null) {
            return new TtmlStyle();
        }
        return ttmlStyle;
    }

    private static boolean isSupportedTag(String str) {
        if (str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals(TtmlNode.TAG_SMPTE_IMAGE) || str.equals(TtmlNode.TAG_SMPTE_DATA) || str.equals(TtmlNode.TAG_SMPTE_INFORMATION)) {
            return true;
        }
        return false;
    }

    private CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new CellResolution(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.getClass();
            char c5 = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        int i5;
        float f5;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        if (attributeValue != null) {
            i5 = Integer.parseInt(attributeValue);
        } else {
            i5 = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = Util.split(attributeValue2, " ");
            if (split.length == 2) {
                f5 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f5 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i6 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i6 = Integer.parseInt(attributeValue3);
        }
        int i7 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i7 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) i5) * f5, i6, i7);
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, CellResolution cellResolution) throws IOException, XmlPullParserException {
        TtmlRegion parseRegionAttributes;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                if (parseStyleAttributes.getId() != null) {
                    map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution)) != null) {
                map2.put(parseRegionAttributes.id, parseRegionAttributes);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j5;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TtmlNode ttmlNode2 = ttmlNode;
        FrameAndTickRate frameAndTickRate2 = frameAndTickRate;
        int attributeCount = xmlPullParser2.getAttributeCount();
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser2, (TtmlStyle) null);
        String[] strArr = null;
        String str = "";
        long j6 = C.TIME_UNSET;
        long j7 = C.TIME_UNSET;
        long j8 = C.TIME_UNSET;
        for (int i5 = 0; i5 < attributeCount; i5++) {
            String attributeName = xmlPullParser2.getAttributeName(i5);
            String attributeValue = xmlPullParser2.getAttributeValue(i5);
            attributeName.getClass();
            char c5 = 65535;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals(ATTR_DURATION)) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals(ATTR_BEGIN)) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str = attributeValue;
                        continue;
                    }
                case 1:
                    j8 = parseTimeExpression(attributeValue, frameAndTickRate2);
                    break;
                case 2:
                    j7 = parseTimeExpression(attributeValue, frameAndTickRate2);
                    break;
                case 3:
                    j6 = parseTimeExpression(attributeValue, frameAndTickRate2);
                    break;
                case 4:
                    String[] parseStyleIds = parseStyleIds(attributeValue);
                    if (parseStyleIds.length > 0) {
                        strArr = parseStyleIds;
                        break;
                    }
                    break;
            }
            Map<String, TtmlRegion> map2 = map;
        }
        if (ttmlNode2 != null) {
            long j9 = ttmlNode2.startTimeUs;
            if (j9 != C.TIME_UNSET) {
                if (j6 != C.TIME_UNSET) {
                    j6 += j9;
                }
                if (j7 != C.TIME_UNSET) {
                    j7 += j9;
                }
            }
        }
        long j10 = j6;
        if (j7 == C.TIME_UNSET) {
            if (j8 != C.TIME_UNSET) {
                j7 = j10 + j8;
            } else if (ttmlNode2 != null) {
                long j11 = ttmlNode2.endTimeUs;
                if (j11 != C.TIME_UNSET) {
                    j5 = j11;
                    return TtmlNode.buildNode(xmlPullParser2.getName(), j10, j5, parseStyleAttributes, strArr, str);
                }
            }
        }
        j5 = j7;
        return TtmlNode.buildNode(xmlPullParser2.getName(), j10, j5, parseStyleAttributes, strArr, str);
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, CellResolution cellResolution) {
        float f5;
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_ORIGIN);
        if (attributeValue2 != null) {
            Pattern pattern = PERCENTAGE_COORDINATES;
            Matcher matcher = pattern.matcher(attributeValue2);
            if (matcher.matches()) {
                int i5 = 1;
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
                    if (attributeValue3 != null) {
                        Matcher matcher2 = pattern.matcher(attributeValue3);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                if (attributeValue4 != null) {
                                    String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                                    lowerInvariant.getClass();
                                    if (lowerInvariant.equals(TtmlNode.CENTER)) {
                                        parseFloat2 += parseFloat4 / 2.0f;
                                        f5 = parseFloat2;
                                        return new TtmlRegion(attributeValue, parseFloat, f5, 0, i5, parseFloat3, 1, 1.0f / ((float) cellResolution.rows));
                                    } else if (lowerInvariant.equals("after")) {
                                        f5 = parseFloat2 + parseFloat4;
                                        i5 = 2;
                                        return new TtmlRegion(attributeValue, parseFloat, f5, 0, i5, parseFloat3, 1, 1.0f / ((float) cellResolution.rows));
                                    }
                                }
                                i5 = 0;
                                f5 = parseFloat2;
                                return new TtmlRegion(attributeValue, parseFloat, f5, 0, i5, parseFloat3, 1, 1.0f / ((float) cellResolution.rows));
                            } catch (NumberFormatException unused) {
                                Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue2);
                                return null;
                            }
                        } else {
                            Log.w(TAG, "Ignoring region with unsupported extent: " + attributeValue2);
                            return null;
                        }
                    } else {
                        Log.w(TAG, "Ignoring region without an extent");
                        return null;
                    }
                } catch (NumberFormatException unused2) {
                    Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue2);
                    return null;
                }
            } else {
                Log.w(TAG, "Ignoring region with unsupported origin: " + attributeValue2);
                return null;
            }
        } else {
            Log.w(TAG, "Ignoring region without an origin");
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012e, code lost:
        if (r3.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.LINETHROUGH) == false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0194, code lost:
        if (r3.equals("start") == false) goto L_0x018c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle parseStyleAttributes(org.xmlpull.v1.XmlPullParser r12, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13) {
        /*
            r11 = this;
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = r1
        L_0x0006:
            if (r2 >= r0) goto L_0x0218
            java.lang.String r3 = r12.getAttributeValue(r2)
            java.lang.String r4 = r12.getAttributeName(r2)
            r4.getClass()
            int r5 = r4.hashCode()
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = -1
            r10 = 1
            switch(r5) {
                case -1550943582: goto L_0x007c;
                case -1224696685: goto L_0x0071;
                case -1065511464: goto L_0x0066;
                case -879295043: goto L_0x005b;
                case -734428249: goto L_0x0050;
                case 3355: goto L_0x0045;
                case 94842723: goto L_0x003a;
                case 365601008: goto L_0x002f;
                case 1287124693: goto L_0x0022;
                default: goto L_0x001f;
            }
        L_0x001f:
            r4 = r9
            goto L_0x0086
        L_0x0022:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002b
            goto L_0x001f
        L_0x002b:
            r4 = 8
            goto L_0x0086
        L_0x002f:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0038
            goto L_0x001f
        L_0x0038:
            r4 = 7
            goto L_0x0086
        L_0x003a:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0043
            goto L_0x001f
        L_0x0043:
            r4 = 6
            goto L_0x0086
        L_0x0045:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x004e
            goto L_0x001f
        L_0x004e:
            r4 = 5
            goto L_0x0086
        L_0x0050:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0059
            goto L_0x001f
        L_0x0059:
            r4 = r6
            goto L_0x0086
        L_0x005b:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0064
            goto L_0x001f
        L_0x0064:
            r4 = r7
            goto L_0x0086
        L_0x0066:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006f
            goto L_0x001f
        L_0x006f:
            r4 = r8
            goto L_0x0086
        L_0x0071:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x001f
        L_0x007a:
            r4 = r10
            goto L_0x0086
        L_0x007c:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0085
            goto L_0x001f
        L_0x0085:
            r4 = r1
        L_0x0086:
            java.lang.String r5 = "TtmlDecoder"
            switch(r4) {
                case 0: goto L_0x0206;
                case 1: goto L_0x01fd;
                case 2: goto L_0x017e;
                case 3: goto L_0x0118;
                case 4: goto L_0x0108;
                case 5: goto L_0x00f2;
                case 6: goto L_0x00cf;
                case 7: goto L_0x00b0;
                case 8: goto L_0x008d;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x0214
        L_0x008d:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.ColorParser.parseTtmlColor(r3)     // Catch:{ IllegalArgumentException -> 0x009a }
            r13.setBackgroundColor(r4)     // Catch:{ IllegalArgumentException -> 0x009a }
            goto L_0x0214
        L_0x009a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing background value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r5, r3)
            goto L_0x0214
        L_0x00b0:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)     // Catch:{ SubtitleDecoderException -> 0x00b9 }
            parseFontSize(r3, r13)     // Catch:{ SubtitleDecoderException -> 0x00b9 }
            goto L_0x0214
        L_0x00b9:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing fontSize value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r5, r3)
            goto L_0x0214
        L_0x00cf:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.ColorParser.parseTtmlColor(r3)     // Catch:{ IllegalArgumentException -> 0x00dc }
            r13.setFontColor(r4)     // Catch:{ IllegalArgumentException -> 0x00dc }
            goto L_0x0214
        L_0x00dc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing color value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r5, r3)
            goto L_0x0214
        L_0x00f2:
            java.lang.String r4 = "style"
            java.lang.String r5 = r12.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0214
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setId(r3)
            goto L_0x0214
        L_0x0108:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setBold(r3)
            goto L_0x0214
        L_0x0118:
            java.lang.String r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toLowerInvariant(r3)
            r3.getClass()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x0147;
                case -1026963764: goto L_0x013c;
                case 913457136: goto L_0x0131;
                case 1679736913: goto L_0x0128;
                default: goto L_0x0126;
            }
        L_0x0126:
            r7 = r9
            goto L_0x0151
        L_0x0128:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0151
            goto L_0x0126
        L_0x0131:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x013a
            goto L_0x0126
        L_0x013a:
            r7 = r8
            goto L_0x0151
        L_0x013c:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0145
            goto L_0x0126
        L_0x0145:
            r7 = r10
            goto L_0x0151
        L_0x0147:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0150
            goto L_0x0126
        L_0x0150:
            r7 = r1
        L_0x0151:
            switch(r7) {
                case 0: goto L_0x0174;
                case 1: goto L_0x016a;
                case 2: goto L_0x0160;
                case 3: goto L_0x0156;
                default: goto L_0x0154;
            }
        L_0x0154:
            goto L_0x0214
        L_0x0156:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setLinethrough(r10)
            goto L_0x0214
        L_0x0160:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setLinethrough(r1)
            goto L_0x0214
        L_0x016a:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setUnderline(r10)
            goto L_0x0214
        L_0x0174:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setUnderline(r1)
            goto L_0x0214
        L_0x017e:
            java.lang.String r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toLowerInvariant(r3)
            r3.getClass()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1364013995: goto L_0x01b8;
                case 100571: goto L_0x01ad;
                case 3317767: goto L_0x01a2;
                case 108511772: goto L_0x0197;
                case 109757538: goto L_0x018e;
                default: goto L_0x018c;
            }
        L_0x018c:
            r6 = r9
            goto L_0x01c2
        L_0x018e:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01c2
            goto L_0x018c
        L_0x0197:
            java.lang.String r4 = "right"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01a0
            goto L_0x018c
        L_0x01a0:
            r6 = r7
            goto L_0x01c2
        L_0x01a2:
            java.lang.String r4 = "left"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01ab
            goto L_0x018c
        L_0x01ab:
            r6 = r8
            goto L_0x01c2
        L_0x01ad:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01b6
            goto L_0x018c
        L_0x01b6:
            r6 = r10
            goto L_0x01c2
        L_0x01b8:
            java.lang.String r4 = "center"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01c1
            goto L_0x018c
        L_0x01c1:
            r6 = r1
        L_0x01c2:
            switch(r6) {
                case 0: goto L_0x01f2;
                case 1: goto L_0x01e7;
                case 2: goto L_0x01dc;
                case 3: goto L_0x01d1;
                case 4: goto L_0x01c6;
                default: goto L_0x01c5;
            }
        L_0x01c5:
            goto L_0x0214
        L_0x01c6:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x0214
        L_0x01d1:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x0214
        L_0x01dc:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x0214
        L_0x01e7:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x0214
        L_0x01f2:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setTextAlign(r3)
            goto L_0x0214
        L_0x01fd:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setFontFamily(r3)
            goto L_0x0214
        L_0x0206:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r11.createIfNull(r13)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r13 = r13.setItalic(r3)
        L_0x0214:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0218:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder.parseStyleAttributes(org.xmlpull.v1.XmlPullParser, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle):com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle");
    }

    private String[] parseStyleIds(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        return Util.split(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009e, code lost:
        if (r13.equals("ms") == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d5, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dd, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long parseTimeExpression(java.lang.String r13, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r14) throws com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException {
        /*
            java.util.regex.Pattern r0 = CLOCK_TIME
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4
            r3 = 3
            r4 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0073
            java.lang.String r13 = r0.group(r7)
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r3)
            long r9 = java.lang.Long.parseLong(r13)
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r2)
            r1 = 0
            if (r13 == 0) goto L_0x0045
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x0046
        L_0x0045:
            r9 = r1
        L_0x0046:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0058
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r3 = r14.effectiveFrameRate
            float r13 = r13 / r3
            double r9 = (double) r13
            goto L_0x0059
        L_0x0058:
            r9 = r1
        L_0x0059:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x006f
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.subFrameRate
            double r2 = (double) r13
            double r0 = r0 / r2
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            double r1 = r0 / r13
        L_0x006f:
            double r7 = r7 + r1
            double r7 = r7 * r4
            long r13 = (long) r7
            return r13
        L_0x0073:
            java.util.regex.Pattern r0 = OFFSET_TIME
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x00ec
            java.lang.String r13 = r0.group(r7)
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            r13.getClass()
            int r0 = r13.hashCode()
            r1 = -1
            switch(r0) {
                case 102: goto L_0x00c2;
                case 104: goto L_0x00b7;
                case 109: goto L_0x00ac;
                case 116: goto L_0x00a1;
                case 3494: goto L_0x0098;
                default: goto L_0x0096;
            }
        L_0x0096:
            r2 = r1
            goto L_0x00cc
        L_0x0098:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00cc
            goto L_0x0096
        L_0x00a1:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00aa
            goto L_0x0096
        L_0x00aa:
            r2 = r3
            goto L_0x00cc
        L_0x00ac:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00b5
            goto L_0x0096
        L_0x00b5:
            r2 = r6
            goto L_0x00cc
        L_0x00b7:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00c0
            goto L_0x0096
        L_0x00c0:
            r2 = r7
            goto L_0x00cc
        L_0x00c2:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00cb
            goto L_0x0096
        L_0x00cb:
            r2 = 0
        L_0x00cc:
            switch(r2) {
                case 0: goto L_0x00e5;
                case 1: goto L_0x00df;
                case 2: goto L_0x00db;
                case 3: goto L_0x00d7;
                case 4: goto L_0x00d0;
                default: goto L_0x00cf;
            }
        L_0x00cf:
            goto L_0x00e9
        L_0x00d0:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00d5:
            double r8 = r8 / r13
            goto L_0x00e9
        L_0x00d7:
            int r13 = r14.tickRate
            double r13 = (double) r13
            goto L_0x00d5
        L_0x00db:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
        L_0x00dd:
            double r8 = r8 * r13
            goto L_0x00e9
        L_0x00df:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            goto L_0x00dd
        L_0x00e5:
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            goto L_0x00d5
        L_0x00e9:
            double r8 = r8 * r4
            long r13 = (long) r8
            return r13
        L_0x00ec:
            com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException r14 = new com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Malformed time expression: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder.parseTimeExpression(java.lang.String, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }

    /* access modifiers changed from: protected */
    public final TtmlSubtitle decode(byte[] bArr, int i5, boolean z4) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            TtmlSubtitle ttmlSubtitle = null;
            hashMap2.put("", new TtmlRegion((String) null));
            int i6 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i5), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i6 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            frameAndTickRate = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                        }
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if (TtmlNode.TAG_HEAD.equals(name)) {
                            parseHeader(newPullParser, hashMap, hashMap2, cellResolution);
                        } else {
                            try {
                                TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                arrayDeque.push(parseNode);
                                if (ttmlNode != null) {
                                    ttmlNode.addChild(parseNode);
                                }
                            } catch (SubtitleDecoderException e5) {
                                Log.w(TAG, "Suppressing parser error", e5);
                            }
                        }
                    } else if (eventType == 4) {
                        ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) arrayDeque.peek(), hashMap, hashMap2);
                        }
                        arrayDeque.pop();
                    }
                    newPullParser.next();
                } else if (eventType != 2) {
                    if (eventType == 3) {
                        i6--;
                    }
                    newPullParser.next();
                }
                i6++;
                newPullParser.next();
            }
            return ttmlSubtitle;
        } catch (XmlPullParserException e6) {
            throw new SubtitleDecoderException("Unable to decode source", e6);
        } catch (IOException e7) {
            throw new IllegalStateException("Unexpected error when reading input.", e7);
        }
    }
}
