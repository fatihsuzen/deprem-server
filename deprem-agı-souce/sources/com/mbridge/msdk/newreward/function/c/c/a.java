package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.c.a.b;

public abstract class a<Resource> implements o {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f10618a = false;

    /* renamed from: b  reason: collision with root package name */
    private final b f10619b;

    /* renamed from: c  reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f10620c;

    /* renamed from: d  reason: collision with root package name */
    private int f10621d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10622e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10623f = false;

    public a(b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f10619b = bVar;
        this.f10620c = aVar;
    }

    public abstract Resource a();

    public final void a(boolean z4) {
        this.f10618a = z4;
    }

    public final b b() {
        return this.f10619b;
    }

    public final com.mbridge.msdk.newreward.function.c.a.a c() {
        return this.f10620c;
    }

    public boolean d() {
        if (TextUtils.isEmpty(j()) || h() || this.f10622e) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (TextUtils.isEmpty(j()) || k() || this.f10623f) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f10621d;
    }

    public final void a(int i5) {
        this.f10621d = i5;
    }

    public final void b(boolean z4) {
        this.f10622e = z4;
    }
}
