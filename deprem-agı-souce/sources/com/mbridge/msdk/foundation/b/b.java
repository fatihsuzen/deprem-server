package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.z;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f8780a;

    /* renamed from: b  reason: collision with root package name */
    private double f8781b;

    /* renamed from: c  reason: collision with root package name */
    private String f8782c;

    /* renamed from: d  reason: collision with root package name */
    private String f8783d;

    /* renamed from: e  reason: collision with root package name */
    private int f8784e;

    /* renamed from: f  reason: collision with root package name */
    private long f8785f;

    /* renamed from: g  reason: collision with root package name */
    private int f8786g;

    /* renamed from: h  reason: collision with root package name */
    private long f8787h;

    /* renamed from: i  reason: collision with root package name */
    private String f8788i;

    /* renamed from: j  reason: collision with root package name */
    private long f8789j;

    public final long a() {
        return this.f8789j;
    }

    public final CopyOnWriteArrayList<CampaignEx> b() {
        return this.f8780a;
    }

    public final double c() {
        return this.f8781b;
    }

    public final String d() {
        return this.f8782c;
    }

    public final String e() {
        return this.f8783d;
    }

    public final int f() {
        return this.f8784e;
    }

    public final int g() {
        return this.f8786g;
    }

    public final long h() {
        return this.f8787h;
    }

    public final void a(long j5) {
        this.f8789j = j5;
    }

    public final void b(String str) {
        this.f8782c = str;
    }

    public final void c(String str) {
        this.f8783d = str;
    }

    public final void d(String str) {
        this.f8788i = str;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f8780a = copyOnWriteArrayList;
    }

    public final void b(int i5) {
        this.f8786g = i5;
    }

    public final void c(long j5) {
        this.f8785f = j5;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String a5 = z.a(str);
            if (!TextUtils.isEmpty(a5)) {
                try {
                    double parseDouble = Double.parseDouble(a5);
                    if (parseDouble > 0.0d) {
                        this.f8781b = parseDouble;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void b(long j5) {
        this.f8787h = j5;
    }

    public final void a(int i5) {
        this.f8784e = i5;
    }
}
