package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class P implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f5120a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5121b;

    protected P(IBinder iBinder, String str) {
        this.f5120a = iBinder;
        this.f5121b = str;
    }

    public final IBinder asBinder() {
        return this.f5120a;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i5, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f5120a.transact(i5, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel j() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f5121b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void k(int i5, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f5120a.transact(i5, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void q0(int i5, Parcel parcel) {
        try {
            this.f5120a.transact(2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
