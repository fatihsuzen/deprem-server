package com.google.android.gms.internal.measurement;

import O.C0732a;
import O.C0734c;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import j$.util.Objects;

public final class L0 extends C0732a {
    public static final Parcelable.Creator<L0> CREATOR = new M0();

    /* renamed from: a  reason: collision with root package name */
    public final int f5011a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5012b;

    /* renamed from: c  reason: collision with root package name */
    public final Intent f5013c;

    public L0(int i5, String str, Intent intent) {
        this.f5011a = i5;
        this.f5012b = str;
        this.f5013c = intent;
    }

    public static L0 c(Activity activity) {
        return new L0(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L0)) {
            return false;
        }
        L0 l02 = (L0) obj;
        if (this.f5011a != l02.f5011a || !Objects.equals(this.f5012b, l02.f5012b) || !Objects.equals(this.f5013c, l02.f5013c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f5011a;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f5011a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.p(parcel, 2, this.f5012b, false);
        C0734c.o(parcel, 3, this.f5013c, i5, false);
        C0734c.b(parcel, a5);
    }
}
