package com.mbridge.msdk.dycreator.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f8300a;

    /* renamed from: b  reason: collision with root package name */
    private String f8301b;

    public a(b bVar) {
        if (bVar != null) {
            this.f8300a = bVar.a();
            this.f8301b = bVar.b();
        }
    }

    public final String toString() {
        return "DyError{errorCode=" + this.f8300a + '}';
    }

    public a(int i5, String str) {
        this.f8300a = i5;
        this.f8301b = str;
    }
}
