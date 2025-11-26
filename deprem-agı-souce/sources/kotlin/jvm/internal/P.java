package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class P {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f24694a;

    public P(int i5) {
        this.f24694a = new ArrayList(i5);
    }

    public void a(Object obj) {
        this.f24694a.add(obj);
    }

    public void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList arrayList = this.f24694a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.f24694a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.f24694a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.f24694a.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    this.f24694a.add(it.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }
    }

    public int c() {
        return this.f24694a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f24694a.toArray(objArr);
    }
}
