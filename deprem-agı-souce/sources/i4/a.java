package i4;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import g4.b;
import g4.d;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24501a = b.i(a.class);

    private static String a(int i5) {
        return TypedValues.Custom.S_DIMENSION + i5;
    }

    public static boolean b(d dVar, int i5, String str) {
        if (i5 < 1) {
            p4.a.b(f24501a).c("dimensionId should be great than 0 (arg: %d)", Integer.valueOf(i5));
            return false;
        }
        if (str != null && str.length() > 255) {
            str = str.substring(0, 255);
            p4.a.b(f24501a).h("dimensionValue was truncated to 255 chars.", new Object[0]);
        }
        if (str != null && str.length() == 0) {
            str = null;
        }
        dVar.d(a(i5), str);
        return true;
    }
}
