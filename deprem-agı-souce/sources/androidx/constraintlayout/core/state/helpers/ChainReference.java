package androidx.constraintlayout.core.state.helpers;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.HashMap;

public class ChainReference extends HelperReference {
    protected float mBias = 0.5f;
    private HashMap<String, Float> mMapPostGoneMargin;
    @NonNull
    @Deprecated
    protected HashMap<String, Float> mMapPostMargin = new HashMap<>();
    private HashMap<String, Float> mMapPreGoneMargin;
    @NonNull
    @Deprecated
    protected HashMap<String, Float> mMapPreMargin = new HashMap<>();
    @NonNull
    @Deprecated
    protected HashMap<String, Float> mMapWeights = new HashMap<>();
    @NonNull
    protected State.Chain mStyle = State.Chain.SPREAD;

    public ChainReference(@NonNull State state, @NonNull State.Helper helper) {
        super(state, helper);
    }

    public void addChainElement(@NonNull String str, float f5, float f6, float f7) {
        addChainElement(str, f5, f6, f7, 0.0f, 0.0f);
    }

    public float getBias() {
        return this.mBias;
    }

    /* access modifiers changed from: package-private */
    public float getPostGoneMargin(@NonNull String str) {
        HashMap<String, Float> hashMap = this.mMapPostGoneMargin;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPostGoneMargin.get(str).floatValue();
    }

    /* access modifiers changed from: protected */
    public float getPostMargin(@NonNull String str) {
        if (this.mMapPostMargin.containsKey(str)) {
            return this.mMapPostMargin.get(str).floatValue();
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getPreGoneMargin(@NonNull String str) {
        HashMap<String, Float> hashMap = this.mMapPreGoneMargin;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return 0.0f;
        }
        return this.mMapPreGoneMargin.get(str).floatValue();
    }

    /* access modifiers changed from: protected */
    public float getPreMargin(@NonNull String str) {
        if (this.mMapPreMargin.containsKey(str)) {
            return this.mMapPreMargin.get(str).floatValue();
        }
        return 0.0f;
    }

    @NonNull
    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    /* access modifiers changed from: protected */
    public float getWeight(@NonNull String str) {
        if (this.mMapWeights.containsKey(str)) {
            return this.mMapWeights.get(str).floatValue();
        }
        return -1.0f;
    }

    @NonNull
    public ChainReference style(@NonNull State.Chain chain) {
        this.mStyle = chain;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addChainElement(@NonNull Object obj, float f5, float f6, float f7, float f8, float f9) {
        super.add(obj);
        String obj2 = obj.toString();
        if (!Float.isNaN(f5)) {
            this.mMapWeights.put(obj2, Float.valueOf(f5));
        }
        if (!Float.isNaN(f6)) {
            this.mMapPreMargin.put(obj2, Float.valueOf(f6));
        }
        if (!Float.isNaN(f7)) {
            this.mMapPostMargin.put(obj2, Float.valueOf(f7));
        }
        if (!Float.isNaN(f8)) {
            if (this.mMapPreGoneMargin == null) {
                this.mMapPreGoneMargin = new HashMap<>();
            }
            this.mMapPreGoneMargin.put(obj2, Float.valueOf(f8));
        }
        if (!Float.isNaN(f9)) {
            if (this.mMapPostGoneMargin == null) {
                this.mMapPostGoneMargin = new HashMap<>();
            }
            this.mMapPostGoneMargin.put(obj2, Float.valueOf(f9));
        }
    }

    @NonNull
    public ChainReference bias(float f5) {
        this.mBias = f5;
        return this;
    }
}
