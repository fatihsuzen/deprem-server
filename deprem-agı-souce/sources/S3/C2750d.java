package s3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: s3.d  reason: case insensitive filesystem */
final class C2750d implements C2751e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C2616a f25831a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final l f25832b;

    /* renamed from: s3.d$a */
    public static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private Object f25833a;

        /* renamed from: b  reason: collision with root package name */
        private int f25834b = -2;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2750d f25835c;

        a(C2750d dVar) {
            this.f25835c = dVar;
        }

        private final void a() {
            Object obj;
            int i5;
            if (this.f25834b == -2) {
                obj = this.f25835c.f25831a.invoke();
            } else {
                l b5 = this.f25835c.f25832b;
                Object obj2 = this.f25833a;
                t.b(obj2);
                obj = b5.invoke(obj2);
            }
            this.f25833a = obj;
            if (obj == null) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            this.f25834b = i5;
        }

        public boolean hasNext() {
            if (this.f25834b < 0) {
                a();
            }
            if (this.f25834b == 1) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.f25834b < 0) {
                a();
            }
            if (this.f25834b != 0) {
                Object obj = this.f25833a;
                t.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f25834b = -1;
                return obj;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2750d(C2616a aVar, l lVar) {
        t.e(aVar, "getInitialValue");
        t.e(lVar, "getNextValue");
        this.f25831a = aVar;
        this.f25832b = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
