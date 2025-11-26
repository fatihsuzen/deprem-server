package com.mbridge.msdk.b.a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

public final class a implements PreloadListener {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<PreloadListener> f7866a;

    /* renamed from: b  reason: collision with root package name */
    private int f7867b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7868c = false;

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.f7866a = new WeakReference<>(preloadListener);
        }
    }

    public final boolean a() {
        return this.f7868c;
    }

    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.f7866a;
        if (weakReference != null && weakReference.get() != null) {
            this.f7866a.get().onPreloadFaild(str);
        }
    }

    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.f7866a;
        if (weakReference != null && weakReference.get() != null) {
            this.f7866a.get().onPreloadSucceed();
        }
    }

    public final void a(boolean z4) {
        this.f7868c = z4;
    }
}
