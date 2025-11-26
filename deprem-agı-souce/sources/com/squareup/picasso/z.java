package com.squareup.picasso;

import M1.d;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

class z {

    /* renamed from: a  reason: collision with root package name */
    final HandlerThread f13460a;

    /* renamed from: b  reason: collision with root package name */
    final M1.a f13461b;

    /* renamed from: c  reason: collision with root package name */
    final Handler f13462c;

    /* renamed from: d  reason: collision with root package name */
    long f13463d;

    /* renamed from: e  reason: collision with root package name */
    long f13464e;

    /* renamed from: f  reason: collision with root package name */
    long f13465f;

    /* renamed from: g  reason: collision with root package name */
    long f13466g;

    /* renamed from: h  reason: collision with root package name */
    long f13467h;

    /* renamed from: i  reason: collision with root package name */
    long f13468i;

    /* renamed from: j  reason: collision with root package name */
    long f13469j;

    /* renamed from: k  reason: collision with root package name */
    long f13470k;

    /* renamed from: l  reason: collision with root package name */
    int f13471l;

    /* renamed from: m  reason: collision with root package name */
    int f13472m;

    /* renamed from: n  reason: collision with root package name */
    int f13473n;

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final z f13474a;

        /* renamed from: com.squareup.picasso.z$a$a  reason: collision with other inner class name */
        class C0118a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Message f13475a;

            C0118a(Message message) {
                this.f13475a = message;
            }

            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f13475a.what);
            }
        }

        a(Looper looper, z zVar) {
            super(looper);
            this.f13474a = zVar;
        }

        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 0) {
                this.f13474a.j();
            } else if (i5 == 1) {
                this.f13474a.k();
            } else if (i5 == 2) {
                this.f13474a.h((long) message.arg1);
            } else if (i5 == 3) {
                this.f13474a.i((long) message.arg1);
            } else if (i5 != 4) {
                s.f13356o.post(new C0118a(message));
            } else {
                this.f13474a.l((Long) message.obj);
            }
        }
    }

    z(M1.a aVar) {
        this.f13461b = aVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f13460a = handlerThread;
        handlerThread.start();
        C.i(handlerThread.getLooper());
        this.f13462c = new a(handlerThread.getLooper(), this);
    }

    private static long g(int i5, long j5) {
        return j5 / ((long) i5);
    }

    private void m(Bitmap bitmap, int i5) {
        int j5 = C.j(bitmap);
        Handler handler = this.f13462c;
        handler.sendMessage(handler.obtainMessage(i5, j5, 0));
    }

    /* access modifiers changed from: package-private */
    public d a() {
        int a5 = this.f13461b.a();
        int size = this.f13461b.size();
        long j5 = this.f13463d;
        long j6 = this.f13464e;
        long j7 = this.f13465f;
        long j8 = this.f13466g;
        long j9 = this.f13467h;
        long j10 = this.f13468i;
        int i5 = a5;
        long j11 = this.f13469j;
        long j12 = this.f13470k;
        int i6 = this.f13471l;
        int i7 = this.f13472m;
        int i8 = i6;
        int i9 = i8;
        int i10 = i7;
        return new d(i5, size, j5, j6, j7, j8, j9, j10, j11, j12, i9, i10, this.f13473n, System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public void b(Bitmap bitmap) {
        m(bitmap, 2);
    }

    /* access modifiers changed from: package-private */
    public void c(Bitmap bitmap) {
        m(bitmap, 3);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f13462c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f13462c.sendEmptyMessage(1);
    }

    /* access modifiers changed from: package-private */
    public void f(long j5) {
        Handler handler = this.f13462c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j5)));
    }

    /* access modifiers changed from: package-private */
    public void h(long j5) {
        int i5 = this.f13472m + 1;
        this.f13472m = i5;
        long j6 = this.f13466g + j5;
        this.f13466g = j6;
        this.f13469j = g(i5, j6);
    }

    /* access modifiers changed from: package-private */
    public void i(long j5) {
        this.f13473n++;
        long j6 = this.f13467h + j5;
        this.f13467h = j6;
        this.f13470k = g(this.f13472m, j6);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f13463d++;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f13464e++;
    }

    /* access modifiers changed from: package-private */
    public void l(Long l5) {
        this.f13471l++;
        long longValue = this.f13465f + l5.longValue();
        this.f13465f = longValue;
        this.f13468i = g(this.f13471l, longValue);
    }
}
