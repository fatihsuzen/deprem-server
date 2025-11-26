package N;

import K.C0660g;
import L.C0668a;
import L.f;
import M.C0684d;
import M.C0691k;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: N.g  reason: case insensitive filesystem */
public abstract class C0713g extends C0709c implements C0668a.f {

    /* renamed from: F  reason: collision with root package name */
    private final C0710d f3088F;

    /* renamed from: G  reason: collision with root package name */
    private final Set f3089G;

    /* renamed from: H  reason: collision with root package name */
    private final Account f3090H;

    protected C0713g(Context context, Looper looper, int i5, C0710d dVar, f.a aVar, f.b bVar) {
        this(context, looper, i5, dVar, (C0684d) aVar, (C0691k) bVar);
    }

    private final Set l0(Set set) {
        Set<Scope> k02 = k0(set);
        for (Scope contains : k02) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return k02;
    }

    /* access modifiers changed from: protected */
    public final Set C() {
        return this.f3089G;
    }

    public Set c() {
        if (o()) {
            return this.f3089G;
        }
        return Collections.EMPTY_SET;
    }

    /* access modifiers changed from: protected */
    public final C0710d j0() {
        return this.f3088F;
    }

    public final Account u() {
        return this.f3090H;
    }

    /* access modifiers changed from: protected */
    public Executor w() {
        return null;
    }

    protected C0713g(Context context, Looper looper, int i5, C0710d dVar, C0684d dVar2, C0691k kVar) {
        this(context, looper, C0714h.a(context), C0660g.n(), i5, dVar, (C0684d) C0722p.k(dVar2), (C0691k) C0722p.k(kVar));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected C0713g(android.content.Context r10, android.os.Looper r11, N.C0714h r12, K.C0660g r13, int r14, N.C0710d r15, M.C0684d r16, M.C0691k r17) {
        /*
            r9 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            if (r0 != 0) goto L_0x0009
            r6 = r2
            goto L_0x000f
        L_0x0009:
            N.E r3 = new N.E
            r3.<init>(r0)
            r6 = r3
        L_0x000f:
            if (r1 != 0) goto L_0x0013
        L_0x0011:
            r7 = r2
            goto L_0x0019
        L_0x0013:
            N.F r2 = new N.F
            r2.<init>(r1)
            goto L_0x0011
        L_0x0019:
            java.lang.String r8 = r15.j()
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.f3088F = r15
            android.accounts.Account r2 = r15.a()
            r9.f3090H = r2
            java.util.Set r1 = r15.d()
            java.util.Set r1 = r9.l0(r1)
            r9.f3089G = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N.C0713g.<init>(android.content.Context, android.os.Looper, N.h, K.g, int, N.d, M.d, M.k):void");
    }

    /* access modifiers changed from: protected */
    public Set k0(Set set) {
        return set;
    }
}
