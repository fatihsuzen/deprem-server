package b2;

import S1.k;
import W2.J;
import W2.u;
import X1.m;
import Y1.h;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import b3.C2308e;
import c3.C2316b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

/* renamed from: b2.K  reason: case insensitive filesystem */
public final class C2279K {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20490b = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f20491a;

    /* renamed from: b2.K$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final boolean a(String str) {
            t.e(str, "filename");
            if (s.D(str, ".xapk", false, 2, (Object) null) || s.D(str, ".apks", false, 2, (Object) null) || s.D(str, ".apkm", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }

        private a() {
        }
    }

    /* renamed from: b2.K$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f20492a;

        /* renamed from: b  reason: collision with root package name */
        Object f20493b;

        /* renamed from: c  reason: collision with root package name */
        Object f20494c;

        /* renamed from: d  reason: collision with root package name */
        Object f20495d;

        /* renamed from: e  reason: collision with root package name */
        Object f20496e;

        /* renamed from: f  reason: collision with root package name */
        Object f20497f;

        /* renamed from: g  reason: collision with root package name */
        Object f20498g;

        /* renamed from: h  reason: collision with root package name */
        Object f20499h;

        /* renamed from: i  reason: collision with root package name */
        Object f20500i;

        /* renamed from: j  reason: collision with root package name */
        Object f20501j;

        /* renamed from: k  reason: collision with root package name */
        Object f20502k;

        /* renamed from: l  reason: collision with root package name */
        int f20503l;

        /* renamed from: m  reason: collision with root package name */
        int f20504m;

        /* renamed from: n  reason: collision with root package name */
        int f20505n;

        /* renamed from: o  reason: collision with root package name */
        long f20506o;

        /* renamed from: p  reason: collision with root package name */
        long f20507p;

        /* renamed from: q  reason: collision with root package name */
        int f20508q;

        /* renamed from: r  reason: collision with root package name */
        final /* synthetic */ File f20509r;

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ C2279K f20510s;

        /* renamed from: t  reason: collision with root package name */
        final /* synthetic */ File f20511t;

        /* renamed from: u  reason: collision with root package name */
        final /* synthetic */ m f20512u;

        /* renamed from: b2.K$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20513a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20514b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(m mVar, C2308e eVar) {
                super(2, eVar);
                this.f20514b = mVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f20514b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20513a == 0) {
                    u.b(obj);
                    m mVar = this.f20514b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.g();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$b  reason: collision with other inner class name */
        static final class C0201b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20515a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20516b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f20517c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0201b(m mVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f20516b = mVar;
                this.f20517c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0201b(this.f20516b, this.f20517c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20515a == 0) {
                    u.b(obj);
                    m mVar = this.f20516b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.d((File) this.f20517c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0201b) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20518a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20519b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f20520c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(m mVar, int i5, C2308e eVar) {
                super(2, eVar);
                this.f20519b = mVar;
                this.f20520c = i5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new c(this.f20519b, this.f20520c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20518a == 0) {
                    u.b(obj);
                    m mVar = this.f20519b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.b(this.f20520c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$d */
        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20521a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20522b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f20523c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(m mVar, L l5, C2308e eVar) {
                super(2, eVar);
                this.f20522b = mVar;
                this.f20523c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new d(this.f20522b, this.f20523c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20521a == 0) {
                    u.b(obj);
                    m mVar = this.f20522b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.c((File) this.f20523c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$e */
        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20524a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20525b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(m mVar, C2308e eVar) {
                super(2, eVar);
                this.f20525b = mVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new e(this.f20525b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20524a == 0) {
                    u.b(obj);
                    m mVar = this.f20525b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.b(100);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$f */
        static final class f extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20526a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20527b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f20528c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f20529d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(m mVar, File file, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f20527b = mVar;
                this.f20528c = file;
                this.f20529d = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new f(this.f20527b, this.f20528c, this.f20529d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20526a == 0) {
                    u.b(obj);
                    k.f32g.f();
                    m mVar = this.f20527b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.a(this.f20528c, this.f20529d);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$g */
        static final class g extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20530a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f20531b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(m mVar, C2308e eVar) {
                super(2, eVar);
                this.f20531b = mVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new g(this.f20531b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20530a == 0) {
                    u.b(obj);
                    m mVar = this.f20531b;
                    if (mVar == null) {
                        return null;
                    }
                    mVar.h();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* renamed from: b2.K$b$h */
        static final class h extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20532a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ I f20533b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ I f20534c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ m f20535d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(I i5, I i6, m mVar, C2308e eVar) {
                super(2, eVar);
                this.f20533b = i5;
                this.f20534c = i6;
                this.f20535d = mVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new h(this.f20533b, this.f20534c, this.f20535d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f20532a == 0) {
                    u.b(obj);
                    if (!this.f20533b.f24687a) {
                        if (!this.f20534c.f24687a) {
                            m mVar = this.f20535d;
                            if (mVar != null) {
                                mVar.e();
                            }
                        } else {
                            m mVar2 = this.f20535d;
                            if (mVar2 != null) {
                                mVar2.h();
                            }
                        }
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(File file, C2279K k5, File file2, m mVar, C2308e eVar) {
            super(2, eVar);
            this.f20509r = file;
            this.f20510s = k5;
            this.f20511t = file2;
            this.f20512u = mVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f20509r, this.f20510s, this.f20511t, this.f20512u, eVar);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(22:99|100|102|103|104|105|106|107|108|109|110|111|(16:113|114|115|116|117|118|(4:120|121|122|(13:125|108|109|110|111|(1:151)|113|114|115|116|117|118|(1:128)(0)))(0)|129|130|131|132|133|134|(9:136|137|138|(9:140|152|153|158|159|160|162|163|(1:180)(0))|141|109|110|111|(0))|38|261)|151|152|153|158|159|160|162|163|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f5, code lost:
            r27 = r7;
            r8 = r9;
            r9 = r11;
            r11 = r12;
            r2 = r13;
            r7 = r3;
            r12 = r5;
            r5 = r18;
            r3 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0302, code lost:
            r19 = r1;
            r21 = r2;
            r4 = r18;
            r5 = r33;
            r1 = r3;
            r3 = r6;
            r10 = r13;
            r12 = r25;
            r8 = r8;
            r9 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
            r2 = r15.getInputStream(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x031f, code lost:
            r33 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
            r6 = new java.io.FileOutputStream((java.io.File) r9.f24690a);
            r1 = new byte[8192];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0333, code lost:
            r20 = r3;
            r3 = r2;
            r2 = r20;
            r22 = r8;
            r20 = r12;
            r12 = new kotlin.jvm.internal.J();
            r18 = r4;
            r13 = r6;
            r4 = r11;
            r11 = r1;
            r1 = r33;
            r33 = r10;
            r10 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0348, code lost:
            r8 = r27;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
            r6 = r3.read(r11);
            r12.f24688a = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0350, code lost:
            r23 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0353, code lost:
            if (r6 == -1) goto L_0x0434;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
            r13.write(r11, 0, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x035b, code lost:
            r6 = r33 + r12.f24688a;
            r24 = r11;
            r10 = (int) ((((double) r6) * 100.0d) / ((double) r8));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x036c, code lost:
            if (r10 <= (r5 + 5)) goto L_0x036e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0372, code lost:
            r27 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x0380, code lost:
            r33 = r6;
            r10 = r23;
            r11 = r24;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0387, code lost:
            r3 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x038a, code lost:
            r27 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
            r8 = java.lang.System.currentTimeMillis();
            S1.k.f32g.V(r10);
            r33 = w3.C2865c0.c();
            r20 = r8;
            r11 = new b2.C2279K.b.c(r0.f20512u, r10, (b3.C2308e) null);
            r0.f20492a = r7;
            r0.f20493b = r2;
            r0.f20494c = r1;
            r0.f20495d = r15;
            r0.f20496e = r3;
            r0.f20497f = r14;
            r0.f20498g = r4;
            r9 = r23;
            r0.f20499h = r9;
            r0.f20500i = r13;
            r0.f20501j = r12;
            r5 = r24;
            r0.f20502k = r5;
            r0.f20503l = r6;
            r8 = r22;
            r0.f20504m = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x03c5, code lost:
            r22 = r1;
            r23 = r2;
            r1 = r27;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
            r0.f20506o = r1;
            r0.f20505n = r10;
            r27 = r1;
            r1 = r20;
            r0.f20507p = r1;
            r20 = r1;
            r0.f20508q = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x03e0, code lost:
            r2 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x03e2, code lost:
            if (w3.C2872g.g(r33, r11, r0) != r2) goto L_0x03e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x03e6, code lost:
            r11 = r5;
            r5 = r10;
            r33 = r22;
            r22 = r8;
            r10 = r9;
            r8 = r27;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x03f5, code lost:
            if (b2.C2279K.a(r0.f20510s) != false) goto L_0x03f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x03f7, code lost:
            r1 = r33;
            r33 = r3;
            r3 = r6;
            r11 = r8;
            r8 = r10;
            r18 = r13;
            r13 = r14;
            r14 = r22;
            r9 = r20;
            r6 = r4;
            r4 = r23;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x040a, code lost:
            r1 = r33;
            r18 = r2;
            r33 = r6;
            r2 = r23;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0414, code lost:
            r1 = r33;
            r10 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0417, code lost:
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x041a, code lost:
            r4 = r7;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x041f, code lost:
            r22 = r1;
            r23 = r2;
            r4 = r7;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0428, code lost:
            r22 = r1;
            r4 = r7;
            r5 = false;
            r10 = r18;
            r3 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x0434, code lost:
            r27 = r8;
            r8 = r22;
            r9 = r23;
            r22 = r1;
            r23 = r2;
            r2 = r18;
            r1 = r3;
            r3 = r33;
            r33 = r1;
            r18 = r13;
            r13 = r14;
            r1 = r22;
            r11 = r27;
            r14 = r8;
            r8 = r9;
            r6 = r4;
            r4 = r23;
            r9 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
            r33.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0457, code lost:
            r10 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0458, code lost:
            r3 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0459, code lost:
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
            r18.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x045f, code lost:
            r18 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0467, code lost:
            if (b2.C2279K.a(r0.f20510s) == false) goto L_0x0469;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0469, code lost:
            kotlin.jvm.internal.t.b(r6);
            r16 = r5;
            r20 = r9;
            r2 = r29;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0479, code lost:
            if (t3.s.D(r6, r2, false, 2, (java.lang.Object) null) != false) goto L_0x047b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x047b, code lost:
            r6 = w3.C2865c0.c();
            r10 = new b2.C2279K.b.d(r0.f20512u, r8, (b3.C2308e) null);
            r0.f20492a = r7;
            r0.f20493b = r4;
            r0.f20494c = r1;
            r0.f20495d = r15;
            r0.f20496e = r13;
            r0.f20497f = null;
            r0.f20498g = null;
            r0.f20499h = null;
            r0.f20500i = null;
            r0.f20501j = null;
            r0.f20502k = null;
            r0.f20503l = r3;
            r0.f20504m = r14;
            r0.f20506o = r11;
            r5 = r16;
            r0.f20505n = r5;
            r8 = r20;
            r0.f20507p = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x04ab, code lost:
            r16 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
            r0.f20508q = 4;
            r1 = w3.C2872g.g(r6, r10, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x04b4, code lost:
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x04b6, code lost:
            if (r1 == r10) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x04ba, code lost:
            r6 = r7;
            r1 = r14;
            r7 = r4;
            r4 = r3;
            r3 = r5;
            r5 = r15;
            r15 = r13;
            r13 = r11;
            r11 = r8;
            r8 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x04c5, code lost:
            r17 = r8;
            r8 = r1;
            r1 = r5;
            r5 = r3;
            r3 = r17;
            r17 = r7;
            r7 = r6;
            r6 = r17;
            r30 = r13;
            r13 = r11;
            r11 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x04da, code lost:
            r10 = r18;
            r3 = r4;
            r4 = r7;
            r1 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x04e2, code lost:
            r16 = r1;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x04e8, code lost:
            r5 = r16;
            r8 = r20;
            r10 = r18;
            r16 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x04f1, code lost:
            r8 = r9;
            r2 = r29;
            r16 = r1;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x04f8, code lost:
            r6 = r4;
            r1 = r15;
            r4 = r3;
            r15 = r13;
            r3 = r16;
            r30 = r8;
            r8 = r14;
            r13 = r30;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0506, code lost:
            r22 = r1;
            r23 = r2;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x050e, code lost:
            r10 = r4;
            r1 = r33;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0513, code lost:
            r33 = r1;
            r10 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0518, code lost:
            r10 = r18;
            r1 = r3;
            r3 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x051e, code lost:
            r19 = r1;
            r2 = r4;
            r20 = r8;
            r10 = r18;
            r8 = r25;
            r5 = false;
            r1 = r33;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:?, code lost:
            r6.f24687a = false;
            S1.k.f32g.f();
            r7.f24687a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0533, code lost:
            r5 = r1;
            r4 = r13;
            r1 = r15;
            r11 = r27;
            r15 = r14;
            r13 = r8;
            r8 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x053e, code lost:
            r8 = r8 + 1;
            r18 = r10;
            r9 = r11;
            r11 = r13;
            r14 = r15;
            r15 = r1;
            r13 = r4;
            r1 = r19;
            r4 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x054c, code lost:
            r17 = true;
            r1 = r3;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0553, code lost:
            r10 = r18;
            r17 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0557, code lost:
            r1 = r3;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x055a, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x055d, code lost:
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x0560, code lost:
            r1 = r5;
            r10 = r18;
            r17 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x0567, code lost:
            if (r7.f24687a == false) goto L_0x05af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x0575, code lost:
            S1.k.f32g.V(100);
            r1 = w3.C2865c0.c();
            r2 = new b2.C2279K.b.e(r0.f20512u, (b3.C2308e) null);
            r0.f20492a = r7;
            r0.f20493b = r6;
            r0.f20494c = r3;
            r0.f20495d = null;
            r0.f20496e = null;
            r0.f20497f = null;
            r0.f20498g = null;
            r0.f20499h = null;
            r0.f20500i = null;
            r0.f20501j = null;
            r0.f20502k = null;
            r0.f20508q = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x05a3, code lost:
            if (w3.C2872g.g(r1, r2, r0) == r10) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x05a7, code lost:
            r1 = r3;
            r3 = r6;
            r4 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x05aa, code lost:
            r6 = r3;
            r7 = r4;
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x05af, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x05b1, code lost:
            r10 = r2;
            r17 = true;
            r1 = r3;
            r3 = r5;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x05cd, code lost:
            r1 = r0.f20511t.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x05d3, code lost:
            if (r1 != null) goto L_0x05d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x05d5, code lost:
            r2 = new java.util.ArrayList();
            X2.C2250q.v(r2, r1);
            r1 = w3.C2865c0.c();
            r3 = new b2.C2279K.b.f(r0.f20512u, r0.f20509r, r2, (b3.C2308e) null);
            r0.f20492a = null;
            r0.f20493b = null;
            r0.f20494c = null;
            r0.f20495d = null;
            r0.f20496e = null;
            r0.f20497f = null;
            r0.f20498g = null;
            r0.f20499h = null;
            r0.f20500i = null;
            r0.f20501j = null;
            r0.f20502k = null;
            r0.f20508q = 6;
            r1 = w3.C2872g.g(r1, r3, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x0608, code lost:
            if (r1 == r10) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0614, code lost:
            if (r3.isEmpty() == false) goto L_0x0616;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x0616, code lost:
            r1 = r3.iterator();
            kotlin.jvm.internal.t.d(r1, "iterator(...)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x0621, code lost:
            if (r1.hasNext() != false) goto L_0x0623;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x0623, code lost:
            r3 = r1.next();
            kotlin.jvm.internal.t.d(r3, "next(...)");
            ((java.io.File) r3).delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:236:0x0630, code lost:
            S1.k.f32g.f();
            r1 = w3.C2865c0.c();
            r2 = new b2.C2279K.b.g(r0.f20512u, (b3.C2308e) null);
            r0.f20492a = null;
            r0.f20493b = null;
            r0.f20494c = null;
            r0.f20495d = null;
            r0.f20496e = null;
            r0.f20497f = null;
            r0.f20498g = null;
            r0.f20499h = null;
            r0.f20500i = null;
            r0.f20501j = null;
            r0.f20502k = null;
            r0.f20508q = 7;
            r1 = w3.C2872g.g(r1, r2, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:237:0x065e, code lost:
            if (r1 == r10) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x0666, code lost:
            r1 = r0.f20511t.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x066c, code lost:
            if (r1 != null) goto L_0x066e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x066f, code lost:
            if (r1.length != 0) goto L_0x0672;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:243:0x0672, code lost:
            r17 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x0674, code lost:
            if (r17 == false) goto L_0x0676;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:245:0x0676, code lost:
            r1 = kotlin.jvm.internal.C2625c.a(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:247:0x067e, code lost:
            if (r1.hasNext() != false) goto L_0x0680;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:248:0x0680, code lost:
            ((java.io.File) r1.next()).delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:250:0x068e, code lost:
            if (r3.isEmpty() == false) goto L_0x0690;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x0690, code lost:
            r1 = r3.iterator();
            kotlin.jvm.internal.t.d(r1, "iterator(...)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x069b, code lost:
            if (r1.hasNext() != false) goto L_0x069d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:254:0x069d, code lost:
            r3 = r1.next();
            kotlin.jvm.internal.t.d(r3, "next(...)");
            ((java.io.File) r3).delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:255:0x06aa, code lost:
            S1.k.f32g.f();
            r1 = w3.C2865c0.c();
            r2 = new b2.C2279K.b.h(r7, r6, r0.f20512u, (b3.C2308e) null);
            r0.f20492a = null;
            r0.f20493b = null;
            r0.f20494c = null;
            r0.f20495d = null;
            r0.f20496e = null;
            r0.f20497f = null;
            r0.f20498g = null;
            r0.f20499h = null;
            r0.f20500i = null;
            r0.f20501j = null;
            r0.f20502k = null;
            r0.f20508q = 8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:256:0x06d9, code lost:
            if (w3.C2872g.g(r1, r2, r0) == r10) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:262:?, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:263:?, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:266:?, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:267:?, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:268:?, code lost:
            return W2.J.f19942a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:269:?, code lost:
            return (W2.J) r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:270:?, code lost:
            return (W2.J) r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r7 = new java.util.zip.ZipFile(r0.f20509r);
            r8 = r7.entries();
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0190, code lost:
            if (r8.hasMoreElements() == false) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x019c, code lost:
            r9 = r9 + ((java.util.zip.ZipEntry) r8.nextElement()).getSize();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x019e, code lost:
            r10 = r2;
            r1 = r3;
            r3 = r5;
            r4 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            r11 = java.lang.System.currentTimeMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x01ac, code lost:
            r18 = r2;
            r15 = r7;
            r14 = r7.entries();
            r8 = 0;
            r13 = 0;
            r7 = r6;
            r6 = r5;
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b7, code lost:
            if (r7.f24687a == false) goto L_0x0560;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c7, code lost:
            r2 = (java.util.zip.ZipEntry) r14.nextElement();
            r25 = r11;
            r11 = r2.getName();
            kotlin.jvm.internal.t.b(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d6, code lost:
            r33 = r5;
            r27 = r9;
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e3, code lost:
            if (t3.s.D(r11, r4, false, 2, (java.lang.Object) null) == false) goto L_0x01e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            kotlin.jvm.internal.t.b(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e8, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ed, code lost:
            if (t3.s.D(r11, ".obb", false, 2, (java.lang.Object) null) == false) goto L_0x01f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f0, code lost:
            r19 = r1;
            r2 = r4;
            r20 = r8;
            r10 = r18;
            r8 = r25;
            r1 = r33;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x01fd, code lost:
            r1 = r3;
            r3 = r6;
            r4 = r7;
            r5 = r10;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0205, code lost:
            r1 = r3;
            r3 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0207, code lost:
            r4 = r7;
            r10 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0218, code lost:
            if (r2.getSize() < r0.f20511t.getUsableSpace()) goto L_0x021a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            r9 = new kotlin.jvm.internal.L();
            r9.f24690a = new java.io.File(r0.f20511t, r11);
            kotlin.jvm.internal.t.b(r11);
            r29 = r4;
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0234, code lost:
            if (t3.s.D(r11, ".obb", false, 2, (java.lang.Object) null) != false) goto L_0x0236;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            kotlin.jvm.internal.t.b(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x023f, code lost:
            if (t3.s.V(r11, "/", false, 2, (java.lang.Object) null) != false) goto L_0x0241;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            kotlin.jvm.internal.t.b(r11);
            r4 = t3.s.l0(r11, "/", 0, false, 6, (java.lang.Object) null);
            kotlin.jvm.internal.t.b(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0257, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            r5 = r11.substring(0, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
            kotlin.jvm.internal.t.d(r5, r1);
            r10 = new java.io.File(android.os.Environment.getExternalStorageDirectory() + '/' + r5);
            r10.mkdirs();
            kotlin.jvm.internal.t.b(r11);
            r4 = r11.substring(r4 + 1);
            kotlin.jvm.internal.t.d(r4, r1);
            r12 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x028f, code lost:
            r12 = r11;
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0291, code lost:
            r4 = new java.io.File(r10, r12);
            r9.f24690a = r4;
            r3.add(r4);
            r4 = w3.C2865c0.c();
            r5 = new b2.C2279K.b.C0201b(r0.f20512u, r9, (b3.C2308e) null);
            r0.f20492a = r7;
            r0.f20493b = r6;
            r0.f20494c = r3;
            r0.f20495d = r15;
            r0.f20496e = r14;
            r0.f20497f = r2;
            r0.f20498g = r12;
            r0.f20499h = r9;
            r0.f20500i = null;
            r0.f20501j = null;
            r0.f20502k = null;
            r0.f20503l = r13;
            r0.f20504m = r8;
            r10 = r27;
            r0.f20506o = r10;
            r19 = r1;
            r1 = r33;
            r0.f20505n = r1;
            r20 = r8;
            r33 = r9;
            r8 = r25;
            r0.f20507p = r8;
            r21 = r2;
            r0.f20508q = 2;
            r2 = w3.C2872g.g(r4, r5, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x02dd, code lost:
            r4 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x02df, code lost:
            if (r2 == r4) goto L_0x02e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x02e4, code lost:
            r18 = r20;
            r20 = r6;
            r5 = r8;
            r9 = r18;
            r18 = r1;
            r1 = r3;
            r3 = r7;
            r7 = r10;
            r10 = r13;
            r13 = r21;
            r11 = r33;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:158:0x045c */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x0355  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x036e A[SYNTHETIC, Splitter:B:120:0x036e] */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x038a  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x03e6  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x0434  */
        /* JADX WARNING: Removed duplicated region for block: B:155:? A[ExcHandler: Exception (unused java.lang.Exception), SYNTHETIC, Splitter:B:152:0x0453] */
        /* JADX WARNING: Removed duplicated region for block: B:165:0x0469 A[Catch:{ Exception -> 0x04e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:180:0x04f1  */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x0560  */
        /* JADX WARNING: Removed duplicated region for block: B:225:0x05cd  */
        /* JADX WARNING: Removed duplicated region for block: B:239:0x0666  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01c7 A[Catch:{ Exception -> 0x0553 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r33) {
            /*
                r32 = this;
                r0 = r32
                java.lang.String r1 = "substring(...)"
                java.lang.Object r2 = c3.C2316b.f()
                int r3 = r0.f20508q
                java.lang.String r4 = ".apk"
                switch(r3) {
                    case 0: goto L_0x0133;
                    case 1: goto L_0x0123;
                    case 2: goto L_0x00dd;
                    case 3: goto L_0x0077;
                    case 4: goto L_0x0044;
                    case 5: goto L_0x002a;
                    case 6: goto L_0x0023;
                    case 7: goto L_0x001c;
                    case 8: goto L_0x0017;
                    default: goto L_0x000f;
                }
            L_0x000f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0017:
                W2.u.b(r33)
                goto L_0x06dc
            L_0x001c:
                W2.u.b(r33)
                r1 = r33
                goto L_0x0662
            L_0x0023:
                W2.u.b(r33)
                r1 = r33
                goto L_0x060c
            L_0x002a:
                java.lang.Object r1 = r0.f20494c
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                java.lang.Object r3 = r0.f20493b
                kotlin.jvm.internal.I r3 = (kotlin.jvm.internal.I) r3
                java.lang.Object r4 = r0.f20492a
                kotlin.jvm.internal.I r4 = (kotlin.jvm.internal.I) r4
                W2.u.b(r33)     // Catch:{ Exception -> 0x003e }
                r10 = r2
                r17 = 1
                goto L_0x05aa
            L_0x003e:
                r10 = r2
            L_0x003f:
                r5 = 0
            L_0x0040:
                r17 = 1
                goto L_0x05b8
            L_0x0044:
                long r9 = r0.f20507p
                int r3 = r0.f20505n
                long r11 = r0.f20506o
                int r13 = r0.f20504m
                int r14 = r0.f20503l
                java.lang.Object r15 = r0.f20496e
                java.util.Enumeration r15 = (java.util.Enumeration) r15
                java.lang.Object r5 = r0.f20495d
                java.util.zip.ZipFile r5 = (java.util.zip.ZipFile) r5
                java.lang.Object r8 = r0.f20494c
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                java.lang.Object r7 = r0.f20493b
                kotlin.jvm.internal.I r7 = (kotlin.jvm.internal.I) r7
                java.lang.Object r6 = r0.f20492a
                kotlin.jvm.internal.I r6 = (kotlin.jvm.internal.I) r6
                W2.u.b(r33)     // Catch:{ Exception -> 0x0072 }
                r19 = r1
                r1 = r13
                r30 = r9
                r10 = r2
                r2 = r4
                r4 = r14
                r13 = r11
                r11 = r30
                goto L_0x04c5
            L_0x0072:
                r10 = r2
                r4 = r6
                r3 = r7
                r1 = r8
                goto L_0x003f
            L_0x0077:
                long r5 = r0.f20507p
                int r3 = r0.f20505n
                long r7 = r0.f20506o
                int r9 = r0.f20504m
                int r10 = r0.f20503l
                java.lang.Object r11 = r0.f20502k
                byte[] r11 = (byte[]) r11
                java.lang.Object r12 = r0.f20501j
                kotlin.jvm.internal.J r12 = (kotlin.jvm.internal.J) r12
                java.lang.Object r13 = r0.f20500i
                java.io.FileOutputStream r13 = (java.io.FileOutputStream) r13
                java.lang.Object r14 = r0.f20499h
                kotlin.jvm.internal.L r14 = (kotlin.jvm.internal.L) r14
                java.lang.Object r15 = r0.f20498g
                java.lang.String r15 = (java.lang.String) r15
                r18 = r3
                java.lang.Object r3 = r0.f20497f
                java.util.Enumeration r3 = (java.util.Enumeration) r3
                r19 = r3
                java.lang.Object r3 = r0.f20496e
                java.io.InputStream r3 = (java.io.InputStream) r3
                r20 = r3
                java.lang.Object r3 = r0.f20495d
                java.util.zip.ZipFile r3 = (java.util.zip.ZipFile) r3
                r21 = r3
                java.lang.Object r3 = r0.f20494c
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                r22 = r3
                java.lang.Object r3 = r0.f20493b
                kotlin.jvm.internal.I r3 = (kotlin.jvm.internal.I) r3
                r23 = r3
                java.lang.Object r3 = r0.f20492a
                kotlin.jvm.internal.I r3 = (kotlin.jvm.internal.I) r3
                W2.u.b(r33)     // Catch:{ Exception -> 0x00d5 }
                r29 = r4
                r4 = r15
                r15 = r21
                r33 = r22
                r22 = r9
                r8 = r7
                r7 = r3
                r3 = r20
                r20 = r5
                r6 = r10
                r10 = r14
                r5 = r18
                r14 = r19
                r19 = r1
                goto L_0x03ef
            L_0x00d5:
                r10 = r2
                r4 = r3
            L_0x00d7:
                r1 = r22
            L_0x00d9:
                r3 = r23
                goto L_0x003f
            L_0x00dd:
                long r5 = r0.f20507p
                int r3 = r0.f20505n
                long r7 = r0.f20506o
                int r9 = r0.f20504m
                int r10 = r0.f20503l
                java.lang.Object r11 = r0.f20499h
                kotlin.jvm.internal.L r11 = (kotlin.jvm.internal.L) r11
                java.lang.Object r12 = r0.f20498g
                java.lang.String r12 = (java.lang.String) r12
                java.lang.Object r13 = r0.f20497f
                java.util.zip.ZipEntry r13 = (java.util.zip.ZipEntry) r13
                java.lang.Object r14 = r0.f20496e
                java.util.Enumeration r14 = (java.util.Enumeration) r14
                java.lang.Object r15 = r0.f20495d
                java.util.zip.ZipFile r15 = (java.util.zip.ZipFile) r15
                r18 = r3
                java.lang.Object r3 = r0.f20494c
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                r19 = r3
                java.lang.Object r3 = r0.f20493b
                kotlin.jvm.internal.I r3 = (kotlin.jvm.internal.I) r3
                r20 = r3
                java.lang.Object r3 = r0.f20492a
                kotlin.jvm.internal.I r3 = (kotlin.jvm.internal.I) r3
                W2.u.b(r33)     // Catch:{ Exception -> 0x011b }
                r29 = r19
                r19 = r1
                r1 = r29
                r29 = r4
                r4 = r2
                goto L_0x02f5
            L_0x011b:
                r10 = r2
                r4 = r3
                r1 = r19
                r3 = r20
                goto L_0x003f
            L_0x0123:
                java.lang.Object r3 = r0.f20494c
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                java.lang.Object r5 = r0.f20493b
                kotlin.jvm.internal.I r5 = (kotlin.jvm.internal.I) r5
                java.lang.Object r6 = r0.f20492a
                kotlin.jvm.internal.I r6 = (kotlin.jvm.internal.I) r6
                W2.u.b(r33)
                goto L_0x017f
            L_0x0133:
                W2.u.b(r33)
                kotlin.jvm.internal.I r3 = new kotlin.jvm.internal.I
                r3.<init>()
                r5 = 1
                r3.f24687a = r5
                kotlin.jvm.internal.I r6 = new kotlin.jvm.internal.I
                r6.<init>()
                r6.f24687a = r5
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                S1.k$a r7 = S1.k.f32g
                java.io.File r8 = r0.f20509r
                java.lang.String r8 = r8.getAbsolutePath()
                java.lang.String r9 = "getAbsolutePath(...)"
                kotlin.jvm.internal.t.d(r8, r9)
                r9 = 0
                r7.C(r8, r9)
                w3.I0 r7 = w3.C2865c0.c()
                b2.K$b$a r8 = new b2.K$b$a
                X1.m r9 = r0.f20512u
                r10 = 0
                r8.<init>(r9, r10)
                r0.f20492a = r3
                r0.f20493b = r6
                r0.f20494c = r5
                r9 = 1
                r0.f20508q = r9
                java.lang.Object r7 = w3.C2872g.g(r7, r8, r0)
                if (r7 != r2) goto L_0x0179
            L_0x0176:
                r10 = r2
                goto L_0x06db
            L_0x0179:
                r30 = r6
                r6 = r3
                r3 = r5
                r5 = r30
            L_0x017f:
                java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x05b1 }
                java.io.File r8 = r0.f20509r     // Catch:{ Exception -> 0x05b1 }
                r7.<init>(r8)     // Catch:{ Exception -> 0x05b1 }
                java.util.Enumeration r8 = r7.entries()     // Catch:{ Exception -> 0x05b1 }
                r9 = 0
            L_0x018c:
                boolean r11 = r8.hasMoreElements()     // Catch:{ Exception -> 0x05b1 }
                if (r11 == 0) goto L_0x01a4
                java.lang.Object r11 = r8.nextElement()     // Catch:{ Exception -> 0x019e }
                java.util.zip.ZipEntry r11 = (java.util.zip.ZipEntry) r11     // Catch:{ Exception -> 0x019e }
                long r11 = r11.getSize()     // Catch:{ Exception -> 0x019e }
                long r9 = r9 + r11
                goto L_0x018c
            L_0x019e:
                r10 = r2
                r1 = r3
                r3 = r5
                r4 = r6
                goto L_0x003f
            L_0x01a4:
                long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b1 }
                java.util.Enumeration r8 = r7.entries()     // Catch:{ Exception -> 0x05b1 }
                r18 = r2
                r15 = r7
                r14 = r8
                r8 = 0
                r13 = 0
                r7 = r6
                r6 = r5
                r5 = 0
            L_0x01b5:
                boolean r2 = r7.f24687a     // Catch:{ Exception -> 0x0553 }
                if (r2 == 0) goto L_0x0560
                b2.K r2 = r0.f20510s     // Catch:{ Exception -> 0x0553 }
                boolean r2 = r2.f20491a     // Catch:{ Exception -> 0x0553 }
                if (r2 != 0) goto L_0x0560
                boolean r2 = r14.hasMoreElements()     // Catch:{ Exception -> 0x0553 }
                if (r2 == 0) goto L_0x0560
                java.lang.Object r2 = r14.nextElement()     // Catch:{ Exception -> 0x0553 }
                java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ Exception -> 0x0553 }
                r25 = r11
                java.lang.String r11 = r2.getName()     // Catch:{ Exception -> 0x0553 }
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x0553 }
                r33 = r5
                r27 = r9
                r5 = 0
                r9 = 0
                r12 = 2
                boolean r10 = t3.s.D(r11, r4, r5, r12, r9)     // Catch:{ Exception -> 0x055d }
                java.lang.String r5 = ".obb"
                if (r10 != 0) goto L_0x020c
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x0205 }
                r10 = 0
                boolean r19 = t3.s.D(r11, r5, r10, r12, r9)     // Catch:{ Exception -> 0x01fd }
                if (r19 == 0) goto L_0x01f0
                goto L_0x020c
            L_0x01f0:
                r19 = r1
                r2 = r4
                r20 = r8
                r10 = r18
                r8 = r25
                r1 = r33
                goto L_0x0533
            L_0x01fd:
                r1 = r3
                r3 = r6
                r4 = r7
                r5 = r10
                r10 = r18
                goto L_0x0040
            L_0x0205:
                r1 = r3
                r3 = r6
            L_0x0207:
                r4 = r7
                r10 = r18
                goto L_0x003f
            L_0x020c:
                long r9 = r2.getSize()     // Catch:{ Exception -> 0x0553 }
                java.io.File r12 = r0.f20511t     // Catch:{ Exception -> 0x0553 }
                long r19 = r12.getUsableSpace()     // Catch:{ Exception -> 0x0553 }
                int r9 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
                if (r9 >= 0) goto L_0x051e
                kotlin.jvm.internal.L r9 = new kotlin.jvm.internal.L     // Catch:{ Exception -> 0x0518 }
                r9.<init>()     // Catch:{ Exception -> 0x0518 }
                java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0518 }
                java.io.File r12 = r0.f20511t     // Catch:{ Exception -> 0x0518 }
                r10.<init>(r12, r11)     // Catch:{ Exception -> 0x0518 }
                r9.f24690a = r10     // Catch:{ Exception -> 0x0518 }
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x0518 }
                r29 = r4
                r4 = 0
                r10 = 0
                r12 = 2
                boolean r5 = t3.s.D(r11, r5, r10, r12, r4)     // Catch:{ Exception -> 0x0518 }
                if (r5 == 0) goto L_0x0302
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x01fd }
                java.lang.String r5 = "/"
                boolean r5 = t3.s.V(r11, r5, r10, r12, r4)     // Catch:{ Exception -> 0x01fd }
                if (r5 == 0) goto L_0x028f
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x0205 }
                java.lang.String r20 = "/"
                r23 = 6
                r24 = 0
                r21 = 0
                r22 = 0
                r19 = r11
                int r4 = t3.s.l0(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x0205 }
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x0205 }
                r10 = 0
                java.lang.String r5 = r11.substring(r10, r4)     // Catch:{ Exception -> 0x01fd }
                kotlin.jvm.internal.t.d(r5, r1)     // Catch:{ Exception -> 0x0205 }
                java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0205 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0205 }
                r12.<init>()     // Catch:{ Exception -> 0x0205 }
                r19 = r4
                java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0205 }
                r12.append(r4)     // Catch:{ Exception -> 0x0205 }
                r4 = 47
                r12.append(r4)     // Catch:{ Exception -> 0x0205 }
                r12.append(r5)     // Catch:{ Exception -> 0x0205 }
                java.lang.String r4 = r12.toString()     // Catch:{ Exception -> 0x0205 }
                r10.<init>(r4)     // Catch:{ Exception -> 0x0205 }
                r10.mkdirs()     // Catch:{ Exception -> 0x0205 }
                kotlin.jvm.internal.t.b(r11)     // Catch:{ Exception -> 0x0205 }
                int r4 = r19 + 1
                java.lang.String r4 = r11.substring(r4)     // Catch:{ Exception -> 0x0205 }
                kotlin.jvm.internal.t.d(r4, r1)     // Catch:{ Exception -> 0x0205 }
                r12 = r4
                goto L_0x0291
            L_0x028f:
                r12 = r11
                r10 = 0
            L_0x0291:
                java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0205 }
                r4.<init>(r10, r12)     // Catch:{ Exception -> 0x0205 }
                r9.f24690a = r4     // Catch:{ Exception -> 0x0205 }
                r3.add(r4)     // Catch:{ Exception -> 0x0205 }
                w3.I0 r4 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0205 }
                b2.K$b$b r5 = new b2.K$b$b     // Catch:{ Exception -> 0x0205 }
                X1.m r10 = r0.f20512u     // Catch:{ Exception -> 0x0205 }
                r11 = 0
                r5.<init>(r10, r9, r11)     // Catch:{ Exception -> 0x0205 }
                r0.f20492a = r7     // Catch:{ Exception -> 0x0205 }
                r0.f20493b = r6     // Catch:{ Exception -> 0x0205 }
                r0.f20494c = r3     // Catch:{ Exception -> 0x0205 }
                r0.f20495d = r15     // Catch:{ Exception -> 0x0205 }
                r0.f20496e = r14     // Catch:{ Exception -> 0x0205 }
                r0.f20497f = r2     // Catch:{ Exception -> 0x0205 }
                r0.f20498g = r12     // Catch:{ Exception -> 0x0205 }
                r0.f20499h = r9     // Catch:{ Exception -> 0x0205 }
                r10 = 0
                r0.f20500i = r10     // Catch:{ Exception -> 0x0205 }
                r0.f20501j = r10     // Catch:{ Exception -> 0x0205 }
                r0.f20502k = r10     // Catch:{ Exception -> 0x0205 }
                r0.f20503l = r13     // Catch:{ Exception -> 0x0205 }
                r0.f20504m = r8     // Catch:{ Exception -> 0x0205 }
                r10 = r27
                r0.f20506o = r10     // Catch:{ Exception -> 0x0205 }
                r19 = r1
                r1 = r33
                r0.f20505n = r1     // Catch:{ Exception -> 0x0205 }
                r20 = r8
                r33 = r9
                r8 = r25
                r0.f20507p = r8     // Catch:{ Exception -> 0x0205 }
                r21 = r2
                r2 = 2
                r0.f20508q = r2     // Catch:{ Exception -> 0x0205 }
                java.lang.Object r2 = w3.C2872g.g(r4, r5, r0)     // Catch:{ Exception -> 0x0205 }
                r4 = r18
                if (r2 != r4) goto L_0x02e4
                r10 = r4
                goto L_0x06db
            L_0x02e4:
                r18 = r20
                r20 = r6
                r5 = r8
                r9 = r18
                r18 = r1
                r1 = r3
                r3 = r7
                r7 = r10
                r10 = r13
                r13 = r21
                r11 = r33
            L_0x02f5:
                r27 = r7
                r8 = r9
                r9 = r11
                r11 = r12
                r2 = r13
                r7 = r3
                r12 = r5
                r5 = r18
                r3 = r20
                goto L_0x0319
            L_0x0302:
                r19 = r1
                r21 = r2
                r20 = r8
                r4 = r18
                r1 = r33
                r33 = r9
                r8 = r25
                r5 = r1
                r1 = r3
                r3 = r6
                r10 = r13
                r12 = r8
                r8 = r20
                r9 = r33
            L_0x0319:
                java.io.InputStream r2 = r15.getInputStream(r2)     // Catch:{ Exception -> 0x0513 }
                java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0513 }
                r33 = r1
                java.lang.Object r1 = r9.f24690a     // Catch:{ Exception -> 0x050e }
                java.io.File r1 = (java.io.File) r1     // Catch:{ Exception -> 0x050e }
                r6.<init>(r1)     // Catch:{ Exception -> 0x050e }
                kotlin.jvm.internal.J r1 = new kotlin.jvm.internal.J     // Catch:{ Exception -> 0x050e }
                r1.<init>()     // Catch:{ Exception -> 0x050e }
                r18 = r1
                r1 = 8192(0x2000, float:1.14794E-41)
                byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x050e }
                r20 = r3
                r3 = r2
                r2 = r20
                r22 = r8
                r20 = r12
                r12 = r18
                r18 = r4
                r13 = r6
                r4 = r11
                r11 = r1
                r1 = r33
                r33 = r10
                r10 = r9
            L_0x0348:
                r8 = r27
            L_0x034a:
                int r6 = r3.read(r11)     // Catch:{ Exception -> 0x0506 }
                r12.f24688a = r6     // Catch:{ Exception -> 0x0506 }
                r23 = r10
                r10 = -1
                if (r6 == r10) goto L_0x0434
                r10 = 0
                r13.write(r11, r10, r6)     // Catch:{ Exception -> 0x0428 }
                int r6 = r12.f24688a     // Catch:{ Exception -> 0x041f }
                int r6 = r33 + r6
                r24 = r11
                double r10 = (double) r6
                r25 = 4636737291354636288(0x4059000000000000, double:100.0)
                double r10 = r10 * r25
                r25 = r10
                double r10 = (double) r8
                double r10 = r25 / r10
                int r10 = (int) r10
                int r11 = r5 + 5
                if (r10 > r11) goto L_0x038a
                long r25 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0387 }
                r11 = 1000(0x3e8, float:1.401E-42)
                r27 = r8
                long r8 = (long) r11
                long r8 = r20 + r8
                int r8 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
                if (r8 <= 0) goto L_0x0380
                if (r10 == r5) goto L_0x0380
                goto L_0x038c
            L_0x0380:
                r33 = r6
                r10 = r23
                r11 = r24
                goto L_0x0348
            L_0x0387:
                r3 = r2
                goto L_0x0207
            L_0x038a:
                r27 = r8
            L_0x038c:
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x041f }
                S1.k$a r5 = S1.k.f32g     // Catch:{ Exception -> 0x041f }
                r5.V(r10)     // Catch:{ Exception -> 0x041f }
                w3.I0 r5 = w3.C2865c0.c()     // Catch:{ Exception -> 0x041f }
                b2.K$b$c r11 = new b2.K$b$c     // Catch:{ Exception -> 0x041f }
                r33 = r5
                X1.m r5 = r0.f20512u     // Catch:{ Exception -> 0x041f }
                r20 = r8
                r8 = 0
                r11.<init>(r5, r10, r8)     // Catch:{ Exception -> 0x041f }
                r0.f20492a = r7     // Catch:{ Exception -> 0x041f }
                r0.f20493b = r2     // Catch:{ Exception -> 0x041f }
                r0.f20494c = r1     // Catch:{ Exception -> 0x041f }
                r0.f20495d = r15     // Catch:{ Exception -> 0x041f }
                r0.f20496e = r3     // Catch:{ Exception -> 0x041f }
                r0.f20497f = r14     // Catch:{ Exception -> 0x041f }
                r0.f20498g = r4     // Catch:{ Exception -> 0x041f }
                r9 = r23
                r0.f20499h = r9     // Catch:{ Exception -> 0x041f }
                r0.f20500i = r13     // Catch:{ Exception -> 0x041f }
                r0.f20501j = r12     // Catch:{ Exception -> 0x041f }
                r5 = r24
                r0.f20502k = r5     // Catch:{ Exception -> 0x041f }
                r0.f20503l = r6     // Catch:{ Exception -> 0x041f }
                r8 = r22
                r0.f20504m = r8     // Catch:{ Exception -> 0x041f }
                r22 = r1
                r23 = r2
                r1 = r27
                r0.f20506o = r1     // Catch:{ Exception -> 0x041a }
                r0.f20505n = r10     // Catch:{ Exception -> 0x041a }
                r27 = r1
                r1 = r20
                r0.f20507p = r1     // Catch:{ Exception -> 0x041a }
                r20 = r1
                r1 = 3
                r0.f20508q = r1     // Catch:{ Exception -> 0x041a }
                r1 = r33
                java.lang.Object r1 = w3.C2872g.g(r1, r11, r0)     // Catch:{ Exception -> 0x041a }
                r2 = r18
                if (r1 != r2) goto L_0x03e6
                goto L_0x0176
            L_0x03e6:
                r11 = r5
                r5 = r10
                r33 = r22
                r22 = r8
                r10 = r9
                r8 = r27
            L_0x03ef:
                b2.K r1 = r0.f20510s     // Catch:{ Exception -> 0x0414 }
                boolean r1 = r1.f20491a     // Catch:{ Exception -> 0x0414 }
                if (r1 == 0) goto L_0x040a
                r1 = r33
                r33 = r3
                r3 = r6
                r11 = r8
                r8 = r10
                r18 = r13
                r13 = r14
                r14 = r22
                r9 = r20
                r6 = r4
                r4 = r23
                goto L_0x0453
            L_0x040a:
                r1 = r33
                r18 = r2
                r33 = r6
                r2 = r23
                goto L_0x034a
            L_0x0414:
                r1 = r33
                r10 = r2
            L_0x0417:
                r4 = r7
                goto L_0x00d9
            L_0x041a:
                r4 = r7
                r10 = r18
                goto L_0x00d7
            L_0x041f:
                r22 = r1
                r23 = r2
                r4 = r7
                r10 = r18
                goto L_0x00d9
            L_0x0428:
                r22 = r1
                r23 = r2
                r4 = r7
                r5 = r10
                r10 = r18
                r3 = r23
                goto L_0x0040
            L_0x0434:
                r27 = r8
                r8 = r22
                r9 = r23
                r22 = r1
                r23 = r2
                r2 = r18
                r1 = r3
                r3 = r33
                r33 = r1
                r18 = r13
                r13 = r14
                r1 = r22
                r11 = r27
                r14 = r8
                r8 = r9
                r6 = r4
                r4 = r23
                r9 = r20
            L_0x0453:
                r33.close()     // Catch:{ IOException -> 0x045c, Exception -> 0x0457 }
                goto L_0x045c
            L_0x0457:
                r10 = r2
            L_0x0458:
                r3 = r4
            L_0x0459:
                r4 = r7
                goto L_0x003f
            L_0x045c:
                r18.close()     // Catch:{ IOException -> 0x045f, Exception -> 0x0457 }
            L_0x045f:
                r18 = r2
                b2.K r2 = r0.f20510s     // Catch:{ Exception -> 0x04e2 }
                boolean r2 = r2.f20491a     // Catch:{ Exception -> 0x04e2 }
                if (r2 != 0) goto L_0x04f1
                kotlin.jvm.internal.t.b(r6)     // Catch:{ Exception -> 0x04e2 }
                r16 = r5
                r20 = r9
                r2 = r29
                r5 = 0
                r9 = 2
                r10 = 0
                boolean r6 = t3.s.D(r6, r2, r10, r9, r5)     // Catch:{ Exception -> 0x04e2 }
                if (r6 == 0) goto L_0x04e8
                w3.I0 r6 = w3.C2865c0.c()     // Catch:{ Exception -> 0x04e2 }
                b2.K$b$d r10 = new b2.K$b$d     // Catch:{ Exception -> 0x04e2 }
                X1.m r9 = r0.f20512u     // Catch:{ Exception -> 0x04e2 }
                r10.<init>(r9, r8, r5)     // Catch:{ Exception -> 0x04e2 }
                r0.f20492a = r7     // Catch:{ Exception -> 0x04e2 }
                r0.f20493b = r4     // Catch:{ Exception -> 0x04e2 }
                r0.f20494c = r1     // Catch:{ Exception -> 0x04e2 }
                r0.f20495d = r15     // Catch:{ Exception -> 0x04e2 }
                r0.f20496e = r13     // Catch:{ Exception -> 0x04e2 }
                r5 = 0
                r0.f20497f = r5     // Catch:{ Exception -> 0x04e2 }
                r0.f20498g = r5     // Catch:{ Exception -> 0x04e2 }
                r0.f20499h = r5     // Catch:{ Exception -> 0x04e2 }
                r0.f20500i = r5     // Catch:{ Exception -> 0x04e2 }
                r0.f20501j = r5     // Catch:{ Exception -> 0x04e2 }
                r0.f20502k = r5     // Catch:{ Exception -> 0x04e2 }
                r0.f20503l = r3     // Catch:{ Exception -> 0x04e2 }
                r0.f20504m = r14     // Catch:{ Exception -> 0x04e2 }
                r0.f20506o = r11     // Catch:{ Exception -> 0x04e2 }
                r5 = r16
                r0.f20505n = r5     // Catch:{ Exception -> 0x04e2 }
                r8 = r20
                r0.f20507p = r8     // Catch:{ Exception -> 0x04e2 }
                r16 = r1
                r1 = 4
                r0.f20508q = r1     // Catch:{ Exception -> 0x04da }
                java.lang.Object r1 = w3.C2872g.g(r6, r10, r0)     // Catch:{ Exception -> 0x04da }
                r10 = r18
                if (r1 != r10) goto L_0x04ba
                goto L_0x06db
            L_0x04ba:
                r6 = r7
                r1 = r14
                r7 = r4
                r4 = r3
                r3 = r5
                r5 = r15
                r15 = r13
                r13 = r11
                r11 = r8
                r8 = r16
            L_0x04c5:
                r17 = r8
                r8 = r1
                r1 = r5
                r5 = r3
                r3 = r17
                r17 = r7
                r7 = r6
                r6 = r17
                r30 = r13
                r13 = r11
                r11 = r30
                r17 = 1
                goto L_0x053e
            L_0x04da:
                r10 = r18
                r3 = r4
                r4 = r7
                r1 = r16
                goto L_0x003f
            L_0x04e2:
                r16 = r1
                r10 = r18
                goto L_0x0458
            L_0x04e8:
                r5 = r16
                r8 = r20
                r10 = r18
                r16 = r1
                goto L_0x04f8
            L_0x04f1:
                r8 = r9
                r2 = r29
                r16 = r1
                r10 = r18
            L_0x04f8:
                r6 = r4
                r1 = r15
                r17 = 1
                r4 = r3
                r15 = r13
                r3 = r16
                r30 = r8
                r8 = r14
                r13 = r30
                goto L_0x053e
            L_0x0506:
                r22 = r1
                r23 = r2
                r10 = r18
                goto L_0x0417
            L_0x050e:
                r10 = r4
                r1 = r33
                goto L_0x0459
            L_0x0513:
                r33 = r1
                r10 = r4
                goto L_0x0459
            L_0x0518:
                r10 = r18
                r1 = r3
                r3 = r6
                goto L_0x0459
            L_0x051e:
                r19 = r1
                r2 = r4
                r20 = r8
                r10 = r18
                r8 = r25
                r5 = 0
                r1 = r33
                r6.f24687a = r5     // Catch:{ Exception -> 0x054c }
                S1.k$a r4 = S1.k.f32g     // Catch:{ Exception -> 0x054c }
                r4.f()     // Catch:{ Exception -> 0x054c }
                r7.f24687a = r5     // Catch:{ Exception -> 0x054c }
            L_0x0533:
                r5 = r1
                r4 = r13
                r1 = r15
                r11 = r27
                r17 = 1
                r15 = r14
                r13 = r8
                r8 = r20
            L_0x053e:
                int r8 = r8 + 1
                r18 = r10
                r9 = r11
                r11 = r13
                r14 = r15
                r15 = r1
                r13 = r4
                r1 = r19
                r4 = r2
                goto L_0x01b5
            L_0x054c:
                r17 = 1
                r1 = r3
                r3 = r6
                r4 = r7
                goto L_0x05b8
            L_0x0553:
                r10 = r18
                r17 = 1
            L_0x0557:
                r1 = r3
                r3 = r6
                r4 = r7
            L_0x055a:
                r5 = 0
                goto L_0x05b8
            L_0x055d:
                r10 = r18
                goto L_0x054c
            L_0x0560:
                r1 = r5
                r10 = r18
                r17 = 1
                boolean r2 = r7.f24687a     // Catch:{ Exception -> 0x0557 }
                if (r2 == 0) goto L_0x05af
                b2.K r2 = r0.f20510s     // Catch:{ Exception -> 0x0557 }
                boolean r2 = r2.f20491a     // Catch:{ Exception -> 0x0557 }
                if (r2 != 0) goto L_0x05af
                r2 = 100
                if (r1 >= r2) goto L_0x05af
                S1.k$a r1 = S1.k.f32g     // Catch:{ Exception -> 0x0557 }
                r1.V(r2)     // Catch:{ Exception -> 0x0557 }
                w3.I0 r1 = w3.C2865c0.c()     // Catch:{ Exception -> 0x0557 }
                b2.K$b$e r2 = new b2.K$b$e     // Catch:{ Exception -> 0x0557 }
                X1.m r4 = r0.f20512u     // Catch:{ Exception -> 0x0557 }
                r5 = 0
                r2.<init>(r4, r5)     // Catch:{ Exception -> 0x0557 }
                r0.f20492a = r7     // Catch:{ Exception -> 0x0557 }
                r0.f20493b = r6     // Catch:{ Exception -> 0x0557 }
                r0.f20494c = r3     // Catch:{ Exception -> 0x0557 }
                r0.f20495d = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20496e = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20497f = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20498g = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20499h = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20500i = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20501j = r5     // Catch:{ Exception -> 0x0557 }
                r0.f20502k = r5     // Catch:{ Exception -> 0x0557 }
                r4 = 5
                r0.f20508q = r4     // Catch:{ Exception -> 0x0557 }
                java.lang.Object r1 = w3.C2872g.g(r1, r2, r0)     // Catch:{ Exception -> 0x0557 }
                if (r1 != r10) goto L_0x05a7
                goto L_0x06db
            L_0x05a7:
                r1 = r3
                r3 = r6
                r4 = r7
            L_0x05aa:
                r6 = r3
                r7 = r4
                r5 = 0
            L_0x05ad:
                r3 = r1
                goto L_0x05bd
            L_0x05af:
                r5 = 0
                goto L_0x05bd
            L_0x05b1:
                r10 = r2
                r17 = 1
                r1 = r3
                r3 = r5
                r4 = r6
                goto L_0x055a
            L_0x05b8:
                r4.f24687a = r5
                r6 = r3
                r7 = r4
                goto L_0x05ad
            L_0x05bd:
                boolean r1 = r7.f24687a
                java.lang.String r2 = "next(...)"
                java.lang.String r4 = "iterator(...)"
                if (r1 == 0) goto L_0x0666
                b2.K r1 = r0.f20510s
                boolean r1 = r1.f20491a
                if (r1 != 0) goto L_0x0666
                java.io.File r1 = r0.f20511t
                java.io.File[] r1 = r1.listFiles()
                if (r1 == 0) goto L_0x0610
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                X2.C2250q.v(r2, r1)
                w3.I0 r1 = w3.C2865c0.c()
                b2.K$b$f r3 = new b2.K$b$f
                X1.m r4 = r0.f20512u
                java.io.File r5 = r0.f20509r
                r8 = 0
                r3.<init>(r4, r5, r2, r8)
                r0.f20492a = r8
                r0.f20493b = r8
                r0.f20494c = r8
                r0.f20495d = r8
                r0.f20496e = r8
                r0.f20497f = r8
                r0.f20498g = r8
                r0.f20499h = r8
                r0.f20500i = r8
                r0.f20501j = r8
                r0.f20502k = r8
                r2 = 6
                r0.f20508q = r2
                java.lang.Object r1 = w3.C2872g.g(r1, r3, r0)
                if (r1 != r10) goto L_0x060c
                goto L_0x06db
            L_0x060c:
                W2.J r1 = (W2.J) r1
                goto L_0x06de
            L_0x0610:
                boolean r1 = r3.isEmpty()
                if (r1 != 0) goto L_0x0630
                java.util.Iterator r1 = r3.iterator()
                kotlin.jvm.internal.t.d(r1, r4)
            L_0x061d:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0630
                java.lang.Object r3 = r1.next()
                kotlin.jvm.internal.t.d(r3, r2)
                java.io.File r3 = (java.io.File) r3
                r3.delete()
                goto L_0x061d
            L_0x0630:
                S1.k$a r1 = S1.k.f32g
                r1.f()
                w3.I0 r1 = w3.C2865c0.c()
                b2.K$b$g r2 = new b2.K$b$g
                X1.m r3 = r0.f20512u
                r5 = 0
                r2.<init>(r3, r5)
                r0.f20492a = r5
                r0.f20493b = r5
                r0.f20494c = r5
                r0.f20495d = r5
                r0.f20496e = r5
                r0.f20497f = r5
                r0.f20498g = r5
                r0.f20499h = r5
                r0.f20500i = r5
                r0.f20501j = r5
                r0.f20502k = r5
                r3 = 7
                r0.f20508q = r3
                java.lang.Object r1 = w3.C2872g.g(r1, r2, r0)
                if (r1 != r10) goto L_0x0662
                goto L_0x06db
            L_0x0662:
                W2.J r1 = (W2.J) r1
                goto L_0x06de
            L_0x0666:
                java.io.File r1 = r0.f20511t
                java.io.File[] r1 = r1.listFiles()
                if (r1 == 0) goto L_0x068a
                int r8 = r1.length
                if (r8 != 0) goto L_0x0672
                goto L_0x0674
            L_0x0672:
                r17 = r5
            L_0x0674:
                if (r17 != 0) goto L_0x068a
                java.util.Iterator r1 = kotlin.jvm.internal.C2625c.a(r1)
            L_0x067a:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L_0x068a
                java.lang.Object r5 = r1.next()
                java.io.File r5 = (java.io.File) r5
                r5.delete()
                goto L_0x067a
            L_0x068a:
                boolean r1 = r3.isEmpty()
                if (r1 != 0) goto L_0x06aa
                java.util.Iterator r1 = r3.iterator()
                kotlin.jvm.internal.t.d(r1, r4)
            L_0x0697:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x06aa
                java.lang.Object r3 = r1.next()
                kotlin.jvm.internal.t.d(r3, r2)
                java.io.File r3 = (java.io.File) r3
                r3.delete()
                goto L_0x0697
            L_0x06aa:
                S1.k$a r1 = S1.k.f32g
                r1.f()
                w3.I0 r1 = w3.C2865c0.c()
                b2.K$b$h r2 = new b2.K$b$h
                X1.m r3 = r0.f20512u
                r5 = 0
                r2.<init>(r7, r6, r3, r5)
                r0.f20492a = r5
                r0.f20493b = r5
                r0.f20494c = r5
                r0.f20495d = r5
                r0.f20496e = r5
                r0.f20497f = r5
                r0.f20498g = r5
                r0.f20499h = r5
                r0.f20500i = r5
                r0.f20501j = r5
                r0.f20502k = r5
                r3 = 8
                r0.f20508q = r3
                java.lang.Object r1 = w3.C2872g.g(r1, r2, r0)
                if (r1 != r10) goto L_0x06dc
            L_0x06db:
                return r10
            L_0x06dc:
                W2.J r1 = W2.J.f19942a
            L_0x06de:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.C2279K.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    private final boolean h(File file, File file2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                t.b(name);
                if (s.D(name, ".apk", false, 2, (Object) null)) {
                    if (zipEntry.getSize() >= file2.getUsableSpace()) {
                        return false;
                    }
                    File file3 = new File(file2, name);
                    inputStream = zipFile.getInputStream(zipEntry);
                    fileOutputStream = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        inputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        inputStream.close();
                    }
                    fileOutputStream.close();
                }
            }
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        } catch (Throwable th) {
            inputStream.close();
            fileOutputStream.close();
            throw th;
        }
    }

    public final void b() {
        this.f20491a = true;
    }

    public final boolean c(File file) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(file).entries();
            while (entries.hasMoreElements()) {
                String name = ((ZipEntry) entries.nextElement()).getName();
                t.b(name);
                if (s.D(name, ".obb", false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }

    public final Drawable d(File file, Context context) {
        t.e(file, "xapkFile");
        t.e(context, "context");
        Drawable drawable = (Drawable) C2276H.f20479a.a().get(file.getName());
        if (drawable == null) {
            File g5 = new C2290j().g(context);
            String name = file.getName();
            t.d(name, "getName(...)");
            String name2 = file.getName();
            t.d(name2, "getName(...)");
            int l02 = s.l0(name2, ".", 0, false, 6, (Object) null);
            boolean z4 = false;
            String substring = name.substring(0, l02);
            t.d(substring, "substring(...)");
            File file2 = new File(g5, substring);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (h(file, file2)) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    if (listFiles.length == 0) {
                        z4 = true;
                    }
                    if (!z4) {
                        Iterator a5 = C2625c.a(listFiles);
                        while (a5.hasNext()) {
                            File file3 = (File) a5.next();
                            C2290j jVar = new C2290j();
                            String absolutePath = file3.getAbsolutePath();
                            t.d(absolutePath, "getAbsolutePath(...)");
                            Drawable h5 = jVar.h(context, absolutePath);
                            C2276H.f20479a.a().put(file.getName(), h5);
                            try {
                                file3.delete();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            drawable = h5;
                        }
                    }
                }
                if (file2.exists()) {
                    new C2291k().a(file2);
                }
            }
        }
        return drawable;
    }

    public final h e(File file, Context context) {
        t.e(file, "xapkFile");
        t.e(context, "context");
        File g5 = new C2290j().g(context);
        String name = file.getName();
        t.d(name, "getName(...)");
        String name2 = file.getName();
        t.d(name2, "getName(...)");
        int l02 = s.l0(name2, ".", 0, false, 6, (Object) null);
        boolean z4 = false;
        String substring = name.substring(0, l02);
        t.d(substring, "substring(...)");
        File file2 = new File(g5, substring);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        h hVar = null;
        if (h(file, file2)) {
            File[] listFiles = file2.listFiles();
            if (listFiles != null) {
                if (listFiles.length == 0) {
                    z4 = true;
                }
                if (!z4) {
                    PackageManager packageManager = context.getPackageManager();
                    Iterator a5 = C2625c.a(listFiles);
                    while (a5.hasNext()) {
                        File file3 = (File) a5.next();
                        t.b(packageManager);
                        String absolutePath = file3.getAbsolutePath();
                        t.d(absolutePath, "getAbsolutePath(...)");
                        PackageInfo c5 = C2301u.c(packageManager, absolutePath, 128);
                        if (c5 != null) {
                            try {
                                long m5 = new C2290j().m(c5);
                                String str = c5.packageName;
                                t.d(str, "packageName");
                                h hVar2 = new h(str, m5);
                                try {
                                    C2276H h5 = C2276H.f20479a;
                                    if (((Drawable) h5.a().get(file.getName())) == null) {
                                        C2290j jVar = new C2290j();
                                        String absolutePath2 = file3.getAbsolutePath();
                                        t.d(absolutePath2, "getAbsolutePath(...)");
                                        h5.a().put(file.getName(), jVar.h(context, absolutePath2));
                                    }
                                    hVar = hVar2;
                                } catch (Exception e5) {
                                    e = e5;
                                    hVar = hVar2;
                                    e.printStackTrace();
                                    file3.delete();
                                }
                            } catch (Exception e6) {
                                e = e6;
                                e.printStackTrace();
                                file3.delete();
                            }
                        }
                        try {
                            file3.delete();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            J j5 = J.f19942a;
                        }
                    }
                }
            }
            if (file2.exists()) {
                new C2291k().a(file2);
            }
        }
        return hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(java.io.File r7) {
        /*
            r6 = this;
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x002d }
            r1.<init>(r7)     // Catch:{ Exception -> 0x002d }
            java.util.Enumeration r7 = r1.entries()     // Catch:{ Exception -> 0x002d }
            r1 = r0
        L_0x000b:
            boolean r2 = r7.hasMoreElements()     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r7.nextElement()     // Catch:{ Exception -> 0x002b }
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x002b }
            kotlin.jvm.internal.t.b(r2)     // Catch:{ Exception -> 0x002b }
            java.lang.String r3 = ".apk"
            r4 = 2
            r5 = 0
            boolean r2 = t3.s.D(r2, r3, r0, r4, r5)     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x000b
            int r1 = r1 + 1
            goto L_0x000b
        L_0x002b:
            r7 = move-exception
            goto L_0x002f
        L_0x002d:
            r7 = move-exception
            r1 = r0
        L_0x002f:
            r7.printStackTrace()
        L_0x0032:
            if (r1 <= 0) goto L_0x0035
            r0 = 1
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.C2279K.f(java.io.File):boolean");
    }

    public final Object g(File file, File file2, m mVar, C2308e eVar) {
        return C2872g.g(C2865c0.b(), new b(file, this, file2, mVar, (C2308e) null), eVar);
    }
}
