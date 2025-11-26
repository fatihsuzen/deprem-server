package o4;

import X2.C2250q;
import java.util.ArrayList;
import java.util.Locale;
import m4.e;
import m4.g;
import m4.m;
import m4.n;
import m4.p;
import m4.t;
import n4.a;
import n4.h;
import q4.i;
import q4.l;
import r4.b;
import s4.c;
import t3.s;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f25590a;

    /* renamed from: b  reason: collision with root package name */
    public final a f25591b;

    /* renamed from: c  reason: collision with root package name */
    public final r4.a f25592c;

    /* renamed from: d  reason: collision with root package name */
    public final h f25593d;

    /* renamed from: e  reason: collision with root package name */
    public final i f25594e;

    /* renamed from: f  reason: collision with root package name */
    public t f25595f;

    /* renamed from: g  reason: collision with root package name */
    public g f25596g = new g();

    /* renamed from: h  reason: collision with root package name */
    public m4.k f25597h = new m4.k();

    /* renamed from: i  reason: collision with root package name */
    public p f25598i = new p((String) null, (String) null, (String) null, (ArrayList) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 1023);

    public k(Locale locale, a aVar, r4.a aVar2, h hVar, l lVar) {
        h hVar2 = hVar;
        l lVar2 = lVar;
        kotlin.jvm.internal.t.e(locale, "appLocale");
        kotlin.jvm.internal.t.e(aVar, "networkUtil");
        kotlin.jvm.internal.t.e(aVar2, "shareStorage");
        kotlin.jvm.internal.t.e(hVar2, "requestApi");
        kotlin.jvm.internal.t.e(lVar2, "resolver");
        this.f25590a = locale;
        this.f25591b = aVar;
        this.f25592c = aVar2;
        this.f25593d = hVar2;
        this.f25594e = lVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof o4.g
            if (r0 == 0) goto L_0x0013
            r0 = r6
            o4.g r0 = (o4.g) r0
            int r1 = r0.f25585d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25585d = r1
            goto L_0x0018
        L_0x0013:
            o4.g r0 = new o4.g
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f25583b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25585d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            o4.k r0 = r0.f25582a
            W2.u.b(r6)     // Catch:{ a -> 0x0063 }
            goto L_0x005f
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0033:
            W2.u.b(r6)
            r4.a r6 = r5.f25592c     // Catch:{ a -> 0x0062 }
            r4.b r2 = r4.b.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x0062 }
            java.lang.String r4 = "en"
            r6.i(r2, r4)     // Catch:{ a -> 0x0062 }
            m4.g r6 = new m4.g     // Catch:{ a -> 0x0062 }
            r6.<init>()     // Catch:{ a -> 0x0062 }
            r5.f25596g = r6     // Catch:{ a -> 0x0062 }
            m4.k r6 = new m4.k     // Catch:{ a -> 0x0062 }
            r6.<init>()     // Catch:{ a -> 0x0062 }
            r5.f25597h = r6     // Catch:{ a -> 0x0062 }
            n4.h r6 = r5.f25593d     // Catch:{ a -> 0x0062 }
            java.lang.String r2 = r5.h()     // Catch:{ a -> 0x0062 }
            r0.f25582a = r5     // Catch:{ a -> 0x0062 }
            r0.f25585d = r3     // Catch:{ a -> 0x0062 }
            java.lang.Object r6 = r6.a(r2, r0)     // Catch:{ a -> 0x0062 }
            if (r6 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r0 = r5
        L_0x005f:
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ a -> 0x0063 }
            return r6
        L_0x0062:
            r0 = r5
        L_0x0063:
            r4.a r6 = r0.f25592c
            r4.b r0 = r4.b.TRANSLATIONS_TEXT
            java.lang.String r6 = r6.k(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.k.a(b3.e):java.lang.Object");
    }

    public final String b() {
        if (this.f25596g.f25386w.length() != 0) {
            return this.f25596g.f25386w;
        }
        t tVar = this.f25595f;
        if (tVar == null) {
            kotlin.jvm.internal.t.w("translationsText");
            tVar = null;
        }
        return tVar.f25496a.f25386w;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof o4.i
            if (r0 == 0) goto L_0x0013
            r0 = r7
            o4.i r0 = (o4.i) r0
            int r1 = r0.f25589d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25589d = r1
            goto L_0x0018
        L_0x0013:
            o4.i r0 = new o4.i
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25587b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25589d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            o4.k r0 = r0.f25586a
            W2.u.b(r7)
            goto L_0x0092
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0037:
            o4.k r2 = r0.f25586a
            W2.u.b(r7)     // Catch:{ a -> 0x003d }
            goto L_0x005c
        L_0x003d:
            r7 = move-exception
            goto L_0x007a
        L_0x003f:
            W2.u.b(r7)
            n4.a r7 = r6.f25591b     // Catch:{ a -> 0x005f }
            boolean r7 = r7.a()     // Catch:{ a -> 0x005f }
            if (r7 == 0) goto L_0x0062
            n4.h r7 = r6.f25593d     // Catch:{ a -> 0x005f }
            java.lang.String r2 = r6.h()     // Catch:{ a -> 0x005f }
            r0.f25586a = r6     // Catch:{ a -> 0x005f }
            r0.f25589d = r4     // Catch:{ a -> 0x005f }
            java.lang.Object r7 = r7.a(r2, r0)     // Catch:{ a -> 0x005f }
            if (r7 != r1) goto L_0x005b
            goto L_0x0090
        L_0x005b:
            r2 = r6
        L_0x005c:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ a -> 0x003d }
            goto L_0x009e
        L_0x005f:
            r7 = move-exception
            r2 = r6
            goto L_0x007a
        L_0x0062:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x005f }
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()     // Catch:{ a -> 0x005f }
            if (r7 != 0) goto L_0x006b
            goto L_0x0070
        L_0x006b:
            com.inmobi.cmp.model.ChoiceError r2 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x005f }
            r7.onCmpError(r2)     // Catch:{ a -> 0x005f }
        L_0x0070:
            r4.a r7 = r6.f25592c     // Catch:{ a -> 0x005f }
            r4.b r2 = r4.b.TRANSLATIONS_TEXT     // Catch:{ a -> 0x005f }
            java.lang.String r7 = r7.k(r2)     // Catch:{ a -> 0x005f }
            r2 = r6
            goto L_0x009e
        L_0x007a:
            com.inmobi.cmp.model.ChoiceError r7 = r7.f18186a
            int[] r5 = o4.C2710e.f25577a
            int r7 = r7.ordinal()
            r7 = r5[r7]
            if (r7 != r4) goto L_0x0096
            r0.f25586a = r2
            r0.f25589d = r3
            java.lang.Object r7 = r2.a(r0)
            if (r7 != r1) goto L_0x0091
        L_0x0090:
            return r1
        L_0x0091:
            r0 = r2
        L_0x0092:
            java.lang.String r7 = (java.lang.String) r7
            r2 = r0
            goto L_0x009e
        L_0x0096:
            r4.a r7 = r2.f25592c
            r4.b r0 = r4.b.TRANSLATIONS_TEXT
            java.lang.String r7 = r7.k(r0)
        L_0x009e:
            r4.a r0 = r2.f25592c
            r4.b r1 = r4.b.TRANSLATIONS_TEXT
            r0.i(r1, r7)
            q4.i r0 = r2.f25594e
            java.lang.Object r7 = r0.a(r7)
            m4.t r7 = (m4.t) r7
            r2.f25595f = r7
            if (r7 != 0) goto L_0x00b7
            java.lang.String r7 = "translationsText"
            kotlin.jvm.internal.t.w(r7)
            r7 = 0
        L_0x00b7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.k.c(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ff, code lost:
        if (r1 == null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0103, code lost:
        r11 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x011f, code lost:
        if (r1 == null) goto L_0x0101;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m4.i d() {
        /*
            r20 = this;
            r0 = r20
            r0.i()
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25364a
            int r1 = r1.length()
            java.lang.String r2 = "translationsText"
            if (r1 != 0) goto L_0x001f
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0019
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0019:
            m4.g r1 = r1.f25496a
            java.lang.String r1 = r1.f25364a
        L_0x001d:
            r5 = r1
            goto L_0x0024
        L_0x001f:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25364a
            goto L_0x001d
        L_0x0024:
            m4.k r1 = r0.f25597h
            java.util.List r1 = r1.f25431p
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x004a
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0036
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0036:
            m4.k r1 = r1.f25498c
            java.util.List r6 = r1.f25431p
            r13 = 62
            r14 = 0
            java.lang.String r7 = " "
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r1 = X2.C2250q.V(r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x0048:
            r6 = r1
            goto L_0x005d
        L_0x004a:
            m4.k r1 = r0.f25597h
            java.util.List r6 = r1.f25431p
            r13 = 62
            r14 = 0
            java.lang.String r7 = " "
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r1 = X2.C2250q.V(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0048
        L_0x005d:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25368e
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0075
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x006f
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x006f:
            m4.g r1 = r1.f25496a
            java.lang.String r1 = r1.f25368e
        L_0x0073:
            r7 = r1
            goto L_0x007a
        L_0x0075:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25368e
            goto L_0x0073
        L_0x007a:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25365b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0092
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x008c
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x008c:
            m4.g r1 = r1.f25496a
            java.lang.String r1 = r1.f25365b
        L_0x0090:
            r8 = r1
            goto L_0x0097
        L_0x0092:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25365b
            goto L_0x0090
        L_0x0097:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25367d
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00af
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x00a9
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x00a9:
            m4.g r1 = r1.f25496a
            java.lang.String r1 = r1.f25367d
        L_0x00ad:
            r9 = r1
            goto L_0x00b4
        L_0x00af:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25367d
            goto L_0x00ad
        L_0x00b4:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25380q
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00cc
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x00c6
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x00c6:
            m4.g r1 = r1.f25496a
            java.lang.String r1 = r1.f25380q
        L_0x00ca:
            r10 = r1
            goto L_0x00d1
        L_0x00cc:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25380q
            goto L_0x00ca
        L_0x00d1:
            m4.p r1 = r0.f25598i
            java.util.List r1 = r1.f25484j
            boolean r1 = r1.isEmpty()
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0105
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x00e5
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x00e5:
            m4.p r1 = r1.f25497b
            java.util.List r1 = r1.f25484j
            boolean r11 = r1.isEmpty()
            if (r11 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r1 = 0
        L_0x00f1:
            if (r1 != 0) goto L_0x00f4
            goto L_0x0101
        L_0x00f4:
            java.lang.Object r1 = X2.C2250q.M(r1)
            m4.q r1 = (m4.q) r1
            if (r1 != 0) goto L_0x00fd
            goto L_0x0101
        L_0x00fd:
            java.lang.String r1 = r1.f25486b
            if (r1 != 0) goto L_0x0103
        L_0x0101:
            r11 = r4
            goto L_0x0122
        L_0x0103:
            r11 = r1
            goto L_0x0122
        L_0x0105:
            m4.p r1 = r0.f25598i
            java.util.List r1 = r1.f25484j
            boolean r11 = r1.isEmpty()
            if (r11 != 0) goto L_0x0110
            goto L_0x0111
        L_0x0110:
            r1 = 0
        L_0x0111:
            if (r1 != 0) goto L_0x0114
            goto L_0x0121
        L_0x0114:
            java.lang.Object r1 = X2.C2250q.M(r1)
            m4.q r1 = (m4.q) r1
            if (r1 != 0) goto L_0x011d
            goto L_0x0121
        L_0x011d:
            java.lang.String r1 = r1.f25486b
            if (r1 != 0) goto L_0x0103
        L_0x0121:
            goto L_0x0101
        L_0x0122:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25343E
            int r1 = r1.length()
            if (r1 != 0) goto L_0x013a
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0134
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0134:
            m4.g r1 = r1.f25496a
            java.lang.String r1 = r1.f25343E
        L_0x0138:
            r12 = r1
            goto L_0x013f
        L_0x013a:
            m4.g r1 = r0.f25596g
            java.lang.String r1 = r1.f25343E
            goto L_0x0138
        L_0x013f:
            m4.e r13 = new m4.e
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0149
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0149:
            m4.e r1 = r1.f25499d
            java.lang.String r14 = r1.f25332a
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0155
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0155:
            m4.e r1 = r1.f25499d
            java.lang.String r15 = r1.f25333b
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0161
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0161:
            m4.e r1 = r1.f25499d
            java.lang.String r1 = r1.f25334c
            m4.t r4 = r0.f25595f
            if (r4 != 0) goto L_0x016d
            kotlin.jvm.internal.t.w(r2)
            r4 = 0
        L_0x016d:
            m4.e r4 = r4.f25499d
            java.lang.String r4 = r4.f25335d
            m4.t r3 = r0.f25595f
            if (r3 != 0) goto L_0x0179
            kotlin.jvm.internal.t.w(r2)
            r3 = 0
        L_0x0179:
            m4.e r3 = r3.f25499d
            java.lang.String r3 = r3.f25336e
            r16 = r1
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x0187
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x0187:
            m4.e r1 = r1.f25499d
            java.util.List r1 = r1.f25337f
            r19 = r1
            r18 = r3
            r17 = r4
            r13.<init>(r14, r15, r16, r17, r18, r19)
            m4.a r14 = new m4.a
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x019e
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x019e:
            m4.a r1 = r1.f25500e
            java.lang.String r15 = r1.f25303a
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x01aa
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x01aa:
            m4.a r1 = r1.f25500e
            java.lang.String r1 = r1.f25304b
            m4.t r3 = r0.f25595f
            if (r3 != 0) goto L_0x01b6
            kotlin.jvm.internal.t.w(r2)
            r3 = 0
        L_0x01b6:
            m4.a r3 = r3.f25500e
            java.lang.String r3 = r3.f25305c
            m4.t r4 = r0.f25595f
            if (r4 != 0) goto L_0x01c2
            kotlin.jvm.internal.t.w(r2)
            r4 = 0
        L_0x01c2:
            m4.a r4 = r4.f25500e
            java.lang.String r4 = r4.f25306d
            r16 = r1
            m4.t r1 = r0.f25595f
            if (r1 != 0) goto L_0x01d0
            kotlin.jvm.internal.t.w(r2)
            r1 = 0
        L_0x01d0:
            m4.a r1 = r1.f25500e
            java.util.List r1 = r1.f25307e
            r19 = r1
            r17 = r3
            r18 = r4
            r14.<init>(r15, r16, r17, r18, r19)
            m4.i r4 = new m4.i
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.k.d():m4.i");
    }

    public final m4.l e() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        m4.l lVar;
        i();
        if (this.f25596g.f25364a.length() == 0) {
            t tVar = this.f25595f;
            if (tVar == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar = null;
            }
            str = tVar.f25496a.f25364a;
        } else {
            str = this.f25596g.f25364a;
        }
        if (this.f25597h.f25431p.isEmpty()) {
            t tVar2 = this.f25595f;
            if (tVar2 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar2 = null;
            }
            str2 = C2250q.V(tVar2.f25498c.f25431p, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (k3.l) null, 62, (Object) null);
        } else {
            str2 = C2250q.V(this.f25597h.f25431p, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (k3.l) null, 62, (Object) null);
        }
        if (this.f25596g.f25381r.length() == 0) {
            t tVar3 = this.f25595f;
            if (tVar3 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar3 = null;
            }
            str3 = tVar3.f25496a.f25381r;
        } else {
            str3 = this.f25596g.f25381r;
        }
        if (this.f25596g.f25355Q.length() == 0) {
            t tVar4 = this.f25595f;
            if (tVar4 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar4 = null;
            }
            str4 = tVar4.f25496a.f25355Q;
        } else {
            str4 = this.f25596g.f25355Q;
        }
        if (this.f25597h.f25421f.length() == 0) {
            t tVar5 = this.f25595f;
            if (tVar5 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar5 = null;
            }
            str5 = tVar5.f25498c.f25421f;
        } else {
            str5 = this.f25597h.f25421f;
        }
        if (this.f25596g.f25378o.length() == 0) {
            t tVar6 = this.f25595f;
            if (tVar6 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar6 = null;
            }
            str6 = tVar6.f25496a.f25378o;
        } else {
            str6 = this.f25596g.f25378o;
        }
        if (this.f25596g.f25366c.length() == 0) {
            t tVar7 = this.f25595f;
            if (tVar7 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar7 = null;
            }
            str7 = tVar7.f25496a.f25366c;
        } else {
            str7 = this.f25596g.f25366c;
        }
        if (this.f25596g.f25379p.length() == 0) {
            t tVar8 = this.f25595f;
            if (tVar8 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar8 = null;
            }
            str8 = tVar8.f25496a.f25379p;
        } else {
            str8 = this.f25596g.f25379p;
        }
        if (this.f25596g.f25339A.length() == 0) {
            t tVar9 = this.f25595f;
            if (tVar9 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar9 = null;
            }
            str9 = tVar9.f25496a.f25339A;
        } else {
            str9 = this.f25596g.f25339A;
        }
        if (this.f25596g.f25380q.length() == 0) {
            t tVar10 = this.f25595f;
            if (tVar10 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar10 = null;
            }
            str10 = tVar10.f25496a.f25380q;
        } else {
            str10 = this.f25596g.f25380q;
        }
        if (this.f25597h.f25424i.length() == 0) {
            t tVar11 = this.f25595f;
            if (tVar11 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar11 = null;
            }
            str11 = tVar11.f25498c.f25424i;
        } else {
            str11 = this.f25597h.f25424i;
        }
        if (this.f25597h.f25425j.length() == 0) {
            t tVar12 = this.f25595f;
            if (tVar12 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar12 = null;
            }
            str12 = tVar12.f25498c.f25425j;
        } else {
            str12 = this.f25597h.f25425j;
        }
        if (this.f25597h.f25426k.length() == 0) {
            t tVar13 = this.f25595f;
            if (tVar13 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar13 = null;
            }
            str13 = tVar13.f25498c.f25426k;
        } else {
            str13 = this.f25597h.f25426k;
        }
        if (this.f25597h.f25427l.length() == 0) {
            t tVar14 = this.f25595f;
            if (tVar14 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar14 = null;
            }
            str14 = tVar14.f25498c.f25427l;
        } else {
            str14 = this.f25597h.f25427l;
        }
        String b5 = b();
        String str16 = str14;
        if (this.f25596g.f25340B.length() == 0) {
            t tVar15 = this.f25595f;
            if (tVar15 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar15 = null;
            }
            str15 = tVar15.f25496a.f25340B;
        } else {
            str15 = this.f25596g.f25340B;
        }
        String str17 = str15;
        t tVar16 = this.f25595f;
        if (tVar16 == null) {
            kotlin.jvm.internal.t.w("translationsText");
            tVar16 = null;
        }
        e eVar = tVar16.f25499d;
        t tVar17 = this.f25595f;
        if (tVar17 == null) {
            kotlin.jvm.internal.t.w("translationsText");
            tVar17 = null;
        }
        lVar = new m4.l(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str16, b5, str17, eVar, tVar17.f25500e);
        return lVar;
    }

    public final n f() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        i();
        t tVar = null;
        if (this.f25597h.f25421f.length() == 0) {
            t tVar2 = this.f25595f;
            if (tVar2 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar2 = null;
            }
            str = tVar2.f25498c.f25421f;
        } else {
            str = this.f25597h.f25421f;
        }
        if (this.f25596g.f25342D.length() == 0) {
            t tVar3 = this.f25595f;
            if (tVar3 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar3 = null;
            }
            str2 = tVar3.f25496a.f25342D;
        } else {
            str2 = this.f25596g.f25342D;
        }
        if (this.f25597h.f25417b.length() == 0) {
            t tVar4 = this.f25595f;
            if (tVar4 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar4 = null;
            }
            str3 = tVar4.f25498c.f25417b;
        } else {
            str3 = this.f25597h.f25417b;
        }
        if (this.f25596g.f25380q.length() == 0) {
            t tVar5 = this.f25595f;
            if (tVar5 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar5 = null;
            }
            str4 = tVar5.f25496a.f25380q;
        } else {
            str4 = this.f25596g.f25380q;
        }
        if (this.f25597h.f25419d.length() == 0) {
            t tVar6 = this.f25595f;
            if (tVar6 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar6 = null;
            }
            str5 = tVar6.f25498c.f25419d;
        } else {
            str5 = this.f25597h.f25419d;
        }
        if (this.f25597h.f25420e.length() == 0) {
            t tVar7 = this.f25595f;
            if (tVar7 == null) {
                kotlin.jvm.internal.t.w("translationsText");
            } else {
                tVar = tVar7;
            }
            str6 = tVar.f25498c.f25420e;
        } else {
            str6 = this.f25597h.f25420e;
        }
        return new n(str, str2, str3, str4, str5, str6, b());
    }

    public final m g() {
        String str;
        String upperCase;
        String upperCase2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        i();
        t tVar = null;
        if (this.f25596g.f25355Q.length() == 0) {
            t tVar2 = this.f25595f;
            if (tVar2 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar2 = null;
            }
            str = tVar2.f25496a.f25355Q;
        } else {
            str = this.f25596g.f25355Q;
        }
        String str14 = str;
        if (this.f25596g.f25381r.length() == 0) {
            t tVar3 = this.f25595f;
            if (tVar3 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar3 = null;
            }
            upperCase = tVar3.f25496a.f25381r.toUpperCase(this.f25590a);
            kotlin.jvm.internal.t.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        } else {
            upperCase = this.f25596g.f25381r.toUpperCase(this.f25590a);
            kotlin.jvm.internal.t.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        }
        String str15 = upperCase;
        if (this.f25596g.f25382s.length() == 0) {
            t tVar4 = this.f25595f;
            if (tVar4 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar4 = null;
            }
            upperCase2 = tVar4.f25496a.f25382s.toUpperCase(this.f25590a);
            kotlin.jvm.internal.t.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        } else {
            upperCase2 = this.f25596g.f25382s.toUpperCase(this.f25590a);
            kotlin.jvm.internal.t.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        }
        String str16 = upperCase2;
        if (this.f25596g.f25384u.length() == 0) {
            t tVar5 = this.f25595f;
            if (tVar5 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar5 = null;
            }
            str2 = tVar5.f25496a.f25384u;
        } else {
            str2 = this.f25596g.f25384u;
        }
        String str17 = str2;
        if (this.f25596g.f25383t.length() == 0) {
            t tVar6 = this.f25595f;
            if (tVar6 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar6 = null;
            }
            str3 = tVar6.f25496a.f25383t;
        } else {
            str3 = this.f25596g.f25383t;
        }
        String str18 = str3;
        if (this.f25596g.f25385v.length() == 0) {
            t tVar7 = this.f25595f;
            if (tVar7 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar7 = null;
            }
            str4 = tVar7.f25496a.f25385v;
        } else {
            str4 = this.f25596g.f25385v;
        }
        String str19 = str4;
        if (this.f25596g.f25343E.length() == 0) {
            t tVar8 = this.f25595f;
            if (tVar8 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar8 = null;
            }
            str5 = tVar8.f25496a.f25343E;
        } else {
            str5 = this.f25596g.f25343E;
        }
        String str20 = str5;
        if (this.f25596g.f25356R.length() == 0) {
            t tVar9 = this.f25595f;
            if (tVar9 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar9 = null;
            }
            str6 = tVar9.f25496a.f25356R;
        } else {
            str6 = this.f25596g.f25356R;
        }
        String str21 = str6;
        if (this.f25596g.f25357S.length() == 0) {
            t tVar10 = this.f25595f;
            if (tVar10 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar10 = null;
            }
            str7 = tVar10.f25496a.f25357S;
        } else {
            str7 = this.f25596g.f25357S;
        }
        String str22 = str7;
        if (this.f25596g.f25358T.length() == 0) {
            t tVar11 = this.f25595f;
            if (tVar11 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar11 = null;
            }
            str8 = tVar11.f25496a.f25358T;
        } else {
            str8 = this.f25596g.f25358T;
        }
        String str23 = str8;
        if (this.f25596g.f25359U.length() == 0) {
            t tVar12 = this.f25595f;
            if (tVar12 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar12 = null;
            }
            str9 = tVar12.f25496a.f25359U;
        } else {
            str9 = this.f25596g.f25359U;
        }
        String str24 = str9;
        if (this.f25596g.f25360V.length() == 0) {
            t tVar13 = this.f25595f;
            if (tVar13 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar13 = null;
            }
            str10 = tVar13.f25496a.f25360V;
        } else {
            str10 = this.f25596g.f25360V;
        }
        String str25 = str10;
        if (this.f25596g.f25361W.length() == 0) {
            t tVar14 = this.f25595f;
            if (tVar14 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar14 = null;
            }
            str11 = tVar14.f25496a.f25361W;
        } else {
            str11 = this.f25596g.f25361W;
        }
        String str26 = str11;
        if (this.f25596g.f25362X.length() == 0) {
            t tVar15 = this.f25595f;
            if (tVar15 == null) {
                kotlin.jvm.internal.t.w("translationsText");
                tVar15 = null;
            }
            str12 = tVar15.f25496a.f25362X;
        } else {
            str12 = this.f25596g.f25362X;
        }
        String str27 = str12;
        String b5 = b();
        if (this.f25596g.f25363Y.length() == 0) {
            t tVar16 = this.f25595f;
            if (tVar16 == null) {
                kotlin.jvm.internal.t.w("translationsText");
            } else {
                tVar = tVar16;
            }
            str13 = tVar.f25496a.f25363Y;
        } else {
            str13 = this.f25596g.f25363Y;
        }
        return new m(str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str27, str24, str25, str26, b5, str13);
    }

    public final String h() {
        String str;
        String str2;
        if (V2.a.e() || V2.a.d()) {
            str = c.j().f19281b.f19234Y.f19300c;
        } else {
            str = c.j().f19281b.f19234Y.f19298a;
        }
        String str3 = str;
        String c5 = V2.a.c();
        if (str3 == null) {
            str2 = null;
        } else {
            String lowerCase = c5.toLowerCase(this.f25590a);
            kotlin.jvm.internal.t.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            str2 = s.L(str3, "${language}", lowerCase, false, 4, (Object) null);
        }
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder("https://cmp.inmobi.com/tcfv2/translations/");
        String lowerCase2 = c5.toLowerCase(this.f25590a);
        kotlin.jvm.internal.t.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase2);
        sb.append(".json");
        return sb.toString();
    }

    public final void i() {
        t tVar;
        if (this.f25595f == null) {
            String k5 = this.f25592c.k(b.TRANSLATIONS_TEXT);
            if (k5.length() > 0) {
                tVar = (t) this.f25594e.a(k5);
            } else {
                new t
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: CONSTRUCTOR  (r0v4 ? I:m4.t) =  call: m4.t.<init>():void type: CONSTRUCTOR in method: o4.k.i():void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v4 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 41 more
                    */
                /*
                    this = this;
                    m4.t r0 = r2.f25595f
                    if (r0 != 0) goto L_0x0022
                    r4.a r0 = r2.f25592c
                    r4.b r1 = r4.b.TRANSLATIONS_TEXT
                    java.lang.String r0 = r0.k(r1)
                    int r1 = r0.length()
                    if (r1 <= 0) goto L_0x001b
                    q4.i r1 = r2.f25594e
                    java.lang.Object r0 = r1.a(r0)
                    m4.t r0 = (m4.t) r0
                    goto L_0x0020
                L_0x001b:
                    m4.t r0 = new m4.t
                    r0.<init>()
                L_0x0020:
                    r2.f25595f = r0
                L_0x0022:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: o4.k.i():void");
            }
        }
