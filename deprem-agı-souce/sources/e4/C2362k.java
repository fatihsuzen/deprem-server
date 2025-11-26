package e4;

import com.mbridge.msdk.MBridgeConstans;
import e4.Q;
import f4.c;
import f4.h;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: e4.k  reason: case insensitive filesystem */
public abstract class C2362k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21589a = new a((C2633k) null);

    /* renamed from: b  reason: collision with root package name */
    public static final C2362k f21590b;

    /* renamed from: c  reason: collision with root package name */
    public static final Q f21591c;

    /* renamed from: d  reason: collision with root package name */
    public static final C2362k f21592d;

    /* renamed from: e4.k$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static {
        C2362k kVar;
        try {
            Class.forName("java.nio.file.Files");
            kVar = new K();
        } catch (ClassNotFoundException unused) {
            kVar = new C2369s();
        }
        f21590b = kVar;
        Q.a aVar = Q.f21501b;
        String property = System.getProperty("java.io.tmpdir");
        t.d(property, "getProperty(\"java.io.tmpdir\")");
        f21591c = Q.a.e(aVar, property, false, 1, (Object) null);
        ClassLoader classLoader = h.class.getClassLoader();
        t.d(classLoader, "ResourceFileSystem::class.java.classLoader");
        f21592d = new h(classLoader, false);
    }

    public abstract void a(Q q5, Q q6);

    public final void b(Q q5, boolean z4) {
        t.e(q5, "dir");
        c.a(this, q5, z4);
    }

    public final void c(Q q5) {
        t.e(q5, "dir");
        d(q5, false);
    }

    public abstract void d(Q q5, boolean z4);

    public final void e(Q q5) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        f(q5, false);
    }

    public abstract void f(Q q5, boolean z4);

    public final boolean g(Q q5) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return c.b(this, q5);
    }

    public abstract C2361j h(Q q5);

    public abstract C2360i i(Q q5);

    public final C2360i j(Q q5) {
        t.e(q5, "file");
        return k(q5, false, false);
    }

    public abstract C2360i k(Q q5, boolean z4, boolean z5);

    public abstract Z l(Q q5);
}
