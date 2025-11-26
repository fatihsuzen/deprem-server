package j$.time.temporal;

public final /* synthetic */ class p implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1197a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1198b;

    public /* synthetic */ p(int i5, int i6) {
        this.f1197a = i6;
        this.f1198b = i5;
    }

    public final m k(m mVar) {
        switch (this.f1197a) {
            case 0:
                int e5 = mVar.e(a.DAY_OF_WEEK);
                int i5 = this.f1198b;
                if (e5 == i5) {
                    return mVar;
                }
                int i6 = e5 - i5;
                return mVar.b((long) (i6 >= 0 ? 7 - i6 : -i6), b.DAYS);
            default:
                int e6 = mVar.e(a.DAY_OF_WEEK);
                int i7 = this.f1198b;
                if (e6 == i7) {
                    return mVar;
                }
                int i8 = i7 - e6;
                return mVar.n((long) (i8 >= 0 ? 7 - i8 : -i8), b.DAYS);
        }
    }
}
