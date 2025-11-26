package x1;

import android.content.Context;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f16984b = new g();

    /* renamed from: a  reason: collision with root package name */
    private Context f16985a;

    private g() {
    }

    public static g c() {
        return f16984b;
    }

    public Context a() {
        return this.f16985a;
    }

    public void b(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f16985a = context2;
    }
}
