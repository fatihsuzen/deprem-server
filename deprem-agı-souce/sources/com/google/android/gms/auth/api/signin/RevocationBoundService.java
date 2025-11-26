package com.google.android.gms.auth.api.signin;

import H.v;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

@Deprecated
public final class RevocationBoundService extends Service {
    public IBinder onBind(Intent intent) {
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) || "com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            if (Log.isLoggable("RevocationService", 2)) {
                Log.v("RevocationService", "RevocationBoundService handling ".concat(String.valueOf(intent.getAction())));
            }
            return new v(this);
        }
        Log.w("RevocationService", "Unknown action sent to RevocationBoundService: ".concat(String.valueOf(intent.getAction())));
        return null;
    }
}
