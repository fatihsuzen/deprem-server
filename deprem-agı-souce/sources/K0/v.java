package k0;

final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1698l f15502a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w f15503b;

    v(w wVar, C1698l lVar) {
        this.f15503b = wVar;
        this.f15502a = lVar;
    }

    public final void run() {
        if (this.f15502a.l()) {
            this.f15503b.f15506c.s();
            return;
        }
        try {
            this.f15503b.f15506c.r(this.f15503b.f15505b.a(this.f15502a));
        } catch (C1696j e5) {
            if (e5.getCause() instanceof Exception) {
                this.f15503b.f15506c.q((Exception) e5.getCause());
            } else {
                this.f15503b.f15506c.q(e5);
            }
        } catch (Exception e6) {
            this.f15503b.f15506c.q(e6);
        }
    }
}
