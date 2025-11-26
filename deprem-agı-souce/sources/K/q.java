package K;

import Z.i;
import android.content.Context;
import android.os.Message;
import android.util.Log;

final class q extends i {

    /* renamed from: b  reason: collision with root package name */
    private final Context f2733b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0660g f2734c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q(K.C0660g r1, android.content.Context r2) {
        /*
            r0 = this;
            r0.f2734c = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L_0x000d
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L_0x0011
        L_0x000d:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L_0x0011:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.f2733b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K.q.<init>(K.g, android.content.Context):void");
    }

    public final void handleMessage(Message message) {
        int i5 = message.what;
        if (i5 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i5);
            return;
        }
        C0660g gVar = this.f2734c;
        int g5 = gVar.g(this.f2733b);
        if (gVar.j(g5)) {
            this.f2734c.p(this.f2733b, g5);
        }
    }
}
