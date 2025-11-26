package j$.time.chrono;

import j$.time.temporal.b;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: j$.time.chrono.h  reason: case insensitive filesystem */
public final class C0462h implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f1045e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a  reason: collision with root package name */
    public final l f1046a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1047b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1048c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1049d;

    static {
        Object[] objArr = {b.YEARS, b.MONTHS, b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i5 = 0; i5 < 3; i5++) {
            arrayList.add(Objects.requireNonNull(objArr[i5]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public C0462h(l lVar, int i5, int i6, int i7) {
        Objects.requireNonNull(lVar, "chrono");
        this.f1046a = lVar;
        this.f1047b = i5;
        this.f1048c = i6;
        this.f1049d = i7;
    }

    public final String toString() {
        if (this.f1047b == 0 && this.f1048c == 0 && this.f1049d == 0) {
            String lVar = this.f1046a.toString();
            return lVar + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1046a.toString());
        sb.append(" P");
        int i5 = this.f1047b;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('Y');
        }
        int i6 = this.f1048c;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('M');
        }
        int i7 = this.f1049d;
        if (i7 != 0) {
            sb.append(i7);
            sb.append('D');
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0462h) {
            C0462h hVar = (C0462h) obj;
            return this.f1047b == hVar.f1047b && this.f1048c == hVar.f1048c && this.f1049d == hVar.f1049d && this.f1046a.equals(hVar.f1046a);
        }
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f1049d, 16) + (Integer.rotateLeft(this.f1048c, 8) + this.f1047b)) ^ this.f1046a.hashCode();
    }

    public Object writeReplace() {
        return new E((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
