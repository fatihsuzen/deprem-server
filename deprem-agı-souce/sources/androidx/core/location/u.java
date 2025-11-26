package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f299a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f300b;

    public /* synthetic */ u(Consumer consumer, Location location) {
        this.f299a = consumer;
        this.f300b = location;
    }

    public final void run() {
        this.f299a.accept(this.f300b);
    }
}
