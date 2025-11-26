package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class y extends AbstractMap implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator f7783i = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Comparator f7784a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7785b;

    /* renamed from: c  reason: collision with root package name */
    e f7786c;

    /* renamed from: d  reason: collision with root package name */
    int f7787d;

    /* renamed from: e  reason: collision with root package name */
    int f7788e;

    /* renamed from: f  reason: collision with root package name */
    final e f7789f;

    /* renamed from: g  reason: collision with root package name */
    private b f7790g;

    /* renamed from: h  reason: collision with root package name */
    private c f7791h;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            /* renamed from: b */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        public void clear() {
            y.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry) || y.this.c((Map.Entry) obj) == null) {
                return false;
            }
            return true;
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            e c5;
            if (!(obj instanceof Map.Entry) || (c5 = y.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            y.this.g(c5, true);
            return true;
        }

        public int size() {
            return y.this.f7787d;
        }
    }

    final class c extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            public Object next() {
                return a().f7805f;
            }
        }

        c() {
        }

        public void clear() {
            y.this.clear();
        }

        public boolean contains(Object obj) {
            return y.this.containsKey(obj);
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            if (y.this.h(obj) != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return y.this.f7787d;
        }
    }

    private abstract class d implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        e f7796a;

        /* renamed from: b  reason: collision with root package name */
        e f7797b = null;

        /* renamed from: c  reason: collision with root package name */
        int f7798c;

        d() {
            this.f7796a = y.this.f7789f.f7803d;
            this.f7798c = y.this.f7788e;
        }

        /* access modifiers changed from: package-private */
        public final e a() {
            e eVar = this.f7796a;
            y yVar = y.this;
            if (eVar == yVar.f7789f) {
                throw new NoSuchElementException();
            } else if (yVar.f7788e == this.f7798c) {
                this.f7796a = eVar.f7803d;
                this.f7797b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            if (this.f7796a != y.this.f7789f) {
                return true;
            }
            return false;
        }

        public final void remove() {
            e eVar = this.f7797b;
            if (eVar != null) {
                y.this.g(eVar, true);
                this.f7797b = null;
                this.f7798c = y.this.f7788e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public y() {
        this(f7783i, true);
    }

    private static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void f(e eVar, boolean z4) {
        int i5;
        int i6;
        int i7;
        int i8;
        while (eVar != null) {
            e eVar2 = eVar.f7801b;
            e eVar3 = eVar.f7802c;
            int i9 = 0;
            if (eVar2 != null) {
                i5 = eVar2.f7808i;
            } else {
                i5 = 0;
            }
            if (eVar3 != null) {
                i6 = eVar3.f7808i;
            } else {
                i6 = 0;
            }
            int i10 = i5 - i6;
            if (i10 == -2) {
                e eVar4 = eVar3.f7801b;
                e eVar5 = eVar3.f7802c;
                if (eVar5 != null) {
                    i8 = eVar5.f7808i;
                } else {
                    i8 = 0;
                }
                if (eVar4 != null) {
                    i9 = eVar4.f7808i;
                }
                int i11 = i9 - i8;
                if (i11 == -1 || (i11 == 0 && !z4)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z4) {
                    return;
                }
            } else if (i10 == 2) {
                e eVar6 = eVar2.f7801b;
                e eVar7 = eVar2.f7802c;
                if (eVar7 != null) {
                    i7 = eVar7.f7808i;
                } else {
                    i7 = 0;
                }
                if (eVar6 != null) {
                    i9 = eVar6.f7808i;
                }
                int i12 = i9 - i7;
                if (i12 == 1 || (i12 == 0 && !z4)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z4) {
                    return;
                }
            } else if (i10 == 0) {
                eVar.f7808i = i5 + 1;
                if (z4) {
                    return;
                }
            } else {
                eVar.f7808i = Math.max(i5, i6) + 1;
                if (!z4) {
                    return;
                }
            }
            eVar = eVar.f7800a;
        }
    }

    private void i(e eVar, e eVar2) {
        e eVar3 = eVar.f7800a;
        eVar.f7800a = null;
        if (eVar2 != null) {
            eVar2.f7800a = eVar3;
        }
        if (eVar3 == null) {
            this.f7786c = eVar2;
        } else if (eVar3.f7801b == eVar) {
            eVar3.f7801b = eVar2;
        } else {
            eVar3.f7802c = eVar2;
        }
    }

    private void j(e eVar) {
        int i5;
        int i6;
        e eVar2 = eVar.f7801b;
        e eVar3 = eVar.f7802c;
        e eVar4 = eVar3.f7801b;
        e eVar5 = eVar3.f7802c;
        eVar.f7802c = eVar4;
        if (eVar4 != null) {
            eVar4.f7800a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f7801b = eVar;
        eVar.f7800a = eVar3;
        int i7 = 0;
        if (eVar2 != null) {
            i5 = eVar2.f7808i;
        } else {
            i5 = 0;
        }
        if (eVar4 != null) {
            i6 = eVar4.f7808i;
        } else {
            i6 = 0;
        }
        int max = Math.max(i5, i6) + 1;
        eVar.f7808i = max;
        if (eVar5 != null) {
            i7 = eVar5.f7808i;
        }
        eVar3.f7808i = Math.max(max, i7) + 1;
    }

    private void k(e eVar) {
        int i5;
        int i6;
        e eVar2 = eVar.f7801b;
        e eVar3 = eVar.f7802c;
        e eVar4 = eVar2.f7801b;
        e eVar5 = eVar2.f7802c;
        eVar.f7801b = eVar5;
        if (eVar5 != null) {
            eVar5.f7800a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f7802c = eVar;
        eVar.f7800a = eVar2;
        int i7 = 0;
        if (eVar3 != null) {
            i5 = eVar3.f7808i;
        } else {
            i5 = 0;
        }
        if (eVar5 != null) {
            i6 = eVar5.f7808i;
        } else {
            i6 = 0;
        }
        int max = Math.max(i5, i6) + 1;
        eVar.f7808i = max;
        if (eVar4 != null) {
            i7 = eVar4.f7808i;
        }
        eVar2.f7808i = Math.max(max, i7) + 1;
    }

    /* access modifiers changed from: package-private */
    public e b(Object obj, boolean z4) {
        int i5;
        e eVar;
        Comparable comparable;
        e eVar2;
        Comparator comparator = this.f7784a;
        e eVar3 = this.f7786c;
        if (eVar3 != null) {
            if (comparator == f7783i) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i5 = comparable.compareTo(eVar3.f7805f);
                } else {
                    i5 = comparator.compare(obj, eVar3.f7805f);
                }
                if (i5 == 0) {
                    return eVar3;
                }
                if (i5 < 0) {
                    eVar2 = eVar3.f7801b;
                } else {
                    eVar2 = eVar3.f7802c;
                }
                if (eVar2 == null) {
                    break;
                }
                eVar3 = eVar2;
            }
        } else {
            i5 = 0;
        }
        e eVar4 = eVar3;
        if (!z4) {
            return null;
        }
        e eVar5 = this.f7789f;
        if (eVar4 != null) {
            eVar = new e(this.f7785b, eVar4, obj, eVar5, eVar5.f7804e);
            if (i5 < 0) {
                eVar4.f7801b = eVar;
            } else {
                eVar4.f7802c = eVar;
            }
            f(eVar4, true);
        } else if (comparator != f7783i || (obj instanceof Comparable)) {
            eVar = new e(this.f7785b, eVar4, obj, eVar5, eVar5.f7804e);
            this.f7786c = eVar;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
        }
        this.f7787d++;
        this.f7788e++;
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public e c(Map.Entry entry) {
        e e5 = e(entry.getKey());
        if (e5 == null || !a(e5.f7807h, entry.getValue())) {
            return null;
        }
        return e5;
    }

    public void clear() {
        this.f7786c = null;
        this.f7787d = 0;
        this.f7788e++;
        e eVar = this.f7789f;
        eVar.f7804e = eVar;
        eVar.f7803d = eVar;
    }

    public boolean containsKey(Object obj) {
        if (e(obj) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public e e(Object obj) {
        if (obj != null) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public Set entrySet() {
        b bVar = this.f7790g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f7790g = bVar2;
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public void g(e eVar, boolean z4) {
        e eVar2;
        int i5;
        if (z4) {
            e eVar3 = eVar.f7804e;
            eVar3.f7803d = eVar.f7803d;
            eVar.f7803d.f7804e = eVar3;
        }
        e eVar4 = eVar.f7801b;
        e eVar5 = eVar.f7802c;
        e eVar6 = eVar.f7800a;
        int i6 = 0;
        if (eVar4 == null || eVar5 == null) {
            if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f7801b = null;
            } else if (eVar5 != null) {
                i(eVar, eVar5);
                eVar.f7802c = null;
            } else {
                i(eVar, (e) null);
            }
            f(eVar6, false);
            this.f7787d--;
            this.f7788e++;
            return;
        }
        if (eVar4.f7808i > eVar5.f7808i) {
            eVar2 = eVar4.b();
        } else {
            eVar2 = eVar5.a();
        }
        g(eVar2, false);
        e eVar7 = eVar.f7801b;
        if (eVar7 != null) {
            i5 = eVar7.f7808i;
            eVar2.f7801b = eVar7;
            eVar7.f7800a = eVar2;
            eVar.f7801b = null;
        } else {
            i5 = 0;
        }
        e eVar8 = eVar.f7802c;
        if (eVar8 != null) {
            i6 = eVar8.f7808i;
            eVar2.f7802c = eVar8;
            eVar8.f7800a = eVar2;
            eVar.f7802c = null;
        }
        eVar2.f7808i = Math.max(i5, i6) + 1;
        i(eVar, eVar2);
    }

    public Object get(Object obj) {
        e e5 = e(obj);
        if (e5 != null) {
            return e5.f7807h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public e h(Object obj) {
        e e5 = e(obj);
        if (e5 != null) {
            g(e5, true);
        }
        return e5;
    }

    public Set keySet() {
        c cVar = this.f7791h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f7791h = cVar2;
        return cVar2;
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        } else if (obj2 != null || this.f7785b) {
            e b5 = b(obj, true);
            Object obj3 = b5.f7807h;
            b5.f7807h = obj2;
            return obj3;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public Object remove(Object obj) {
        e h5 = h(obj);
        if (h5 != null) {
            return h5.f7807h;
        }
        return null;
    }

    public int size() {
        return this.f7787d;
    }

    public y(boolean z4) {
        this(f7783i, z4);
    }

    public y(Comparator comparator, boolean z4) {
        this.f7787d = 0;
        this.f7788e = 0;
        this.f7784a = comparator == null ? f7783i : comparator;
        this.f7785b = z4;
        this.f7789f = new e(z4);
    }

    static final class e implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        e f7800a;

        /* renamed from: b  reason: collision with root package name */
        e f7801b;

        /* renamed from: c  reason: collision with root package name */
        e f7802c;

        /* renamed from: d  reason: collision with root package name */
        e f7803d;

        /* renamed from: e  reason: collision with root package name */
        e f7804e;

        /* renamed from: f  reason: collision with root package name */
        final Object f7805f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f7806g;

        /* renamed from: h  reason: collision with root package name */
        Object f7807h;

        /* renamed from: i  reason: collision with root package name */
        int f7808i;

        e(boolean z4) {
            this.f7805f = null;
            this.f7806g = z4;
            this.f7804e = this;
            this.f7803d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f7801b; eVar2 != null; eVar2 = eVar2.f7801b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f7802c; eVar2 != null; eVar2 = eVar2.f7802c) {
                eVar = eVar2;
            }
            return eVar;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f7805f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f7807h;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public Object getKey() {
            return this.f7805f;
        }

        public Object getValue() {
            return this.f7807h;
        }

        public int hashCode() {
            int i5;
            Object obj = this.f7805f;
            int i6 = 0;
            if (obj == null) {
                i5 = 0;
            } else {
                i5 = obj.hashCode();
            }
            Object obj2 = this.f7807h;
            if (obj2 != null) {
                i6 = obj2.hashCode();
            }
            return i5 ^ i6;
        }

        public Object setValue(Object obj) {
            if (obj != null || this.f7806g) {
                Object obj2 = this.f7807h;
                this.f7807h = obj;
                return obj2;
            }
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f7805f + "=" + this.f7807h;
        }

        e(boolean z4, e eVar, Object obj, e eVar2, e eVar3) {
            this.f7800a = eVar;
            this.f7805f = obj;
            this.f7806g = z4;
            this.f7808i = 1;
            this.f7803d = eVar2;
            this.f7804e = eVar3;
            eVar3.f7803d = this;
            eVar2.f7804e = this;
        }
    }
}
