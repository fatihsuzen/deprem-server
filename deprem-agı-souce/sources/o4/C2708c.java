package o4;

import java.util.Arrays;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import q4.i;
import q4.k;

/* renamed from: o4.c  reason: case insensitive filesystem */
public final class C2708c implements E {

    /* renamed from: a  reason: collision with root package name */
    public final a f25568a;

    /* renamed from: b  reason: collision with root package name */
    public final r4.a f25569b;

    /* renamed from: c  reason: collision with root package name */
    public final h f25570c;

    /* renamed from: d  reason: collision with root package name */
    public final i f25571d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25572e;

    public C2708c(a aVar, r4.a aVar2, h hVar, k kVar, String str, String str2) {
        t.e(aVar, "networkUtil");
        t.e(aVar2, "sharedStorage");
        t.e(hVar, "requestApi");
        t.e(kVar, "resolver");
        t.e(str, "packageName");
        t.e(str2, "pCode");
        this.f25568a = aVar;
        this.f25569b = aVar2;
        this.f25570c = hVar;
        this.f25571d = kVar;
        Q q5 = Q.f24695a;
        String format = String.format(t.n("https://choice.inmobi.com/", "configs/users/%s/%s/config?sdkVersion=%s"), Arrays.copyOf(new Object[]{str2, str, "p-a-2.3.3"}, 3));
        t.d(format, "format(format, *args)");
        this.f25572e = format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof o4.F
            if (r0 == 0) goto L_0x0013
            r0 = r5
            o4.F r0 = (o4.F) r0
            int r1 = r0.f25561d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25561d = r1
            goto L_0x0018
        L_0x0013:
            o4.F r0 = new o4.F
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f25559b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25561d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            o4.c r0 = r0.f25558a
            W2.u.b(r5)     // Catch:{ a -> 0x006a }
            goto L_0x004e
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0033:
            W2.u.b(r5)
            n4.a r5 = r4.f25568a     // Catch:{ a -> 0x0069 }
            boolean r5 = r5.a()     // Catch:{ a -> 0x0069 }
            if (r5 == 0) goto L_0x0051
            n4.h r5 = r4.f25570c     // Catch:{ a -> 0x0069 }
            java.lang.String r2 = r4.f25572e     // Catch:{ a -> 0x0069 }
            r0.f25558a = r4     // Catch:{ a -> 0x0069 }
            r0.f25561d = r3     // Catch:{ a -> 0x0069 }
            java.lang.Object r5 = r5.a(r2, r0)     // Catch:{ a -> 0x0069 }
            if (r5 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r4
        L_0x004e:
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ a -> 0x006a }
            goto L_0x0072
        L_0x0051:
            com.inmobi.cmp.ChoiceCmp r5 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x0069 }
            com.inmobi.cmp.ChoiceCmpCallback r5 = r5.getCallback()     // Catch:{ a -> 0x0069 }
            if (r5 != 0) goto L_0x005a
            goto L_0x005f
        L_0x005a:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x0069 }
            r5.onCmpError(r0)     // Catch:{ a -> 0x0069 }
        L_0x005f:
            r4.a r5 = r4.f25569b     // Catch:{ a -> 0x0069 }
            r4.b r0 = r4.b.PORTAL_CONFIG     // Catch:{ a -> 0x0069 }
            java.lang.String r5 = r5.k(r0)     // Catch:{ a -> 0x0069 }
            r0 = r4
            goto L_0x0072
        L_0x0069:
            r0 = r4
        L_0x006a:
            r4.a r5 = r0.f25569b
            r4.b r1 = r4.b.PORTAL_CONFIG
            java.lang.String r5 = r5.k(r1)
        L_0x0072:
            r4.a r1 = r0.f25569b
            r4.b r2 = r4.b.PORTAL_CONFIG
            r1.i(r2, r5)
            q4.i r0 = r0.f25571d
            java.lang.Object r5 = r0.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.C2708c.a(b3.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(b3.C2308e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof o4.C2706a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            o4.a r0 = (o4.C2706a) r0
            int r1 = r0.f25564c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25564c = r1
            goto L_0x0018
        L_0x0013:
            o4.a r0 = new o4.a
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f25562a
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25564c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            W2.u.b(r6)     // Catch:{ a -> 0x006c }
            goto L_0x005b
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0031:
            W2.u.b(r6)
            n4.a r6 = r5.f25568a     // Catch:{ a -> 0x006c }
            boolean r6 = r6.a()     // Catch:{ a -> 0x006c }
            if (r6 == 0) goto L_0x005e
            q4.i r6 = r5.f25571d     // Catch:{ a -> 0x006c }
            r4.a r2 = r5.f25569b     // Catch:{ a -> 0x006c }
            r4.b r4 = r4.b.PORTAL_CONFIG     // Catch:{ a -> 0x006c }
            java.lang.String r2 = r2.k(r4)     // Catch:{ a -> 0x006c }
            java.lang.Object r6 = r6.a(r2)     // Catch:{ a -> 0x006c }
            T3.i r6 = (T3.i) r6     // Catch:{ a -> 0x006c }
            n4.h r2 = r5.f25570c     // Catch:{ a -> 0x006c }
            T3.c r6 = r6.f19281b     // Catch:{ a -> 0x006c }
            java.lang.String r6 = r6.f19253r     // Catch:{ a -> 0x006c }
            r0.f25564c = r3     // Catch:{ a -> 0x006c }
            java.lang.Object r6 = r2.c(r6, r0)     // Catch:{ a -> 0x006c }
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6     // Catch:{ a -> 0x006c }
            return r6
        L_0x005e:
            com.inmobi.cmp.ChoiceCmp r6 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x006c }
            com.inmobi.cmp.ChoiceCmpCallback r6 = r6.getCallback()     // Catch:{ a -> 0x006c }
            if (r6 != 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x006c }
            r6.onCmpError(r0)     // Catch:{ a -> 0x006c }
        L_0x006c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.C2708c.b(b3.e):java.lang.Object");
    }
}
