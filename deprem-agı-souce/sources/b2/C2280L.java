package b2;

import W2.J;
import W2.u;
import X1.C2226c;
import X1.C2228e;
import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import b3.C2308e;
import c3.C2316b;
import java.io.File;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

/* renamed from: b2.L  reason: case insensitive filesystem */
public final class C2280L {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f20536a = new byte[4096];
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f20537b;

    /* renamed from: b2.L$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20538a;

        /* renamed from: b  reason: collision with root package name */
        int f20539b;

        /* renamed from: c  reason: collision with root package name */
        int f20540c;

        /* renamed from: d  reason: collision with root package name */
        int f20541d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20542e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ZipOutputStream f20543f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Context f20544g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C2280L f20545h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(DocumentFile documentFile, ZipOutputStream zipOutputStream, Context context, C2280L l5, C2308e eVar) {
            super(2, eVar);
            this.f20542e = documentFile;
            this.f20543f = zipOutputStream;
            this.f20544g = context;
            this.f20545h = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f20542e, this.f20543f, this.f20544g, this.f20545h, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r8.f20541d
                r2 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                int r1 = r8.f20540c
                int r3 = r8.f20539b
                java.lang.Object r4 = r8.f20538a
                androidx.documentfile.provider.DocumentFile[] r4 = (androidx.documentfile.provider.DocumentFile[]) r4
                W2.u.b(r9)
                goto L_0x00b0
            L_0x0018:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0020:
                W2.u.b(r9)
                androidx.documentfile.provider.DocumentFile r9 = r8.f20542e
                boolean r9 = r9.isFile()
                r1 = 0
                if (r9 == 0) goto L_0x007c
                java.util.zip.ZipEntry r9 = new java.util.zip.ZipEntry
                androidx.documentfile.provider.DocumentFile r0 = r8.f20542e
                java.lang.String r0 = r0.getName()
                r9.<init>(r0)
                java.util.zip.ZipOutputStream r0 = r8.f20543f
                r0.putNextEntry(r9)
                android.content.Context r9 = r8.f20544g
                android.content.ContentResolver r9 = r9.getContentResolver()
                r0 = 0
                if (r9 == 0) goto L_0x0050
                androidx.documentfile.provider.DocumentFile r2 = r8.f20542e
                android.net.Uri r2 = r2.getUri()
                java.io.InputStream r9 = r9.openInputStream(r2)
                goto L_0x0051
            L_0x0050:
                r9 = r0
            L_0x0051:
                b2.L r2 = r8.f20545h
                java.util.zip.ZipOutputStream r3 = r8.f20543f
                if (r9 == 0) goto L_0x006b
            L_0x0057:
                byte[] r4 = r2.f20536a     // Catch:{ all -> 0x0069 }
                int r4 = r9.read(r4)     // Catch:{ all -> 0x0069 }
                if (r4 <= 0) goto L_0x006b
                byte[] r5 = r2.f20536a     // Catch:{ all -> 0x0069 }
                r3.write(r5, r1, r4)     // Catch:{ all -> 0x0069 }
                goto L_0x0057
            L_0x0069:
                r0 = move-exception
                goto L_0x0076
            L_0x006b:
                W2.J r1 = W2.J.f19942a     // Catch:{ all -> 0x0069 }
                h3.C2453b.a(r9, r0)
                java.util.zip.ZipOutputStream r9 = r8.f20543f
                r9.closeEntry()
                goto L_0x00b2
            L_0x0076:
                throw r0     // Catch:{ all -> 0x0077 }
            L_0x0077:
                r1 = move-exception
                h3.C2453b.a(r9, r0)
                throw r1
            L_0x007c:
                androidx.documentfile.provider.DocumentFile r9 = r8.f20542e
                boolean r9 = r9.isDirectory()
                if (r9 == 0) goto L_0x00b2
                androidx.documentfile.provider.DocumentFile r9 = r8.f20542e
                androidx.documentfile.provider.DocumentFile[] r9 = r9.listFiles()
                java.lang.String r3 = "listFiles(...)"
                kotlin.jvm.internal.t.d(r9, r3)
                int r3 = r9.length
                r4 = r3
                r3 = r1
                r1 = r4
                r4 = r9
            L_0x0094:
                if (r3 >= r1) goto L_0x00b2
                r9 = r4[r3]
                b2.L r5 = r8.f20545h
                kotlin.jvm.internal.t.b(r9)
                java.util.zip.ZipOutputStream r6 = r8.f20543f
                android.content.Context r7 = r8.f20544g
                r8.f20538a = r4
                r8.f20539b = r3
                r8.f20540c = r1
                r8.f20541d = r2
                java.lang.Object r9 = r5.f(r9, r6, r7, r8)
                if (r9 != r0) goto L_0x00b0
                return r0
            L_0x00b0:
                int r3 = r3 + r2
                goto L_0x0094
            L_0x00b2:
                W2.J r9 = W2.J.f19942a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20546a;

        /* renamed from: b  reason: collision with root package name */
        int f20547b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f20548c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f20549d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ZipOutputStream f20550e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2280L f20551f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(File file, String str, ZipOutputStream zipOutputStream, C2280L l5, C2308e eVar) {
            super(2, eVar);
            this.f20548c = file;
            this.f20549d = str;
            this.f20550e = zipOutputStream;
            this.f20551f = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f20548c, this.f20549d, this.f20550e, this.f20551f, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r6.f20547b
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r6.f20546a
                java.util.Iterator r1 = (java.util.Iterator) r1
                W2.u.b(r7)
                goto L_0x0079
            L_0x0013:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001b:
                W2.u.b(r7)
                java.io.File r7 = r6.f20548c
                boolean r7 = r7.isFile()
                if (r7 == 0) goto L_0x0064
                java.util.zip.ZipEntry r7 = new java.util.zip.ZipEntry
                java.lang.String r0 = r6.f20549d
                r7.<init>(r0)
                java.util.zip.ZipOutputStream r0 = r6.f20550e
                r0.putNextEntry(r7)
                java.io.FileInputStream r7 = new java.io.FileInputStream
                java.io.File r0 = r6.f20548c
                r7.<init>(r0)
                b2.L r0 = r6.f20551f
                java.util.zip.ZipOutputStream r1 = r6.f20550e
            L_0x003d:
                byte[] r2 = r0.f20536a     // Catch:{ all -> 0x0050 }
                int r2 = r7.read(r2)     // Catch:{ all -> 0x0050 }
                if (r2 <= 0) goto L_0x0052
                byte[] r3 = r0.f20536a     // Catch:{ all -> 0x0050 }
                r4 = 0
                r1.write(r3, r4, r2)     // Catch:{ all -> 0x0050 }
                goto L_0x003d
            L_0x0050:
                r0 = move-exception
                goto L_0x005e
            L_0x0052:
                W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x0050 }
                r0 = 0
                h3.C2453b.a(r7, r0)
                java.util.zip.ZipOutputStream r7 = r6.f20550e
                r7.closeEntry()
                goto L_0x00b1
            L_0x005e:
                throw r0     // Catch:{ all -> 0x005f }
            L_0x005f:
                r1 = move-exception
                h3.C2453b.a(r7, r0)
                throw r1
            L_0x0064:
                java.io.File r7 = r6.f20548c
                boolean r7 = r7.isDirectory()
                if (r7 == 0) goto L_0x00b1
                java.io.File r7 = r6.f20548c
                java.io.File[] r7 = r7.listFiles()
                if (r7 == 0) goto L_0x00b1
                java.util.Iterator r7 = kotlin.jvm.internal.C2625c.a(r7)
                r1 = r7
            L_0x0079:
                boolean r7 = r1.hasNext()
                if (r7 == 0) goto L_0x00b1
                java.lang.Object r7 = r1.next()
                java.io.File r7 = (java.io.File) r7
                b2.L r3 = r6.f20551f
                kotlin.jvm.internal.t.b(r7)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = r6.f20549d
                r4.append(r5)
                r5 = 47
                r4.append(r5)
                java.lang.String r5 = r7.getName()
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                java.util.zip.ZipOutputStream r5 = r6.f20550e
                r6.f20546a = r1
                r6.f20547b = r2
                java.lang.Object r7 = r3.g(r7, r4, r5, r6)
                if (r7 != r0) goto L_0x0079
                return r0
            L_0x00b1:
                W2.J r7 = W2.J.f19942a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20552a;

        /* renamed from: b  reason: collision with root package name */
        Object f20553b;

        /* renamed from: c  reason: collision with root package name */
        Object f20554c;

        /* renamed from: d  reason: collision with root package name */
        int f20555d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f20556e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f20557f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C2280L f20558g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C2226c f20559h;

        /* renamed from: b2.L$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20560a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20561b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f20562c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2226c cVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f20561b = cVar;
                this.f20562c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20561b, this.f20562c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20560a == 0) {
                    u.b(obj);
                    this.f20561b.b(String.valueOf(this.f20562c.size()));
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$c$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20563a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20564b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2280L f20565c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f20566d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f20567e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2226c cVar, C2280L l5, ArrayList arrayList, String str, C2308e eVar) {
                super(2, eVar);
                this.f20564b = cVar;
                this.f20565c = l5;
                this.f20566d = arrayList;
                this.f20567e = str;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20564b, this.f20565c, this.f20566d, this.f20567e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20563a == 0) {
                    u.b(obj);
                    this.f20564b.c((this.f20565c.f20537b * 100) / this.f20566d.size(), this.f20567e);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$c$c  reason: collision with other inner class name */
        static final class C0202c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20568a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20569b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f20570c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0202c(C2226c cVar, File file, C2308e eVar) {
                super(2, eVar);
                this.f20569b = cVar;
                this.f20570c = file;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0202c(this.f20569b, this.f20570c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20568a == 0) {
                    u.b(obj);
                    C2226c cVar = this.f20569b;
                    String name = this.f20570c.getName();
                    t.d(name, "getName(...)");
                    cVar.a(name);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0202c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(File file, ArrayList arrayList, C2280L l5, C2226c cVar, C2308e eVar) {
            super(2, eVar);
            this.f20556e = file;
            this.f20557f = arrayList;
            this.f20558g = l5;
            this.f20559h = cVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f20556e, this.f20557f, this.f20558g, this.f20559h, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x007d, code lost:
            if (w3.C2872g.g(r9, r10, r0) == r1) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0107, code lost:
            if (w3.C2872g.g(r10, r12, r0) != r1) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0129, code lost:
            if (w3.C2872g.g(r2, r4, r0) == r1) goto L_0x012b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x010a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f20555d
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L_0x0057
                if (r2 == r6) goto L_0x004b
                if (r2 == r5) goto L_0x003a
                if (r2 == r4) goto L_0x0024
                if (r2 != r3) goto L_0x001c
                W2.u.b(r20)
                goto L_0x012c
            L_0x001c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0024:
                java.lang.Object r2 = r0.f20554c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r8 = r0.f20553b
                java.util.zip.ZipOutputStream r8 = (java.util.zip.ZipOutputStream) r8
                java.lang.Object r9 = r0.f20552a
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                W2.u.b(r20)
            L_0x0033:
                r18 = r9
                r9 = r2
                r2 = r8
                r8 = r18
                goto L_0x008c
            L_0x003a:
                java.lang.Object r2 = r0.f20554c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r8 = r0.f20553b
                java.util.zip.ZipOutputStream r8 = (java.util.zip.ZipOutputStream) r8
                java.lang.Object r9 = r0.f20552a
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                W2.u.b(r20)
                goto L_0x00be
            L_0x004b:
                java.lang.Object r2 = r0.f20553b
                java.util.zip.ZipOutputStream r2 = (java.util.zip.ZipOutputStream) r2
                java.lang.Object r8 = r0.f20552a
                java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
                W2.u.b(r20)
                goto L_0x0081
            L_0x0057:
                W2.u.b(r20)
                java.io.FileOutputStream r8 = new java.io.FileOutputStream
                java.io.File r2 = r0.f20556e
                r8.<init>(r2)
                java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream
                r2.<init>(r8)
                w3.I0 r9 = w3.C2865c0.c()
                b2.L$c$a r10 = new b2.L$c$a
                X1.c r11 = r0.f20559h
                java.util.ArrayList r12 = r0.f20557f
                r10.<init>(r11, r12, r7)
                r0.f20552a = r8
                r0.f20553b = r2
                r0.f20555d = r6
                java.lang.Object r9 = w3.C2872g.g(r9, r10, r0)
                if (r9 != r1) goto L_0x0081
                goto L_0x012b
            L_0x0081:
                java.util.ArrayList r9 = r0.f20557f
                java.util.Iterator r9 = r9.iterator()
                java.lang.String r10 = "iterator(...)"
                kotlin.jvm.internal.t.d(r9, r10)
            L_0x008c:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x010a
                java.lang.Object r10 = r9.next()
                java.lang.String r11 = "next(...)"
                kotlin.jvm.internal.t.d(r10, r11)
                java.io.File r10 = (java.io.File) r10
                b2.L r11 = r0.f20558g
                java.lang.String r12 = r10.getName()
                java.lang.String r13 = "getName(...)"
                kotlin.jvm.internal.t.d(r12, r13)
                r0.f20552a = r8
                r0.f20553b = r2
                r0.f20554c = r9
                r0.f20555d = r5
                java.lang.Object r10 = r11.g(r10, r12, r2, r0)
                if (r10 != r1) goto L_0x00b8
                goto L_0x012b
            L_0x00b8:
                r18 = r8
                r8 = r2
                r2 = r9
                r9 = r18
            L_0x00be:
                b2.L r10 = r0.f20558g
                int r10 = r10.f20537b
                b2.L r11 = r0.f20558g
                int r10 = r10 + r6
                r11.f20537b = r10
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                b2.L r11 = r0.f20558g
                int r11 = r11.f20537b
                r10.append(r11)
                r11 = 47
                r10.append(r11)
                java.util.ArrayList r11 = r0.f20557f
                int r11 = r11.size()
                r10.append(r11)
                java.lang.String r16 = r10.toString()
                w3.I0 r10 = w3.C2865c0.c()
                b2.L$c$b r12 = new b2.L$c$b
                X1.c r13 = r0.f20559h
                b2.L r14 = r0.f20558g
                java.util.ArrayList r15 = r0.f20557f
                r17 = 0
                r12.<init>(r13, r14, r15, r16, r17)
                r0.f20552a = r9
                r0.f20553b = r8
                r0.f20554c = r2
                r0.f20555d = r4
                java.lang.Object r10 = w3.C2872g.g(r10, r12, r0)
                if (r10 != r1) goto L_0x0033
                goto L_0x012b
            L_0x010a:
                r2.close()
                r8.close()
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$c$c r4 = new b2.L$c$c
                X1.c r5 = r0.f20559h
                java.io.File r6 = r0.f20556e
                r4.<init>(r5, r6, r7)
                r0.f20552a = r7
                r0.f20553b = r7
                r0.f20554c = r7
                r0.f20555d = r3
                java.lang.Object r2 = w3.C2872g.g(r2, r4, r0)
                if (r2 != r1) goto L_0x012c
            L_0x012b:
                return r1
            L_0x012c:
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20571a;

        /* renamed from: b  reason: collision with root package name */
        Object f20572b;

        /* renamed from: c  reason: collision with root package name */
        Object f20573c;

        /* renamed from: d  reason: collision with root package name */
        int f20574d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f20575e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20576f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f20577g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ C2280L f20578h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ C2226c f20579i;

        /* renamed from: b2.L$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20580a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20581b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f20582c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2226c cVar, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f20581b = cVar;
                this.f20582c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20581b, this.f20582c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20580a == 0) {
                    u.b(obj);
                    this.f20581b.b(String.valueOf(this.f20582c.size()));
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$d$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20583a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20584b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2226c cVar, C2308e eVar) {
                super(2, eVar);
                this.f20584b = cVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20584b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20583a == 0) {
                    u.b(obj);
                    this.f20584b.onError("FileNotFoundException");
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$d$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20585a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20586b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2280L f20587c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f20588d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f20589e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2226c cVar, C2280L l5, ArrayList arrayList, String str, C2308e eVar) {
                super(2, eVar);
                this.f20586b = cVar;
                this.f20587c = l5;
                this.f20588d = arrayList;
                this.f20589e = str;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20586b, this.f20587c, this.f20588d, this.f20589e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20585a == 0) {
                    u.b(obj);
                    this.f20586b.c((this.f20587c.f20537b * 100) / this.f20588d.size(), this.f20589e);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$d$d  reason: collision with other inner class name */
        static final class C0203d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20590a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2226c f20591b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DocumentFile f20592c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0203d(C2226c cVar, DocumentFile documentFile, C2308e eVar) {
                super(2, eVar);
                this.f20591b = cVar;
                this.f20592c = documentFile;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0203d(this.f20591b, this.f20592c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20590a == 0) {
                    u.b(obj);
                    C2226c cVar = this.f20591b;
                    String name = this.f20592c.getName();
                    t.b(name);
                    cVar.a(name);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0203d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, DocumentFile documentFile, ArrayList arrayList, C2280L l5, C2226c cVar, C2308e eVar) {
            super(2, eVar);
            this.f20575e = context;
            this.f20576f = documentFile;
            this.f20577g = arrayList;
            this.f20578h = l5;
            this.f20579i = cVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f20575e, this.f20576f, this.f20577g, this.f20578h, this.f20579i, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
            if (w3.C2872g.g(r2, r9, r0) == r1) goto L_0x0141;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0093, code lost:
            if (w3.C2872g.g(r2, r9, r0) != r1) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x011b, code lost:
            if (w3.C2872g.g(r10, r12, r0) != r1) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x013f, code lost:
            if (w3.C2872g.g(r2, r4, r0) == r1) goto L_0x0141;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x011e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f20574d
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                r8 = 0
                if (r2 == 0) goto L_0x0055
                if (r2 == r7) goto L_0x0051
                if (r2 == r6) goto L_0x004d
                if (r2 == r5) goto L_0x003c
                if (r2 == r4) goto L_0x0027
                if (r2 != r3) goto L_0x001f
                W2.u.b(r20)
                goto L_0x0142
            L_0x001f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0027:
                java.lang.Object r2 = r0.f20573c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r6 = r0.f20572b
                java.util.zip.ZipOutputStream r6 = (java.util.zip.ZipOutputStream) r6
                java.lang.Object r9 = r0.f20571a
                java.io.OutputStream r9 = (java.io.OutputStream) r9
                W2.u.b(r20)
            L_0x0036:
                r18 = r9
                r9 = r2
                r2 = r18
                goto L_0x00a8
            L_0x003c:
                java.lang.Object r2 = r0.f20573c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r6 = r0.f20572b
                java.util.zip.ZipOutputStream r6 = (java.util.zip.ZipOutputStream) r6
                java.lang.Object r9 = r0.f20571a
                java.io.OutputStream r9 = (java.io.OutputStream) r9
                W2.u.b(r20)
                goto L_0x00d2
            L_0x004d:
                W2.u.b(r20)
                goto L_0x0097
            L_0x0051:
                W2.u.b(r20)
                goto L_0x006f
            L_0x0055:
                W2.u.b(r20)
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$d$a r9 = new b2.L$d$a
                X1.c r10 = r0.f20579i
                java.util.ArrayList r11 = r0.f20577g
                r9.<init>(r10, r11, r8)
                r0.f20574d = r7
                java.lang.Object r2 = w3.C2872g.g(r2, r9, r0)
                if (r2 != r1) goto L_0x006f
                goto L_0x0141
            L_0x006f:
                android.content.Context r2 = r0.f20575e     // Catch:{ FileNotFoundException -> 0x0082 }
                android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0082 }
                if (r2 == 0) goto L_0x0097
                androidx.documentfile.provider.DocumentFile r9 = r0.f20576f     // Catch:{ FileNotFoundException -> 0x0082 }
                android.net.Uri r9 = r9.getUri()     // Catch:{ FileNotFoundException -> 0x0082 }
                java.io.OutputStream r2 = r2.openOutputStream(r9)     // Catch:{ FileNotFoundException -> 0x0082 }
                goto L_0x0098
            L_0x0082:
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$d$b r9 = new b2.L$d$b
                X1.c r10 = r0.f20579i
                r9.<init>(r10, r8)
                r0.f20574d = r6
                java.lang.Object r2 = w3.C2872g.g(r2, r9, r0)
                if (r2 != r1) goto L_0x0097
                goto L_0x0141
            L_0x0097:
                r2 = r8
            L_0x0098:
                java.util.zip.ZipOutputStream r6 = new java.util.zip.ZipOutputStream
                r6.<init>(r2)
                java.util.ArrayList r9 = r0.f20577g
                java.util.Iterator r9 = r9.iterator()
                java.lang.String r10 = "iterator(...)"
                kotlin.jvm.internal.t.d(r9, r10)
            L_0x00a8:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x011e
                java.lang.Object r10 = r9.next()
                java.lang.String r11 = "next(...)"
                kotlin.jvm.internal.t.d(r10, r11)
                androidx.documentfile.provider.DocumentFile r10 = (androidx.documentfile.provider.DocumentFile) r10
                b2.L r11 = r0.f20578h
                android.content.Context r12 = r0.f20575e
                r0.f20571a = r2
                r0.f20572b = r6
                r0.f20573c = r9
                r0.f20574d = r5
                java.lang.Object r10 = r11.f(r10, r6, r12, r0)
                if (r10 != r1) goto L_0x00cd
                goto L_0x0141
            L_0x00cd:
                r18 = r9
                r9 = r2
                r2 = r18
            L_0x00d2:
                b2.L r10 = r0.f20578h
                int r10 = r10.f20537b
                b2.L r11 = r0.f20578h
                int r10 = r10 + r7
                r11.f20537b = r10
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                b2.L r11 = r0.f20578h
                int r11 = r11.f20537b
                r10.append(r11)
                r11 = 47
                r10.append(r11)
                java.util.ArrayList r11 = r0.f20577g
                int r11 = r11.size()
                r10.append(r11)
                java.lang.String r16 = r10.toString()
                w3.I0 r10 = w3.C2865c0.c()
                b2.L$d$c r12 = new b2.L$d$c
                X1.c r13 = r0.f20579i
                b2.L r14 = r0.f20578h
                java.util.ArrayList r15 = r0.f20577g
                r17 = 0
                r12.<init>(r13, r14, r15, r16, r17)
                r0.f20571a = r9
                r0.f20572b = r6
                r0.f20573c = r2
                r0.f20574d = r4
                java.lang.Object r10 = w3.C2872g.g(r10, r12, r0)
                if (r10 != r1) goto L_0x0036
                goto L_0x0141
            L_0x011e:
                r6.close()
                if (r2 == 0) goto L_0x0126
                r2.close()
            L_0x0126:
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$d$d r4 = new b2.L$d$d
                X1.c r5 = r0.f20579i
                androidx.documentfile.provider.DocumentFile r6 = r0.f20576f
                r4.<init>(r5, r6, r8)
                r0.f20571a = r8
                r0.f20572b = r8
                r0.f20573c = r8
                r0.f20574d = r3
                java.lang.Object r2 = w3.C2872g.g(r2, r4, r0)
                if (r2 != r1) goto L_0x0142
            L_0x0141:
                return r1
            L_0x0142:
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20593a;

        /* renamed from: b  reason: collision with root package name */
        Object f20594b;

        /* renamed from: c  reason: collision with root package name */
        Object f20595c;

        /* renamed from: d  reason: collision with root package name */
        Object f20596d;

        /* renamed from: e  reason: collision with root package name */
        Object f20597e;

        /* renamed from: f  reason: collision with root package name */
        Object f20598f;

        /* renamed from: g  reason: collision with root package name */
        long f20599g;

        /* renamed from: h  reason: collision with root package name */
        int f20600h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f20601i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ File f20602j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ C2280L f20603k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ C2228e f20604l;

        /* renamed from: b2.L$e$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20605a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20606b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20606b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20606b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20605a == 0) {
                    u.b(obj);
                    this.f20606b.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$e$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20607a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20608b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f20609c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2228e eVar, K k5, C2308e eVar2) {
                super(2, eVar2);
                this.f20608b = eVar;
                this.f20609c = k5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20608b, this.f20609c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20607a == 0) {
                    u.b(obj);
                    this.f20608b.d(this.f20609c.f24689a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$e$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20610a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20611b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f20612c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2228e eVar, kotlin.jvm.internal.J j5, C2308e eVar2) {
                super(2, eVar2);
                this.f20611b = eVar;
                this.f20612c = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20611b, this.f20612c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20610a == 0) {
                    u.b(obj);
                    this.f20611b.b(this.f20612c.f24688a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, File file, C2280L l5, C2228e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f20601i = str;
            this.f20602j = file;
            this.f20603k = l5;
            this.f20604l = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f20601i, this.f20602j, this.f20603k, this.f20604l, eVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.util.zip.ZipInputStream} */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0193, code lost:
            if (w3.C2872g.g(r3, r4, r1) != r0) goto L_0x0196;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x019a */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9 A[Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0105 A[Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0117 A[Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x013f A[Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0162 A[Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0174 A[Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.Object r0 = c3.C2316b.f()
                int r2 = r1.f20600h
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x0076
                if (r2 == r5) goto L_0x0053
                if (r2 == r4) goto L_0x0029
                if (r2 != r3) goto L_0x0021
                java.lang.Object r0 = r1.f20593a
                r2 = r0
                java.util.zip.ZipInputStream r2 = (java.util.zip.ZipInputStream) r2
                W2.u.b(r20)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                goto L_0x0196
            L_0x001e:
                r0 = move-exception
                goto L_0x01a9
            L_0x0021:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0029:
                long r7 = r1.f20599g
                java.lang.Object r2 = r1.f20598f
                kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
                java.lang.Object r9 = r1.f20597e
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                java.lang.Object r10 = r1.f20596d
                kotlin.jvm.internal.K r10 = (kotlin.jvm.internal.K) r10
                java.lang.Object r11 = r1.f20595c
                kotlin.jvm.internal.J r11 = (kotlin.jvm.internal.J) r11
                java.lang.Object r12 = r1.f20594b
                java.util.zip.ZipInputStream r12 = (java.util.zip.ZipInputStream) r12
                java.lang.Object r13 = r1.f20593a
                java.io.File r13 = (java.io.File) r13
                W2.u.b(r20)     // Catch:{ EOFException -> 0x0050, IOException -> 0x004d, all -> 0x0049 }
                r14 = r4
                goto L_0x0144
            L_0x0049:
                r0 = move-exception
                r2 = r12
                goto L_0x01a9
            L_0x004d:
                r2 = r12
                goto L_0x019a
            L_0x0050:
                r2 = r12
                goto L_0x01a0
            L_0x0053:
                java.lang.Object r2 = r1.f20596d
                java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2
                java.lang.Object r7 = r1.f20595c
                kotlin.jvm.internal.J r7 = (kotlin.jvm.internal.J) r7
                java.lang.Object r8 = r1.f20594b
                java.util.zip.ZipInputStream r8 = (java.util.zip.ZipInputStream) r8
                java.lang.Object r9 = r1.f20593a
                java.io.File r9 = (java.io.File) r9
                W2.u.b(r20)     // Catch:{ EOFException -> 0x0073, IOException -> 0x0070, all -> 0x006c }
                r16 = r8
                r8 = r2
                r2 = r16
                goto L_0x00b2
            L_0x006c:
                r0 = move-exception
                r2 = r8
                goto L_0x01a9
            L_0x0070:
                r2 = r8
                goto L_0x019a
            L_0x0073:
                r2 = r8
                goto L_0x01a0
            L_0x0076:
                W2.u.b(r20)
                java.io.File r9 = new java.io.File
                java.lang.String r2 = r1.f20601i
                r9.<init>(r2)
                java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream
                java.io.FileInputStream r7 = new java.io.FileInputStream
                java.io.File r8 = r1.f20602j
                r7.<init>(r8)
                r2.<init>(r7)
                kotlin.jvm.internal.J r7 = new kotlin.jvm.internal.J
                r7.<init>()
                java.util.zip.ZipEntry r8 = r2.getNextEntry()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                w3.I0 r10 = w3.C2865c0.c()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                b2.L$e$a r11 = new b2.L$e$a     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                X1.e r12 = r1.f20604l     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r11.<init>(r12, r6)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20593a = r9     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20594b = r2     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20595c = r7     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20596d = r8     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20600h = r5     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                java.lang.Object r10 = w3.C2872g.g(r10, r11, r1)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r10 != r0) goto L_0x00b2
                goto L_0x0195
            L_0x00b2:
                kotlin.jvm.internal.K r10 = new kotlin.jvm.internal.K     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r10.<init>()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
            L_0x00b7:
                if (r8 == 0) goto L_0x0174
                int r11 = r7.f24688a     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                int r11 = r11 + r5
                r7.f24688a = r11     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                java.io.File r11 = new java.io.File     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                java.lang.String r12 = r8.getName()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r11.<init>(r9, r12)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                boolean r8 = r8.isDirectory()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r8 == 0) goto L_0x00d7
                boolean r8 = r11.mkdirs()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                kotlin.coroutines.jvm.internal.b.a(r8)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r14 = r4
                goto L_0x0167
            L_0x00d7:
                java.io.File r8 = r11.getParentFile()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r8 == 0) goto L_0x00e6
                boolean r12 = r8.exists()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r12 != 0) goto L_0x00e6
                r8.mkdirs()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
            L_0x00e6:
                java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r8.<init>(r11)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                kotlin.jvm.internal.J r11 = new kotlin.jvm.internal.J     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r11.<init>()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r12 = 0
                r16 = r9
                r9 = r8
                r8 = r16
            L_0x00f7:
                b2.L r14 = r1.f20603k     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                byte[] r14 = r14.f20536a     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                int r14 = r2.read(r14)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r11.f24688a = r14     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r14 <= 0) goto L_0x0162
                long r3 = r10.f24689a     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                long r5 = (long) r14     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                long r3 = r3 + r5
                r10.f24689a = r3     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r5 = 1000(0x3e8, float:1.401E-42)
                long r5 = (long) r5     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                long r5 = r5 + r12
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r3 <= 0) goto L_0x0150
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                w3.I0 r5 = w3.C2865c0.c()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                b2.L$e$b r6 = new b2.L$e$b     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                X1.e r12 = r1.f20604l     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r13 = 0
                r6.<init>(r12, r10, r13)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20593a = r8     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20594b = r2     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20595c = r7     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20596d = r10     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20597e = r9     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20598f = r11     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20599g = r3     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r14 = 2
                r1.f20600h = r14     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                java.lang.Object r5 = w3.C2872g.g(r5, r6, r1)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r5 != r0) goto L_0x013f
                goto L_0x0195
            L_0x013f:
                r12 = r2
                r13 = r8
                r2 = r11
                r11 = r7
                r7 = r3
            L_0x0144:
                r16 = r11
                r11 = r2
                r2 = r12
                r17 = r7
                r7 = r16
                r8 = r13
                r12 = r17
                goto L_0x0151
            L_0x0150:
                r14 = 2
            L_0x0151:
                b2.L r3 = r1.f20603k     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                byte[] r3 = r3.f20536a     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                int r4 = r11.f24688a     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r5 = 0
                r9.write(r3, r5, r4)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r4 = r14
                r3 = 3
                r5 = 1
                r6 = 0
                goto L_0x00f7
            L_0x0162:
                r14 = r4
                r9.close()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r9 = r8
            L_0x0167:
                r2.closeEntry()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                java.util.zip.ZipEntry r8 = r2.getNextEntry()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r4 = r14
                r3 = 3
                r5 = 1
                r6 = 0
                goto L_0x00b7
            L_0x0174:
                w3.I0 r3 = w3.C2865c0.c()     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                b2.L$e$c r4 = new b2.L$e$c     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                X1.e r5 = r1.f20604l     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r13 = 0
                r4.<init>(r5, r7, r13)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20593a = r2     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20594b = r13     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20595c = r13     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20596d = r13     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20597e = r13     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r1.f20598f = r13     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                r15 = 3
                r1.f20600h = r15     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                java.lang.Object r3 = w3.C2872g.g(r3, r4, r1)     // Catch:{ EOFException -> 0x01a0, IOException -> 0x019a }
                if (r3 != r0) goto L_0x0196
            L_0x0195:
                return r0
            L_0x0196:
                r2.close()
                goto L_0x01a6
            L_0x019a:
                X1.e r0 = r1.f20604l     // Catch:{ all -> 0x001e }
                r0.a()     // Catch:{ all -> 0x001e }
                goto L_0x0196
            L_0x01a0:
                X1.e r0 = r1.f20604l     // Catch:{ all -> 0x001e }
                r0.a()     // Catch:{ all -> 0x001e }
                goto L_0x0196
            L_0x01a6:
                W2.J r0 = W2.J.f19942a
                return r0
            L_0x01a9:
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20613a;

        /* renamed from: b  reason: collision with root package name */
        Object f20614b;

        /* renamed from: c  reason: collision with root package name */
        Object f20615c;

        /* renamed from: d  reason: collision with root package name */
        Object f20616d;

        /* renamed from: e  reason: collision with root package name */
        Object f20617e;

        /* renamed from: f  reason: collision with root package name */
        Object f20618f;

        /* renamed from: g  reason: collision with root package name */
        Object f20619g;

        /* renamed from: h  reason: collision with root package name */
        int f20620h;

        /* renamed from: i  reason: collision with root package name */
        long f20621i;

        /* renamed from: j  reason: collision with root package name */
        int f20622j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ File f20623k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Uri f20624l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ Context f20625m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ C2228e f20626n;

        /* renamed from: b2.L$f$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20627a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20628b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20628b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20628b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20627a == 0) {
                    u.b(obj);
                    this.f20628b.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$f$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20629a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20630b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20630b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20630b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20629a == 0) {
                    u.b(obj);
                    this.f20630b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$f$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20631a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20632b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20632b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20632b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20631a == 0) {
                    u.b(obj);
                    this.f20632b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$f$d */
        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20633a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20634b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f20635c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C2228e eVar, K k5, C2308e eVar2) {
                super(2, eVar2);
                this.f20634b = eVar;
                this.f20635c = k5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new d(this.f20634b, this.f20635c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20633a == 0) {
                    u.b(obj);
                    this.f20634b.d(this.f20635c.f24689a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$f$e */
        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20636a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20637b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f20638c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(C2228e eVar, kotlin.jvm.internal.J j5, C2308e eVar2) {
                super(2, eVar2);
                this.f20637b = eVar;
                this.f20638c = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new e(this.f20637b, this.f20638c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20636a == 0) {
                    u.b(obj);
                    this.f20637b.b(this.f20638c.f24688a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(File file, Uri uri, Context context, C2228e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f20623k = file;
            this.f20624l = uri;
            this.f20625m = context;
            this.f20626n = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f20623k, this.f20624l, this.f20625m, this.f20626n, eVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX WARNING: type inference failed for: r5v9 */
        /* JADX WARNING: type inference failed for: r3v16, types: [androidx.documentfile.provider.DocumentFile] */
        /* JADX WARNING: type inference failed for: r3v22 */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0091, code lost:
            if (w3.C2872g.g(r2, r3, r0) == r1) goto L_0x02a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x02a4, code lost:
            if (w3.C2872g.g(r2, r3, r0) == r1) goto L_0x02a6;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x01e6  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x020d  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0221  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x024f  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0259  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x026a  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0280  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                r25 = this;
                r0 = r25
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f20622j
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x007d
                if (r2 == r8) goto L_0x0079
                if (r2 == r6) goto L_0x0064
                if (r2 == r5) goto L_0x004e
                if (r2 == r4) goto L_0x0027
                if (r2 != r3) goto L_0x001f
                W2.u.b(r26)
                goto L_0x02a7
            L_0x001f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0027:
                long r10 = r0.f20621i
                int r2 = r0.f20620h
                java.lang.Object r12 = r0.f20619g
                kotlin.jvm.internal.J r12 = (kotlin.jvm.internal.J) r12
                java.lang.Object r13 = r0.f20618f
                byte[] r13 = (byte[]) r13
                java.lang.Object r14 = r0.f20617e
                java.io.OutputStream r14 = (java.io.OutputStream) r14
                java.lang.Object r15 = r0.f20616d
                kotlin.jvm.internal.K r15 = (kotlin.jvm.internal.K) r15
                java.lang.Object r3 = r0.f20615c
                kotlin.jvm.internal.J r3 = (kotlin.jvm.internal.J) r3
                java.lang.Object r7 = r0.f20614b
                kotlin.jvm.internal.L r7 = (kotlin.jvm.internal.L) r7
                java.lang.Object r4 = r0.f20613a
                java.util.zip.ZipInputStream r4 = (java.util.zip.ZipInputStream) r4
                W2.u.b(r26)
                r5 = r14
                r14 = 4
                goto L_0x0251
            L_0x004e:
                java.lang.Object r2 = r0.f20616d
                kotlin.jvm.internal.K r2 = (kotlin.jvm.internal.K) r2
                java.lang.Object r3 = r0.f20615c
                kotlin.jvm.internal.J r3 = (kotlin.jvm.internal.J) r3
                java.lang.Object r4 = r0.f20614b
                kotlin.jvm.internal.L r4 = (kotlin.jvm.internal.L) r4
                java.lang.Object r7 = r0.f20613a
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                W2.u.b(r26)
                r11 = r5
                goto L_0x01e9
            L_0x0064:
                java.lang.Object r2 = r0.f20616d
                kotlin.jvm.internal.K r2 = (kotlin.jvm.internal.K) r2
                java.lang.Object r3 = r0.f20615c
                kotlin.jvm.internal.J r3 = (kotlin.jvm.internal.J) r3
                java.lang.Object r4 = r0.f20614b
                kotlin.jvm.internal.L r4 = (kotlin.jvm.internal.L) r4
                java.lang.Object r7 = r0.f20613a
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                W2.u.b(r26)
                goto L_0x01bc
            L_0x0079:
                W2.u.b(r26)
                goto L_0x0095
            L_0x007d:
                W2.u.b(r26)
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$f$a r3 = new b2.L$f$a
                X1.e r4 = r0.f20626n
                r3.<init>(r4, r9)
                r0.f20622j = r8
                java.lang.Object r2 = w3.C2872g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0095
                goto L_0x02a6
            L_0x0095:
                java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream
                java.io.FileInputStream r3 = new java.io.FileInputStream
                java.io.File r4 = r0.f20623k
                r3.<init>(r4)
                r2.<init>(r3)
                java.util.zip.ZipEntry r3 = r2.getNextEntry()
                android.net.Uri r4 = r0.f20624l
                java.lang.String r10 = r4.getLastPathSegment()
                kotlin.jvm.internal.t.b(r10)
                r14 = 6
                r15 = 0
                java.lang.String r11 = ":"
                r12 = 0
                r13 = 0
                int r4 = t3.s.l0(r10, r11, r12, r13, r14, r15)
                int r4 = r4 + r8
                java.lang.String r4 = r10.substring(r4)
                java.lang.String r7 = "substring(...)"
                kotlin.jvm.internal.t.d(r4, r7)
                kotlin.jvm.internal.L r7 = new kotlin.jvm.internal.L
                r7.<init>()
                android.content.Context r10 = r0.f20625m
                android.net.Uri r11 = r0.f20624l
                androidx.documentfile.provider.DocumentFile r10 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r10, r11)
                r7.f24690a = r10
                java.lang.String r10 = "/"
                java.lang.String[] r18 = new java.lang.String[]{r10}
                r21 = 6
                r22 = 0
                r19 = 0
                r20 = 0
                r17 = r4
                java.util.List r4 = t3.s.G0(r17, r18, r19, r20, r21, r22)
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.Iterator r4 = r4.iterator()
            L_0x00eb:
                boolean r10 = r4.hasNext()
                if (r10 == 0) goto L_0x012f
                java.lang.Object r10 = r4.next()
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r11 = r7.f24690a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x0119
                androidx.documentfile.provider.DocumentFile[] r11 = r11.listFiles()
                if (r11 == 0) goto L_0x0119
                int r12 = r11.length
                r14 = r9
                r13 = 0
            L_0x0106:
                if (r13 >= r12) goto L_0x011a
                r15 = r11[r13]
                java.lang.String r5 = r15.getName()
                boolean r5 = t3.s.E(r5, r10, r8)
                if (r5 == 0) goto L_0x0115
                r14 = r15
            L_0x0115:
                int r13 = r13 + 1
                r5 = 3
                goto L_0x0106
            L_0x0119:
                r14 = r9
            L_0x011a:
                if (r14 == 0) goto L_0x011f
                r7.f24690a = r14
                goto L_0x012d
            L_0x011f:
                java.lang.Object r5 = r7.f24690a
                androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
                if (r5 == 0) goto L_0x012a
                androidx.documentfile.provider.DocumentFile r5 = r5.createDirectory(r10)
                goto L_0x012b
            L_0x012a:
                r5 = r9
            L_0x012b:
                r7.f24690a = r5
            L_0x012d:
                r5 = 3
                goto L_0x00eb
            L_0x012f:
                kotlin.jvm.internal.J r4 = new kotlin.jvm.internal.J
                r4.<init>()
                kotlin.jvm.internal.K r5 = new kotlin.jvm.internal.K
                r5.<init>()
                r23 = r5
                r5 = r2
                r2 = r23
            L_0x013e:
                if (r3 == 0) goto L_0x0280
                int r10 = r4.f24688a
                int r10 = r10 + r8
                r4.f24688a = r10
                boolean r10 = r3.isDirectory()
                if (r10 == 0) goto L_0x0161
                android.content.Context r10 = r0.f20625m
                android.net.Uri r11 = r0.f20624l
                androidx.documentfile.provider.DocumentFile r10 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r10, r11)
                if (r10 == 0) goto L_0x015c
                java.lang.String r3 = r3.getName()
                r10.createDirectory(r3)
            L_0x015c:
                r8 = 0
                r16 = 4
                goto L_0x0274
            L_0x0161:
                b2.j r10 = new b2.j
                r10.<init>()
                java.lang.String r11 = r3.getName()
                java.lang.String r12 = "getName(...)"
                kotlin.jvm.internal.t.d(r11, r12)
                java.lang.String r10 = r10.i(r11)
                java.lang.Object r11 = r7.f24690a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x0182
                java.lang.String r3 = r3.getName()
                androidx.documentfile.provider.DocumentFile r3 = r11.createFile(r10, r3)
                goto L_0x0183
            L_0x0182:
                r3 = r9
            L_0x0183:
                if (r3 == 0) goto L_0x015c
                android.content.Context r10 = r0.f20625m     // Catch:{ FileNotFoundException -> 0x0196 }
                android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0196 }
                if (r10 == 0) goto L_0x01bf
                android.net.Uri r3 = r3.getUri()     // Catch:{ FileNotFoundException -> 0x0196 }
                java.io.OutputStream r3 = r10.openOutputStream(r3)     // Catch:{ FileNotFoundException -> 0x0196 }
                goto L_0x01c0
            L_0x0196:
                w3.I0 r3 = w3.C2865c0.c()
                b2.L$f$b r10 = new b2.L$f$b
                X1.e r11 = r0.f20626n
                r10.<init>(r11, r9)
                r0.f20613a = r5
                r0.f20614b = r7
                r0.f20615c = r4
                r0.f20616d = r2
                r0.f20617e = r9
                r0.f20618f = r9
                r0.f20619g = r9
                r0.f20622j = r6
                java.lang.Object r3 = w3.C2872g.g(r3, r10, r0)
                if (r3 != r1) goto L_0x01b9
                goto L_0x02a6
            L_0x01b9:
                r3 = r4
                r4 = r7
                r7 = r5
            L_0x01bc:
                r5 = r7
                r7 = r4
                r4 = r3
            L_0x01bf:
                r3 = r9
            L_0x01c0:
                if (r3 != 0) goto L_0x01f1
                w3.I0 r3 = w3.C2865c0.c()
                b2.L$f$c r10 = new b2.L$f$c
                X1.e r11 = r0.f20626n
                r10.<init>(r11, r9)
                r0.f20613a = r5
                r0.f20614b = r7
                r0.f20615c = r4
                r0.f20616d = r2
                r0.f20617e = r9
                r0.f20618f = r9
                r0.f20619g = r9
                r11 = 3
                r0.f20622j = r11
                java.lang.Object r3 = w3.C2872g.g(r3, r10, r0)
                if (r3 != r1) goto L_0x01e6
                goto L_0x02a6
            L_0x01e6:
                r3 = r4
                r4 = r7
                r7 = r5
            L_0x01e9:
                r5 = r7
                r8 = 0
                r16 = 4
                r7 = r4
            L_0x01ee:
                r4 = r3
                goto L_0x0274
            L_0x01f1:
                r11 = 3
                r10 = 1024(0x400, float:1.435E-42)
                byte[] r10 = new byte[r10]
                kotlin.jvm.internal.J r12 = new kotlin.jvm.internal.J
                r12.<init>()
                r13 = 0
                r15 = r5
                r5 = r3
                r3 = r4
                r4 = r15
                r14 = r13
                r13 = r10
                r10 = r2
                r2 = 0
            L_0x0205:
                int r6 = r4.read(r13)
                r12.f24688a = r6
                if (r6 <= 0) goto L_0x026a
                r19 = r12
                long r11 = r10.f24689a
                long r8 = (long) r6
                long r11 = r11 + r8
                r10.f24689a = r11
                long r8 = java.lang.System.currentTimeMillis()
                r6 = 1000(0x3e8, float:1.401E-42)
                long r11 = (long) r6
                long r11 = r11 + r14
                int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
                if (r6 <= 0) goto L_0x0259
                long r8 = java.lang.System.currentTimeMillis()
                w3.I0 r6 = w3.C2865c0.c()
                b2.L$f$d r11 = new b2.L$f$d
                X1.e r12 = r0.f20626n
                r14 = 0
                r11.<init>(r12, r10, r14)
                r0.f20613a = r4
                r0.f20614b = r7
                r0.f20615c = r3
                r0.f20616d = r10
                r0.f20617e = r5
                r0.f20618f = r13
                r12 = r19
                r0.f20619g = r12
                r0.f20620h = r2
                r0.f20621i = r8
                r14 = 4
                r0.f20622j = r14
                java.lang.Object r6 = w3.C2872g.g(r6, r11, r0)
                if (r6 != r1) goto L_0x024f
                goto L_0x02a6
            L_0x024f:
                r15 = r10
                r10 = r8
            L_0x0251:
                r16 = r14
                r23 = r10
                r10 = r15
                r14 = r23
                goto L_0x025d
            L_0x0259:
                r12 = r19
                r16 = 4
            L_0x025d:
                int r6 = r12.f24688a
                r8 = 0
                r5.write(r13, r8, r6)
                int r6 = r12.f24688a
                int r2 = r2 + r6
                r8 = 1
                r9 = 0
                r11 = 3
                goto L_0x0205
            L_0x026a:
                r8 = 0
                r16 = 4
                r5.close()
                r5 = r4
                r2 = r10
                goto L_0x01ee
            L_0x0274:
                r5.closeEntry()
                java.util.zip.ZipEntry r3 = r5.getNextEntry()
                r6 = 2
                r8 = 1
                r9 = 0
                goto L_0x013e
            L_0x0280:
                r5.close()
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$f$e r3 = new b2.L$f$e
                X1.e r5 = r0.f20626n
                r14 = 0
                r3.<init>(r5, r4, r14)
                r0.f20613a = r14
                r0.f20614b = r14
                r0.f20615c = r14
                r0.f20616d = r14
                r0.f20617e = r14
                r0.f20618f = r14
                r0.f20619g = r14
                r4 = 5
                r0.f20622j = r4
                java.lang.Object r2 = w3.C2872g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x02a7
            L_0x02a6:
                return r1
            L_0x02a7:
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$g */
    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20639a;

        /* renamed from: b  reason: collision with root package name */
        Object f20640b;

        /* renamed from: c  reason: collision with root package name */
        Object f20641c;

        /* renamed from: d  reason: collision with root package name */
        Object f20642d;

        /* renamed from: e  reason: collision with root package name */
        Object f20643e;

        /* renamed from: f  reason: collision with root package name */
        Object f20644f;

        /* renamed from: g  reason: collision with root package name */
        long f20645g;

        /* renamed from: h  reason: collision with root package name */
        int f20646h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f20647i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Context f20648j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20649k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ C2280L f20650l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ C2228e f20651m;

        /* renamed from: b2.L$g$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20652a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20653b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20653b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20653b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20652a == 0) {
                    u.b(obj);
                    this.f20653b.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$g$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20654a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20655b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f20656c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2228e eVar, K k5, C2308e eVar2) {
                super(2, eVar2);
                this.f20655b = eVar;
                this.f20656c = k5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20655b, this.f20656c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20654a == 0) {
                    u.b(obj);
                    this.f20655b.d(this.f20656c.f24689a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$g$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20657a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20658b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f20659c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2228e eVar, kotlin.jvm.internal.J j5, C2308e eVar2) {
                super(2, eVar2);
                this.f20658b = eVar;
                this.f20659c = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20658b, this.f20659c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20657a == 0) {
                    u.b(obj);
                    this.f20658b.b(this.f20659c.f24688a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str, Context context, DocumentFile documentFile, C2280L l5, C2228e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f20647i = str;
            this.f20648j = context;
            this.f20649k = documentFile;
            this.f20650l = l5;
            this.f20651m = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f20647i, this.f20648j, this.f20649k, this.f20650l, this.f20651m, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x008f, code lost:
            if (w3.C2872g.g(r9, r10, r0) == r1) goto L_0x0176;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0129, code lost:
            if (w3.C2872g.g(r3, r4, r0) == r1) goto L_0x0176;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0174, code lost:
            if (w3.C2872g.g(r2, r3, r0) != r1) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0176, code lost:
            return r1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00f2  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x013e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0152  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f20646h
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x0051
                if (r2 == r5) goto L_0x0041
                if (r2 == r4) goto L_0x0021
                if (r2 != r3) goto L_0x0019
                W2.u.b(r19)
                goto L_0x0177
            L_0x0019:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0021:
                long r7 = r0.f20645g
                java.lang.Object r2 = r0.f20644f
                kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
                java.lang.Object r9 = r0.f20643e
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                java.lang.Object r10 = r0.f20642d
                kotlin.jvm.internal.K r10 = (kotlin.jvm.internal.K) r10
                java.lang.Object r11 = r0.f20641c
                kotlin.jvm.internal.J r11 = (kotlin.jvm.internal.J) r11
                java.lang.Object r12 = r0.f20640b
                java.util.zip.ZipInputStream r12 = (java.util.zip.ZipInputStream) r12
                java.lang.Object r13 = r0.f20639a
                java.io.File r13 = (java.io.File) r13
                W2.u.b(r19)
                r5 = r4
                goto L_0x012d
            L_0x0041:
                java.lang.Object r2 = r0.f20641c
                java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2
                java.lang.Object r7 = r0.f20640b
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                java.lang.Object r8 = r0.f20639a
                java.io.File r8 = (java.io.File) r8
                W2.u.b(r19)
                goto L_0x0093
            L_0x0051:
                W2.u.b(r19)
                java.io.File r8 = new java.io.File
                java.lang.String r2 = r0.f20647i
                r8.<init>(r2)
                android.content.Context r2 = r0.f20648j
                android.content.ContentResolver r2 = r2.getContentResolver()
                if (r2 == 0) goto L_0x006e
                androidx.documentfile.provider.DocumentFile r7 = r0.f20649k
                android.net.Uri r7 = r7.getUri()
                java.io.InputStream r2 = r2.openInputStream(r7)
                goto L_0x006f
            L_0x006e:
                r2 = r6
            L_0x006f:
                java.util.zip.ZipInputStream r7 = new java.util.zip.ZipInputStream
                r7.<init>(r2)
                java.util.zip.ZipEntry r2 = r7.getNextEntry()
                w3.I0 r9 = w3.C2865c0.c()
                b2.L$g$a r10 = new b2.L$g$a
                X1.e r11 = r0.f20651m
                r10.<init>(r11, r6)
                r0.f20639a = r8
                r0.f20640b = r7
                r0.f20641c = r2
                r0.f20646h = r5
                java.lang.Object r9 = w3.C2872g.g(r9, r10, r0)
                if (r9 != r1) goto L_0x0093
                goto L_0x0176
            L_0x0093:
                kotlin.jvm.internal.J r9 = new kotlin.jvm.internal.J
                r9.<init>()
                kotlin.jvm.internal.K r10 = new kotlin.jvm.internal.K
                r10.<init>()
            L_0x009d:
                if (r2 == 0) goto L_0x0152
                int r11 = r9.f24688a
                int r11 = r11 + r5
                r9.f24688a = r11
                java.io.File r11 = new java.io.File
                java.lang.String r12 = r2.getName()
                r11.<init>(r8, r12)
                boolean r2 = r2.isDirectory()
                if (r2 == 0) goto L_0x00bd
                boolean r2 = r11.mkdirs()
                kotlin.coroutines.jvm.internal.b.a(r2)
                r5 = r4
                goto L_0x0145
            L_0x00bd:
                java.io.File r2 = r11.getParentFile()
                if (r2 == 0) goto L_0x00cc
                boolean r12 = r2.exists()
                if (r12 != 0) goto L_0x00cc
                r2.mkdirs()
            L_0x00cc:
                java.io.FileOutputStream r2 = new java.io.FileOutputStream
                r2.<init>(r11)
                kotlin.jvm.internal.J r11 = new kotlin.jvm.internal.J
                r11.<init>()
                r12 = 0
                r16 = r9
                r9 = r2
                r2 = r11
                r11 = r16
                r16 = r12
                r12 = r7
                r13 = r8
                r7 = r16
            L_0x00e4:
                b2.L r14 = r0.f20650l
                byte[] r14 = r14.f20536a
                int r14 = r12.read(r14)
                r2.f24688a = r14
                if (r14 <= 0) goto L_0x013e
                long r3 = r10.f24689a
                long r5 = (long) r14
                long r3 = r3 + r5
                r10.f24689a = r3
                long r3 = java.lang.System.currentTimeMillis()
                r5 = 1000(0x3e8, float:1.401E-42)
                long r5 = (long) r5
                long r5 = r5 + r7
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r3 <= 0) goto L_0x012c
                long r7 = java.lang.System.currentTimeMillis()
                w3.I0 r3 = w3.C2865c0.c()
                b2.L$g$b r4 = new b2.L$g$b
                X1.e r5 = r0.f20651m
                r6 = 0
                r4.<init>(r5, r10, r6)
                r0.f20639a = r13
                r0.f20640b = r12
                r0.f20641c = r11
                r0.f20642d = r10
                r0.f20643e = r9
                r0.f20644f = r2
                r0.f20645g = r7
                r5 = 2
                r0.f20646h = r5
                java.lang.Object r3 = w3.C2872g.g(r3, r4, r0)
                if (r3 != r1) goto L_0x012d
                goto L_0x0176
            L_0x012c:
                r5 = 2
            L_0x012d:
                b2.L r3 = r0.f20650l
                byte[] r3 = r3.f20536a
                r4 = 0
                int r6 = r2.f24688a
                r9.write(r3, r4, r6)
                r4 = r5
                r3 = 3
                r5 = 1
                r6 = 0
                goto L_0x00e4
            L_0x013e:
                r5 = r4
                r9.close()
                r9 = r11
                r7 = r12
                r8 = r13
            L_0x0145:
                r7.closeEntry()
                java.util.zip.ZipEntry r2 = r7.getNextEntry()
                r4 = r5
                r3 = 3
                r5 = 1
                r6 = 0
                goto L_0x009d
            L_0x0152:
                r7.close()
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$g$c r3 = new b2.L$g$c
                X1.e r4 = r0.f20651m
                r6 = 0
                r3.<init>(r4, r9, r6)
                r0.f20639a = r6
                r0.f20640b = r6
                r0.f20641c = r6
                r0.f20642d = r6
                r0.f20643e = r6
                r0.f20644f = r6
                r15 = 3
                r0.f20646h = r15
                java.lang.Object r2 = w3.C2872g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0177
            L_0x0176:
                return r1
            L_0x0177:
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: b2.L$h */
    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20660a;

        /* renamed from: b  reason: collision with root package name */
        Object f20661b;

        /* renamed from: c  reason: collision with root package name */
        Object f20662c;

        /* renamed from: d  reason: collision with root package name */
        Object f20663d;

        /* renamed from: e  reason: collision with root package name */
        Object f20664e;

        /* renamed from: f  reason: collision with root package name */
        Object f20665f;

        /* renamed from: g  reason: collision with root package name */
        Object f20666g;

        /* renamed from: h  reason: collision with root package name */
        long f20667h;

        /* renamed from: i  reason: collision with root package name */
        int f20668i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Context f20669j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ DocumentFile f20670k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Uri f20671l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ C2228e f20672m;

        /* renamed from: b2.L$h$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20673a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20674b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20674b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20674b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20673a == 0) {
                    u.b(obj);
                    this.f20674b.c();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$h$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20675a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20676b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20676b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new b(this.f20676b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20675a == 0) {
                    u.b(obj);
                    this.f20676b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$h$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20677a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20678b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(C2228e eVar, C2308e eVar2) {
                super(2, eVar2);
                this.f20678b = eVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20678b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20677a == 0) {
                    u.b(obj);
                    this.f20678b.a();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$h$d */
        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20679a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20680b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ K f20681c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(C2228e eVar, K k5, C2308e eVar2) {
                super(2, eVar2);
                this.f20680b = eVar;
                this.f20681c = k5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new d(this.f20680b, this.f20681c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20679a == 0) {
                    u.b(obj);
                    this.f20680b.d(this.f20681c.f24689a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.L$h$e */
        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20682a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2228e f20683b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.J f20684c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(C2228e eVar, kotlin.jvm.internal.J j5, C2308e eVar2) {
                super(2, eVar2);
                this.f20683b = eVar;
                this.f20684c = j5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new e(this.f20683b, this.f20684c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20682a == 0) {
                    u.b(obj);
                    this.f20683b.b(this.f20684c.f24688a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Context context, DocumentFile documentFile, Uri uri, C2228e eVar, C2308e eVar2) {
            super(2, eVar2);
            this.f20669j = context;
            this.f20670k = documentFile;
            this.f20671l = uri;
            this.f20672m = eVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f20669j, this.f20670k, this.f20671l, this.f20672m, eVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r9v1 */
        /* JADX WARNING: type inference failed for: r11v11, types: [b3.e, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r9v12, types: [boolean, int] */
        /* JADX WARNING: type inference failed for: r11v21 */
        /* JADX WARNING: type inference failed for: r11v40 */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x02d5, code lost:
            if (w3.C2872g.g(r7, r8, r0) == r1) goto L_0x031d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x031b, code lost:
            if (w3.C2872g.g(r2, r3, r0) == r1) goto L_0x031d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0094, code lost:
            if (w3.C2872g.g(r2, r4, r0) == r1) goto L_0x031d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0277, code lost:
            if (w3.C2872g.g(r7, r8, r0) != r1) goto L_0x027b;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x029c  */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x02ae  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x02da  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x02e5  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x02f7  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x014e  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                r26 = this;
                r0 = r26
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f20668i
                java.lang.String r3 = "/"
                r4 = 5
                r5 = 4
                r6 = 3
                r7 = 2
                r8 = 0
                r9 = 1
                r10 = 0
                if (r2 == 0) goto L_0x0080
                if (r2 == r9) goto L_0x007c
                if (r2 == r7) goto L_0x0065
                if (r2 == r6) goto L_0x004e
                if (r2 == r5) goto L_0x002a
                if (r2 != r4) goto L_0x0022
                W2.u.b(r27)
                goto L_0x031e
            L_0x0022:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x002a:
                long r11 = r0.f20667h
                java.lang.Object r2 = r0.f20666g
                kotlin.jvm.internal.J r2 = (kotlin.jvm.internal.J) r2
                java.lang.Object r13 = r0.f20665f
                byte[] r13 = (byte[]) r13
                java.lang.Object r14 = r0.f20664e
                java.io.OutputStream r14 = (java.io.OutputStream) r14
                java.lang.Object r15 = r0.f20663d
                kotlin.jvm.internal.K r15 = (kotlin.jvm.internal.K) r15
                java.lang.Object r4 = r0.f20662c
                kotlin.jvm.internal.J r4 = (kotlin.jvm.internal.J) r4
                java.lang.Object r5 = r0.f20661b
                kotlin.jvm.internal.L r5 = (kotlin.jvm.internal.L) r5
                java.lang.Object r6 = r0.f20660a
                java.util.zip.ZipInputStream r6 = (java.util.zip.ZipInputStream) r6
                W2.u.b(r27)
                r9 = 4
                goto L_0x02d8
            L_0x004e:
                java.lang.Object r2 = r0.f20663d
                kotlin.jvm.internal.K r2 = (kotlin.jvm.internal.K) r2
                java.lang.Object r4 = r0.f20662c
                kotlin.jvm.internal.J r4 = (kotlin.jvm.internal.J) r4
                java.lang.Object r5 = r0.f20661b
                kotlin.jvm.internal.L r5 = (kotlin.jvm.internal.L) r5
                java.lang.Object r6 = r0.f20660a
                java.util.zip.ZipInputStream r6 = (java.util.zip.ZipInputStream) r6
                W2.u.b(r27)
                r10 = r7
                r11 = 3
                goto L_0x027b
            L_0x0065:
                java.lang.Object r2 = r0.f20663d
                kotlin.jvm.internal.K r2 = (kotlin.jvm.internal.K) r2
                java.lang.Object r4 = r0.f20662c
                kotlin.jvm.internal.J r4 = (kotlin.jvm.internal.J) r4
                java.lang.Object r5 = r0.f20661b
                kotlin.jvm.internal.L r5 = (kotlin.jvm.internal.L) r5
                java.lang.Object r6 = r0.f20660a
                java.util.zip.ZipInputStream r6 = (java.util.zip.ZipInputStream) r6
                W2.u.b(r27)
                r11 = r10
                r10 = r7
                goto L_0x0254
            L_0x007c:
                W2.u.b(r27)
                goto L_0x0098
            L_0x0080:
                W2.u.b(r27)
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$h$a r4 = new b2.L$h$a
                X1.e r5 = r0.f20672m
                r4.<init>(r5, r10)
                r0.f20668i = r9
                java.lang.Object r2 = w3.C2872g.g(r2, r4, r0)
                if (r2 != r1) goto L_0x0098
                goto L_0x031d
            L_0x0098:
                android.content.Context r2 = r0.f20669j
                android.content.ContentResolver r2 = r2.getContentResolver()
                if (r2 == 0) goto L_0x00ab
                androidx.documentfile.provider.DocumentFile r4 = r0.f20670k
                android.net.Uri r4 = r4.getUri()
                java.io.InputStream r2 = r2.openInputStream(r4)
                goto L_0x00ac
            L_0x00ab:
                r2 = r10
            L_0x00ac:
                java.util.zip.ZipInputStream r4 = new java.util.zip.ZipInputStream
                r4.<init>(r2)
                java.util.zip.ZipEntry r2 = r4.getNextEntry()
                android.net.Uri r5 = r0.f20671l
                java.lang.String r16 = r5.getLastPathSegment()
                kotlin.jvm.internal.t.b(r16)
                r20 = 6
                r21 = 0
                java.lang.String r17 = ":"
                r18 = 0
                r19 = 0
                int r5 = t3.s.l0(r16, r17, r18, r19, r20, r21)
                r6 = r16
                int r5 = r5 + r9
                java.lang.String r5 = r6.substring(r5)
                java.lang.String r6 = "substring(...)"
                kotlin.jvm.internal.t.d(r5, r6)
                kotlin.jvm.internal.L r6 = new kotlin.jvm.internal.L
                r6.<init>()
                android.content.Context r11 = r0.f20669j
                android.net.Uri r12 = r0.f20671l
                androidx.documentfile.provider.DocumentFile r11 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r11, r12)
                r6.f24690a = r11
                java.lang.String[] r17 = new java.lang.String[]{r3}
                r16 = r5
                java.util.List r5 = t3.s.G0(r16, r17, r18, r19, r20, r21)
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.Iterator r5 = r5.iterator()
            L_0x00f7:
                boolean r11 = r5.hasNext()
                if (r11 == 0) goto L_0x013c
                java.lang.Object r11 = r5.next()
                java.lang.String r11 = (java.lang.String) r11
                java.lang.Object r12 = r6.f24690a
                androidx.documentfile.provider.DocumentFile r12 = (androidx.documentfile.provider.DocumentFile) r12
                if (r12 == 0) goto L_0x0126
                androidx.documentfile.provider.DocumentFile[] r12 = r12.listFiles()
                if (r12 == 0) goto L_0x0126
                int r13 = r12.length
                r14 = r8
                r15 = r10
            L_0x0112:
                if (r14 >= r13) goto L_0x0127
                r16 = r12[r14]
                java.lang.String r7 = r16.getName()
                boolean r7 = t3.s.E(r7, r11, r9)
                if (r7 == 0) goto L_0x0122
                r15 = r16
            L_0x0122:
                int r14 = r14 + 1
                r7 = 2
                goto L_0x0112
            L_0x0126:
                r15 = r10
            L_0x0127:
                if (r15 == 0) goto L_0x012c
                r6.f24690a = r15
                goto L_0x013a
            L_0x012c:
                java.lang.Object r7 = r6.f24690a
                androidx.documentfile.provider.DocumentFile r7 = (androidx.documentfile.provider.DocumentFile) r7
                if (r7 == 0) goto L_0x0137
                androidx.documentfile.provider.DocumentFile r7 = r7.createDirectory(r11)
                goto L_0x0138
            L_0x0137:
                r7 = r10
            L_0x0138:
                r6.f24690a = r7
            L_0x013a:
                r7 = 2
                goto L_0x00f7
            L_0x013c:
                kotlin.jvm.internal.J r5 = new kotlin.jvm.internal.J
                r5.<init>()
                kotlin.jvm.internal.K r7 = new kotlin.jvm.internal.K
                r7.<init>()
                r24 = r6
                r6 = r4
                r4 = r5
                r5 = r24
            L_0x014c:
                if (r2 == 0) goto L_0x02f7
                int r11 = r4.f24688a
                int r11 = r11 + r9
                r4.f24688a = r11
                boolean r11 = r2.isDirectory()
                if (r11 == 0) goto L_0x016a
                java.lang.Object r11 = r5.f24690a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x0166
                java.lang.String r2 = r2.getName()
                r11.createDirectory(r2)
            L_0x0166:
                r11 = r8
                r9 = 4
                goto L_0x02eb
            L_0x016a:
                java.lang.String r11 = r2.getName()
                java.lang.String r2 = r2.getName()
                java.lang.String r12 = "getName(...)"
                kotlin.jvm.internal.t.d(r2, r12)
                java.lang.String[] r19 = new java.lang.String[]{r3}
                r22 = 6
                r23 = 0
                r20 = 0
                r21 = 0
                r18 = r2
                java.util.List r2 = t3.s.G0(r18, r19, r20, r21, r22, r23)
                kotlin.jvm.internal.L r12 = new kotlin.jvm.internal.L
                r12.<init>()
                java.lang.Object r13 = r5.f24690a
                r12.f24690a = r13
                int r13 = r2.size()
                if (r13 <= r9) goto L_0x01fc
                int r11 = r2.size()
                int r11 = r11 - r9
                java.util.List r11 = r2.subList(r8, r11)
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.util.Iterator r11 = r11.iterator()
            L_0x01a7:
                boolean r13 = r11.hasNext()
                if (r13 == 0) goto L_0x01f0
                java.lang.Object r13 = r11.next()
                java.lang.String r13 = (java.lang.String) r13
                java.lang.Object r14 = r5.f24690a
                androidx.documentfile.provider.DocumentFile r14 = (androidx.documentfile.provider.DocumentFile) r14
                if (r14 == 0) goto L_0x01d9
                androidx.documentfile.provider.DocumentFile[] r14 = r14.listFiles()
                if (r14 == 0) goto L_0x01d9
                int r15 = r14.length
                r18 = r10
            L_0x01c2:
                if (r8 >= r15) goto L_0x01d6
                r19 = r14[r8]
                java.lang.String r10 = r19.getName()
                boolean r10 = t3.s.E(r10, r13, r9)
                if (r10 == 0) goto L_0x01d2
                r18 = r19
            L_0x01d2:
                int r8 = r8 + 1
                r10 = 0
                goto L_0x01c2
            L_0x01d6:
                r8 = r18
                goto L_0x01da
            L_0x01d9:
                r8 = 0
            L_0x01da:
                if (r8 == 0) goto L_0x01df
                r12.f24690a = r8
                goto L_0x01ed
            L_0x01df:
                java.lang.Object r8 = r12.f24690a
                androidx.documentfile.provider.DocumentFile r8 = (androidx.documentfile.provider.DocumentFile) r8
                if (r8 == 0) goto L_0x01ea
                androidx.documentfile.provider.DocumentFile r8 = r8.createDirectory(r13)
                goto L_0x01eb
            L_0x01ea:
                r8 = 0
            L_0x01eb:
                r12.f24690a = r8
            L_0x01ed:
                r8 = 0
                r10 = 0
                goto L_0x01a7
            L_0x01f0:
                int r8 = r2.size()
                int r8 = r8 - r9
                java.lang.Object r2 = r2.get(r8)
                r11 = r2
                java.lang.String r11 = (java.lang.String) r11
            L_0x01fc:
                b2.j r2 = new b2.j
                r2.<init>()
                kotlin.jvm.internal.t.b(r11)
                java.lang.String r2 = r2.i(r11)
                java.lang.Object r8 = r12.f24690a
                androidx.documentfile.provider.DocumentFile r8 = (androidx.documentfile.provider.DocumentFile) r8
                if (r8 == 0) goto L_0x0213
                androidx.documentfile.provider.DocumentFile r2 = r8.createFile(r2, r11)
                goto L_0x0214
            L_0x0213:
                r2 = 0
            L_0x0214:
                if (r2 == 0) goto L_0x027c
                android.content.Context r8 = r0.f20669j     // Catch:{ FileNotFoundException -> 0x022e }
                android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ FileNotFoundException -> 0x022e }
                if (r8 == 0) goto L_0x0227
                android.net.Uri r2 = r2.getUri()     // Catch:{ FileNotFoundException -> 0x022e }
                java.io.OutputStream r2 = r8.openOutputStream(r2)     // Catch:{ FileNotFoundException -> 0x022e }
                goto L_0x0228
            L_0x0227:
                r2 = 0
            L_0x0228:
                r10 = r7
                r7 = r2
                r2 = r10
                r10 = 2
                r11 = 0
                goto L_0x0255
            L_0x022e:
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$h$b r8 = new b2.L$h$b
                X1.e r10 = r0.f20672m
                r11 = 0
                r8.<init>(r10, r11)
                r0.f20660a = r6
                r0.f20661b = r5
                r0.f20662c = r4
                r0.f20663d = r7
                r0.f20664e = r11
                r0.f20665f = r11
                r0.f20666g = r11
                r10 = 2
                r0.f20668i = r10
                java.lang.Object r2 = w3.C2872g.g(r2, r8, r0)
                if (r2 != r1) goto L_0x0253
                goto L_0x031d
            L_0x0253:
                r2 = r7
            L_0x0254:
                r7 = r11
            L_0x0255:
                if (r7 != 0) goto L_0x0280
                w3.I0 r7 = w3.C2865c0.c()
                b2.L$h$c r8 = new b2.L$h$c
                X1.e r12 = r0.f20672m
                r8.<init>(r12, r11)
                r0.f20660a = r6
                r0.f20661b = r5
                r0.f20662c = r4
                r0.f20663d = r2
                r0.f20664e = r11
                r0.f20665f = r11
                r0.f20666g = r11
                r11 = 3
                r0.f20668i = r11
                java.lang.Object r7 = w3.C2872g.g(r7, r8, r0)
                if (r7 != r1) goto L_0x027b
                goto L_0x031d
            L_0x027b:
                r7 = r2
            L_0x027c:
                r9 = 4
                r11 = 0
                goto L_0x02eb
            L_0x0280:
                r11 = 3
                r8 = 1024(0x400, float:1.435E-42)
                byte[] r8 = new byte[r8]
                kotlin.jvm.internal.J r12 = new kotlin.jvm.internal.J
                r12.<init>()
                r13 = 0
                r15 = r2
                r2 = r12
                r24 = r13
                r14 = r7
                r13 = r8
                r7 = r24
            L_0x0294:
                int r12 = r6.read(r13)
                r2.f24688a = r12
                if (r12 <= 0) goto L_0x02e5
                long r9 = r15.f24689a
                long r11 = (long) r12
                long r9 = r9 + r11
                r15.f24689a = r9
                long r9 = java.lang.System.currentTimeMillis()
                r11 = 1000(0x3e8, float:1.401E-42)
                long r11 = (long) r11
                long r11 = r11 + r7
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 <= 0) goto L_0x02da
                long r11 = java.lang.System.currentTimeMillis()
                w3.I0 r7 = w3.C2865c0.c()
                b2.L$h$d r8 = new b2.L$h$d
                X1.e r9 = r0.f20672m
                r10 = 0
                r8.<init>(r9, r15, r10)
                r0.f20660a = r6
                r0.f20661b = r5
                r0.f20662c = r4
                r0.f20663d = r15
                r0.f20664e = r14
                r0.f20665f = r13
                r0.f20666g = r2
                r0.f20667h = r11
                r9 = 4
                r0.f20668i = r9
                java.lang.Object r7 = w3.C2872g.g(r7, r8, r0)
                if (r7 != r1) goto L_0x02d8
                goto L_0x031d
            L_0x02d8:
                r7 = r11
                goto L_0x02db
            L_0x02da:
                r9 = 4
            L_0x02db:
                int r10 = r2.f24688a
                r11 = 0
                r14.write(r13, r11, r10)
                r9 = 1
                r10 = 2
                r11 = 3
                goto L_0x0294
            L_0x02e5:
                r9 = 4
                r11 = 0
                r14.close()
                r7 = r15
            L_0x02eb:
                r6.closeEntry()
                java.util.zip.ZipEntry r2 = r6.getNextEntry()
                r8 = r11
                r9 = 1
                r10 = 0
                goto L_0x014c
            L_0x02f7:
                r6.close()
                w3.I0 r2 = w3.C2865c0.c()
                b2.L$h$e r3 = new b2.L$h$e
                X1.e r5 = r0.f20672m
                r10 = 0
                r3.<init>(r5, r4, r10)
                r0.f20660a = r10
                r0.f20661b = r10
                r0.f20662c = r10
                r0.f20663d = r10
                r0.f20664e = r10
                r0.f20665f = r10
                r0.f20666g = r10
                r4 = 5
                r0.f20668i = r4
                java.lang.Object r2 = w3.C2872g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x031e
            L_0x031d:
                return r1
            L_0x031e:
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2280L.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final Object f(DocumentFile documentFile, ZipOutputStream zipOutputStream, Context context, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new a(documentFile, zipOutputStream, context, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object g(File file, String str, ZipOutputStream zipOutputStream, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(file, str, zipOutputStream, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object h(ArrayList arrayList, DocumentFile documentFile, C2226c cVar, Context context, C2308e eVar) {
        DocumentFile documentFile2 = documentFile;
        Context context2 = context;
        Object g5 = C2872g.g(C2865c0.b(), new d(context2, documentFile2, arrayList, this, cVar, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object i(ArrayList arrayList, File file, C2226c cVar, C2308e eVar) {
        File file2 = file;
        Object g5 = C2872g.g(C2865c0.b(), new c(file2, arrayList, this, cVar, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object j(DocumentFile documentFile, Uri uri, C2228e eVar, Context context, C2308e eVar2) {
        Object g5 = C2872g.g(C2865c0.b(), new h(context, documentFile, uri, eVar, (C2308e) null), eVar2);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object k(DocumentFile documentFile, String str, C2228e eVar, Context context, C2308e eVar2) {
        String str2 = str;
        Context context2 = context;
        Object g5 = C2872g.g(C2865c0.b(), new g(str2, context2, documentFile, this, eVar, (C2308e) null), eVar2);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object l(File file, Uri uri, C2228e eVar, Context context, C2308e eVar2) {
        Object g5 = C2872g.g(C2865c0.b(), new f(file, uri, context, eVar, (C2308e) null), eVar2);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final Object m(File file, String str, C2228e eVar, C2308e eVar2) {
        String str2 = str;
        Object g5 = C2872g.g(C2865c0.b(), new e(str2, file, this, eVar, (C2308e) null), eVar2);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }
}
