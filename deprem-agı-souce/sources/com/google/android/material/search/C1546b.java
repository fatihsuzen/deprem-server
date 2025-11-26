package com.google.android.material.search;

/* renamed from: com.google.android.material.search.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1546b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBar f7074a;

    public /* synthetic */ C1546b(SearchBar searchBar) {
        this.f7074a = searchBar;
    }

    public final void run() {
        this.f7074a.searchBarAnimationHelper.startOnLoadAnimation(this.f7074a);
    }
}
