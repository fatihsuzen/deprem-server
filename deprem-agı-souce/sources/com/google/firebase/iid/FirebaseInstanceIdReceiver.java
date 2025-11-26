package com.google.firebase.iid;

import J.C0645a;
import J.C0646b;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.messaging.C1565n;
import com.google.firebase.messaging.H;
import java.util.concurrent.ExecutionException;
import k0.C1701o;

public final class FirebaseInstanceIdReceiver extends C0646b {
    private static Intent f(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public int b(Context context, C0645a aVar) {
        try {
            return ((Integer) C1701o.a(new C1565n(context).g(aVar.c()))).intValue();
        } catch (InterruptedException | ExecutionException e5) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e5);
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    public void c(Context context, Bundle bundle) {
        Intent f5 = f(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (H.D(f5)) {
            H.v(f5);
        }
    }
}
