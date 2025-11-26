package com.google.android.material.button;

import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialButtonGroup f6960a;

    public /* synthetic */ c(MaterialButtonGroup materialButtonGroup) {
        this.f6960a = materialButtonGroup;
    }

    public final int compare(Object obj, Object obj2) {
        return MaterialButtonGroup.a(this.f6960a, (MaterialButton) obj, (MaterialButton) obj2);
    }
}
