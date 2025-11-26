package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

public final class t implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f9740a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f9741b;

    public final synchronized void execute(Runnable runnable) {
        try {
            if (this.f9740a == null) {
                this.f9740a = a(runnable);
                r.a().execute(this.f9740a);
            } else if (this.f9741b == null) {
                this.f9741b = a(runnable);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private Runnable a(final Runnable runnable) {
        return new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("LimitExecutor", e5.getMessage());
                    }
                } catch (Throwable th) {
                    t.this.a();
                    throw th;
                }
                t.this.a();
            }
        };
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f9741b;
        this.f9740a = runnable;
        this.f9741b = null;
        if (runnable != null) {
            r.a().execute(this.f9740a);
        }
    }
}
