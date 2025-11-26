package O3;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.t;
import r3.C2733c;

final class c extends IllegalArgumentException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(str);
        t.e(str, NotificationCompat.CATEGORY_MESSAGE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(C2733c cVar, C2733c cVar2) {
        this("Serializer for " + cVar2 + " already registered in the scope of " + cVar);
        t.e(cVar, "baseClass");
        t.e(cVar2, "concreteClass");
    }
}
