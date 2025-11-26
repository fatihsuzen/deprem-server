package com.google.android.gms.measurement.internal;

import O.C0732a;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

public final class E extends C0732a implements Iterable {
    public static final Parcelable.Creator<E> CREATOR = new F();

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f5830a;

    E(Bundle bundle) {
        this.f5830a = bundle;
    }

    /* access modifiers changed from: package-private */
    public final Object c(String str) {
        return this.f5830a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Long d(String str) {
        return Long.valueOf(this.f5830a.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final Double f(String str) {
        return Double.valueOf(this.f5830a.getDouble("value"));
    }

    /* access modifiers changed from: package-private */
    public final String g(String str) {
        return this.f5830a.getString(str);
    }

    public final int i() {
        return this.f5830a.size();
    }

    public final Iterator iterator() {
        return new D(this);
    }

    public final Bundle j() {
        return new Bundle(this.f5830a);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bundle k() {
        return this.f5830a;
    }

    public final String toString() {
        return this.f5830a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.e(parcel, 2, j(), false);
        C0734c.b(parcel, a5);
    }
}
