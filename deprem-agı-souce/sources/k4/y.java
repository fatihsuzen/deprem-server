package k4;

import W2.J;
import androidx.lifecycle.LiveDataScope;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;

public final class y extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24673a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f24674b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f24675c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(h hVar, C2308e eVar) {
        super(2, eVar);
        this.f24675c = hVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        y yVar = new y(this.f24675c, eVar);
        yVar.f24674b = obj;
        return yVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        y yVar = new y(this.f24675c, (C2308e) obj2);
        yVar.f24674b = (LiveDataScope) obj;
        return yVar.invokeSuspend(J.f19942a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (r1.emit((java.lang.String) r7, r6) == r0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if (r7 == r0) goto L_0x005f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r6.f24673a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r7)
            goto L_0x0060
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.f24674b
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            W2.u.b(r7)
            goto L_0x0052
        L_0x0022:
            W2.u.b(r7)
            java.lang.Object r7 = r6.f24674b
            r1 = r7
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            k4.l r7 = k4.z.f24677b
            k4.h r4 = r6.f24675c
            r6.f24674b = r1
            r6.f24673a = r3
            r7.getClass()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r5 = r7.f24607h
            r3.addAll(r5)
            k4.p r5 = new k4.p
            r5.<init>(r3)
            java.util.ArrayList r3 = r7.f24607h
            r3.clear()
            k4.g r3 = k4.g.CLICK
            java.lang.Object r7 = r7.b(r3, r5, r4, r6)
            if (r7 != r0) goto L_0x0052
            goto L_0x005f
        L_0x0052:
            java.lang.String r7 = (java.lang.String) r7
            r3 = 0
            r6.f24674b = r3
            r6.f24673a = r2
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto L_0x0060
        L_0x005f:
            return r0
        L_0x0060:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
