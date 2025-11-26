package com.google.firebase.sessions;

import S0.e;
import X2.C2250q;
import Z0.h;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import b1.C1028m;
import b1.C1034t;
import b1.C1035u;
import b3.C2312i;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.sessions.b;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import o0.f;
import p.j;
import q0.C1756a;
import q0.b;
import r0.C1786c;
import r0.C1788e;
import r0.F;
import r0.r;
import w3.I;

@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final a Companion = new a((C2633k) null);
    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";
    /* access modifiers changed from: private */
    public static final F appContext;
    /* access modifiers changed from: private */
    public static final F backgroundDispatcher;
    /* access modifiers changed from: private */
    public static final F blockingDispatcher;
    /* access modifiers changed from: private */
    public static final F firebaseApp;
    /* access modifiers changed from: private */
    public static final F firebaseInstallationsApi;
    /* access modifiers changed from: private */
    public static final F firebaseSessionsComponent;
    /* access modifiers changed from: private */
    public static final F transportFactory;

    private static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static {
        F b5 = F.b(Context.class);
        t.d(b5, "unqualified(...)");
        appContext = b5;
        F b6 = F.b(f.class);
        t.d(b6, "unqualified(...)");
        firebaseApp = b6;
        F b7 = F.b(e.class);
        t.d(b7, "unqualified(...)");
        firebaseInstallationsApi = b7;
        Class<I> cls = I.class;
        F a5 = F.a(C1756a.class, cls);
        t.d(a5, "qualified(...)");
        backgroundDispatcher = a5;
        F a6 = F.a(b.class, cls);
        t.d(a6, "qualified(...)");
        blockingDispatcher = a6;
        F b8 = F.b(j.class);
        t.d(b8, "unqualified(...)");
        transportFactory = b8;
        F b9 = F.b(b.class);
        t.d(b9, "unqualified(...)");
        firebaseSessionsComponent = b9;
        try {
            MultiProcessDataStoreFactory.INSTANCE.getClass();
        } catch (NoClassDefFoundError unused) {
            Log.w("FirebaseSessions", "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* access modifiers changed from: private */
    public static final C1028m getComponents$lambda$0(C1788e eVar) {
        return ((b) eVar.e(firebaseSessionsComponent)).a();
    }

    /* access modifiers changed from: private */
    public static final b getComponents$lambda$1(C1788e eVar) {
        b.a a5 = a.a();
        Object e5 = eVar.e(appContext);
        t.d(e5, "get(...)");
        b.a e6 = a5.e((Context) e5);
        Object e7 = eVar.e(backgroundDispatcher);
        t.d(e7, "get(...)");
        b.a c5 = e6.c((C2312i) e7);
        Object e8 = eVar.e(blockingDispatcher);
        t.d(e8, "get(...)");
        b.a a6 = c5.a((C2312i) e8);
        Object e9 = eVar.e(firebaseApp);
        t.d(e9, "get(...)");
        b.a d5 = a6.d((f) e9);
        Object e10 = eVar.e(firebaseInstallationsApi);
        t.d(e10, "get(...)");
        b.a b5 = d5.b((e) e10);
        R0.b b6 = eVar.b(transportFactory);
        t.d(b6, "getProvider(...)");
        return b5.f(b6).build();
    }

    public List<C1786c> getComponents() {
        return C2250q.j(C1786c.c(C1028m.class).h(LIBRARY_NAME).b(r.l(firebaseSessionsComponent)).f(new C1034t()).e().d(), C1786c.c(b.class).h("fire-sessions-component").b(r.l(appContext)).b(r.l(backgroundDispatcher)).b(r.l(blockingDispatcher)).b(r.l(firebaseApp)).b(r.l(firebaseInstallationsApi)).b(r.n(transportFactory)).f(new C1035u()).d(), h.b(LIBRARY_NAME, "3.0.3"));
    }
}
