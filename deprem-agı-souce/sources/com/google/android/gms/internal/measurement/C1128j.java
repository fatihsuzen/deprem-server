package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.j  reason: case insensitive filesystem */
public final class C1128j implements r {

    /* renamed from: a  reason: collision with root package name */
    private final Double f5387a;

    public C1128j(Double d5) {
        if (d5 == null) {
            this.f5387a = Double.valueOf(Double.NaN);
        } else {
            this.f5387a = d5;
        }
    }

    public final Double C() {
        return this.f5387a;
    }

    public final String b() {
        int scale;
        Double d5 = this.f5387a;
        if (Double.isNaN(d5.doubleValue())) {
            return "NaN";
        }
        if (!Double.isInfinite(d5.doubleValue())) {
            BigDecimal a5 = C1119i.a(BigDecimal.valueOf(d5.doubleValue()));
            DecimalFormat decimalFormat = new DecimalFormat("0E0");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (a5.scale() > 0) {
                scale = a5.precision();
            } else {
                scale = a5.scale();
            }
            decimalFormat.setMinimumFractionDigits(scale - 1);
            String format = decimalFormat.format(a5);
            int indexOf = format.indexOf(ExifInterface.LONGITUDE_EAST);
            if (indexOf <= 0) {
                return format;
            }
            int parseInt = Integer.parseInt(format.substring(indexOf + 1));
            if ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) {
                return format.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+");
            }
            return a5.toPlainString();
        } else if (d5.doubleValue() > 0.0d) {
            return "Infinity";
        } else {
            return "-Infinity";
        }
    }

    public final Iterator c() {
        return null;
    }

    public final Boolean d() {
        Double d5 = this.f5387a;
        boolean z4 = false;
        if (!Double.isNaN(d5.doubleValue()) && d5.doubleValue() != 0.0d) {
            z4 = true;
        }
        return Boolean.valueOf(z4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1128j)) {
            return false;
        }
        return this.f5387a.equals(((C1128j) obj).f5387a);
    }

    public final int hashCode() {
        return this.f5387a.hashCode();
    }

    public final r j() {
        return new C1128j(this.f5387a);
    }

    public final r k(String str, U1 u12, List list) {
        if ("toString".equals(str)) {
            return new C1235v(b());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{b(), str}));
    }

    public final String toString() {
        return b();
    }
}
