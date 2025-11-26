package k0;

import N.C0722p;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: k0.o  reason: case insensitive filesystem */
public abstract class C1701o {
    public static Object a(C1698l lVar) {
        C0722p.i();
        C0722p.g();
        C0722p.l(lVar, "Task must not be null");
        if (lVar.m()) {
            return h(lVar);
        }
        r rVar = new r((q) null);
        i(lVar, rVar);
        rVar.c();
        return h(lVar);
    }

    public static Object b(C1698l lVar, long j5, TimeUnit timeUnit) {
        C0722p.i();
        C0722p.g();
        C0722p.l(lVar, "Task must not be null");
        C0722p.l(timeUnit, "TimeUnit must not be null");
        if (lVar.m()) {
            return h(lVar);
        }
        r rVar = new r((q) null);
        i(lVar, rVar);
        if (rVar.e(j5, timeUnit)) {
            return h(lVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static C1698l c(Executor executor, Callable callable) {
        C0722p.l(executor, "Executor must not be null");
        C0722p.l(callable, "Callback must not be null");
        O o5 = new O();
        executor.execute(new P(o5, callable));
        return o5;
    }

    public static C1698l d(Exception exc) {
        O o5 = new O();
        o5.q(exc);
        return o5;
    }

    public static C1698l e(Object obj) {
        O o5 = new O();
        o5.r(obj);
        return o5;
    }

    public static C1698l f(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return e((Object) null);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((C1698l) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        O o5 = new O();
        t tVar = new t(collection.size(), o5);
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            i((C1698l) it2.next(), tVar);
        }
        return o5;
    }

    public static C1698l g(C1698l... lVarArr) {
        if (lVarArr == null || lVarArr.length == 0) {
            return e((Object) null);
        }
        return f(Arrays.asList(lVarArr));
    }

    private static Object h(C1698l lVar) {
        if (lVar.n()) {
            return lVar.j();
        }
        if (lVar.l()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(lVar.i());
    }

    private static void i(C1698l lVar, s sVar) {
        Executor executor = C1700n.f15490b;
        lVar.f(executor, sVar);
        lVar.d(executor, sVar);
        lVar.a(executor, sVar);
    }
}
