package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

public final /* synthetic */ class F0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Double.valueOf(((DynamicScheme) obj).secondaryPalette.getKeyColor().getTone());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
