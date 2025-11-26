package M;

import K.C0655b;
import N.C0716j;
import android.util.Log;

/* renamed from: M.E  reason: case insensitive filesystem */
final class C0673E implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0655b f2834a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0674F f2835b;

    C0673E(C0674F f5, C0655b bVar) {
        this.f2835b = f5;
        this.f2834a = bVar;
    }

    public final void run() {
        C0674F f5 = this.f2835b;
        C0670B b5 = (C0670B) f5.f2841f.f2909j.get(f5.f2837b);
        if (b5 != null) {
            if (this.f2834a.i()) {
                this.f2835b.f2840e = true;
                if (this.f2835b.f2836a.o()) {
                    this.f2835b.i();
                    return;
                }
                try {
                    C0674F f6 = this.f2835b;
                    f6.f2836a.l((C0716j) null, f6.f2836a.c());
                } catch (SecurityException e5) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e5);
                    this.f2835b.f2836a.d("Failed to get service from broker.");
                    b5.H(new C0655b(10), (Exception) null);
                }
            } else {
                b5.H(this.f2834a, (Exception) null);
            }
        }
    }
}
