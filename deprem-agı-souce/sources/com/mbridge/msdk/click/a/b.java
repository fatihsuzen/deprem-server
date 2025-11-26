package com.mbridge.msdk.click.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f8083a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f8084b = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f8085c;

    /* renamed from: d  reason: collision with root package name */
    private int f8086d;

    /* renamed from: e  reason: collision with root package name */
    private HashSet<String> f8087e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private long f8088f = System.currentTimeMillis();

    /* renamed from: g  reason: collision with root package name */
    private CampaignEx f8089g;

    /* renamed from: h  reason: collision with root package name */
    private String f8090h;

    /* renamed from: i  reason: collision with root package name */
    private int f8091i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8092j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8093k;

    /* renamed from: l  reason: collision with root package name */
    private int f8094l;

    public b(String str, String str2) {
        this.f8085c = str;
        b(str2);
    }

    public final boolean a() {
        return this.f8092j;
    }

    public final boolean b() {
        return this.f8093k;
    }

    public final int c() {
        return this.f8094l;
    }

    public final int d() {
        return this.f8091i;
    }

    public final String e() {
        return this.f8090h;
    }

    public final CampaignEx f() {
        return this.f8089g;
    }

    public final String g() {
        return this.f8085c;
    }

    public final int h() {
        return this.f8086d;
    }

    public final HashSet<String> i() {
        return this.f8087e;
    }

    public final long j() {
        return this.f8088f;
    }

    public final void a(boolean z4) {
        this.f8092j = z4;
    }

    public final void b(boolean z4) {
        this.f8093k = z4;
    }

    public final void a(int i5) {
        this.f8094l = i5;
    }

    public final void b(int i5) {
        this.f8091i = i5;
    }

    public final void a(String str) {
        this.f8090h = str;
    }

    public final void b(String str) {
        this.f8086d++;
        this.f8087e.add(str);
    }

    public final void a(CampaignEx campaignEx) {
        this.f8089g = campaignEx;
    }
}
