package i4;

import g4.d;
import i4.d;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f24504a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f24505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f24506c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d.a f24507d;

    public /* synthetic */ c(d dVar, boolean z4, g4.d dVar2, d.a aVar) {
        this.f24504a = dVar;
        this.f24505b = z4;
        this.f24506c = dVar2;
        this.f24507d = aVar;
    }

    public final void run() {
        this.f24504a.d(this.f24505b, this.f24506c, this.f24507d);
    }
}
