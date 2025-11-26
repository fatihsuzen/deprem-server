package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.a;
import j$.time.temporal.n;

public final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1106a;

    public /* synthetic */ h(int i5) {
        this.f1106a = i5;
    }

    public final boolean e(p pVar, StringBuilder sb) {
        long j5;
        p pVar2 = pVar;
        StringBuilder sb2 = sb;
        switch (this.f1106a) {
            case 0:
                Long a5 = pVar2.a(a.INSTANT_SECONDS);
                n nVar = pVar2.f1134a;
                a aVar = a.NANO_OF_SECOND;
                Long valueOf = nVar.c(aVar) ? Long.valueOf(nVar.q(aVar)) : null;
                int i5 = 0;
                if (a5 == null) {
                    return false;
                }
                long longValue = a5.longValue();
                if (valueOf != null) {
                    j5 = valueOf.longValue();
                } else {
                    j5 = 0;
                }
                int a6 = aVar.f1181b.a(j5, aVar);
                if (longValue >= -62167219200L) {
                    long j6 = longValue - 253402300800L;
                    long B4 = j$.com.android.tools.r8.a.B(j6, 315569520000L) + 1;
                    LocalDateTime z4 = LocalDateTime.z(j$.com.android.tools.r8.a.A(j6, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (B4 > 0) {
                        sb2.append('+');
                        sb2.append(B4);
                    }
                    sb2.append(z4);
                    if (z4.f1012b.f1156c == 0) {
                        sb2.append(":00");
                    }
                } else {
                    long j7 = longValue + 62167219200L;
                    long j8 = j7 / 315569520000L;
                    long j9 = j7 % 315569520000L;
                    LocalDateTime z5 = LocalDateTime.z(j9 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb2.length();
                    sb2.append(z5);
                    if (z5.f1012b.f1156c == 0) {
                        sb2.append(":00");
                    }
                    if (j8 < 0) {
                        if (z5.f1011a.f1144a == -10000) {
                            sb2.replace(length, length + 2, Long.toString(j8 - 1));
                        } else if (j9 == 0) {
                            sb2.insert(length, j8);
                        } else {
                            sb2.insert(length + 1, Math.abs(j8));
                        }
                    }
                }
                if (a6 > 0) {
                    sb2.append('.');
                    int i6 = 100000000;
                    while (true) {
                        if (a6 > 0 || i5 % 3 != 0 || i5 < -2) {
                            int i7 = a6 / i6;
                            sb2.append((char) (i7 + 48));
                            a6 -= i7 * i6;
                            i6 /= 10;
                            i5++;
                        }
                    }
                }
                sb2.append('Z');
                return true;
            default:
                a aVar2 = n.f1124f;
                n nVar2 = pVar2.f1134a;
                Object h5 = nVar2.h(aVar2);
                if (h5 == null && pVar2.f1136c == 0) {
                    throw new RuntimeException("Unable to extract " + aVar2 + " from temporal " + nVar2);
                }
                ZoneId zoneId = (ZoneId) h5;
                if (zoneId == null) {
                    return false;
                }
                sb2.append(zoneId.d());
                return true;
        }
    }

    public final String toString() {
        switch (this.f1106a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
