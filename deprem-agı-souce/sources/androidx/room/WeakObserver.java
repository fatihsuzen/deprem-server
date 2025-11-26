package androidx.room;

import androidx.room.InvalidationTracker;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class WeakObserver extends InvalidationTracker.Observer {
    private final WeakReference<InvalidationTracker.Observer> delegateRef;
    private final InvalidationTracker tracker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeakObserver(InvalidationTracker invalidationTracker, InvalidationTracker.Observer observer) {
        super(observer.getTables$room_runtime_release());
        t.e(invalidationTracker, "tracker");
        t.e(observer, "delegate");
        this.tracker = invalidationTracker;
        this.delegateRef = new WeakReference<>(observer);
    }

    public void onInvalidated(Set<String> set) {
        t.e(set, "tables");
        InvalidationTracker.Observer observer = this.delegateRef.get();
        if (observer == null) {
            this.tracker.removeObserver(this);
        } else {
            observer.onInvalidated(set);
        }
    }
}
