package com.google.android.material.search;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class q implements ViewUtils.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f7092a;

    public /* synthetic */ q(SearchView searchView) {
        this.f7092a = searchView;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return SearchView.g(this.f7092a, view, windowInsetsCompat, relativePadding);
    }
}
