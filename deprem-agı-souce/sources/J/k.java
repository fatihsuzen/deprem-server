package J;

import android.os.Build;
import android.util.Log;
import j$.util.Objects;

public final class k extends ClassLoader {
    /* access modifiers changed from: protected */
    public final Class loadClass(String str, boolean z4) {
        if (!Objects.equals(str, "com.google.android.gms.iid.MessengerCompat")) {
            return super.loadClass(str, z4);
        }
        if (!Log.isLoggable("CloudMessengerCompat", 3) && (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("CloudMessengerCompat", 3))) {
            return l.class;
        }
        Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
        return l.class;
    }
}
