package L;

import M.C0684d;
import M.C0691k;
import M.C0693m;
import android.os.Looper;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f2784a = Collections.newSetFromMap(new WeakHashMap());

    public interface a extends C0684d {
    }

    public interface b extends C0691k {
    }

    public static Set b() {
        Set set = f2784a;
        synchronized (set) {
        }
        return set;
    }

    public abstract com.google.android.gms.common.api.internal.a a(com.google.android.gms.common.api.internal.a aVar);

    public abstract Looper c();

    public boolean d(C0693m mVar) {
        throw new UnsupportedOperationException();
    }

    public void e() {
        throw new UnsupportedOperationException();
    }
}
