package androidx.work.impl.model;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;

public abstract /* synthetic */ class x0 {
    public static void a(WorkTagDao workTagDao, String str, Set set) {
        t.e(str, "id");
        t.e(set, "tags");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), str));
        }
    }
}
