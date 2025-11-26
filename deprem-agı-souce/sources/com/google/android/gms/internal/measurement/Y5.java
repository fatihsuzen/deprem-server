package com.google.android.gms.internal.measurement;

import j$.util.DesugarCollections;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

abstract class Y5 extends AbstractMap {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f5280a;

    /* renamed from: b  reason: collision with root package name */
    private int f5281b;

    /* renamed from: c  reason: collision with root package name */
    private Map f5282c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5283d;

    /* renamed from: e  reason: collision with root package name */
    private volatile X5 f5284e;

    /* renamed from: f  reason: collision with root package name */
    private Map f5285f;

    /* synthetic */ Y5(byte[] bArr) {
        Map map = Collections.EMPTY_MAP;
        this.f5282c = map;
        this.f5285f = map;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final Object h(int i5) {
        i();
        Object value = ((V5) this.f5280a[i5]).getValue();
        Object[] objArr = this.f5280a;
        System.arraycopy(objArr, i5 + 1, objArr, i5, (this.f5281b - i5) - 1);
        this.f5281b--;
        if (!this.f5282c.isEmpty()) {
            Iterator it = p().entrySet().iterator();
            Object[] objArr2 = this.f5280a;
            int i6 = this.f5281b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i6] = new V5(this, (Comparable) entry.getKey(), entry.getValue());
            this.f5281b++;
            it.remove();
        }
        return value;
    }

    private final int n(Comparable comparable) {
        int i5 = this.f5281b;
        int i6 = i5 - 1;
        int i7 = 0;
        if (i6 >= 0) {
            int compareTo = comparable.compareTo(((V5) this.f5280a[i6]).a());
            if (compareTo > 0) {
                return -(i5 + 1);
            }
            if (compareTo == 0) {
                return i6;
            }
        }
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int compareTo2 = comparable.compareTo(((V5) this.f5280a[i8]).a());
            if (compareTo2 < 0) {
                i6 = i8 - 1;
            } else if (compareTo2 <= 0) {
                return i8;
            } else {
                i7 = i8 + 1;
            }
        }
        return -(i7 + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void i() {
        if (this.f5283d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap p() {
        i();
        if (this.f5282c.isEmpty() && !(this.f5282c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f5282c = treeMap;
            this.f5285f = treeMap.descendingMap();
        }
        return (SortedMap) this.f5282c;
    }

    public void a() {
        Map map;
        Map map2;
        if (!this.f5283d) {
            if (this.f5282c.isEmpty()) {
                map = Collections.EMPTY_MAP;
            } else {
                map = DesugarCollections.unmodifiableMap(this.f5282c);
            }
            this.f5282c = map;
            if (this.f5285f.isEmpty()) {
                map2 = Collections.EMPTY_MAP;
            } else {
                map2 = DesugarCollections.unmodifiableMap(this.f5285f);
            }
            this.f5285f = map2;
            this.f5283d = true;
        }
    }

    public final boolean b() {
        return this.f5283d;
    }

    public final int c() {
        return this.f5281b;
    }

    public final void clear() {
        i();
        if (this.f5281b != 0) {
            this.f5280a = null;
            this.f5281b = 0;
        }
        if (!this.f5282c.isEmpty()) {
            this.f5282c.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (n(comparable) >= 0 || this.f5282c.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final Map.Entry e(int i5) {
        if (i5 < this.f5281b) {
            return (V5) this.f5280a[i5];
        }
        throw new ArrayIndexOutOfBoundsException(i5);
    }

    public final Set entrySet() {
        if (this.f5284e == null) {
            this.f5284e = new X5(this, (byte[]) null);
        }
        return this.f5284e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y5)) {
            return super.equals(obj);
        }
        Y5 y5 = (Y5) obj;
        int size = size();
        if (size != y5.size()) {
            return false;
        }
        int i5 = this.f5281b;
        if (i5 != y5.f5281b) {
            return entrySet().equals(y5.entrySet());
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!e(i6).equals(y5.e(i6))) {
                return false;
            }
        }
        if (i5 != size) {
            return this.f5282c.equals(y5.f5282c);
        }
        return true;
    }

    public final Iterable f() {
        if (this.f5282c.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.f5282c.entrySet();
    }

    /* renamed from: g */
    public final Object put(Comparable comparable, Object obj) {
        i();
        int n5 = n(comparable);
        if (n5 >= 0) {
            return ((V5) this.f5280a[n5]).setValue(obj);
        }
        i();
        if (this.f5280a == null) {
            this.f5280a = new Object[16];
        }
        int i5 = -(n5 + 1);
        if (i5 >= 16) {
            return p().put(comparable, obj);
        }
        if (this.f5281b == 16) {
            V5 v5 = (V5) this.f5280a[15];
            this.f5281b = 15;
            p().put(v5.a(), v5.getValue());
        }
        Object[] objArr = this.f5280a;
        int length = objArr.length;
        System.arraycopy(objArr, i5, objArr, i5 + 1, 15 - i5);
        this.f5280a[i5] = new V5(this, comparable, obj);
        this.f5281b++;
        return null;
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int n5 = n(comparable);
        if (n5 >= 0) {
            return ((V5) this.f5280a[n5]).getValue();
        }
        return this.f5282c.get(comparable);
    }

    public final int hashCode() {
        int i5 = this.f5281b;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += this.f5280a[i7].hashCode();
        }
        if (this.f5282c.size() > 0) {
            return i6 + this.f5282c.hashCode();
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object[] j() {
        return this.f5280a;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int k() {
        return this.f5281b;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map l() {
        return this.f5282c;
    }

    public final Object remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int n5 = n(comparable);
        if (n5 >= 0) {
            return h(n5);
        }
        if (this.f5282c.isEmpty()) {
            return null;
        }
        return this.f5282c.remove(comparable);
    }

    public final int size() {
        return this.f5281b + this.f5282c.size();
    }
}
