package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.i;
import com.google.firebase.messaging.n0;
import k0.C1698l;

class k0 extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final a f7453a;

    interface a {
        C1698l a(Intent intent);
    }

    k0(a aVar) {
        this.f7453a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void b(n0.a aVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            this.f7453a.a(aVar.f7466a).b(new i(), new j0(aVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
