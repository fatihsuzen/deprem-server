package h4;

import g4.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingDeque;
import p4.a;

public class h {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23764c = b.i(h.class);

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingDeque f23765a = new LinkedBlockingDeque();

    /* renamed from: b  reason: collision with root package name */
    private final i f23766b;

    public h(i iVar) {
        this.f23766b = iVar;
    }

    public void a(g gVar) {
        this.f23765a.add(gVar);
    }

    public void b(List list) {
        this.f23765a.drainTo(list);
    }

    public boolean c() {
        if (!this.f23765a.isEmpty() || !this.f23766b.d()) {
            return false;
        }
        return true;
    }

    public void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f23765a.offerFirst((g) it.next());
        }
    }

    public boolean e(boolean z4) {
        if (z4) {
            List f5 = this.f23766b.f();
            ListIterator listIterator = f5.listIterator(f5.size());
            while (listIterator.hasPrevious()) {
                this.f23765a.offerFirst((g) listIterator.previous());
            }
            a.b(f23764c).a("Switched state to ONLINE, uncached %d events from disk.", Integer.valueOf(f5.size()));
        } else if (!this.f23765a.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.f23765a.drainTo(arrayList);
            this.f23766b.a(arrayList);
            a.b(f23764c).a("Switched state to OFFLINE, caching %d events to disk.", Integer.valueOf(arrayList.size()));
        }
        if (!z4 || this.f23765a.isEmpty()) {
            return false;
        }
        return true;
    }
}
