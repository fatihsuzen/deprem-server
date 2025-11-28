package com.finazzi.distquake;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.TimeZone;
import u2.I1;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final I1 f13687a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f13688b;

    public a0(I1 i12, TimeZone timeZone) {
        this.f13687a = i12;
        this.f13688b = timeZone;
    }

    private BigDecimal a(BigDecimal bigDecimal, Calendar calendar) {
        if (this.f13688b.inDaylightTime(calendar.getTime())) {
            bigDecimal = bigDecimal.add(BigDecimal.ONE);
        }
        if (bigDecimal.doubleValue() > 24.0d) {
            return bigDecimal.subtract(BigDecimal.valueOf(24));
        }
        return bigDecimal;
    }

    private BigDecimal b(h0 h0Var, Calendar calendar, boolean z7) {
        calendar.setTimeZone(this.f13688b);
        BigDecimal p7 = p(calendar, Boolean.valueOf(z7));
        BigDecimal u7 = u(q(p7));
        BigDecimal k8 = k(u7, h0Var);
        if (k8.doubleValue() < -1.0d || k8.doubleValue() > 1.0d) {
            return null;
        }
        return n(m(u7, p7, t(k8, Boolean.valueOf(z7))), calendar);
    }

    private BigDecimal e(BigDecimal bigDecimal) {
        return w(bigDecimal, BigDecimal.valueOf(0.017453292519943295d));
    }

    private BigDecimal f(BigDecimal bigDecimal) {
        return w(bigDecimal, new BigDecimal(57.29577951308232d));
    }

    private BigDecimal g(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.divide(bigDecimal2, 4, RoundingMode.HALF_EVEN);
    }

    private BigDecimal h(BigDecimal bigDecimal) {
        return x(BigDecimal.valueOf(Math.acos(bigDecimal.doubleValue())));
    }

    private BigDecimal i() {
        return g(this.f13687a.b(), BigDecimal.valueOf(15));
    }

    private BigDecimal j(BigDecimal bigDecimal) {
        return x(BigDecimal.valueOf(Math.cos(BigDecimal.valueOf(Math.asin(bigDecimal.doubleValue())).doubleValue())));
    }

    private BigDecimal k(BigDecimal bigDecimal, h0 h0Var) {
        BigDecimal s7 = s(bigDecimal);
        BigDecimal j8 = j(s7);
        return x(g(BigDecimal.valueOf(Math.cos(e(h0Var.a()).doubleValue())).subtract(s7.multiply(BigDecimal.valueOf(Math.sin(e(this.f13687a.a()).doubleValue())))), j8.multiply(BigDecimal.valueOf(Math.cos(e(this.f13687a.a()).doubleValue())))));
    }

    private BigDecimal l(Calendar calendar) {
        return new BigDecimal(calendar.get(6));
    }

    private BigDecimal m(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        BigDecimal r7 = r(bigDecimal);
        BigDecimal subtract = bigDecimal3.add(r7).subtract(bigDecimal2.multiply(new BigDecimal("0.06571"))).subtract(new BigDecimal("6.622"));
        if (subtract.doubleValue() < 0.0d) {
            subtract = subtract.add(BigDecimal.valueOf(24));
        } else if (subtract.doubleValue() > 24.0d) {
            subtract = subtract.subtract(BigDecimal.valueOf(24));
        }
        return x(subtract);
    }

    private BigDecimal n(BigDecimal bigDecimal, Calendar calendar) {
        return a(bigDecimal.subtract(i()).add(v(calendar)), calendar);
    }

    private Calendar o(BigDecimal bigDecimal, Calendar calendar) {
        if (bigDecimal == null) {
            return null;
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        if (bigDecimal.compareTo(bigDecimal2) == -1) {
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(24.0d));
            calendar2.add(11, -24);
        }
        String[] split = bigDecimal.toPlainString().split("\\.");
        int parseInt = Integer.parseInt(split[0]);
        BigDecimal scale = new BigDecimal("0." + split[1]).multiply(BigDecimal.valueOf(60)).setScale(0, RoundingMode.HALF_EVEN);
        if (scale.intValue() == 60) {
            parseInt++;
        } else {
            bigDecimal2 = scale;
        }
        if (parseInt == 24) {
            parseInt = 0;
        }
        calendar2.set(11, parseInt);
        calendar2.set(12, bigDecimal2.intValue());
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        calendar2.setTimeZone(calendar.getTimeZone());
        return calendar2;
    }

    private BigDecimal p(Calendar calendar, Boolean bool) {
        int i8;
        if (bool.booleanValue()) {
            i8 = 6;
        } else {
            i8 = 18;
        }
        return x(l(calendar).add(g(BigDecimal.valueOf((long) i8).subtract(i()), BigDecimal.valueOf(24))));
    }

    private BigDecimal q(BigDecimal bigDecimal) {
        return x(w(new BigDecimal("0.9856"), bigDecimal).subtract(new BigDecimal("3.289")));
    }

    private BigDecimal r(BigDecimal bigDecimal) {
        BigDecimal x7 = x(f(new BigDecimal(Math.atan(e(w(f(new BigDecimal(Math.tan(e(bigDecimal).doubleValue()))), new BigDecimal("0.91764"))).doubleValue()))));
        if (x7.doubleValue() < 0.0d) {
            x7 = x7.add(BigDecimal.valueOf(360));
        } else if (x7.doubleValue() > 360.0d) {
            x7 = x7.subtract(BigDecimal.valueOf(360));
        }
        BigDecimal valueOf = BigDecimal.valueOf(90);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        return g(x7.add(bigDecimal.divide(valueOf, 0, roundingMode).multiply(valueOf).subtract(x7.divide(valueOf, 0, roundingMode).multiply(valueOf))), BigDecimal.valueOf(15));
    }

    private BigDecimal s(BigDecimal bigDecimal) {
        return x(BigDecimal.valueOf(Math.sin(e(bigDecimal).doubleValue())).multiply(new BigDecimal("0.39782")));
    }

    private BigDecimal t(BigDecimal bigDecimal, Boolean bool) {
        BigDecimal f8 = f(h(bigDecimal));
        if (bool.booleanValue()) {
            f8 = BigDecimal.valueOf(360).subtract(f8);
        }
        return g(f8, BigDecimal.valueOf(15));
    }

    private BigDecimal u(BigDecimal bigDecimal) {
        BigDecimal add = bigDecimal.add(w(new BigDecimal(Math.sin(e(bigDecimal).doubleValue())), new BigDecimal("1.916"))).add(w(new BigDecimal(Math.sin(w(e(bigDecimal), BigDecimal.valueOf(2)).doubleValue())), new BigDecimal("0.020")).add(new BigDecimal("282.634")));
        if (add.doubleValue() > 360.0d) {
            add = add.subtract(BigDecimal.valueOf(360));
        }
        return x(add);
    }

    private BigDecimal v(Calendar calendar) {
        return new BigDecimal(calendar.get(15) / 3600000).setScale(0, RoundingMode.HALF_EVEN);
    }

    private BigDecimal w(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return x(bigDecimal.multiply(bigDecimal2));
    }

    private BigDecimal x(BigDecimal bigDecimal) {
        return bigDecimal.setScale(4, RoundingMode.HALF_EVEN);
    }

    public Calendar c(h0 h0Var, Calendar calendar) {
        return o(b(h0Var, calendar, true), calendar);
    }

    public Calendar d(h0 h0Var, Calendar calendar) {
        return o(b(h0Var, calendar, false), calendar);
    }
}
