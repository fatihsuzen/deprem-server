package androidx.datastore;

import android.content.Context;
import e4.Q;
import k3.C2616a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class DataStoreSingletonDelegate$getValue$1$1 extends u implements C2616a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ DataStoreSingletonDelegate<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = dataStoreSingletonDelegate;
    }

    public final Q invoke() {
        Q.a aVar = Q.f21501b;
        Context context = this.$applicationContext;
        t.d(context, "applicationContext");
        String absolutePath = DataStoreFile.dataStoreFile(context, this.this$0.fileName).getAbsolutePath();
        t.d(absolutePath, "applicationContext.dataS…le(fileName).absolutePath");
        return Q.a.e(aVar, absolutePath, false, 1, (Object) null);
    }
}
