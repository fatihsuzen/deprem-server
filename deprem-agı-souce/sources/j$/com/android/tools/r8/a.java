package j$.com.android.tools.r8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.ZoneOffset;
import j$.time.c;
import j$.time.chrono.C0455a;
import j$.time.chrono.C0456b;
import j$.time.chrono.C0459e;
import j$.time.chrono.C0463i;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.m;
import j$.time.chrono.s;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.util.Objects;
import j$.util.concurrent.l;
import j$.util.concurrent.t;
import j$.util.function.b;
import j$.util.function.d;
import j$.util.function.e;
import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import sun.misc.Unsafe;

public abstract /* synthetic */ class a {
    public static /* synthetic */ long A(long j5, long j6) {
        long j7 = j5 % j6;
        if (j7 == 0) {
            return 0;
        }
        return (((j5 ^ j6) >> 63) | 1) > 0 ? j7 : j7 + j6;
    }

    public static /* synthetic */ long B(long j5, long j6) {
        long j7 = j5 / j6;
        return (j5 - (j6 * j7) != 0 && (((j5 ^ j6) >> 63) | 1) < 0) ? j7 - 1 : j7;
    }

    public static /* synthetic */ long C(long j5, long j6) {
        long j7 = j5 - j6;
        boolean z4 = false;
        boolean z5 = (j6 ^ j5) >= 0;
        if ((j5 ^ j7) >= 0) {
            z4 = true;
        }
        if (z5 || z4) {
            return j7;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long w(long j5, int i5) {
        long j6 = (long) i5;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j6) + Long.numberOfLeadingZeros(j6) + Long.numberOfLeadingZeros(~j5) + Long.numberOfLeadingZeros(j5);
        if (numberOfLeadingZeros > 65) {
            return j5 * j6;
        }
        if (numberOfLeadingZeros >= 64) {
            int i6 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
            boolean z4 = false;
            boolean z5 = i6 >= 0;
            if (j6 != Long.MIN_VALUE) {
                z4 = true;
            }
            if (z4 || z5) {
                long j7 = j5 * j6;
                if (i6 == 0 || j7 / j5 == j6) {
                    return j7;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long x(long j5, long j6) {
        long j7 = j5 + j6;
        boolean z4 = false;
        boolean z5 = (j6 ^ j5) < 0;
        if ((j5 ^ j7) >= 0) {
            z4 = true;
        }
        if (z5 || z4) {
            return j7;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ Map.Entry y(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(obj), Objects.requireNonNull(obj2));
    }

    public static /* synthetic */ boolean z(Unsafe unsafe, Object obj, long j5, l lVar) {
        while (true) {
            Unsafe unsafe2 = unsafe;
            Object obj2 = obj;
            long j6 = j5;
            l lVar2 = lVar;
            if (unsafe2.compareAndSwapObject(obj2, j6, (Object) null, lVar2)) {
                return true;
            }
            if (unsafe2.getObject(obj2, j6) != null) {
                return false;
            }
            unsafe = unsafe2;
            obj = obj2;
            j5 = j6;
            lVar = lVar2;
        }
    }

    public static b d(DoubleConsumer doubleConsumer, DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new b(doubleConsumer, doubleConsumer2);
    }

    public static d e(IntConsumer intConsumer, IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new d(intConsumer, intConsumer2);
    }

    public static e f(LongConsumer longConsumer, LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new e(longConsumer, longConsumer2);
    }

    public static t b(BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(biConsumer2);
        return new t(1, (Object) biConsumer, (Object) biConsumer2);
    }

    public static t c(BiFunction biFunction, Function function) {
        Objects.requireNonNull(function);
        return new t(biFunction, function);
    }

    public static void j(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static String D(Object obj, Object obj2) {
        String str;
        String obj3;
        String str2 = "null";
        if (obj == null || (str = obj.toString()) == null) {
            str = str2;
        }
        int length = str.length();
        if (!(obj2 == null || (obj3 = obj2.toString()) == null)) {
            str2 = obj3;
        }
        int length2 = str2.length();
        char[] cArr = new char[(length + length2 + 1)];
        str.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        str2.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    public static boolean o(m mVar, q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.ERA : qVar != null && qVar.e(mVar);
    }

    public static j$.time.chrono.l v(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        Object obj = (j$.time.chrono.l) nVar.h(r.f1200b);
        s sVar = s.f1072c;
        if (obj == null) {
            obj = Objects.requireNonNull(sVar, "defaultObj");
        }
        return (j$.time.chrono.l) obj;
    }

    public static int k(ChronoZonedDateTime chronoZonedDateTime, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return r.a(chronoZonedDateTime, qVar);
        }
        int i5 = C0463i.f1050a[((j$.time.temporal.a) qVar).ordinal()];
        if (i5 == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i5 != 2) {
            return chronoZonedDateTime.toLocalDateTime().e(qVar);
        } else {
            return chronoZonedDateTime.getOffset().f1021b;
        }
    }

    public static int l(m mVar, q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return mVar.getValue();
        }
        return r.a(mVar, qVar);
    }

    public static long m(m mVar, q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return (long) mVar.getValue();
        }
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(mVar);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.chrono.l E(java.lang.String r4) {
        /*
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.chrono.C0455a.f1039a
            java.lang.String r0 = "id"
            j$.util.Objects.requireNonNull(r4, r0)
        L_0x0007:
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.chrono.C0455a.f1039a
            java.lang.Object r1 = r0.get(r4)
            j$.time.chrono.l r1 = (j$.time.chrono.l) r1
            if (r1 != 0) goto L_0x0019
            j$.util.concurrent.ConcurrentHashMap r1 = j$.time.chrono.C0455a.f1040b
            java.lang.Object r1 = r1.get(r4)
            j$.time.chrono.l r1 = (j$.time.chrono.l) r1
        L_0x0019:
            if (r1 == 0) goto L_0x001c
            return r1
        L_0x001c:
            java.lang.String r1 = "ISO"
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L_0x008b
            j$.time.chrono.o r0 = j$.time.chrono.o.f1056l
            r0.getClass()
            java.lang.String r2 = "Hijrah-umalqura"
            j$.time.chrono.C0455a.e(r0, r2)
            j$.time.chrono.v r0 = j$.time.chrono.v.f1075c
            r0.getClass()
            java.lang.String r2 = "Japanese"
            j$.time.chrono.C0455a.e(r0, r2)
            j$.time.chrono.A r0 = j$.time.chrono.A.f1028c
            r0.getClass()
            java.lang.String r2 = "Minguo"
            j$.time.chrono.C0455a.e(r0, r2)
            j$.time.chrono.G r0 = j$.time.chrono.G.f1035c
            r0.getClass()
            java.lang.String r2 = "ThaiBuddhist"
            j$.time.chrono.C0455a.e(r0, r2)
            java.lang.Class<j$.time.chrono.a> r0 = j$.time.chrono.C0455a.class
            r0 = 0
            j$.time.chrono.a[] r0 = new j$.time.chrono.C0455a[r0]     // Catch:{ all -> 0x0080 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ all -> 0x0080 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0080 }
        L_0x0059:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0077
            java.lang.Object r2 = r0.next()
            j$.time.chrono.a r2 = (j$.time.chrono.C0455a) r2
            java.lang.String r3 = r2.d()
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0059
            java.lang.String r3 = r2.d()
            j$.time.chrono.C0455a.e(r2, r3)
            goto L_0x0059
        L_0x0077:
            j$.time.chrono.s r0 = j$.time.chrono.s.f1072c
            r0.getClass()
            j$.time.chrono.C0455a.e(r0, r1)
            goto L_0x0007
        L_0x0080:
            r4 = move-exception
            java.util.ServiceConfigurationError r0 = new java.util.ServiceConfigurationError
            java.lang.String r1 = r4.getMessage()
            r0.<init>(r1, r4)
            throw r0
        L_0x008b:
            java.lang.Class<j$.time.chrono.l> r0 = j$.time.chrono.l.class
            java.util.ServiceLoader r0 = java.util.ServiceLoader.load(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0095:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b6
            java.lang.Object r1 = r0.next()
            j$.time.chrono.l r1 = (j$.time.chrono.l) r1
            java.lang.String r2 = r1.d()
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00b5
            java.lang.String r2 = r1.j()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0095
        L_0x00b5:
            return r1
        L_0x00b6:
            j$.time.b r0 = new j$.time.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown chronology: "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.com.android.tools.r8.a.E(java.lang.String):j$.time.chrono.l");
    }

    public static Object s(m mVar, j$.time.format.a aVar) {
        if (aVar == r.f1201c) {
            return j$.time.temporal.b.ERAS;
        }
        return r.c(mVar, aVar);
    }

    public static Object q(C0459e eVar, j$.time.format.a aVar) {
        if (aVar == r.f1199a || aVar == r.f1203e || aVar == r.f1202d) {
            return null;
        }
        if (aVar == r.f1205g) {
            return eVar.toLocalTime();
        }
        if (aVar == r.f1200b) {
            return eVar.getChronology();
        }
        if (aVar == r.f1201c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(eVar);
    }

    public static boolean n(C0456b bVar, q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.e(bVar);
    }

    public static long t(C0459e eVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return ((eVar.toLocalDate().r() * 86400) + ((long) eVar.toLocalTime().H())) - ((long) zoneOffset.f1021b);
    }

    public static Object r(ChronoZonedDateTime chronoZonedDateTime, j$.time.format.a aVar) {
        if (aVar == r.f1203e || aVar == r.f1199a) {
            return chronoZonedDateTime.getZone();
        }
        if (aVar == r.f1202d) {
            return chronoZonedDateTime.getOffset();
        }
        if (aVar == r.f1205g) {
            return chronoZonedDateTime.toLocalTime();
        }
        if (aVar == r.f1200b) {
            return chronoZonedDateTime.getChronology();
        }
        if (aVar == r.f1201c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(chronoZonedDateTime);
    }

    public static int h(C0459e eVar, C0459e eVar2) {
        int u5 = eVar.toLocalDate().u(eVar2.toLocalDate());
        if (u5 != 0 || (u5 = eVar.toLocalTime().compareTo(eVar2.toLocalTime())) != 0) {
            return u5;
        }
        return ((C0455a) eVar.getChronology()).d().compareTo(eVar2.getChronology().d());
    }

    public static Object p(C0456b bVar, j$.time.format.a aVar) {
        if (aVar == r.f1199a || aVar == r.f1203e || aVar == r.f1202d || aVar == r.f1205g) {
            return null;
        }
        if (aVar == r.f1200b) {
            return bVar.getChronology();
        }
        if (aVar == r.f1201c) {
            return j$.time.temporal.b.DAYS;
        }
        return aVar.a(bVar);
    }

    public static j$.time.temporal.m a(C0456b bVar, j$.time.temporal.m mVar) {
        return mVar.a(bVar.r(), j$.time.temporal.a.EPOCH_DAY);
    }

    public static long u(ChronoZonedDateTime chronoZonedDateTime) {
        return ((chronoZonedDateTime.toLocalDate().r() * 86400) + ((long) chronoZonedDateTime.toLocalTime().H())) - ((long) chronoZonedDateTime.getOffset().f1021b);
    }

    public static int i(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int compare = Long.compare(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
        if (compare != 0 || (compare = chronoZonedDateTime.toLocalTime().f1157d - chronoZonedDateTime2.toLocalTime().f1157d) != 0 || (compare = chronoZonedDateTime.toLocalDateTime().t(chronoZonedDateTime2.toLocalDateTime())) != 0 || (compare = chronoZonedDateTime.getZone().d().compareTo(chronoZonedDateTime2.getZone().d())) != 0) {
            return compare;
        }
        return ((C0455a) chronoZonedDateTime.getChronology()).d().compareTo(chronoZonedDateTime2.getChronology().d());
    }

    public static int g(C0456b bVar, C0456b bVar2) {
        int compare = Long.compare(bVar.r(), bVar2.r());
        if (compare != 0) {
            return compare;
        }
        return ((C0455a) bVar.getChronology()).d().compareTo(bVar2.getChronology().d());
    }
}
