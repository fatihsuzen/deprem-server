package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.t4  reason: case insensitive filesystem */
abstract class C1222t4 extends AbstractList implements C1143k5 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5585a;

    C1222t4(boolean z4) {
        this.f5585a = z4;
    }

    public final boolean A() {
        return this.f5585a;
    }

    public final void B() {
        if (this.f5585a) {
            this.f5585a = false;
        }
    }

    public final boolean addAll(int i5, Collection collection) {
        c();
        return super.addAll(i5, collection);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!this.f5585a) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        c();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i5 = 0; i5 < size; i5++) {
            if (!get(i5).equals(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i5 = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i5 = (i5 * 31) + get(i6).hashCode();
        }
        return i5;
    }

    public abstract Object remove(int i5);

    public final boolean remove(Object obj) {
        c();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        c();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        c();
        return super.retainAll(collection);
    }

    public boolean addAll(Collection collection) {
        c();
        return super.addAll(collection);
    }
}
