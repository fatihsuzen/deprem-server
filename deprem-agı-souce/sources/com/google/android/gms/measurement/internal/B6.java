package com.google.android.gms.measurement.internal;

import N.C0722p;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class B6 extends C0732a {
    public static final Parcelable.Creator<B6> CREATOR = new C6();

    /* renamed from: A  reason: collision with root package name */
    public final long f5760A;

    /* renamed from: B  reason: collision with root package name */
    public final String f5761B;

    /* renamed from: C  reason: collision with root package name */
    public final String f5762C;

    /* renamed from: D  reason: collision with root package name */
    public final long f5763D;

    /* renamed from: E  reason: collision with root package name */
    public final int f5764E;

    /* renamed from: a  reason: collision with root package name */
    public final String f5765a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5766b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5767c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5768d;

    /* renamed from: e  reason: collision with root package name */
    public final long f5769e;

    /* renamed from: f  reason: collision with root package name */
    public final long f5770f;

    /* renamed from: g  reason: collision with root package name */
    public final String f5771g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5772h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f5773i;

    /* renamed from: j  reason: collision with root package name */
    public final long f5774j;

    /* renamed from: k  reason: collision with root package name */
    public final String f5775k;

    /* renamed from: l  reason: collision with root package name */
    public final long f5776l;

    /* renamed from: m  reason: collision with root package name */
    public final int f5777m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f5778n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f5779o;

    /* renamed from: p  reason: collision with root package name */
    public final Boolean f5780p;

    /* renamed from: q  reason: collision with root package name */
    public final long f5781q;

    /* renamed from: r  reason: collision with root package name */
    public final List f5782r;

    /* renamed from: s  reason: collision with root package name */
    public final String f5783s;

    /* renamed from: t  reason: collision with root package name */
    public final String f5784t;

    /* renamed from: u  reason: collision with root package name */
    public final String f5785u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f5786v;

    /* renamed from: w  reason: collision with root package name */
    public final long f5787w;

    /* renamed from: x  reason: collision with root package name */
    public final int f5788x;

    /* renamed from: y  reason: collision with root package name */
    public final String f5789y;

    /* renamed from: z  reason: collision with root package name */
    public final int f5790z;

    B6(String str, String str2, String str3, long j5, String str4, long j6, long j7, String str5, boolean z4, boolean z5, String str6, long j8, int i5, boolean z6, boolean z7, Boolean bool, long j9, List list, String str7, String str8, String str9, boolean z8, long j10, int i6, String str10, int i7, long j11, String str11, String str12, long j12, int i8) {
        C0722p.e(str);
        this.f5765a = str;
        this.f5766b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f5767c = str3;
        this.f5774j = j5;
        this.f5768d = str4;
        this.f5769e = j6;
        this.f5770f = j7;
        this.f5771g = str5;
        this.f5772h = z4;
        this.f5773i = z5;
        this.f5775k = str6;
        this.f5776l = j8;
        this.f5777m = i5;
        this.f5778n = z6;
        this.f5779o = z7;
        this.f5780p = bool;
        this.f5781q = j9;
        this.f5782r = list;
        this.f5783s = str7;
        this.f5784t = str8;
        this.f5785u = str9;
        this.f5786v = z8;
        this.f5787w = j10;
        this.f5788x = i6;
        this.f5789y = str10;
        this.f5790z = i7;
        this.f5760A = j11;
        this.f5761B = str11;
        this.f5762C = str12;
        this.f5763D = j12;
        this.f5764E = i8;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.f5765a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 2, str, false);
        C0734c.p(parcel, 3, this.f5766b, false);
        C0734c.p(parcel, 4, this.f5767c, false);
        C0734c.p(parcel, 5, this.f5768d, false);
        C0734c.m(parcel, 6, this.f5769e);
        C0734c.m(parcel, 7, this.f5770f);
        C0734c.p(parcel, 8, this.f5771g, false);
        C0734c.c(parcel, 9, this.f5772h);
        C0734c.c(parcel, 10, this.f5773i);
        C0734c.m(parcel, 11, this.f5774j);
        C0734c.p(parcel, 12, this.f5775k, false);
        C0734c.m(parcel, 14, this.f5776l);
        C0734c.j(parcel, 15, this.f5777m);
        C0734c.c(parcel, 16, this.f5778n);
        C0734c.c(parcel, 18, this.f5779o);
        C0734c.d(parcel, 21, this.f5780p, false);
        C0734c.m(parcel, 22, this.f5781q);
        C0734c.q(parcel, 23, this.f5782r, false);
        C0734c.p(parcel, 25, this.f5783s, false);
        C0734c.p(parcel, 26, this.f5784t, false);
        C0734c.p(parcel, 27, this.f5785u, false);
        C0734c.c(parcel, 28, this.f5786v);
        C0734c.m(parcel, 29, this.f5787w);
        C0734c.j(parcel, 30, this.f5788x);
        C0734c.p(parcel, 31, this.f5789y, false);
        C0734c.j(parcel, 32, this.f5790z);
        C0734c.m(parcel, 34, this.f5760A);
        C0734c.p(parcel, 35, this.f5761B, false);
        C0734c.p(parcel, 36, this.f5762C, false);
        C0734c.m(parcel, 37, this.f5763D);
        C0734c.j(parcel, 38, this.f5764E);
        C0734c.b(parcel, a5);
    }

    B6(String str, String str2, String str3, String str4, long j5, long j6, String str5, boolean z4, boolean z5, long j7, String str6, long j8, int i5, boolean z6, boolean z7, Boolean bool, long j9, List list, String str7, String str8, String str9, boolean z8, long j10, int i6, String str10, int i7, long j11, String str11, String str12, long j12, int i8) {
        this.f5765a = str;
        this.f5766b = str2;
        this.f5767c = str3;
        this.f5774j = j7;
        this.f5768d = str4;
        this.f5769e = j5;
        this.f5770f = j6;
        this.f5771g = str5;
        this.f5772h = z4;
        this.f5773i = z5;
        this.f5775k = str6;
        this.f5776l = j8;
        this.f5777m = i5;
        this.f5778n = z6;
        this.f5779o = z7;
        this.f5780p = bool;
        this.f5781q = j9;
        this.f5782r = list;
        this.f5783s = str7;
        this.f5784t = str8;
        this.f5785u = str9;
        this.f5786v = z8;
        this.f5787w = j10;
        this.f5788x = i6;
        this.f5789y = str10;
        this.f5790z = i7;
        this.f5760A = j11;
        this.f5761B = str11;
        this.f5762C = str12;
        this.f5763D = j12;
        this.f5764E = i8;
    }
}
