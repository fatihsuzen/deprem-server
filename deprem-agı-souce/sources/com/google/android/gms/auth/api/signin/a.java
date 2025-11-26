package com.google.android.gms.auth.api.signin;

import G.b;
import H.o;
import N.C0708b;
import N.C0722p;
import android.content.Context;
import android.content.Intent;
import k0.C1698l;
import k0.C1701o;

public abstract class a {
    public static b a(Context context, GoogleSignInOptions googleSignInOptions) {
        return new b(context, (GoogleSignInOptions) C0722p.k(googleSignInOptions));
    }

    public static C1698l b(Intent intent) {
        b f5 = o.f(intent);
        GoogleSignInAccount a5 = f5.a();
        if (!f5.getStatus().i() || a5 == null) {
            return C1701o.d(C0708b.a(f5.getStatus()));
        }
        return C1701o.e(a5);
    }
}
