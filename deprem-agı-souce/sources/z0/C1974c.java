package z0;

import X2.M;
import androidx.collection.a;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: z0.c  reason: case insensitive filesystem */
public final class C1974c {

    /* renamed from: a  reason: collision with root package name */
    private final String f17185a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17186b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f17187c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1974c(String str, long j5) {
        this(str, j5, (Map) null, 4, (C2633k) null);
        t.e(str, "sessionId");
    }

    public final Map a() {
        return this.f17187c;
    }

    public final String b() {
        return this.f17185a;
    }

    public final long c() {
        return this.f17186b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1974c)) {
            return false;
        }
        C1974c cVar = (C1974c) obj;
        if (t.a(this.f17185a, cVar.f17185a) && this.f17186b == cVar.f17186b && t.a(this.f17187c, cVar.f17187c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f17185a.hashCode() * 31) + a.a(this.f17186b)) * 31) + this.f17187c.hashCode();
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.f17185a + ", timestamp=" + this.f17186b + ", additionalCustomKeys=" + this.f17187c + ')';
    }

    public C1974c(String str, long j5, Map map) {
        t.e(str, "sessionId");
        t.e(map, "additionalCustomKeys");
        this.f17185a = str;
        this.f17186b = j5;
        this.f17187c = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1974c(String str, long j5, Map map, int i5, C2633k kVar) {
        this(str, j5, (i5 & 4) != 0 ? M.h() : map);
    }
}
