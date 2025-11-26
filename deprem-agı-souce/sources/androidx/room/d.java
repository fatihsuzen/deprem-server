package androidx.room;

import androidx.room.BaseRoomConnectionManager;
import k3.C2616a;

public final /* synthetic */ class d implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseRoomConnectionManager f432a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseRoomConnectionManager.DriverWrapper f433b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f434c;

    public /* synthetic */ d(BaseRoomConnectionManager baseRoomConnectionManager, BaseRoomConnectionManager.DriverWrapper driverWrapper, String str) {
        this.f432a = baseRoomConnectionManager;
        this.f433b = driverWrapper;
        this.f434c = str;
    }

    public final Object invoke() {
        return BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1(this.f432a, this.f433b, this.f434c);
    }
}
