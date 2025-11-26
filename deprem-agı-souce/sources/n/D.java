package N;

import M.C0688h;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public abstract class D implements DialogInterface.OnClickListener {
    public static D b(Activity activity, Intent intent, int i5) {
        return new B(intent, activity, i5);
    }

    public static D c(C0688h hVar, Intent intent, int i5) {
        return new C(intent, hVar, 2);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void onClick(DialogInterface dialogInterface, int i5) {
        try {
            a();
        } catch (ActivityNotFoundException e5) {
            String str = "Failed to start resolution intent.";
            if (true == Build.FINGERPRINT.contains("generic")) {
                str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", str, e5);
        } catch (Throwable th) {
            dialogInterface.dismiss();
            throw th;
        }
        dialogInterface.dismiss();
    }
}
