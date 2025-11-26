package com.mbridge.msdk.tracker.network;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class g implements x {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f11585a;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final u f11588a;

        /* renamed from: b  reason: collision with root package name */
        private final w f11589b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f11590c;

        public a(u uVar, w wVar, Runnable runnable) {
            this.f11588a = uVar;
            this.f11589b = wVar;
            this.f11590c = runnable;
        }

        public final void run() {
            if (this.f11588a.n()) {
                this.f11588a.c("canceled-at-delivery");
                return;
            }
            w wVar = this.f11589b;
            ad adVar = wVar.f11722c;
            if (adVar == null) {
                this.f11588a.a(wVar.f11720a);
            } else {
                this.f11588a.b(adVar);
            }
            if (!this.f11589b.f11723d) {
                this.f11588a.c("done");
            }
            Runnable runnable = this.f11590c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public g(final Handler handler) {
        this.f11585a = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void a(u<?> uVar, ad adVar) {
        this.f11585a.execute(new a(uVar, w.a(adVar), (Runnable) null));
    }

    public g(Executor executor) {
        this.f11585a = executor;
    }

    public final void a(u<?> uVar, w<?> wVar) {
        uVar.w();
        this.f11585a.execute(new a(uVar, wVar, (Runnable) null));
    }
}
