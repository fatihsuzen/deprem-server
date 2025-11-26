package com.google.android.gms.common.api;

import K.C0655b;
import L.c;
import L.j;
import N.C0720n;
import O.C0732a;
import O.C0734c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Status extends C0732a implements j, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final Status f4848e = new Status(-1);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f4849f = new Status(0);

    /* renamed from: g  reason: collision with root package name */
    public static final Status f4850g = new Status(14);

    /* renamed from: h  reason: collision with root package name */
    public static final Status f4851h = new Status(8);

    /* renamed from: i  reason: collision with root package name */
    public static final Status f4852i = new Status(15);

    /* renamed from: j  reason: collision with root package name */
    public static final Status f4853j = new Status(16);

    /* renamed from: k  reason: collision with root package name */
    public static final Status f4854k = new Status(18);

    /* renamed from: l  reason: collision with root package name */
    public static final Status f4855l = new Status(17);

    /* renamed from: a  reason: collision with root package name */
    private final int f4856a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4857b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f4858c;

    /* renamed from: d  reason: collision with root package name */
    private final C0655b f4859d;

    Status(int i5, String str, PendingIntent pendingIntent, C0655b bVar) {
        this.f4856a = i5;
        this.f4857b = str;
        this.f4858c = pendingIntent;
        this.f4859d = bVar;
    }

    public C0655b c() {
        return this.f4859d;
    }

    public int d() {
        return this.f4856a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f4856a != status.f4856a || !C0720n.a(this.f4857b, status.f4857b) || !C0720n.a(this.f4858c, status.f4858c) || !C0720n.a(this.f4859d, status.f4859d)) {
            return false;
        }
        return true;
    }

    public String f() {
        return this.f4857b;
    }

    public boolean g() {
        return this.f4858c != null;
    }

    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return C0720n.b(Integer.valueOf(this.f4856a), this.f4857b, this.f4858c, this.f4859d);
    }

    public boolean i() {
        return this.f4856a <= 0;
    }

    public final String j() {
        String str = this.f4857b;
        if (str != null) {
            return str;
        }
        return c.a(this.f4856a);
    }

    public String toString() {
        C0720n.a c5 = C0720n.c(this);
        c5.a("statusCode", j());
        c5.a("resolution", this.f4858c);
        return c5.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, d());
        C0734c.p(parcel, 2, f(), false);
        C0734c.o(parcel, 3, this.f4858c, i5, false);
        C0734c.o(parcel, 4, c(), i5, false);
        C0734c.b(parcel, a5);
    }

    public Status(int i5) {
        this(i5, (String) null);
    }

    public Status(C0655b bVar, String str) {
        this(bVar, str, 17);
    }

    public Status(int i5, String str) {
        this(i5, str, (PendingIntent) null);
    }

    public Status(C0655b bVar, String str, int i5) {
        this(i5, str, bVar.f(), bVar);
    }

    public Status(int i5, String str, PendingIntent pendingIntent) {
        this(i5, str, pendingIntent, (C0655b) null);
    }
}
