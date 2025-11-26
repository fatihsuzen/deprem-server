package androidx.work.impl.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f764a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f765b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f766c;

    public /* synthetic */ n(IdGenerator idGenerator, int i5, int i6) {
        this.f764a = idGenerator;
        this.f765b = i5;
        this.f766c = i6;
    }

    public final Object call() {
        return IdGenerator.nextJobSchedulerIdWithRange$lambda$0(this.f764a, this.f765b, this.f766c);
    }
}
