package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;

abstract class b {

    interface a {
        void a();

        void c();

        void d();
    }

    /* renamed from: android.support.v4.media.b$b  reason: collision with other inner class name */
    static class C0013b extends MediaBrowser.ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        protected final a f130a;

        public C0013b(a aVar) {
            this.f130a = aVar;
        }

        public void onConnected() {
            this.f130a.c();
        }

        public void onConnectionFailed() {
            this.f130a.d();
        }

        public void onConnectionSuspended() {
            this.f130a.a();
        }
    }

    public static void a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    public static Object b(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    public static Object c(a aVar) {
        return new C0013b(aVar);
    }

    public static void d(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    public static Bundle e(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    public static Object f(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }
}
