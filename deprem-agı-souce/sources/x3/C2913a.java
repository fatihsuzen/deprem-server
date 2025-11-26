package x3;

import B3.r;
import android.os.Looper;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import w3.I0;

/* renamed from: x3.a  reason: case insensitive filesystem */
public final class C2913a implements r {
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public I0 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C2917e(C2919g.a(mainLooper, true), (String) null, 2, (C2633k) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public int c() {
        return 1073741823;
    }
}
