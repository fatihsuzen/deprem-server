package k4;

import J2.u;
import P3.d;
import P3.k;
import T3.c;
import W2.J;
import X2.C2250q;
import android.content.Context;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n4.a;
import n4.h;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final u f24600a;

    /* renamed from: b  reason: collision with root package name */
    public final c f24601b;

    /* renamed from: c  reason: collision with root package name */
    public final a f24602c;

    /* renamed from: d  reason: collision with root package name */
    public final h f24603d;

    /* renamed from: e  reason: collision with root package name */
    public final ChoiceCmpCallback f24604e;

    /* renamed from: f  reason: collision with root package name */
    public final r4.a f24605f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24606g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f24607h = new ArrayList();

    static {
        t.d(l.class.getSimpleName(), "Tracking::class.java.simpleName");
    }

    public l(u uVar, c cVar, a aVar, h hVar, ChoiceCmpCallback choiceCmpCallback, r4.a aVar2, String str) {
        t.e(uVar, "tcModel");
        t.e(aVar, "networkUtil");
        t.e(hVar, "requestApi");
        t.e(aVar2, "sharedStorage");
        t.e(str, "domain");
        this.f24600a = uVar;
        this.f24601b = cVar;
        this.f24602c = aVar;
        this.f24603d = hVar;
        this.f24604e = choiceCmpCallback;
        this.f24605f = aVar2;
        this.f24606g = str;
    }

    public static Object e(l lVar, Boolean bool, String str, String str2, String str3, boolean z4, C2308e eVar, int i5) {
        String str4;
        String str5;
        String str6;
        boolean z5;
        String f5;
        String f6;
        l lVar2 = lVar;
        Boolean bool2 = bool;
        h hVar = h.GDPR;
        ArrayList arrayList = null;
        if ((i5 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i5 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i5 & 8) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i5 & 64) != 0) {
            z5 = false;
        } else {
            z5 = z4;
        }
        lVar2.getClass();
        if (t.a(bool2, b.a(true))) {
            f5 = "All";
        } else {
            f5 = lVar2.f((String) null);
        }
        String str7 = f5;
        if (t.a(bool2, b.a(true))) {
            f6 = "none";
        } else {
            f6 = lVar2.f("legitimate");
        }
        String str8 = f6;
        String e5 = m.l.e();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(lVar2.f24607h);
        if (m.l.f960a) {
            arrayList = new ArrayList();
            m.l.f961b.forEach(new m.h(arrayList));
        }
        o oVar = new o(arrayList2, str7, str8, str4, str5, (String) null, (String) null, str6, (String) null, e5, arrayList, b.a(z5), 96);
        lVar2.f24607h.clear();
        lVar2.f24605f.i(r4.b.GDPR_STATUS, str7);
        r4.a aVar = lVar2.f24605f;
        r4.b bVar = r4.b.GBC_STATUS;
        if (e5 == null) {
            e5 = "";
        }
        aVar.i(bVar, e5);
        return lVar2.b(g.DONE, oVar, hVar, eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static k4.c g(k4.h r11) {
        /*
            r4.a r0 = s4.c.l()
            int r1 = r11.ordinal()
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r4) goto L_0x001d
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0014
            goto L_0x001d
        L_0x0014:
            W2.q r11 = new W2.q
            r11.<init>()
            throw r11
        L_0x001a:
            r4.b r1 = r4.b.MSPA_CONFIG_THEME_UUID
            goto L_0x0022
        L_0x001d:
            r4.b r1 = r4.b.CONFIG_THEME_UUID
            goto L_0x0022
        L_0x0020:
            r4.b r1 = r4.b.CCPA_CONFIG_THEME_UUID
        L_0x0022:
            java.lang.String r6 = r0.k(r1)
            int r0 = r6.length()
            r1 = 0
            if (r0 != 0) goto L_0x002e
            return r1
        L_0x002e:
            r4.a r0 = s4.c.l()
            int r5 = r11.ordinal()
            if (r5 == 0) goto L_0x004b
            if (r5 == r4) goto L_0x0048
            if (r5 == r3) goto L_0x0045
            if (r5 != r2) goto L_0x003f
            goto L_0x0048
        L_0x003f:
            W2.q r11 = new W2.q
            r11.<init>()
            throw r11
        L_0x0045:
            r4.b r5 = r4.b.MSPA_CONFIG_LANGUAGE
            goto L_0x004d
        L_0x0048:
            r4.b r5 = r4.b.CONFIG_LANGUAGE
            goto L_0x004d
        L_0x004b:
            r4.b r5 = r4.b.CCPA_CONFIG_LANGUAGE
        L_0x004d:
            java.lang.String r7 = r0.k(r5)
            int r0 = r11.ordinal()
            if (r0 == 0) goto L_0x0067
            if (r0 == r4) goto L_0x0064
            if (r0 == r3) goto L_0x0067
            if (r0 != r2) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            W2.q r11 = new W2.q
            r11.<init>()
            throw r11
        L_0x0064:
            r4.b r0 = r4.b.CONFIG_COP_APPLICABLE
            goto L_0x0068
        L_0x0067:
            r0 = r1
        L_0x0068:
            r5 = 0
            java.lang.String r8 = "preferenceKey"
            if (r0 != 0) goto L_0x006f
            r0 = r1
            goto L_0x0085
        L_0x006f:
            r4.a r9 = s4.c.l()
            r9.getClass()
            kotlin.jvm.internal.t.e(r0, r8)
            android.content.SharedPreferences r9 = r9.f25721a
            java.lang.String r0 = r0.f25815a
            boolean r0 = r9.getBoolean(r0, r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0085:
            int r9 = r11.ordinal()
            if (r9 == 0) goto L_0x009b
            if (r9 == r4) goto L_0x0098
            if (r9 == r3) goto L_0x009b
            if (r9 != r2) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            W2.q r11 = new W2.q
            r11.<init>()
            throw r11
        L_0x0098:
            r4.b r9 = r4.b.CONFIG_ADV_APPLICABLE
            goto L_0x009c
        L_0x009b:
            r9 = r1
        L_0x009c:
            if (r9 != 0) goto L_0x00a0
        L_0x009e:
            r9 = r1
            goto L_0x00b7
        L_0x00a0:
            r4.a r1 = s4.c.l()
            r1.getClass()
            kotlin.jvm.internal.t.e(r9, r8)
            android.content.SharedPreferences r1 = r1.f25721a
            java.lang.String r9 = r9.f25815a
            boolean r1 = r1.getBoolean(r9, r5)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            goto L_0x009e
        L_0x00b7:
            r4.a r1 = s4.c.l()
            int r11 = r11.ordinal()
            if (r11 == 0) goto L_0x00d4
            if (r11 == r4) goto L_0x00d1
            if (r11 == r3) goto L_0x00ce
            if (r11 != r2) goto L_0x00c8
            goto L_0x00d1
        L_0x00c8:
            W2.q r11 = new W2.q
            r11.<init>()
            throw r11
        L_0x00ce:
            r4.b r11 = r4.b.MSPA_CONFIG_GBC_APPLICABLE
            goto L_0x00d6
        L_0x00d1:
            r4.b r11 = r4.b.CONFIG_GBC_APPLICABLE
            goto L_0x00d6
        L_0x00d4:
            r4.b r11 = r4.b.CCPA_CONFIG_GBC_APPLICABLE
        L_0x00d6:
            r1.getClass()
            kotlin.jvm.internal.t.e(r11, r8)
            android.content.SharedPreferences r1 = r1.f25721a
            java.lang.String r11 = r11.f25815a
            boolean r10 = r1.getBoolean(r11, r5)
            k4.c r5 = new k4.c
            r8 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l.g(k4.h):k4.c");
    }

    public final Object a(String str, h hVar, boolean z4, C2308e eVar) {
        Boolean bool;
        String str2;
        boolean z5;
        c g5 = g(hVar);
        t.e(hVar, "regulation");
        Boolean bool2 = null;
        if (hVar == h.GDPR) {
            if (t.a(s4.c.j().f19281b.f19231V.f19264c, Boolean.TRUE)) {
                List list = s4.c.j().f19281b.f19233X.f19208a;
                String upperCase = s4.c.f25866n.toUpperCase(Locale.ROOT);
                t.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                if (list.contains(upperCase)) {
                    z5 = true;
                    bool = Boolean.valueOf(z5);
                }
            }
            z5 = false;
            bool = Boolean.valueOf(z5);
        } else {
            bool = null;
        }
        String str3 = hVar.f24590a;
        c cVar = this.f24601b;
        if (cVar == null) {
            str2 = null;
        } else {
            str2 = cVar.f19236a;
        }
        boolean z6 = m.l.f960a;
        String c5 = m.l.c(this.f24605f);
        if (t.a(bool, b.a(true))) {
            bool2 = b.a(ChoiceCmp.INSTANCE.getUserSubscribed());
        }
        Object c6 = c(g.VISIT, new s(str, b.a(z4), str3, str2, g5, bool2, c5, bool, m.l.f960a), hVar, eVar);
        if (c6 == C2316b.f()) {
            return c6;
        }
        return J.f19942a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(k4.g r12, k4.m r13, k4.h r14, b3.C2308e r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof k4.i
            if (r0 == 0) goto L_0x0013
            r0 = r15
            k4.i r0 = (k4.i) r0
            int r1 = r0.f24593c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24593c = r1
            goto L_0x0018
        L_0x0013:
            k4.i r0 = new k4.i
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f24591a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f24593c
            java.lang.String r3 = ""
            r4 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r4) goto L_0x002b
            W2.u.b(r15)     // Catch:{ a -> 0x0086 }
            goto L_0x0079
        L_0x002b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0033:
            W2.u.b(r15)
            k4.m r12 = r11.h(r12, r13, r14)
            java.lang.String r13 = "https://api.cmp.inmobi.com/"
            android.net.Uri r13 = android.net.Uri.parse(r13)
            android.net.Uri$Builder r13 = r13.buildUpon()
            java.lang.String r5 = r12.d()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "\\"
            java.lang.String r7 = ""
            r8 = 0
            java.lang.String r12 = t3.s.L(r5, r6, r7, r8, r9, r10)
            java.lang.String r14 = "log"
            android.net.Uri$Builder r12 = r13.appendQueryParameter(r14, r12)
            android.net.Uri r12 = r12.build()
            java.lang.String r12 = r12.toString()
            java.lang.String r13 = "parse(BuildConfig.INMOBI…      .build().toString()"
            kotlin.jvm.internal.t.d(r12, r13)
            n4.a r13 = r11.f24602c     // Catch:{ a -> 0x0086 }
            boolean r13 = r13.a()     // Catch:{ a -> 0x0086 }
            if (r13 == 0) goto L_0x007c
            n4.h r13 = r11.f24603d     // Catch:{ a -> 0x0086 }
            r0.f24593c = r4     // Catch:{ a -> 0x0086 }
            java.lang.Object r15 = r13.a(r12, r0)     // Catch:{ a -> 0x0086 }
            if (r15 != r1) goto L_0x0079
            return r1
        L_0x0079:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ a -> 0x0086 }
            return r15
        L_0x007c:
            com.inmobi.cmp.ChoiceCmpCallback r12 = r11.f24604e     // Catch:{ a -> 0x0086 }
            if (r12 != 0) goto L_0x0081
            goto L_0x0086
        L_0x0081:
            com.inmobi.cmp.model.ChoiceError r13 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0086 }
            r12.onCmpError(r13)     // Catch:{ a -> 0x0086 }
        L_0x0086:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l.b(k4.g, k4.m, k4.h, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(k4.g r11, k4.s r12, k4.h r13, b3.C2308e r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof k4.j
            if (r0 == 0) goto L_0x0013
            r0 = r14
            k4.j r0 = (k4.j) r0
            int r1 = r0.f24596c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24596c = r1
            goto L_0x0018
        L_0x0013:
            k4.j r0 = new k4.j
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f24594a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f24596c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r14)     // Catch:{ a -> 0x0066 }
            goto L_0x0066
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            W2.u.b(r14)
            k4.m r11 = r10.h(r11, r12, r13)
            java.lang.String r12 = "https://visit-server.inmobi-choice.io/visit-event"
            n4.a r13 = r10.f24602c     // Catch:{ a -> 0x0066 }
            boolean r13 = r13.a()     // Catch:{ a -> 0x0066 }
            if (r13 == 0) goto L_0x005c
            n4.h r13 = r10.f24603d     // Catch:{ a -> 0x0066 }
            java.lang.String r4 = r11.d()     // Catch:{ a -> 0x0066 }
            java.lang.String r5 = "\\"
            java.lang.String r6 = ""
            r8 = 4
            r9 = 0
            r7 = 0
            java.lang.String r11 = t3.s.L(r4, r5, r6, r7, r8, r9)     // Catch:{ a -> 0x0066 }
            r0.f24596c = r3     // Catch:{ a -> 0x0066 }
            java.lang.Object r11 = r13.b(r12, r11, r0)     // Catch:{ a -> 0x0066 }
            if (r11 != r1) goto L_0x0066
            return r1
        L_0x005c:
            com.inmobi.cmp.ChoiceCmpCallback r11 = r10.f24604e     // Catch:{ a -> 0x0066 }
            if (r11 != 0) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            com.inmobi.cmp.model.ChoiceError r12 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0066 }
            r11.onCmpError(r12)     // Catch:{ a -> 0x0066 }
        L_0x0066:
            W2.J r11 = W2.J.f19942a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l.c(k4.g, k4.s, k4.h, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(k4.h r19, k4.e r20, java.lang.String r21, boolean r22, b3.C2308e r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r23
            boolean r3 = r2 instanceof k4.k
            if (r3 == 0) goto L_0x0019
            r3 = r2
            k4.k r3 = (k4.k) r3
            int r4 = r3.f24599c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f24599c = r4
            goto L_0x001e
        L_0x0019:
            k4.k r3 = new k4.k
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f24597a
            java.lang.Object r4 = c3.C2316b.f()
            int r5 = r3.f24599c
            r6 = 1
            if (r5 == 0) goto L_0x0038
            if (r5 != r6) goto L_0x0030
            W2.u.b(r2)
            goto L_0x00ca
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            W2.u.b(r2)
            kotlin.jvm.internal.L r2 = new kotlin.jvm.internal.L
            r2.<init>()
            if (r22 == 0) goto L_0x0048
            k4.c r5 = g(r1)
            r2.f24690a = r5
        L_0x0048:
            k4.c r13 = new k4.c
            T3.i r5 = s4.c.j()
            T3.c r5 = r5.f19281b
            java.lang.String r5 = r5.f19230U
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = ""
        L_0x0056:
            r8 = r5
            r4.a r5 = s4.c.l()
            r4.b r7 = r4.b.PORTAL_CHOICE_LANG
            java.lang.String r9 = r5.k(r7)
            java.lang.String r5 = "regulation"
            kotlin.jvm.internal.t.e(r1, r5)
            k4.h r7 = k4.h.GDPR
            r14 = 0
            if (r1 != r7) goto L_0x0074
            boolean r10 = V2.a.e()
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            goto L_0x0075
        L_0x0074:
            r10 = r14
        L_0x0075:
            kotlin.jvm.internal.t.e(r1, r5)
            if (r1 != r7) goto L_0x0084
            boolean r5 = V2.a.d()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r11 = r5
            goto L_0x0085
        L_0x0084:
            r11 = r14
        L_0x0085:
            boolean r12 = m.l.f960a
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            T3.c r5 = r0.f24601b
            if (r5 != 0) goto L_0x0090
            goto L_0x00ce
        L_0x0090:
            java.lang.String r8 = r5.f19236a
            java.lang.String r9 = r5.f19242g
            J2.u r7 = r0.f24600a
            int r10 = r7.f18326m
            r7 = r20
            java.lang.String r11 = r7.f24576a
            java.lang.String r12 = r5.f19240e
            java.lang.Object r2 = r2.f24690a
            k4.c r2 = (k4.c) r2
            if (r22 == 0) goto L_0x00ab
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r6)
            r17 = r5
            goto L_0x00ad
        L_0x00ab:
            r17 = r14
        L_0x00ad:
            if (r22 == 0) goto L_0x00b5
            r4.a r5 = r0.f24605f
            java.lang.String r14 = m.l.c(r5)
        L_0x00b5:
            r16 = r14
            k4.n r7 = new k4.n
            r15 = r21
            r14 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            k4.g r2 = k4.g.INIT
            r3.f24599c = r6
            java.lang.Object r2 = r0.b(r2, r7, r1, r3)
            if (r2 != r4) goto L_0x00ca
            return r4
        L_0x00ca:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x00d1
        L_0x00ce:
            java.lang.String r1 = "Error sending init log: CMP configuration have not been initialized yet"
            return r1
        L_0x00d1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l.d(k4.h, k4.e, java.lang.String, boolean, b3.e):java.lang.Object");
    }

    public final String f(String str) {
        List<Boolean> list;
        k kVar;
        Map map;
        boolean a5 = t.a(str, "legitimate");
        if (a5) {
            list = C2250q.r(C2250q.j(this.f24600a.f18310D.getMap().values(), this.f24600a.f18309C.getMap().values(), this.f24600a.f18332s.getMap().values()));
        } else {
            Collection<Boolean> values = this.f24600a.f18331r.getMap().values();
            u uVar = this.f24600a;
            uVar.getClass();
            Vector vector = new Vector((Map) null, 1, (C2633k) null);
            for (Map.Entry next : uVar.f18339z.getMap().entrySet()) {
                d dVar = uVar.f18314a;
                if (dVar == null || (map = dVar.f18877i) == null) {
                    kVar = null;
                } else {
                    kVar = (k) map.get(String.valueOf(((Number) next.getKey()).intValue()));
                }
                if (kVar != null && u.d(kVar)) {
                    vector.getMap().put(next.getKey(), next.getValue());
                }
            }
            list = C2250q.r(C2250q.j(values, vector.getMap().values(), this.f24600a.f18307A.getMap().values()));
        }
        boolean z4 = list instanceof Collection;
        if (!z4 || !list.isEmpty()) {
            for (Boolean booleanValue : list) {
                if (!booleanValue.booleanValue()) {
                    if (!z4 || !list.isEmpty()) {
                        for (Boolean booleanValue2 : list) {
                            if (booleanValue2.booleanValue()) {
                                return "Partial";
                            }
                        }
                    }
                    if (a5) {
                        return "all";
                    }
                    return "Reject";
                }
            }
        }
        if (a5) {
            return "none";
        }
        return "All";
    }

    public final m h(g gVar, m mVar, h hVar) {
        String str;
        mVar.b(Calendar.getInstance().getTimeInMillis());
        t.e(gVar, "<set-?>");
        mVar.f24609b = gVar;
        StringBuilder sb = new StringBuilder();
        sb.append(hVar.f24590a);
        sb.append('-');
        String uuid = z.f24676a.toString();
        t.d(uuid, "sessionID.toString()");
        sb.append(uuid);
        mVar.f24610c = sb.toString();
        String str2 = this.f24606g;
        t.e(str2, "<set-?>");
        mVar.f24611d = str2;
        String str3 = s4.c.f25866n;
        t.e(str3, "<set-?>");
        mVar.f24612e = str3;
        Context applicationContext = s4.c.c().getApplicationContext();
        t.d(applicationContext, "ServiceLocator.application.applicationContext");
        String a5 = r.a(applicationContext);
        t.e(a5, "<set-?>");
        mVar.f24613f = a5;
        c cVar = this.f24601b;
        if (cVar == null) {
            str = null;
        } else {
            str = cVar.f19229T;
        }
        mVar.f24614g = str;
        return mVar;
    }

    public final void i(String str, String str2) {
        t.e(str, "identifier");
        t.e(str2, "value");
        ArrayList arrayList = this.f24607h;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        arrayList.add(new C2622a(timeInMillis, str + ':' + str2));
    }
}
