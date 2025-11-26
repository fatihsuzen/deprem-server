package T;

import android.content.Context;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static final e f4352b = new e();

    /* renamed from: a  reason: collision with root package name */
    private d f4353a = null;

    public static d a(Context context) {
        return f4352b.b(context);
    }

    public final synchronized d b(Context context) {
        try {
            if (this.f4353a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f4353a = new d(context);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f4353a;
    }
}
