package b2;

import S1.k;
import W2.J;
import W2.u;
import X1.k;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import b3.C2308e;
import b3.C2312i;
import c2.C2314a;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: b2.v  reason: case insensitive filesystem */
public abstract class C2302v {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20755a = new a((C2633k) null);

    /* renamed from: b2.v$a */
    public static final class a {

        /* renamed from: b2.v$a$a  reason: collision with other inner class name */
        static final class C0207a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20756a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f20757b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f20758c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ k f20759d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0207a(String str, Context context, k kVar, C2308e eVar) {
                super(2, eVar);
                this.f20757b = str;
                this.f20758c = context;
                this.f20759d = kVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0207a(this.f20757b, this.f20758c, this.f20759d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f20756a;
                if (i5 == 0) {
                    u.b(obj);
                    a aVar = C2302v.f20755a;
                    String str = this.f20757b;
                    Context context = this.f20758c;
                    k kVar = this.f20759d;
                    this.f20756a = 1;
                    if (aVar.c(str, context, kVar, this) == f5) {
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
                return ((C0207a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.v$a$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            Object f20760a;

            /* renamed from: b  reason: collision with root package name */
            Object f20761b;

            /* renamed from: c  reason: collision with root package name */
            int f20762c;

            /* renamed from: d  reason: collision with root package name */
            int f20763d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f20764e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Context f20765f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ k f20766g;

            /* renamed from: b2.v$a$b$a  reason: collision with other inner class name */
            static final class C0208a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20767a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ k f20768b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20769c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f20770d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0208a(k kVar, String str, String str2, C2308e eVar) {
                    super(2, eVar);
                    this.f20768b = kVar;
                    this.f20769c = str;
                    this.f20770d = str2;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0208a(this.f20768b, this.f20769c, this.f20770d, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f20767a == 0) {
                        u.b(obj);
                        k kVar = this.f20768b;
                        if (kVar != null) {
                            kVar.e(this.f20769c);
                        }
                        k.a aVar = S1.k.f32g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f20770d);
                            ResultReceiver v5 = aVar.v();
                            if (v5 != null) {
                                v5.send(304, bundle);
                            }
                        }
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(M m5, C2308e eVar) {
                    return ((C0208a) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* renamed from: b2.v$a$b$b  reason: collision with other inner class name */
            static final class C0209b extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20771a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ X1.k f20772b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20773c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f20774d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0209b(X1.k kVar, String str, String str2, C2308e eVar) {
                    super(2, eVar);
                    this.f20772b = kVar;
                    this.f20773c = str;
                    this.f20774d = str2;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0209b(this.f20772b, this.f20773c, this.f20774d, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f20771a == 0) {
                        u.b(obj);
                        X1.k kVar = this.f20772b;
                        if (kVar != null) {
                            kVar.a(this.f20773c);
                        }
                        k.a aVar = S1.k.f32g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f20774d);
                            ResultReceiver v5 = aVar.v();
                            if (v5 != null) {
                                v5.send(301, bundle);
                            }
                        }
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(M m5, C2308e eVar) {
                    return ((C0209b) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* renamed from: b2.v$a$b$c */
            static final class c extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20775a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ X1.k f20776b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20777c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f20778d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ String f20779e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                c(X1.k kVar, String str, String str2, String str3, C2308e eVar) {
                    super(2, eVar);
                    this.f20776b = kVar;
                    this.f20777c = str;
                    this.f20778d = str2;
                    this.f20779e = str3;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new c(this.f20776b, this.f20777c, this.f20778d, this.f20779e, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f20775a == 0) {
                        u.b(obj);
                        X1.k kVar = this.f20776b;
                        if (kVar != null) {
                            kVar.c(this.f20777c, this.f20778d);
                        }
                        k.a aVar = S1.k.f32g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f20779e);
                            bundle.putString("filename", this.f20777c);
                            bundle.putString("errorMsg", this.f20778d);
                            ResultReceiver v5 = aVar.v();
                            if (v5 != null) {
                                v5.send(303, bundle);
                            }
                        }
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(M m5, C2308e eVar) {
                    return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* renamed from: b2.v$a$b$d */
            static final class d extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20780a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ X1.k f20781b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20782c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f20783d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                d(X1.k kVar, String str, String str2, C2308e eVar) {
                    super(2, eVar);
                    this.f20781b = kVar;
                    this.f20782c = str;
                    this.f20783d = str2;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new d(this.f20781b, this.f20782c, this.f20783d, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f20780a == 0) {
                        u.b(obj);
                        X1.k kVar = this.f20781b;
                        if (kVar != null) {
                            kVar.b(this.f20782c);
                        }
                        k.a aVar = S1.k.f32g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f20783d);
                            bundle.putString("filename", this.f20782c);
                            ResultReceiver v5 = aVar.v();
                            if (v5 != null) {
                                v5.send(302, bundle);
                            }
                        }
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(M m5, C2308e eVar) {
                    return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* renamed from: b2.v$a$b$e */
            static final class e extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20784a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ X1.k f20785b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20786c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                e(X1.k kVar, String str, C2308e eVar) {
                    super(2, eVar);
                    this.f20785b = kVar;
                    this.f20786c = str;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new e(this.f20785b, this.f20786c, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f20784a == 0) {
                        u.b(obj);
                        X1.k kVar = this.f20785b;
                        if (kVar == null) {
                            return null;
                        }
                        kVar.d(this.f20786c);
                        return J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(M m5, C2308e eVar) {
                    return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, Context context, X1.k kVar, C2308e eVar) {
                super(2, eVar);
                this.f20764e = str;
                this.f20765f = context;
                this.f20766g = kVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20764e, this.f20765f, this.f20766g, eVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e6, code lost:
                if (r2 == r0) goto L_0x01e8;
             */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x013a A[Catch:{ Exception -> 0x0024 }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0199 A[Catch:{ Exception -> 0x0024 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x01b3 A[Catch:{ Exception -> 0x0024 }] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x00c2=Splitter:B:42:0x00c2, B:13:0x002f=Splitter:B:13:0x002f} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r24) {
                /*
                    r23 = this;
                    r1 = r23
                    java.lang.Object r0 = c3.C2316b.f()
                    int r2 = r1.f20763d
                    r3 = 5
                    r4 = 4
                    r5 = 3
                    r6 = 2
                    r7 = 0
                    java.lang.String r8 = "getPackageManager(...)"
                    r9 = 1
                    r10 = 0
                    if (r2 == 0) goto L_0x004c
                    if (r2 == r9) goto L_0x0040
                    if (r2 == r6) goto L_0x0034
                    if (r2 == r5) goto L_0x002f
                    if (r2 == r4) goto L_0x002f
                    if (r2 != r3) goto L_0x0027
                    W2.u.b(r24)     // Catch:{ Exception -> 0x0024 }
                    r2 = r24
                    goto L_0x01e9
                L_0x0024:
                    r0 = move-exception
                    goto L_0x01ec
                L_0x0027:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r2)
                    throw r0
                L_0x002f:
                    W2.u.b(r24)     // Catch:{ Exception -> 0x0024 }
                    goto L_0x01cb
                L_0x0034:
                    int r2 = r1.f20762c
                    java.lang.Object r3 = r1.f20760a
                    java.lang.String r3 = (java.lang.String) r3
                    W2.u.b(r24)     // Catch:{ Exception -> 0x0024 }
                    r15 = r3
                    goto L_0x011c
                L_0x0040:
                    java.lang.Object r2 = r1.f20761b
                    android.content.pm.PackageInfo r2 = (android.content.pm.PackageInfo) r2
                    java.lang.Object r3 = r1.f20760a
                    java.lang.String r3 = (java.lang.String) r3
                    W2.u.b(r24)     // Catch:{ NameNotFoundException -> 0x00c0 }
                    goto L_0x00ba
                L_0x004c:
                    W2.u.b(r24)
                    java.io.File r2 = new java.io.File
                    java.lang.String r11 = r1.f20764e
                    r2.<init>(r11)
                    boolean r2 = r2.exists()
                    if (r2 == 0) goto L_0x0227
                    android.content.Context r2 = r1.f20765f     // Catch:{ Exception -> 0x0024 }
                    android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x0024 }
                    kotlin.jvm.internal.t.d(r2, r8)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r11 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    r12 = 128(0x80, float:1.794E-43)
                    android.content.pm.PackageInfo r2 = b2.C2301u.c(r2, r11, r12)     // Catch:{ Exception -> 0x0024 }
                    if (r2 == 0) goto L_0x0072
                    android.content.pm.ApplicationInfo r11 = r2.applicationInfo     // Catch:{ Exception -> 0x0024 }
                    goto L_0x0073
                L_0x0072:
                    r11 = r10
                L_0x0073:
                    if (r11 == 0) goto L_0x01d3
                    android.content.pm.ApplicationInfo r3 = r2.applicationInfo     // Catch:{ Exception -> 0x0024 }
                    kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x0024 }
                    b2.j r11 = new b2.j     // Catch:{ Exception -> 0x0024 }
                    r11.<init>()     // Catch:{ Exception -> 0x0024 }
                    long r11 = r11.m(r2)     // Catch:{ Exception -> 0x0024 }
                    android.content.Context r13 = r1.f20765f     // Catch:{ NameNotFoundException -> 0x00c0 }
                    android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00c0 }
                    kotlin.jvm.internal.t.d(r13, r8)     // Catch:{ NameNotFoundException -> 0x00c0 }
                    android.content.pm.PackageInfo r13 = b2.C2301u.d(r13, r3, r7)     // Catch:{ NameNotFoundException -> 0x00c0 }
                    b2.j r14 = new b2.j     // Catch:{ NameNotFoundException -> 0x00c0 }
                    r14.<init>()     // Catch:{ NameNotFoundException -> 0x00c0 }
                    long r13 = r14.m(r13)     // Catch:{ NameNotFoundException -> 0x00c0 }
                    int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                    if (r11 <= 0) goto L_0x00bd
                    w3.I0 r11 = w3.C2865c0.c()     // Catch:{ NameNotFoundException -> 0x00c0 }
                    b2.v$a$b$a r12 = new b2.v$a$b$a     // Catch:{ NameNotFoundException -> 0x00c0 }
                    X1.k r13 = r1.f20766g     // Catch:{ NameNotFoundException -> 0x00c0 }
                    java.lang.String r14 = r1.f20764e     // Catch:{ NameNotFoundException -> 0x00c0 }
                    r12.<init>(r13, r14, r3, r10)     // Catch:{ NameNotFoundException -> 0x00c0 }
                    r1.f20760a = r3     // Catch:{ NameNotFoundException -> 0x00c0 }
                    r1.f20761b = r2     // Catch:{ NameNotFoundException -> 0x00c0 }
                    r1.f20763d = r9     // Catch:{ NameNotFoundException -> 0x00c0 }
                    java.lang.Object r11 = w3.C2872g.g(r11, r12, r1)     // Catch:{ NameNotFoundException -> 0x00c0 }
                    if (r11 != r0) goto L_0x00ba
                    goto L_0x01e8
                L_0x00ba:
                    W2.J r0 = W2.J.f19942a     // Catch:{ NameNotFoundException -> 0x00c0 }
                    return r0
                L_0x00bd:
                    r11 = r3
                    r3 = r9
                    goto L_0x00c2
                L_0x00c0:
                    r11 = r3
                    r3 = r7
                L_0x00c2:
                    b2.j r12 = new b2.j     // Catch:{ Exception -> 0x0024 }
                    r12.<init>()     // Catch:{ Exception -> 0x0024 }
                    android.content.pm.ApplicationInfo r13 = r2.applicationInfo     // Catch:{ Exception -> 0x0024 }
                    kotlin.jvm.internal.t.b(r13)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r14 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    android.content.Context r15 = r1.f20765f     // Catch:{ Exception -> 0x0024 }
                    android.content.pm.PackageManager r15 = r15.getPackageManager()     // Catch:{ Exception -> 0x0024 }
                    kotlin.jvm.internal.t.d(r15, r8)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r20 = r12.b(r13, r14, r15)     // Catch:{ Exception -> 0x0024 }
                    b2.j r8 = new b2.j     // Catch:{ Exception -> 0x0024 }
                    r8.<init>()     // Catch:{ Exception -> 0x0024 }
                    long r18 = r8.m(r2)     // Catch:{ Exception -> 0x0024 }
                    b2.i r8 = new b2.i     // Catch:{ Exception -> 0x0024 }
                    r8.<init>()     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r12 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    long r21 = r8.j(r12)     // Catch:{ Exception -> 0x0024 }
                    S1.k$a r16 = S1.k.f32g     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r8 = "packageName"
                    kotlin.jvm.internal.t.d(r2, r8)     // Catch:{ Exception -> 0x0024 }
                    r17 = r2
                    r16.B(r17, r18, r20, r21)     // Catch:{ Exception -> 0x0024 }
                    w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0024 }
                    b2.v$a$b$b r8 = new b2.v$a$b$b     // Catch:{ Exception -> 0x0024 }
                    X1.k r12 = r1.f20766g     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r13 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    r8.<init>(r12, r13, r11, r10)     // Catch:{ Exception -> 0x0024 }
                    r1.f20760a = r11     // Catch:{ Exception -> 0x0024 }
                    r1.f20761b = r10     // Catch:{ Exception -> 0x0024 }
                    r1.f20762c = r3     // Catch:{ Exception -> 0x0024 }
                    r1.f20763d = r6     // Catch:{ Exception -> 0x0024 }
                    java.lang.Object r2 = w3.C2872g.g(r2, r8, r1)     // Catch:{ Exception -> 0x0024 }
                    if (r2 != r0) goto L_0x011a
                    goto L_0x01e8
                L_0x011a:
                    r2 = r3
                    r15 = r11
                L_0x011c:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024 }
                    r3.<init>()     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = "pm install -i \""
                    r3.append(r6)     // Catch:{ Exception -> 0x0024 }
                    android.content.Context r6 = r1.f20765f     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0024 }
                    r3.append(r6)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = "\" "
                    r3.append(r6)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0024 }
                    if (r2 == 0) goto L_0x014b
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024 }
                    r2.<init>()     // Catch:{ Exception -> 0x0024 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r3 = "-r "
                    r2.append(r3)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x0024 }
                L_0x014b:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024 }
                    r2.<init>()     // Catch:{ Exception -> 0x0024 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0024 }
                    r3 = 34
                    r2.append(r3)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    r2.append(r6)     // Catch:{ Exception -> 0x0024 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0024 }
                    java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = "su"
                    java.lang.String r8 = "-c"
                    java.lang.String[] r2 = new java.lang.String[]{r6, r8, r2}     // Catch:{ Exception -> 0x0024 }
                    java.lang.Process r2 = r3.exec(r2)     // Catch:{ Exception -> 0x0024 }
                    java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0024 }
                    java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0024 }
                    java.io.InputStream r8 = r2.getInputStream()     // Catch:{ Exception -> 0x0024 }
                    r6.<init>(r8)     // Catch:{ Exception -> 0x0024 }
                    r3.<init>(r6)     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r14 = r3.readLine()     // Catch:{ Exception -> 0x0024 }
                    if (r14 == 0) goto L_0x0191
                    java.lang.String r6 = "Success"
                    boolean r6 = t3.s.E(r14, r6, r9)     // Catch:{ Exception -> 0x0024 }
                    if (r6 == 0) goto L_0x0191
                    r7 = r9
                L_0x0191:
                    r3.close()     // Catch:{ Exception -> 0x0024 }
                    r2.waitFor()     // Catch:{ Exception -> 0x0024 }
                    if (r7 != 0) goto L_0x01b3
                    w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0024 }
                    b2.v$a$b$c r11 = new b2.v$a$b$c     // Catch:{ Exception -> 0x0024 }
                    X1.k r12 = r1.f20766g     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r13 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    r16 = 0
                    r11.<init>(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0024 }
                    r1.f20760a = r10     // Catch:{ Exception -> 0x0024 }
                    r1.f20763d = r5     // Catch:{ Exception -> 0x0024 }
                    java.lang.Object r2 = w3.C2872g.g(r2, r11, r1)     // Catch:{ Exception -> 0x0024 }
                    if (r2 != r0) goto L_0x01cb
                    goto L_0x01e8
                L_0x01b3:
                    w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0024 }
                    b2.v$a$b$d r3 = new b2.v$a$b$d     // Catch:{ Exception -> 0x0024 }
                    X1.k r5 = r1.f20766g     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    r3.<init>(r5, r6, r15, r10)     // Catch:{ Exception -> 0x0024 }
                    r1.f20760a = r10     // Catch:{ Exception -> 0x0024 }
                    r1.f20763d = r4     // Catch:{ Exception -> 0x0024 }
                    java.lang.Object r2 = w3.C2872g.g(r2, r3, r1)     // Catch:{ Exception -> 0x0024 }
                    if (r2 != r0) goto L_0x01cb
                    goto L_0x01e8
                L_0x01cb:
                    S1.k$a r0 = S1.k.f32g     // Catch:{ Exception -> 0x0024 }
                    r0.e()     // Catch:{ Exception -> 0x0024 }
                    W2.J r0 = W2.J.f19942a     // Catch:{ Exception -> 0x0024 }
                    goto L_0x0230
                L_0x01d3:
                    w3.I0 r2 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0024 }
                    b2.v$a$b$e r4 = new b2.v$a$b$e     // Catch:{ Exception -> 0x0024 }
                    X1.k r5 = r1.f20766g     // Catch:{ Exception -> 0x0024 }
                    java.lang.String r6 = r1.f20764e     // Catch:{ Exception -> 0x0024 }
                    r4.<init>(r5, r6, r10)     // Catch:{ Exception -> 0x0024 }
                    r1.f20763d = r3     // Catch:{ Exception -> 0x0024 }
                    java.lang.Object r2 = w3.C2872g.g(r2, r4, r1)     // Catch:{ Exception -> 0x0024 }
                    if (r2 != r0) goto L_0x01e9
                L_0x01e8:
                    return r0
                L_0x01e9:
                    W2.J r2 = (W2.J) r2     // Catch:{ Exception -> 0x0024 }
                    goto L_0x0230
                L_0x01ec:
                    S1.k$a r2 = S1.k.f32g
                    r2.e()
                    X1.k r3 = r1.f20766g
                    if (r3 == 0) goto L_0x01fe
                    java.lang.String r4 = r1.f20764e
                    java.lang.String r5 = r0.getMessage()
                    r3.c(r4, r5)
                L_0x01fe:
                    android.os.ResultReceiver r3 = r2.v()
                    if (r3 == 0) goto L_0x0224
                    android.os.Bundle r3 = new android.os.Bundle
                    r3.<init>()
                    java.lang.String r4 = "filename"
                    java.lang.String r5 = r1.f20764e
                    r3.putString(r4, r5)
                    java.lang.String r4 = "errorMsg"
                    java.lang.String r0 = r0.getMessage()
                    r3.putString(r4, r0)
                    android.os.ResultReceiver r0 = r2.v()
                    if (r0 == 0) goto L_0x0224
                    r2 = 303(0x12f, float:4.25E-43)
                    r0.send(r2, r3)
                L_0x0224:
                    W2.J r0 = W2.J.f19942a
                    goto L_0x0230
                L_0x0227:
                    X1.k r0 = r1.f20766g
                    if (r0 == 0) goto L_0x0230
                    java.lang.String r2 = r1.f20764e
                    r0.f(r2)
                L_0x0230:
                    W2.J r0 = W2.J.f19942a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: b2.C2302v.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final Object c(String str, Context context, X1.k kVar, C2308e eVar) {
            Object g5 = C2872g.g(C2865c0.a(), new b(str, context, kVar, (C2308e) null), eVar);
            if (g5 == C2316b.f()) {
                return g5;
            }
            return J.f19942a;
        }

        public final void b(String str, Context context, X1.k kVar) {
            t.e(str, "filename");
            t.e(context, "context");
            C2908y0 unused = C2876i.d(N.a(C2865c0.a()), (C2312i) null, (O) null, new C0207a(str, context, kVar, (C2308e) null), 3, (Object) null);
        }

        public final boolean d() {
            return C2314a.b();
        }

        private a() {
        }
    }
}
