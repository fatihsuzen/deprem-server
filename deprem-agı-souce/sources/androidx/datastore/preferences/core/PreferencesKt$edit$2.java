package androidx.datastore.preferences.core;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {358}, m = "invokeSuspend")
final class PreferencesKt$edit$2 extends l implements p {
    final /* synthetic */ p $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferencesKt$edit$2(p pVar, C2308e eVar) {
        super(2, eVar);
        this.$transform = pVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.$transform, eVar);
        preferencesKt$edit$2.L$0 = obj;
        return preferencesKt$edit$2;
    }

    public final Object invoke(Preferences preferences, C2308e eVar) {
        return ((PreferencesKt$edit$2) create(preferences, eVar)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            MutablePreferences mutablePreferences = ((Preferences) this.L$0).toMutablePreferences();
            p pVar = this.$transform;
            this.L$0 = mutablePreferences;
            this.label = 1;
            if (pVar.invoke(mutablePreferences, this) == f5) {
                return f5;
            }
            return mutablePreferences;
        } else if (i5 == 1) {
            MutablePreferences mutablePreferences2 = (MutablePreferences) this.L$0;
            u.b(obj);
            return mutablePreferences2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
