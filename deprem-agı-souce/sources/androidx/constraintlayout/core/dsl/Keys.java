package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

public class Keys {
    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, int i5) {
        if (i5 != Integer.MIN_VALUE) {
            sb.append(str);
            sb.append(":'");
            sb.append(i5);
            sb.append("',\n");
        }
    }

    /* access modifiers changed from: protected */
    public String unpack(String[] strArr) {
        String str;
        StringBuilder sb = new StringBuilder("[");
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (i5 == 0) {
                str = "'";
            } else {
                str = ",'";
            }
            sb.append(str);
            sb.append(strArr[i5]);
            sb.append("'");
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(str);
            sb.append(":'");
            sb.append(str2);
            sb.append("',\n");
        }
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, float f5) {
        if (!Float.isNaN(f5)) {
            sb.append(str);
            sb.append(":");
            sb.append(f5);
            sb.append(",\n");
        }
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(":");
            sb.append(unpack(strArr));
            sb.append(",\n");
        }
    }

    /* access modifiers changed from: protected */
    public void append(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }
}
