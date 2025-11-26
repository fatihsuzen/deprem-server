package z0;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import u0.g;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final List f17223a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f17224b;

    public k(int i5) {
        this.f17224b = i5;
    }

    public List a() {
        List b5 = b();
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < b5.size(); i5++) {
            arrayList.add(((j) b5.get(i5)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return DesugarCollections.unmodifiableList(new ArrayList(this.f17223a));
    }

    public synchronized boolean c(List list) {
        this.f17223a.clear();
        if (list.size() > this.f17224b) {
            g f5 = g.f();
            f5.k("Ignored " + 0 + " entries when adding rollout assignments. Maximum allowable: " + this.f17224b);
            return this.f17223a.addAll(list.subList(0, this.f17224b));
        }
        return this.f17223a.addAll(list);
    }
}
