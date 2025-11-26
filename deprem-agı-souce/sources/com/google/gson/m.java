package com.google.gson;

import com.google.gson.internal.x;
import com.google.gson.internal.z;
import j$.util.Objects;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class m extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7811a;

    public m(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f7811a = bool;
    }

    private static boolean t(m mVar) {
        Object obj = mVar.f7811a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f7811a == null) {
            if (mVar.f7811a == null) {
                return true;
            }
            return false;
        } else if (!t(this) || !t(mVar)) {
            Object obj2 = this.f7811a;
            if (obj2 instanceof Number) {
                Object obj3 = mVar.f7811a;
                if (obj3 instanceof Number) {
                    if (!(obj2 instanceof BigDecimal) || !(obj3 instanceof BigDecimal)) {
                        double p5 = p();
                        double p6 = mVar.p();
                        if (p5 == p6 || (Double.isNaN(p5) && Double.isNaN(p6))) {
                            return true;
                        }
                        return false;
                    } else if (l().compareTo(mVar.l()) == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return obj2.equals(mVar.f7811a);
        } else if ((this.f7811a instanceof BigInteger) || (mVar.f7811a instanceof BigInteger)) {
            return n().equals(mVar.n());
        } else {
            if (q().longValue() == mVar.q().longValue()) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f7811a == null) {
            return 31;
        }
        if (t(this)) {
            doubleToLongBits = q().longValue();
        } else {
            Object obj = this.f7811a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(q().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public BigDecimal l() {
        Object obj = this.f7811a;
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        return z.b(r());
    }

    public BigInteger n() {
        Object obj = this.f7811a;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if (t(this)) {
            return BigInteger.valueOf(q().longValue());
        }
        return z.c(r());
    }

    public boolean o() {
        if (s()) {
            return ((Boolean) this.f7811a).booleanValue();
        }
        return Boolean.parseBoolean(r());
    }

    public double p() {
        if (u()) {
            return q().doubleValue();
        }
        return Double.parseDouble(r());
    }

    public Number q() {
        Object obj = this.f7811a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new x((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String r() {
        Object obj = this.f7811a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (u()) {
            return q().toString();
        }
        if (s()) {
            return ((Boolean) this.f7811a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f7811a.getClass());
    }

    public boolean s() {
        return this.f7811a instanceof Boolean;
    }

    public boolean u() {
        return this.f7811a instanceof Number;
    }

    public boolean v() {
        return this.f7811a instanceof String;
    }

    public m(Number number) {
        Objects.requireNonNull(number);
        this.f7811a = number;
    }

    public m(String str) {
        Objects.requireNonNull(str);
        this.f7811a = str;
    }
}
