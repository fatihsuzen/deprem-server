package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

public final /* synthetic */ class k2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TemperatureCache f7019a;

    public /* synthetic */ k2(TemperatureCache temperatureCache) {
        this.f7019a = temperatureCache;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f7019a.getTempsByHct().get((Hct) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
