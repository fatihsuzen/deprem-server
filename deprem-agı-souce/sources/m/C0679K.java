package M;

import K.C0655b;
import N.C0709c;
import N.C0711e;
import N.C0719m;
import N.C0723q;
import N.r;
import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.b;
import k0.C1692f;
import k0.C1698l;

/* renamed from: M.K  reason: case insensitive filesystem */
final class C0679K implements C1692f {

    /* renamed from: a  reason: collision with root package name */
    private final C0685e f2845a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2846b;

    /* renamed from: c  reason: collision with root package name */
    private final C0682b f2847c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2848d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2849e;

    C0679K(C0685e eVar, int i5, C0682b bVar, long j5, long j6, String str, String str2) {
        this.f2845a = eVar;
        this.f2846b = i5;
        this.f2847c = bVar;
        this.f2848d = j5;
        this.f2849e = j6;
    }

    static C0679K b(C0685e eVar, int i5, C0682b bVar) {
        boolean z4;
        long j5;
        if (!eVar.e()) {
            return null;
        }
        r a5 = C0723q.b().a();
        if (a5 == null) {
            z4 = true;
        } else if (!a5.f()) {
            return null;
        } else {
            z4 = a5.g();
            C0670B t5 = eVar.t(bVar);
            if (t5 != null) {
                if (!(t5.v() instanceof C0709c)) {
                    return null;
                }
                C0709c cVar = (C0709c) t5.v();
                if (cVar.J() && !cVar.f()) {
                    C0711e c5 = c(t5, cVar, i5);
                    if (c5 == null) {
                        return null;
                    }
                    t5.G();
                    z4 = c5.i();
                }
            }
        }
        long j6 = 0;
        if (z4) {
            j5 = System.currentTimeMillis();
        } else {
            j5 = 0;
        }
        if (z4) {
            j6 = SystemClock.elapsedRealtime();
        }
        return new C0679K(eVar, i5, bVar, j5, j6, (String) null, (String) null);
    }

    private static C0711e c(C0670B b5, C0709c cVar, int i5) {
        int[] d5;
        int[] f5;
        C0711e H4 = cVar.H();
        if (H4 == null || !H4.g() || ((d5 = H4.d()) != null ? !b.a(d5, i5) : !((f5 = H4.f()) == null || !b.a(f5, i5))) || b5.t() >= H4.c()) {
            return null;
        }
        return H4;
    }

    public final void a(C1698l lVar) {
        C0670B t5;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j5;
        long j6;
        if (this.f2845a.e()) {
            r a5 = C0723q.b().a();
            if ((a5 == null || a5.f()) && (t5 = this.f2845a.t(this.f2847c)) != null && (t5.v() instanceof C0709c)) {
                C0709c cVar = (C0709c) t5.v();
                boolean z5 = true;
                int i9 = 0;
                if (this.f2848d > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int z6 = cVar.z();
                int i10 = 100;
                if (a5 != null) {
                    boolean g5 = z4 & a5.g();
                    int c5 = a5.c();
                    int d5 = a5.d();
                    i7 = a5.i();
                    if (cVar.J() && !cVar.f()) {
                        C0711e c6 = c(t5, cVar, this.f2846b);
                        if (c6 != null) {
                            if (!c6.i() || this.f2848d <= 0) {
                                z5 = false;
                            }
                            d5 = c6.c();
                            g5 = z5;
                        } else {
                            return;
                        }
                    }
                    i6 = c5;
                    i5 = d5;
                } else {
                    i7 = 0;
                    i5 = 100;
                    i6 = 5000;
                }
                C0685e eVar = this.f2845a;
                int i11 = -1;
                if (lVar.n()) {
                    i8 = 0;
                } else {
                    if (!lVar.l()) {
                        Exception i12 = lVar.i();
                        if (i12 instanceof L.b) {
                            Status a6 = ((L.b) i12).a();
                            i10 = a6.d();
                            C0655b c7 = a6.c();
                            if (c7 != null) {
                                i8 = c7.c();
                                i9 = i10;
                            }
                        } else {
                            i9 = 101;
                            i8 = -1;
                        }
                    }
                    i9 = i10;
                    i8 = -1;
                }
                if (z4) {
                    long j7 = this.f2848d;
                    long j8 = this.f2849e;
                    long currentTimeMillis = System.currentTimeMillis();
                    i11 = (int) (SystemClock.elapsedRealtime() - j8);
                    j6 = currentTimeMillis;
                    j5 = j7;
                } else {
                    j5 = 0;
                    j6 = 0;
                }
                C0719m mVar = new C0719m(this.f2846b, i9, i8, j5, j6, (String) null, (String) null, z6, i11);
                eVar.C(mVar, i7, (long) i6, i5);
            }
        }
    }
}
