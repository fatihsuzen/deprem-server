package J;

import android.os.Bundle;

final class z extends C0644A {
    z(int i5, int i6, Bundle bundle) {
        super(i5, i6, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d((Object) null);
        } else {
            c(new B(4, "Invalid response to one way request", (Throwable) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }
}
