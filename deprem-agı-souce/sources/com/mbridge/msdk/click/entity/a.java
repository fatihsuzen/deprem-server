package com.mbridge.msdk.click.entity;

import androidx.annotation.NonNull;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f8116a;

    /* renamed from: b  reason: collision with root package name */
    public String f8117b;

    /* renamed from: c  reason: collision with root package name */
    public String f8118c;

    /* renamed from: d  reason: collision with root package name */
    public String f8119d;

    /* renamed from: e  reason: collision with root package name */
    public int f8120e;

    /* renamed from: f  reason: collision with root package name */
    public int f8121f;

    /* renamed from: g  reason: collision with root package name */
    public String f8122g;

    /* renamed from: h  reason: collision with root package name */
    public String f8123h;

    public final String a() {
        return "statusCode=" + this.f8121f + ", location=" + this.f8116a + ", contentType=" + this.f8117b + ", contentLength=" + this.f8120e + ", contentEncoding=" + this.f8118c + ", referer=" + this.f8119d;
    }

    @NonNull
    public final String toString() {
        return "ClickResponseHeader{location='" + this.f8116a + '\'' + ", contentType='" + this.f8117b + '\'' + ", contentEncoding='" + this.f8118c + '\'' + ", referer='" + this.f8119d + '\'' + ", contentLength=" + this.f8120e + ", statusCode=" + this.f8121f + ", url='" + this.f8122g + '\'' + ", exception='" + this.f8123h + '\'' + '}';
    }
}
