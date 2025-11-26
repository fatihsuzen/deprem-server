package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

public abstract class h {

    /* renamed from: b  reason: collision with root package name */
    protected Context f10228b;

    /* renamed from: c  reason: collision with root package name */
    protected Object f10229c;

    /* renamed from: d  reason: collision with root package name */
    protected WindVaneWebView f10230d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.f10228b = context;
        this.f10230d = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f10229c = obj;
        this.f10230d = windVaneWebView;
    }
}
