package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.appcompat.R;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleOutputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class Cea608Decoder extends CeaDecoder {
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_608_ID = 4;
    private static final int CC_VALID_FLAG = 4;
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, R.styleable.AppCompatTheme_windowMinWidthMinor, 92, 94, 95, R.styleable.AppCompatTheme_windowMinWidthMajor, R.styleable.AppCompatTheme_windowNoTitle, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    /* access modifiers changed from: private */
    public static final int[] STYLE_COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, -256, -65281};
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private int captionMode;
    private int captionRowCount;
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ArrayList<CueBuilder> cueBuilders = new ArrayList<>();
    private List<Cue> cues;
    private CueBuilder currentCueBuilder = new CueBuilder(0, 4);
    private List<Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedField;

    private static class CueBuilder {
        private static final int BASE_ROW = 15;
        private static final int SCREEN_CHARWIDTH = 32;
        private int captionMode;
        private int captionRowCount;
        private final StringBuilder captionStringBuilder = new StringBuilder();
        private final List<CueStyle> cueStyles = new ArrayList();
        private int indent;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private int row;
        private int tabOffset;

        private static class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int i5, boolean z4, int i6) {
                this.style = i5;
                this.underline = z4;
                this.start = i6;
            }
        }

        public CueBuilder(int i5, int i6) {
            reset(i5);
            setCaptionRowCount(i6);
        }

        private static void setColorSpan(SpannableStringBuilder spannableStringBuilder, int i5, int i6, int i7) {
            if (i7 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i7), i5, i6, 33);
            }
        }

        private static void setItalicSpan(SpannableStringBuilder spannableStringBuilder, int i5, int i6) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i5, i6, 33);
        }

        private static void setUnderlineSpan(SpannableStringBuilder spannableStringBuilder, int i5, int i6) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i5, i6, 33);
        }

        public void append(char c5) {
            this.captionStringBuilder.append(c5);
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
                int size = this.cueStyles.size() - 1;
                while (size >= 0) {
                    CueStyle cueStyle = this.cueStyles.get(size);
                    int i5 = cueStyle.start;
                    if (i5 == length) {
                        cueStyle.start = i5 - 1;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public Cue build() {
            int i5;
            float f5;
            int i6;
            int i7;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i8 = 0; i8 < this.rolledUpCaptions.size(); i8++) {
                spannableStringBuilder.append(this.rolledUpCaptions.get(i8));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i9 = this.indent + this.tabOffset;
            int length = (32 - i9) - spannableStringBuilder.length();
            int i10 = i9 - length;
            int i11 = 2;
            if (this.captionMode == 2 && (Math.abs(i10) < 3 || length < 0)) {
                f5 = 0.5f;
                i5 = 2;
                i11 = 1;
            } else if (this.captionMode != 2 || i10 <= 0) {
                f5 = ((((float) i9) / 32.0f) * 0.8f) + 0.1f;
                i5 = 2;
                i11 = 0;
            } else {
                f5 = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
                i5 = 2;
            }
            if (this.captionMode == 1 || (i7 = this.row) > 7) {
                i7 = this.row - 17;
                i6 = i5;
            } else {
                i6 = 0;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i7, 1, i6, f5, i11, Float.MIN_VALUE);
        }

        public SpannableString buildSpannableString() {
            int i5;
            boolean z4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = 0;
            int i11 = 0;
            boolean z5 = false;
            while (i10 < this.cueStyles.size()) {
                CueStyle cueStyle = this.cueStyles.get(i10);
                boolean z6 = cueStyle.underline;
                int i12 = cueStyle.style;
                if (i12 != 8) {
                    if (i12 == 7) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (i12 != 7) {
                        i9 = Cea608Decoder.STYLE_COLORS[i12];
                    }
                    z5 = z4;
                }
                int i13 = cueStyle.start;
                i10++;
                if (i10 < this.cueStyles.size()) {
                    i5 = this.cueStyles.get(i10).start;
                } else {
                    i5 = length;
                }
                if (i13 != i5) {
                    if (i6 != -1 && !z6) {
                        setUnderlineSpan(spannableStringBuilder, i6, i13);
                        i6 = -1;
                    } else if (i6 == -1 && z6) {
                        i6 = i13;
                    }
                    if (i7 != -1 && !z5) {
                        setItalicSpan(spannableStringBuilder, i7, i13);
                        i7 = -1;
                    } else if (i7 == -1 && z5) {
                        i7 = i13;
                    }
                    if (i9 != i8) {
                        setColorSpan(spannableStringBuilder, i11, i13, i8);
                        i8 = i9;
                        i11 = i13;
                    }
                }
            }
            if (!(i6 == -1 || i6 == length)) {
                setUnderlineSpan(spannableStringBuilder, i6, length);
            }
            if (!(i7 == -1 || i7 == length)) {
                setItalicSpan(spannableStringBuilder, i7, length);
            }
            if (i11 != length) {
                setColorSpan(spannableStringBuilder, i11, length, i8);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public int getRow() {
            return this.row;
        }

        public boolean isEmpty() {
            if (!this.cueStyles.isEmpty() || !this.rolledUpCaptions.isEmpty() || this.captionStringBuilder.length() != 0) {
                return false;
            }
            return true;
        }

        public void reset(int i5) {
            this.captionMode = i5;
            this.cueStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.setLength(0);
            this.cueStyles.clear();
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setCaptionRowCount(int i5) {
            this.captionRowCount = i5;
        }

        public void setIndent(int i5) {
            this.indent = i5;
        }

        public void setRow(int i5) {
            this.row = i5;
        }

        public void setStyle(int i5, boolean z4) {
            this.cueStyles.add(new CueStyle(i5, z4, this.captionStringBuilder.length()));
        }

        public void setTab(int i5) {
            this.tabOffset = i5;
        }

        public String toString() {
            return this.captionStringBuilder.toString();
        }
    }

    public Cea608Decoder(String str, int i5) {
        int i6;
        if (MimeTypes.APPLICATION_MP4CEA608.equals(str)) {
            i6 = 2;
        } else {
            i6 = 3;
        }
        this.packetLength = i6;
        if (i5 == 3 || i5 == 4) {
            this.selectedField = 2;
        } else {
            this.selectedField = 1;
        }
        setCaptionMode(0);
        resetCueBuilders();
    }

    private static char getChar(byte b5) {
        return (char) BASIC_CHARACTER_SET[(b5 & Byte.MAX_VALUE) - 32];
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < this.cueBuilders.size(); i5++) {
            Cue build = this.cueBuilders.get(i5).build();
            if (build != null) {
                arrayList.add(build);
            }
        }
        return arrayList;
    }

    private static char getExtendedEsFrChar(byte b5) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b5 & 31];
    }

    private static char getExtendedPtDeChar(byte b5) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b5 & 31];
    }

    private static char getSpecialChar(byte b5) {
        return (char) SPECIAL_CHARACTER_SET[b5 & 15];
    }

    private boolean handleCtrl(byte b5, byte b6) {
        boolean isRepeatable = isRepeatable(b5);
        if (isRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b5 && this.repeatableControlCc2 == b6) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b5;
            this.repeatableControlCc2 = b6;
        }
        if (isMidrowCtrlCode(b5, b6)) {
            handleMidrowCtrl(b6);
            return isRepeatable;
        } else if (isPreambleAddressCode(b5, b6)) {
            handlePreambleAddressCode(b5, b6);
            return isRepeatable;
        } else if (isTabCtrlCode(b5, b6)) {
            this.currentCueBuilder.setTab(b6 - 32);
            return isRepeatable;
        } else {
            if (isMiscCode(b5, b6)) {
                handleMiscCode(b6);
            }
            return isRepeatable;
        }
    }

    private void handleMidrowCtrl(byte b5) {
        boolean z4;
        this.currentCueBuilder.append(' ');
        if ((b5 & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.currentCueBuilder.setStyle((b5 >> 1) & 7, z4);
    }

    private void handleMiscCode(byte b5) {
        if (b5 == 32) {
            setCaptionMode(2);
        } else if (b5 != 41) {
            switch (b5) {
                case 37:
                    setCaptionMode(1);
                    setCaptionRowCount(2);
                    return;
                case 38:
                    setCaptionMode(1);
                    setCaptionRowCount(3);
                    return;
                case 39:
                    setCaptionMode(1);
                    setCaptionRowCount(4);
                    return;
                default:
                    int i5 = this.captionMode;
                    if (i5 != 0) {
                        if (b5 != 33) {
                            switch (b5) {
                                case 44:
                                    this.cues = null;
                                    if (i5 == 1 || i5 == 3) {
                                        resetCueBuilders();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i5 == 1 && !this.currentCueBuilder.isEmpty()) {
                                        this.currentCueBuilder.rollUp();
                                        return;
                                    }
                                    return;
                                case 46:
                                    resetCueBuilders();
                                    return;
                                case 47:
                                    this.cues = getDisplayCues();
                                    resetCueBuilders();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.currentCueBuilder.backspace();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            setCaptionMode(3);
        }
    }

    private void handlePreambleAddressCode(byte b5, byte b6) {
        boolean z4;
        int i5;
        int i6 = ROW_INDICES[b5 & 7];
        if ((b6 & CTRL_RESUME_CAPTION_LOADING) != 0) {
            i6++;
        }
        if (i6 != this.currentCueBuilder.getRow()) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cueBuilder;
                this.cueBuilders.add(cueBuilder);
            }
            this.currentCueBuilder.setRow(i6);
        }
        boolean z5 = false;
        if ((b6 & 16) == 16) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((b6 & 1) == 1) {
            z5 = true;
        }
        int i7 = (b6 >> 1) & 7;
        CueBuilder cueBuilder2 = this.currentCueBuilder;
        if (z4) {
            i5 = 8;
        } else {
            i5 = i7;
        }
        cueBuilder2.setStyle(i5, z5);
        if (z4) {
            this.currentCueBuilder.setIndent(COLUMN_INDICES[i7]);
        }
    }

    private static boolean isMidrowCtrlCode(byte b5, byte b6) {
        return (b5 & 247) == 17 && (b6 & 240) == 32;
    }

    private static boolean isMiscCode(byte b5, byte b6) {
        return (b5 & 247) == 20 && (b6 & 240) == 32;
    }

    private static boolean isPreambleAddressCode(byte b5, byte b6) {
        return (b5 & 240) == 16 && (b6 & 192) == 64;
    }

    private static boolean isRepeatable(byte b5) {
        return (b5 & 240) == 16;
    }

    private static boolean isTabCtrlCode(byte b5, byte b6) {
        return (b5 & 247) == 23 && b6 >= 33 && b6 <= 35;
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private void setCaptionMode(int i5) {
        int i6 = this.captionMode;
        if (i6 != i5) {
            this.captionMode = i5;
            resetCueBuilders();
            if (i6 == 3 || i5 == 1 || i5 == 0) {
                this.cues = null;
            }
        }
    }

    private void setCaptionRowCount(int i5) {
        this.captionRowCount = i5;
        this.currentCueBuilder.setCaptionRowCount(i5);
    }

    /* access modifiers changed from: protected */
    public final Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
    }

    /* access modifiers changed from: protected */
    public final void decode(SubtitleInputBuffer subtitleInputBuffer) {
        byte b5;
        int i5;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            int bytesLeft = this.ccData.bytesLeft();
            int i6 = this.packetLength;
            if (bytesLeft < i6) {
                break;
            }
            if (i6 == 2) {
                b5 = CC_IMPLICIT_DATA_HEADER;
            } else {
                b5 = (byte) this.ccData.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.ccData.readUnsignedByte() & 127);
            byte readUnsignedByte2 = (byte) (this.ccData.readUnsignedByte() & 127);
            if ((b5 & 6) == 4 && (((i5 = this.selectedField) != 1 || (b5 & 1) == 0) && ((i5 != 2 || (b5 & 1) == 1) && !(readUnsignedByte == 0 && readUnsignedByte2 == 0)))) {
                if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & 240) == 48) {
                    this.currentCueBuilder.append(getSpecialChar(readUnsignedByte2));
                } else if ((readUnsignedByte & 246) == 18 && (readUnsignedByte2 & 224) == 32) {
                    this.currentCueBuilder.backspace();
                    if ((readUnsignedByte & 1) == 0) {
                        this.currentCueBuilder.append(getExtendedEsFrChar(readUnsignedByte2));
                    } else {
                        this.currentCueBuilder.append(getExtendedPtDeChar(readUnsignedByte2));
                    }
                } else if ((readUnsignedByte & 224) == 0) {
                    z5 = handleCtrl(readUnsignedByte, readUnsignedByte2);
                } else {
                    this.currentCueBuilder.append(getChar(readUnsignedByte));
                    if ((readUnsignedByte2 & 224) != 0) {
                        this.currentCueBuilder.append(getChar(readUnsignedByte2));
                    }
                }
                z4 = true;
            }
        }
        if (z4) {
            if (!z5) {
                this.repeatableControlSet = false;
            }
            int i7 = this.captionMode;
            if (i7 == 1 || i7 == 3) {
                this.cues = getDisplayCues();
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
        setCaptionMode(0);
        setCaptionRowCount(4);
        resetCueBuilders();
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = 0;
        this.repeatableControlCc2 = 0;
    }

    public final String getName() {
        return "Cea608Decoder";
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

    public final void release() {
    }

    public final /* bridge */ /* synthetic */ void setPositionUs(long j5) {
        super.setPositionUs(j5);
    }
}
