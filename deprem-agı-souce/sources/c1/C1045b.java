package c1;

import F3.a;
import F3.g;
import android.util.Log;
import b3.C2308e;
import c1.C1046c;
import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: c1.b  reason: case insensitive filesystem */
public final class C1045b {

    /* renamed from: a  reason: collision with root package name */
    public static final C1045b f4747a = new C1045b();

    /* renamed from: b  reason: collision with root package name */
    private static final Map f4748b = DesugarCollections.synchronizedMap(new LinkedHashMap());

    /* renamed from: c1.b$a */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final F3.a f4749a;

        /* renamed from: b  reason: collision with root package name */
        private C1046c f4750b;

        public a(F3.a aVar, C1046c cVar) {
            t.e(aVar, "mutex");
            this.f4749a = aVar;
            this.f4750b = cVar;
        }

        public final F3.a a() {
            return this.f4749a;
        }

        public final C1046c b() {
            return this.f4750b;
        }

        public final void c(C1046c cVar) {
            this.f4750b = cVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (t.a(this.f4749a, aVar.f4749a) && t.a(this.f4750b, aVar.f4750b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i5;
            int hashCode = this.f4749a.hashCode() * 31;
            C1046c cVar = this.f4750b;
            if (cVar == null) {
                i5 = 0;
            } else {
                i5 = cVar.hashCode();
            }
            return hashCode + i5;
        }

        public String toString() {
            return "Dependency(mutex=" + this.f4749a + ", subscriber=" + this.f4750b + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(F3.a aVar, C1046c cVar, int i5, C2633k kVar) {
            this(aVar, (i5 & 2) != 0 ? null : cVar);
        }
    }

    /* renamed from: c1.b$b  reason: collision with other inner class name */
    static final class C0068b extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4751a;

        /* renamed from: b  reason: collision with root package name */
        Object f4752b;

        /* renamed from: c  reason: collision with root package name */
        Object f4753c;

        /* renamed from: d  reason: collision with root package name */
        Object f4754d;

        /* renamed from: e  reason: collision with root package name */
        Object f4755e;

        /* renamed from: f  reason: collision with root package name */
        Object f4756f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f4757g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C1045b f4758h;

        /* renamed from: i  reason: collision with root package name */
        int f4759i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0068b(C1045b bVar, C2308e eVar) {
            super(eVar);
            this.f4758h = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4757g = obj;
            this.f4759i |= Integer.MIN_VALUE;
            return this.f4758h.c(this);
        }
    }

    private C1045b() {
    }

    public static final void a(C1046c.a aVar) {
        t.e(aVar, "subscriberName");
        Map map = f4748b;
        if (map.containsKey(aVar)) {
            Log.d("FirebaseSessions", "Dependency " + aVar + " already added.");
            return;
        }
        t.d(map, "dependencies");
        map.put(aVar, new a(g.a(true), (C1046c) null, 2, (C2633k) null));
        Log.d("FirebaseSessions", "Dependency to " + aVar + " added.");
    }

    private final a b(C1046c.a aVar) {
        Map map = f4748b;
        t.d(map, "dependencies");
        Object obj = map.get(aVar);
        if (obj != null) {
            t.d(obj, "getOrElse(...)");
            return (a) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + aVar + ". Dependencies should be added at class load time.");
    }

    public static final void e(C1046c cVar) {
        t.e(cVar, "subscriber");
        C1046c.a b5 = cVar.b();
        a b6 = f4747a.b(b5);
        if (b6.b() != null) {
            Log.d("FirebaseSessions", "Subscriber " + b5 + " already registered.");
            return;
        }
        b6.c(cVar);
        Log.d("FirebaseSessions", "Subscriber " + b5 + " registered.");
        a.C0176a.b(b6.a(), (Object) null, 1, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: c1.c$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(b3.C2308e r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof c1.C1045b.C0068b
            if (r0 == 0) goto L_0x0013
            r0 = r11
            c1.b$b r0 = (c1.C1045b.C0068b) r0
            int r1 = r0.f4759i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4759i = r1
            goto L_0x0018
        L_0x0013:
            c1.b$b r0 = new c1.b$b
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f4757g
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f4759i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r2 = r0.f4756f
            java.lang.Object r5 = r0.f4755e
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.f4754d
            F3.a r6 = (F3.a) r6
            java.lang.Object r7 = r0.f4753c
            c1.c$a r7 = (c1.C1046c.a) r7
            java.lang.Object r8 = r0.f4752b
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f4751a
            java.util.Map r9 = (java.util.Map) r9
            W2.u.b(r11)
            goto L_0x00a0
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0048:
            W2.u.b(r11)
            java.util.Map r11 = f4748b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.t.d(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = X2.M.e(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L_0x0069:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x00b3
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            c1.c$a r7 = (c1.C1046c.a) r7
            java.lang.Object r11 = r11.getValue()
            c1.b$a r11 = (c1.C1045b.a) r11
            F3.a r6 = r11.a()
            r0.f4751a = r5
            r0.f4752b = r8
            r0.f4753c = r7
            r0.f4754d = r6
            r0.f4755e = r5
            r0.f4756f = r2
            r0.f4759i = r3
            java.lang.Object r11 = r6.lock(r4, r0)
            if (r11 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r9 = r5
        L_0x00a0:
            c1.b r11 = f4747a     // Catch:{ all -> 0x00ae }
            c1.c r11 = r11.d(r7)     // Catch:{ all -> 0x00ae }
            r6.unlock(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L_0x0069
        L_0x00ae:
            r11 = move-exception
            r6.unlock(r4)
            throw r11
        L_0x00b3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.C1045b.c(b3.e):java.lang.Object");
    }

    public final C1046c d(C1046c.a aVar) {
        t.e(aVar, "subscriberName");
        C1046c b5 = b(aVar).b();
        if (b5 != null) {
            return b5;
        }
        throw new IllegalStateException("Subscriber " + aVar + " has not been registered.");
    }
}
