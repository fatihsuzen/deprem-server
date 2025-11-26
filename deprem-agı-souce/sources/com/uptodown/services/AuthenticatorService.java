package com.uptodown.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.jvm.internal.t;
import z2.C2964x;

public final class AuthenticatorService extends Service {
    public IBinder onBind(Intent intent) {
        t.e(intent, "intent");
        IBinder iBinder = new C2964x(this).getIBinder();
        t.d(iBinder, "getIBinder(...)");
        return iBinder;
    }
}
