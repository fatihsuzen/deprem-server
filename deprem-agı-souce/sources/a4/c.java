package a4;

import com.mbridge.msdk.thrid.okhttp.internal.http2.Header;
import e4.C2359h;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final C2359h f20306d = C2359h.f(":");

    /* renamed from: e  reason: collision with root package name */
    public static final C2359h f20307e = C2359h.f(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: f  reason: collision with root package name */
    public static final C2359h f20308f = C2359h.f(Header.TARGET_METHOD_UTF8);

    /* renamed from: g  reason: collision with root package name */
    public static final C2359h f20309g = C2359h.f(Header.TARGET_PATH_UTF8);

    /* renamed from: h  reason: collision with root package name */
    public static final C2359h f20310h = C2359h.f(Header.TARGET_SCHEME_UTF8);

    /* renamed from: i  reason: collision with root package name */
    public static final C2359h f20311i = C2359h.f(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: a  reason: collision with root package name */
    public final C2359h f20312a;

    /* renamed from: b  reason: collision with root package name */
    public final C2359h f20313b;

    /* renamed from: c  reason: collision with root package name */
    final int f20314c;

    public c(String str, String str2) {
        this(C2359h.f(str), C2359h.f(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (!this.f20312a.equals(cVar.f20312a) || !this.f20313b.equals(cVar.f20313b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f20312a.hashCode()) * 31) + this.f20313b.hashCode();
    }

    public String toString() {
        return V3.c.o("%s: %s", this.f20312a.L(), this.f20313b.L());
    }

    public c(C2359h hVar, String str) {
        this(hVar, C2359h.f(str));
    }

    public c(C2359h hVar, C2359h hVar2) {
        this.f20312a = hVar;
        this.f20313b = hVar2;
        this.f20314c = hVar.F() + 32 + hVar2.F();
    }
}
