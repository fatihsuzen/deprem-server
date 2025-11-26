package androidx.appcompat.widget;

class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRelative = false;
    private boolean mIsRtl = false;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;

    RtlSpacingHelper() {
    }

    public int getEnd() {
        if (this.mIsRtl) {
            return this.mLeft;
        }
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl) {
            return this.mRight;
        }
        return this.mLeft;
    }

    public void setAbsolute(int i5, int i6) {
        this.mIsRelative = false;
        if (i5 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i5;
            this.mLeft = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.mExplicitRight = i6;
            this.mRight = i6;
        }
    }

    public void setDirection(boolean z4) {
        if (z4 != this.mIsRtl) {
            this.mIsRtl = z4;
            if (!this.mIsRelative) {
                this.mLeft = this.mExplicitLeft;
                this.mRight = this.mExplicitRight;
            } else if (z4) {
                int i5 = this.mEnd;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.mExplicitLeft;
                }
                this.mLeft = i5;
                int i6 = this.mStart;
                if (i6 == Integer.MIN_VALUE) {
                    i6 = this.mExplicitRight;
                }
                this.mRight = i6;
            } else {
                int i7 = this.mStart;
                if (i7 == Integer.MIN_VALUE) {
                    i7 = this.mExplicitLeft;
                }
                this.mLeft = i7;
                int i8 = this.mEnd;
                if (i8 == Integer.MIN_VALUE) {
                    i8 = this.mExplicitRight;
                }
                this.mRight = i8;
            }
        }
    }

    public void setRelative(int i5, int i6) {
        this.mStart = i5;
        this.mEnd = i6;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i6 != Integer.MIN_VALUE) {
                this.mLeft = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.mRight = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.mLeft = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.mRight = i6;
        }
    }
}
