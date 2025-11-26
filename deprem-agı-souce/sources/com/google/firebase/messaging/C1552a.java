package com.google.firebase.messaging;

import K0.d;
import K0.e;
import L0.a;
import androidx.core.app.NotificationCompat;

/* renamed from: com.google.firebase.messaging.a  reason: case insensitive filesystem */
public final class C1552a implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7358a = new C1552a();

    /* renamed from: com.google.firebase.messaging.a$a  reason: collision with other inner class name */
    private static final class C0071a implements d {

        /* renamed from: a  reason: collision with root package name */
        static final C0071a f7359a = new C0071a();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f7360b = K0.c.a("projectNumber").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final K0.c f7361c = K0.c.a("messageId").b(N0.a.b().c(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final K0.c f7362d = K0.c.a("instanceId").b(N0.a.b().c(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final K0.c f7363e = K0.c.a("messageType").b(N0.a.b().c(4).a()).a();

        /* renamed from: f  reason: collision with root package name */
        private static final K0.c f7364f = K0.c.a("sdkPlatform").b(N0.a.b().c(5).a()).a();

        /* renamed from: g  reason: collision with root package name */
        private static final K0.c f7365g = K0.c.a("packageName").b(N0.a.b().c(6).a()).a();

        /* renamed from: h  reason: collision with root package name */
        private static final K0.c f7366h = K0.c.a("collapseKey").b(N0.a.b().c(7).a()).a();

        /* renamed from: i  reason: collision with root package name */
        private static final K0.c f7367i = K0.c.a("priority").b(N0.a.b().c(8).a()).a();

        /* renamed from: j  reason: collision with root package name */
        private static final K0.c f7368j = K0.c.a("ttl").b(N0.a.b().c(9).a()).a();

        /* renamed from: k  reason: collision with root package name */
        private static final K0.c f7369k = K0.c.a("topic").b(N0.a.b().c(10).a()).a();

        /* renamed from: l  reason: collision with root package name */
        private static final K0.c f7370l = K0.c.a("bulkId").b(N0.a.b().c(11).a()).a();

        /* renamed from: m  reason: collision with root package name */
        private static final K0.c f7371m = K0.c.a(NotificationCompat.CATEGORY_EVENT).b(N0.a.b().c(12).a()).a();

        /* renamed from: n  reason: collision with root package name */
        private static final K0.c f7372n = K0.c.a("analyticsLabel").b(N0.a.b().c(13).a()).a();

        /* renamed from: o  reason: collision with root package name */
        private static final K0.c f7373o = K0.c.a("campaignId").b(N0.a.b().c(14).a()).a();

        /* renamed from: p  reason: collision with root package name */
        private static final K0.c f7374p = K0.c.a("composerLabel").b(N0.a.b().c(15).a()).a();

        private C0071a() {
        }

        /* renamed from: b */
        public void a(X0.a aVar, e eVar) {
            eVar.c(f7360b, aVar.l());
            eVar.a(f7361c, aVar.h());
            eVar.a(f7362d, aVar.g());
            eVar.a(f7363e, aVar.i());
            eVar.a(f7364f, aVar.m());
            eVar.a(f7365g, aVar.j());
            eVar.a(f7366h, aVar.d());
            eVar.d(f7367i, aVar.k());
            eVar.d(f7368j, aVar.o());
            eVar.a(f7369k, aVar.n());
            eVar.c(f7370l, aVar.b());
            eVar.a(f7371m, aVar.f());
            eVar.a(f7372n, aVar.a());
            eVar.c(f7373o, aVar.c());
            eVar.a(f7374p, aVar.e());
        }
    }

    /* renamed from: com.google.firebase.messaging.a$b */
    private static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        static final b f7375a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f7376b = K0.c.a("messagingClientEvent").b(N0.a.b().c(1).a()).a();

        private b() {
        }

        /* renamed from: b */
        public void a(X0.b bVar, e eVar) {
            eVar.a(f7376b, bVar.a());
        }
    }

    /* renamed from: com.google.firebase.messaging.a$c */
    private static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        static final c f7377a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final K0.c f7378b = K0.c.d("messagingClientEventExtension");

        private c() {
        }

        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.a.a(obj);
            b((K) null, (e) obj2);
        }

        public void b(K k5, e eVar) {
            throw null;
        }
    }

    private C1552a() {
    }

    public void a(L0.b bVar) {
        bVar.a(K.class, c.f7377a);
        bVar.a(X0.b.class, b.f7375a);
        bVar.a(X0.a.class, C0071a.f7359a);
    }
}
