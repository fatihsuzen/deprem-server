package com.google.android.gms.measurement.internal;

import N.C0722p;
import O.C0732a;
import android.os.Parcel;
import android.os.Parcelable;

public final class G extends C0732a {
    public static final Parcelable.Creator<G> CREATOR = new H();

    /* renamed from: a  reason: collision with root package name */
    public final String f5883a;

    /* renamed from: b  reason: collision with root package name */
    public final E f5884b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5885c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5886d;

    G(G g5, long j5) {
        C0722p.k(g5);
        this.f5883a = g5.f5883a;
        this.f5884b = g5.f5884b;
        this.f5885c = g5.f5885c;
        this.f5886d = j5;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5884b);
        String str = this.f5885c;
        int length = String.valueOf(str).length();
        String str2 = this.f5883a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + valueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        H.a(this, parcel, i5);
    }

    public G(String str, E e5, String str2, long j5) {
        this.f5883a = str;
        this.f5884b = e5;
        this.f5885c = str2;
        this.f5886d = j5;
    }
}
