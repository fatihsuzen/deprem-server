package J;

import android.util.Log;
import java.io.IOException;
import k0.C1699m;

/* renamed from: J.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0651g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1699m f2632a;

    public /* synthetic */ C0651g(C1699m mVar) {
        this.f2632a = mVar;
    }

    public final void run() {
        if (this.f2632a.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
