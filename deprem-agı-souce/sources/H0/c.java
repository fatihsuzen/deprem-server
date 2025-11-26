package H0;

import W2.J;
import W2.u;
import X2.C2250q;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import n3.C2700a;
import r3.C2739i;
import z3.C2972e;
import z3.C2974g;

public final class c {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ C2739i[] f2508f = {M.g(new G(c.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final Context f2509a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2510b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ThreadLocal f2511c = new ThreadLocal();

    /* renamed from: d  reason: collision with root package name */
    private final C2700a f2512d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final DataStore f2513e;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f2514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f2515b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k3.l f2516c;

        /* renamed from: H0.c$a$a  reason: collision with other inner class name */
        static final class C0044a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f2517a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f2518b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ k3.l f2519c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0044a(k3.l lVar, C2308e eVar) {
                super(2, eVar);
                this.f2519c = lVar;
            }

            /* renamed from: b */
            public final Object invoke(MutablePreferences mutablePreferences, C2308e eVar) {
                return ((C0044a) create(mutablePreferences, eVar)).invokeSuspend(J.f19942a);
            }

            public final C2308e create(Object obj, C2308e eVar) {
                C0044a aVar = new C0044a(this.f2519c, eVar);
                aVar.f2518b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f2517a == 0) {
                    u.b(obj);
                    this.f2519c.invoke((MutablePreferences) this.f2518b);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, k3.l lVar, C2308e eVar) {
            super(2, eVar);
            this.f2515b = cVar;
            this.f2516c = lVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f2515b, this.f2516c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f2514a;
            if (i5 == 0) {
                u.b(obj);
                if (!t.a(this.f2515b.f2511c.get(), kotlin.coroutines.jvm.internal.b.a(true))) {
                    this.f2515b.f2511c.set(kotlin.coroutines.jvm.internal.b.a(true));
                    DataStore c5 = this.f2515b.f2513e;
                    C0044a aVar = new C0044a(this.f2516c, (C2308e) null);
                    this.f2514a = 1;
                    obj = PreferencesKt.edit(c5, aVar, this);
                    if (obj == f5) {
                        return f5;
                    }
                } else {
                    throw new IllegalStateException("Don't call JavaDataStorage.edit() from within an existing edit() callback.\nThis causes deadlocks, and is generally indicative of a code smell.\nInstead, either pass around the initial `MutablePreferences` instance, or don't do everything in a single callback. ");
                }
            } else if (i5 == 1) {
                try {
                    u.b(obj);
                } catch (Throwable th) {
                    this.f2515b.f2511c.set(kotlin.coroutines.jvm.internal.b.a(false));
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Preferences preferences = (Preferences) obj;
            this.f2515b.f2511c.set(kotlin.coroutines.jvm.internal.b.a(false));
            return preferences;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f2520a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f2521b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, C2308e eVar) {
            super(2, eVar);
            this.f2521b = cVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f2521b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Map<Preferences.Key<?>, Object> asMap;
            Object f5 = C2316b.f();
            int i5 = this.f2520a;
            if (i5 == 0) {
                u.b(obj);
                C2972e data = this.f2521b.f2513e.getData();
                this.f2520a = 1;
                obj = C2974g.p(data, this);
                if (obj == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Preferences preferences = (Preferences) obj;
            if (preferences == null || (asMap = preferences.asMap()) == null) {
                return X2.M.h();
            }
            return asMap;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: H0.c$c  reason: collision with other inner class name */
    static final class C0045c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f2522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f2523b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Preferences.Key f2524c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f2525d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0045c(c cVar, Preferences.Key key, Object obj, C2308e eVar) {
            super(2, eVar);
            this.f2523b = cVar;
            this.f2524c = key;
            this.f2525d = obj;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0045c(this.f2523b, this.f2524c, this.f2525d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object f5 = C2316b.f();
            int i5 = this.f2522a;
            if (i5 == 0) {
                u.b(obj);
                C2972e data = this.f2523b.f2513e.getData();
                this.f2522a = 1;
                obj = C2974g.p(data, this);
                if (obj == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Preferences preferences = (Preferences) obj;
            if (preferences == null || (obj2 = preferences.get(this.f2524c)) == null) {
                return this.f2525d;
            }
            return obj2;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C0045c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f2526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f2527b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Preferences.Key f2528c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f2529d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f2530a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f2531b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Preferences.Key f2532c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Object f2533d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Preferences.Key key, Object obj, C2308e eVar) {
                super(2, eVar);
                this.f2532c = key;
                this.f2533d = obj;
            }

            /* renamed from: b */
            public final Object invoke(MutablePreferences mutablePreferences, C2308e eVar) {
                return ((a) create(mutablePreferences, eVar)).invokeSuspend(J.f19942a);
            }

            public final C2308e create(Object obj, C2308e eVar) {
                a aVar = new a(this.f2532c, this.f2533d, eVar);
                aVar.f2531b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f2530a == 0) {
                    u.b(obj);
                    ((MutablePreferences) this.f2531b).set(this.f2532c, this.f2533d);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, Preferences.Key key, Object obj, C2308e eVar) {
            super(2, eVar);
            this.f2527b = cVar;
            this.f2528c = key;
            this.f2529d = obj;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f2527b, this.f2528c, this.f2529d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f2526a;
            if (i5 == 0) {
                u.b(obj);
                DataStore c5 = this.f2527b.f2513e;
                a aVar = new a(this.f2528c, this.f2529d, (C2308e) null);
                this.f2526a = 1;
                Object edit = PreferencesKt.edit(c5, aVar, this);
                if (edit == f5) {
                    return f5;
                }
                return edit;
            } else if (i5 == 1) {
                u.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public c(Context context, String str) {
        t.e(context, "context");
        t.e(str, RewardPlus.NAME);
        this.f2509a = context;
        this.f2510b = str;
        this.f2512d = PreferenceDataStoreDelegateKt.preferencesDataStore$default(str, new ReplaceFileCorruptionHandler(new a(this)), new b(this), (w3.M) null, 8, (Object) null);
        this.f2513e = i(context);
    }

    /* access modifiers changed from: private */
    public static final Preferences e(c cVar, CorruptionException corruptionException) {
        t.e(corruptionException, "ex");
        String c5 = M.b(c.class).c();
        Log.w(c5, "CorruptionException in " + cVar.f2510b + " DataStore running in process " + Process.myPid(), corruptionException);
        return PreferencesFactory.createEmpty();
    }

    /* access modifiers changed from: private */
    public static final List f(c cVar, Context context) {
        t.e(context, "it");
        return C2250q.d(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context, cVar.f2510b, (Set) null, 4, (Object) null));
    }

    private final DataStore i(Context context) {
        return (DataStore) this.f2512d.getValue(context, f2508f[0]);
    }

    public final Preferences g(k3.l lVar) {
        t.e(lVar, "transform");
        return (Preferences) C2874h.b((C2312i) null, new a(this, lVar, (C2308e) null), 1, (Object) null);
    }

    public final Map h() {
        return (Map) C2874h.b((C2312i) null, new b(this, (C2308e) null), 1, (Object) null);
    }

    public final Object j(Preferences.Key key, Object obj) {
        t.e(key, "key");
        return C2874h.b((C2312i) null, new C0045c(this, key, obj, (C2308e) null), 1, (Object) null);
    }

    public final Preferences k(Preferences.Key key, Object obj) {
        t.e(key, "key");
        return (Preferences) C2874h.b((C2312i) null, new d(this, key, obj, (C2308e) null), 1, (Object) null);
    }
}
