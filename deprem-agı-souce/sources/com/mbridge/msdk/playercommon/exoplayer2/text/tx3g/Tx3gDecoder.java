package com.mbridge.msdk.playercommon.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '﻿';
    private static final char BOM_UTF16_LE = '￾';
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 16711680;
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = Util.getIntegerCodeForString("styl");
    private static final int TYPE_TBOX = Util.getIntegerCodeForString("tbox");
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        decodeInitializationData(list);
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray2, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        boolean z4;
        if (parsableByteArray2.bytesLeft() >= 12) {
            z4 = true;
        } else {
            z4 = false;
        }
        assertTrue(z4);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        parsableByteArray2.skipBytes(1);
        int readInt = parsableByteArray2.readInt();
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        attachFontFace(spannableStringBuilder2, readUnsignedByte, this.defaultFontFace, readUnsignedShort, readUnsignedShort2, 0);
        attachColor(spannableStringBuilder2, readInt, this.defaultColorRgba, readUnsignedShort, readUnsignedShort2, 0);
    }

    private static void assertTrue(boolean z4) throws SubtitleDecoderException {
        if (!z4) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int i5, int i6, int i7, int i8, int i9) {
        if (i5 != i6) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i5 >>> 8) | ((i5 & 255) << 24)), i7, i8, i9 | 33);
        }
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i5, int i6, int i7, int i8, int i9) {
        boolean z4;
        boolean z5;
        if (i5 != i6) {
            int i10 = i9 | 33;
            boolean z6 = true;
            if ((i5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i5 & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z4) {
                if (z5) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i7, i8, i10);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i7, i8, i10);
                }
            } else if (z5) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i7, i8, i10);
            }
            if ((i5 & 4) == 0) {
                z6 = false;
            }
            if (z6) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i7, i8, i10);
            }
            if (!z6 && !z4 && !z5) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i7, i8, i10);
            }
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i5, int i6, int i7) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i5, i6, i7 | 33);
        }
    }

    private void decodeInitializationData(List<byte[]> list) {
        String str = "sans-serif";
        boolean z4 = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            if (TX3G_SERIF.equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43))) {
                str = C.SERIF_NAME;
            }
            this.defaultFontFamily = str;
            int i5 = bArr[25] * 20;
            this.calculatedVideoTrackHeight = i5;
            if ((bArr[0] & 32) != 0) {
                z4 = true;
            }
            this.customVerticalPlacement = z4;
            if (z4) {
                float f5 = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i5);
                this.defaultVerticalPlacement = f5;
                this.defaultVerticalPlacement = Util.constrainValue(f5, 0.0f, 0.95f);
                return;
            }
            this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
            return;
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = str;
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray2) throws SubtitleDecoderException {
        boolean z4;
        char peekChar;
        if (parsableByteArray2.bytesLeft() >= 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        assertTrue(z4);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (parsableByteArray2.bytesLeft() < 2 || ((peekChar = parsableByteArray2.peekChar()) != 65279 && peekChar != 65534)) {
            return parsableByteArray2.readString(readUnsignedShort, Charset.forName(C.UTF8_NAME));
        }
        return parsableByteArray2.readString(readUnsignedShort, Charset.forName(C.UTF16_NAME));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7, types: [int] */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle decode(byte[] r10, int r11, boolean r12) throws com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException {
        /*
            r9 = this;
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            r12.reset(r10, r11)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r9.parsableByteArray
            java.lang.String r10 = readSubtitleText(r10)
            boolean r11 = r10.isEmpty()
            if (r11 == 0) goto L_0x0014
            com.mbridge.msdk.playercommon.exoplayer2.text.tx3g.Tx3gSubtitle r10 = com.mbridge.msdk.playercommon.exoplayer2.text.tx3g.Tx3gSubtitle.EMPTY
            return r10
        L_0x0014:
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r10)
            int r1 = r9.defaultFontFace
            int r4 = r0.length()
            r5 = 16711680(0xff0000, float:2.3418052E-38)
            r2 = 0
            r3 = 0
            attachFontFace(r0, r1, r2, r3, r4, r5)
            int r1 = r9.defaultColorRgba
            int r4 = r0.length()
            r2 = -1
            attachColor(r0, r1, r2, r3, r4, r5)
            java.lang.String r1 = r9.defaultFontFamily
            int r4 = r0.length()
            java.lang.String r2 = "sans-serif"
            attachFontFamily(r0, r1, r2, r3, r4, r5)
            float r10 = r9.defaultVerticalPlacement
            r3 = r10
        L_0x003e:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r9.parsableByteArray
            int r10 = r10.bytesLeft()
            r11 = 8
            if (r10 < r11) goto L_0x00ad
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r10 = r9.parsableByteArray
            int r10 = r10.getPosition()
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r11 = r9.parsableByteArray
            int r11 = r11.readInt()
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            int r12 = r12.readInt()
            int r1 = TYPE_STYL
            r2 = 2
            r4 = 0
            r5 = 1
            if (r12 != r1) goto L_0x007e
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            int r12 = r12.bytesLeft()
            if (r12 < r2) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r5 = r4
        L_0x006b:
            assertTrue(r5)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            int r12 = r12.readUnsignedShort()
        L_0x0074:
            if (r4 >= r12) goto L_0x00a6
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = r9.parsableByteArray
            r9.applyStyleRecord(r1, r0)
            int r4 = r4 + 1
            goto L_0x0074
        L_0x007e:
            int r1 = TYPE_TBOX
            if (r12 != r1) goto L_0x00a6
            boolean r12 = r9.customVerticalPlacement
            if (r12 == 0) goto L_0x00a6
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            int r12 = r12.bytesLeft()
            if (r12 < r2) goto L_0x008f
            r4 = r5
        L_0x008f:
            assertTrue(r4)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            int r12 = r12.readUnsignedShort()
            float r12 = (float) r12
            int r1 = r9.calculatedVideoTrackHeight
            float r1 = (float) r1
            float r12 = r12 / r1
            r1 = 0
            r2 = 1064514355(0x3f733333, float:0.95)
            float r12 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.constrainValue((float) r12, (float) r1, (float) r2)
            r3 = r12
        L_0x00a6:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r12 = r9.parsableByteArray
            int r10 = r10 + r11
            r12.setPosition(r10)
            goto L_0x003e
        L_0x00ad:
            com.mbridge.msdk.playercommon.exoplayer2.text.tx3g.Tx3gSubtitle r10 = new com.mbridge.msdk.playercommon.exoplayer2.text.tx3g.Tx3gSubtitle
            r1 = r0
            com.mbridge.msdk.playercommon.exoplayer2.text.Cue r0 = new com.mbridge.msdk.playercommon.exoplayer2.text.Cue
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = 1
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 1
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.<init>(r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.tx3g.Tx3gDecoder.decode(byte[], int, boolean):com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle");
    }
}
