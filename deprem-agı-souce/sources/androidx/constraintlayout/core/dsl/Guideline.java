package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Helper;

public abstract class Guideline extends Helper {
    private int mEnd = Integer.MIN_VALUE;
    private float mPercent = Float.NaN;
    private int mStart = Integer.MIN_VALUE;

    Guideline(String str) {
        super(str, new Helper.HelperType(""));
    }

    public int getEnd() {
        return this.mEnd;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setEnd(int i5) {
        this.mEnd = i5;
        this.configMap.put(TtmlNode.END, String.valueOf(i5));
    }

    public void setPercent(float f5) {
        this.mPercent = f5;
        this.configMap.put("percent", String.valueOf(f5));
    }

    public void setStart(int i5) {
        this.mStart = i5;
        this.configMap.put("start", String.valueOf(i5));
    }
}
