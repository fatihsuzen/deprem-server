package L2;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.t;

public final class g extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str) {
        super(str);
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
