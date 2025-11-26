package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class X5 extends AbstractSet {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Y5 f5270a;

    /* synthetic */ X5(Y5 y5, byte[] bArr) {
        Objects.requireNonNull(y5);
        this.f5270a = y5;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f5270a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.f5270a.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f5270a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value) {
            return true;
        }
        if (obj2 == null || !obj2.equals(value)) {
            return false;
        }
        return true;
    }

    public final Iterator iterator() {
        return new W5(this.f5270a, (byte[]) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f5270a.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.f5270a.size();
    }
}
