package J;

import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import k0.C1689c;
import k0.C1698l;

/* renamed from: J.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0649e implements C1689c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0649e f2630a = new C0649e();

    private /* synthetic */ C0649e() {
    }

    public final Object a(C1698l lVar) {
        if (lVar.n()) {
            return (Bundle) lVar.j();
        }
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Error making request: ".concat(String.valueOf(lVar.i())));
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", lVar.i());
    }
}
