package f0;

import N.C0722p;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.J0;
import com.google.android.gms.measurement.internal.C1402q2;
import com.google.android.gms.measurement.internal.X2;

/* renamed from: f0.o  reason: case insensitive filesystem */
public final class C1660o {

    /* renamed from: a  reason: collision with root package name */
    private final C1659n f15319a;

    public C1660o(C1659n nVar) {
        C0722p.k(nVar);
        this.f15319a = nVar;
    }

    public final void a(Context context, Intent intent) {
        X2 O4 = X2.O(context, (J0) null, (Long) null);
        C1402q2 a5 = O4.a();
        if (intent == null) {
            a5.r().a("Receiver called with null intent");
            return;
        }
        O4.c();
        String action = intent.getAction();
        a5.w().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            a5.w().a("Starting wakeful intent.");
            this.f15319a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            a5.r().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
