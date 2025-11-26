package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import j$.time.zone.f;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class ZoneOffset extends ZoneId implements n, o, Comparable<ZoneOffset>, Serializable {
    public static final ZoneOffset UTC = C(0);

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap f1017d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentHashMap f1018e = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: f  reason: collision with root package name */
    public static final ZoneOffset f1019f = C(-64800);

    /* renamed from: g  reason: collision with root package name */
    public static final ZoneOffset f1020g = C(64800);
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b  reason: collision with root package name */
    public final int f1021b;

    /* renamed from: c  reason: collision with root package name */
    public final transient String f1022c;

    public final int compareTo(Object obj) {
        return ((ZoneOffset) obj).f1021b - this.f1021b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.ZoneOffset A(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            j$.util.Objects.requireNonNull(r7, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = f1018e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0063
            r1 = 3
            if (r0 == r1) goto L_0x007f
            r4 = 5
            if (r0 == r4) goto L_0x005a
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L_0x0050
            r5 = 7
            if (r0 == r5) goto L_0x0043
            r1 = 9
            if (r0 != r1) goto L_0x0037
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r6, r2)
            int r2 = D(r7, r5, r2)
            goto L_0x0085
        L_0x0037:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L_0x0043:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r1, r3)
            int r2 = D(r7, r4, r3)
            goto L_0x0085
        L_0x0050:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r6, r2)
        L_0x0058:
            r2 = r3
            goto L_0x0085
        L_0x005a:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r1, r3)
            goto L_0x0058
        L_0x0063:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L_0x007f:
            int r0 = D(r7, r2, r3)
            r1 = r3
            r2 = r1
        L_0x0085:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L_0x009e
            if (r3 != r5) goto L_0x0092
            goto L_0x009e
        L_0x0092:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L_0x009e:
            if (r3 != r5) goto L_0x00a8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = B(r7, r0, r1)
            return r7
        L_0x00a8:
            j$.time.ZoneOffset r7 = B(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.A(java.lang.String):j$.time.ZoneOffset");
    }

    public final f v() {
        Objects.requireNonNull(this, TypedValues.CycleType.S_WAVE_OFFSET);
        return new f(this);
    }

    public static int D(CharSequence charSequence, int i5, boolean z4) {
        if (z4) {
            String str = (String) charSequence;
            if (str.charAt(i5 - 1) != ':') {
                throw new RuntimeException("Invalid ID for ZoneOffset, colon not found when expected: " + str);
            }
        }
        String str2 = (String) charSequence;
        char charAt = str2.charAt(i5);
        char charAt2 = str2.charAt(i5 + 1);
        if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
            throw new RuntimeException("Invalid ID for ZoneOffset, non numeric characters found: " + str2);
        }
        return (charAt2 - '0') + ((charAt - '0') * 10);
    }

    public static ZoneOffset B(int i5, int i6, int i7) {
        if (i5 < -18 || i5 > 18) {
            throw new RuntimeException("Zone offset hours not in valid range: value " + i5 + " is not in the range -18 to 18");
        }
        if (i5 > 0) {
            if (i6 < 0 || i7 < 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i5 < 0) {
            if (i6 > 0 || i7 > 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i6 > 0 && i7 < 0) || (i6 < 0 && i7 > 0)) {
            throw new RuntimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i6 < -59 || i6 > 59) {
            throw new RuntimeException("Zone offset minutes not in valid range: value " + i6 + " is not in the range -59 to 59");
        } else if (i7 < -59 || i7 > 59) {
            throw new RuntimeException("Zone offset seconds not in valid range: value " + i7 + " is not in the range -59 to 59");
        } else if (Math.abs(i5) != 18 || (i6 | i7) == 0) {
            return C((i6 * 60) + (i5 * 3600) + i7);
        } else {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset C(int i5) {
        if (i5 < -64800 || i5 > 64800) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i5 % 900 != 0) {
            return new ZoneOffset(i5);
        } else {
            Integer valueOf = Integer.valueOf(i5);
            ConcurrentHashMap concurrentHashMap = f1017d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i5));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
            f1018e.putIfAbsent(zoneOffset2.f1022c, zoneOffset2);
            return zoneOffset2;
        }
    }

    public ZoneOffset(int i5) {
        String str;
        this.f1021b = i5;
        if (i5 == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i5);
            StringBuilder sb = new StringBuilder();
            int i6 = abs / 3600;
            int i7 = (abs / 60) % 60;
            sb.append(i5 < 0 ? "-" : "+");
            sb.append(i6 < 10 ? "0" : "");
            sb.append(i6);
            String str2 = ":";
            sb.append(i7 < 10 ? ":0" : str2);
            sb.append(i7);
            int i8 = abs % 60;
            if (i8 != 0) {
                sb.append(i8 < 10 ? ":0" : str2);
                sb.append(i8);
            }
            str = sb.toString();
        }
        this.f1022c = str;
    }

    public final String d() {
        return this.f1022c;
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.OFFSET_SECONDS : qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        return r.d(this, qVar);
    }

    public final int e(q qVar) {
        if (qVar == a.OFFSET_SECONDS) {
            return this.f1021b;
        }
        if (!c.b(qVar)) {
            return r.d(this, qVar).a(q(qVar), qVar);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long q(q qVar) {
        if (qVar == a.OFFSET_SECONDS) {
            return (long) this.f1021b;
        }
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final Object h(j$.time.format.a aVar) {
        return (aVar == r.f1202d || aVar == r.f1203e) ? this : r.c(this, aVar);
    }

    public final m k(m mVar) {
        return mVar.a((long) this.f1021b, a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f1021b == ((ZoneOffset) obj).f1021b;
    }

    public final int hashCode() {
        return this.f1021b;
    }

    public final String toString() {
        return this.f1022c;
    }

    private Object writeReplace() {
        return new r((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void z(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        F(dataOutput);
    }

    public final void F(DataOutput dataOutput) {
        int i5 = this.f1021b;
        int i6 = i5 % 900 == 0 ? i5 / 900 : 127;
        dataOutput.writeByte(i6);
        if (i6 == 127) {
            dataOutput.writeInt(i5);
        }
    }

    public static ZoneOffset E(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? C(dataInput.readInt()) : C(readByte * 900);
    }
}
