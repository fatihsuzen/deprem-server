package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.measurement.f  reason: case insensitive filesystem */
public final class C1092f implements Iterable, r, C1164n {

    /* renamed from: a  reason: collision with root package name */
    final SortedMap f5340a;

    /* renamed from: b  reason: collision with root package name */
    final Map f5341b;

    public C1092f() {
        this.f5340a = new TreeMap();
        this.f5341b = new TreeMap();
    }

    public final Double C() {
        SortedMap sortedMap = this.f5340a;
        if (sortedMap.size() == 1) {
            return q(0).C();
        }
        if (sortedMap.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    public final String b() {
        return w(",");
    }

    public final Iterator c() {
        return new C1074d(this, this.f5340a.keySet().iterator(), this.f5341b.keySet().iterator());
    }

    public final Boolean d() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1092f)) {
            return false;
        }
        C1092f fVar = (C1092f) obj;
        if (o() != fVar.o()) {
            return false;
        }
        SortedMap sortedMap = this.f5340a;
        if (sortedMap.isEmpty()) {
            return fVar.f5340a.isEmpty();
        }
        for (int intValue = ((Integer) sortedMap.firstKey()).intValue(); intValue <= ((Integer) sortedMap.lastKey()).intValue(); intValue++) {
            if (!q(intValue).equals(fVar.q(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final r f(String str) {
        r rVar;
        if ("length".equals(str)) {
            return new C1128j(Double.valueOf((double) o()));
        }
        if (!i(str) || (rVar = (r) this.f5341b.get(str)) == null) {
            return r.f5553b0;
        }
        return rVar;
    }

    public final void g(String str, r rVar) {
        if (rVar == null) {
            this.f5341b.remove(str);
        } else {
            this.f5341b.put(str, rVar);
        }
    }

    public final int hashCode() {
        return this.f5340a.hashCode() * 31;
    }

    public final boolean i(String str) {
        if ("length".equals(str) || this.f5341b.containsKey(str)) {
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        return new C1083e(this);
    }

    public final r j() {
        C1092f fVar = new C1092f();
        for (Map.Entry entry : this.f5340a.entrySet()) {
            if (entry.getValue() instanceof C1164n) {
                fVar.f5340a.put((Integer) entry.getKey(), (r) entry.getValue());
            } else {
                fVar.f5340a.put((Integer) entry.getKey(), ((r) entry.getValue()).j());
            }
        }
        return fVar;
    }

    public final r k(String str, U1 u12, List list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return E.a(str, this, u12, list);
        }
        return C1155m.a(this, new C1235v(str), u12, list);
    }

    public final List l() {
        ArrayList arrayList = new ArrayList(o());
        for (int i5 = 0; i5 < o(); i5++) {
            arrayList.add(q(i5));
        }
        return arrayList;
    }

    public final Iterator n() {
        return this.f5340a.keySet().iterator();
    }

    public final int o() {
        SortedMap sortedMap = this.f5340a;
        if (sortedMap.isEmpty()) {
            return 0;
        }
        return ((Integer) sortedMap.lastKey()).intValue() + 1;
    }

    public final int p() {
        return this.f5340a.size();
    }

    public final r q(int i5) {
        r rVar;
        if (i5 >= o()) {
            throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
        } else if (!s(i5) || (rVar = (r) this.f5340a.get(Integer.valueOf(i5))) == null) {
            return r.f5553b0;
        } else {
            return rVar;
        }
    }

    public final void r(int i5, r rVar) {
        if (i5 > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i5 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i5);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (rVar == null) {
            this.f5340a.remove(Integer.valueOf(i5));
        } else {
            this.f5340a.put(Integer.valueOf(i5), rVar);
        }
    }

    public final boolean s(int i5) {
        if (i5 >= 0) {
            SortedMap sortedMap = this.f5340a;
            if (i5 <= ((Integer) sortedMap.lastKey()).intValue()) {
                return sortedMap.containsKey(Integer.valueOf(i5));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i5);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void t() {
        this.f5340a.clear();
    }

    public final String toString() {
        return w(",");
    }

    public final void u(int i5, r rVar) {
        if (i5 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 21);
            sb.append("Invalid value index: ");
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        } else if (i5 >= o()) {
            r(i5, rVar);
        } else {
            SortedMap sortedMap = this.f5340a;
            for (int intValue = ((Integer) sortedMap.lastKey()).intValue(); intValue >= i5; intValue--) {
                Integer valueOf = Integer.valueOf(intValue);
                r rVar2 = (r) sortedMap.get(valueOf);
                if (rVar2 != null) {
                    r(intValue + 1, rVar2);
                    sortedMap.remove(valueOf);
                }
            }
            r(i5, rVar);
        }
    }

    public final void v(int i5) {
        SortedMap sortedMap = this.f5340a;
        int intValue = ((Integer) sortedMap.lastKey()).intValue();
        if (i5 <= intValue && i5 >= 0) {
            sortedMap.remove(Integer.valueOf(i5));
            if (i5 == intValue) {
                int i6 = i5 - 1;
                Integer valueOf = Integer.valueOf(i6);
                if (!sortedMap.containsKey(valueOf) && i6 >= 0) {
                    sortedMap.put(valueOf, r.f5553b0);
                    return;
                }
                return;
            }
            while (true) {
                i5++;
                if (i5 <= ((Integer) sortedMap.lastKey()).intValue()) {
                    Integer valueOf2 = Integer.valueOf(i5);
                    r rVar = (r) sortedMap.get(valueOf2);
                    if (rVar != null) {
                        sortedMap.put(Integer.valueOf(i5 - 1), rVar);
                        sortedMap.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final String w(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.f5340a.isEmpty()) {
            int i5 = 0;
            while (true) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i5 >= o()) {
                    break;
                }
                r q5 = q(i5);
                sb.append(str2);
                if (!(q5 instanceof C1244w) && !(q5 instanceof C1182p)) {
                    sb.append(q5.b());
                }
                i5++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public C1092f(List list) {
        this();
        if (list != null) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                r(i5, (r) list.get(i5));
            }
        }
    }
}
