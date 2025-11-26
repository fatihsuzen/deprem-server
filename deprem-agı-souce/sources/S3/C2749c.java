package s3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.l;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: s3.c  reason: case insensitive filesystem */
public final class C2749c implements C2751e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C2751e f25824a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f25825b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final l f25826c;

    /* renamed from: s3.c$a */
    public static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f25827a;

        /* renamed from: b  reason: collision with root package name */
        private int f25828b = -1;

        /* renamed from: c  reason: collision with root package name */
        private Object f25829c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2749c f25830d;

        a(C2749c cVar) {
            this.f25830d = cVar;
            this.f25827a = cVar.f25824a.iterator();
        }

        private final void a() {
            while (this.f25827a.hasNext()) {
                Object next = this.f25827a.next();
                if (((Boolean) this.f25830d.f25826c.invoke(next)).booleanValue() == this.f25830d.f25825b) {
                    this.f25829c = next;
                    this.f25828b = 1;
                    return;
                }
            }
            this.f25828b = 0;
        }

        public boolean hasNext() {
            if (this.f25828b == -1) {
                a();
            }
            if (this.f25828b == 1) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.f25828b == -1) {
                a();
            }
            if (this.f25828b != 0) {
                Object obj = this.f25829c;
                this.f25829c = null;
                this.f25828b = -1;
                return obj;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2749c(C2751e eVar, boolean z4, l lVar) {
        t.e(eVar, "sequence");
        t.e(lVar, "predicate");
        this.f25824a = eVar;
        this.f25825b = z4;
        this.f25826c = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
