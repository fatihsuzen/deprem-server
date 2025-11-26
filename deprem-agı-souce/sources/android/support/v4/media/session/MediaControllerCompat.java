package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final b f131a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f132b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet f133c = new HashSet();

    static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f134a;

        /* renamed from: b  reason: collision with root package name */
        final Object f135b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private final List f136c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private HashMap f137d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        final MediaSessionCompat.Token f138e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference f139a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f139a = new WeakReference(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i5, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f139a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f135b) {
                        mediaControllerImplApi21.f138e.e(b.a.i(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f138e.f(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.f();
                    }
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            public void Q(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            public void f(List list) {
                throw new AssertionError();
            }

            public void g(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void h() {
                throw new AssertionError();
            }

            public void p0(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f138e = token;
            Object c5 = c.c(context, token.d());
            this.f134a = c5;
            if (c5 == null) {
                throw new RemoteException();
            } else if (token.c() == null) {
                g();
            }
        }

        private void g() {
            h("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        public MediaMetadataCompat a() {
            Object d5 = c.d(this.f134a);
            if (d5 != null) {
                return MediaMetadataCompat.a(d5);
            }
            return null;
        }

        public final void b(a aVar) {
            c.i(this.f134a, aVar.mCallbackObj);
            synchronized (this.f135b) {
                if (this.f138e.c() != null) {
                    try {
                        a aVar2 = (a) this.f137d.remove(aVar);
                        if (aVar2 != null) {
                            aVar.mIControllerCallback = null;
                            this.f138e.c().A(aVar2);
                        }
                    } catch (RemoteException e5) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e5);
                    }
                } else {
                    this.f136c.remove(aVar);
                }
            }
        }

        public boolean c(KeyEvent keyEvent) {
            return c.b(this.f134a, keyEvent);
        }

        public final void e(a aVar, Handler handler) {
            c.g(this.f134a, aVar.mCallbackObj, handler);
            synchronized (this.f135b) {
                if (this.f138e.c() != null) {
                    a aVar2 = new a(aVar);
                    this.f137d.put(aVar, aVar2);
                    aVar.mIControllerCallback = aVar2;
                    try {
                        this.f138e.c().o(aVar2);
                        aVar.postToHandler(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e5) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e5);
                    }
                } else {
                    aVar.mIControllerCallback = null;
                    this.f136c.add(aVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (this.f138e.c() != null) {
                for (a aVar : this.f136c) {
                    a aVar2 = new a(aVar);
                    this.f137d.put(aVar, aVar2);
                    aVar.mIControllerCallback = aVar2;
                    try {
                        this.f138e.c().o(aVar2);
                        aVar.postToHandler(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e5) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e5);
                    }
                }
                this.f136c.clear();
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.f138e.c() != null) {
                try {
                    return this.f138e.c().getPlaybackState();
                } catch (RemoteException e5) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e5);
                }
            }
            Object e6 = c.e(this.f134a);
            if (e6 != null) {
                return PlaybackStateCompat.a(e6);
            }
            return null;
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver) {
            c.h(this.f134a, str, bundle, resultReceiver);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {
        final Object mCallbackObj = c.a(new b(this));
        C0014a mHandler;
        a mIControllerCallback;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        private class C0014a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f140a = false;

            C0014a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.f140a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            a.this.onSessionEvent((String) message.obj, data);
                            return;
                        case 2:
                            a.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            a.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            a.this.onAudioInfoChanged((e) message.obj);
                            return;
                        case 5:
                            a.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            a.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            a.this.onExtrasChanged(bundle);
                            return;
                        case 8:
                            a.this.onSessionDestroyed();
                            return;
                        case 9:
                            a.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            a.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            a.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            a.this.onSessionReady();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference f142a;

            b(a aVar) {
                this.f142a = new WeakReference(aVar);
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onExtrasChanged(bundle);
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onMetadataChanged(MediaMetadataCompat.a(obj));
                }
            }

            public void c(int i5, int i6, int i7, int i8, int i9) {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onAudioInfoChanged(new e(i5, i6, i7, i8, i9));
                }
            }

            public void d(Object obj) {
                a aVar = (a) this.f142a.get();
                if (aVar != null && aVar.mIControllerCallback == null) {
                    aVar.onPlaybackStateChanged(PlaybackStateCompat.a(obj));
                }
            }

            public void e(String str, Bundle bundle) {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onSessionEvent(str, bundle);
                }
            }

            public void f(List list) {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onQueueChanged(MediaSessionCompat.QueueItem.b(list));
                }
            }

            public void g(CharSequence charSequence) {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onQueueTitleChanged(charSequence);
                }
            }

            public void h() {
                a aVar = (a) this.f142a.get();
                if (aVar != null) {
                    aVar.onSessionDestroyed();
                }
            }
        }

        private static class c extends a.C0015a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference f143a;

            c(a aVar) {
                this.f143a = new WeakReference(aVar);
            }

            public void G(boolean z4) {
                a aVar = (a) this.f143a.get();
                if (aVar != null) {
                    aVar.postToHandler(11, Boolean.valueOf(z4), (Bundle) null);
                }
            }

            public void M(boolean z4) {
            }

            public void Y(int i5) {
                a aVar = (a) this.f143a.get();
                if (aVar != null) {
                    aVar.postToHandler(12, Integer.valueOf(i5), (Bundle) null);
                }
            }

            public void m0(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.f143a.get();
                if (aVar != null) {
                    aVar.postToHandler(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void onEvent(String str, Bundle bundle) {
                a aVar = (a) this.f143a.get();
                if (aVar != null) {
                    aVar.postToHandler(1, str, bundle);
                }
            }

            public void onRepeatModeChanged(int i5) {
                a aVar = (a) this.f143a.get();
                if (aVar != null) {
                    aVar.postToHandler(9, Integer.valueOf(i5), (Bundle) null);
                }
            }

            public void w() {
                a aVar = (a) this.f143a.get();
                if (aVar != null) {
                    aVar.postToHandler(13, (Object) null, (Bundle) null);
                }
            }
        }

        public void binderDied() {
            postToHandler(8, (Object) null, (Bundle) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public a getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void onAudioInfoChanged(e eVar) {
        }

        public void onCaptioningEnabledChanged(boolean z4) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public abstract void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat);

        public abstract void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat);

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i5) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i5) {
        }

        /* access modifiers changed from: package-private */
        public void postToHandler(int i5, Object obj, Bundle bundle) {
            C0014a aVar = this.mHandler;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(i5, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* access modifiers changed from: package-private */
        public void setHandler(Handler handler) {
            if (handler == null) {
                C0014a aVar = this.mHandler;
                if (aVar != null) {
                    aVar.f140a = false;
                    aVar.removeCallbacksAndMessages((Object) null);
                    this.mHandler = null;
                    return;
                }
                return;
            }
            C0014a aVar2 = new C0014a(handler.getLooper());
            this.mHandler = aVar2;
            aVar2.f140a = true;
        }
    }

    interface b {
        MediaMetadataCompat a();

        void b(a aVar);

        boolean c(KeyEvent keyEvent);

        f d();

        void e(a aVar, Handler handler);

        PlaybackStateCompat getPlaybackState();
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        public f d() {
            Object f5 = c.f(this.f134a);
            if (f5 != null) {
                return new h(f5);
            }
            return null;
        }
    }

    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        public f d() {
            Object f5 = c.f(this.f134a);
            if (f5 != null) {
                return new i(f5);
            }
            return null;
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private final int f144a;

        /* renamed from: b  reason: collision with root package name */
        private final int f145b;

        /* renamed from: c  reason: collision with root package name */
        private final int f146c;

        /* renamed from: d  reason: collision with root package name */
        private final int f147d;

        /* renamed from: e  reason: collision with root package name */
        private final int f148e;

        e(int i5, int i6, int i7, int i8, int i9) {
            this.f144a = i5;
            this.f145b = i6;
            this.f146c = i7;
            this.f147d = i8;
            this.f148e = i9;
        }
    }

    public static abstract class f {
        f() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e(long j5);

        public abstract void f(int i5);

        public abstract void g(int i5);

        public abstract void h();

        public abstract void i();
    }

    static class g extends f {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f149a;

        public g(Object obj) {
            this.f149a = obj;
        }

        public void a() {
            c.d.a(this.f149a);
        }

        public void b() {
            c.d.b(this.f149a);
        }

        public void c() {
            c.d.c(this.f149a);
        }

        public void d() {
            c.d.d(this.f149a);
        }

        public void e(long j5) {
            c.d.e(this.f149a, j5);
        }

        public void f(int i5) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i5);
            j("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        public void g(int i5) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i5);
            j("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }

        public void h() {
            c.d.g(this.f149a);
        }

        public void i() {
            c.d.h(this.f149a);
        }

        public void j(String str, Bundle bundle) {
            MediaControllerCompat.h(str, bundle);
            c.d.f(this.f149a, str, bundle);
        }
    }

    static class h extends g {
        public h(Object obj) {
            super(obj);
        }
    }

    static class i extends h {
        public i(Object obj) {
            super(obj);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.f132b = token;
            if (Build.VERSION.SDK_INT >= 24) {
                this.f131a = new d(context, token);
            } else {
                this.f131a = new c(context, token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }

    static void h(String str, Bundle bundle) {
        if (str != null) {
            if (!str.equals("android.support.v4.media.session.action.FOLLOW") && !str.equals("android.support.v4.media.session.action.UNFOLLOW")) {
                return;
            }
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f131a.c(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public MediaMetadataCompat b() {
        return this.f131a.a();
    }

    public PlaybackStateCompat c() {
        return this.f131a.getPlaybackState();
    }

    public f d() {
        return this.f131a.d();
    }

    public void e(a aVar) {
        f(aVar, (Handler) null);
    }

    public void f(a aVar, Handler handler) {
        if (aVar != null) {
            if (handler == null) {
                handler = new Handler();
            }
            aVar.setHandler(handler);
            this.f131a.e(aVar, handler);
            this.f133c.add(aVar);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void g(a aVar) {
        if (aVar != null) {
            try {
                this.f133c.remove(aVar);
                this.f131a.b(aVar);
            } finally {
                aVar.setHandler((Handler) null);
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }
}
