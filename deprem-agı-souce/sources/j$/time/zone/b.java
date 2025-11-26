package j$.time.zone;

import j$.com.android.tools.r8.a;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class b implements Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f1221e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a  reason: collision with root package name */
    public final long f1222a;

    /* renamed from: b  reason: collision with root package name */
    public final LocalDateTime f1223b;

    /* renamed from: c  reason: collision with root package name */
    public final ZoneOffset f1224c;

    /* renamed from: d  reason: collision with root package name */
    public final ZoneOffset f1225d;

    static {
        Class<b> cls = b.class;
    }

    public final int compareTo(Object obj) {
        return Long.compare(this.f1222a, ((b) obj).f1222a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        localDateTime.getClass();
        this.f1222a = a.t(localDateTime, zoneOffset);
        this.f1223b = localDateTime;
        this.f1224c = zoneOffset;
        this.f1225d = zoneOffset2;
    }

    public b(long j5, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f1222a = j5;
        this.f1223b = LocalDateTime.z(j5, 0, zoneOffset);
        this.f1224c = zoneOffset;
        this.f1225d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean e() {
        return this.f1225d.f1021b > this.f1224c.f1021b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f1222a == bVar.f1222a && this.f1224c.equals(bVar.f1224c) && this.f1225d.equals(bVar.f1225d);
        }
    }

    public final int hashCode() {
        return (this.f1223b.hashCode() ^ this.f1224c.f1021b) ^ Integer.rotateLeft(this.f1225d.f1021b, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(e() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f1223b);
        sb.append(this.f1224c);
        sb.append(" to ");
        sb.append(this.f1225d);
        sb.append(']');
        return sb.toString();
    }
}
