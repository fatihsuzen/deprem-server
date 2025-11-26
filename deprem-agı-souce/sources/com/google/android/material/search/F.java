package com.google.android.material.search;

public final /* synthetic */ class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f7072a;

    public /* synthetic */ F(SearchView searchView) {
        this.f7072a = searchView;
    }

    public final void run() {
        this.f7072a.requestFocusAndShowKeyboardIfNeeded();
    }
}
