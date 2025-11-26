package J;

import android.os.Bundle;
import android.util.Log;
import k0.C1699m;

/* renamed from: J.A  reason: case insensitive filesystem */
abstract class C0644A {

    /* renamed from: a  reason: collision with root package name */
    final int f2600a;

    /* renamed from: b  reason: collision with root package name */
    final C1699m f2601b = new C1699m();

    /* renamed from: c  reason: collision with root package name */
    final int f2602c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f2603d;

    C0644A(int i5, int i6, Bundle bundle) {
        this.f2600a = i5;
        this.f2602c = i6;
        this.f2603d = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public final void c(B b5) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj = toString();
            String obj2 = b5.toString();
            Log.d("MessengerIpcClient", "Failing " + obj + " with " + obj2);
        }
        this.f2601b.b(b5);
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj2 = toString();
            String valueOf = String.valueOf(obj);
            Log.d("MessengerIpcClient", "Finishing " + obj2 + " with " + valueOf);
        }
        this.f2601b.c(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f2602c + " id=" + this.f2600a + " oneWay=" + b() + "}";
    }
}
