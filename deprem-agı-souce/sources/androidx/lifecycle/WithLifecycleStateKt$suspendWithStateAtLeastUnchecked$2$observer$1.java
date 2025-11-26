package androidx.lifecycle;

import W2.t;
import W2.u;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import k3.C2616a;
import kotlin.jvm.internal.t;
import w3.C2882l;

public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ C2616a $block;
    final /* synthetic */ C2882l $co;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, C2882l lVar, C2616a aVar) {
        this.$state = state;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
        this.$co = lVar;
        this.$block = aVar;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Object obj;
        t.e(lifecycleOwner, "source");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.Companion.upTo(this.$state)) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            C2882l lVar = this.$co;
            C2616a aVar = this.$block;
            try {
                t.a aVar2 = W2.t.f19966b;
                obj = W2.t.b(aVar.invoke());
            } catch (Throwable th) {
                t.a aVar3 = W2.t.f19966b;
                obj = W2.t.b(u.a(th));
            }
            lVar.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked.removeObserver(this);
            C2882l lVar2 = this.$co;
            t.a aVar4 = W2.t.f19966b;
            lVar2.resumeWith(W2.t.b(u.a(new LifecycleDestroyedException())));
        }
    }
}
