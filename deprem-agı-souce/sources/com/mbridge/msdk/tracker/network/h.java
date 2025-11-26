package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f11591a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11592b;

    public h(String str, String str2) {
        this.f11591a = str;
        this.f11592b = str2;
    }

    public final String a() {
        return this.f11591a;
    }

    public final String b() {
        return this.f11592b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (!TextUtils.equals(this.f11591a, hVar.f11591a) || !TextUtils.equals(this.f11592b, hVar.f11592b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f11591a.hashCode() * 31) + this.f11592b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f11591a + ",value=" + this.f11592b + "]";
    }
}
