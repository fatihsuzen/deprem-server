package W1;

import W2.J;
import W2.u;
import X1.C2227d;
import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;

/* renamed from: W1.b  reason: case insensitive filesystem */
public final class C2209b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f19795a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f19796b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2227d f19797c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final boolean f19798d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f19799e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f19800f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f19801g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f19802h;

    /* renamed from: W1.b$a */
    static final class a extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19803a;

        /* renamed from: b  reason: collision with root package name */
        int f19804b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2209b f19805c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2209b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19805c = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f19805c, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
            if (W1.C2209b.c(r6, r5) == r0) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0048, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
            if (r6 == r0) goto L_0x0048;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f19804b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                W2.u.b(r6)
                goto L_0x0049
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                java.lang.Object r1 = r5.f19803a
                W1.b r1 = (W1.C2209b) r1
                W2.u.b(r6)
                goto L_0x0032
            L_0x0022:
                W2.u.b(r6)
                W1.b r1 = r5.f19805c
                r5.f19803a = r1
                r5.f19804b = r3
                java.lang.Object r6 = r1.u(r5)
                if (r6 != r0) goto L_0x0032
                goto L_0x0048
            L_0x0032:
                java.lang.Number r6 = (java.lang.Number) r6
                long r3 = r6.longValue()
                r1.f19801g = r3
                W1.b r6 = r5.f19805c
                r1 = 0
                r5.f19803a = r1
                r5.f19804b = r2
                java.lang.Object r6 = r6.w(r5)
                if (r6 != r0) goto L_0x0049
            L_0x0048:
                return r0
            L_0x0049:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$b  reason: collision with other inner class name */
    static final class C0185b extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19806a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19807b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0185b(C2209b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19807b = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0185b(this.f19807b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            long j5;
            C2316b.f();
            if (this.f19806a == 0) {
                u.b(obj);
                Iterator it = this.f19807b.f19795a.iterator();
                t.d(it, "iterator(...)");
                long j6 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    if (next instanceof File) {
                        j5 = this.f19807b.D((File) next);
                    } else if (next instanceof DocumentFile) {
                        j5 = this.f19807b.C((DocumentFile) next);
                    } else {
                        j5 = 0;
                    }
                    j6 += j5;
                }
                return b.c(j6);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C0185b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$c */
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19808a;

        /* renamed from: b  reason: collision with root package name */
        Object f19809b;

        /* renamed from: c  reason: collision with root package name */
        Object f19810c;

        /* renamed from: d  reason: collision with root package name */
        Object f19811d;

        /* renamed from: e  reason: collision with root package name */
        int f19812e;

        /* renamed from: f  reason: collision with root package name */
        int f19813f;

        /* renamed from: g  reason: collision with root package name */
        /* synthetic */ Object f19814g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C2209b f19815h;

        /* renamed from: i  reason: collision with root package name */
        int f19816i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2209b bVar, C2308e eVar) {
            super(eVar);
            this.f19815h = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19814g = obj;
            this.f19816i |= Integer.MIN_VALUE;
            return this.f19815h.v((DocumentFile) null, (DocumentFile) null, this);
        }
    }

    /* renamed from: W1.b$d */
    static final class d extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19817a;

        /* renamed from: b  reason: collision with root package name */
        Object f19818b;

        /* renamed from: c  reason: collision with root package name */
        Object f19819c;

        /* renamed from: d  reason: collision with root package name */
        int f19820d;

        /* renamed from: e  reason: collision with root package name */
        int f19821e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2209b f19822f;

        /* renamed from: W1.b$d$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19823a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f19824b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2209b f19825c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Object f19826d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(int i5, C2209b bVar, Object obj, C2308e eVar) {
                super(2, eVar);
                this.f19824b = i5;
                this.f19825c = bVar;
                this.f19826d = obj;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f19824b, this.f19825c, this.f19826d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19823a == 0) {
                    u.b(obj);
                    int i5 = this.f19824b + 1;
                    C2227d m5 = this.f19825c.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    m5.b(this.f19826d, i5, this.f19825c.f19795a.size(), this.f19825c.f19801g);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$d$b  reason: collision with other inner class name */
        static final class C0186b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19827a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f19828b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2209b f19829c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0186b(File file, C2209b bVar, C2308e eVar) {
                super(2, eVar);
                this.f19828b = file;
                this.f19829c = bVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0186b(this.f19828b, this.f19829c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2227d m5;
                C2316b.f();
                if (this.f19827a == 0) {
                    u.b(obj);
                    if (!(this.f19828b == null || (m5 = this.f19829c.f19797c) == null)) {
                        m5.h(this.f19828b);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0186b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$d$c */
        static final class c extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19830a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DocumentFile f19831b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2209b f19832c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(DocumentFile documentFile, C2209b bVar, C2308e eVar) {
                super(2, eVar);
                this.f19831b = documentFile;
                this.f19832c = bVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f19831b, this.f19832c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2227d m5;
                C2316b.f();
                if (this.f19830a == 0) {
                    u.b(obj);
                    if (!(this.f19831b == null || (m5 = this.f19832c.f19797c) == null)) {
                        m5.h(this.f19831b);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$d$d  reason: collision with other inner class name */
        static final class C0187d extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19833a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DocumentFile f19834b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2209b f19835c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0187d(DocumentFile documentFile, C2209b bVar, C2308e eVar) {
                super(2, eVar);
                this.f19834b = documentFile;
                this.f19835c = bVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0187d(this.f19834b, this.f19835c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2227d m5;
                C2316b.f();
                if (this.f19833a == 0) {
                    u.b(obj);
                    if (!(this.f19834b == null || (m5 = this.f19835c.f19797c) == null)) {
                        m5.h(this.f19834b);
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0187d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$d$e */
        static final class e extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19836a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2209b f19837b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(C2209b bVar, C2308e eVar) {
                super(2, eVar);
                this.f19837b = bVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new e(this.f19837b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19836a == 0) {
                    u.b(obj);
                    C2227d m5 = this.f19837b.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    m5.i();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2209b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19822f = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f19822f, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
            r5 = r4;
            r4 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0072, code lost:
            r5 = r4;
            r4 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
            if (r4.hasNext() == false) goto L_0x01ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0097, code lost:
            r9 = r1 + 1;
            r3 = r4.next();
            r5 = w3.C2865c0.c();
            r6 = new W1.C2209b.d.a(r1, r8.f19822f, r3, (b3.C2308e) null);
            r8.f19817a = r4;
            r8.f19818b = r3;
            r8.f19819c = null;
            r8.f19820d = r9;
            r8.f19821e = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b7, code lost:
            if (w3.C2872g.g(r5, r6, r8) != r0) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bb, code lost:
            r1 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
            if ((r3 instanceof java.io.File) == false) goto L_0x0174;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c8, code lost:
            if ((W1.C2209b.n(r8.f19822f) instanceof java.io.File) == false) goto L_0x011b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ca, code lost:
            r9 = r8.f19822f;
            r8.f19817a = r4;
            r8.f19818b = r3;
            r8.f19820d = r1;
            r8.f19821e = 2;
            r9 = W1.C2209b.f(r9, (java.io.File) r3, (java.io.File) W1.C2209b.n(r9), r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e2, code lost:
            if (r9 != r0) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e6, code lost:
            r3 = (java.io.File) r9;
            r9 = w3.C2865c0.c();
            r6 = new W1.C2209b.d.C0186b(r3, r8.f19822f, (b3.C2308e) null);
            r8.f19817a = r5;
            r8.f19818b = r4;
            r8.f19819c = r3;
            r8.f19820d = r1;
            r8.f19821e = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0103, code lost:
            if (w3.C2872g.g(r9, r6, r8) != r0) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x010d, code lost:
            if (W1.C2209b.i(r8.f19822f) == false) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x010f, code lost:
            if (r3 == null) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0111, code lost:
            W1.C2209b.g(r8.f19822f, (java.io.File) r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0118, code lost:
            r4 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0123, code lost:
            if ((W1.C2209b.n(r8.f19822f) instanceof androidx.documentfile.provider.DocumentFile) == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0125, code lost:
            r9 = r8.f19822f;
            r8.f19817a = r4;
            r8.f19818b = r3;
            r8.f19820d = r1;
            r8.f19821e = 4;
            r9 = W1.C2209b.e(r9, (java.io.File) r3, (androidx.documentfile.provider.DocumentFile) W1.C2209b.n(r9), r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x013d, code lost:
            if (r9 != r0) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0141, code lost:
            r3 = (androidx.documentfile.provider.DocumentFile) r9;
            r9 = w3.C2865c0.c();
            r6 = new W1.C2209b.d.c(r3, r8.f19822f, (b3.C2308e) null);
            r8.f19817a = r5;
            r8.f19818b = r4;
            r8.f19819c = r3;
            r8.f19820d = r1;
            r8.f19821e = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x015e, code lost:
            if (w3.C2872g.g(r9, r6, r8) != r0) goto L_0x0162;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0168, code lost:
            if (W1.C2209b.i(r8.f19822f) == false) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x016a, code lost:
            if (r3 == null) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x016c, code lost:
            W1.C2209b.g(r8.f19822f, (java.io.File) r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0176, code lost:
            if ((r3 instanceof androidx.documentfile.provider.DocumentFile) == false) goto L_0x01e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0180, code lost:
            if ((W1.C2209b.n(r8.f19822f) instanceof java.io.File) == false) goto L_0x018f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0182, code lost:
            r9 = androidx.documentfile.provider.DocumentFile.fromFile((java.io.File) W1.C2209b.n(r8.f19822f));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x018f, code lost:
            r9 = W1.C2209b.n(r8.f19822f);
            kotlin.jvm.internal.t.c(r9, "null cannot be cast to non-null type androidx.documentfile.provider.DocumentFile");
            r9 = (androidx.documentfile.provider.DocumentFile) r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x019c, code lost:
            r8.f19817a = r4;
            r8.f19818b = r3;
            r8.f19820d = r1;
            r8.f19821e = 6;
            r9 = W1.C2209b.b(r8.f19822f, (androidx.documentfile.provider.DocumentFile) r3, r9, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ae, code lost:
            if (r9 != r0) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01b1, code lost:
            r3 = (androidx.documentfile.provider.DocumentFile) r9;
            r9 = w3.C2865c0.c();
            r6 = new W1.C2209b.d.C0187d(r3, r8.f19822f, (b3.C2308e) null);
            r8.f19817a = r5;
            r8.f19818b = r4;
            r8.f19819c = r3;
            r8.f19820d = r1;
            r8.f19821e = 7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ce, code lost:
            if (w3.C2872g.g(r9, r6, r8) != r0) goto L_0x01d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01d7, code lost:
            if (W1.C2209b.i(r8.f19822f) == false) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d9, code lost:
            if (r3 == null) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01db, code lost:
            ((androidx.documentfile.provider.DocumentFile) r4).delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e9, code lost:
            throw new java.lang.Exception("Unsupported data type");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ea, code lost:
            r9 = w3.C2865c0.c();
            r1 = new W1.C2209b.d.e(r8.f19822f, (b3.C2308e) null);
            r8.f19817a = null;
            r8.f19818b = null;
            r8.f19819c = null;
            r8.f19821e = 8;
            r9 = w3.C2872g.g(r9, r1, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0203, code lost:
            if (r9 != r0) goto L_0x0206;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0205, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0206, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
            r5 = r4;
            r4 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r8.f19821e
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0082;
                    case 1: goto L_0x0076;
                    case 2: goto L_0x0067;
                    case 3: goto L_0x0056;
                    case 4: goto L_0x0047;
                    case 5: goto L_0x0036;
                    case 6: goto L_0x0027;
                    case 7: goto L_0x0016;
                    case 8: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0012:
                W2.u.b(r9)
                return r9
            L_0x0016:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19819c
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                java.lang.Object r4 = r8.f19818b
                java.lang.Object r5 = r8.f19817a
                java.util.Iterator r5 = (java.util.Iterator) r5
                W2.u.b(r9)
                goto L_0x01d1
            L_0x0027:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19818b
                java.lang.Object r4 = r8.f19817a
                java.util.Iterator r4 = (java.util.Iterator) r4
                W2.u.b(r9)
            L_0x0032:
                r5 = r4
                r4 = r3
                goto L_0x01b1
            L_0x0036:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19819c
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                java.lang.Object r4 = r8.f19818b
                java.lang.Object r5 = r8.f19817a
                java.util.Iterator r5 = (java.util.Iterator) r5
                W2.u.b(r9)
                goto L_0x0162
            L_0x0047:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19818b
                java.lang.Object r4 = r8.f19817a
                java.util.Iterator r4 = (java.util.Iterator) r4
                W2.u.b(r9)
            L_0x0052:
                r5 = r4
                r4 = r3
                goto L_0x0141
            L_0x0056:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19819c
                java.io.File r3 = (java.io.File) r3
                java.lang.Object r4 = r8.f19818b
                java.lang.Object r5 = r8.f19817a
                java.util.Iterator r5 = (java.util.Iterator) r5
                W2.u.b(r9)
                goto L_0x0107
            L_0x0067:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19818b
                java.lang.Object r4 = r8.f19817a
                java.util.Iterator r4 = (java.util.Iterator) r4
                W2.u.b(r9)
            L_0x0072:
                r5 = r4
                r4 = r3
                goto L_0x00e6
            L_0x0076:
                int r1 = r8.f19820d
                java.lang.Object r3 = r8.f19818b
                java.lang.Object r4 = r8.f19817a
                java.util.Iterator r4 = (java.util.Iterator) r4
                W2.u.b(r9)
                goto L_0x00bc
            L_0x0082:
                W2.u.b(r9)
                W1.b r9 = r8.f19822f
                java.util.ArrayList r9 = r9.f19795a
                java.util.Iterator r9 = r9.iterator()
                r1 = 0
                r4 = r9
            L_0x0091:
                boolean r9 = r4.hasNext()
                if (r9 == 0) goto L_0x01ea
                int r9 = r1 + 1
                java.lang.Object r3 = r4.next()
                w3.I0 r5 = w3.C2865c0.c()
                W1.b$d$a r6 = new W1.b$d$a
                W1.b r7 = r8.f19822f
                r6.<init>(r1, r7, r3, r2)
                r8.f19817a = r4
                r8.f19818b = r3
                r8.f19819c = r2
                r8.f19820d = r9
                r1 = 1
                r8.f19821e = r1
                java.lang.Object r1 = w3.C2872g.g(r5, r6, r8)
                if (r1 != r0) goto L_0x00bb
                goto L_0x0205
            L_0x00bb:
                r1 = r9
            L_0x00bc:
                boolean r9 = r3 instanceof java.io.File
                if (r9 == 0) goto L_0x0174
                W1.b r9 = r8.f19822f
                java.lang.Object r9 = r9.f19796b
                boolean r9 = r9 instanceof java.io.File
                if (r9 == 0) goto L_0x011b
                W1.b r9 = r8.f19822f
                r5 = r3
                java.io.File r5 = (java.io.File) r5
                java.lang.Object r6 = r9.f19796b
                java.io.File r6 = (java.io.File) r6
                r8.f19817a = r4
                r8.f19818b = r3
                r8.f19820d = r1
                r7 = 2
                r8.f19821e = r7
                java.lang.Object r9 = r9.z(r5, r6, r8)
                if (r9 != r0) goto L_0x0072
                goto L_0x0205
            L_0x00e6:
                r3 = r9
                java.io.File r3 = (java.io.File) r3
                w3.I0 r9 = w3.C2865c0.c()
                W1.b$d$b r6 = new W1.b$d$b
                W1.b r7 = r8.f19822f
                r6.<init>(r3, r7, r2)
                r8.f19817a = r5
                r8.f19818b = r4
                r8.f19819c = r3
                r8.f19820d = r1
                r7 = 3
                r8.f19821e = r7
                java.lang.Object r9 = w3.C2872g.g(r9, r6, r8)
                if (r9 != r0) goto L_0x0107
                goto L_0x0205
            L_0x0107:
                W1.b r9 = r8.f19822f
                boolean r9 = r9.f19798d
                if (r9 == 0) goto L_0x0118
                if (r3 == 0) goto L_0x0118
                W1.b r9 = r8.f19822f
                java.io.File r4 = (java.io.File) r4
                r9.B(r4)
            L_0x0118:
                r4 = r5
                goto L_0x0091
            L_0x011b:
                W1.b r9 = r8.f19822f
                java.lang.Object r9 = r9.f19796b
                boolean r9 = r9 instanceof androidx.documentfile.provider.DocumentFile
                if (r9 == 0) goto L_0x0091
                W1.b r9 = r8.f19822f
                r5 = r3
                java.io.File r5 = (java.io.File) r5
                java.lang.Object r6 = r9.f19796b
                androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
                r8.f19817a = r4
                r8.f19818b = r3
                r8.f19820d = r1
                r7 = 4
                r8.f19821e = r7
                java.lang.Object r9 = r9.y(r5, r6, r8)
                if (r9 != r0) goto L_0x0052
                goto L_0x0205
            L_0x0141:
                r3 = r9
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                w3.I0 r9 = w3.C2865c0.c()
                W1.b$d$c r6 = new W1.b$d$c
                W1.b r7 = r8.f19822f
                r6.<init>(r3, r7, r2)
                r8.f19817a = r5
                r8.f19818b = r4
                r8.f19819c = r3
                r8.f19820d = r1
                r7 = 5
                r8.f19821e = r7
                java.lang.Object r9 = w3.C2872g.g(r9, r6, r8)
                if (r9 != r0) goto L_0x0162
                goto L_0x0205
            L_0x0162:
                W1.b r9 = r8.f19822f
                boolean r9 = r9.f19798d
                if (r9 == 0) goto L_0x0118
                if (r3 == 0) goto L_0x0118
                W1.b r9 = r8.f19822f
                java.io.File r4 = (java.io.File) r4
                r9.B(r4)
                goto L_0x0118
            L_0x0174:
                boolean r9 = r3 instanceof androidx.documentfile.provider.DocumentFile
                if (r9 == 0) goto L_0x01e2
                W1.b r9 = r8.f19822f
                java.lang.Object r9 = r9.f19796b
                boolean r9 = r9 instanceof java.io.File
                if (r9 == 0) goto L_0x018f
                W1.b r9 = r8.f19822f
                java.lang.Object r9 = r9.f19796b
                java.io.File r9 = (java.io.File) r9
                androidx.documentfile.provider.DocumentFile r9 = androidx.documentfile.provider.DocumentFile.fromFile(r9)
                goto L_0x019c
            L_0x018f:
                W1.b r9 = r8.f19822f
                java.lang.Object r9 = r9.f19796b
                java.lang.String r5 = "null cannot be cast to non-null type androidx.documentfile.provider.DocumentFile"
                kotlin.jvm.internal.t.c(r9, r5)
                androidx.documentfile.provider.DocumentFile r9 = (androidx.documentfile.provider.DocumentFile) r9
            L_0x019c:
                W1.b r5 = r8.f19822f
                r6 = r3
                androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
                r8.f19817a = r4
                r8.f19818b = r3
                r8.f19820d = r1
                r7 = 6
                r8.f19821e = r7
                java.lang.Object r9 = r5.v(r6, r9, r8)
                if (r9 != r0) goto L_0x0032
                goto L_0x0205
            L_0x01b1:
                r3 = r9
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                w3.I0 r9 = w3.C2865c0.c()
                W1.b$d$d r6 = new W1.b$d$d
                W1.b r7 = r8.f19822f
                r6.<init>(r3, r7, r2)
                r8.f19817a = r5
                r8.f19818b = r4
                r8.f19819c = r3
                r8.f19820d = r1
                r7 = 7
                r8.f19821e = r7
                java.lang.Object r9 = w3.C2872g.g(r9, r6, r8)
                if (r9 != r0) goto L_0x01d1
                goto L_0x0205
            L_0x01d1:
                W1.b r9 = r8.f19822f
                boolean r9 = r9.f19798d
                if (r9 == 0) goto L_0x0118
                if (r3 == 0) goto L_0x0118
                androidx.documentfile.provider.DocumentFile r4 = (androidx.documentfile.provider.DocumentFile) r4
                r4.delete()
                goto L_0x0118
            L_0x01e2:
                java.lang.Exception r9 = new java.lang.Exception
                java.lang.String r0 = "Unsupported data type"
                r9.<init>(r0)
                throw r9
            L_0x01ea:
                w3.I0 r9 = w3.C2865c0.c()
                W1.b$d$e r1 = new W1.b$d$e
                W1.b r3 = r8.f19822f
                r1.<init>(r3, r2)
                r8.f19817a = r2
                r8.f19818b = r2
                r8.f19819c = r2
                r2 = 8
                r8.f19821e = r2
                java.lang.Object r9 = w3.C2872g.g(r9, r1, r8)
                if (r9 != r0) goto L_0x0206
            L_0x0205:
                return r0
            L_0x0206:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$e */
    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19838a;

        /* renamed from: b  reason: collision with root package name */
        Object f19839b;

        /* renamed from: c  reason: collision with root package name */
        int f19840c;

        /* renamed from: d  reason: collision with root package name */
        long f19841d;

        /* renamed from: e  reason: collision with root package name */
        long f19842e;

        /* renamed from: f  reason: collision with root package name */
        int f19843f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C2209b f19844g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ InputStream f19845h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ OutputStream f19846i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f19847j;

        /* renamed from: W1.b$e$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19848a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2209b f19849b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f19850c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f19851d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2209b bVar, int i5, String str, C2308e eVar) {
                super(2, eVar);
                this.f19849b = bVar;
                this.f19850c = i5;
                this.f19851d = str;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f19849b, this.f19850c, this.f19851d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19848a == 0) {
                    u.b(obj);
                    C2227d m5 = this.f19849b.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    m5.e(this.f19850c, this.f19851d, this.f19849b.f19800f, this.f19849b.f19801g);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(C2209b bVar, InputStream inputStream, OutputStream outputStream, String str, C2308e eVar) {
            super(2, eVar);
            this.f19844g = bVar;
            this.f19845h = inputStream;
            this.f19846i = outputStream;
            this.f19847j = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f19844g, this.f19845h, this.f19846i, this.f19847j, eVar);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0051 A[Catch:{ all -> 0x0024 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae A[Catch:{ all -> 0x0024 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00d9 A[SYNTHETIC, Splitter:B:33:0x00d9] */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.Object r0 = c3.C2316b.f()
                int r2 = r1.f19843f
                r3 = 1
                if (r2 == 0) goto L_0x002f
                if (r2 != r3) goto L_0x0027
                long r6 = r1.f19842e
                long r8 = r1.f19841d
                int r2 = r1.f19840c
                java.lang.Object r10 = r1.f19839b
                kotlin.jvm.internal.J r10 = (kotlin.jvm.internal.J) r10
                java.lang.Object r11 = r1.f19838a
                byte[] r11 = (byte[]) r11
                W2.u.b(r20)     // Catch:{ all -> 0x0024 }
                r12 = r8
                r17 = 0
                r8 = r6
                goto L_0x00d6
            L_0x0024:
                r0 = move-exception
                goto L_0x00e6
            L_0x0027:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x002f:
                W2.u.b(r20)
                r2 = 8192(0x2000, float:1.14794E-41)
                byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0024 }
                kotlin.jvm.internal.J r6 = new kotlin.jvm.internal.J     // Catch:{ all -> 0x0024 }
                r6.<init>()     // Catch:{ all -> 0x0024 }
                W1.b r7 = r1.f19844g     // Catch:{ all -> 0x0024 }
                int r7 = r7.f19802h     // Catch:{ all -> 0x0024 }
                r11 = r2
                r10 = r6
                r8 = 0
                r12 = 0
            L_0x0047:
                java.io.InputStream r2 = r1.f19845h     // Catch:{ all -> 0x0024 }
                int r2 = r2.read(r11)     // Catch:{ all -> 0x0024 }
                r10.f24688a = r2     // Catch:{ all -> 0x0024 }
                if (r2 <= 0) goto L_0x00d9
                java.io.OutputStream r6 = r1.f19846i     // Catch:{ all -> 0x0024 }
                r14 = 0
                r6.write(r11, r14, r2)     // Catch:{ all -> 0x0024 }
                W1.b r2 = r1.f19844g     // Catch:{ all -> 0x0024 }
                long r15 = r2.f19800f     // Catch:{ all -> 0x0024 }
                int r6 = r10.f24688a     // Catch:{ all -> 0x0024 }
                r17 = 0
                long r4 = (long) r6     // Catch:{ all -> 0x0024 }
                long r4 = r4 + r15
                r2.f19800f = r4     // Catch:{ all -> 0x0024 }
                int r2 = r10.f24688a     // Catch:{ all -> 0x0024 }
                long r4 = (long) r2     // Catch:{ all -> 0x0024 }
                long r8 = r8 + r4
                W1.b r2 = r1.f19844g     // Catch:{ all -> 0x0024 }
                long r4 = r2.f19801g     // Catch:{ all -> 0x0024 }
                int r2 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
                if (r2 <= 0) goto L_0x008e
                W1.b r2 = r1.f19844g     // Catch:{ all -> 0x0024 }
                long r4 = r2.f19800f     // Catch:{ all -> 0x0024 }
                double r4 = (double) r4     // Catch:{ all -> 0x0024 }
                r14 = 4636737291354636288(0x4059000000000000, double:100.0)
                double r4 = r4 * r14
                W1.b r2 = r1.f19844g     // Catch:{ all -> 0x0024 }
                long r14 = r2.f19801g     // Catch:{ all -> 0x0024 }
                double r14 = (double) r14     // Catch:{ all -> 0x0024 }
                double r4 = r4 / r14
                int r2 = (int) r4     // Catch:{ all -> 0x0024 }
                r4 = 100
                int r2 = q3.C2729e.e(r2, r4)     // Catch:{ all -> 0x0024 }
                goto L_0x008f
            L_0x008e:
                r2 = r14
            L_0x008f:
                int r4 = r7 + 10
                if (r2 > r4) goto L_0x00a1
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0024 }
                r6 = 1000(0x3e8, float:1.401E-42)
                long r14 = (long) r6     // Catch:{ all -> 0x0024 }
                long r14 = r14 + r12
                int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r4 <= 0) goto L_0x0047
                if (r2 <= r7) goto L_0x0047
            L_0x00a1:
                long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0024 }
                W1.b r4 = r1.f19844g     // Catch:{ all -> 0x0024 }
                r4.f19802h = r2     // Catch:{ all -> 0x0024 }
                java.lang.String r4 = r1.f19847j     // Catch:{ all -> 0x0024 }
                if (r4 == 0) goto L_0x00d6
                int r4 = r4.length()     // Catch:{ all -> 0x0024 }
                if (r4 != 0) goto L_0x00b5
                goto L_0x00d6
            L_0x00b5:
                w3.I0 r4 = w3.C2865c0.c()     // Catch:{ all -> 0x0024 }
                W1.b$e$a r5 = new W1.b$e$a     // Catch:{ all -> 0x0024 }
                W1.b r6 = r1.f19844g     // Catch:{ all -> 0x0024 }
                java.lang.String r7 = r1.f19847j     // Catch:{ all -> 0x0024 }
                r14 = 0
                r5.<init>(r6, r2, r7, r14)     // Catch:{ all -> 0x0024 }
                r1.f19838a = r11     // Catch:{ all -> 0x0024 }
                r1.f19839b = r10     // Catch:{ all -> 0x0024 }
                r1.f19840c = r2     // Catch:{ all -> 0x0024 }
                r1.f19841d = r12     // Catch:{ all -> 0x0024 }
                r1.f19842e = r8     // Catch:{ all -> 0x0024 }
                r1.f19843f = r3     // Catch:{ all -> 0x0024 }
                java.lang.Object r4 = w3.C2872g.g(r4, r5, r1)     // Catch:{ all -> 0x0024 }
                if (r4 != r0) goto L_0x00d6
                return r0
            L_0x00d6:
                r7 = r2
                goto L_0x0047
            L_0x00d9:
                java.io.InputStream r0 = r1.f19845h     // Catch:{ Exception -> 0x00de }
                r0.close()     // Catch:{ Exception -> 0x00de }
            L_0x00de:
                java.io.OutputStream r0 = r1.f19846i     // Catch:{ Exception -> 0x00e3 }
                r0.close()     // Catch:{ Exception -> 0x00e3 }
            L_0x00e3:
                W2.J r0 = W2.J.f19942a
                return r0
            L_0x00e6:
                java.io.InputStream r2 = r1.f19845h     // Catch:{ Exception -> 0x00eb }
                r2.close()     // Catch:{ Exception -> 0x00eb }
            L_0x00eb:
                java.io.OutputStream r2 = r1.f19846i     // Catch:{ Exception -> 0x00f0 }
                r2.close()     // Catch:{ Exception -> 0x00f0 }
            L_0x00f0:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$f */
    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19852a;

        /* renamed from: b  reason: collision with root package name */
        Object f19853b;

        /* renamed from: c  reason: collision with root package name */
        Object f19854c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f19855d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C2209b f19856e;

        /* renamed from: f  reason: collision with root package name */
        int f19857f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(C2209b bVar, C2308e eVar) {
            super(eVar);
            this.f19856e = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19855d = obj;
            this.f19857f |= Integer.MIN_VALUE;
            return this.f19856e.z((File) null, (File) null, this);
        }
    }

    /* renamed from: W1.b$g */
    static final class g extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19858a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19859b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(C2209b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19859b = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f19859b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19858a == 0) {
                u.b(obj);
                C2227d m5 = this.f19859b.f19797c;
                if (m5 == null) {
                    return null;
                }
                m5.g();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$h */
    static final class h extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19860a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19861b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f19862c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C2209b bVar, File file, C2308e eVar) {
            super(2, eVar);
            this.f19861b = bVar;
            this.f19862c = file;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f19861b, this.f19862c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19860a == 0) {
                u.b(obj);
                C2227d m5 = this.f19861b.f19797c;
                if (m5 == null) {
                    return null;
                }
                m5.f(this.f19862c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$i */
    static final class i extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19864b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f19865c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(C2209b bVar, File file, C2308e eVar) {
            super(2, eVar);
            this.f19864b = bVar;
            this.f19865c = file;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f19864b, this.f19865c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19863a == 0) {
                u.b(obj);
                C2227d m5 = this.f19864b.f19797c;
                if (m5 == null) {
                    return null;
                }
                m5.c(this.f19865c);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$j */
    static final class j extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19866a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19867b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f19868c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(C2209b bVar, L l5, C2308e eVar) {
            super(2, eVar);
            this.f19867b = bVar;
            this.f19868c = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f19867b, this.f19868c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19866a == 0) {
                u.b(obj);
                C2227d m5 = this.f19867b.f19797c;
                if (m5 == null) {
                    return null;
                }
                m5.f((File) this.f19868c.f24690a);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$k */
    static final class k extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19869a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19870b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f19871c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(C2209b bVar, L l5, C2308e eVar) {
            super(2, eVar);
            this.f19870b = bVar;
            this.f19871c = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f19870b, this.f19871c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19869a == 0) {
                u.b(obj);
                C2227d m5 = this.f19870b.f19797c;
                if (m5 == null) {
                    return null;
                }
                m5.c((File) this.f19871c.f24690a);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$l */
    static final class l extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19872a;

        /* renamed from: b  reason: collision with root package name */
        Object f19873b;

        /* renamed from: c  reason: collision with root package name */
        Object f19874c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f19875d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C2209b f19876e;

        /* renamed from: f  reason: collision with root package name */
        int f19877f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(C2209b bVar, C2308e eVar) {
            super(eVar);
            this.f19876e = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19875d = obj;
            this.f19877f |= Integer.MIN_VALUE;
            return this.f19876e.y((File) null, (DocumentFile) null, this);
        }
    }

    /* renamed from: W1.b$m */
    static final class m extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19878a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f19879b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(C2209b bVar, C2308e eVar) {
            super(2, eVar);
            this.f19879b = bVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new m(this.f19879b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f19878a == 0) {
                u.b(obj);
                C2227d m5 = this.f19879b.f19797c;
                if (m5 == null) {
                    return null;
                }
                m5.g();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((m) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: W1.b$n */
    static final class n extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19880a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f19881b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2209b f19882c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DocumentFile f19883d;

        /* renamed from: W1.b$n$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19884a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2209b f19885b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f19886c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2209b bVar, File file, C2308e eVar) {
                super(2, eVar);
                this.f19885b = bVar;
                this.f19886c = file;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f19885b, this.f19886c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19884a == 0) {
                    u.b(obj);
                    C2227d m5 = this.f19885b.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    m5.f(this.f19886c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$n$b  reason: collision with other inner class name */
        static final class C0188b extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19887a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2209b f19888b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f19889c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0188b(C2209b bVar, File file, C2308e eVar) {
                super(2, eVar);
                this.f19888b = bVar;
                this.f19889c = file;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0188b(this.f19888b, this.f19889c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19887a == 0) {
                    u.b(obj);
                    C2227d m5 = this.f19888b.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    m5.c(this.f19889c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0188b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$n$c */
        static final class c extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19890a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2209b f19891b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DocumentFile f19892c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2209b bVar, DocumentFile documentFile, C2308e eVar) {
                super(2, eVar);
                this.f19891b = bVar;
                this.f19892c = documentFile;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f19891b, this.f19892c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19890a == 0) {
                    u.b(obj);
                    C2227d m5 = this.f19891b.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    DocumentFile documentFile = this.f19892c;
                    t.b(documentFile);
                    m5.d(documentFile);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: W1.b$n$d */
        static final class d extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19893a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2209b f19894b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DocumentFile f19895c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C2209b bVar, DocumentFile documentFile, C2308e eVar) {
                super(2, eVar);
                this.f19894b = bVar;
                this.f19895c = documentFile;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new d(this.f19894b, this.f19895c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f19893a == 0) {
                    u.b(obj);
                    C2227d m5 = this.f19894b.f19797c;
                    if (m5 == null) {
                        return null;
                    }
                    DocumentFile documentFile = this.f19895c;
                    t.b(documentFile);
                    m5.a(documentFile);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(File file, C2209b bVar, DocumentFile documentFile, C2308e eVar) {
            super(2, eVar);
            this.f19881b = file;
            this.f19882c = bVar;
            this.f19883d = documentFile;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new n(this.f19881b, this.f19882c, this.f19883d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
            if (W1.C2209b.d(r7, r8, r9, r10, r11, r14) == r0) goto L_0x00e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
            if (w3.C2872g.g(r1, r2, r14) != r0) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cc, code lost:
            if (w3.C2872g.g(r1, r2, r14) != r0) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e5, code lost:
            if (w3.C2872g.g(r1, r2, r14) != r0) goto L_0x00e8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r14.f19880a
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x003b
                if (r1 == r6) goto L_0x0035
                if (r1 == r5) goto L_0x002f
                if (r1 == r4) goto L_0x0029
                if (r1 == r3) goto L_0x0025
                if (r1 != r2) goto L_0x001d
                W2.u.b(r15)
                r13 = r14
                goto L_0x0099
            L_0x001d:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0025:
                W2.u.b(r15)
                goto L_0x007e
            L_0x0029:
                W2.u.b(r15)
                r13 = r14
                goto L_0x00b2
            L_0x002f:
                W2.u.b(r15)
                r13 = r14
                goto L_0x00cf
            L_0x0035:
                W2.u.b(r15)
                r13 = r14
                goto L_0x00e8
            L_0x003b:
                W2.u.b(r15)
                r15 = 0
                java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00b7, SecurityException -> 0x00b5 }
                java.io.File r1 = r14.f19881b     // Catch:{ FileNotFoundException -> 0x00b7, SecurityException -> 0x00b5 }
                r8.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00b7, SecurityException -> 0x00b5 }
                W1.b r1 = r14.f19882c     // Catch:{ FileNotFoundException -> 0x0061 }
                android.content.Context r1 = r1.f19799e     // Catch:{ FileNotFoundException -> 0x0061 }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0061 }
                if (r1 == 0) goto L_0x0063
                androidx.documentfile.provider.DocumentFile r5 = r14.f19883d     // Catch:{ FileNotFoundException -> 0x0061 }
                kotlin.jvm.internal.t.b(r5)     // Catch:{ FileNotFoundException -> 0x0061 }
                android.net.Uri r5 = r5.getUri()     // Catch:{ FileNotFoundException -> 0x0061 }
                java.io.OutputStream r1 = r1.openOutputStream(r5)     // Catch:{ FileNotFoundException -> 0x0061 }
                r9 = r1
                goto L_0x0064
            L_0x0061:
                r13 = r14
                goto L_0x009c
            L_0x0063:
                r9 = r15
            L_0x0064:
                if (r9 != 0) goto L_0x0081
                w3.I0 r1 = w3.C2865c0.c()
                W1.b$n$d r2 = new W1.b$n$d
                W1.b r4 = r14.f19882c
                androidx.documentfile.provider.DocumentFile r5 = r14.f19883d
                r2.<init>(r4, r5, r15)
                r14.f19880a = r3
                java.lang.Object r15 = w3.C2872g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x007e
                r13 = r14
                goto L_0x00e7
            L_0x007e:
                W2.J r15 = W2.J.f19942a
                return r15
            L_0x0081:
                W1.b r7 = r14.f19882c
                java.io.File r15 = r14.f19881b
                java.lang.String r10 = r15.getName()
                java.io.File r15 = r14.f19881b
                long r11 = r15.length()
                r14.f19880a = r2
                r13 = r14
                java.lang.Object r15 = r7.x(r8, r9, r10, r11, r13)
                if (r15 != r0) goto L_0x0099
                goto L_0x00e7
            L_0x0099:
                W2.J r15 = W2.J.f19942a
                return r15
            L_0x009c:
                w3.I0 r1 = w3.C2865c0.c()
                W1.b$n$c r2 = new W1.b$n$c
                W1.b r3 = r13.f19882c
                androidx.documentfile.provider.DocumentFile r5 = r13.f19883d
                r2.<init>(r3, r5, r15)
                r13.f19880a = r4
                java.lang.Object r15 = w3.C2872g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x00b2
                goto L_0x00e7
            L_0x00b2:
                W2.J r15 = W2.J.f19942a
                return r15
            L_0x00b5:
                r13 = r14
                goto L_0x00b9
            L_0x00b7:
                r13 = r14
                goto L_0x00d2
            L_0x00b9:
                w3.I0 r1 = w3.C2865c0.c()
                W1.b$n$b r2 = new W1.b$n$b
                W1.b r3 = r13.f19882c
                java.io.File r4 = r13.f19881b
                r2.<init>(r3, r4, r15)
                r13.f19880a = r5
                java.lang.Object r15 = w3.C2872g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x00cf
                goto L_0x00e7
            L_0x00cf:
                W2.J r15 = W2.J.f19942a
                return r15
            L_0x00d2:
                w3.I0 r1 = w3.C2865c0.c()
                W1.b$n$a r2 = new W1.b$n$a
                W1.b r3 = r13.f19882c
                java.io.File r4 = r13.f19881b
                r2.<init>(r3, r4, r15)
                r13.f19880a = r6
                java.lang.Object r15 = w3.C2872g.g(r1, r2, r14)
                if (r15 != r0) goto L_0x00e8
            L_0x00e7:
                return r0
            L_0x00e8:
                W2.J r15 = W2.J.f19942a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((n) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2209b(ArrayList arrayList, Object obj, C2227d dVar, boolean z4, Context context) {
        t.e(arrayList, "itemsToCopy");
        t.e(obj, "targetDir");
        t.e(context, "context");
        this.f19795a = arrayList;
        this.f19796b = obj;
        this.f19797c = dVar;
        this.f19798d = z4;
        this.f19799e = context;
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this, (C2308e) null), 3, (Object) null);
    }

    private final DocumentFile A(DocumentFile documentFile, DocumentFile documentFile2) {
        if (documentFile.isDirectory()) {
            throw new Exception("Trying copying a directory into a file");
        } else if (documentFile.getName() == null) {
            throw new Exception("Source name unknown");
        } else if (documentFile.getType() != null) {
            String type = documentFile.getType();
            t.b(type);
            String name = documentFile.getName();
            t.b(name);
            String name2 = documentFile.getName();
            t.b(name2);
            if (s.D(name2, ".xapk", false, 2, (Object) null)) {
                type = "application/vnd.android.package-archive";
            } else if (s.V(name, ".", false, 2, (Object) null)) {
                name = name.substring(0, s.l0(name, ".", 0, false, 6, (Object) null));
                t.d(name, "substring(...)");
            }
            return documentFile2.createFile(type, name);
        } else {
            throw new Exception("Source mimetype unknown");
        }
    }

    /* access modifiers changed from: private */
    public final void B(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            Iterator a5 = C2625c.a(listFiles);
            while (a5.hasNext()) {
                File file2 = (File) a5.next();
                t.b(file2);
                B(file2);
            }
        }
        file.delete();
    }

    /* access modifiers changed from: private */
    public final long C(DocumentFile documentFile) {
        if (documentFile.isFile()) {
            return documentFile.length();
        }
        long j5 = 0;
        if (documentFile.isDirectory()) {
            DocumentFile[] listFiles = documentFile.listFiles();
            t.d(listFiles, "listFiles(...)");
            for (DocumentFile documentFile2 : listFiles) {
                t.b(documentFile2);
                j5 += C(documentFile2);
            }
        }
        return j5;
    }

    /* access modifiers changed from: private */
    public final long D(File file) {
        File[] listFiles;
        if (file.isFile()) {
            return file.length();
        }
        long j5 = 0;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            Iterator a5 = C2625c.a(listFiles);
            while (a5.hasNext()) {
                File file2 = (File) a5.next();
                t.b(file2);
                j5 += D(file2);
            }
        }
        return j5;
    }

    private final Object E(File file, DocumentFile documentFile, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new n(file, this, documentFile, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object u(C2308e eVar) {
        return C2872g.g(C2865c0.b(), new C0185b(this, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(androidx.documentfile.provider.DocumentFile r12, androidx.documentfile.provider.DocumentFile r13, b3.C2308e r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof W1.C2209b.c
            if (r0 == 0) goto L_0x0013
            r0 = r14
            W1.b$c r0 = (W1.C2209b.c) r0
            int r1 = r0.f19816i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19816i = r1
            goto L_0x0018
        L_0x0013:
            W1.b$c r0 = new W1.b$c
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f19814g
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f19816i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r12 = r0.f19808a
            androidx.documentfile.provider.DocumentFile r12 = (androidx.documentfile.provider.DocumentFile) r12
            W2.u.b(r14)
            return r12
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0038:
            int r12 = r0.f19813f
            int r13 = r0.f19812e
            java.lang.Object r2 = r0.f19811d
            androidx.documentfile.provider.DocumentFile[] r2 = (androidx.documentfile.provider.DocumentFile[]) r2
            java.lang.Object r5 = r0.f19810c
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            java.lang.Object r6 = r0.f19809b
            androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
            java.lang.Object r7 = r0.f19808a
            W1.b r7 = (W1.C2209b) r7
            W2.u.b(r14)
            r14 = r5
            goto L_0x00ba
        L_0x0052:
            W2.u.b(r14)
            boolean r14 = r13.isFile()
            if (r14 == 0) goto L_0x006b
            androidx.documentfile.provider.DocumentFile r14 = r13.getParentFile()
            if (r14 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r13 = r14
        L_0x0063:
            androidx.documentfile.provider.DocumentFile r13 = r11.A(r12, r13)
        L_0x0067:
            r4 = r11
            r10 = r0
            goto L_0x00d6
        L_0x006b:
            boolean r14 = r13.isDirectory()
            if (r14 == 0) goto L_0x0067
            boolean r14 = r12.isDirectory()
            if (r14 == 0) goto L_0x00cb
            java.lang.String r14 = r12.getName()
            if (r14 == 0) goto L_0x00c3
            java.lang.String r14 = r12.getName()
            kotlin.jvm.internal.t.b(r14)
            androidx.documentfile.provider.DocumentFile r13 = r13.createDirectory(r14)
            if (r13 == 0) goto L_0x0067
            androidx.documentfile.provider.DocumentFile[] r14 = r12.listFiles()
            java.lang.String r2 = "listFiles(...)"
            kotlin.jvm.internal.t.d(r14, r2)
            int r2 = r14.length
            r5 = 0
            r7 = r13
            r13 = r12
            r12 = r2
            r2 = r14
            r14 = r7
            r7 = r11
        L_0x009b:
            if (r5 >= r12) goto L_0x00be
            r6 = r2[r5]
            kotlin.jvm.internal.t.b(r6)
            r0.f19808a = r7
            r0.f19809b = r13
            r0.f19810c = r14
            r0.f19811d = r2
            r0.f19812e = r5
            r0.f19813f = r12
            r0.f19816i = r4
            java.lang.Object r6 = r7.v(r6, r14, r0)
            if (r6 != r1) goto L_0x00b8
            goto L_0x011b
        L_0x00b8:
            r6 = r13
            r13 = r5
        L_0x00ba:
            int r5 = r13 + 1
            r13 = r6
            goto L_0x009b
        L_0x00be:
            r12 = r13
            r13 = r14
            r10 = r0
            r4 = r7
            goto L_0x00d6
        L_0x00c3:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "Source name unknown"
            r12.<init>(r13)
            throw r12
        L_0x00cb:
            boolean r14 = r12.isFile()
            if (r14 == 0) goto L_0x0067
            androidx.documentfile.provider.DocumentFile r13 = r11.A(r12, r13)
            goto L_0x0067
        L_0x00d6:
            if (r13 == 0) goto L_0x012d
            boolean r14 = r13.isFile()
            if (r14 == 0) goto L_0x012d
            android.content.Context r14 = r4.f19799e
            android.content.ContentResolver r14 = r14.getContentResolver()
            if (r14 == 0) goto L_0x0125
            android.net.Uri r0 = r12.getUri()
            java.io.InputStream r5 = r14.openInputStream(r0)
            if (r5 == 0) goto L_0x0125
            android.content.Context r14 = r4.f19799e
            android.content.ContentResolver r14 = r14.getContentResolver()
            if (r14 == 0) goto L_0x011d
            android.net.Uri r0 = r13.getUri()
            java.io.OutputStream r6 = r14.openOutputStream(r0)
            if (r6 == 0) goto L_0x011d
            java.lang.String r7 = r12.getName()
            long r8 = r12.length()
            r10.f19808a = r13
            r12 = 0
            r10.f19809b = r12
            r10.f19810c = r12
            r10.f19811d = r12
            r10.f19816i = r3
            java.lang.Object r12 = r4.x(r5, r6, r7, r8, r10)
            if (r12 != r1) goto L_0x011c
        L_0x011b:
            return r1
        L_0x011c:
            return r13
        L_0x011d:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "Cannot open output stream"
            r12.<init>(r13)
            throw r12
        L_0x0125:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "Cannot open input stream"
            r12.<init>(r13)
            throw r12
        L_0x012d:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.v(androidx.documentfile.provider.DocumentFile, androidx.documentfile.provider.DocumentFile, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object w(C2308e eVar) {
        return C2872g.g(C2865c0.b(), new d(this, (C2308e) null), eVar);
    }

    /* access modifiers changed from: private */
    public final Object x(InputStream inputStream, OutputStream outputStream, String str, long j5, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new e(this, inputStream, outputStream, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0146 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(java.io.File r19, androidx.documentfile.provider.DocumentFile r20, b3.C2308e r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof W1.C2209b.l
            if (r4 == 0) goto L_0x001b
            r4 = r3
            W1.b$l r4 = (W1.C2209b.l) r4
            int r5 = r4.f19877f
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f19877f = r5
            goto L_0x0020
        L_0x001b:
            W1.b$l r4 = new W1.b$l
            r4.<init>(r0, r3)
        L_0x0020:
            java.lang.Object r3 = r4.f19875d
            java.lang.Object r5 = c3.C2316b.f()
            int r6 = r4.f19877f
            r7 = 4
            r8 = 3
            r9 = 0
            r10 = 2
            r11 = 1
            if (r6 == 0) goto L_0x005c
            if (r6 == r11) goto L_0x0058
            if (r6 == r10) goto L_0x0050
            if (r6 == r8) goto L_0x0050
            if (r6 != r7) goto L_0x0048
            java.lang.Object r1 = r4.f19874c
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r4.f19873b
            androidx.documentfile.provider.DocumentFile r2 = (androidx.documentfile.provider.DocumentFile) r2
            java.lang.Object r6 = r4.f19872a
            W1.b r6 = (W1.C2209b) r6
            W2.u.b(r3)
            goto L_0x0129
        L_0x0048:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0050:
            java.lang.Object r1 = r4.f19872a
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            W2.u.b(r3)
            return r1
        L_0x0058:
            W2.u.b(r3)
            goto L_0x0085
        L_0x005c:
            W2.u.b(r3)
            b2.j r3 = new b2.j
            r3.<init>()
            android.content.Context r6 = r0.f19799e
            long r12 = r3.l(r6, r2)
            long r14 = r18.D(r19)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x0086
            w3.I0 r1 = w3.C2865c0.c()
            W1.b$m r2 = new W1.b$m
            r2.<init>(r0, r9)
            r4.f19877f = r11
            java.lang.Object r1 = w3.C2872g.g(r1, r2, r4)
            if (r1 != r5) goto L_0x0085
            goto L_0x0146
        L_0x0085:
            return r9
        L_0x0086:
            boolean r3 = r1.isFile()
            if (r3 == 0) goto L_0x0108
            boolean r3 = r2.isDirectory()
            if (r3 == 0) goto L_0x00db
            java.lang.String r3 = r1.getName()
            java.lang.String r6 = "getName(...)"
            kotlin.jvm.internal.t.d(r3, r6)
            java.lang.String r7 = "."
            r12 = 0
            boolean r3 = t3.s.V(r3, r7, r12, r10, r9)
            if (r3 == 0) goto L_0x00c9
            java.lang.String r3 = r1.getName()
            kotlin.jvm.internal.t.d(r3, r6)
            java.lang.String r12 = r1.getName()
            kotlin.jvm.internal.t.d(r12, r6)
            r16 = 6
            r17 = 0
            java.lang.String r13 = "."
            r14 = 0
            r15 = 0
            int r6 = t3.s.l0(r12, r13, r14, r15, r16, r17)
            int r6 = r6 + r11
            java.lang.String r3 = r3.substring(r6)
            java.lang.String r6 = "substring(...)"
            kotlin.jvm.internal.t.d(r3, r6)
            goto L_0x00cb
        L_0x00c9:
            java.lang.String r3 = ""
        L_0x00cb:
            int r6 = r3.length()
            if (r6 != 0) goto L_0x00d3
            java.lang.String r3 = "*/*"
        L_0x00d3:
            java.lang.String r6 = r1.getName()
            androidx.documentfile.provider.DocumentFile r2 = r2.createFile(r3, r6)
        L_0x00db:
            if (r2 == 0) goto L_0x0100
            boolean r3 = r2.isFile()
            if (r3 == 0) goto L_0x00f4
            boolean r3 = r2.exists()
            if (r3 == 0) goto L_0x00f4
            r4.f19872a = r2
            r4.f19877f = r10
            java.lang.Object r1 = r0.E(r1, r2, r4)
            if (r1 != r5) goto L_0x00ff
            goto L_0x0146
        L_0x00f4:
            r4.f19872a = r2
            r4.f19877f = r8
            java.lang.Object r1 = r0.E(r1, r2, r4)
            if (r1 != r5) goto L_0x00ff
            goto L_0x0146
        L_0x00ff:
            return r2
        L_0x0100:
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r2 = "Target is null"
            r1.<init>(r2)
            throw r1
        L_0x0108:
            boolean r3 = r1.isDirectory()
            if (r3 == 0) goto L_0x016b
            boolean r3 = r2.isDirectory()
            if (r3 == 0) goto L_0x0163
            java.lang.String r3 = r1.getName()
            androidx.documentfile.provider.DocumentFile r2 = r2.createDirectory(r3)
            if (r2 == 0) goto L_0x0148
            java.io.File[] r1 = r1.listFiles()
            if (r1 == 0) goto L_0x0147
            java.util.Iterator r1 = kotlin.jvm.internal.C2625c.a(r1)
            r6 = r0
        L_0x0129:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0147
            java.lang.Object r3 = r1.next()
            java.io.File r3 = (java.io.File) r3
            kotlin.jvm.internal.t.b(r3)
            r4.f19872a = r6
            r4.f19873b = r2
            r4.f19874c = r1
            r4.f19877f = r7
            java.lang.Object r3 = r6.y(r3, r2, r4)
            if (r3 != r5) goto L_0x0129
        L_0x0146:
            return r5
        L_0x0147:
            return r2
        L_0x0148:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cannot create Directory "
            r3.append(r4)
            java.lang.String r1 = r1.getName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0163:
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r2 = "Cannot copy a directory into a file"
            r1.<init>(r2)
            throw r1
        L_0x016b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.y(java.io.File, androidx.documentfile.provider.DocumentFile, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012e, code lost:
        r11 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0201, code lost:
        if (r9.hasNext() == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0203, code lost:
        r11 = (java.io.File) r9.next();
        kotlin.jvm.internal.t.b(r11);
        r7.f19852a = r1;
        r7.f19853b = r10;
        r7.f19854c = r9;
        r7.f19857f = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x021d, code lost:
        if (r1.z(r11, (java.io.File) r10.f24690a, r7) != r0) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0220, code lost:
        r11 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0234, code lost:
        return r11.f24690a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x021f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(java.io.File r9, java.io.File r10, b3.C2308e r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof W1.C2209b.f
            if (r0 == 0) goto L_0x0014
            r0 = r11
            W1.b$f r0 = (W1.C2209b.f) r0
            int r1 = r0.f19857f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.f19857f = r1
        L_0x0012:
            r7 = r0
            goto L_0x001a
        L_0x0014:
            W1.b$f r0 = new W1.b$f
            r0.<init>(r8, r11)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r11 = r7.f19855d
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r7.f19857f
            r2 = 0
            switch(r1) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0066;
                case 2: goto L_0x005f;
                case 3: goto L_0x0058;
                case 4: goto L_0x0051;
                case 5: goto L_0x004a;
                case 6: goto L_0x0040;
                case 7: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002e:
            java.lang.Object r9 = r7.f19854c
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r7.f19853b
            kotlin.jvm.internal.L r10 = (kotlin.jvm.internal.L) r10
            java.lang.Object r1 = r7.f19852a
            W1.b r1 = (W1.C2209b) r1
            W2.u.b(r11)
            r2 = r8
            goto L_0x01fd
        L_0x0040:
            java.lang.Object r9 = r7.f19852a
            kotlin.jvm.internal.L r9 = (kotlin.jvm.internal.L) r9
            W2.u.b(r11)
            r2 = r8
            goto L_0x012e
        L_0x004a:
            W2.u.b(r11)
            r1 = r2
            r2 = r8
            goto L_0x0149
        L_0x0051:
            W2.u.b(r11)
            r1 = r2
            r2 = r8
            goto L_0x015e
        L_0x0058:
            W2.u.b(r11)
            r1 = r2
            r2 = r8
            goto L_0x0177
        L_0x005f:
            W2.u.b(r11)
            r1 = r2
            r2 = r8
            goto L_0x018b
        L_0x0066:
            W2.u.b(r11)
            goto L_0x0095
        L_0x006a:
            W2.u.b(r11)
            kotlin.jvm.internal.L r11 = new kotlin.jvm.internal.L
            r11.<init>()
            r11.f24690a = r10
            long r3 = r10.getUsableSpace()
            long r5 = r8.D(r9)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0096
            w3.I0 r9 = w3.C2865c0.c()
            W1.b$g r10 = new W1.b$g
            r10.<init>(r8, r2)
            r11 = 1
            r7.f19857f = r11
            java.lang.Object r9 = w3.C2872g.g(r9, r10, r7)
            if (r9 != r0) goto L_0x0095
            r2 = r8
            goto L_0x021f
        L_0x0095:
            return r2
        L_0x0096:
            boolean r1 = r9.isFile()
            r3 = 2
            r4 = 47
            if (r1 == 0) goto L_0x018c
            boolean r1 = r10.isDirectory()
            if (r1 == 0) goto L_0x00c6
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = r10.getAbsolutePath()
            r5.append(r10)
            r5.append(r4)
            java.lang.String r10 = r9.getName()
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r1.<init>(r10)
            r11.f24690a = r1
        L_0x00c6:
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            boolean r10 = r10.exists()
            if (r10 == 0) goto L_0x00ef
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            boolean r10 = r10.isFile()
            if (r10 == 0) goto L_0x00ef
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            java.lang.String r10 = r10.getAbsolutePath()
            java.lang.String r1 = r9.getAbsolutePath()
            boolean r10 = kotlin.jvm.internal.t.a(r10, r1)
            if (r10 == 0) goto L_0x00ef
            java.lang.Object r9 = r11.f24690a
            return r9
        L_0x00ef:
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            boolean r10 = r10.exists()
            if (r10 == 0) goto L_0x0103
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            boolean r10 = r10.isFile()
            if (r10 != 0) goto L_0x0105
        L_0x0103:
            r1 = r2
            goto L_0x0108
        L_0x0105:
            r2 = r8
            goto L_0x0232
        L_0x0108:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0161, SecurityException -> 0x015f }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0161, SecurityException -> 0x015f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0133, SecurityException -> 0x0131 }
            java.lang.Object r10 = r11.f24690a     // Catch:{ FileNotFoundException -> 0x0133, SecurityException -> 0x0131 }
            java.io.File r10 = (java.io.File) r10     // Catch:{ FileNotFoundException -> 0x0133, SecurityException -> 0x0131 }
            r3.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0133, SecurityException -> 0x0131 }
            java.lang.String r4 = r9.getName()
            long r5 = r9.length()
            r7.f19852a = r11
            r9 = 6
            r7.f19857f = r9
            r1 = r8
            java.lang.Object r9 = r1.x(r2, r3, r4, r5, r7)
            r2 = r1
            if (r9 != r0) goto L_0x012d
            goto L_0x021f
        L_0x012d:
            r9 = r11
        L_0x012e:
            r11 = r9
            goto L_0x0232
        L_0x0131:
            r2 = r8
            goto L_0x0135
        L_0x0133:
            r2 = r8
            goto L_0x014a
        L_0x0135:
            w3.I0 r9 = w3.C2865c0.c()
            W1.b$k r10 = new W1.b$k
            r10.<init>(r8, r11, r1)
            r11 = 5
            r7.f19857f = r11
            java.lang.Object r9 = w3.C2872g.g(r9, r10, r7)
            if (r9 != r0) goto L_0x0149
            goto L_0x021f
        L_0x0149:
            return r1
        L_0x014a:
            w3.I0 r9 = w3.C2865c0.c()
            W1.b$j r10 = new W1.b$j
            r10.<init>(r8, r11, r1)
            r11 = 4
            r7.f19857f = r11
            java.lang.Object r9 = w3.C2872g.g(r9, r10, r7)
            if (r9 != r0) goto L_0x015e
            goto L_0x021f
        L_0x015e:
            return r1
        L_0x015f:
            r2 = r8
            goto L_0x0163
        L_0x0161:
            r2 = r8
            goto L_0x0178
        L_0x0163:
            w3.I0 r10 = w3.C2865c0.c()
            W1.b$i r11 = new W1.b$i
            r11.<init>(r8, r9, r1)
            r9 = 3
            r7.f19857f = r9
            java.lang.Object r9 = w3.C2872g.g(r10, r11, r7)
            if (r9 != r0) goto L_0x0177
            goto L_0x021f
        L_0x0177:
            return r1
        L_0x0178:
            w3.I0 r10 = w3.C2865c0.c()
            W1.b$h r11 = new W1.b$h
            r11.<init>(r8, r9, r1)
            r7.f19857f = r3
            java.lang.Object r9 = w3.C2872g.g(r10, r11, r7)
            if (r9 != r0) goto L_0x018b
            goto L_0x021f
        L_0x018b:
            return r1
        L_0x018c:
            r1 = r2
            r2 = r8
            boolean r5 = r9.isDirectory()
            if (r5 == 0) goto L_0x0232
            boolean r5 = r10.isDirectory()
            if (r5 == 0) goto L_0x022a
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = r10.getAbsolutePath()
            r6.append(r10)
            r6.append(r4)
            java.lang.String r10 = r9.getName()
            r6.append(r10)
            java.lang.String r10 = r6.toString()
            r5.<init>(r10)
            r11.f24690a = r5
            java.lang.String r10 = r5.getAbsolutePath()
            java.lang.String r4 = "getAbsolutePath(...)"
            kotlin.jvm.internal.t.d(r10, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r9.getAbsolutePath()
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            boolean r10 = t3.s.P(r10, r4, r5, r3, r1)
            if (r10 != 0) goto L_0x0222
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            boolean r10 = r10.exists()
            if (r10 != 0) goto L_0x01f1
            java.lang.Object r10 = r11.f24690a
            java.io.File r10 = (java.io.File) r10
            r10.mkdir()
        L_0x01f1:
            java.io.File[] r9 = r9.listFiles()
            if (r9 == 0) goto L_0x0232
            java.util.Iterator r9 = kotlin.jvm.internal.C2625c.a(r9)
            r10 = r11
            r1 = r2
        L_0x01fd:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0220
            java.lang.Object r11 = r9.next()
            java.io.File r11 = (java.io.File) r11
            kotlin.jvm.internal.t.b(r11)
            java.lang.Object r3 = r10.f24690a
            java.io.File r3 = (java.io.File) r3
            r7.f19852a = r1
            r7.f19853b = r10
            r7.f19854c = r9
            r4 = 7
            r7.f19857f = r4
            java.lang.Object r11 = r1.z(r11, r3, r7)
            if (r11 != r0) goto L_0x01fd
        L_0x021f:
            return r0
        L_0x0220:
            r11 = r10
            goto L_0x0232
        L_0x0222:
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "Cannot copy a directory into itself"
            r9.<init>(r10)
            throw r9
        L_0x022a:
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "Cannot copy a directory into a file"
            r9.<init>(r10)
            throw r9
        L_0x0232:
            java.lang.Object r9 = r11.f24690a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C2209b.z(java.io.File, java.io.File, b3.e):java.lang.Object");
    }
}
