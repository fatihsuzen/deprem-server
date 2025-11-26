package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.a  reason: case insensitive filesystem */
public final /* synthetic */ class C1468a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TonalPalette f7006a;

    public /* synthetic */ C1468a(TonalPalette tonalPalette) {
        this.f7006a = tonalPalette;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DynamicColor.b(this.f7006a, (DynamicScheme) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
