package com.google.android.gms.measurement.internal;

import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.measurement.internal.i  reason: case insensitive filesystem */
public final class C1341i extends C0732a {
    public static final Parcelable.Creator<C1341i> CREATOR = new C1349j();

    /* renamed from: a  reason: collision with root package name */
    public String f6470a;

    /* renamed from: b  reason: collision with root package name */
    public String f6471b;

    /* renamed from: c  reason: collision with root package name */
    public v6 f6472c;

    /* renamed from: d  reason: collision with root package name */
    public long f6473d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6474e;

    /* renamed from: f  reason: collision with root package name */
    public String f6475f;

    /* renamed from: g  reason: collision with root package name */
    public final G f6476g;

    /* renamed from: h  reason: collision with root package name */
    public long f6477h;

    /* renamed from: i  reason: collision with root package name */
    public G f6478i;

    /* renamed from: j  reason: collision with root package name */
    public final long f6479j;

    /* renamed from: k  reason: collision with root package name */
    public final G f6480k;

    C1341i(C1341i iVar) {
        C0722p.k(iVar);
        this.f6470a = iVar.f6470a;
        this.f6471b = iVar.f6471b;
        this.f6472c = iVar.f6472c;
        this.f6473d = iVar.f6473d;
        this.f6474e = iVar.f6474e;
        this.f6475f = iVar.f6475f;
        this.f6476g = iVar.f6476g;
        this.f6477h = iVar.f6477h;
        this.f6478i = iVar.f6478i;
        this.f6479j = iVar.f6479j;
        this.f6480k = iVar.f6480k;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 2, this.f6470a, false);
        C0734c.p(parcel, 3, this.f6471b, false);
        C0734c.o(parcel, 4, this.f6472c, i5, false);
        C0734c.m(parcel, 5, this.f6473d);
        C0734c.c(parcel, 6, this.f6474e);
        C0734c.p(parcel, 7, this.f6475f, false);
        C0734c.o(parcel, 8, this.f6476g, i5, false);
        C0734c.m(parcel, 9, this.f6477h);
        C0734c.o(parcel, 10, this.f6478i, i5, false);
        C0734c.m(parcel, 11, this.f6479j);
        C0734c.o(parcel, 12, this.f6480k, i5, false);
        C0734c.b(parcel, a5);
    }

    C1341i(String str, String str2, v6 v6Var, long j5, boolean z4, String str3, G g5, long j6, G g6, long j7, G g7) {
        this.f6470a = str;
        this.f6471b = str2;
        this.f6472c = v6Var;
        this.f6473d = j5;
        this.f6474e = z4;
        this.f6475f = str3;
        this.f6476g = g5;
        this.f6477h = j6;
        this.f6478i = g6;
        this.f6479j = j7;
        this.f6480k = g7;
    }
}
