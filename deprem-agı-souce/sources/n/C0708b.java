package N;

import L.b;
import L.i;
import com.google.android.gms.common.api.Status;

/* renamed from: N.b  reason: case insensitive filesystem */
public abstract class C0708b {
    public static b a(Status status) {
        if (status.g()) {
            return new i(status);
        }
        return new b(status);
    }
}
