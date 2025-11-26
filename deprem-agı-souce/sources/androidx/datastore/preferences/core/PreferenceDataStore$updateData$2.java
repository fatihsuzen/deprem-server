package androidx.datastore.preferences.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;

@f(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {94}, m = "invokeSuspend")
final class PreferenceDataStore$updateData$2 extends l implements p {
    final /* synthetic */ p $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStore$updateData$2(p pVar, C2308e eVar) {
        super(2, eVar);
        this.$transform = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        PreferenceDataStore$updateData$2 preferenceDataStore$updateData$2 = new PreferenceDataStore$updateData$2(this.$transform, eVar);
        preferenceDataStore$updateData$2.L$0 = obj;
        return preferenceDataStore$updateData$2;
    }

    public final Object invoke(Preferences preferences, C2308e eVar) {
        return ((PreferenceDataStore$updateData$2) create(preferences, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            p pVar = this.$transform;
            this.label = 1;
            obj = pVar.invoke((Preferences) this.L$0, this);
            if (obj == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Preferences preferences = (Preferences) obj;
        t.c(preferences, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
        ((MutablePreferences) preferences).freeze$datastore_preferences_core_release();
        return preferences;
    }
}
