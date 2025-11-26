package androidx.activity;

import k3.l;

public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ l $onBackPressed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnBackPressedDispatcherKt$addCallback$callback$1(boolean z4, l lVar) {
        super(z4);
        this.$onBackPressed = lVar;
    }

    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
