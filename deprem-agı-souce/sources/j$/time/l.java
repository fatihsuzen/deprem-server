package j$.time;

import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public enum l implements n, o {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final l[] f1159a = null;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: j$.time.l[]} */
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r15v1, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.lang.Enum, j$.time.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            j$.time.l r0 = new j$.time.l
            java.lang.String r1 = "JANUARY"
            r2 = 0
            r0.<init>(r1, r2)
            JANUARY = r0
            j$.time.l r1 = new j$.time.l
            java.lang.String r3 = "FEBRUARY"
            r4 = 1
            r1.<init>(r3, r4)
            FEBRUARY = r1
            j$.time.l r3 = new j$.time.l
            java.lang.String r5 = "MARCH"
            r6 = 2
            r3.<init>(r5, r6)
            MARCH = r3
            j$.time.l r5 = new j$.time.l
            java.lang.String r7 = "APRIL"
            r8 = 3
            r5.<init>(r7, r8)
            APRIL = r5
            j$.time.l r7 = new j$.time.l
            java.lang.String r9 = "MAY"
            r10 = 4
            r7.<init>(r9, r10)
            MAY = r7
            j$.time.l r9 = new j$.time.l
            java.lang.String r11 = "JUNE"
            r12 = 5
            r9.<init>(r11, r12)
            JUNE = r9
            j$.time.l r11 = new j$.time.l
            java.lang.String r13 = "JULY"
            r14 = 6
            r11.<init>(r13, r14)
            JULY = r11
            j$.time.l r13 = new j$.time.l
            java.lang.String r15 = "AUGUST"
            r16 = r2
            r2 = 7
            r13.<init>(r15, r2)
            AUGUST = r13
            j$.time.l r15 = new j$.time.l
            r17 = r2
            java.lang.String r2 = "SEPTEMBER"
            r18 = r4
            r4 = 8
            r15.<init>(r2, r4)
            SEPTEMBER = r15
            j$.time.l r2 = new j$.time.l
            r19 = r4
            java.lang.String r4 = "OCTOBER"
            r20 = r6
            r6 = 9
            r2.<init>(r4, r6)
            OCTOBER = r2
            j$.time.l r4 = new j$.time.l
            r21 = r6
            java.lang.String r6 = "NOVEMBER"
            r22 = r8
            r8 = 10
            r4.<init>(r6, r8)
            NOVEMBER = r4
            j$.time.l r6 = new j$.time.l
            r23 = r8
            java.lang.String r8 = "DECEMBER"
            r24 = r10
            r10 = 11
            r6.<init>(r8, r10)
            DECEMBER = r6
            r8 = 12
            j$.time.l[] r8 = new j$.time.l[r8]
            r8[r16] = r0
            r8[r18] = r1
            r8[r20] = r3
            r8[r22] = r5
            r8[r24] = r7
            r8[r12] = r9
            r8[r14] = r11
            r8[r17] = r13
            r8[r19] = r15
            r8[r21] = r2
            r8[r23] = r4
            r8[r10] = r6
            f1160b = r8
            j$.time.l[] r0 = values()
            f1159a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.l.<clinit>():void");
    }

    public static l y(int i5) {
        if (i5 >= 1 && i5 <= 12) {
            return f1159a[i5 - 1];
        }
        throw new RuntimeException("Invalid value for MonthOfYear: " + i5);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.MONTH_OF_YEAR : qVar != null && qVar.e(this);
    }

    public final u g(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return qVar.range();
        }
        return r.d(this, qVar);
    }

    public final int e(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return getValue();
        }
        return r.a(this, qVar);
    }

    public final long q(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return (long) getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.g(this);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final int w(boolean z4) {
        int i5 = k.f1158a[ordinal()];
        return i5 != 1 ? (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31 : z4 ? 29 : 28;
    }

    public final int x() {
        int i5 = k.f1158a[ordinal()];
        if (i5 != 1) {
            return (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final int v(boolean z4) {
        switch (k.f1158a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z4 ? 1 : 0) + true;
            case 3:
                return z4 + true;
            case 4:
                return z4 + true;
            case 5:
                return z4 + true;
            case 6:
                return 1;
            case 7:
                return z4 + true;
            case 8:
                return z4 + true;
            case 9:
                return z4 + true;
            case 10:
                return z4 + true;
            case 11:
                return z4 + true;
            default:
                return z4 + true;
        }
    }

    public final Object h(j$.time.format.a aVar) {
        if (aVar == r.f1200b) {
            return s.f1072c;
        }
        if (aVar == r.f1201c) {
            return b.MONTHS;
        }
        return r.c(this, aVar);
    }

    public final m k(m mVar) {
        if (j$.com.android.tools.r8.a.v(mVar).equals(s.f1072c)) {
            return mVar.a((long) getValue(), a.MONTH_OF_YEAR);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }
}
