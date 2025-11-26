package f0;

import com.google.android.gms.internal.measurement.Q;

/* renamed from: f0.d  reason: case insensitive filesystem */
public abstract class C1649d extends Q implements C1650e {
    public C1649d() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r12v24, types: [f0.k] */
    /* JADX WARNING: type inference failed for: r12v32, types: [f0.h] */
    /* JADX WARNING: type inference failed for: r12v37 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r12v39 */
    /* JADX WARNING: type inference failed for: r12v40 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
            r8 = this;
            r12 = 0
            r0 = 0
            r1 = 1
            switch(r9) {
                case 1: goto L_0x02b2;
                case 2: goto L_0x0297;
                case 3: goto L_0x0006;
                case 4: goto L_0x0284;
                case 5: goto L_0x0269;
                case 6: goto L_0x0256;
                case 7: goto L_0x023a;
                case 8: goto L_0x0006;
                case 9: goto L_0x021e;
                case 10: goto L_0x0202;
                case 11: goto L_0x01eb;
                case 12: goto L_0x01d0;
                case 13: goto L_0x01bd;
                case 14: goto L_0x019a;
                case 15: goto L_0x017b;
                case 16: goto L_0x015c;
                case 17: goto L_0x0141;
                case 18: goto L_0x012e;
                case 19: goto L_0x0113;
                case 20: goto L_0x0100;
                case 21: goto L_0x00df;
                case 22: goto L_0x0006;
                case 23: goto L_0x0006;
                case 24: goto L_0x00c0;
                case 25: goto L_0x00ad;
                case 26: goto L_0x009b;
                case 27: goto L_0x0089;
                case 28: goto L_0x0006;
                case 29: goto L_0x0056;
                case 30: goto L_0x003c;
                case 31: goto L_0x0007;
                default: goto L_0x0006;
            }
        L_0x0006:
            return r0
        L_0x0007:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.S.b(r10, r0)
            android.os.Bundle r0 = (android.os.Bundle) r0
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x001e
            goto L_0x0030
        L_0x001e:
            java.lang.String r12 = "com.google.android.gms.measurement.internal.ITriggerUrisCallback"
            android.os.IInterface r12 = r2.queryLocalInterface(r12)
            boolean r3 = r12 instanceof f0.C1653h
            if (r3 == 0) goto L_0x002b
            f0.h r12 = (f0.C1653h) r12
            goto L_0x0030
        L_0x002b:
            f0.f r12 = new f0.f
            r12.<init>(r2)
        L_0x0030:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.X(r9, r0, r12)
            r11.writeNoException()
        L_0x0039:
            r2 = r8
            goto L_0x02cc
        L_0x003c:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.g> r12 = com.google.android.gms.measurement.internal.C1325g.CREATOR
            android.os.Parcelable r12 = com.google.android.gms.internal.measurement.S.b(r10, r12)
            com.google.android.gms.measurement.internal.g r12 = (com.google.android.gms.measurement.internal.C1325g) r12
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.N(r9, r12)
            r11.writeNoException()
            goto L_0x0039
        L_0x0056:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            android.os.Parcelable$Creator<f0.N> r0 = f0.N.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.S.b(r10, r0)
            f0.N r0 = (f0.N) r0
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x006d
            goto L_0x007f
        L_0x006d:
            java.lang.String r12 = "com.google.android.gms.measurement.internal.IUploadBatchesCallback"
            android.os.IInterface r12 = r2.queryLocalInterface(r12)
            boolean r3 = r12 instanceof f0.C1656k
            if (r3 == 0) goto L_0x007a
            f0.k r12 = (f0.C1656k) r12
            goto L_0x007f
        L_0x007a:
            f0.i r12 = new f0.i
            r12.<init>(r2)
        L_0x007f:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.V(r9, r0, r12)
            r11.writeNoException()
            goto L_0x0039
        L_0x0089:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.e0(r9)
            r11.writeNoException()
            goto L_0x0039
        L_0x009b:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.K(r9)
            r11.writeNoException()
            goto L_0x0039
        L_0x00ad:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.F(r9)
            r11.writeNoException()
            goto L_0x0039
        L_0x00c0:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            android.os.Parcelable$Creator r12 = android.os.Bundle.CREATOR
            android.os.Parcelable r12 = com.google.android.gms.internal.measurement.S.b(r10, r12)
            android.os.Bundle r12 = (android.os.Bundle) r12
            com.google.android.gms.internal.measurement.S.f(r10)
            java.util.List r9 = r8.H(r9, r12)
            r11.writeNoException()
            r11.writeTypedList(r9)
            goto L_0x0039
        L_0x00df:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            f0.a r9 = r8.T(r9)
            r11.writeNoException()
            if (r9 != 0) goto L_0x00f8
            r11.writeInt(r0)
            goto L_0x0039
        L_0x00f8:
            r11.writeInt(r1)
            r9.writeToParcel(r11, r1)
            goto L_0x0039
        L_0x0100:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.l0(r9)
            r11.writeNoException()
            goto L_0x0039
        L_0x0113:
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            android.os.Bundle r9 = (android.os.Bundle) r9
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r12 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r12 = com.google.android.gms.internal.measurement.S.b(r10, r12)
            com.google.android.gms.measurement.internal.B6 r12 = (com.google.android.gms.measurement.internal.B6) r12
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.U(r9, r12)
            r11.writeNoException()
            goto L_0x0039
        L_0x012e:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.v(r9)
            r11.writeNoException()
            goto L_0x0039
        L_0x0141:
            java.lang.String r9 = r10.readString()
            java.lang.String r12 = r10.readString()
            java.lang.String r0 = r10.readString()
            com.google.android.gms.internal.measurement.S.f(r10)
            java.util.List r9 = r8.y(r9, r12, r0)
            r11.writeNoException()
            r11.writeTypedList(r9)
            goto L_0x0039
        L_0x015c:
            java.lang.String r9 = r10.readString()
            java.lang.String r12 = r10.readString()
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r0 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.S.b(r10, r0)
            com.google.android.gms.measurement.internal.B6 r0 = (com.google.android.gms.measurement.internal.B6) r0
            com.google.android.gms.internal.measurement.S.f(r10)
            java.util.List r9 = r8.k0(r9, r12, r0)
            r11.writeNoException()
            r11.writeTypedList(r9)
            goto L_0x0039
        L_0x017b:
            java.lang.String r9 = r10.readString()
            java.lang.String r12 = r10.readString()
            java.lang.String r0 = r10.readString()
            boolean r2 = com.google.android.gms.internal.measurement.S.a(r10)
            com.google.android.gms.internal.measurement.S.f(r10)
            java.util.List r9 = r8.m(r9, r12, r0, r2)
            r11.writeNoException()
            r11.writeTypedList(r9)
            goto L_0x0039
        L_0x019a:
            java.lang.String r9 = r10.readString()
            java.lang.String r12 = r10.readString()
            boolean r0 = com.google.android.gms.internal.measurement.S.a(r10)
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r2 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.measurement.internal.B6 r2 = (com.google.android.gms.measurement.internal.B6) r2
            com.google.android.gms.internal.measurement.S.f(r10)
            java.util.List r9 = r8.h0(r9, r12, r0, r2)
            r11.writeNoException()
            r11.writeTypedList(r9)
            goto L_0x0039
        L_0x01bd:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.i> r9 = com.google.android.gms.measurement.internal.C1341i.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.i r9 = (com.google.android.gms.measurement.internal.C1341i) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.P(r9)
            r11.writeNoException()
            goto L_0x0039
        L_0x01d0:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.i> r9 = com.google.android.gms.measurement.internal.C1341i.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.i r9 = (com.google.android.gms.measurement.internal.C1341i) r9
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r12 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r12 = com.google.android.gms.internal.measurement.S.b(r10, r12)
            com.google.android.gms.measurement.internal.B6 r12 = (com.google.android.gms.measurement.internal.B6) r12
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.p(r9, r12)
            r11.writeNoException()
            goto L_0x0039
        L_0x01eb:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            java.lang.String r9 = r8.j0(r9)
            r11.writeNoException()
            r11.writeString(r9)
            goto L_0x0039
        L_0x0202:
            long r3 = r10.readLong()
            java.lang.String r5 = r10.readString()
            java.lang.String r6 = r10.readString()
            java.lang.String r7 = r10.readString()
            com.google.android.gms.internal.measurement.S.f(r10)
            r2 = r8
            r2.t(r3, r5, r6, r7)
            r11.writeNoException()
            goto L_0x02cc
        L_0x021e:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.G> r9 = com.google.android.gms.measurement.internal.G.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.G r9 = (com.google.android.gms.measurement.internal.G) r9
            java.lang.String r12 = r10.readString()
            com.google.android.gms.internal.measurement.S.f(r10)
            byte[] r9 = r8.O(r9, r12)
            r11.writeNoException()
            r11.writeByteArray(r9)
            goto L_0x02cc
        L_0x023a:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            boolean r12 = com.google.android.gms.internal.measurement.S.a(r10)
            com.google.android.gms.internal.measurement.S.f(r10)
            java.util.List r9 = r8.n0(r9, r12)
            r11.writeNoException()
            r11.writeTypedList(r9)
            goto L_0x02cc
        L_0x0256:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.J(r9)
            r11.writeNoException()
            goto L_0x02cc
        L_0x0269:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.G> r9 = com.google.android.gms.measurement.internal.G.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.G r9 = (com.google.android.gms.measurement.internal.G) r9
            java.lang.String r12 = r10.readString()
            java.lang.String r0 = r10.readString()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.r(r9, r12, r0)
            r11.writeNoException()
            goto L_0x02cc
        L_0x0284:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r9 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.B6 r9 = (com.google.android.gms.measurement.internal.B6) r9
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.a0(r9)
            r11.writeNoException()
            goto L_0x02cc
        L_0x0297:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.v6> r9 = com.google.android.gms.measurement.internal.v6.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.v6 r9 = (com.google.android.gms.measurement.internal.v6) r9
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r12 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r12 = com.google.android.gms.internal.measurement.S.b(r10, r12)
            com.google.android.gms.measurement.internal.B6 r12 = (com.google.android.gms.measurement.internal.B6) r12
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.S(r9, r12)
            r11.writeNoException()
            goto L_0x02cc
        L_0x02b2:
            r2 = r8
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.G> r9 = com.google.android.gms.measurement.internal.G.CREATOR
            android.os.Parcelable r9 = com.google.android.gms.internal.measurement.S.b(r10, r9)
            com.google.android.gms.measurement.internal.G r9 = (com.google.android.gms.measurement.internal.G) r9
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.B6> r12 = com.google.android.gms.measurement.internal.B6.CREATOR
            android.os.Parcelable r12 = com.google.android.gms.internal.measurement.S.b(r10, r12)
            com.google.android.gms.measurement.internal.B6 r12 = (com.google.android.gms.measurement.internal.B6) r12
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.I(r9, r12)
            r11.writeNoException()
        L_0x02cc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.C1649d.i(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
