package N;

import K.C0655b;
import android.os.Bundle;

abstract class Q extends d0 {

    /* renamed from: d  reason: collision with root package name */
    public final int f3002d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f3003e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C0709c f3004f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected Q(C0709c cVar, int i5, Bundle bundle) {
        super(cVar, Boolean.TRUE);
        this.f3004f = cVar;
        this.f3002d = i5;
        this.f3003e = bundle;
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [android.os.Parcelable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void a(java.lang.Object r3) {
        /*
            r2 = this;
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            int r3 = r2.f3002d
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x001e
            boolean r3 = r2.g()
            if (r3 != 0) goto L_0x001d
            N.c r3 = r2.f3004f
            r3.i0(r0, (android.os.IInterface) null)
            K.b r3 = new K.b
            r0 = 8
            r3.<init>(r0, r1)
            r2.f(r3)
        L_0x001d:
            return
        L_0x001e:
            N.c r3 = r2.f3004f
            r3.i0(r0, (android.os.IInterface) null)
            android.os.Bundle r3 = r2.f3003e
            if (r3 == 0) goto L_0x0030
            java.lang.String r0 = "pendingIntent"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            r1 = r3
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1
        L_0x0030:
            int r3 = r2.f3002d
            K.b r0 = new K.b
            r0.<init>(r3, r1)
            r2.f(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N.Q.a(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public abstract void f(C0655b bVar);

    /* access modifiers changed from: protected */
    public abstract boolean g();

    /* access modifiers changed from: protected */
    public final void b() {
    }
}
