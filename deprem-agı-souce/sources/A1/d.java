package A1;

import android.text.TextUtils;
import android.util.Log;
import t1.c;

public abstract class d {
    public static void a(String str) {
        if (c.f16596a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void b(String str, Exception exc) {
        if ((c.f16596a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
