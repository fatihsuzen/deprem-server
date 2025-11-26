package androidx.core.view;

import W2.J;
import android.view.View;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import s3.C2753g;

@f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
final class ViewKt$allViews$1 extends k implements p {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, C2308e eVar) {
        super(2, eVar);
        this.$this_allViews = view;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, eVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: s3.g} */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        if (r1.e(r5, r4) == r0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r1.a(r5, r4) == r0) goto L_0x004e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r5)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            java.lang.Object r1 = r4.L$0
            s3.g r1 = (s3.C2753g) r1
            W2.u.b(r5)
            goto L_0x0037
        L_0x0022:
            W2.u.b(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            s3.g r1 = (s3.C2753g) r1
            android.view.View r5 = r4.$this_allViews
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r5 = r1.a(r5, r4)
            if (r5 != r0) goto L_0x0037
            goto L_0x004e
        L_0x0037:
            android.view.View r5 = r4.$this_allViews
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x004f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            s3.e r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r3 = 0
            r4.L$0 = r3
            r4.label = r2
            java.lang.Object r5 = r1.e(r5, r4)
            if (r5 != r0) goto L_0x004f
        L_0x004e:
            return r0
        L_0x004f:
            W2.J r5 = W2.J.f19942a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2753g gVar, C2308e eVar) {
        return ((ViewKt$allViews$1) create(gVar, eVar)).invokeSuspend(J.f19942a);
    }
}
