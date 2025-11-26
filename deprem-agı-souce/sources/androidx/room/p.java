package androidx.room;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomTrackingLiveData f445a;

    public /* synthetic */ p(RoomTrackingLiveData roomTrackingLiveData) {
        this.f445a = roomTrackingLiveData;
    }

    public final void run() {
        RoomTrackingLiveData$observer$1.onInvalidated$lambda$0(this.f445a);
    }
}
