package M;

import K.C0655b;
import K.C0660g;
import Z.i;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.a;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c0 extends C0687g implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f2890b;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicReference f2891c = new AtomicReference((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final Handler f2892d = new i(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    protected final C0660g f2893e;

    c0(C0688h hVar, C0660g gVar) {
        super(hVar);
        this.f2893e = gVar;
    }

    /* access modifiers changed from: private */
    public final void l(C0655b bVar, int i5) {
        this.f2891c.set((Object) null);
        m(bVar, i5);
    }

    /* access modifiers changed from: private */
    public final void o() {
        this.f2891c.set((Object) null);
        n();
    }

    private static final int p(Z z4) {
        if (z4 == null) {
            return -1;
        }
        return z4.a();
    }

    public final void e(int i5, int i6, Intent intent) {
        Z z4 = (Z) this.f2891c.get();
        if (i5 != 1) {
            if (i5 == 2) {
                int g5 = this.f2893e.g(b());
                if (g5 == 0) {
                    o();
                    return;
                } else if (z4 == null) {
                    return;
                } else {
                    if (z4.b().c() == 18 && g5 == 18) {
                        return;
                    }
                }
            }
        } else if (i6 == -1) {
            o();
            return;
        } else if (i6 == 0) {
            if (z4 != null) {
                int i7 = 13;
                if (intent != null) {
                    i7 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                l(new C0655b(i7, (PendingIntent) null, z4.b().toString()), p(z4));
                return;
            }
            return;
        }
        if (z4 != null) {
            l(z4.b(), z4.a());
        }
    }

    public final void f(Bundle bundle) {
        Z z4;
        super.f(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.f2891c;
            if (bundle.getBoolean("resolving_error", false)) {
                z4 = new Z(new C0655b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                z4 = null;
            }
            atomicReference.set(z4);
        }
    }

    public final void i(Bundle bundle) {
        super.i(bundle);
        Z z4 = (Z) this.f2891c.get();
        if (z4 != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", z4.a());
            bundle.putInt("failed_status", z4.b().c());
            bundle.putParcelable("failed_resolution", z4.b().f());
        }
    }

    public void j() {
        super.j();
        this.f2890b = true;
    }

    public void k() {
        super.k();
        this.f2890b = false;
    }

    /* access modifiers changed from: protected */
    public abstract void m(C0655b bVar, int i5);

    /* access modifiers changed from: protected */
    public abstract void n();

    public final void onCancel(DialogInterface dialogInterface) {
        l(new C0655b(13, (PendingIntent) null), p((Z) this.f2891c.get()));
    }

    public final void s(C0655b bVar, int i5) {
        AtomicReference atomicReference;
        Z z4 = new Z(bVar, i5);
        do {
            atomicReference = this.f2891c;
            if (a.a(atomicReference, (Object) null, z4)) {
                this.f2892d.post(new b0(this, z4));
                return;
            }
        } while (atomicReference.get() == null);
    }
}
