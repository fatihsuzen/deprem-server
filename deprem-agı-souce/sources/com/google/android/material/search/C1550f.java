package com.google.android.material.search;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: com.google.android.material.search.f  reason: case insensitive filesystem */
public final /* synthetic */ class C1550f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBarAnimationHelper f7077a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchBar f7078b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f7079c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f7080d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f7081e;

    public /* synthetic */ C1550f(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z4) {
        this.f7077a = searchBarAnimationHelper;
        this.f7078b = searchBar;
        this.f7079c = view;
        this.f7080d = appBarLayout;
        this.f7081e = z4;
    }

    public final void run() {
        SearchBarAnimationHelper.b(this.f7077a, this.f7078b, this.f7079c, this.f7080d, this.f7081e);
    }
}
