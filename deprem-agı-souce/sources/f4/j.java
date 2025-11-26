package f4;

import W2.J;
import W2.y;
import X2.C2250q;
import X2.M;
import a3.C2265a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import e4.C2358g;
import e4.C2361j;
import e4.Q;
import java.io.IOException;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import t3.C2777a;
import t3.s;

public abstract class j {

    public static final class a implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(((i) obj).a(), ((i) obj2).a());
        }
    }

    static final class b extends u implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ I f21654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f21655b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ K f21656c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2358g f21657d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ K f21658e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ K f21659f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(I i5, long j5, K k5, C2358g gVar, K k6, K k7) {
            super(2);
            this.f21654a = i5;
            this.f21655b = j5;
            this.f21656c = k5;
            this.f21657d = gVar;
            this.f21658e = k6;
            this.f21659f = k7;
        }

        public final void a(int i5, long j5) {
            long j6;
            if (i5 == 1) {
                I i6 = this.f21654a;
                if (!i6.f24687a) {
                    i6.f24687a = true;
                    if (j5 >= this.f21655b) {
                        K k5 = this.f21656c;
                        long j7 = k5.f24689a;
                        if (j7 == 4294967295L) {
                            j7 = this.f21657d.readLongLe();
                        }
                        k5.f24689a = j7;
                        K k6 = this.f21658e;
                        long j8 = 0;
                        if (k6.f24689a == 4294967295L) {
                            j6 = this.f21657d.readLongLe();
                        } else {
                            j6 = 0;
                        }
                        k6.f24689a = j6;
                        K k7 = this.f21659f;
                        if (k7.f24689a == 4294967295L) {
                            j8 = this.f21657d.readLongLe();
                        }
                        k7.f24689a = j8;
                        return;
                    }
                    throw new IOException("bad zip: zip64 extra too short");
                }
                throw new IOException("bad zip: zip64 extra repeated");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), ((Number) obj2).longValue());
            return J.f19942a;
        }
    }

    static final class c extends u implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2358g f21660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ L f21661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f21662c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ L f21663d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2358g gVar, L l5, L l6, L l7) {
            super(2);
            this.f21660a = gVar;
            this.f21661b = l5;
            this.f21662c = l6;
            this.f21663d = l7;
        }

        public final void a(int i5, long j5) {
            boolean z4;
            boolean z5;
            if (i5 == 21589) {
                long j6 = 1;
                if (j5 >= 1) {
                    byte readByte = this.f21660a.readByte();
                    boolean z6 = false;
                    if ((readByte & 1) == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if ((readByte & 2) == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if ((readByte & 4) == 4) {
                        z6 = true;
                    }
                    C2358g gVar = this.f21660a;
                    if (z4) {
                        j6 = 5;
                    }
                    if (z5) {
                        j6 += 4;
                    }
                    if (z6) {
                        j6 += 4;
                    }
                    if (j5 >= j6) {
                        if (z4) {
                            this.f21661b.f24690a = Long.valueOf(((long) gVar.readIntLe()) * 1000);
                        }
                        if (z5) {
                            this.f21662c.f24690a = Long.valueOf(((long) this.f21660a.readIntLe()) * 1000);
                        }
                        if (z6) {
                            this.f21663d.f24690a = Long.valueOf(((long) this.f21660a.readIntLe()) * 1000);
                            return;
                        }
                        return;
                    }
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), ((Number) obj2).longValue());
            return J.f19942a;
        }
    }

    private static final Map a(List list) {
        Q e5 = Q.a.e(Q.f21501b, "/", false, 1, (Object) null);
        Map l5 = M.l(y.a(e5, new i(e5, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, (C2633k) null)));
        for (i iVar : C2250q.h0(list, new a())) {
            if (((i) l5.put(iVar.a(), iVar)) == null) {
                while (true) {
                    Q h5 = iVar.a().h();
                    if (h5 == null) {
                        break;
                    }
                    i iVar2 = (i) l5.get(h5);
                    if (iVar2 != null) {
                        iVar2.b().add(iVar.a());
                        break;
                    }
                    i iVar3 = new i(h5, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, (C2633k) null);
                    l5.put(h5, iVar3);
                    iVar3.b().add(iVar.a());
                    iVar = iVar3;
                }
            }
        }
        return l5;
    }

    private static final Long b(int i5, int i6) {
        if (i6 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i5 >> 9) & 127) + 1980, ((i5 >> 5) & 15) - 1, i5 & 31, (i6 >> 11) & 31, (i6 >> 5) & 63, (i6 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String num = Integer.toString(i5, C2777a.a(16));
        t.d(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r10.close();
        r4 = r4 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r4 <= 0) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        r4 = e4.L.d(r3.z(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        if (r4.readIntLe() != 117853008) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        r5 = r4.readIntLe();
        r12 = r4.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        if (r4.readIntLe() != 1) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r5 != 0) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        r5 = e4.L.d(r3.z(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r10 = r5.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        if (r10 != 101075792) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        r8 = j(r5, r8);
        r10 = W2.J.f19942a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        h3.C2453b.a(r5, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
        throw new java.io.IOException("bad zip: expected " + c(101075792) + " but was " + c(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        h3.C2453b.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d2, code lost:
        r5 = W2.J.f19942a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        h3.C2453b.a(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        h3.C2453b.a(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e1, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        r4 = new java.util.ArrayList();
        r5 = e4.L.d(r3.z(r8.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r12 = r8.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f9, code lost:
        if (r6 >= r12) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fb, code lost:
        r10 = e(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0109, code lost:
        if (r10.f() >= r8.a()) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0115, code lost:
        if (((java.lang.Boolean) r2.invoke(r10)).booleanValue() == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0117, code lost:
        r4.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011c, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0129, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012a, code lost:
        r2 = W2.J.f19942a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        h3.C2453b.a(r5, (java.lang.Throwable) null);
        r4 = new e4.b0(r0, r1, a(r4), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0138, code lost:
        h3.C2453b.a(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013b, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        h3.C2453b.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0141, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        r8 = f(r10);
        r9 = r10.readUtf8((long) r8.b());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final e4.b0 d(e4.Q r18, e4.C2362k r19, k3.l r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.t.e(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.t.e(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.t.e(r2, r3)
            e4.i r3 = r1.i(r0)
            long r4 = r3.size()     // Catch:{ all -> 0x00d8 }
            r6 = 22
            long r6 = (long) r6     // Catch:{ all -> 0x00d8 }
            long r4 = r4 - r6
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x015c
            r8 = 65536(0x10000, double:3.2379E-319)
            long r8 = r4 - r8
            long r8 = java.lang.Math.max(r8, r6)     // Catch:{ all -> 0x00d8 }
        L_0x0030:
            e4.Z r10 = r3.z(r4)     // Catch:{ all -> 0x00d8 }
            e4.g r10 = e4.L.d(r10)     // Catch:{ all -> 0x00d8 }
            int r11 = r10.readIntLe()     // Catch:{ all -> 0x0142 }
            r12 = 101010256(0x6054b50, float:2.506985E-35)
            if (r11 != r12) goto L_0x0144
            f4.f r8 = f(r10)     // Catch:{ all -> 0x0142 }
            int r9 = r8.b()     // Catch:{ all -> 0x0142 }
            long r11 = (long) r9     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = r10.readUtf8(r11)     // Catch:{ all -> 0x0142 }
            r10.close()     // Catch:{ all -> 0x00d8 }
            r10 = 20
            long r10 = (long) r10     // Catch:{ all -> 0x00d8 }
            long r4 = r4 - r10
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r11 = 0
            if (r10 <= 0) goto L_0x00e2
            e4.Z r4 = r3.z(r4)     // Catch:{ all -> 0x00d8 }
            e4.g r4 = e4.L.d(r4)     // Catch:{ all -> 0x00d8 }
            int r5 = r4.readIntLe()     // Catch:{ all -> 0x0097 }
            r10 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r5 != r10) goto L_0x00d2
            int r5 = r4.readIntLe()     // Catch:{ all -> 0x0097 }
            long r12 = r4.readLongLe()     // Catch:{ all -> 0x0097 }
            int r10 = r4.readIntLe()     // Catch:{ all -> 0x0097 }
            r14 = 1
            if (r10 != r14) goto L_0x00ca
            if (r5 != 0) goto L_0x00ca
            e4.Z r5 = r3.z(r12)     // Catch:{ all -> 0x0097 }
            e4.g r5 = e4.L.d(r5)     // Catch:{ all -> 0x0097 }
            int r10 = r5.readIntLe()     // Catch:{ all -> 0x009a }
            r12 = 101075792(0x6064b50, float:2.525793E-35)
            if (r10 != r12) goto L_0x009d
            f4.f r8 = j(r5, r8)     // Catch:{ all -> 0x009a }
            W2.J r10 = W2.J.f19942a     // Catch:{ all -> 0x009a }
            h3.C2453b.a(r5, r11)     // Catch:{ all -> 0x0097 }
            goto L_0x00d2
        L_0x0097:
            r0 = move-exception
            r1 = r0
            goto L_0x00dc
        L_0x009a:
            r0 = move-exception
            r1 = r0
            goto L_0x00c4
        L_0x009d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = c(r12)     // Catch:{ all -> 0x009a }
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = " but was "
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = c(r10)     // Catch:{ all -> 0x009a }
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009a }
            r0.<init>(r1)     // Catch:{ all -> 0x009a }
            throw r0     // Catch:{ all -> 0x009a }
        L_0x00c4:
            throw r1     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            h3.C2453b.a(r5, r1)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x00ca:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x00d2:
            W2.J r5 = W2.J.f19942a     // Catch:{ all -> 0x0097 }
            h3.C2453b.a(r4, r11)     // Catch:{ all -> 0x00d8 }
            goto L_0x00e2
        L_0x00d8:
            r0 = move-exception
            r1 = r0
            goto L_0x0177
        L_0x00dc:
            throw r1     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r0 = move-exception
            h3.C2453b.a(r4, r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x00e2:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00d8 }
            r4.<init>()     // Catch:{ all -> 0x00d8 }
            long r12 = r8.a()     // Catch:{ all -> 0x00d8 }
            e4.Z r5 = r3.z(r12)     // Catch:{ all -> 0x00d8 }
            e4.g r5 = e4.L.d(r5)     // Catch:{ all -> 0x00d8 }
            long r12 = r8.c()     // Catch:{ all -> 0x011b }
        L_0x00f7:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x012a
            f4.i r10 = e(r5)     // Catch:{ all -> 0x011b }
            long r14 = r10.f()     // Catch:{ all -> 0x011b }
            long r16 = r8.a()     // Catch:{ all -> 0x011b }
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x0122
            java.lang.Object r14 = r2.invoke(r10)     // Catch:{ all -> 0x011b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x011b }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x011b }
            if (r14 == 0) goto L_0x011e
            r4.add(r10)     // Catch:{ all -> 0x011b }
            goto L_0x011e
        L_0x011b:
            r0 = move-exception
            r1 = r0
            goto L_0x013c
        L_0x011e:
            r14 = 1
            long r6 = r6 + r14
            goto L_0x00f7
        L_0x0122:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011b }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x011b }
            throw r0     // Catch:{ all -> 0x011b }
        L_0x012a:
            W2.J r2 = W2.J.f19942a     // Catch:{ all -> 0x011b }
            h3.C2453b.a(r5, r11)     // Catch:{ all -> 0x00d8 }
            java.util.Map r2 = a(r4)     // Catch:{ all -> 0x00d8 }
            e4.b0 r4 = new e4.b0     // Catch:{ all -> 0x00d8 }
            r4.<init>(r0, r1, r2, r9)     // Catch:{ all -> 0x00d8 }
            h3.C2453b.a(r3, r11)
            return r4
        L_0x013c:
            throw r1     // Catch:{ all -> 0x013d }
        L_0x013d:
            r0 = move-exception
            h3.C2453b.a(r5, r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x0142:
            r0 = move-exception
            goto L_0x0158
        L_0x0144:
            r10.close()     // Catch:{ all -> 0x00d8 }
            r10 = -1
            long r4 = r4 + r10
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0150
            goto L_0x0030
        L_0x0150:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x0158:
            r10.close()     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x015c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "not a zip: size="
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            long r4 = r3.size()     // Catch:{ all -> 0x00d8 }
            r1.append(r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d8 }
            r0.<init>(r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x0177:
            throw r1     // Catch:{ all -> 0x0178 }
        L_0x0178:
            r0 = move-exception
            h3.C2453b.a(r3, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f4.j.d(e4.Q, e4.k, k3.l):e4.b0");
    }

    public static final i e(C2358g gVar) {
        long j5;
        C2358g gVar2 = gVar;
        t.e(gVar2, "<this>");
        int readIntLe = gVar2.readIntLe();
        if (readIntLe == 33639248) {
            gVar2.skip(4);
            short readShortLe = gVar2.readShortLe();
            short s5 = readShortLe & 65535;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = gVar2.readShortLe() & 65535;
                Long b5 = b(gVar2.readShortLe() & 65535, gVar2.readShortLe() & 65535);
                long readIntLe2 = ((long) gVar2.readIntLe()) & 4294967295L;
                K k5 = new K();
                k5.f24689a = ((long) gVar2.readIntLe()) & 4294967295L;
                K k6 = new K();
                k6.f24689a = ((long) gVar2.readIntLe()) & 4294967295L;
                short readShortLe3 = gVar2.readShortLe() & 65535;
                short readShortLe4 = gVar2.readShortLe() & 65535;
                gVar2.skip(8);
                K k7 = new K();
                k7.f24689a = ((long) gVar2.readIntLe()) & 4294967295L;
                String readUtf8 = gVar2.readUtf8((long) (gVar2.readShortLe() & 65535));
                if (!s.U(readUtf8, 0, false, 2, (Object) null)) {
                    if (k6.f24689a == 4294967295L) {
                        j5 = (long) 8;
                    } else {
                        j5 = 0;
                    }
                    long j6 = readIntLe2;
                    if (k5.f24689a == 4294967295L) {
                        j5 += (long) 8;
                    }
                    if (k7.f24689a == 4294967295L) {
                        j5 += (long) 8;
                    }
                    I i5 = new I();
                    g(gVar2, readShortLe3, new b(i5, j5, k6, gVar2, k5, k7));
                    if (j5 <= 0 || i5.f24687a) {
                        return new i(Q.a.e(Q.f21501b, "/", false, 1, (Object) null).k(readUtf8), s.D(readUtf8, "/", false, 2, (Object) null), gVar2.readUtf8((long) readShortLe4), j6, k5.f24689a, k6.f24689a, readShortLe2, b5, k7.f24689a);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + c(s5));
        }
        throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(readIntLe));
    }

    private static final f f(C2358g gVar) {
        short readShortLe = gVar.readShortLe() & 65535;
        short readShortLe2 = gVar.readShortLe() & 65535;
        long readShortLe3 = (long) (gVar.readShortLe() & 65535);
        if (readShortLe3 == ((long) (gVar.readShortLe() & 65535)) && readShortLe == 0 && readShortLe2 == 0) {
            gVar.skip(4);
            return new f(readShortLe3, 4294967295L & ((long) gVar.readIntLe()), gVar.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void g(C2358g gVar, int i5, p pVar) {
        long j5 = (long) i5;
        while (j5 != 0) {
            if (j5 >= 4) {
                short readShortLe = gVar.readShortLe() & 65535;
                long readShortLe2 = ((long) gVar.readShortLe()) & 65535;
                long j6 = j5 - ((long) 4);
                if (j6 >= readShortLe2) {
                    gVar.require(readShortLe2);
                    long size = gVar.g().size();
                    pVar.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (gVar.g().size() + readShortLe2) - size;
                    int i6 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i6 >= 0) {
                        if (i6 > 0) {
                            gVar.g().skip(size2);
                        }
                        j5 = j6 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final C2361j h(C2358g gVar, C2361j jVar) {
        t.e(gVar, "<this>");
        t.e(jVar, "basicMetadata");
        C2361j i5 = i(gVar, jVar);
        t.b(i5);
        return i5;
    }

    private static final C2361j i(C2358g gVar, C2361j jVar) {
        Long l5;
        C2358g gVar2 = gVar;
        L l6 = new L();
        if (jVar != null) {
            l5 = jVar.a();
        } else {
            l5 = null;
        }
        l6.f24690a = l5;
        L l7 = new L();
        L l8 = new L();
        int readIntLe = gVar2.readIntLe();
        if (readIntLe == 67324752) {
            gVar2.skip(2);
            short readShortLe = gVar2.readShortLe();
            short s5 = readShortLe & 65535;
            if ((readShortLe & 1) == 0) {
                gVar2.skip(18);
                short readShortLe2 = gVar2.readShortLe() & 65535;
                gVar2.skip(((long) gVar2.readShortLe()) & 65535);
                if (jVar == null) {
                    gVar2.skip((long) readShortLe2);
                    return null;
                }
                g(gVar2, readShortLe2, new c(gVar2, l6, l7, l8));
                return new C2361j(jVar.d(), jVar.c(), (Q) null, jVar.b(), (Long) l8.f24690a, (Long) l6.f24690a, (Long) l7.f24690a, (Map) null, 128, (C2633k) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + c(s5));
        }
        throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(readIntLe));
    }

    private static final f j(C2358g gVar, f fVar) {
        gVar.skip(12);
        int readIntLe = gVar.readIntLe();
        int readIntLe2 = gVar.readIntLe();
        long readLongLe = gVar.readLongLe();
        if (readLongLe == gVar.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            gVar.skip(8);
            return new f(readLongLe, gVar.readLongLe(), fVar.b());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void k(C2358g gVar) {
        t.e(gVar, "<this>");
        i(gVar, (C2361j) null);
    }
}
