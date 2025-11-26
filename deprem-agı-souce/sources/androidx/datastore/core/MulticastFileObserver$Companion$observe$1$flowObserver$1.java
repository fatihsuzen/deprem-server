package androidx.datastore.core;

import W2.J;
import java.io.File;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import y3.n;
import y3.v;

final class MulticastFileObserver$Companion$observe$1$flowObserver$1 extends u implements l {
    final /* synthetic */ v $$this$channelFlow;
    final /* synthetic */ File $file;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MulticastFileObserver$Companion$observe$1$flowObserver$1(File file, v vVar) {
        super(1);
        this.$file = file;
        this.$$this$channelFlow = vVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return J.f19942a;
    }

    public final void invoke(String str) {
        if (t.a(str, this.$file.getName())) {
            n.b(this.$$this$channelFlow, J.f19942a);
        }
    }
}
