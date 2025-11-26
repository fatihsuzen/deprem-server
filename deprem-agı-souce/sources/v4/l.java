package v4;

import android.app.Dialog;
import android.content.Context;

public final class l extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f26086a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context, p pVar, int i5) {
        super(context, i5);
        this.f26086a = pVar;
    }

    public final void onBackPressed() {
        p pVar = this.f26086a;
        String str = p.f26090y;
        pVar.h();
    }
}
