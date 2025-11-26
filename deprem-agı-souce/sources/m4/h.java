package m4;

import J2.v;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f25390a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25391b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25392c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25393d;

    /* renamed from: e  reason: collision with root package name */
    public final List f25394e;

    public h(String str, String str2, int i5, String str3, ArrayList arrayList) {
        t.e(str, "identifier");
        t.e(str2, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        t.e(str3, "domain");
        t.e(arrayList, "purposes");
        this.f25390a = str;
        this.f25391b = str2;
        this.f25392c = i5;
        this.f25393d = str3;
        this.f25394e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (t.a(this.f25390a, hVar.f25390a) && t.a(this.f25391b, hVar.f25391b) && this.f25392c == hVar.f25392c && t.a(this.f25393d, hVar.f25393d) && t.a(this.f25394e, hVar.f25394e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int a5 = v.a(this.f25391b, this.f25390a.hashCode() * 31, 31);
        return this.f25394e.hashCode() + v.a(this.f25393d, (this.f25392c + a5) * 31, 31);
    }

    public final String toString() {
        return "Disclosure(identifier=" + this.f25390a + ", type=" + this.f25391b + ", maxAgeSeconds=" + this.f25392c + ", domain=" + this.f25393d + ", purposes=" + this.f25394e + ')';
    }
}
