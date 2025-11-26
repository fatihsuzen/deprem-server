package com.inmobi.cmp.core.model;

import J2.x;
import J2.y;
import J2.z;
import X2.C2250q;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import k3.l;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public final class Vector {

    /* renamed from: a  reason: collision with root package name */
    private Map f7843a;

    /* renamed from: b  reason: collision with root package name */
    private int f7844b;

    public Vector() {
        this((Map) null, 1, (C2633k) null);
    }

    public static /* synthetic */ Vector copy$default(Vector vector, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            map = vector.f7843a;
        }
        return vector.copy(map);
    }

    public final void clear() {
        this.f7843a.clear();
    }

    public final Map<Integer, Boolean> component1() {
        return this.f7843a;
    }

    public final boolean contains(int i5) {
        return this.f7843a.containsKey(Integer.valueOf(i5));
    }

    public final Vector copy(Map<Integer, Boolean> map) {
        t.e(map, "map");
        return new Vector(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Vector) && t.a(this.f7843a, ((Vector) obj).f7843a);
    }

    public final void forEach(p pVar) {
        t.e(pVar, "action");
        for (Map.Entry entry : this.f7843a.entrySet()) {
            pVar.invoke(entry.getKey(), entry.getValue());
        }
    }

    public final void forEachMap(l lVar) {
        t.e(lVar, "action");
        for (Map.Entry invoke : this.f7843a.entrySet()) {
            lVar.invoke(invoke);
        }
    }

    public final Boolean get(int i5) {
        return (Boolean) this.f7843a.get(Integer.valueOf(i5));
    }

    public final Set<Integer> getAcceptedItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Number intValue : getMap().keySet()) {
            int intValue2 = intValue.intValue();
            if (t.a(get(intValue2), Boolean.TRUE)) {
                linkedHashSet.add(Integer.valueOf(intValue2));
            }
        }
        return linkedHashSet;
    }

    public final int getBitLength() {
        return this.f7844b;
    }

    public final Set<Integer> getKeys() {
        return this.f7843a.keySet();
    }

    public final Map<Integer, Boolean> getMap() {
        return this.f7843a;
    }

    public final int getMaxId() {
        Integer num = (Integer) C2250q.Z(this.f7843a.keySet());
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        return this.f7843a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f7843a.isEmpty();
    }

    public final void set(int i5) {
        this.f7843a.put(Integer.valueOf(i5), Boolean.TRUE);
    }

    public final void setAllOwnedItems() {
        for (Map.Entry key : this.f7843a.entrySet()) {
            set(((Number) key.getKey()).intValue());
        }
    }

    public final void setBitLength(int i5) {
        this.f7844b = i5;
    }

    public final void setItems(Set<Integer> set) {
        t.e(set, "ids");
        for (Number intValue : set) {
            getMap().put(Integer.valueOf(intValue.intValue()), Boolean.TRUE);
            setBitLength(0);
        }
    }

    public final void setMap(Map<Integer, Boolean> map) {
        t.e(map, "<set-?>");
        this.f7843a = map;
    }

    public final void setOwnedItems(Vector vector) {
        if (vector != null) {
            vector.forEach(new y(this));
        }
    }

    public final int size() {
        return this.f7843a.size();
    }

    public String toString() {
        return "Vector(map=" + this.f7843a + ')';
    }

    public final void unset(int i5) {
        this.f7843a.put(Integer.valueOf(i5), Boolean.FALSE);
        this.f7844b = 0;
    }

    public final void unsetAllOwnedItems() {
        for (Map.Entry key : this.f7843a.entrySet()) {
            unset(((Number) key.getKey()).intValue());
        }
    }

    public Vector(Map<Integer, Boolean> map) {
        t.e(map, "map");
        this.f7843a = map;
    }

    public final void set(Vector vector) {
        if (vector != null) {
            vector.forEach(new x(this));
        }
    }

    public final void set(Set<String> set) {
        t.e(set, "ids");
        for (String t5 : set) {
            Integer t6 = s.t(t5);
            if (t6 != null) {
                getMap().put(Integer.valueOf(t6.intValue()), Boolean.TRUE);
                setBitLength(0);
            }
        }
    }

    public final void unset(Vector vector) {
        forEach(new z(vector, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Vector(Map map, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? new LinkedHashMap() : map);
    }

    public final void unset(Set<Integer> set) {
        t.e(set, "ids");
        for (Number intValue : set) {
            getMap().put(Integer.valueOf(intValue.intValue()), Boolean.FALSE);
            setBitLength(0);
        }
    }
}
