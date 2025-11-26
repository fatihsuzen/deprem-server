package N;

import T.e;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public abstract class Y {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3006a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3007b;

    /* renamed from: c  reason: collision with root package name */
    private static String f3008c;

    /* renamed from: d  reason: collision with root package name */
    private static int f3009d;

    public static int a(Context context) {
        b(context);
        return f3009d;
    }

    private static void b(Context context) {
        synchronized (f3006a) {
            try {
                if (!f3007b) {
                    f3007b = true;
                    Bundle bundle = e.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f3008c = bundle.getString("com.google.app.id");
                        f3009d = bundle.getInt("com.google.android.gms.version");
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                Log.wtf("MetadataValueReader", "This should never happen.", e5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
