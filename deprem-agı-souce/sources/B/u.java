package b;

import R3.h;
import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class u extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public h f834a;

    /* renamed from: b  reason: collision with root package name */
    public int f835b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f836c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(x xVar, C2308e eVar) {
        super(2, eVar);
        this.f836c = xVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new u(this.f836c, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new u(this.f836c, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015b, code lost:
        if (r12.length() > 0) goto L_0x015d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f835b
            java.lang.String r3 = "STATE_AND_NATIONAL"
            java.lang.String r4 = "state"
            r5 = 1
            if (r2 == 0) goto L_0x0021
            if (r2 != r5) goto L_0x0019
            R3.h r1 = r0.f834a
            W2.u.b(r18)
            r2 = r18
            goto L_0x007d
        L_0x0019:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0021:
            W2.u.b(r18)
            R3.h r13 = R3.e.b()
            android.app.Application r2 = s4.c.f25853a
            b.x r2 = r0.f836c
            T3.i r2 = r2.f841c
            T3.c r2 = r2.f19281b
            java.lang.String r2 = r2.f19219J
            boolean r2 = kotlin.jvm.internal.t.a(r2, r3)
            if (r2 == 0) goto L_0x003c
            J2.i r2 = J2.i.STATE_AND_NATIONAL
        L_0x003a:
            r12 = r2
            goto L_0x003f
        L_0x003c:
            J2.i r2 = J2.i.NATIONAL
            goto L_0x003a
        L_0x003f:
            java.lang.String r2 = "jurisdiction"
            kotlin.jvm.internal.t.e(r12, r2)
            kotlin.jvm.internal.t.e(r13, r4)
            o4.D r2 = s4.c.f25852B
            if (r2 != 0) goto L_0x0067
            o4.D r7 = new o4.D
            java.util.Locale r8 = s4.c.a()
            n4.a r9 = s4.c.i()
            n4.h r10 = s4.c.k()
            r4.a r11 = s4.c.l()
            q4.j r14 = new q4.j
            r14.<init>()
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            s4.c.f25852B = r7
        L_0x0067:
            o4.D r2 = s4.c.f25852B
            if (r2 != 0) goto L_0x0071
            java.lang.String r2 = "mspaPrivacyRepository"
            kotlin.jvm.internal.t.w(r2)
            r2 = 0
        L_0x0071:
            r0.f834a = r13
            r0.f835b = r5
            java.lang.Object r2 = r2.a(r0)
            if (r2 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r1 = r13
        L_0x007d:
            R3.a r2 = (R3.a) r2
            b.x r5 = r0.f836c
            r5.getClass()
            java.util.List r7 = r2.f18958c
            if (r7 != 0) goto L_0x0089
            goto L_0x009e
        L_0x0089:
            java.util.Iterator r7 = r7.iterator()
        L_0x008d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x009e
            java.lang.Object r8 = r7.next()
            R3.f r8 = (R3.f) r8
            java.lang.Boolean r9 = r8.f18986b
            r8.f18987c = r9
            goto L_0x008d
        L_0x009e:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r8 = r2.f18958c
            if (r8 != 0) goto L_0x00a9
            r9 = 0
            goto L_0x00dc
        L_0x00a9:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x00b2:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x00dc
            java.lang.Object r10 = r8.next()
            r11 = r10
            R3.f r11 = (R3.f) r11
            java.lang.Integer r11 = r11.f18985a
            if (r11 != 0) goto L_0x00c4
            goto L_0x00b2
        L_0x00c4:
            int r11 = r11.intValue()
            T3.i r12 = r5.f841c
            T3.c r12 = r12.f19281b
            java.util.List r12 = r12.f19223N
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            boolean r11 = r12.contains(r11)
            if (r11 == 0) goto L_0x00b2
            r9.add(r10)
            goto L_0x00b2
        L_0x00dc:
            if (r9 != 0) goto L_0x00e0
            goto L_0x0214
        L_0x00e0:
            int r8 = r9.size()
            r10 = 0
        L_0x00e5:
            if (r10 >= r8) goto L_0x0214
            java.lang.Object r11 = r9.get(r10)
            int r10 = r10 + 1
            R3.f r11 = (R3.f) r11
            java.lang.Integer r12 = r11.f18985a
            int[] r13 = R3.j.f19017b
            int r13 = X2.C2242i.Q(r13)
            if (r12 != 0) goto L_0x00fb
            goto L_0x0210
        L_0x00fb:
            int r12 = r12.intValue()
            if (r12 != r13) goto L_0x0210
            T3.i r12 = r5.f841c
            T3.c r12 = r12.f19281b
            java.lang.String r12 = r12.f19219J
            java.lang.String r13 = "NATIONAL"
            boolean r12 = kotlin.jvm.internal.t.a(r12, r13)
            if (r12 != 0) goto L_0x01b5
            T3.i r12 = r5.f841c
            T3.c r12 = r12.f19281b
            java.lang.String r12 = r12.f19219J
            boolean r12 = kotlin.jvm.internal.t.a(r12, r3)
            if (r12 == 0) goto L_0x015d
            kotlin.jvm.internal.t.e(r1, r4)
            kotlin.jvm.internal.t.e(r1, r4)
            int r12 = r1.ordinal()
            switch(r12) {
                case 0: goto L_0x0155;
                case 1: goto L_0x0152;
                case 2: goto L_0x014f;
                case 3: goto L_0x014c;
                case 4: goto L_0x0149;
                case 5: goto L_0x0146;
                case 6: goto L_0x0143;
                case 7: goto L_0x0140;
                case 8: goto L_0x013d;
                case 9: goto L_0x013a;
                case 10: goto L_0x0137;
                case 11: goto L_0x0134;
                case 12: goto L_0x0131;
                case 13: goto L_0x012e;
                case 14: goto L_0x012b;
                default: goto L_0x0128;
            }
        L_0x0128:
            java.lang.String r12 = ""
            goto L_0x0157
        L_0x012b:
            java.lang.String r12 = "tn"
            goto L_0x0157
        L_0x012e:
            java.lang.String r12 = "nj"
            goto L_0x0157
        L_0x0131:
            java.lang.String r12 = "nh"
            goto L_0x0157
        L_0x0134:
            java.lang.String r12 = "ne"
            goto L_0x0157
        L_0x0137:
            java.lang.String r12 = "ia"
            goto L_0x0157
        L_0x013a:
            java.lang.String r12 = "de"
            goto L_0x0157
        L_0x013d:
            java.lang.String r12 = "tx"
            goto L_0x0157
        L_0x0140:
            java.lang.String r12 = "or"
            goto L_0x0157
        L_0x0143:
            java.lang.String r12 = "mt"
            goto L_0x0157
        L_0x0146:
            java.lang.String r12 = "fl"
            goto L_0x0157
        L_0x0149:
            java.lang.String r12 = "va"
            goto L_0x0157
        L_0x014c:
            java.lang.String r12 = "ut"
            goto L_0x0157
        L_0x014f:
            java.lang.String r12 = "ct"
            goto L_0x0157
        L_0x0152:
            java.lang.String r12 = "co"
            goto L_0x0157
        L_0x0155:
            java.lang.String r12 = "ca"
        L_0x0157:
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x01b5
        L_0x015d:
            java.util.List r12 = r11.f18989e
            if (r12 != 0) goto L_0x0163
            r13 = 0
            goto L_0x01b2
        L_0x0163:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r12 = r12.iterator()
        L_0x016c:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x01b2
            java.lang.Object r14 = r12.next()
            r15 = r14
            R3.g r15 = (R3.g) r15
            java.util.List r15 = r15.f18997f
            if (r15 != 0) goto L_0x017e
            goto L_0x016c
        L_0x017e:
            boolean r16 = r15.isEmpty()
            if (r16 == 0) goto L_0x0185
            goto L_0x016c
        L_0x0185:
            java.util.Iterator r15 = r15.iterator()
        L_0x0189:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x01ac
            java.lang.Object r16 = r15.next()
            java.lang.Number r16 = (java.lang.Number) r16
            int r16 = r16.intValue()
            T3.i r6 = r5.f841c
            T3.c r6 = r6.f19281b
            java.util.List r6 = r6.f19224O
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L_0x01af
            r13.add(r14)
        L_0x01ac:
            r0 = r17
            goto L_0x016c
        L_0x01af:
            r0 = r17
            goto L_0x0189
        L_0x01b2:
            r11.f18990f = r13
            goto L_0x01e5
        L_0x01b5:
            java.util.List r0 = r11.f18989e
            if (r0 != 0) goto L_0x01bb
            r6 = 0
            goto L_0x01e3
        L_0x01bb:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x01c4:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x01e3
            java.lang.Object r12 = r0.next()
            r13 = r12
            R3.g r13 = (R3.g) r13
            T3.i r14 = r5.f841c
            T3.c r14 = r14.f19281b
            java.util.List r14 = r14.f19224O
            java.lang.Integer r13 = r13.f18992a
            boolean r13 = X2.C2250q.E(r14, r13)
            if (r13 == 0) goto L_0x01c4
            r6.add(r12)
            goto L_0x01c4
        L_0x01e3:
            r11.f18990f = r6
        L_0x01e5:
            java.util.List r0 = r11.f18990f
            if (r0 != 0) goto L_0x01ea
            goto L_0x0209
        L_0x01ea:
            java.util.Iterator r0 = r0.iterator()
        L_0x01ee:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0209
            java.lang.Object r6 = r0.next()
            R3.g r6 = (R3.g) r6
            java.lang.Boolean r12 = r11.f18987c
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            boolean r12 = kotlin.jvm.internal.t.a(r12, r13)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r6.f18995d = r12
            goto L_0x01ee
        L_0x0209:
            r7.add(r11)
        L_0x020c:
            r0 = r17
            goto L_0x00e5
        L_0x0210:
            r7.add(r11)
            goto L_0x020c
        L_0x0214:
            r2.f18959d = r7
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
