package g3;

import f3.C2378a;
import o3.C2705c;
import p3.C2713a;

/* renamed from: g3.a  reason: case insensitive filesystem */
public class C2396a extends C2378a {

    /* renamed from: g3.a$a  reason: collision with other inner class name */
    private static final class C0240a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0240a f22169a = new C0240a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f22170b;

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
                    f22170b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f22170b = num2;
        }

        private C0240a() {
        }
    }

    private final boolean c(int i5) {
        Integer num = C0240a.f22170b;
        if (num == null || num.intValue() >= i5) {
            return true;
        }
        return false;
    }

    public C2705c b() {
        if (c(34)) {
            return new C2713a();
        }
        return super.b();
    }
}
