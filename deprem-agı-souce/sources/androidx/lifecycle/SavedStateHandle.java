package androidx.lifecycle;

import X2.T;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2974g;
import z3.D;
import z3.w;

public final class SavedStateHandle {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public SavedStateHandleImpl impl;
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                bundle = bundle2;
            }
            if (bundle == null) {
                return new SavedStateHandle();
            }
            ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
            t.b(classLoader);
            bundle.setClassLoader(classLoader);
            return new SavedStateHandle(SavedStateReader.m152toMapimpl(SavedStateReader.m71constructorimpl(bundle)));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object obj) {
            return SavedStateHandleImpl_androidKt.isAcceptableType(obj);
        }

        private Companion() {
        }
    }

    public SavedStateHandle(Map<String, ? extends Object> map) {
        t.e(map, "initialState");
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(map);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z4, T t5) {
        SavingStateLiveData<?> savingStateLiveData;
        if (!this.impl.getMutableFlows().containsKey(str)) {
            Map<String, SavingStateLiveData<?>> map = this.liveDatas;
            SavingStateLiveData<?> savingStateLiveData2 = map.get(str);
            if (savingStateLiveData2 == null) {
                if (this.impl.getRegular().containsKey(str)) {
                    savingStateLiveData = new SavingStateLiveData<>(this, str, this.impl.getRegular().get(str));
                } else if (z4) {
                    this.impl.getRegular().put(str, t5);
                    savingStateLiveData = new SavingStateLiveData<>(this, str, t5);
                } else {
                    savingStateLiveData = new SavingStateLiveData<>(this, str);
                }
                savingStateLiveData2 = savingStateLiveData;
                map.put(str, savingStateLiveData2);
            }
            return savingStateLiveData2;
        }
        throw new IllegalArgumentException(SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(str).toString());
    }

    @MainThread
    public final void clearSavedStateProvider(String str) {
        t.e(str, "key");
        this.impl.clearSavedStateProvider(str);
    }

    @MainThread
    public final boolean contains(String str) {
        t.e(str, "key");
        return this.impl.contains(str);
    }

    @MainThread
    public final <T> T get(String str) {
        t.e(str, "key");
        return this.impl.get(str);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String str) {
        t.e(str, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(str, false, (Object) null);
        t.c(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @MainThread
    public final <T> w getMutableStateFlow(String str, T t5) {
        t.e(str, "key");
        if (!this.liveDatas.containsKey(str)) {
            return this.impl.getMutableStateFlow(str, t5);
        }
        throw new IllegalArgumentException(SavedStateHandle_androidKt.createMutuallyExclusiveErrorMessage(str).toString());
    }

    @MainThread
    public final <T> D getStateFlow(String str, T t5) {
        t.e(str, "key");
        if (this.impl.getMutableFlows().containsKey(str)) {
            return C2974g.a(this.impl.getMutableStateFlow(str, t5));
        }
        return this.impl.getStateFlow(str, t5);
    }

    @MainThread
    public final Set<String> keys() {
        return T.h(this.impl.keys(), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T remove(String str) {
        t.e(str, "key");
        T remove = this.impl.remove(str);
        SavingStateLiveData remove2 = this.liveDatas.remove(str);
        if (remove2 != null) {
            remove2.detach();
        }
        return remove;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.impl.getSavedStateProvider();
    }

    @MainThread
    public final <T> void set(String str, T t5) {
        MutableLiveData mutableLiveData;
        t.e(str, "key");
        if (Companion.validateValue(t5)) {
            SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(str);
            if (savingStateLiveData instanceof MutableLiveData) {
                mutableLiveData = savingStateLiveData;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(t5);
            }
            this.impl.set(str, t5);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        t.b(t5);
        sb.append(t5.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @MainThread
    public final void setSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        t.e(str, "key");
        t.e(savedStateProvider, "provider");
        this.impl.setSavedStateProvider(str, savedStateProvider);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String str, T t5) {
        t.e(str, "key");
        return getLiveDataInternal(str, true, t5);
    }

    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t5) {
            super(t5);
            t.e(str, "key");
            this.key = str;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        public void setValue(T t5) {
            SavedStateHandleImpl access$getImpl$p;
            SavedStateHandle savedStateHandle = this.handle;
            if (!(savedStateHandle == null || (access$getImpl$p = savedStateHandle.impl) == null)) {
                access$getImpl$p.set(this.key, t5);
            }
            super.setValue(t5);
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            t.e(str, "key");
            this.key = str;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl((Map) null, 1, (C2633k) null);
    }
}
