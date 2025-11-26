package androidx.datastore.migrations;

import b3.C2308e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.android.kt", l = {151}, m = "shouldMigrate")
final class SharedPreferencesMigration$shouldMigrate$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedPreferencesMigration<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesMigration$shouldMigrate$1(SharedPreferencesMigration<T> sharedPreferencesMigration, C2308e eVar) {
        super(eVar);
        this.this$0 = sharedPreferencesMigration;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.shouldMigrate(null, this);
    }
}
