package androidx.browser.trusted;

import android.net.Uri;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f233a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f234b;

    public /* synthetic */ j(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f233a = trustedWebActivityServiceConnectionPool;
        this.f234b = uri;
    }

    public final void run() {
        this.f233a.mConnections.remove(this.f234b);
    }
}
