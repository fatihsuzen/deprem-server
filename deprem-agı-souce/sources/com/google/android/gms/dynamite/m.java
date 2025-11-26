package com.google.android.gms.dynamite;

import U.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b0.C1002a;
import b0.C1006e;

public final class m extends C1002a implements IInterface {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int k() {
        Parcel i5 = i(6, j());
        int readInt = i5.readInt();
        i5.recycle();
        return readInt;
    }

    public final int q0(a aVar, String str, boolean z4) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(z4 ? 1 : 0);
        Parcel i5 = i(3, j5);
        int readInt = i5.readInt();
        i5.recycle();
        return readInt;
    }

    public final int r0(a aVar, String str, boolean z4) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(z4 ? 1 : 0);
        Parcel i5 = i(5, j5);
        int readInt = i5.readInt();
        i5.recycle();
        return readInt;
    }

    public final a s0(a aVar, String str, int i5) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(i5);
        Parcel i6 = i(2, j5);
        a j6 = a.C0060a.j(i6.readStrongBinder());
        i6.recycle();
        return j6;
    }

    public final a t0(a aVar, String str, int i5, a aVar2) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(i5);
        C1006e.d(j5, aVar2);
        Parcel i6 = i(8, j5);
        a j6 = a.C0060a.j(i6.readStrongBinder());
        i6.recycle();
        return j6;
    }

    public final a u0(a aVar, String str, int i5) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(i5);
        Parcel i6 = i(4, j5);
        a j6 = a.C0060a.j(i6.readStrongBinder());
        i6.recycle();
        return j6;
    }

    public final a v0(a aVar, String str, boolean z4, long j5) {
        Parcel j6 = j();
        C1006e.d(j6, aVar);
        j6.writeString(str);
        j6.writeInt(z4 ? 1 : 0);
        j6.writeLong(j5);
        Parcel i5 = i(7, j6);
        a j7 = a.C0060a.j(i5.readStrongBinder());
        i5.recycle();
        return j7;
    }
}
