package w3;

import b3.C2313j;
import java.util.concurrent.Executor;

/* renamed from: w3.b0  reason: case insensitive filesystem */
final class C2863b0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final I f26270a;

    public C2863b0(I i5) {
        this.f26270a = i5;
    }

    public void execute(Runnable runnable) {
        I i5 = this.f26270a;
        C2313j jVar = C2313j.f20794a;
        if (i5.isDispatchNeeded(jVar)) {
            this.f26270a.dispatch(jVar, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f26270a.toString();
    }
}
