package W1;

import W2.J;
import W2.u;
import X1.C2232i;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.documentfile.provider.DocumentFile;
import b2.C2276H;
import b2.C2290j;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.io.File;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: W1.d  reason: case insensitive filesystem */
public final class C2211d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final DocumentFile f19909a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f19910b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f19911c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final C2232i f19912d;

    /* renamed from: W1.d$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19913a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2211d f19914b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2211d dVar, C2308e eVar) {
            super(2, eVar);
            this.f19914b = dVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f19914b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f19913a;
            if (i5 == 0) {
                u.b(obj);
                C2211d dVar = this.f19914b;
                this.f19913a = 1;
                if (dVar.f(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.d$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19915a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2211d f19916b;

        /* renamed from: W1.d$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19917a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2211d f19918b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f19919c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2211d dVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f19918b = dVar;
                this.f19919c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f19918b, this.f19919c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19917a == 0) {
                    u.b(obj);
                    this.f19918b.f19912d.a(this.f19919c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.d$b$b  reason: collision with other inner class name */
        static final class C0190b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19920a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2211d f19921b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f19922c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0190b(C2211d dVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f19921b = dVar;
                this.f19922c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0190b(this.f19921b, this.f19922c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19920a == 0) {
                    u.b(obj);
                    this.f19921b.f19912d.b(this.f19922c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0190b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2211d dVar, C2308e eVar) {
            super(2, eVar);
            this.f19916b = dVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f19916b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d2, code lost:
            if (w3.C2872g.g(r10, r4, r9) == r0) goto L_0x00d4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r9.f19915a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0021
                if (r1 == r3) goto L_0x000e
                if (r1 != r2) goto L_0x0019
            L_0x000e:
                W2.u.b(r10)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                goto L_0x00dc
            L_0x0013:
                r10 = move-exception
                goto L_0x00d5
            L_0x0016:
                r10 = move-exception
                goto L_0x00d9
            L_0x0019:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0021:
                W2.u.b(r10)
                W1.d r10 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                androidx.documentfile.provider.DocumentFile r10 = r10.f19909a     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r1 = 0
                if (r10 == 0) goto L_0x007d
                W1.d r10 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                androidx.documentfile.provider.DocumentFile r10 = r10.f19909a     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                androidx.documentfile.provider.DocumentFile[] r10 = r10.listFiles()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r2 = "listFiles(...)"
                kotlin.jvm.internal.t.d(r10, r2)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r2.<init>()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                int r4 = r10.length     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r5 = 0
            L_0x0043:
                if (r5 >= r4) goto L_0x0069
                r6 = r10[r5]     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r7 = r6.getName()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r7 == 0) goto L_0x0066
                r2.add(r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                android.net.Uri r7 = r6.getUri()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r7 = r7.getPath()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r7 == 0) goto L_0x0066
                W1.d r8 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                kotlin.jvm.internal.t.b(r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r8.g(r7, r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
            L_0x0066:
                int r5 = r5 + 1
                goto L_0x0043
            L_0x0069:
                w3.I0 r10 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                W1.d$b$a r4 = new W1.d$b$a     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                W1.d r5 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r4.<init>(r5, r2, r1)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r9.f19915a = r3     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.Object r10 = w3.C2872g.g(r10, r4, r9)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r10 != r0) goto L_0x00dc
                goto L_0x00d4
            L_0x007d:
                W1.d r10 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File r10 = r10.f19910b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r10 == 0) goto L_0x00dc
                W1.d r10 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File r10 = r10.f19910b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File[] r10 = r10.listFiles()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r3.<init>()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r10 == 0) goto L_0x00c1
                java.util.Iterator r10 = kotlin.jvm.internal.C2625c.a(r10)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
            L_0x009a:
                boolean r4 = r10.hasNext()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r4 == 0) goto L_0x00c1
                java.lang.Object r4 = r10.next()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File r4 = (java.io.File) r4     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r3.add(r4)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                W1.d r5 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r6 = r4.getPath()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r7 = "getPath(...)"
                kotlin.jvm.internal.t.d(r6, r7)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r7 = "getName(...)"
                kotlin.jvm.internal.t.d(r4, r7)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r5.g(r6, r4)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                goto L_0x009a
            L_0x00c1:
                w3.I0 r10 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                W1.d$b$b r4 = new W1.d$b$b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                W1.d r5 = r9.f19916b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r4.<init>(r5, r3, r1)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r9.f19915a = r2     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.Object r10 = w3.C2872g.g(r10, r4, r9)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r10 != r0) goto L_0x00dc
            L_0x00d4:
                return r0
            L_0x00d5:
                r10.printStackTrace()
                goto L_0x00dc
            L_0x00d9:
                r10.printStackTrace()
            L_0x00dc:
                W2.J r10 = W2.J.f19942a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2211d.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2211d(DocumentFile documentFile, File file, Context context, C2232i iVar) {
        t.e(context, "context");
        t.e(iVar, "listener");
        this.f19909a = documentFile;
        this.f19910b = file;
        this.f19911c = context;
        this.f19912d = iVar;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void g(String str, String str2) {
        Drawable h5;
        if (s.D(str2, ".apk", false, 2, (Object) null)) {
            C2276H h6 = C2276H.f20479a;
            if (!h6.a().containsKey(str2) && (h5 = new C2290j().h(this.f19911c, str)) != null) {
                h6.a().put(str2, h5);
            }
        }
    }
}
