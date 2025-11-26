package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f292a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f293b;

    public /* synthetic */ p(Consumer consumer, Location location) {
        this.f292a = consumer;
        this.f293b = location;
    }

    public final void run() {
        this.f292a.accept(this.f293b);
    }
}
