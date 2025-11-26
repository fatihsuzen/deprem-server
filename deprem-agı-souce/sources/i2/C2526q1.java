package i2;

import android.content.Context;
import android.content.DialogInterface;

/* renamed from: i2.q1  reason: case insensitive filesystem */
public final /* synthetic */ class C2526q1 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2540v1 f24326a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f24327b;

    public /* synthetic */ C2526q1(C2540v1 v1Var, Context context) {
        this.f24326a = v1Var;
        this.f24327b = context;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        C2540v1.L3(this.f24326a, this.f24327b, dialogInterface);
    }
}
