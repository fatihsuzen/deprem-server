package s3;

import java.util.Iterator;
import k3.l;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: s3.p  reason: case insensitive filesystem */
public final class C2762p implements C2751e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C2751e f25844a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final l f25845b;

    /* renamed from: s3.p$a */
    public static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f25846a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2762p f25847b;

        a(C2762p pVar) {
            this.f25847b = pVar;
            this.f25846a = pVar.f25844a.iterator();
        }

        public boolean hasNext() {
            return this.f25846a.hasNext();
        }

        public Object next() {
            return this.f25847b.f25845b.invoke(this.f25846a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2762p(C2751e eVar, l lVar) {
        t.e(eVar, "sequence");
        t.e(lVar, "transformer");
        this.f25844a = eVar;
        this.f25845b = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
