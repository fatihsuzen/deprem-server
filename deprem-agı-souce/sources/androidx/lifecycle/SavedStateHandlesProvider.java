package androidx.lifecycle;

import W2.C2223l;
import W2.m;
import W2.s;
import W2.y;
import X2.M;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final C2223l viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry2, ViewModelStoreOwner viewModelStoreOwner) {
        t.e(savedStateRegistry2, "savedStateRegistry");
        t.e(viewModelStoreOwner, "viewModelStoreOwner");
        this.savedStateRegistry = savedStateRegistry2;
        this.viewModel$delegate = m.b(new q(viewModelStoreOwner));
    }

    private final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SavedStateHandlesVM viewModel_delegate$lambda$0(ViewModelStoreOwner viewModelStoreOwner) {
        return SavedStateHandleSupport.getSavedStateHandlesVM(viewModelStoreOwner);
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        s[] sVarArr;
        t.e(str, "key");
        performRestore();
        Bundle bundle = this.restoredState;
        if (bundle == null || !SavedStateReader.m72containsimpl(SavedStateReader.m71constructorimpl(bundle), str)) {
            return null;
        }
        Bundle r22 = SavedStateReader.m133getSavedStateOrNullimpl(SavedStateReader.m71constructorimpl(bundle), str);
        if (r22 == null) {
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
            r22 = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
            SavedStateWriter.m157constructorimpl(r22);
        }
        SavedStateWriter.m193removeimpl(SavedStateWriter.m157constructorimpl(bundle), str);
        if (SavedStateReader.m149isEmptyimpl(SavedStateReader.m71constructorimpl(bundle))) {
            this.restoredState = null;
        }
        return r22;
    }

    public final void performRestore() {
        s[] sVarArr;
        if (!this.restored) {
            Bundle consumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey(SavedStateHandleSupport.SAVED_STATE_KEY);
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
            Bundle r22 = SavedStateWriter.m157constructorimpl(bundleOf);
            Bundle bundle = this.restoredState;
            if (bundle != null) {
                SavedStateWriter.m161putAllimpl(r22, bundle);
            }
            if (consumeRestoredStateForKey != null) {
                SavedStateWriter.m161putAllimpl(r22, consumeRestoredStateForKey);
            }
            this.restoredState = bundleOf;
            this.restored = true;
            getViewModel();
        }
    }

    public Bundle saveState() {
        s[] sVarArr;
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
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            SavedStateWriter.m161putAllimpl(r12, bundle);
        }
        for (Map.Entry next : getViewModel().getHandles().entrySet()) {
            String str = (String) next.getKey();
            Bundle saveState = ((SavedStateHandle) next.getValue()).savedStateProvider().saveState();
            if (!SavedStateReader.m149isEmptyimpl(SavedStateReader.m71constructorimpl(saveState))) {
                SavedStateWriter.m184putSavedStateimpl(r12, str, saveState);
            }
        }
        this.restored = false;
        return bundleOf;
    }
}
