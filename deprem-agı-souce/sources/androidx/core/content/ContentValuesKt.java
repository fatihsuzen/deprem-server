package androidx.core.content;

import W2.s;
import android.content.ContentValues;

public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(s... sVarArr) {
        ContentValues contentValues = new ContentValues(sVarArr.length);
        for (s sVar : sVarArr) {
            String str = (String) sVar.a();
            Object b5 = sVar.b();
            if (b5 == null) {
                contentValues.putNull(str);
            } else if (b5 instanceof String) {
                contentValues.put(str, (String) b5);
            } else if (b5 instanceof Integer) {
                contentValues.put(str, (Integer) b5);
            } else if (b5 instanceof Long) {
                contentValues.put(str, (Long) b5);
            } else if (b5 instanceof Boolean) {
                contentValues.put(str, (Boolean) b5);
            } else if (b5 instanceof Float) {
                contentValues.put(str, (Float) b5);
            } else if (b5 instanceof Double) {
                contentValues.put(str, (Double) b5);
            } else if (b5 instanceof byte[]) {
                contentValues.put(str, (byte[]) b5);
            } else if (b5 instanceof Byte) {
                contentValues.put(str, (Byte) b5);
            } else if (b5 instanceof Short) {
                contentValues.put(str, (Short) b5);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b5.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return contentValues;
    }
}
