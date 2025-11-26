package o4;

import n4.a;
import n4.h;
import q4.f;
import q4.i;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final a f25627a;

    /* renamed from: b  reason: collision with root package name */
    public final h f25628b;

    /* renamed from: c  reason: collision with root package name */
    public final i f25629c;

    public t(a aVar, h hVar, f fVar) {
        kotlin.jvm.internal.t.e(aVar, "networkUtil");
        kotlin.jvm.internal.t.e(hVar, "requestApi");
        kotlin.jvm.internal.t.e(fVar, "resolver");
        this.f25627a = aVar;
        this.f25628b = hVar;
        this.f25629c = fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof o4.s
            if (r0 == 0) goto L_0x0013
            r0 = r7
            o4.s r0 = (o4.s) r0
            int r1 = r0.f25626d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25626d = r1
            goto L_0x0018
        L_0x0013:
            o4.s r0 = new o4.s
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25624b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25626d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            o4.t r0 = r0.f25623a
            W2.u.b(r7)     // Catch:{ a -> 0x0067 }
            goto L_0x0055
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0034:
            W2.u.b(r7)
            n4.a r7 = r6.f25627a     // Catch:{ a -> 0x0066 }
            boolean r7 = r7.a()     // Catch:{ a -> 0x0066 }
            if (r7 == 0) goto L_0x0058
            n4.h r7 = r6.f25628b     // Catch:{ a -> 0x0066 }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r5 = "geoip"
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r5)     // Catch:{ a -> 0x0066 }
            r0.f25623a = r6     // Catch:{ a -> 0x0066 }
            r0.f25626d = r4     // Catch:{ a -> 0x0066 }
            java.lang.Object r7 = r7.a(r2, r0)     // Catch:{ a -> 0x0066 }
            if (r7 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r0 = r6
        L_0x0055:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ a -> 0x0067 }
            goto L_0x0068
        L_0x0058:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x0066 }
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()     // Catch:{ a -> 0x0066 }
            if (r7 != 0) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0066 }
            r7.onCmpError(r0)     // Catch:{ a -> 0x0066 }
        L_0x0066:
            r0 = r6
        L_0x0067:
            r7 = r3
        L_0x0068:
            if (r7 != 0) goto L_0x006b
            goto L_0x0074
        L_0x006b:
            q4.i r0 = r0.f25629c
            java.lang.Object r7 = r0.a(r7)
            r3 = r7
            U2.c r3 = (U2.c) r3
        L_0x0074:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.t.a(b3.e):java.lang.Object");
    }
}
