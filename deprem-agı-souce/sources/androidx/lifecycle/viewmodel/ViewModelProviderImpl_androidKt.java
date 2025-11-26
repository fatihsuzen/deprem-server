package androidx.lifecycle.viewmodel;

public final class ViewModelProviderImpl_androidKt {
    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return r1.create(j3.C2582a.a(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return r1.create(j3.C2582a.a(r2), r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <VM extends androidx.lifecycle.ViewModel> VM createViewModel(androidx.lifecycle.ViewModelProvider.Factory r1, r3.C2733c r2, androidx.lifecycle.viewmodel.CreationExtras r3) {
        /*
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.t.e(r1, r0)
            java.lang.String r0 = "modelClass"
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "extras"
            kotlin.jvm.internal.t.e(r3, r0)
            androidx.lifecycle.ViewModel r1 = r1.create((r3.C2733c) r2, (androidx.lifecycle.viewmodel.CreationExtras) r3)     // Catch:{ AbstractMethodError -> 0x0014 }
            return r1
        L_0x0014:
            java.lang.Class r0 = j3.C2582a.a(r2)     // Catch:{ AbstractMethodError -> 0x001d }
            androidx.lifecycle.ViewModel r1 = r1.create(r0, (androidx.lifecycle.viewmodel.CreationExtras) r3)     // Catch:{ AbstractMethodError -> 0x001d }
            goto L_0x0025
        L_0x001d:
            java.lang.Class r2 = j3.C2582a.a(r2)
            androidx.lifecycle.ViewModel r1 = r1.create(r2)
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.viewmodel.ViewModelProviderImpl_androidKt.createViewModel(androidx.lifecycle.ViewModelProvider$Factory, r3.c, androidx.lifecycle.viewmodel.CreationExtras):androidx.lifecycle.ViewModel");
    }
}
