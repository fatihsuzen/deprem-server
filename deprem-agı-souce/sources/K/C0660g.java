package K;

import I.C0643a;
import I.b;
import M.C0676H;
import M.C0677I;
import M.C0688h;
import N.C0706A;
import N.C0722p;
import N.D;
import Z.g;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.k;

/* renamed from: K.g  reason: case insensitive filesystem */
public class C0660g extends C0661h {

    /* renamed from: d  reason: collision with root package name */
    public static final int f2712d = C0661h.f2716a;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2713e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final C0660g f2714f = new C0660g();

    /* renamed from: c  reason: collision with root package name */
    private String f2715c;

    public static C0660g n() {
        return f2714f;
    }

    public Intent b(Context context, int i5, String str) {
        return super.b(context, i5, str);
    }

    public PendingIntent c(Context context, int i5, int i6) {
        return super.c(context, i5, i6);
    }

    public final String e(int i5) {
        return super.e(i5);
    }

    public int g(Context context) {
        return super.g(context);
    }

    public int h(Context context, int i5) {
        return super.h(context, i5);
    }

    public final boolean j(int i5) {
        return super.j(i5);
    }

    public Dialog l(Activity activity, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i5, D.b(activity, b(activity, i5, "d"), i6), onCancelListener, (DialogInterface.OnClickListener) null);
    }

    public PendingIntent m(Context context, C0655b bVar) {
        if (bVar.g()) {
            return bVar.f();
        }
        return c(context, bVar.c(), 0);
    }

    public boolean o(Activity activity, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        Dialog l5 = l(activity, i5, i6, onCancelListener);
        if (l5 == null) {
            return false;
        }
        t(activity, l5, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i5) {
        u(context, i5, (String) null, d(context, i5, 0, "n"));
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.DialogInterface$OnClickListener] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.app.Dialog q(android.content.Context r6, int r7, N.D r8, android.content.DialogInterface.OnCancelListener r9, android.content.DialogInterface.OnClickListener r10) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.res.Resources$Theme r2 = r6.getTheme()
            r3 = 16843529(0x1010309, float:2.3695736E-38)
            r4 = 1
            r2.resolveAttribute(r3, r1, r4)
            android.content.res.Resources r2 = r6.getResources()
            int r1 = r1.resourceId
            java.lang.String r1 = r2.getResourceEntryName(r1)
            java.lang.String r2 = "Theme.Dialog.Alert"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002c
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r1 = 5
            r0.<init>(r6, r1)
        L_0x002c:
            if (r0 != 0) goto L_0x0033
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r6)
        L_0x0033:
            java.lang.String r1 = N.C0706A.c(r6, r7)
            r0.setMessage(r1)
            if (r9 == 0) goto L_0x003f
            r0.setOnCancelListener(r9)
        L_0x003f:
            java.lang.String r9 = N.C0706A.b(r6, r7)
            if (r9 == 0) goto L_0x004b
            if (r8 != 0) goto L_0x0048
            r8 = r10
        L_0x0048:
            r0.setPositiveButton(r9, r8)
        L_0x004b:
            java.lang.String r6 = N.C0706A.f(r6, r7)
            if (r6 == 0) goto L_0x0054
            r0.setTitle(r6)
        L_0x0054:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r8 = 0
            r7[r8] = r6
            java.lang.String r6 = "Creating dialog for Google Play services availability issue. ConnectionResult=%s"
            java.lang.String r6 = java.lang.String.format(r6, r7)
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            java.lang.String r8 = "GoogleApiAvailability"
            android.util.Log.w(r8, r6, r7)
            android.app.AlertDialog r6 = r0.create()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: K.C0660g.q(android.content.Context, int, N.D, android.content.DialogInterface$OnCancelListener, android.content.DialogInterface$OnClickListener):android.app.Dialog");
    }

    public final Dialog r(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C0706A.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        t(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final C0677I s(Context context, C0676H h5) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        C0677I i5 = new C0677I(h5);
        g.a(context, i5, intentFilter);
        i5.a(context);
        if (i(context, "com.google.android.gms")) {
            return i5;
        }
        h5.a();
        i5.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                o.f(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        C0656c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    public final void u(Context context, int i5, String str, PendingIntent pendingIntent) {
        int i6;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i5), null}), new IllegalArgumentException());
        if (i5 == 18) {
            v(context);
        } else if (pendingIntent != null) {
            String e5 = C0706A.e(context, i5);
            String d5 = C0706A.d(context, i5);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) C0722p.k(context.getSystemService("notification"));
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(e5).setStyle(new NotificationCompat.BigTextStyle().bigText(d5));
            if (h.c(context)) {
                C0722p.n(k.b());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (h.d(context)) {
                    style.addAction(C0643a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(b.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(d5);
            }
            if (k.e()) {
                C0722p.n(k.e());
                synchronized (f2713e) {
                    str2 = this.f2715c;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel a5 = notificationManager.getNotificationChannel(str2);
                    String string = context.getResources().getString(b.common_google_play_services_notification_channel_name);
                    if (a5 == null) {
                        notificationManager.createNotificationChannel(androidx.browser.trusted.g.a(str2, string, 4));
                    } else if (!string.contentEquals(a5.getName())) {
                        a5.setName(string);
                        notificationManager.createNotificationChannel(a5);
                    }
                }
                style.setChannelId(str2);
            }
            Notification build = style.build();
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                C0665l.f2722b.set(false);
                i6 = 10436;
            } else {
                i6 = 39789;
            }
            notificationManager.notify(i6, build);
        } else if (i5 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void v(Context context) {
        new q(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean w(Activity activity, C0688h hVar, int i5, int i6, DialogInterface.OnCancelListener onCancelListener) {
        Activity activity2 = activity;
        DialogInterface.OnCancelListener onCancelListener2 = onCancelListener;
        Dialog q5 = q(activity2, i5, D.c(hVar, b(activity, i5, "d"), 2), onCancelListener2, (DialogInterface.OnClickListener) null);
        if (q5 == null) {
            return false;
        }
        t(activity2, q5, "GooglePlayServicesErrorDialog", onCancelListener2);
        return true;
    }

    public final boolean x(Context context, C0655b bVar, int i5) {
        PendingIntent m5;
        if (T.b.a(context) || (m5 = m(context, bVar)) == null) {
            return false;
        }
        u(context, bVar.c(), (String) null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, m5, i5, true), Z.h.f4496a | 134217728));
        return true;
    }
}
