package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f256a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f257b;

    public /* synthetic */ b(ResourcesCompat.FontCallback fontCallback, int i5) {
        this.f256a = fontCallback;
        this.f257b = i5;
    }

    public final void run() {
        this.f256a.onFontRetrievalFailed(this.f257b);
    }
}
