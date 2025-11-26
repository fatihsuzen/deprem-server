package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.HashMap;

public class FlowReference extends HelperReference {
    protected float mFirstHorizontalBias = 0.5f;
    protected int mFirstHorizontalStyle = -1;
    protected float mFirstVerticalBias = 0.5f;
    protected int mFirstVerticalStyle = -1;
    protected Flow mFlow;
    protected int mHorizontalAlign = 2;
    protected int mHorizontalGap = 0;
    protected int mHorizontalStyle = -1;
    protected float mLastHorizontalBias = 0.5f;
    protected int mLastHorizontalStyle = -1;
    protected float mLastVerticalBias = 0.5f;
    protected int mLastVerticalStyle = -1;
    protected HashMap<String, Float> mMapPostMargin;
    protected HashMap<String, Float> mMapPreMargin;
    protected HashMap<String, Float> mMapWeights;
    protected int mMaxElementsWrap = -1;
    protected int mOrientation = 0;
    protected int mPaddingBottom = 0;
    protected int mPaddingLeft = 0;
    protected int mPaddingRight = 0;
    protected int mPaddingTop = 0;
    protected int mVerticalAlign = 2;
    protected int mVerticalGap = 0;
    protected int mVerticalStyle = -1;
    protected int mWrapMode = 0;

    public FlowReference(State state, State.Helper helper) {
        super(state, helper);
        if (helper == State.Helper.VERTICAL_FLOW) {
            this.mOrientation = 1;
        }
    }

    public void addFlowElement(String str, float f5, float f6, float f7) {
        super.add(str);
        if (!Float.isNaN(f5)) {
            if (this.mMapWeights == null) {
                this.mMapWeights = new HashMap<>();
            }
            this.mMapWeights.put(str, Float.valueOf(f5));
        }
        if (!Float.isNaN(f6)) {
            if (this.mMapPreMargin == null) {
                this.mMapPreMargin = new HashMap<>();
            }
            this.mMapPreMargin.put(str, Float.valueOf(f6));
        }
        if (!Float.isNaN(f7)) {
            if (this.mMapPostMargin == null) {
                this.mMapPostMargin = new HashMap<>();
            }
            this.mMapPostMargin.put(str, Float.valueOf(f7));
        }
    }

    public void apply() {
        getHelperWidget();
        setConstraintWidget(this.mFlow);
        this.mFlow.setOrientation(this.mOrientation);
        this.mFlow.setWrapMode(this.mWrapMode);
        int i5 = this.mMaxElementsWrap;
        if (i5 != -1) {
            this.mFlow.setMaxElementsWrap(i5);
        }
        int i6 = this.mPaddingLeft;
        if (i6 != 0) {
            this.mFlow.setPaddingLeft(i6);
        }
        int i7 = this.mPaddingTop;
        if (i7 != 0) {
            this.mFlow.setPaddingTop(i7);
        }
        int i8 = this.mPaddingRight;
        if (i8 != 0) {
            this.mFlow.setPaddingRight(i8);
        }
        int i9 = this.mPaddingBottom;
        if (i9 != 0) {
            this.mFlow.setPaddingBottom(i9);
        }
        int i10 = this.mHorizontalGap;
        if (i10 != 0) {
            this.mFlow.setHorizontalGap(i10);
        }
        int i11 = this.mVerticalGap;
        if (i11 != 0) {
            this.mFlow.setVerticalGap(i11);
        }
        float f5 = this.mHorizontalBias;
        if (f5 != 0.5f) {
            this.mFlow.setHorizontalBias(f5);
        }
        float f6 = this.mFirstHorizontalBias;
        if (f6 != 0.5f) {
            this.mFlow.setFirstHorizontalBias(f6);
        }
        float f7 = this.mLastHorizontalBias;
        if (f7 != 0.5f) {
            this.mFlow.setLastHorizontalBias(f7);
        }
        float f8 = this.mVerticalBias;
        if (f8 != 0.5f) {
            this.mFlow.setVerticalBias(f8);
        }
        float f9 = this.mFirstVerticalBias;
        if (f9 != 0.5f) {
            this.mFlow.setFirstVerticalBias(f9);
        }
        float f10 = this.mLastVerticalBias;
        if (f10 != 0.5f) {
            this.mFlow.setLastVerticalBias(f10);
        }
        int i12 = this.mHorizontalAlign;
        if (i12 != 2) {
            this.mFlow.setHorizontalAlign(i12);
        }
        int i13 = this.mVerticalAlign;
        if (i13 != 2) {
            this.mFlow.setVerticalAlign(i13);
        }
        int i14 = this.mVerticalStyle;
        if (i14 != -1) {
            this.mFlow.setVerticalStyle(i14);
        }
        int i15 = this.mFirstVerticalStyle;
        if (i15 != -1) {
            this.mFlow.setFirstVerticalStyle(i15);
        }
        int i16 = this.mLastVerticalStyle;
        if (i16 != -1) {
            this.mFlow.setLastVerticalStyle(i16);
        }
        int i17 = this.mHorizontalStyle;
        if (i17 != -1) {
            this.mFlow.setHorizontalStyle(i17);
        }
        int i18 = this.mFirstHorizontalStyle;
        if (i18 != -1) {
            this.mFlow.setFirstHorizontalStyle(i18);
        }
        int i19 = this.mLastHorizontalStyle;
        if (i19 != -1) {
            this.mFlow.setLastHorizontalStyle(i19);
        }
        applyBase();
    }

    public float getFirstHorizontalBias() {
        return this.mFirstHorizontalBias;
    }

    public int getFirstHorizontalStyle() {
        return this.mFirstHorizontalStyle;
    }

    public float getFirstVerticalBias() {
        return this.mFirstVerticalBias;
    }

    public int getFirstVerticalStyle() {
        return this.mFirstVerticalStyle;
    }

    public HelperWidget getHelperWidget() {
        if (this.mFlow == null) {
            this.mFlow = new Flow();
        }
        return this.mFlow;
    }

    public int getHorizontalAlign() {
        return this.mHorizontalAlign;
    }

    public float getHorizontalBias() {
        return this.mHorizontalBias;
    }

    public int getHorizontalGap() {
        return this.mHorizontalGap;
    }

    public int getHorizontalStyle() {
        return this.mHorizontalStyle;
    }

    public float getLastHorizontalBias() {
        return this.mLastHorizontalBias;
    }

    public int getLastHorizontalStyle() {
        return this.mLastHorizontalStyle;
    }

    public float getLastVerticalBias() {
        return this.mLastVerticalBias;
    }

    public int getLastVerticalStyle() {
        return this.mLastVerticalStyle;
    }

    public int getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    /* access modifiers changed from: protected */
    public float getPostMargin(String str) {
        HashMap<String, Float> hashMap = this.mMapPreMargin;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPreMargin.get(str).floatValue();
    }

    /* access modifiers changed from: protected */
    public float getPreMargin(String str) {
        HashMap<String, Float> hashMap = this.mMapPostMargin;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPostMargin.get(str).floatValue();
    }

    public int getVerticalAlign() {
        return this.mVerticalAlign;
    }

    public float getVerticalBias() {
        return this.mVerticalBias;
    }

    public int getVerticalGap() {
        return this.mVerticalGap;
    }

    public int getVerticalStyle() {
        return this.mVerticalStyle;
    }

    /* access modifiers changed from: protected */
    public float getWeight(String str) {
        HashMap<String, Float> hashMap = this.mMapWeights;
        if (hashMap != null && hashMap.containsKey(str)) {
            return this.mMapWeights.get(str).floatValue();
        }
        return -1.0f;
    }

    public int getWrapMode() {
        return this.mWrapMode;
    }

    public void setFirstHorizontalBias(float f5) {
        this.mFirstHorizontalBias = f5;
    }

    public void setFirstHorizontalStyle(int i5) {
        this.mFirstHorizontalStyle = i5;
    }

    public void setFirstVerticalBias(float f5) {
        this.mFirstVerticalBias = f5;
    }

    public void setFirstVerticalStyle(int i5) {
        this.mFirstVerticalStyle = i5;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        if (helperWidget instanceof Flow) {
            this.mFlow = (Flow) helperWidget;
        } else {
            this.mFlow = null;
        }
    }

    public void setHorizontalAlign(int i5) {
        this.mHorizontalAlign = i5;
    }

    public void setHorizontalGap(int i5) {
        this.mHorizontalGap = i5;
    }

    public void setHorizontalStyle(int i5) {
        this.mHorizontalStyle = i5;
    }

    public void setLastHorizontalBias(float f5) {
        this.mLastHorizontalBias = f5;
    }

    public void setLastHorizontalStyle(int i5) {
        this.mLastHorizontalStyle = i5;
    }

    public void setLastVerticalBias(float f5) {
        this.mLastVerticalBias = f5;
    }

    public void setLastVerticalStyle(int i5) {
        this.mLastVerticalStyle = i5;
    }

    public void setMaxElementsWrap(int i5) {
        this.mMaxElementsWrap = i5;
    }

    public void setOrientation(int i5) {
        this.mOrientation = i5;
    }

    public void setPaddingBottom(int i5) {
        this.mPaddingBottom = i5;
    }

    public void setPaddingLeft(int i5) {
        this.mPaddingLeft = i5;
    }

    public void setPaddingRight(int i5) {
        this.mPaddingRight = i5;
    }

    public void setPaddingTop(int i5) {
        this.mPaddingTop = i5;
    }

    public void setVerticalAlign(int i5) {
        this.mVerticalAlign = i5;
    }

    public void setVerticalGap(int i5) {
        this.mVerticalGap = i5;
    }

    public void setVerticalStyle(int i5) {
        this.mVerticalStyle = i5;
    }

    public void setWrapMode(int i5) {
        this.mWrapMode = i5;
    }
}
