package com.mbridge.msdk.tracker;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

public final class e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f11495a;

    /* renamed from: b  reason: collision with root package name */
    private int f11496b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f11497c = 0;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f11498d;

    /* renamed from: e  reason: collision with root package name */
    private String f11499e;

    /* renamed from: f  reason: collision with root package name */
    private long f11500f;

    /* renamed from: g  reason: collision with root package name */
    private long f11501g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f11502h = 604800000;

    /* renamed from: i  reason: collision with root package name */
    private h f11503i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11504j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11505k = false;

    public e(String str) {
        this.f11495a = str;
        this.f11500f = System.currentTimeMillis();
        this.f11499e = UUID.randomUUID().toString();
    }

    public final String a() {
        return this.f11495a;
    }

    public final int b() {
        return this.f11496b;
    }

    public final int c() {
        return this.f11497c;
    }

    public final JSONObject d() {
        JSONObject jSONObject = this.f11498d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f11498d = jSONObject2;
        return jSONObject2;
    }

    public final String e() {
        return this.f11499e;
    }

    public final long f() {
        return this.f11500f;
    }

    public final long g() {
        return this.f11501g;
    }

    public final long h() {
        return this.f11502h;
    }

    public final h i() {
        return this.f11503i;
    }

    public final boolean j() {
        return this.f11504j;
    }

    public final boolean k() {
        return this.f11505k;
    }

    public final void a(int i5) {
        this.f11496b = i5;
    }

    public final void b(int i5) {
        this.f11497c = i5;
    }

    /* access modifiers changed from: package-private */
    public final void c(long j5) {
        this.f11502h = j5;
    }

    public final void a(JSONObject jSONObject) {
        this.f11498d = jSONObject;
    }

    public final void b(long j5) {
        this.f11501g = j5;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.f11499e = str;
    }

    public final void a(long j5) {
        this.f11500f = j5;
    }

    public final void a(h hVar) {
        this.f11503i = hVar;
    }

    public final void a(boolean z4) {
        this.f11505k = z4;
    }
}
