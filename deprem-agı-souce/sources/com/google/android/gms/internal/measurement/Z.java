package com.google.android.gms.internal.measurement;

final class Z extends C1102g0 {

    /* renamed from: c  reason: collision with root package name */
    private final String f5288c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5289d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5290e;

    /* synthetic */ Z(String str, boolean z4, int i5, W w4, X x4, int i6, byte[] bArr) {
        this.f5288c = str;
        this.f5289d = i5;
        this.f5290e = i6;
    }

    public final String a() {
        return this.f5288c;
    }

    public final boolean b() {
        return false;
    }

    public final W c() {
        return null;
    }

    public final X d() {
        return null;
    }

    public final int e() {
        return this.f5289d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1102g0) {
            C1102g0 g0Var = (C1102g0) obj;
            if (this.f5288c.equals(g0Var.a())) {
                g0Var.b();
                int i5 = this.f5289d;
                int e5 = g0Var.e();
                if (i5 == 0) {
                    throw null;
                } else if (i5 == e5) {
                    g0Var.c();
                    g0Var.d();
                    int i6 = this.f5290e;
                    int f5 = g0Var.f();
                    if (i6 == 0) {
                        throw null;
                    } else if (f5 == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int f() {
        return this.f5290e;
    }

    public final int hashCode() {
        int hashCode = this.f5288c.hashCode() ^ 1000003;
        int i5 = this.f5289d;
        if (i5 != 0) {
            int i6 = (((hashCode * 1000003) ^ 1237) * 1000003) ^ i5;
            if (this.f5290e != 0) {
                return (i6 * 583896283) ^ 1;
            }
            throw null;
        }
        throw null;
    }

    public final String toString() {
        String str;
        int i5 = this.f5289d;
        String str2 = "null";
        if (i5 == 1) {
            str = "ALL_CHECKS";
        } else if (i5 == 2) {
            str = "SKIP_COMPLIANCE_CHECK";
        } else if (i5 == 3) {
            str = "SKIP_SECURITY_CHECK";
        } else if (i5 != 4) {
            str = str2;
        } else {
            str = "NO_CHECKS";
        }
        if (this.f5290e == 1) {
            str2 = "READ_AND_WRITE";
        }
        String str3 = this.f5288c;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 73 + str.length() + 91 + str2.length() + 1);
        sb.append("FileComplianceOptions{fileOwner=");
        sb.append(str3);
        sb.append(", hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str);
        sb.append(", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
