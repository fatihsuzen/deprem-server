package n2;

import android.content.Context;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.t;
import o2.C2702a;
import q2.C2718e;
import q2.C2724k;
import w3.C2865c0;
import w3.C2908y0;
import w3.N;
import w3.O;

/* renamed from: n2.a  reason: case insensitive filesystem */
public final class C2693a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f25501a;

    public C2693a(Context context) {
        t.e(context, "context");
        this.f25501a = context;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(n2.C2693a r7, q2.C2717d r8, o2.C2702a r9, b3.C2308e r10) {
        /*
            java.lang.String r0 = "errorMsg"
            java.lang.String r1 = "success"
            r7.getClass()
            boolean r2 = r10 instanceof n2.C2695c
            if (r2 == 0) goto L_0x001a
            r2 = r10
            n2.c r2 = (n2.C2695c) r2
            int r3 = r2.f25509d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001a
            int r3 = r3 - r4
            r2.f25509d = r3
            goto L_0x001f
        L_0x001a:
            n2.c r2 = new n2.c
            r2.<init>(r7, r10)
        L_0x001f:
            java.lang.Object r10 = r2.f25507b
            java.lang.Object r3 = c3.C2316b.f()
            int r4 = r2.f25509d
            r5 = 0
            switch(r4) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0038;
                case 2: goto L_0x0038;
                case 3: goto L_0x0038;
                case 4: goto L_0x0038;
                case 5: goto L_0x0038;
                case 6: goto L_0x0033;
                default: goto L_0x002b;
            }
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            W2.u.b(r10)
            goto L_0x011c
        L_0x0038:
            o2.a r7 = r2.f25506a
            r9 = r7
            W2.u.b(r10)     // Catch:{ JSONException -> 0x0040 }
            goto L_0x011c
        L_0x0040:
            r7 = move-exception
            goto L_0x0104
        L_0x0043:
            W2.u.b(r10)
            int r10 = r8.b()     // Catch:{ JSONException -> 0x0040 }
            r4 = 409(0x199, float:5.73E-43)
            r6 = 1
            if (r10 != r4) goto L_0x0076
            q2.e r8 = new q2.e     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r10 = r7.f25501a     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r10)     // Catch:{ JSONException -> 0x0040 }
            q2.k r10 = q2.C2724k.f25689a     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r7 = r7.f25501a     // Catch:{ JSONException -> 0x0040 }
            long r0 = r10.d(r7)     // Catch:{ JSONException -> 0x0040 }
            r8.b(r0)     // Catch:{ JSONException -> 0x0040 }
            w3.I0 r7 = w3.C2865c0.c()     // Catch:{ JSONException -> 0x0040 }
            n2.d r8 = new n2.d     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f25506a = r9     // Catch:{ JSONException -> 0x0040 }
            r2.f25509d = r6     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = w3.C2872g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x0076:
            java.lang.String r10 = r8.a()     // Catch:{ JSONException -> 0x0040 }
            if (r10 == 0) goto L_0x00ef
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0040 }
            java.lang.String r8 = r8.a()     // Catch:{ JSONException -> 0x0040 }
            kotlin.jvm.internal.t.b(r8)     // Catch:{ JSONException -> 0x0040 }
            r10.<init>(r8)     // Catch:{ JSONException -> 0x0040 }
            boolean r8 = r10.has(r1)     // Catch:{ JSONException -> 0x0040 }
            if (r8 == 0) goto L_0x00bb
            int r8 = r10.getInt(r1)     // Catch:{ JSONException -> 0x0040 }
            if (r8 != r6) goto L_0x00bb
            q2.e r8 = new q2.e     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r10 = r7.f25501a     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r10)     // Catch:{ JSONException -> 0x0040 }
            q2.k r10 = q2.C2724k.f25689a     // Catch:{ JSONException -> 0x0040 }
            android.content.Context r7 = r7.f25501a     // Catch:{ JSONException -> 0x0040 }
            long r0 = r10.d(r7)     // Catch:{ JSONException -> 0x0040 }
            r8.b(r0)     // Catch:{ JSONException -> 0x0040 }
            w3.I0 r7 = w3.C2865c0.c()     // Catch:{ JSONException -> 0x0040 }
            n2.e r8 = new n2.e     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f25506a = r9     // Catch:{ JSONException -> 0x0040 }
            r10 = 2
            r2.f25509d = r10     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = w3.C2872g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x00bb:
            boolean r7 = r10.has(r0)     // Catch:{ JSONException -> 0x0040 }
            if (r7 == 0) goto L_0x00da
            java.lang.String r7 = r10.getString(r0)     // Catch:{ JSONException -> 0x0040 }
            w3.I0 r8 = w3.C2865c0.c()     // Catch:{ JSONException -> 0x0040 }
            n2.f r10 = new n2.f     // Catch:{ JSONException -> 0x0040 }
            r10.<init>(r9, r7, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f25506a = r9     // Catch:{ JSONException -> 0x0040 }
            r7 = 3
            r2.f25509d = r7     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = w3.C2872g.g(r8, r10, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x00da:
            w3.I0 r7 = w3.C2865c0.c()     // Catch:{ JSONException -> 0x0040 }
            n2.g r8 = new n2.g     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f25506a = r9     // Catch:{ JSONException -> 0x0040 }
            r10 = 4
            r2.f25509d = r10     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = w3.C2872g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x00ef:
            w3.I0 r7 = w3.C2865c0.c()     // Catch:{ JSONException -> 0x0040 }
            n2.h r8 = new n2.h     // Catch:{ JSONException -> 0x0040 }
            r8.<init>(r9, r5)     // Catch:{ JSONException -> 0x0040 }
            r2.f25506a = r9     // Catch:{ JSONException -> 0x0040 }
            r10 = 5
            r2.f25509d = r10     // Catch:{ JSONException -> 0x0040 }
            java.lang.Object r7 = w3.C2872g.g(r7, r8, r2)     // Catch:{ JSONException -> 0x0040 }
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x0104:
            r7.printStackTrace()
            w3.I0 r8 = w3.C2865c0.c()
            n2.i r10 = new n2.i
            r10.<init>(r9, r7, r5)
            r2.f25506a = r5
            r7 = 6
            r2.f25509d = r7
            java.lang.Object r7 = w3.C2872g.g(r8, r10, r2)
            if (r7 != r3) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            W2.J r3 = W2.J.f19942a
        L_0x011e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.C2693a.b(n2.a, q2.d, o2.a, b3.e):java.lang.Object");
    }

    public final void c(String str, C2702a aVar) {
        t.e(str, "token");
        t.e(aVar, "initListener");
        if (new C2718e(this.f25501a).a() == C2724k.f25689a.d(this.f25501a)) {
            aVar.c();
        } else {
            C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new C2694b(this, str, aVar, (C2308e) null), 3, (Object) null);
        }
    }
}
