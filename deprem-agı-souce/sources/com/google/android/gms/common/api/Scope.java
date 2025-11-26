package com.google.android.gms.common.api;

import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Scope extends C0732a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f4846a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4847b;

    Scope(int i5, String str) {
        C0722p.f(str, "scopeUri must not be null or empty");
        this.f4846a = i5;
        this.f4847b = str;
    }

    public String c() {
        return this.f4847b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4847b.equals(((Scope) obj).f4847b);
    }

    public int hashCode() {
        return this.f4847b.hashCode();
    }

    public String toString() {
        return this.f4847b;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f4846a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.p(parcel, 2, c(), false);
        C0734c.b(parcel, a5);
    }

    public Scope(String str) {
        this(1, str);
    }
}
