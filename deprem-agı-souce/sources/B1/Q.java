package b1;

import java.util.Locale;
import kotlin.jvm.internal.t;
import t3.s;

public final class Q {

    /* renamed from: a  reason: collision with root package name */
    private final a0 f4574a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f4575b;

    public Q(a0 a0Var, c0 c0Var) {
        t.e(a0Var, "timeProvider");
        t.e(c0Var, "uuidGenerator");
        this.f4574a = a0Var;
        this.f4575b = c0Var;
    }

    private final String b() {
        String uuid = this.f4575b.next().toString();
        t.d(uuid, "toString(...)");
        String lowerCase = s.L(uuid, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        t.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final K a(K k5) {
        String str;
        int i5;
        String b5 = b();
        if (k5 == null || (str = k5.a()) == null) {
            str = b5;
        }
        if (k5 != null) {
            i5 = k5.c() + 1;
        } else {
            i5 = 0;
        }
        return new K(b5, str, i5, this.f4574a.a().b());
    }
}
