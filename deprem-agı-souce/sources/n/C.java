package N;

import M.C0688h;
import android.content.Intent;

final class C extends D {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f2983a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0688h f2984b;

    C(Intent intent, C0688h hVar, int i5) {
        this.f2983a = intent;
        this.f2984b = hVar;
    }

    public final void a() {
        Intent intent = this.f2983a;
        if (intent != null) {
            this.f2984b.startActivityForResult(intent, 2);
        }
    }
}
