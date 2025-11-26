package r;

import android.content.Context;
import java.io.Closeable;
import z.C1952d;

abstract class v implements Closeable {

    interface a {
        a a(Context context);

        v build();
    }

    v() {
    }

    /* access modifiers changed from: package-private */
    public abstract C1952d a();

    public void close() {
        a().close();
    }

    /* access modifiers changed from: package-private */
    public abstract u d();
}
