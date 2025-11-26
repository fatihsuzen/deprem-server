package M;

import L.e;
import android.os.Looper;
import com.google.android.gms.common.api.internal.a;

/* renamed from: M.G  reason: case insensitive filesystem */
public final class C0675G extends C0700u {

    /* renamed from: c  reason: collision with root package name */
    private final e f2842c;

    public C0675G(e eVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f2842c = eVar;
    }

    public final a a(a aVar) {
        return this.f2842c.e(aVar);
    }

    public final Looper c() {
        return this.f2842c.k();
    }
}
