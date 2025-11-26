package W1;

import U1.C2201a;
import W2.J;
import W2.u;
import X1.C2225b;
import Y1.C2258b;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.documentfile.provider.DocumentFile;
import b2.C2289i;
import b2.C2290j;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: W1.a  reason: case insensitive filesystem */
public final class C2208a {

    /* renamed from: e  reason: collision with root package name */
    public static final C0183a f19719e = new C0183a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f19720a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2225b f19721b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f19722c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19723d;

    /* renamed from: W1.a$a  reason: collision with other inner class name */
    public static final class C0183a {
        public /* synthetic */ C0183a(C2633k kVar) {
            this();
        }

        private C0183a() {
        }
    }

    /* renamed from: W1.a$b */
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f19724a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19725b;

        /* renamed from: c  reason: collision with root package name */
        int f19726c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2208a aVar, C2308e eVar) {
            super(eVar);
            this.f19725b = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19724a = obj;
            this.f19726c |= Integer.MIN_VALUE;
            return this.f19725b.l((C2258b) null, this);
        }
    }

    /* renamed from: W1.a$c */
    static final class c extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19727a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19728b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2258b f19729c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2208a aVar, C2258b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19728b = aVar;
            this.f19729c = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f19728b, this.f19729c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19727a == 0) {
                u.b(obj);
                C2225b i5 = this.f19728b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.a(this.f19729c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$d */
    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19730a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19731b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2258b f19732c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2208a aVar, C2258b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19731b = aVar;
            this.f19732c = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f19731b, this.f19732c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19730a == 0) {
                u.b(obj);
                C2225b i5 = this.f19731b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.a(this.f19732c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$e */
    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19733a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19734b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2258b f19735c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2208a aVar, C2258b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19734b = aVar;
            this.f19735c = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f19734b, this.f19735c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19733a == 0) {
                u.b(obj);
                C2225b i5 = this.f19734b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.e(this.f19735c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$f */
    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19736a;

        /* renamed from: b  reason: collision with root package name */
        Object f19737b;

        /* renamed from: c  reason: collision with root package name */
        int f19738c;

        /* renamed from: d  reason: collision with root package name */
        int f19739d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f19740e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2208a f19741f;

        /* renamed from: W1.a$f$a  reason: collision with other inner class name */
        static final class C0184a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19742a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2208a f19743b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2258b f19744c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f19745d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0184a(C2208a aVar, C2258b bVar, int i5, C2308e eVar) {
                super(2, eVar);
                this.f19743b = aVar;
                this.f19744c = bVar;
                this.f19745d = i5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0184a(this.f19743b, this.f19744c, this.f19745d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19742a == 0) {
                    u.b(obj);
                    C2225b i5 = this.f19743b.f19721b;
                    if (i5 == null) {
                        return null;
                    }
                    i5.g(this.f19744c, this.f19745d);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0184a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.a$f$b */
        static final class b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19746a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2208a f19747b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f19748c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2208a aVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f19747b = aVar;
                this.f19748c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f19747b, this.f19748c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19746a == 0) {
                    u.b(obj);
                    C2225b i5 = this.f19747b.f19721b;
                    if (i5 == null) {
                        return null;
                    }
                    i5.c(this.f19748c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ArrayList arrayList, C2208a aVar, C2308e eVar) {
            super(2, eVar);
            this.f19740e = arrayList;
            this.f19741f = aVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f19740e, this.f19741f, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008c, code lost:
            if (W1.C2208a.d(r7, r6, r11) != r0) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a4, code lost:
            if (w3.C2872g.g(r12, r1, r11) == r0) goto L_0x00a6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r11.f19739d
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x0039
                if (r1 == r4) goto L_0x002a
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                W2.u.b(r12)
                goto L_0x00a7
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                int r1 = r11.f19738c
                java.lang.Object r6 = r11.f19736a
                java.util.Iterator r6 = (java.util.Iterator) r6
                W2.u.b(r12)
                r12 = r6
                goto L_0x004b
            L_0x002a:
                int r1 = r11.f19738c
                java.lang.Object r6 = r11.f19737b
                Y1.b r6 = (Y1.C2258b) r6
                java.lang.Object r7 = r11.f19736a
                java.util.Iterator r7 = (java.util.Iterator) r7
                W2.u.b(r12)
                r12 = r7
                goto L_0x0075
            L_0x0039:
                W2.u.b(r12)
                java.util.ArrayList r12 = r11.f19740e
                int r12 = r12.size()
                if (r12 <= 0) goto L_0x00a7
                java.util.ArrayList r12 = r11.f19740e
                java.util.Iterator r12 = r12.iterator()
                r1 = 0
            L_0x004b:
                boolean r6 = r12.hasNext()
                if (r6 == 0) goto L_0x008f
                int r6 = r1 + 1
                java.lang.Object r7 = r12.next()
                Y1.b r7 = (Y1.C2258b) r7
                w3.I0 r8 = w3.C2865c0.c()
                W1.a$f$a r9 = new W1.a$f$a
                W1.a r10 = r11.f19741f
                r9.<init>(r10, r7, r1, r5)
                r11.f19736a = r12
                r11.f19737b = r7
                r11.f19738c = r6
                r11.f19739d = r4
                java.lang.Object r1 = w3.C2872g.g(r8, r9, r11)
                if (r1 != r0) goto L_0x0073
                goto L_0x00a6
            L_0x0073:
                r1 = r6
                r6 = r7
            L_0x0075:
                W1.a r7 = r11.f19741f
                java.lang.String r7 = r7.p(r6)
                r6.d(r7)
                W1.a r7 = r11.f19741f
                r11.f19736a = r12
                r11.f19737b = r5
                r11.f19738c = r1
                r11.f19739d = r3
                java.lang.Object r6 = r7.o(r6, r11)
                if (r6 != r0) goto L_0x004b
                goto L_0x00a6
            L_0x008f:
                w3.I0 r12 = w3.C2865c0.c()
                W1.a$f$b r1 = new W1.a$f$b
                W1.a r3 = r11.f19741f
                java.util.ArrayList r4 = r11.f19740e
                r1.<init>(r3, r4, r5)
                r11.f19736a = r5
                r11.f19739d = r2
                java.lang.Object r12 = w3.C2872g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00a7
            L_0x00a6:
                return r0
            L_0x00a7:
                W2.J r12 = W2.J.f19942a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2208a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$g */
    static final class g extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19749a;

        /* renamed from: b  reason: collision with root package name */
        Object f19750b;

        /* renamed from: c  reason: collision with root package name */
        Object f19751c;

        /* renamed from: d  reason: collision with root package name */
        Object f19752d;

        /* renamed from: e  reason: collision with root package name */
        Object f19753e;

        /* renamed from: f  reason: collision with root package name */
        int f19754f;

        /* renamed from: g  reason: collision with root package name */
        int f19755g;

        /* renamed from: h  reason: collision with root package name */
        long f19756h;

        /* renamed from: i  reason: collision with root package name */
        long f19757i;

        /* renamed from: j  reason: collision with root package name */
        /* synthetic */ Object f19758j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ C2208a f19759k;

        /* renamed from: l  reason: collision with root package name */
        int f19760l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C2208a aVar, C2308e eVar) {
            super(eVar);
            this.f19759k = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19758j = obj;
            this.f19760l |= Integer.MIN_VALUE;
            return this.f19759k.n((Object) null, (Object) null, this);
        }
    }

    /* renamed from: W1.a$h */
    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19761a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19762b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19763c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C2208a aVar, int i5, C2308e eVar) {
            super(2, eVar);
            this.f19762b = aVar;
            this.f19763c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f19762b, this.f19763c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19761a == 0) {
                u.b(obj);
                C2225b i5 = this.f19762b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.f(this.f19763c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$i */
    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19764a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19765b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2258b f19766c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(C2208a aVar, C2258b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19765b = aVar;
            this.f19766c = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f19765b, this.f19766c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19764a == 0) {
                u.b(obj);
                C2225b i5 = this.f19765b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.a(this.f19766c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$j */
    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19767a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19768b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2258b f19769c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(C2208a aVar, C2258b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19768b = aVar;
            this.f19769c = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f19768b, this.f19769c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19767a == 0) {
                u.b(obj);
                C2225b i5 = this.f19768b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.b(this.f19769c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$k */
    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19770a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19771b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f19772c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(C2208a aVar, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f19771b = aVar;
            this.f19772c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f19771b, this.f19772c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
            if (r0.exists() != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
            r0.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
            if (r4.exists() != false) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
            r4.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cd, code lost:
            if (r0.exists() != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
            if (r4.exists() != false) goto L_0x0088;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r3.f19770a
                r2 = 1
                if (r1 == 0) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                W2.u.b(r4)     // Catch:{ CancellationException -> 0x0012 }
                goto L_0x002d
            L_0x000f:
                r4 = move-exception
                goto L_0x00ef
            L_0x0012:
                r4 = move-exception
                goto L_0x008c
            L_0x0015:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L_0x001d:
                W2.u.b(r4)
                W1.a r4 = r3.f19771b     // Catch:{ CancellationException -> 0x0012 }
                java.util.ArrayList r1 = r3.f19772c     // Catch:{ CancellationException -> 0x0012 }
                r3.f19770a = r2     // Catch:{ CancellationException -> 0x0012 }
                java.lang.Object r4 = r4.m(r1, r3)     // Catch:{ CancellationException -> 0x0012 }
                if (r4 != r0) goto L_0x002d
                return r0
            L_0x002d:
                W1.a r4 = r3.f19771b
                boolean r4 = r4.f19723d
                if (r4 == 0) goto L_0x00ec
                W1.a r4 = r3.f19771b
                java.lang.String r4 = r4.f19722c
                if (r4 == 0) goto L_0x00ec
                U1.a r4 = new U1.a
                W1.a r0 = r3.f19771b
                android.content.Context r0 = r0.f19720a
                r4.<init>(r0)
                java.lang.Object r4 = r4.c()
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4 instanceof java.io.File
                if (r0 == 0) goto L_0x006d
                java.io.File r0 = new java.io.File
                java.io.File r4 = (java.io.File) r4
                W1.a r1 = r3.f19771b
                java.lang.String r1 = r1.f19722c
                kotlin.jvm.internal.t.b(r1)
                r0.<init>(r4, r1)
                boolean r4 = r0.exists()
                if (r4 == 0) goto L_0x00ec
            L_0x0068:
                r0.delete()
                goto L_0x00ec
            L_0x006d:
                boolean r0 = r4 instanceof androidx.documentfile.provider.DocumentFile
                if (r0 == 0) goto L_0x00ec
                androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4
                W1.a r0 = r3.f19771b
                java.lang.String r0 = r0.f19722c
                kotlin.jvm.internal.t.b(r0)
                androidx.documentfile.provider.DocumentFile r4 = r4.findFile(r0)
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4.exists()
                if (r0 == 0) goto L_0x00ec
            L_0x0088:
                r4.delete()
                goto L_0x00ec
            L_0x008c:
                W1.a r0 = r3.f19771b     // Catch:{ all -> 0x000f }
                r0.f19723d = r2     // Catch:{ all -> 0x000f }
                r4.printStackTrace()     // Catch:{ all -> 0x000f }
                W1.a r4 = r3.f19771b
                boolean r4 = r4.f19723d
                if (r4 == 0) goto L_0x00ec
                W1.a r4 = r3.f19771b
                java.lang.String r4 = r4.f19722c
                if (r4 == 0) goto L_0x00ec
                U1.a r4 = new U1.a
                W1.a r0 = r3.f19771b
                android.content.Context r0 = r0.f19720a
                r4.<init>(r0)
                java.lang.Object r4 = r4.c()
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4 instanceof java.io.File
                if (r0 == 0) goto L_0x00d0
                java.io.File r0 = new java.io.File
                java.io.File r4 = (java.io.File) r4
                W1.a r1 = r3.f19771b
                java.lang.String r1 = r1.f19722c
                kotlin.jvm.internal.t.b(r1)
                r0.<init>(r4, r1)
                boolean r4 = r0.exists()
                if (r4 == 0) goto L_0x00ec
                goto L_0x0068
            L_0x00d0:
                boolean r0 = r4 instanceof androidx.documentfile.provider.DocumentFile
                if (r0 == 0) goto L_0x00ec
                androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4
                W1.a r0 = r3.f19771b
                java.lang.String r0 = r0.f19722c
                kotlin.jvm.internal.t.b(r0)
                androidx.documentfile.provider.DocumentFile r4 = r4.findFile(r0)
                if (r4 == 0) goto L_0x00ec
                boolean r0 = r4.exists()
                if (r0 == 0) goto L_0x00ec
                goto L_0x0088
            L_0x00ec:
                W2.J r4 = W2.J.f19942a
                return r4
            L_0x00ef:
                W1.a r0 = r3.f19771b
                boolean r0 = r0.f19723d
                if (r0 == 0) goto L_0x014c
                W1.a r0 = r3.f19771b
                java.lang.String r0 = r0.f19722c
                if (r0 == 0) goto L_0x014c
                U1.a r0 = new U1.a
                W1.a r1 = r3.f19771b
                android.content.Context r1 = r1.f19720a
                r0.<init>(r1)
                java.lang.Object r0 = r0.c()
                if (r0 == 0) goto L_0x014c
                boolean r1 = r0 instanceof java.io.File
                if (r1 == 0) goto L_0x012e
                java.io.File r1 = new java.io.File
                java.io.File r0 = (java.io.File) r0
                W1.a r2 = r3.f19771b
                java.lang.String r2 = r2.f19722c
                kotlin.jvm.internal.t.b(r2)
                r1.<init>(r0, r2)
                boolean r0 = r1.exists()
                if (r0 == 0) goto L_0x014c
                r1.delete()
                goto L_0x014c
            L_0x012e:
                boolean r1 = r0 instanceof androidx.documentfile.provider.DocumentFile
                if (r1 == 0) goto L_0x014c
                androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
                W1.a r1 = r3.f19771b
                java.lang.String r1 = r1.f19722c
                kotlin.jvm.internal.t.b(r1)
                androidx.documentfile.provider.DocumentFile r0 = r0.findFile(r1)
                if (r0 == 0) goto L_0x014c
                boolean r1 = r0.exists()
                if (r1 == 0) goto L_0x014c
                r0.delete()
            L_0x014c:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2208a.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$l */
    static final class l extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19773a;

        /* renamed from: b  reason: collision with root package name */
        Object f19774b;

        /* renamed from: c  reason: collision with root package name */
        Object f19775c;

        /* renamed from: d  reason: collision with root package name */
        Object f19776d;

        /* renamed from: e  reason: collision with root package name */
        Object f19777e;

        /* renamed from: f  reason: collision with root package name */
        Object f19778f;

        /* renamed from: g  reason: collision with root package name */
        long f19779g;

        /* renamed from: h  reason: collision with root package name */
        long f19780h;

        /* renamed from: i  reason: collision with root package name */
        int f19781i;

        /* renamed from: j  reason: collision with root package name */
        int f19782j;

        /* renamed from: k  reason: collision with root package name */
        int f19783k;

        /* renamed from: l  reason: collision with root package name */
        int f19784l;

        /* renamed from: m  reason: collision with root package name */
        int f19785m;

        /* renamed from: n  reason: collision with root package name */
        /* synthetic */ Object f19786n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ C2208a f19787o;

        /* renamed from: p  reason: collision with root package name */
        int f19788p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(C2208a aVar, C2308e eVar) {
            super(eVar);
            this.f19787o = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19786n = obj;
            this.f19788p |= Integer.MIN_VALUE;
            return this.f19787o.v((ArrayList) null, (ArrayList) null, (String) null, 0, this);
        }
    }

    /* renamed from: W1.a$m */
    static final class m extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19789a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19790b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19791c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(C2208a aVar, String str, C2308e eVar) {
            super(2, eVar);
            this.f19790b = aVar;
            this.f19791c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new m(this.f19790b, this.f19791c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19789a == 0) {
                u.b(obj);
                C2225b i5 = this.f19790b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.d(this.f19791c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((m) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.a$n */
    static final class n extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19792a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2208a f19793b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19794c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(C2208a aVar, int i5, C2308e eVar) {
            super(2, eVar);
            this.f19793b = aVar;
            this.f19794c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new n(this.f19793b, this.f19794c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19792a == 0) {
                u.b(obj);
                C2225b i5 = this.f19793b.f19721b;
                if (i5 == null) {
                    return null;
                }
                i5.f(this.f19794c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((n) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2208a(Context context, C2225b bVar) {
        t.e(context, "context");
        this.f19720a = context;
        this.f19721b = bVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0187, code lost:
        if (r2 == r4) goto L_0x0189;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(Y1.C2258b r19, b3.C2308e r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            boolean r3 = r2 instanceof W1.C2208a.b
            if (r3 == 0) goto L_0x0019
            r3 = r2
            W1.a$b r3 = (W1.C2208a.b) r3
            int r4 = r3.f19726c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f19726c = r4
            goto L_0x001e
        L_0x0019:
            W1.a$b r3 = new W1.a$b
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f19724a
            java.lang.Object r4 = c3.C2316b.f()
            int r5 = r3.f19726c
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            if (r5 == 0) goto L_0x005b
            if (r5 == r10) goto L_0x0056
            if (r5 == r9) goto L_0x0051
            if (r5 == r8) goto L_0x004c
            if (r5 == r7) goto L_0x0047
            if (r5 != r6) goto L_0x003f
            W2.u.b(r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x018a
        L_0x003c:
            r0 = move-exception
            goto L_0x018d
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0047:
            W2.u.b(r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x0175
        L_0x004c:
            W2.u.b(r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x0160
        L_0x0051:
            W2.u.b(r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x00fb
        L_0x0056:
            W2.u.b(r2)     // Catch:{ Exception -> 0x003c }
            goto L_0x0190
        L_0x005b:
            W2.u.b(r2)
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x003c }
            android.content.Context r5 = r1.f19720a     // Catch:{ Exception -> 0x003c }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ Exception -> 0x003c }
            java.lang.String r11 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r5, r11)     // Catch:{ Exception -> 0x003c }
            java.lang.String r11 = r0.c()     // Catch:{ Exception -> 0x003c }
            r12 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = b2.C2301u.a(r5, r11, r12)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r5.sourceDir     // Catch:{ Exception -> 0x003c }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003c }
            long r11 = r2.length()     // Catch:{ Exception -> 0x003c }
            double r11 = (double) r11     // Catch:{ Exception -> 0x003c }
            r13 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r11 = r11 * r13
            long r11 = (long) r11     // Catch:{ Exception -> 0x003c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c }
            r5.<init>()     // Catch:{ Exception -> 0x003c }
            java.lang.String r15 = r0.a()     // Catch:{ Exception -> 0x003c }
            r5.append(r15)     // Catch:{ Exception -> 0x003c }
            java.lang.String r15 = ".apk"
            r5.append(r15)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x003c }
            r0.d(r5)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r0.a()     // Catch:{ Exception -> 0x003c }
            r1.f19722c = r5     // Catch:{ Exception -> 0x003c }
            U1.a r5 = new U1.a     // Catch:{ Exception -> 0x003c }
            android.content.Context r15 = r1.f19720a     // Catch:{ Exception -> 0x003c }
            r5.<init>(r15)     // Catch:{ Exception -> 0x003c }
            java.lang.Object r5 = r5.c()     // Catch:{ Exception -> 0x003c }
            if (r5 == 0) goto L_0x0190
            boolean r15 = r5 instanceof java.io.File     // Catch:{ Exception -> 0x003c }
            r16 = r13
            r13 = 0
            if (r15 == 0) goto L_0x00ff
            r6 = r5
            java.io.File r6 = (java.io.File) r6     // Catch:{ Exception -> 0x003c }
            long r6 = r6.getUsableSpace()     // Catch:{ Exception -> 0x003c }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x003c }
            java.io.File r5 = (java.io.File) r5     // Catch:{ Exception -> 0x003c }
            java.lang.String r14 = r1.f19722c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.t.b(r14)     // Catch:{ Exception -> 0x003c }
            r8.<init>(r5, r14)     // Catch:{ Exception -> 0x003c }
            int r5 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x00e8
            boolean r0 = r8.exists()     // Catch:{ Exception -> 0x003c }
            if (r0 == 0) goto L_0x00d8
            r8.delete()     // Catch:{ Exception -> 0x003c }
        L_0x00d8:
            boolean r0 = r8.createNewFile()     // Catch:{ Exception -> 0x003c }
            if (r0 == 0) goto L_0x0190
            r3.f19726c = r10     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = r1.n(r2, r8, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0190
            goto L_0x0189
        L_0x00e8:
            w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x003c }
            W1.a$c r5 = new W1.a$c     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r0, r13)     // Catch:{ Exception -> 0x003c }
            r3.f19726c = r9     // Catch:{ Exception -> 0x003c }
            java.lang.Object r2 = w3.C2872g.g(r2, r5, r3)     // Catch:{ Exception -> 0x003c }
            if (r2 != r4) goto L_0x00fb
            goto L_0x0189
        L_0x00fb:
            W2.J r2 = (W2.J) r2     // Catch:{ Exception -> 0x003c }
            goto L_0x0190
        L_0x00ff:
            boolean r9 = r5 instanceof androidx.documentfile.provider.DocumentFile     // Catch:{ Exception -> 0x003c }
            if (r9 == 0) goto L_0x0190
            r9 = r5
            androidx.documentfile.provider.DocumentFile r9 = (androidx.documentfile.provider.DocumentFile) r9     // Catch:{ Exception -> 0x003c }
            java.lang.String r10 = r1.f19722c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.t.b(r10)     // Catch:{ Exception -> 0x003c }
            androidx.documentfile.provider.DocumentFile r9 = r9.findFile(r10)     // Catch:{ Exception -> 0x003c }
            java.lang.String r10 = ""
            if (r9 != 0) goto L_0x0122
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5     // Catch:{ Exception -> 0x003c }
            java.lang.String r9 = r1.f19722c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.t.b(r9)     // Catch:{ Exception -> 0x003c }
            androidx.documentfile.provider.DocumentFile r9 = r5.createFile(r10, r9)     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.t.b(r9)     // Catch:{ Exception -> 0x003c }
            goto L_0x0139
        L_0x0122:
            boolean r14 = r9.exists()     // Catch:{ Exception -> 0x003c }
            if (r14 == 0) goto L_0x0139
            boolean r14 = r9.delete()     // Catch:{ Exception -> 0x003c }
            if (r14 == 0) goto L_0x0139
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5     // Catch:{ Exception -> 0x003c }
            java.lang.String r9 = r1.f19722c     // Catch:{ Exception -> 0x003c }
            kotlin.jvm.internal.t.b(r9)     // Catch:{ Exception -> 0x003c }
            androidx.documentfile.provider.DocumentFile r9 = r5.createFile(r10, r9)     // Catch:{ Exception -> 0x003c }
        L_0x0139:
            if (r9 == 0) goto L_0x0178
            b2.j r5 = new b2.j     // Catch:{ Exception -> 0x003c }
            r5.<init>()     // Catch:{ Exception -> 0x003c }
            android.content.Context r6 = r1.f19720a     // Catch:{ Exception -> 0x003c }
            long r5 = r5.l(r6, r9)     // Catch:{ Exception -> 0x003c }
            r14 = 0
            int r10 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r10 != 0) goto L_0x0153
            r5 = 1
            long r5 = r5 + r11
            double r5 = (double) r5     // Catch:{ Exception -> 0x003c }
            double r5 = r5 * r16
            long r5 = (long) r5     // Catch:{ Exception -> 0x003c }
        L_0x0153:
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x0163
            r3.f19726c = r8     // Catch:{ Exception -> 0x003c }
            java.lang.Object r0 = r1.n(r2, r9, r3)     // Catch:{ Exception -> 0x003c }
            if (r0 != r4) goto L_0x0160
            goto L_0x0189
        L_0x0160:
            W2.J r0 = W2.J.f19942a     // Catch:{ Exception -> 0x003c }
            goto L_0x0190
        L_0x0163:
            w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x003c }
            W1.a$d r5 = new W1.a$d     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r0, r13)     // Catch:{ Exception -> 0x003c }
            r3.f19726c = r7     // Catch:{ Exception -> 0x003c }
            java.lang.Object r2 = w3.C2872g.g(r2, r5, r3)     // Catch:{ Exception -> 0x003c }
            if (r2 != r4) goto L_0x0175
            goto L_0x0189
        L_0x0175:
            W2.J r2 = (W2.J) r2     // Catch:{ Exception -> 0x003c }
            goto L_0x0190
        L_0x0178:
            w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x003c }
            W1.a$e r5 = new W1.a$e     // Catch:{ Exception -> 0x003c }
            r5.<init>(r1, r0, r13)     // Catch:{ Exception -> 0x003c }
            r3.f19726c = r6     // Catch:{ Exception -> 0x003c }
            java.lang.Object r2 = w3.C2872g.g(r2, r5, r3)     // Catch:{ Exception -> 0x003c }
            if (r2 != r4) goto L_0x018a
        L_0x0189:
            return r4
        L_0x018a:
            W2.J r2 = (W2.J) r2     // Catch:{ Exception -> 0x003c }
            goto L_0x0190
        L_0x018d:
            r0.printStackTrace()
        L_0x0190:
            W2.J r0 = W2.J.f19942a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2208a.l(Y1.b, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object m(ArrayList arrayList, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new f(arrayList, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.Object r20, java.lang.Object r21, b3.C2308e r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = r2 instanceof W1.C2208a.g
            if (r3 == 0) goto L_0x0019
            r3 = r2
            W1.a$g r3 = (W1.C2208a.g) r3
            int r4 = r3.f19760l
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f19760l = r4
            goto L_0x001e
        L_0x0019:
            W1.a$g r3 = new W1.a$g
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f19758j
            java.lang.Object r4 = c3.C2316b.f()
            int r5 = r3.f19760l
            r6 = 1
            if (r5 == 0) goto L_0x0055
            if (r5 != r6) goto L_0x004d
            long r8 = r3.f19757i
            long r10 = r3.f19756h
            int r1 = r3.f19755g
            int r5 = r3.f19754f
            java.lang.Object r12 = r3.f19753e
            kotlin.jvm.internal.J r12 = (kotlin.jvm.internal.J) r12
            java.lang.Object r13 = r3.f19752d
            byte[] r13 = (byte[]) r13
            java.lang.Object r14 = r3.f19751c
            java.io.OutputStream r14 = (java.io.OutputStream) r14
            java.lang.Object r15 = r3.f19750b
            java.io.InputStream r15 = (java.io.InputStream) r15
            java.lang.Object r7 = r3.f19749a
            W1.a r7 = (W1.C2208a) r7
            W2.u.b(r2)
            r0 = r6
            goto L_0x00f1
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0055:
            W2.u.b(r2)
            java.io.InputStream r2 = r19.q(r20)
            r5 = r21
            java.io.OutputStream r5 = r0.r(r5)
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]
            kotlin.jvm.internal.J r8 = new kotlin.jvm.internal.J
            r8.<init>()
            boolean r9 = r1 instanceof java.io.File
            r10 = 0
            if (r9 == 0) goto L_0x0081
            java.io.File r1 = (java.io.File) r1
            long r12 = r1.length()
        L_0x0077:
            r14 = r12
            r12 = r8
            r8 = r14
            r15 = r2
            r14 = r5
            r13 = r7
        L_0x007d:
            r1 = 0
            r5 = 0
            r7 = r0
            goto L_0x0092
        L_0x0081:
            boolean r9 = r1 instanceof androidx.documentfile.provider.DocumentFile
            if (r9 == 0) goto L_0x008c
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            long r12 = r1.length()
            goto L_0x0077
        L_0x008c:
            r15 = r2
            r14 = r5
            r13 = r7
            r12 = r8
            r8 = r10
            goto L_0x007d
        L_0x0092:
            int r2 = r15.read(r13)
            r12.f24688a = r2
            if (r2 <= 0) goto L_0x00fe
            r20 = r7
            double r6 = (double) r5
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r6 = r6 * r16
            r16 = r3
            double r2 = (double) r8
            double r6 = r6 / r2
            int r2 = (int) r6
            int r3 = r1 + 10
            if (r2 > r3) goto L_0x00c1
            long r6 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, float:1.401E-42)
            r17 = r6
            long r6 = (long) r3
            long r6 = r6 + r10
            int r3 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00bb
            if (r2 <= r1) goto L_0x00bb
            goto L_0x00c1
        L_0x00bb:
            r7 = r20
            r3 = r16
            r0 = 1
            goto L_0x00f1
        L_0x00c1:
            long r10 = java.lang.System.currentTimeMillis()
            w3.I0 r1 = w3.C2865c0.c()
            W1.a$h r3 = new W1.a$h
            r6 = 0
            r7 = r20
            r3.<init>(r7, r2, r6)
            r6 = r16
            r6.f19749a = r7
            r6.f19750b = r15
            r6.f19751c = r14
            r6.f19752d = r13
            r6.f19753e = r12
            r6.f19754f = r5
            r6.f19755g = r2
            r6.f19756h = r10
            r6.f19757i = r8
            r0 = 1
            r6.f19760l = r0
            java.lang.Object r1 = w3.C2872g.g(r1, r3, r6)
            if (r1 != r4) goto L_0x00ef
            return r4
        L_0x00ef:
            r1 = r2
            r3 = r6
        L_0x00f1:
            int r2 = r12.f24688a
            r6 = 0
            r14.write(r13, r6, r2)
            int r2 = r12.f24688a
            int r5 = r5 + r2
            r6 = r0
            r0 = r19
            goto L_0x0092
        L_0x00fe:
            r15.close()
            r14.close()
            W2.J r0 = W2.J.f19942a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2208a.n(java.lang.Object, java.lang.Object, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(Y1.C2258b r21, b3.C2308e r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            android.content.Context r0 = r1.f19720a
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 == 0) goto L_0x01fb
            r3 = 0
            java.lang.String r4 = r2.c()     // Catch:{ NameNotFoundException -> 0x001e }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = b2.C2301u.a(r0, r4, r5)     // Catch:{ NameNotFoundException -> 0x001e }
            java.lang.String r4 = r0.sourceDir     // Catch:{ NameNotFoundException -> 0x001e }
            java.lang.String[] r0 = r0.splitSourceDirs     // Catch:{ NameNotFoundException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r0 = move-exception
            goto L_0x0020
        L_0x001e:
            r0 = move-exception
            r4 = r3
        L_0x0020:
            r0.printStackTrace()
            r0 = r3
        L_0x0024:
            if (r4 == 0) goto L_0x01fb
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            long r10 = r5.length()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r13 = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r12.add(r4)
            r8 = 6
            r9 = 0
            java.lang.String r5 = "/"
            r6 = 0
            r7 = 0
            int r5 = t3.s.l0(r4, r5, r6, r7, r8, r9)
            r6 = 1
            int r5 = r5 + r6
            java.lang.String r4 = r4.substring(r5)
            java.lang.String r5 = "substring(...)"
            kotlin.jvm.internal.t.d(r4, r5)
            r3.add(r4)
            if (r0 == 0) goto L_0x008f
            java.util.Iterator r0 = kotlin.jvm.internal.C2625c.a(r0)
        L_0x005b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x008f
            java.lang.Object r4 = r0.next()
            r14 = r4
            java.lang.String r14 = (java.lang.String) r14
            java.io.File r4 = new java.io.File
            r4.<init>(r14)
            long r7 = r4.length()
            long r10 = r10 + r7
            r12.add(r14)
            r18 = 6
            r19 = 0
            java.lang.String r15 = "/"
            r16 = 0
            r17 = 0
            int r4 = t3.s.l0(r14, r15, r16, r17, r18, r19)
            int r4 = r4 + r6
            java.lang.String r4 = r14.substring(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            r3.add(r4)
            goto L_0x005b
        L_0x008f:
            b2.I r0 = new b2.I
            r0.<init>()
            java.lang.String r4 = r2.c()
            java.util.ArrayList r0 = r0.a(r4)
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r4 = "iterator(...)"
            kotlin.jvm.internal.t.d(r0, r4)
        L_0x00a5:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0109
            java.lang.Object r4 = r0.next()
            java.lang.String r7 = "next(...)"
            kotlin.jvm.internal.t.d(r4, r7)
            java.io.File r4 = (java.io.File) r4
            long r7 = r4.length()
            long r10 = r10 + r7
            java.lang.String r7 = r4.getAbsolutePath()
            r12.add(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Android/Obb/"
            r7.append(r8)
            java.lang.String r8 = r2.c()
            r7.append(r8)
            r8 = 47
            r7.append(r8)
            java.lang.String r8 = r4.getAbsolutePath()
            java.lang.String r9 = "getAbsolutePath(...)"
            kotlin.jvm.internal.t.d(r8, r9)
            java.lang.String r14 = r4.getAbsolutePath()
            kotlin.jvm.internal.t.d(r14, r9)
            r18 = 6
            r19 = 0
            java.lang.String r15 = "/"
            r16 = 0
            r17 = 0
            int r4 = t3.s.l0(r14, r15, r16, r17, r18, r19)
            int r4 = r4 + r6
            java.lang.String r4 = r8.substring(r4)
            kotlin.jvm.internal.t.d(r4, r5)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r3.add(r4)
            goto L_0x00a5
        L_0x0109:
            U1.a r0 = new U1.a
            android.content.Context r4 = r1.f19720a
            r0.<init>(r4)
            java.lang.Object r0 = r0.c()
            r4 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            r7 = 0
            r9 = 0
            if (r0 == 0) goto L_0x012f
            boolean r14 = r0 instanceof java.io.File
            if (r14 == 0) goto L_0x0131
            r14 = r0
            java.io.File r14 = (java.io.File) r14
            boolean r15 = r14.exists()
            if (r15 == 0) goto L_0x0131
            long r7 = r14.getUsableSpace()
        L_0x012f:
            r0 = r6
            goto L_0x0157
        L_0x0131:
            boolean r14 = r0 instanceof androidx.documentfile.provider.DocumentFile
            if (r14 == 0) goto L_0x0156
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
            boolean r14 = r0.exists()
            if (r14 == 0) goto L_0x0156
            b2.j r14 = new b2.j
            r14.<init>()
            android.content.Context r15 = r1.f19720a
            long r14 = r14.l(r15, r0)
            int r0 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0153
            r7 = 1
            long r7 = r7 + r10
            double r7 = (double) r7
            double r7 = r7 * r4
            long r7 = (long) r7
            goto L_0x012f
        L_0x0153:
            r0 = r6
            r7 = r14
            goto L_0x0157
        L_0x0156:
            r0 = r9
        L_0x0157:
            double r10 = (double) r10
            double r10 = r10 * r4
            long r4 = (long) r10
            if (r0 == 0) goto L_0x01eb
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01db
            java.lang.String r0 = r20.p(r21)
            int r7 = r12.size()
            if (r7 <= r6) goto L_0x01b0
            U1.a r6 = new U1.a
            android.content.Context r7 = r1.f19720a
            r6.<init>(r7)
            java.lang.String r6 = r6.b()
            if (r6 == 0) goto L_0x0187
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = r7.toString()
            goto L_0x0198
        L_0x0187:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = ".xapk"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L_0x0198:
            r2.d(r0)
            r1.f19722c = r0
            r7 = r22
            r5 = r4
            r2 = r12
            r4 = r0
            java.lang.Object r0 = r1.v(r2, r3, r4, r5, r7)
            java.lang.Object r2 = c3.C2316b.f()
            if (r0 != r2) goto L_0x01ad
            return r0
        L_0x01ad:
            W2.J r0 = W2.J.f19942a
            return r0
        L_0x01b0:
            r7 = r22
            r0 = r12
            int r3 = r0.size()
            if (r3 != r6) goto L_0x01fb
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r3 = "get(...)"
            kotlin.jvm.internal.t.d(r0, r3)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = ".apk"
            r4 = 2
            boolean r0 = t3.s.D(r0, r3, r9, r4, r13)
            if (r0 == 0) goto L_0x01fb
            java.lang.Object r0 = r20.l(r21, r22)
            java.lang.Object r2 = c3.C2316b.f()
            if (r0 != r2) goto L_0x01d8
            return r0
        L_0x01d8:
            W2.J r0 = W2.J.f19942a
            return r0
        L_0x01db:
            r7 = r22
            w3.I0 r0 = w3.C2865c0.c()
            W1.a$i r3 = new W1.a$i
            r3.<init>(r1, r2, r13)
            java.lang.Object r0 = w3.C2872g.g(r0, r3, r7)
            return r0
        L_0x01eb:
            r7 = r22
            w3.I0 r0 = w3.C2865c0.c()
            W1.a$j r3 = new W1.a$j
            r3.<init>(r1, r2, r13)
            java.lang.Object r0 = w3.C2872g.g(r0, r3, r7)
            return r0
        L_0x01fb:
            W2.J r0 = W2.J.f19942a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2208a.o(Y1.b, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String p(C2258b bVar) {
        String str;
        C2201a aVar = new C2201a(this.f19720a);
        if (aVar.i()) {
            str = new C2289i().q(bVar.b());
        } else {
            str = new C2289i().q(bVar.c());
        }
        if (aVar.k()) {
            str = str + '_' + s(bVar);
        }
        if (!aVar.l()) {
            return str;
        }
        return str + '_' + t(bVar);
    }

    private final InputStream q(Object obj) {
        InputStream inputStream;
        if (obj instanceof File) {
            return new FileInputStream((File) obj);
        }
        if (obj instanceof DocumentFile) {
            ContentResolver contentResolver = this.f19720a.getContentResolver();
            if (contentResolver != null) {
                inputStream = contentResolver.openInputStream(((DocumentFile) obj).getUri());
            } else {
                inputStream = null;
            }
            t.b(inputStream);
            return inputStream;
        }
        throw new Exception("getInputStream: Illegal parameter type");
    }

    private final OutputStream r(Object obj) {
        OutputStream outputStream;
        if (obj instanceof File) {
            return new FileOutputStream((File) obj);
        }
        if (obj instanceof DocumentFile) {
            DocumentFile documentFile = (DocumentFile) obj;
            if (documentFile.getName() != null) {
                ContentResolver contentResolver = this.f19720a.getContentResolver();
                if (contentResolver != null) {
                    outputStream = contentResolver.openOutputStream(documentFile.getUri());
                } else {
                    outputStream = null;
                }
                t.b(outputStream);
                return outputStream;
            }
            throw new Exception("getOutputStream: DocumentFile name is null");
        }
        throw new Exception("getOutputStream: Illegal parameter type");
    }

    private final long s(C2258b bVar) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = this.f19720a.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            packageInfo = C2301u.d(packageManager, bVar.c(), 0);
        } catch (Exception e5) {
            e5.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return new C2290j().m(packageInfo);
        }
        return 0;
    }

    private final String t(C2258b bVar) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = this.f19720a.getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            packageInfo = C2301u.d(packageManager, bVar.c(), 0);
        } catch (Exception e5) {
            e5.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0156 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01a6 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0205 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0223 A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(java.util.ArrayList r23, java.util.ArrayList r24, java.lang.String r25, long r26, b3.C2308e r28) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r2 = r24
            r3 = r25
            r4 = r28
            boolean r5 = r4 instanceof W1.C2208a.l
            if (r5 == 0) goto L_0x001d
            r5 = r4
            W1.a$l r5 = (W1.C2208a.l) r5
            int r6 = r5.f19788p
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L_0x001d
            int r6 = r6 - r7
            r5.f19788p = r6
            goto L_0x0022
        L_0x001d:
            W1.a$l r5 = new W1.a$l
            r5.<init>(r1, r4)
        L_0x0022:
            java.lang.Object r4 = r5.f19786n
            java.lang.Object r6 = c3.C2316b.f()
            int r7 = r5.f19788p
            r8 = 2
            r10 = 1
            if (r7 == 0) goto L_0x009d
            if (r7 == r10) goto L_0x007a
            if (r7 != r8) goto L_0x0072
            int r0 = r5.f19785m
            int r2 = r5.f19784l
            long r12 = r5.f19780h
            int r3 = r5.f19783k
            int r7 = r5.f19782j
            int r10 = r5.f19781i
            long r14 = r5.f19779g
            java.lang.Object r8 = r5.f19778f
            java.io.BufferedInputStream r8 = (java.io.BufferedInputStream) r8
            java.lang.Object r11 = r5.f19777e
            byte[] r11 = (byte[]) r11
            java.lang.Object r9 = r5.f19776d
            java.util.zip.ZipOutputStream r9 = (java.util.zip.ZipOutputStream) r9
            r23 = r0
            java.lang.Object r0 = r5.f19775c
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r24 = r0
            java.lang.Object r0 = r5.f19774b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r25 = r0
            java.lang.Object r0 = r5.f19773a
            W1.a r0 = (W1.C2208a) r0
            W2.u.b(r4)     // Catch:{ Exception -> 0x006f }
            r17 = r24
            r18 = r25
            r19 = r14
            r15 = r9
            r14 = r11
            r11 = r6
            r9 = r7
            r7 = r23
            goto L_0x020c
        L_0x006f:
            r0 = move-exception
            goto L_0x0250
        L_0x0072:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x007a:
            long r2 = r5.f19780h
            int r0 = r5.f19783k
            int r7 = r5.f19782j
            int r8 = r5.f19781i
            long r9 = r5.f19779g
            java.lang.Object r11 = r5.f19777e
            byte[] r11 = (byte[]) r11
            java.lang.Object r12 = r5.f19776d
            java.util.zip.ZipOutputStream r12 = (java.util.zip.ZipOutputStream) r12
            java.lang.Object r13 = r5.f19775c
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r5.f19774b
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r5.f19773a
            W1.a r15 = (W1.C2208a) r15
            W2.u.b(r4)     // Catch:{ Exception -> 0x006f }
            goto L_0x014d
        L_0x009d:
            W2.u.b(r4)
            if (r0 == 0) goto L_0x0253
            if (r2 == 0) goto L_0x0253
            int r4 = r0.size()     // Catch:{ Exception -> 0x006f }
            int r7 = r2.size()     // Catch:{ Exception -> 0x006f }
            if (r4 != r7) goto L_0x0253
            U1.a r4 = new U1.a     // Catch:{ Exception -> 0x006f }
            android.content.Context r7 = r1.f19720a     // Catch:{ Exception -> 0x006f }
            r4.<init>(r7)     // Catch:{ Exception -> 0x006f }
            java.lang.Object r4 = r4.c()     // Catch:{ Exception -> 0x006f }
            boolean r7 = r4 instanceof java.io.File     // Catch:{ Exception -> 0x006f }
            if (r7 == 0) goto L_0x00e8
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x006f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            r8.<init>()     // Catch:{ Exception -> 0x006f }
            java.io.File r4 = (java.io.File) r4     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x006f }
            r8.append(r4)     // Catch:{ Exception -> 0x006f }
            r4 = 47
            r8.append(r4)     // Catch:{ Exception -> 0x006f }
            r8.append(r3)     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x006f }
            r7.<init>(r4)     // Catch:{ Exception -> 0x006f }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x006f }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x006f }
            r8.<init>(r7)     // Catch:{ Exception -> 0x006f }
            r4.<init>(r8)     // Catch:{ Exception -> 0x006f }
            r12 = r4
            goto L_0x010f
        L_0x00e8:
            boolean r7 = r4 instanceof androidx.documentfile.provider.DocumentFile     // Catch:{ Exception -> 0x006f }
            if (r7 == 0) goto L_0x010e
            androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4     // Catch:{ Exception -> 0x006f }
            java.lang.String r7 = ""
            androidx.documentfile.provider.DocumentFile r4 = r4.createFile(r7, r3)     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x0106
            java.io.OutputStream r4 = r1.r(r4)     // Catch:{ Exception -> 0x006f }
            java.util.zip.ZipOutputStream r7 = new java.util.zip.ZipOutputStream     // Catch:{ Exception -> 0x006f }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x006f }
            r8.<init>(r4)     // Catch:{ Exception -> 0x006f }
            r7.<init>(r8)     // Catch:{ Exception -> 0x006f }
            r12 = r7
            goto L_0x010f
        L_0x0106:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x006f }
            java.lang.String r2 = "zipSuspend createFile return null"
            r0.<init>(r2)     // Catch:{ Exception -> 0x006f }
            throw r0     // Catch:{ Exception -> 0x006f }
        L_0x010e:
            r12 = 0
        L_0x010f:
            if (r12 == 0) goto L_0x0248
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r11 = new byte[r7]     // Catch:{ Exception -> 0x006f }
            w3.I0 r4 = w3.C2865c0.c()     // Catch:{ Exception -> 0x006f }
            W1.a$m r8 = new W1.a$m     // Catch:{ Exception -> 0x006f }
            r9 = 0
            r8.<init>(r1, r3, r9)     // Catch:{ Exception -> 0x006f }
            r5.f19773a = r1     // Catch:{ Exception -> 0x006f }
            r5.f19774b = r0     // Catch:{ Exception -> 0x006f }
            r5.f19775c = r2     // Catch:{ Exception -> 0x006f }
            r5.f19776d = r12     // Catch:{ Exception -> 0x006f }
            r5.f19777e = r11     // Catch:{ Exception -> 0x006f }
            r13 = r26
            r5.f19779g = r13     // Catch:{ Exception -> 0x006f }
            r3 = 0
            r5.f19781i = r3     // Catch:{ Exception -> 0x006f }
            r5.f19782j = r7     // Catch:{ Exception -> 0x006f }
            r5.f19783k = r3     // Catch:{ Exception -> 0x006f }
            r9 = r8
            r7 = 0
            r5.f19780h = r7     // Catch:{ Exception -> 0x006f }
            r5.f19788p = r10     // Catch:{ Exception -> 0x006f }
            java.lang.Object r4 = w3.C2872g.g(r4, r9, r5)     // Catch:{ Exception -> 0x006f }
            if (r4 != r6) goto L_0x0144
            r11 = r6
            goto L_0x0204
        L_0x0144:
            r15 = r1
            r9 = r13
            r14 = r0
            r13 = r2
            r2 = r7
            r0 = 0
            r7 = 8192(0x2000, float:1.14794E-41)
            r8 = 0
        L_0x014d:
            int r4 = r14.size()     // Catch:{ Exception -> 0x006f }
            r23 = r0
            r0 = 0
        L_0x0154:
            if (r0 >= r4) goto L_0x0244
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006f }
            java.lang.Object r16 = r14.get(r0)     // Catch:{ Exception -> 0x006f }
            r24 = r2
            r2 = r16
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x006f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x006f }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x006f }
            r2.<init>(r1, r7)     // Catch:{ Exception -> 0x006f }
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x006f }
            java.lang.Object r3 = r13.get(r0)     // Catch:{ Exception -> 0x006f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x006f }
            r1.<init>(r3)     // Catch:{ Exception -> 0x006f }
            r12.putNextEntry(r1)     // Catch:{ Exception -> 0x006f }
            r3 = 0
            int r1 = r2.read(r11, r3, r7)     // Catch:{ Exception -> 0x006f }
            r17 = r13
            r18 = r14
            r19 = r15
            r14 = r11
            r15 = r12
            r11 = r8
            r12 = r9
            r10 = r2
            r8 = r5
            r9 = r7
            r2 = r0
            r7 = r4
            r0 = r23
            r23 = r24
        L_0x0190:
            r4 = -1
            if (r1 == r4) goto L_0x0223
            r15.write(r14, r3, r1)     // Catch:{ Exception -> 0x006f }
            int r1 = r1 + r11
            double r3 = (double) r1     // Catch:{ Exception -> 0x006f }
            r20 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r3 = r3 * r20
            r25 = r3
            double r3 = (double) r12     // Catch:{ Exception -> 0x006f }
            double r3 = r25 / r3
            int r3 = (int) r3     // Catch:{ Exception -> 0x006f }
            int r4 = r0 + 10
            if (r3 > r4) goto L_0x01c1
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006f }
            r11 = 1000(0x3e8, float:1.401E-42)
            r25 = r4
            long r4 = (long) r11     // Catch:{ Exception -> 0x006f }
            long r4 = r23 + r4
            int r4 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x01b8
            if (r3 <= r0) goto L_0x01b8
            goto L_0x01c1
        L_0x01b8:
            r11 = r6
            r3 = r19
            r19 = r12
            r12 = r23
        L_0x01bf:
            r4 = 0
            goto L_0x0213
        L_0x01c1:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x006f }
            w3.I0 r0 = w3.C2865c0.c()     // Catch:{ Exception -> 0x006f }
            W1.a$n r11 = new W1.a$n     // Catch:{ Exception -> 0x006f }
            r23 = r0
            r16 = r6
            r6 = r19
            r0 = 0
            r11.<init>(r6, r3, r0)     // Catch:{ Exception -> 0x006f }
            r8.f19773a = r6     // Catch:{ Exception -> 0x006f }
            r0 = r18
            r8.f19774b = r0     // Catch:{ Exception -> 0x006f }
            r18 = r0
            r0 = r17
            r8.f19775c = r0     // Catch:{ Exception -> 0x006f }
            r8.f19776d = r15     // Catch:{ Exception -> 0x006f }
            r8.f19777e = r14     // Catch:{ Exception -> 0x006f }
            r8.f19778f = r10     // Catch:{ Exception -> 0x006f }
            r8.f19779g = r12     // Catch:{ Exception -> 0x006f }
            r8.f19781i = r1     // Catch:{ Exception -> 0x006f }
            r8.f19782j = r9     // Catch:{ Exception -> 0x006f }
            r8.f19783k = r3     // Catch:{ Exception -> 0x006f }
            r8.f19780h = r4     // Catch:{ Exception -> 0x006f }
            r8.f19784l = r2     // Catch:{ Exception -> 0x006f }
            r8.f19785m = r7     // Catch:{ Exception -> 0x006f }
            r17 = r0
            r0 = 2
            r8.f19788p = r0     // Catch:{ Exception -> 0x006f }
            r0 = r23
            java.lang.Object r0 = w3.C2872g.g(r0, r11, r8)     // Catch:{ Exception -> 0x006f }
            r11 = r16
            if (r0 != r11) goto L_0x0205
        L_0x0204:
            return r11
        L_0x0205:
            r0 = r6
            r19 = r12
            r12 = r4
            r5 = r8
            r8 = r10
            r10 = r1
        L_0x020c:
            r1 = r3
            r3 = r0
            r0 = r1
            r1 = r10
            r10 = r8
            r8 = r5
            goto L_0x01bf
        L_0x0213:
            int r5 = r10.read(r14, r4, r9)     // Catch:{ Exception -> 0x006f }
            r6 = r11
            r23 = r12
            r12 = r19
            r11 = r1
            r19 = r3
            r3 = r4
            r1 = r5
            goto L_0x0190
        L_0x0223:
            r4 = r3
            r16 = r6
            r6 = r19
            r10.close()     // Catch:{ Exception -> 0x006f }
            int r1 = r2 + 1
            r2 = r23
            r23 = r0
            r0 = r1
            r4 = r7
            r5 = r8
            r7 = r9
            r8 = r11
            r9 = r12
            r11 = r14
            r12 = r15
            r13 = r17
            r14 = r18
            r1 = r22
            r15 = r6
            r6 = r16
            goto L_0x0154
        L_0x0244:
            r12.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0253
        L_0x0248:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = "zipSuspend ZipOutputStream is null"
            r0.<init>(r1)     // Catch:{ Exception -> 0x006f }
            throw r0     // Catch:{ Exception -> 0x006f }
        L_0x0250:
            r0.printStackTrace()
        L_0x0253:
            W2.J r0 = W2.J.f19942a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2208a.v(java.util.ArrayList, java.util.ArrayList, java.lang.String, long, b3.e):java.lang.Object");
    }

    public final C2908y0 u(ArrayList arrayList) {
        t.e(arrayList, "appsToBackup");
        return C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new k(this, arrayList, (C2308e) null), 3, (Object) null);
    }
}
