package o4;

import android.app.Application;
import android.content.Context;
import java.util.Locale;
import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import q4.i;
import q4.m;

public final class B implements w {

    /* renamed from: a  reason: collision with root package name */
    public final Context f25541a;

    /* renamed from: b  reason: collision with root package name */
    public final a f25542b;

    /* renamed from: c  reason: collision with root package name */
    public final Locale f25543c;

    /* renamed from: d  reason: collision with root package name */
    public final r4.a f25544d;

    /* renamed from: e  reason: collision with root package name */
    public final h f25545e;

    /* renamed from: f  reason: collision with root package name */
    public final i f25546f;

    public B(Application application, a aVar, Locale locale, r4.a aVar2, h hVar, m mVar) {
        t.e(application, "context");
        t.e(aVar, "networkUtil");
        t.e(locale, "appLocale");
        t.e(aVar2, "sharedStorage");
        t.e(hVar, "requestApi");
        t.e(mVar, "resolver");
        this.f25541a = application;
        this.f25542b = aVar;
        this.f25543c = locale;
        this.f25544d = aVar2;
        this.f25545e = hVar;
        this.f25546f = mVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0092, code lost:
        h3.C2453b.a(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0095, code lost:
        throw r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(int r7, b3.C2308e r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof o4.x
            if (r0 == 0) goto L_0x0013
            r0 = r8
            o4.x r0 = (o4.x) r0
            int r1 = r0.f25643f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25643f = r1
            goto L_0x0018
        L_0x0013:
            o4.x r0 = new o4.x
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25641d
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25643f
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x0047
            if (r2 == r3) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r7 = r0.f25639b
            java.lang.String r7 = (java.lang.String) r7
            o4.B r0 = r0.f25638a
            W2.u.b(r8)
            goto L_0x00ae
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            int r7 = r0.f25640c
            java.lang.Object r2 = r0.f25639b
            o4.B r2 = (o4.B) r2
            o4.B r3 = r0.f25638a
            W2.u.b(r8)
            goto L_0x005b
        L_0x0047:
            W2.u.b(r8)
            r0.f25638a = r6
            r0.f25639b = r6
            r0.f25640c = r7
            r0.f25643f = r3
            java.lang.Object r8 = r6.c(r7, r0)
            if (r8 != r1) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            r2 = r6
            r3 = r2
        L_0x005b:
            java.lang.String r8 = (java.lang.String) r8
            r2.getClass()
            int r5 = r8.length()
            if (r5 != 0) goto L_0x0096
            if (r7 <= r4) goto L_0x006b
            int r8 = E1.d.vendor_list_3
            goto L_0x006d
        L_0x006b:
            int r8 = E1.d.vendor_list_2
        L_0x006d:
            android.content.Context r2 = r2.f25541a
            android.content.res.Resources r2 = r2.getResources()
            java.io.InputStream r8 = r2.openRawResource(r8)
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r5 = new java.io.InputStreamReader
            r5.<init>(r8)
            r2.<init>(r5)
            java.lang.String r8 = r2.readLine()     // Catch:{ all -> 0x008f }
            r5 = 0
            h3.C2453b.a(r2, r5)
            java.lang.String r2 = "{\n            val resour…}\n            }\n        }"
            kotlin.jvm.internal.t.d(r8, r2)
            goto L_0x0096
        L_0x008f:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r8 = move-exception
            h3.C2453b.a(r2, r7)
            throw r8
        L_0x0096:
            r4.a r2 = r3.f25544d
            r4.b r5 = r4.b.VENDOR_LIST
            r2.i(r5, r8)
            r0.f25638a = r3
            r0.f25639b = r8
            r0.f25643f = r4
            java.lang.Object r7 = r3.d(r7, r0)
            if (r7 != r1) goto L_0x00aa
        L_0x00a9:
            return r1
        L_0x00aa:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r3
        L_0x00ae:
            java.lang.String r8 = (java.lang.String) r8
            q4.i r1 = r0.f25546f
            java.lang.Object r7 = r1.a(r7)
            P3.d r7 = (P3.d) r7
            r4.a r1 = r0.f25544d
            r4.b r2 = r4.b.TCF_POLICY_VERSION
            java.lang.Integer r3 = r7.f18871c
            if (r3 != 0) goto L_0x00c2
            r3 = r4
            goto L_0x00c6
        L_0x00c2:
            int r3 = r3.intValue()
        L_0x00c6:
            r1.f(r2, r3)
            r4.a r1 = r0.f25544d
            r4.b r2 = r4.b.GPP_POLICY_VERSION
            java.lang.Integer r3 = r7.f18871c
            if (r3 != 0) goto L_0x00d2
            goto L_0x00d6
        L_0x00d2:
            int r4 = r3.intValue()
        L_0x00d6:
            r1.f(r2, r4)
            int r1 = r8.length()
            if (r1 <= 0) goto L_0x0120
            q4.i r1 = r0.f25546f
            java.lang.Object r8 = r1.a(r8)
            P3.d r8 = (P3.d) r8
            java.util.Map r1 = r8.f18872d
            java.lang.String r2 = "<set-?>"
            kotlin.jvm.internal.t.e(r1, r2)
            r7.f18872d = r1
            java.util.Map r1 = r8.f18873e
            kotlin.jvm.internal.t.e(r1, r2)
            r7.f18873e = r1
            java.util.Map r1 = r8.f18874f
            kotlin.jvm.internal.t.e(r1, r2)
            r7.f18874f = r1
            java.util.Map r1 = r8.f18875g
            kotlin.jvm.internal.t.e(r1, r2)
            r7.f18875g = r1
            java.util.Map r1 = r8.f18878j
            kotlin.jvm.internal.t.e(r1, r2)
            r7.f18878j = r1
            java.util.Map r8 = r8.f18879k
            kotlin.jvm.internal.t.e(r8, r2)
            r7.f18879k = r8
            r4.a r8 = r0.f25544d
            r4.b r0 = r4.b.PORTAL_CHOICE_LANG
            java.lang.String r8 = r8.k(r0)
            kotlin.jvm.internal.t.e(r8, r2)
            r7.f18880l = r8
        L_0x0120:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.B.a(int, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(int r9, b3.C2308e r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof o4.y
            if (r0 == 0) goto L_0x0013
            r0 = r10
            o4.y r0 = (o4.y) r0
            int r1 = r0.f25646c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25646c = r1
            goto L_0x0018
        L_0x0013:
            o4.y r0 = new o4.y
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f25644a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25646c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r10)     // Catch:{ a -> 0x006d }
            goto L_0x006a
        L_0x0029:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0031:
            W2.u.b(r10)
            n4.h r10 = r8.f25545e     // Catch:{ a -> 0x006d }
            kotlin.jvm.internal.Q r2 = kotlin.jvm.internal.Q.f24695a     // Catch:{ a -> 0x006d }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r4 = "GVL-v%s/purposes-%s.json"
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r4)     // Catch:{ a -> 0x006d }
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.b.b(r9)     // Catch:{ a -> 0x006d }
            r4.a r4 = r8.f25544d     // Catch:{ a -> 0x006d }
            r4.b r5 = r4.b.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x006d }
            java.lang.String r4 = r4.k(r5)     // Catch:{ a -> 0x006d }
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ a -> 0x006d }
            r7 = 0
            r6[r7] = r9     // Catch:{ a -> 0x006d }
            r6[r3] = r4     // Catch:{ a -> 0x006d }
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r6, r5)     // Catch:{ a -> 0x006d }
            java.lang.String r9 = java.lang.String.format(r2, r9)     // Catch:{ a -> 0x006d }
            java.lang.String r2 = "format(format, *args)"
            kotlin.jvm.internal.t.d(r9, r2)     // Catch:{ a -> 0x006d }
            r0.f25646c = r3     // Catch:{ a -> 0x006d }
            java.lang.Object r10 = r10.a(r9, r0)     // Catch:{ a -> 0x006d }
            if (r10 != r1) goto L_0x006a
            return r1
        L_0x006a:
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ a -> 0x006d }
            return r10
        L_0x006d:
            java.lang.String r9 = ""
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.B.b(int, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(int r8, b3.C2308e r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof o4.z
            if (r0 == 0) goto L_0x0013
            r0 = r9
            o4.z r0 = (o4.z) r0
            int r1 = r0.f25650d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25650d = r1
            goto L_0x0018
        L_0x0013:
            o4.z r0 = new o4.z
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f25648b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25650d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            o4.B r8 = r0.f25647a
            W2.u.b(r9)     // Catch:{ a -> 0x0087 }
            goto L_0x006c
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            W2.u.b(r9)
            n4.a r9 = r7.f25542b     // Catch:{ a -> 0x0086 }
            boolean r9 = r9.a()     // Catch:{ a -> 0x0086 }
            if (r9 == 0) goto L_0x006f
            n4.h r9 = r7.f25545e     // Catch:{ a -> 0x0086 }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            kotlin.jvm.internal.Q r4 = kotlin.jvm.internal.Q.f24695a     // Catch:{ a -> 0x0086 }
            java.lang.String r4 = "GVL-v%s/vendor-list.json"
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.b.b(r8)     // Catch:{ a -> 0x0086 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ a -> 0x0086 }
            r6 = 0
            r5[r6] = r8     // Catch:{ a -> 0x0086 }
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r5, r3)     // Catch:{ a -> 0x0086 }
            java.lang.String r8 = java.lang.String.format(r4, r8)     // Catch:{ a -> 0x0086 }
            java.lang.String r4 = "format(format, *args)"
            kotlin.jvm.internal.t.d(r8, r4)     // Catch:{ a -> 0x0086 }
            java.lang.String r8 = kotlin.jvm.internal.t.n(r2, r8)     // Catch:{ a -> 0x0086 }
            r0.f25647a = r7     // Catch:{ a -> 0x0086 }
            r0.f25650d = r3     // Catch:{ a -> 0x0086 }
            java.lang.Object r9 = r9.a(r8, r0)     // Catch:{ a -> 0x0086 }
            if (r9 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r8 = r7
        L_0x006c:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ a -> 0x0087 }
            return r9
        L_0x006f:
            com.inmobi.cmp.ChoiceCmp r8 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x0086 }
            com.inmobi.cmp.ChoiceCmpCallback r8 = r8.getCallback()     // Catch:{ a -> 0x0086 }
            if (r8 != 0) goto L_0x0078
            goto L_0x007d
        L_0x0078:
            com.inmobi.cmp.model.ChoiceError r9 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0086 }
            r8.onCmpError(r9)     // Catch:{ a -> 0x0086 }
        L_0x007d:
            r4.a r8 = r7.f25544d     // Catch:{ a -> 0x0086 }
            r4.b r9 = r4.b.VENDOR_LIST     // Catch:{ a -> 0x0086 }
            java.lang.String r8 = r8.k(r9)     // Catch:{ a -> 0x0086 }
            return r8
        L_0x0086:
            r8 = r7
        L_0x0087:
            r4.a r8 = r8.f25544d
            r4.b r9 = r4.b.VENDOR_LIST
            java.lang.String r8 = r8.k(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.B.c(int, b3.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
        if (r14 != r1) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(int r13, b3.C2308e r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof o4.A
            if (r0 == 0) goto L_0x0013
            r0 = r14
            o4.A r0 = (o4.A) r0
            int r1 = r0.f25540f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25540f = r1
            goto L_0x0018
        L_0x0013:
            o4.A r0 = new o4.A
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f25538d
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25540f
            java.lang.String r3 = "en"
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0037
            if (r2 != r5) goto L_0x002f
            W2.u.b(r14)
            goto L_0x00cd
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            int r13 = r0.f25537c
            java.lang.String r2 = r0.f25536b
            o4.B r4 = r0.f25535a
            W2.u.b(r14)     // Catch:{ a -> 0x00b8 }
            goto L_0x00a9
        L_0x0041:
            W2.u.b(r14)
            java.lang.String r2 = V2.a.c()     // Catch:{ a -> 0x00b7 }
            java.util.Locale r14 = r12.f25543c     // Catch:{ a -> 0x00b7 }
            java.lang.String r6 = r2.toLowerCase(r14)     // Catch:{ a -> 0x00b7 }
            java.lang.String r14 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.t.d(r6, r14)     // Catch:{ a -> 0x00b7 }
            java.lang.String r14 = "-"
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch:{ a -> 0x00b7 }
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            java.util.List r14 = t3.s.G0(r6, r7, r8, r9, r10, r11)     // Catch:{ a -> 0x00b7 }
            java.lang.Object r14 = X2.C2250q.M(r14)     // Catch:{ a -> 0x00b7 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ a -> 0x00b7 }
            n4.a r6 = r12.f25542b     // Catch:{ a -> 0x00b7 }
            boolean r6 = r6.a()     // Catch:{ a -> 0x00b7 }
            if (r6 == 0) goto L_0x00ac
            boolean r14 = kotlin.jvm.internal.t.a(r14, r3)     // Catch:{ a -> 0x00b7 }
            if (r14 != 0) goto L_0x00ac
            n4.h r14 = r12.f25545e     // Catch:{ a -> 0x00b7 }
            kotlin.jvm.internal.Q r6 = kotlin.jvm.internal.Q.f24695a     // Catch:{ a -> 0x00b7 }
            java.lang.String r6 = "https://cmp.inmobi.com/"
            java.lang.String r7 = "GVL-v%s/purposes-%s.json"
            java.lang.String r6 = kotlin.jvm.internal.t.n(r6, r7)     // Catch:{ a -> 0x00b7 }
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.b(r13)     // Catch:{ a -> 0x00b7 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ a -> 0x00b7 }
            r9 = 0
            r8[r9] = r7     // Catch:{ a -> 0x00b7 }
            r8[r4] = r2     // Catch:{ a -> 0x00b7 }
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r8, r5)     // Catch:{ a -> 0x00b7 }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ a -> 0x00b7 }
            java.lang.String r7 = "format(format, *args)"
            kotlin.jvm.internal.t.d(r6, r7)     // Catch:{ a -> 0x00b7 }
            r0.f25535a = r12     // Catch:{ a -> 0x00b7 }
            r0.f25536b = r2     // Catch:{ a -> 0x00b7 }
            r0.f25537c = r13     // Catch:{ a -> 0x00b7 }
            r0.f25540f = r4     // Catch:{ a -> 0x00b7 }
            java.lang.Object r14 = r14.a(r6, r0)     // Catch:{ a -> 0x00b7 }
            if (r14 != r1) goto L_0x00a8
            goto L_0x00cc
        L_0x00a8:
            r4 = r12
        L_0x00a9:
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ a -> 0x00b8 }
            goto L_0x00af
        L_0x00ac:
            java.lang.String r14 = ""
            r4 = r12
        L_0x00af:
            r4.a r6 = r4.f25544d     // Catch:{ a -> 0x00b8 }
            r4.b r7 = r4.b.PORTAL_CHOICE_LANG     // Catch:{ a -> 0x00b8 }
            r6.i(r7, r2)     // Catch:{ a -> 0x00b8 }
            return r14
        L_0x00b7:
            r4 = r12
        L_0x00b8:
            r4.a r14 = r4.f25544d
            r4.b r2 = r4.b.PORTAL_CHOICE_LANG
            r14.i(r2, r3)
            r14 = 0
            r0.f25535a = r14
            r0.f25536b = r14
            r0.f25540f = r5
            java.lang.Object r14 = r4.b(r13, r0)
            if (r14 != r1) goto L_0x00cd
        L_0x00cc:
            return r1
        L_0x00cd:
            java.lang.String r14 = (java.lang.String) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.B.d(int, b3.e):java.lang.Object");
    }
}
