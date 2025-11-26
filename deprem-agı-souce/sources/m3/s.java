package M3;

import J3.f;
import N3.S;
import androidx.privacysandbox.ads.adservices.adid.a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class s extends B {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18695a;

    /* renamed from: b  reason: collision with root package name */
    private final f f18696b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18697c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Object obj, boolean z4, f fVar, int i5, C2633k kVar) {
        this(obj, z4, (i5 & 4) != 0 ? null : fVar);
    }

    public String c() {
        return this.f18697c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (g() == sVar.g() && t.a(c(), sVar.c())) {
            return true;
        }
        return false;
    }

    public final f f() {
        return this.f18696b;
    }

    public boolean g() {
        return this.f18695a;
    }

    public int hashCode() {
        return (a.a(g()) * 31) + c().hashCode();
    }

    public String toString() {
        if (!g()) {
            return c();
        }
        StringBuilder sb = new StringBuilder();
        S.c(sb, c());
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Object obj, boolean z4, f fVar) {
        super((C2633k) null);
        t.e(obj, TtmlNode.TAG_BODY);
        this.f18695a = z4;
        this.f18696b = fVar;
        this.f18697c = obj.toString();
        if (fVar != null && !fVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
