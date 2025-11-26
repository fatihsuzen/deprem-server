package b2;

import S1.i;
import W2.J;
import W2.u;
import X1.C2231h;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.documentfile.provider.DocumentFile;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2901v;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: b2.l  reason: case insensitive filesystem */
public final class C2292l {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20704d = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static C2901v f20705e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static C2901v f20706f;

    /* renamed from: a  reason: collision with root package name */
    private final Context f20707a;

    /* renamed from: b  reason: collision with root package name */
    private final C2231h f20708b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f20709c;

    /* renamed from: b2.l$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2901v a() {
            return C2292l.f20705e;
        }

        public final C2901v b() {
            return C2292l.f20706f;
        }

        public final void c(C2901v vVar) {
            C2292l.f20705e = vVar;
        }

        public final void d(C2901v vVar) {
            C2292l.f20706f = vVar;
        }

        private a() {
        }
    }

    /* renamed from: b2.l$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20710a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f20711b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OutputStream f20712c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(InputStream inputStream, OutputStream outputStream, C2308e eVar) {
            super(2, eVar);
            this.f20711b = inputStream;
            this.f20712c = outputStream;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f20711b, this.f20712c, eVar);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                c3.C2316b.f()
                int r0 = r3.f20710a
                if (r0 != 0) goto L_0x0037
                W2.u.b(r4)
                r4 = 8192(0x2000, float:1.14794E-41)
                byte[] r4 = new byte[r4]     // Catch:{ all -> 0x001d }
            L_0x000e:
                java.io.InputStream r0 = r3.f20711b     // Catch:{ all -> 0x001d }
                int r0 = r0.read(r4)     // Catch:{ all -> 0x001d }
                if (r0 <= 0) goto L_0x001f
                java.io.OutputStream r1 = r3.f20712c     // Catch:{ all -> 0x001d }
                r2 = 0
                r1.write(r4, r2, r0)     // Catch:{ all -> 0x001d }
                goto L_0x000e
            L_0x001d:
                r4 = move-exception
                goto L_0x002c
            L_0x001f:
                java.io.InputStream r4 = r3.f20711b     // Catch:{ Exception -> 0x0024 }
                r4.close()     // Catch:{ Exception -> 0x0024 }
            L_0x0024:
                java.io.OutputStream r4 = r3.f20712c     // Catch:{ Exception -> 0x0029 }
                r4.close()     // Catch:{ Exception -> 0x0029 }
            L_0x0029:
                W2.J r4 = W2.J.f19942a
                return r4
            L_0x002c:
                java.io.InputStream r0 = r3.f20711b     // Catch:{ Exception -> 0x0031 }
                r0.close()     // Catch:{ Exception -> 0x0031 }
            L_0x0031:
                java.io.OutputStream r0 = r3.f20712c     // Catch:{ Exception -> 0x0036 }
                r0.close()     // Catch:{ Exception -> 0x0036 }
            L_0x0036:
                throw r4
            L_0x0037:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2292l.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.l$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20713a;

        /* renamed from: b  reason: collision with root package name */
        int f20714b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f20715c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f20716d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C2292l f20717e;

        /* renamed from: b2.l$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20718a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20719b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20719b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20719b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20718a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20719b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b("noEnoughSpace");
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20720a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20721b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20721b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20721b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20720a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20721b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b("fileNotFoundException");
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$c$c  reason: collision with other inner class name */
        static final class C0205c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20722a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20723b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0205c(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20723b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0205c(this.f20723b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20722a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20723b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b("securityException");
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0205c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$c$d */
        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20724a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20725b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20725b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new d(this.f20725b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20724a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20725b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b("fileNotFoundException");
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$c$e */
        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20726a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20727b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20727b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new e(this.f20727b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20726a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20727b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b("securityException");
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(File file, File file2, C2292l lVar, C2308e eVar) {
            super(2, eVar);
            this.f20715c = file;
            this.f20716d = file2;
            this.f20717e = lVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f20715c, this.f20716d, this.f20717e, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0064, code lost:
            if (r9 == r0) goto L_0x013d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
            return (W2.J) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cc, code lost:
            if (r9 != r0) goto L_0x00d0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d0, code lost:
            r9 = (W2.J) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
            r9 = r1;
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e9, code lost:
            if (r9 != r0) goto L_0x00ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ec, code lost:
            r9 = (W2.J) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ef, code lost:
            if (r1 == null) goto L_0x0110;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r3 = new java.io.FileOutputStream(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
            r9 = w3.C2865c0.c();
            r3 = new b2.C2292l.c.e(r8.f20717e, (b3.C2308e) null);
            r8.f20713a = r1;
            r8.f20714b = 5;
            r9 = w3.C2872g.g(r9, r3, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x010b, code lost:
            if (r9 != r0) goto L_0x010e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x010e, code lost:
            r9 = (W2.J) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0110, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0112, code lost:
            r9 = w3.C2865c0.c();
            r3 = new b2.C2292l.c.d(r8.f20717e, (b3.C2308e) null);
            r8.f20713a = r1;
            r8.f20714b = 4;
            r9 = w3.C2872g.g(r9, r3, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0126, code lost:
            if (r9 != r0) goto L_0x0129;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0129, code lost:
            r9 = (W2.J) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x012c, code lost:
            if (r1 == null) goto L_0x013e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x012e, code lost:
            if (r3 == null) goto L_0x013e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0130, code lost:
            r9 = r8.f20717e;
            r8.f20713a = null;
            r8.f20714b = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x013b, code lost:
            if (b2.C2292l.c(r9, r1, r3, r8) != r0) goto L_0x013e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x013d, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0140, code lost:
            return W2.J.f19942a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r8.f20714b
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x003f;
                    case 1: goto L_0x003b;
                    case 2: goto L_0x0032;
                    case 3: goto L_0x0029;
                    case 4: goto L_0x0020;
                    case 5: goto L_0x0017;
                    case 6: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0012:
                W2.u.b(r9)
                goto L_0x013e
            L_0x0017:
                java.lang.Object r1 = r8.f20713a
                java.io.InputStream r1 = (java.io.InputStream) r1
                W2.u.b(r9)
                goto L_0x010e
            L_0x0020:
                java.lang.Object r1 = r8.f20713a
                java.io.InputStream r1 = (java.io.InputStream) r1
                W2.u.b(r9)
                goto L_0x0129
            L_0x0029:
                java.lang.Object r1 = r8.f20713a
                java.io.File r1 = (java.io.File) r1
                W2.u.b(r9)
                goto L_0x00d0
            L_0x0032:
                java.lang.Object r1 = r8.f20713a
                java.io.File r1 = (java.io.File) r1
                W2.u.b(r9)
                goto L_0x00ec
            L_0x003b:
                W2.u.b(r9)
                goto L_0x0068
            L_0x003f:
                W2.u.b(r9)
                java.io.File r9 = r8.f20715c
                long r3 = r9.getUsableSpace()
                java.io.File r1 = r8.f20716d
                long r5 = r1.length()
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x006b
                w3.I0 r9 = w3.C2865c0.c()
                b2.l$c$a r1 = new b2.l$c$a
                b2.l r3 = r8.f20717e
                r1.<init>(r3, r2)
                r2 = 1
                r8.f20714b = r2
                java.lang.Object r9 = w3.C2872g.g(r9, r1, r8)
                if (r9 != r0) goto L_0x0068
                goto L_0x013d
            L_0x0068:
                W2.J r9 = (W2.J) r9
                return r9
            L_0x006b:
                java.io.File r1 = r8.f20716d
                boolean r1 = r1.isFile()
                if (r1 == 0) goto L_0x0141
                java.io.File r1 = r8.f20715c
                boolean r1 = r1.isDirectory()
                if (r1 == 0) goto L_0x00a0
                java.io.File r9 = new java.io.File
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.io.File r3 = r8.f20715c
                java.lang.String r3 = r3.getAbsolutePath()
                r1.append(r3)
                r3 = 47
                r1.append(r3)
                java.io.File r3 = r8.f20716d
                java.lang.String r3 = r3.getName()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r9.<init>(r1)
            L_0x00a0:
                r1 = r9
                boolean r9 = r1.exists()
                if (r9 == 0) goto L_0x00ad
                boolean r9 = r1.isFile()
                if (r9 != 0) goto L_0x013e
            L_0x00ad:
                java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00d5, SecurityException -> 0x00b8 }
                java.io.File r3 = r8.f20716d     // Catch:{ FileNotFoundException -> 0x00d5, SecurityException -> 0x00b8 }
                r9.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00d5, SecurityException -> 0x00b8 }
                r7 = r1
                r1 = r9
                r9 = r7
                goto L_0x00ef
            L_0x00b8:
                w3.I0 r9 = w3.C2865c0.c()
                b2.l$c$c r3 = new b2.l$c$c
                b2.l r4 = r8.f20717e
                r3.<init>(r4, r2)
                r8.f20713a = r1
                r4 = 3
                r8.f20714b = r4
                java.lang.Object r9 = w3.C2872g.g(r9, r3, r8)
                if (r9 != r0) goto L_0x00d0
                goto L_0x013d
            L_0x00d0:
                W2.J r9 = (W2.J) r9
            L_0x00d2:
                r9 = r1
                r1 = r2
                goto L_0x00ef
            L_0x00d5:
                w3.I0 r9 = w3.C2865c0.c()
                b2.l$c$b r3 = new b2.l$c$b
                b2.l r4 = r8.f20717e
                r3.<init>(r4, r2)
                r8.f20713a = r1
                r4 = 2
                r8.f20714b = r4
                java.lang.Object r9 = w3.C2872g.g(r9, r3, r8)
                if (r9 != r0) goto L_0x00ec
                goto L_0x013d
            L_0x00ec:
                W2.J r9 = (W2.J) r9
                goto L_0x00d2
            L_0x00ef:
                if (r1 == 0) goto L_0x0110
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0112, SecurityException -> 0x00f7 }
                r3.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0112, SecurityException -> 0x00f7 }
                goto L_0x012c
            L_0x00f7:
                w3.I0 r9 = w3.C2865c0.c()
                b2.l$c$e r3 = new b2.l$c$e
                b2.l r4 = r8.f20717e
                r3.<init>(r4, r2)
                r8.f20713a = r1
                r4 = 5
                r8.f20714b = r4
                java.lang.Object r9 = w3.C2872g.g(r9, r3, r8)
                if (r9 != r0) goto L_0x010e
                goto L_0x013d
            L_0x010e:
                W2.J r9 = (W2.J) r9
            L_0x0110:
                r3 = r2
                goto L_0x012c
            L_0x0112:
                w3.I0 r9 = w3.C2865c0.c()
                b2.l$c$d r3 = new b2.l$c$d
                b2.l r4 = r8.f20717e
                r3.<init>(r4, r2)
                r8.f20713a = r1
                r4 = 4
                r8.f20714b = r4
                java.lang.Object r9 = w3.C2872g.g(r9, r3, r8)
                if (r9 != r0) goto L_0x0129
                goto L_0x013d
            L_0x0129:
                W2.J r9 = (W2.J) r9
                goto L_0x0110
            L_0x012c:
                if (r1 == 0) goto L_0x013e
                if (r3 == 0) goto L_0x013e
                b2.l r9 = r8.f20717e
                r8.f20713a = r2
                r2 = 6
                r8.f20714b = r2
                java.lang.Object r9 = r9.r(r1, r3, r8)
                if (r9 != r0) goto L_0x013e
            L_0x013d:
                return r0
            L_0x013e:
                W2.J r9 = W2.J.f19942a
                return r9
            L_0x0141:
                W2.J r9 = W2.J.f19942a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2292l.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.l$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20728a;

        /* renamed from: b  reason: collision with root package name */
        Object f20729b;

        /* renamed from: c  reason: collision with root package name */
        Object f20730c;

        /* renamed from: d  reason: collision with root package name */
        Object f20731d;

        /* renamed from: e  reason: collision with root package name */
        Object f20732e;

        /* renamed from: f  reason: collision with root package name */
        Object f20733f;

        /* renamed from: g  reason: collision with root package name */
        Object f20734g;

        /* renamed from: h  reason: collision with root package name */
        Object f20735h;

        /* renamed from: i  reason: collision with root package name */
        int f20736i;

        /* renamed from: j  reason: collision with root package name */
        int f20737j;

        /* renamed from: k  reason: collision with root package name */
        boolean f20738k;

        /* renamed from: l  reason: collision with root package name */
        int f20739l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ C2292l f20740m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ ArrayList f20741n;

        /* renamed from: b2.l$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20742a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20743b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20743b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20743b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20742a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20743b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$d$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20744a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20745b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2292l lVar, C2308e eVar) {
                super(2, eVar);
                this.f20745b = lVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20745b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20744a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20745b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$d$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20746a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20747b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f20748c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2292l lVar, String str, C2308e eVar) {
                super(2, eVar);
                this.f20747b = lVar;
                this.f20748c = str;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20747b, this.f20748c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20746a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20747b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b(this.f20748c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.l$d$d  reason: collision with other inner class name */
        static final class C0206d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20749a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2292l f20750b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f20751c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0206d(C2292l lVar, String str, C2308e eVar) {
                super(2, eVar);
                this.f20750b = lVar;
                this.f20751c = str;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0206d(this.f20750b, this.f20751c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20749a == 0) {
                    u.b(obj);
                    C2231h w4 = this.f20750b.w();
                    if (w4 == null) {
                        return null;
                    }
                    w4.b(this.f20751c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0206d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2292l lVar, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f20740m = lVar;
            this.f20741n = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f20740m, this.f20741n, eVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v117, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v46, resolved type: kotlin.jvm.internal.L} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v118, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: android.content.pm.PackageInstaller} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v119, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: kotlin.jvm.internal.J} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v125, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v73, resolved type: kotlin.jvm.internal.L} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v127, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: kotlin.jvm.internal.J} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0333, code lost:
            r6 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0340, code lost:
            if (r4 == null) goto L_0x03c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0346, code lost:
            if (r8.isEmpty() != false) goto L_0x03c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0348, code lost:
            r13 = new java.io.File(new b2.C2290j().e(), r4);
            r13.mkdirs();
            r8 = r8.iterator();
            kotlin.jvm.internal.t.d(r8, "iterator(...)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0360, code lost:
            r15 = r14;
            r14 = r4;
            r4 = r12;
            r12 = r8;
            r8 = r15;
            r15 = r0;
            r0 = r3;
            r3 = r11;
            r11 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x036d, code lost:
            if (r12.hasNext() == false) goto L_0x03b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x036f, code lost:
            r6 = r12.next();
            kotlin.jvm.internal.t.d(r6, r9);
            r6 = (java.io.File) r6;
            r10 = r1.f20740m;
            r1.f20728a = r8;
            r1.f20729b = r5;
            r1.f20730c = r4;
            r1.f20731d = r3;
            r1.f20732e = r15;
            r1.f20733f = r14;
            r1.f20734g = r13;
            r1.f20735h = r12;
            r1.f20736i = r11;
            r1.f20737j = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x038e, code lost:
            r19 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            r1.f20739l = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0397, code lost:
            if (b2.C2292l.d(r10, r6, r13, r1) != r2) goto L_0x039b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x039b, code lost:
            r3 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x039e, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x039f, code lost:
            r3 = r4;
            r9 = r11;
            r11 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x03a5, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x03a6, code lost:
            r3 = r4;
            r9 = r11;
            r11 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x03ac, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x03ad, code lost:
            r19 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x03b0, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x03b1, code lost:
            r19 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x03b4, code lost:
            r19 = r3;
            r3 = r0;
            r6 = r5;
            r0 = r15;
            r5 = r4;
            r4 = r14;
            r14 = r8;
            r8 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x03bf, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x03c0, code lost:
            r9 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x03c3, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x03c4, code lost:
            r9 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x03c7, code lost:
            r8 = r11;
            r11 = r6;
            r6 = r5;
            r5 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
            r10 = new android.content.pm.PackageInstaller.SessionParams(b2.C2292l.j(r1.f20740m, r4, r0, r14));
            r10.setInstallLocation(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x03dc, code lost:
            if (r3 == 0) goto L_0x0413;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x03e0, code lost:
            if (android.os.Build.VERSION.SDK_INT < 31) goto L_0x0413;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x03e8, code lost:
            if (b2.C2292l.i(r1.f20740m) != false) goto L_0x0407;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x03ea, code lost:
            b2.C2292l.n(r1.f20740m, new b2.C2290j().s());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x03f9, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x03fa, code lost:
            r3 = r5;
            r5 = r6;
            r9 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x03fd, code lost:
            r11 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0400, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x0401, code lost:
            r3 = r5;
            r5 = r6;
            r9 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0404, code lost:
            r11 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x040d, code lost:
            if (b2.C2292l.i(r1.f20740m) != false) goto L_0x0413;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x040f, code lost:
            b2.C2293m.a(r10, 2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0417, code lost:
            if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x041d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0419, code lost:
            b2.C2294n.a(r10, 2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x041d, code lost:
            if (r4 == null) goto L_0x0422;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x041f, code lost:
            r10.setAppPackageName(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0422, code lost:
            r3 = S1.k.f32g;
            r3.K(r5.createSession(r10));
            r3 = r3.n();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:?, code lost:
            r8.f24690a = r5.openSession(r3);
            r4 = r14.iterator();
            kotlin.jvm.internal.t.d(r4, "iterator(...)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0440, code lost:
            if (r4.hasNext() == false) goto L_0x049b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0442, code lost:
            r7 = r4.next();
            kotlin.jvm.internal.t.d(r7, r9);
            r10 = b2.C2292l.f(r1.f20740m, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
            r7 = b2.C2292l.h(r1.f20740m, (android.content.pm.PackageInstaller.Session) r8.f24690a, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
            r6.f24688a = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x045c, code lost:
            if (r10 == null) goto L_0x046c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x045e, code lost:
            r11 = 2;
            kotlin.coroutines.jvm.internal.b.c(h3.C2452a.b(r10, r7, 0, 2, (java.lang.Object) null));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0469, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x046a, code lost:
            r4 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x046c, code lost:
            r11 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x046d, code lost:
            r6.f24688a = r11;
            ((android.content.pm.PackageInstaller.Session) r8.f24690a).fsync(r7);
            r12 = W2.J.f19942a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:?, code lost:
            h3.C2453b.a(r7, (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:?, code lost:
            h3.C2453b.a(r10, (java.lang.Throwable) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0480, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0481, code lost:
            r9 = r3;
            r3 = r5;
            r5 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0486, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x0487, code lost:
            r9 = r3;
            r3 = r5;
            r5 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x048c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x048d, code lost:
            r4 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:?, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x0490, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
            h3.C2453b.a(r7, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0494, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0496, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:?, code lost:
            h3.C2453b.a(r10, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x049a, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x049b, code lost:
            r4 = new android.content.Intent(r1.f20740m.t(), com.uptodown.core.service.SplitApksEventsService.class);
            r6.f24688a = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x04ad, code lost:
            if (android.os.Build.VERSION.SDK_INT < 31) goto L_0x04b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x04af, code lost:
            r10 = 301989888;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x04b2, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x04b3, code lost:
            r0 = android.app.PendingIntent.getService(r1.f20740m.t(), 0, r4, r10);
            r6.f24688a = 4;
            ((android.content.pm.PackageInstaller.Session) r8.f24690a).commit(r0.getIntentSender());
            r6.f24688a = 5;
            r0 = w3.C2905x.a((w3.C2908y0) getContext().get(w3.C2908y0.f26320k0));
            b2.C2292l.f20704d.d(r0);
            r1.f20728a = r6;
            r1.f20729b = r5;
            r1.f20730c = r8;
            r1.f20731d = null;
            r1.f20732e = null;
            r1.f20733f = null;
            r1.f20734g = null;
            r1.f20735h = null;
            r1.f20736i = r3;
            r1.f20739l = 4;
            r0 = r0.A(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x04fd, code lost:
            if (r0 != r2) goto L_0x0501;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x0501, code lost:
            r9 = r3;
            r3 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x0509, code lost:
            if (((java.lang.Boolean) r0).booleanValue() != false) goto L_0x052b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x050b, code lost:
            b2.C2292l.b(r1.f20740m, r9, r5);
            S1.k.f32g.e();
            r0 = "fail";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x0517, code lost:
            r2 = (android.content.pm.PackageInstaller.Session) r3.f24690a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x051b, code lost:
            if (r2 == null) goto L_0x0522;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x051d, code lost:
            r2.close();
            r2 = W2.J.f19942a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x0522, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x0523, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0524, code lost:
            r11 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x0527, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0528, code lost:
            r11 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
            r0 = w3.C2905x.a((w3.C2908y0) getContext().get(w3.C2908y0.f26320k0));
            b2.C2292l.f20704d.c(r0);
            r1.f20728a = r6;
            r1.f20729b = r5;
            r1.f20730c = r3;
            r1.f20736i = r9;
            r1.f20739l = 5;
            r0 = r0.A(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x054f, code lost:
            if (r0 != r2) goto L_0x0553;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x0553, code lost:
            r2 = (android.content.pm.PackageInstaller.Session) r3.f24690a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x0557, code lost:
            if (r2 == null) goto L_0x055a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x055a, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:241:0x05a9, code lost:
            r0 = r9;
            r2 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
            b2.C2292l.b(r1.f20740m, r0, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x05b0, code lost:
            r0 = (android.content.pm.PackageInstaller.Session) r2.f24690a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:245:0x05b4, code lost:
            if (r0 != null) goto L_0x05b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x05b6, code lost:
            r0.close();
            r0 = W2.J.f19942a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x05fb, code lost:
            r0 = r9;
            r2 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
            b2.C2292l.b(r1.f20740m, r0, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:256:0x0602, code lost:
            r0 = (android.content.pm.PackageInstaller.Session) r2.f24690a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:257:0x0606, code lost:
            if (r0 != null) goto L_0x05b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:259:0x060b, code lost:
            return W2.J.f19942a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0243, code lost:
            r6 = r3;
            r9 = r26;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0246, code lost:
            r3 = r0;
            r0 = r5;
            r5 = r13;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:241:0x05a9  */
        /* JADX WARNING: Removed duplicated region for block: B:253:0x05fb  */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:238:0x056d=Splitter:B:238:0x056d, B:249:0x05bf=Splitter:B:249:0x05bf} */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:242:0x05ab=Splitter:B:242:0x05ab, B:254:0x05fd=Splitter:B:254:0x05fd} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                r27 = this;
                r1 = r27
                java.lang.Object r2 = c3.C2316b.f()
                int r0 = r1.f20739l
                java.lang.String r6 = "next(...)"
                java.lang.String r7 = "iterator(...)"
                r9 = 0
                r10 = 0
                switch(r0) {
                    case 0: goto L_0x010a;
                    case 1: goto L_0x00e3;
                    case 2: goto L_0x00b1;
                    case 3: goto L_0x0081;
                    case 4: goto L_0x005c;
                    case 5: goto L_0x003a;
                    case 6: goto L_0x002b;
                    case 7: goto L_0x0019;
                    default: goto L_0x0011;
                }
            L_0x0011:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0019:
                int r0 = r1.f20736i
                java.lang.Object r2 = r1.f20729b
                kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
                java.lang.Object r3 = r1.f20728a
                android.content.pm.PackageInstaller r3 = (android.content.pm.PackageInstaller) r3
                W2.u.b(r28)     // Catch:{ all -> 0x0028 }
                goto L_0x05ab
            L_0x0028:
                r0 = move-exception
                goto L_0x060c
            L_0x002b:
                int r0 = r1.f20736i
                java.lang.Object r2 = r1.f20729b
                kotlin.jvm.internal.L r2 = (kotlin.jvm.internal.L) r2
                java.lang.Object r3 = r1.f20728a
                android.content.pm.PackageInstaller r3 = (android.content.pm.PackageInstaller) r3
                W2.u.b(r28)     // Catch:{ all -> 0x0028 }
                goto L_0x05fd
            L_0x003a:
                int r9 = r1.f20736i
                java.lang.Object r0 = r1.f20730c
                r3 = r0
                kotlin.jvm.internal.L r3 = (kotlin.jvm.internal.L) r3
                java.lang.Object r0 = r1.f20729b
                r4 = r0
                android.content.pm.PackageInstaller r4 = (android.content.pm.PackageInstaller) r4
                java.lang.Object r0 = r1.f20728a
                r5 = r0
                kotlin.jvm.internal.J r5 = (kotlin.jvm.internal.J) r5
                W2.u.b(r28)     // Catch:{ Exception -> 0x0057, all -> 0x0052 }
                r0 = r28
                goto L_0x0553
            L_0x0052:
                r0 = move-exception
            L_0x0053:
                r11 = r3
                r3 = r4
                goto L_0x056d
            L_0x0057:
                r0 = move-exception
            L_0x0058:
                r11 = r3
                r3 = r4
                goto L_0x05bf
            L_0x005c:
                int r9 = r1.f20736i
                java.lang.Object r0 = r1.f20730c
                r4 = r0
                kotlin.jvm.internal.L r4 = (kotlin.jvm.internal.L) r4
                java.lang.Object r0 = r1.f20729b
                r5 = r0
                android.content.pm.PackageInstaller r5 = (android.content.pm.PackageInstaller) r5
                java.lang.Object r0 = r1.f20728a
                r6 = r0
                kotlin.jvm.internal.J r6 = (kotlin.jvm.internal.J) r6
                W2.u.b(r28)     // Catch:{ Exception -> 0x007b, all -> 0x0075 }
                r0 = r28
                r3 = r4
                goto L_0x0503
            L_0x0075:
                r0 = move-exception
                r11 = r4
            L_0x0077:
                r3 = r5
                r5 = r6
                goto L_0x056d
            L_0x007b:
                r0 = move-exception
                r11 = r4
            L_0x007d:
                r3 = r5
                r5 = r6
                goto L_0x05bf
            L_0x0081:
                int r0 = r1.f20737j
                int r11 = r1.f20736i
                java.lang.Object r12 = r1.f20735h
                java.util.Iterator r12 = (java.util.Iterator) r12
                java.lang.Object r13 = r1.f20734g
                java.io.File r13 = (java.io.File) r13
                java.lang.Object r14 = r1.f20733f
                java.lang.String r14 = (java.lang.String) r14
                java.lang.Object r15 = r1.f20732e
                java.lang.Long r15 = (java.lang.Long) r15
                java.lang.Object r3 = r1.f20731d
                kotlin.jvm.internal.L r3 = (kotlin.jvm.internal.L) r3
                java.lang.Object r4 = r1.f20730c
                android.content.pm.PackageInstaller r4 = (android.content.pm.PackageInstaller) r4
                java.lang.Object r5 = r1.f20729b
                kotlin.jvm.internal.J r5 = (kotlin.jvm.internal.J) r5
                java.lang.Object r8 = r1.f20728a
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                W2.u.b(r28)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
                r9 = r6
                goto L_0x0369
            L_0x00ab:
                r0 = move-exception
                r9 = r11
                goto L_0x0053
            L_0x00ae:
                r0 = move-exception
                r9 = r11
                goto L_0x0058
            L_0x00b1:
                boolean r0 = r1.f20738k
                int r3 = r1.f20736i
                java.lang.Object r4 = r1.f20734g
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r5 = r1.f20733f
                java.lang.Long r5 = (java.lang.Long) r5
                java.lang.Object r8 = r1.f20732e
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                java.lang.Object r11 = r1.f20731d
                kotlin.jvm.internal.L r11 = (kotlin.jvm.internal.L) r11
                java.lang.Object r12 = r1.f20730c
                android.content.pm.PackageInstaller r12 = (android.content.pm.PackageInstaller) r12
                java.lang.Object r13 = r1.f20729b
                kotlin.jvm.internal.J r13 = (kotlin.jvm.internal.J) r13
                java.lang.Object r14 = r1.f20728a
                java.util.ArrayList r14 = (java.util.ArrayList) r14
                W2.u.b(r28)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
                r9 = r6
                goto L_0x0333
            L_0x00d7:
                r0 = move-exception
                r9 = r3
                r3 = r12
                r5 = r13
                goto L_0x056d
            L_0x00dd:
                r0 = move-exception
                r9 = r3
                r3 = r12
                r5 = r13
                goto L_0x05bf
            L_0x00e3:
                boolean r0 = r1.f20738k
                int r3 = r1.f20736i
                java.lang.Object r4 = r1.f20734g
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r5 = r1.f20733f
                java.lang.Long r5 = (java.lang.Long) r5
                java.lang.Object r8 = r1.f20732e
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                java.lang.Object r11 = r1.f20731d
                kotlin.jvm.internal.L r11 = (kotlin.jvm.internal.L) r11
                java.lang.Object r12 = r1.f20730c
                android.content.pm.PackageInstaller r12 = (android.content.pm.PackageInstaller) r12
                java.lang.Object r13 = r1.f20729b
                kotlin.jvm.internal.J r13 = (kotlin.jvm.internal.J) r13
                java.lang.Object r14 = r1.f20728a
                java.util.ArrayList r14 = (java.util.ArrayList) r14
                W2.u.b(r28)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
                r26 = r6
                goto L_0x0243
            L_0x010a:
                W2.u.b(r28)
                java.util.ArrayList r14 = new java.util.ArrayList
                r14.<init>()
                kotlin.jvm.internal.J r5 = new kotlin.jvm.internal.J
                r5.<init>()
                b2.l r0 = r1.f20740m
                android.content.Context r0 = r0.t()
                android.content.pm.PackageManager r0 = r0.getPackageManager()
                android.content.pm.PackageInstaller r12 = r0.getPackageInstaller()
                java.lang.String r0 = "getPackageInstaller(...)"
                kotlin.jvm.internal.t.d(r12, r0)
                b2.l r0 = r1.f20740m
                r0.p(r12)
                kotlin.jvm.internal.L r11 = new kotlin.jvm.internal.L
                r11.<init>()
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
                r8.<init>()     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
                java.util.ArrayList r0 = r1.f20741n     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
                kotlin.jvm.internal.t.d(r0, r7)     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
            L_0x0142:
                boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
                java.lang.String r4 = "getAbsolutePath(...)"
                if (r3 == 0) goto L_0x0178
                java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                kotlin.jvm.internal.t.d(r3, r6)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                boolean r13 = r3 instanceof java.io.File     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                if (r13 == 0) goto L_0x0142
                r13 = r3
                java.io.File r13 = (java.io.File) r13     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                java.lang.String r13 = r13.getAbsolutePath()     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                kotlin.jvm.internal.t.d(r13, r4)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                java.lang.String r4 = ".obb"
                r15 = 2
                boolean r4 = t3.s.D(r13, r4, r9, r15, r10)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                if (r4 == 0) goto L_0x0174
                r8.add(r3)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                goto L_0x0142
            L_0x016c:
                r0 = move-exception
            L_0x016d:
                r3 = r12
                goto L_0x056d
            L_0x0170:
                r0 = move-exception
            L_0x0171:
                r3 = r12
                goto L_0x05bf
            L_0x0174:
                r14.add(r3)     // Catch:{ Exception -> 0x0170, all -> 0x016c }
                goto L_0x0142
            L_0x0178:
                int r0 = r14.size()     // Catch:{ Exception -> 0x0569, all -> 0x0565 }
                r3 = 128(0x80, float:1.794E-43)
                java.lang.String r13 = "getPackageManager(...)"
                r15 = 1
                if (r0 != r15) goto L_0x024e
                java.lang.Object r0 = r14.get(r9)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r15 = "get(...)"
                kotlin.jvm.internal.t.d(r0, r15)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                boolean r15 = r0 instanceof java.io.File     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r15 == 0) goto L_0x024b
                b2.l r15 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.Context r15 = r15.t()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.PackageManager r15 = r15.getPackageManager()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r15, r13)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r18 = r0
                java.io.File r18 = (java.io.File) r18     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r9 = r18.getAbsolutePath()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r9, r4)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.PackageInfo r3 = b2.C2301u.c(r15, r9, r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r3 == 0) goto L_0x01bb
                android.content.pm.ApplicationInfo r9 = r3.applicationInfo     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                goto L_0x01bc
            L_0x01b1:
                r0 = move-exception
                r3 = r12
                r9 = 0
                goto L_0x056d
            L_0x01b6:
                r0 = move-exception
                r3 = r12
                r9 = 0
                goto L_0x05bf
            L_0x01bb:
                r9 = r10
            L_0x01bc:
                if (r9 == 0) goto L_0x024b
                b2.l r9 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.ApplicationInfo r15 = r3.applicationInfo     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.b(r15)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                int r15 = r15.targetSdkVersion     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                boolean r9 = r9.E(r15)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r15 = r3.packageName     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.j r10 = new b2.j     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r10.<init>()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r20 = r15
                android.content.pm.ApplicationInfo r15 = r3.applicationInfo     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.b(r15)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r19 = r0
                java.io.File r19 = (java.io.File) r19     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r26 = r6
                java.lang.String r6 = r19.getAbsolutePath()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r6, r4)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.l r4 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.Context r4 = r4.t()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r4, r13)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r23 = r10.b(r15, r6, r4)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.j r4 = new b2.j     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r4.<init>()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r3 = r4.m(r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.Long r3 = kotlin.coroutines.jvm.internal.b.c(r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                S1.k$a r19 = S1.k.f32g     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r21 = r3.longValue()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.io.File r0 = (java.io.File) r0     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r24 = r0.length()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r19.B(r20, r21, r23, r24)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r4 = r20
                w3.I0 r0 = w3.C2865c0.c()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.l$d$a r6 = new b2.l$d$a     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.l r10 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r13 = 0
                r6.<init>(r10, r13)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20728a = r14     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20729b = r5     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20730c = r12     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20731d = r11     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20732e = r8     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20733f = r3     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20734g = r4     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r10 = 0
                r1.f20736i = r10     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20738k = r9     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r15 = 1
                r1.f20739l = r15     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.Object r0 = w3.C2872g.g(r0, r6, r1)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r0 != r2) goto L_0x023f
                goto L_0x05fa
            L_0x023f:
                r13 = r5
                r0 = r9
                r5 = r3
                r3 = 0
            L_0x0243:
                r6 = r3
                r9 = r26
            L_0x0246:
                r3 = r0
                r0 = r5
                r5 = r13
                goto L_0x0340
            L_0x024b:
                r9 = r6
                goto L_0x033c
            L_0x024e:
                r26 = r6
                java.util.Iterator r0 = r14.iterator()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                kotlin.jvm.internal.t.d(r0, r7)     // Catch:{ Exception -> 0x0560, all -> 0x055b }
            L_0x0257:
                boolean r6 = r0.hasNext()     // Catch:{ Exception -> 0x0560, all -> 0x055b }
                if (r6 == 0) goto L_0x033a
                java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r9 = r26
                kotlin.jvm.internal.t.d(r6, r9)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                boolean r10 = r6 instanceof java.io.File     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r10 == 0) goto L_0x0336
                b2.l r10 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.Context r10 = r10.t()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.PackageManager r10 = r10.getPackageManager()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r10, r13)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r15 = r6
                java.io.File r15 = (java.io.File) r15     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r15 = r15.getAbsolutePath()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r15, r4)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.PackageInfo r10 = b2.C2301u.c(r10, r15, r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r10 == 0) goto L_0x028a
                android.content.pm.ApplicationInfo r15 = r10.applicationInfo     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                goto L_0x028b
            L_0x028a:
                r15 = 0
            L_0x028b:
                if (r15 == 0) goto L_0x0336
                b2.i r15 = new b2.i     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r15.<init>()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                boolean r15 = r15.o(r10)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r15 == 0) goto L_0x0336
                b2.l r0 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.ApplicationInfo r3 = r10.applicationInfo     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                int r3 = r3.targetSdkVersion     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                boolean r0 = r0.E(r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r3 = r10.packageName     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.j r15 = new b2.j     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r15.<init>()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r20 = r3
                android.content.pm.ApplicationInfo r3 = r10.applicationInfo     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.io.File r6 = (java.io.File) r6     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r6, r4)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.l r4 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.Context r4 = r4.t()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r4, r13)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.String r23 = r15.b(r3, r6, r4)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.j r3 = new b2.j     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r3.<init>()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r3 = r3.m(r10)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.Long r3 = kotlin.coroutines.jvm.internal.b.c(r3)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.util.Iterator r4 = r14.iterator()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r4, r7)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r21 = 0
                r24 = r21
            L_0x02e5:
                boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r6 == 0) goto L_0x02fb
                java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                kotlin.jvm.internal.t.d(r6, r9)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.io.File r6 = (java.io.File) r6     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r21 = r6.length()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r24 = r24 + r21
                goto L_0x02e5
            L_0x02fb:
                S1.k$a r19 = S1.k.f32g     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                long r21 = r3.longValue()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r19.B(r20, r21, r23, r24)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r4 = r20
                w3.I0 r6 = w3.C2865c0.c()     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.l$d$b r10 = new b2.l$d$b     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                b2.l r13 = r1.f20740m     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r15 = 0
                r10.<init>(r13, r15)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20728a = r14     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20729b = r5     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20730c = r12     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20731d = r11     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20732e = r8     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20733f = r3     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20734g = r4     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r13 = 0
                r1.f20736i = r13     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r1.f20738k = r0     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                r15 = 2
                r1.f20739l = r15     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                java.lang.Object r6 = w3.C2872g.g(r6, r10, r1)     // Catch:{ Exception -> 0x01b6, all -> 0x01b1 }
                if (r6 != r2) goto L_0x0330
                goto L_0x05fa
            L_0x0330:
                r13 = r5
                r5 = r3
                r3 = 0
            L_0x0333:
                r6 = r3
                goto L_0x0246
            L_0x0336:
                r26 = r9
                goto L_0x0257
            L_0x033a:
                r9 = r26
            L_0x033c:
                r0 = 0
                r3 = 0
                r4 = 0
                r6 = 0
            L_0x0340:
                if (r4 == 0) goto L_0x03c7
                boolean r10 = r8.isEmpty()     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                if (r10 != 0) goto L_0x03c7
                b2.j r10 = new b2.j     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                r10.<init>()     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                java.io.File r10 = r10.e()     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                java.io.File r13 = new java.io.File     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                r13.<init>(r10, r4)     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                r13.mkdirs()     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                kotlin.jvm.internal.t.d(r8, r7)     // Catch:{ Exception -> 0x03c3, all -> 0x03bf }
                r15 = r14
                r14 = r4
                r4 = r12
                r12 = r8
                r8 = r15
                r15 = r0
                r0 = r3
                r3 = r11
                r11 = r6
            L_0x0369:
                boolean r6 = r12.hasNext()     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                if (r6 == 0) goto L_0x03b4
                java.lang.Object r6 = r12.next()     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                kotlin.jvm.internal.t.d(r6, r9)     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                java.io.File r6 = (java.io.File) r6     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                b2.l r10 = r1.f20740m     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20728a = r8     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20729b = r5     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20730c = r4     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20731d = r3     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20732e = r15     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20733f = r14     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20734g = r13     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20735h = r12     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20736i = r11     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r1.f20737j = r0     // Catch:{ Exception -> 0x03b0, all -> 0x03ac }
                r19 = r3
                r3 = 3
                r1.f20739l = r3     // Catch:{ Exception -> 0x03a5, all -> 0x039e }
                java.lang.Object r3 = r10.s(r6, r13, r1)     // Catch:{ Exception -> 0x03a5, all -> 0x039e }
                if (r3 != r2) goto L_0x039b
                goto L_0x05fa
            L_0x039b:
                r3 = r19
                goto L_0x0369
            L_0x039e:
                r0 = move-exception
            L_0x039f:
                r3 = r4
                r9 = r11
                r11 = r19
                goto L_0x056d
            L_0x03a5:
                r0 = move-exception
            L_0x03a6:
                r3 = r4
                r9 = r11
                r11 = r19
                goto L_0x05bf
            L_0x03ac:
                r0 = move-exception
                r19 = r3
                goto L_0x039f
            L_0x03b0:
                r0 = move-exception
                r19 = r3
                goto L_0x03a6
            L_0x03b4:
                r19 = r3
                r3 = r0
                r6 = r5
                r0 = r15
                r5 = r4
                r4 = r14
                r14 = r8
                r8 = r19
                goto L_0x03cb
            L_0x03bf:
                r0 = move-exception
                r9 = r6
                goto L_0x016d
            L_0x03c3:
                r0 = move-exception
                r9 = r6
                goto L_0x0171
            L_0x03c7:
                r8 = r11
                r11 = r6
                r6 = r5
                r5 = r12
            L_0x03cb:
                b2.l r10 = r1.f20740m     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                int r0 = r10.y(r4, r0, r14)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                android.content.pm.PackageInstaller$SessionParams r10 = new android.content.pm.PackageInstaller$SessionParams     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r10.<init>(r0)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r13 = 0
                r10.setInstallLocation(r13)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r0 = 31
                if (r3 == 0) goto L_0x0413
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                if (r3 < r0) goto L_0x0413
                b2.l r3 = r1.f20740m     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                boolean r3 = r3.f20709c     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                if (r3 != 0) goto L_0x0407
                b2.l r3 = r1.f20740m     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                b2.j r12 = new b2.j     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r12.<init>()     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                boolean r12 = r12.s()     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r3.f20709c = r12     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                goto L_0x0407
            L_0x03f9:
                r0 = move-exception
                r3 = r5
                r5 = r6
                r9 = r11
            L_0x03fd:
                r11 = r8
                goto L_0x056d
            L_0x0400:
                r0 = move-exception
                r3 = r5
                r5 = r6
                r9 = r11
            L_0x0404:
                r11 = r8
                goto L_0x05bf
            L_0x0407:
                b2.l r3 = r1.f20740m     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                boolean r3 = r3.f20709c     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                if (r3 != 0) goto L_0x0413
                r15 = 2
                r10.setRequireUserAction(r15)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
            L_0x0413:
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r12 = 33
                if (r3 < r12) goto L_0x041d
                r15 = 2
                r10.setPackageSource(r15)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
            L_0x041d:
                if (r4 == 0) goto L_0x0422
                r10.setAppPackageName(r4)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
            L_0x0422:
                S1.k$a r3 = S1.k.f32g     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                int r4 = r5.createSession(r10)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                r3.K(r4)     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                int r3 = r3.n()     // Catch:{ Exception -> 0x0400, all -> 0x03f9 }
                android.content.pm.PackageInstaller$Session r4 = r5.openSession(r3)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r8.f24690a = r4     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                java.util.Iterator r4 = r14.iterator()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                kotlin.jvm.internal.t.d(r4, r7)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
            L_0x043c:
                boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                if (r7 == 0) goto L_0x049b
                java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                kotlin.jvm.internal.t.d(r7, r9)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                b2.l r10 = r1.f20740m     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                java.io.InputStream r10 = r10.v(r7)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                b2.l r11 = r1.f20740m     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                java.lang.Object r12 = r8.f24690a     // Catch:{ all -> 0x048c }
                android.content.pm.PackageInstaller$Session r12 = (android.content.pm.PackageInstaller.Session) r12     // Catch:{ all -> 0x048c }
                java.io.OutputStream r7 = r11.x(r12, r7)     // Catch:{ all -> 0x048c }
                r15 = 1
                r6.f24688a = r15     // Catch:{ all -> 0x0469 }
                if (r10 == 0) goto L_0x046c
                r11 = 2
                r12 = 0
                r13 = 0
                long r16 = h3.C2452a.b(r10, r7, r13, r11, r12)     // Catch:{ all -> 0x0469 }
                kotlin.coroutines.jvm.internal.b.c(r16)     // Catch:{ all -> 0x0469 }
                goto L_0x046d
            L_0x0469:
                r0 = move-exception
                r4 = r0
                goto L_0x048f
            L_0x046c:
                r11 = 2
            L_0x046d:
                r6.f24688a = r11     // Catch:{ all -> 0x0469 }
                java.lang.Object r12 = r8.f24690a     // Catch:{ all -> 0x0469 }
                android.content.pm.PackageInstaller$Session r12 = (android.content.pm.PackageInstaller.Session) r12     // Catch:{ all -> 0x0469 }
                r12.fsync(r7)     // Catch:{ all -> 0x0469 }
                W2.J r12 = W2.J.f19942a     // Catch:{ all -> 0x0469 }
                r12 = 0
                h3.C2453b.a(r7, r12)     // Catch:{ all -> 0x048c }
                h3.C2453b.a(r10, r12)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                goto L_0x043c
            L_0x0480:
                r0 = move-exception
                r9 = r3
                r3 = r5
                r5 = r6
                goto L_0x03fd
            L_0x0486:
                r0 = move-exception
                r9 = r3
                r3 = r5
                r5 = r6
                goto L_0x0404
            L_0x048c:
                r0 = move-exception
                r4 = r0
                goto L_0x0495
            L_0x048f:
                throw r4     // Catch:{ all -> 0x0490 }
            L_0x0490:
                r0 = move-exception
                h3.C2453b.a(r7, r4)     // Catch:{ all -> 0x048c }
                throw r0     // Catch:{ all -> 0x048c }
            L_0x0495:
                throw r4     // Catch:{ all -> 0x0496 }
            L_0x0496:
                r0 = move-exception
                h3.C2453b.a(r10, r4)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                throw r0     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
            L_0x049b:
                android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                b2.l r7 = r1.f20740m     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                android.content.Context r7 = r7.t()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                java.lang.Class<com.uptodown.core.service.SplitApksEventsService> r9 = com.uptodown.core.service.SplitApksEventsService.class
                r4.<init>(r7, r9)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r7 = 3
                r6.f24688a = r7     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                if (r7 < r0) goto L_0x04b2
                r10 = 301989888(0x12000000, float:4.0389678E-28)
                goto L_0x04b3
            L_0x04b2:
                r10 = 0
            L_0x04b3:
                b2.l r0 = r1.f20740m     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                android.content.Context r0 = r0.t()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r13 = 0
                android.app.PendingIntent r0 = android.app.PendingIntent.getService(r0, r13, r4, r10)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r4 = 4
                r6.f24688a = r4     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                java.lang.Object r7 = r8.f24690a     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                android.content.pm.PackageInstaller$Session r7 = (android.content.pm.PackageInstaller.Session) r7     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                android.content.IntentSender r0 = r0.getIntentSender()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r7.commit(r0)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r0 = 5
                r6.f24688a = r0     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                b3.i r0 = r1.getContext()     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                w3.y0$b r7 = w3.C2908y0.f26320k0     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                b3.i$b r0 = r0.get(r7)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                w3.y0 r0 = (w3.C2908y0) r0     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                w3.v r0 = w3.C2905x.a(r0)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                b2.l$a r7 = b2.C2292l.f20704d     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r7.d(r0)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20728a = r6     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20729b = r5     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20730c = r8     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r12 = 0
                r1.f20731d = r12     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20732e = r12     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20733f = r12     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20734g = r12     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20735h = r12     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20736i = r3     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                r1.f20739l = r4     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                java.lang.Object r0 = r0.A(r1)     // Catch:{ Exception -> 0x0486, all -> 0x0480 }
                if (r0 != r2) goto L_0x0501
                goto L_0x05fa
            L_0x0501:
                r9 = r3
                r3 = r8
            L_0x0503:
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                if (r0 != 0) goto L_0x052b
                b2.l r0 = r1.f20740m     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r0.q(r9, r5)     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                S1.k$a r0 = S1.k.f32g     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r0.e()     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                java.lang.String r0 = "fail"
                java.lang.Object r2 = r3.f24690a
                android.content.pm.PackageInstaller$Session r2 = (android.content.pm.PackageInstaller.Session) r2
                if (r2 == 0) goto L_0x0522
            L_0x051d:
                r2.close()
                W2.J r2 = W2.J.f19942a
            L_0x0522:
                return r0
            L_0x0523:
                r0 = move-exception
                r11 = r3
                goto L_0x0077
            L_0x0527:
                r0 = move-exception
                r11 = r3
                goto L_0x007d
            L_0x052b:
                b3.i r0 = r1.getContext()     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                w3.y0$b r4 = w3.C2908y0.f26320k0     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                b3.i$b r0 = r0.get(r4)     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                w3.y0 r0 = (w3.C2908y0) r0     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                w3.v r0 = w3.C2905x.a(r0)     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                b2.l$a r4 = b2.C2292l.f20704d     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r4.c(r0)     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r1.f20728a = r6     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r1.f20729b = r5     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r1.f20730c = r3     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r1.f20736i = r9     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                r4 = 5
                r1.f20739l = r4     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                java.lang.Object r0 = r0.A(r1)     // Catch:{ Exception -> 0x0527, all -> 0x0523 }
                if (r0 != r2) goto L_0x0553
                goto L_0x05fa
            L_0x0553:
                java.lang.Object r2 = r3.f24690a
                android.content.pm.PackageInstaller$Session r2 = (android.content.pm.PackageInstaller.Session) r2
                if (r2 == 0) goto L_0x055a
                goto L_0x051d
            L_0x055a:
                return r0
            L_0x055b:
                r0 = move-exception
                r13 = 0
                r3 = r12
                r9 = r13
                goto L_0x056d
            L_0x0560:
                r0 = move-exception
                r13 = 0
                r3 = r12
                r9 = r13
                goto L_0x05bf
            L_0x0565:
                r0 = move-exception
                r13 = r9
                goto L_0x016d
            L_0x0569:
                r0 = move-exception
                r13 = r9
                goto L_0x0171
            L_0x056d:
                r0.printStackTrace()     // Catch:{ all -> 0x05bc }
                S1.k$a r0 = S1.k.f32g     // Catch:{ all -> 0x05bc }
                r0.e()     // Catch:{ all -> 0x05bc }
                b2.l r0 = r1.f20740m     // Catch:{ all -> 0x05bc }
                java.lang.Object r4 = r11.f24690a     // Catch:{ all -> 0x05bc }
                android.content.pm.PackageInstaller$Session r4 = (android.content.pm.PackageInstaller.Session) r4     // Catch:{ all -> 0x05bc }
                int r5 = r5.f24688a     // Catch:{ all -> 0x05bc }
                java.lang.String r0 = r0.u(r9, r4, r5)     // Catch:{ all -> 0x05bc }
                w3.I0 r4 = w3.C2865c0.c()     // Catch:{ all -> 0x05bc }
                b2.l$d$d r5 = new b2.l$d$d     // Catch:{ all -> 0x05bc }
                b2.l r6 = r1.f20740m     // Catch:{ all -> 0x05bc }
                r12 = 0
                r5.<init>(r6, r0, r12)     // Catch:{ all -> 0x05bc }
                r1.f20728a = r3     // Catch:{ all -> 0x05bc }
                r1.f20729b = r11     // Catch:{ all -> 0x05bc }
                r1.f20730c = r12     // Catch:{ all -> 0x05bc }
                r1.f20731d = r12     // Catch:{ all -> 0x05bc }
                r1.f20732e = r12     // Catch:{ all -> 0x05bc }
                r1.f20733f = r12     // Catch:{ all -> 0x05bc }
                r1.f20734g = r12     // Catch:{ all -> 0x05bc }
                r1.f20735h = r12     // Catch:{ all -> 0x05bc }
                r1.f20736i = r9     // Catch:{ all -> 0x05bc }
                r0 = 7
                r1.f20739l = r0     // Catch:{ all -> 0x05bc }
                java.lang.Object r0 = w3.C2872g.g(r4, r5, r1)     // Catch:{ all -> 0x05bc }
                if (r0 != r2) goto L_0x05a9
                goto L_0x05fa
            L_0x05a9:
                r0 = r9
                r2 = r11
            L_0x05ab:
                b2.l r4 = r1.f20740m     // Catch:{ all -> 0x0028 }
                r4.q(r0, r3)     // Catch:{ all -> 0x0028 }
                java.lang.Object r0 = r2.f24690a
                android.content.pm.PackageInstaller$Session r0 = (android.content.pm.PackageInstaller.Session) r0
                if (r0 == 0) goto L_0x0609
            L_0x05b6:
                r0.close()
                W2.J r0 = W2.J.f19942a
                goto L_0x0609
            L_0x05bc:
                r0 = move-exception
                r2 = r11
                goto L_0x060c
            L_0x05bf:
                r0.printStackTrace()     // Catch:{ all -> 0x05bc }
                S1.k$a r0 = S1.k.f32g     // Catch:{ all -> 0x05bc }
                r0.e()     // Catch:{ all -> 0x05bc }
                b2.l r0 = r1.f20740m     // Catch:{ all -> 0x05bc }
                java.lang.Object r4 = r11.f24690a     // Catch:{ all -> 0x05bc }
                android.content.pm.PackageInstaller$Session r4 = (android.content.pm.PackageInstaller.Session) r4     // Catch:{ all -> 0x05bc }
                int r5 = r5.f24688a     // Catch:{ all -> 0x05bc }
                java.lang.String r0 = r0.u(r9, r4, r5)     // Catch:{ all -> 0x05bc }
                w3.I0 r4 = w3.C2865c0.c()     // Catch:{ all -> 0x05bc }
                b2.l$d$c r5 = new b2.l$d$c     // Catch:{ all -> 0x05bc }
                b2.l r6 = r1.f20740m     // Catch:{ all -> 0x05bc }
                r12 = 0
                r5.<init>(r6, r0, r12)     // Catch:{ all -> 0x05bc }
                r1.f20728a = r3     // Catch:{ all -> 0x05bc }
                r1.f20729b = r11     // Catch:{ all -> 0x05bc }
                r1.f20730c = r12     // Catch:{ all -> 0x05bc }
                r1.f20731d = r12     // Catch:{ all -> 0x05bc }
                r1.f20732e = r12     // Catch:{ all -> 0x05bc }
                r1.f20733f = r12     // Catch:{ all -> 0x05bc }
                r1.f20734g = r12     // Catch:{ all -> 0x05bc }
                r1.f20735h = r12     // Catch:{ all -> 0x05bc }
                r1.f20736i = r9     // Catch:{ all -> 0x05bc }
                r0 = 6
                r1.f20739l = r0     // Catch:{ all -> 0x05bc }
                java.lang.Object r0 = w3.C2872g.g(r4, r5, r1)     // Catch:{ all -> 0x05bc }
                if (r0 != r2) goto L_0x05fb
            L_0x05fa:
                return r2
            L_0x05fb:
                r0 = r9
                r2 = r11
            L_0x05fd:
                b2.l r4 = r1.f20740m     // Catch:{ all -> 0x0028 }
                r4.q(r0, r3)     // Catch:{ all -> 0x0028 }
                java.lang.Object r0 = r2.f24690a
                android.content.pm.PackageInstaller$Session r0 = (android.content.pm.PackageInstaller.Session) r0
                if (r0 == 0) goto L_0x0609
                goto L_0x05b6
            L_0x0609:
                W2.J r0 = W2.J.f19942a
                return r0
            L_0x060c:
                java.lang.Object r2 = r2.f24690a
                android.content.pm.PackageInstaller$Session r2 = (android.content.pm.PackageInstaller.Session) r2
                if (r2 == 0) goto L_0x0617
                r2.close()
                W2.J r2 = W2.J.f19942a
            L_0x0617:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2292l.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.l$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20752a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2292l f20753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f20754c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2292l lVar, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f20753b = lVar;
            this.f20754c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f20753b, this.f20754c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f20752a;
            if (i5 == 0) {
                u.b(obj);
                C2292l lVar = this.f20753b;
                ArrayList arrayList = this.f20754c;
                this.f20752a = 1;
                if (lVar.C(arrayList, this) == f5) {
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2292l(Context context, C2231h hVar) {
        t.e(context, "context");
        this.f20707a = context;
        this.f20708b = hVar;
    }

    public static /* synthetic */ void B(C2292l lVar, ArrayList arrayList, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        lVar.A(arrayList, z4);
    }

    /* access modifiers changed from: private */
    public final Object C(ArrayList arrayList, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new d(this, arrayList, (C2308e) null), eVar);
    }

    private final void D(ArrayList arrayList) {
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new e(this, arrayList, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void p(PackageInstaller packageInstaller) {
        for (PackageInstaller.SessionInfo sessionId : packageInstaller.getMySessions()) {
            try {
                packageInstaller.abandonSession(sessionId.getSessionId());
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void q(int i5, PackageInstaller packageInstaller) {
        try {
            packageInstaller.abandonSession(i5);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final Object r(InputStream inputStream, OutputStream outputStream, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(inputStream, outputStream, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object s(File file, File file2, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new c(file2, file, this, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    public final String u(int i5, PackageInstaller.Session session, int i6) {
        if (i5 == 0) {
            return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE});
        } else if (session == null) {
            return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{"103"});
        } else if (i6 == 0) {
            return this.f20707a.getString(i.installation_status_failure_storage);
        } else {
            if (i6 == 1) {
                return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{"105"});
            } else if (i6 == 2) {
                return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{"106"});
            } else if (i6 == 3) {
                return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{"107"});
            } else if (i6 == 4) {
                return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{"108"});
            } else {
                return this.f20707a.getString(i.error_code_installation_status_failure, new Object[]{"101"});
            }
        }
    }

    /* access modifiers changed from: private */
    public final InputStream v(Object obj) {
        if (obj instanceof File) {
            return new FileInputStream((File) obj);
        }
        if (obj instanceof DocumentFile) {
            ContentResolver contentResolver = this.f20707a.getContentResolver();
            if (contentResolver != null) {
                return contentResolver.openInputStream(((DocumentFile) obj).getUri());
            }
            return null;
        }
        throw new Exception("getInputStream: Illegal parameter type");
    }

    /* access modifiers changed from: private */
    public final OutputStream x(PackageInstaller.Session session, Object obj) {
        String name;
        long length;
        if (obj instanceof File) {
            File file = (File) obj;
            name = file.getName();
            length = file.length();
        } else if (obj instanceof DocumentFile) {
            DocumentFile documentFile = (DocumentFile) obj;
            if (documentFile.getName() != null) {
                name = documentFile.getName();
                t.b(name);
                length = documentFile.length();
            } else {
                throw new Exception("getOutputStream: DocumentFile name is null");
            }
        } else {
            throw new Exception("getOutputStream: Illegal parameter type");
        }
        OutputStream openWrite = session.openWrite(name, 0, length);
        t.d(openWrite, "openWrite(...)");
        return openWrite;
    }

    /* access modifiers changed from: private */
    public final int y(String str, Long l5, ArrayList arrayList) {
        PackageInfo packageInfo;
        if (str != null) {
            try {
                PackageManager packageManager = this.f20707a.getPackageManager();
                t.d(packageManager, "getPackageManager(...)");
                packageInfo = C2301u.d(packageManager, str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo != null) {
                long m5 = new C2290j().m(packageInfo);
                if (l5 != null && m5 == l5.longValue() && arrayList.size() > 1) {
                    return 2;
                }
            }
        }
        return 1;
    }

    public final void A(ArrayList arrayList, boolean z4) {
        t.e(arrayList, "apks");
        this.f20709c = z4;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        D(arrayList2);
    }

    public final boolean E(int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 31) {
            return false;
        }
        if (i6 == 31 && i5 >= 29) {
            return true;
        }
        if (i6 == 32 && i5 >= 29) {
            return true;
        }
        if (i6 == 33 && i5 >= 30) {
            return true;
        }
        if (i6 < 34 || i5 < 31) {
            return false;
        }
        return true;
    }

    public final Context t() {
        return this.f20707a;
    }

    public final C2231h w() {
        return this.f20708b;
    }

    public final void z(File file, boolean z4) {
        t.e(file, "apk");
        this.f20709c = z4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        D(arrayList);
    }
}
