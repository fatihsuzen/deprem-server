package com.google.gson;

import com.google.gson.internal.y;
import java.util.Set;

public final class k extends h {

    /* renamed from: a  reason: collision with root package name */
    private final y f7810a = new y(false);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k) || !((k) obj).f7810a.equals(this.f7810a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7810a.hashCode();
    }

    public void l(String str, h hVar) {
        y yVar = this.f7810a;
        if (hVar == null) {
            hVar = j.f7809a;
        }
        yVar.put(str, hVar);
    }

    public Set n() {
        return this.f7810a.entrySet();
    }
}
