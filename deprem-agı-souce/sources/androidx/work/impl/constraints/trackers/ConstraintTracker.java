package androidx.work.impl.constraints.trackers;

import W2.J;
import X2.C2250q;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners = new LinkedHashSet<>();
    private final Object lock = new Object();
    private final TaskExecutor taskExecutor;

    protected ConstraintTracker(Context context, TaskExecutor taskExecutor2) {
        t.e(context, "context");
        t.e(taskExecutor2, "taskExecutor");
        this.taskExecutor = taskExecutor2;
        Context applicationContext = context.getApplicationContext();
        t.d(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
    }

    /* access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List list, ConstraintTracker constraintTracker) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(constraintTracker.currentState);
        }
    }

    public final void addListener(ConstraintListener<T> constraintListener) {
        t.e(constraintListener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.add(constraintListener)) {
                    if (this.listeners.size() == 1) {
                        this.currentState = readSystemState();
                        Logger logger = Logger.get();
                        String access$getTAG$p = ConstraintTrackerKt.TAG;
                        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": initial state = " + this.currentState);
                        startTracking();
                    }
                    constraintListener.onConstraintChanged(this.currentState);
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Context getAppContext() {
        return this.appContext;
    }

    public final T getState() {
        T t5 = this.currentState;
        if (t5 == null) {
            return readSystemState();
        }
        return t5;
    }

    public abstract T readSystemState();

    public final void removeListener(ConstraintListener<T> constraintListener) {
        t.e(constraintListener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.remove(constraintListener) && this.listeners.isEmpty()) {
                    stopTracking();
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setState(T t5) {
        synchronized (this.lock) {
            T t6 = this.currentState;
            if (t6 == null || !t.a(t6, t5)) {
                this.currentState = t5;
                this.taskExecutor.getMainThreadExecutor().execute(new a(C2250q.n0(this.listeners), this));
                J j5 = J.f19942a;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
