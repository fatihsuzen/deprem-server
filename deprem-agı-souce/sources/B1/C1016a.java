package b1;

import java.util.List;
import kotlin.jvm.internal.t;

/* renamed from: b1.a  reason: case insensitive filesystem */
public final class C1016a {

    /* renamed from: a  reason: collision with root package name */
    private final String f4640a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4641b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4642c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4643d;

    /* renamed from: e  reason: collision with root package name */
    private final F f4644e;

    /* renamed from: f  reason: collision with root package name */
    private final List f4645f;

    public C1016a(String str, String str2, String str3, String str4, F f5, List list) {
        t.e(str, "packageName");
        t.e(str2, "versionName");
        t.e(str3, "appBuildVersion");
        t.e(str4, "deviceManufacturer");
        t.e(f5, "currentProcessDetails");
        t.e(list, "appProcessDetails");
        this.f4640a = str;
        this.f4641b = str2;
        this.f4642c = str3;
        this.f4643d = str4;
        this.f4644e = f5;
        this.f4645f = list;
    }

    public final String a() {
        return this.f4642c;
    }

    public final List b() {
        return this.f4645f;
    }

    public final F c() {
        return this.f4644e;
    }

    public final String d() {
        return this.f4643d;
    }

    public final String e() {
        return this.f4640a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1016a)) {
            return false;
        }
        C1016a aVar = (C1016a) obj;
        if (t.a(this.f4640a, aVar.f4640a) && t.a(this.f4641b, aVar.f4641b) && t.a(this.f4642c, aVar.f4642c) && t.a(this.f4643d, aVar.f4643d) && t.a(this.f4644e, aVar.f4644e) && t.a(this.f4645f, aVar.f4645f)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f4641b;
    }

    public int hashCode() {
        return (((((((((this.f4640a.hashCode() * 31) + this.f4641b.hashCode()) * 31) + this.f4642c.hashCode()) * 31) + this.f4643d.hashCode()) * 31) + this.f4644e.hashCode()) * 31) + this.f4645f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f4640a + ", versionName=" + this.f4641b + ", appBuildVersion=" + this.f4642c + ", deviceManufacturer=" + this.f4643d + ", currentProcessDetails=" + this.f4644e + ", appProcessDetails=" + this.f4645f + ')';
    }
}
