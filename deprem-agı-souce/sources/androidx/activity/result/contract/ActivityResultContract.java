package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.t;

public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t5) {
            this.value = t5;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i5);

    public SynchronousResult<O> getSynchronousResult(Context context, I i5) {
        t.e(context, "context");
        return null;
    }

    public abstract O parseResult(int i5, Intent intent);
}
