package androidx.leanback.widget;

final class WindowAlignment {
    public final Axis horizontal;
    private Axis mMainAxis;
    private int mOrientation = 0;
    private Axis mSecondAxis;
    public final Axis vertical;

    static final class Axis {
        private static final int PF_KEYLINE_OVER_HIGH_EDGE = 2;
        private static final int PF_KEYLINE_OVER_LOW_EDGE = 1;
        private int mMaxEdge;
        private int mMaxScroll;
        private int mMinEdge;
        private int mMinScroll;
        private int mPaddingMax;
        private int mPaddingMin;
        private int mPreferredKeyLine = 2;
        private boolean mReversedFlow;
        private int mSize;
        private int mWindowAlignment = 3;
        private int mWindowAlignmentOffset = 0;
        private float mWindowAlignmentOffsetPercent = 50.0f;

        Axis(String str) {
            reset();
        }

        /* access modifiers changed from: package-private */
        public int calculateKeyline() {
            int i5;
            if (!this.mReversedFlow) {
                int i6 = this.mWindowAlignmentOffset;
                if (i6 < 0) {
                    i6 += this.mSize;
                }
                float f5 = this.mWindowAlignmentOffsetPercent;
                if (f5 != -1.0f) {
                    return i6 + ((int) ((((float) this.mSize) * f5) / 100.0f));
                }
                return i6;
            }
            int i7 = this.mWindowAlignmentOffset;
            if (i7 >= 0) {
                i5 = this.mSize - i7;
            } else {
                i5 = -i7;
            }
            float f6 = this.mWindowAlignmentOffsetPercent;
            if (f6 != -1.0f) {
                return i5 - ((int) ((((float) this.mSize) * f6) / 100.0f));
            }
            return i5;
        }

        /* access modifiers changed from: package-private */
        public int calculateScrollToKeyLine(int i5, int i6) {
            return i5 - i6;
        }

        public int getClientSize() {
            return (this.mSize - this.mPaddingMin) - this.mPaddingMax;
        }

        public int getMaxScroll() {
            return this.mMaxScroll;
        }

        public int getMinScroll() {
            return this.mMinScroll;
        }

        public int getPaddingMax() {
            return this.mPaddingMax;
        }

        public int getPaddingMin() {
            return this.mPaddingMin;
        }

        public int getScroll(int i5) {
            int i6;
            int i7;
            int size = getSize();
            int calculateKeyline = calculateKeyline();
            boolean isMinUnknown = isMinUnknown();
            boolean isMaxUnknown = isMaxUnknown();
            if (!isMinUnknown) {
                int i8 = this.mPaddingMin;
                int i9 = calculateKeyline - i8;
                if (this.mReversedFlow ? (this.mWindowAlignment & 2) != 0 : (this.mWindowAlignment & 1) != 0) {
                    int i10 = this.mMinEdge;
                    if (i5 - i10 <= i9) {
                        int i11 = i10 - i8;
                        if (isMaxUnknown || i11 <= (i7 = this.mMaxScroll)) {
                            return i11;
                        }
                        return i7;
                    }
                }
            }
            if (!isMaxUnknown) {
                int i12 = this.mPaddingMax;
                int i13 = (size - calculateKeyline) - i12;
                if (this.mReversedFlow ? (this.mWindowAlignment & 1) != 0 : (this.mWindowAlignment & 2) != 0) {
                    int i14 = this.mMaxEdge;
                    if (i14 - i5 <= i13) {
                        int i15 = i14 - (size - i12);
                        if (isMinUnknown || i15 >= (i6 = this.mMinScroll)) {
                            return i15;
                        }
                        return i6;
                    }
                }
            }
            return calculateScrollToKeyLine(i5, calculateKeyline);
        }

        public int getSize() {
            return this.mSize;
        }

        public int getWindowAlignment() {
            return this.mWindowAlignment;
        }

        public int getWindowAlignmentOffset() {
            return this.mWindowAlignmentOffset;
        }

        public float getWindowAlignmentOffsetPercent() {
            return this.mWindowAlignmentOffsetPercent;
        }

        public void invalidateScrollMax() {
            this.mMaxEdge = Integer.MAX_VALUE;
            this.mMaxScroll = Integer.MAX_VALUE;
        }

        public void invalidateScrollMin() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMinScroll = Integer.MIN_VALUE;
        }

        public boolean isMaxUnknown() {
            if (this.mMaxEdge == Integer.MAX_VALUE) {
                return true;
            }
            return false;
        }

        public boolean isMinUnknown() {
            if (this.mMinEdge == Integer.MIN_VALUE) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isPreferKeylineOverHighEdge() {
            if ((this.mPreferredKeyLine & 2) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isPreferKeylineOverLowEdge() {
            if ((this.mPreferredKeyLine & 1) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMaxEdge = Integer.MAX_VALUE;
        }

        public void setPadding(int i5, int i6) {
            this.mPaddingMin = i5;
            this.mPaddingMax = i6;
        }

        /* access modifiers changed from: package-private */
        public void setPreferKeylineOverHighEdge(boolean z4) {
            int i5;
            if (z4) {
                i5 = this.mPreferredKeyLine | 2;
            } else {
                i5 = this.mPreferredKeyLine & -3;
            }
            this.mPreferredKeyLine = i5;
        }

        /* access modifiers changed from: package-private */
        public void setPreferKeylineOverLowEdge(boolean z4) {
            int i5;
            if (z4) {
                i5 = this.mPreferredKeyLine | 1;
            } else {
                i5 = this.mPreferredKeyLine & -2;
            }
            this.mPreferredKeyLine = i5;
        }

        public void setReversedFlow(boolean z4) {
            this.mReversedFlow = z4;
        }

        public void setSize(int i5) {
            this.mSize = i5;
        }

        public void setWindowAlignment(int i5) {
            this.mWindowAlignment = i5;
        }

        public void setWindowAlignmentOffset(int i5) {
            this.mWindowAlignmentOffset = i5;
        }

        public void setWindowAlignmentOffsetPercent(float f5) {
            if ((f5 < 0.0f || f5 > 100.0f) && f5 != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.mWindowAlignmentOffsetPercent = f5;
        }

        public String toString() {
            return " min:" + this.mMinEdge + " " + this.mMinScroll + " max:" + this.mMaxEdge + " " + this.mMaxScroll;
        }

        public void updateMinMax(int i5, int i6, int i7, int i8) {
            this.mMinEdge = i5;
            this.mMaxEdge = i6;
            int clientSize = getClientSize();
            int calculateKeyline = calculateKeyline();
            boolean isMinUnknown = isMinUnknown();
            boolean isMaxUnknown = isMaxUnknown();
            if (!isMinUnknown) {
                if (this.mReversedFlow ? (this.mWindowAlignment & 2) == 0 : (this.mWindowAlignment & 1) == 0) {
                    this.mMinScroll = calculateScrollToKeyLine(i7, calculateKeyline);
                } else {
                    this.mMinScroll = this.mMinEdge - this.mPaddingMin;
                }
            }
            if (!isMaxUnknown) {
                if (this.mReversedFlow ? (this.mWindowAlignment & 1) == 0 : (this.mWindowAlignment & 2) == 0) {
                    this.mMaxScroll = calculateScrollToKeyLine(i8, calculateKeyline);
                } else {
                    this.mMaxScroll = (this.mMaxEdge - this.mPaddingMin) - clientSize;
                }
            }
            if (!isMaxUnknown && !isMinUnknown) {
                if (!this.mReversedFlow) {
                    int i9 = this.mWindowAlignment;
                    if ((i9 & 1) != 0) {
                        if (isPreferKeylineOverLowEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i8, calculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                    } else if ((i9 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i7, calculateKeyline));
                        }
                        this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    }
                } else {
                    int i10 = this.mWindowAlignment;
                    if ((i10 & 1) != 0) {
                        if (isPreferKeylineOverLowEdge()) {
                            this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i7, calculateKeyline));
                        }
                        this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    } else if ((i10 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i8, calculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                    }
                }
            }
        }
    }

    WindowAlignment() {
        Axis axis = new Axis("vertical");
        this.vertical = axis;
        Axis axis2 = new Axis("horizontal");
        this.horizontal = axis2;
        this.mMainAxis = axis2;
        this.mSecondAxis = axis;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Axis mainAxis() {
        return this.mMainAxis;
    }

    public void reset() {
        mainAxis().reset();
    }

    public Axis secondAxis() {
        return this.mSecondAxis;
    }

    public void setOrientation(int i5) {
        this.mOrientation = i5;
        if (i5 == 0) {
            this.mMainAxis = this.horizontal;
            this.mSecondAxis = this.vertical;
            return;
        }
        this.mMainAxis = this.vertical;
        this.mSecondAxis = this.horizontal;
    }

    public String toString() {
        return "horizontal=" + this.horizontal + "; vertical=" + this.vertical;
    }
}
