package androidx.datastore.core;

import W2.J;
import androidx.core.app.NotificationCompat;
import androidx.datastore.core.Message;
import java.util.concurrent.CancellationException;
import k3.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import w3.C2901v;

final class DataStoreImpl$writeActor$2 extends u implements p {
    public static final DataStoreImpl$writeActor$2 INSTANCE = new DataStoreImpl$writeActor$2();

    DataStoreImpl$writeActor$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Update) obj, (Throwable) obj2);
        return J.f19942a;
    }

    public final void invoke(Message.Update<T> update, Throwable th) {
        t.e(update, NotificationCompat.CATEGORY_MESSAGE);
        C2901v ack = update.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        ack.t(th);
    }
}
