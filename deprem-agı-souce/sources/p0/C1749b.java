package p0;

import N.C0722p;
import O0.d;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C1237v1;
import com.google.firebase.analytics.connector.internal.b;
import e0.C1626a;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import o0.C1729b;
import o0.f;
import p0.C1748a;

/* renamed from: p0.b  reason: case insensitive filesystem */
public class C1749b implements C1748a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile C1748a f15682c;

    /* renamed from: a  reason: collision with root package name */
    final C1626a f15683a;

    /* renamed from: b  reason: collision with root package name */
    final Map f15684b = new ConcurrentHashMap();

    /* renamed from: p0.b$a */
    class a implements C1748a.C0158a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15685a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1749b f15686b;

        a(C1749b bVar, String str) {
            this.f15685a = str;
            Objects.requireNonNull(bVar);
            this.f15686b = bVar;
        }
    }

    C1749b(C1626a aVar) {
        C0722p.k(aVar);
        this.f15683a = aVar;
    }

    public static C1748a d(f fVar, Context context, d dVar) {
        C0722p.k(fVar);
        C0722p.k(context);
        C0722p.k(dVar);
        C0722p.k(context.getApplicationContext());
        if (f15682c == null) {
            synchronized (C1749b.class) {
                try {
                    if (f15682c == null) {
                        Bundle bundle = new Bundle(1);
                        if (fVar.u()) {
                            dVar.a(C1729b.class, C1751d.f15688a, C1750c.f15687a);
                            bundle.putBoolean("dataCollectionDefaultEnabled", fVar.t());
                        }
                        f15682c = new C1749b(C1237v1.o(context, bundle).p());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15682c;
    }

    static /* synthetic */ void e(O0.a aVar) {
        throw null;
    }

    private final boolean f(String str) {
        if (str.isEmpty()) {
            return false;
        }
        Map map = this.f15684b;
        if (!map.containsKey(str) || map.get(str) == null) {
            return false;
        }
        return true;
    }

    public C1748a.C0158a a(String str, C1748a.b bVar) {
        Object obj;
        C0722p.k(bVar);
        if (b.a(str) && !f(str)) {
            C1626a aVar = this.f15683a;
            if ("fiam".equals(str)) {
                obj = new com.google.firebase.analytics.connector.internal.d(aVar, bVar);
            } else if ("clx".equals(str)) {
                obj = new com.google.firebase.analytics.connector.internal.f(aVar, bVar);
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f15684b.put(str, obj);
                return new a(this, str);
            }
        }
        return null;
    }

    public void b(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (b.a(str) && b.b(str2, bundle) && b.e(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1);
            }
            this.f15683a.a(str, str2, bundle);
        }
    }

    public void c(String str, String str2, Object obj) {
        if (b.a(str) && b.d(str, str2)) {
            this.f15683a.c(str, str2, obj);
        }
    }
}
