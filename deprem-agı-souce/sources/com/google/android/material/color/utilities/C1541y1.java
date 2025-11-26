package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.y1  reason: case insensitive filesystem */
public final /* synthetic */ class C1541y1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f7030a;

    public /* synthetic */ C1541y1(MaterialDynamicColors materialDynamicColors) {
        this.f7030a = materialDynamicColors;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f7030a.primaryFixed();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
