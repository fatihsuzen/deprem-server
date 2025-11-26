package com.google.android.gms.internal.measurement;

import android.content.Context;
import l0.k;

final class M3 extends C1115h4 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5020a;

    /* renamed from: b  reason: collision with root package name */
    private final k f5021b;

    M3(Context context, k kVar) {
        this.f5020a = context;
        this.f5021b = kVar;
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f5020a;
    }

    /* access modifiers changed from: package-private */
    public final k b() {
        return this.f5021b;
    }

    public final boolean equals(Object obj) {
        k kVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1115h4) {
            C1115h4 h4Var = (C1115h4) obj;
            if (!this.f5020a.equals(h4Var.a()) || ((kVar = this.f5021b) != null ? !kVar.equals(h4Var.b()) : h4Var.b() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = this.f5020a.hashCode() ^ 1000003;
        k kVar = this.f5021b;
        if (kVar == null) {
            i5 = 0;
        } else {
            i5 = kVar.hashCode();
        }
        return (hashCode * 1000003) ^ i5;
    }

    public final String toString() {
        String obj = this.f5020a.toString();
        int length = obj.length();
        String valueOf = String.valueOf(this.f5021b);
        StringBuilder sb = new StringBuilder(length + 45 + valueOf.length() + 1);
        sb.append("FlagsContext{context=");
        sb.append(obj);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
