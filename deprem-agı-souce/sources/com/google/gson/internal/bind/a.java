package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.h;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import j$.util.Objects;
import j1.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class a extends c {

    /* renamed from: r  reason: collision with root package name */
    private static final Writer f7745r = new C0077a();

    /* renamed from: s  reason: collision with root package name */
    private static final m f7746s = new m("closed");

    /* renamed from: o  reason: collision with root package name */
    private final List f7747o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private String f7748p;

    /* renamed from: q  reason: collision with root package name */
    private h f7749q = j.f7809a;

    /* renamed from: com.google.gson.internal.bind.a$a  reason: collision with other inner class name */
    class C0077a extends Writer {
        C0077a() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i5, int i6) {
            throw new AssertionError();
        }
    }

    public a() {
        super(f7745r);
    }

    private h T() {
        List list = this.f7747o;
        return (h) list.get(list.size() - 1);
    }

    private void U(h hVar) {
        if (this.f7748p != null) {
            if (!hVar.i() || s()) {
                ((k) T()).l(this.f7748p, hVar);
            }
            this.f7748p = null;
        } else if (this.f7747o.isEmpty()) {
            this.f7749q = hVar;
        } else {
            h T4 = T();
            if (T4 instanceof f) {
                ((f) T4).l(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public c L(double d5) {
        if (v() || (!Double.isNaN(d5) && !Double.isInfinite(d5))) {
            U(new m((Number) Double.valueOf(d5)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d5);
    }

    public c M(long j5) {
        U(new m((Number) Long.valueOf(j5)));
        return this;
    }

    public c N(Boolean bool) {
        if (bool == null) {
            return z();
        }
        U(new m(bool));
        return this;
    }

    public c O(Number number) {
        if (number == null) {
            return z();
        }
        if (!v()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        U(new m(number));
        return this;
    }

    public c P(String str) {
        if (str == null) {
            return z();
        }
        U(new m(str));
        return this;
    }

    public c Q(boolean z4) {
        U(new m(Boolean.valueOf(z4)));
        return this;
    }

    public h S() {
        if (this.f7747o.isEmpty()) {
            return this.f7749q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f7747o);
    }

    public void close() {
        if (this.f7747o.isEmpty()) {
            this.f7747o.add(f7746s);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void flush() {
    }

    public c m() {
        f fVar = new f();
        U(fVar);
        this.f7747o.add(fVar);
        return this;
    }

    public c n() {
        k kVar = new k();
        U(kVar);
        this.f7747o.add(kVar);
        return this;
    }

    public c p() {
        if (this.f7747o.isEmpty() || this.f7748p != null) {
            throw new IllegalStateException();
        } else if (T() instanceof f) {
            List list = this.f7747o;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c q() {
        if (this.f7747o.isEmpty() || this.f7748p != null) {
            throw new IllegalStateException();
        } else if (T() instanceof k) {
            List list = this.f7747o;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c x(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f7747o.isEmpty() || this.f7748p != null) {
            throw new IllegalStateException("Did not expect a name");
        } else if (T() instanceof k) {
            this.f7748p = str;
            return this;
        } else {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
    }

    public c z() {
        U(j.f7809a);
        return this;
    }
}
