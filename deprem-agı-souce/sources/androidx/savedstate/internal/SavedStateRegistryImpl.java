package androidx.savedstate.internal;

import W2.J;
import W2.s;
import W2.y;
import X2.M;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SavedStateRegistryImpl {
    private static final Companion Companion = new Companion((C2633k) null);
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    /* access modifiers changed from: private */
    public final Map<String, SavedStateRegistry.SavedStateProvider> keyToProviders;
    private final SynchronizedObject lock;
    private final C2616a onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    private static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, C2616a aVar) {
        t.e(savedStateRegistryOwner, "owner");
        t.e(aVar, "onAttach");
        this.owner = savedStateRegistryOwner;
        this.onAttach = aVar;
        this.lock = new SynchronizedObject();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    /* access modifiers changed from: private */
    public static final J _init_$lambda$0() {
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void performAttach$lambda$12(SavedStateRegistryImpl savedStateRegistryImpl, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        t.e(lifecycleOwner, "<unused var>");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistryImpl.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistryImpl.isAllowingSavingState = false;
        }
    }

    @MainThread
    public final Bundle consumeRestoredStateForKey(String str) {
        Bundle bundle;
        t.e(str, "key");
        if (this.isRestored) {
            Bundle bundle2 = this.restoredState;
            if (bundle2 == null) {
                return null;
            }
            Bundle r22 = SavedStateReader.m71constructorimpl(bundle2);
            if (SavedStateReader.m72containsimpl(r22, str)) {
                bundle = SavedStateReader.m128getSavedStateimpl(r22, str);
            } else {
                bundle = null;
            }
            SavedStateWriter.m193removeimpl(SavedStateWriter.m157constructorimpl(bundle2), str);
            if (SavedStateReader.m149isEmptyimpl(SavedStateReader.m71constructorimpl(bundle2))) {
                this.restoredState = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
    }

    public final C2616a getOnAttach$savedstate_release() {
        return this.onAttach;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider(String str) {
        SavedStateRegistry.SavedStateProvider savedStateProvider;
        t.e(str, "key");
        synchronized (this.lock) {
            Iterator it = this.keyToProviders.entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                SavedStateRegistry.SavedStateProvider savedStateProvider2 = (SavedStateRegistry.SavedStateProvider) entry.getValue();
                if (t.a((String) entry.getKey(), str)) {
                    savedStateProvider = savedStateProvider2;
                    continue;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    @MainThread
    public final boolean isRestored() {
        return this.isRestored;
    }

    @MainThread
    public final void performAttach() {
        if (this.owner.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        } else if (!this.attached) {
            this.onAttach.invoke();
            this.owner.getLifecycle().addObserver(new a(this));
            this.attached = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
    }

    @MainThread
    public final void performRestore$savedstate_release(Bundle bundle) {
        if (!this.attached) {
            performAttach();
        }
        if (this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + this.owner.getLifecycle().getCurrentState()).toString());
        } else if (!this.isRestored) {
            Bundle bundle2 = null;
            if (bundle != null) {
                Bundle r42 = SavedStateReader.m71constructorimpl(bundle);
                if (SavedStateReader.m72containsimpl(r42, SAVED_COMPONENTS_KEY)) {
                    bundle2 = SavedStateReader.m128getSavedStateimpl(r42, SAVED_COMPONENTS_KEY);
                }
            }
            this.restoredState = bundle2;
            this.isRestored = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
    }

    @MainThread
    public final void performSave$savedstate_release(Bundle bundle) {
        s[] sVarArr;
        t.e(bundle, "outBundle");
        Map h5 = M.h();
        if (h5.isEmpty()) {
            sVarArr = new s[0];
        } else {
            ArrayList arrayList = new ArrayList(h5.size());
            for (Map.Entry entry : h5.entrySet()) {
                arrayList.add(y.a((String) entry.getKey(), entry.getValue()));
            }
            sVarArr = (s[]) arrayList.toArray(new s[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
        Bundle r12 = SavedStateWriter.m157constructorimpl(bundleOf);
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            SavedStateWriter.m161putAllimpl(r12, bundle2);
        }
        synchronized (this.lock) {
            try {
                for (Map.Entry entry2 : this.keyToProviders.entrySet()) {
                    SavedStateWriter.m184putSavedStateimpl(r12, (String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState());
                }
                J j5 = J.f19942a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!SavedStateReader.m149isEmptyimpl(SavedStateReader.m71constructorimpl(bundleOf))) {
            SavedStateWriter.m184putSavedStateimpl(SavedStateWriter.m157constructorimpl(bundle), SAVED_COMPONENTS_KEY, bundleOf);
        }
    }

    @MainThread
    public final void registerSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        t.e(str, "key");
        t.e(savedStateProvider, "provider");
        synchronized (this.lock) {
            if (!this.keyToProviders.containsKey(str)) {
                this.keyToProviders.put(str, savedStateProvider);
                J j5 = J.f19942a;
            } else {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean z4) {
        this.isAllowingSavingState = z4;
    }

    @MainThread
    public final void unregisterSavedStateProvider(String str) {
        t.e(str, "key");
        synchronized (this.lock) {
            SavedStateRegistry.SavedStateProvider savedStateProvider = (SavedStateRegistry.SavedStateProvider) this.keyToProviders.remove(str);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SavedStateRegistryImpl(androidx.savedstate.SavedStateRegistryOwner r1, k3.C2616a r2, int r3, kotlin.jvm.internal.C2633k r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0009
            androidx.savedstate.internal.b r2 = new androidx.savedstate.internal.b
            r2.<init>()
        L_0x0009:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.savedstate.internal.SavedStateRegistryImpl.<init>(androidx.savedstate.SavedStateRegistryOwner, k3.a, int, kotlin.jvm.internal.k):void");
    }
}
