package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Arrays;

public class Ref {
    private String mId;
    private float mPostMargin;
    private float mPreMargin;
    private float mWeight;

    Ref(String str) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
    }

    public static void addStringToReferences(String str, ArrayList<Ref> arrayList) {
        Object obj;
        if (str != null && str.length() != 0) {
            Object[] objArr = new Object[4];
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < str.length(); i7++) {
                char charAt = str.charAt(i7);
                if (!(charAt == ' ' || charAt == '\'')) {
                    if (charAt == ',') {
                        if (i5 < 3) {
                            objArr[i5] = sb.toString();
                            sb.setLength(0);
                            i5++;
                        }
                        if (i6 == 1 && (obj = objArr[0]) != null) {
                            arrayList.add(new Ref(obj.toString()));
                            objArr[0] = null;
                        }
                    } else if (charAt == '[') {
                        i6++;
                    } else if (charAt != ']') {
                        sb.append(charAt);
                    } else if (i6 > 0) {
                        i6--;
                        objArr[i5] = sb.toString();
                        sb.setLength(0);
                        Object obj2 = objArr[0];
                        if (obj2 != null) {
                            arrayList.add(new Ref(obj2.toString(), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3])));
                            Arrays.fill(objArr, (Object) null);
                        }
                    }
                    i5 = 0;
                }
            }
        }
    }

    public static float parseFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception unused) {
            return Float.NaN;
        }
    }

    public static Ref parseStringToRef(String str) {
        String[] split = str.replaceAll("[\\[\\]\\']", "").split(",");
        if (split.length == 0) {
            return null;
        }
        Object[] objArr = new Object[4];
        int i5 = 0;
        while (i5 < split.length && i5 < 4) {
            objArr[i5] = split[i5];
            i5++;
        }
        return new Ref(objArr[0].toString().replace("'", ""), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3]));
    }

    public String getId() {
        return this.mId;
    }

    public float getPostMargin() {
        return this.mPostMargin;
    }

    public float getPreMargin() {
        return this.mPreMargin;
    }

    public float getWeight() {
        return this.mWeight;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setPostMargin(float f5) {
        this.mPostMargin = f5;
    }

    public void setPreMargin(float f5) {
        this.mPreMargin = f5;
    }

    public void setWeight(float f5) {
        this.mWeight = f5;
    }

    public String toString() {
        boolean z4;
        float f5;
        String str = this.mId;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (!Float.isNaN(this.mWeight) || !Float.isNaN(this.mPreMargin) || !Float.isNaN(this.mPostMargin)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            sb.append("[");
        }
        sb.append("'");
        sb.append(this.mId);
        sb.append("'");
        float f6 = 0.0f;
        if (!Float.isNaN(this.mPostMargin)) {
            sb.append(",");
            if (!Float.isNaN(this.mWeight)) {
                f5 = this.mWeight;
            } else {
                f5 = 0.0f;
            }
            sb.append(f5);
            sb.append(",");
            if (!Float.isNaN(this.mPreMargin)) {
                f6 = this.mPreMargin;
            }
            sb.append(f6);
            sb.append(",");
            sb.append(this.mPostMargin);
        } else if (!Float.isNaN(this.mPreMargin)) {
            sb.append(",");
            if (!Float.isNaN(this.mWeight)) {
                f6 = this.mWeight;
            }
            sb.append(f6);
            sb.append(",");
            sb.append(this.mPreMargin);
        } else if (!Float.isNaN(this.mWeight)) {
            sb.append(",");
            sb.append(this.mWeight);
        }
        if (z4) {
            sb.append("]");
        }
        sb.append(",");
        return sb.toString();
    }

    Ref(String str, float f5) {
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f5;
    }

    Ref(String str, float f5, float f6) {
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f5;
        this.mPreMargin = f6;
    }

    Ref(String str, float f5, float f6, float f7) {
        this.mId = str;
        this.mWeight = f5;
        this.mPreMargin = f6;
        this.mPostMargin = f7;
    }
}
