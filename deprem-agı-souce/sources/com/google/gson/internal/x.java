package com.google.gson.internal;

import java.math.BigDecimal;

public final class x extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f7782a;

    public x(String str) {
        this.f7782a = str;
    }

    private BigDecimal a() {
        return z.b(this.f7782a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f7782a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f7782a.equals(((x) obj).f7782a);
        }
        return false;
    }

    public float floatValue() {
        return Float.parseFloat(this.f7782a);
    }

    public int hashCode() {
        return this.f7782a.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return (int) java.lang.Long.parseLong(r2.f7782a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        return a().intValue();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int intValue() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f7782a     // Catch:{ NumberFormatException -> 0x0007 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0007 }
            return r0
        L_0x0007:
            java.lang.String r0 = r2.f7782a     // Catch:{ NumberFormatException -> 0x000f }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x000f }
            int r0 = (int) r0
            return r0
        L_0x000f:
            java.math.BigDecimal r0 = r2.a()
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.x.intValue():int");
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f7782a);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f7782a;
    }
}
