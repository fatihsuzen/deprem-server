package j$.time.zone;

import j$.com.android.tools.r8.a;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.d;
import j$.time.g;
import j$.time.j;
import j$.time.l;
import j$.time.temporal.p;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public final class f implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    public static final long[] f1237i = new long[0];

    /* renamed from: j  reason: collision with root package name */
    public static final e[] f1238j = new e[0];

    /* renamed from: k  reason: collision with root package name */
    public static final LocalDateTime[] f1239k = new LocalDateTime[0];

    /* renamed from: l  reason: collision with root package name */
    public static final b[] f1240l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a  reason: collision with root package name */
    public final long[] f1241a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset[] f1242b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f1243c;

    /* renamed from: d  reason: collision with root package name */
    public final LocalDateTime[] f1244d;

    /* renamed from: e  reason: collision with root package name */
    public final ZoneOffset[] f1245e;

    /* renamed from: f  reason: collision with root package name */
    public final e[] f1246f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeZone f1247g;

    /* renamed from: h  reason: collision with root package name */
    public final transient ConcurrentHashMap f1248h = new ConcurrentHashMap();

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.f1223b;
        if (bVar.e()) {
            if (localDateTime.x(localDateTime2)) {
                return bVar.f1224c;
            }
            if (!localDateTime.x(bVar.f1223b.B((long) (bVar.f1225d.f1021b - bVar.f1224c.f1021b)))) {
                return bVar.f1225d;
            }
        } else if (!localDateTime.x(localDateTime2)) {
            return bVar.f1225d;
        } else {
            if (localDateTime.x(bVar.f1223b.B((long) (bVar.f1225d.f1021b - bVar.f1224c.f1021b)))) {
                return bVar.f1224c;
            }
        }
        return bVar;
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f1241a = jArr;
        this.f1242b = zoneOffsetArr;
        this.f1243c = jArr2;
        this.f1245e = zoneOffsetArr2;
        this.f1246f = eVarArr;
        if (jArr2.length == 0) {
            this.f1244d = f1239k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (i5 < jArr2.length) {
                int i6 = i5 + 1;
                b bVar = new b(jArr2[i5], zoneOffsetArr2[i5], zoneOffsetArr2[i6]);
                if (bVar.e()) {
                    arrayList.add(bVar.f1223b);
                    arrayList.add(bVar.f1223b.B((long) (bVar.f1225d.f1021b - bVar.f1224c.f1021b)));
                } else {
                    arrayList.add(bVar.f1223b.B((long) (bVar.f1225d.f1021b - bVar.f1224c.f1021b)));
                    arrayList.add(bVar.f1223b);
                }
                i5 = i6;
            }
            this.f1244d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f1247g = null;
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f1242b = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        long[] jArr = f1237i;
        this.f1241a = jArr;
        this.f1243c = jArr;
        this.f1244d = f1239k;
        this.f1245e = zoneOffsetArr;
        this.f1246f = f1238j;
        this.f1247g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f1242b = zoneOffsetArr;
        zoneOffsetArr[0] = g(timeZone.getRawOffset());
        long[] jArr = f1237i;
        this.f1241a = jArr;
        this.f1243c = jArr;
        this.f1244d = f1239k;
        this.f1245e = zoneOffsetArr;
        this.f1246f = f1238j;
        this.f1247g = timeZone;
    }

    public static ZoneOffset g(int i5) {
        return ZoneOffset.C(i5 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f1247g != null ? (byte) 100 : 1, this);
    }

    public static int c(long j5, ZoneOffset zoneOffset) {
        return g.E(a.B(j5 + ((long) zoneOffset.f1021b), (long) 86400)).f1144a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f1247g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f1243c;
        if (jArr.length == 0) {
            return this.f1242b[0];
        }
        long j5 = instant.f1007a;
        if (this.f1246f.length <= 0 || j5 <= jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, j5);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return this.f1245e[binarySearch + 1];
        }
        ZoneOffset[] zoneOffsetArr = this.f1245e;
        b[] b5 = b(c(j5, zoneOffsetArr[zoneOffsetArr.length - 1]));
        b bVar = null;
        for (int i5 = 0; i5 < b5.length; i5++) {
            bVar = b5[i5];
            if (j5 < bVar.f1222a) {
                return bVar.f1224c;
            }
        }
        return bVar.f1225d;
    }

    public final List f(LocalDateTime localDateTime) {
        Object e5 = e(localDateTime);
        if (!(e5 instanceof b)) {
            return Collections.singletonList((ZoneOffset) e5);
        }
        b bVar = (b) e5;
        if (bVar.e()) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {bVar.f1224c, bVar.f1225d};
        ArrayList arrayList = new ArrayList(2);
        for (int i5 = 0; i5 < 2; i5++) {
            arrayList.add(Objects.requireNonNull(objArr[i5]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r8.v(r0) > 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        if (r8.f1012b.G() <= r0.f1012b.G()) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(j$.time.LocalDateTime r8) {
        /*
            r7 = this;
            java.util.TimeZone r0 = r7.f1247g
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0043
            j$.time.g r0 = r8.f1011a
            int r0 = r0.f1144a
            j$.time.zone.b[] r0 = r7.b(r0)
            int r3 = r0.length
            if (r3 != 0) goto L_0x0027
            java.util.TimeZone r0 = r7.f1247g
            j$.time.ZoneOffset[] r1 = r7.f1242b
            r1 = r1[r2]
            long r1 = j$.com.android.tools.r8.a.t(r8, r1)
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            int r8 = r0.getOffset(r1)
            j$.time.ZoneOffset r8 = g(r8)
            return r8
        L_0x0027:
            int r3 = r0.length
        L_0x0028:
            if (r2 >= r3) goto L_0x0042
            r1 = r0[r2]
            java.lang.Object r4 = a(r8, r1)
            boolean r5 = r4 instanceof j$.time.zone.b
            if (r5 != 0) goto L_0x0041
            j$.time.ZoneOffset r1 = r1.f1224c
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            int r2 = r2 + 1
            r1 = r4
            goto L_0x0028
        L_0x0041:
            return r4
        L_0x0042:
            return r1
        L_0x0043:
            long[] r0 = r7.f1243c
            int r0 = r0.length
            if (r0 != 0) goto L_0x004d
            j$.time.ZoneOffset[] r8 = r7.f1242b
            r8 = r8[r2]
            return r8
        L_0x004d:
            j$.time.zone.e[] r0 = r7.f1246f
            int r0 = r0.length
            if (r0 <= 0) goto L_0x00ab
            j$.time.LocalDateTime[] r0 = r7.f1244d
            int r3 = r0.length
            int r3 = r3 + -1
            r0 = r0[r3]
            if (r0 == 0) goto L_0x0065
            r8.getClass()
            int r0 = r8.v(r0)
            if (r0 <= 0) goto L_0x00ab
            goto L_0x0087
        L_0x0065:
            j$.time.g r3 = r8.f1011a
            long r3 = r3.r()
            j$.time.g r5 = r0.f1011a
            long r5 = r5.r()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0087
            if (r3 != 0) goto L_0x00ab
            j$.time.j r3 = r8.f1012b
            long r3 = r3.G()
            j$.time.j r0 = r0.f1012b
            long r5 = r0.G()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ab
        L_0x0087:
            j$.time.g r0 = r8.f1011a
            int r0 = r0.f1144a
            j$.time.zone.b[] r0 = r7.b(r0)
            int r3 = r0.length
        L_0x0090:
            if (r2 >= r3) goto L_0x00aa
            r1 = r0[r2]
            java.lang.Object r4 = a(r8, r1)
            boolean r5 = r4 instanceof j$.time.zone.b
            if (r5 != 0) goto L_0x00a9
            j$.time.ZoneOffset r1 = r1.f1224c
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x00a5
            goto L_0x00a9
        L_0x00a5:
            int r2 = r2 + 1
            r1 = r4
            goto L_0x0090
        L_0x00a9:
            return r4
        L_0x00aa:
            return r1
        L_0x00ab:
            j$.time.LocalDateTime[] r0 = r7.f1244d
            int r8 = java.util.Arrays.binarySearch(r0, r8)
            r0 = -1
            if (r8 != r0) goto L_0x00b9
            j$.time.ZoneOffset[] r8 = r7.f1245e
            r8 = r8[r2]
            return r8
        L_0x00b9:
            if (r8 >= 0) goto L_0x00bf
            int r8 = -r8
            int r8 = r8 + -2
            goto L_0x00d3
        L_0x00bf:
            j$.time.LocalDateTime[] r0 = r7.f1244d
            int r1 = r0.length
            int r1 = r1 + -1
            if (r8 >= r1) goto L_0x00d3
            r1 = r0[r8]
            int r2 = r8 + 1
            r0 = r0[r2]
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00d3
            r8 = r2
        L_0x00d3:
            r0 = r8 & 1
            if (r0 != 0) goto L_0x00fb
            j$.time.LocalDateTime[] r0 = r7.f1244d
            r1 = r0[r8]
            int r2 = r8 + 1
            r0 = r0[r2]
            j$.time.ZoneOffset[] r2 = r7.f1245e
            int r8 = r8 / 2
            r3 = r2[r8]
            int r8 = r8 + 1
            r8 = r2[r8]
            int r2 = r8.f1021b
            int r4 = r3.f1021b
            if (r2 <= r4) goto L_0x00f5
            j$.time.zone.b r0 = new j$.time.zone.b
            r0.<init>((j$.time.LocalDateTime) r1, (j$.time.ZoneOffset) r3, (j$.time.ZoneOffset) r8)
            return r0
        L_0x00f5:
            j$.time.zone.b r1 = new j$.time.zone.b
            r1.<init>((j$.time.LocalDateTime) r0, (j$.time.ZoneOffset) r3, (j$.time.ZoneOffset) r8)
            return r1
        L_0x00fb:
            j$.time.ZoneOffset[] r0 = r7.f1245e
            int r8 = r8 / 2
            int r8 = r8 + 1
            r8 = r0[r8]
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    public final b[] b(int i5) {
        g gVar;
        int i6 = i5;
        b[] bVarArr = f1240l;
        Integer valueOf = Integer.valueOf(i6);
        b[] bVarArr2 = (b[]) this.f1248h.get(valueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j5 = 1;
        int i7 = 0;
        if (this.f1247g == null) {
            e[] eVarArr = this.f1246f;
            b[] bVarArr3 = new b[eVarArr.length];
            int i8 = 0;
            while (i8 < eVarArr.length) {
                e eVar = eVarArr[i8];
                byte b5 = eVar.f1229b;
                if (b5 < 0) {
                    l lVar = eVar.f1228a;
                    long j6 = (long) i6;
                    s.f1072c.getClass();
                    int w4 = lVar.w(s.f(j6)) + 1 + eVar.f1229b;
                    g gVar2 = g.f1142d;
                    j$.time.temporal.a.YEAR.k(j6);
                    Objects.requireNonNull(lVar, "month");
                    j$.time.temporal.a.DAY_OF_MONTH.k((long) w4);
                    gVar = g.w(i6, lVar.getValue(), w4);
                    d dVar = eVar.f1230c;
                    if (dVar != null) {
                        gVar = gVar.f(new p(dVar.getValue(), 1));
                    }
                } else {
                    l lVar2 = eVar.f1228a;
                    g gVar3 = g.f1142d;
                    j$.time.temporal.a.YEAR.k((long) i6);
                    Objects.requireNonNull(lVar2, "month");
                    j$.time.temporal.a.DAY_OF_MONTH.k((long) b5);
                    gVar = g.w(i6, lVar2.getValue(), b5);
                    d dVar2 = eVar.f1230c;
                    if (dVar2 != null) {
                        gVar = gVar.f(new p(dVar2.getValue(), i7));
                    }
                }
                if (eVar.f1232e) {
                    gVar = gVar.G(1);
                }
                LocalDateTime y4 = LocalDateTime.y(gVar, eVar.f1231d);
                d dVar3 = eVar.f1233f;
                ZoneOffset zoneOffset = eVar.f1234g;
                ZoneOffset zoneOffset2 = eVar.f1235h;
                dVar3.getClass();
                int i9 = c.f1226a[dVar3.ordinal()];
                if (i9 == 1) {
                    y4 = y4.B((long) (zoneOffset2.f1021b - ZoneOffset.UTC.f1021b));
                } else if (i9 == 2) {
                    y4 = y4.B((long) (zoneOffset2.f1021b - zoneOffset.f1021b));
                }
                bVarArr3[i8] = new b(y4, eVar.f1235h, eVar.f1236i);
                i8++;
                i7 = 0;
            }
            if (i6 < 2100) {
                this.f1248h.putIfAbsent(valueOf, bVarArr3);
            }
            return bVarArr3;
        } else if (i6 < 1800) {
            return bVarArr;
        } else {
            LocalDateTime localDateTime = LocalDateTime.f1009c;
            g D4 = g.D(i6 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.k((long) 0);
            long t5 = a.t(new LocalDateTime(D4, j.f1153h[0]), this.f1242b[0]);
            long j7 = 1000;
            int offset = this.f1247g.getOffset(t5 * 1000);
            long j8 = 31968000 + t5;
            while (t5 < j8) {
                long j9 = t5 + 7776000;
                long j10 = j7;
                if (offset != this.f1247g.getOffset(j9 * j10)) {
                    while (j9 - t5 > j5) {
                        long B4 = a.B(j9 + t5, 2);
                        if (this.f1247g.getOffset(B4 * j10) == offset) {
                            t5 = B4;
                        } else {
                            j9 = B4;
                        }
                        j5 = 1;
                    }
                    if (this.f1247g.getOffset(t5 * j10) == offset) {
                        t5 = j9;
                    }
                    ZoneOffset g5 = g(offset);
                    int offset2 = this.f1247g.getOffset(t5 * j10);
                    ZoneOffset g6 = g(offset2);
                    if (c(t5, g6) == i6) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(t5, g5, g6);
                    }
                    offset = offset2;
                } else {
                    t5 = j9;
                }
                j7 = j10;
                j5 = 1;
            }
            if (1916 <= i6 && i6 < 2100) {
                this.f1248h.putIfAbsent(valueOf, bVarArr);
            }
            return bVarArr;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return Objects.equals(this.f1247g, fVar.f1247g) && Arrays.equals(this.f1241a, fVar.f1241a) && Arrays.equals(this.f1242b, fVar.f1242b) && Arrays.equals(this.f1243c, fVar.f1243c) && Arrays.equals(this.f1245e, fVar.f1245e) && Arrays.equals(this.f1246f, fVar.f1246f);
        }
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f1247g) ^ Arrays.hashCode(this.f1241a)) ^ Arrays.hashCode(this.f1242b)) ^ Arrays.hashCode(this.f1243c)) ^ Arrays.hashCode(this.f1245e)) ^ Arrays.hashCode(this.f1246f);
    }

    public final String toString() {
        TimeZone timeZone = this.f1247g;
        if (timeZone != null) {
            String id = timeZone.getID();
            return "ZoneRules[timeZone=" + id + "]";
        }
        ZoneOffset[] zoneOffsetArr = this.f1242b;
        ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
        return "ZoneRules[currentStandardOffset=" + zoneOffset + "]";
    }
}
