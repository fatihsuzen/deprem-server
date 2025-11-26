package com.google.android.gms.auth.api.signin;

import E.C0637a;
import H.o;
import K.C0660g;
import K.C0665l;
import L.e;
import L.f;
import M.C0681a;
import N.C0721o;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.dynamite.DynamiteModule;
import k0.C1698l;

public class b extends e {

    /* renamed from: k  reason: collision with root package name */
    private static final f f4833k = new f((byte[]) null);

    /* renamed from: l  reason: collision with root package name */
    static int f4834l = 1;

    b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, C0637a.f2373b, googleSignInOptions, new e.a.C0049a().b(new C0681a()).a());
    }

    private final synchronized int t() {
        int i5;
        try {
            i5 = f4834l;
            if (i5 == 1) {
                Context i6 = i();
                C0660g n5 = C0660g.n();
                int h5 = n5.h(i6, C0665l.f2721a);
                if (h5 == 0) {
                    i5 = 4;
                    f4834l = 4;
                } else if (n5.b(i6, h5, (String) null) != null || DynamiteModule.a(i6, "com.google.android.gms.auth.api.fallback") == 0) {
                    i5 = 2;
                    f4834l = 2;
                } else {
                    i5 = 3;
                    f4834l = 3;
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return i5;
    }

    public Intent q() {
        Context i5 = i();
        int t5 = t();
        int i6 = t5 - 1;
        if (t5 == 0) {
            throw null;
        } else if (i6 == 2) {
            return o.b(i5, (GoogleSignInOptions) h());
        } else {
            if (i6 != 3) {
                return o.c(i5, (GoogleSignInOptions) h());
            }
            return o.a(i5, (GoogleSignInOptions) h());
        }
    }

    public C1698l r() {
        boolean z4;
        f b5 = b();
        Context i5 = i();
        if (t() == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        return C0721o.b(o.e(b5, i5, z4));
    }

    public C1698l s() {
        boolean z4;
        f b5 = b();
        Context i5 = i();
        if (t() == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        return C0721o.b(o.d(b5, i5, z4));
    }
}
