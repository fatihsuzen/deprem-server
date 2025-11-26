package b1;

import R0.b;
import android.util.Log;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import p.C1745c;
import p.C1746d;
import p.j;
import t3.C2780d;

/* renamed from: b1.h  reason: case insensitive filesystem */
public final class C1023h implements C1024i {

    /* renamed from: b  reason: collision with root package name */
    public static final a f4703b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final b f4704a;

    /* renamed from: b1.h$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C1023h(b bVar) {
        t.e(bVar, "transportFactoryProvider");
        this.f4704a = bVar;
    }

    /* access modifiers changed from: private */
    public final byte[] c(L l5) {
        String b5 = M.f4547a.c().b(l5);
        t.d(b5, "encode(...)");
        Log.d("FirebaseSessions", "Session Event Type: " + l5.b().name());
        byte[] bytes = b5.getBytes(C2780d.f25888b);
        t.d(bytes, "getBytes(...)");
        return bytes;
    }

    public void a(L l5) {
        t.e(l5, "sessionEvent");
        ((j) this.f4704a.get()).a("FIREBASE_APPQUALITY_SESSION", L.class, C1745c.b("json"), new C1022g(this)).b(C1746d.f(l5));
    }
}
