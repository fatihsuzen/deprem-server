package b1;

import androidx.collection.a;
import kotlin.jvm.internal.t;

public final class T {

    /* renamed from: a  reason: collision with root package name */
    private final String f4578a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4579b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4580c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4581d;

    /* renamed from: e  reason: collision with root package name */
    private final C1021f f4582e;

    /* renamed from: f  reason: collision with root package name */
    private final String f4583f;

    /* renamed from: g  reason: collision with root package name */
    private final String f4584g;

    public T(String str, String str2, int i5, long j5, C1021f fVar, String str3, String str4) {
        t.e(str, "sessionId");
        t.e(str2, "firstSessionId");
        t.e(fVar, "dataCollectionStatus");
        t.e(str3, "firebaseInstallationId");
        t.e(str4, "firebaseAuthenticationToken");
        this.f4578a = str;
        this.f4579b = str2;
        this.f4580c = i5;
        this.f4581d = j5;
        this.f4582e = fVar;
        this.f4583f = str3;
        this.f4584g = str4;
    }

    public final C1021f a() {
        return this.f4582e;
    }

    public final long b() {
        return this.f4581d;
    }

    public final String c() {
        return this.f4584g;
    }

    public final String d() {
        return this.f4583f;
    }

    public final String e() {
        return this.f4579b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T)) {
            return false;
        }
        T t5 = (T) obj;
        if (t.a(this.f4578a, t5.f4578a) && t.a(this.f4579b, t5.f4579b) && this.f4580c == t5.f4580c && this.f4581d == t5.f4581d && t.a(this.f4582e, t5.f4582e) && t.a(this.f4583f, t5.f4583f) && t.a(this.f4584g, t5.f4584g)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f4578a;
    }

    public final int g() {
        return this.f4580c;
    }

    public int hashCode() {
        return (((((((((((this.f4578a.hashCode() * 31) + this.f4579b.hashCode()) * 31) + this.f4580c) * 31) + a.a(this.f4581d)) * 31) + this.f4582e.hashCode()) * 31) + this.f4583f.hashCode()) * 31) + this.f4584g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f4578a + ", firstSessionId=" + this.f4579b + ", sessionIndex=" + this.f4580c + ", eventTimestampUs=" + this.f4581d + ", dataCollectionStatus=" + this.f4582e + ", firebaseInstallationId=" + this.f4583f + ", firebaseAuthenticationToken=" + this.f4584g + ')';
    }
}
