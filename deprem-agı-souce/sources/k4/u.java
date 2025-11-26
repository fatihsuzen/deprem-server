package k4;

import W2.J;
import androidx.lifecycle.LiveDataScope;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;

public final class u extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24655a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f24656b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24657c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f24658d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f24659e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(String str, b bVar, int i5, C2308e eVar) {
        super(2, eVar);
        this.f24657c = str;
        this.f24658d = bVar;
        this.f24659e = i5;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        u uVar = new u(this.f24657c, this.f24658d, this.f24659e, eVar);
        uVar.f24656b = obj;
        return uVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((u) create((LiveDataScope) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d0, code lost:
        if (r3 == r1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00df, code lost:
        if (r2.emit((java.lang.String) r3, r0) == r1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e1, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f24655a
            r3 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0028
            if (r2 == r5) goto L_0x001d
            if (r2 != r3) goto L_0x0015
            W2.u.b(r24)
            goto L_0x00e2
        L_0x0015:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001d:
            java.lang.Object r2 = r0.f24656b
            androidx.lifecycle.LiveDataScope r2 = (androidx.lifecycle.LiveDataScope) r2
            W2.u.b(r24)
            r3 = r24
            goto L_0x00d3
        L_0x0028:
            W2.u.b(r24)
            java.lang.Object r2 = r0.f24656b
            androidx.lifecycle.LiveDataScope r2 = (androidx.lifecycle.LiveDataScope) r2
            k4.l r6 = k4.z.f24677b
            r4.a r7 = s4.c.l()
            r4.b r8 = r4.b.HDR_GPP_STRING
            java.lang.String r14 = r7.k(r8)
            java.lang.String r7 = r0.f24657c
            java.lang.String r8 = "STATE_AND_NATIONAL"
            boolean r7 = kotlin.jvm.internal.t.a(r7, r8)
            if (r7 == 0) goto L_0x0049
            java.lang.String r7 = s4.c.f25865m
            r15 = r7
            goto L_0x004a
        L_0x0049:
            r15 = 0
        L_0x004a:
            java.lang.String r7 = r0.f24657c
            k4.b r8 = r0.f24658d
            int r9 = r0.f24659e
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.b.a(r5)
            r0.f24656b = r2
            r0.f24655a = r5
            r6.getClass()
            java.lang.String r19 = m.l.e()
            r11 = r10
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r12 = r6.f24607h
            r10.addAll(r12)
            r12 = r11
            java.lang.String r11 = r8.f24560a
            java.lang.String r9 = k4.f.a(r9)
            boolean r13 = m.l.f960a
            if (r13 == 0) goto L_0x0089
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            com.inmobi.cmp.core.model.Vector r3 = m.l.f961b
            m.h r4 = new m.h
            r4.<init>(r13)
            r3.forEach(r4)
            r20 = r13
        L_0x0086:
            r3 = r12
            r12 = r9
            goto L_0x008c
        L_0x0089:
            r20 = 0
            goto L_0x0086
        L_0x008c:
            k4.o r9 = new k4.o
            r21 = 0
            r22 = 2440(0x988, float:3.419E-42)
            r13 = 0
            r17 = 0
            r18 = 0
            r16 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.b.a(r5)
            boolean r3 = kotlin.jvm.internal.t.a(r3, r4)
            if (r3 == 0) goto L_0x00ad
            r4.a r3 = r6.f24605f
            r4.b r4 = r4.b.MSPA_CONSENT_EXPLICITLY
            r3.j(r4, r5)
        L_0x00ad:
            r4.a r3 = r6.f24605f
            r4.b r4 = r4.b.MSPA_STATUS
            java.lang.String r5 = r8.f24560a
            r3.i(r4, r5)
            r4.a r3 = r6.f24605f
            r4.b r4 = r4.b.GBC_STATUS
            if (r19 != 0) goto L_0x00be
            java.lang.String r19 = ""
        L_0x00be:
            r5 = r19
            r3.i(r4, r5)
            java.util.ArrayList r3 = r6.f24607h
            r3.clear()
            k4.g r3 = k4.g.DONE
            k4.h r4 = k4.h.MSPA
            java.lang.Object r3 = r6.b(r3, r9, r4, r0)
            if (r3 != r1) goto L_0x00d3
            goto L_0x00e1
        L_0x00d3:
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            r0.f24656b = r4
            r4 = 2
            r0.f24655a = r4
            java.lang.Object r2 = r2.emit(r3, r0)
            if (r2 != r1) goto L_0x00e2
        L_0x00e1:
            return r1
        L_0x00e2:
            W2.J r1 = W2.J.f19942a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
