package androidx.work;

import androidx.annotation.RestrictTo;
import d3.C2344a;
import d3.C2345b;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public enum DirectExecutor implements Executor {
    INSTANCE;

    static {
        DirectExecutor[] $values;
        $ENTRIES = C2345b.a($values);
    }

    public static C2344a getEntries() {
        return $ENTRIES;
    }

    public void execute(Runnable runnable) {
        t.e(runnable, "command");
        runnable.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}
