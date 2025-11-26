package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;

public final class e implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r15) {
        /*
            r14 = this;
            int r0 = O.C0733b.w(r15)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r10 = r6
            r11 = r10
            r12 = r11
            r13 = r12
            r4 = r2
            r7 = r4
            r8 = r7
            r9 = r8
        L_0x0010:
            int r1 = r15.dataPosition()
            if (r1 >= r0) goto L_0x0060
            int r1 = O.C0733b.p(r15)
            int r2 = O.C0733b.k(r1)
            switch(r2) {
                case 1: goto L_0x005b;
                case 2: goto L_0x0054;
                case 3: goto L_0x004a;
                case 4: goto L_0x0045;
                case 5: goto L_0x0040;
                case 6: goto L_0x003b;
                case 7: goto L_0x0036;
                case 8: goto L_0x0031;
                case 9: goto L_0x002a;
                case 10: goto L_0x0025;
                default: goto L_0x0021;
            }
        L_0x0021:
            O.C0733b.v(r15, r1)
            goto L_0x0010
        L_0x0025:
            java.lang.String r13 = O.C0733b.f(r15, r1)
            goto L_0x0010
        L_0x002a:
            android.os.Parcelable$Creator<H.a> r2 = H.C0641a.CREATOR
            java.util.ArrayList r12 = O.C0733b.i(r15, r1, r2)
            goto L_0x0010
        L_0x0031:
            java.lang.String r11 = O.C0733b.f(r15, r1)
            goto L_0x0010
        L_0x0036:
            java.lang.String r10 = O.C0733b.f(r15, r1)
            goto L_0x0010
        L_0x003b:
            boolean r9 = O.C0733b.l(r15, r1)
            goto L_0x0010
        L_0x0040:
            boolean r8 = O.C0733b.l(r15, r1)
            goto L_0x0010
        L_0x0045:
            boolean r7 = O.C0733b.l(r15, r1)
            goto L_0x0010
        L_0x004a:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = O.C0733b.e(r15, r1, r2)
            r6 = r1
            android.accounts.Account r6 = (android.accounts.Account) r6
            goto L_0x0010
        L_0x0054:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r2 = com.google.android.gms.common.api.Scope.CREATOR
            java.util.ArrayList r5 = O.C0733b.i(r15, r1, r2)
            goto L_0x0010
        L_0x005b:
            int r4 = O.C0733b.r(r15, r1)
            goto L_0x0010
        L_0x0060:
            O.C0733b.j(r15, r0)
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r3 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions
            r3.<init>((int) r4, (java.util.ArrayList) r5, (android.accounts.Account) r6, (boolean) r7, (boolean) r8, (boolean) r9, (java.lang.String) r10, (java.lang.String) r11, (java.util.ArrayList) r12, (java.lang.String) r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.e.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i5) {
        return new GoogleSignInOptions[i5];
    }
}
