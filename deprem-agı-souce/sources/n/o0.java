package N;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

final class o0 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q0 f3131a;

    /* synthetic */ o0(q0 q0Var, p0 p0Var) {
        this.f3131a = q0Var;
    }

    public final boolean handleMessage(Message message) {
        int i5 = message.what;
        if (i5 == 0) {
            synchronized (this.f3131a.f3135g) {
                try {
                    m0 m0Var = (m0) message.obj;
                    n0 n0Var = (n0) this.f3131a.f3135g.get(m0Var);
                    if (n0Var != null && n0Var.i()) {
                        if (n0Var.j()) {
                            n0Var.g("GmsClientSupervisor");
                        }
                        this.f3131a.f3135g.remove(m0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } else if (i5 != 1) {
            return false;
        } else {
            synchronized (this.f3131a.f3135g) {
                try {
                    m0 m0Var2 = (m0) message.obj;
                    n0 n0Var2 = (n0) this.f3131a.f3135g.get(m0Var2);
                    if (n0Var2 != null && n0Var2.a() == 3) {
                        String valueOf = String.valueOf(m0Var2);
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                        ComponentName b5 = n0Var2.b();
                        if (b5 == null) {
                            b5 = m0Var2.a();
                        }
                        if (b5 == null) {
                            String c5 = m0Var2.c();
                            C0722p.k(c5);
                            b5 = new ComponentName(c5, EnvironmentCompat.MEDIA_UNKNOWN);
                        }
                        n0Var2.onServiceDisconnected(b5);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
    }
}
