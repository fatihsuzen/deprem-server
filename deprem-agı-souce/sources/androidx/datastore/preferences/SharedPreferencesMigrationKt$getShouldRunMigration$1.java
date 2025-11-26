package androidx.datastore.preferences;

import W2.J;
import W2.u;
import X2.C2250q;
import androidx.datastore.preferences.core.Preferences;
import b.w;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getShouldRunMigration$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
final class SharedPreferencesMigrationKt$getShouldRunMigration$1 extends l implements p {
    final /* synthetic */ Set<String> $keysToMigrate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesMigrationKt$getShouldRunMigration$1(Set<String> set, C2308e eVar) {
        super(2, eVar);
        this.$keysToMigrate = set;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        SharedPreferencesMigrationKt$getShouldRunMigration$1 sharedPreferencesMigrationKt$getShouldRunMigration$1 = new SharedPreferencesMigrationKt$getShouldRunMigration$1(this.$keysToMigrate, eVar);
        sharedPreferencesMigrationKt$getShouldRunMigration$1.L$0 = obj;
        return sharedPreferencesMigrationKt$getShouldRunMigration$1;
    }

    public final Object invoke(Preferences preferences, C2308e eVar) {
        return ((SharedPreferencesMigrationKt$getShouldRunMigration$1) create(preferences, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        if (this.label == 0) {
            u.b(obj);
            Set<Preferences.Key<?>> keySet = ((Preferences) this.L$0).asMap().keySet();
            ArrayList arrayList = new ArrayList(C2250q.p(keySet, 10));
            for (Preferences.Key name : keySet) {
                arrayList.add(name.getName());
            }
            boolean z4 = true;
            if (this.$keysToMigrate != SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS()) {
                Set<String> set = this.$keysToMigrate;
                if (!w.a(set) || !set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!arrayList.contains((String) it.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z4 = false;
            }
            return b.a(z4);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
