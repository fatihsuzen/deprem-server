package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class f extends h implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f7578a = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f) || !((f) obj).f7578a.equals(this.f7578a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7578a.hashCode();
    }

    public Iterator iterator() {
        return this.f7578a.iterator();
    }

    public void l(h hVar) {
        if (hVar == null) {
            hVar = j.f7809a;
        }
        this.f7578a.add(hVar);
    }
}
