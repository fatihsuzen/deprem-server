package androidx.lifecycle;

import W2.C2223l;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class ViewModelLazy<VM extends ViewModel> implements C2223l {
    private VM cached;
    private final C2616a extrasProducer;
    private final C2616a factoryProducer;
    private final C2616a storeProducer;
    private final C2733c viewModelClass;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(C2733c cVar, C2616a aVar, C2616a aVar2) {
        this(cVar, aVar, aVar2, (C2616a) null, 8, (C2633k) null);
        t.e(cVar, "viewModelClass");
        t.e(aVar, "storeProducer");
        t.e(aVar2, "factoryProducer");
    }

    /* access modifiers changed from: private */
    public static final CreationExtras.Empty _init_$lambda$0() {
        return CreationExtras.Empty.INSTANCE;
    }

    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    public ViewModelLazy(C2733c cVar, C2616a aVar, C2616a aVar2, C2616a aVar3) {
        t.e(cVar, "viewModelClass");
        t.e(aVar, "storeProducer");
        t.e(aVar2, "factoryProducer");
        t.e(aVar3, "extrasProducer");
        this.viewModelClass = cVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
        this.extrasProducer = aVar3;
    }

    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = ViewModelProvider.Companion.create((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(this.viewModelClass);
        this.cached = vm2;
        return vm2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ViewModelLazy(r3.C2733c r1, k3.C2616a r2, k3.C2616a r3, k3.C2616a r4, int r5, kotlin.jvm.internal.C2633k r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0009
            androidx.lifecycle.x r4 = new androidx.lifecycle.x
            r4.<init>()
        L_0x0009:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelLazy.<init>(r3.c, k3.a, k3.a, k3.a, int, kotlin.jvm.internal.k):void");
    }
}
