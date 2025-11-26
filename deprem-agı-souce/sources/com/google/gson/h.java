package com.google.gson;

import com.google.gson.internal.E;
import j1.c;
import java.io.IOException;

public abstract class h {
    public f c() {
        if (g()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public k d() {
        if (j()) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public m f() {
        if (k()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean g() {
        return this instanceof f;
    }

    public boolean i() {
        return this instanceof j;
    }

    public boolean j() {
        return this instanceof k;
    }

    public boolean k() {
        return this instanceof m;
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            c cVar = new c(E.b(sb));
            cVar.J(r.LENIENT);
            E.a(this, cVar);
            return sb.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }
}
