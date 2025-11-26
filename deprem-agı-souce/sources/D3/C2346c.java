package d3;

import X2.C2236c;
import X2.C2242i;
import java.io.Serializable;
import kotlin.jvm.internal.t;

/* renamed from: d3.c  reason: case insensitive filesystem */
final class C2346c extends C2236c implements C2344a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final Enum[] f21427a;

    public C2346c(Enum[] enumArr) {
        t.e(enumArr, "entries");
        this.f21427a = enumArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return g((Enum) obj);
    }

    public boolean g(Enum enumR) {
        t.e(enumR, "element");
        if (((Enum) C2242i.T(this.f21427a, enumR.ordinal())) == enumR) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return this.f21427a.length;
    }

    /* renamed from: i */
    public Enum get(int i5) {
        C2236c.Companion.b(i5, this.f21427a.length);
        return this.f21427a[i5];
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return j((Enum) obj);
    }

    public int j(Enum enumR) {
        t.e(enumR, "element");
        int ordinal = enumR.ordinal();
        if (((Enum) C2242i.T(this.f21427a, ordinal)) == enumR) {
            return ordinal;
        }
        return -1;
    }

    public int k(Enum enumR) {
        t.e(enumR, "element");
        return indexOf(enumR);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return k((Enum) obj);
    }
}
