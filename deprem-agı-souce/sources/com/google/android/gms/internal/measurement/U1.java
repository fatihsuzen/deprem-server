package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class U1 {

    /* renamed from: a  reason: collision with root package name */
    public final U1 f5184a;

    /* renamed from: b  reason: collision with root package name */
    final C1269z f5185b;

    /* renamed from: c  reason: collision with root package name */
    final Map f5186c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map f5187d = new HashMap();

    public U1(U1 u12, C1269z zVar) {
        this.f5184a = u12;
        this.f5185b = zVar;
    }

    public final r a(r rVar) {
        return this.f5185b.b(this, rVar);
    }

    public final r b(C1092f fVar) {
        r rVar = r.f5553b0;
        Iterator n5 = fVar.n();
        while (n5.hasNext()) {
            rVar = this.f5185b.b(this, fVar.q(((Integer) n5.next()).intValue()));
            if (rVar instanceof C1110h) {
                break;
            }
        }
        return rVar;
    }

    public final U1 c() {
        return new U1(this, this.f5185b);
    }

    public final boolean d(String str) {
        if (this.f5186c.containsKey(str)) {
            return true;
        }
        U1 u12 = this.f5184a;
        if (u12 != null) {
            return u12.d(str);
        }
        return false;
    }

    public final void e(String str, r rVar) {
        U1 u12;
        Map map = this.f5186c;
        if (!map.containsKey(str) && (u12 = this.f5184a) != null && u12.d(str)) {
            u12.e(str, rVar);
        } else if (!this.f5187d.containsKey(str)) {
            if (rVar == null) {
                map.remove(str);
            } else {
                map.put(str, rVar);
            }
        }
    }

    public final void f(String str, r rVar) {
        if (!this.f5187d.containsKey(str)) {
            if (rVar == null) {
                this.f5186c.remove(str);
            } else {
                this.f5186c.put(str, rVar);
            }
        }
    }

    public final void g(String str, r rVar) {
        f(str, rVar);
        this.f5187d.put(str, Boolean.TRUE);
    }

    public final r h(String str) {
        Map map = this.f5186c;
        if (map.containsKey(str)) {
            return (r) map.get(str);
        }
        U1 u12 = this.f5184a;
        if (u12 != null) {
            return u12.h(str);
        }
        throw new IllegalArgumentException(String.format("%s is not defined", new Object[]{str}));
    }
}
