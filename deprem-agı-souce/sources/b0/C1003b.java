package b0;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: b0.b  reason: case insensitive filesystem */
public abstract class C1003b {
    public static String a(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            length = objArr.length;
            if (i6 >= length) {
                break;
            }
            Object obj = objArr[i6];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e5) {
                    Exception exc = e5;
                    String str3 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), exc);
                    str2 = "<" + str3 + " threw " + exc.getClass().getName() + ">";
                }
            }
            objArr[i6] = str2;
            i6++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i7 = 0;
        while (true) {
            length2 = objArr.length;
            if (i5 >= length2 || (indexOf = str.indexOf("%s", i7)) == -1) {
                sb.append(str, i7, str.length());
            } else {
                sb.append(str, i7, indexOf);
                sb.append(objArr[i5]);
                i5++;
                i7 = indexOf + 2;
            }
        }
        sb.append(str, i7, str.length());
        if (i5 < length2) {
            sb.append(" [");
            sb.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
