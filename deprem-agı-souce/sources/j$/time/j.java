package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class j implements m, o, Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final j f1150e;

    /* renamed from: f  reason: collision with root package name */
    public static final j f1151f = new j(23, 59, 59, 999999999);

    /* renamed from: g  reason: collision with root package name */
    public static final j f1152g;

    /* renamed from: h  reason: collision with root package name */
    public static final j[] f1153h = new j[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a  reason: collision with root package name */
    public final byte f1154a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f1155b;

    /* renamed from: c  reason: collision with root package name */
    public final byte f1156c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1157d;

    static {
        int i5 = 0;
        while (true) {
            j[] jVarArr = f1153h;
            if (i5 < jVarArr.length) {
                jVarArr[i5] = new j(i5, 0, 0, 0);
                i5++;
            } else {
                j jVar = jVarArr[0];
                f1152g = jVar;
                j jVar2 = jVarArr[12];
                f1150e = jVar;
                return;
            }
        }
    }

    public static j z(long j5) {
        a.NANO_OF_DAY.k(j5);
        int i5 = (int) (j5 / 3600000000000L);
        long j6 = j5 - (((long) i5) * 3600000000000L);
        int i6 = (int) (j6 / 60000000000L);
        long j7 = j6 - (((long) i6) * 60000000000L);
        int i7 = (int) (j7 / C.NANOS_PER_SECOND);
        return w(i5, i6, i7, (int) (j7 - (((long) i7) * C.NANOS_PER_SECOND)));
    }

    public static j x(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        j jVar = (j) nVar.h(r.f1205g);
        if (jVar != null) {
            return jVar;
        }
        String name = nVar.getClass().getName();
        throw new RuntimeException("Unable to obtain LocalTime from TemporalAccessor: " + nVar + " of type " + name);
    }

    public static j w(int i5, int i6, int i7, int i8) {
        if ((i6 | i7 | i8) == 0) {
            return f1153h[i5];
        }
        return new j(i5, i6, i7, i8);
    }

    public j(int i5, int i6, int i7, int i8) {
        this.f1154a = (byte) i5;
        this.f1155b = (byte) i6;
        this.f1156c = (byte) i7;
        this.f1157d = i8;
    }

    public final boolean c(q qVar) {
        if (qVar instanceof a) {
            return ((a) qVar).n();
        }
        return qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        return r.d(this, qVar);
    }

    public final int e(q qVar) {
        if (qVar instanceof a) {
            return y(qVar);
        }
        return r.a(this, qVar);
    }

    public final long q(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        if (qVar == a.NANO_OF_DAY) {
            return G();
        }
        if (qVar == a.MICRO_OF_DAY) {
            return G() / 1000;
        }
        return (long) y(qVar);
    }

    public final int y(q qVar) {
        switch (i.f1148a[((a) qVar).ordinal()]) {
            case 1:
                return this.f1157d;
            case 2:
                throw new RuntimeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f1157d / 1000;
            case 4:
                throw new RuntimeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f1157d / 1000000;
            case 6:
                return (int) (G() / 1000000);
            case 7:
                return this.f1156c;
            case 8:
                return H();
            case 9:
                return this.f1155b;
            case 10:
                return (this.f1154a * 60) + this.f1155b;
            case 11:
                return this.f1154a % 12;
            case 12:
                int i5 = this.f1154a % 12;
                if (i5 % 12 == 0) {
                    return 12;
                }
                return i5;
            case 13:
                return this.f1154a;
            case 14:
                byte b5 = this.f1154a;
                if (b5 == 0) {
                    return 24;
                }
                return b5;
            case 15:
                return this.f1154a / 12;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: I */
    public final j a(long j5, q qVar) {
        if (!(qVar instanceof a)) {
            return (j) qVar.h(this, j5);
        }
        a aVar = (a) qVar;
        aVar.k(j5);
        switch (i.f1148a[aVar.ordinal()]) {
            case 1:
                return J((int) j5);
            case 2:
                return z(j5);
            case 3:
                return J(((int) j5) * 1000);
            case 4:
                return z(j5 * 1000);
            case 5:
                return J(((int) j5) * 1000000);
            case 6:
                return z(j5 * 1000000);
            case 7:
                int i5 = (int) j5;
                if (this.f1156c != i5) {
                    a.SECOND_OF_MINUTE.k((long) i5);
                    return w(this.f1154a, this.f1155b, i5, this.f1157d);
                }
                break;
            case 8:
                return E(j5 - ((long) H()));
            case 9:
                int i6 = (int) j5;
                if (this.f1155b != i6) {
                    a.MINUTE_OF_HOUR.k((long) i6);
                    return w(this.f1154a, i6, this.f1156c, this.f1157d);
                }
                break;
            case 10:
                return C(j5 - ((long) ((this.f1154a * 60) + this.f1155b)));
            case 11:
                return B(j5 - ((long) (this.f1154a % 12)));
            case 12:
                if (j5 == 12) {
                    j5 = 0;
                }
                return B(j5 - ((long) (this.f1154a % 12)));
            case 13:
                int i7 = (int) j5;
                if (this.f1154a != i7) {
                    a.HOUR_OF_DAY.k((long) i7);
                    return w(i7, this.f1155b, this.f1156c, this.f1157d);
                }
                break;
            case 14:
                if (j5 == 24) {
                    j5 = 0;
                }
                int i8 = (int) j5;
                if (this.f1154a != i8) {
                    a.HOUR_OF_DAY.k((long) i8);
                    return w(i8, this.f1155b, this.f1156c, this.f1157d);
                }
                break;
            case 15:
                return B((j5 - ((long) (this.f1154a / 12))) * 12);
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return this;
    }

    public final j J(int i5) {
        if (this.f1157d == i5) {
            return this;
        }
        a.NANO_OF_SECOND.k((long) i5);
        return w(this.f1154a, this.f1155b, this.f1156c, i5);
    }

    /* renamed from: A */
    public final j b(long j5, s sVar) {
        if (!(sVar instanceof b)) {
            return (j) sVar.e(this, j5);
        }
        switch (i.f1149b[((b) sVar).ordinal()]) {
            case 1:
                return D(j5);
            case 2:
                return D((j5 % 86400000000L) * 1000);
            case 3:
                return D((j5 % 86400000) * 1000000);
            case 4:
                return E(j5);
            case 5:
                return C(j5);
            case 6:
                return B(j5);
            case 7:
                return B((j5 % 2) * 12);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final j B(long j5) {
        if (j5 == 0) {
            return this;
        }
        return w(((((int) (j5 % 24)) + this.f1154a) + 24) % 24, this.f1155b, this.f1156c, this.f1157d);
    }

    public final j C(long j5) {
        if (j5 != 0) {
            int i5 = (this.f1154a * 60) + this.f1155b;
            int i6 = ((((int) (j5 % 1440)) + i5) + 1440) % 1440;
            if (i5 != i6) {
                return w(i6 / 60, i6 % 60, this.f1156c, this.f1157d);
            }
        }
        return this;
    }

    public final j E(long j5) {
        if (j5 != 0) {
            int i5 = (this.f1155b * 60) + (this.f1154a * 3600) + this.f1156c;
            int i6 = ((((int) (j5 % 86400)) + i5) + 86400) % 86400;
            if (i5 != i6) {
                return w(i6 / 3600, (i6 / 60) % 60, i6 % 60, this.f1157d);
            }
        }
        return this;
    }

    public final j D(long j5) {
        if (j5 != 0) {
            long G4 = G();
            long j6 = (((j5 % 86400000000000L) + G4) + 86400000000000L) % 86400000000000L;
            if (G4 != j6) {
                return w((int) (j6 / 3600000000000L), (int) ((j6 / 60000000000L) % 60), (int) ((j6 / C.NANOS_PER_SECOND) % 60), (int) (j6 % C.NANOS_PER_SECOND));
            }
        }
        return this;
    }

    public final m n(long j5, b bVar) {
        return j5 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1, bVar) : b(-j5, bVar);
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1200b || aVar == r.f1199a || aVar == r.f1203e || aVar == r.f1202d) {
            return null;
        }
        if (aVar == r.f1205g) {
            return this;
        }
        if (aVar == r.f1204f) {
            return null;
        }
        if (aVar == r.f1201c) {
            return b.NANOS;
        }
        return aVar.a(this);
    }

    public final m k(m mVar) {
        return mVar.a(G(), a.NANO_OF_DAY);
    }

    public final int H() {
        return (this.f1155b * 60) + (this.f1154a * 3600) + this.f1156c;
    }

    public final long G() {
        return (((long) this.f1156c) * C.NANOS_PER_SECOND) + (((long) this.f1155b) * 60000000000L) + (((long) this.f1154a) * 3600000000000L) + ((long) this.f1157d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = java.lang.Integer.compare(r2.f1155b, r3.f1155b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = java.lang.Integer.compare(r2.f1156c, r3.f1156c);
     */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compareTo(j$.time.j r3) {
        /*
            r2 = this;
            byte r0 = r2.f1154a
            byte r1 = r3.f1154a
            int r0 = java.lang.Integer.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
            byte r0 = r2.f1155b
            byte r1 = r3.f1155b
            int r0 = java.lang.Integer.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
            byte r0 = r2.f1156c
            byte r1 = r3.f1156c
            int r0 = java.lang.Integer.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
            int r0 = r2.f1157d
            int r3 = r3.f1157d
            int r3 = java.lang.Integer.compare(r0, r3)
            return r3
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.j.compareTo(j$.time.j):int");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return this.f1154a == jVar.f1154a && this.f1155b == jVar.f1155b && this.f1156c == jVar.f1156c && this.f1157d == jVar.f1157d;
        }
    }

    public final m f(g gVar) {
        return (j) j$.com.android.tools.r8.a.a(gVar, this);
    }

    public final int hashCode() {
        long G4 = G();
        return (int) (G4 ^ (G4 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b5 = this.f1154a;
        byte b6 = this.f1155b;
        byte b7 = this.f1156c;
        int i5 = this.f1157d;
        sb.append(b5 < 10 ? "0" : "");
        sb.append(b5);
        String str = ":";
        sb.append(b6 < 10 ? ":0" : str);
        sb.append(b6);
        if (b7 > 0 || i5 > 0) {
            if (b7 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append(b7);
            if (i5 > 0) {
                sb.append('.');
                if (i5 % 1000000 == 0) {
                    sb.append(Integer.toString((i5 / 1000000) + 1000).substring(1));
                } else if (i5 % 1000 == 0) {
                    sb.append(Integer.toString((i5 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i5 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void K(DataOutput dataOutput) {
        if (this.f1157d != 0) {
            dataOutput.writeByte(this.f1154a);
            dataOutput.writeByte(this.f1155b);
            dataOutput.writeByte(this.f1156c);
            dataOutput.writeInt(this.f1157d);
        } else if (this.f1156c != 0) {
            dataOutput.writeByte(this.f1154a);
            dataOutput.writeByte(this.f1155b);
            dataOutput.writeByte(~this.f1156c);
        } else if (this.f1155b == 0) {
            dataOutput.writeByte(~this.f1154a);
        } else {
            dataOutput.writeByte(this.f1154a);
            dataOutput.writeByte(~this.f1155b);
        }
    }

    public static j F(DataInput dataInput) {
        int i5;
        int i6;
        int readByte = dataInput.readByte();
        byte b5 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i5 = 0;
            i6 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i7 = ~readByte2;
                i6 = 0;
                b5 = i7;
                i5 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i5 = ~readByte3;
                    byte b6 = readByte2;
                    i6 = 0;
                    b5 = b6;
                } else {
                    int readInt = dataInput.readInt();
                    byte b7 = readByte2;
                    i6 = readInt;
                    b5 = b7;
                    i5 = readByte3;
                }
            }
        }
        a.HOUR_OF_DAY.k((long) readByte);
        a.MINUTE_OF_HOUR.k((long) b5);
        a.SECOND_OF_MINUTE.k((long) i5);
        a.NANO_OF_SECOND.k((long) i6);
        return w(readByte, b5, i5, i6);
    }
}
