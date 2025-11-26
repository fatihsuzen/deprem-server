package N;

import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class l0 implements Parcelable.Creator {
    static void a(C0712f fVar, Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, fVar.f3072a);
        C0734c.j(parcel, 2, fVar.f3073b);
        C0734c.j(parcel, 3, fVar.f3074c);
        C0734c.p(parcel, 4, fVar.f3075d, false);
        C0734c.i(parcel, 5, fVar.f3076e, false);
        C0734c.r(parcel, 6, fVar.f3077f, i5, false);
        C0734c.e(parcel, 7, fVar.f3078g, false);
        C0734c.o(parcel, 8, fVar.f3079h, i5, false);
        C0734c.r(parcel, 10, fVar.f3080i, i5, false);
        C0734c.r(parcel, 11, fVar.f3081j, i5, false);
        C0734c.c(parcel, 12, fVar.f3082k);
        C0734c.j(parcel, 13, fVar.f3083l);
        C0734c.c(parcel, 14, fVar.f3084m);
        C0734c.p(parcel, 15, fVar.c(), false);
        C0734c.b(parcel, a5);
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r23) {
        /*
            r22 = this;
            r0 = r23
            int r1 = O.C0733b.w(r0)
            com.google.android.gms.common.api.Scope[] r2 = N.C0712f.f3070o
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            K.d[] r4 = N.C0712f.f3071p
            r5 = 0
            r6 = 0
            r13 = r2
            r14 = r3
            r16 = r4
            r17 = r16
            r11 = r5
            r12 = r11
            r15 = r12
            r21 = r15
            r8 = r6
            r9 = r8
            r10 = r9
            r18 = r10
            r19 = r18
            r20 = r19
        L_0x0025:
            int r2 = r0.dataPosition()
            if (r2 >= r1) goto L_0x0096
            int r2 = O.C0733b.p(r0)
            int r3 = O.C0733b.k(r2)
            switch(r3) {
                case 1: goto L_0x0091;
                case 2: goto L_0x008c;
                case 3: goto L_0x0087;
                case 4: goto L_0x0082;
                case 5: goto L_0x007d;
                case 6: goto L_0x0073;
                case 7: goto L_0x006e;
                case 8: goto L_0x0064;
                case 9: goto L_0x0036;
                case 10: goto L_0x0059;
                case 11: goto L_0x004e;
                case 12: goto L_0x0049;
                case 13: goto L_0x0044;
                case 14: goto L_0x003f;
                case 15: goto L_0x003a;
                default: goto L_0x0036;
            }
        L_0x0036:
            O.C0733b.v(r0, r2)
            goto L_0x0025
        L_0x003a:
            java.lang.String r21 = O.C0733b.f(r0, r2)
            goto L_0x0025
        L_0x003f:
            boolean r20 = O.C0733b.l(r0, r2)
            goto L_0x0025
        L_0x0044:
            int r19 = O.C0733b.r(r0, r2)
            goto L_0x0025
        L_0x0049:
            boolean r18 = O.C0733b.l(r0, r2)
            goto L_0x0025
        L_0x004e:
            android.os.Parcelable$Creator<K.d> r3 = K.C0657d.CREATOR
            java.lang.Object[] r2 = O.C0733b.h(r0, r2, r3)
            r17 = r2
            K.d[] r17 = (K.C0657d[]) r17
            goto L_0x0025
        L_0x0059:
            android.os.Parcelable$Creator<K.d> r3 = K.C0657d.CREATOR
            java.lang.Object[] r2 = O.C0733b.h(r0, r2, r3)
            r16 = r2
            K.d[] r16 = (K.C0657d[]) r16
            goto L_0x0025
        L_0x0064:
            android.os.Parcelable$Creator r3 = android.accounts.Account.CREATOR
            android.os.Parcelable r2 = O.C0733b.e(r0, r2, r3)
            r15 = r2
            android.accounts.Account r15 = (android.accounts.Account) r15
            goto L_0x0025
        L_0x006e:
            android.os.Bundle r14 = O.C0733b.a(r0, r2)
            goto L_0x0025
        L_0x0073:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r3 = com.google.android.gms.common.api.Scope.CREATOR
            java.lang.Object[] r2 = O.C0733b.h(r0, r2, r3)
            r13 = r2
            com.google.android.gms.common.api.Scope[] r13 = (com.google.android.gms.common.api.Scope[]) r13
            goto L_0x0025
        L_0x007d:
            android.os.IBinder r12 = O.C0733b.q(r0, r2)
            goto L_0x0025
        L_0x0082:
            java.lang.String r11 = O.C0733b.f(r0, r2)
            goto L_0x0025
        L_0x0087:
            int r10 = O.C0733b.r(r0, r2)
            goto L_0x0025
        L_0x008c:
            int r9 = O.C0733b.r(r0, r2)
            goto L_0x0025
        L_0x0091:
            int r8 = O.C0733b.r(r0, r2)
            goto L_0x0025
        L_0x0096:
            O.C0733b.j(r0, r1)
            N.f r7 = new N.f
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: N.l0.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new C0712f[i5];
    }
}
