package K;

import java.util.concurrent.Callable;

public final /* synthetic */ class u implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2735a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2736b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ z f2737c;

    public /* synthetic */ u(boolean z4, String str, z zVar) {
        this.f2735a = z4;
        this.f2736b = str;
        this.f2737c = zVar;
    }

    public final Object call() {
        return D.c(this.f2735a, this.f2736b, this.f2737c);
    }
}
