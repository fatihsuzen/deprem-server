package f3;

import e3.C2349a;
import kotlin.jvm.internal.t;

/* renamed from: f3.a  reason: case insensitive filesystem */
public abstract class C2378a extends C2349a {

    /* renamed from: f3.a$a  reason: collision with other inner class name */
    private static final class C0222a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0222a f21624a = new C0222a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f21625b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                    if (num != null && num.intValue() > 0) {
                        num2 = num;
                    }
                    f21625b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f21625b = num2;
        }

        private C0222a() {
        }
    }

    private final boolean c(int i5) {
        Integer num = C0222a.f21625b;
        if (num == null || num.intValue() >= i5) {
            return true;
        }
        return false;
    }

    public void a(Throwable th, Throwable th2) {
        t.e(th, "cause");
        t.e(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
