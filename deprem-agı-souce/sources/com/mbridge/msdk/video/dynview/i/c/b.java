package com.mbridge.msdk.video.dynview.i.c;

import android.os.CountDownTimer;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private long f12134a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f12135b;

    /* renamed from: c  reason: collision with root package name */
    private a f12136c;

    /* renamed from: d  reason: collision with root package name */
    private a f12137d;

    private static class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private a f12138a;

        public a(long j5, long j6) {
            super(j5, j6);
        }

        /* access modifiers changed from: package-private */
        public final void a(a aVar) {
            this.f12138a = aVar;
        }

        public final void onFinish() {
            a aVar = this.f12138a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void onTick(long j5) {
            a aVar = this.f12138a;
            if (aVar != null) {
                aVar.a(j5);
            }
        }
    }

    private void c() {
        a aVar = this.f12137d;
        if (aVar != null) {
            aVar.cancel();
            this.f12137d = null;
        }
        if (this.f12135b <= 0) {
            this.f12135b = this.f12134a + 1000;
        }
        a aVar2 = new a(this.f12134a, this.f12135b);
        this.f12137d = aVar2;
        aVar2.a(this.f12136c);
    }

    public final b a(long j5) {
        if (j5 < 0) {
            j5 = 1000;
        }
        this.f12135b = j5;
        return this;
    }

    public final b b(long j5) {
        this.f12134a = j5;
        return this;
    }

    public final b a(a aVar) {
        this.f12136c = aVar;
        return this;
    }

    public final void b() {
        a aVar = this.f12137d;
        if (aVar != null) {
            aVar.cancel();
            this.f12137d = null;
        }
    }

    public final void a() {
        if (this.f12137d == null) {
            c();
        }
        this.f12137d.start();
    }

    public final void a(long j5, a aVar) {
        this.f12134a = j5;
        this.f12136c = aVar;
        c();
        a aVar2 = this.f12137d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }
}
