package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final /* synthetic */ class o implements OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f7088a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7089b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7090c;

    public /* synthetic */ o(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6) {
        this.f7088a = marginLayoutParams;
        this.f7089b = i5;
        this.f7090c = i6;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.b(this.f7088a, this.f7089b, this.f7090c, view, windowInsetsCompat);
    }
}
