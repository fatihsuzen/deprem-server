package o4;

import W2.J;
import androidx.lifecycle.LiveDataScope;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import q4.i;

public final class n extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public i f25604a;

    /* renamed from: b  reason: collision with root package name */
    public int f25605b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ Object f25606c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o f25607d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f25608e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(o oVar, String str, C2308e eVar) {
        super(2, eVar);
        this.f25607d = oVar;
        this.f25608e = str;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        n nVar = new n(this.f25607d, this.f25608e, eVar);
        nVar.f25606c = obj;
        return nVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((n) create((LiveDataScope) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0087, code lost:
        if (r7.emit(r1, r6) != r0) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r6.f25605b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            W2.u.b(r7)
            goto L_0x008a
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            q4.i r1 = r6.f25604a
            java.lang.Object r3 = r6.f25606c
            androidx.lifecycle.LiveDataScope r3 = (androidx.lifecycle.LiveDataScope) r3
            W2.u.b(r7)     // Catch:{ a -> 0x0076 }
            goto L_0x0056
        L_0x0025:
            W2.u.b(r7)
            java.lang.Object r7 = r6.f25606c
            androidx.lifecycle.LiveDataScope r7 = (androidx.lifecycle.LiveDataScope) r7
            o4.o r1 = r6.f25607d     // Catch:{ a -> 0x0075 }
            n4.a r1 = r1.f25609a     // Catch:{ a -> 0x0075 }
            boolean r1 = r1.a()     // Catch:{ a -> 0x0075 }
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = r6.f25608e     // Catch:{ a -> 0x0075 }
            int r1 = r1.length()     // Catch:{ a -> 0x0075 }
            if (r1 <= 0) goto L_0x0061
            o4.o r1 = r6.f25607d     // Catch:{ a -> 0x0075 }
            q4.i r4 = r1.f25611c     // Catch:{ a -> 0x0075 }
            n4.h r1 = r1.f25610b     // Catch:{ a -> 0x0075 }
            java.lang.String r5 = r6.f25608e     // Catch:{ a -> 0x0075 }
            r6.f25606c = r7     // Catch:{ a -> 0x0075 }
            r6.f25604a = r4     // Catch:{ a -> 0x0075 }
            r6.f25605b = r3     // Catch:{ a -> 0x0075 }
            java.lang.Object r1 = r1.a(r5, r6)     // Catch:{ a -> 0x0075 }
            if (r1 != r0) goto L_0x0053
            goto L_0x0089
        L_0x0053:
            r3 = r7
            r7 = r1
            r1 = r4
        L_0x0056:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ a -> 0x0076 }
            java.lang.Object r7 = r1.a(r7)     // Catch:{ a -> 0x0076 }
            m4.f r7 = (m4.f) r7     // Catch:{ a -> 0x0076 }
        L_0x005e:
            r1 = r7
            r7 = r3
            goto L_0x007c
        L_0x0061:
            com.inmobi.cmp.ChoiceCmp r1 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x0075 }
            com.inmobi.cmp.ChoiceCmpCallback r1 = r1.getCallback()     // Catch:{ a -> 0x0075 }
            if (r1 != 0) goto L_0x006a
            goto L_0x006f
        L_0x006a:
            com.inmobi.cmp.model.ChoiceError r3 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0075 }
            r1.onCmpError(r3)     // Catch:{ a -> 0x0075 }
        L_0x006f:
            m4.f r1 = new m4.f     // Catch:{ a -> 0x0075 }
            r1.<init>()     // Catch:{ a -> 0x0075 }
            goto L_0x007c
        L_0x0075:
            r3 = r7
        L_0x0076:
            m4.f r7 = new m4.f
            r7.<init>()
            goto L_0x005e
        L_0x007c:
            r3 = 0
            r6.f25606c = r3
            r6.f25604a = r3
            r6.f25605b = r2
            java.lang.Object r7 = r7.emit(r1, r6)
            if (r7 != r0) goto L_0x008a
        L_0x0089:
            return r0
        L_0x008a:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
