package com.google.firebase.messaging;

import O.C0732a;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.C1556e;
import java.util.Map;

public final class S extends C0732a {
    public static final Parcelable.Creator<S> CREATOR = new T();

    /* renamed from: a  reason: collision with root package name */
    Bundle f7312a;

    /* renamed from: b  reason: collision with root package name */
    private Map f7313b;

    /* renamed from: c  reason: collision with root package name */
    private b f7314c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f7315a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7316b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f7317c;

        /* renamed from: d  reason: collision with root package name */
        private final String f7318d;

        /* renamed from: e  reason: collision with root package name */
        private final String f7319e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f7320f;

        /* renamed from: g  reason: collision with root package name */
        private final String f7321g;

        /* renamed from: h  reason: collision with root package name */
        private final String f7322h;

        /* renamed from: i  reason: collision with root package name */
        private final String f7323i;

        /* renamed from: j  reason: collision with root package name */
        private final String f7324j;

        /* renamed from: k  reason: collision with root package name */
        private final String f7325k;

        /* renamed from: l  reason: collision with root package name */
        private final String f7326l;

        /* renamed from: m  reason: collision with root package name */
        private final String f7327m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f7328n;

        /* renamed from: o  reason: collision with root package name */
        private final String f7329o;

        /* renamed from: p  reason: collision with root package name */
        private final Integer f7330p;

        /* renamed from: q  reason: collision with root package name */
        private final Integer f7331q;

        /* renamed from: r  reason: collision with root package name */
        private final Integer f7332r;

        /* renamed from: s  reason: collision with root package name */
        private final int[] f7333s;

        /* renamed from: t  reason: collision with root package name */
        private final Long f7334t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f7335u;

        /* renamed from: v  reason: collision with root package name */
        private final boolean f7336v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f7337w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f7338x;

        /* renamed from: y  reason: collision with root package name */
        private final boolean f7339y;

        /* renamed from: z  reason: collision with root package name */
        private final long[] f7340z;

        private static String[] b(J j5, String str) {
            Object[] g5 = j5.g(str);
            if (g5 == null) {
                return null;
            }
            String[] strArr = new String[g5.length];
            for (int i5 = 0; i5 < g5.length; i5++) {
                strArr[i5] = String.valueOf(g5[i5]);
            }
            return strArr;
        }

        public String a() {
            return this.f7318d;
        }

        public String c() {
            return this.f7315a;
        }

        private b(J j5) {
            this.f7315a = j5.p("gcm.n.title");
            this.f7316b = j5.h("gcm.n.title");
            this.f7317c = b(j5, "gcm.n.title");
            this.f7318d = j5.p("gcm.n.body");
            this.f7319e = j5.h("gcm.n.body");
            this.f7320f = b(j5, "gcm.n.body");
            this.f7321g = j5.p("gcm.n.icon");
            this.f7323i = j5.o();
            this.f7324j = j5.p("gcm.n.tag");
            this.f7325k = j5.p("gcm.n.color");
            this.f7326l = j5.p("gcm.n.click_action");
            this.f7327m = j5.p("gcm.n.android_channel_id");
            this.f7328n = j5.f();
            this.f7322h = j5.p("gcm.n.image");
            this.f7329o = j5.p("gcm.n.ticker");
            this.f7330p = j5.b("gcm.n.notification_priority");
            this.f7331q = j5.b("gcm.n.visibility");
            this.f7332r = j5.b("gcm.n.notification_count");
            this.f7335u = j5.a("gcm.n.sticky");
            this.f7336v = j5.a("gcm.n.local_only");
            this.f7337w = j5.a("gcm.n.default_sound");
            this.f7338x = j5.a("gcm.n.default_vibrate_timings");
            this.f7339y = j5.a("gcm.n.default_light_settings");
            this.f7334t = j5.j("gcm.n.event_time");
            this.f7333s = j5.e();
            this.f7340z = j5.q();
        }
    }

    public S(Bundle bundle) {
        this.f7312a = bundle;
    }

    public Map c() {
        if (this.f7313b == null) {
            this.f7313b = C1556e.a.a(this.f7312a);
        }
        return this.f7313b;
    }

    public b d() {
        if (this.f7314c == null && J.t(this.f7312a)) {
            this.f7314c = new b(new J(this.f7312a));
        }
        return this.f7314c;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        T.c(this, parcel, i5);
    }
}
