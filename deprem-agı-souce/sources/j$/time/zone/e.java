package j$.time.zone;

import androidx.work.WorkInfo;
import j$.time.ZoneOffset;
import j$.time.d;
import j$.time.j;
import j$.time.l;
import j$.time.temporal.a;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a  reason: collision with root package name */
    public final l f1228a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f1229b;

    /* renamed from: c  reason: collision with root package name */
    public final d f1230c;

    /* renamed from: d  reason: collision with root package name */
    public final j f1231d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1232e;

    /* renamed from: f  reason: collision with root package name */
    public final d f1233f;

    /* renamed from: g  reason: collision with root package name */
    public final ZoneOffset f1234g;

    /* renamed from: h  reason: collision with root package name */
    public final ZoneOffset f1235h;

    /* renamed from: i  reason: collision with root package name */
    public final ZoneOffset f1236i;

    static {
        Class<e> cls = e.class;
    }

    public e(l lVar, int i5, d dVar, j jVar, boolean z4, d dVar2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f1228a = lVar;
        this.f1229b = (byte) i5;
        this.f1230c = dVar;
        this.f1231d = jVar;
        this.f1232e = z4;
        this.f1233f = dVar2;
        this.f1234g = zoneOffset;
        this.f1235h = zoneOffset2;
        this.f1236i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        byte b5;
        int i5;
        int i6;
        int H4 = this.f1232e ? 86400 : this.f1231d.H();
        int i7 = this.f1234g.f1021b;
        int i8 = this.f1235h.f1021b - i7;
        int i9 = this.f1236i.f1021b - i7;
        if (H4 % 3600 == 0) {
            b5 = this.f1232e ? 24 : this.f1231d.f1154a;
        } else {
            b5 = 31;
        }
        int i10 = i7 % 900 == 0 ? (i7 / 900) + 128 : 255;
        if (i8 == 0 || i8 == 1800 || i8 == 3600) {
            i5 = i8 / 1800;
        } else {
            i5 = 3;
        }
        if (i9 == 0 || i9 == 1800 || i9 == 3600) {
            i6 = i9 / 1800;
        } else {
            i6 = 3;
        }
        d dVar = this.f1230c;
        dataOutput.writeInt((this.f1228a.getValue() << 28) + ((this.f1229b + 32) << 22) + ((dVar == null ? 0 : dVar.getValue()) << 19) + (b5 << 14) + (this.f1233f.ordinal() << 12) + (i10 << 4) + (i5 << 2) + i6);
        if (b5 == 31) {
            dataOutput.writeInt(H4);
        }
        if (i10 == 255) {
            dataOutput.writeInt(i7);
        }
        if (i5 == 3) {
            dataOutput.writeInt(this.f1235h.f1021b);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.f1236i.f1021b);
        }
    }

    public static e a(DataInput dataInput) {
        d v5;
        d dVar;
        j jVar;
        int i5;
        int i6;
        int readInt = dataInput.readInt();
        l y4 = l.y(readInt >>> 28);
        int i7 = ((264241152 & readInt) >>> 22) - 32;
        int i8 = (3670016 & readInt) >>> 19;
        if (i8 == 0) {
            v5 = null;
        } else {
            v5 = d.v(i8);
        }
        d dVar2 = v5;
        int i9 = (507904 & readInt) >>> 14;
        d dVar3 = d.values()[(readInt & 12288) >>> 12];
        int i10 = (readInt & 4080) >>> 4;
        int i11 = (readInt & 12) >>> 2;
        int i12 = readInt & 3;
        boolean z4 = false;
        if (i9 == 31) {
            long readInt2 = (long) dataInput.readInt();
            j jVar2 = j.f1150e;
            a.SECOND_OF_DAY.k(readInt2);
            int i13 = (int) (readInt2 / 3600);
            long j5 = readInt2 - ((long) (i13 * 3600));
            int i14 = (int) (j5 / 60);
            dVar = dVar3;
            jVar = j.w(i13, i14, (int) (j5 - ((long) (i14 * 60))), 0);
        } else {
            dVar = dVar3;
            int i15 = i9 % 24;
            j jVar3 = j.f1150e;
            a.HOUR_OF_DAY.k((long) i15);
            jVar = j.f1153h[i15];
        }
        ZoneOffset C4 = ZoneOffset.C(i10 == 255 ? dataInput.readInt() : (i10 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) * 900);
        if (i11 == 3) {
            i5 = dataInput.readInt();
        } else {
            i5 = (i11 * 1800) + C4.f1021b;
        }
        ZoneOffset C5 = ZoneOffset.C(i5);
        if (i12 == 3) {
            i6 = dataInput.readInt();
        } else {
            i6 = (i12 * 1800) + C4.f1021b;
        }
        ZoneOffset C6 = ZoneOffset.C(i6);
        if (i9 == 24) {
            z4 = true;
        }
        Objects.requireNonNull(y4, "month");
        Objects.requireNonNull(jVar, "time");
        d dVar4 = dVar;
        Objects.requireNonNull(dVar4, "timeDefnition");
        Objects.requireNonNull(C4, "standardOffset");
        Objects.requireNonNull(C5, "offsetBefore");
        Objects.requireNonNull(C6, "offsetAfter");
        if (i7 < -28 || i7 > 31 || i7 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (z4 && !jVar.equals(j.f1152g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        } else if (jVar.f1157d == 0) {
            return new e(y4, i7, dVar2, jVar, z4, dVar4, C4, C5, C6);
        } else {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f1228a == eVar.f1228a && this.f1229b == eVar.f1229b && this.f1230c == eVar.f1230c && this.f1233f == eVar.f1233f && this.f1231d.equals(eVar.f1231d) && this.f1232e == eVar.f1232e && this.f1234g.equals(eVar.f1234g) && this.f1235h.equals(eVar.f1235h) && this.f1236i.equals(eVar.f1236i);
        }
    }

    public final int hashCode() {
        int H4 = ((this.f1231d.H() + (this.f1232e ? 1 : 0)) << 15) + (this.f1228a.ordinal() << 11) + ((this.f1229b + 32) << 5);
        d dVar = this.f1230c;
        return ((this.f1234g.f1021b ^ (this.f1233f.ordinal() + (H4 + ((dVar == null ? 7 : dVar.ordinal()) << 2)))) ^ this.f1235h.f1021b) ^ this.f1236i.f1021b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.f1236i.f1021b - this.f1235h.f1021b > 0 ? "Gap " : "Overlap ");
        sb.append(this.f1235h);
        sb.append(" to ");
        sb.append(this.f1236i);
        sb.append(", ");
        d dVar = this.f1230c;
        if (dVar != null) {
            byte b5 = this.f1229b;
            if (b5 == -1) {
                sb.append(dVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.f1228a.name());
            } else if (b5 < 0) {
                sb.append(dVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.f1229b) - 1);
                sb.append(" of ");
                sb.append(this.f1228a.name());
            } else {
                sb.append(dVar.name());
                sb.append(" on or after ");
                sb.append(this.f1228a.name());
                sb.append(' ');
                sb.append(this.f1229b);
            }
        } else {
            sb.append(this.f1228a.name());
            sb.append(' ');
            sb.append(this.f1229b);
        }
        sb.append(" at ");
        sb.append(this.f1232e ? "24:00" : this.f1231d.toString());
        sb.append(" ");
        sb.append(this.f1233f);
        sb.append(", standard offset ");
        sb.append(this.f1234g);
        sb.append(']');
        return sb.toString();
    }
}
