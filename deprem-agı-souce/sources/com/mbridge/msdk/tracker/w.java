package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final int f11758a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11759b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11760c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11761d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11762e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11763f;

    /* renamed from: g  reason: collision with root package name */
    public final o f11764g;

    /* renamed from: h  reason: collision with root package name */
    public final d f11765h;

    /* renamed from: i  reason: collision with root package name */
    public final v f11766i;

    /* renamed from: j  reason: collision with root package name */
    public final f f11767j;

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f11768a = 50;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f11769b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f11770c = 1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public o f11771d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f11772e = 2;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f11773f = 50;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f11774g = 604800000;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public d f11775h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public v f11776i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public f f11777j;

        public final a a(int i5) {
            if (i5 <= 0) {
                this.f11768a = 50;
                return this;
            }
            this.f11768a = i5;
            return this;
        }

        public final a b(int i5) {
            if (i5 < 0) {
                this.f11769b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
                return this;
            }
            this.f11769b = i5;
            return this;
        }

        public final a c(int i5) {
            if (i5 <= 0) {
                this.f11772e = 2;
                return this;
            }
            this.f11772e = i5;
            return this;
        }

        public final a d(int i5) {
            if (i5 < 0) {
                this.f11773f = 50;
                return this;
            }
            this.f11773f = i5;
            return this;
        }

        public final a e(int i5) {
            if (i5 < 0) {
                this.f11774g = 604800000;
                return this;
            }
            this.f11774g = i5;
            return this;
        }

        public final a a(int i5, o oVar) {
            this.f11770c = i5;
            this.f11771d = oVar;
            return this;
        }

        public final a a(d dVar) {
            this.f11775h = dVar;
            return this;
        }

        public final a a(v vVar) {
            this.f11776i = vVar;
            return this;
        }

        public final a a(f fVar) {
            this.f11777j = fVar;
            return this;
        }

        public final w a() {
            if (y.a((Object) this.f11775h) && a.f11490a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.a((Object) this.f11776i) && a.f11490a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.a((Object) this.f11771d) || y.a((Object) this.f11771d.c())) && a.f11490a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new w(this);
        }
    }

    private w(a aVar) {
        this.f11758a = aVar.f11768a;
        this.f11759b = aVar.f11769b;
        this.f11760c = aVar.f11770c;
        this.f11761d = aVar.f11772e;
        this.f11762e = aVar.f11773f;
        this.f11763f = aVar.f11774g;
        this.f11764g = aVar.f11771d;
        this.f11765h = aVar.f11775h;
        this.f11766i = aVar.f11776i;
        this.f11767j = aVar.f11777j;
    }
}
