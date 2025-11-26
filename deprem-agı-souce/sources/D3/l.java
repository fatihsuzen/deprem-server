package D3;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.L;

public final class l {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18092b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18093c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18094d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18095e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray f18096a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        Class<l> cls = l.class;
        f18092b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask$volatile");
        f18093c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex$volatile");
        f18094d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex$volatile");
        f18095e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer$volatile");
    }

    private final h b(h hVar) {
        if (e() == 127) {
            return hVar;
        }
        if (hVar.f18083b) {
            f18095e.incrementAndGet(this);
        }
        int i5 = f18093c.get(this) & 127;
        while (this.f18096a.get(i5) != null) {
            Thread.yield();
        }
        this.f18096a.lazySet(i5, hVar);
        f18093c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar != null && hVar.f18083b) {
            f18095e.decrementAndGet(this);
        }
    }

    private final int e() {
        return f18093c.get(this) - f18094d.get(this);
    }

    private final h m() {
        h hVar;
        while (true) {
            int i5 = f18094d.get(this);
            if (i5 - f18093c.get(this) == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (f18094d.compareAndSet(this, i5, i5 + 1) && (hVar = (h) this.f18096a.getAndSet(i6, (Object) null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    private final boolean n(d dVar) {
        h m5 = m();
        if (m5 == null) {
            return false;
        }
        dVar.a(m5);
        return true;
    }

    private final h o(boolean z4) {
        h hVar;
        do {
            hVar = (h) f18092b.get(this);
            if (hVar == null || hVar.f18083b != z4) {
                int i5 = f18094d.get(this);
                int i6 = f18093c.get(this);
                while (i5 != i6) {
                    if (z4 && f18095e.get(this) == 0) {
                        return null;
                    }
                    i6--;
                    h q5 = q(i6, z4);
                    if (q5 != null) {
                        return q5;
                    }
                }
                return null;
            }
        } while (!a.a(f18092b, this, hVar, (Object) null));
        return hVar;
    }

    private final h p(int i5) {
        int i6 = f18094d.get(this);
        int i7 = f18093c.get(this);
        boolean z4 = true;
        if (i5 != 1) {
            z4 = false;
        }
        while (i6 != i7) {
            if (z4 && f18095e.get(this) == 0) {
                return null;
            }
            int i8 = i6 + 1;
            h q5 = q(i6, z4);
            if (q5 != null) {
                return q5;
            }
            i6 = i8;
        }
        return null;
    }

    private final h q(int i5, boolean z4) {
        int i6 = i5 & 127;
        h hVar = (h) this.f18096a.get(i6);
        if (hVar == null || hVar.f18083b != z4 || !y3.l.a(this.f18096a, i6, hVar, (Object) null)) {
            return null;
        }
        if (z4) {
            f18095e.decrementAndGet(this);
        }
        return hVar;
    }

    private final long s(int i5, L l5) {
        h hVar;
        int i6;
        do {
            hVar = (h) f18092b.get(this);
            if (hVar == null) {
                return -2;
            }
            if (hVar.f18083b) {
                i6 = 1;
            } else {
                i6 = 2;
            }
            if ((i6 & i5) == 0) {
                return -2;
            }
            long a5 = j.f18090f.a() - hVar.f18082a;
            long j5 = j.f18086b;
            if (a5 < j5) {
                return j5 - a5;
            }
        } while (!a.a(f18092b, this, hVar, (Object) null));
        l5.f24690a = hVar;
        return -1;
    }

    public final h a(h hVar, boolean z4) {
        if (z4) {
            return b(hVar);
        }
        h hVar2 = (h) f18092b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int i() {
        if (f18092b.get(this) != null) {
            return e() + 1;
        }
        return e();
    }

    public final void j(d dVar) {
        h hVar = (h) f18092b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (n(dVar));
    }

    public final h k() {
        h hVar = (h) f18092b.getAndSet(this, (Object) null);
        if (hVar == null) {
            return m();
        }
        return hVar;
    }

    public final h l() {
        return o(true);
    }

    public final long r(int i5, L l5) {
        h hVar;
        if (i5 == 3) {
            hVar = m();
        } else {
            hVar = p(i5);
        }
        if (hVar == null) {
            return s(i5, l5);
        }
        l5.f24690a = hVar;
        return -1;
    }
}
