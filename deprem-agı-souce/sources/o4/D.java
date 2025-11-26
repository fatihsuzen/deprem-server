package o4;

import J2.i;
import R3.e;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import q4.j;

public final class D {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f25551a;

    /* renamed from: b  reason: collision with root package name */
    public final a f25552b;

    /* renamed from: c  reason: collision with root package name */
    public final h f25553c;

    /* renamed from: d  reason: collision with root package name */
    public final r4.a f25554d;

    /* renamed from: e  reason: collision with root package name */
    public final i f25555e;

    /* renamed from: f  reason: collision with root package name */
    public final R3.h f25556f;

    /* renamed from: g  reason: collision with root package name */
    public final q4.i f25557g;

    public D(Locale locale, a aVar, h hVar, r4.a aVar2, i iVar, R3.h hVar2, j jVar) {
        t.e(locale, "appLocale");
        t.e(aVar, "networkUtil");
        t.e(hVar, "requestApi");
        t.e(aVar2, "sharedStorage");
        t.e(iVar, "jurisdiction");
        t.e(hVar2, MRAIDCommunicatorUtil.KEY_STATE);
        t.e(jVar, "resolver");
        this.f25551a = locale;
        this.f25552b = aVar;
        this.f25553c = hVar;
        this.f25554d = aVar2;
        this.f25555e = iVar;
        this.f25556f = hVar2;
        this.f25557g = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof o4.C
            if (r0 == 0) goto L_0x0013
            r0 = r5
            o4.C r0 = (o4.C) r0
            int r1 = r0.f25550d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25550d = r1
            goto L_0x0018
        L_0x0013:
            o4.C r0 = new o4.C
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f25548b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25550d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            o4.D r0 = r0.f25547a
            W2.u.b(r5)     // Catch:{ a -> 0x006c }
            goto L_0x0050
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0033:
            W2.u.b(r5)
            n4.a r5 = r4.f25552b     // Catch:{ a -> 0x006b }
            boolean r5 = r5.a()     // Catch:{ a -> 0x006b }
            if (r5 == 0) goto L_0x0053
            n4.h r5 = r4.f25553c     // Catch:{ a -> 0x006b }
            java.lang.String r2 = r4.b()     // Catch:{ a -> 0x006b }
            r0.f25547a = r4     // Catch:{ a -> 0x006b }
            r0.f25550d = r3     // Catch:{ a -> 0x006b }
            java.lang.Object r5 = r5.a(r2, r0)     // Catch:{ a -> 0x006b }
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r4
        L_0x0050:
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ a -> 0x006c }
            goto L_0x0074
        L_0x0053:
            com.inmobi.cmp.ChoiceCmp r5 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x006b }
            com.inmobi.cmp.ChoiceCmpCallback r5 = r5.getCallback()     // Catch:{ a -> 0x006b }
            if (r5 != 0) goto L_0x005c
            goto L_0x0061
        L_0x005c:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x006b }
            r5.onCmpError(r0)     // Catch:{ a -> 0x006b }
        L_0x0061:
            r4.a r5 = r4.f25554d     // Catch:{ a -> 0x006b }
            r4.b r0 = r4.b.MSPA_PURPOSES     // Catch:{ a -> 0x006b }
            java.lang.String r5 = r5.k(r0)     // Catch:{ a -> 0x006b }
            r0 = r4
            goto L_0x0074
        L_0x006b:
            r0 = r4
        L_0x006c:
            r4.a r5 = r0.f25554d
            r4.b r1 = r4.b.MSPA_PURPOSES
            java.lang.String r5 = r5.k(r1)
        L_0x0074:
            r4.a r1 = r0.f25554d
            r4.b r2 = r4.b.MSPA_PURPOSES
            r1.i(r2, r5)
            q4.i r0 = r0.f25557g
            java.lang.Object r5 = r0.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.D.a(b3.e):java.lang.Object");
    }

    public final String b() {
        String str;
        i iVar = this.f25555e;
        i iVar2 = i.STATE_AND_NATIONAL;
        if (iVar == iVar2) {
            R3.h hVar = this.f25556f;
            t.e(hVar, MRAIDCommunicatorUtil.KEY_STATE);
            if (R3.j.b(hVar).length() > 0) {
                t.e(iVar2, "value");
                e.f18984f = iVar2;
                Q q5 = Q.f24695a;
                str = String.format("us-mspa/v1/purposes-state-%s-", Arrays.copyOf(new Object[]{R3.j.b(this.f25556f)}, 1));
                t.d(str, "format(format, *args)");
                StringBuilder sb = new StringBuilder("https://cmp.inmobi.com/");
                sb.append(str);
                String lowerCase = "en".toLowerCase(this.f25551a);
                t.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                sb.append(lowerCase);
                sb.append(".json");
                return sb.toString();
            }
        }
        i iVar3 = i.NATIONAL;
        t.e(iVar3, "value");
        e.f18984f = iVar3;
        str = "us-mspa/v1/purposes-national-";
        StringBuilder sb2 = new StringBuilder("https://cmp.inmobi.com/");
        sb2.append(str);
        String lowerCase2 = "en".toLowerCase(this.f25551a);
        t.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        sb2.append(lowerCase2);
        sb2.append(".json");
        return sb2.toString();
    }
}
