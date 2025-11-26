package J;

import a0.C1000f;
import android.os.Looper;
import android.os.Message;

final class i extends C1000f {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0647c f2636b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i(C0647c cVar, Looper looper) {
        super(looper);
        this.f2636b = cVar;
    }

    public final void handleMessage(Message message) {
        C0647c.g(this.f2636b, message);
    }
}
