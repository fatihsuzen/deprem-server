package l2;

import kotlin.jvm.internal.t;

/* renamed from: l2.g  reason: case insensitive filesystem */
public final class C2658g {

    /* renamed from: a  reason: collision with root package name */
    private final String f25086a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25087b;

    public C2658g(String str, String str2) {
        t.e(str, "packagename");
        t.e(str2, "installerPackagename");
        this.f25086a = str;
        this.f25087b = str2;
    }

    public final String a() {
        return this.f25086a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2658g)) {
            return false;
        }
        C2658g gVar = (C2658g) obj;
        if (t.a(this.f25086a, gVar.f25086a) && t.a(this.f25087b, gVar.f25087b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f25086a.hashCode() * 31) + this.f25087b.hashCode();
    }

    public String toString() {
        return "{packagename='" + this.f25086a + "', installerPackagename='" + this.f25087b + "'}";
    }
}
