package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0427b implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DependencyDao_Impl f624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dependency f625b;

    public /* synthetic */ C0427b(DependencyDao_Impl dependencyDao_Impl, Dependency dependency) {
        this.f624a = dependencyDao_Impl;
        this.f625b = dependency;
    }

    public final Object invoke(Object obj) {
        return DependencyDao_Impl.insertDependency$lambda$0(this.f624a, this.f625b, (SQLiteConnection) obj);
    }
}
