package com.google.firebase.installations;

import o0.m;

public class d extends m {

    /* renamed from: a  reason: collision with root package name */
    private final a f7252a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public d(a aVar) {
        this.f7252a = aVar;
    }

    public d(String str, a aVar) {
        super(str);
        this.f7252a = aVar;
    }
}
