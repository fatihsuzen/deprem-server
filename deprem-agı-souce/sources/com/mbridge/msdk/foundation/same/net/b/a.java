package com.mbridge.msdk.foundation.same.net.b;

import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;

public abstract class a extends c<String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9307a = "a";

    public abstract void a(String str);

    public abstract void b(String str);

    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f9307a;
        af.b(str, "errorCode = " + aVar.f9304a);
        a(com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    public void onSuccess(d<String> dVar) {
        if (dVar != null) {
            b((String) dVar.f9311c);
        }
    }
}
