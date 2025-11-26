package androidx.profileinstaller;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceProfileWriter f404a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f405b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f406c;

    public /* synthetic */ b(DeviceProfileWriter deviceProfileWriter, int i5, Object obj) {
        this.f404a = deviceProfileWriter;
        this.f405b = i5;
        this.f406c = obj;
    }

    public final void run() {
        this.f404a.mDiagnostics.onResultReceived(this.f405b, this.f406c);
    }
}
