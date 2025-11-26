package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import com.squareup.picasso.C1585a;
import j$.util.DesugarCollections;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class s {

    /* renamed from: o  reason: collision with root package name */
    static final Handler f13356o = new a(Looper.getMainLooper());

    /* renamed from: p  reason: collision with root package name */
    static volatile s f13357p = null;

    /* renamed from: a  reason: collision with root package name */
    private final g f13358a;

    /* renamed from: b  reason: collision with root package name */
    private final c f13359b;

    /* renamed from: c  reason: collision with root package name */
    private final List f13360c;

    /* renamed from: d  reason: collision with root package name */
    final Context f13361d;

    /* renamed from: e  reason: collision with root package name */
    final g f13362e;

    /* renamed from: f  reason: collision with root package name */
    final M1.a f13363f;

    /* renamed from: g  reason: collision with root package name */
    final z f13364g;

    /* renamed from: h  reason: collision with root package name */
    final Map f13365h;

    /* renamed from: i  reason: collision with root package name */
    final Map f13366i;

    /* renamed from: j  reason: collision with root package name */
    final ReferenceQueue f13367j;

    /* renamed from: k  reason: collision with root package name */
    final Bitmap.Config f13368k;

    /* renamed from: l  reason: collision with root package name */
    boolean f13369l;

    /* renamed from: m  reason: collision with root package name */
    volatile boolean f13370m;

    /* renamed from: n  reason: collision with root package name */
    boolean f13371n;

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 != 3) {
                int i6 = 0;
                if (i5 == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    while (i6 < size) {
                        C1587c cVar = (C1587c) list.get(i6);
                        cVar.f13269b.d(cVar);
                        i6++;
                    }
                } else if (i5 == 13) {
                    List list2 = (List) message.obj;
                    int size2 = list2.size();
                    while (i6 < size2) {
                        C1585a aVar = (C1585a) list2.get(i6);
                        aVar.f13247a.n(aVar);
                        i6++;
                    }
                } else {
                    throw new AssertionError("Unknown handler message received: " + message.what);
                }
            } else {
                C1585a aVar2 = (C1585a) message.obj;
                if (aVar2.g().f13370m) {
                    C.u("Main", "canceled", aVar2.f13248b.d(), "target got garbage collected");
                }
                aVar2.f13247a.a(aVar2.k());
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f13372a;

        /* renamed from: b  reason: collision with root package name */
        private M1.c f13373b;

        /* renamed from: c  reason: collision with root package name */
        private ExecutorService f13374c;

        /* renamed from: d  reason: collision with root package name */
        private M1.a f13375d;

        /* renamed from: e  reason: collision with root package name */
        private g f13376e;

        /* renamed from: f  reason: collision with root package name */
        private List f13377f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap.Config f13378g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f13379h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f13380i;

        public b(Context context) {
            if (context != null) {
                this.f13372a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public s a() {
            Context context = this.f13372a;
            if (this.f13373b == null) {
                this.f13373b = new r(context);
            }
            if (this.f13375d == null) {
                this.f13375d = new l(context);
            }
            if (this.f13374c == null) {
                this.f13374c = new u();
            }
            if (this.f13376e == null) {
                this.f13376e = g.f13394a;
            }
            z zVar = new z(this.f13375d);
            z zVar2 = zVar;
            return new s(context, new g(context, this.f13374c, s.f13356o, this.f13373b, this.f13375d, zVar), this.f13375d, (d) null, this.f13376e, this.f13377f, zVar2, this.f13378g, this.f13379h, this.f13380i);
        }
    }

    private static class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final ReferenceQueue f13381a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f13382b;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Exception f13383a;

            a(Exception exc) {
                this.f13383a = exc;
            }

            public void run() {
                throw new RuntimeException(this.f13383a);
            }
        }

        c(ReferenceQueue referenceQueue, Handler handler) {
            this.f13381a = referenceQueue;
            this.f13382b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C1585a.C0115a aVar = (C1585a.C0115a) this.f13381a.remove(1000);
                    Message obtainMessage = this.f13382b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f13259a;
                        this.f13382b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e5) {
                    this.f13382b.post(new a(e5));
                    return;
                }
            }
        }
    }

    public interface d {
    }

    public enum e {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        

        /* renamed from: a  reason: collision with root package name */
        final int f13389a;

        private e(int i5) {
            this.f13389a = i5;
        }
    }

    public enum f {
        LOW,
        NORMAL,
        HIGH
    }

    public interface g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f13394a = new a();

        static class a implements g {
            a() {
            }

            public v a(v vVar) {
                return vVar;
            }
        }

        v a(v vVar);
    }

    s(Context context, g gVar, M1.a aVar, d dVar, g gVar2, List list, z zVar, Bitmap.Config config, boolean z4, boolean z5) {
        int i5;
        this.f13361d = context;
        this.f13362e = gVar;
        this.f13363f = aVar;
        this.f13358a = gVar2;
        this.f13368k = config;
        if (list != null) {
            i5 = list.size();
        } else {
            i5 = 0;
        }
        ArrayList arrayList = new ArrayList(i5 + 7);
        arrayList.add(new y(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new d(context));
        arrayList.add(new n(context));
        arrayList.add(new e(context));
        arrayList.add(new C1586b(context));
        arrayList.add(new i(context));
        arrayList.add(new q(gVar.f13301d, zVar));
        this.f13360c = DesugarCollections.unmodifiableList(arrayList);
        this.f13364g = zVar;
        this.f13365h = new WeakHashMap();
        this.f13366i = new WeakHashMap();
        this.f13369l = z4;
        this.f13370m = z5;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.f13367j = referenceQueue;
        c cVar = new c(referenceQueue, f13356o);
        this.f13359b = cVar;
        cVar.start();
    }

    private void f(Bitmap bitmap, e eVar, C1585a aVar, Exception exc) {
        if (!aVar.l()) {
            if (!aVar.m()) {
                this.f13365h.remove(aVar.k());
            }
            if (bitmap == null) {
                aVar.c(exc);
                if (this.f13370m) {
                    C.u("Main", "errored", aVar.f13248b.d(), exc.getMessage());
                }
            } else if (eVar != null) {
                aVar.b(bitmap, eVar);
                if (this.f13370m) {
                    String d5 = aVar.f13248b.d();
                    C.u("Main", "completed", d5, "from " + eVar);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public static s h() {
        if (f13357p == null) {
            synchronized (s.class) {
                try {
                    if (f13357p == null) {
                        Context context = PicassoProvider.f13246a;
                        if (context != null) {
                            f13357p = new b(context).a();
                        } else {
                            throw new IllegalStateException("context == null");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13357p;
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        C.c();
        C1585a aVar = (C1585a) this.f13365h.remove(obj);
        if (aVar != null) {
            aVar.a();
            this.f13362e.c(aVar);
        }
        if (obj instanceof ImageView) {
            f fVar = (f) this.f13366i.remove((ImageView) obj);
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void b(ImageView imageView) {
        if (imageView != null) {
            a(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void c(A a5) {
        if (a5 != null) {
            a(a5);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    /* access modifiers changed from: package-private */
    public void d(C1587c cVar) {
        boolean z4;
        C1585a h5 = cVar.h();
        List i5 = cVar.i();
        if (i5 == null || i5.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (h5 != null || z4) {
            Uri uri = cVar.j().f13408d;
            Exception k5 = cVar.k();
            Bitmap s5 = cVar.s();
            e o5 = cVar.o();
            if (h5 != null) {
                f(s5, o5, h5, k5);
            }
            if (z4) {
                int size = i5.size();
                for (int i6 = 0; i6 < size; i6++) {
                    f(s5, o5, (C1585a) i5.get(i6), k5);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(ImageView imageView, f fVar) {
        if (this.f13366i.containsKey(imageView)) {
            a(imageView);
        }
        this.f13366i.put(imageView, fVar);
    }

    /* access modifiers changed from: package-private */
    public void g(C1585a aVar) {
        Object k5 = aVar.k();
        if (!(k5 == null || this.f13365h.get(k5) == aVar)) {
            a(k5);
            this.f13365h.put(k5, aVar);
        }
        o(aVar);
    }

    /* access modifiers changed from: package-private */
    public List i() {
        return this.f13360c;
    }

    public w j(int i5) {
        if (i5 != 0) {
            return new w(this, (Uri) null, i5);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public w k(Uri uri) {
        return new w(this, uri, 0);
    }

    public w l(String str) {
        if (str == null) {
            return new w(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return k(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* access modifiers changed from: package-private */
    public Bitmap m(String str) {
        Bitmap bitmap = this.f13363f.get(str);
        if (bitmap != null) {
            this.f13364g.d();
            return bitmap;
        }
        this.f13364g.e();
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public void n(C1585a aVar) {
        Bitmap bitmap;
        if (o.a(aVar.f13251e)) {
            bitmap = m(aVar.d());
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            e eVar = e.MEMORY;
            f(bitmap, eVar, aVar, (Exception) null);
            if (this.f13370m) {
                C.u("Main", "completed", aVar.f13248b.d(), "from " + eVar);
                return;
            }
            return;
        }
        g(aVar);
        if (this.f13370m) {
            C.t("Main", "resumed", aVar.f13248b.d());
        }
    }

    /* access modifiers changed from: package-private */
    public void o(C1585a aVar) {
        this.f13362e.h(aVar);
    }

    /* access modifiers changed from: package-private */
    public v p(v vVar) {
        v a5 = this.f13358a.a(vVar);
        if (a5 != null) {
            return a5;
        }
        throw new IllegalStateException("Request transformer " + this.f13358a.getClass().getCanonicalName() + " returned null for " + vVar);
    }
}
