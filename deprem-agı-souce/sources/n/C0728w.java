package N;

import L.C0668a;
import android.os.Bundle;

/* renamed from: N.w  reason: case insensitive filesystem */
public class C0728w implements C0668a.d {

    /* renamed from: b  reason: collision with root package name */
    public static final C0728w f3158b = a().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f3159a;

    /* renamed from: N.w$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f3160a;

        /* synthetic */ a(C0730y yVar) {
        }

        public C0728w a() {
            return new C0728w(this.f3160a, (C0731z) null);
        }

        public a b(String str) {
            this.f3160a = str;
            return this;
        }
    }

    /* synthetic */ C0728w(String str, C0731z zVar) {
        this.f3159a = str;
    }

    public static a a() {
        return new a((C0730y) null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f3159a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0728w)) {
            return false;
        }
        return C0720n.a(this.f3159a, ((C0728w) obj).f3159a);
    }

    public final int hashCode() {
        return C0720n.b(this.f3159a);
    }
}
