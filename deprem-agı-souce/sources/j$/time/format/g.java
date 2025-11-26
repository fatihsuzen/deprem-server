package j$.time.format;

import j$.time.temporal.q;
import j$.time.temporal.u;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public final class g extends i {

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1105g;

    public g(q qVar, int i5, int i6, boolean z4, int i7) {
        super(qVar, i5, i6, u.NOT_NEGATIVE, i7);
        this.f1105g = z4;
    }

    public final i a() {
        if (this.f1112e == -1) {
            return this;
        }
        return new g(this.f1108a, this.f1109b, this.f1110c, this.f1105g, -1);
    }

    public final i b(int i5) {
        return new g(this.f1108a, this.f1109b, this.f1110c, this.f1105g, this.f1112e + i5);
    }

    public final boolean e(p pVar, StringBuilder sb) {
        q qVar = this.f1108a;
        Long a5 = pVar.a(qVar);
        if (a5 == null) {
            return false;
        }
        s sVar = pVar.f1135b.f1096c;
        long longValue = a5.longValue();
        u range = qVar.range();
        range.b(longValue, qVar);
        BigDecimal valueOf = BigDecimal.valueOf(range.f1206a);
        BigDecimal add = BigDecimal.valueOf(range.f1209d).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z4 = this.f1105g;
        int i5 = this.f1109b;
        if (scale == 0) {
            if (i5 > 0) {
                if (z4) {
                    sVar.getClass();
                    sb.append('.');
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    sVar.getClass();
                    sb.append('0');
                }
            }
            return true;
        }
        String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i5), this.f1110c), roundingMode).toPlainString().substring(2);
        sVar.getClass();
        if (z4) {
            sb.append('.');
        }
        sb.append(substring);
        return true;
    }

    public final String toString() {
        String str = this.f1105g ? ",DecimalPoint" : "";
        return "Fraction(" + this.f1108a + "," + this.f1109b + "," + this.f1110c + str + ")";
    }
}
