package com.google.firebase.messaging;

import J.C0645a;
import J.C0647c;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class FirebaseMessagingService extends C1560i {

    /* renamed from: g  reason: collision with root package name */
    private static final Queue f7298g = new ArrayDeque(10);

    /* renamed from: f  reason: collision with root package name */
    private C0647c f7299f;

    private boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue queue = f7298g;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        } else if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        } else {
            Log.d("FirebaseMessaging", "Received duplicate message: " + str);
            return true;
        }
    }

    private void k(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (J.t(extras)) {
            J j5 = new J(extras);
            ExecutorService e5 = C1566o.e();
            try {
                if (!new C1557f(this, j5, e5).a()) {
                    e5.shutdown();
                    if (H.D(intent)) {
                        H.w(intent);
                    }
                } else {
                    return;
                }
            } finally {
                e5.shutdown();
            }
        }
        p(new S(extras));
    }

    private String l(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return intent.getStringExtra("message_id");
        }
        return stringExtra;
    }

    private C0647c m(Context context) {
        if (this.f7299f == null) {
            this.f7299f = new C0647c(context.getApplicationContext());
        }
        return this.f7299f;
    }

    private void n(Intent intent) {
        if (!j(intent.getStringExtra("google.message_id"))) {
            t(intent);
        }
        m(this).b(new C0645a(intent));
    }

    private void t(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        char c5 = 65535;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    c5 = 0;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    c5 = 1;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    c5 = 2;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                o();
                return;
            case 1:
                H.y(intent);
                k(intent);
                return;
            case 2:
                s(l(intent), new W(intent.getStringExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR)));
                return;
            case 3:
                q(intent.getStringExtra("google.message_id"));
                return;
            default:
                Log.w("FirebaseMessaging", "Received message with unknown type: " + stringExtra);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public Intent e(Intent intent) {
        return X.b().c();
    }

    public void f(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            n(intent);
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            r(intent.getStringExtra("token"));
        } else {
            Log.d("FirebaseMessaging", "Unknown intent action: " + intent.getAction());
        }
    }

    public void o() {
    }

    public void p(S s5) {
    }

    public void q(String str) {
    }

    public void r(String str) {
    }

    public void s(String str, Exception exc) {
    }
}
