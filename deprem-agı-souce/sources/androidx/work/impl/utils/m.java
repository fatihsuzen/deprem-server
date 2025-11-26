package androidx.work.impl.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f763a;

    public /* synthetic */ m(IdGenerator idGenerator) {
        this.f763a = idGenerator;
    }

    public final Object call() {
        return IdGenerator.nextAlarmManagerId$lambda$1(this.f763a);
    }
}
