package w3;

import k3.q;
import kotlin.jvm.internal.t;

/* renamed from: w3.z  reason: case insensitive filesystem */
final class C2909z {

    /* renamed from: a  reason: collision with root package name */
    public final Object f26322a;

    /* renamed from: b  reason: collision with root package name */
    public final C2880k f26323b;

    /* renamed from: c  reason: collision with root package name */
    public final q f26324c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f26325d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f26326e;

    public C2909z(Object obj, C2880k kVar, q qVar, Object obj2, Throwable th) {
        this.f26322a = obj;
        this.f26323b = kVar;
        this.f26324c = qVar;
        this.f26325d = obj2;
        this.f26326e = th;
    }

    public static /* synthetic */ C2909z b(C2909z zVar, Object obj, C2880k kVar, q qVar, Object obj2, Throwable th, int i5, Object obj3) {
        if ((i5 & 1) != 0) {
            obj = zVar.f26322a;
        }
        if ((i5 & 2) != 0) {
            kVar = zVar.f26323b;
        }
        if ((i5 & 4) != 0) {
            qVar = zVar.f26324c;
        }
        if ((i5 & 8) != 0) {
            obj2 = zVar.f26325d;
        }
        if ((i5 & 16) != 0) {
            th = zVar.f26326e;
        }
        Object obj4 = obj2;
        Throwable th2 = th;
        return zVar.a(obj, kVar, qVar, obj4, th2);
    }

    public final C2909z a(Object obj, C2880k kVar, q qVar, Object obj2, Throwable th) {
        return new C2909z(obj, kVar, qVar, obj2, th);
    }

    public final boolean c() {
        if (this.f26326e != null) {
            return true;
        }
        return false;
    }

    public final void d(C2886n nVar, Throwable th) {
        C2880k kVar = this.f26323b;
        if (kVar != null) {
            nVar.n(kVar, th);
        }
        q qVar = this.f26324c;
        if (qVar != null) {
            nVar.o(qVar, th, this.f26322a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2909z)) {
            return false;
        }
        C2909z zVar = (C2909z) obj;
        if (t.a(this.f26322a, zVar.f26322a) && t.a(this.f26323b, zVar.f26323b) && t.a(this.f26324c, zVar.f26324c) && t.a(this.f26325d, zVar.f26325d) && t.a(this.f26326e, zVar.f26326e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        Object obj = this.f26322a;
        int i9 = 0;
        if (obj == null) {
            i5 = 0;
        } else {
            i5 = obj.hashCode();
        }
        int i10 = i5 * 31;
        C2880k kVar = this.f26323b;
        if (kVar == null) {
            i6 = 0;
        } else {
            i6 = kVar.hashCode();
        }
        int i11 = (i10 + i6) * 31;
        q qVar = this.f26324c;
        if (qVar == null) {
            i7 = 0;
        } else {
            i7 = qVar.hashCode();
        }
        int i12 = (i11 + i7) * 31;
        Object obj2 = this.f26325d;
        if (obj2 == null) {
            i8 = 0;
        } else {
            i8 = obj2.hashCode();
        }
        int i13 = (i12 + i8) * 31;
        Throwable th = this.f26326e;
        if (th != null) {
            i9 = th.hashCode();
        }
        return i13 + i9;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f26322a + ", cancelHandler=" + this.f26323b + ", onCancellation=" + this.f26324c + ", idempotentResume=" + this.f26325d + ", cancelCause=" + this.f26326e + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C2909z(java.lang.Object r2, w3.C2880k r3, k3.q r4, java.lang.Object r5, java.lang.Throwable r6, int r7, kotlin.jvm.internal.C2633k r8) {
        /*
            r1 = this;
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r8 = r7 & 8
            if (r8 == 0) goto L_0x0010
            r5 = r0
        L_0x0010:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x001b
            r7 = r0
        L_0x0015:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x001d
        L_0x001b:
            r7 = r6
            goto L_0x0015
        L_0x001d:
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.C2909z.<init>(java.lang.Object, w3.k, k3.q, java.lang.Object, java.lang.Throwable, int, kotlin.jvm.internal.k):void");
    }
}
