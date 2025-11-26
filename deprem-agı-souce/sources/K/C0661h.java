package K;

import N.s0;
import T.e;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.PendingIntentCompat;
import com.google.android.gms.common.util.h;

/* renamed from: K.h  reason: case insensitive filesystem */
public class C0661h {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2716a = C0665l.f2721a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0661h f2717b = new C0661h();

    C0661h() {
    }

    public static C0661h f() {
        return f2717b;
    }

    public int a(Context context) {
        return C0665l.b(context);
    }

    public Intent b(Context context, int i5, String str) {
        if (i5 == 1 || i5 == 2) {
            if (context == null || !h.d(context)) {
                StringBuilder sb = new StringBuilder();
                sb.append("gcore_");
                sb.append(f2716a);
                sb.append("-");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                sb.append("-");
                if (context != null) {
                    sb.append(context.getPackageName());
                }
                sb.append("-");
                if (context != null) {
                    try {
                        sb.append(e.a(context).e(context.getPackageName(), 0).versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                String sb2 = sb.toString();
                int i6 = s0.f3152c;
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(sb2)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            }
            int i7 = s0.f3152c;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else if (i5 != 3) {
            return null;
        } else {
            int i8 = s0.f3152c;
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", (String) null);
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(fromParts);
            return intent3;
        }
    }

    public PendingIntent c(Context context, int i5, int i6) {
        return d(context, i5, i6, (String) null);
    }

    public PendingIntent d(Context context, int i5, int i6, String str) {
        Intent b5 = b(context, i5, str);
        if (b5 == null) {
            return null;
        }
        return PendingIntentCompat.getActivity(context, i6, b5, 134217728, false);
    }

    public String e(int i5) {
        return C0665l.c(i5);
    }

    public int g(Context context) {
        return h(context, f2716a);
    }

    public int h(Context context, int i5) {
        int g5 = C0665l.g(context, i5);
        if (C0665l.h(context, g5)) {
            return 18;
        }
        return g5;
    }

    public boolean i(Context context, String str) {
        return C0665l.l(context, str);
    }

    public boolean j(int i5) {
        return C0665l.j(i5);
    }

    public void k(Context context, int i5) {
        C0665l.a(context, i5);
    }
}
