package N3;

import W2.J;
import X2.C2241h;
import kotlin.jvm.internal.t;

/* renamed from: N3.f  reason: case insensitive filesystem */
public abstract class C2136f {

    /* renamed from: a  reason: collision with root package name */
    private final C2241h f18785a = new C2241h();

    /* renamed from: b  reason: collision with root package name */
    private int f18786b;

    /* access modifiers changed from: protected */
    public final void a(char[] cArr) {
        t.e(cArr, "array");
        synchronized (this) {
            try {
                if (this.f18786b + cArr.length < C2134d.f18783a) {
                    this.f18786b += cArr.length;
                    this.f18785a.addLast(cArr);
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final char[] b(int i5) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.f18785a.t();
            if (cArr != null) {
                this.f18786b -= cArr.length;
            } else {
                cArr = null;
            }
        }
        if (cArr == null) {
            return new char[i5];
        }
        return cArr;
    }
}
