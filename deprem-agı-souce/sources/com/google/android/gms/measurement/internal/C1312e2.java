package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.P;
import com.google.android.gms.internal.measurement.S;
import f0.C1646a;
import f0.C1650e;
import f0.C1653h;
import f0.C1656k;
import f0.N;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.e2  reason: case insensitive filesystem */
public final class C1312e2 extends P implements C1650e {
    C1312e2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void F(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(25, j5);
    }

    public final void I(G g5, B6 b6) {
        Parcel j5 = j();
        S.c(j5, g5);
        S.c(j5, b6);
        k(1, j5);
    }

    public final void J(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(6, j5);
    }

    public final void K(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(26, j5);
    }

    public final void N(B6 b6, C1325g gVar) {
        Parcel j5 = j();
        S.c(j5, b6);
        S.c(j5, gVar);
        k(30, j5);
    }

    public final byte[] O(G g5, String str) {
        Parcel j5 = j();
        S.c(j5, g5);
        j5.writeString(str);
        Parcel i5 = i(9, j5);
        byte[] createByteArray = i5.createByteArray();
        i5.recycle();
        return createByteArray;
    }

    public final void S(v6 v6Var, B6 b6) {
        Parcel j5 = j();
        S.c(j5, v6Var);
        S.c(j5, b6);
        k(2, j5);
    }

    public final C1646a T(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        Parcel i5 = i(21, j5);
        C1646a aVar = (C1646a) S.b(i5, C1646a.CREATOR);
        i5.recycle();
        return aVar;
    }

    public final void U(Bundle bundle, B6 b6) {
        Parcel j5 = j();
        S.c(j5, bundle);
        S.c(j5, b6);
        k(19, j5);
    }

    public final void V(B6 b6, N n5, C1656k kVar) {
        Parcel j5 = j();
        S.c(j5, b6);
        S.c(j5, n5);
        S.d(j5, kVar);
        k(29, j5);
    }

    public final void X(B6 b6, Bundle bundle, C1653h hVar) {
        Parcel j5 = j();
        S.c(j5, b6);
        S.c(j5, bundle);
        S.d(j5, hVar);
        k(31, j5);
    }

    public final void a0(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(4, j5);
    }

    public final void e0(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(27, j5);
    }

    public final List h0(String str, String str2, boolean z4, B6 b6) {
        Parcel j5 = j();
        j5.writeString(str);
        j5.writeString(str2);
        int i5 = S.f5169b;
        j5.writeInt(z4 ? 1 : 0);
        S.c(j5, b6);
        Parcel i6 = i(14, j5);
        ArrayList<v6> createTypedArrayList = i6.createTypedArrayList(v6.CREATOR);
        i6.recycle();
        return createTypedArrayList;
    }

    public final String j0(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        Parcel i5 = i(11, j5);
        String readString = i5.readString();
        i5.recycle();
        return readString;
    }

    public final List k0(String str, String str2, B6 b6) {
        Parcel j5 = j();
        j5.writeString(str);
        j5.writeString(str2);
        S.c(j5, b6);
        Parcel i5 = i(16, j5);
        ArrayList<C1341i> createTypedArrayList = i5.createTypedArrayList(C1341i.CREATOR);
        i5.recycle();
        return createTypedArrayList;
    }

    public final void l0(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(20, j5);
    }

    public final List m(String str, String str2, String str3, boolean z4) {
        Parcel j5 = j();
        j5.writeString((String) null);
        j5.writeString(str2);
        j5.writeString(str3);
        int i5 = S.f5169b;
        j5.writeInt(z4 ? 1 : 0);
        Parcel i6 = i(15, j5);
        ArrayList<v6> createTypedArrayList = i6.createTypedArrayList(v6.CREATOR);
        i6.recycle();
        return createTypedArrayList;
    }

    public final void p(C1341i iVar, B6 b6) {
        Parcel j5 = j();
        S.c(j5, iVar);
        S.c(j5, b6);
        k(12, j5);
    }

    public final void t(long j5, String str, String str2, String str3) {
        Parcel j6 = j();
        j6.writeLong(j5);
        j6.writeString(str);
        j6.writeString(str2);
        j6.writeString(str3);
        k(10, j6);
    }

    public final void v(B6 b6) {
        Parcel j5 = j();
        S.c(j5, b6);
        k(18, j5);
    }

    public final List y(String str, String str2, String str3) {
        Parcel j5 = j();
        j5.writeString((String) null);
        j5.writeString(str2);
        j5.writeString(str3);
        Parcel i5 = i(17, j5);
        ArrayList<C1341i> createTypedArrayList = i5.createTypedArrayList(C1341i.CREATOR);
        i5.recycle();
        return createTypedArrayList;
    }
}
