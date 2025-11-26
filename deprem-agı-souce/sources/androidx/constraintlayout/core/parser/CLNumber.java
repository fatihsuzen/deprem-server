package androidx.constraintlayout.core.parser;

public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f5 = getFloat();
            float f6 = ((CLNumber) obj).getFloat();
            if ((!Float.isNaN(f5) || !Float.isNaN(f6)) && f5 != f6) {
                return false;
            }
            return true;
        }
        return false;
    }

    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = (float) Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    public int hashCode() {
        int i5;
        int hashCode = super.hashCode() * 31;
        float f5 = this.mValue;
        if (f5 != 0.0f) {
            i5 = Float.floatToIntBits(f5);
        } else {
            i5 = 0;
        }
        return hashCode + i5;
    }

    public boolean isInt() {
        float f5 = getFloat();
        if (((float) ((int) f5)) == f5) {
            return true;
        }
        return false;
    }

    public void putValue(float f5) {
        this.mValue = f5;
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i5);
        float f5 = getFloat();
        int i7 = (int) f5;
        if (((float) i7) == f5) {
            sb.append(i7);
        } else {
            sb.append(f5);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        float f5 = getFloat();
        int i5 = (int) f5;
        if (((float) i5) == f5) {
            return "" + i5;
        }
        return "" + f5;
    }

    public CLNumber(float f5) {
        super((char[]) null);
        this.mValue = f5;
    }
}
