package com.mbridge.msdk.e.a;

import android.os.CountDownTimer;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private a f8757a;

    /* renamed from: b  reason: collision with root package name */
    private long f8758b;

    /* renamed from: c  reason: collision with root package name */
    private a f8759c;

    /* renamed from: d  reason: collision with root package name */
    private long f8760d = 0;

    private static class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private a f8761a;

        public a(long j5, long j6) {
            super(j5, j6);
        }

        /* access modifiers changed from: package-private */
        public final void a(a aVar) {
            this.f8761a = aVar;
        }

        public final void onFinish() {
            a aVar = this.f8761a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        public final void onTick(long j5) {
            a aVar = this.f8761a;
            if (aVar != null) {
                aVar.onTick(j5);
            }
        }
    }

    public final void a() {
        a aVar = this.f8759c;
        if (aVar != null) {
            aVar.cancel();
            this.f8759c = null;
        }
    }

    public final b b(long j5) {
        this.f8760d = j5;
        return this;
    }

    public final void b() {
        a aVar = this.f8759c;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.f8759c = null;
            }
            if (this.f8758b <= 0) {
                this.f8758b = this.f8760d + 1000;
            }
            a aVar2 = new a(this.f8760d, this.f8758b);
            this.f8759c = aVar2;
            aVar2.a(this.f8757a);
        }
        this.f8759c.start();
    }

    public final b a(long j5) {
        if (j5 < 0) {
            j5 = 1000;
        }
        this.f8758b = j5;
        return this;
    }

    public final b a(a aVar) {
        this.f8757a = aVar;
        return this;
    }
}
