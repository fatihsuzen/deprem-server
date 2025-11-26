package j$.time;

import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public enum d implements n, o {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final d[] f1087a = null;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: j$.time.d[]} */
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.lang.Enum, j$.time.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            j$.time.d r0 = new j$.time.d
            java.lang.String r1 = "MONDAY"
            r2 = 0
            r0.<init>(r1, r2)
            MONDAY = r0
            j$.time.d r1 = new j$.time.d
            java.lang.String r3 = "TUESDAY"
            r4 = 1
            r1.<init>(r3, r4)
            TUESDAY = r1
            j$.time.d r3 = new j$.time.d
            java.lang.String r5 = "WEDNESDAY"
            r6 = 2
            r3.<init>(r5, r6)
            WEDNESDAY = r3
            j$.time.d r5 = new j$.time.d
            java.lang.String r7 = "THURSDAY"
            r8 = 3
            r5.<init>(r7, r8)
            THURSDAY = r5
            j$.time.d r7 = new j$.time.d
            java.lang.String r9 = "FRIDAY"
            r10 = 4
            r7.<init>(r9, r10)
            FRIDAY = r7
            j$.time.d r9 = new j$.time.d
            java.lang.String r11 = "SATURDAY"
            r12 = 5
            r9.<init>(r11, r12)
            SATURDAY = r9
            j$.time.d r11 = new j$.time.d
            java.lang.String r13 = "SUNDAY"
            r14 = 6
            r11.<init>(r13, r14)
            SUNDAY = r11
            r13 = 7
            j$.time.d[] r13 = new j$.time.d[r13]
            r13[r2] = r0
            r13[r4] = r1
            r13[r6] = r3
            r13[r8] = r5
            r13[r10] = r7
            r13[r12] = r9
            r13[r14] = r11
            f1088b = r13
            j$.time.d[] r0 = values()
            f1087a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.d.<clinit>():void");
    }

    public static d v(int i5) {
        if (i5 >= 1 && i5 <= 7) {
            return f1087a[i5 - 1];
        }
        throw new RuntimeException("Invalid value for DayOfWeek: " + i5);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.DAY_OF_WEEK : qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return qVar.range();
        }
        return r.d(this, qVar);
    }

    public final int e(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return getValue();
        }
        return r.a(this, qVar);
    }

    public final long q(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return (long) getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1201c) {
            return b.DAYS;
        }
        return r.c(this, aVar);
    }

    public final m k(m mVar) {
        return mVar.a((long) getValue(), a.DAY_OF_WEEK);
    }
}
