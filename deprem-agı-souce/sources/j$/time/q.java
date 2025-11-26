package j$.time;

import j$.time.temporal.b;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public final class q implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final q f1169d = new q(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a  reason: collision with root package name */
    public final int f1170a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1171b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1172c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Object[] objArr = {b.YEARS, b.MONTHS, b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i5 = 0; i5 < 3; i5++) {
            arrayList.add(Objects.requireNonNull(objArr[i5]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public q(int i5, int i6, int i7) {
        this.f1170a = i5;
        this.f1171b = i6;
        this.f1172c = i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.f1170a == qVar.f1170a && this.f1171b == qVar.f1171b && this.f1172c == qVar.f1172c;
        }
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f1172c, 16) + Integer.rotateLeft(this.f1171b, 8) + this.f1170a;
    }

    public final String toString() {
        if (this == f1169d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i5 = this.f1170a;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('Y');
        }
        int i6 = this.f1171b;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        int i7 = this.f1172c;
        if (i7 != 0) {
            sb.append(i7);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
