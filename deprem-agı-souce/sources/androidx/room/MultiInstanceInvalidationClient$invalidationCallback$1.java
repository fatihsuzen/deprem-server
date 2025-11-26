package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.O;

public final class MultiInstanceInvalidationClient$invalidationCallback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$invalidationCallback$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onInvalidation(String[] strArr) {
        t.e(strArr, "tables");
        C2908y0 unused = C2876i.d(this.this$0.coroutineScope, (C2312i) null, (O) null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(strArr, this.this$0, (C2308e) null), 3, (Object) null);
    }
}
