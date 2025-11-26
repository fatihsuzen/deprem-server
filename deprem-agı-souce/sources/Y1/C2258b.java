package Y1;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

/* renamed from: Y1.b  reason: case insensitive filesystem */
public final class C2258b {

    /* renamed from: a  reason: collision with root package name */
    private final String f20124a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20125b;

    /* renamed from: c  reason: collision with root package name */
    private String f20126c;

    public C2258b(String str, String str2) {
        t.e(str, "packageName");
        t.e(str2, RewardPlus.NAME);
        this.f20124a = str;
        this.f20125b = str2;
    }

    public final String a() {
        return this.f20126c;
    }

    public final String b() {
        return this.f20125b;
    }

    public final String c() {
        return this.f20124a;
    }

    public final void d(String str) {
        this.f20126c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2258b)) {
            return false;
        }
        C2258b bVar = (C2258b) obj;
        if (t.a(this.f20124a, bVar.f20124a) && t.a(this.f20125b, bVar.f20125b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f20124a.hashCode() * 31) + this.f20125b.hashCode();
    }

    public String toString() {
        return "AppToBackup(packageName=" + this.f20124a + ", name=" + this.f20125b + ')';
    }
}
