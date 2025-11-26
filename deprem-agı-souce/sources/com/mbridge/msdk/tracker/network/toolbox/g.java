package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.h;
import j$.util.DesugarCollections;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f11668a;

    /* renamed from: b  reason: collision with root package name */
    private final List<h> f11669b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11670c;

    /* renamed from: d  reason: collision with root package name */
    private final InputStream f11671d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f11672e;

    public g(int i5, List<h> list) {
        this(i5, list, -1, (InputStream) null);
    }

    public final int a() {
        return this.f11668a;
    }

    public final List<h> b() {
        return DesugarCollections.unmodifiableList(this.f11669b);
    }

    public final int c() {
        return this.f11670c;
    }

    public final InputStream d() {
        InputStream inputStream = this.f11671d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f11672e != null) {
            return new ByteArrayInputStream(this.f11672e);
        }
        return null;
    }

    public g(int i5, List<h> list, int i6, InputStream inputStream) {
        this.f11668a = i5;
        this.f11669b = list;
        this.f11670c = i6;
        this.f11671d = inputStream;
        this.f11672e = null;
    }
}
