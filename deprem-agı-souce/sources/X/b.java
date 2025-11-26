package X;

import E.C0638b;
import E.c;
import K.C0665l;
import M.C0684d;
import M.C0691k;
import N.C0710d;
import N.C0713g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;

public final class b extends C0713g {

    /* renamed from: I  reason: collision with root package name */
    private final Bundle f4429I = new Bundle();

    public b(Context context, Looper looper, C0710d dVar, c cVar, C0684d dVar2, C0691k kVar) {
        super(context, looper, 16, dVar, dVar2, kVar);
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.f4429I;
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.auth.service.START";
    }

    public final boolean S() {
        return true;
    }

    public final int k() {
        return C0665l.f2721a;
    }

    public final boolean o() {
        C0710d j02 = j0();
        if (TextUtils.isEmpty(j02.b()) || j02.e(C0638b.f2380a).isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new c(iBinder);
    }
}
