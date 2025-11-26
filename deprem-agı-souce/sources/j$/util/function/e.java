package j$.util.function;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

public final /* synthetic */ class e implements LongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f1379a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f1380b;

    public /* synthetic */ e(LongConsumer longConsumer, LongConsumer longConsumer2) {
        this.f1379a = longConsumer;
        this.f1380b = longConsumer2;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void accept(long j5) {
        this.f1379a.accept(j5);
        this.f1380b.accept(j5);
    }
}
