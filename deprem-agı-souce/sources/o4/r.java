package o4;

import java.util.Locale;
import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import q4.e;
import q4.i;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f25618a;

    /* renamed from: b  reason: collision with root package name */
    public final a f25619b;

    /* renamed from: c  reason: collision with root package name */
    public final r4.a f25620c;

    /* renamed from: d  reason: collision with root package name */
    public final h f25621d;

    /* renamed from: e  reason: collision with root package name */
    public final i f25622e;

    public r(Locale locale, a aVar, r4.a aVar2, h hVar, e eVar) {
        t.e(locale, "appLocale");
        t.e(aVar, "networkUtil");
        t.e(aVar2, "sharedStorage");
        t.e(hVar, "requestApi");
        t.e(eVar, "resolver");
        this.f25618a = locale;
        this.f25619b = aVar;
        this.f25620c = aVar2;
        this.f25621d = hVar;
        this.f25622e = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof o4.q
            if (r0 == 0) goto L_0x0013
            r0 = r7
            o4.q r0 = (o4.q) r0
            int r1 = r0.f25617d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25617d = r1
            goto L_0x0018
        L_0x0013:
            o4.q r0 = new o4.q
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25615b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25617d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            o4.r r0 = r0.f25614a
            W2.u.b(r7)     // Catch:{ a -> 0x008a }
            goto L_0x006e
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0033:
            W2.u.b(r7)
            n4.a r7 = r6.f25619b     // Catch:{ a -> 0x0089 }
            boolean r7 = r7.a()     // Catch:{ a -> 0x0089 }
            if (r7 == 0) goto L_0x0071
            n4.h r7 = r6.f25621d     // Catch:{ a -> 0x0089 }
            java.lang.String r2 = V2.a.c()     // Catch:{ a -> 0x0089 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ a -> 0x0089 }
            java.lang.String r5 = "https://cmp.inmobi.com/google-basic-consent/v1/purposes-"
            r4.<init>(r5)     // Catch:{ a -> 0x0089 }
            java.util.Locale r5 = r6.f25618a     // Catch:{ a -> 0x0089 }
            java.lang.String r2 = r2.toLowerCase(r5)     // Catch:{ a -> 0x0089 }
            java.lang.String r5 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.t.d(r2, r5)     // Catch:{ a -> 0x0089 }
            r4.append(r2)     // Catch:{ a -> 0x0089 }
            java.lang.String r2 = ".json"
            r4.append(r2)     // Catch:{ a -> 0x0089 }
            java.lang.String r2 = r4.toString()     // Catch:{ a -> 0x0089 }
            r0.f25614a = r6     // Catch:{ a -> 0x0089 }
            r0.f25617d = r3     // Catch:{ a -> 0x0089 }
            java.lang.Object r7 = r7.a(r2, r0)     // Catch:{ a -> 0x0089 }
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r0 = r6
        L_0x006e:
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ a -> 0x008a }
            goto L_0x0092
        L_0x0071:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x0089 }
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()     // Catch:{ a -> 0x0089 }
            if (r7 != 0) goto L_0x007a
            goto L_0x007f
        L_0x007a:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0089 }
            r7.onCmpError(r0)     // Catch:{ a -> 0x0089 }
        L_0x007f:
            r4.a r7 = r6.f25620c     // Catch:{ a -> 0x0089 }
            r4.b r0 = r4.b.GOOGLE_BASIC_CONSENT     // Catch:{ a -> 0x0089 }
            java.lang.String r7 = r7.k(r0)     // Catch:{ a -> 0x0089 }
            r0 = r6
            goto L_0x0092
        L_0x0089:
            r0 = r6
        L_0x008a:
            r4.a r7 = r0.f25620c
            r4.b r1 = r4.b.GOOGLE_BASIC_CONSENT
            java.lang.String r7 = r7.k(r1)
        L_0x0092:
            r4.a r1 = r0.f25620c
            r4.b r2 = r4.b.GOOGLE_BASIC_CONSENT
            r1.i(r2, r7)
            q4.i r0 = r0.f25622e
            java.lang.Object r7 = r0.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.r.a(b3.e):java.lang.Object");
    }
}
