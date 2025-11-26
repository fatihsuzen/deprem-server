package c1;

import b1.W;
import kotlin.jvm.internal.t;

/* renamed from: c1.a  reason: case insensitive filesystem */
public final class C1044a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1044a f4745a = new C1044a();

    /* renamed from: b  reason: collision with root package name */
    public static W f4746b;

    private C1044a() {
    }

    public static final void b() {
        try {
            if (f4746b == null) {
                f4745a.c(W.f4588a.a());
            }
            C1044a aVar = f4745a;
            if (aVar.a().a()) {
                aVar.a().b();
            }
        } catch (Exception unused) {
        }
    }

    public final W a() {
        W w4 = f4746b;
        if (w4 != null) {
            return w4;
        }
        t.w("sharedSessionRepository");
        return null;
    }

    public final void c(W w4) {
        t.e(w4, "<set-?>");
        f4746b = w4;
    }
}
