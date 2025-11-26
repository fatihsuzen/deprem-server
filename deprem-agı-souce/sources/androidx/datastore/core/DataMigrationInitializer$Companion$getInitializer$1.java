package androidx.datastore.core;

import W2.J;
import W2.u;
import androidx.datastore.core.DataMigrationInitializer;
import b3.C2308e;
import c3.C2316b;
import java.util.List;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
final class DataMigrationInitializer$Companion$getInitializer$1 extends l implements p {
    final /* synthetic */ List<DataMigration<T>> $migrations;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$getInitializer$1(List<? extends DataMigration<T>> list, C2308e eVar) {
        super(2, eVar);
        this.$migrations = list;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        DataMigrationInitializer$Companion$getInitializer$1 dataMigrationInitializer$Companion$getInitializer$1 = new DataMigrationInitializer$Companion$getInitializer$1(this.$migrations, eVar);
        dataMigrationInitializer$Companion$getInitializer$1.L$0 = obj;
        return dataMigrationInitializer$Companion$getInitializer$1;
    }

    public final Object invoke(InitializerApi<T> initializerApi, C2308e eVar) {
        return ((DataMigrationInitializer$Companion$getInitializer$1) create(initializerApi, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            DataMigrationInitializer.Companion companion = DataMigrationInitializer.Companion;
            List<DataMigration<T>> list = this.$migrations;
            this.label = 1;
            if (companion.runMigrations(list, (InitializerApi) this.L$0, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }
}
