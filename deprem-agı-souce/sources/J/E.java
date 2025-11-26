package J;

import T.e;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.k;
import java.util.List;

public final class E {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2609a;

    /* renamed from: b  reason: collision with root package name */
    private int f2610b;

    /* renamed from: c  reason: collision with root package name */
    private int f2611c = 0;

    public E(Context context) {
        this.f2609a = context;
    }

    public final synchronized int a() {
        PackageInfo packageInfo;
        if (this.f2610b == 0) {
            try {
                packageInfo = e.a(this.f2609a).e("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e5) {
                Log.w("Metadata", "Failed to find package ".concat(e5.toString()));
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f2610b = packageInfo.versionCode;
            }
        }
        return this.f2610b;
    }

    public final synchronized int b() {
        int i5 = this.f2611c;
        if (i5 != 0) {
            return i5;
        }
        Context context = this.f2609a;
        PackageManager packageManager = context.getPackageManager();
        if (e.a(context).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i6 = 1;
        if (!k.e()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                this.f2611c = i6;
                return i6;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) {
            Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
            if (true == k.e()) {
                i6 = 2;
            }
            this.f2611c = i6;
            return i6;
        }
        i6 = 2;
        this.f2611c = i6;
        return i6;
    }
}
