package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.measurement.z5  reason: case insensitive filesystem */
public final class C1275z5 extends LinkedHashMap {

    /* renamed from: b  reason: collision with root package name */
    private static final C1275z5 f5709b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f5710a = true;

    static {
        C1275z5 z5Var = new C1275z5();
        f5709b = z5Var;
        z5Var.f5710a = false;
    }

    private C1275z5() {
    }

    public static C1275z5 a() {
        return f5709b;
    }

    private static int g(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = C1152l5.f5434b;
            int length = bArr.length;
            int c5 = C1152l5.c(length, bArr, 0, length);
            if (c5 == 0) {
                return 1;
            }
            return c5;
        } else if (!(obj instanceof C1107g5)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private final void h() {
        if (!this.f5710a) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(C1275z5 z5Var) {
        h();
        if (!z5Var.isEmpty()) {
            putAll(z5Var);
        }
    }

    public final C1275z5 c() {
        if (isEmpty()) {
            return new C1275z5();
        }
        return new C1275z5(this);
    }

    public final void clear() {
        h();
        super.clear();
    }

    public final void e() {
        this.f5710a = false;
    }

    public final Set entrySet() {
        if (isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z4;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z4 = value.equals(obj2);
                continue;
            } else {
                z4 = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z4) {
                return false;
            }
        }
        return true;
    }

    public final boolean f() {
        return this.f5710a;
    }

    public final int hashCode() {
        int i5 = 0;
        for (Map.Entry entry : entrySet()) {
            i5 += g(entry.getValue()) ^ g(entry.getKey());
        }
        return i5;
    }

    public final Object put(Object obj, Object obj2) {
        h();
        byte[] bArr = C1152l5.f5434b;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        h();
        for (Object next : map.keySet()) {
            byte[] bArr = C1152l5.f5434b;
            next.getClass();
            map.get(next).getClass();
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        h();
        return super.remove(obj);
    }

    private C1275z5(Map map) {
        super(map);
    }
}
