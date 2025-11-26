package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleOutputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea708Decoder extends CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final CueBuilder[] cueBuilders;
    private List<Cue> cues;
    private CueBuilder currentCueBuilder;
    private DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private List<Cue> lastCues;
    private final int selectedServiceNumber;
    private final ParsableBitArray serviceBlockPacket = new ParsableBitArray();

    private static final class CueBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK;
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int COLOR_TRANSPARENT;
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND;
        private static final int[] PEN_STYLE_EDGE_TYPE = {0, 0, 0, 0, 0, 3, 3};
        private static final int[] PEN_STYLE_FONT_STYLE = {0, 1, 2, 3, 4, 3, 4};
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private static final int[] WINDOW_STYLE_JUSTIFICATION = {0, 0, 0, 0, 0, 2, 0};
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION = {0, 0, 0, 0, 0, 0, 2};
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION = {3, 3, 3, 3, 3, 3, 1};
        private static final boolean[] WINDOW_STYLE_WORD_WRAP = {false, false, false, true, true, true, false};
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private int row;
        private int rowCount;
        private boolean rowLock;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;

        static {
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 0);
            COLOR_SOLID_BLACK = argbColorFromCeaColor;
            int argbColorFromCeaColor2 = getArgbColorFromCeaColor(0, 0, 0, 3);
            COLOR_TRANSPARENT = argbColorFromCeaColor2;
            int i5 = argbColorFromCeaColor;
            int i6 = argbColorFromCeaColor;
            WINDOW_STYLE_FILL = new int[]{argbColorFromCeaColor, argbColorFromCeaColor2, i5, i6, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor};
            int i7 = argbColorFromCeaColor2;
            PEN_STYLE_BACKGROUND = new int[]{argbColorFromCeaColor, argbColorFromCeaColor, i5, i6, argbColorFromCeaColor, i7, i7};
        }

        public CueBuilder() {
            reset();
        }

        public static int getArgbColorFromCeaColor(int i5, int i6, int i7) {
            return getArgbColorFromCeaColor(i5, i6, i7, 0);
        }

        public final void append(char c5) {
            if (c5 == 10) {
                this.rolledUpCaptions.add(buildSpannableString());
                this.captionStringBuilder.clear();
                if (this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if (this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if (this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if (this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while (true) {
                    if ((this.rowLock && this.rolledUpCaptions.size() >= this.rowCount) || this.rolledUpCaptions.size() >= 15) {
                        this.rolledUpCaptions.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.captionStringBuilder.append(c5);
            }
        }

        public final void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue build() {
            /*
                r13 = this;
                boolean r0 = r13.isEmpty()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = r0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r13.rolledUpCaptions
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r13.rolledUpCaptions
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r13.buildSpannableString()
                r2.append(r1)
                int r1 = r13.justification
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x005e
                if (r1 == r5) goto L_0x005b
                if (r1 == r3) goto L_0x0058
                if (r1 != r4) goto L_0x003f
                goto L_0x005e
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unexpected justification value: "
                r1.append(r2)
                int r2 = r13.justification
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0058:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0060
            L_0x005b:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0060
            L_0x005e:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0060:
                boolean r6 = r13.relativePositioning
                if (r6 == 0) goto L_0x006f
                int r6 = r13.horizontalAnchor
                float r6 = (float) r6
                r7 = 1120272384(0x42c60000, float:99.0)
                float r6 = r6 / r7
                int r8 = r13.verticalAnchor
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007c
            L_0x006f:
                int r6 = r13.horizontalAnchor
                float r6 = (float) r6
                r7 = 1129381888(0x43510000, float:209.0)
                float r6 = r6 / r7
                int r7 = r13.verticalAnchor
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007c:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r6 = r6 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r6 = r6 + r9
                float r8 = r8 * r7
                float r8 = r8 + r9
                int r7 = r13.anchorId
                int r9 = r7 % 3
                if (r9 != 0) goto L_0x0090
                r9 = r7
                r7 = r6
                r6 = r0
                goto L_0x009b
            L_0x0090:
                int r9 = r7 % 3
                if (r9 != r5) goto L_0x0098
                r9 = r7
                r7 = r6
                r6 = r5
                goto L_0x009b
            L_0x0098:
                r9 = r7
                r7 = r6
                r6 = r3
            L_0x009b:
                int r10 = r9 / 3
                if (r10 != 0) goto L_0x00a1
                r3 = r0
                goto L_0x00a6
            L_0x00a1:
                int r4 = r9 / 3
                if (r4 != r5) goto L_0x00a6
                r3 = r5
            L_0x00a6:
                int r11 = r13.windowFillColor
                int r4 = COLOR_SOLID_BLACK
                if (r11 == r4) goto L_0x00b1
                r10 = r5
            L_0x00ad:
                r4 = r8
                r8 = r3
                r3 = r1
                goto L_0x00b3
            L_0x00b1:
                r10 = r0
                goto L_0x00ad
            L_0x00b3:
                com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue r1 = new com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue
                r9 = 1
                int r12 = r13.priority
                r5 = 0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder.CueBuilder.build():com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Cue");
        }

        public final SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public final void defineWindow(boolean z4, boolean z5, boolean z6, int i5, boolean z7, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            int i13 = i11;
            int i14 = i12;
            this.defined = true;
            this.visible = z4;
            this.rowLock = z5;
            this.priority = i5;
            this.relativePositioning = z7;
            this.verticalAnchor = i6;
            this.horizontalAnchor = i7;
            this.anchorId = i10;
            int i15 = i8 + 1;
            if (this.rowCount != i15) {
                this.rowCount = i15;
                while (true) {
                    if ((!z5 || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        break;
                    }
                    this.rolledUpCaptions.remove(0);
                }
            }
            if (!(i13 == 0 || this.windowStyleId == i13)) {
                this.windowStyleId = i13;
                int i16 = i13 - 1;
                setWindowAttributes(WINDOW_STYLE_FILL[i16], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i16], 0, WINDOW_STYLE_PRINT_DIRECTION[i16], WINDOW_STYLE_SCROLL_DIRECTION[i16], WINDOW_STYLE_JUSTIFICATION[i16]);
            }
            if (i14 != 0 && this.penStyleId != i14) {
                this.penStyleId = i14;
                int i17 = i14 - 1;
                setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i17], PEN_STYLE_FONT_STYLE[i17]);
                setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i17], COLOR_SOLID_BLACK);
            }
        }

        public final boolean isDefined() {
            return this.defined;
        }

        public final boolean isEmpty() {
            if (!isDefined()) {
                return true;
            }
            if (!this.rolledUpCaptions.isEmpty() || this.captionStringBuilder.length() != 0) {
                return false;
            }
            return true;
        }

        public final boolean isVisible() {
            return this.visible;
        }

        public final void reset() {
            clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.rowLock = true;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i5 = COLOR_SOLID_BLACK;
            this.windowFillColor = i5;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i5;
        }

        public final void setPenAttributes(int i5, int i6, int i7, boolean z4, boolean z5, int i8, int i9) {
            if (this.italicsStartPosition != -1) {
                if (!z4) {
                    this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z4) {
                this.italicsStartPosition = this.captionStringBuilder.length();
            }
            if (this.underlineStartPosition != -1) {
                if (!z5) {
                    this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                    this.underlineStartPosition = -1;
                }
            } else if (z5) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            }
        }

        public final void setPenColor(int i5, int i6, int i7) {
            if (!(this.foregroundColorStartPosition == -1 || this.foregroundColor == i5)) {
                this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i5 != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = i5;
            }
            if (!(this.backgroundColorStartPosition == -1 || this.backgroundColor == i6)) {
                this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i6 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = i6;
            }
        }

        public final void setPenLocation(int i5, int i6) {
            if (this.row != i5) {
                append(10);
            }
            this.row = i5;
        }

        public final void setVisibility(boolean z4) {
            this.visible = z4;
        }

        public final void setWindowAttributes(int i5, int i6, boolean z4, int i7, int i8, int i9, int i10) {
            this.windowFillColor = i5;
            this.justification = i10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x002d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getArgbColorFromCeaColor(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r4, r0, r1)
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r5, r0, r1)
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r6, r0, r1)
                com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkIndex(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x001b
                if (r7 == r1) goto L_0x001b
                r3 = 2
                if (r7 == r3) goto L_0x001f
                r3 = 3
                if (r7 == r3) goto L_0x001d
            L_0x001b:
                r7 = r2
                goto L_0x0021
            L_0x001d:
                r7 = r0
                goto L_0x0021
            L_0x001f:
                r7 = 127(0x7f, float:1.78E-43)
            L_0x0021:
                if (r4 <= r1) goto L_0x0025
                r4 = r2
                goto L_0x0026
            L_0x0025:
                r4 = r0
            L_0x0026:
                if (r5 <= r1) goto L_0x002a
                r5 = r2
                goto L_0x002b
            L_0x002a:
                r5 = r0
            L_0x002b:
                if (r6 <= r1) goto L_0x002e
                r0 = r2
            L_0x002e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(int, int, int, int):int");
        }
    }

    private static final class DtvCcPacket {
        int currentIndex = 0;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i5, int i6) {
            this.sequenceNumber = i5;
            this.packetSize = i6;
            this.packetData = new byte[((i6 * 2) - 1)];
        }
    }

    public Cea708Decoder(int i5) {
        this.selectedServiceNumber = i5 == -1 ? 1 : i5;
        this.cueBuilders = new CueBuilder[8];
        for (int i6 = 0; i6 < 8; i6++) {
            this.cueBuilders[i6] = new CueBuilder();
        }
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
    }

    private void finalizeCurrentPacket() {
        if (this.currentDtvCcPacket != null) {
            processCurrentPacket();
            this.currentDtvCcPacket = null;
        }
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 8; i5++) {
            if (!this.cueBuilders[i5].isEmpty() && this.cueBuilders[i5].isVisible()) {
                arrayList.add(this.cueBuilders[i5].build());
            }
        }
        Collections.sort(arrayList);
        return DesugarCollections.unmodifiableList(arrayList);
    }

    private void handleC0Command(int i5) {
        if (i5 == 0) {
            return;
        }
        if (i5 == 3) {
            this.cues = getDisplayCues();
        } else if (i5 != 8) {
            switch (i5) {
                case 12:
                    resetCueBuilders();
                    return;
                case 13:
                    this.currentCueBuilder.append(10);
                    return;
                case 14:
                    return;
                default:
                    if (i5 >= 17 && i5 <= 23) {
                        Log.w(TAG, "Currently unsupported COMMAND_EXT1 Command: " + i5);
                        this.serviceBlockPacket.skipBits(8);
                        return;
                    } else if (i5 < 24 || i5 > 31) {
                        Log.w(TAG, "Invalid C0 command: " + i5);
                        return;
                    } else {
                        Log.w(TAG, "Currently unsupported COMMAND_P16 Command: " + i5);
                        this.serviceBlockPacket.skipBits(16);
                        return;
                    }
            }
        } else {
            this.currentCueBuilder.backspace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
        if (r2 > 8) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (r4.serviceBlockPacket.readBit() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        r4.cueBuilders[8 - r2].reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b9, code lost:
        if (r2 > 8) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c1, code lost:
        if (r4.serviceBlockPacket.readBit() == false) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c3, code lost:
        r4.cueBuilders[8 - r2].setVisibility(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cd, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e7, code lost:
        if (r2 > 8) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ef, code lost:
        if (r4.serviceBlockPacket.readBit() == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f1, code lost:
        r4.cueBuilders[8 - r2].clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fa, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleC1Command(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x00fd;
                case 129: goto L_0x00fd;
                case 130: goto L_0x00fd;
                case 131: goto L_0x00fd;
                case 132: goto L_0x00fd;
                case 133: goto L_0x00fd;
                case 134: goto L_0x00fd;
                case 135: goto L_0x00fd;
                case 136: goto L_0x00e7;
                case 137: goto L_0x00d0;
                case 138: goto L_0x00b9;
                case 139: goto L_0x009d;
                case 140: goto L_0x0087;
                case 141: goto L_0x0081;
                case 142: goto L_0x010b;
                case 143: goto L_0x007d;
                case 144: goto L_0x006b;
                case 145: goto L_0x0057;
                case 146: goto L_0x0045;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0031;
                case 152: goto L_0x001f;
                case 153: goto L_0x001f;
                case 154: goto L_0x001f;
                case 155: goto L_0x001f;
                case 156: goto L_0x001f;
                case 157: goto L_0x001f;
                case 158: goto L_0x001f;
                case 159: goto L_0x001f;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid C1 command: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Cea708Decoder"
            android.util.Log.w(r0, r5)
            return
        L_0x001f:
            int r5 = r5 + -152
            r4.handleDefineWindow(r5)
            int r0 = r4.currentWindow
            if (r0 == r5) goto L_0x010b
            r4.currentWindow = r5
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            r5 = r0[r5]
            r4.currentCueBuilder = r5
            return
        L_0x0031:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0041
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r0 = 32
            r5.skipBits(r0)
            return
        L_0x0041:
            r4.handleSetWindowAttributes()
            return
        L_0x0045:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0053
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r5.skipBits(r0)
            return
        L_0x0053:
            r4.handleSetPenLocation()
            return
        L_0x0057:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0067
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r0 = 24
            r5.skipBits(r0)
            return
        L_0x0067:
            r4.handleSetPenColor()
            return
        L_0x006b:
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder r5 = r4.currentCueBuilder
            boolean r5 = r5.isDefined()
            if (r5 != 0) goto L_0x0079
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r5.skipBits(r0)
            return
        L_0x0079:
            r4.handleSetPenAttributes()
            return
        L_0x007d:
            r4.resetCueBuilders()
            return
        L_0x0081:
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            r5.skipBits(r1)
            return
        L_0x0087:
            if (r2 > r1) goto L_0x010b
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x009a
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r5 = r4.cueBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.reset()
        L_0x009a:
            int r2 = r2 + 1
            goto L_0x0087
        L_0x009d:
            r5 = r2
        L_0x009e:
            if (r5 > r1) goto L_0x010b
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r0 = r4.serviceBlockPacket
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x00b6
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.isVisible()
            r3 = r3 ^ r2
            r0.setVisibility(r3)
        L_0x00b6:
            int r5 = r5 + 1
            goto L_0x009e
        L_0x00b9:
            if (r2 > r1) goto L_0x010b
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x00cd
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r5 = r4.cueBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.setVisibility(r0)
        L_0x00cd:
            int r2 = r2 + 1
            goto L_0x00b9
        L_0x00d0:
            r5 = r2
        L_0x00d1:
            if (r5 > r1) goto L_0x010b
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r0 = r4.serviceBlockPacket
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x00e4
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.setVisibility(r2)
        L_0x00e4:
            int r5 = r5 + 1
            goto L_0x00d1
        L_0x00e7:
            if (r2 > r1) goto L_0x010b
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r5 = r4.serviceBlockPacket
            boolean r5 = r5.readBit()
            if (r5 == 0) goto L_0x00fa
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r5 = r4.cueBuilders
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.clear()
        L_0x00fa:
            int r2 = r2 + 1
            goto L_0x00e7
        L_0x00fd:
            int r5 = r5 + -128
            int r0 = r4.currentWindow
            if (r0 == r5) goto L_0x010b
            r4.currentWindow = r5
            com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder$CueBuilder[] r0 = r4.cueBuilders
            r5 = r0[r5]
            r4.currentCueBuilder = r5
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder.handleC1Command(int):void");
    }

    private void handleC2Command(int i5) {
        if (i5 > 7) {
            if (i5 <= 15) {
                this.serviceBlockPacket.skipBits(8);
            } else if (i5 <= 23) {
                this.serviceBlockPacket.skipBits(16);
            } else if (i5 <= 31) {
                this.serviceBlockPacket.skipBits(24);
            }
        }
    }

    private void handleC3Command(int i5) {
        if (i5 <= 135) {
            this.serviceBlockPacket.skipBits(32);
        } else if (i5 <= COMMAND_RST) {
            this.serviceBlockPacket.skipBits(40);
        } else if (i5 <= 159) {
            this.serviceBlockPacket.skipBits(2);
            this.serviceBlockPacket.skipBits(this.serviceBlockPacket.readBits(6) * 8);
        }
    }

    private void handleDefineWindow(int i5) {
        CueBuilder cueBuilder = this.cueBuilders[i5];
        this.serviceBlockPacket.skipBits(2);
        boolean readBit = this.serviceBlockPacket.readBit();
        boolean readBit2 = this.serviceBlockPacket.readBit();
        boolean readBit3 = this.serviceBlockPacket.readBit();
        int readBits = this.serviceBlockPacket.readBits(3);
        boolean readBit4 = this.serviceBlockPacket.readBit();
        int readBits2 = this.serviceBlockPacket.readBits(7);
        int readBits3 = this.serviceBlockPacket.readBits(8);
        int readBits4 = this.serviceBlockPacket.readBits(4);
        int readBits5 = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        int readBits6 = this.serviceBlockPacket.readBits(6);
        this.serviceBlockPacket.skipBits(2);
        cueBuilder.defineWindow(readBit, readBit2, readBit3, readBits, readBit4, readBits2, readBits3, readBits5, readBits6, readBits4, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleG0Character(int i5) {
        if (i5 == 127) {
            this.currentCueBuilder.append(9835);
        } else {
            this.currentCueBuilder.append((char) (i5 & 255));
        }
    }

    private void handleG1Character(int i5) {
        this.currentCueBuilder.append((char) (i5 & 255));
    }

    private void handleG2Character(int i5) {
        if (i5 == 32) {
            this.currentCueBuilder.append(' ');
        } else if (i5 == 33) {
            this.currentCueBuilder.append(160);
        } else if (i5 == 37) {
            this.currentCueBuilder.append(8230);
        } else if (i5 == 42) {
            this.currentCueBuilder.append(352);
        } else if (i5 == 44) {
            this.currentCueBuilder.append(338);
        } else if (i5 == 63) {
            this.currentCueBuilder.append(376);
        } else if (i5 == 57) {
            this.currentCueBuilder.append(8482);
        } else if (i5 == 58) {
            this.currentCueBuilder.append(353);
        } else if (i5 == 60) {
            this.currentCueBuilder.append(339);
        } else if (i5 != 61) {
            switch (i5) {
                case 48:
                    this.currentCueBuilder.append(9608);
                    return;
                case 49:
                    this.currentCueBuilder.append(8216);
                    return;
                case 50:
                    this.currentCueBuilder.append(8217);
                    return;
                case 51:
                    this.currentCueBuilder.append(8220);
                    return;
                case 52:
                    this.currentCueBuilder.append(8221);
                    return;
                case 53:
                    this.currentCueBuilder.append(8226);
                    return;
                default:
                    switch (i5) {
                        case 118:
                            this.currentCueBuilder.append(8539);
                            return;
                        case 119:
                            this.currentCueBuilder.append(8540);
                            return;
                        case 120:
                            this.currentCueBuilder.append(8541);
                            return;
                        case 121:
                            this.currentCueBuilder.append(8542);
                            return;
                        case 122:
                            this.currentCueBuilder.append(9474);
                            return;
                        case 123:
                            this.currentCueBuilder.append(9488);
                            return;
                        case 124:
                            this.currentCueBuilder.append(9492);
                            return;
                        case 125:
                            this.currentCueBuilder.append(9472);
                            return;
                        case 126:
                            this.currentCueBuilder.append(9496);
                            return;
                        case 127:
                            this.currentCueBuilder.append(9484);
                            return;
                        default:
                            Log.w(TAG, "Invalid G2 character: " + i5);
                            return;
                    }
            }
        } else {
            this.currentCueBuilder.append(8480);
        }
    }

    private void handleG3Character(int i5) {
        if (i5 == 160) {
            this.currentCueBuilder.append(13252);
            return;
        }
        Log.w(TAG, "Invalid G3 character: " + i5);
        this.currentCueBuilder.append('_');
    }

    private void handleSetPenAttributes() {
        this.currentCueBuilder.setPenAttributes(this.serviceBlockPacket.readBits(4), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleSetPenColor() {
        int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2)));
    }

    private void handleSetPenLocation() {
        this.serviceBlockPacket.skipBits(4);
        int readBits = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenLocation(readBits, this.serviceBlockPacket.readBits(6));
    }

    private void handleSetWindowAttributes() {
        int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int readBits = this.serviceBlockPacket.readBits(2);
        int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        if (this.serviceBlockPacket.readBit()) {
            readBits |= 4;
        }
        boolean readBit = this.serviceBlockPacket.readBit();
        int readBits2 = this.serviceBlockPacket.readBits(2);
        int readBits3 = this.serviceBlockPacket.readBits(2);
        int readBits4 = this.serviceBlockPacket.readBits(2);
        this.serviceBlockPacket.skipBits(8);
        this.currentCueBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, readBit, readBits, readBits2, readBits3, readBits4);
    }

    private void processCurrentPacket() {
        DtvCcPacket dtvCcPacket = this.currentDtvCcPacket;
        int i5 = dtvCcPacket.currentIndex;
        if (i5 != (dtvCcPacket.packetSize * 2) - 1) {
            Log.w(TAG, "DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + "); ignoring packet");
            return;
        }
        this.serviceBlockPacket.reset(dtvCcPacket.packetData, i5);
        int readBits = this.serviceBlockPacket.readBits(3);
        int readBits2 = this.serviceBlockPacket.readBits(5);
        if (readBits == 7) {
            this.serviceBlockPacket.skipBits(2);
            readBits += this.serviceBlockPacket.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w(TAG, "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
            }
        } else if (readBits == this.selectedServiceNumber) {
            boolean z4 = false;
            while (this.serviceBlockPacket.bitsLeft() > 0) {
                int readBits3 = this.serviceBlockPacket.readBits(8);
                if (readBits3 == 16) {
                    int readBits4 = this.serviceBlockPacket.readBits(8);
                    if (readBits4 <= 31) {
                        handleC2Command(readBits4);
                    } else if (readBits4 <= 127) {
                        handleG2Character(readBits4);
                    } else if (readBits4 <= 159) {
                        handleC3Command(readBits4);
                    } else if (readBits4 <= 255) {
                        handleG3Character(readBits4);
                    } else {
                        Log.w(TAG, "Invalid extended command: " + readBits4);
                    }
                } else if (readBits3 <= 31) {
                    handleC0Command(readBits3);
                } else if (readBits3 <= 127) {
                    handleG0Character(readBits3);
                } else if (readBits3 <= 159) {
                    handleC1Command(readBits3);
                } else if (readBits3 <= 255) {
                    handleG1Character(readBits3);
                } else {
                    Log.w(TAG, "Invalid base command: " + readBits3);
                }
                z4 = true;
            }
            if (z4) {
                this.cues = getDisplayCues();
            }
        }
    }

    private void resetCueBuilders() {
        for (int i5 = 0; i5 < 8; i5++) {
            this.cueBuilders[i5].reset();
        }
    }

    /* access modifiers changed from: protected */
    public final Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
    }

    /* access modifiers changed from: protected */
    public final void decode(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z4;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        while (this.ccData.bytesLeft() >= 3) {
            int readUnsignedByte = this.ccData.readUnsignedByte();
            int i5 = readUnsignedByte & 3;
            boolean z5 = false;
            if ((readUnsignedByte & 4) == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            byte readUnsignedByte2 = (byte) this.ccData.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.ccData.readUnsignedByte();
            if ((i5 == 2 || i5 == 3) && z4) {
                if (i5 == 3) {
                    finalizeCurrentPacket();
                    int i6 = (readUnsignedByte2 & 192) >> 6;
                    byte b5 = readUnsignedByte2 & 63;
                    if (b5 == 0) {
                        b5 = 64;
                    }
                    DtvCcPacket dtvCcPacket = new DtvCcPacket(i6, b5);
                    this.currentDtvCcPacket = dtvCcPacket;
                    byte[] bArr = dtvCcPacket.packetData;
                    int i7 = dtvCcPacket.currentIndex;
                    dtvCcPacket.currentIndex = i7 + 1;
                    bArr[i7] = readUnsignedByte3;
                } else {
                    if (i5 == 2) {
                        z5 = true;
                    }
                    Assertions.checkArgument(z5);
                    DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                    if (dtvCcPacket2 == null) {
                        Log.e(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = dtvCcPacket2.packetData;
                        int i8 = dtvCcPacket2.currentIndex;
                        int i9 = i8 + 1;
                        dtvCcPacket2.currentIndex = i9;
                        bArr2[i8] = readUnsignedByte2;
                        dtvCcPacket2.currentIndex = i8 + 2;
                        bArr2[i9] = readUnsignedByte3;
                    }
                }
                DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                if (dtvCcPacket3.currentIndex == (dtvCcPacket3.packetSize * 2) - 1) {
                    finalizeCurrentPacket();
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    public final /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    public final void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    public final String getName() {
        return TAG;
    }

    /* access modifiers changed from: protected */
    public final boolean isNewSubtitleDataAvailable() {
        if (this.cues != this.lastCues) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    public final /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final /* bridge */ /* synthetic */ void setPositionUs(long j5) {
        super.setPositionUs(j5);
    }
}
