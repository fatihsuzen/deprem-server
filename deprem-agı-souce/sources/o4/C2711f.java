package o4;

import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import q4.b;
import q4.i;

/* renamed from: o4.f  reason: case insensitive filesystem */
public final class C2711f {

    /* renamed from: a  reason: collision with root package name */
    public final a f25578a;

    /* renamed from: b  reason: collision with root package name */
    public final r4.a f25579b;

    /* renamed from: c  reason: collision with root package name */
    public final h f25580c;

    /* renamed from: d  reason: collision with root package name */
    public final i f25581d;

    public C2711f(a aVar, r4.a aVar2, h hVar, b bVar) {
        t.e(aVar, "networkUtil");
        t.e(aVar2, "sharedStorage");
        t.e(hVar, "requestApi");
        t.e(bVar, "resolver");
        this.f25578a = aVar;
        this.f25579b = aVar2;
        this.f25580c = hVar;
        this.f25581d = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof o4.C2709d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            o4.d r0 = (o4.C2709d) r0
            int r1 = r0.f25576d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25576d = r1
            goto L_0x0018
        L_0x0013:
            o4.d r0 = new o4.d
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f25574b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25576d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            o4.f r0 = r0.f25573a
            W2.u.b(r6)     // Catch:{ a -> 0x0070 }
            goto L_0x0054
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0033:
            W2.u.b(r6)
            n4.a r6 = r5.f25578a     // Catch:{ a -> 0x006f }
            boolean r6 = r6.a()     // Catch:{ a -> 0x006f }
            if (r6 == 0) goto L_0x0057
            n4.h r6 = r5.f25580c     // Catch:{ a -> 0x006f }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r4 = "GVL-v2/cmp-list.json"
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r4)     // Catch:{ a -> 0x006f }
            r0.f25573a = r5     // Catch:{ a -> 0x006f }
            r0.f25576d = r3     // Catch:{ a -> 0x006f }
            java.lang.Object r6 = r6.a(r2, r0)     // Catch:{ a -> 0x006f }
            if (r6 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r5
        L_0x0054:
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ a -> 0x0070 }
            goto L_0x0078
        L_0x0057:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x006f }
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()     // Catch:{ a -> 0x006f }
            if (r6 != 0) goto L_0x0060
            goto L_0x0065
        L_0x0060:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x006f }
            r6.onCmpError(r0)     // Catch:{ a -> 0x006f }
        L_0x0065:
            r4.a r6 = r5.f25579b     // Catch:{ a -> 0x006f }
            r4.b r0 = r4.b.CMP_LIST     // Catch:{ a -> 0x006f }
            java.lang.String r6 = r6.k(r0)     // Catch:{ a -> 0x006f }
            r0 = r5
            goto L_0x0078
        L_0x006f:
            r0 = r5
        L_0x0070:
            r4.a r6 = r0.f25579b
            r4.b r1 = r4.b.CMP_LIST
            java.lang.String r6 = r6.k(r1)
        L_0x0078:
            r4.a r1 = r0.f25579b
            r4.b r2 = r4.b.CMP_LIST
            r1.i(r2, r6)
            q4.i r0 = r0.f25581d
            java.lang.Object r6 = r0.a(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.C2711f.a(b3.e):java.lang.Object");
    }
}
