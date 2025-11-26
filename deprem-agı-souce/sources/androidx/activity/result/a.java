package androidx.activity.result;

import k3.l;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f192a;

    public /* synthetic */ a(l lVar) {
        this.f192a = lVar;
    }

    public final void onActivityResult(Object obj) {
        ActivityResultCallerKt.registerForActivityResult$lambda$0(this.f192a, obj);
    }
}
