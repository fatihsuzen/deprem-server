package F3;

import B3.A;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class m extends A {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f18137e = new AtomicReferenceArray(l.f18136f);

    public m(long j5, m mVar, int i5) {
        super(j5, mVar, i5);
    }

    public int r() {
        return l.f18136f;
    }

    public void s(int i5, Throwable th, C2312i iVar) {
        v().set(i5, l.f18135e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f17367c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.f18137e;
    }
}
