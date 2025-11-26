package androidx.activity.result;

import k3.l;

public final /* synthetic */ class b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f193a;

    public /* synthetic */ b(l lVar) {
        this.f193a = lVar;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.registerForActivityResult$lambda$1(this.f193a, obj);
    }
}
