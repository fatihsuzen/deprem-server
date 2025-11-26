package B3;

import b3.C2312i;
import kotlin.jvm.internal.t;
import w3.U0;

final class Q {

    /* renamed from: a  reason: collision with root package name */
    public final C2312i f17383a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f17384b;

    /* renamed from: c  reason: collision with root package name */
    private final U0[] f17385c;

    /* renamed from: d  reason: collision with root package name */
    private int f17386d;

    public Q(C2312i iVar, int i5) {
        this.f17383a = iVar;
        this.f17384b = new Object[i5];
        this.f17385c = new U0[i5];
    }

    public final void a(U0 u02, Object obj) {
        Object[] objArr = this.f17384b;
        int i5 = this.f17386d;
        objArr[i5] = obj;
        U0[] u0Arr = this.f17385c;
        this.f17386d = i5 + 1;
        t.c(u02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        u0Arr[i5] = u02;
    }

    public final void b(C2312i iVar) {
        int length = this.f17385c.length - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                U0 u02 = this.f17385c[length];
                t.b(u02);
                u02.u(iVar, this.f17384b[length]);
                if (i5 >= 0) {
                    length = i5;
                } else {
                    return;
                }
            }
        }
    }
}
