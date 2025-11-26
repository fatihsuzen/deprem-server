package N;

import android.app.Activity;
import android.content.Intent;

final class B extends D {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f2980a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f2981b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f2982c;

    B(Intent intent, Activity activity, int i5) {
        this.f2980a = intent;
        this.f2981b = activity;
        this.f2982c = i5;
    }

    public final void a() {
        Intent intent = this.f2980a;
        if (intent != null) {
            this.f2981b.startActivityForResult(intent, this.f2982c);
        }
    }
}
