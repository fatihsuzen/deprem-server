package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.e5  reason: case insensitive filesystem */
public abstract class C1089e5 extends C1213s4 {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected C1072c6 zzc = C1072c6.a();

    protected static C1134j5 A(C1134j5 j5Var) {
        int size = j5Var.size();
        return j5Var.a(size + size);
    }

    protected static C1143k5 B() {
        return O5.d();
    }

    protected static C1143k5 C(C1143k5 k5Var) {
        int size = k5Var.size();
        return k5Var.m(size + size);
    }

    private static final boolean D(C1089e5 e5Var, boolean z4) {
        C1089e5 e5Var2;
        byte byteValue = ((Byte) e5Var.E(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d5 = N5.a().b(e5Var.getClass()).d(e5Var);
        if (z4) {
            if (true != d5) {
                e5Var2 = null;
            } else {
                e5Var2 = e5Var;
            }
            e5Var.E(2, e5Var2, (Object) null);
        }
        return d5;
    }

    private final int h(Q5 q5) {
        return N5.a().b(getClass()).a(this);
    }

    static C1089e5 s(Class cls) {
        Map map = zzd;
        C1089e5 e5Var = (C1089e5) map.get(cls);
        if (e5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                e5Var = (C1089e5) map.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (e5Var != null) {
            return e5Var;
        }
        C1089e5 e5Var2 = (C1089e5) ((C1089e5) C1126i6.h(cls)).E(6, (Object) null, (Object) null);
        if (e5Var2 != null) {
            map.put(cls, e5Var2);
            return e5Var2;
        }
        throw new IllegalStateException();
    }

    protected static void t(Class cls, C1089e5 e5Var) {
        e5Var.k();
        zzd.put(cls, e5Var);
    }

    protected static Object w(F5 f5, String str, Object[] objArr) {
        return new P5(f5, str, objArr);
    }

    static Object x(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static C1125i5 y() {
        return C1098f5.d();
    }

    protected static C1134j5 z() {
        return C1223t5.d();
    }

    /* access modifiers changed from: protected */
    public abstract Object E(int i5, Object obj, Object obj2);

    public final int a() {
        if (j()) {
            int h5 = h((Q5) null);
            if (h5 >= 0) {
                return h5;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(h5).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(h5);
            throw new IllegalStateException(sb.toString());
        }
        int i5 = this.zzb & Integer.MAX_VALUE;
        if (i5 != Integer.MAX_VALUE) {
            return i5;
        }
        int h6 = h((Q5) null);
        if (h6 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | h6;
            return h6;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(h6).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(h6);
        throw new IllegalStateException(sb2.toString());
    }

    public final /* synthetic */ E5 b() {
        return (C1071c5) E(5, (Object) null, (Object) null);
    }

    public final void c(M4 m42) {
        N5.a().b(getClass()).g(this, N4.L(m42));
    }

    public final /* synthetic */ F5 d() {
        return (C1089e5) E(6, (Object) null, (Object) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return N5.a().b(getClass()).h(this, (C1089e5) obj);
    }

    /* access modifiers changed from: package-private */
    public final int f(Q5 q5) {
        if (j()) {
            int a5 = q5.a(this);
            if (a5 >= 0) {
                return a5;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(a5).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(a5);
            throw new IllegalStateException(sb.toString());
        }
        int i5 = this.zzb & Integer.MAX_VALUE;
        if (i5 != Integer.MAX_VALUE) {
            return i5;
        }
        int a6 = q5.a(this);
        if (a6 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | a6;
            return a6;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(a6).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(a6);
        throw new IllegalStateException(sb2.toString());
    }

    public final int hashCode() {
        if (j()) {
            return n();
        }
        int i5 = this.zza;
        if (i5 != 0) {
            return i5;
        }
        int n5 = n();
        this.zza = n5;
        return n5;
    }

    public final boolean i() {
        return D(this, true);
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        this.zzb &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final C1089e5 m() {
        return (C1089e5) E(4, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int n() {
        return N5.a().b(getClass()).c(this);
    }

    /* access modifiers changed from: protected */
    public final void o() {
        N5.a().b(getClass()).e(this);
        k();
    }

    /* access modifiers changed from: protected */
    public final C1071c5 p() {
        return (C1071c5) E(5, (Object) null, (Object) null);
    }

    public final C1071c5 q() {
        C1071c5 c5Var = (C1071c5) E(5, (Object) null, (Object) null);
        c5Var.p(this);
        return c5Var;
    }

    /* access modifiers changed from: package-private */
    public final void r(int i5) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final String toString() {
        return H5.a(this, super.toString());
    }
}
