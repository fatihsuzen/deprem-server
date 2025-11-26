package H;

import L.f;
import M.C0693m;
import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class g extends AsyncTaskLoader implements C0693m {

    /* renamed from: a  reason: collision with root package name */
    private final Semaphore f2495a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private final Set f2496b;

    public g(Context context, Set set) {
        super(context);
        this.f2496b = set;
    }

    public final /* bridge */ /* synthetic */ Object loadInBackground() {
        int i5 = 0;
        for (f d5 : this.f2496b) {
            if (d5.d(this)) {
                i5++;
            }
        }
        try {
            this.f2495a.tryAcquire(i5, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e5) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e5);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void onStartLoading() {
        this.f2495a.drainPermits();
        forceLoad();
    }
}
