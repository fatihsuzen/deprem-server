package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1471b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Hct f7007a;

    public /* synthetic */ C1471b(Hct hct) {
        this.f7007a = hct;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Double.valueOf(this.f7007a.getTone());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
