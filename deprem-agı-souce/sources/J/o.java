package J;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import k0.C1698l;
import k0.C1701o;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f2640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0645a f2641b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f2642c;

    public /* synthetic */ o(Context context, C0645a aVar, CountDownLatch countDownLatch) {
        this.f2640a = context;
        this.f2641b = aVar;
        this.f2642c = countDownLatch;
    }

    public final void run() {
        C1698l lVar;
        C0645a aVar = this.f2641b;
        if (TextUtils.isEmpty(aVar.d())) {
            lVar = C1701o.e((Object) null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", aVar.d());
            Integer f5 = aVar.f();
            if (f5 != null) {
                bundle.putInt("google.product_id", f5.intValue());
            }
            Context context = this.f2640a;
            bundle.putBoolean("supports_message_handled", true);
            lVar = D.b(context).c(2, bundle);
        }
        lVar.b(m.f2638a, new n(this.f2642c));
    }
}
