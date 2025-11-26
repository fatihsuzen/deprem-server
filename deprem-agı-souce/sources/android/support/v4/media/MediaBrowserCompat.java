package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {

    /* renamed from: b  reason: collision with root package name */
    static final boolean f86b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    private final c f87a;

    private static class CustomActionResultReceiver extends d.b {
        /* access modifiers changed from: protected */
        public void a(int i5, Bundle bundle) {
        }
    }

    private static class ItemReceiver extends d.b {
        /* access modifiers changed from: protected */
        public void a(int i5, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i5 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                MediaItem mediaItem = (MediaItem) parcelable;
                throw null;
            }
            throw null;
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f88a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f89b;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: b */
            public MediaItem[] newArray(int i5) {
                return new MediaItem[i5];
            }
        }

        MediaItem(Parcel parcel) {
            this.f88a = parcel.readInt();
            this.f89b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f88a + ", mDescription=" + this.f89b + '}';
        }

        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.f88a);
            this.f89b.writeToParcel(parcel, i5);
        }
    }

    private static class SearchResultReceiver extends d.b {
        /* access modifiers changed from: protected */
        public void a(int i5, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i5 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            throw null;
        }
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f90a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference f91b;

        a(g gVar) {
            this.f90a = new WeakReference(gVar);
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            this.f91b = new WeakReference(messenger);
        }

        public void handleMessage(Message message) {
            WeakReference weakReference = this.f91b;
            if (weakReference != null && weakReference.get() != null && this.f90a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                g gVar = (g) this.f90a.get();
                Messenger messenger = (Messenger) this.f91b.get();
                try {
                    int i5 = message.what;
                    if (i5 == 1) {
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.a(bundle);
                        gVar.f(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                    } else if (i5 == 2) {
                        gVar.i(messenger);
                    } else if (i5 != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                        MediaSessionCompat.a(bundle2);
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                        MediaSessionCompat.a(bundle3);
                        gVar.g(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        gVar.i(messenger);
                    }
                }
            }
        }
    }

    public static class b {
        a mConnectionCallbackInternal;
        final Object mConnectionCallbackObj = b.c(new C0012b());

        interface a {
            void a();

            void c();

            void d();
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        private class C0012b implements b.a {
            C0012b() {
            }

            public void a() {
                a aVar = b.this.mConnectionCallbackInternal;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.onConnectionSuspended();
            }

            public void c() {
                a aVar = b.this.mConnectionCallbackInternal;
                if (aVar != null) {
                    aVar.c();
                }
                b.this.onConnected();
            }

            public void d() {
                a aVar = b.this.mConnectionCallbackInternal;
                if (aVar != null) {
                    aVar.d();
                }
                b.this.onConnectionFailed();
            }
        }

        public abstract void onConnected();

        public abstract void onConnectionFailed();

        public abstract void onConnectionSuspended();

        /* access modifiers changed from: package-private */
        public void setInternalConnectionCallback(a aVar) {
            this.mConnectionCallbackInternal = aVar;
        }
    }

    interface c {
        void b();

        MediaSessionCompat.Token e();

        void h();
    }

    static class d implements c, g, b.a {

        /* renamed from: a  reason: collision with root package name */
        final Context f93a;

        /* renamed from: b  reason: collision with root package name */
        protected final Object f94b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f95c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f96d = new a(this);

        /* renamed from: e  reason: collision with root package name */
        private final ArrayMap f97e = new ArrayMap();

        /* renamed from: f  reason: collision with root package name */
        protected int f98f;

        /* renamed from: g  reason: collision with root package name */
        protected h f99g;

        /* renamed from: h  reason: collision with root package name */
        protected Messenger f100h;

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f101i;

        d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            Bundle bundle2;
            this.f93a = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.f95c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bVar.setInternalConnectionCallback(this);
            this.f94b = b.b(context, componentName, bVar.mConnectionCallbackObj, bundle2);
        }

        public void a() {
            this.f99g = null;
            this.f100h = null;
            this.f101i = null;
            this.f96d.a((Messenger) null);
        }

        public void b() {
            Messenger messenger;
            h hVar = this.f99g;
            if (!(hVar == null || (messenger = this.f100h) == null)) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            b.d(this.f94b);
        }

        public void c() {
            Bundle e5 = b.e(this.f94b);
            if (e5 != null) {
                this.f98f = e5.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(e5, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.f99g = new h(binder, this.f95c);
                    Messenger messenger = new Messenger(this.f96d);
                    this.f100h = messenger;
                    this.f96d.a(messenger);
                    try {
                        this.f99g.a(this.f93a, this.f100h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                android.support.v4.media.session.b i5 = b.a.i(BundleCompat.getBinder(e5, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (i5 != null) {
                    this.f101i = MediaSessionCompat.Token.b(b.f(this.f94b), i5);
                }
            }
        }

        public void d() {
        }

        public MediaSessionCompat.Token e() {
            if (this.f101i == null) {
                this.f101i = MediaSessionCompat.Token.a(b.f(this.f94b));
            }
            return this.f101i;
        }

        public void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        public void g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f100h == messenger) {
                a.a(this.f97e.get(str));
                if (MediaBrowserCompat.f86b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        public void h() {
            b.a(this.f94b);
        }

        public void i(Messenger messenger) {
        }
    }

    static class e extends d {
        e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    interface g {
        void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void i(Messenger messenger);
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f102a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f103b;

        public h(IBinder iBinder, Bundle bundle) {
            this.f102a = new Messenger(iBinder);
            this.f103b = bundle;
        }

        private void b(int i5, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i5;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f102a.send(obtain);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f103b);
            b(6, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void c(Messenger messenger) {
            b(7, (Bundle) null, messenger);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f87a = new f(context, componentName, bVar, bundle);
        } else {
            this.f87a = new e(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        this.f87a.h();
    }

    public void b() {
        this.f87a.b();
    }

    public MediaSessionCompat.Token c() {
        return this.f87a.e();
    }
}
