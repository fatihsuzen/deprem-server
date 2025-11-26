package k4;

import W2.J;
import androidx.lifecycle.LiveDataScope;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;

public final class t extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24650a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f24651b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24652c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f24653d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Boolean f24654e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(String str, String str2, Boolean bool, C2308e eVar) {
        super(2, eVar);
        this.f24652c = str;
        this.f24653d = str2;
        this.f24654e = bool;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        t tVar = new t(this.f24652c, this.f24653d, this.f24654e, eVar);
        tVar.f24651b = obj;
        return tVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((t) create((LiveDataScope) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r14 == r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r1.emit((java.lang.String) r14, r13) == r0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r13.f24650a
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            W2.u.b(r14)
            r11 = r13
            goto L_0x006d
        L_0x0014:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001c:
            java.lang.Object r1 = r13.f24651b
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            W2.u.b(r14)
            r11 = r13
            goto L_0x0060
        L_0x0025:
            W2.u.b(r14)
            java.lang.Object r14 = r13.f24651b
            r1 = r14
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            k4.l r5 = k4.z.f24677b
            java.lang.String r14 = r13.f24652c
            int r6 = r14.length()
            if (r6 != 0) goto L_0x0039
            r7 = r4
            goto L_0x003a
        L_0x0039:
            r7 = r14
        L_0x003a:
            r4.a r14 = s4.c.l()
            r4.b r6 = r4.b.NON_IAB_CONSENT_ENCODED
            java.lang.String r9 = r14.k(r6)
            java.lang.String r14 = r13.f24653d
            int r6 = r14.length()
            if (r6 != 0) goto L_0x004e
            r8 = r4
            goto L_0x004f
        L_0x004e:
            r8 = r14
        L_0x004f:
            java.lang.Boolean r6 = r13.f24654e
            r13.f24651b = r1
            r13.f24650a = r3
            r10 = 0
            r12 = 80
            r11 = r13
            java.lang.Object r14 = k4.l.e(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L_0x0060
            goto L_0x006c
        L_0x0060:
            java.lang.String r14 = (java.lang.String) r14
            r11.f24651b = r4
            r11.f24650a = r2
            java.lang.Object r14 = r1.emit(r14, r13)
            if (r14 != r0) goto L_0x006d
        L_0x006c:
            return r0
        L_0x006d:
            W2.J r14 = W2.J.f19942a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
