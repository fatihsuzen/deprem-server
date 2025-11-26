package androidx.leanback.graphics;

import android.graphics.Rect;

public class BoundsRule {
    public ValueRule bottom;
    public ValueRule left;
    public ValueRule right;
    public ValueRule top;

    public BoundsRule() {
    }

    private int doCalculate(int i5, ValueRule valueRule, int i6) {
        return i5 + valueRule.mAbsoluteValue + ((int) (valueRule.mFraction * ((float) i6)));
    }

    public void calculateBounds(Rect rect, Rect rect2) {
        ValueRule valueRule = this.left;
        if (valueRule == null) {
            rect2.left = rect.left;
        } else {
            rect2.left = doCalculate(rect.left, valueRule, rect.width());
        }
        ValueRule valueRule2 = this.right;
        if (valueRule2 == null) {
            rect2.right = rect.right;
        } else {
            rect2.right = doCalculate(rect.left, valueRule2, rect.width());
        }
        ValueRule valueRule3 = this.top;
        if (valueRule3 == null) {
            rect2.top = rect.top;
        } else {
            rect2.top = doCalculate(rect.top, valueRule3, rect.height());
        }
        ValueRule valueRule4 = this.bottom;
        if (valueRule4 == null) {
            rect2.bottom = rect.bottom;
        } else {
            rect2.bottom = doCalculate(rect.top, valueRule4, rect.height());
        }
    }

    public BoundsRule(BoundsRule boundsRule) {
        ValueRule valueRule = boundsRule.left;
        ValueRule valueRule2 = null;
        this.left = valueRule != null ? new ValueRule(valueRule) : null;
        ValueRule valueRule3 = boundsRule.right;
        this.right = valueRule3 != null ? new ValueRule(valueRule3) : null;
        ValueRule valueRule4 = boundsRule.top;
        this.top = valueRule4 != null ? new ValueRule(valueRule4) : null;
        ValueRule valueRule5 = boundsRule.bottom;
        this.bottom = valueRule5 != null ? new ValueRule(valueRule5) : valueRule2;
    }

    public static final class ValueRule {
        int mAbsoluteValue;
        float mFraction;

        ValueRule(int i5, float f5) {
            this.mAbsoluteValue = i5;
            this.mFraction = f5;
        }

        public static ValueRule absoluteValue(int i5) {
            return new ValueRule(i5, 0.0f);
        }

        public static ValueRule inheritFromParent(float f5) {
            return new ValueRule(0, f5);
        }

        public static ValueRule inheritFromParentWithOffset(float f5, int i5) {
            return new ValueRule(i5, f5);
        }

        public int getAbsoluteValue() {
            return this.mAbsoluteValue;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public void setAbsoluteValue(int i5) {
            this.mAbsoluteValue = i5;
        }

        public void setFraction(float f5) {
            this.mFraction = f5;
        }

        ValueRule(ValueRule valueRule) {
            this.mFraction = valueRule.mFraction;
            this.mAbsoluteValue = valueRule.mAbsoluteValue;
        }
    }
}
