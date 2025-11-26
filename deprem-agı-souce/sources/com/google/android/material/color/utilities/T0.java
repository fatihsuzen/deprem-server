package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

public final /* synthetic */ class T0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MaterialDynamicColors.Z((DynamicScheme) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
