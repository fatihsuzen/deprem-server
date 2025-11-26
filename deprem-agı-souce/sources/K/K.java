package K;

import java.util.concurrent.Callable;

final class K extends M {

    /* renamed from: f  reason: collision with root package name */
    private final Callable f2693f;

    /* synthetic */ K(Callable callable, L l5) {
        super(false, 1, 5, (String) null, (Throwable) null, (L) null);
        this.f2693f = callable;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        try {
            return (String) this.f2693f.call();
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}
