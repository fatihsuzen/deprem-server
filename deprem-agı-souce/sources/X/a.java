package X;

import android.os.IBinder;
import android.os.IInterface;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4427a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4428b;

    protected a(IBinder iBinder, String str) {
        this.f4427a = iBinder;
        this.f4428b = str;
    }

    public final IBinder asBinder() {
        return this.f4427a;
    }
}
