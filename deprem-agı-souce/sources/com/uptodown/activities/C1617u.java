package com.uptodown.activities;

import android.view.View;
import com.uptodown.activities.MyApps;
import java.util.ArrayList;

/* renamed from: com.uptodown.activities.u  reason: case insensitive filesystem */
public final /* synthetic */ class C1617u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f15155a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyApps f15156b;

    public /* synthetic */ C1617u(ArrayList arrayList, MyApps myApps) {
        this.f15155a = arrayList;
        this.f15156b = myApps;
    }

    public final void onClick(View view) {
        MyApps.f.l(this.f15155a, this.f15156b, view);
    }
}
