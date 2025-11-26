package com.google.android.gms.internal.measurement;

import android.os.BadParcelableException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public abstract class S {

    /* renamed from: a  reason: collision with root package name */
    private static final ClassLoader f5168a = S.class.getClassLoader();

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f5169b = 0;

    public static boolean a(Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static Parcelable b(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void d(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder((IBinder) null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static HashMap e(Parcel parcel) {
        return parcel.readHashMap(f5168a);
    }

    public static void f(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail > 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(dataAvail).length() + 45);
            sb.append("Parcel data not fully consumed, unread size: ");
            sb.append(dataAvail);
            throw new BadParcelableException(sb.toString());
        }
    }
}
