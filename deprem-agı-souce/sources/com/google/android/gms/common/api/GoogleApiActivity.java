package com.google.android.gms.common.api;

import K.C0655b;
import M.C0685e;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    protected int f4845a = 0;

    public static Intent a(Context context, PendingIntent pendingIntent, int i5, boolean z4) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i5);
        intent.putExtra("notify_manager", z4);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r12 = this;
            android.content.Intent r0 = r12.getIntent()
            android.os.Bundle r1 = r0.getExtras()
            java.lang.String r2 = "GoogleApiActivity"
            if (r1 != 0) goto L_0x0015
            java.lang.String r0 = "Activity started without extras"
            android.util.Log.e(r2, r0)
            r12.finish()
            return
        L_0x0015:
            java.lang.String r0 = "pending_intent"
            java.lang.Object r0 = r1.get(r0)
            r3 = r0
            android.app.PendingIntent r3 = (android.app.PendingIntent) r3
            java.lang.String r0 = "error_code"
            java.lang.Object r0 = r1.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r3 != 0) goto L_0x0034
            if (r0 == 0) goto L_0x002b
            goto L_0x0034
        L_0x002b:
            java.lang.String r0 = "Activity started without resolution"
            android.util.Log.e(r2, r0)
            r12.finish()
            return
        L_0x0034:
            r4 = 1
            if (r3 == 0) goto L_0x00ae
            android.content.IntentSender r6 = r3.getIntentSender()     // Catch:{ ActivityNotFoundException -> 0x0056, SendIntentException -> 0x004b }
            r10 = 0
            r11 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r5 = r12
            r5.startIntentSenderForResult(r6, r7, r8, r9, r10, r11)     // Catch:{ ActivityNotFoundException -> 0x0049, SendIntentException -> 0x0047 }
            r5.f4845a = r4     // Catch:{ ActivityNotFoundException -> 0x0049, SendIntentException -> 0x0047 }
            return
        L_0x0047:
            r0 = move-exception
            goto L_0x004d
        L_0x0049:
            r0 = move-exception
            goto L_0x0058
        L_0x004b:
            r0 = move-exception
            r5 = r12
        L_0x004d:
            java.lang.String r1 = "Failed to launch pendingIntent"
            android.util.Log.e(r2, r1, r0)
            r12.finish()
            return
        L_0x0056:
            r0 = move-exception
            r5 = r12
        L_0x0058:
            java.lang.String r6 = "notify_manager"
            boolean r1 = r1.getBoolean(r6, r4)
            if (r1 == 0) goto L_0x007b
            M.e r0 = M.C0685e.u(r12)
            K.b r1 = new K.b
            r2 = 22
            r3 = 0
            r1.<init>(r2, r3)
            android.content.Intent r2 = r12.getIntent()
            java.lang.String r3 = "failing_client_id"
            r6 = -1
            int r2 = r2.getIntExtra(r3, r6)
            r0.D(r1, r2)
            goto L_0x00a8
        L_0x007b:
            java.lang.String r1 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Activity not found while launching "
            r3.append(r6)
            r3.append(r1)
            java.lang.String r1 = "."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = android.os.Build.FINGERPRINT
            java.lang.String r6 = "generic"
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x00a5
            java.lang.String r3 = " This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store."
            java.lang.String r1 = r1.concat(r3)
        L_0x00a5:
            android.util.Log.e(r2, r1, r0)
        L_0x00a8:
            r5.f4845a = r4
            r12.finish()
            return
        L_0x00ae:
            r5 = r12
            java.lang.Object r0 = N.C0722p.k(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            K.g r1 = K.C0660g.n()
            r2 = 2
            r1.o(r12, r0, r2, r12)
            r5.f4845a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiActivity.b():void");
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f4845a = 0;
            setResult(i6, intent);
            if (booleanExtra) {
                C0685e u5 = C0685e.u(this);
                if (i6 == -1) {
                    u5.E();
                } else if (i6 == 0) {
                    u5.D(new C0655b(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i5 == 2) {
            this.f4845a = 0;
            setResult(i6, intent);
        }
        finish();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f4845a = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4845a = bundle.getInt("resolution");
        }
        if (this.f4845a != 1) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f4845a);
        super.onSaveInstanceState(bundle);
    }
}
