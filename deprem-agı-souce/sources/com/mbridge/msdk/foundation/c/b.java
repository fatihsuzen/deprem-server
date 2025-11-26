package com.mbridge.msdk.foundation.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.Serializable;
import java.util.HashMap;

public final class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f8804a;

    /* renamed from: b  reason: collision with root package name */
    private int f8805b;

    /* renamed from: c  reason: collision with root package name */
    private String f8806c;

    /* renamed from: d  reason: collision with root package name */
    private Throwable f8807d;

    /* renamed from: e  reason: collision with root package name */
    private CampaignEx f8808e;

    /* renamed from: f  reason: collision with root package name */
    private MBridgeIds f8809f;

    /* renamed from: g  reason: collision with root package name */
    private String f8810g;

    /* renamed from: h  reason: collision with root package name */
    private String f8811h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8812i;

    /* renamed from: j  reason: collision with root package name */
    private int f8813j = -1;

    /* renamed from: k  reason: collision with root package name */
    private String f8814k;

    /* renamed from: l  reason: collision with root package name */
    private HashMap<Object, Object> f8815l;

    /* renamed from: m  reason: collision with root package name */
    private int f8816m;

    /* renamed from: n  reason: collision with root package name */
    private String f8817n;

    /* renamed from: o  reason: collision with root package name */
    private String f8818o;

    /* renamed from: p  reason: collision with root package name */
    private String f8819p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f8820q;

    public b(int i5) {
        this.f8804a = i5;
        this.f8805b = a.b(i5);
    }

    public final int a() {
        return this.f8804a;
    }

    public final String b() {
        String str;
        int i5;
        if (!TextUtils.isEmpty(this.f8806c)) {
            str = this.f8806c;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && (i5 = this.f8804a) != -1) {
            str = a.a(i5);
        }
        Throwable th = this.f8807d;
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " # " + message;
    }

    public final CampaignEx c() {
        return this.f8808e;
    }

    public final MBridgeIds d() {
        if (this.f8809f == null) {
            this.f8809f = new MBridgeIds();
        }
        return this.f8809f;
    }

    public final int e() {
        return this.f8805b;
    }

    public final String f() {
        return this.f8811h;
    }

    public final int g() {
        return this.f8813j;
    }

    public final String h() {
        return this.f8814k;
    }

    public final int i() {
        return this.f8816m;
    }

    public final String j() {
        return this.f8817n;
    }

    public final String k() {
        return this.f8818o;
    }

    public final String l() {
        return this.f8819p;
    }

    public final boolean m() {
        return this.f8820q;
    }

    public final String toString() {
        return "MBFailureReason{errorCode=" + this.f8804a + ", errorSubType=" + this.f8805b + ", message='" + this.f8806c + '\'' + ", cause=" + this.f8807d + ", campaign=" + this.f8808e + ", ids=" + this.f8809f + ", requestId='" + this.f8810g + '\'' + ", localRequestId='" + this.f8811h + '\'' + ", isHeaderBidding=" + this.f8812i + ", typeD=" + this.f8813j + ", reasonD='" + this.f8814k + '\'' + ", extraMap=" + this.f8815l + ", serverErrorCode=" + this.f8816m + ", errorUrl='" + this.f8817n + '\'' + ", serverErrorResponse='" + this.f8818o + '\'' + '}';
    }

    public final void a(String str) {
        this.f8806c = str;
    }

    public final void c(String str) {
        this.f8814k = str;
    }

    public final void e(String str) {
        this.f8818o = str;
    }

    public final void f(String str) {
        this.f8819p = str;
    }

    public final void a(Throwable th) {
        this.f8807d = th;
    }

    public final void a(CampaignEx campaignEx) {
        this.f8808e = campaignEx;
    }

    public final void d(String str) {
        this.f8817n = str;
    }

    public b(int i5, String str) {
        this.f8804a = i5;
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
        }
        this.f8806c = str;
        this.f8805b = a.b(i5);
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.f8809f = mBridgeIds;
    }

    public final void a(boolean z4) {
        this.f8812i = z4;
    }

    public final void a(Object obj, Object obj2) {
        if (this.f8815l == null) {
            this.f8815l = new HashMap<>();
        }
        this.f8815l.put(obj, obj2);
    }

    public final Object a(Object obj) {
        HashMap<Object, Object> hashMap = this.f8815l;
        if (hashMap != null && hashMap.containsKey(obj)) {
            return this.f8815l.get(obj);
        }
        return null;
    }

    public final void b(String str) {
        this.f8811h = str;
    }

    public b(int i5, int i6, String str) {
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
            this.f8806c = str;
        } else {
            this.f8806c = a.a(i6);
        }
        this.f8816m = i5;
        this.f8805b = a.b(i6);
    }

    public final void b(boolean z4) {
        this.f8820q = z4;
    }

    public final void a(int i5) {
        this.f8813j = i5;
    }
}
