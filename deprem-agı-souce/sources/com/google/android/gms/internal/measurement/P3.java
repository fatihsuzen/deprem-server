package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.net.Uri;
import j$.util.function.Function$CC;
import java.util.function.Function;

final /* synthetic */ class P3 implements Function {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ContentResolver f5126a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Uri f5127b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Runnable f5128c;

    /* synthetic */ P3(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        this.f5126a = contentResolver;
        this.f5127b = uri;
        this.f5128c = runnable;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final /* synthetic */ Object apply(Object obj) {
        return Q3.f(this.f5126a, this.f5127b, this.f5128c, (Uri) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
