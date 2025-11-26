package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import f0.C1658m;
import f0.x;
import f0.y;
import f0.z;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.j2  reason: case insensitive filesystem */
public final class C1352j2 {

    /* renamed from: b  reason: collision with root package name */
    protected static final AtomicReference f6498b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    protected static final AtomicReference f6499c = new AtomicReference();

    /* renamed from: d  reason: collision with root package name */
    protected static final AtomicReference f6500d = new AtomicReference();

    /* renamed from: a  reason: collision with root package name */
    private final C1658m f6501a;

    public C1352j2(C1658m mVar) {
        this.f6501a = mVar;
    }

    private static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z4;
        String str2;
        C0722p.k(strArr);
        C0722p.k(strArr2);
        C0722p.k(atomicReference);
        if (strArr.length == strArr2.length) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.a(z4);
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (Objects.equals(str, strArr[i5])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i5];
                        if (str2 == null) {
                            str2 = strArr2[i5] + "(" + strArr[i5] + ")";
                            strArr3[i5] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f6501a.A()) {
            return str;
        }
        return g(str, x.f15334c, x.f15332a, f6498b);
    }

    /* access modifiers changed from: protected */
    public final String b(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f6501a.A()) {
            return str;
        }
        return g(str, y.f15337b, y.f15336a, f6499c);
    }

    /* access modifiers changed from: protected */
    public final String c(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f6501a.A()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, z.f15341b, z.f15340a, f6500d);
        }
        return "experiment_id(" + str + ")";
    }

    /* access modifiers changed from: protected */
    public final String d(G g5) {
        String str;
        C1658m mVar = this.f6501a;
        if (!mVar.A()) {
            return g5.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(g5.f5885c);
        sb.append(",name=");
        sb.append(a(g5.f5883a));
        sb.append(",params=");
        E e5 = g5.f5884b;
        if (e5 == null) {
            str = null;
        } else if (!mVar.A()) {
            str = e5.toString();
        } else {
            str = e(e5.j());
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String e(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.f6501a.A()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String next : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(b(next));
            sb.append("=");
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                str = f(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = f((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = f(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            sb.append(str);
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String f(Object[] objArr) {
        String str;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = e(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
