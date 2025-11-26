package J3;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import l3.C2677a;

public abstract class j {

    public static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private int f18382a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f18383b;

        a(f fVar) {
            this.f18383b = fVar;
            this.f18382a = fVar.e();
        }

        /* renamed from: a */
        public f next() {
            f fVar = this.f18383b;
            int e5 = fVar.e();
            int i5 = this.f18382a;
            this.f18382a = i5 - 1;
            return fVar.h(e5 - i5);
        }

        public boolean hasNext() {
            if (this.f18382a > 0) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private int f18384a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f18385b;

        b(f fVar) {
            this.f18385b = fVar;
            this.f18384a = fVar.e();
        }

        /* renamed from: a */
        public String next() {
            f fVar = this.f18385b;
            int e5 = fVar.e();
            int i5 = this.f18384a;
            this.f18384a = i5 - 1;
            return fVar.f(e5 - i5);
        }

        public boolean hasNext() {
            if (this.f18384a > 0) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class c implements Iterable, C2677a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f18386a;

        public c(f fVar) {
            this.f18386a = fVar;
        }

        public Iterator iterator() {
            return new a(this.f18386a);
        }
    }

    public static final class d implements Iterable, C2677a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f18387a;

        public d(f fVar) {
            this.f18387a = fVar;
        }

        public Iterator iterator() {
            return new b(this.f18387a);
        }
    }

    public static final Iterable a(f fVar) {
        t.e(fVar, "<this>");
        return new c(fVar);
    }

    public static final Iterable b(f fVar) {
        t.e(fVar, "<this>");
        return new d(fVar);
    }
}
