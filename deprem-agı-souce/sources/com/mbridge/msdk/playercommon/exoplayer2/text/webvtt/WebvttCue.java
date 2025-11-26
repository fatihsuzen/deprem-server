package com.mbridge.msdk.playercommon.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;

public final class WebvttCue extends Cue {
    public final long endTime;
    public final long startTime;

    /* renamed from: com.mbridge.msdk.playercommon.exoplayer2.text.webvtt.WebvttCue$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$text$Layout$Alignment = r0
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$text$Layout$Alignment     // Catch:{ NoSuchFieldError -> 0x001d }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$text$Layout$Alignment     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.webvtt.WebvttCue.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {
        private static final String TAG = "WebvttCueBuilder";
        private long endTime;
        private float line;
        private int lineAnchor;
        private int lineType;
        private float position;
        private int positionAnchor;
        private long startTime;
        private SpannableStringBuilder text;
        private Layout.Alignment textAlignment;
        private float width;

        public Builder() {
            reset();
        }

        private Builder derivePositionAnchorFromAlignment() {
            Layout.Alignment alignment = this.textAlignment;
            if (alignment == null) {
                this.positionAnchor = Integer.MIN_VALUE;
                return this;
            }
            int i5 = AnonymousClass1.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
            if (i5 == 1) {
                this.positionAnchor = 0;
                return this;
            } else if (i5 == 2) {
                this.positionAnchor = 1;
                return this;
            } else if (i5 != 3) {
                Log.w(TAG, "Unrecognized alignment: " + this.textAlignment);
                this.positionAnchor = 0;
                return this;
            } else {
                this.positionAnchor = 2;
                return this;
            }
        }

        public WebvttCue build() {
            if (this.position != Float.MIN_VALUE && this.positionAnchor == Integer.MIN_VALUE) {
                derivePositionAnchorFromAlignment();
            }
            return new WebvttCue(this.startTime, this.endTime, this.text, this.textAlignment, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
        }

        public void reset() {
            this.startTime = 0;
            this.endTime = 0;
            this.text = null;
            this.textAlignment = null;
            this.line = Float.MIN_VALUE;
            this.lineType = Integer.MIN_VALUE;
            this.lineAnchor = Integer.MIN_VALUE;
            this.position = Float.MIN_VALUE;
            this.positionAnchor = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public Builder setEndTime(long j5) {
            this.endTime = j5;
            return this;
        }

        public Builder setLine(float f5) {
            this.line = f5;
            return this;
        }

        public Builder setLineAnchor(int i5) {
            this.lineAnchor = i5;
            return this;
        }

        public Builder setLineType(int i5) {
            this.lineType = i5;
            return this;
        }

        public Builder setPosition(float f5) {
            this.position = f5;
            return this;
        }

        public Builder setPositionAnchor(int i5) {
            this.positionAnchor = i5;
            return this;
        }

        public Builder setStartTime(long j5) {
            this.startTime = j5;
            return this;
        }

        public Builder setText(SpannableStringBuilder spannableStringBuilder) {
            this.text = spannableStringBuilder;
            return this;
        }

        public Builder setTextAlignment(Layout.Alignment alignment) {
            this.textAlignment = alignment;
            return this;
        }

        public Builder setWidth(float f5) {
            this.width = f5;
            return this;
        }
    }

    public WebvttCue(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public final boolean isNormalCue() {
        if (this.line == Float.MIN_VALUE && this.position == Float.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public WebvttCue(long j5, long j6, CharSequence charSequence) {
        this(j5, j6, charSequence, (Layout.Alignment) null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public WebvttCue(long j5, long j6, CharSequence charSequence, Layout.Alignment alignment, float f5, int i5, int i6, float f6, int i7, float f7) {
        super(charSequence, alignment, f5, i5, i6, f6, i7, f7);
        this.startTime = j5;
        this.endTime = j6;
    }
}
