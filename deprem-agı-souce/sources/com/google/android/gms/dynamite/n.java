package com.google.android.gms.dynamite;

import U.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b0.C1002a;
import b0.C1006e;

public final class n extends C1002a implements IInterface {
    n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final a k(a aVar, String str, int i5, a aVar2) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(i5);
        C1006e.d(j5, aVar2);
        Parcel i6 = i(2, j5);
        a j6 = a.C0060a.j(i6.readStrongBinder());
        i6.recycle();
        return j6;
    }

    public final a q0(a aVar, String str, int i5, a aVar2) {
        Parcel j5 = j();
        C1006e.d(j5, aVar);
        j5.writeString(str);
        j5.writeInt(i5);
        C1006e.d(j5, aVar2);
        Parcel i6 = i(3, j5);
        a j6 = a.C0060a.j(i6.readStrongBinder());
        i6.recycle();
        return j6;
    }
}
