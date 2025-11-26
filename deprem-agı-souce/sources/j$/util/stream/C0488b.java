package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.stream.b  reason: case insensitive filesystem */
public abstract class C0488b extends C0498d {

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference f1662h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f1663i;

    public abstract Object h();

    public C0488b(C0594w1 w1Var, Spliterator spliterator) {
        super(w1Var, spliterator);
        this.f1662h = new AtomicReference((Object) null);
    }

    public C0488b(C0488b bVar, Spliterator spliterator) {
        super((C0498d) bVar, spliterator);
        this.f1662h = bVar.f1662h;
    }

    public final void compute() {
        Object obj;
        Spliterator trySplit;
        Spliterator spliterator = this.f1690b;
        long estimateSize = spliterator.estimateSize();
        long j5 = this.f1691c;
        if (j5 == 0) {
            j5 = C0498d.e(estimateSize);
            this.f1691c = j5;
        }
        AtomicReference atomicReference = this.f1662h;
        boolean z4 = false;
        C0488b bVar = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z5 = bVar.f1663i;
            if (!z5) {
                CountedCompleter<?> completer = bVar.getCompleter();
                while (true) {
                    C0488b bVar2 = (C0488b) ((C0498d) completer);
                    if (z5 || bVar2 == null) {
                        break;
                    }
                    z5 = bVar2.f1663i;
                    completer = bVar2.getCompleter();
                }
            }
            if (z5) {
                obj = bVar.h();
                break;
            } else if (estimateSize <= j5 || (trySplit = spliterator.trySplit()) == null) {
                obj = bVar.a();
            } else {
                C0488b bVar3 = (C0488b) bVar.c(trySplit);
                bVar.f1692d = bVar3;
                C0488b bVar4 = (C0488b) bVar.c(spliterator);
                bVar.f1693e = bVar4;
                bVar.setPendingCount(1);
                if (z4) {
                    spliterator = trySplit;
                    bVar = bVar3;
                    bVar3 = bVar4;
                } else {
                    bVar = bVar4;
                }
                z4 = !z4;
                bVar3.fork();
                estimateSize = spliterator.estimateSize();
            }
        }
        obj = bVar.a();
        bVar.d(obj);
        bVar.tryComplete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000a A[LOOP:0: B:4:0x000a->B:7:0x0016, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r2.b()
            if (r0 == 0) goto L_0x0019
            if (r3 == 0) goto L_0x0018
            java.util.concurrent.atomic.AtomicReference r0 = r2.f1662h
        L_0x000a:
            r1 = 0
            boolean r1 = r0.compareAndSet(r1, r3)
            if (r1 == 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x000a
        L_0x0018:
            return
        L_0x0019:
            r2.f1694f = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0488b.d(java.lang.Object):void");
    }

    public final Object getRawResult() {
        return i();
    }

    public final Object i() {
        if (!b()) {
            return this.f1694f;
        }
        Object obj = this.f1662h.get();
        if (obj == null) {
            return h();
        }
        return obj;
    }

    public void f() {
        this.f1663i = true;
    }

    public final void g() {
        C0488b bVar = this;
        for (C0488b bVar2 = (C0488b) ((C0498d) getCompleter()); bVar2 != null; bVar2 = (C0488b) ((C0498d) bVar2.getCompleter())) {
            if (bVar2.f1692d == bVar) {
                C0488b bVar3 = (C0488b) bVar2.f1693e;
                if (!bVar3.f1663i) {
                    bVar3.f();
                }
            }
            bVar = bVar2;
        }
    }
}
