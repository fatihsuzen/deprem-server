package androidx.dynamicanimation.animation;

public class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f5) {
        this.mValue = f5;
    }

    public FloatValueHolder(float f5) {
        setValue(f5);
    }
}
