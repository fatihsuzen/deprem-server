package com.google.android.gms.measurement.internal;

import N.C0722p;
import O.C0732a;
import android.os.Parcel;
import android.os.Parcelable;

public final class v6 extends C0732a {
    public static final Parcelable.Creator<v6> CREATOR = new w6();

    /* renamed from: a  reason: collision with root package name */
    public final int f6787a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6788b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6789c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f6790d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6791e;

    /* renamed from: f  reason: collision with root package name */
    public final String f6792f;

    /* renamed from: g  reason: collision with root package name */
    public final Double f6793g;

    v6(int i5, String str, long j5, Long l5, Float f5, String str2, String str3, Double d5) {
        this.f6787a = i5;
        this.f6788b = str;
        this.f6789c = j5;
        this.f6790d = l5;
        this.f6793g = i5 == 1 ? f5 != null ? Double.valueOf(f5.doubleValue()) : null : d5;
        this.f6791e = str2;
        this.f6792f = str3;
    }

    public final Object c() {
        Long l5 = this.f6790d;
        if (l5 != null) {
            return l5;
        }
        Double d5 = this.f6793g;
        if (d5 != null) {
            return d5;
        }
        String str = this.f6791e;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        w6.a(this, parcel, i5);
    }

    v6(x6 x6Var) {
        this(x6Var.f6894c, x6Var.f6895d, x6Var.f6896e, x6Var.f6893b);
    }

    v6(String str, long j5, Object obj, String str2) {
        C0722p.e(str);
        this.f6787a = 2;
        this.f6788b = str;
        this.f6789c = j5;
        this.f6792f = str2;
        if (obj == null) {
            this.f6790d = null;
            this.f6793g = null;
            this.f6791e = null;
        } else if (obj instanceof Long) {
            this.f6790d = (Long) obj;
            this.f6793g = null;
            this.f6791e = null;
        } else if (obj instanceof String) {
            this.f6790d = null;
            this.f6793g = null;
            this.f6791e = (String) obj;
        } else if (obj instanceof Double) {
            this.f6790d = null;
            this.f6793g = (Double) obj;
            this.f6791e = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
