package o4;

import kotlin.jvm.internal.t;
import n4.a;
import n4.h;
import q4.g;
import q4.i;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final a f25634a;

    /* renamed from: b  reason: collision with root package name */
    public final r4.a f25635b;

    /* renamed from: c  reason: collision with root package name */
    public final h f25636c;

    /* renamed from: d  reason: collision with root package name */
    public final i f25637d;

    public v(a aVar, r4.a aVar2, h hVar, g gVar) {
        t.e(aVar, "networkUtil");
        t.e(aVar2, "sharedStorage");
        t.e(hVar, "requestApi");
        t.e(gVar, "resolver");
        this.f25634a = aVar;
        this.f25635b = aVar2;
        this.f25636c = hVar;
        this.f25637d = gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(b3.C2308e r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof o4.u
            if (r0 == 0) goto L_0x0013
            r0 = r14
            o4.u r0 = (o4.u) r0
            int r1 = r0.f25633d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25633d = r1
            goto L_0x0018
        L_0x0013:
            o4.u r0 = new o4.u
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f25631b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f25633d
            r3 = 0
            r4 = 0
            java.lang.String r6 = "googleVendorLastUpdate"
            java.lang.String r7 = "preferenceKey"
            r8 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r8) goto L_0x0032
            o4.v r0 = r0.f25630a
            W2.u.b(r14)     // Catch:{ a -> 0x009d }
            goto L_0x0081
        L_0x0032:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x003a:
            W2.u.b(r14)
            n4.a r14 = r13.f25634a     // Catch:{ a -> 0x009c }
            boolean r14 = r14.a()     // Catch:{ a -> 0x009c }
            if (r14 == 0) goto L_0x0084
            r4.a r14 = r13.f25635b     // Catch:{ a -> 0x009c }
            r4.b r2 = r4.b.GOOGLE_VENDOR_LAST_UPDATE     // Catch:{ a -> 0x009c }
            r14.getClass()     // Catch:{ a -> 0x009c }
            kotlin.jvm.internal.t.e(r2, r7)     // Catch:{ a -> 0x009c }
            android.content.SharedPreferences r14 = r14.f25721a     // Catch:{ a -> 0x009c }
            long r9 = r14.getLong(r6, r4)     // Catch:{ a -> 0x009c }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ a -> 0x009c }
            long r9 = l4.a.a(r9, r11)     // Catch:{ a -> 0x009c }
            long r11 = (long) r3     // Catch:{ a -> 0x009c }
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 < 0) goto L_0x0084
            r4.a r14 = r13.f25635b     // Catch:{ a -> 0x009c }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ a -> 0x009c }
            r14.g(r2, r9)     // Catch:{ a -> 0x009c }
            n4.h r14 = r13.f25636c     // Catch:{ a -> 0x009c }
            java.lang.String r2 = "https://cmp.inmobi.com/"
            java.lang.String r9 = "tcfv2/google-atp-list.json"
            java.lang.String r2 = kotlin.jvm.internal.t.n(r2, r9)     // Catch:{ a -> 0x009c }
            r0.f25630a = r13     // Catch:{ a -> 0x009c }
            r0.f25633d = r8     // Catch:{ a -> 0x009c }
            java.lang.Object r14 = r14.a(r2, r0)     // Catch:{ a -> 0x009c }
            if (r14 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r0 = r13
        L_0x0081:
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ a -> 0x009d }
            goto L_0x00c5
        L_0x0084:
            com.inmobi.cmp.ChoiceCmp r14 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch:{ a -> 0x009c }
            com.inmobi.cmp.ChoiceCmpCallback r14 = r14.getCallback()     // Catch:{ a -> 0x009c }
            if (r14 != 0) goto L_0x008d
            goto L_0x0092
        L_0x008d:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x009c }
            r14.onCmpError(r0)     // Catch:{ a -> 0x009c }
        L_0x0092:
            r4.a r14 = r13.f25635b     // Catch:{ a -> 0x009c }
            r4.b r0 = r4.b.GOOGLE_VENDOR_LIST     // Catch:{ a -> 0x009c }
            java.lang.String r14 = r14.k(r0)     // Catch:{ a -> 0x009c }
            r0 = r13
            goto L_0x00c5
        L_0x009c:
            r0 = r13
        L_0x009d:
            r4.a r14 = r0.f25635b
            r4.b r1 = r4.b.GOOGLE_VENDOR_LAST_UPDATE
            r14.getClass()
            kotlin.jvm.internal.t.e(r1, r7)
            android.content.SharedPreferences r14 = r14.f25721a
            long r1 = r14.getLong(r6, r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r1 = l4.a.a(r1, r4)
            long r3 = (long) r3
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 < 0) goto L_0x00bd
            java.lang.String r14 = ""
            goto L_0x00c5
        L_0x00bd:
            r4.a r14 = r0.f25635b
            r4.b r1 = r4.b.GOOGLE_VENDOR_LIST
            java.lang.String r14 = r14.k(r1)
        L_0x00c5:
            r4.a r1 = r0.f25635b
            r4.b r2 = r4.b.GOOGLE_VENDOR_LIST
            r1.i(r2, r14)
            q4.i r0 = r0.f25637d
            java.lang.Object r14 = r0.a(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: o4.v.a(b3.e):java.lang.Object");
    }
}
