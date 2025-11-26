package androidx.core.content;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection f258a;

    public /* synthetic */ v(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f258a = unusedAppRestrictionsBackportServiceConnection;
    }

    public final void run() {
        this.f258a.disconnectFromService();
    }
}
