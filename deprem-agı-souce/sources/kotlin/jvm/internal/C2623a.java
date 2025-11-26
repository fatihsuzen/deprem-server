package kotlin.jvm.internal;

import java.io.Serializable;

/* renamed from: kotlin.jvm.internal.a  reason: case insensitive filesystem */
public class C2623a implements C2637o, Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f24696a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f24697b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24698c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24699d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f24700e;

    /* renamed from: f  reason: collision with root package name */
    private final int f24701f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24702g;

    public C2623a(int i5, Object obj, Class cls, String str, String str2, int i6) {
        boolean z4;
        this.f24696a = obj;
        this.f24697b = cls;
        this.f24698c = str;
        this.f24699d = str2;
        if ((i6 & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f24700e = z4;
        this.f24701f = i5;
        this.f24702g = i6 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2623a)) {
            return false;
        }
        C2623a aVar = (C2623a) obj;
        if (this.f24700e != aVar.f24700e || this.f24701f != aVar.f24701f || this.f24702g != aVar.f24702g || !t.a(this.f24696a, aVar.f24696a) || !t.a(this.f24697b, aVar.f24697b) || !this.f24698c.equals(aVar.f24698c) || !this.f24699d.equals(aVar.f24699d)) {
            return false;
        }
        return true;
    }

    public int getArity() {
        return this.f24701f;
    }

    public int hashCode() {
        int i5;
        int i6;
        Object obj = this.f24696a;
        int i7 = 0;
        if (obj != null) {
            i5 = obj.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = i5 * 31;
        Class cls = this.f24697b;
        if (cls != null) {
            i7 = cls.hashCode();
        }
        int hashCode = (((((i8 + i7) * 31) + this.f24698c.hashCode()) * 31) + this.f24699d.hashCode()) * 31;
        if (this.f24700e) {
            i6 = 1231;
        } else {
            i6 = 1237;
        }
        return ((((hashCode + i6) * 31) + this.f24701f) * 31) + this.f24702g;
    }

    public String toString() {
        return M.h(this);
    }
}
