package H2;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.t;

public abstract class d {
    public static void a(int i5, String str, String str2, Throwable th, Boolean bool) {
        if (2 <= b.a(i5) && t.a(bool, Boolean.TRUE)) {
            if (i5 != 0) {
                int i6 = i5 - 1;
                if (i6 == 0) {
                    Log.v(str, str2, th);
                } else if (i6 == 1) {
                    Log.d(str, str2, th);
                } else if (i6 == 2) {
                    Log.i(str, str2, th);
                } else if (i6 == 3) {
                    Log.w(str, str2, th);
                } else if (i6 == 4) {
                    Log.e(str, str2, th);
                }
            } else {
                throw null;
            }
        }
    }

    public static void b(String str, String str2) {
        t.e(str, "tag");
        t.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        a(3, str, str2, (Throwable) null, Boolean.FALSE);
    }

    public static void c(String str, String str2, Exception exc, Boolean bool, int i5) {
        if ((i5 & 1) != 0) {
            str = "Inmobi Cmp";
        }
        if ((i5 & 4) != 0) {
            exc = null;
        }
        if ((i5 & 8) != 0) {
            bool = Boolean.FALSE;
        }
        t.e(str2, NotificationCompat.CATEGORY_MESSAGE);
        a(5, str, str2, exc, bool);
    }
}
