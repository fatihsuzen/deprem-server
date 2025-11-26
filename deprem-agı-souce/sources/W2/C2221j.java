package W2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: W2.j  reason: case insensitive filesystem */
public final class C2221j implements Comparable {

    /* renamed from: e  reason: collision with root package name */
    public static final a f19951e = new a((C2633k) null);

    /* renamed from: f  reason: collision with root package name */
    public static final C2221j f19952f = C2222k.a();

    /* renamed from: a  reason: collision with root package name */
    private final int f19953a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19954b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19955c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19956d;

    /* renamed from: W2.j$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public C2221j(int i5, int i6, int i7) {
        this.f19953a = i5;
        this.f19954b = i6;
        this.f19955c = i7;
        this.f19956d = b(i5, i6, i7);
    }

    private final int b(int i5, int i6, int i7) {
        if (i5 >= 0 && i5 < 256 && i6 >= 0 && i6 < 256 && i7 >= 0 && i7 < 256) {
            return (i5 << 16) + (i6 << 8) + i7;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i5 + '.' + i6 + '.' + i7).toString());
    }

    /* renamed from: a */
    public int compareTo(C2221j jVar) {
        t.e(jVar, "other");
        return this.f19956d - jVar.f19956d;
    }

    public boolean equals(Object obj) {
        C2221j jVar;
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2221j) {
            jVar = (C2221j) obj;
        } else {
            jVar = null;
        }
        if (jVar != null && this.f19956d == jVar.f19956d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f19956d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f19953a);
        sb.append('.');
        sb.append(this.f19954b);
        sb.append('.');
        sb.append(this.f19955c);
        return sb.toString();
    }
}
