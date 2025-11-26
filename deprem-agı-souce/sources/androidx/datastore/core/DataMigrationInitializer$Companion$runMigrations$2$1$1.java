package androidx.datastore.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends l implements k3.l {
    final /* synthetic */ DataMigration<T> $migration;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$2$1$1(DataMigration<T> dataMigration, C2308e eVar) {
        super(1, eVar);
        this.$migration = dataMigration;
    }

    public final C2308e create(C2308e eVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.$migration, eVar);
    }

    public final Object invoke(C2308e eVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            DataMigration<T> dataMigration = this.$migration;
            this.label = 1;
            if (dataMigration.cleanUp(this) == f5) {
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
