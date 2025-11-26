package b1;

import kotlin.jvm.internal.t;

/* renamed from: b1.b  reason: case insensitive filesystem */
public final class C1017b {

    /* renamed from: a  reason: collision with root package name */
    private final String f4646a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4647b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4648c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4649d;

    /* renamed from: e  reason: collision with root package name */
    private final C1038x f4650e;

    /* renamed from: f  reason: collision with root package name */
    private final C1016a f4651f;

    public C1017b(String str, String str2, String str3, String str4, C1038x xVar, C1016a aVar) {
        t.e(str, "appId");
        t.e(str2, "deviceModel");
        t.e(str3, "sessionSdkVersion");
        t.e(str4, "osVersion");
        t.e(xVar, "logEnvironment");
        t.e(aVar, "androidAppInfo");
        this.f4646a = str;
        this.f4647b = str2;
        this.f4648c = str3;
        this.f4649d = str4;
        this.f4650e = xVar;
        this.f4651f = aVar;
    }

    public final C1016a a() {
        return this.f4651f;
    }

    public final String b() {
        return this.f4646a;
    }

    public final String c() {
        return this.f4647b;
    }

    public final C1038x d() {
        return this.f4650e;
    }

    public final String e() {
        return this.f4649d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1017b)) {
            return false;
        }
        C1017b bVar = (C1017b) obj;
        if (t.a(this.f4646a, bVar.f4646a) && t.a(this.f4647b, bVar.f4647b) && t.a(this.f4648c, bVar.f4648c) && t.a(this.f4649d, bVar.f4649d) && this.f4650e == bVar.f4650e && t.a(this.f4651f, bVar.f4651f)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f4648c;
    }

    public int hashCode() {
        return (((((((((this.f4646a.hashCode() * 31) + this.f4647b.hashCode()) * 31) + this.f4648c.hashCode()) * 31) + this.f4649d.hashCode()) * 31) + this.f4650e.hashCode()) * 31) + this.f4651f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f4646a + ", deviceModel=" + this.f4647b + ", sessionSdkVersion=" + this.f4648c + ", osVersion=" + this.f4649d + ", logEnvironment=" + this.f4650e + ", androidAppInfo=" + this.f4651f + ')';
    }
}
