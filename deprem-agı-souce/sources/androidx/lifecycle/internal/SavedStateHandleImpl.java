package androidx.lifecycle.internal;

import W2.s;
import W2.y;
import X2.M;
import X2.T;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import i.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2974g;
import z3.D;
import z3.F;
import z3.w;

public final class SavedStateHandleImpl {
    private final Map<String, w> flows;
    private final Map<String, w> mutableFlows;
    private final Map<String, SavedStateRegistry.SavedStateProvider> providers;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    public SavedStateHandleImpl() {
        this((Map) null, 1, (C2633k) null);
    }

    /* access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandleImpl savedStateHandleImpl) {
        s[] sVarArr;
        for (Map.Entry entry : M.t(savedStateHandleImpl.mutableFlows).entrySet()) {
            savedStateHandleImpl.set((String) entry.getKey(), ((w) entry.getValue()).getValue());
        }
        for (Map.Entry entry2 : M.t(savedStateHandleImpl.providers).entrySet()) {
            savedStateHandleImpl.set((String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState());
        }
        Map<String, Object> map = savedStateHandleImpl.regular;
        if (map.isEmpty()) {
            sVarArr = new s[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(y.a((String) next.getKey(), next.getValue()));
            }
            sVarArr = (s[]) arrayList.toArray(new s[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
        SavedStateWriter.m157constructorimpl(bundleOf);
        return bundleOf;
    }

    @MainThread
    public final void clearSavedStateProvider(String str) {
        t.e(str, "key");
        this.providers.remove(str);
    }

    @MainThread
    public final boolean contains(String str) {
        t.e(str, "key");
        return this.regular.containsKey(str);
    }

    @MainThread
    public final <T> T get(String str) {
        t.e(str, "key");
        try {
            w wVar = this.mutableFlows.get(str);
            if (wVar != null) {
                T value = wVar.getValue();
                if (value != null) {
                    return value;
                }
            }
            return this.regular.get(str);
        } catch (ClassCastException unused) {
            remove(str);
            return null;
        }
    }

    public final Map<String, w> getMutableFlows() {
        return this.mutableFlows;
    }

    @MainThread
    public final <T> w getMutableStateFlow(String str, T t5) {
        t.e(str, "key");
        Map<String, w> map = this.mutableFlows;
        w wVar = map.get(str);
        if (wVar == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t5);
            }
            wVar = F.a(this.regular.get(str));
            map.put(str, wVar);
        }
        w wVar2 = wVar;
        t.c(wVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.MutableStateFlow<T of androidx.lifecycle.internal.SavedStateHandleImpl.getMutableStateFlow>");
        return wVar2;
    }

    public final Map<String, Object> getRegular() {
        return this.regular;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> D getStateFlow(String str, T t5) {
        t.e(str, "key");
        Map<String, w> map = this.flows;
        w wVar = map.get(str);
        if (wVar == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t5);
            }
            wVar = F.a(this.regular.get(str));
            map.put(str, wVar);
        }
        D a5 = C2974g.a(wVar);
        t.c(a5, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.internal.SavedStateHandleImpl.getStateFlow>");
        return a5;
    }

    @MainThread
    public final Set<String> keys() {
        return T.h(this.regular.keySet(), this.providers.keySet());
    }

    @MainThread
    public final <T> T remove(String str) {
        t.e(str, "key");
        T remove = this.regular.remove(str);
        this.flows.remove(str);
        this.mutableFlows.remove(str);
        return remove;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String str, T t5) {
        t.e(str, "key");
        this.regular.put(str, t5);
        w wVar = this.flows.get(str);
        if (wVar != null) {
            wVar.setValue(t5);
        }
        w wVar2 = this.mutableFlows.get(str);
        if (wVar2 != null) {
            wVar2.setValue(t5);
        }
    }

    @MainThread
    public final void setSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider2) {
        t.e(str, "key");
        t.e(savedStateProvider2, "provider");
        this.providers.put(str, savedStateProvider2);
    }

    public SavedStateHandleImpl(Map<String, ? extends Object> map) {
        t.e(map, "initialState");
        this.regular = M.v(map);
        this.providers = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.mutableFlows = new LinkedHashMap();
        this.savedStateProvider = new a(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SavedStateHandleImpl(Map map, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? M.h() : map);
    }
}
